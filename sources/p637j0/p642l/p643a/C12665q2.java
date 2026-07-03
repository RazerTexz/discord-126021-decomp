package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.InterfaceC12581g;
import p637j0.p641k.C12591d;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.p649o.C12755y;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Func2;
import p658rx.functions.FuncN;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.q2 */
/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12665q2<R> implements Observable.InterfaceC13006b<R, Observable<?>[]> {

    /* JADX INFO: renamed from: j */
    public final FuncN<? extends R> f27005j;

    /* JADX INFO: renamed from: j0.l.a.q2$a */
    /* JADX INFO: compiled from: OperatorZip.java */
    public static final class a<R> extends AtomicLong {

        /* JADX INFO: renamed from: j */
        public static final int f27006j = (int) (((double) C12719i.f27283j) * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        public final InterfaceC12581g<? super R> child;
        private final CompositeSubscription childSubscription;
        public int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        /* JADX INFO: renamed from: j0.l.a.q2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorZip.java */
        public final class C13348a extends Subscriber {

            /* JADX INFO: renamed from: j */
            public final C12719i f27007j;

            public C13348a() {
                int i = C12719i.f27283j;
                this.f27007j = C12755y.m10858b() ? new C12719i(true, C12719i.f27283j) : new C12719i();
            }

            @Override // p637j0.InterfaceC12581g
            public void onCompleted() {
                C12719i c12719i = this.f27007j;
                if (c12719i.f27285l == null) {
                    c12719i.f27285l = C12614e.f26768a;
                }
                a.this.m10779b();
            }

            @Override // p637j0.InterfaceC12581g
            public void onError(Throwable th) {
                a.this.child.onError(th);
            }

            @Override // p637j0.InterfaceC12581g
            public void onNext(Object obj) {
                try {
                    this.f27007j.m10817a(obj);
                } catch (MissingBackpressureException e) {
                    a.this.child.onError(e);
                }
                a.this.m10779b();
            }

            @Override // p658rx.Subscriber
            public void onStart() {
                request(C12719i.f27283j);
            }
        }

        public a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = subscriber;
            this.zipFunction = funcN;
            subscriber.add(compositeSubscription);
        }

        /* JADX INFO: renamed from: a */
        public void m10778a(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i = 0; i < observableArr.length; i++) {
                C13348a c13348a = new C13348a();
                objArr[i] = c13348a;
                this.childSubscription.m11136a(c13348a);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                observableArr[i2].m11107i0((C13348a) objArr[i2]);
            }
        }

        /* JADX INFO: renamed from: b */
        public void m10779b() {
            Object[] objArr = this.subscribers;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            InterfaceC12581g<? super R> interfaceC12581g = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z2 = true;
                for (int i = 0; i < length; i++) {
                    Object objM10818b = ((C13348a) objArr[i]).f27007j.m10818b();
                    if (objM10818b == null) {
                        z2 = false;
                    } else {
                        if (C12614e.m10746c(objM10818b)) {
                            interfaceC12581g.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                        objArr2[i] = C12614e.m10745b(objM10818b);
                    }
                }
                if (z2 && atomicLong.get() > 0) {
                    try {
                        interfaceC12581g.onNext(this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            C12719i c12719i = ((C13348a) obj).f27007j;
                            c12719i.m10819c();
                            if (C12614e.m10746c(c12719i.m10818b())) {
                                interfaceC12581g.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > f27006j) {
                            for (Object obj2 : objArr) {
                                ((C13348a) obj2).request(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        C3404f.m4329p1(th, interfaceC12581g, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.q2$b */
    /* JADX INFO: compiled from: OperatorZip.java */
    public static final class b<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        public final a<R> zipper;

        public b(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            C3404f.m4276c0(this, j);
            this.zipper.m10779b();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.q2$c */
    /* JADX INFO: compiled from: OperatorZip.java */
    public final class c extends Subscriber<Observable[]> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super R> f27009j;

        /* JADX INFO: renamed from: k */
        public final a<R> f27010k;

        /* JADX INFO: renamed from: l */
        public final b<R> f27011l;

        /* JADX INFO: renamed from: m */
        public boolean f27012m;

        public c(C12665q2 c12665q2, Subscriber<? super R> subscriber, a<R> aVar, b<R> bVar) {
            this.f27009j = subscriber;
            this.f27010k = aVar;
            this.f27011l = bVar;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f27012m) {
                return;
            }
            this.f27009j.onCompleted();
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.f27009j.onError(th);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr == null || observableArr.length == 0) {
                this.f27009j.onCompleted();
            } else {
                this.f27012m = true;
                this.f27010k.m10778a(observableArr, this.f27011l);
            }
        }
    }

    public C12665q2(Func2 func2) {
        this.f27005j = new C12591d(func2);
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.f27005j);
        b bVar = new b(aVar);
        c cVar = new c(this, subscriber, aVar, bVar);
        subscriber.add(cVar);
        subscriber.setProducer(bVar);
        return cVar;
    }
}
