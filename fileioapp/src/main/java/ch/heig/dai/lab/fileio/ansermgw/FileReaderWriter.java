package ch.heig.dai.lab.fileio.ansermgw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

public class FileReaderWriter {
    private final static String LINE_SEPARATOR = "\n";

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read.
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file, encoding))) {
            return reader
                    .lines()
                    .collect(Collectors.joining(LINE_SEPARATOR));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Write the content to a file with a given encoding.
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        try (FileWriter writer = new FileWriter(file, encoding)) {
            writer.write(content);
            writer.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
