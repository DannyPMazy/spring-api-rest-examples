package com.dresses.example.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.dresses.example.second.model.DressProduct;
import com.dresses.example.second.repository.*;

@RestController
public class SiteTwoController {
	
	@Autowired
	private DressProductRepository repository;
	
	@GetMapping("/comunicate")
	public String getCommunication() {
		return "La Porta 8082 sta rispondendo";
	}

	@PostMapping("/addproduct")
	public String addProduct(@Validated @RequestBody DressProduct product) {
		repository.save(product);
		return "Prodotto Aggiunto Correttamente nel Database";
	}
	
	@GetMapping("/readproducts")
	public ResponseEntity<List<DressProduct>> readProducts() {
		List<DressProduct> products = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(products::add);
		return ResponseEntity.ok().body(products);
	}
	
}
