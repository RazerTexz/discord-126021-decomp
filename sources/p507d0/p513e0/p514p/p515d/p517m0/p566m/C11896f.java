package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11902l;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12035c;
import p507d0.p579g0.C12106w;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.f */
/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11896f implements InterfaceC11905o {

    /* JADX INFO: renamed from: a */
    public static final String f24709a = C12106w.substringBeforeLast(C11896f.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: b */
    public static final InterfaceC11905o f24710b = new a("NO_LOCKS", f.f24717a, C11895e.f24708b);

    /* JADX INFO: renamed from: c */
    public final InterfaceC11902l f24711c;

    /* JADX INFO: renamed from: d */
    public final f f24712d;

    /* JADX INFO: renamed from: e */
    public final String f24713e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$a */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class a extends C11896f {
        public a(String str, f fVar, InterfaceC11902l interfaceC11902l) {
            super(str, fVar, interfaceC11902l);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9981a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f
        /* JADX INFO: renamed from: c */
        public <K, V> o<V> mo9980c(String str, K k) {
            o<V> oVarFallThrough = o.fallThrough();
            if (oVarFallThrough != null) {
                return oVarFallThrough;
            }
            m9981a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$b */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public class b<T> extends j<T> {

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ Object f24714m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11896f c11896f, C11896f c11896f2, Function0 function0, Object obj) {
            super(c11896f2, function0);
            this.f24714m = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h
        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            o<T> oVarValue = o.value(this.f24714m);
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

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ Function1 f24715n;

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ Function1 f24716o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C11896f c11896f, C11896f c11896f2, Function0 function0, Function1 function1, Function1 function2) {
            super(c11896f2, function0);
            this.f24715n = function1;
            this.f24716o = function2;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9983a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h
        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            Function1 function1 = this.f24715n;
            if (function1 == null) {
                o<T> oVarMo9982c = super.mo9982c(z2);
                if (oVarMo9982c != null) {
                    return oVarMo9982c;
                }
                m9983a(0);
                throw null;
            }
            o<T> oVarValue = o.value(function1.invoke(Boolean.valueOf(z2)));
            if (oVarValue != null) {
                return oVarValue;
            }
            m9983a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$d */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class d<K, V> extends e<K, V> implements InterfaceC11891a<K, V> {
        public d(C11896f c11896f, ConcurrentMap concurrentMap, a aVar) {
            super(c11896f, concurrentMap, null);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9984a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.e
        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                m9984a(2);
                throw null;
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v != null) {
                return v;
            }
            m9984a(3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$e */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class e<K, V> extends l<g<K, V>, V> implements InterfaceC11892b<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C11896f c11896f, ConcurrentMap concurrentMap, a aVar) {
            super(c11896f, concurrentMap, new C11897g());
            if (c11896f == null) {
                m9985a(0);
                throw null;
            }
            if (concurrentMap != null) {
            } else {
                m9985a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9985a(int i) {
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
            m9985a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public interface f {

        /* JADX INFO: renamed from: a */
        public static final f f24717a = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f$a */
        /* JADX INFO: compiled from: LockBasedStorageManager.java */
        public static class a implements f {
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
                }
                throw C12035c.rethrow(th);
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$g */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class g<K, V> {

        /* JADX INFO: renamed from: a */
        public final K f24718a;

        /* JADX INFO: renamed from: b */
        public final Function0<? extends V> f24719b;

        public g(K k, Function0<? extends V> function0) {
            this.f24718a = k;
            this.f24719b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && g.class == obj.getClass() && this.f24718a.equals(((g) obj).f24718a);
        }

        public int hashCode() {
            return this.f24718a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$h */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class h<T> implements InterfaceC11901k<T> {

        /* JADX INFO: renamed from: j */
        public final C11896f f24720j;

        /* JADX INFO: renamed from: k */
        public final Function0<? extends T> f24721k;

        /* JADX INFO: renamed from: l */
        public volatile Object f24722l;

        public h(C11896f c11896f, Function0<? extends T> function0) {
            if (c11896f == null) {
                m9986a(0);
                throw null;
            }
            if (function0 == null) {
                m9986a(1);
                throw null;
            }
            this.f24722l = n.NOT_COMPUTED;
            this.f24720j = c11896f;
            this.f24721k = function0;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9986a(int i) {
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

        /* JADX INFO: renamed from: b */
        public void mo9987b(T t) {
        }

        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            o<T> oVarMo9980c = this.f24720j.mo9980c("in a lazy value", null);
            if (oVarMo9980c != null) {
                return oVarMo9980c;
            }
            m9986a(2);
            throw null;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0049 A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x004e A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T tInvoke;
            o<T> oVarMo9982c;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.f24722l;
            if (!(obj instanceof n)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.f24720j.f24711c.lock();
            try {
                Object obj2 = this.f24722l;
                if (!(obj2 instanceof n)) {
                    tInvoke = (T) WrappedValues.unescapeThrowable(obj2);
                } else if (obj2 == nVar2) {
                    this.f24722l = nVar;
                    o<T> oVarMo9982c2 = mo9982c(true);
                    if (!oVarMo9982c2.isFallThrough()) {
                        tInvoke = oVarMo9982c2.getValue();
                    } else if (obj2 == nVar) {
                        oVarMo9982c = mo9982c(false);
                        if (oVarMo9982c.isFallThrough()) {
                            this.f24722l = nVar2;
                            try {
                                tInvoke = this.f24721k.invoke();
                                mo9987b(tInvoke);
                                this.f24722l = tInvoke;
                            } catch (Throwable th) {
                                if (C12035c.isProcessCanceledException(th)) {
                                    this.f24722l = n.NOT_COMPUTED;
                                    throw th;
                                }
                                if (this.f24722l == nVar2) {
                                    this.f24722l = WrappedValues.escapeThrowable(th);
                                }
                                throw ((f.a) this.f24720j.f24712d).handleException(th);
                            }
                        } else {
                            tInvoke = oVarMo9982c.getValue();
                        }
                    } else {
                        this.f24722l = nVar2;
                        tInvoke = this.f24721k.invoke();
                        mo9987b(tInvoke);
                        this.f24722l = tInvoke;
                    }
                } else if (obj2 == nVar) {
                    oVarMo9982c = mo9982c(false);
                    if (oVarMo9982c.isFallThrough()) {
                        tInvoke = oVarMo9982c.getValue();
                    } else {
                        this.f24722l = nVar2;
                        tInvoke = this.f24721k.invoke();
                        mo9987b(tInvoke);
                        this.f24722l = tInvoke;
                    }
                } else {
                    this.f24722l = nVar2;
                    tInvoke = this.f24721k.invoke();
                    mo9987b(tInvoke);
                    this.f24722l = tInvoke;
                }
                this.f24720j.f24711c.unlock();
                return tInvoke;
            } catch (Throwable th2) {
                this.f24720j.f24711c.unlock();
                throw th2;
            }
        }

        public boolean isComputed() {
            return (this.f24722l == n.NOT_COMPUTED || this.f24722l == n.COMPUTING) ? false : true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$i */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class i<T> extends h<T> {

        /* JADX INFO: renamed from: m */
        public volatile C11903m<T> f24723m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(C11896f c11896f, Function0<? extends T> function0) {
            super(c11896f, function0);
            if (c11896f == null) {
                m9988a(0);
                throw null;
            }
            if (function0 == null) {
                m9988a(1);
                throw null;
            }
            this.f24723m = null;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9988a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h
        /* JADX INFO: renamed from: b */
        public final void mo9987b(T t) {
            this.f24723m = new C11903m<>(t);
            try {
                c cVar = (c) this;
                if (t == null) {
                    c.m9983a(2);
                    throw null;
                }
                cVar.f24716o.invoke(t);
                this.f24723m = null;
            } catch (Throwable th) {
                this.f24723m = null;
                throw th;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            C11903m<T> c11903m = this.f24723m;
            return (c11903m == null || !c11903m.hasValue()) ? (T) super.invoke() : c11903m.getValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$j */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class j<T> extends h<T> implements InterfaceC11900j<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(C11896f c11896f, Function0<? extends T> function0) {
            super(c11896f, function0);
            if (c11896f == null) {
                m9989a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                m9989a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9989a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            m9989a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$k */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class k<T> extends i<T> implements InterfaceC11900j<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(C11896f c11896f, Function0<? extends T> function0) {
            super(c11896f, function0);
            if (c11896f == null) {
                m9990a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                m9990a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9990a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.i, p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            m9990a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$l */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class l<K, V> implements InterfaceC11899i<K, V> {

        /* JADX INFO: renamed from: j */
        public final C11896f f24724j;

        /* JADX INFO: renamed from: k */
        public final ConcurrentMap<K, Object> f24725k;

        /* JADX INFO: renamed from: l */
        public final Function1<? super K, ? extends V> f24726l;

        public l(C11896f c11896f, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (c11896f == null) {
                m9991a(0);
                throw null;
            }
            if (concurrentMap == null) {
                m9991a(1);
                throw null;
            }
            if (function1 == null) {
                m9991a(2);
                throw null;
            }
            this.f24724j = c11896f;
            this.f24725k = concurrentMap;
            this.f24726l = function1;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9991a(int i) {
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

        /* JADX INFO: renamed from: b */
        public final AssertionError m9992b(K k, Object obj) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.f24724j);
            C11896f.m9979d(assertionError);
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
            o<V> oVarMo9980c;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.f24725k.get(k);
            if (obj != null && obj != nVar2) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.f24724j.f24711c.lock();
            try {
                Object obj2 = this.f24725k.get(k);
                AssertionError assertionErrorM9992b = null;
                if (obj2 == nVar2) {
                    o<V> oVarMo9980c2 = this.f24724j.mo9980c("", k);
                    if (oVarMo9980c2 == null) {
                        m9991a(3);
                        throw null;
                    }
                    if (oVarMo9980c2.isFallThrough()) {
                        obj2 = nVar;
                        if (obj2 != nVar) {
                            oVarMo9980c = this.f24724j.mo9980c("", k);
                            if (oVarMo9980c != null) {
                                m9991a(3);
                                throw null;
                            }
                            if (!oVarMo9980c.isFallThrough()) {
                                value = oVarMo9980c.getValue();
                            } else {
                                if (obj2 != null) {
                                    this.f24725k.put(k, nVar2);
                                    vInvoke = this.f24726l.invoke(k);
                                    objPut = this.f24725k.put(k, WrappedValues.escapeNull(vInvoke));
                                    if (objPut == nVar2) {
                                        this.f24724j.f24711c.unlock();
                                        return vInvoke;
                                    }
                                    assertionErrorM9992b = m9992b(k, objPut);
                                    throw assertionErrorM9992b;
                                }
                                value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                            }
                        } else {
                            if (obj2 != null) {
                                this.f24725k.put(k, nVar2);
                                vInvoke = this.f24726l.invoke(k);
                                objPut = this.f24725k.put(k, WrappedValues.escapeNull(vInvoke));
                                if (objPut == nVar2) {
                                    this.f24724j.f24711c.unlock();
                                    return vInvoke;
                                }
                                assertionErrorM9992b = m9992b(k, objPut);
                                throw assertionErrorM9992b;
                            }
                            value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                        }
                    } else {
                        value = oVarMo9980c2.getValue();
                    }
                } else if (obj2 != nVar) {
                    oVarMo9980c = this.f24724j.mo9980c("", k);
                    if (oVarMo9980c != null) {
                        m9991a(3);
                        throw null;
                    }
                    if (!oVarMo9980c.isFallThrough()) {
                        value = oVarMo9980c.getValue();
                    } else {
                        if (obj2 != null) {
                            this.f24725k.put(k, nVar2);
                            vInvoke = this.f24726l.invoke(k);
                            objPut = this.f24725k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == nVar2) {
                                this.f24724j.f24711c.unlock();
                                return vInvoke;
                            }
                            assertionErrorM9992b = m9992b(k, objPut);
                            throw assertionErrorM9992b;
                        }
                        value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    }
                } else {
                    if (obj2 != null) {
                        try {
                            this.f24725k.put(k, nVar2);
                            vInvoke = this.f24726l.invoke(k);
                            objPut = this.f24725k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == nVar2) {
                                this.f24724j.f24711c.unlock();
                                return vInvoke;
                            }
                            assertionErrorM9992b = m9992b(k, objPut);
                            throw assertionErrorM9992b;
                        } catch (Throwable th) {
                            if (C12035c.isProcessCanceledException(th)) {
                                this.f24725k.remove(k);
                                throw th;
                            }
                            if (th == assertionErrorM9992b) {
                                throw ((f.a) this.f24724j.f24712d).handleException(th);
                            }
                            Object objPut2 = this.f24725k.put(k, WrappedValues.escapeThrowable(th));
                            if (objPut2 != nVar2) {
                                throw m9992b(k, objPut2);
                            }
                            throw ((f.a) this.f24724j.f24712d).handleException(th);
                        }
                    }
                    value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                }
                this.f24724j.f24711c.unlock();
                return value;
            } catch (Throwable th2) {
                this.f24724j.f24711c.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$m */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class m<K, V> extends l<K, V> implements InterfaceC11898h<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(C11896f c11896f, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(c11896f, concurrentMap, function1);
            if (c11896f == null) {
                m9993a(0);
                throw null;
            }
            if (concurrentMap == null) {
                m9993a(1);
                throw null;
            }
            if (function1 != null) {
            } else {
                m9993a(2);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9993a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f.l, kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v != null) {
                return v;
            }
            m9993a(3);
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

        /* JADX INFO: renamed from: a */
        public final T f24731a;

        /* JADX INFO: renamed from: b */
        public final boolean f24732b;

        public o(T t, boolean z2) {
            this.f24731a = t;
            this.f24732b = z2;
        }

        public static <T> o<T> fallThrough() {
            return new o<>(null, true);
        }

        public static <T> o<T> value(T t) {
            return new o<>(t, false);
        }

        public T getValue() {
            return this.f24731a;
        }

        public boolean isFallThrough() {
            return this.f24732b;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.f24731a);
        }
    }

    public C11896f(String str, f fVar, InterfaceC11902l interfaceC11902l) {
        if (str == null) {
            m9977a(4);
            throw null;
        }
        if (fVar == null) {
            m9977a(5);
            throw null;
        }
        if (interfaceC11902l == null) {
            m9977a(6);
            throw null;
        }
        this.f24711c = interfaceC11902l;
        this.f24712d = fVar;
        this.f24713e = str;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9977a(int i2) {
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

    /* JADX INFO: renamed from: b */
    public static <K> ConcurrentMap<K, Object> m9978b() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: renamed from: d */
    public static <T extends Throwable> T m9979d(T t) {
        if (t == null) {
            m9977a(36);
            throw null;
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (!stackTrace[i3].getClassName().startsWith(f24709a)) {
                i2 = i3;
                break;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return t;
    }

    /* JADX INFO: renamed from: c */
    public <K, V> o<V> mo9980c(String str, K k2) {
        StringBuilder sbM836X = C1643a.m836X("Recursion detected ", str);
        sbM836X.append(k2 == null ? "" : C1643a.m881v("on input: ", k2));
        sbM836X.append(" under ");
        sbM836X.append(this);
        AssertionError assertionError = new AssertionError(sbM836X.toString());
        m9979d(assertionError);
        throw assertionError;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <T> T compute(Function0<? extends T> function0) {
        if (function0 == null) {
            m9977a(34);
            throw null;
        }
        this.f24711c.lock();
        try {
            T tInvoke = function0.invoke();
            this.f24711c.unlock();
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw ((f.a) this.f24712d).handleException(th);
            } catch (Throwable th2) {
                this.f24711c.unlock();
                throw th2;
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <K, V> InterfaceC11891a<K, V> createCacheWithNotNullValues() {
        return new d(this, m9978b(), null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <K, V> InterfaceC11892b<K, V> createCacheWithNullableValues() {
        return new e(this, m9978b(), null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <T> InterfaceC11900j<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new j(this, function0);
        }
        m9977a(23);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <T> InterfaceC11900j<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2) {
        if (function0 == null) {
            m9977a(28);
            throw null;
        }
        if (function2 != null) {
            return new c(this, this, function0, function1, function2);
        }
        m9977a(29);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <K, V> InterfaceC11898h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            m9977a(9);
            throw null;
        }
        InterfaceC11898h<K, V> interfaceC11898hCreateMemoizedFunction = createMemoizedFunction(function1, m9978b());
        if (interfaceC11898hCreateMemoizedFunction != null) {
            return interfaceC11898hCreateMemoizedFunction;
        }
        m9977a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <K, V> InterfaceC11899i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            m9977a(19);
            throw null;
        }
        InterfaceC11899i<K, V> interfaceC11899iCreateMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, m9978b());
        if (interfaceC11899iCreateMemoizedFunctionWithNullableValues != null) {
            return interfaceC11899iCreateMemoizedFunctionWithNullableValues;
        }
        m9977a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <T> InterfaceC11901k<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new h(this, function0);
        }
        m9977a(30);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o
    public <T> InterfaceC11900j<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t) {
        if (function0 == null) {
            m9977a(26);
            throw null;
        }
        if (t != null) {
            return new b(this, this, function0, t);
        }
        m9977a(27);
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return C1643a.m822J(sb, this.f24713e, ")");
    }

    public <K, V> InterfaceC11898h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            m9977a(14);
            throw null;
        }
        if (concurrentMap != null) {
            return new m(this, concurrentMap, function1);
        }
        m9977a(15);
        throw null;
    }

    public <K, V> InterfaceC11899i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            m9977a(21);
            throw null;
        }
        if (concurrentMap != null) {
            return new l(this, concurrentMap, function1);
        }
        m9977a(22);
        throw null;
    }

    public C11896f(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11896f(String str, Runnable runnable, Function1<InterruptedException, Unit> function1) {
        f fVar = f.f24717a;
        int i2 = InterfaceC11902l.f24733a;
        this(str, fVar, InterfaceC11902l.a.f24734a.simpleLock(runnable, function1));
    }
}
