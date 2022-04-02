package com.example.WordsApp.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WORDS")
public class Words {

	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="WORD")
	String word;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Words(String word) {
		super();
		this.word = word;
	}
	
	public Words() {}
}
