import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneTest3 {
    @Test
    public void gmailTitleTest() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cabalities = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(url,cabalities);

        driver.get("http://gmail.com");
        System.out.println(driver.getTitle());
    }
}
