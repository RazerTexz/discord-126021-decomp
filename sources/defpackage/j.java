package defpackage;

import j0.k.Func1;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T, R> implements Func1<Map<Long, ? extends Integer>, Set<? extends Long>> {
    public static final j j = new j(0);
    public static final j k = new j(1);
    public final /* synthetic */ int l;

    public j(int i) {
        this.l = i;
    }

    @Override // j0.k.Func1
    public final Set<? extends Long> call(Map<Long, ? extends Integer> map) {
        int i = this.l;
        if (i == 0) {
            return map.keySet();
        }
        if (i == 1) {
            return map.keySet();
        }
        throw null;
    }
}
