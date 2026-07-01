package d0;

import java.util.Collection;

/* JADX INFO: compiled from: UIntArray.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements Collection<p>, d0.z.d.g0.a {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m106constructorimpl(int i) {
        return m107constructorimpl(new int[i]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m107constructorimpl(int[] iArr) {
        d0.z.d.m.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m108getpVg5ArA(int[] iArr, int i) {
        return p.m105constructorimpl(iArr[i]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m109getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m110setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}
