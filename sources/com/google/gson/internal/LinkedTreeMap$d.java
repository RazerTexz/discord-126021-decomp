package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LinkedTreeMap$d<T> implements Iterator<T> {
    public LinkedTreeMap$e<K, V> j;
    public LinkedTreeMap$e<K, V> k = null;
    public int l;
    public final /* synthetic */ LinkedTreeMap m;

    public LinkedTreeMap$d(LinkedTreeMap linkedTreeMap) {
        this.m = linkedTreeMap;
        this.j = linkedTreeMap.header.m;
        this.l = linkedTreeMap.modCount;
    }

    public final LinkedTreeMap$e<K, V> a() {
        LinkedTreeMap$e<K, V> linkedTreeMap$e = this.j;
        LinkedTreeMap linkedTreeMap = this.m;
        if (linkedTreeMap$e == linkedTreeMap.header) {
            throw new NoSuchElementException();
        }
        if (linkedTreeMap.modCount != this.l) {
            throw new ConcurrentModificationException();
        }
        this.j = linkedTreeMap$e.m;
        this.k = linkedTreeMap$e;
        return linkedTreeMap$e;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j != this.m.header;
    }

    @Override // java.util.Iterator
    public final void remove() {
        Map$Entry map$Entry = this.k;
        if (map$Entry == null) {
            throw new IllegalStateException();
        }
        this.m.e(map$Entry, true);
        this.k = null;
        this.l = this.m.modCount;
    }
}
