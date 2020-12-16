package com.peqa.example_name.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import com.peqa.example_name.constants.*;
import com.peqa.example_name.structure.Profesional;
import com.peqa.example_name.structure.Profesionals;

public class CVController {
    static Logger logger = Logger.getLogger(CVController.class);

    public CVController() {
        //
    }

    public static JSONObject serveCV(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id));
    }

    public static JSONObject serveGeneralInfo(Request req, Response res, Profesionals pro) {
        res.type("application/json");

        JSONObject json = new JSONObject(pro.getGeneralInfo());

        return json;
    }

    public static JSONObject serveSocialLinks(Request req, Response res, Profesionals pro) {
        res.type("application/json");

        JSONObject json = new JSONObject(pro.getSocialLinks());

        return json;
    }

    public static JSONObject serveExperience(Request req, Response res, Profesionals pro) {
        res.type("application/json");

        JSONObject json = new JSONObject(pro.getExperiences());

        return json;
    }

    public static JSONObject serveEducation(Request req, Response res, Profesionals pro) {
        res.type("application/json");

        JSONObject json = new JSONObject(pro.getEducations());

        return json;
    }

    public static JSONObject serveProjects(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        JSONObject json = new JSONObject(pro.getProjects());

        return json;
    }
}
