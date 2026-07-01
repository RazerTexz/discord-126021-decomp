package d0.d0;

import java.lang.Comparable;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndInclusive();

    T getStart();
}
