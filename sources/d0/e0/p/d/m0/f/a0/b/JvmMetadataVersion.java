package d0.e0.p.d.m0.f.a0.b;

import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.f, reason: use source file name */
/* JADX INFO: compiled from: JvmMetadataVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final JvmMetadataVersion f;
    public final boolean g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.f$a */
    /* JADX INFO: compiled from: JvmMetadataVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f = new JvmMetadataVersion(1, 4, 2);
        new JvmMetadataVersion(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmMetadataVersion(int[] iArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(iArr, "versionArray");
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
            JvmMetadataVersion jvmMetadataVersion = f;
            zA = major == jvmMetadataVersion.getMajor() && getMinor() <= jvmMetadataVersion.getMinor() + 1;
        }
        return zA;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int... iArr) {
        this(iArr, false);
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
    }
}
