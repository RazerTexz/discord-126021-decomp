package d0.u;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.u.b, reason: use source file name */
/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _ComparisonsJvm extends a {
    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2) {
        Intrinsics3.checkNotNullParameter(t, "a");
        Intrinsics3.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }
}
