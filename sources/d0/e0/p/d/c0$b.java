package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0$b<T> extends c0$c<T> {
    public final Function0<T> k;
    public volatile Object l;

    public c0$b(Function0<T> function0) {
        if (function0 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }
        this.l = null;
        this.k = function0;
    }

    @Override // d0.e0.p.d.c0$c, kotlin.jvm.functions.Function0
    public T invoke() {
        T t = (T) this.l;
        if (t != null) {
            if (t == c0$c.j) {
                return null;
            }
            return t;
        }
        T tInvoke = this.k.invoke();
        this.l = tInvoke == null ? c0$c.j : tInvoke;
        return tInvoke;
    }
}
