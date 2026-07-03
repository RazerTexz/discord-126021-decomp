package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.f */
/* JADX INFO: compiled from: JvmMetadataVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11673f extends AbstractC11702a {

    /* JADX INFO: renamed from: f */
    public static final C11673f f23711f;

    /* JADX INFO: renamed from: g */
    public final boolean f23712g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.f$a */
    /* JADX INFO: compiled from: JvmMetadataVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f23711f = new C11673f(1, 4, 2);
        new C11673f(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11673f(int[] iArr, boolean z2) {
        C12238m.checkNotNullParameter(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
        this.f23712g = z2;
    }

    public boolean isCompatible() {
        boolean zM9813a;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.f23712g) {
            zM9813a = m9813a(f23711f);
        } else {
            int major = getMajor();
            C11673f c11673f = f23711f;
            zM9813a = major == c11673f.getMajor() && getMinor() <= c11673f.getMinor() + 1;
        }
        return zM9813a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11673f(int... iArr) {
        this(iArr, false);
        C12238m.checkNotNullParameter(iArr, "numbers");
    }
}
