import browsertest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();

        //Verify the text
        String expectedMsg = "Welcome Back!";
        String actualMsg = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        //Click on the sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(5000);

        //Enter the invalid username
        driver.findElement(By.id("user[email]")).sendKeys("pri123@gmail.com");
        Thread.sleep(5000);

        //Enter the invalid password
        driver.findElement(By.id("user[password]")).sendKeys("Prima101!");
        Thread.sleep(5000);

        //Click on Login button
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(5000);

       //Verify the error message
        String expectedMsg = "Invalid email or password.";
        String actualMsg = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
