import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Cep {
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o seu CEP: ");
        this.cep = scanner.nextLine();
    }

    public InformacoesCep bucaCep (String cep){
        URI url = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), InformacoesCep.class);
        } catch (Exception e) {
            throw new RuntimeException("CEP não encontrado!");
        }
    }
}
