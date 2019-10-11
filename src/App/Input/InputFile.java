package App.Input;

import App.ConsoleHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFile {
    private ArrayList<String> listPath = new ArrayList<>();

    public void startToReadParts(String parts) {
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(parts))) {
            while (reader.ready()) {
                String line = reader.readLine();
                listPath.add(index, line);
                index++;
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("IOException\n");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public ArrayList<String> getListPath() {
        return listPath;
    }
}
