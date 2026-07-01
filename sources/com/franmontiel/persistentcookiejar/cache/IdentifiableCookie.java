package com.franmontiel.persistentcookiejar.cache;

import b.d.b.a.outline;
import f0.Cookie;

/* JADX INFO: loaded from: classes3.dex */
public class IdentifiableCookie {
    public Cookie a;

    public IdentifiableCookie(Cookie cookie) {
        this.a = cookie;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.a.f.equals(this.a.f) || !identifiableCookie.a.i.equals(this.a.i) || !identifiableCookie.a.j.equals(this.a.j)) {
            return false;
        }
        Cookie cookie = identifiableCookie.a;
        boolean z2 = cookie.k;
        Cookie cookie2 = this.a;
        return z2 == cookie2.k && cookie.n == cookie2.n;
    }

    public int hashCode() {
        int iM = outline.m(this.a.j, outline.m(this.a.i, outline.m(this.a.f, 527, 31), 31), 31);
        Cookie cookie = this.a;
        return ((iM + (!cookie.k ? 1 : 0)) * 31) + (!cookie.n ? 1 : 0);
    }
}
