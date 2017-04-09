package com.springwebservice.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.springwebservice.model.Slogan;
import com.springwebservice.services.SloganService;

@ManagedBean(name="sloganDataTable")
@RequestScoped
public class SloganDataTableController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{sloganService}")
	SloganService sloganService;
	
	private List<Slogan> sloganList = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		sloganList = sloganService.findAll();
	}
	
	public SloganService getSloganService() {
		return sloganService;
	}

	public void setSloganService(SloganService sloganService) {
		this.sloganService = sloganService;
	}

	public List<Slogan> getSloganList() {
		return sloganList;
	}

	public void setSloganList(List<Slogan> sloganList) {
		this.sloganList = sloganList;
	}
	
}
