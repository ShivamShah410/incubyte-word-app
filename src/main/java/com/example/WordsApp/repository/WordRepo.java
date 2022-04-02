package com.example.WordsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WordsApp.component.Words;

@Repository
public interface WordRepo extends JpaRepository<Words, Integer> {

	Words findByWord(String name);


	
}
