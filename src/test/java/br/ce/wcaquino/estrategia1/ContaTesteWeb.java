package br.ce.wcaquino.estrategia1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTesteWeb {

  private ChromeDriver driver;

  @Before
  public void login() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("http://seubarriga.wcaquino.me/");
    driver.findElementById("email").sendKeys("tcosta1996@hotmail.com");
    driver.findElementById("senha").sendKeys("SeuBarriga");
    driver.findElementByTagName("button").click();
  }

  @Test
  public void teste_1_inserir() {
    driver.findElement(By.linkText("Contas")).click();
    driver.findElement(By.linkText("Adicionar")).click();
    driver.findElement(By.id("nome")).sendKeys("Conta estratégia #1");
    driver.findElement(By.tagName("button")).click();

    String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    Assert.assertEquals("Conta adicionada com sucesso!", mensagem);
  }

  @Test
  public void teste_2_consultar() {
    driver.findElement(By.linkText("Contas")).click();
    driver.findElement(By.linkText("Listar")).click();
    driver.findElement(By.xpath("// td[contains(text(),'Conta estratégia #1')]/..//a")).click();

    String nomeConta = driver.findElement(By.id("nome")).getAttribute("value");
    Assert.assertEquals("Conta estratégia #1", nomeConta);
  }

  @Test
  public void teste_3_alterar() {
    driver.findElement(By.linkText("Contas")).click();
    driver.findElement(By.linkText("Listar")).click();
    driver.findElement(By.xpath("// td[contains(text(),'Conta estratégia #1')]/..//a")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Conta estratégia #1 - alterada");
    driver.findElement(By.tagName("button")).click();
    String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    Assert.assertEquals("Conta alterada com sucesso!", mensagem);
  }

  @Test
  public void teste_4_excluir() {
    driver.findElement(By.linkText("Contas")).click();
    driver.findElement(By.linkText("Listar")).click();
    driver.findElement(By.xpath("// td[contains(text(),'Conta estratégia #1 - alterada')]/..//a[2]")).click();

    String mensagem = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    Assert.assertEquals("Conta removida com sucesso!", mensagem);
  }

  @After
  public void fechar() {
    driver.quit();
  }
}
