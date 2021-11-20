package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.FilmImage;
import com.example.demo.domain.UlogaImage;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.GlumacRepository;
import com.example.demo.repository.KategorijeRepository;
import com.example.demo.repository.OcenaRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.repository.ZanrRepository;

import model.Film;
import model.Glumac;
import model.Kategorija;
import model.Ocena;
import model.Uloga;
import model.Zanr;

@Controller
@RequestMapping(value="filmovi")
public class FilmoviController {

	@Autowired
	FilmRepository fr;
	
	@Autowired
	ZanrRepository zr;
	
	@Autowired
	KategorijeRepository kr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	UlogaRepository ur;
	
	@Autowired
	GlumacRepository gr;
	
	@ModelAttribute
	public void getRoles(Model model) {
		List<Film> filmovi = fr.findAll();
		model.addAttribute("filmovi", filmovi);
	}
	
	@ModelAttribute
	public void getZanrove(Model model) {
		List<Zanr> zanrovi = zr.findAll();
		model.addAttribute("zanrovi", zanrovi);
	}
	
	@ModelAttribute
	public void getKategorije(Model model) {
		List<Kategorija> kategorije = kr.findAll();
		model.addAttribute("kategorije", kategorije);
	}
	
	@RequestMapping(value="UnosFilmaInit", method=RequestMethod.GET)
	public String initialize(Model m){
		m.addAttribute("filmI", new FilmImage());
		return "unos/SaveFilm";
	}
	
	@RequestMapping(value="/dodajKomentar", method=RequestMethod.POST)
	public String dodajKomentar(HttpServletRequest request, String komentar, Integer idfilm, Integer ocena) {
		Ocena o = new Ocena();
		o.setOcena(ocena);
		o.setKomentar(komentar);
		or.save(o);
		Film film = fr.findById(idfilm).get();
		film.setOcena(o);
		fr.flush();
		request.setAttribute("film", film);
		return "prikazFilmaPoImenu";
	}
	
	@RequestMapping(value="saveFilmImg", method=RequestMethod.POST)
	public String saveFilm(Model m, @ModelAttribute("filmI") FilmImage filmImage, HttpServletRequest request, HttpServletResponse response,
			Integer idzanr, Integer idkategorija, Integer ocena){
		MultipartFile file = filmImage.getSlika();
		if (null != file) {
			String fileName = file.getOriginalFilename();
			String filePath;
			try {
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je "+filePath);
				File imageFile = new File(filePath, fileName);
				Zanr zanr = zr.findById(idzanr).get();
				Kategorija kategorija = kr.findById(idkategorija).get();
				file.transferTo(imageFile);
				Film f1 = new Film();
				f1.setNaziv(filmImage.getNaziv());
				f1.setTrajanje(filmImage.getTrajanje());
				Ocena o = or.findByOcena(ocena);
				f1.setOcena(o);
				f1.setOpis(filmImage.getOpis());
				f1.setReziser(filmImage.getReziser());
				f1.setZanr(zanr);
				f1.setKategorija(kategorija);
				f1.setSlika(Files.readAllBytes(imageFile.toPath()));
				fr.save(f1);
			
				request.getSession().setAttribute("film", f1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "unos/SaveFilm";
	}
}
