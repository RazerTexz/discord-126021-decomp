package com.franmontiel.persistentcookiejar.cache;

import f0.n;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SetCookieCache$SetCookieCacheIterator implements Iterator<n> {
    public Iterator<IdentifiableCookie> j;

    public SetCookieCache$SetCookieCacheIterator(SetCookieCache setCookieCache) {
        this.j = setCookieCache.j.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public n next() {
        return this.j.next().a;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.j.remove();
    }
}
