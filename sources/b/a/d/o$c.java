package b.a.d;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Observable$c;

/* JADX INFO: Add missing generic type declarations: [V, K, V1] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$c<T, R, K, V, V1> implements Observable$c<Map<K, ? extends V>, Map<K, ? extends V1>> {
    public final /* synthetic */ Collection j;
    public final /* synthetic */ Function1 k;

    public o$c(Collection collection, Function1 function1) {
        this.j = collection;
        this.k = function1;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        return ((Observable) obj).Y(new s(this)).r();
    }
}
