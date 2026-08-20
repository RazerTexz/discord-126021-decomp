package p007b.p109f.p161j.p181p;

import java.util.Objects;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: b.f.j.p.z */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2023z extends C1974e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Future f4264a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InterfaceC2002o0.a f4265b;

    public C2023z(C1963a0 c1963a0, Future future, InterfaceC2002o0.a aVar) {
        this.f4264a = future;
        this.f4265b = aVar;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
    /* JADX INFO: renamed from: a */
    public void mo1438a() {
        if (this.f4264a.cancel(false)) {
            C2000n0.a aVar = (C2000n0.a) this.f4265b;
            C2000n0 c2000n0 = C2000n0.this;
            C2019x c2019x = aVar.f4172a;
            Objects.requireNonNull(c2000n0);
            c2019x.m1524a().mo1357d(c2019x.f4259b, "NetworkFetchProducer", null);
            c2019x.f4258a.mo1426d();
        }
    }
}
