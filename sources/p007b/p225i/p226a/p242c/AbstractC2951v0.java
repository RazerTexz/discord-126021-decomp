package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s;

/* JADX INFO: renamed from: b.i.a.c.v0 */
/* JADX INFO: compiled from: BaseRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2951v0 implements InterfaceC2728f2, InterfaceC2763g2 {

    /* JADX INFO: renamed from: j */
    public final int f7889j;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C2804h2 f7891l;

    /* JADX INFO: renamed from: m */
    public int f7892m;

    /* JADX INFO: renamed from: n */
    public int f7893n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public InterfaceC2546i0 f7894o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public C2811j1[] f7895p;

    /* JADX INFO: renamed from: q */
    public long f7896q;

    /* JADX INFO: renamed from: s */
    public boolean f7898s;

    /* JADX INFO: renamed from: t */
    public boolean f7899t;

    /* JADX INFO: renamed from: k */
    public final C2815k1 f7890k = new C2815k1();

    /* JADX INFO: renamed from: r */
    public long f7897r = Long.MIN_VALUE;

    public AbstractC2951v0(int i) {
        this.f7889j = i;
    }

    /* JADX INFO: renamed from: A */
    public final C2815k1 m3547A() {
        this.f7890k.m3279a();
        return this.f7890k;
    }

    /* JADX INFO: renamed from: B */
    public abstract void mo2621B();

    /* JADX INFO: renamed from: C */
    public void mo3137C(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    /* JADX INFO: renamed from: D */
    public abstract void mo2622D(long j, boolean z2) throws ExoPlaybackException;

    /* JADX INFO: renamed from: E */
    public void mo3140E() {
    }

    /* JADX INFO: renamed from: F */
    public void mo3141F() throws ExoPlaybackException {
    }

    /* JADX INFO: renamed from: G */
    public void mo3142G() {
    }

    /* JADX INFO: renamed from: H */
    public abstract void mo2623H(C2811j1[] c2811j1Arr, long j, long j2) throws ExoPlaybackException;

    /* JADX INFO: renamed from: I */
    public final int m3548I(C2815k1 c2815k1, DecoderInputBuffer decoderInputBuffer, int i) {
        InterfaceC2546i0 interfaceC2546i0 = this.f7894o;
        Objects.requireNonNull(interfaceC2546i0);
        int iMo2505a = interfaceC2546i0.mo2505a(c2815k1, decoderInputBuffer, i);
        if (iMo2505a == -4) {
            if (decoderInputBuffer.m3555n()) {
                this.f7897r = Long.MIN_VALUE;
                return this.f7898s ? -4 : -3;
            }
            long j = decoderInputBuffer.f19780n + this.f7896q;
            decoderInputBuffer.f19780n = j;
            this.f7897r = Math.max(this.f7897r, j);
        } else if (iMo2505a == -5) {
            C2811j1 c2811j1 = c2815k1.f7196b;
            Objects.requireNonNull(c2811j1);
            if (c2811j1.f7127A != RecyclerView.FOREVER_NS) {
                C2811j1.b bVarM3275a = c2811j1.m3275a();
                bVarM3275a.f7177o = c2811j1.f7127A + this.f7896q;
                c2815k1.f7196b = bVarM3275a.m3277a();
            }
        }
        return iMo2505a;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: f */
    public final void mo2932f(int i) {
        this.f7892m = i;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: g */
    public final void mo2933g() {
        C1460d.m426D(this.f7893n == 1);
        this.f7890k.m3279a();
        this.f7893n = 0;
        this.f7894o = null;
        this.f7895p = null;
        this.f7898s = false;
        mo2621B();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    public final int getState() {
        return this.f7893n;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    @Nullable
    /* JADX INFO: renamed from: h */
    public final InterfaceC2546i0 mo2934h() {
        return this.f7894o;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: j */
    public final boolean mo2935j() {
        return this.f7897r == Long.MIN_VALUE;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: k */
    public final void mo2936k(C2811j1[] c2811j1Arr, InterfaceC2546i0 interfaceC2546i0, long j, long j2) throws ExoPlaybackException {
        C1460d.m426D(!this.f7898s);
        this.f7894o = interfaceC2546i0;
        if (this.f7897r == Long.MIN_VALUE) {
            this.f7897r = j;
        }
        this.f7895p = c2811j1Arr;
        this.f7896q = j2;
        mo2623H(c2811j1Arr, j, j2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: l */
    public final void mo2937l() {
        this.f7898s = true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: m */
    public final InterfaceC2763g2 mo2938m() {
        return this;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: n */
    public /* synthetic */ void mo2939n(float f, float f2) throws ExoPlaybackException {
        C2678e2.m2772a(this, f, f2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: o */
    public final void mo2940o(C2804h2 c2804h2, C2811j1[] c2811j1Arr, InterfaceC2546i0 interfaceC2546i0, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException {
        C1460d.m426D(this.f7893n == 0);
        this.f7891l = c2804h2;
        this.f7893n = 1;
        mo3137C(z2, z3);
        mo2936k(c2811j1Arr, interfaceC2546i0, j2, j3);
        mo2622D(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2763g2
    /* JADX INFO: renamed from: p */
    public int mo3119p() throws ExoPlaybackException {
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.C2576b2.b
    /* JADX INFO: renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    public final void reset() {
        C1460d.m426D(this.f7893n == 0);
        this.f7890k.m3279a();
        mo3140E();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: s */
    public final void mo2941s() throws IOException {
        InterfaceC2546i0 interfaceC2546i0 = this.f7894o;
        Objects.requireNonNull(interfaceC2546i0);
        interfaceC2546i0.mo2506b();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    public final void start() throws ExoPlaybackException {
        C1460d.m426D(this.f7893n == 1);
        this.f7893n = 2;
        mo3141F();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    public final void stop() {
        C1460d.m426D(this.f7893n == 2);
        this.f7893n = 1;
        mo3142G();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: t */
    public final long mo2942t() {
        return this.f7897r;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: u */
    public final void mo2943u(long j) throws ExoPlaybackException {
        this.f7898s = false;
        this.f7897r = j;
        mo2622D(j, false);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: v */
    public final boolean mo2944v() {
        return this.f7898s;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    @Nullable
    /* JADX INFO: renamed from: w */
    public InterfaceC2752s mo2945w() {
        return null;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: x */
    public final int mo2946x() {
        return this.f7889j;
    }

    /* JADX INFO: renamed from: y */
    public final ExoPlaybackException m3549y(Throwable th, @Nullable C2811j1 c2811j1, int i) {
        return m3550z(th, c2811j1, false, i);
    }

    /* JADX INFO: renamed from: z */
    public final ExoPlaybackException m3550z(Throwable th, @Nullable C2811j1 c2811j1, boolean z2, int i) {
        int iMo2630a;
        if (c2811j1 == null || this.f7899t) {
            iMo2630a = 4;
        } else {
            this.f7899t = true;
            try {
                iMo2630a = mo2630a(c2811j1) & 7;
                this.f7899t = false;
            } catch (ExoPlaybackException unused) {
                this.f7899t = false;
                iMo2630a = 4;
            } catch (Throwable th2) {
                this.f7899t = false;
                throw th2;
            }
        }
        return new ExoPlaybackException(1, th, null, i, getName(), this.f7892m, c2811j1, c2811j1 == null ? 4 : iMo2630a, z2);
    }
}
