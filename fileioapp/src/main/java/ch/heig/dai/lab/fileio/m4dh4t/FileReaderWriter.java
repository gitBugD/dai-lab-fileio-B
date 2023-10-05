package ch.heig.dai.lab.fileio.m4dh4t;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), encoding)
            );

            StringBuilder fileContent = new StringBuilder();
            String fileLine = in.readLine();
            while (fileLine != null) {
                fileContent.append(fileLine);

                fileLine = in.readLine();
            }

            in.close();
            return fileContent.toString();
        } catch (Exception e) {
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
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), encoding
            ));

            out.write(content);
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
