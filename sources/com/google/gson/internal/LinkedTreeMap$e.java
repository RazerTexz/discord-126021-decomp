package com.google.gson.internal;

import java.util.Map$Entry;

/* JADX INFO: loaded from: classes3.dex */
public final class LinkedTreeMap$e<K, V> implements Map$Entry<K, V> {
    public LinkedTreeMap$e<K, V> j;
    public LinkedTreeMap$e<K, V> k;
    public LinkedTreeMap$e<K, V> l;
    public LinkedTreeMap$e<K, V> m;
    public LinkedTreeMap$e<K, V> n;
    public final K o;
    public V p;
    public int q;

    public LinkedTreeMap$e() {
        this.o = null;
        this.n = this;
        this.m = this;
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        K k = this.o;
        if (k == null) {
            if (map$Entry.getKey() != null) {
                return false;
            }
        } else if (!k.equals(map$Entry.getKey())) {
            return false;
        }
        V v = this.p;
        if (v == null) {
            if (map$Entry.getValue() != null) {
                return false;
            }
        } else if (!v.equals(map$Entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map$Entry
    public K getKey() {
        return this.o;
    }

    @Override // java.util.Map$Entry
    public V getValue() {
        return this.p;
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        K k = this.o;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.p;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        V v2 = this.p;
        this.p = v;
        return v2;
    }

    public String toString() {
        return this.o + "=" + this.p;
    }

    public LinkedTreeMap$e(LinkedTreeMap$e<K, V> linkedTreeMap$e, K k, LinkedTreeMap$e<K, V> linkedTreeMap$e2, LinkedTreeMap$e<K, V> linkedTreeMap$e3) {
        this.j = linkedTreeMap$e;
        this.o = k;
        this.q = 1;
        this.m = linkedTreeMap$e2;
        this.n = linkedTreeMap$e3;
        linkedTreeMap$e3.m = this;
        linkedTreeMap$e2.n = this;
    }
}
