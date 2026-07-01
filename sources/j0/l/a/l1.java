package j0.l.a;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable$a;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorReplay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l1<T> implements Observable$a<T> {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ Func0 k;

    public l1(AtomicReference atomicReference, Func0 func0) {
        this.j = atomicReference;
        this.k = func0;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        j1$f j1_f;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            j1_f = (j1$f) this.j.get();
            if (j1_f != null) {
                break;
            }
            j1$f j1_f2 = new j1$f((j1$e) this.k.call());
            j1_f2.add(new j0.r.a(new m1(j1_f2)));
            if (this.j.compareAndSet(j1_f, j1_f2)) {
                j1_f = j1_f2;
                break;
            }
        }
        j1$c<T> j1_c = new j1$c<>(j1_f, subscriber);
        if (!j1_f.m) {
            synchronized (j1_f.n) {
                if (!j1_f.m) {
                    j1_f.n.a(j1_c);
                    j1_f.p++;
                }
            }
        }
        subscriber.add(j1_c);
        j1_f.k.h(j1_c);
        subscriber.setProducer(j1_c);
    }
}
