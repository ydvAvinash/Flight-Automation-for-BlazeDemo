package Blazeautomation;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Blazedemoautomate {
	ChromeDriver driver;

	public void initializedriver() { 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void departcity(String city) {

		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		Select departcity = new Select(driver.findElement(By.xpath("//body/div[3]/form[1]/select[1]")));
		departcity.selectByValue(city);
	}

	public void destinationcity(String dcity) {
		Select descity = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		descity.selectByValue(dcity);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	public void chooseflight(String flightname) {
		String xpath = "//td[text()='" + flightname + "']/preceding-sibling::td/input[@type='submit']";
		driver.findElement(By.xpath(xpath)).click();
	}

	public void reserveddetail(String name, String address, String city, String state, int zip, String cardtypes,
			int ccn, int month, int year, String nameoc) {
		String namexp = "//input[@id='inputName']";
		String addxpath = "//input[@id='address']";
		String cityxp = "//input[@id='city']";
		String statexp = "//input[@id='state']";
		String zipxp = "//input[@id='zipCode']";
		String cardxp = "//select[@name='cardType']";// select class use garna parcha
		String ccnxp = "//input[@id='creditCardNumber']";
		String monthxp = "//input[@id='creditCardMonth']";
		String yearxp = "//input[@id='creditCardYear']";
		String nameocxp = "//input[@id='nameOnCard']";

		driver.findElement(By.xpath(namexp)).sendKeys(name);
		driver.findElement(By.xpath(addxpath)).sendKeys(address);
		driver.findElement(By.xpath(cityxp)).sendKeys(city);
		driver.findElement(By.xpath(statexp)).sendKeys(state);
		driver.findElement(By.xpath(zipxp)).sendKeys(String.valueOf(zip));
		Select cardt = new Select(driver.findElement(By.xpath(cardxp)));
		cardt.selectByValue(cardtypes);
		driver.findElement(By.xpath(ccnxp)).sendKeys(String.valueOf(ccn));
		driver.findElement(By.xpath(monthxp)).sendKeys(String.valueOf(month));
		driver.findElement(By.xpath(yearxp)).sendKeys(String.valueOf(year));
		driver.findElement(By.xpath(nameocxp)).sendKeys(nameoc);
		driver.findElement(By.xpath("//body/div[2]/form[1]/div[11]/div[1]/input[1]")).click();
		//driver.quit();
	}

	public static void main(String[] args) {

		Blazedemoautomate b1 = new Blazedemoautomate();
		b1.initializedriver();
		b1.departcity("Paris");
		b1.destinationcity("London");
		b1.chooseflight("Virgin America");
		b1.reserveddetail("John", "US", "Woodland", "California", 12345, "dinersclub", 123456789, 10, 2024, "Harry Styles");

		
	}

}

