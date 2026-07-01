package j0.l.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends Scheduler$Worker implements Subscription {
    public static final boolean j;
    public static volatile Object n;
    public final ScheduledExecutorService p;
    public volatile boolean q;
    public static final Object o = new Object();
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> l = new ConcurrentHashMap<>();
    public static final AtomicReference<ScheduledExecutorService> m = new AtomicReference<>();
    public static final int k = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i = j0.l.e.h.a;
        j = !z2 && (i == 0 || i >= 21);
    }

    public g(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!g(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            e((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.p = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static Method d(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public static void e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = m;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new j0.l.e.j("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool)) {
                g$a g_a = new g$a();
                int i = k;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(g_a, i, i, TimeUnit.MILLISECONDS);
                break;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
        l.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean g(ScheduledExecutorService scheduledExecutorService) {
        Method methodD;
        if (j) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = n;
                Object obj2 = o;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodD = d(scheduledExecutorService);
                    if (methodD != null) {
                        obj2 = methodD;
                    }
                    n = obj2;
                } else {
                    methodD = (Method) obj;
                }
            } else {
                methodD = d(scheduledExecutorService);
            }
            if (methodD != null) {
                try {
                    methodD.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e) {
                    j0.o.l.b(e);
                } catch (IllegalArgumentException e2) {
                    j0.o.l.b(e2);
                } catch (InvocationTargetException e3) {
                    j0.o.l.b(e3);
                }
            }
        }
        return false;
    }

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        return this.q ? j0.r.c.a : f(action0, 0L, null);
    }

    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j2, TimeUnit timeUnit) {
        return this.q ? j0.r.c.a : f(action0, j2, timeUnit);
    }

    public j f(Action0 action0, long j2, TimeUnit timeUnit) {
        j jVar = new j(j0.o.l.d(action0));
        jVar.a(j2 <= 0 ? this.p.submit(jVar) : this.p.schedule(jVar, j2, timeUnit));
        return jVar;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.q;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.q = true;
        this.p.shutdownNow();
        l.remove(this.p);
    }
}
