package b.f.j.p;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.f.j.p.q0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer2 extends BaseProducerContextCallbacks {
    public final /* synthetic */ AtomicBoolean a;

    public PartialDiskCacheProducer2(PartialDiskCacheProducer3 partialDiskCacheProducer3, AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // b.f.j.p.ProducerContextCallbacks
    public void a() {
        this.a.set(true);
    }
}
