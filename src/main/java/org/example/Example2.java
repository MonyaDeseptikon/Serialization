package org.example;

import java.io.*;

public class Example2 extends ObjectInputStream implements Externalizable {
   private   ExampleSon son = new ExampleSon();
    public String text;
   //Добавил еще одну переменную,- класс поменялся (добавилось поле), поэтому вылетает ошибка
  //  public String textNew;
    public Example2(String text) throws IOException {
        this.text=text;

        System.out.println(text);
    }

    public String getText() {
        return text+'\n' + son.text;
    }

    public void setText(String text) {
       //Здесь добавил +" New", но ошибка не вылетает,- видимо так допустимо. - ведь новые поля и методы не появились
        this.text = text+" New";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.son);
        out.writeObject(this.text);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.son=(ExampleSon) in.readObject();
        this.text= (String) in.readObject();


    }
}
