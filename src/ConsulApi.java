import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsulApi {
    String apikey = "2ff7392c8ecf59b99207107a";
    // Setting URL
    String urlBase = "https://v6.exchangerate-api.com/v6/";
    //+apikey+"/pair/"+ monedaBase + monedaConver + cantidad;
    public double GestionDeConsulta(String monedaBase, String monedaConver, double cantidad) throws IOException, InterruptedException {


        // Making Request
        HttpClient client = HttpClient.newHttpClient();
        // Creamos la peticion, al igual que la URI para realizar la peticion a la API, incluyendo los parametros
        // a esperar del main
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + apikey + "/pair/" + monedaBase + "/" + monedaConver + "/" + cantidad))
                .build();

        // Se solicita la respuesta del cliente de tipo String
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Abrimos un tipo Gson de la libreria del mismo nombre para la conversion de JSON
        Gson gson = new Gson();
        // Creamos un jsonResponse el cual, con el metodo fromJson, convierte la cadena del json a un jsonObject
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        // Obtenemos el valor del conversion_result del objeto JsonObject, convirtiendolo a Double con el getAsDouble
        double conversionResult = jsonResponse.get("conversion_result").getAsDouble();
        // Retornamos el conversionResult

        return conversionResult;
    }
}
