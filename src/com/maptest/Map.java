package com.maptest;

/**
 * @author wy
 * @create 2020-08-01 11:25
 */
public interface Map<K,V> {
    V put(K k,V v);
    V get(K k);
    int size();

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }


}
