package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.FilmoviUlogeRepository;
import com.example.demo.repository.ZanrRepository;

import model.Filmoviuloga;
import model.Zanr;

public class ZanrConverter implements Converter<String, Zanr>{

	@Autowired 
	ZanrRepository zr;
	
	public ZanrConverter(ZanrRepository zr){
		this.zr = zr;
	}
	
	@Override
	public Zanr convert(String source) {
		int idzanr = -1;
		try {
			idzanr = Integer.parseInt(source);
		}catch(NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Zanr.class),idzanr, null);
		}
		return null;
	}
}
