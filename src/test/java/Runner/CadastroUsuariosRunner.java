package Runner;

import Component.AcessoSiteComponent;
import Component.CadasatroUsuariosComponent;
import Reader.LeituraDeDados;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ResourceBundle;

import static Runner.AcessoSiteRunner.driver;

public class CadastroUsuariosRunner implements CadasatroUsuariosComponent {

    //Localizadores do botão bootstrap version
    private static final String botaoListaBootstrapVersao = "switch-version-select";
    private static final String opcaoBootstrapV4 = "bootstrap_theme_v4";
    //Localizador do botão Add Customer
    private static final String botaoAddCustomer = "a.btn.btn-default";
    //Localizadores dos campos da página de cadastro
    private static final String nomeUsuario = "field-customerName";
    private static final String sobrenomeUsuario = "field-contactLastName";
    private static final String nomeContato = "field-contactFirstName";
    private static final String telefone = "field-phone";
    private static final String primeiroEndereco = "field-addressLine1";
    private static final String segundoEndereco = "field-addressLine2";
    private static final String cidade = "field-city";
    private static final String estado = "field-state";
    private static final String codigoPostal = "field-postalCode";
    private static final String pais = "field-country";
    private static final String campoEmpregador = "//*[contains(text(),'Select from Employeer')]";
    private static final String listaEmpregador = "//div[@class='chosen-drop']/ul/li[contains(text(),'Fixter')]";
    private static final String limiteCredito = "field-creditLimit";
    private static final String botaoSave = "form-button-save";
    private static final String mensagemSucesso = "report-success";
    private static final String cancelarCadastro = "cancel-button";
    //Localizadores lista de usuários
    private static final String campoNomePesquisa = "customerName";
    private static final String campoTesteSicredi = "//form[@id='gcrud-search-form']//td[contains(text(),'Teste Sicredi')]";
    private static final String botaoMore = "//button[contains(text(), 'More')]";
    private static final String botaoDelete = "//div[@class='only-desktops']//a[@title='Delete']";
    private static final String botaoDeleteConfirmacao = "//div[@class='modal-dialog']//button[contains(text(),'Delete')]";
    private static final String mensagemExcusaoSucesso = "//*[contains(text(),'Your data has been successfully deleted from the database.')]";


    LeituraDeDados dados = new LeituraDeDados();

    public void mudaVersaoBootstrap() {
        Select boostrapVersoes = new Select(AcessoSiteRunner.getDriver().findElement(By.id(botaoListaBootstrapVersao)));
        boostrapVersoes.selectByValue(opcaoBootstrapV4);

    }

    public void clicaAddCustomer() {
        AcessoSiteRunner.getDriver().findElement(By.cssSelector(botaoAddCustomer)).click();
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id(nomeUsuario)));
    }

    public void preencheFormularioCadastroUsuario() {

        AcessoSiteRunner.getDriver().findElement(By.id(nomeUsuario)).sendKeys(dados.getNomeUsuario());
        AcessoSiteRunner.getDriver().findElement(By.id(sobrenomeUsuario)).sendKeys(dados.getUltimoNomeUsuario());
        AcessoSiteRunner.getDriver().findElement(By.id(nomeContato)).sendKeys(dados.getNomeContatoUsuario());
        AcessoSiteRunner.getDriver().findElement(By.id(telefone)).sendKeys(dados.getTelefoneUsuario());
        AcessoSiteRunner.getDriver().findElement(By.id(primeiroEndereco)).sendKeys(dados.getEnderecoUsuario());
        AcessoSiteRunner.getDriver().findElement(By.id(segundoEndereco)).sendKeys(dados.getComplementoEndereco());
        AcessoSiteRunner.getDriver().findElement(By.id(cidade)).sendKeys(dados.getCidade());
        AcessoSiteRunner.getDriver().findElement(By.id(estado)).sendKeys(dados.getEstado());
        AcessoSiteRunner.getDriver().findElement(By.id(codigoPostal)).sendKeys(dados.getCodigoPostal());
        AcessoSiteRunner.getDriver().findElement(By.id(pais)).sendKeys(dados.getPais());
        AcessoSiteRunner.getDriver().findElement(By.xpath(campoEmpregador)).click();
        AcessoSiteRunner.getDriver().findElement(By.xpath(listaEmpregador)).click();
        AcessoSiteRunner.getDriver().findElement(By.id(limiteCredito)).sendKeys(dados.getLimiteCredito());
    }

    public void clicaEmSave() {
        AcessoSiteRunner.getDriver().findElement(By.id(botaoSave)).click();
    }

    public void validaMensagemCadastroComSucesso() {

        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.id(mensagemSucesso)));
        String mensagem = AcessoSiteRunner.getDriver().findElement(By.id(mensagemSucesso)).getText();
        Assert.assertThat(mensagem , CoreMatchers.containsString("Your data has been successfully stored into the database."));
    }

    public void retornaPaginaListaUsuarios() {
        AcessoSiteRunner.getDriver().findElement(By.id(cancelarCadastro)).click();
    }

    public void pesquisaNomeUsuarioCadastrado() {
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.name(campoNomePesquisa)));
        AcessoSiteRunner.getDriver().findElement(By.name(campoNomePesquisa)).sendKeys(dados.getNomeUsuario());
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(campoTesteSicredi),dados.getNomeUsuario()));
    }

    public void abreOpcoesCadastro() {
        AcessoSiteRunner.getDriver().findElement(By.xpath(botaoMore)).click();
    }

    public void clicaBotaoDelete() {
        AcessoSiteRunner.getDriver().findElement(By.xpath(botaoDelete)).click();
    }

    public void validaMensagemExclusao() {
        AcessoSiteRunner.getDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(mensagemExcusaoSucesso)));
        String sucesso = AcessoSiteRunner.getDriver().findElement(By.xpath(mensagemExcusaoSucesso)).getText();
        Assert.assertEquals(sucesso, "Your data has been successfully deleted from the database.");
    }

    public void confirmaDeletarCadastro() {
        AcessoSiteRunner.getDriver().findElement(By.xpath(botaoDeleteConfirmacao)).click();
    }


}
