package Runner;

import Component.AcessoSiteComponent;
import Reader.LeituraDeDados;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcessoSiteRunner implements AcessoSiteComponent {

    //Dados para acesso do site
    public static WebDriver driver;
    public static WebDriverWait wait;
    LeituraDeDados dados = new LeituraDeDados();

    public void acessoSite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get(dados.consultaPropriedades("ACESSO_SITE"));
        driver.manage().window().maximize();
    }

    public void sairSite(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getDriverWait(){
        return wait;
    }
}
