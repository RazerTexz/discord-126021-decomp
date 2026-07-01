package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.j.a.a;
import b.i.c.l.d;
import b.i.c.l.d$b;
import b.i.c.l.g;
import b.i.c.l.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AnalyticsConnectorRegistrar implements g {
    @Override // b.i.c.l.g
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<d<?>> getComponents() {
        d$b d_bA = d.a(a.class);
        d_bA.a(new o(c.class, 1, 0));
        d_bA.a(new o(Context.class, 1, 0));
        d_bA.a(new o(b.i.c.q.d.class, 1, 0));
        d_bA.c(b.i.c.j.a.c.a.a);
        d_bA.d(2);
        return Arrays.asList(d_bA.b(), f.N("fire-analytics", "18.0.0"));
    }
}
