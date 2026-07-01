package f0.e0.k.i;

import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.ConscryptPlatform;
import f0.e0.k.Platform2;
import f0.e0.k.i.DeferredSocketAdapter;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.conscrypt.Conscrypt;

/* JADX INFO: renamed from: f0.e0.k.i.i, reason: use source file name */
/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final DeferredSocketAdapter.a a = new a();

    /* JADX INFO: renamed from: f0.e0.k.i.i$a */
    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class a implements DeferredSocketAdapter.a {
        @Override // f0.e0.k.i.DeferredSocketAdapter.a
        public boolean a(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            ConscryptPlatform.a aVar = ConscryptPlatform.e;
            return ConscryptPlatform.d && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // f0.e0.k.i.DeferredSocketAdapter.a
        public SocketAdapter b(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new ConscryptSocketAdapter();
        }
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean b() {
        ConscryptPlatform.a aVar = ConscryptPlatform.e;
        return ConscryptPlatform.d;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public String c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = Platform2.c.a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
