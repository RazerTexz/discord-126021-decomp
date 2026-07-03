package p507d0.p582u;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.u.b */
/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12170b extends C12169a {
    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2) {
        C12238m.checkNotNullParameter(t, "a");
        C12238m.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }
}
