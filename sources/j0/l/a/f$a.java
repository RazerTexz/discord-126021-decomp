package j0.l.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a<T, R> extends Subscriber<T> {
    public final f$b<T, R> j;
    public final int k;
    public boolean l;

    public f$a(f$b<T, R> f_b, int i) {
        this.j = f_b;
        this.k = i;
        request(f_b.bufferSize);
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.j.c(null, this.k);
    }

    @Override // j0.g
    public void onError(Throwable th) {
        Throwable th2;
        Throwable compositeException;
        if (this.l) {
            j0.o.l.b(th);
            return;
        }
        AtomicReference<Throwable> atomicReference = this.j.error;
        do {
            th2 = atomicReference.get();
            if (th2 == null) {
                compositeException = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                compositeException = new CompositeException(arrayList);
            } else {
                compositeException = new CompositeException(Arrays.asList(th2, th));
            }
        } while (!atomicReference.compareAndSet(th2, compositeException));
        this.l = true;
        this.j.c(null, this.k);
    }

    @Override // j0.g
    public void onNext(T t) {
        if (this.l) {
            return;
        }
        f$b<T, R> f_b = this.j;
        if (t == null) {
            t = (T) e.f3771b;
        }
        f_b.c(t, this.k);
    }
}
