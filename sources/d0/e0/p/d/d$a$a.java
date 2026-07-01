package d0.e0.p.d;

import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$a<T> implements Comparator<T> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Method method = (Method) t;
        d0.z.d.m.checkNotNullExpressionValue(method, "it");
        String name = method.getName();
        Method method2 = (Method) t2;
        d0.z.d.m.checkNotNullExpressionValue(method2, "it");
        return d0.u.a.compareValues(name, method2.getName());
    }
}
