package p637j0.p642l.p643a;

import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d2 */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12613d2<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26767j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12613d2(C12621f2 c12621f2, Subscriber subscriber, boolean z2, Subscriber subscriber2) {
        super(subscriber, z2);
        this.f26767j = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        try {
            this.f26767j.onCompleted();
        } finally {
            this.f26767j.unsubscribe();
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        try {
            this.f26767j.onError(th);
        } finally {
            this.f26767j.unsubscribe();
        }
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f26767j.onNext(t);
    }
}
