package br.com.alura.screenmatch.viacep;
import br.com.alura.screenmatch.viacep.models.ConsultaCep;
import br.com.alura.screenmatch.viacep.models.Endereco;
import br.com.alura.screenmatch.viacep.models.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ConsultaCep consultaCep = new ConsultaCep();
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite um número de CEP para consulta: ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");

        }
    }
}
