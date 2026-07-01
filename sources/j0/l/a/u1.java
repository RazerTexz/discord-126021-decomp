package j0.l.a;

import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorSkipWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public class u1<T> extends Subscriber<T> {
    public boolean j;
    public int k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ w1 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(w1 w1Var, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = w1Var;
        this.l = subscriber2;
        this.j = true;
    }

    @Override // j0.g
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        if (!this.j) {
            this.l.onNext(t);
            return;
        }
        try {
            Func2<? super T, Integer, Boolean> func2 = this.m.j;
            int i = this.k;
            this.k = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                request(1L);
            } else {
                this.j = false;
                this.l.onNext(t);
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, this.l, t);
        }
    }
}
