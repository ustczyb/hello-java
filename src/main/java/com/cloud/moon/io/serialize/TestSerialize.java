package com.cloud.moon.io.serialize;

import com.cloud.moon.io.serialize.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by zhangyubo02 on 2017/9/2.
 */
public class TestSerialize {

    private Person person;
    private String filePath = "Person.out";

    @Before
    public void prepare(){
        person = new Person();
//        person.setAge(10);
        person.setName("test");
    }

    @Test
    public void writeObject() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(person);
        oos.close();
    }

    @Test
    public void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Person p = (Person) ois.readObject();
        ois.close();
        System.out.println(p);
    }
}
