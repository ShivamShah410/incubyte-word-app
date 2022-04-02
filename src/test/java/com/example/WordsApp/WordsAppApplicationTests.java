package com.example.WordsApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.WordsApp.component.Words;
import com.example.WordsApp.service.WordService;

@SpringBootTest
class WordsAppApplicationTests {
	
	@Autowired
	WordService service;

	@Test
	void getAllWordsTest() {
		List<Words> allWords = service.getAllwords();
		assertTrue(allWords.size() > 0);
	}
	
	@Test
	void addWordTest() {
		Words ip = new Words("qwerty");
		Words addedword = service.createWord(ip);
		assertEquals(addedword.getWord(), "qwerty");
		assertTrue(addedword.getId() > 0);
	}

	@Test
	void updateWordTest() {
		Words updatedWord = service.updateWord();
		assertEquals(null, updatedWord);
	}
	
	@Test
	void deleteWordTest() {
		Words deletedWord = service.deleteWord();
		assertEquals(null, deletedWord);
	}
	
	
}
