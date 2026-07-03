package p600f0.p601e0.p609k.p610i;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.C12333h;

/* JADX INFO: renamed from: f0.e0.k.i.a */
/* JADX INFO: compiled from: Android10SocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public final class C12334a implements InterfaceC12344k {
    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        return C12333h.f25785c.m10333c() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || C12238m.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends EnumC12381y> list) throws IOException {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            C12238m.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
            Object[] array = C12333h.f25785c.m10331a(list).toArray(new String[0]);
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
