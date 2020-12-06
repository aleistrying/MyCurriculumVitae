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
        DatosGenerales dg = inicializarDatosGenerales("Erick Agrazal", "29", "Yo soy un desarrollador empedernido.");
        get("/datos-generales", (req, res) -> {
            res.type("application/json");
            JSONObject jo = new JSONObject(dg);
            return jo;
        });
    }

    public static DatosGenerales inicializarDatosGenerales(String _nombre, String _edad, String _abstracto){
        DatosGenerales dg = new DatosGenerales();
        dg.setNombre(_nombre);
        dg.setEdad(_edad);
        dg.setAbstracto(_abstracto);
        return dg;
    }
}
