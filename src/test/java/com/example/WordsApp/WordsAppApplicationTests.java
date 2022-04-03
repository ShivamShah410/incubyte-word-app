package com.example.WordsApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
		String input = "wdw23ew232";
		Words ip = new Words(input);
		Words addedword = service.createWord(ip);
		assertEquals(addedword.getWord(), input);
		assertTrue(addedword.getId() > 0);
	}

	@Test
	void updateWordTest() {
		Words wordToBeUpdate = new Words();
		wordToBeUpdate.setId(1);
		wordToBeUpdate.setWord("New Word");
		Words updatedWord = service.updateWord(wordToBeUpdate);
		assertNotEquals(null, updatedWord);
	}
	
	@Test
	void deleteWordTest() {
		String deletedWord = service.deleteWord(27);
		assertNotEquals(null, deletedWord);
	}
	
	
}
