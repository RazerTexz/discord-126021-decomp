package f0.e0.g;

import b.d.b.a.outline;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import f0.CipherSuite;
import f0.ConnectionSpec;
import f0.e0.Util7;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: f0.e0.g.b, reason: use source file name */
/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionSpecSelector {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3613b;
    public boolean c;
    public final List<ConnectionSpec> d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        Intrinsics3.checkParameterIsNotNull(list, "connectionSpecs");
        this.d = list;
    }

    public final ConnectionSpec a(SSLSocket sSLSocket) throws IOException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        int i = this.a;
        int size = this.d.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.d.get(i);
            if (connectionSpec.b(sSLSocket)) {
                this.a = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec == null) {
            StringBuilder sbU = outline.U("Unable to find acceptable protocols. isFallback=");
            sbU.append(this.c);
            sbU.append(',');
            sbU.append(" modes=");
            sbU.append(this.d);
            sbU.append(',');
            sbU.append(" supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            if (enabledProtocols2 == null) {
                Intrinsics3.throwNpe();
            }
            String string = Arrays.toString(enabledProtocols2);
            Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbU.append(string);
            throw new UnknownServiceException(sbU.toString());
        }
        int i2 = this.a;
        int size2 = this.d.size();
        while (true) {
            if (i2 >= size2) {
                z2 = false;
                break;
            }
            if (this.d.get(i2).b(sSLSocket)) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.f3613b = z2;
        boolean z3 = this.c;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (connectionSpec.g != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            String[] strArr = connectionSpec.g;
            CipherSuite.b bVar = CipherSuite.f3673s;
            Comparator<String> comparator = CipherSuite.a;
            enabledCipherSuites = Util7.q(enabledCipherSuites2, strArr, CipherSuite.a);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (connectionSpec.h != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            Intrinsics3.checkExpressionValueIsNotNull(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = Util7.q(enabledProtocols3, connectionSpec.h, d0.u.a.naturalOrder());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics3.checkExpressionValueIsNotNull(supportedCipherSuites, "supportedCipherSuites");
        CipherSuite.b bVar2 = CipherSuite.f3673s;
        Comparator<String> comparator2 = CipherSuite.a;
        Comparator<String> comparator3 = CipherSuite.a;
        byte[] bArr = Util7.a;
        Intrinsics3.checkParameterIsNotNull(supportedCipherSuites, "$this$indexOf");
        Intrinsics3.checkParameterIsNotNull("TLS_FALLBACK_SCSV", "value");
        Intrinsics3.checkParameterIsNotNull(comparator3, "comparator");
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (((CipherSuite.a) comparator3).compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z3 && i3 != -1) {
            Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i3];
            Intrinsics3.checkExpressionValueIsNotNull(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Intrinsics3.checkParameterIsNotNull(enabledCipherSuites, "$this$concat");
            Intrinsics3.checkParameterIsNotNull(str, "value");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            Intrinsics3.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[_Arrays.getLastIndex(enabledCipherSuites)] = str;
        }
        ConnectionSpec.a aVar = new ConnectionSpec.a(connectionSpec);
        Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
        aVar.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        Intrinsics3.checkExpressionValueIsNotNull(enabledProtocols, "tlsVersionsIntersection");
        aVar.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        ConnectionSpec connectionSpecA = aVar.a();
        if (connectionSpecA.c() != null) {
            sSLSocket.setEnabledProtocols(connectionSpecA.h);
        }
        if (connectionSpecA.a() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpecA.g);
        }
        return connectionSpec;
    }
}
