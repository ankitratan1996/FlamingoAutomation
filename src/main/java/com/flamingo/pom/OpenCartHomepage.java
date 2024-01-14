package com.flamingo.pom;

import org.openqa.selenium.By;

public class OpenCartHomepage {
	
	private OpenCartHomepage() {}
	
	By openCartLogo=By.xpath("//*[@id=\"logo\"]/a/img");
	By navbarDesktops=By.linkText("Desktops");
	By navbarLaptopsNotebooks=By.linkText("Laptops & Notebooks");
	By navbarComponents=By.linkText("Components");
	By navbarTablets=By.linkText("Tablets");
	By navbarSoftware=By.linkText("Software");
	By navbarPhonesPDAs =By.linkText("Cameras");
	By navbarMP3Players =By.linkText("MP3 Players");
	By searchbar=By.xpath("//*[@id=\"search\"]/input");
	By kartDisplay=By.xpath("//*[@id=\"header-cart\"]/div/button");
	
}
