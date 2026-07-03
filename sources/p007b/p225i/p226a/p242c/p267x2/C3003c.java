package p007b.p225i.p226a.p242c.p267x2;

import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.c */
/* JADX INFO: compiled from: ChunkIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3003c implements InterfaceC3119t {

    /* JADX INFO: renamed from: a */
    public final int f8061a;

    /* JADX INFO: renamed from: b */
    public final int[] f8062b;

    /* JADX INFO: renamed from: c */
    public final long[] f8063c;

    /* JADX INFO: renamed from: d */
    public final long[] f8064d;

    /* JADX INFO: renamed from: e */
    public final long[] f8065e;

    /* JADX INFO: renamed from: f */
    public final long f8066f;

    public C3003c(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f8062b = iArr;
        this.f8063c = jArr;
        this.f8064d = jArr2;
        this.f8065e = jArr3;
        int length = iArr.length;
        this.f8061a = length;
        if (length > 0) {
            this.f8066f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f8066f = 0L;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: c */
    public boolean mo3619c() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: h */
    public InterfaceC3119t.a mo3620h(long j) {
        int iM2997e = C2738e0.m2997e(this.f8065e, j, true, true);
        long[] jArr = this.f8065e;
        long j2 = jArr[iM2997e];
        long[] jArr2 = this.f8063c;
        C3120u c3120u = new C3120u(j2, jArr2[iM2997e]);
        if (j2 >= j || iM2997e == this.f8061a - 1) {
            return new InterfaceC3119t.a(c3120u);
        }
        int i = iM2997e + 1;
        return new InterfaceC3119t.a(c3120u, new C3120u(jArr[i], jArr2[i]));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
    /* JADX INFO: renamed from: i */
    public long mo3621i() {
        return this.f8066f;
    }

    public String toString() {
        int i = this.f8061a;
        String string = Arrays.toString(this.f8062b);
        String string2 = Arrays.toString(this.f8063c);
        String string3 = Arrays.toString(this.f8065e);
        String string4 = Arrays.toString(this.f8064d);
        StringBuilder sb = new StringBuilder(C1643a.m841b(string4, C1643a.m841b(string3, C1643a.m841b(string2, C1643a.m841b(string, 71)))));
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(string);
        C1643a.m876s0(sb, ", offsets=", string2, ", timeUs=", string3);
        return C1643a.m823K(sb, ", durationsUs=", string4, ")");
    }
}
