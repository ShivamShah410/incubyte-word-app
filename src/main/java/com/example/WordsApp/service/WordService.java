package com.example.WordsApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WordsApp.component.Words;
import com.example.WordsApp.repository.WordRepo;

@Service
public class WordService {

	@Autowired
	WordRepo repo;

	public List<Words> getAllwords() {
		return repo.findAll();
	}

	public Words updateWord(Words w) {
		
		Words updatedWprd = repo.save(w);
		return updatedWprd;
	}

	public String deleteWord(int id) {
		repo.deleteById(id);
		return "success";
	}

	public Words createWord(Words word) {
		repo.save(word);
		return repo.findByWord(word.getWord());
	}
	
	public Words findWord(String name) {
		return repo.findByWord(name);
	}
	
}
