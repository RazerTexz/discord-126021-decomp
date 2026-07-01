package d0.t;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b<T> implements Sequence<T> {
    public final /* synthetic */ Object[] a;

    public k$b(Object[] objArr) {
        this.a = objArr;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return d0.z.d.c.iterator(this.a);
    }
}
