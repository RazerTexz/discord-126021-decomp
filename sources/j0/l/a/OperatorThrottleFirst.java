package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.k2, reason: use source file name */
/* JADX INFO: compiled from: OperatorThrottleFirst.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorThrottleFirst<T> extends Subscriber<T> {
    public long j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ OperatorThrottleFirst2 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorThrottleFirst(OperatorThrottleFirst2 operatorThrottleFirst2, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.l = operatorThrottleFirst2;
        this.k = subscriber2;
        this.j = -1L;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        Objects.requireNonNull(this.l.k);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.j;
        if (j == -1 || jCurrentTimeMillis < j || jCurrentTimeMillis - j >= this.l.j) {
            this.j = jCurrentTimeMillis;
            this.k.onNext(t);
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
