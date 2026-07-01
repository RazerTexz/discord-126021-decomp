package b.a.d;

import j0.k.Func1;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p<T, R, K> implements Func1<K, Boolean> {
    public final /* synthetic */ Map j;

    public p(Map map) {
        this.j = map;
    }

    @Override // j0.k.Func1
    public Boolean call(Object obj) {
        return Boolean.valueOf(this.j.containsKey(obj));
    }
}
