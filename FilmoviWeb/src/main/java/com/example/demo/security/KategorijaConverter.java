package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.FilmoviUlogeRepository;
import com.example.demo.repository.KategorijeRepository;

import model.Filmoviuloga;
import model.Kategorija;

public class KategorijaConverter implements Converter<String, Kategorija>{

	@Autowired
	KategorijeRepository kr;
	
	public KategorijaConverter(KategorijeRepository kr){
		this.kr = kr;
	}
	
	
	@Override
	public Kategorija convert(String source) {
		int idkategorija = -1;
		try {
			idkategorija = Integer.parseInt(source);
		}catch(NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Kategorija.class),idkategorija, null);
		}
		return null;
	}
}
