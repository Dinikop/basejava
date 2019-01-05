package org.dnk;

import org.dnk.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Resume resume = new Resume("Jack");
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");

        Method method = Resume.class.getMethod("toString");
        try {
            System.out.println(method.invoke(resume));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
