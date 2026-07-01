package d0.u;

import d0.z.d.m;

/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    public static final <T extends Comparable<? super T>> T maxOf(T t, T t2) {
        m.checkNotNullParameter(t, "a");
        m.checkNotNullParameter(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }
}
