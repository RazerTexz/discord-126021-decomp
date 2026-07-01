package b.f.j.p;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class q0 extends e {
    public final /* synthetic */ AtomicBoolean a;

    public q0(r0 r0Var, AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // b.f.j.p.y0
    public void a() {
        this.a.set(true);
    }
}
