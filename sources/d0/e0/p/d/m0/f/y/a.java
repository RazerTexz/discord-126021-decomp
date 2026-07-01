package d0.e0.p.d.m0.f.y;

import d0.z.d.m;

/* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d0.e0.p.d.m0.f.z.a {
    public static final a$a f = new a$a(null);
    public static final a g = new a(1, 0, 7);

    static {
        new a(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(int... iArr) {
        m.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }

    public boolean isCompatible() {
        return a(g);
    }
}
