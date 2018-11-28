import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        try {
            r.getClass().getMethod("toString").invoke(r);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(r);
    }
}
