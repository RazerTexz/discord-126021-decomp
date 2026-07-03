package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.j.p.o */
/* JADX INFO: compiled from: DelayProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2001o implements InterfaceC2018w0<CloseableReference<AbstractC1917c>> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2018w0<CloseableReference<AbstractC1917c>> f4174a;

    /* JADX INFO: renamed from: b */
    public final ScheduledExecutorService f4175b;

    /* JADX INFO: renamed from: b.f.j.p.o$a */
    /* JADX INFO: compiled from: DelayProducer.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC1995l f4176j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ InterfaceC2020x0 f4177k;

        public a(InterfaceC1995l interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
            this.f4176j = interfaceC1995l;
            this.f4177k = interfaceC2020x0;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2001o.this.f4174a.mo1417b(this.f4176j, this.f4177k);
        }
    }

    public C2001o(InterfaceC2018w0<CloseableReference<AbstractC1917c>> interfaceC2018w0, ScheduledExecutorService scheduledExecutorService) {
        this.f4174a = interfaceC2018w0;
        this.f4175b = scheduledExecutorService;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2018w0
    /* JADX INFO: renamed from: b */
    public void mo1417b(InterfaceC1995l<CloseableReference<AbstractC1917c>> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
        ImageRequest imageRequestMo1447e = interfaceC2020x0.mo1447e();
        ScheduledExecutorService scheduledExecutorService = this.f4175b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new a(interfaceC1995l, interfaceC2020x0), imageRequestMo1447e.f19603u, TimeUnit.MILLISECONDS);
        } else {
            this.f4174a.mo1417b(interfaceC1995l, interfaceC2020x0);
        }
    }
}
