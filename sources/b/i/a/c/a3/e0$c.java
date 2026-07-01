package b.i.a.c.a3;

import b.i.a.c.j1;
import b.i.a.c.k1;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$c implements i0 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f814b;

    public e0$c(e0 e0Var, int i) {
        this.f814b = e0Var;
        this.a = i;
    }

    @Override // b.i.a.c.a3.i0
    public int a(k1 k1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int i2;
        e0 e0Var = this.f814b;
        int i3 = this.a;
        if (e0Var.D()) {
            return -3;
        }
        e0Var.y(i3);
        h0 h0Var = e0Var.D[i3];
        boolean z2 = e0Var.V;
        boolean z3 = (i & 2) != 0;
        h0$b h0_b = h0Var.f819b;
        synchronized (h0Var) {
            decoderInputBuffer.m = false;
            i2 = -5;
            if (h0Var.o()) {
                j1 j1Var = h0Var.c.b(h0Var.k()).a;
                if (z3 || j1Var != h0Var.h) {
                    h0Var.r(j1Var, k1Var);
                } else {
                    int iL = h0Var.l(h0Var.t);
                    if (h0Var.q(iL)) {
                        decoderInputBuffer.j = h0Var.n[iL];
                        long j = h0Var.o[iL];
                        decoderInputBuffer.n = j;
                        if (j < h0Var.u) {
                            decoderInputBuffer.j(Integer.MIN_VALUE);
                        }
                        h0_b.a = h0Var.m[iL];
                        h0_b.f824b = h0Var.l[iL];
                        h0_b.c = h0Var.p[iL];
                        i2 = -4;
                    } else {
                        decoderInputBuffer.m = true;
                        i2 = -3;
                    }
                }
            } else if (z2 || h0Var.f821x) {
                decoderInputBuffer.j = 4;
                i2 = -4;
            } else {
                j1 j1Var2 = h0Var.B;
                if (j1Var2 == null || (!z3 && j1Var2 == h0Var.h)) {
                    i2 = -3;
                } else {
                    h0Var.r(j1Var2, k1Var);
                }
            }
        }
        if (i2 == -4 && !decoderInputBuffer.n()) {
            boolean z4 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z4) {
                    g0 g0Var = h0Var.a;
                    g0.f(g0Var.e, decoderInputBuffer, h0Var.f819b, g0Var.c);
                } else {
                    g0 g0Var2 = h0Var.a;
                    g0Var2.e = g0.f(g0Var2.e, decoderInputBuffer, h0Var.f819b, g0Var2.c);
                }
            }
            if (!z4) {
                h0Var.t++;
            }
        }
        if (i2 == -3) {
            e0Var.z(i3);
        }
        return i2;
    }

    @Override // b.i.a.c.a3.i0
    public void b() throws IOException {
        e0 e0Var = this.f814b;
        h0 h0Var = e0Var.D[this.a];
        DrmSession drmSession = h0Var.i;
        if (drmSession == null || drmSession.getState() != 1) {
            e0Var.A();
        } else {
            DrmSession$DrmSessionException drmSession$DrmSessionExceptionF = h0Var.i.f();
            Objects.requireNonNull(drmSession$DrmSessionExceptionF);
            throw drmSession$DrmSessionExceptionF;
        }
    }

    @Override // b.i.a.c.a3.i0
    public int c(long j) {
        int i;
        e0 e0Var = this.f814b;
        int i2 = this.a;
        boolean z2 = false;
        if (e0Var.D()) {
            return 0;
        }
        e0Var.y(i2);
        h0 h0Var = e0Var.D[i2];
        boolean z3 = e0Var.V;
        synchronized (h0Var) {
            int iL = h0Var.l(h0Var.t);
            if (h0Var.o() && j >= h0Var.o[iL]) {
                if (j <= h0Var.w || !z3) {
                    i = h0Var.i(iL, h0Var.q - h0Var.t, j, true);
                    if (i == -1) {
                    }
                } else {
                    i = h0Var.q - h0Var.t;
                }
            }
            i = 0;
        }
        synchronized (h0Var) {
            if (i >= 0) {
                if (h0Var.t + i <= h0Var.q) {
                    z2 = true;
                }
            }
            b.c.a.a0.d.j(z2);
            h0Var.t += i;
        }
        if (i == 0) {
            e0Var.z(i2);
        }
        return i;
    }

    @Override // b.i.a.c.a3.i0
    public boolean d() {
        e0 e0Var = this.f814b;
        return !e0Var.D() && e0Var.D[this.a].p(e0Var.V);
    }
}
