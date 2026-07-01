package b.f.j.p;

import b.f.j.j.EncodedImage2;
import java.util.concurrent.CancellationException;
import z.Continuation3;
import z.Task6;

/* JADX INFO: renamed from: b.f.j.p.q, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheReadProducer implements Continuation3<EncodedImage2, Void> {
    public final /* synthetic */ ProducerListener2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProducerContext f634b;
    public final /* synthetic */ Consumer2 c;
    public final /* synthetic */ DiskCacheReadProducer3 d;

    public DiskCacheReadProducer(DiskCacheReadProducer3 diskCacheReadProducer3, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer2 consumer2) {
        this.d = diskCacheReadProducer3;
        this.a = producerListener2;
        this.f634b = producerContext;
        this.c = consumer2;
    }

    @Override // z.Continuation3
    public Void a(Task6<EncodedImage2> task6) throws Exception {
        boolean z2;
        EncodedImage2 encodedImage2;
        synchronized (task6.g) {
            z2 = task6.i;
        }
        if (z2 || (task6.e() && (task6.d() instanceof CancellationException))) {
            this.a.d(this.f634b, "DiskCacheProducer", null);
            this.c.d();
        } else if (task6.e()) {
            this.a.k(this.f634b, "DiskCacheProducer", task6.d(), null);
            this.d.d.b(this.c, this.f634b);
        } else {
            synchronized (task6.g) {
                encodedImage2 = task6.j;
            }
            EncodedImage2 encodedImage3 = encodedImage2;
            if (encodedImage3 != null) {
                ProducerListener2 producerListener2 = this.a;
                ProducerContext producerContext = this.f634b;
                producerListener2.j(producerContext, "DiskCacheProducer", DiskCacheReadProducer3.c(producerListener2, producerContext, true, encodedImage3.n()));
                this.a.c(this.f634b, "DiskCacheProducer", true);
                this.f634b.n("disk");
                this.c.a(1.0f);
                this.c.b(encodedImage3, 1);
                encodedImage3.close();
            } else {
                ProducerListener2 producerListener3 = this.a;
                ProducerContext producerContext2 = this.f634b;
                producerListener3.j(producerContext2, "DiskCacheProducer", DiskCacheReadProducer3.c(producerListener3, producerContext2, false, 0));
                this.d.d.b(this.c, this.f634b);
            }
        }
        return null;
    }
}
