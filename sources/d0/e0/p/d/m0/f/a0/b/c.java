package d0.e0.p.d.m0.f.a0.b;

import d0.z.d.m;

/* JADX INFO: compiled from: JvmBytecodeBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d0.e0.p.d.m0.f.z.a {
    public static final c f;

    static {
        new c$a(null);
        f = new c(1, 0, 3);
        new c(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(int... iArr) {
        m.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }
}
