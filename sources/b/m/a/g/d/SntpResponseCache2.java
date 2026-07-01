package b.m.a.g.d;

import b.m.a.Clock5;
import b.m.a.SyncResponseCache;
import b.m.a.g.d.SntpClient;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.m.a.g.d.g, reason: use source file name */
/* JADX INFO: compiled from: SntpResponseCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SntpResponseCache2 implements SntpResponseCache {
    public final SyncResponseCache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Clock5 f1908b;

    public SntpResponseCache2(SyncResponseCache syncResponseCache, Clock5 clock5) {
        Intrinsics3.checkParameterIsNotNull(syncResponseCache, "syncResponseCache");
        Intrinsics3.checkParameterIsNotNull(clock5, "deviceClock");
        this.a = syncResponseCache;
        this.f1908b = clock5;
    }

    @Override // b.m.a.g.d.SntpResponseCache
    public void a(SntpClient.b bVar) {
        Intrinsics3.checkParameterIsNotNull(bVar, "response");
        this.a.f(bVar.a);
        this.a.a(bVar.f1907b);
        this.a.b(bVar.c);
    }

    @Override // b.m.a.g.d.SntpResponseCache
    public void clear() {
        this.a.clear();
    }

    @Override // b.m.a.g.d.SntpResponseCache
    public SntpClient.b get() {
        long jE = this.a.e();
        long jC = this.a.c();
        long jD = this.a.d();
        if (jC == 0) {
            return null;
        }
        return new SntpClient.b(jE, jC, jD, this.f1908b);
    }
}
