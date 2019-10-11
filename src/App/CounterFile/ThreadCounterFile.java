package App.CounterFile;

import App.ConsoleHelper;
import App.OutputFile.OutputFile;

import java.io.File;

public class ThreadCounterFile implements Runnable {
    private int number;
    private String path;
    private int counterFile;


    public ThreadCounterFile(final int number, final String path) {
        this.number = number;
        this.path = path;
    }

    @Override
    public void run() {
        startToCounterFiles(path);
        ConsoleHelper.showResult(this);
        OutputFile.writeDataToCSV(this);
    }

    public int getNumber() {
        return number;
    }

    public String getPath() {
        return path;
    }

    public int getCounterFile() {
        return counterFile;
    }

    private Integer startToCounterFiles(final String path) {
        File file = new File(path);
        if (file.isFile()) {
            counterFile = -1;
            return counterFile;
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File pathFile : files) {
                if (Controller.isInterrupt()) {
                    break;
                }

                if (pathFile.isFile())
                    counterFile++;

                if (pathFile.isDirectory())
                    startToCounterFiles(pathFile.getPath());
            }
        }
        return counterFile;
    }
}
