package infonal_test_project;

/*
public class infodeneme
{

}

*/


//package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class infodeneme {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.yandex.com.tr/");
		selenium.start();
	}

	@Test
	public void testInfodeneme() throws Exception {
		selenium.open("http://www.n11.com/");
		assertEquals("n11.com - Al��veri�in U�urlu Adresi", selenium.getTitle());
		selenium.click("link=Giri� Yap");
		selenium.waitForPageToLoad("30000");
		assertEquals("Giri� Yap - n11.com", selenium.getTitle());
		selenium.type("id=email", "testotomasyon1@outlook.com");
		selenium.type("id=password", "123456ot");
		selenium.click("id=loginButton");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=searchData");
		selenium.type("id=searchData", "samsung");
		selenium.click("css=span.icon.iconSearch");
		selenium.waitForPageToLoad("30000");
		//verifyEquals("Samsung", selenium.getText("css=div.resultText > h1"));
		selenium.click("link=2");
		selenium.waitForPageToLoad("30000");
		assertEquals("2", selenium.getValue("name=currentPage"));
		selenium.click("//li[3]/div/div[2]/span[2]");
		String kontrol1 = selenium.getText("//li[3]/div/div/a/h3");
		selenium.click("link=Hesab�m");
		selenium.waitForPageToLoad("30000");
		assertEquals("Hesab�m - n11.com", selenium.getTitle());
		selenium.click("xpath=(//a[contains(text(),'Favorilerim')])[2]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Favorilerim - n11.com", selenium.getTitle());
		assertEquals(kontrol1, selenium.getText("//td[3]/p/a"));
		System.out.println("de�er = " + kontrol1);
		selenium.click("link=Kald�r");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
