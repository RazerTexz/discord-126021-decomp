package p007b.p225i.p361c.p369m;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p369m.p370d.C4595e;
import p007b.p225i.p361c.p369m.p370d.C4596f;
import p007b.p225i.p361c.p369m.p370d.C4598h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4630h1;
import p007b.p225i.p361c.p369m.p370d.p373k.C4638k0;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4635j0;
import p007b.p225i.p361c.p369m.p370d.p373k.RunnableC4636j1;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;

/* JADX INFO: renamed from: b.i.c.m.c */
/* JADX INFO: compiled from: FirebaseCrashlytics.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4590c implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4598h f12222j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ExecutorService f12223k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C4735c f12224l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ boolean f12225m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4638k0 f12226n;

    public CallableC4590c(C4598h c4598h, ExecutorService executorService, C4735c c4735c, boolean z2, C4638k0 c4638k0) {
        this.f12222j = c4598h;
        this.f12223k = executorService;
        this.f12224l = c4735c;
        this.f12225m = z2;
        this.f12226n = c4638k0;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        C4598h c4598h = this.f12222j;
        ExecutorService executorService = this.f12223k;
        C4735c c4735c = this.f12224l;
        C4542c c4542c = c4598h.f12235b;
        c4542c.m6330a();
        c4598h.f12246m.m6451c().mo6023r(executorService, new C4596f(c4598h, c4735c)).mo6023r(executorService, new C4595e(c4598h, c4542c.f12120f.f12135b, c4735c, executorService));
        if (!this.f12225m) {
            return null;
        }
        C4638k0 c4638k0 = this.f12226n;
        C4735c c4735c2 = this.f12224l;
        ExecutorService executorService2 = c4638k0.f12340l;
        CallableC4635j0 callableC4635j0 = new CallableC4635j0(c4638k0, c4735c2);
        FilenameFilter filenameFilter = C4630h1.f12313a;
        executorService2.execute(new RunnableC4636j1(callableC4635j0, new TaskCompletionSource()));
        return null;
    }
}
