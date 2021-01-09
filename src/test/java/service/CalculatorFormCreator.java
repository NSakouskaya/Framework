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
        return new CalculatorForm(TestDataReader.getTestData(numberOfInstances),
                TestDataReader.getTestData(operatingSystem),
                TestDataReader.getTestData(machineClass),
                TestDataReader.getTestData(machineType),
                TestDataReader.getTestData(dataCenter),
                TestDataReader.getTestData(committedUsage),
                TestDataReader.getTestData(numberOfNodes),
                TestDataReader.getTestData(numberOfGPUs),
                TestDataReader.getTestData(typeGPU),
                TestDataReader.getTestData(localSSD));
    }

    public static CalculatorForm withEmptyNumberOfInstances() {
         return new CalculatorForm ("",
                 TestDataReader.getTestData(operatingSystem),
                 TestDataReader.getTestData(machineClass),
                 TestDataReader.getTestData(machineType),
                 TestDataReader.getTestData(dataCenter),
                 TestDataReader.getTestData(committedUsage),
                 TestDataReader.getTestData(numberOfNodes),
                 TestDataReader.getTestData(numberOfGPUs),
                 TestDataReader.getTestData(typeGPU),
                 TestDataReader.getTestData(localSSD));
             }

    public static CalculatorForm withEmptyNumberOfNodes() {
        return new CalculatorForm (TestDataReader.getTestData(numberOfInstances),
                TestDataReader.getTestData(operatingSystem),
                TestDataReader.getTestData(machineClass),
                TestDataReader.getTestData(machineType),
                TestDataReader.getTestData(dataCenter),
                TestDataReader.getTestData(committedUsage),
                TestDataReader.getTestData(""),
                TestDataReader.getTestData(numberOfGPUs),
                TestDataReader.getTestData(typeGPU),
                TestDataReader.getTestData(localSSD));
    }

}
