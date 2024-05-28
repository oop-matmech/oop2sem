package robots.model.helpz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.*;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileManageTest {

    @BeforeEach
    void prepareForTest(){
        profileManager.changeProfileSaveDirectory("test");
        profileManager.setDefaultProfile();
    }

    @Test
    void writeToFileTest() throws FileNotFoundException {
        profileManager.WriteToFile();
        File test = new File(profileManager.filePath);
        try(BufferedReader br = new BufferedReader(new FileReader(test))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null){
                i += 1;
            }
            assertEquals(i, 6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void restoreMyProfileTest(){
        try {
            File test = new File(profileManager.filePath);
            PrintWriter pw = new PrintWriter(test);
            pw.println("en_US");

            StringBuilder a = new StringBuilder();
            a.append("15");
            a.append(" ");
            a.append("20");
            pw.println("false");
            pw.println(a.toString());
            pw.println("amogos~sus");

            a = new StringBuilder();
            a.append("100");
            a.append(" ");
            a.append("200");
            pw.println(true);
            pw.println(a.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        profileManager.restoreMyProfile();
        assertEquals(profileManager.getCurrentLocale(), Locale.US);
        assertEquals(profileManager.getLogWindowPos(), new Point(15, 20));
        assertFalse(profileManager.isLogWindowIsClosed());
        assertEquals(profileManager.getCurrentLog(), "amogos~sus");
        assertTrue(profileManager.isGameWindowIsClosed());
        assertEquals(profileManager.getGameWindowPos(), new Point(100, 200));
    }

    @Test
    void setDefaultProfileTest() {
        assertEquals(profileManager.getCurrentLocale(), Locale.getDefault());
        assertEquals(profileManager.getLogWindowPos(), new Point(10, 10));
        assertFalse(profileManager.isLogWindowIsClosed());
        assertEquals(profileManager.getCurrentLog(), "");
        assertFalse(profileManager.isGameWindowIsClosed());
        assertEquals(profileManager.getGameWindowPos(), new Point(10, 10));
    }

    @Test
    void setAndGetTestCurrentProfile() {
        profileManager.setCurrentProfile("1");
        assertEquals(profileManager.getCurrentProfile(), "1");
        assertEquals(profileManager.profileName, "profile1.txt");
        assertEquals(profileManager.filePath, profileManager.homePath + File.separator + profileManager.saveFolder + File.separator + profileManager.profileName);
    }

    @Test
    void setAndGetTestLocale() {
        profileManager.setCurrentLocale(new Locale.Builder().setLanguage("en").setRegion("US").build());
        assertEquals(profileManager.getCurrentLocale(), Locale.US);
    }

    @Test
    void setAndGetTestIsLogWindowClosed() {
        profileManager.setLogWindowIsClosed(false);
        assertFalse(profileManager.isLogWindowIsClosed());
        profileManager.setLogWindowIsClosed(true);
        assertTrue(profileManager.isLogWindowIsClosed());
    }

    @Test
    void setAndGetTestIsGameWindowClosed() {
        profileManager.setGameWindowIsClosed(false);
        assertFalse(profileManager.isGameWindowIsClosed());
        profileManager.setGameWindowIsClosed(true);
        assertTrue(profileManager.isGameWindowIsClosed());
    }

    @Test
    void setAndGetTestLogWindowPos() {
        profileManager.setLogWindowPos(new Point(40, 30));
        assertEquals(profileManager.getLogWindowPos(), new Point(40, 30));
    }

    @Test
    void setAndGetTestGameWindowPos(){
        profileManager.setGameWindowPos(new Point(40, 30));
        assertEquals(profileManager.getGameWindowPos(), new Point(40, 30));
    }
}
