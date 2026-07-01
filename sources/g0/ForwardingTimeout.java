package g0;

import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: g0.k, reason: use source file name */
/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingTimeout extends Timeout2 {
    public Timeout2 e;

    public ForwardingTimeout(Timeout2 timeout2) {
        Intrinsics3.checkParameterIsNotNull(timeout2, "delegate");
        this.e = timeout2;
    }

    @Override // g0.Timeout2
    public Timeout2 a() {
        return this.e.a();
    }

    @Override // g0.Timeout2
    public Timeout2 b() {
        return this.e.b();
    }

    @Override // g0.Timeout2
    public long c() {
        return this.e.c();
    }

    @Override // g0.Timeout2
    public Timeout2 d(long j) {
        return this.e.d(j);
    }

    @Override // g0.Timeout2
    public boolean e() {
        return this.e.e();
    }

    @Override // g0.Timeout2
    public void f() throws IOException {
        this.e.f();
    }

    @Override // g0.Timeout2
    public Timeout2 g(long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        return this.e.g(j, timeUnit);
    }

    @Override // g0.Timeout2
    public long h() {
        return this.e.h();
    }
}
