package b.i.a.f.i.b;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x8 {
    public b9 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w8 f1579b;

    public x8(w8 w8Var) {
        this.f1579b = w8Var;
    }

    @WorkerThread
    public final void a() {
        this.f1579b.b();
        b9 b9Var = this.a;
        if (b9Var != null) {
            this.f1579b.c.removeCallbacks(b9Var);
        }
        if (this.f1579b.a.h.o(p.v0)) {
            this.f1579b.l().f1525x.a(false);
        }
    }
}
