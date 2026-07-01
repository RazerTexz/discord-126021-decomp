package d0.e0.p.d.m0.m;

import d0.g0.w;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements o {
    public static final String a = w.substringBeforeLast(f.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3514b = new f$a("NO_LOCKS", f$f.a, e.f3513b);
    public final l c;
    public final f$f d;
    public final String e;

    public f(String str, f$f f_f, l lVar) {
        if (str == null) {
            a(4);
            throw null;
        }
        if (f_f == null) {
            a(5);
            throw null;
        }
        if (lVar == null) {
            a(6);
            throw null;
        }
        this.c = lVar;
        this.d = f_f;
        this.e = str;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    public static /* synthetic */ void a(int i) {
        String str = (i == 10 || i == 13 || i == 20 || i == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 10 || i == 13 || i == 20 || i == 37) ? 2 : 3];
        if (i == 1 || i == 3 || i == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i != 6) {
            switch (i) {
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
        if (i == 10 || i == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i) {
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
        if (i != 10 && i != 13 && i != 20 && i != 37) {
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
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (!stackTrace[i2].getClassName().startsWith(a)) {
                i = i2;
                break;
            }
        }
        List listSubList = Arrays.asList(stackTrace).subList(i, length);
        t.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return t;
    }

    public <K, V> f$o<V> c(String str, K k) {
        StringBuilder sbX = b.d.b.a.a.X("Recursion detected ", str);
        sbX.append(k == null ? "" : b.d.b.a.a.v("on input: ", k));
        sbX.append(" under ");
        sbX.append(this);
        AssertionError assertionError = new AssertionError(sbX.toString());
        d(assertionError);
        throw assertionError;
    }

    @Override // d0.e0.p.d.m0.m.o
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
                throw ((f$f$a) this.d).handleException(th);
            } catch (Throwable th2) {
                this.c.unlock();
                throw th2;
            }
        }
    }

    @Override // d0.e0.p.d.m0.m.o
    public <K, V> a<K, V> createCacheWithNotNullValues() {
        return new f$d(this, b(), null);
    }

    @Override // d0.e0.p.d.m0.m.o
    public <K, V> b<K, V> createCacheWithNullableValues() {
        return new f$e(this, b(), null);
    }

    @Override // d0.e0.p.d.m0.m.o
    public <T> j<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new f$j(this, function0);
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.o
    public <T> j<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function2) {
        if (function0 == null) {
            a(28);
            throw null;
        }
        if (function2 != null) {
            return new f$c(this, this, function0, function1, function2);
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.o
    public <K, V> h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(9);
            throw null;
        }
        h<K, V> hVarCreateMemoizedFunction = createMemoizedFunction(function1, b());
        if (hVarCreateMemoizedFunction != null) {
            return hVarCreateMemoizedFunction;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.o
    public <K, V> i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(19);
            throw null;
        }
        i<K, V> iVarCreateMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, b());
        if (iVarCreateMemoizedFunctionWithNullableValues != null) {
            return iVarCreateMemoizedFunctionWithNullableValues;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.o
    public <T> k<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new f$h(this, function0);
        }
        a(30);
        throw null;
    }

    @Override // d0.e0.p.d.m0.m.o
    public <T> j<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t) {
        if (function0 == null) {
            a(26);
            throw null;
        }
        if (t != null) {
            return new f$b(this, this, function0, t);
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
        return b.d.b.a.a.J(sb, this.e, ")");
    }

    public <K, V> h<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(14);
            throw null;
        }
        if (concurrentMap != null) {
            return new f$m(this, concurrentMap, function1);
        }
        a(15);
        throw null;
    }

    public <K, V> i<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(21);
            throw null;
        }
        if (concurrentMap != null) {
            return new f$l(this, concurrentMap, function1);
        }
        a(22);
        throw null;
    }

    public f(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(String str, Runnable runnable, Function1<InterruptedException, Unit> function1) {
        f$f f_f = f$f.a;
        int i = l.a;
        this(str, f_f, l$a.a.simpleLock(runnable, function1));
    }
}
