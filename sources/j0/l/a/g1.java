package j0.l.a;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g1<T> implements Observable$a<T> {
    public final /* synthetic */ AtomicReference j;

    public g1(AtomicReference atomicReference) {
        this.j = atomicReference;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            h1$b h1_b = (h1$b) this.j.get();
            if (h1_b == null || h1_b.isUnsubscribed()) {
                h1$b h1_b2 = new h1$b(this.j);
                h1_b2.add(new j0.r.a(new i1(h1_b2)));
                if (this.j.compareAndSet(h1_b, h1_b2)) {
                    h1_b = h1_b2;
                } else {
                    continue;
                }
            }
            h1$a h1_a = new h1$a(h1_b, subscriber);
            while (true) {
                h1$a[] h1_aArr = h1_b.o.get();
                z2 = false;
                if (h1_aArr == h1$b.k) {
                    break;
                }
                int length = h1_aArr.length;
                h1$a[] h1_aArr2 = new h1$a[length + 1];
                System.arraycopy(h1_aArr, 0, h1_aArr2, 0, length);
                h1_aArr2[length] = h1_a;
                if (h1_b.o.compareAndSet(h1_aArr, h1_aArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                subscriber.add(h1_a);
                subscriber.setProducer(h1_a);
                return;
            }
        }
    }
}
