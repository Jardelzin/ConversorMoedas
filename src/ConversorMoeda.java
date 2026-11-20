import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoeda {
 public static void main(String[] args){
     Scanner leitor = new Scanner(System.in);

     //Menu
     System.out.println("=== CONVERSOR DE MOEDAS ===");
     System.out.println("Escolha para qual moeda deseja converter:");
     System.out.println("1 - Dólar Americano (USD)");
     System.out.println("2 - Euro (EUR)");
     System.out.println("3 - Libra Esterlina (GBP)");
     System.out.print("Digite o número da opção: ");
     int opcao = leitor.nextInt();

     //Variaveis
     String parMoeda = "";
     String nomeMoeda = "";
     String simbolo = "";


     //Estrutura de decisão
     switch(opcao){
         case 1:
             parMoeda = "USD-BRL";
             nomeMoeda = "Dólar ";
             simbolo = "US$";
             break;
         case 2:
             parMoeda = "EUR-BRL";
             nomeMoeda = "Euro";
             simbolo = "€";
             break;
         case 3:
             parMoeda = "GBP-BRL";
             nomeMoeda = "Libra Esterlina";
             simbolo = "£";
             break;
         default:
             System.out.println("Opção inválida! Encerrando o programa.");
             leitor.close();
             return;

     }

     try {
         System.out.println("\nBuscando cotação atual do " + nomeMoeda + "...");

         // Concatenamos (+) a variável parMoeda no final da URL
         String url = "https://economia.awesomeapi.com.br/json/last/" + parMoeda;

         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(url))
                 .GET()
                 .build();

         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         String json = response.body();

         // Extraindo a cotação
         String busca = "\"bid\":\"";
         int inicio = json.indexOf(busca) + busca.length();
         int fim = json.indexOf("\"", inicio);
         String cotacaoTexto = json.substring(inicio, fim);

         double taxaAtual = Double.parseDouble(cotacaoTexto);

         System.out.printf("Cotação atual (%s): R$ %.2f%n", nomeMoeda, taxaAtual);
         System.out.println("-----------------------------------");

         System.out.print("Digite o valor em Reais (BRL): R$ ");
         double valorEmReais = leitor.nextDouble();

         double valorConvertido = valorEmReais / taxaAtual;

         //Inserir o símbolo (US$, € ou £) no texto
         System.out.printf("Resultado: %s %.2f%n", simbolo, valorConvertido);

     } catch (Exception e) {
         System.out.println("Erro ao buscar cotação. Verifique sua internet.");
         e.printStackTrace();
     } finally {
         leitor.close();
     }
 }








 }












