package j0.l.e;

import j0.l.e.ScalarSynchronousObservable;
import rx.Scheduler;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.e.l, reason: use source file name */
/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class ScalarSynchronousObservable2 implements Action0 {
    public final /* synthetic */ Action0 j;
    public final /* synthetic */ Scheduler.Worker k;

    public ScalarSynchronousObservable2(ScalarSynchronousObservable.b bVar, Action0 action0, Scheduler.Worker worker) {
        this.j = action0;
        this.k = worker;
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
