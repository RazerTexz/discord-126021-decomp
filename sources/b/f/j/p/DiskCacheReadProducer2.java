package b.f.j.p;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.f.j.p.r, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheReadProducer2 extends BaseProducerContextCallbacks {
    public final /* synthetic */ AtomicBoolean a;

    public DiskCacheReadProducer2(DiskCacheReadProducer3 diskCacheReadProducer3, AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // b.f.j.p.ProducerContextCallbacks
    public void a() {
        this.a.set(true);
    }
}
