package p600f0.p601e0.p605g;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12141k;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12366j;
import p600f0.C12369m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.g.b */
/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12282b {

    /* JADX INFO: renamed from: a */
    public int f25433a;

    /* JADX INFO: renamed from: b */
    public boolean f25434b;

    /* JADX INFO: renamed from: c */
    public boolean f25435c;

    /* JADX INFO: renamed from: d */
    public final List<C12369m> f25436d;

    public C12282b(List<C12369m> list) {
        C12238m.checkParameterIsNotNull(list, "connectionSpecs");
        this.f25436d = list;
    }

    /* JADX INFO: renamed from: a */
    public final C12369m m10166a(SSLSocket sSLSocket) throws IOException, CloneNotSupportedException {
        C12369m c12369m;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        int i = this.f25433a;
        int size = this.f25436d.size();
        while (true) {
            if (i >= size) {
                c12369m = null;
                break;
            }
            c12369m = this.f25436d.get(i);
            if (c12369m.m10376b(sSLSocket)) {
                this.f25433a = i + 1;
                break;
            }
            i++;
        }
        if (c12369m == null) {
            StringBuilder sbM833U = C1643a.m833U("Unable to find acceptable protocols. isFallback=");
            sbM833U.append(this.f25435c);
            sbM833U.append(',');
            sbM833U.append(" modes=");
            sbM833U.append(this.f25436d);
            sbM833U.append(',');
            sbM833U.append(" supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            if (enabledProtocols2 == null) {
                C12238m.throwNpe();
            }
            String string = Arrays.toString(enabledProtocols2);
            C12238m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbM833U.append(string);
            throw new UnknownServiceException(sbM833U.toString());
        }
        int i2 = this.f25433a;
        int size2 = this.f25436d.size();
        while (true) {
            if (i2 >= size2) {
                z2 = false;
                break;
            }
            if (this.f25436d.get(i2).m10376b(sSLSocket)) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.f25434b = z2;
        boolean z3 = this.f25435c;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (c12369m.f25936g != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            C12238m.checkExpressionValueIsNotNull(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            String[] strArr = c12369m.f25936g;
            C12366j.b bVar = C12366j.f25927s;
            Comparator<String> comparator = C12366j.f25909a;
            enabledCipherSuites = C12272c.m10136q(enabledCipherSuites2, strArr, C12366j.f25909a);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (c12369m.f25937h != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            C12238m.checkExpressionValueIsNotNull(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = C12272c.m10136q(enabledProtocols3, c12369m.f25937h, C12169a.naturalOrder());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        C12238m.checkExpressionValueIsNotNull(supportedCipherSuites, "supportedCipherSuites");
        C12366j.b bVar2 = C12366j.f25927s;
        Comparator<String> comparator2 = C12366j.f25909a;
        Comparator<String> comparator3 = C12366j.f25909a;
        byte[] bArr = C12272c.f25397a;
        C12238m.checkParameterIsNotNull(supportedCipherSuites, "$this$indexOf");
        C12238m.checkParameterIsNotNull("TLS_FALLBACK_SCSV", "value");
        C12238m.checkParameterIsNotNull(comparator3, "comparator");
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (((C12366j.a) comparator3).compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z3 && i3 != -1) {
            C12238m.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i3];
            C12238m.checkExpressionValueIsNotNull(str, "supportedCipherSuites[indexOfFallbackScsv]");
            C12238m.checkParameterIsNotNull(enabledCipherSuites, "$this$concat");
            C12238m.checkParameterIsNotNull(str, "value");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            C12238m.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[C12141k.getLastIndex(enabledCipherSuites)] = str;
        }
        C12369m.a aVar = new C12369m.a(c12369m);
        C12238m.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
        aVar.m10379b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        C12238m.checkExpressionValueIsNotNull(enabledProtocols, "tlsVersionsIntersection");
        aVar.m10382e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        C12369m c12369mM10378a = aVar.m10378a();
        if (c12369mM10378a.m10377c() != null) {
            sSLSocket.setEnabledProtocols(c12369mM10378a.f25937h);
        }
        if (c12369mM10378a.m10375a() != null) {
            sSLSocket.setEnabledCipherSuites(c12369mM10378a.f25936g);
        }
        return c12369m;
    }
}
