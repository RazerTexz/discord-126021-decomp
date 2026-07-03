package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.p */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12151p extends C12149o {
    public static final <T> Iterator<C12168z<T>> withIndex(Iterator<? extends T> it) {
        C12238m.checkNotNullParameter(it, "$this$withIndex");
        return new C12124b0(it);
    }
}
