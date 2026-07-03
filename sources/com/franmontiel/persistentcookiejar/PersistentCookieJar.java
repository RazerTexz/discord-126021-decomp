package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p600f0.C12370n;
import p600f0.C12379w;

/* JADX INFO: loaded from: classes3.dex */
public class PersistentCookieJar implements ClearableCookieJar {

    /* JADX INFO: renamed from: b */
    public CookieCache f19665b;

    /* JADX INFO: renamed from: c */
    public CookiePersistor f19666c;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.f19665b = cookieCache;
        this.f19666c = cookiePersistor;
        ((SetCookieCache) cookieCache).addAll(((SharedPrefsCookiePersistor) cookiePersistor).m8749c());
    }

    @Override // p600f0.InterfaceC12372p
    /* JADX INFO: renamed from: a */
    public synchronized void mo8745a(C12379w c12379w, List<C12370n> list) {
        this.f19665b.addAll(list);
        CookiePersistor cookiePersistor = this.f19666c;
        ArrayList arrayList = new ArrayList();
        for (C12370n c12370n : list) {
            if (c12370n.f25954m) {
                arrayList.add(c12370n);
            }
        }
        cookiePersistor.mo8747a(arrayList);
    }

    @Override // p600f0.InterfaceC12372p
    /* JADX INFO: renamed from: b */
    public synchronized List<C12370n> mo8746b(C12379w c12379w) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator<C12370n> it = this.f19665b.iterator();
        while (it.hasNext()) {
            C12370n next = it.next();
            if (next.f25949h < System.currentTimeMillis()) {
                arrayList2.add(next);
                it.remove();
            } else if (next.m10384a(c12379w)) {
                arrayList.add(next);
            }
        }
        this.f19666c.removeAll(arrayList2);
        return arrayList;
    }
}
