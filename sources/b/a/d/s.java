package b.a.d;

import java.util.Map;
import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [V, K, V1] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s<T, R, K, V, V1> implements j0.k.b<Map<K, ? extends V>, Observable<? extends Map<K, V1>>> {
    public final /* synthetic */ o$c j;

    public s(o$c o_c) {
        this.j = o_c;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Map map = (Map) obj;
        return Observable.B(this.j.j).y(new p(map)).g0(q.j, new r(this, map));
    }
}
