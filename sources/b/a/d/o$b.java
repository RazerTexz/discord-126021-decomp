package b.a.d;

import java.util.Map;
import rx.Observable$c;

/* JADX INFO: Add missing generic type declarations: [V, K, V1] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$b<T, R, K, V, V1> implements Observable$c<Map<K, ? extends V>, Map<K, ? extends V1>> {
    public static final o$b j = new o$b();

    @Override // j0.k.b
    public Object call(Object obj) {
        return new j0.l.e.k(d0.t.h0.emptyMap());
    }
}
