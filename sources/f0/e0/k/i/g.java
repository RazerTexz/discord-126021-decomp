package f0.e0.k.i;

import d0.z.d.m;
import f0.e0.k.c$a;
import f0.y;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements k {
    public static final j$a a = new g$a();

    @Override // f0.e0.k.i.k
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // f0.e0.k.i.k
    public boolean b() {
        c$a c_a = f0.e0.k.c.e;
        return f0.e0.k.c.d;
    }

    @Override // f0.e0.k.i.k
    public String c(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || m.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // f0.e0.k.i.k
    public void d(SSLSocket sSLSocket, String str, List<? extends y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            m.checkExpressionValueIsNotNull(parameters, "sslParameters");
            Object[] array = f0.e0.k.h.c.a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
