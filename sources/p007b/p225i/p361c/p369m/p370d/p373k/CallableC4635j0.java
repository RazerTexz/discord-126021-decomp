package p007b.p225i.p361c.p369m.p370d.p373k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.p384s.InterfaceC4736d;

/* JADX INFO: renamed from: b.i.c.m.d.k.j0 */
/* JADX INFO: compiled from: CrashlyticsCore.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4635j0 implements Callable<Task<Void>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC4736d f12323j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4638k0 f12324k;

    public CallableC4635j0(C4638k0 c4638k0, InterfaceC4736d interfaceC4736d) {
        this.f12324k = c4638k0;
        this.f12323j = interfaceC4736d;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return C4638k0.m6439a(this.f12324k, this.f12323j);
    }
}
