import jdk.internal.module.ModuleInfoExtender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    private Path tempFile;
    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("test", ".txt");
    }
    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }
    @Test
    public void testWriteAndRead() {
        List<String> data = List.of("line 1", "line 2");
        FileHandler.writeToFile(tempFile.toString(), data);
        assertTrue(Files.exists(tempFile));
        List<String> fileContent = FileHandler.readFromFile(tempFile.toString());
        assertEquals(data, fileContent);
    }
}
