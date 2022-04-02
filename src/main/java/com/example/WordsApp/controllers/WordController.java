package com.example.WordsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WordsApp.component.Words;
import com.example.WordsApp.service.WordService;

@RestController
@RequestMapping(value = "/words")
public class WordController {
	
	@Autowired
	WordService service;

	@GetMapping("/all")
	public List<Words> getAll() {
		return service.getAllwords();
	}
	
	@PostMapping("/add")
	public Words createWord(@RequestBody Words w) {
//		Words word = new Words();
//		word.setWord(w);
		return service.createWord(w);
		
	}
	
}
