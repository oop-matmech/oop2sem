package robots.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LogWindowSourceDiffblueTest {
    /**
     * Method under test:
     * {@link LogWindowSource#registerListener(LogChangeListener)}
     */
    @Test
    void testRegisterListener() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        Logger.getDefaultLogSource().registerListener(mock(LogChangeListener.class));
    }

    /**
     * Method under test:
     * {@link LogWindowSource#registerListener(LogChangeListener)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterListener2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.linkLast(ConcurrentLinkedDeque.java:347)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.offerLast(ConcurrentLinkedDeque.java:865)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.offer(ConcurrentLinkedDeque.java:979)
        //       at robots.model.log.LogWindowSource.registerListener(LogWindowSource.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        Logger.getDefaultLogSource().registerListener(null);
    }

    /**
     * Method under test:
     * {@link LogWindowSource#unregisterListener(LogChangeListener)}
     */
    @Test
    void testUnregisterListener() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        Logger.getDefaultLogSource().unregisterListener(mock(LogChangeListener.class));
    }

    /**
     * Method under test:
     * {@link LogWindowSource#unregisterListener(LogChangeListener)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnregisterListener2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.removeFirstOccurrence(ConcurrentLinkedDeque.java:1030)
        //       at java.base/java.util.concurrent.ConcurrentLinkedDeque.remove(ConcurrentLinkedDeque.java:1142)
        //       at robots.model.log.LogWindowSource.unregisterListener(LogWindowSource.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        Logger.getDefaultLogSource().unregisterListener(null);
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs2() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Trace, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs3() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Info, "42");
        defaultLogSource.append(LogLevel.Debug, "robots.model.log.LogChangeListener[]");
        defaultLogSource.append(LogLevel.Trace, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs4() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Info, "42");
        defaultLogSource.append(null, "robots.model.log.LogChangeListener[]");
        defaultLogSource.append(LogLevel.Trace, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs5() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Info, "42");
        defaultLogSource.append(LogLevel.Debug, "");
        defaultLogSource.append(LogLevel.Trace, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs6() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.append(LogLevel.Info, "42");
        defaultLogSource.append(null, "robots.model.log.LogChangeListener[]");
        defaultLogSource.append(LogLevel.Info, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#triggerLogs()}
     */
    @Test
    void testTriggerLogs7() {
        // Arrange
        LogChangeListener listener = mock(LogChangeListener.class);
        doNothing().when(listener).onLogChanged();
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        defaultLogSource.unregisterListener(mock(LogChangeListener.class));
        defaultLogSource.append(LogLevel.Warning, "42");
        defaultLogSource.append(LogLevel.Debug, "robots.model.log.LogChangeListener[]");
        defaultLogSource.append(LogLevel.Trace, "Str Message");
        defaultLogSource.registerListener(listener);

        // Act
        defaultLogSource.triggerLogs();

        // Assert
        verify(listener).onLogChanged();
    }

    /**
     * Method under test: {@link LogWindowSource#size()}
     */
    @Test
    void testSize2() {
        // Arrange
        LogWindowSource defaultLogSource = Logger.getDefaultLogSource();
        var prevSize = defaultLogSource.size();
        defaultLogSource.append(LogLevel.Warning, "Str Message");

        // Act and Assert
        assertEquals(prevSize + 1, defaultLogSource.size());
    }

    /**
     * Method under test: {@link LogWindowSource#LogWindowSource(int)}
     */
    @Test
    void testNewLogWindowSource() {
        // Arrange and Act
        LogWindowSource actualLogWindowSource = new LogWindowSource(3);

        // Assert
        assertEquals(0, actualLogWindowSource.mCounter.get());
        assertEquals(0, actualLogWindowSource.size());
    }
}
