package b.i.a.f.h.j;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends e {
    public SharedPreferences l;
    public long m;
    public long n;
    public final r0 o;

    public p0(g gVar) {
        super(gVar);
        this.n = -1L;
        this.o = new r0(this, "monitoring", e0.A.a.longValue(), null);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        this.l = this.j.f1417b.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long O() {
        b.i.a.f.b.f.b();
        N();
        if (this.n == -1) {
            this.n = this.l.getLong("last_dispatch", 0L);
        }
        return this.n;
    }

    public final void R() {
        b.i.a.f.b.f.b();
        N();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.l.edit();
        editorEdit.putLong("last_dispatch", jCurrentTimeMillis);
        editorEdit.apply();
        this.n = jCurrentTimeMillis;
    }
}
