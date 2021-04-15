package com.timeboard.server.projects.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.timeboard.server.projects.model.ProjectUser;
import com.timeboard.server.projects.repository.ProjectUserRepository;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	private static final Logger log = LoggerFactory.getLogger(ProjectUserServiceImpl.class);

	@Autowired
	private ProjectUserRepository projectUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ProjectUser save(ProjectUser user) {
		// Encrypt the password
		user.getProjectSchema().getAccount().setPassword(
				passwordEncoder.encode(user.getProjectSchema().getAccount().getPassword()));
		ProjectUser justSavedUser = projectUserRepository.save(user);
		log.info("User:" + justSavedUser.getProjectSchema().getAccount().getLogin() + " saved.");
		return justSavedUser;
	}

	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext()
				.getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			String username = ((UserDetails)userDetails).getUsername();
			log.info("Logged in username:" + username);
			return username;
		}
		return null;
	}

	@Override
	public ProjectUser findByUsernameAndTenantname(String username, String tenant) {
		ProjectUser user = projectUserRepository.findByUsernameAndTenantname(username,
				tenant);
		log.info("Found user with username:" + user.getProjectSchema().getAccount().getLogin()
				+ " from tenant:" + user.getProjectSchema());
		return user;
	}

	@Override
	public List<ProjectUser> findAllUsers() {
		return projectUserRepository.findAll();
	}
}