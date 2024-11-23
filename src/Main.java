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

        Cep cep = new Cep();
        FileCep fileCep = new FileCep();

        try {
            cep.menu();

            InformacoesCep minhasInformacoesCep = cep.bucaCep(cep.getCep());
            System.out.println(minhasInformacoesCep);
            fileCep.file(minhasInformacoesCep);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}
