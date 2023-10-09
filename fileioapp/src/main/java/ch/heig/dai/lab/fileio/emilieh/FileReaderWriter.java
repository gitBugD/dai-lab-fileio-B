package ch.heig.dai.lab.fileio.emilieh;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) throws IOException {
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        var reader = new FileReader(file, encoding);
        StringBuilder s = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
           s.append((char) c);
        }
        reader.close();

        return s.toString();
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) throws IOException {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        var reader = new BufferedReader(new StringReader(content));
        var writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }
        writer.flush();
        writer.close();
        reader.close();

        return false;
    }
}
