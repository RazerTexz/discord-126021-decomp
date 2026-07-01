package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorSampleWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n1$a<T> extends Subscriber<T> implements Action0 {
    public static final Object j = new Object();
    public final Subscriber<? super T> k;
    public final AtomicReference<Object> l = new AtomicReference<>(j);

    public n1$a(Subscriber<? super T> subscriber) {
        this.k = subscriber;
    }

    public final void a() {
        AtomicReference<Object> atomicReference = this.l;
        Object obj = j;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != obj) {
            try {
                this.k.onNext(andSet);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                onError(th);
            }
        }
    }

    @Override // rx.functions.Action0
    public void call() {
        a();
    }

    @Override // j0.g
    public void onCompleted() {
        a();
        this.k.onCompleted();
        unsubscribe();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.onError(th);
        unsubscribe();
    }

    @Override // j0.g
    public void onNext(T t) {
        this.l.set(t);
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
