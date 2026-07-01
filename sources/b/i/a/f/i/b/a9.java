package b.i.a.f.i.b;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a9 implements Runnable {
    public final b9 j;

    public a9(b9 b9Var) {
        this.j = b9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b9 b9Var = this.j;
        x8 x8Var = b9Var.l;
        long j = b9Var.j;
        long j2 = b9Var.k;
        x8Var.f1579b.b();
        x8Var.f1579b.g().m.a("Application going to the background");
        boolean z2 = true;
        if (x8Var.f1579b.a.h.o(p.v0)) {
            x8Var.f1579b.l().f1525x.a(true);
        }
        Bundle bundle = new Bundle();
        if (!x8Var.f1579b.a.h.z().booleanValue()) {
            x8Var.f1579b.e.c.c();
            if (x8Var.f1579b.a.h.o(p.m0)) {
                d9 d9Var = x8Var.f1579b.e;
                long j3 = j2 - d9Var.f1528b;
                d9Var.f1528b = j2;
                bundle.putLong("_et", j3);
                h7.A(x8Var.f1579b.q().w(true), bundle, true);
            } else {
                z2 = false;
            }
            x8Var.f1579b.w(false, z2, j2);
        }
        x8Var.f1579b.n().E("auto", "_ab", j, bundle);
    }
}
