package f0.e0.k.i;

import d0.z.d.m;
import f0.y;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: DeferredSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements k {
    public k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j$a f3655b;

    public j(j$a j_a) {
        m.checkParameterIsNotNull(j_a, "socketAdapterFactory");
        this.f3655b = j_a;
    }

    @Override // f0.e0.k.i.k
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f3655b.a(sSLSocket);
    }

    @Override // f0.e0.k.i.k
    public boolean b() {
        return true;
    }

    @Override // f0.e0.k.i.k
    public String c(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        k kVarE = e(sSLSocket);
        if (kVarE != null) {
            return kVarE.c(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.i.k
    public void d(SSLSocket sSLSocket, String str, List<? extends y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        k kVarE = e(sSLSocket);
        if (kVarE != null) {
            kVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized k e(SSLSocket sSLSocket) {
        if (this.a == null && this.f3655b.a(sSLSocket)) {
            this.a = this.f3655b.b(sSLSocket);
        }
        return this.a;
    }
}
