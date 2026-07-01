package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.j.a.a;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.q.Subscriber2;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(a.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(Context.class, 1, 0));
        bVarA.a(new Dependency2(Subscriber2.class, 1, 0));
        bVarA.c(b.i.c.j.a.c.a.a);
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-analytics", "18.0.0"));
    }
}
