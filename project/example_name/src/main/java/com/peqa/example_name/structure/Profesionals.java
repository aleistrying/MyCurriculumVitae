package com.peqa.example_name.structure;

import com.peqa.example_name.structure.*;
import com.peqa.example_name.structure.personStructure.*;
import java.util.List;
import java.util.ArrayList;

public class Profesionals {
    List<Profesional> profesionals = new ArrayList<>();

    public void addProfesional(int id, GeneralInfo _gi, Educations _ed, Experiences _ex, Projects _pr, SocialLinks _sl,
            TechnicalSkills _ts) {
        Profesional profesional = new Profesional();
        profesional.setId(id);
        profesional.setGeneralInfo(_gi);
        profesional.setEducations(_ed);
        profesional.setExperiences(_ex);
        profesional.setProjects(_pr);
        profesional.setSocialLinks(_sl);
        profesional.setTechnicalSkills(_ts);
        profesionals.add(profesional);
    }

    public List<Profesional> getProfesionals() {
        return profesionals;
    }

    public Profesional getProfesional(int id) {
        int i = 1;
        while (i - 1 < profesionals.size()) {
            if (profesionals.get(i - 1).getId() == id) {
                return profesionals.get(i - 1);
            }
            i++;
        }
        return new Profesional();
    }

    public int getSize() {
        return profesionals.size();
    }
}
