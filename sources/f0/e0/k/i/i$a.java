package f0.e0.k.i;

import d0.z.d.m;
import f0.e0.k.d$a;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a implements j$a {
    @Override // f0.e0.k.i.j$a
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        d$a d_a = f0.e0.k.d.e;
        return f0.e0.k.d.d && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // f0.e0.k.i.j$a
    public k b(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return new i();
    }
}
