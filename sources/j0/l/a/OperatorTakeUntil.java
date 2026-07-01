package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorTakeUntil<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorTakeUntil(OperatorTakeUntil3 operatorTakeUntil3, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.j = subscriber2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        try {
            this.j.onCompleted();
        } finally {
            this.j.unsubscribe();
        }
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        try {
            this.j.onError(th);
        } finally {
            this.j.unsubscribe();
        }
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
