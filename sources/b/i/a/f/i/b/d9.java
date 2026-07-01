package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d9 {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1528b;
    public final i c;
    public final /* synthetic */ w8 d;

    public d9(w8 w8Var) {
        this.d = w8Var;
        this.c = new c9(this, w8Var.a);
        Objects.requireNonNull((b.i.a.f.e.o.c) w8Var.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.a = jElapsedRealtime;
        this.f1528b = jElapsedRealtime;
    }

    @WorkerThread
    public final boolean a(boolean z2, boolean z3, long j) {
        this.d.b();
        this.d.t();
        if (!b.i.a.f.h.l.r9.b() || !this.d.a.h.o(p.q0) || this.d.a.d()) {
            h4 h4Var = this.d.l().v;
            Objects.requireNonNull((b.i.a.f.e.o.c) this.d.a.o);
            h4Var.b(System.currentTimeMillis());
        }
        long jB = j - this.a;
        if (!z2 && jB < 1000) {
            this.d.g().n.b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jB));
            return false;
        }
        if (this.d.a.h.o(p.T) && !z3) {
            if (((b.i.a.f.h.l.v9) b.i.a.f.h.l.s9.j.a()).a() && this.d.a.h.o(p.V)) {
                jB = j - this.f1528b;
                this.f1528b = j;
            } else {
                jB = b();
            }
        }
        this.d.g().n.b("Recording user engagement, ms", Long.valueOf(jB));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jB);
        h7.A(this.d.q().w(!this.d.a.h.z().booleanValue()), bundle, true);
        if (this.d.a.h.o(p.T) && !this.d.a.h.o(p.U) && z3) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.d.a.h.o(p.U) || !z3) {
            this.d.n().H("auto", "_e", bundle);
        }
        this.a = j;
        this.c.c();
        this.c.b(3600000L);
        return true;
    }

    @WorkerThread
    public final long b() {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.d.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.f1528b;
        this.f1528b = jElapsedRealtime;
        return j;
    }
}
