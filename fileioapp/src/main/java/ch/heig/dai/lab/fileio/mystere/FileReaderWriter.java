package ch.heig.dai.lab.fileio.mystere;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     *
     * @param file     the file to read.
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }

        return sb.toString();
    }

    /**
     * Write the content to a file with a given encoding.
     *
     * @param file     the file to write to
     * @param content  the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))) {
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }

        return true;
    }
}
