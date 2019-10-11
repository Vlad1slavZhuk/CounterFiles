package App;

import App.CounterFile.Controller;
import App.CounterFile.ThreadCounterFile;
import org.jnativehook.GlobalScreen;

import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleHelper {
    public static void showResult(ThreadCounterFile counterFile) {
        Formatter formatter = new Formatter();
        if (!Controller.isInterrupt()) {
            formatter.format("|%-5s| %-30s| %-35s| %-10s< |", counterFile.getNumber(),
                    counterFile.getCounterFile() == -1 ? "This is the path to the file." : counterFile.getCounterFile(),
                    counterFile.getPath(), "READY");
        } else
            formatter.format("|%-5s| %-30s| %-35s| %-10s! |", counterFile.getNumber(),
                    counterFile.getCounterFile() == -1 ? "This is the path to the file." : counterFile.getCounterFile(),
                    counterFile.getPath(), "CANCELLED");

        writeMessage(formatter.toString());
    }

    public static void homeText() {
        Formatter formatter = new Formatter();
        writeMessage("Press \"ESC\" to cancel or Press \"Q\" to exit.");
        writeMessage("__________________________________________________________________________________________");
        formatter.format("|%-5s| %-30s| %-35s| %-11s |", "#", "Number of files", "Location", "STATUS");
        writeMessage(formatter.toString());
        writeMessage("------------------------------------------------------------------------------------------");
        formatter.close();
    }

    public static void writeMessage(String text) {
        System.out.println(text);
    }

    public static void disableLogger() {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }
}
