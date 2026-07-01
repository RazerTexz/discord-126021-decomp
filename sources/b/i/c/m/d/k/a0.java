package b.i.c.m.d.k;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 implements Callable<Void> {
    public final /* synthetic */ long j;
    public final /* synthetic */ x k;

    public a0(x xVar, long j) {
        this.k = xVar;
        this.j = j;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.j);
        this.k.f1703z.a("_ae", bundle);
        return null;
    }
}
