package com.peqa.example_name;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.options;
import static spark.Spark.before;
import static spark.Spark.staticFileLocation;
import static spark.Spark.staticFiles;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONObject;

import com.peqa.example_name.structure.personStructure.*;
import com.peqa.example_name.structure.*;
import com.peqa.example_name.constants.*;

import com.peqa.example_name.controller.CVController;

import java.util.Arrays;

/**
 * CV de Alejandro Parparcen!
 *
 */
public class App {
    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        GeneralInfo gi = initializeGeneralInfo();
        SocialLinks sl = initializeSocialLinks();
        Educations ed = initializeEducation();
        Experiences ex = initializeExperiences();
        Projects pr = initializeProjects();
        TechnicalSkills ts = initializeTechnicalSkills();

        Profesionals profesionals = new Profesionals();
        profesionals.addProfesional(1, gi, ed, ex, pr, sl, ts);

        BasicConfigurator.configure();

        staticFiles.location("/public");
        // staticFileLocation("/public");
        // home route

        // get(Path.Web.HOME, "text/html", (req, res) -> {
        // return IndexController.serveHomePage(req, res);
        // });

        get(Path.Web.HOME, (req, res) -> {
            res.status(200);
            res.redirect("/html/index.html");
            return "";
        });
        // IndexController.serveHomePage(req, res));
        // System.out.println("CV PATH" + Path.Web.GET_CV);
        get(Path.Web.GET_CV, (req, res) -> CVController.serveCV(req, res, profesionals));
        get(Path.Web.GET_CV_MAIN, (req, res) -> CVController.serveCV(req, res, profesionals));

        get(Path.Web.GET_GENERAL_INFO, (req, res) -> CVController.serveGeneralInfo(req, res, profesionals));
        get(Path.Web.GET_SOCIAL_LINKS, (req, res) -> CVController.serveSocialLinks(req, res, profesionals));
        get(Path.Web.GET_EXPERIENCE, (req, res) -> CVController.serveExperience(req, res, profesionals));
        get(Path.Web.GET_EDUCATION, (req, res) -> CVController.serveEducation(req, res, profesionals));
        get(Path.Web.GET_PROJECTS, (req, res) -> CVController.serveProjects(req, res, profesionals));

        // put routes
        post(Path.Web.PUT_EDUCATION, (req, res) -> {
            JSONObject json = new JSONObject(req);

            return json;
        });

        post(Path.Web.POST_EXPERIENCE, (req, res) -> {
            res.type("aplication/json");
            JSONObject json = new JSONObject(req);

            return json;
        });

        post("/addProject", (req, res) -> {
            res.type("aplication/json");
            JSONObject json = new JSONObject(req);

            return json;
        });

