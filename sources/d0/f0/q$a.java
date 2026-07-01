package d0.f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a<T> implements Iterable<T>, d0.z.d.g0.a {
    public final /* synthetic */ Sequence j;

    public q$a(Sequence sequence) {
        this.j = sequence;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.j.iterator();
    }
}
