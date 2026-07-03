package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: j0.l.a.e2 */
/* JADX INFO: compiled from: OperatorTakeUntil.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12617e2<E> extends Subscriber<E> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26779j;

    public C12617e2(C12621f2 c12621f2, Subscriber subscriber) {
        this.f26779j = subscriber;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f26779j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26779j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(E e) {
        this.f26779j.onCompleted();
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
