package f0.e0.g;

import f0.j$a;
import f0.j$b;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3613b;
    public boolean c;
    public final List<f0.m> d;

    public b(List<f0.m> list) {
        d0.z.d.m.checkParameterIsNotNull(list, "connectionSpecs");
        this.d = list;
    }

    public final f0.m a(SSLSocket sSLSocket) throws IOException, CloneNotSupportedException {
        f0.m mVar;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        d0.z.d.m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        int i = this.a;
        int size = this.d.size();
        while (true) {
            if (i >= size) {
                mVar = null;
                break;
            }
            mVar = this.d.get(i);
            if (mVar.b(sSLSocket)) {
                this.a = i + 1;
                break;
            }
            i++;
        }
        if (mVar == null) {
            StringBuilder sbU = b.d.b.a.a.U("Unable to find acceptable protocols. isFallback=");
            sbU.append(this.c);
            sbU.append(',');
            sbU.append(" modes=");
            sbU.append(this.d);
            sbU.append(',');
            sbU.append(" supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            if (enabledProtocols2 == null) {
                d0.z.d.m.throwNpe();
            }
            String string = Arrays.toString(enabledProtocols2);
            d0.z.d.m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
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
        d0.z.d.m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (mVar.g != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            d0.z.d.m.checkExpressionValueIsNotNull(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            String[] strArr = mVar.g;
            j$b j_b = f0.j.f3673s;
            Comparator<String> comparator = f0.j.a;
            enabledCipherSuites = f0.e0.c.q(enabledCipherSuites2, strArr, f0.j.a);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (mVar.h != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            d0.z.d.m.checkExpressionValueIsNotNull(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = f0.e0.c.q(enabledProtocols3, mVar.h, d0.u.a.naturalOrder());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        d0.z.d.m.checkExpressionValueIsNotNull(supportedCipherSuites, "supportedCipherSuites");
        j$b j_b2 = f0.j.f3673s;
        Comparator<String> comparator2 = f0.j.a;
        Comparator<String> comparator3 = f0.j.a;
        byte[] bArr = f0.e0.c.a;
        d0.z.d.m.checkParameterIsNotNull(supportedCipherSuites, "$this$indexOf");
        d0.z.d.m.checkParameterIsNotNull("TLS_FALLBACK_SCSV", "value");
        d0.z.d.m.checkParameterIsNotNull(comparator3, "comparator");
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (((j$a) comparator3).compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z3 && i3 != -1) {
            d0.z.d.m.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i3];
            d0.z.d.m.checkExpressionValueIsNotNull(str, "supportedCipherSuites[indexOfFallbackScsv]");
            d0.z.d.m.checkParameterIsNotNull(enabledCipherSuites, "$this$concat");
            d0.z.d.m.checkParameterIsNotNull(str, "value");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            d0.z.d.m.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[d0.t.k.getLastIndex(enabledCipherSuites)] = str;
        }
        f0.m$a m_a = new f0.m$a(mVar);
        d0.z.d.m.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
        m_a.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        d0.z.d.m.checkExpressionValueIsNotNull(enabledProtocols, "tlsVersionsIntersection");
        m_a.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        f0.m mVarA = m_a.a();
        if (mVarA.c() != null) {
            sSLSocket.setEnabledProtocols(mVarA.h);
        }
        if (mVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(mVarA.g);
        }
        return mVar;
    }
}
