package br.com.calebe.backend.testes;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.calebe.backend.dto.UsuarioDTO;
import br.com.calebe.backend.services.UsuarioService;
import br.com.calebe.backend.tipos.TipoUsuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TesteAPI {

	@LocalServerPort
    private int port;
	
	private String uri;
	
	@PostConstruct
    public void init() {
		usuarioService.limparTabela();
		
    	usuarioService.salvar(new UsuarioDTO("1", "Luis", "Freitas", "lfreitas@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("2", "Marcelo", "Lima", "mlima@teste.com.br", "123456", TipoUsuario.ADMINISTRADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("3", "Diego", "Costa", "dcosta@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("4", "Vitor", "Santos", "vsantos@teste.com.br", "123456", TipoUsuario.USUARIO_FINALIZADOR.getDescricao()));
    	usuarioService.salvar(new UsuarioDTO("5", "Pedro", "Souza", "psouza@teste.com.br", "123456", TipoUsuario.USUARIO_TRIADOR.getDescricao()));
    	
        uri = "http://localhost:" + port;
    }
	
	@Autowired
	private UsuarioService usuarioService;
    
	// verificando se o link para listar usuarios é valida
	@Test
	public void listarUsuariosIsValid() {
    	
		RestAssured.
    	given().
    	when().
            get(uri+"/usuario/listar").
        then().
            assertThat().
            statusCode(200);
    	
	}
	
	// verificando se o link para listar usuarios retorna um JSON
	@Test
	public void listarUsuariosReturnsJSON() {
    	
		RestAssured.
    	given().
    	when().
            get(uri+"/usuario/listar").
        then().
            contentType(ContentType.JSON);
    	
	}
	
	// verificando se a lista de usuarios esta vindo com todos os usuarios cadastrados
	@Test
	public void testarRequisicaoListarUsuariosLengthValid() {

    	RestAssured.
    	given().
    	when().
            get(uri+"/usuario/listar").
        then().
            assertThat().
            body("size()", Matchers.is(5)).
        and().
            contentType(ContentType.JSON);
    	
	}
	
	// verificando se todos os usuarios da lista tem os seus atributos corretos
	@Test
	public void verificarAtributosDaLista() {
    	
		List<UsuarioDTO> usuariosDTO = RestAssured.given().when().get(uri+"/usuario/listar").getBody().jsonPath().getList("", UsuarioDTO.class);

		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("id", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("nome", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("sobrenome", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("email", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("senha", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("tipoUsuario", Matchers.notNullValue())));
		assertThat(usuariosDTO, Matchers.everyItem(Matchers.hasProperty("tipoUsuarioId", Matchers.notNullValue())));
		
	}
	
	// verificando se o link para buscar o usuario pelo id é valida
	@Test
	public void buscarUsuarioIsValid() {
    	
		RestAssured.
    	given().
    	when().
            get(uri+"/usuario/1").
        then().
            assertThat().
            statusCode(200);
    	
	}
	
	// verificando se o link para buscar o produtor com maior intervalo de premios retorna um JSON
	@Test
	public void buscarUsuarioReturnsJSON() {
    	
		RestAssured.
    	given().
    	when().
            get(uri+"/usuario/1").
        then().
            contentType(ContentType.JSON);
    	
	}
	
	
	
}
