import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static String monedaBase;
    public static String monedaConver;
    public static double cantidad = 0;
    public static Scanner lectura = new Scanner((System.in));
    static String inicios = """
                 ↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓ 
                 • Bienvenido/a al Conversor de Monedas ☺ •
                """;
    static String menu = """       
                        MENU 
            1 • Dólar → Peso argentino
            2 • Peso Argentino → Dólar
            3 • Dólar → Real brasileño
            4 • Real brasileño → Dólar
            5 • Dólar → Peso colombiano
            6 • Peso colombiano → Dólar
            7 • Salir  """;

    String fin = """
                \nIngrese el número de la opción elegida
                       Elija una opción válida
                 ↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓◄►↓ 
                """;
    static String continuar = """
                Continuar con el menu:
                1 • Continuar.
                2 • Salir.
                """;
    static String chau ="Hasta pronto ☻";

    public static void main(String[] args) throws IOException, InterruptedException {
        ConsulApi consulApi = new ConsulApi();
        System.out.println(inicios);
        System.out.println(menu);

    int busqueda = lectura.nextInt();

     switch (busqueda) {
        case 1:

            monedaBase="USD";
            monedaConver="ARS";
            System.out.println("Ingresar cantidad de $"+ monedaBase+" a convertin en $"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("La conversión de :" +monedaBase+" $"+cantidad+", a "+monedaConver+ " es de $"+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");
            break;
        case 2:
            monedaBase="ARS";
            monedaConver="USD";
            System.out.println("Ingresar cantidad de"+ monedaBase+" a convertin en pesos"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("Tienes total de: "+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");

            break;
        case 3:
            monedaConver="USD";
            monedaConver="BRC";
            System.out.println("Ingresar cantidad de"+ monedaBase+" a convertin en pesos"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("Tienes total de: "+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");

            break;
        case 4:
            monedaBase="BRC";
            monedaConver="USD";
            System.out.println("Ingresar cantidad de"+ monedaBase+" a convertin en pesos"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("Tienes total de: "+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");

            break;
        case 5:

            monedaBase="USD";
            monedaConver= "COP";
            System.out.println("Ingresar cantidad de"+ monedaBase+" a convertin en pesos"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("Tienes total de: "+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");


            break;
        case 6:
            monedaBase= "COP";
            monedaConver="USD";
            System.out.println("Ingresar cantidad de"+ monedaBase+" a convertin en pesos"+ monedaConver);
            cantidad = lectura.nextDouble();
            System.out.println("Tienes total de: "+ consulApi.GestionDeConsulta(monedaBase,monedaConver, cantidad) + ".");

            break;
        case 7:
            System.out.println(chau);
            return;
        default:
            System.out.println("Opción no válida");
            System.out.println(continuar);
            int continuarr ;
            continuarr = lectura.nextInt();
            switch (continuarr) {

                case 2:
                    System.out.println(chau);
                    return;
                default:
                    System.out.println("Opción no válida");
                    System.out.println(continuar);
                    return;
            }
    }
        System.out.println();

    }

}




