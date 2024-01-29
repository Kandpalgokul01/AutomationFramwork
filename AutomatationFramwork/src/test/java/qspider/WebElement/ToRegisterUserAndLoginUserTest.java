package qspider.WebElement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import qspider.pomRepo.LoginPage;
import qspider.pomRepo.RegisterPage;

public class ToRegisterUserAndLoginUserTest extends BaseClass {

	
	@Test
	public void toRegister() throws EncryptedDocumentException, IOException, InterruptedException {
		String name=fileUtil.fetchDataFromRegisterExcelSheet("TestDataContainer", 1, 0);
		String email= fileUtil.fetchDataFromRegisterExcelSheet("TestDataContainer", 1, 1);
		String password= fileUtil.fetchDataFromRegisterExcelSheet("TestDataContainer", 1, 2);

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.registerUser(name, email, password);
		
		Thread.sleep(2000);
		
		LoginPage login= new LoginPage(driver);
		
		Assert.assertTrue(login.verifyRegisterUser());
		System.out.println("Pass: the user has registerd");
		
	}
	
	public void toLogin() throws EncryptedDocumentException, IOException {
		
		String email= fileUtil.fetchDataFromRegisterExcelSheet("TestDataContainer", 1, 1);
		String password= fileUtil.fetchDataFromRegisterExcelSheet("TestDataContainer", 1, 2);

		LoginPage login= new LoginPage(driver);
		login.loginUser(email, password);
		
		
	}
}
