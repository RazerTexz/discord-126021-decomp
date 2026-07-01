package d0.e0.p.d;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0$a<T> extends c0$c<T> implements Function0<T> {
    public final Function0<T> k;
    public volatile SoftReference<Object> l;

    public c0$a(T t, Function0<T> function0) {
        if (function0 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }
        this.l = null;
        this.k = function0;
        if (t != null) {
            this.l = new SoftReference<>(t);
        }
    }

    @Override // d0.e0.p.d.c0$c, kotlin.jvm.functions.Function0
    public T invoke() {
        T t;
        SoftReference<Object> softReference = this.l;
        if (softReference == null || (t = (T) softReference.get()) == null) {
            T tInvoke = this.k.invoke();
            this.l = new SoftReference<>(tInvoke == null ? c0$c.j : tInvoke);
            return tInvoke;
        }
        if (t == c0$c.j) {
            return null;
        }
        return t;
    }
}
