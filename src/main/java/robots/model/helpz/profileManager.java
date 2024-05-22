package robots.model.helpz;

import robots.model.objects.PathPoint;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class profileManager {
    private static Locale currentLocale = Locale.getDefault();

    private static boolean logWindowIsClosed = false;
    private static Point logWindowPos;
    private static String currentLog = "";

    private static Point gameWindowPos;
    private static boolean gameWindowIsClosed = false;

    public static String homePath = System.getProperty("user.home");
    public static String saveFolder = "GAME";
    public static String profileName = "profile.txt";
    public static String filePath = homePath + File.separator + saveFolder + File.separator + profileName;
    private static File profileFile = new File(filePath);

    public static void CreateFolder() {
        File folder = new File(homePath + File.separator + saveFolder);
        if (!folder.exists())
            folder.mkdir();
    }
    public static void WriteToFile() {
        try {
            PrintWriter pw = new PrintWriter(profileFile);
            pw.println(currentLocale);

            pw.println(logWindowIsClosed);
            pw.println(logWindowPos);
            pw.println(currentLog);

            pw.println(gameWindowIsClosed);
            pw.println(gameWindowPos);

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(Locale currentLocale) {
        profileManager.currentLocale = currentLocale;
    }

    public static boolean isLogWindowIsClosed() {
        return logWindowIsClosed;
    }

    public static void setLogWindowIsClosed(boolean logWindowIsClosed) {
        profileManager.logWindowIsClosed = logWindowIsClosed;
    }

    public static Point getLogWindowPos() {
        return logWindowPos;
    }

    public static void setLogWindowPos(Point logWindowPos) {
        profileManager.logWindowPos = logWindowPos;
    }

    public static String getCurrentLog() {
        return currentLog;
    }

    public static void setCurrentLog(String currentLog) {
        profileManager.currentLog = currentLog;
    }

    public static Point getGameWindowPos() {
        return gameWindowPos;
    }

    public static void setGameWindowPos(Point gameWindowPos) {
        profileManager.gameWindowPos = gameWindowPos;
    }

    public static boolean isGameWindowIsClosed() {
        return gameWindowIsClosed;
    }

    public static void setGameWindowIsClosed(boolean gameWindowIsClosed) {
        profileManager.gameWindowIsClosed = gameWindowIsClosed;
    }
}
