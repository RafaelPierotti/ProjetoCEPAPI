import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class FileCep {

    public void file (InformacoesCep informacoesCep){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter file = new FileWriter("cep.json");
            file.write(gson.toJson(informacoesCep));
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
