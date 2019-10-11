package App;

import App.CounterFile.Controller;
import App.Input.InputFile;
import App.OutputFile.OutputFile;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("You wrote the args = " + Arrays.toString(args));
        if (args.length != 2)
            ConsoleHelper.writeMessage("Few arguments or many arguments! Try again!");

        else {
            String input = args[0];
            String output = args[1];

            OutputFile.setOutputFile(output);
            // Disable logging Jnativehook--------------------------------
            ConsoleHelper.disableLogger();

            // Start ListenerKey------------------------------------------
            Thread listenerKey = new Thread(new ListenerKey());
            listenerKey.start();

            //-------------------------------------------------------------
            InputFile inputFile = new InputFile();
            inputFile.startToReadParts(input);
            if (inputFile.getListPath().size() != 0) {
                ConsoleHelper.writeMessage(inputFile.getListPath() + "");
                ConsoleHelper.writeMessage("Start to search!");
                ConsoleHelper.homeText();
                Controller controller = new Controller(inputFile.getListPath());
                controller.createThreadsAndStartToSearch();
            } else {
                ConsoleHelper.writeMessage("There are no path lines in the input file");
            }
        }
    }
}
