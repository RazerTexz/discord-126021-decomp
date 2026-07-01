package b.f.j.p;

import java.util.Objects;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends e {
    public final /* synthetic */ Future a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0$a f643b;

    public z(a0 a0Var, Future future, o0$a o0_a) {
        this.a = future;
        this.f643b = o0_a;
    }

    @Override // b.f.j.p.y0
    public void a() {
        if (this.a.cancel(false)) {
            n0$a n0_a = (n0$a) this.f643b;
            n0 n0Var = n0_a.f630b;
            x xVar = n0_a.a;
            Objects.requireNonNull(n0Var);
            xVar.a().d(xVar.f642b, "NetworkFetchProducer", null);
            xVar.a.d();
        }
    }
}
