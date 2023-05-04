package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.edu.projeto.dao.ClienteDAO;
import br.edu.projeto.model.Cliente;

@ViewScoped
@Named
public class CrudClientes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
    private ClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	private List<Cliente> listaCliente;
	
	private Boolean rendNovoCadastro;
	
    @PostConstruct
    public void init() {
    	this.setListaCliente(clienteDAO.listAll());
    }
	
	public void novoCadastro() {
        this.setCliente(new Cliente());
        this.setRendNovoCadastro(true);
    }
	
	public void alterarCadastro() {
        this.setRendNovoCadastro(false);
    }
	
	public void remover() {
		if (this.clienteDAO.delete(this.cliente)) {
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "cliente Removida", null));
			this.listaCliente.remove(this.cliente);
		} else 
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao Remover cliente", null));
		this.cliente = null;
        PrimeFaces.current().ajax().update("form:messages", "form:dt-cliente");
	}	
	
	public void salvarNovo() {
		if (this.clienteDAO.insert(this.cliente)) {
			this.getListaCliente().add(this.cliente);
			PrimeFaces.current().executeScript("PF('clienteDialog').hide()");
			PrimeFaces.current().ajax().update("form:dt-cliente");
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Criada", null));
		} else
    		this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao Criar Cliente", null));
		PrimeFaces.current().ajax().update("form:messages");
	}
	
	public void salvarAlteracao() {
		if (this.cliente.getId_clientes() != null && this.cliente.getId_clientes() > 0)
		{
			if (this.clienteDAO.update(this.cliente)) {
				PrimeFaces.current().executeScript("PF('clienteDialog').hide()");
				PrimeFaces.current().ajax().update("form:dt-cliente");
				this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Atualizada", null));
			} else
        		this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha ao Atualizar Cliente", null));
		} else {
			this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ID da Cliente inválido!", null));
    	}
		this.setListaCliente(clienteDAO.listAll());
		PrimeFaces.current().ajax().update("form:messages");
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente= listaCliente;
	}

	public Boolean getRendNovoCadastro() {
		return rendNovoCadastro;
	}

	public void setRendNovoCadastro(Boolean rendNovoCadastro) {
		this.rendNovoCadastro = rendNovoCadastro;
	}
}