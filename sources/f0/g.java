package f0;

import com.adjust.sdk.Constants;
import d0.z.d.e0;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.functions.Function0;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final Set<g$b> c;
    public final f0.e0.m.c d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g$a f3670b = new g$a(null);
    public static final g a = new g(d0.t.u.toSet(new ArrayList()), null, 2);

    public g(Set set, f0.e0.m.c cVar, int i) {
        int i2 = i & 2;
        d0.z.d.m.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = null;
    }

    public final void a(String str, Function0<? extends List<? extends X509Certificate>> function0) throws SSLPeerUnverifiedException {
        d0.z.d.m.checkParameterIsNotNull(str, "hostname");
        d0.z.d.m.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        d0.z.d.m.checkParameterIsNotNull(str, "hostname");
        Set<g$b> set = this.c;
        List<g$b> listEmptyList = d0.t.n.emptyList();
        for (Object obj : set) {
            Objects.requireNonNull((g$b) obj);
            d0.z.d.m.checkParameterIsNotNull(str, "hostname");
            if (d0.g0.t.startsWith$default(null, "**.", false, 2, null)) {
                throw null;
            }
            if (d0.g0.t.startsWith$default(null, "*.", false, 2, null)) {
                throw null;
            }
            if (d0.z.d.m.areEqual(str, (Object) null)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                e0.asMutableList(listEmptyList).add(obj);
            }
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = function0.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                Objects.requireNonNull((g$b) it.next());
                throw null;
            }
        }
        StringBuilder sbX = b.d.b.a.a.X("Certificate pinning failure!", "\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sbX.append("\n    ");
            d0.z.d.m.checkParameterIsNotNull(x509Certificate2, "certificate");
            if (!(x509Certificate2 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            d0.z.d.m.checkParameterIsNotNull(x509Certificate2, "$this$sha256Hash");
            ByteString$a byteString$a = ByteString.k;
            PublicKey publicKey = x509Certificate2.getPublicKey();
            d0.z.d.m.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            d0.z.d.m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            sb.append(ByteString$a.d(byteString$a, encoded, 0, 0, 3).g(Constants.SHA256).f());
            sbX.append(sb.toString());
            sbX.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            d0.z.d.m.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
            sbX.append(subjectDN.getName());
        }
        sbX.append("\n  Pinned certificates for ");
        sbX.append(str);
        sbX.append(":");
        for (g$b g_b : listEmptyList) {
            sbX.append("\n    ");
            sbX.append(g_b);
        }
        String string = sbX.toString();
        d0.z.d.m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final g b(f0.e0.m.c cVar) {
        d0.z.d.m.checkParameterIsNotNull(cVar, "certificateChainCleaner");
        return d0.z.d.m.areEqual(this.d, cVar) ? this : new g(this.c, cVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (d0.z.d.m.areEqual(gVar.c, this.c) && d0.z.d.m.areEqual(gVar.d, this.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.c.hashCode() + 1517) * 41;
        f0.e0.m.c cVar = this.d;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public g(Set<g$b> set, f0.e0.m.c cVar) {
        d0.z.d.m.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = cVar;
    }
}
