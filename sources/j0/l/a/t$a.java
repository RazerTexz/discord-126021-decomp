package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$a<T> extends Subscriber<T> {
    public boolean j;
    public final /* synthetic */ t k;

    public t$a(t tVar) {
        this.k = tVar;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.j) {
            return;
        }
        this.j = true;
        unsubscribe();
        this.k.k.onNext(j0.f.a);
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.j) {
            return;
        }
        this.j = true;
        unsubscribe();
        this.k.k.onNext(new j0.f(j0.f$a.OnError, null, th));
    }

    @Override // j0.g
    public void onNext(T t) {
        long j;
        if (this.j) {
            return;
        }
        this.k.j.onNext(t);
        do {
            j = this.k.m.get();
            if (j == RecyclerView.FOREVER_NS) {
                break;
            }
        } while (!this.k.m.compareAndSet(j, j - 1));
        this.k.l.b(1L);
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.k.l.c(producer);
    }
}
