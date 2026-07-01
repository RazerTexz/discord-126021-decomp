package j0.l.c;

import j0.l.e.PlatformDependent;
import j0.l.e.RxThreadFactory;
import j0.r.Subscriptions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.g, reason: use source file name */
/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class NewThreadWorker extends Scheduler.Worker implements Subscription {
    public static final boolean j;
    public static volatile Object n;
    public final ScheduledExecutorService p;
    public volatile boolean q;
    public static final Object o = new Object();
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> l = new ConcurrentHashMap<>();
    public static final AtomicReference<ScheduledExecutorService> m = new AtomicReference<>();
    public static final int k = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: renamed from: j0.l.c.g$a */
    /* JADX INFO: compiled from: NewThreadWorker.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator<ScheduledThreadPoolExecutor> it = NewThreadWorker.l.keySet().iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor next = it.next();
                    if (next.isShutdown()) {
                        it.remove();
                    } else {
                        next.purge();
                    }
                }
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                j0.o.l.b(th);
            }
        }
    }

    static {
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i = PlatformDependent.a;
        j = !z2 && (i == 0 || i >= 21);
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
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
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i = k;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.MILLISECONDS);
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

    @Override // rx.Scheduler.Worker
    public Subscription a(Action0 action0) {
        return this.q ? Subscriptions.a : f(action0, 0L, null);
    }

    @Override // rx.Scheduler.Worker
    public Subscription b(Action0 action0, long j2, TimeUnit timeUnit) {
        return this.q ? Subscriptions.a : f(action0, j2, timeUnit);
    }

    public ScheduledAction f(Action0 action0, long j2, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(j0.o.l.d(action0));
        scheduledAction.a(j2 <= 0 ? this.p.submit(scheduledAction) : this.p.schedule(scheduledAction, j2, timeUnit));
        return scheduledAction;
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
