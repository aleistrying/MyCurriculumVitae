package com.peqa.example_name;

import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.put;
import static spark.Spark.post;
import static spark.Spark.before;


import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import org.json.JSONObject;


/**
 * CV
 *      Estructura de JSON: 
 *      {
 *          'datosGenerales': {
 *              'nombre': 'Erick Agrazal',
 *              'edad': 29,
 *              'abstracto': 'Yo soy un desarrollador empedernido.'
 *          },
 *          'estudios': [
 *              {
 *                  'institucion': 'Universidad Tecnológica de Panamá',
 *                  'titulo': 'Ingeniero en sistemas'
 *              }
 *          ]
 *      }
 *
 */
public class App {
    static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ) {
        // Configura un logger simple de consola
        BasicConfigurator.configure();

        // Habilitar CORS
        enableCors();

        // Inicializar datos
        DatosGenerales datosGenerales = inicializarDatosGenerales("Erick Agrazal", "29", "Yo soy un desarrollador empedernido.");
        Estudios estudios = inicializarEstudios();

        // Controladores
        get("/datos-generales", (req, res) -> {
            res.type("application/json");
            JSONObject jo = new JSONObject(datosGenerales);
            return jo;
        });
        put("/datos-generales", (req, res) ->{
            res.type("application/json");
            JSONObject body = new JSONObject(req.body());
            datosGenerales.setNombre(body.getString("nombre"));
            datosGenerales.setEdad(body.getString("edad"));
            datosGenerales.setAbstracto(body.getString("abstracto"));
            JSONObject jo = new JSONObject(datosGenerales);
            return jo;
        });
        get("/estudios", (req, res) -> {
            res.type("application/json");
            JSONObject jo = new JSONObject(estudios);
            return jo;
        });
        post("/estudios", (req, res) -> {
            res.type("application/json");
            JSONObject body = new JSONObject(req.body());
            estudios.agregarEstudio(body.getString("institucion"), body.getString("titulo"));
            JSONObject jo = new JSONObject(estudios);
            return jo;
        });
    }

    public static DatosGenerales inicializarDatosGenerales(String _nombre, String _edad, String _abstracto){
        DatosGenerales datosGenerales = new DatosGenerales();
        datosGenerales.setNombre(_nombre);
        datosGenerales.setEdad(_edad);
        datosGenerales.setAbstracto(_abstracto);
        return datosGenerales;
    }

    public static Estudios inicializarEstudios(){
        Estudios estudios = new Estudios();
        estudios.agregarEstudio("Universidad Tecnológica de Panamá", "Ingeniero en sistemas");
        estudios.agregarEstudio("Universidad Tecnológica de Panamá", "Maestría en seguridad informática");
        estudios.agregarEstudio("Universidad Latina de Panamá", "Maestría en docencia superior");
        return estudios;
    }

    // ===========================================
    // NO HACE FALTA MODIFICAR DE AQUÍ HACIA ABAJO
    // ===========================================
    public static void enableCors() {
        options("/*", (request, response) -> {
    
          String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
          if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
          }
    
          String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
          if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
          }
    
          return "OK";
        });
    
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }

}
