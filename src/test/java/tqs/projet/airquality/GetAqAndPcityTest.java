package tqs.projet.airquality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import static io.github.bonigarcia.seljup.BrowserType.OPERA;

@ExtendWith(SeleniumJupiter.class)
public class GetAqAndPcityTest {
	
  private WebDriver driver;
  JavascriptExecutor js;
  
  public GetAqAndPcityTest(PhantomJSDriver driver) {
	  this.driver = driver;
	  js = driver;
  }
  
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void getAqAndPcity() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("input_city")).click();
    driver.findElement(By.id("input_city")).sendKeys("Aveiro");
    driver.findElement(By.id("redirect")).click();
    assertThat(driver.findElement(By.cssSelector(".container > .table tr:nth-child(1) > td")).getText(), is("Aveiro"));
    assertThat(driver.findElement(By.cssSelector(".container > .table tr:nth-child(2) > td")).getText(), is("PT"));
    assertThat(driver.getTitle(), is("Air quality for Aveiro"));
  }
}
