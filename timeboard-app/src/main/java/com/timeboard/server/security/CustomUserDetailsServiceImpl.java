package com.timeboard.server.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.timeboard.server.projects.model.CustomUserDetails;
import com.timeboard.server.projects.model.ProjectUser;
import com.timeboard.server.projects.model.Role;
import com.timeboard.server.projects.service.ProjectUserService;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	@Autowired
	private ProjectUserService userService;

	@Override
	public UserDetails loadUserByUsernameAndTenantname(String username,
	                                                   String tenant) throws UsernameNotFoundException {
		if (username.isBlank() || tenant.isBlank()) {
			throw new UsernameNotFoundException(
					"Username and domain must be provided");
		}
		// Look for the user based on the username and tenant by accessing the
		// UserRepository via the UserService
		ProjectUser user = userService.findByUsernameAndTenantname(username, tenant);

		if (user == null) {
			throw new UsernameNotFoundException(
					String.format(
							"Username not found for domain, "
									+ "username=%s, tenant=%s",
							username, tenant));
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		CustomUserDetails customUserDetails = new CustomUserDetails(
				user.getProjectSchema().getAccount().getLogin(),
				user.getProjectSchema().getAccount().getPassword(),
				grantedAuthorities,
				tenant);

		return customUserDetails;
	}
}