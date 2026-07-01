package d0.u;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a<T> implements Comparator {
    public final /* synthetic */ Function1[] j;

    public a$a(Function1[] function1Arr) {
        this.j = function1Arr;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.access$compareValuesByImpl(t, t2, this.j);
    }
}
