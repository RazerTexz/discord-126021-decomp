package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.i.c.m.d.k.a0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4608a0 implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f12257j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4663x f12258k;

    public CallableC4608a0(C4663x c4663x, long j) {
        this.f12258k = c4663x;
        this.f12257j = j;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.f12257j);
        this.f12258k.f12446z.mo6386a("_ae", bundle);
        return null;
    }
}
