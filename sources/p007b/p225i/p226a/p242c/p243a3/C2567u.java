package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2812j2;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.a3.u */
/* JADX INFO: compiled from: MaskingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2567u implements InterfaceC2570x, InterfaceC2570x.a {

    /* JADX INFO: renamed from: j */
    public final InterfaceC2530a0.a f5705j;

    /* JADX INFO: renamed from: k */
    public final long f5706k;

    /* JADX INFO: renamed from: l */
    public final C2713o f5707l;

    /* JADX INFO: renamed from: m */
    public InterfaceC2530a0 f5708m;

    /* JADX INFO: renamed from: n */
    public InterfaceC2570x f5709n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public InterfaceC2570x.a f5710o;

    /* JADX INFO: renamed from: p */
    public long f5711p = -9223372036854775807L;

    public C2567u(InterfaceC2530a0.a aVar, C2713o c2713o, long j) {
        this.f5705j = aVar;
        this.f5707l = c2713o;
        this.f5706k = j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2548j0.a
    /* JADX INFO: renamed from: a */
    public void mo2542a(InterfaceC2548j0 interfaceC2548j0) {
        InterfaceC2570x.a aVar = this.f5710o;
        int i = C2738e0.f6708a;
        aVar.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x.a
    /* JADX INFO: renamed from: b */
    public void mo2563b(InterfaceC2570x interfaceC2570x) {
        InterfaceC2570x.a aVar = this.f5710o;
        int i = C2738e0.f6708a;
        aVar.mo2563b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: c */
    public long mo2479c() {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2479c();
    }

    /* JADX INFO: renamed from: d */
    public void m2590d(InterfaceC2530a0.a aVar) {
        long j = this.f5706k;
        long j2 = this.f5711p;
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        InterfaceC2530a0 interfaceC2530a0 = this.f5708m;
        Objects.requireNonNull(interfaceC2530a0);
        InterfaceC2570x interfaceC2570xMo2459n = interfaceC2530a0.mo2459n(aVar, this.f5707l, j);
        this.f5709n = interfaceC2570xMo2459n;
        if (this.f5710o != null) {
            interfaceC2570xMo2459n.mo2488l(this, j);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: e */
    public void mo2481e() throws IOException {
        try {
            InterfaceC2570x interfaceC2570x = this.f5709n;
            if (interfaceC2570x != null) {
                interfaceC2570x.mo2481e();
                return;
            }
            InterfaceC2530a0 interfaceC2530a0 = this.f5708m;
            if (interfaceC2530a0 != null) {
                interfaceC2530a0.mo2453h();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: f */
    public long mo2482f(long j) {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2482f(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: g */
    public boolean mo2483g(long j) {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        return interfaceC2570x != null && interfaceC2570x.mo2483g(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: h */
    public boolean mo2484h() {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        return interfaceC2570x != null && interfaceC2570x.mo2484h();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: i */
    public long mo2485i(long j, C2812j2 c2812j2) {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2485i(j, c2812j2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: k */
    public long mo2487k() {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2487k();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: l */
    public void mo2488l(InterfaceC2570x.a aVar, long j) {
        this.f5710o = aVar;
        InterfaceC2570x interfaceC2570x = this.f5709n;
        if (interfaceC2570x != null) {
            long j2 = this.f5706k;
            long j3 = this.f5711p;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            interfaceC2570x.mo2488l(this, j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: m */
    public long mo2489m(InterfaceC2644j[] interfaceC2644jArr, boolean[] zArr, InterfaceC2546i0[] interfaceC2546i0Arr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f5711p;
        if (j3 == -9223372036854775807L || j != this.f5706k) {
            j2 = j;
        } else {
            this.f5711p = -9223372036854775807L;
            j2 = j3;
        }
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2489m(interfaceC2644jArr, zArr, interfaceC2546i0Arr, zArr2, j2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: n */
    public C2558o0 mo2490n() {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2490n();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: q */
    public long mo2493q() {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        return interfaceC2570x.mo2493q();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: r */
    public void mo2494r(long j, boolean z2) {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        interfaceC2570x.mo2494r(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: s */
    public void mo2495s(long j) {
        InterfaceC2570x interfaceC2570x = this.f5709n;
        int i = C2738e0.f6708a;
        interfaceC2570x.mo2495s(j);
    }
}
