package b.i.a.f.i.b;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y8 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ w8 k;

    public y8(w8 w8Var, long j) {
        this.k = w8Var;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w8 w8Var = this.k;
        long j = this.j;
        w8Var.b();
        w8Var.x();
        w8Var.g().n.b("Activity paused, time", Long.valueOf(j));
        x8 x8Var = w8Var.f;
        Objects.requireNonNull((b.i.a.f.e.o.c) x8Var.f1579b.a.o);
        b9 b9Var = new b9(x8Var, System.currentTimeMillis(), j);
        x8Var.a = b9Var;
        x8Var.f1579b.c.postDelayed(b9Var, 2000L);
        if (w8Var.a.h.z().booleanValue()) {
            w8Var.e.c.c();
        }
        f9 f9Var = w8Var.d;
        if (f9Var.a.a.h.o(p.v0)) {
            return;
        }
        f9Var.a.l().f1525x.a(true);
    }
}
