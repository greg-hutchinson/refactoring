package ca.attractors.soduko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;


// What's wrong with this test?
public class SodukoBoardBuilderTest {
    @BeforeEach
    void initialize() {
    }

    @Test
    void buildFile() {
        File file = getTestFile("valid-soduko.csv");
        SodukoBoardBuilder sodukoBoardBuilder = new SodukoBoardBuilder();
        SodukoBoard board = sodukoBoardBuilder.build(file);
        assertTrue(board.isValid());
    }

    public static File getTestFile(String fileName) {
        URL resource = SodukoBoardBuilderTest.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            try {
                return new File(resource.toURI());
            }
            catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
