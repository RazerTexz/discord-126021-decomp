package j0.l.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends Scheduler$Worker implements Runnable {
    public final Executor j;
    public final ScheduledExecutorService n;
    public final ConcurrentLinkedQueue<j> l = new ConcurrentLinkedQueue<>();
    public final AtomicInteger m = new AtomicInteger();
    public final CompositeSubscription k = new CompositeSubscription();

    public c$a(Executor executor) {
        ScheduledExecutorService scheduledExecutorService;
        this.j = executor;
        ScheduledExecutorService[] scheduledExecutorServiceArr = d.c.e.get();
        if (scheduledExecutorServiceArr == d.a) {
            scheduledExecutorService = d.f3789b;
        } else {
            int i = d.d + 1;
            i = i >= scheduledExecutorServiceArr.length ? 0 : i;
            d.d = i;
            scheduledExecutorService = scheduledExecutorServiceArr[i];
        }
        this.n = scheduledExecutorService;
    }

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        if (this.k.k) {
            return j0.r.c.a;
        }
        j jVar = new j(j0.o.l.d(action0), this.k);
        this.k.a(jVar);
        this.l.offer(jVar);
        if (this.m.getAndIncrement() == 0) {
            try {
                this.j.execute(this);
            } catch (RejectedExecutionException e) {
                this.k.c(jVar);
                this.m.decrementAndGet();
                j0.o.l.b(e);
                throw e;
            }
        }
        return jVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
        if (j <= 0) {
            return a(action0);
        }
        if (this.k.k) {
            return j0.r.c.a;
        }
        Action0 action0D = j0.o.l.d(action0);
        j0.r.b bVar = new j0.r.b();
        j0.r.b bVar2 = new j0.r.b();
        bVar2.a(bVar);
        this.k.a(bVar2);
        j0.r.a aVar = new j0.r.a(new c$a$a(this, bVar2));
        j jVar = new j(new c$a$b(this, bVar2, action0D, aVar));
        bVar.a(jVar);
        try {
            jVar.a(this.n.schedule(jVar, j, timeUnit));
            return aVar;
        } catch (RejectedExecutionException e) {
            j0.o.l.b(e);
            throw e;
        }
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.k.k;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.k.k) {
            j jVarPoll = this.l.poll();
            if (jVarPoll == null) {
                return;
            }
            if (!jVarPoll.cancel.k) {
                if (this.k.k) {
                    this.l.clear();
                    return;
                }
                jVarPoll.run();
            }
            if (this.m.decrementAndGet() == 0) {
                return;
            }
        }
        this.l.clear();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.k.unsubscribe();
        this.l.clear();
    }
}
