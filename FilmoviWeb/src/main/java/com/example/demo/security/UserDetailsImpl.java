package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.Filmoviuloga;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String username;
	 private String password;
	 private Set<Filmoviuloga> roles;

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for(Filmoviuloga r:roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getNaziv()));
		}
		 return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<Filmoviuloga> getRoles() {
		return roles;
	}

	public void setRoles(Set<Filmoviuloga> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
