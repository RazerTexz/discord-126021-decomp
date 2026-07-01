package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: loaded from: classes3.dex */
public final class LinkedTreeMap$c<K> extends AbstractSet<K> {
    public final /* synthetic */ LinkedTreeMap j;

    public LinkedTreeMap$c(LinkedTreeMap linkedTreeMap) {
        this.j = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.j.c(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new LinkedTreeMap$c$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        LinkedTreeMap linkedTreeMap = this.j;
        LinkedTreeMap$e linkedTreeMap$eC = linkedTreeMap.c(obj);
        if (linkedTreeMap$eC != null) {
            linkedTreeMap.e(linkedTreeMap$eC, true);
        }
        return linkedTreeMap$eC != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.j.size;
    }
}
