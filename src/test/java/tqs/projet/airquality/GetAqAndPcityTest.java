package tqs.projet.airquality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.openqa.selenium.JavascriptExecutor;

@ExtendWith(SeleniumJupiter.class)
public class GetAqAndPcityTest {
	
  private WebDriver driver;
  private JavascriptExecutor js;
  
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
	    driver.findElement(By.xpath("//input")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("Aveiro");
	    driver.findElement(By.xpath("//button")).click();
	    assertThat(driver.findElement(By.xpath("//td[contains(.,\'Aveiro\')]")).getText(), is("Aveiro"));
	    assertThat(driver.findElement(By.xpath("//td[contains(.,\'PT\')]")).getText(), is("PT"));
	    assertThat(driver.getTitle(), is("Air quality for Aveiro"));
  }
}
