package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.UlogaImage;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.FilmoviKorisnikRepository;
import com.example.demo.repository.FilmoviUlogeRepository;
import com.example.demo.repository.GlumacRepository;
import com.example.demo.repository.OcenaRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.ZanrRepository;

import model.Film;
import model.Glumac;
import model.Uloga;

@Controller
@RequestMapping(value="uloga")
public class UlogaController {

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
	
	@RequestMapping(value="UnosUlogaInit", method=RequestMethod.GET)
	public String initialize(Model m){
		m.addAttribute("ulogaI", new UlogaImage());
		return "unosUloge";
	}
	
	@RequestMapping(value="saveUlogaImg", method=RequestMethod.POST)
	public String saveGlumac(Model m, @ModelAttribute("ulogaI") UlogaImage ulogaImage, HttpServletRequest request, HttpServletResponse response,
			String ime, String prezime, Integer godina, String nazivFilma){
		MultipartFile file = ulogaImage.getSlika();
		if (null != file) {
			String fileName = file.getOriginalFilename();
			String filePath;
			try {
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je "+filePath);
				File imageFile = new File(filePath, fileName);
				file.transferTo(imageFile);
				Uloga uloga = new Uloga();
				uloga.setNaziv(ulogaImage.getNaziv());
				Glumac glumac = new Glumac();
				glumac.setIme(ime);
				glumac.setPrezime(prezime);
				glumac.setGodina(godina);
				gr.save(glumac);
				Film film = fr.findFilmByNaziv(nazivFilma);
				uloga.setFilm(film);
				uloga.setGlumac(glumac);
				uloga.getGlumac().setSlika(Files.readAllBytes(imageFile.toPath()));
				ur.save(uloga);
				request.getSession().setAttribute("uloga", uloga);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "unosUloge";
	}
}
