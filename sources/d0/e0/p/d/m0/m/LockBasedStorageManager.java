package d0.e0.p.d.m0.m;

import b.d.b.a.outline;
import d0.e0.p.d.m0.m.locks4;
import d0.e0.p.d.m0.p.exceptionUtils;
import d0.g0.Strings4;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.f, reason: use source file name */
/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {
    public static final String a = Strings4.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StorageManager f3514b = new a("NO_LOCKS", f.a, locks3.f3513b);
    public final locks4 c;
    public final f d;
    public final String e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$a */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class a extends LockBasedStorageManager {
        public a(String str, f fVar, locks4 locks4Var) {
            super(str, fVar, locks4Var);
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 1 ? 3 : 2];
            if (i != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager
        public <K, V> o<V> c(String str, K k) {
            o<V> oVarFallThrough = o.fallThrough();
            if (oVarFallThrough != null) {
                return oVarFallThrough;
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$b */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public class b<T> extends j<T> {
        public final /* synthetic */ Object m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Object obj) {
            super(lockBasedStorageManager2, function0);
            this.m = obj;
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.h
        public o<T> c(boolean z2) {
            o<T> oVarValue = o.value(this.m);
            if (oVarValue != null) {
                return oVarValue;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$c */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public class c<T> extends k<T> {
        public final /* synthetic */ Function1 n;
        public final /* synthetic */ Function1 o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Function1 function1, Function1 function2) {
            super(lockBasedStorageManager2, function0);
            this.n = function1;
            this.o = function2;
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 2 ? 2 : 3];
            if (i != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.h
        public o<T> c(boolean z2) {
            Function1 function1 = this.n;
            if (function1 == null) {
                o<T> oVarC = super.c(z2);
                if (oVarC != null) {
                    return oVarC;
                }
                a(0);
                throw null;
            }
            o<T> oVarValue = o.value(function1.invoke(Boolean.valueOf(z2)));
            if (oVarValue != null) {
                return oVarValue;
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$d */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class d<K, V> extends e<K, V> implements storage<K, V> {
        public d(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, null);
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.e
        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                a(2);
                throw null;
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v != null) {
                return v;
            }
            a(3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$e */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class e<K, V> extends l<g<K, V>, V> implements storage2<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, new LockBasedStorageManager2());
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (concurrentMap != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 != null) {
                return invoke(new g(k, function0));
            }
            a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public interface f {
        public static final f a = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f$a */
        /* JADX INFO: compiled from: LockBasedStorageManager.java */
        public static class a implements f {
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
                }
                throw exceptionUtils.rethrow(th);
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$g */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class g<K, V> {
        public final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<? extends V> f3515b;

        public g(K k, Function0<? extends V> function0) {
            this.a = k;
            this.f3515b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && g.class == obj.getClass() && this.a.equals(((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$h */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class h<T> implements storage6<T> {
        public final LockBasedStorageManager j;
        public final Function0<? extends T> k;
        public volatile Object l;

        public h(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (function0 == null) {
                a(1);
                throw null;
            }
            this.l = n.NOT_COMPUTED;
            this.j = lockBasedStorageManager;
            this.k = function0;
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public void b(T t) {
        }

        public o<T> c(boolean z2) {
            o<T> oVarC = this.j.c("in a lazy value", null);
            if (oVarC != null) {
                return oVarC;
            }
            a(2);
            throw null;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0049 A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x004e A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T tInvoke;
            o<T> oVarC;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.l;
            if (!(obj instanceof n)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.j.c.lock();
            try {
                Object obj2 = this.l;
                if (!(obj2 instanceof n)) {
                    tInvoke = (T) WrappedValues.unescapeThrowable(obj2);
                } else if (obj2 == nVar2) {
                    this.l = nVar;
                    o<T> oVarC2 = c(true);
                    if (!oVarC2.isFallThrough()) {
                        tInvoke = oVarC2.getValue();
                    } else if (obj2 == nVar) {
                        oVarC = c(false);
                        if (oVarC.isFallThrough()) {
                            this.l = nVar2;
                            try {
                                tInvoke = this.k.invoke();
                                b(tInvoke);
                                this.l = tInvoke;
                            } catch (Throwable th) {
                                if (exceptionUtils.isProcessCanceledException(th)) {
                                    this.l = n.NOT_COMPUTED;
                                    throw th;
                                }
                                if (this.l == nVar2) {
                                    this.l = WrappedValues.escapeThrowable(th);
                                }
                                throw ((f.a) this.j.d).handleException(th);
                            }
                        } else {
                            tInvoke = oVarC.getValue();
                        }
                    } else {
                        this.l = nVar2;
                        tInvoke = this.k.invoke();
                        b(tInvoke);
                        this.l = tInvoke;
                    }
                } else if (obj2 == nVar) {
                    oVarC = c(false);
                    if (oVarC.isFallThrough()) {
                        tInvoke = oVarC.getValue();
                    } else {
                        this.l = nVar2;
                        tInvoke = this.k.invoke();
                        b(tInvoke);
                        this.l = tInvoke;
                    }
                } else {
                    this.l = nVar2;
                    tInvoke = this.k.invoke();
                    b(tInvoke);
                    this.l = tInvoke;
                }
                this.j.c.unlock();
                return tInvoke;
            } catch (Throwable th2) {
                this.j.c.unlock();
                throw th2;
            }
        }

        public boolean isComputed() {
            return (this.l == n.NOT_COMPUTED || this.l == n.COMPUTING) ? false : true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$i */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class i<T> extends h<T> {
        public volatile SingleThreadValue<T> m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (function0 == null) {
                a(1);
                throw null;
            }
            this.m = null;
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.h
        public final void b(T t) {
            this.m = new SingleThreadValue<>(t);
            try {
                c cVar = (c) this;
                if (t == null) {
                    c.a(2);
                    throw null;
                }
                cVar.o.invoke(t);
                this.m = null;
            } catch (Throwable th) {
                this.m = null;
                throw th;
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.m;
            return (singleThreadValue == null || !singleThreadValue.hasValue()) ? (T) super.invoke() : singleThreadValue.getValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$j */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class j<T> extends h<T> implements storage5<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$k */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class k<T> extends i<T> implements storage5<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                a(1);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.i, d0.e0.p.d.m0.m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$l */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class l<K, V> implements storage4<K, V> {
        public final LockBasedStorageManager j;
        public final ConcurrentMap<K, Object> k;
        public final Function1<? super K, ? extends V> l;

        public l(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (concurrentMap == null) {
                a(1);
                throw null;
            }
            if (function1 == null) {
                a(2);
                throw null;
            }
            this.j = lockBasedStorageManager;
            this.k = concurrentMap;
            this.l = function1;
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public final AssertionError b(K k, Object obj) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.j);
            LockBasedStorageManager.d(assertionError);
            return assertionError;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0041 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x0049 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x004f A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0054 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0058 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x005a A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x007d  */
        /* JADX WARN: Code duplicated, block: B:35:0x0085 A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #1 {all -> 0x008a, blocks: (B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:55:0x0066, outer: #0 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V vInvoke;
            Object objPut;
            V value;
            o<V> oVarC;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.k.get(k);
            if (obj != null && obj != nVar2) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.j.c.lock();
            try {
                Object obj2 = this.k.get(k);
                AssertionError assertionErrorB = null;
                if (obj2 == nVar2) {
                    o<V> oVarC2 = this.j.c("", k);
                    if (oVarC2 == null) {
                        a(3);
                        throw null;
                    }
                    if (oVarC2.isFallThrough()) {
                        obj2 = nVar;
                        if (obj2 != nVar) {
                            oVarC = this.j.c("", k);
                            if (oVarC != null) {
                                a(3);
                                throw null;
                            }
                            if (!oVarC.isFallThrough()) {
                                value = oVarC.getValue();
                            } else {
                                if (obj2 != null) {
                                    this.k.put(k, nVar2);
                                    vInvoke = this.l.invoke(k);
                                    objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                                    if (objPut == nVar2) {
                                        this.j.c.unlock();
                                        return vInvoke;
                                    }
                                    assertionErrorB = b(k, objPut);
                                    throw assertionErrorB;
                                }
                                value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                            }
                        } else {
                            if (obj2 != null) {
                                this.k.put(k, nVar2);
                                vInvoke = this.l.invoke(k);
                                objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                                if (objPut == nVar2) {
                                    this.j.c.unlock();
                                    return vInvoke;
                                }
                                assertionErrorB = b(k, objPut);
                                throw assertionErrorB;
                            }
                            value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                        }
                    } else {
                        value = oVarC2.getValue();
                    }
                } else if (obj2 != nVar) {
                    oVarC = this.j.c("", k);
                    if (oVarC != null) {
                        a(3);
                        throw null;
                    }
                    if (!oVarC.isFallThrough()) {
                        value = oVarC.getValue();
                    } else {
                        if (obj2 != null) {
                            this.k.put(k, nVar2);
                            vInvoke = this.l.invoke(k);
                            objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == nVar2) {
                                this.j.c.unlock();
                                return vInvoke;
                            }
                            assertionErrorB = b(k, objPut);
                            throw assertionErrorB;
                        }
                        value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    }
                } else {
                    if (obj2 != null) {
                        try {
                            this.k.put(k, nVar2);
                            vInvoke = this.l.invoke(k);
                            objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == nVar2) {
                                this.j.c.unlock();
                                return vInvoke;
                            }
                            assertionErrorB = b(k, objPut);
                            throw assertionErrorB;
                        } catch (Throwable th) {
                            if (exceptionUtils.isProcessCanceledException(th)) {
                                this.k.remove(k);
                                throw th;
                            }
                            if (th == assertionErrorB) {
                                throw ((f.a) this.j.d).handleException(th);
                            }
                            Object objPut2 = this.k.put(k, WrappedValues.escapeThrowable(th));
                            if (objPut2 != nVar2) {
                                throw b(k, objPut2);
                            }
                            throw ((f.a) this.j.d).handleException(th);
                        }
                    }
                    value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                }
                this.j.c.unlock();
                return value;
            } catch (Throwable th2) {
                this.j.c.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$m */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class m<K, V> extends l<K, V> implements storage3<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                a(0);
                throw null;
            }
            if (concurrentMap == null) {
                a(1);
                throw null;
            }
            if (function1 != null) {
            } else {
                a(2);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.m.LockBasedStorageManager.l, kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v != null) {
                return v;
            }
            a(3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$n */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$o */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class o<T> {
        public final T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3516b;

        public o(T t, boolean z2) {
            this.a = t;
            this.f3516b = z2;
        }

        public static <T> o<T> fallThrough() {
            return new o<>(null, true);
        }

        public static <T> o<T> value(T t) {
            return new o<>(t, false);
        }

        public T getValue() {
            return this.a;
        }

        public boolean isFallThrough() {
            return this.f3516b;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.a);
        }
    }

    public LockBasedStorageManager(String str, f fVar, locks4 locks4Var) {
        if (str == null) {
            a(4);
            throw null;
        }
        if (fVar == null) {
            a(5);
            throw null;
        }
        if (locks4Var == null) {
            a(6);
            throw null;
        }
        this.c = locks4Var;
        this.d = fVar;
        this.e = str;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? 2 : 3];
        if (i2 == 1 || i2 == 3 || i2 == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i2 != 6) {
            switch (i2) {
                case 8:
                    objArr[0] = "exceptionHandlingStrategy";
                    break;
                case 9:
                case 11:
                case 14:
                case 16:
                case 19:
                case 21:
                    objArr[0] = "compute";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 12:
                case 17:
                case 25:
                case 27:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 15:
                case 18:
                case 22:
                    objArr[0] = "map";
                    break;
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                    objArr[0] = "computable";
                    break;
                case 29:
                case 33:
                    objArr[0] = "postCompute";
                    break;
                case 35:
                    objArr[0] = "source";
                    break;
                case 36:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        } else {
            objArr[0] = "lock";
        }
        if (i2 == 10 || i2 == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i2 == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i2 != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case 13:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case 24:
            case 25:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 10 && i2 != 13 && i2 != 20 && i2 != 37) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static <K> ConcurrentMap<K, Object> b() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    public static <T extends Throwable> T d(T t) {
        if (t == null) {
            a(36);
            throw null;
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (!stackTrace[i3].getClassName().startsWith(a)) {
                i2 = i3;
                break;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return t;
    }

    public <K, V> o<V> c(String str, K k2) {
        StringBuilder sbX = outline.X("Recursion detected ", str);
        sbX.append(k2 == null ? "" : outline.v("on input: ", k2));
        sbX.append(" under ");
        sbX.append(this);
        AssertionError assertionError = new AssertionError(sbX.toString());
        d(assertionError);
        throw assertionError;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <T> T compute(Function0<? extends T> function0) {
        if (function0 == null) {
            a(34);
            throw null;
        }
        this.c.lock();
        try {
            T tInvoke = function0.invoke();
            this.c.unlock();
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw ((f.a) this.d).handleException(th);
            } catch (Throwable th2) {
                this.c.unlock();
                throw th2;
            }
        }
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <K, V> storage<K, V> createCacheWithNotNullValues() {
        return new d(this, b(), null);
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <K, V> storage2<K, V> createCacheWithNullableValues() {
        return new e(this, b(), null);
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <T> storage5<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new j(this, function0);
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <T> storage5<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2) {
        if (function0 == null) {
            a(28);
            throw null;
        }
        if (function2 != null) {
            return new c(this, this, function0, function1, function2);
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <K, V> storage3<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(9);
            throw null;
        }
        storage3<K, V> storage3VarCreateMemoizedFunction = createMemoizedFunction(function1, b());
        if (storage3VarCreateMemoizedFunction != null) {
            return storage3VarCreateMemoizedFunction;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <K, V> storage4<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(19);
            throw null;
        }
        storage4<K, V> storage4VarCreateMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, b());
        if (storage4VarCreateMemoizedFunctionWithNullableValues != null) {
            return storage4VarCreateMemoizedFunctionWithNullableValues;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <T> storage6<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new h(this, function0);
        }
        a(30);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.StorageManager
    public <T> storage5<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t) {
        if (function0 == null) {
            a(26);
            throw null;
        }
        if (t != null) {
            return new b(this, this, function0, t);
        }
        a(27);
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return outline.J(sb, this.e, ")");
    }

    public <K, V> storage3<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(14);
            throw null;
        }
        if (concurrentMap != null) {
            return new m(this, concurrentMap, function1);
        }
        a(15);
        throw null;
    }

    public <K, V> storage4<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(21);
            throw null;
        }
        if (concurrentMap != null) {
            return new l(this, concurrentMap, function1);
        }
        a(22);
        throw null;
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LockBasedStorageManager(String str, Runnable runnable, Function1<InterruptedException, Unit> function1) {
        f fVar = f.a;
        int i2 = locks4.a;
        this(str, fVar, locks4.a.a.simpleLock(runnable, function1));
    }
}
