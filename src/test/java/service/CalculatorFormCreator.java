package service;

import model.CalculatorForm;

public class CalculatorFormCreator {

    public static final String numberOfInstances = "testdata.number.of.instances";
    public static final String operatingSystem = "testdata.operating.system";
    public static final String machineClass = "testdata.machine.class";
    public static final String machineType = "testdata.machine.type";
    public static final String dataCenter = "testdata.data.center";
    public static final String committedUsage = "testdata.committed.usage";
    public static final String numberOfNodes = "testdata.number.of.nodes";
    public static final String numberOfGPUs = "testdata.number.of.gPUs";
    public static final String typeGPU = "testdata.type.gPU";
    public static final String localSSD = "testdata.local.sSD";


    public static CalculatorForm withDataFromProperty(){
        CalculatorForm form = new CalculatorForm();
                form.setNumberOfInstances(TestDataReader.getTestData(numberOfInstances));
                form.setOperatingSystem(TestDataReader.getTestData(operatingSystem));
                form.setMachineClass(TestDataReader.getTestData(machineClass));
                form.setMachineType(TestDataReader.getTestData(machineType));
                form.setDataCenter(TestDataReader.getTestData(dataCenter));
                form.setCommittedUsage(TestDataReader.getTestData(committedUsage));
                form.setNumberOfNodes(TestDataReader.getTestData(numberOfNodes));
                form.setNumberOfGPUs(TestDataReader.getTestData(numberOfGPUs));
                form.setTypeGPU(TestDataReader.getTestData(typeGPU));
                form.setLocalSSD(TestDataReader.getTestData(localSSD));
        return form;
    }

//    public static void withEmptyNumberOfInstances() {
//        CalculatorForm form = new CalculatorForm();
//                 form.setNumberOfInstances("");
//                 form.setOperatingSystem(TestDataReader.getTestData(operatingSystem));
//                 form.setMachineClass(TestDataReader.getTestData(machineClass));
//                 form.setMachineType(TestDataReader.getTestData(machineType));
//                 form.setDataCenter(TestDataReader.getTestData(dataCenter));
//                 form.setCommittedUsage(TestDataReader.getTestData(committedUsage));
//                 form.setNumberOfNodes(TestDataReader.getTestData(numberOfNodes));
//                 form.setNumberOfGPUs(TestDataReader.getTestData(numberOfGPUs));
//                 form.setTypeGPU(TestDataReader.getTestData(typeGPU));
//                 form.setLocalSSD(TestDataReader.getTestData(localSSD));
//    }
//
//    public static void withEmptyNumberOfNodes() {
//        CalculatorForm form = new CalculatorForm();
//        form.setNumberOfInstances(TestDataReader.getTestData(numberOfInstances));
//                form.setOperatingSystem(TestDataReader.getTestData(operatingSystem));
//                form.setMachineClass(TestDataReader.getTestData(machineClass));
//                form.setMachineType(TestDataReader.getTestData(machineType));
//                form.setDataCenter(TestDataReader.getTestData(dataCenter));
//                form.setCommittedUsage(TestDataReader.getTestData(committedUsage));
//                form.setNumberOfNodes("");
//                form.setNumberOfGPUs(TestDataReader.getTestData(numberOfGPUs));
//                form.setTypeGPU(TestDataReader.getTestData(typeGPU));
//                form.setLocalSSD(TestDataReader.getTestData(localSSD));
//    }

}
