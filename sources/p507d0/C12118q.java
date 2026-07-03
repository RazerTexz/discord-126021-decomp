package p507d0;

import java.util.Collection;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.q */
/* JADX INFO: compiled from: UIntArray.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12118q implements Collection<C12117p>, InterfaceC12228a {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m11483constructorimpl(int i) {
        return m11484constructorimpl(new int[i]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m11484constructorimpl(int[] iArr) {
        C12238m.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m11485getpVg5ArA(int[] iArr, int i) {
        return C12117p.m11482constructorimpl(iArr[i]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m11486getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m11487setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}
