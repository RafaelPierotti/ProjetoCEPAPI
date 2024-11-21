import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        CEP cep = new CEP();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o seu CEP");
        cep.setCep(scanner.nextLine());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String url = "viacep.com.br/ws/" + cep.getCep() + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
    }
}