package test.com.effectiveJava.charcter02;

import main.com.effectiveJava.charcter02.SingletonC;
import org.junit.Test;

import java.io.*;

/**
 * Description:
 * User: chenbin-pc
 * Date: 2018-05-09
 * Time: 10:24
 */
public class Charter02Test {

    @Test
    public void testEnum() {
        File file = new File("singletonEnum");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {

            oos = new ObjectOutputStream(new FileOutputStream(file));
            SingletonC singleton = SingletonC.INSTANCE;
            oos.writeObject(SingletonC.INSTANCE);
            oos.close();
            ois = new ObjectInputStream(new FileInputStream(file));
            SingletonC singleton2 = (SingletonC) ois.readObject();
            System.out.println(singleton == singleton2);//true

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
