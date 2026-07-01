package d0.f0;

import d0.t.AbstractIterator3;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T, K> extends AbstractIterator3<T> {
    public final HashSet<K> l;
    public final Iterator<T> m;
    public final Function1<T, K> n;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends T> it, Function1<? super T, ? extends K> function1) {
        Intrinsics3.checkNotNullParameter(it, "source");
        Intrinsics3.checkNotNullParameter(function1, "keySelector");
        this.m = it;
        this.n = function1;
        this.l = new HashSet<>();
    }

    @Override // d0.t.AbstractIterator3
    public void a() {
        while (this.m.hasNext()) {
            T next = this.m.next();
            if (this.l.add(this.n.invoke(next))) {
                b(next);
                return;
            }
        }
        this.j = 3;
    }
}
