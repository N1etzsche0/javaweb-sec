package com.anbai.sec.serializes.CommonsCollections1;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.HashMap;
import java.util.Map;
public class TransformedMapTest {
    public static Transformer keyTransformer = input -> {
        int num = (int) input;
        num += 1;
        return (Object) num;
    };

    public static Transformer valueTransformer = input -> {
      String str = input.toString();
      return str + "1";
    };

    public static void main(String[] args){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(String.valueOf(1),"a");
        System.out.println("初始化map："+hashMap);
        Map map = TransformedMap.decorate(hashMap,keyTransformer,valueTransformer);
        map.put(2,"b");
        System.out.println("transformMap:"+map);
    }
}
