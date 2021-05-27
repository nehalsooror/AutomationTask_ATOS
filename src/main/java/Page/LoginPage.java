package Page;

import UIActions.UiAction;
import org.openqa.selenium.By;

import static UIActions.UiAction.WAIT_UNTIL_VISIBILITY;

public class LoginPage {

    UiAction elementaction = new UiAction();

    By email = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@type='password']");
    By submitButton = By.xpath("//button[@type='submit']");





    public LoginPage EnterEmail(String mail){ elementaction.FindElement(email).SendKeysToElement(mail);
        return this; }

    public LoginPage EnterPassword(String pass) { elementaction.FindElement(password).SendKeysToElement(pass);
        return this; }

    public void ClickSubmitButton(){
        elementaction.FindElement(submitButton).ActOntheElement(UiAction.CLICK);
    }




}
