package d0.d0;

import d0.z.d.m;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a {
    public static <T extends Comparable<? super T>> boolean contains(a<T> aVar, T t) {
        m.checkNotNullParameter(t, "value");
        return t.compareTo(aVar.getStart()) >= 0 && t.compareTo(aVar.getEndInclusive()) <= 0;
    }

    public static <T extends Comparable<? super T>> boolean isEmpty(a<T> aVar) {
        return aVar.getStart().compareTo(aVar.getEndInclusive()) > 0;
    }
}
