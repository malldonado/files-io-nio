package br.eti.matheusmaldonado;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class UsingNIO {

    private static final String MY_FILE;

    public UsingNIO() {
        try {
            this.writeFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("-------------------------------");

        try {
            this.readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void writeFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile(MY_FILE, "rw");
        FileChannel channel = file.getChannel();
        channel.write(ByteBuffer.wrap("Ola mundo NIO".getBytes(StandardCharsets.UTF_8)));
        channel.close();
        file.close();
        System.out.println("Dados gravados no arquivo");
    }

    private void readFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile(MY_FILE, "rw");
        FileChannel channel = file.getChannel();
        long fileSize = channel.size();
        ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
        channel.read(buffer);
        buffer.flip();

        for(int i = 0; (long)i < fileSize; ++i) {
            System.out.println((char)buffer.get());
        }

        channel.close();
        file.close();
    }

    public static void main(String[] args) {
        new UsingNIO();
    }

    static {
        MY_FILE = "c:" + File.separator + "file-using-nio.txt";
    }
}
