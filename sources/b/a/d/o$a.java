package b.a.d;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$a<T> extends d0.z.d.o implements Function1<T, T> {
    public static final o$a j = new o$a();

    public o$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        d0.z.d.m.checkNotNull(t);
        return t;
    }
}
