package robots.model.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.management.ServiceNotFoundException;
import javax.management.loading.MLet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EncodingResolverDiffblueTest {
    /**
     * Method under test:
     * {@link EncodingResolver#newBundle(String, Locale, String, ClassLoader, boolean)}
     */
    @Test
    void testNewBundle() throws IOException, IllegalAccessException, InstantiationException {
        // Arrange
        EncodingResolver encodingResolver = new EncodingResolver();
        Locale locale = Locale.getDefault();

        // Act and Assert
        assertNull(encodingResolver.newBundle("Base Name", locale, "Format", new MLet(), true));
    }

    /**
     * Method under test:
     * {@link EncodingResolver#newBundle(String, Locale, String, ClassLoader, boolean)}
     */
    @Test
    void testNewBundle2() throws IOException, IllegalAccessException, InstantiationException {
        // Arrange
        EncodingResolver encodingResolver = new EncodingResolver();
        Locale locale = Locale.getDefault();

        // Act and Assert
        assertNull(encodingResolver.newBundle("foo", locale, "foo", new MLet(), false));
    }

    /**
     * Method under test:
     * {@link EncodingResolver#newBundle(String, Locale, String, ClassLoader, boolean)}
     */
    @Test
    void testNewBundle3() throws IOException, IllegalAccessException, InstantiationException {
        // Arrange
        EncodingResolver encodingResolver = new EncodingResolver();
        Locale locale = Locale.getDefault();
        URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
        when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(null);

        // Act
        ResourceBundle actualNewBundleResult = encodingResolver.newBundle("Base Name", locale, "Format",
                new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
                        new MLet(), urlStreamHandlerFactory),
                true);

        // Assert
        verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
        assertNull(actualNewBundleResult);
    }

    /**
     * Method under test:
     * {@link EncodingResolver#newBundle(String, Locale, String, ClassLoader, boolean)}
     */
    @Test
    void testNewBundle4() throws IOException, IllegalAccessException, InstantiationException, ServiceNotFoundException {
        // Arrange
        EncodingResolver encodingResolver = new EncodingResolver();
        Locale locale = Locale.getDefault();

        MLet mLet = new MLet();
        mLet.addURL("https://example.org/example");
        URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
        when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(null);

        // Act
        ResourceBundle actualNewBundleResult = encodingResolver.newBundle("Base Name", locale, "Format",
                new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, mLet,
                        urlStreamHandlerFactory),
                true);

        // Assert
        verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
        assertNull(actualNewBundleResult);
    }
}
