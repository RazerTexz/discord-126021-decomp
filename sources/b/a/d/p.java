package b.a.d;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p<T, R, K> implements j0.k.b<K, Boolean> {
    public final /* synthetic */ Map j;

    public p(Map map) {
        this.j = map;
    }

    @Override // j0.k.b
    public Boolean call(Object obj) {
        return Boolean.valueOf(this.j.containsKey(obj));
    }
}
