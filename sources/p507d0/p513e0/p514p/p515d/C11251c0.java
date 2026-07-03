package p507d0.p513e0.p514p.p515d;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.c0 */
/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11251c0 {

    /* JADX INFO: renamed from: d0.e0.p.d.c0$a */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class a<T> extends c<T> implements Function0<T> {

        /* JADX INFO: renamed from: k */
        public final Function0<T> f22322k;

        /* JADX INFO: renamed from: l */
        public volatile SoftReference<Object> f22323l;

        public a(T t, Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
            }
            this.f22323l = null;
            this.f22322k = function0;
            if (t != null) {
                this.f22323l = new SoftReference<>(t);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.C11251c0.c, kotlin.jvm.functions.Function0
        public T invoke() {
            T t;
            SoftReference<Object> softReference = this.f22323l;
            if (softReference == null || (t = (T) softReference.get()) == null) {
                T tInvoke = this.f22322k.invoke();
                this.f22323l = new SoftReference<>(tInvoke == null ? c.f22326j : tInvoke);
                return tInvoke;
            }
            if (t == c.f22326j) {
                return null;
            }
            return t;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.c0$b */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static class b<T> extends c<T> {

        /* JADX INFO: renamed from: k */
        public final Function0<T> f22324k;

        /* JADX INFO: renamed from: l */
        public volatile Object f22325l;

        public b(Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
            }
            this.f22325l = null;
            this.f22324k = function0;
        }

        @Override // p507d0.p513e0.p514p.p515d.C11251c0.c, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) this.f22325l;
            if (t != null) {
                if (t == c.f22326j) {
                    return null;
                }
                return t;
            }
            T tInvoke = this.f22324k.invoke();
            this.f22325l = tInvoke == null ? c.f22326j : tInvoke;
            return tInvoke;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.c0$c */
    /* JADX INFO: compiled from: ReflectProperties.java */
    public static abstract class c<T> {

        /* JADX INFO: renamed from: j */
        public static final Object f22326j = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.c0$c$a */
        /* JADX INFO: compiled from: ReflectProperties.java */
        public static class a {
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        public abstract T invoke();
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9332a(int i) {
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
        m9332a(0);
        throw null;
    }

    public static <T> a<T> lazySoft(T t, Function0<T> function0) {
        if (function0 != null) {
            return new a<>(t, function0);
        }
        m9332a(1);
        throw null;
    }

    public static <T> a<T> lazySoft(Function0<T> function0) {
        if (function0 != null) {
            return lazySoft(null, function0);
        }
        m9332a(2);
        throw null;
    }
}
