package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Example extends ObjectInputStream implements Serializable {
   //Ключевое слово  transient - при сериализации это поле не будет инициализироваться, - говорят его потом можно инициалицировать самостоятельно
//   private  transient ExampleSon son = new ExampleSon();
    private   ExampleSon son = new ExampleSon();
    public String text;
   //Добавил еще одну переменную, - класс поменялся (добавилось поле), поэтому вылетает ошибка
  //  public String textNew;
    public Example(String text) throws IOException {
        this.text=text;

        System.out.println(text);
    }

    public String getText() {
        return text+'\n' + son.text;
    }

    public void setText(String text) {
       //Здесь добавил +" New", но ошибка не вылетает, - видимо так допустимо . - ведь новые поля и методы не повились
        this.text = text+" New";
    }
}
