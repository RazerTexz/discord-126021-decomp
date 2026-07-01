package j0.l.a;

import j0.l.a.OperatorReplay;
import j0.r.BooleanSubscription;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.l1, reason: use source file name */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorReplay3<T> implements Observable.a<T> {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ Func0 k;

    public OperatorReplay3(AtomicReference atomicReference, Func0 func0) {
        this.j = atomicReference;
        this.k = func0;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        OperatorReplay.f fVar;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            fVar = (OperatorReplay.f) this.j.get();
            if (fVar != null) {
                break;
            }
            OperatorReplay.f fVar2 = new OperatorReplay.f((OperatorReplay.e) this.k.call());
            fVar2.add(new BooleanSubscription(new OperatorReplay4(fVar2)));
            if (this.j.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        OperatorReplay.c<T> cVar = new OperatorReplay.c<>(fVar, subscriber);
        if (!fVar.m) {
            synchronized (fVar.n) {
                if (!fVar.m) {
                    fVar.n.a(cVar);
                    fVar.p++;
                }
            }
        }
        subscriber.add(cVar);
        fVar.k.h(cVar);
        subscriber.setProducer(cVar);
    }
}
