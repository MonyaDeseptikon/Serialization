package org.example;



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("serialized_object");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Example example = new Example("Serialization");
        System.out.println(1);
        System.out.println(example.getText());
        objectOutputStream.writeObject(example);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("serialized_object");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(2);
        Example exampleRead = (Example) objectInputStream.readObject();
               System.out.println(exampleRead.getText());
        objectInputStream.close();
        fileInputStream.close();
        exampleRead.setText("New text");
        System.out.println(3);
//        System.out.println(example.getText());
        System.out.println(4);
        System.out.println(exampleRead.getText());
//        System.out.println(example.text);





    }


}