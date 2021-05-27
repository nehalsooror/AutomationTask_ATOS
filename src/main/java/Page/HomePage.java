package Page;

import UIActions.UiAction;
import org.openqa.selenium.By;

import static UIActions.UiAction.WAIT_UNTIL_VISIBILITY;

public class HomePage {

    By loginPageTitle ;

    UiAction elementaction = new UiAction();



    public Boolean findPageTitle (String name){
        Boolean status = false;
        loginPageTitle = By.xpath(String.format("//h3[contains(text(),'%s')]",name));
        elementaction.ElementWait(loginPageTitle,WAIT_UNTIL_VISIBILITY);
         status = elementaction.FindElement(loginPageTitle).elementIsDisplayed();
           return status;
    }
}
