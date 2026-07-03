package p637j0.p642l.p645c;

import java.util.concurrent.ThreadFactory;
import p658rx.Scheduler;

/* JADX INFO: renamed from: j0.l.c.f */
/* JADX INFO: compiled from: NewThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12701f extends Scheduler {

    /* JADX INFO: renamed from: a */
    public final ThreadFactory f27222a;

    public C12701f(ThreadFactory threadFactory) {
        this.f27222a = threadFactory;
    }

    @Override // p658rx.Scheduler
    /* JADX INFO: renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new C12702g(this.f27222a);
    }
}
