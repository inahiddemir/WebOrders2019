package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    /*
    This class gonna be super class for all page classses. Includuing  all common locators,
    WebElements and initialize page factory.
     */
    @FindBy(tagName = "h1")
    private WebElement pageLogo;

    public BasePage(){
        //its coming from selenium WebDriver
        //to enable @FindBy annotations (FindBy coming from selenium)
        PageFactory.initElements(Driver.get(),this);
    }

    public String getPageLogoText(){
        return pageLogo.getText();
    }

    public void navigateTo(String moduleName){
        Driver.get().findElement(By.linkText(moduleName)).click();
    }

}
