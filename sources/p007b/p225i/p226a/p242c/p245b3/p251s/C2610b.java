package p007b.p225i.p226a.p242c.p245b3.p251s;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.b3.s.b */
/* JADX INFO: compiled from: SubripSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2610b implements InterfaceC2583g {

    /* JADX INFO: renamed from: j */
    public final C2578b[] f6024j;

    /* JADX INFO: renamed from: k */
    public final long[] f6025k;

    public C2610b(C2578b[] c2578bArr, long[] jArr) {
        this.f6024j = c2578bArr;
        this.f6025k = jArr;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int iM2994b = C2738e0.m2994b(this.f6025k, j, false, false);
        if (iM2994b < this.f6025k.length) {
            return iM2994b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        C1460d.m531j(i >= 0);
        C1460d.m531j(i < this.f6025k.length);
        return this.f6025k[i];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: h */
    public List<C2578b> mo2614h(long j) {
        int iM2997e = C2738e0.m2997e(this.f6025k, j, true, false);
        if (iM2997e != -1) {
            C2578b[] c2578bArr = this.f6024j;
            if (c2578bArr[iM2997e] != C2578b.f5754j) {
                return Collections.singletonList(c2578bArr[iM2997e]);
            }
        }
        return Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6025k.length;
    }
}
