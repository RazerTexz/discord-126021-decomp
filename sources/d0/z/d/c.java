package d0.z.d;

import java.util.Iterator;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        m.checkNotNullParameter(tArr, "array");
        return new b(tArr);
    }
}
