package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.p374l.C4670b;

/* JADX INFO: renamed from: b.i.c.m.d.k.n */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4643n implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f12350j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f12351k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4663x f12352l;

    public CallableC4643n(C4663x c4663x, long j, String str) {
        this.f12352l = c4663x;
        this.f12350j = j;
        this.f12351k = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        if (this.f12352l.m6479p()) {
            return null;
        }
        C4670b c4670b = this.f12352l.f12440t;
        c4670b.f12473d.mo6495e(this.f12350j, this.f12351k);
        return null;
    }
}
