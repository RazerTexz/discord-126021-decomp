package com.franmontiel.persistentcookiejar.cache;

import b.d.b.a.a;
import f0.n;

/* JADX INFO: loaded from: classes3.dex */
public class IdentifiableCookie {
    public n a;

    public IdentifiableCookie(n nVar) {
        this.a = nVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.a.f.equals(this.a.f) || !identifiableCookie.a.i.equals(this.a.i) || !identifiableCookie.a.j.equals(this.a.j)) {
            return false;
        }
        n nVar = identifiableCookie.a;
        boolean z2 = nVar.k;
        n nVar2 = this.a;
        return z2 == nVar2.k && nVar.n == nVar2.n;
    }

    public int hashCode() {
        int iM = a.m(this.a.j, a.m(this.a.i, a.m(this.a.f, 527, 31), 31), 31);
        n nVar = this.a;
        return ((iM + (!nVar.k ? 1 : 0)) * 31) + (!nVar.n ? 1 : 0);
    }
}
