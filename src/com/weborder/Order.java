package com.weborder;

import java.nio.charset.Charset;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
  
  
  
  public String selectCard(int randomCardAsInt) {
    String[] card = {
      "#ctl00_MainContent_fmwOrder_cardList_0",
      "#ctl00_MainContent_fmwOrder_cardList_1",
      "#ctl00_MainContent_fmwOrder_cardList_2"};

    return card[randomCardAsInt];
  }
  
  public static void main(String[] args) throws InterruptedException {
    
    System.setProperty("webdriver.chrome.driver", "/Users/Mediart/Documents/selenium dependencies/drivers/chromedriver.exe");
    
    WebDriver driver = new ChromeDriver();
    driver.manage().window().fullscreen();
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");

    driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
    
    driver.findElement(By.cssSelector("#ctl00_menu > li:nth-child(3) > a")).click();
    
    
      Random r = new Random();
      int random = r.nextInt(99);
      String rStr = "" + random;
      
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(rStr);
    
    String[] middleName = {"Olsen", "Kamil", "Yusuf", "Osman", "Kemal", "Hamit", "Hasan", "Oguzhan", "Omer", "Mehmet"};
        
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys("John " + middleName[r.nextInt(middleName.length)] + " Smith");
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
    
    String zipCode= "";
    for (int i = 0; i < 5; i++) {
      zipCode += "" + r.nextInt(9);
    }

    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);

    Order newCard = new Order();
    int cardType = r.nextInt(3);
    String creditCard = newCard.selectCard(cardType);
  
    driver.findElement(By.cssSelector(creditCard)).click();
    
    
//    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1")).click();
//    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_2")).click();

//    Enter any card number. If you selected Visa, card number should start with 4.
//    If you selected Master, card number should start with 5. 
//    If you selected American Express, card number should start with 3.
//    New card number should be auto generated every time you run the test. 
//    Card numbers should be 16 digits for Visa and Master, 15 for American Express.
    
    String card= "";
    
    if(cardType == 0) {
      card = "4";
      for (int i = 0; i < 15; i++) {
      card += "" + r.nextInt(9);
      }  
    }else if(cardType == 1) {
      card = "5";
      for (int i = 0; i < 15; i++) {
        card += "" + r.nextInt(9);
        }
    }else if(cardType == 2) {
      card = "3";
      for (int i = 0; i < 14; i++) {
        card += "" + r.nextInt(9);
        }
    }
    
    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(card);

    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("04/27");

    driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton")).click();

    
    if( driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder > tbody > tr > td > div > strong")).isDisplayed()){
      System.out.println("Verified");
      }else{
      System.out.println("unVerified");
      }
    
//     String expected = "New order has been successfully added.";
//          String text = driver.findElement(By.tagName("body")).getText();
//          if (text.contains(expected)) {
//              System.out.println("pass");
//          } else {
//              System.out.println("fail");
//              System.out.println("Expected:\t" + expected);
//          }
    
    
    
    
    
    Thread.sleep(5000);
    driver.close();
    
  }
  
  
  
}