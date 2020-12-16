package com.peqa.example_name.structure.personStructure;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private String description;
    private String sourceCode;
    private String tryOut;
    private List<String> keywords = new ArrayList<>();

    public Project() {

    }

    public Project(String _projectName, String _description, String _tryOut, String _sourceCode,
            List<String> _keywords) {
        projectName = _projectName;
        description = _description;
        tryOut = _tryOut;
        sourceCode = _sourceCode;
        keywords = _keywords;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String _projectName) {
        projectName = _projectName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String _sourceCode) {
        sourceCode = _sourceCode;
    }

    public String getTryOut() {
        return tryOut;
    }

    public void setTryOut(String _tryOut) {
        tryOut = _tryOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String _description) {
        description = _description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> _keywords) {
        keywords = _keywords;
    }

}
