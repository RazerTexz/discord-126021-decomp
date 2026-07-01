package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DelayProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f631b;

    public o(w0<CloseableReference<b.f.j.j.c>> w0Var, ScheduledExecutorService scheduledExecutorService) {
        this.a = w0Var;
        this.f631b = scheduledExecutorService;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        ImageRequest imageRequestE = x0Var.e();
        ScheduledExecutorService scheduledExecutorService = this.f631b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new o$a(this, lVar, x0Var), imageRequestE.u, TimeUnit.MILLISECONDS);
        } else {
            this.a.b(lVar, x0Var);
        }
    }
}
