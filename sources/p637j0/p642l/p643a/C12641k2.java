package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.k2 */
/* JADX INFO: compiled from: OperatorThrottleFirst.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12641k2<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public long f26891j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Subscriber f26892k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C12645l2 f26893l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12641k2(C12645l2 c12645l2, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f26893l = c12645l2;
        this.f26892k = subscriber2;
        this.f26891j = -1L;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f26892k.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26892k.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        Objects.requireNonNull(this.f26893l.f26908k);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f26891j;
        if (j == -1 || jCurrentTimeMillis < j || jCurrentTimeMillis - j >= this.f26893l.f26907j) {
            this.f26891j = jCurrentTimeMillis;
            this.f26892k.onNext(t);
        }
    }

    @Override // p658rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
