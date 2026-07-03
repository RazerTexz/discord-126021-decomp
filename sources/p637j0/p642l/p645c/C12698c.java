package p637j0.p642l.p645c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p637j0.p652o.C12774l;
import p637j0.p655r.C12785a;
import p637j0.p655r.C12786b;
import p637j0.p655r.C12787c;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.c */
/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12698c extends Scheduler {

    /* JADX INFO: renamed from: a */
    public final Executor f27203a;

    /* JADX INFO: renamed from: j0.l.c.c$a */
    /* JADX INFO: compiled from: ExecutorScheduler.java */
    public static final class a extends Scheduler.Worker implements Runnable {

        /* JADX INFO: renamed from: j */
        public final Executor f27204j;

        /* JADX INFO: renamed from: n */
        public final ScheduledExecutorService f27208n;

        /* JADX INFO: renamed from: l */
        public final ConcurrentLinkedQueue<RunnableC12705j> f27206l = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: m */
        public final AtomicInteger f27207m = new AtomicInteger();

        /* JADX INFO: renamed from: k */
        public final CompositeSubscription f27205k = new CompositeSubscription();

        /* JADX INFO: renamed from: j0.l.c.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ExecutorScheduler.java */
        public class C13353a implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ C12786b f27209j;

            public C13353a(C12786b c12786b) {
                this.f27209j = c12786b;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                a.this.f27205k.m11138c(this.f27209j);
            }
        }

        /* JADX INFO: renamed from: j0.l.c.c$a$b */
        /* JADX INFO: compiled from: ExecutorScheduler.java */
        public class b implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ C12786b f27211j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ Action0 f27212k;

            /* JADX INFO: renamed from: l */
            public final /* synthetic */ Subscription f27213l;

            public b(C12786b c12786b, Action0 action0, Subscription subscription) {
                this.f27211j = c12786b;
                this.f27212k = action0;
                this.f27213l = subscription;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                if (this.f27211j.isUnsubscribed()) {
                    return;
                }
                Subscription subscriptionMo10740a = a.this.mo10740a(this.f27212k);
                this.f27211j.m10881a(subscriptionMo10740a);
                if (subscriptionMo10740a.getClass() == RunnableC12705j.class) {
                    ((RunnableC12705j) subscriptionMo10740a).cancel.m11128a(this.f27213l);
                }
            }
        }

        public a(Executor executor) {
            ScheduledExecutorService scheduledExecutorService;
            this.f27204j = executor;
            ScheduledExecutorService[] scheduledExecutorServiceArr = C12699d.f27217c.f27219e.get();
            if (scheduledExecutorServiceArr == C12699d.f27215a) {
                scheduledExecutorService = C12699d.f27216b;
            } else {
                int i = C12699d.f27218d + 1;
                i = i >= scheduledExecutorServiceArr.length ? 0 : i;
                C12699d.f27218d = i;
                scheduledExecutorService = scheduledExecutorServiceArr[i];
            }
            this.f27208n = scheduledExecutorService;
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            if (this.f27205k.f27656k) {
                return C12787c.f27422a;
            }
            RunnableC12705j runnableC12705j = new RunnableC12705j(C12774l.m10865d(action0), this.f27205k);
            this.f27205k.m11136a(runnableC12705j);
            this.f27206l.offer(runnableC12705j);
            if (this.f27207m.getAndIncrement() == 0) {
                try {
                    this.f27204j.execute(this);
                } catch (RejectedExecutionException e) {
                    this.f27205k.m11138c(runnableC12705j);
                    this.f27207m.decrementAndGet();
                    C12774l.m10863b(e);
                    throw e;
                }
            }
            return runnableC12705j;
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
        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo10740a(action0);
            }
            if (this.f27205k.f27656k) {
                return C12787c.f27422a;
            }
            Action0 action0M10865d = C12774l.m10865d(action0);
            C12786b c12786b = new C12786b();
            C12786b c12786b2 = new C12786b();
            c12786b2.m10881a(c12786b);
            this.f27205k.m11136a(c12786b2);
            C12785a c12785a = new C12785a(new C13353a(c12786b2));
            RunnableC12705j runnableC12705j = new RunnableC12705j(new b(c12786b2, action0M10865d, c12785a));
            c12786b.m10881a(runnableC12705j);
            try {
                runnableC12705j.m10807a(this.f27208n.schedule(runnableC12705j, j, timeUnit));
                return c12785a;
            } catch (RejectedExecutionException e) {
                C12774l.m10863b(e);
                throw e;
            }
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27205k.f27656k;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f27205k.f27656k) {
                RunnableC12705j runnableC12705jPoll = this.f27206l.poll();
                if (runnableC12705jPoll == null) {
                    return;
                }
                if (!runnableC12705jPoll.cancel.f27645k) {
                    if (this.f27205k.f27656k) {
                        this.f27206l.clear();
                        return;
                    }
                    runnableC12705jPoll.run();
                }
                if (this.f27207m.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f27206l.clear();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f27205k.unsubscribe();
            this.f27206l.clear();
        }
    }

    public C12698c(Executor executor) {
        this.f27203a = executor;
    }

    @Override // p658rx.Scheduler
    /* JADX INFO: renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a(this.f27203a);
    }
}
