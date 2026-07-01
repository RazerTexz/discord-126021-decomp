package f0.e0.k.i;

import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.BouncyCastlePlatform;
import f0.e0.k.Platform2;
import f0.e0.k.i.DeferredSocketAdapter;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: renamed from: f0.e0.k.i.g, reason: use source file name */
/* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BouncyCastleSocketAdapter implements SocketAdapter {
    public static final DeferredSocketAdapter.a a = new a();

    /* JADX INFO: renamed from: f0.e0.k.i.g$a */
    /* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
    public static final class a implements DeferredSocketAdapter.a {
        @Override // f0.e0.k.i.DeferredSocketAdapter.a
        public boolean a(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            BouncyCastlePlatform.a aVar = BouncyCastlePlatform.e;
            return BouncyCastlePlatform.d && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // f0.e0.k.i.DeferredSocketAdapter.a
        public SocketAdapter b(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new BouncyCastleSocketAdapter();
        }
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean b() {
        BouncyCastlePlatform.a aVar = BouncyCastlePlatform.e;
        return BouncyCastlePlatform.d;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public String c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || Intrinsics3.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Intrinsics3.checkExpressionValueIsNotNull(parameters, "sslParameters");
            Object[] array = Platform2.c.a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
