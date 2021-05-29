package Tests;

import BaseClass.Base;

import FileReader.PropertiesFileReader;
import Modules.AllureTestExecutionListener;
import Modules.InputDataValidation;
import Page.*;
import UIActions.UiAction;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Listeners(AllureTestExecutionListener.class)
public class Tests extends Base {

    RegistrationPage register;
    LoginPage login;
    HomePage home;
    InputDataValidation data;

    /**
     *
     * To read data from excel file
     * @return
     */
    @DataProvider(name="Registration")
    public Object[][] getDataFromDataprovider(){
//        return ExcelReader.XslxReader("src\\test\\resources\\inputTestData.xlsx");
        return new Object[][] {{ "Nehal", "srour","01061516120","kdjlsjk@hdh.com","Nehal@nono","Nehal@nono" },
                              { "Krishna", "Krishna","01061516120","jdkjs","eHal@nono","djhks" },
                              { "Bhupesh", "USA","kdjk","jdkjs","djhfs","djhks" }};
    }

    /**
     * Validate the Contents of Excel Sheet Input Data
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param pass
     * @param conPass
     */

    @Description("Validate the Contents of Excel Sheet Input Data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("To Make Sure All The Input Data Is Up To Date And Valid")
    @Test(priority = 1 ,dataProvider = "Registration")
    public void verifyInputTestData(String firstName,String lastName,String phone,String email,String pass,String conPass) {

        data = new InputDataValidation();

        System.out.println(data.validateFirstName(firstName));
        System.out.println(data.validateLastName(firstName,lastName));
        System.out.println(data.validatePassword(pass));
        System.out.println(data.validateEmail(email));


    }

    /**
     * Register With Different Input Data
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param pass
     * @param conPass
     */

    @Description("Register With Different Input Data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register With Different Input Data")
    @Test(priority= 2 ,dataProvider="Registration")
  public void registerNewUser(String firstName,String lastName,String phone,String email,String pass,String conPass) {
        String[] filedata = (PropertiesFileReader.propertiesFileReader(new String[]{"RegisterURL"},"configuration.properties"));
        UiAction.getDriver().navigate().to(filedata[0]);

        register = new RegistrationPage();
        register.EnterFirstName(firstName).EnterLastName(lastName).EnterPhoneNumber(phone).EnterEmail(email)
               .EnterPassword(pass).EnterConfirmPassword(conPass).ClickSubmitButton();
  }

    /**
     * Login Using Same Input Data To Validate That The registration Is Done Successfully
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param pass
     * @param conPass
     */
    @Description("Login Using Same Input Data To Validate That The registration Is Done Successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("validating the login of registered users")
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
        Assert.assertEquals(home.findPageTitle(firstName+" "+lastName),firstName+" "+lastName);
    }
}