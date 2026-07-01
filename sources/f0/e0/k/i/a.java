package f0.e0.k.i;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build$VERSION;
import d0.z.d.m;
import f0.y;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: Android10SocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public final class a implements k {
    @Override // f0.e0.k.i.k
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // f0.e0.k.i.k
    public boolean b() {
        return f0.e0.k.h.c.c() && Build$VERSION.SDK_INT >= 29;
    }

    @Override // f0.e0.k.i.k
    @SuppressLint({"NewApi"})
    public String c(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || m.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // f0.e0.k.i.k
    @SuppressLint({"NewApi"})
    public void d(SSLSocket sSLSocket, String str, List<? extends y> list) throws IOException {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            m.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
            Object[] array = f0.e0.k.h.c.a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
