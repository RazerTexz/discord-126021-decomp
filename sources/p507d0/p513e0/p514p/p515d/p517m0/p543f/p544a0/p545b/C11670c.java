package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.c */
/* JADX INFO: compiled from: JvmBytecodeBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11670c extends AbstractC11702a {

    /* JADX INFO: renamed from: f */
    public static final C11670c f23703f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.c$a */
    /* JADX INFO: compiled from: JvmBytecodeBinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f23703f = new C11670c(1, 0, 3);
        new C11670c(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11670c(int... iArr) {
        C12238m.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }
}
