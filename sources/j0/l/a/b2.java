package j0.l.a;

import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public class b2<T> extends Subscriber<T> {
    public int j;
    public boolean k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ c2 m;

    public b2(c2 c2Var, Subscriber subscriber) {
        this.m = c2Var;
        this.l = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.k) {
            j0.o.l.b(th);
            return;
        }
        this.k = true;
        try {
            this.l.onError(th);
        } finally {
            unsubscribe();
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        if (isUnsubscribed()) {
            return;
        }
        int i = this.j;
        int i2 = i + 1;
        this.j = i2;
        int i3 = this.m.j;
        if (i < i3) {
            boolean z2 = i2 == i3;
            this.l.onNext(t);
            if (!z2 || this.k) {
                return;
            }
            this.k = true;
            try {
                this.l.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.l.setProducer(new b2$a(this, producer));
    }
}
