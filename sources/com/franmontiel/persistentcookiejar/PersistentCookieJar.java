package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import f0.n;
import f0.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PersistentCookieJar implements ClearableCookieJar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CookieCache f2909b;
    public CookiePersistor c;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.f2909b = cookieCache;
        this.c = cookiePersistor;
        ((SetCookieCache) cookieCache).addAll(((SharedPrefsCookiePersistor) cookiePersistor).c());
    }

    @Override // f0.p
    public synchronized void a(w wVar, List<n> list) {
        this.f2909b.addAll(list);
        CookiePersistor cookiePersistor = this.c;
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar.m) {
                arrayList.add(nVar);
            }
        }
        cookiePersistor.a(arrayList);
    }

    @Override // f0.p
    public synchronized List<n> b(w wVar) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator<n> it = this.f2909b.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.h < System.currentTimeMillis()) {
                arrayList2.add(next);
                it.remove();
            } else if (next.a(wVar)) {
                arrayList.add(next);
            }
        }
        this.c.removeAll(arrayList2);
        return arrayList;
    }
}
