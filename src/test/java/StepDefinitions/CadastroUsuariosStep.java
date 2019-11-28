package StepDefinitions;

import Component.AcessoSiteComponent;
import Component.CadasatroUsuariosComponent;
import Runner.AcessoSiteRunner;
import Runner.CadastroUsuariosRunner;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroUsuariosStep {

    AcessoSiteComponent acessoSiteComponent = new AcessoSiteRunner();
    CadasatroUsuariosComponent cadasatroUsuariosComponent = new CadastroUsuariosRunner();

    @Dado("que acesso a pagina de cadastro de usuarios")
    public void que_acesso_a_pagina_de_cadastro_de_usuarios() {
        acessoSiteComponent.acessoSite();
    }
   @E("mudo a versao do bootstrap")
    public void mudo_a_versao_do_bootstrap() {
        cadasatroUsuariosComponent.mudaVersaoBootstrap();
    }
    @E("clico em Add Customer")
    public void clico_em_Add_Customer() {
        cadasatroUsuariosComponent.clicaAddCustomer();
    }
    @E("insiro as informações para cadastrar um usuario")
    public void insiro_as_informações_para_cadastrar_um_usuario() {
        cadasatroUsuariosComponent.preencheFormularioCadastroUsuario();
    }
    @Quando("clico em Save")
    public void clico_em_Save() {
        cadasatroUsuariosComponent.clicaEmSave();
    }
    @Então("é exibida mensagem informando que os dados foram salvos com sucesso")
    public void é_exibida_mensagem_informando_que_os_dados_foram_salvos_com_sucesso() {
        cadasatroUsuariosComponent.validaMensagemCadastroComSucesso();
    }

    @Dado("que estou na lista de usuarios")
    public void que_estou_na_lista_de_usuarios() {
        cadasatroUsuariosComponent.retornaPaginaListaUsuarios();
    }
    @E("pesquiso pelo cadastro recem inserido")
    public void pesquiso_pelo_cadastro_recem_inserido() {
        cadasatroUsuariosComponent.pesquisaNomeUsuarioCadastrado();
    }
    @E("clico no botão More")
    public void clico_no_botão_More() {
        cadasatroUsuariosComponent.abreOpcoesCadastro();
    }
    @E("clico em Delete")
    public void clico_em_Delete() {
        cadasatroUsuariosComponent.clicaBotaoDelete();
    }
    @Quando("clico em Delete na pop up de confirmação")
    public void clico_em_Delete_na_pop_up_de_confirmacao() {
        cadasatroUsuariosComponent.confirmaDeletarCadastro();
    }
    @Então("é exibida mensagem informando que o cadastro foi excluído")
    public void e_exibida_mensagem_informando_que_o_cadastro_foi_excluido() {
        cadasatroUsuariosComponent.validaMensagemExclusao();
        acessoSiteComponent.sairSite();
    }
}
