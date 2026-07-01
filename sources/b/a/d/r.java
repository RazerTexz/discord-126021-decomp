package b.a.d;

import j0.k.Func1;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K, V1] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r<T, R, K, V1> implements Func1<K, V1> {
    public final /* synthetic */ s j;
    public final /* synthetic */ Map k;

    public r(s sVar, Map map) {
        this.j = sVar;
        this.k = map;
    }

    @Override // j0.k.Func1
    public final V1 call(K k) {
        return (V1) this.j.j.k.invoke(this.k.get(k));
    }
}
