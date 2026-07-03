package p637j0.p642l.p643a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p644b.C12693a;
import p637j0.p642l.p647e.C12721k;
import p637j0.p642l.p647e.EnumC12714d;
import p637j0.p642l.p647e.p648n.C12726c;
import p637j0.p642l.p647e.p649o.C12744n;
import p637j0.p642l.p647e.p649o.C12755y;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.h */
/* JADX INFO: compiled from: OnSubscribeConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12626h<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Observable<? extends T> f26812j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC12589b<? super T, ? extends Observable<? extends R>> f26813k;

    /* JADX INFO: renamed from: j0.l.a.h$a */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class a<T, R> implements Producer {

        /* JADX INFO: renamed from: j */
        public final R f26814j;

        /* JADX INFO: renamed from: k */
        public final c<T, R> f26815k;

        /* JADX INFO: renamed from: l */
        public boolean f26816l;

        public a(R r, c<T, R> cVar) {
            this.f26814j = r;
            this.f26815k = cVar;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (this.f26816l || j <= 0) {
                return;
            }
            this.f26816l = true;
            c<T, R> cVar = this.f26815k;
            cVar.f26819j.onNext(this.f26814j);
            cVar.f26822m.m10796b(1L);
            cVar.f26828s = false;
            cVar.m10751a();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h$b */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class b<T, R> extends Subscriber<R> {

        /* JADX INFO: renamed from: j */
        public final c<T, R> f26817j;

        /* JADX INFO: renamed from: k */
        public long f26818k;

        public b(c<T, R> cVar) {
            this.f26817j = cVar;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            c<T, R> cVar = this.f26817j;
            long j = this.f26818k;
            if (j != 0) {
                cVar.f26822m.m10796b(j);
            }
            cVar.f26828s = false;
            cVar.m10751a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            c<T, R> cVar = this.f26817j;
            long j = this.f26818k;
            if (!EnumC12714d.m10811f(cVar.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            if (cVar.f26821l == 0) {
                Throwable thM10813h = EnumC12714d.m10813h(cVar.f26825p);
                if (!EnumC12714d.m10812g(thM10813h)) {
                    cVar.f26819j.onError(thM10813h);
                }
                cVar.unsubscribe();
                return;
            }
            if (j != 0) {
                cVar.f26822m.m10796b(j);
            }
            cVar.f26828s = false;
            cVar.m10751a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(R r) {
            this.f26818k++;
            this.f26817j.f26819j.onNext(r);
        }

        @Override // p658rx.Subscriber
        public void setProducer(Producer producer) {
            this.f26817j.f26822m.m10797c(producer);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h$c */
    /* JADX INFO: compiled from: OnSubscribeConcatMap.java */
    public static final class c<T, R> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f26819j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<? super T, ? extends Observable<? extends R>> f26820k;

        /* JADX INFO: renamed from: l */
        public final int f26821l;

        /* JADX INFO: renamed from: n */
        public final Queue<Object> f26823n;

        /* JADX INFO: renamed from: q */
        public final SerialSubscription f26826q;

        /* JADX INFO: renamed from: r */
        public volatile boolean f26827r;

        /* JADX INFO: renamed from: s */
        public volatile boolean f26828s;

        /* JADX INFO: renamed from: m */
        public final C12693a f26822m = new C12693a();

        /* JADX INFO: renamed from: o */
        public final AtomicInteger f26824o = new AtomicInteger();

        /* JADX INFO: renamed from: p */
        public final AtomicReference<Throwable> f26825p = new AtomicReference<>();

        public c(Subscriber<? super R> subscriber, InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b, int i, int i2) {
            this.f26819j = subscriber;
            this.f26820k = interfaceC12589b;
            this.f26821l = i2;
            this.f26823n = C12755y.m10858b() ? new C12744n<>(i) : new C12726c<>(i);
            this.f26826q = new SerialSubscription();
            request(i);
        }

        /* JADX INFO: renamed from: a */
        public void m10751a() {
            if (this.f26824o.getAndIncrement() != 0) {
                return;
            }
            int i = this.f26821l;
            while (!this.f26819j.isUnsubscribed()) {
                if (!this.f26828s) {
                    if (i == 1 && this.f26825p.get() != null) {
                        Throwable thM10813h = EnumC12714d.m10813h(this.f26825p);
                        if (EnumC12714d.m10812g(thM10813h)) {
                            return;
                        }
                        this.f26819j.onError(thM10813h);
                        return;
                    }
                    boolean z2 = this.f26827r;
                    Object objPoll = this.f26823n.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable thM10813h2 = EnumC12714d.m10813h(this.f26825p);
                        if (thM10813h2 == null) {
                            this.f26819j.onCompleted();
                            return;
                        } else {
                            if (EnumC12714d.m10812g(thM10813h2)) {
                                return;
                            }
                            this.f26819j.onError(thM10813h2);
                            return;
                        }
                    }
                    if (!z3) {
                        try {
                            Observable<? extends R> observableCall = this.f26820k.call((Object) C12614e.m10745b(objPoll));
                            if (observableCall == null) {
                                m10752b(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (observableCall != EnumC12606c.f26751k) {
                                if (observableCall instanceof C12721k) {
                                    this.f26828s = true;
                                    this.f26822m.m10797c(new a(((C12721k) observableCall).f27288l, this));
                                } else {
                                    b bVar = new b(this);
                                    this.f26826q.m11139a(bVar);
                                    if (bVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f26828s = true;
                                    observableCall.m11107i0(bVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            m10752b(th);
                            return;
                        }
                    }
                }
                if (this.f26824o.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public void m10752b(Throwable th) {
            unsubscribe();
            if (!EnumC12714d.m10811f(this.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            Throwable thM10813h = EnumC12714d.m10813h(this.f26825p);
            if (EnumC12714d.m10812g(thM10813h)) {
                return;
            }
            this.f26819j.onError(thM10813h);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.f26827r = true;
            m10751a();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (!EnumC12714d.m10811f(this.f26825p, th)) {
                C12774l.m10863b(th);
                return;
            }
            this.f26827r = true;
            if (this.f26821l != 0) {
                m10751a();
                return;
            }
            Throwable thM10813h = EnumC12714d.m10813h(this.f26825p);
            if (!EnumC12714d.m10812g(thM10813h)) {
                this.f26819j.onError(thM10813h);
            }
            this.f26826q.f27657j.unsubscribe();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            Queue<Object> queue = this.f26823n;
            Object obj = t;
            if (t == null) {
                obj = C12614e.f26769b;
            }
            if (queue.offer(obj)) {
                m10751a();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    public C12626h(Observable<? extends T> observable, InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b, int i, int i2) {
        this.f26812j = observable;
        this.f26813k = interfaceC12589b;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(new SerializedSubscriber(subscriber), this.f26813k, 2, 0);
        subscriber.add(cVar);
        subscriber.add(cVar.f26826q);
        subscriber.setProducer(new C12622g(this, cVar));
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.f26812j.m11107i0(cVar);
    }
}
