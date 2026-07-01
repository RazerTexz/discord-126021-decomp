package j0.l.e;

import rx.Scheduler$Worker;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Action0 {
    public final /* synthetic */ Action0 j;
    public final /* synthetic */ Scheduler$Worker k;

    public l(k$b k_b, Action0 action0, Scheduler$Worker scheduler$Worker) {
        this.j = action0;
        this.k = scheduler$Worker;
    }

    @Override // rx.functions.Action0
    public void call() {
        try {
            this.j.call();
        } finally {
            this.k.unsubscribe();
        }
    }
}
