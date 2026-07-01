package d0.e0.p.d;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.c0, reason: use source file name */
/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReflectProperties {

    /* JADX INFO: renamed from: d0.e0.p.d.c0$a */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class a<T> extends c<T> implements Function0<T> {
        public final Function0<T> k;
        public volatile SoftReference<Object> l;

        public a(T t, Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
            }
            this.l = null;
            this.k = function0;
            if (t != null) {
                this.l = new SoftReference<>(t);
            }
        }

        @Override // d0.e0.p.d.ReflectProperties.c, kotlin.jvm.functions.Function0
        public T invoke() {
            T t;
            SoftReference<Object> softReference = this.l;
            if (softReference == null || (t = (T) softReference.get()) == null) {
                T tInvoke = this.k.invoke();
                this.l = new SoftReference<>(tInvoke == null ? c.j : tInvoke);
                return tInvoke;
            }
            if (t == c.j) {
                return null;
            }
            return t;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.c0$b */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class b<T> extends c<T> {
        public final Function0<T> k;
        public volatile Object l;

        public b(Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
            }
            this.l = null;
            this.k = function0;
        }

        @Override // d0.e0.p.d.ReflectProperties.c, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) this.l;
            if (t != null) {
                if (t == c.j) {
                    return null;
                }
                return t;
            }
            T tInvoke = this.k.invoke();
            this.l = tInvoke == null ? c.j : tInvoke;
            return tInvoke;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.c0$c */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static abstract class c<T> {
        public static final Object j = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.c0$c$a */
        /* JADX INFO: compiled from: ReflectProperties.java */
        public static class a {
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        public abstract T invoke();
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> b<T> lazy(Function0<T> function0) {
        if (function0 != null) {
            return new b<>(function0);
        }
        a(0);
        throw null;
    }

    public static <T> a<T> lazySoft(T t, Function0<T> function0) {
        if (function0 != null) {
            return new a<>(t, function0);
        }
        a(1);
        throw null;
    }

    public static <T> a<T> lazySoft(Function0<T> function0) {
        if (function0 != null) {
            return lazySoft(null, function0);
        }
        a(2);
        throw null;
    }
}
