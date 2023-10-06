package ch.heig.dai.lab.fileio.dominiksaul;

import java.io.File;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     *
     * @param file     the file to read.
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) throws IOException {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.

        var reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), encoding));

        String text = reader.readLine();

        reader.close();

        return text;
    }

    /**
     * Write the content to a file with a given encoding.
     *
     * @param file     the file to write to
     * @param content  the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) throws IOException {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.

        var writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), encoding));

        writer.write(content);

        writer.flush();
        writer.close();

        return false;
    }
}
