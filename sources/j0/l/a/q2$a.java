package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Subscriber;
import rx.functions.FuncN;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2$a<R> extends AtomicLong {
    public static final int j = (int) (((double) j0.l.e.i.j) * 0.7d);
    private static final long serialVersionUID = 5995274816189928317L;
    public final j0.g<? super R> child;
    private final CompositeSubscription childSubscription;
    public int emitted;
    private AtomicLong requested;
    private volatile Object[] subscribers;
    private final FuncN<? extends R> zipFunction;

    public q2$a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.childSubscription = compositeSubscription;
        this.child = subscriber;
        this.zipFunction = funcN;
        subscriber.add(compositeSubscription);
    }

    public void a(Observable[] observableArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[observableArr.length];
        for (int i = 0; i < observableArr.length; i++) {
            q2$a$a q2_a_a = new q2$a$a(this);
            objArr[i] = q2_a_a;
            this.childSubscription.a(q2_a_a);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < observableArr.length; i2++) {
            observableArr[i2].i0((q2$a$a) objArr[i2]);
        }
    }

    public void b() {
        Object[] objArr = this.subscribers;
        if (objArr == null || getAndIncrement() != 0) {
            return;
        }
        int length = objArr.length;
        j0.g<? super R> gVar = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z2 = true;
            for (int i = 0; i < length; i++) {
                Object objB = ((q2$a$a) objArr[i]).j.b();
                if (objB == null) {
                    z2 = false;
                } else {
                    if (e.c(objB)) {
                        gVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    }
                    objArr2[i] = e.b(objB);
                }
            }
            if (z2 && atomicLong.get() > 0) {
                try {
                    gVar.onNext(this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        j0.l.e.i iVar = ((q2$a$a) obj).j;
                        iVar.c();
                        if (e.c(iVar.b())) {
                            gVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                    }
                    if (this.emitted > j) {
                        for (Object obj2 : objArr) {
                            ((q2$a$a) obj2).request(this.emitted);
                        }
                        this.emitted = 0;
                    }
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.p1(th, gVar, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
