package j0.l.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* JADX INFO: renamed from: j0.l.a.n0, reason: use source file name */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorBufferWithTime2<T> implements Observable.b<List<T>, T> {
    public final long j;
    public final long k;
    public final TimeUnit l;
    public final int m;
    public final Scheduler n;

    /* JADX INFO: renamed from: j0.l.a.n0$a */
    /* JADX INFO: compiled from: OperatorBufferWithTime.java */
    public final class a extends Subscriber<T> {
        public final Subscriber<? super List<T>> j;
        public final Scheduler.Worker k;
        public List<T> l = new ArrayList();
        public boolean m;

        public a(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.j = subscriber;
            this.k = worker;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            try {
                this.k.unsubscribe();
                synchronized (this) {
                    if (this.m) {
                        return;
                    }
                    this.m = true;
                    List<T> list = this.l;
                    this.l = null;
                    this.j.onNext(list);
                    this.j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                Subscriber<? super List<T>> subscriber = this.j;
                b.i.a.f.e.o.f.o1(th);
                subscriber.onError(th);
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                this.l = null;
                this.j.onError(th);
                unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            List<T> list;
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.l.add(t);
                if (this.l.size() == OperatorBufferWithTime2.this.m) {
                    list = this.l;
                    this.l = new ArrayList();
                } else {
                    list = null;
                }
                if (list != null) {
                    this.j.onNext(list);
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.n0$b */
    /* JADX INFO: compiled from: OperatorBufferWithTime.java */
    public final class b extends Subscriber<T> {
        public final Subscriber<? super List<T>> j;
        public final Scheduler.Worker k;
        public final List<List<T>> l = new LinkedList();
        public boolean m;

        /* JADX INFO: renamed from: j0.l.a.n0$b$a */
        /* JADX INFO: compiled from: OperatorBufferWithTime.java */
        public class a implements Action0 {
            public final /* synthetic */ List j;

            public a(List list) {
                this.j = list;
            }

            @Override // rx.functions.Action0
            public void call() {
                boolean z2;
                b bVar = b.this;
                List<T> list = this.j;
                synchronized (bVar) {
                    if (bVar.m) {
                        return;
                    }
                    Iterator<List<T>> it = bVar.l.iterator();
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
                            bVar.j.onNext(list);
                        } catch (Throwable th) {
                            b.i.a.f.e.o.f.o1(th);
                            bVar.onError(th);
                        }
                    }
                }
            }
        }

        public b(Subscriber<? super List<T>> subscriber, Scheduler.Worker worker) {
            this.j = subscriber;
            this.k = worker;
        }

        public void a() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.l.add(arrayList);
                Scheduler.Worker worker = this.k;
                a aVar = new a(arrayList);
                OperatorBufferWithTime2 operatorBufferWithTime2 = OperatorBufferWithTime2.this;
                worker.b(aVar, operatorBufferWithTime2.j, operatorBufferWithTime2.l);
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.m) {
                        return;
                    }
                    this.m = true;
                    LinkedList linkedList = new LinkedList(this.l);
                    this.l.clear();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.j.onNext((List) it.next());
                    }
                    this.j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                Subscriber<? super List<T>> subscriber = this.j;
                b.i.a.f.e.o.f.o1(th);
                subscriber.onError(th);
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                this.l.clear();
                this.j.onError(th);
                unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                Iterator<List<T>> it = this.l.iterator();
                LinkedList linkedList = null;
                while (it.hasNext()) {
                    List<T> next = it.next();
                    next.add(t);
                    if (next.size() == OperatorBufferWithTime2.this.m) {
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
                        this.j.onNext((List) it2.next());
                    }
                }
            }
        }
    }

    public OperatorBufferWithTime2(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.j = j;
        this.k = j2;
        this.l = timeUnit;
        this.m = i;
        this.n = scheduler;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.n.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.j == this.k) {
            a aVar = new a(serializedSubscriber, workerA);
            aVar.add(workerA);
            subscriber.add(aVar);
            Scheduler.Worker worker = aVar.k;
            OperatorBufferWithTime operatorBufferWithTime = new OperatorBufferWithTime(aVar);
            long j = this.j;
            worker.c(operatorBufferWithTime, j, j, this.l);
            return aVar;
        }
        b bVar = new b(serializedSubscriber, workerA);
        bVar.add(workerA);
        subscriber.add(bVar);
        bVar.a();
        Scheduler.Worker worker2 = bVar.k;
        OperatorBufferWithTime3 operatorBufferWithTime3 = new OperatorBufferWithTime3(bVar);
        long j2 = this.k;
        worker2.c(operatorBufferWithTime3, j2, j2, this.l);
        return bVar;
    }
}
