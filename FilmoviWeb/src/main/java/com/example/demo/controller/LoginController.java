package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.FilmoviKorisnikRepository;
import com.example.demo.repository.FilmoviUlogeRepository;
import com.example.demo.repository.GlumacRepository;
import com.example.demo.repository.OcenaRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.ZanrRepository;

import model.Film;
import model.Filmovikorisnik;
import model.Filmoviuloga;
import model.Glumac;
import model.Uloga;
import model.Zanr;

@Controller
@RequestMapping(value="auth")
public class LoginController {

	@Autowired
	FilmRepository fr;
	
	@Autowired
	FilmoviKorisnikRepository fkr;
	
	@Autowired
	FilmoviUlogeRepository fur;
	
	@Autowired
	ZanrRepository zr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	GlumacRepository gr;
	
	@Autowired
	UlogaRepository ur;
	
	
	@RequestMapping(value="/getUlogeFilma", method=RequestMethod.GET)
	public String getUlogeFilma(HttpServletRequest request, Integer idfilm) {
		Film film = fr.findById(idfilm).get();
		List<Uloga> uloge = ur.findUlogaByFilm(film);
		request.getSession().setAttribute("uloge", uloge);
		return "prikazUlogaFilma";
		
	}
	
	@RequestMapping(value="/getFilmByZanr", method=RequestMethod.GET)
	public String getFilmByZanr(HttpServletRequest request, String nazivZanra) {
		Zanr zanr = zr.findZanrByNaziv(nazivZanra);
		List<Film> filmovi = fr.findFilmByZanr(zanr);
		request.getSession().setAttribute("zanr", zanr);
		request.getSession().setAttribute("film", filmovi);
		return "sviFilmoviZanra";
	}
	
	
	@RequestMapping(value="/getFilm", method=RequestMethod.GET)
	public String getFilm(HttpServletRequest request, String naziv) {
		Film film = fr.findFilmByNaziv(naziv);
		request.getSession().setAttribute("film", film);
		return "prikazFilmaPoImenu";
	}
	
	@RequestMapping(value="getSlikaFilma", method=RequestMethod.GET)
	public void getSlikaFilma(HttpServletRequest request, HttpServletResponse response, Integer idFilma) {
		Film film = fr.findById(idFilma).get();
		byte[] slika = film.getSlika();
		
		response.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE);
		
		try {

			response.getOutputStream().write(slika);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		request.getSession().setAttribute("slika", null);
	}
	
	@RequestMapping(value="getSlikaGlumca", method=RequestMethod.GET)
	public void getSlikaGlumca(HttpServletRequest request, HttpServletResponse response, Integer idglumac) {
		Glumac glumac = gr.findById(idglumac).get();
		byte[] slika = glumac.getSlika();
		
		response.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE);
		
		try {

			response.getOutputStream().write(slika);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		request.getSession().setAttribute("slika", null);
	}
	
	@ModelAttribute
	public void getRoles(Model model) {
		List<Filmoviuloga> roles = fur.findAll();
		model.addAttribute("roles", roles);
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() {    
	   System.out.println("CALLED ME!!!!!!!!!!!");
    	return "login";
     
    }
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginHello() {    
		   System.out.println("YOU CALLED ME!!!!!!!!!!!");
	    	return "login";
	     
	    }
	
	 @RequestMapping(value = "registerUser", method = RequestMethod.GET)
		public String newUser(Model model) {
			Filmovikorisnik u = new Filmovikorisnik();
			model.addAttribute("user", u);
			return "register";
		}
	 
	 
	 @RequestMapping(value = "register", method = RequestMethod.POST)
		public String saveUser(@Valid @ModelAttribute("user") Filmovikorisnik u, Errors errors) {
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     	u.setSifra(passwordEncoder.encode(u.getSifra()));
			
	     	if(errors.hasErrors()) {
	     		return "register";
	     	}
	     	
			for (Filmoviuloga r : u.getUlogas()) {
				r.addKorisnik(u);
				
			}
	    	fkr.save(u);
	    	
	    	return "login";

		}
	 
	 
	 
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            SecurityContextHolder.getContext().setAuthentication(null);
	        }
	        return "redirect:/auth/loginPage";
	    }
	 
	 @RequestMapping(value="/pocetna", method = RequestMethod.GET)
	    public String getPocetna (){
	       
	        return "pocetna";
	 }
	
	
	@RequestMapping(value="/getSveFilmove", method=RequestMethod.GET)
	public String getSveFilmove(HttpServletRequest request) {
		List<Film> filmovi = fr.findAll();
		request.getSession().setAttribute("filmovi", filmovi);
		return "sviFilmovi";
	}
}
