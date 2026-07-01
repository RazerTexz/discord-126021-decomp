package d0.f0;

import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$e<T> implements Sequence<T> {
    public final /* synthetic */ Sequence a;

    public q$e(Sequence<? extends T> sequence) {
        this.a = sequence;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        List mutableList = q.toMutableList(this.a);
        d0.t.q.sort(mutableList);
        return mutableList.iterator();
    }
}
