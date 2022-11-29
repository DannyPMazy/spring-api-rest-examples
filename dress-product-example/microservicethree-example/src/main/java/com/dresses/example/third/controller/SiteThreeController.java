package com.dresses.example.third.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dresses.example.third.model.*;
import com.dresses.example.third.repository.DressProductRepository;

@RestController
public class SiteThreeController {
	
	@Autowired
	private DressProductRepository repository;
	
	@GetMapping("/comunicate")
	public String getCommunication() {
		return "La Porta 8008 sta rispondendo";
	}
	
	@GetMapping("/databasecontrolling")
	public String controllingDatabaseIfEmpty() {
		List<DressProduct> products = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(products::add);
		if (products.isEmpty()) {
			return "Il Database è vuoto";
		} else {
			return "Il Database contiene uno o più prodotti";
		}
	}

}
