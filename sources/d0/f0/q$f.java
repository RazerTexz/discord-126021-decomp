package d0.f0;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$f<T> implements Sequence<T> {
    public final /* synthetic */ Sequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f3574b;

    public q$f(Sequence<? extends T> sequence, Comparator comparator) {
        this.a = sequence;
        this.f3574b = comparator;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        List mutableList = q.toMutableList(this.a);
        d0.t.q.sortWith(mutableList, this.f3574b);
        return mutableList.iterator();
    }
}
