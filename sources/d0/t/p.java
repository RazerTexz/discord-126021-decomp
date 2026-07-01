package d0.t;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    public static final <T> Iterator<z<T>> withIndex(Iterator<? extends T> it) {
        d0.z.d.m.checkNotNullParameter(it, "$this$withIndex");
        return new b0(it);
    }
}
