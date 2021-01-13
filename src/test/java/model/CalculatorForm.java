package model;

import java.util.Objects;

public class CalculatorForm {

     private String numberOfInstances;
     private String operatingSystem;
     private String machineClass;
     private String machineType;
     private String dataCenter;
     private String committedUsage;
     private String numberOfNodes;
     private String numberOfGPUs;
     private String typeGPU;
     private String localSSD;

    public CalculatorForm() {
    }

    public String getNumberOfInstances() { return numberOfInstances; }

    public String setNumberOfInstances(String testData) {
    return numberOfInstances = testData; }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String setOperatingSystem(String testData) {
        return operatingSystem = testData; }

    public String getMachineClass() {
        return machineClass;
    }

    public String setMachineClass(String testData) {
        return machineClass = testData; }

    public String getMachineType() {
        return machineType;
    }

    public String setMachineType(String testData) {
        return machineType = testData; }

    public String getDataCenter() {
        return dataCenter;
    }

    public String setDataCenter(String testData) {
        return dataCenter = testData; }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String setCommittedUsage(String testData) {
        return committedUsage = testData; }

    public String getNumberOfNodes() {
        return numberOfNodes;
    }

    public String setNumberOfNodes(String testData) {
        return numberOfNodes = testData; }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String setNumberOfGPUs(String testData) {
        return numberOfGPUs = testData; }

    public String getTypeGPU() {
        return typeGPU;
    }

    public String setTypeGPU(String testData) {
        return typeGPU = testData; }

    public String getLocalSSD() {
        return localSSD;
    }

    public String setLocalSSD(String testData) {
        return localSSD = testData; }


    @Override
    public String toString() {
        return "CalculatorForm{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", dataCenter='" + dataCenter + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", numberOfNodes='" + numberOfNodes + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", typeGPU='" + typeGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculatorForm)) return false;
        CalculatorForm that = (CalculatorForm) o;
        return Objects.equals(getNumberOfInstances(), that.getNumberOfInstances()) &&
                Objects.equals(getOperatingSystem(), that.getOperatingSystem()) &&
                Objects.equals(getMachineClass(), that.getMachineClass()) &&
                Objects.equals(getMachineType(), that.getMachineType()) &&
                Objects.equals(getDataCenter(), that.getDataCenter()) &&
                Objects.equals(getCommittedUsage(), that.getCommittedUsage()) &&
                Objects.equals(getNumberOfNodes(), that.getNumberOfNodes()) &&
                Objects.equals(getNumberOfGPUs(), that.getNumberOfGPUs()) &&
                Objects.equals(getTypeGPU(), that.getTypeGPU()) &&
                Objects.equals(getLocalSSD(), that.getLocalSSD());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getOperatingSystem(), getMachineClass(), getMachineType(), getDataCenter(), getCommittedUsage(), getNumberOfNodes(), getNumberOfGPUs(), getTypeGPU(), getLocalSSD());
    }

}
