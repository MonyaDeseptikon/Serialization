package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IoNio {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("secret_message.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(10000);
            int bytesRead = channel.read(buf);
            // Дешифровка ивыводсообщения
            buf.flip();
            while(buf.hasRemaining()){
                // Работа с буфером
                System.out.print((char) buf.get());
            }
            // Зашифровка изапись нового сообщения
            buf.clear();
            buf.put("New Encrypted Message".getBytes());
            buf.flip();
            while(buf.hasRemaining()) {
                channel.write(buf);
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
