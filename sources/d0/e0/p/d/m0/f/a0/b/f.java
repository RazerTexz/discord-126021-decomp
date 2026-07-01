package d0.e0.p.d.m0.f.a0.b;

import d0.z.d.m;

/* JADX INFO: compiled from: JvmMetadataVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.f.z.a {
    public static final f f;
    public final boolean g;

    static {
        new f$a(null);
        f = new f(1, 4, 2);
        new f(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(int[] iArr, boolean z2) {
        m.checkNotNullParameter(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
        this.g = z2;
    }

    public boolean isCompatible() {
        boolean zA;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.g) {
            zA = a(f);
        } else {
            int major = getMajor();
            f fVar = f;
            zA = major == fVar.getMajor() && getMinor() <= fVar.getMinor() + 1;
        }
        return zA;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(int... iArr) {
        this(iArr, false);
        m.checkNotNullParameter(iArr, "numbers");
    }
}
