package f0;

import b.d.b.a.outline;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.e0.Util7;
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

/* JADX INFO: renamed from: f0.v, reason: use source file name */
/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Handshake {
    public final Lazy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TlsVersion f3680b;
    public final CipherSuite c;
    public final List<Certificate> d;

    /* JADX INFO: renamed from: f0.v$a */
    /* JADX INFO: compiled from: Handshake.kt */
    public static final class a extends Lambda implements Function0<List<? extends Certificate>> {
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
    public static final class b extends Lambda implements Function0<List<? extends Certificate>> {
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
                return Collections2.emptyList();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics3.checkParameterIsNotNull(tlsVersion, "tlsVersion");
        Intrinsics3.checkParameterIsNotNull(cipherSuite, "cipherSuite");
        Intrinsics3.checkParameterIsNotNull(list, "localCertificates");
        Intrinsics3.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.f3680b = tlsVersion;
        this.c = cipherSuite;
        this.d = list;
        this.a = LazyJVM.lazy(new b(function0));
    }

    public static final Handshake a(SSLSession sSLSession) throws IOException {
        List<Certificate> listEmptyList;
        Intrinsics3.checkParameterIsNotNull(sSLSession, "$this$handshake");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException(outline.w("cipherSuite == ", cipherSuite));
        }
        CipherSuite cipherSuiteB = CipherSuite.f3673s.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null".toString());
        }
        if (Intrinsics3.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionA = TlsVersion.p.a(protocol);
        try {
            listEmptyList = d(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = Collections2.emptyList();
        }
        return new Handshake(tlsVersionA, cipherSuiteB, d(sSLSession.getLocalCertificates()), new a(listEmptyList));
    }

    public static final List<Certificate> d(Certificate[] certificateArr) {
        return certificateArr != null ? Util7.m((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : Collections2.emptyList();
    }

    public final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics3.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    public final List<Certificate> c() {
        return (List) this.a.getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.f3680b == this.f3680b && Intrinsics3.areEqual(handshake.c, this.c) && Intrinsics3.areEqual(handshake.c(), c()) && Intrinsics3.areEqual(handshake.d, this.d)) {
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
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sbX = outline.X("Handshake{", "tlsVersion=");
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
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sbX.append(arrayList2);
        sbX.append('}');
        return sbX.toString();
    }
}
