package com.springwebservice.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.springwebservice.model.Slogan;
import com.springwebservice.services.SloganService;

@ManagedBean
@SessionScoped
public class HomeController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String moveToPage1() {
      return "/home";
	}
	
}