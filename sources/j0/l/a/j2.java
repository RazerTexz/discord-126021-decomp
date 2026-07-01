package j0.l.a;

import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: OperatorTakeWhile.java */
/* JADX INFO: loaded from: classes3.dex */
public class j2<T> extends Subscriber<T> {
    public int j;
    public boolean k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ i2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(i2 i2Var, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.m = i2Var;
        this.l = subscriber2;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.k) {
            return;
        }
        this.l.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        try {
            Func2<? super T, ? super Integer, Boolean> func2 = this.m.j;
            int i = this.j;
            this.j = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                this.l.onNext(t);
                return;
            }
            this.k = true;
            this.l.onCompleted();
            unsubscribe();
        } catch (Throwable th) {
            this.k = true;
            b.i.a.f.e.o.f.p1(th, this.l, t);
            unsubscribe();
        }
    }
}
