package p637j0.p642l.p643a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.n0 */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12651n0<T> implements Observable.InterfaceC13006b<List<T>, T> {

    /* JADX INFO: renamed from: j */
    public final long f26931j;

    /* JADX INFO: renamed from: k */
    public final long f26932k;

    /* JADX INFO: renamed from: l */
    public final TimeUnit f26933l;

    /* JADX INFO: renamed from: m */
    public final int f26934m;

    /* JADX INFO: renamed from: n */
    public final Scheduler f26935n;

    /* JADX INFO: renamed from: j0.l.a.n0$a */
    /* JADX INFO: compiled from: OperatorBufferWithTime.java */
    public final class a extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super List<T>> f26936j;

        /* JADX INFO: renamed from: k */
        public final Scheduler.Worker f26937k;

        /* JADX INFO: renamed from: l */
        public List<T> f26938l = new ArrayList();

        /* JADX INFO: renamed from: m */
        public boolean f26939m;

        public a(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.f26936j = subscriber;
            this.f26937k = worker;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            try {
                this.f26937k.unsubscribe();
                synchronized (this) {
                    if (this.f26939m) {
                        return;
                    }
                    this.f26939m = true;
                    List<T> list = this.f26938l;
                    this.f26938l = null;
                    this.f26936j.onNext(list);
                    this.f26936j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                Subscriber<? super List<T>> subscriber = this.f26936j;
                C3404f.m4325o1(th);
                subscriber.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f26939m) {
                    return;
                }
                this.f26939m = true;
                this.f26938l = null;
                this.f26936j.onError(th);
                unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (this.f26939m) {
                    return;
                }
                this.f26938l.add(t);
                if (this.f26938l.size() == C12651n0.this.f26934m) {
                    list = this.f26938l;
                    this.f26938l = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.f26936j.onNext(list);
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.n0$b */
    /* JADX INFO: compiled from: OperatorBufferWithTime.java */
    public final class b extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super List<T>> f26941j;

        /* JADX INFO: renamed from: k */
        public final Scheduler.Worker f26942k;

        /* JADX INFO: renamed from: l */
        public final List<List<T>> f26943l = new LinkedList();

        /* JADX INFO: renamed from: m */
        public boolean f26944m;

        /* JADX INFO: renamed from: j0.l.a.n0$b$a */
        /* JADX INFO: compiled from: OperatorBufferWithTime.java */
        public class a implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ List f26946j;

            public a(List list) {
                this.f26946j = list;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                boolean z2;
                b bVar = b.this;
                List<T> list = this.f26946j;
                synchronized (bVar) {
                    if (bVar.f26944m) {
                        return;
                    }
                    Iterator<List<T>> it = bVar.f26943l.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        } else if (it.next() == list) {
                            it.remove();
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        try {
                            bVar.f26941j.onNext(list);
                        } catch (Throwable th) {
                            C3404f.m4325o1(th);
                            bVar.onError(th);
                        }
                    }
                }
            }
        }

        public b(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.f26941j = subscriber;
            this.f26942k = worker;
        }

        /* JADX INFO: renamed from: a */
        public void m10774a() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f26944m) {
                    return;
                }
                this.f26943l.add(arrayList);
                Scheduler.Worker worker = this.f26942k;
                a aVar = new a(arrayList);
                C12651n0 c12651n0 = C12651n0.this;
                worker.mo10741b(aVar, c12651n0.f26931j, c12651n0.f26933l);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f26944m) {
                        return;
                    }
                    this.f26944m = true;
                    LinkedList linkedList = new LinkedList(this.f26943l);
                    this.f26943l.clear();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.f26941j.onNext((List) it.next());
                    }
                    this.f26941j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                Subscriber<? super List<T>> subscriber = this.f26941j;
                C3404f.m4325o1(th);
                subscriber.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f26944m) {
                    return;
                }
                this.f26944m = true;
                this.f26943l.clear();
                this.f26941j.onError(th);
                unsubscribe();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            synchronized (this) {
                if (this.f26944m) {
                    return;
                }
                Iterator<List<T>> it = this.f26943l.iterator();
                LinkedList linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t);
                    if (next.size() == C12651n0.this.f26934m) {
                        it.remove();
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(next);
                    }
                }
                if (linkedList != null) {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        this.f26941j.onNext((List) it2.next());
                    }
                }
            }
        }
    }

    public C12651n0(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.f26931j = j;
        this.f26932k = j2;
        this.f26933l = timeUnit;
        this.f26934m = i;
        this.f26935n = scheduler;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f26935n.mo10739a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f26931j == this.f26932k) {
            a aVar = new a(serializedSubscriber, workerMo10739a);
            aVar.add(workerMo10739a);
            subscriber.add(aVar);
            Scheduler.Worker worker = aVar.f26937k;
            C12647m0 c12647m0 = new C12647m0(aVar);
            long j = this.f26931j;
            worker.m11120c(c12647m0, j, j, this.f26933l);
            return aVar;
        }
        b bVar = new b(serializedSubscriber, workerMo10739a);
        bVar.add(workerMo10739a);
        subscriber.add(bVar);
        bVar.m10774a();
        Scheduler.Worker worker2 = bVar.f26942k;
        C12655o0 c12655o0 = new C12655o0(bVar);
        long j2 = this.f26932k;
        worker2.m11120c(c12655o0, j2, j2, this.f26933l);
        return bVar;
    }
}