        enableCors();

    }

    public static GeneralInfo initializeGeneralInfo() {
        GeneralInfo gi = new GeneralInfo();
        gi.setName("Alejandro");
        gi.setLastname("Parparcen");
        gi.setProfesionalTitle("Software Developer");
        gi.setLocation("Panama, Panama City");
        gi.setAboutMe(
                "I'm a guy who loves technology and is driven by the desire to learn, solve and create. All the challenges i give myself, i complete with efficency and accuracy. Details and quality matter most to me when working by myself or with a team, mediocrity isn't acceptable hence why I push myself and my peers to do our best.");
        return gi;
    }

    public static SocialLinks initializeSocialLinks() {

        SocialLinks sl = new SocialLinks();
        sl.addSocialLinks("Discord", "._.#1238", "../img/Discord.svg");
        sl.addSocialLinks("WhatsApp", "+507 6938-9892", "../img/WhatsApp.svg");
        sl.addSocialLinks("Email", "alejandroparparcen@yahoo.com", "../img/Email.svg");
        sl.addSocialLinks("GitHub", "https://github.com/lapron3000", "../img/GitHub.svg");
        sl.addSocialLinks("Portfolio", "https://to-do.AlejoWeb.com", "../img/Portfolio.svg");
        return sl;
    }

    public static Educations initializeEducation() {
        Educations ed = new Educations();
        // to-do, probably adding grade? and location ?
        ed.addEducation("Instituto PC CENTER", 2016, 2017,
                "Certificado de Reparacion de Computadoras: Reparacion, Mantenimiento y Construccion de Computadoras");
        ed.addEducation("El Colegio de Panama", 2008, 2018, "Bachiller en Ciencias");
        ed.addEducation("Universidad Tecnologica de Panama", 2019, 2019, "Certificado de Linux Essentials");
        ed.addEducation("Universidad Tecnologica de Panama", 2019, 2022, "Licenciatura en Desarrollo de Software");
        return ed;
    }

    public static Experiences initializeExperiences() {
        Experiences ex = new Experiences();

        ex.addExperience("PostNet", 2018, "Software Dev. & Tech Support", Arrays.asList(
                "Cloned disks, Cleaned Cases, and Helped overall the business work better in some tech aspects.",
                "Created software in C# to manage their stock better, this software used MySQL and Windows forms.",
                "Helped create a PHP software that helps manage Orders of Work OT System."));

        ex.addExperience("Quijano & Associates", 2019, "Jr. Programmer",
                Arrays.asList("I used PL/SQL to create forms, querys and fix day to day problems.",
                        "I had projects and fixes i manages in day to day basis to support the companies software.",
                        "I worked with Forms & Reports, and also Apex."));

        ex.addExperience("PostNet", 2020, "Software Developer & Software Engineer", Arrays.asList(
                "Helped create various screens in React. This system was a CRM that gave users accounts, with those accounts you could create a cart, and then use a credit card or yappy to pay.",
                "Did Frontend screens using react classes, Material UI, Materialize and W3.CSS.",
                "Worked the whole backend security system to create keys, salts, hashes, etc."));

        ex.addExperience("Uman Tech Consulting", 2020, "Software Developer & Software Engineer", Arrays.asList(
                "Worked with a Startup to create an app that manages KPIs (key performance indicators) from each of the users that buy the solution.",
                "Did Frontend screens using react classes, Material UI, and W3.CSS.",
                "Worked the whole backend security system to create keys, salts, hashes, etc.",
                "Created most of the backend querys made in MongoDB using mongoose as a library.",
                "Used heroku to deploy the app, and git to version manage."));
        return ex;
    }

    public static Projects initializeProjects() {

        Projects pr = new Projects();
        pr.addProject("Profesional Curriculum Vitae",
                "This is an aplication to show the CV of a profesional. This application has a frontend in JS, HTML, CSS and a backend in Java using Spark. The frontend communicates with the backend throughout an API created in Spark with Java.",
                "https://github.com/lapron3000/MyCurriculumVitae", "https://github.com/lapron3000/MyCurriculumVitae",
                Arrays.asList("Javascript", "HTML", "CSS", "Java", "Spark"));
        pr.addProject("Test2",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Deserunt enim tenetur libero corrupti saepe exercitationem ea eius nobis voluptas laudantium non quo voluptates, placeat quidem quae ab voluptatibus magni! Qui.Lorem ipsum dolor sit amet consectetur adipisicing elit. Deserunt enim tenetur libero corrupti saepe exercitationem ea eius nobis voluptas laudantium non quo voluptates, placeat quidem quae ab voluptatibus magni! Qui.",
                "https://github.com/lapron3000", "https://github.com/lapron3000",
                Arrays.asList("test", "magic", "coding", "React2"));
        return pr;
    }

    public static TechnicalSkills initializeTechnicalSkills() {
        TechnicalSkills ts = new TechnicalSkills();
        ts.addTechnicalSkill("Human Languages", Arrays.asList("Spanish", "English"));
        ts.addTechnicalSkill("Programming Languages", Arrays.asList("PL/SQL", "Java", "JavaScript", "Python", "C#"));
        ts.addTechnicalSkill("Front-end", Arrays.asList("HTML/CSS", "Bootstrap", "Materialize", "W3.CSS", "React"));
        ts.addTechnicalSkill("Back-end", Arrays.asList("Node JS", "Java", "PHP"));
        ts.addTechnicalSkill("Databases", Arrays.asList("MySQL", "MongoDB", "Oracle"));
        ts.addTechnicalSkill("Others", Arrays.asList("Git", "Heroku", "Amazon AWS", "Office365", "Unity", "AutoCAD",
                "Google Search", "Knowledge of Computer Parts"));
        return ts;
    }

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
        // before((request, response) -> {
        // response.header("Access-Control-Allow-Origin", "*");
        // response.header("Access-Control-Request-Method", "*");
        // response.header("Access-Control-Allow-Headers", "*");
        // });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }
}
