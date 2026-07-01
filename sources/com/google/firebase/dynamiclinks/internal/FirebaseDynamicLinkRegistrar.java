package com.google.firebase.dynamiclinks.internal;

import androidx.annotation.Keep;
import b.i.c.c;
import b.i.c.l.d;
import b.i.c.l.d$b;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.o.a;
import b.i.c.o.b.f;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class FirebaseDynamicLinkRegistrar implements g {
    @Override // b.i.c.l.g
    @Keep
    public final List<d<?>> getComponents() {
        d$b d_bA = d.a(a.class);
        d_bA.a(new o(c.class, 1, 0));
        d_bA.a(new o(b.i.c.j.a.a.class, 0, 0));
        d_bA.c(f.a);
        return Arrays.asList(d_bA.b());
    }
}
