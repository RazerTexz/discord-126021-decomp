package f0;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public final Lazy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f3680b;
    public final j c;
    public final List<Certificate> d;

    /* JADX WARN: Multi-variable type inference failed */
    public v(d0 d0Var, j jVar, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        d0.z.d.m.checkParameterIsNotNull(d0Var, "tlsVersion");
        d0.z.d.m.checkParameterIsNotNull(jVar, "cipherSuite");
        d0.z.d.m.checkParameterIsNotNull(list, "localCertificates");
        d0.z.d.m.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.f3680b = d0Var;
        this.c = jVar;
        this.d = list;
        this.a = d0.g.lazy(new v$b(function0));
    }

    public static final v a(SSLSession sSLSession) throws IOException {
        List<Certificate> listEmptyList;
        d0.z.d.m.checkParameterIsNotNull(sSLSession, "$this$handshake");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException(b.d.b.a.a.w("cipherSuite == ", cipherSuite));
        }
        j jVarB = j.f3673s.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null".toString());
        }
        if (d0.z.d.m.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        d0 d0VarA = d0.p.a(protocol);
        try {
            listEmptyList = d(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = d0.t.n.emptyList();
        }
        return new v(d0VarA, jVarB, d(sSLSession.getLocalCertificates()), new v$a(listEmptyList));
    }

    public static final List<Certificate> d(Certificate[] certificateArr) {
        return certificateArr != null ? f0.e0.c.m((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : d0.t.n.emptyList();
    }

    public final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        d0.z.d.m.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    public final List<Certificate> c() {
        return (List) this.a.getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (vVar.f3680b == this.f3680b && d0.z.d.m.areEqual(vVar.c, this.c) && d0.z.d.m.areEqual(vVar.c(), c()) && d0.z.d.m.areEqual(vVar.d, this.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode() + ((c().hashCode() + ((this.c.hashCode() + ((this.f3680b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public String toString() {
        List<Certificate> listC = c();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sbX = b.d.b.a.a.X("Handshake{", "tlsVersion=");
        sbX.append(this.f3680b);
        sbX.append(' ');
        sbX.append("cipherSuite=");
        sbX.append(this.c);
        sbX.append(' ');
        sbX.append("peerCertificates=");
        sbX.append(string);
        sbX.append(' ');
        sbX.append("localCertificates=");
        List<Certificate> list = this.d;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sbX.append(arrayList2);
        sbX.append('}');
        return sbX.toString();
    }
}
