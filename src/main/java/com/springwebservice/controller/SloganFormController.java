package com.springwebservice.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.springwebservice.model.Slogan;
import com.springwebservice.services.SloganService;

@ManagedBean(name = "sloganForm")
@SessionScoped
public class SloganFormController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{sloganService}")
	SloganService sloganService;
	
	private Slogan slogan = new Slogan();

	public SloganService getSloganService() {
		return sloganService;
	}

	public void setSloganService(SloganService sloganService) {
		this.sloganService = sloganService;
	}
	
	public Slogan getSlogan() {
		return slogan;
	}

	public void setSlogan(Slogan slogan) {
		this.slogan = slogan;
	}
	
	public void submit() {
		if(!slogan.equals(new Slogan())) {
			sloganService.add(slogan);
		}
		slogan = new Slogan();
	}
}
