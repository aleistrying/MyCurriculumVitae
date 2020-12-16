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

        public static String GET_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo";

        public static String GET_EDUCATION = Path.Api.VERSION + "/Education";
        public static String GET_EXPERIENCE = Path.Api.VERSION + "/Experience";
        public static String GET_PROJECTS = Path.Api.VERSION + "/Projects";
        public static String GET_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks";

        // post routes
        public static String POST_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo/";

        public static String POST_EDUCATION = Path.Api.VERSION + "/Education/";
        public static String POST_EXPERIENCE = Path.Api.VERSION + "/Experience/";
        public static String POST_PROJECTS = Path.Api.VERSION + "/Projects/";
        public static String POST_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/";

        // put routes
        public static String PUT_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo";

        public static String PUT_EDUCATION = Path.Api.VERSION + "/Education/:id";
        public static String PUT_EXPERIENCE = Path.Api.VERSION + "/Experience/:id";
        public static String PUT_PROJECTS = Path.Api.VERSION + "/Projects/:id";
        public static String PUT_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/:id";

        // delete routes
        public static String DELETE_GENERAL_INFO = Path.Api.VERSION + "/GeneralInfo";

        public static String DELETE_EDUCATION = Path.Api.VERSION + "/Education/:id";
        public static String DELETE_EXPERIENCE = Path.Api.VERSION + "/Experience/:id";
        public static String DELETE_PROJECTS = Path.Api.VERSION + "/Projects/:id";
        public static String DELETE_SOCIAL_LINKS = Path.Api.VERSION + "/SocialLinks/:id";
    }

    public static class Pages {

        public static String INDEX = "../frontend/html/index.html";
    }
}
