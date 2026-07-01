package com.google.gson.internal;

import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes3.dex */
public class LinkedTreeMap$b$a<K, V> extends LinkedTreeMap<K, V>.LinkedTreeMap$d<Map$Entry<K, V>> {
    public LinkedTreeMap$b$a(LinkedTreeMap$b linkedTreeMap$b) {
        super(linkedTreeMap$b.j);
    }

    @Override // java.util.Iterator
    public Object next() {
        return a();
    }
}
