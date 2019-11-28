# language: pt

  Funcionalidade: Cenários do cadastro de usuários


    Cenário: Cadastrar um usuário na página de cadastros
      Dado que acesso a pagina de cadastro de usuarios
      E mudo a versao do bootstrap
      E clico em Add Customer
      E insiro as informações para cadastrar um usuario
      Quando clico em Save
      Então é exibida mensagem informando que os dados foram salvos com sucesso

    Cenario: Excluir cadastro inserido
      Dado que estou na lista de usuarios
      E pesquiso pelo cadastro recem inserido
      E clico no botão More
      E clico em Delete
      Quando clico em Delete na pop up de confirmação
      Então é exibida mensagem informando que o cadastro foi excluído