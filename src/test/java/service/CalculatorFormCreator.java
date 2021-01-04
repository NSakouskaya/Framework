package service;

import model.CalculatorForm;

public class CalculatorFormCreator {

    public static final String numberOfInstances = "4";
    public static final String operatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    public static final String machineClass = "Regular";
    public static final String machineType = "n1-standard-8 (vCPUs: 8, RAM: 32 GB)";
    public static final String dataCenter = "Frankfurt (europe-west3)";
    public static final String committedUsage = "1 Year";
    public static final String numberOfNodes = "4";
    public static final String numberOfGPUs = "4";
    public static final String typeGPU = "NVIDIA Tesla V100";
    public static final String localSSD = "2x375 Gb";

     public static CalculatorForm withValuesFromProperty() {
         return new CalculatorForm(numberOfInstances, operatingSystem, machineClass, machineType, dataCenter, committedUsage, numberOfNodes, numberOfGPUs, typeGPU, localSSD);
     }

    public static CalculatorForm withEmptyNumberOfInstances() {
         return new CalculatorForm ("", operatingSystem, machineClass, machineType, dataCenter, committedUsage, numberOfNodes, numberOfGPUs, typeGPU, localSSD);
    }

    public static CalculatorForm withEmptyNumberOfNodes() {
        return new CalculatorForm (numberOfInstances, operatingSystem, machineClass, machineType, dataCenter, committedUsage, "", numberOfGPUs, typeGPU, localSSD);
    }

}
