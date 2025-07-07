package br.eti.matheusmaldonado;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UsingIO {
    private static final String MY_FILE;

    public UsingIO() {
        try {
            this.writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.readFile();
    }

    private void writeFile() throws IOException {
    }

    private void readFile() {
        try (FileReader reader = new FileReader(MY_FILE)) {
            for(int content = reader.read(); content != -1; content = reader.read()) {
                System.out.print((char)content);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UsingIO();
    }

    static {
        MY_FILE = "c:" + File.separator + "file-using-io.txt";
    }
}
