package b.i.e.q.r;

import b.i.e.k;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1864b;
    public final k[] c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.f1864b = iArr;
        float f = i4;
        this.c = new k[]{new k(i2, f), new k(i3, f)};
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
