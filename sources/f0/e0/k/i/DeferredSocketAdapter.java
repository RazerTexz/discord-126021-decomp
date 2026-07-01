package f0.e0.k.i;

import d0.z.d.Intrinsics3;
import f0.Protocol2;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: f0.e0.k.i.j, reason: use source file name */
/* JADX INFO: compiled from: DeferredSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeferredSocketAdapter implements SocketAdapter {
    public SocketAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3655b;

    /* JADX INFO: renamed from: f0.e0.k.i.j$a */
    /* JADX INFO: compiled from: DeferredSocketAdapter.kt */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        SocketAdapter b(SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "socketAdapterFactory");
        this.f3655b = aVar;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f3655b.a(sSLSocket);
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean b() {
        return true;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public String c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        SocketAdapter socketAdapterE = e(sSLSocket);
        if (socketAdapterE != null) {
            return socketAdapterE.c(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        SocketAdapter socketAdapterE = e(sSLSocket);
        if (socketAdapterE != null) {
            socketAdapterE.d(sSLSocket, str, list);
        }
    }

    public final synchronized SocketAdapter e(SSLSocket sSLSocket) {
        if (this.a == null && this.f3655b.a(sSLSocket)) {
            this.a = this.f3655b.b(sSLSocket);
        }
        return this.a;
    }
}
