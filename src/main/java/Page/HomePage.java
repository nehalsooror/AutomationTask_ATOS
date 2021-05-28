package Page;

import UIActions.UiAction;
import org.openqa.selenium.By;

import static UIActions.UiAction.WAIT_UNTIL_VISIBILITY;
import static UIActions.UiAction.WAIT_implicitlyWait;

public class HomePage {

    By loginPageTitle ;

    UiAction elementaction = new UiAction();



    public String findPageTitle (String name){
        String  status = null;
        loginPageTitle = By.xpath(String.format("//h3[contains(text(),'%s')]",name));
        elementaction.ElementWait(loginPageTitle,WAIT_implicitlyWait);
         status = elementaction.FindElement(loginPageTitle).ActOntheElement(UiAction.GET_TEXT);
         System.out.println(status);
           return status;
    }
}
