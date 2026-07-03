package p600f0;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.v */
/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12378v {

    /* JADX INFO: renamed from: a */
    public final Lazy f25969a;

    /* JADX INFO: renamed from: b */
    public final EnumC12268d0 f25970b;

    /* JADX INFO: renamed from: c */
    public final C12366j f25971c;

    /* JADX INFO: renamed from: d */
    public final List<Certificate> f25972d;

    /* JADX INFO: renamed from: f0.v$a */
    /* JADX INFO: compiled from: Handshake.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends Certificate>> {
        public final /* synthetic */ List $peerCertificatesCopy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list) {
            super(0);
            this.$peerCertificatesCopy = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public List<? extends Certificate> invoke() {
            return this.$peerCertificatesCopy;
        }
    }

    /* JADX INFO: renamed from: f0.v$b */
    /* JADX INFO: compiled from: Handshake.kt */
    public static final class b extends AbstractC12240o implements Function0<List<? extends Certificate>> {
        public final /* synthetic */ Function0 $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(0);
            this.$peerCertificatesFn = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public List<? extends Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return C12147n.emptyList();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12378v(EnumC12268d0 enumC12268d0, C12366j c12366j, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        C12238m.checkParameterIsNotNull(enumC12268d0, "tlsVersion");
        C12238m.checkParameterIsNotNull(c12366j, "cipherSuite");
        C12238m.checkParameterIsNotNull(list, "localCertificates");
        C12238m.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.f25970b = enumC12268d0;
        this.f25971c = c12366j;
        this.f25972d = list;
        this.f25969a = C12083g.lazy(new b(function0));
    }

    /* JADX INFO: renamed from: a */
    public static final C12378v m10395a(SSLSession sSLSession) throws IOException {
        List<Certificate> listEmptyList;
        C12238m.checkParameterIsNotNull(sSLSession, "$this$handshake");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException(C1643a.m883w("cipherSuite == ", cipherSuite));
        }
        C12366j c12366jM10373b = C12366j.f25927s.m10373b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null".toString());
        }
        if (C12238m.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        EnumC12268d0 enumC12268d0M10110a = EnumC12268d0.f25393p.m10110a(protocol);
        try {
            listEmptyList = m10396d(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = C12147n.emptyList();
        }
        return new C12378v(enumC12268d0M10110a, c12366jM10373b, m10396d(sSLSession.getLocalCertificates()), new a(listEmptyList));
    }

    /* JADX INFO: renamed from: d */
    public static final List<Certificate> m10396d(Certificate[] certificateArr) {
        return certificateArr != null ? C12272c.m10132m((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : C12147n.emptyList();
    }

    /* JADX INFO: renamed from: b */
    public final String m10397b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        C12238m.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    /* JADX INFO: renamed from: c */
    public final List<Certificate> m10398c() {
        return (List) this.f25969a.getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12378v) {
            C12378v c12378v = (C12378v) obj;
            if (c12378v.f25970b == this.f25970b && C12238m.areEqual(c12378v.f25971c, this.f25971c) && C12238m.areEqual(c12378v.m10398c(), m10398c()) && C12238m.areEqual(c12378v.f25972d, this.f25972d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25972d.hashCode() + ((m10398c().hashCode() + ((this.f25971c.hashCode() + ((this.f25970b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public String toString() {
        List<Certificate> listM10398c = m10398c();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM10398c, 10));
        Iterator<T> it = listM10398c.iterator();
        while (it.hasNext()) {
            arrayList.add(m10397b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sbM836X = C1643a.m836X("Handshake{", "tlsVersion=");
        sbM836X.append(this.f25970b);
        sbM836X.append(' ');
        sbM836X.append("cipherSuite=");
        sbM836X.append(this.f25971c);
        sbM836X.append(' ');
        sbM836X.append("peerCertificates=");
        sbM836X.append(string);
        sbM836X.append(' ');
        sbM836X.append("localCertificates=");
        List<Certificate> list = this.f25972d;
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(m10397b((Certificate) it2.next()));
        }
        sbM836X.append(arrayList2);
        sbM836X.append('}');
        return sbM836X.toString();
    }
}
