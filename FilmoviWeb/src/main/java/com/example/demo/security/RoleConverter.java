package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.example.demo.repository.FilmoviUlogeRepository;

import model.Filmoviuloga;

public class RoleConverter implements Converter<String, Filmoviuloga>{

	@Autowired
	FilmoviUlogeRepository r;
	
	public RoleConverter(FilmoviUlogeRepository r){
		this.r=r;
	}
	
	@Override
	public Filmoviuloga convert(String source) {
		int idRole = -1;
		try {
			idRole = Integer.parseInt(source);
		}catch(NumberFormatException e) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Filmoviuloga.class),idRole, null);
		}
		return null;
	}

}
