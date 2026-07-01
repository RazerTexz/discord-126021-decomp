package g0;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k extends y {
    public y e;

    public k(y yVar) {
        d0.z.d.m.checkParameterIsNotNull(yVar, "delegate");
        this.e = yVar;
    }

    @Override // g0.y
    public y a() {
        return this.e.a();
    }

    @Override // g0.y
    public y b() {
        return this.e.b();
    }

    @Override // g0.y
    public long c() {
        return this.e.c();
    }

    @Override // g0.y
    public y d(long j) {
        return this.e.d(j);
    }

    @Override // g0.y
    public boolean e() {
        return this.e.e();
    }

    @Override // g0.y
    public void f() throws IOException {
        this.e.f();
    }

    @Override // g0.y
    public y g(long j, TimeUnit timeUnit) {
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "unit");
        return this.e.g(j, timeUnit);
    }

    @Override // g0.y
    public long h() {
        return this.e.h();
    }
}
