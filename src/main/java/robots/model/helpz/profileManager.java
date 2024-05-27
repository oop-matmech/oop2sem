package robots.model.helpz;

import java.awt.*;
import java.io.*;
import java.util.Locale;

public class profileManager {
    private static String currentProfile = "";
    private static Locale currentLocale = Locale.getDefault();

    private static boolean logWindowIsClosed = false;
    private static boolean choosingProfileState = true;
    private static int logWindowPosX = 10;
    private static int logWindowPosY = 10;
    private static String currentLog = "";

    private static int gameWindowPosX = 310;
    private static int gameWindowPosY = 10;
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

    public static boolean CheckOnProfileFile(){
        return profileFile.exists() && !profileFile.isDirectory();
    }

    public static void WriteToFile() {
        if (!CheckOnProfileFile()){
            try {
                CreateFolder();
                profileFile.createNewFile();
            } catch (Exception e){}
        }
        if (CheckOnProfileFile()) {
            try {
                CreateFolder();
                PrintWriter pw = new PrintWriter(profileFile);
                pw.println(currentLocale);

                StringBuilder a = new StringBuilder();
                a.append(logWindowPosX);
                a.append(" ");
                a.append(logWindowPosY);
                pw.println(logWindowIsClosed);
                pw.println(a.toString());
                pw.println(currentLog);

                a = new StringBuilder();
                a.append(gameWindowPosX);
                a.append(" ");
                a.append(gameWindowPosY);
                pw.println(gameWindowIsClosed);
                pw.println(a.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
        return new Point(logWindowPosX, logWindowPosY);
    }

    public static void setLogWindowPos(Point logWindowPos) {
        profileManager.logWindowPosX = logWindowPos.x;
        profileManager.logWindowPosY = logWindowPos.y;
    }

    public static String getCurrentProfile() {
        return currentProfile;
    }
    public static void setCurrentProfile(String currentProfile) {
        profileManager.currentProfile = currentProfile;
        profileName = "profile" + currentProfile + ".txt";
        filePath = homePath + File.separator + saveFolder + File.separator + profileName;
        profileFile = new File(filePath);
        LoadSave.changeProfile(currentProfile);
    }
    public static String getCurrentLog() {
        return currentLog;
    }

    public static void setCurrentLog(String currentLog) {
        profileManager.currentLog = makeLogString(currentLog);
    }

    public static Point getGameWindowPos() {
        return new Point(gameWindowPosX, gameWindowPosY);
    }

    public static void setGameWindowPos(Point gameWindowPos) {
        profileManager.gameWindowPosX = gameWindowPos.x;
        profileManager.gameWindowPosY = gameWindowPos.y;
    }

    public static boolean isGameWindowIsClosed() {
        return gameWindowIsClosed;
    }

    public static void setGameWindowIsClosed(boolean gameWindowIsClosed) {
        profileManager.gameWindowIsClosed = gameWindowIsClosed;
    }

    public static String makeLogString(String log){
        StringBuilder a = new StringBuilder(log);
        for (int i = 0; i < log.length(); i++){
            if (a.charAt(i) == '\n') {
                a.setCharAt(i, '~');
            }
        }
        return a.toString();
    }

    public static void endProfileChoosingSession(){
        choosingProfileState = false;
    }

    public static boolean isNotChoosingProfileState(){
        return !choosingProfileState;
    }

    public static void restoreMyProfile(){
        try(BufferedReader br = new BufferedReader(new FileReader(profileFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            sb.append(line);
            setCurrentLocale(new Locale.Builder().setLanguage(sb.substring(0, sb.indexOf("_"))).setRegion(sb.substring(sb.indexOf("_") + 1)).build());

            line = br.readLine();
            setLogWindowIsClosed(line.equals("true"));

            line = br.readLine();
            sb.delete(0, sb.length());
            sb.append(line);
            int pos_x = Integer.parseInt(sb.substring(0, sb.indexOf(" ")));
            int pos_y = Integer.parseInt(sb.substring(sb.indexOf(" ") + 1));
            setLogWindowPos(new Point(pos_x, pos_y));

            line = br.readLine();
            sb.delete(0, sb.length());
            sb.append(line);
            setCurrentLog(sb.toString());

            line = br.readLine();
            setGameWindowIsClosed(line.equals("true"));

            line = br.readLine();
            sb.delete(0, sb.length());
            sb.append(line);
            pos_x = Integer.parseInt(sb.substring(0, sb.indexOf(" ")));
            pos_y = Integer.parseInt(sb.substring(sb.indexOf(" ") + 1));
            setGameWindowPos(new Point(pos_x, pos_y));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDefaultProfile() {
        setCurrentLocale(Locale.getDefault());
        setLogWindowIsClosed(false);
        setLogWindowPos(new Point(10, 10));
        setCurrentLog("");
        setGameWindowIsClosed(false);
        setGameWindowPos(new Point(10, 10));
    }

    public static void deleteFile(String profileName_num){
        String profileName_del = "profile" + profileName_num + ".txt";
        String filePath_del = homePath + File.separator + saveFolder + File.separator + profileName_del;
        File profileFile_del = new File(filePath_del);

        if (profileFile_del.exists()) {
            profileFile_del.delete();
        }
    }
}
