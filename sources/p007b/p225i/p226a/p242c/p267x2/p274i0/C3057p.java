package p007b.p225i.p226a.p242c.p267x2.p274i0;

import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.p */
/* JADX INFO: compiled from: TrackSampleTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3057p {

    /* JADX INFO: renamed from: a */
    public final C3054m f8493a;

    /* JADX INFO: renamed from: b */
    public final int f8494b;

    /* JADX INFO: renamed from: c */
    public final long[] f8495c;

    /* JADX INFO: renamed from: d */
    public final int[] f8496d;

    /* JADX INFO: renamed from: e */
    public final int f8497e;

    /* JADX INFO: renamed from: f */
    public final long[] f8498f;

    /* JADX INFO: renamed from: g */
    public final int[] f8499g;

    /* JADX INFO: renamed from: h */
    public final long f8500h;

    public C3057p(C3054m c3054m, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        C1460d.m531j(iArr.length == jArr2.length);
        C1460d.m531j(jArr.length == jArr2.length);
        C1460d.m531j(iArr2.length == jArr2.length);
        this.f8493a = c3054m;
        this.f8495c = jArr;
        this.f8496d = iArr;
        this.f8497e = i;
        this.f8498f = jArr2;
        this.f8499g = iArr2;
        this.f8500h = j;
        this.f8494b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m3732a(long j) {
        for (int iM2997e = C2738e0.m2997e(this.f8498f, j, true, false); iM2997e >= 0; iM2997e--) {
            if ((this.f8499g[iM2997e] & 1) != 0) {
                return iM2997e;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public int m3733b(long j) {
        for (int iM2994b = C2738e0.m2994b(this.f8498f, j, true, false); iM2994b < this.f8498f.length; iM2994b++) {
            if ((this.f8499g[iM2994b] & 1) != 0) {
                return iM2994b;
            }
        }
        return -1;
    }
}
