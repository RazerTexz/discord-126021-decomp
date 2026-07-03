package p637j0.p642l.p645c;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p647e.C12718h;
import p637j0.p642l.p647e.ThreadFactoryC12720j;
import p637j0.p652o.C12774l;
import p637j0.p655r.C12787c;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.c.g */
/* JADX INFO: compiled from: NewThreadWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12702g extends Scheduler.Worker implements Subscription {

    /* JADX INFO: renamed from: j */
    public static final boolean f27223j;

    /* JADX INFO: renamed from: n */
    public static volatile Object f27227n;

    /* JADX INFO: renamed from: p */
    public final ScheduledExecutorService f27229p;

    /* JADX INFO: renamed from: q */
    public volatile boolean f27230q;

    /* JADX INFO: renamed from: o */
    public static final Object f27228o = new Object();

    /* JADX INFO: renamed from: l */
    public static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f27225l = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: m */
    public static final AtomicReference<ScheduledExecutorService> f27226m = new AtomicReference<>();

    /* JADX INFO: renamed from: k */
    public static final int f27224k = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: renamed from: j0.l.c.g$a */
    /* JADX INFO: compiled from: NewThreadWorker.java */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator<ScheduledThreadPoolExecutor> it = C12702g.f27225l.keySet().iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor next = it.next();
                    if (next.isShutdown()) {
                        it.remove();
                    } else {
                        next.purge();
                    }
                }
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                C12774l.m10863b(th);
            }
        }
    }

    static {
        boolean z2 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int i = C12718h.f27281a;
        f27223j = !z2 && (i == 0 || i >= 21);
    }

    public C12702g(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m10804g(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            m10803e((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.f27229p = scheduledExecutorServiceNewScheduledThreadPool;
    }

    /* JADX INFO: renamed from: d */
    public static Method m10802d(ScheduledExecutorService scheduledExecutorService) {
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

    /* JADX INFO: renamed from: e */
    public static void m10803e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f27226m;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC12720j("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i = f27224k;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.MILLISECONDS);
                break;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
        f27225l.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    /* JADX INFO: renamed from: g */
    public static boolean m10804g(ScheduledExecutorService scheduledExecutorService) {
        Method methodM10802d;
        if (f27223j) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f27227n;
                Object obj2 = f27228o;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodM10802d = m10802d(scheduledExecutorService);
                    if (methodM10802d != null) {
                        obj2 = methodM10802d;
                    }
                    f27227n = obj2;
                } else {
                    methodM10802d = (Method) obj;
                }
            } else {
                methodM10802d = m10802d(scheduledExecutorService);
            }
            if (methodM10802d != null) {
                try {
                    methodM10802d.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e) {
                    C12774l.m10863b(e);
                } catch (IllegalArgumentException e2) {
                    C12774l.m10863b(e2);
                } catch (InvocationTargetException e3) {
                    C12774l.m10863b(e3);
                }
            }
        }
        return false;
    }

    @Override // rx.Scheduler.Worker
    /* JADX INFO: renamed from: a */
    public Subscription mo10740a(Action0 action0) {
        return this.f27230q ? C12787c.f27422a : m10805f(action0, 0L, null);
    }

    @Override // rx.Scheduler.Worker
    /* JADX INFO: renamed from: b */
    public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
        return this.f27230q ? C12787c.f27422a : m10805f(action0, j, timeUnit);
    }

    /* JADX INFO: renamed from: f */
    public RunnableC12705j m10805f(Action0 action0, long j, TimeUnit timeUnit) {
        RunnableC12705j runnableC12705j = new RunnableC12705j(C12774l.m10865d(action0));
        runnableC12705j.m10807a(j <= 0 ? this.f27229p.submit(runnableC12705j) : this.f27229p.schedule(runnableC12705j, j, timeUnit));
        return runnableC12705j;
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27230q;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f27230q = true;
        this.f27229p.shutdownNow();
        f27225l.remove(this.f27229p);
    }
}
