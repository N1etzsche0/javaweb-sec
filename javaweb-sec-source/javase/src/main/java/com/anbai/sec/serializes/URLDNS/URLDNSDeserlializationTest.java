package com.anbai.sec.serializes.URLDNS;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
public class URLDNSDeserlializationTest {
    public static void main(String[] args) throws MalformedURLException {
        URL                  url     = new URL("http://czuqmi.dnslog.cn");
        URL                  url2     = new URL("http://czuqmi.dnslog.cn");
//        url.equals(url2);
        url.hashCode();
    }

}
