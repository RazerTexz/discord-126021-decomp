package j0.l.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Scheduler$Worker;
import rx.functions.Action0;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class x implements Producer {
    public final /* synthetic */ AtomicLong j;
    public final /* synthetic */ j0.l.b.a k;
    public final /* synthetic */ AtomicBoolean l;
    public final /* synthetic */ Scheduler$Worker m;
    public final /* synthetic */ Action0 n;

    public x(y yVar, AtomicLong atomicLong, j0.l.b.a aVar, AtomicBoolean atomicBoolean, Scheduler$Worker scheduler$Worker, Action0 action0) {
        this.j = atomicLong;
        this.k = aVar;
        this.l = atomicBoolean;
        this.m = scheduler$Worker;
        this.n = action0;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j > 0) {
            b.i.a.f.e.o.f.c0(this.j, j);
            this.k.j(j);
            if (this.l.compareAndSet(true, false)) {
                this.m.a(this.n);
            }
        }
    }
}
