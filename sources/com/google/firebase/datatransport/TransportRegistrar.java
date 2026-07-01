package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import b.i.a.b.i.a;
import b.i.a.b.j.n;
import b.i.c.l.d;
import b.i.c.l.d$b;
import b.i.c.l.e;
import b.i.c.l.g;
import b.i.c.l.o;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TransportRegistrar implements g {
    public static /* synthetic */ b.i.a.b.g lambda$getComponents$0(e eVar) {
        n.b((Context) eVar.a(Context.class));
        return n.a().c(a.e);
    }

    @Override // b.i.c.l.g
    public List<d<?>> getComponents() {
        d$b d_bA = d.a(b.i.a.b.g.class);
        d_bA.a(new o(Context.class, 1, 0));
        d_bA.c(b.i.c.n.a.a);
        return Collections.singletonList(d_bA.b());
    }
}
