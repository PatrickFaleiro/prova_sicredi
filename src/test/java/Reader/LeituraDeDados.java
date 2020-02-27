package Reader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeituraDeDados {

    String caminho = "C:\\projects\\prova_sicredi\\src\\test\\java\\Config\\";
    String caminhoConfiguracao = caminho + "Configuracoes.properties";
    Properties propriedades = new Properties();



    public String consultaPropriedades(String propriedade){
        try {
            propriedades.load(new FileInputStream(caminhoConfiguracao));
            switch (propriedade) {
                case "NOME_USUARIO":
                    return propriedades.getProperty("nome");
                case "ULTIMO_NOME_USUARIO":
                    return propriedades.getProperty("ultimoNome");
                case "CONTATO_USUARIO":
                    return propriedades.getProperty("contatoNome");
                case "NUMERO_TELEFONE":
                    return propriedades.getProperty("numerotelefone");
                case "ENDERECO_USUARIO":
                    return propriedades.getProperty("enderecoUsuario");
                case "ENDERECO_COMPLEMENTO":
                    return propriedades.getProperty("enderecoComplemento");
                case "CIDADE_USUARIO":
                    return propriedades.getProperty("cidadeUsuario");
                case "ESTADO_USUARIO":
                    return propriedades.getProperty("estadoUsuario");
                case "CODIGO_POSTAL":
                    return propriedades.getProperty("codigoPostal");
                case "PAIS_ORIGEM_USUARIO":
                    return propriedades.getProperty("paisUsuario");
                case "LIMITE_CREDITO":
                    return propriedades.getProperty("limiteCreditoUsuario");
                case "ACESSO_SITE":
                    return propriedades.getProperty("http_site");

            }

            } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException e) {
           return e.getMessage();
        }
        return null;
    }

}



