package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h2$a<T> extends Subscriber<T> {
    public final Subscriber<? super T> j;
    public boolean k;
    public final /* synthetic */ h2 l;

    public h2$a(h2 h2Var, Subscriber<? super T> subscriber) {
        this.l = h2Var;
        this.j = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.k) {
            return;
        }
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
        try {
            if (this.l.j.call(t).booleanValue()) {
                this.k = true;
                this.j.onCompleted();
                unsubscribe();
            }
        } catch (Throwable th) {
            this.k = true;
            b.i.a.f.e.o.f.p1(th, this.j, t);
            unsubscribe();
        }
    }
}
