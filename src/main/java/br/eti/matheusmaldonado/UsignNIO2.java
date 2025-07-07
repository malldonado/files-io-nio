package br.eti.matheusmaldonado;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class UsignNIO2 {
    private static final String MY_FILE;

    public UsignNIO2() {
        try {
            this.writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("---------------------------------");

        try {
            this.readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void writeFile() throws IOException {
        Path path = Paths.get(MY_FILE);
        Files.writeString(path, "Ola mundo NIO2");
        System.out.println("Arquivo gravado com sucesso");
    }

    private void readFile() throws IOException {
        Path path = Paths.get(MY_FILE);
        List var10000 = Files.readAllLines(path);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public static void main(String[] args) {
        new UsignNIO2();
    }

    static {
        MY_FILE = "c:" + File.separator + "file-using-nio2.txt";
    }
}
