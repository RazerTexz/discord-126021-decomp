package p007b.p225i.p414e.p426q.p427r;

import p007b.p225i.p414e.C4956k;

/* JADX INFO: renamed from: b.i.e.q.r.c */
/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5006c {

    /* JADX INFO: renamed from: a */
    public final int f13407a;

    /* JADX INFO: renamed from: b */
    public final int[] f13408b;

    /* JADX INFO: renamed from: c */
    public final C4956k[] f13409c;

    public C5006c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f13407a = i;
        this.f13408b = iArr;
        float f = i4;
        this.f13409c = new C4956k[]{new C4956k(i2, f), new C4956k(i3, f)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5006c) && this.f13407a == ((C5006c) obj).f13407a;
    }

    public int hashCode() {
        return this.f13407a;
    }
}
