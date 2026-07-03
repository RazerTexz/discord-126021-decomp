package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.C12693a;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.x */
/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12684x implements Producer {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AtomicLong f27076j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C12693a f27077k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ AtomicBoolean f27078l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Scheduler.Worker f27079m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Action0 f27080n;

    public C12684x(C12687y c12687y, AtomicLong atomicLong, C12693a c12693a, AtomicBoolean atomicBoolean, Scheduler.Worker worker, Action0 action0) {
        this.f27076j = atomicLong;
        this.f27077k = c12693a;
        this.f27078l = atomicBoolean;
        this.f27079m = worker;
        this.f27080n = action0;
    }

    @Override // p658rx.Producer
    /* JADX INFO: renamed from: j */
    public void mo10704j(long j) {
        if (j > 0) {
            C3404f.m4276c0(this.f27076j, j);
            this.f27077k.mo10704j(j);
            if (this.f27078l.compareAndSet(true, false)) {
                this.f27079m.mo10740a(this.f27080n);
            }
        }
    }
}
