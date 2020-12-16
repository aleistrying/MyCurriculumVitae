package com.peqa.example_name.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import spark.Request;
import spark.Response;
import com.peqa.example_name.constants.*;
import com.peqa.example_name.structure.*;

import org.json.JSONObject;

public class IndexController {
    static Logger logger = Logger.getLogger(IndexController.class);

    public IndexController() {
        //
    }

    // this could change easily to a rendering engine that can render the CV HTML
    // pages
    // using handlebars, ejs or some other engine. USELESS FOR NOW
    public static JSONObject serveHomePage(Request req, Response res) {
        JSONObject json = new JSONObject(req);

        return json;
    }

}
