package com.maptest;

/**
 * @author wy
 * @create 2020-08-01 12:09
 */
public class HashMap_<K, V> implements Map<K, V> {


    private Entry_<K, V>[] table = null;
    private int size = 0;

    public HashMap_() {
        table = new Entry_[16];
    }

    /**
     * put存储实现思路
     * 通过key 进行hash
     * 取模16 下标
     * 放到数组中去
     * 判断当前下标
     * 没有值：直接放到下标
     * 有值：用链表 next指针 引用
     *
     * @param k
     * @param v
     * @return
     */

    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry_<K, V> entry_ = table[index];
        if (entry_ == null) {
            table[index] = new Entry_<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry_<>(k, v, index, entry_);
        }


        return table[index].getValue();
    }

    private int hash(K k) {
        int i = k.hashCode() % 16;
        //return i>0?i:-i;
        return Math.abs(i);
    }

    /**
     * get 实现思路
     * 根据key 的hash值
     * 找到对应的数组下标
     * 判断下标是否有值
     * 有值 判断key是否相等
     * 相等：》直接返回
     * 不相等： 当前值得链表next key 是否相等 》直接返回
     * 不相等：》null
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        if (size == 0) {
            return null;
        }
        int index = hash(k);
        if (table[index] == null) {
            return null;
        }
        Entry_<K, V> entry_2 = FindValue(k, table[index]);

        return entry_2 == null ? null : entry_2.getValue();
    }

    public Entry_<K, V> FindValue(K k, Entry_<K, V> entry_) {

        if (entry_.getKey().equals(k) || entry_.getKey() == k) {
            return entry_;
        } else {
            if (entry_.next != null) {

                 return  FindValue(k, entry_.next);
//                while (entry_.next!=null){
//                    if(entry_.next.getKey().equals(k) || entry_.next.getKey() == k){
//                        return entry_.next;
//                    }
//                }
            }

        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    public class Entry_<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry_<K, V> next;

        public Entry_(K k, V v, int hash, Entry_<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

}

