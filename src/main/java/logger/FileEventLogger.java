package logger;

import Event.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
   private String fileName;

    public FileEventLogger() {
    }

    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
        }

    public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(file, msg.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
    public void init() {
        this.file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.canWrite()) {
            return;
        }
        else {
            try {
                throw  new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
