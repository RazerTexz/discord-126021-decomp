package j0.l.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Scheduler$Worker;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n0$b<T> extends Subscriber<T> {
    public final Subscriber<? super List<T>> j;
    public final Scheduler$Worker k;
    public final List<List<T>> l = new LinkedList();
    public boolean m;
    public final /* synthetic */ n0 n;

    public n0$b(n0 n0Var, Subscriber<? super List<T>> subscriber, Scheduler$Worker scheduler$Worker) {
        this.n = n0Var;
        this.j = subscriber;
        this.k = scheduler$Worker;
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            if (this.m) {
                return;
            }
            this.l.add(arrayList);
            Scheduler$Worker scheduler$Worker = this.k;
            n0$b$a n0_b_a = new n0$b$a(this, arrayList);
            n0 n0Var = this.n;
            scheduler$Worker.b(n0_b_a, n0Var.j, n0Var.l);
        }
    }

    @Override // j0.g
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

    @Override // j0.g
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

    @Override // j0.g
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
                if (next.size() == this.n.m) {
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
