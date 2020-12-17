package com.peqa.example_name.constants;

public class Path {
    /**
     * Constructor
     * 
     */
    public Path() {
        //
    }

    public static class Api {
        public static String VERSION = "/api/v1";
    }

    public static class Web {
        // This class holds all the web related routes.

        public static String HOME = "/";
        // get routes
        public static String GET_CV_MAIN = Path.Api.VERSION + "/CurriculumVitae";

        public static String GET_CV = Path.Api.VERSION + "/CurriculumVitae/:id";

        public static String GET_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo/:id";

        public static String GET_EDUCATIONS = Path.Api.VERSION + "/Educations/:id";
        public static String GET_TECHNICAL_SKILLS = Path.Api.VERSION + "/TechnicalSkills/:id";
        public static String GET_EXPERIENCES = Path.Api.VERSION + "/Experiences/:id";
        public static String GET_PROJECTS = Path.Api.VERSION + "/Projects/:id";
        public static String GET_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/:id";

        // post routes
        public static String POST_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo/";

        public static String POST_EDUCATIONS = Path.Api.VERSION + "/Educations/";
        public static String POST_TECHNICAL_SKILLS = Path.Api.VERSION + "/TechnicalSkills/";
        public static String POST_EXPERIENCES = Path.Api.VERSION + "/Experiences/";
        public static String POST_PROJECTS = Path.Api.VERSION + "/Projects/";
        public static String POST_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/";

        // put routes
        public static String PUT_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo/:id";

        public static String PUT_EDUCATIONS = Path.Api.VERSION + "/Educations/:id";
        public static String PUT_TECHNICAL_SKILLS = Path.Api.VERSION + "/TechnicalSkills/:id";
        public static String PUT_EXPERIENCES = Path.Api.VERSION + "/Experiences/:id";
        public static String PUT_PROJECTS = Path.Api.VERSION + "/Projects/:id";
        public static String PUT_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/:id";

        // delete routes
        public static String DELETE_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo/:id";

        public static String DELETE_EDUCATIONS = Path.Api.VERSION + "/Educations/:id";
        public static String DELETE_TECHNICAL_SKILLS = Path.Api.VERSION + "/TecnicalSkills/:id";
        public static String DELETE_EXPERIENCES = Path.Api.VERSION + "/Experiences/:id";
        public static String DELETE_PROJECTS = Path.Api.VERSION + "/Projects/:id";
        public static String DELETE_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/:id";
    }

    public static class Pages {

        public static String INDEX = "../frontend/html/index.html";
    }
}
