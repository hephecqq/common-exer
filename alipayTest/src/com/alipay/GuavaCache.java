package com.alipay;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCache {

    @Test
    public void test() {
//        // 模拟数据
//        final List<Person> list = new ArrayList<Person>(5);
//        list.add(new Person("1", "zhangsan"));
//        list.add(new Person("2", "lisi"));
//        list.add(new Person("3", "wangwu"));
        CacheLoader<String,Map<String,Integer>> loader;
        loader = new CacheLoader<String, Map<String, Integer>>(){

            @Override
            public Map<String, Integer> load(String key) throws Exception {
                //当guava中不存在时候,则会调用load方法
                return null;
            }
            
        };
        
        LoadingCache<String, Map<String,Integer>> cache;
        //写数据1s后重新加载缓存
        cache = CacheBuilder.newBuilder().refreshAfterWrite(1L, TimeUnit.SECONDS).build(loader);
        assertEquals(0, cache.size());
        cache.put("GlobalAreaDict", new HashMap<String, Integer>());
                
        
    }
}
