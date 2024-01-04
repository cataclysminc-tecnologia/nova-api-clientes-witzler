package br.com.witzler.clientes.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.witzler.clientes.domain.entity.Unidades;
import br.com.witzler.clientes.domain.entity.WebCliente;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.domain.repositorio.WebClienteRepositorio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JwtSecurityValidateToken {
	private Integer id_client = 0;
	private String username = "";
	
	/**
	 * Construtor que apenas monta a chave de assinatura, utilizado para verificar o id_client da requisição com o token.<br>
	 * @param chaveAssinatura
	 */
	public JwtSecurityValidateToken(String chaveAssinatura) {
		decriptTokenSemToken(chaveAssinatura,0);
	}
	
	/**
	 * Método que pega o Bearer Token da requisição, acha o client_id, seta ele como variável global e também pega os id´s das unidades, também setando elas como variável global por questões de segurança (evitar um cliente pegar informações de outro cliente).
	 * @param chaveAssinatura
	 */
	public void decriptTokenSemToken(String chaveAssinatura, Integer id_requisicao){
		/*PEGOU TOKEN DE ACESSO*/
		String token = "";
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String authorization = request.getHeader("Authorization");
			if(authorization != null && authorization.startsWith("Bearer ")){
				token = authorization.substring(7);
			}
		}catch(Exception ex) {
			System.out.println("Erro ao tentar adquirir o Bearer Token da requisição: " + ex);
		}
		// System.out.println("CHEGOU O TOKEN: " + token);
		/*FIM PEGOU TOKEN DE ACESSO*/
		/*VERIFICANDO ID CLIENTE DO TOKEN*/
		try{
			Claims claims = Jwts.parser().setSigningKey(chaveAssinatura).parseClaimsJws(token).getBody();
			this.id_client = (Integer) claims.get("id_cliente");
			this.username = (String) claims.get("sub");
			
		}catch(Exception ex){
			System.out.println("Token Inválido: " + ex);
		}
		/*FIM VERIFICANDO ID CLIENTE DO TOKEN*/
	}
	
	/**
	 * Esse método verifica se no token consta a permissão de administrador proveniente da tabela de login.<br>
	 * @return
	 */
	public boolean isAdmin() {
		boolean isAdmin = false;
		Collection<? extends GrantedAuthority> listaPermissoes = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority permissao : listaPermissoes) {
			if(permissao.getAuthority().equals("ROLE_ADMIN")) {
				// System.out.println("admin: " + permissao.getAuthority());
				isAdmin = true;
				break;
			}
		}
		return isAdmin;
	}
	
	/**
	 * Esse método verifica pelo username do token e da requisição se eles são iguais, caso contrário, ele verifica se o token é de um admin, em caso negativo, ele retorna falso.<br> 
	 * @param username
	 * @return
	 */
	public boolean isVerifiedByUsernameOrIsAdmin(String username) {
		boolean isVerified = false;
		if(this.getUsername().contains(username)) {
			isVerified = true;
		}else {
			if(isAdmin()) {
				isVerified = true;
			}
		}
		return isVerified;
	}
	
	/**
	 * 
	 * @param webClienteRepositorio
	 * @param cow_client_id
	 * @param arquivoURL
	 * @return
	 */
	public boolean urlIsFromClient(WebClienteRepositorio webClienteRepositorio, Integer client_id, String arquivoURL) {
		boolean urlAutenticada = false;
		if(webClienteRepositorio != null) {
			List<WebCliente> listaCliente = webClienteRepositorio.listandoTudoPorId(client_id);
			for (WebCliente webCliente : listaCliente) {
				String pathCliente = "/clientes/" + webCliente.getCow_client_id().intValue();
				String pathClienteAlternativo = "\\clientes\\" + webCliente.getCow_client_id().intValue();
				// System.out.println("Path Cliente: " + pathCliente);
				// System.out.println("Path Cliente Alternativo: " + pathClienteAlternativo);
				// System.out.println("Arquivo URL: " + arquivoURL);
				if(arquivoURL.contains(pathCliente)) {
					urlAutenticada = true;
				}else if(arquivoURL.contains(pathClienteAlternativo)) {
					urlAutenticada = true;
				}
				// System.out.println("Resultado: " + urlAutenticada);
				break;
			}
		}
		return urlAutenticada;
	}
	
	/**
	 * Método que verifica se a unidade pertence realmente ao cliente.<br>
	 * @param unidadesRepositorio
	 * @param id_requisicao
	 * @return
	 */
	public boolean isUnidadeFromClient(UnidadesRepositorio unidadesRepositorio, Integer id_unit) {
		boolean unidadeLegatima = false;
		ArrayList<Integer> listaUnidadesIdsDesteCliente = new ArrayList<>();
		if(unidadesRepositorio != null && !username.isEmpty()) {
			List<Unidades> listaUnidades = unidadesRepositorio.listandoUnidadesCliente(username);
			for (Unidades unidades : listaUnidades) {
				listaUnidadesIdsDesteCliente.add(unidades.getId_unidades());
			}
			for (Integer unit_id_deste_token : listaUnidadesIdsDesteCliente) {
				if(unit_id_deste_token.intValue() == id_unit.intValue()) {
					unidadeLegatima = true;
					break;
				}
			}
		}
		return unidadeLegatima;
	}
	
}
