package s.a;

import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Executors;

/* JADX INFO: renamed from: s.a.s, reason: use source file name */
/* JADX INFO: compiled from: CommonPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CommonPool extends Executors {
    public static final int j;
    public static final CommonPool k = new CommonPool();
    public static volatile Executor pool;

    /* JADX INFO: renamed from: s.a.s$a */
    /* JADX INFO: compiled from: CommonPool.kt */
    public static final class a implements ThreadFactory {
        public final /* synthetic */ AtomicInteger j;

        public a(AtomicInteger atomicInteger) {
            this.j = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sbU = outline.U("CommonPool-worker-");
            sbU.append(this.j.incrementAndGet());
            Thread thread = new Thread(runnable, sbU.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer intOrNull = StringNumberConversions.toIntOrNull(property);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new IllegalStateException(outline.w("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", property).toString());
            }
            iIntValue = intOrNull.intValue();
        } else {
            iIntValue = -1;
        }
        j = iIntValue;
    }

    public final ExecutorService I() {
        return java.util.concurrent.Executors.newFixedThreadPool(L(), new a(new AtomicInteger()));
    }

    public final ExecutorService J() {
        Class<?> cls;
        ExecutorService executorService;
        Integer num;
        if (System.getSecurityManager() != null) {
            return I();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return I();
        }
        if (j < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object objInvoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                Objects.requireNonNull(k);
                executorService.submit(CommonPool2.j);
                try {
                    Object objInvoke2 = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
                    if (!(objInvoke2 instanceof Integer)) {
                        objInvoke2 = null;
                    }
                    num = (Integer) objInvoke2;
                } catch (Throwable unused3) {
                    num = null;
                }
                if (!(num != null && num.intValue() >= 1)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(k.L()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused4) {
        }
        return executorService2 != null ? executorService2 : I();
    }

    public final int L() {
        Integer numValueOf = Integer.valueOf(j);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : _Ranges.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executorJ = pool;
            if (executorJ == null) {
                synchronized (this) {
                    executorJ = pool;
                    if (executorJ == null) {
                        executorJ = J();
                        pool = executorJ;
                    }
                }
            }
            executorJ.execute(runnable);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.q.T(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }
}
