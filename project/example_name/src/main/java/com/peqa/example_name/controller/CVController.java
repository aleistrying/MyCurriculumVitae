package com.peqa.example_name.controller;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.peqa.example_name.constants.*;
import com.peqa.example_name.structure.Profesional;
import com.peqa.example_name.structure.Profesionals;
import com.peqa.example_name.structure.personStructure.Experiences;
import com.peqa.example_name.structure.personStructure.GeneralInfo;

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

    public static JSONObject handleGetGeneralInfo(Request req, Response res, Profesionals pro) {

        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getGeneralInfo());
    }

    public static JSONObject handleGetSocialLinks(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getSocialLinks());
    }

    public static JSONObject handleGetExperiences(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getExperiences());
    }

    public static JSONObject handleGetEducations(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getEducations());
    }

    public static JSONObject handleGetProjects(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getProjects());
    }

    public static JSONObject handleGetTechnicalSkills(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getTechnicalSkills());
    }

    public static JSONObject handlePutGeneralInfo(Request req, Response res, Profesionals pro) {

        res.type("application/json");
        JSONObject body;
        JSONObject generalInfo;
        try {
            body = new JSONObject(req.body());
        } catch (Exception e) {
            return new JSONObject("{success:false, message:'Incorrect JSON Formatting.'}");
        }
        try {
            generalInfo = body.getJSONObject("generalInfo");
        } catch (Exception e) {
            return new JSONObject("{success:false, message:'Incorrect JSON Formatting.'}");
        }

        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        GeneralInfo gi = new GeneralInfo();

        gi.setName(generalInfo.getString("name"));
        gi.setLastname(generalInfo.getString("lastname"));
        gi.setProfesionalTitle(generalInfo.getString("profesionalTitle"));
        gi.setLocation(generalInfo.getString("location"));
        gi.setAboutMe(generalInfo.getString("aboutMe"));

        pro.getProfesional(id).setGeneralInfo(gi);

        return new JSONObject("{success:true}");

    }

    public static JSONObject handlePutSocialLinks(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getSocialLinks());
    }

    public static JSONObject handlePutExperiences(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        JSONObject body = new JSONObject(req.body());
        // Object experiences = body.get("experiences");

        // System.out.println("THIS IS body body");
        // System.out.println(body);
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        // System.out.println("THIS IS experiences");
        // // System.out.println(body.getString("experiences"));
        // System.out.println("THIS IS json");
        JSONArray jsonExperiences;
        try {
            jsonExperiences = body.getJSONArray("experiences");
        } catch (Exception e) {
            return new JSONObject("{success:false, message:'Incorrect JSON Formatting.'}");
        }
        // System.out.println("done");
        int i = 0;
        Experiences exp = new Experiences();
        JSONObject value;
        JSONArray details;
        while (i < jsonExperiences.length()) {
            // System.out.println("in loop");
            // System.out.println(jsonExperiences.get(i));
            try {
                value = jsonExperiences.getJSONObject(i);
            } catch (Exception e) {
                return new JSONObject("{success:false, message:'Incorrect JSON Formatting.'}");
            }
            List<String> detailsList = new ArrayList<>();
            int k = 0;
            try {
                details = value.getJSONArray("details");
            } catch (Exception e) {
                return new JSONObject("{success:false, message:'Incorrect JSON Formatting.'}");
            }
            while (k < details.length()) {

                // System.out.println("loop details");
                // System.out.println(details.getString(k));

                detailsList.add(details.getString(k));
                k++;
            }

            // System.out.println("experiences in loop");
            // System.out.println(value);
            exp.addExperience(value.getString("organizationName"), (int) value.get("year"), value.getString("position"),
                    detailsList);
            // System.out.println("added exp");

            i++;
        }

        // System.out.println("THIS IS experiences json with orgname");
        // System.out.println(exp);

        // System.out.println(new
        // JSONObject(body.getString("experiences")).getString("organizationName"));

        // exp.addExperience(experiences["organizationName"], experiences["year"],
        // position, details);

        pro.getProfesional(id).setExperiences(exp);

        return new JSONObject("{success:true}");
    }

    public static JSONObject handlePutEducations(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getEducations());
    }

    public static JSONObject handlePutProjects(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getProjects());
    }

    public static JSONObject handlePutTechnicalSkills(Request req, Response res, Profesionals pro) {
        res.type("application/json");
        // default value when you search
        int id = 1;
        try {
            id = Integer.parseInt(req.params(":id"));
        } catch (Exception e) {
            // console.log(e);
            System.out.println(e);
        }
        return new JSONObject(pro.getProfesional(id).getTechnicalSkills());
    }
}
