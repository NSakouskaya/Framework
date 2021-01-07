package service;
import model.CalculatorForm;

public class CalculatorFormCreator {

    private static final String numberOfInstances = "4";
    private static final String operatingSystem = "free";
    private static final String machineClass = "regular";
    private static final String machineType = "CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8";
    private static final String dataCenter = "europe-west3";
    private static final String committedUsage = "1";
    private static final String numberOfNodes = "4";
    private static final String numberOfGPUs = "4";
    private static final String typeGPU = "NVIDIA_TESLA_T4";
    private static final String localSSD = "24";

     public static CalculatorForm withValuesFromProperty() {
         CalculatorForm calculator = new CalculatorForm();
         calculator.setNumberOfInstances(numberOfInstances);
         calculator.setOperatingSystem(operatingSystem);
         calculator.setMachineClass(machineClass);
         calculator.setMachineType(machineType);
         calculator.setDataCenter(dataCenter);
         calculator.setCommittedUsage(committedUsage);
         calculator.setNumberOfNodes(numberOfNodes);
         calculator.setNumberOfGPUs(numberOfGPUs);
         calculator.setTypeGPU(typeGPU);
         calculator.setLocalSSD(localSSD);

         return calculator;
     }

    public static CalculatorForm withEmptyNumberOfInstances() {
         return new CalculatorForm ("", operatingSystem, machineClass, machineType, dataCenter, committedUsage, numberOfNodes, numberOfGPUs, typeGPU, localSSD);
    }

    public static CalculatorForm withEmptyNumberOfNodes() {
        return new CalculatorForm (numberOfInstances, operatingSystem, machineClass, machineType, dataCenter, committedUsage, "", numberOfGPUs, typeGPU, localSSD);
    }

}
