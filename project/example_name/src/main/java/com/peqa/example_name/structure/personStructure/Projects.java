package com.peqa.example_name.structure.personStructure;

import java.util.List;
import java.util.ArrayList;

public class Projects {
    List<Project> projects = new ArrayList<>();

    public void addProject(String projectName, String description, String sourceCode, String tryOut,
            List<String> keywords) {
        Project project = new Project();
        project.setProjectName(projectName);
        project.setDescription(description);
        project.setSourceCode(sourceCode);
        project.setTryOut(tryOut);
        project.setKeywords(keywords);

        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getSize() {
        return projects.size();
    }
}