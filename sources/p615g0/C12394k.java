package p615g0;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.k */
/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12394k extends C12408y {

    /* JADX INFO: renamed from: e */
    public C12408y f26094e;

    public C12394k(C12408y c12408y) {
        C12238m.checkParameterIsNotNull(c12408y, "delegate");
        this.f26094e = c12408y;
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: a */
    public C12408y mo10478a() {
        return this.f26094e.mo10478a();
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: b */
    public C12408y mo10479b() {
        return this.f26094e.mo10479b();
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: c */
    public long mo10480c() {
        return this.f26094e.mo10480c();
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: d */
    public C12408y mo10481d(long j) {
        return this.f26094e.mo10481d(j);
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: e */
    public boolean mo10482e() {
        return this.f26094e.mo10482e();
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: f */
    public void mo10483f() throws IOException {
        this.f26094e.mo10483f();
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: g */
    public C12408y mo10484g(long j, TimeUnit timeUnit) {
        C12238m.checkParameterIsNotNull(timeUnit, "unit");
        return this.f26094e.mo10484g(j, timeUnit);
    }

    @Override // p615g0.C12408y
    /* JADX INFO: renamed from: h */
    public long mo10485h() {
        return this.f26094e.mo10485h();
    }
}
