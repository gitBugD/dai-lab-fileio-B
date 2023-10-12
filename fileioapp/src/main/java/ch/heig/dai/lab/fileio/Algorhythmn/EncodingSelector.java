package ch.heig.dai.lab.fileio.Algorhythmn;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
        String[] supportedExtension = {".utf8", ".txt", ".utf16be", ".utf16le"};
        Charset[] supportedEncoding = {StandardCharsets.UTF_8, StandardCharsets.US_ASCII,
                StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE};
        String filename = file.getName();
        int indexOfPoint = filename.lastIndexOf(".");
        for (int i = 0; i < supportedExtension.length && indexOfPoint != -1; i++) {
            String extension = filename.substring(indexOfPoint);
            if (extension.contains(supportedExtension[i])) {
                return supportedEncoding[i];
            }
        }
        return null;
    }
}

