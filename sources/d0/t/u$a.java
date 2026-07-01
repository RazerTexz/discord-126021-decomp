package d0.t;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$a<T> implements Sequence<T> {
    public final /* synthetic */ Iterable a;

    public u$a(Iterable iterable) {
        this.a = iterable;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return this.a.iterator();
    }
}
