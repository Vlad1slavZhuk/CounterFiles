package App.OutputFile;

import App.CounterFile.ThreadCounterFile;

import java.io.*;

public class OutputFile {
    private static String outputFile;

    public static void setOutputFile(String outputFile) {
        int index = outputFile.lastIndexOf('.');
        String extension = outputFile.substring(index, outputFile.length());
        if (!extension.equals(".csv"))
            outputFile = outputFile.replace(extension, ".csv");

        OutputFile.outputFile = outputFile;
    }

    public static void writeDataToCSV(ThreadCounterFile counterFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(counterFile.getPath() + ";" + counterFile.getCounterFile());
            stringBuilder.append("\n");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
