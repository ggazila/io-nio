package task4.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLocator {
    private static final String DEFAULT_LOCATION = "persons.txt";
    private static final String URL_LOCATION = "https://docs.google.com/uc?export=download&id=10TOlddqQENxeDjvzDV4tGdYCcuSNTerb";

    private static String handleFilePath(String location) {
        Path of = Path.of(location);
        if (Files.notExists(of)) {
            System.out.println(
                    "File doesn't exist. Download from GDrive in the root of this project");
            downloadFile();
            return DEFAULT_LOCATION;
        } else {
            return location;
        }
    }

    private static void downloadFile() {
        try {
            URL url = new URL(URL_LOCATION);
            ReadableByteChannel channel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(
                    DEFAULT_LOCATION);
            fileOutputStream.getChannel()
                    .transferFrom(channel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getFilePath() {
        return Path.of(handleFilePath(DEFAULT_LOCATION));
    }

    public static Path getFilePath(String location) {
        return Path.of(handleFilePath(location));
    }
}
