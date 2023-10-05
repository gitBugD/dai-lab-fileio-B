package ch.heig.dai.lab.fileio.m4dh4t;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class EncodingSelector {

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {
        if (file == null) {
            return null;
        }

        String fileName = file.getName();
        // Use a hashmap
        HashMap<String, Charset> map = new HashMap<>();
        map.put(".utf8", StandardCharsets.UTF_8);
        map.put(".txt", StandardCharsets.US_ASCII);
        map.put(".utf16be", StandardCharsets.UTF_16BE);
        map.put(".utf16le", StandardCharsets.UTF_16LE);

        // Search if file possess an extension
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return null;
        }

        // Get the extension
        String extension = fileName.substring(index);
        return map.get(extension);
    }
}