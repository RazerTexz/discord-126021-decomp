package j0.l.a;

import j0.l.b.ProducerArbiter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Scheduler;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.x, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class OnSubscribeRedo5 implements Producer {
    public final /* synthetic */ AtomicLong j;
    public final /* synthetic */ ProducerArbiter k;
    public final /* synthetic */ AtomicBoolean l;
    public final /* synthetic */ Scheduler.Worker m;
    public final /* synthetic */ Action0 n;

    public OnSubscribeRedo5(OnSubscribeRedo6 onSubscribeRedo6, AtomicLong atomicLong, ProducerArbiter producerArbiter, AtomicBoolean atomicBoolean, Scheduler.Worker worker, Action0 action0) {
        this.j = atomicLong;
        this.k = producerArbiter;
        this.l = atomicBoolean;
        this.m = worker;
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
