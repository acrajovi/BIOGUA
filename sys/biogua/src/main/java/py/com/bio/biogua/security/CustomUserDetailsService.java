package py.com.bio.biogua.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.bio.biogua.model.Usuarios;
import py.com.bio.biogua.service.UsuariosService;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Usuarios usuario = usuariosService.obtenerById(userName);
		logger.info("User : {}", usuario);
		if(usuario==null){
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getPass(), 
				 true, true, true, true, getGrantedAuthorities(usuario));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Usuarios usuario){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
//		for(UserProfile userProfile : user.getUserProfiles()){
//			logger.info("UserProfile : {}", userProfile);
//			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
	
}
