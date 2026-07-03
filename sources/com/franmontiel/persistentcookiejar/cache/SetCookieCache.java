package com.franmontiel.persistentcookiejar.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p600f0.C12370n;

/* JADX INFO: loaded from: classes3.dex */
public class SetCookieCache implements CookieCache {

    /* JADX INFO: renamed from: j */
    public Set<IdentifiableCookie> f19668j = new HashSet();

    public class SetCookieCacheIterator implements Iterator<C12370n> {

        /* JADX INFO: renamed from: j */
        public Iterator<IdentifiableCookie> f19669j;

        public SetCookieCacheIterator(SetCookieCache setCookieCache) {
            this.f19669j = setCookieCache.f19668j.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19669j.hasNext();
        }

        @Override // java.util.Iterator
        public C12370n next() {
            return this.f19669j.next().f19667a;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f19669j.remove();
        }
    }

    @Override // com.franmontiel.persistentcookiejar.cache.CookieCache
    public void addAll(Collection<C12370n> collection) {
        ArrayList<IdentifiableCookie> arrayList = new ArrayList(collection.size());
        Iterator<C12370n> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new IdentifiableCookie(it.next()));
        }
        for (IdentifiableCookie identifiableCookie : arrayList) {
            this.f19668j.remove(identifiableCookie);
            this.f19668j.add(identifiableCookie);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<C12370n> iterator() {
        return new SetCookieCacheIterator(this);
    }
}
