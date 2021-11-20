package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FilmoviKorisnikRepository;

import model.Filmovikorisnik;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private FilmoviKorisnikRepository korisnikRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Filmovikorisnik user = korisnikRepository.findByKorisnickoime(username);
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUsername(user.getKorisnickoime());
		userDetails.setPassword(user.getSifra());
		userDetails.setRoles(user.getUlogas());
		return userDetails;
	}

}
