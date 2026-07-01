package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes3.dex */
public class LinkedTreeMap$b<K, V> extends AbstractSet<Map$Entry<K, V>> {
    public final /* synthetic */ LinkedTreeMap j;

    public LinkedTreeMap$b(LinkedTreeMap linkedTreeMap) {
        this.j = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return (obj instanceof Map$Entry) && this.j.b((Map$Entry) obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map$Entry<K, V>> iterator() {
        return new LinkedTreeMap$b$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        LinkedTreeMap$e<K, V> linkedTreeMap$eB;
        if (!(obj instanceof Map$Entry) || (linkedTreeMap$eB = this.j.b((Map$Entry) obj)) == null) {
            return false;
        }
        this.j.e(linkedTreeMap$eB, true);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size;
    }
}
