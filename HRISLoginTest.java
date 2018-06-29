package com.qait.automation.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRISLoginTest {
	HRISLogin hrs=new HRISLogin();
	
	
	
	@Test(priority= 0)
	public void testOpenBrowserAndOpenHris() {
		hrs.OpenBrowserAndOpenHris();
		Assert.assertTrue(hrs.URL().contains("hris.qainfotech"));
	}
	@Test(priority=1)
		public void testLoginCorrectCredentials() 
		{
		
			hrs.Login("rahulgumber", "Rahul@321#");
			Assert.assertTrue(hrs.URL().contains("timesheet"));
			hrs.Logout();
		}
	@Test(priority=2)
	public void testLoginWrongPass_LoginWrongUsr()
	{   
		
		hrs.Login("wrongusername", "123456789");
		hrs.clearFields();
		Assert.assertFalse(hrs.URL().contains("Login.php"));
	}
	@Test(priority=3)
	public void testBlankUser_Pass()
	{
		hrs.clearFields();
		hrs.Login("","");
		Assert.assertFalse(hrs.URL().contains("timesheet"));
		
	}
	@Test(priority=4)
	public void WrongPass_CorrectUsr()
	{
		hrs.clearFields();
		hrs.Login("rahulgumber", "great");
		Assert.assertFalse(hrs.URL().contains("timesheet"));
	}
	@Test(priority=5)
	public void testBlankUsr_CorrectPass()
	{	
		hrs.clearFields();
		hrs.Login("","Rahul@321#");
		Assert.assertFalse(hrs.URL().contains("timesheet"));		
	}
	}
	