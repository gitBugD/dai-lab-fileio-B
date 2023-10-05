package ch.heig.dai.lab.fileio.mystere;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class EncodingSelector {

    /**
     * List of all extension available for this application.
     */
    private final Map<String, Charset> extension;

    public EncodingSelector() {
        extension = new HashMap<>();
        extension.put("utf8", StandardCharsets.UTF_8);
        extension.put("txt", StandardCharsets.US_ASCII);
        extension.put("utf16be", StandardCharsets.UTF_16BE);
        extension.put("utf16le", StandardCharsets.UTF_16LE);
    }

    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     * - .utf8:    UTF-8
     * - .txt:     US-ASCII
     * - .utf16be: UTF-16BE
     * - .utf16le: UTF-16LE
     *
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {
        return extension.get(file.getName().substring(file.getName().lastIndexOf(".") + 1));
    }
}
