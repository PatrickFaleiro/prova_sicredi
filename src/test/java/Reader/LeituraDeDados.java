package Reader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeituraDeDados {

    String caminho = "C:\\projects\\prova_sicredi\\src\\test\\java\\Config\\";
    String appConfigPath = caminho + "Configuracoes.properties";
    Properties properties = new Properties();

    public String getNomeUsuario() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("nome");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getUltimoNomeUsuario() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("ultimoNome");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getNomeContatoUsuario() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("contactName");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getTelefoneUsuario() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("numerotelefone");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getEnderecoUsuario() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("enderecoUm");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getComplementoEndereco() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("enderecoDois");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getCidade() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("cidadeUsuario");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getEstado() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("estadoUsuario");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getCodigoPostal() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("postalCode");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getPais() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("paisUsuario");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getLimiteCredito() {
        try {
            properties.load(new FileInputStream(appConfigPath));
            return properties.getProperty("limiteCreditoUsuario");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}



