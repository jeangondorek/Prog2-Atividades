package br.edu.projeto.util;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.edu.projeto.dao.UsuarioDAO;
import br.edu.projeto.model.TipoPermissao;
import br.edu.projeto.model.Usuario;

@WebListener
public class AdminSetup implements ServletContextListener {

	@Inject
    private Pbkdf2PasswordHash passwordHash;

    @Inject
    private UsuarioDAO usuarioDAO;

    private Usuario admin;
    
    public void contextInitialized(ServletContextEvent event) {
        if (usuarioDAO.isUsuarioUnique("admin")){ 	
	    	admin = new Usuario();
	        admin.setEmail("admin@admin.com");
	        String senhaPadrao = "admin";
	        admin.setSenha(passwordHash.generate(senhaPadrao.toCharArray()));
	        admin.setUsuario("admin");
	        TipoPermissao permissao = new TipoPermissao();
	        permissao.setPermissao(Permissao.ADMINISTRADOR);
	        permissao.addUsuario(admin);
	        usuarioDAO.save(admin);
        }
    }
}