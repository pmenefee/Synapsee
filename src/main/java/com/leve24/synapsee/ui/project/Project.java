package com.leve24.synapsee.ui.project;

public class Project {

    private String name;

    private String path;


    public void Create(String ProjectName){
        name = ProjectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
