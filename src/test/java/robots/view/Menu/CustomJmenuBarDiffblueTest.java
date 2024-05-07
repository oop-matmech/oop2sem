package robots.view.Menu;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.Set;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuDragMouseListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.view.MainApplicationFrame;

class CustomJmenuBarDiffblueTest {
    /**
     * Method under test: {@link CustomJmenuBar#buildLookAndFeel()}
     */
    @Test
    void testBuildLookAndFeel() {
        // Arrange and Act
        JMenu actualBuildLookAndFeelResult = (new CustomJmenuBar()).buildLookAndFeel();

        // Assert
        Object expectedTreeLock = actualBuildLookAndFeelResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildLookAndFeelResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildLookAndFeel()}
     */
    @Test
    void testBuildLookAndFeel2() {
        // Arrange and Act
        JMenu actualBuildLookAndFeelResult = (new CustomJmenuBar(mock(MainApplicationFrame.class))).buildLookAndFeel();

        // Assert
        Object expectedTreeLock = actualBuildLookAndFeelResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildLookAndFeelResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test:
     * {@link CustomJmenuBar#generateSchemeOption(String, String)}
     */
    @Test
    void testGenerateSchemeOption() {
        // Arrange and Act
        JMenuItem actualGenerateSchemeOptionResult = (new CustomJmenuBar()).generateSchemeOption("Text", "Variant");

        // Assert
        MouseListener expectedMenuDragMouseListener = actualGenerateSchemeOptionResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualGenerateSchemeOptionResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test:
     * {@link CustomJmenuBar#generateSchemeOption(String, String)}
     */
    @Test
    void testGenerateSchemeOption2() {
        // Arrange and Act
        JMenuItem actualGenerateSchemeOptionResult = (new CustomJmenuBar(mock(MainApplicationFrame.class)))
                .generateSchemeOption("Text", "Variant");

        // Assert
        MouseListener expectedMenuDragMouseListener = actualGenerateSchemeOptionResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualGenerateSchemeOptionResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildTestMenu()}
     */
    @Test
    void testBuildTestMenu() {
        // Arrange and Act
        JMenu actualBuildTestMenuResult = (new CustomJmenuBar()).buildTestMenu();

        // Assert
        Object expectedTreeLock = actualBuildTestMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildTestMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildTestMenu()}
     */
    @Test
    void testBuildTestMenu2() {
        // Arrange and Act
        JMenu actualBuildTestMenuResult = (new CustomJmenuBar(mock(MainApplicationFrame.class))).buildTestMenu();

        // Assert
        Object expectedTreeLock = actualBuildTestMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildTestMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildTestMenuItem()}
     */
    @Test
    void testBuildTestMenuItem() {
        // Arrange and Act
        JMenuItem actualBuildTestMenuItemResult = (new CustomJmenuBar()).buildTestMenuItem();

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildTestMenuItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildTestMenuItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildTestMenuItem()}
     */
    @Test
    void testBuildTestMenuItem2() {
        // Arrange and Act
        JMenuItem actualBuildTestMenuItemResult = (new CustomJmenuBar(mock(MainApplicationFrame.class)))
                .buildTestMenuItem();

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildTestMenuItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildTestMenuItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildLanguageMenu()}
     */
    @Test
    void testBuildLanguageMenu() {
        // Arrange and Act
        JMenu actualBuildLanguageMenuResult = (new CustomJmenuBar()).buildLanguageMenu();

        // Assert
        Object expectedTreeLock = actualBuildLanguageMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildLanguageMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildLanguageMenu()}
     */
    @Test
    void testBuildLanguageMenu2() {
        // Arrange and Act
        JMenu actualBuildLanguageMenuResult = (new CustomJmenuBar(mock(MainApplicationFrame.class))).buildLanguageMenu();

        // Assert
        Object expectedTreeLock = actualBuildLanguageMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildLanguageMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildLanguageItem(String, Locale)}
     */
    @Test
    void testBuildLanguageItem() {
        // Arrange
        CustomJmenuBar customJmenuBar = new CustomJmenuBar();

        // Act
        JMenuItem actualBuildLanguageItemResult = customJmenuBar.buildLanguageItem("Dr", Locale.getDefault());

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildLanguageItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildLanguageItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildLanguageItem(String, Locale)}
     */
    @Test
    void testBuildLanguageItem2() {
        // Arrange
        CustomJmenuBar customJmenuBar = new CustomJmenuBar(mock(MainApplicationFrame.class));

        // Act
        JMenuItem actualBuildLanguageItemResult = customJmenuBar.buildLanguageItem("Dr", Locale.getDefault());

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildLanguageItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildLanguageItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildExitMenu()}
     */
    @Test
    void testBuildExitMenu() {
        // Arrange and Act
        JMenu actualBuildExitMenuResult = (new CustomJmenuBar()).buildExitMenu();

        // Assert
        Object expectedTreeLock = actualBuildExitMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildExitMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildExitMenu()}
     */
    @Test
    void testBuildExitMenu2() {
        // Arrange and Act
        JMenu actualBuildExitMenuResult = (new CustomJmenuBar(mock(MainApplicationFrame.class))).buildExitMenu();

        // Assert
        Object expectedTreeLock = actualBuildExitMenuResult.getTreeLock();
        assertSame(expectedTreeLock, actualBuildExitMenuResult.getPopupMenu().getTreeLock());
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildExitItem()}
     */
    @Test
    void testBuildExitItem() {
        // Arrange and Act
        JMenuItem actualBuildExitItemResult = (new CustomJmenuBar()).buildExitItem();

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildExitItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildExitItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#buildExitItem()}
     */
    @Test
    void testBuildExitItem2() {
        // Arrange and Act
        JMenuItem actualBuildExitItemResult = (new CustomJmenuBar(mock(MainApplicationFrame.class))).buildExitItem();

        // Assert
        MouseListener expectedMenuDragMouseListener = actualBuildExitItemResult.getMouseListeners()[0];
        assertSame(expectedMenuDragMouseListener, actualBuildExitItemResult.getMenuDragMouseListeners()[0]);
    }

    /**
     * Method under test: {@link CustomJmenuBar#generateMenuBar()}
     */
    @Test
    void testGenerateMenuBar() {
        // Arrange, Act and Assert
        Locale locale = (new CustomJmenuBar()).generateMenuBar().getLocale();
        Set<String> expectedUnicodeLocaleAttributes = locale.getUnicodeLocaleKeys();
        assertSame(expectedUnicodeLocaleAttributes, locale.getUnicodeLocaleAttributes());
    }

    /**
     * Method under test: {@link CustomJmenuBar#generateMenuBar()}
     */
    @Test
    void testGenerateMenuBar2() {
        // Arrange, Act and Assert
        Locale locale = (new CustomJmenuBar(mock(MainApplicationFrame.class))).generateMenuBar().getLocale();
        Set<String> expectedUnicodeLocaleAttributes = locale.getUnicodeLocaleKeys();
        assertSame(expectedUnicodeLocaleAttributes, locale.getUnicodeLocaleAttributes());
    }

    /**
     * Method under test: {@link CustomJmenuBar#CustomJmenuBar()}
     */
    @Test
    void testNewCustomJmenuBar() {
        // Arrange and Act
        CustomJmenuBar actualCustomJmenuBar = new CustomJmenuBar();

        // Assert
        Object expectedTreeLock = actualCustomJmenuBar.buildLanguageMenu().getTreeLock();
        assertSame(expectedTreeLock, actualCustomJmenuBar.buildExitMenu().getTreeLock());
    }

    /**
     * Method under test:
     * {@link CustomJmenuBar#CustomJmenuBar(MainApplicationFrame)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewCustomJmenuBar2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        MainApplicationFrame screen_ = null;

        // Act
        CustomJmenuBar actualCustomJmenuBar = new CustomJmenuBar(screen_);

        // Assert
        // TODO: Add assertions on result
    }
}
