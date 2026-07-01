package com.google.firebase.dynamiclinks.internal;

import androidx.annotation.Keep;
import b.i.c.FirebaseApp2;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.o.a;
import b.i.c.o.b.f;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class FirebaseDynamicLinkRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    @Keep
    public final List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(a.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(b.i.c.j.a.a.class, 0, 0));
        bVarA.c(f.a);
        return Arrays.asList(bVarA.b());
    }
}
