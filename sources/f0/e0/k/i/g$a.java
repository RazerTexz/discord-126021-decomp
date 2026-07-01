package f0.e0.k.i;

import d0.z.d.m;
import f0.e0.k.c$a;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a implements j$a {
    @Override // f0.e0.k.i.j$a
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        c$a c_a = f0.e0.k.c.e;
        return f0.e0.k.c.d && (sSLSocket instanceof BCSSLSocket);
    }

    @Override // f0.e0.k.i.j$a
    public k b(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return new g();
    }
}
