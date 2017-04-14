//import java.util.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Mega-Raid-2 on 14.04.2017.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
            createCreature("Zerg",10);
            createCreature("Protoss",5);
            createCreature("Terran",12);//напишите тут ваш код
        }

        public static class Zerg {
            public String name;
        }

        public static class Protoss {
            public String name;
        }

        public static class Terran {
            public String name;
        }
        public static void createCreature(String name,int qty) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

            Class<?> c = Class.forName("Main$"+name);
            Constructor<?> ctr = c.getConstructor();
            for (int i=0;i < qty;i++ ) {
                Object creature = ctr.newInstance();
                for (Field field : c.getDeclaredFields()){
                    field.setAccessible(true);
                    field.set(creature,name+i);
                }

                try {
                    System.out.println(toString(creature));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        public static String toString(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField("name");
        Object value = field.get(object);
           return value.toString();
        }
}
