package com.franmontiel.persistentcookiejar.cache;

import p007b.p100d.p104b.p105a.C1643a;
import p600f0.C12370n;

/* JADX INFO: loaded from: classes3.dex */
public class IdentifiableCookie {

    /* JADX INFO: renamed from: a */
    public C12370n f19667a;

    public IdentifiableCookie(C12370n c12370n) {
        this.f19667a = c12370n;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.f19667a.f25947f.equals(this.f19667a.f25947f) || !identifiableCookie.f19667a.f25950i.equals(this.f19667a.f25950i) || !identifiableCookie.f19667a.f25951j.equals(this.f19667a.f25951j)) {
            return false;
        }
        C12370n c12370n = identifiableCookie.f19667a;
        boolean z2 = c12370n.f25952k;
        C12370n c12370n2 = this.f19667a;
        return z2 == c12370n2.f25952k && c12370n.f25955n == c12370n2.f25955n;
    }

    public int hashCode() {
        int iM863m = C1643a.m863m(this.f19667a.f25951j, C1643a.m863m(this.f19667a.f25950i, C1643a.m863m(this.f19667a.f25947f, 527, 31), 31), 31);
        C12370n c12370n = this.f19667a;
        return ((iM863m + (!c12370n.f25952k ? 1 : 0)) * 31) + (!c12370n.f25955n ? 1 : 0);
    }
}
