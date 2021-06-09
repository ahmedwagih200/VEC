package com.example.vec.models;

import java.util.ArrayList;

public class InspectionModel {
    String partName;
    String problemSpinnerData;
    String solutionSpinnerData;
    String problemImagePath;
    String solutionImagePath;
    ArrayList<String> problemSpinnerItems;
    ArrayList<String> solutionSpinnerItems;

    public ArrayList<String> getProblemSpinnerItems() {
        return problemSpinnerItems;
    }

    public void setProblemSpinnerItems(ArrayList<String> problemSpinnerItems) {
        this.problemSpinnerItems = problemSpinnerItems;
    }

    public ArrayList<String> getSolutionSpinnerItems() {
        return solutionSpinnerItems;
    }

    public void setSolutionSpinnerItems(ArrayList<String> solutionSpinnerItems) {
        this.solutionSpinnerItems = solutionSpinnerItems;
    }

    public InspectionModel(String partName, String problemImagePath, String solutionImagePath, ArrayList<String> problemSpinnerItems, ArrayList<String> solutionSpinnerItems) {
        this.partName = partName;
        this.problemImagePath = problemImagePath;
        this.solutionImagePath = solutionImagePath;
        this.problemSpinnerItems = problemSpinnerItems;
        this.solutionSpinnerItems = solutionSpinnerItems;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getProblemSpinnerData() {
        return problemSpinnerData;
    }

    public void setProblemSpinnerData(String problemSpinnerData) {
        this.problemSpinnerData = problemSpinnerData;
    }

    public String getSolutionSpinnerData() {
        return solutionSpinnerData;
    }

    public void setSolutionSpinnerData(String solutionSpinnerData) {
        this.solutionSpinnerData = solutionSpinnerData;
    }

    public String getProblemImagePath() {
        return problemImagePath;
    }

    public void setProblemImagePath(String problemImagePath) {
        this.problemImagePath = problemImagePath;
    }

    public String getSolutionImagePath() {
        return solutionImagePath;
    }

    public void setSolutionImagePath(String solutionImagePath) {
        this.solutionImagePath = solutionImagePath;
    }
}
