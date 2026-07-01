package j0.l.a;

import j0.l.a.OperatorPublish2;
import j0.r.BooleanSubscription;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.g1, reason: use source file name */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorPublish<T> implements Observable.a<T> {
    public final /* synthetic */ AtomicReference j;

    public OperatorPublish(AtomicReference atomicReference) {
        this.j = atomicReference;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            OperatorPublish2.b bVar = (OperatorPublish2.b) this.j.get();
            if (bVar == null || bVar.isUnsubscribed()) {
                OperatorPublish2.b bVar2 = new OperatorPublish2.b(this.j);
                bVar2.add(new BooleanSubscription(new OperatorPublish3(bVar2)));
                if (this.j.compareAndSet(bVar, bVar2)) {
                    bVar = bVar2;
                } else {
                    continue;
                }
            }
            OperatorPublish2.a aVar = new OperatorPublish2.a(bVar, subscriber);
            while (true) {
                OperatorPublish2.a[] aVarArr = bVar.o.get();
                z2 = false;
                if (aVarArr == OperatorPublish2.b.k) {
                    break;
                }
                int length = aVarArr.length;
                OperatorPublish2.a[] aVarArr2 = new OperatorPublish2.a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (bVar.o.compareAndSet(aVarArr, aVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                subscriber.add(aVar);
                subscriber.setProducer(aVar);
                return;
            }
        }
    }
}
