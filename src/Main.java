import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println("Informe o seu cep: ");
        var cep = scanner.nextLine();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Cep meuCep = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            InformacoesCep minhasInformacoesCep = gson.fromJson(json, InformacoesCep.class);

            meuCep = new Cep(minhasInformacoesCep);

            System.out.println(meuCep);

        } catch (JsonSyntaxException e){
            System.out.println("CEP Inválido");
            System.out.println(e.getMessage());
        }

        FileWriter file = new FileWriter("cep.json");
        file.write(gson.toJson(meuCep));
        file.close();
        System.out.println("Programa finalizado");
    }
}
