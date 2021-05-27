package Page;

import org.openqa.selenium.By;


import UIActions.UiAction;

public class RegistrationPage {
	
	UiAction elementaction = new UiAction();
	
	By firstName = By.xpath("//input[@name='firstname']");
	By lastName = By.xpath("//input[@name='lastname']");
	By mobileNumber = By.xpath("//input[@name='phone']");
	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name='password']");
	By confirmPassword = By.xpath("//input[@name='confirmpassword']");
	By submitButton = By.xpath("//button[@type='submit']");





	public RegistrationPage EnterFirstName(String name){
		elementaction.FindElement(firstName).SendKeysToElement(name);
		return this;
	}
	public RegistrationPage EnterLastName(String name){
		elementaction.FindElement(lastName).SendKeysToElement(name);
		return this;
	}
	public RegistrationPage EnterPhoneNumber(String num){

		elementaction.FindElement(mobileNumber).SendKeysToElement(num);

		return this;

	}
	public RegistrationPage EnterEmail(String mail){
		
				  elementaction.FindElement(email).SendKeysToElement(mail);
		
		return this;
		
	}
	
	public RegistrationPage EnterPassword(String pass) {
		
			elementaction.FindElement(password).SendKeysToElement(pass);
		return this;
	}
	public RegistrationPage EnterConfirmPassword(String pass) {
		elementaction.FindElement(confirmPassword).SendKeysToElement(pass);
		return this;
	}

	public void ClickSubmitButton(){
		elementaction.FindElement(submitButton).ActOntheElement(UiAction.CLICK);
	}

}