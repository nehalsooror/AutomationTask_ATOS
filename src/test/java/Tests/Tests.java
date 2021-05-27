package Tests;

import BaseClass.Base;
import FileReader.ExcelReader;
import FileReader.PropertiesFileReader;
import Modules.InputDataValidation;
import Page.*;
import UIActions.UiAction;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests extends Base {

    RegistrationPage register;
    LoginPage login;
    HomePage home;
    InputDataValidation data;

    @DataProvider(name="Registration")
    public Object[][] getDataFromDataprovider(){
        return ExcelReader.XslxReader("E:/tasks/AutomationTaskATOS/inputTestData.xlsx");
    }

    /**
     * new Object[][]
     *                 {
     *                         { "Nehal", "srour","01061516120","kdjlsjk@hdh.com","Nehal@nono","Nehal@nono" },
     *                         { "Krishna", "Krishna","01061516120","jdkjs","eHal@nono","djhks" },
     *                         { "Bhupesh", "USA","kdjk","jdkjs","djhfs","djhks" }
     *                 };
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param pass
     * @param conPass
     */


    @Test(priority = 1 ,dataProvider = "Registration")
    public void verifyTheInputTestData(String firstName,String lastName,String phone,String email,String pass,String conPass) {

        data = new InputDataValidation();

        System.out.println(data.validateFirstName(firstName));
        System.out.println(data.validateLastName(firstName,lastName));
        System.out.println(data.validatePassword(pass));
        System.out.println(data.validateEmail(email));
    }


    @Test(priority= 2 ,dataProvider="Registration")
  public void registerNewUser(String firstName,String lastName,String phone,String email,String pass,String conPass) {
        String[] filedata = (PropertiesFileReader.propertiesFileReader(new String[]{"RegisterURL"},"configuration.properties"));
        UiAction.getDriver().navigate().to(filedata[0]);

        register = new RegistrationPage();
        register.EnterFirstName(firstName).EnterLastName(lastName).EnterPhoneNumber(phone).EnterEmail(email)
               .EnterPassword(pass).EnterConfirmPassword(conPass).ClickSubmitButton();
  }


    @Test(priority = 3 ,dataProvider="Registration")
    public void loginUser(String firstName,String lastName,String phone,String email,String pass,String conPass) {
        String[] filedata = (PropertiesFileReader.propertiesFileReader(new String[]{"LogoutURL"},"configuration.properties"));
        //To logout
        UiAction.getDriver().navigate().to(filedata[0]);
        //To login
        login = new LoginPage();
        home = new HomePage();
        login.EnterEmail(email).EnterPassword(pass).ClickSubmitButton();
        //to Assert the login is done successfully
        Assert.assertTrue(home.findPageTitle(firstName+" "+lastName));
    }
}