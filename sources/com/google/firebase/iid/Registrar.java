package com.google.firebase.iid;

import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.l.d$b;
import b.i.c.l.e;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.r.d;
import b.i.c.s.e0.a;
import b.i.c.s.r;
import b.i.c.s.s;
import b.i.c.x.h;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class Registrar implements g {
    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(e eVar) {
        return new FirebaseInstanceId((c) eVar.a(c.class), eVar.b(h.class), eVar.b(d.class), (b.i.c.u.g) eVar.a(b.i.c.u.g.class));
    }

    public static final /* synthetic */ a lambda$getComponents$1$Registrar(e eVar) {
        return new Registrar$a((FirebaseInstanceId) eVar.a(FirebaseInstanceId.class));
    }

    @Override // b.i.c.l.g
    @Keep
    public final List<b.i.c.l.d<?>> getComponents() {
        d$b d_bA = b.i.c.l.d.a(FirebaseInstanceId.class);
        d_bA.a(new o(c.class, 1, 0));
        d_bA.a(new o(h.class, 0, 1));
        d_bA.a(new o(d.class, 0, 1));
        d_bA.a(new o(b.i.c.u.g.class, 1, 0));
        d_bA.c(r.a);
        d_bA.d(1);
        b.i.c.l.d dVarB = d_bA.b();
        d$b d_bA2 = b.i.c.l.d.a(a.class);
        d_bA2.a(new o(FirebaseInstanceId.class, 1, 0));
        d_bA2.c(s.a);
        return Arrays.asList(dVarB, d_bA2.b(), f.N("fire-iid", "21.0.0"));
    }
}
