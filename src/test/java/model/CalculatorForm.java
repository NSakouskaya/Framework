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

    public CalculatorForm(String numberOfInstances, String operatingSystem, String machineClass, String machineType, String dataCenter, String committedUsage, String numberOfNodes, String numberOfGPUs, String typeGPU, String localSSD) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.dataCenter = dataCenter;
        this.committedUsage = committedUsage;
        this.numberOfNodes = numberOfNodes;
        this.numberOfGPUs = numberOfGPUs;
        this.typeGPU = typeGPU;
        this.localSSD = localSSD;
    }

    public CalculatorForm() {

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(String numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

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
