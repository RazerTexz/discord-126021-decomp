package b.i.a.f.i.b;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v8 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ w8 k;

    public v8(w8 w8Var, long j) {
        this.k = w8Var;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w8 w8Var = this.k;
        long j = this.j;
        w8Var.b();
        w8Var.x();
        w8Var.g().n.b("Activity resumed, time", Long.valueOf(j));
        if (w8Var.a.h.o(p.v0)) {
            if (w8Var.a.h.z().booleanValue() || w8Var.l().f1525x.b()) {
                d9 d9Var = w8Var.e;
                d9Var.d.b();
                d9Var.c.c();
                d9Var.a = j;
                d9Var.f1528b = j;
            }
            w8Var.f.a();
        } else {
            w8Var.f.a();
            if (w8Var.a.h.z().booleanValue()) {
                d9 d9Var2 = w8Var.e;
                d9Var2.d.b();
                d9Var2.c.c();
                d9Var2.a = j;
                d9Var2.f1528b = j;
            }
        }
        f9 f9Var = w8Var.d;
        f9Var.a.b();
        if (f9Var.a.a.d()) {
            if (!f9Var.a.a.h.o(p.v0)) {
                f9Var.a.l().f1525x.a(false);
            }
            Objects.requireNonNull((b.i.a.f.e.o.c) f9Var.a.a.o);
            f9Var.b(System.currentTimeMillis(), false);
        }
    }
}
