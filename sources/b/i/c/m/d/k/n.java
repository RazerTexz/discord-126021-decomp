package b.i.c.m.d.k;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements Callable<Void> {
    public final /* synthetic */ long j;
    public final /* synthetic */ String k;
    public final /* synthetic */ x l;

    public n(x xVar, long j, String str) {
        this.l = xVar;
        this.j = j;
        this.k = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        if (this.l.p()) {
            return null;
        }
        b.i.c.m.d.l.b bVar = this.l.t;
        bVar.d.e(this.j, this.k);
        return null;
    }
}
