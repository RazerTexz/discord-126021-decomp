package f0.e0.k.i;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.Platform2;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: f0.e0.k.i.a, reason: use source file name */
/* JADX INFO: compiled from: Android10SocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public final class Android10SocketAdapter implements SocketAdapter {
    @Override // f0.e0.k.i.SocketAdapter
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean b() {
        return Platform2.c.c() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // f0.e0.k.i.SocketAdapter
    @SuppressLint({"NewApi"})
    public String c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || Intrinsics3.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // f0.e0.k.i.SocketAdapter
    @SuppressLint({"NewApi"})
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Intrinsics3.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
            Object[] array = Platform2.c.a(list).toArray(new String[0]);
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
