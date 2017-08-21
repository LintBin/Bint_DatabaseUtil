package com.bint.generation;

import com.bint.exception.NotSupportDataBaseException;
import org.junit.Test;

import com.bint.data.DataBase;
import com.bint.util.DataBaseFactory;

public class SpellerTest {
	private Speller speller = new Speller();
	DataBase dataBase = DataBaseFactory.getDataBaseInstance();

	public SpellerTest() throws NotSupportDataBaseException {
	}

	@Test
	public void getTableContent() {
		String result = null;
		try {
			result = speller.getTableContent(dataBase.getTables().get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
