package com.peqa.example_name;

import static spark.Spark.get;

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
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();
        DatosGenerales datosGenerales = inicializarDatosGenerales("Erick Agrazal", "29", "Yo soy un desarrollador empedernido.");
        Estudios estudios = inicializarEstudios();
        get("/datos-generales", (req, res) -> {
            res.type("application/json");
            JSONObject jo = new JSONObject(datosGenerales);
            return jo;
        });
        get("/estudios", (req, res) -> {
            res.type("application/json");
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
}
