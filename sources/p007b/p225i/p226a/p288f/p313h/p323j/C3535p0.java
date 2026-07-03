package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.SharedPreferences;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.p0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3535p0 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public SharedPreferences f9777l;

    /* JADX INFO: renamed from: m */
    public long f9778m;

    /* JADX INFO: renamed from: n */
    public long f9779n;

    /* JADX INFO: renamed from: o */
    public final C3539r0 f9780o;

    public C3535p0(C3515g c3515g) {
        super(c3515g);
        this.f9779n = -1L;
        this.f9780o = new C3539r0(this, "monitoring", C3510e0.f9686A.f9716a.longValue(), null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        this.f9777l = this.f9684j.f9722b.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    /* JADX INFO: renamed from: O */
    public final long m4485O() {
        C3180f.m3967b();
        m4444N();
        if (this.f9779n == -1) {
            this.f9779n = this.f9777l.getLong("last_dispatch", 0L);
        }
        return this.f9779n;
    }

    /* JADX INFO: renamed from: R */
    public final void m4486R() {
        C3180f.m3967b();
        m4444N();
        Objects.requireNonNull((C3401c) this.f9684j.f9724d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.f9777l.edit();
        editorEdit.putLong("last_dispatch", jCurrentTimeMillis);
        editorEdit.apply();
        this.f9779n = jCurrentTimeMillis;
    }
}
