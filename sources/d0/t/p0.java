package d0.t;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    public static final void checkWindowSizeStep(int i, int i2) {
        String strR;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            strR = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            strR = b.d.b.a.a.r("size ", i, " must be greater than zero.");
        }
        throw new IllegalArgumentException(strR.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? v.j : d0.f0.l.iterator(new p0$a(i, i2, it, z3, z2, null));
    }
}
