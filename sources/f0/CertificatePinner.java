package f0;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import f0.e0.m.CertificateChainCleaner;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* JADX INFO: renamed from: f0.g, reason: use source file name */
/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificatePinner {
    public final Set<b> c;
    public final CertificateChainCleaner d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3670b = new a(null);
    public static final CertificatePinner a = new CertificatePinner(_Collections.toSet(new ArrayList()), null, 2);

    /* JADX INFO: renamed from: f0.g$a */
    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String a(Certificate certificate) {
            Intrinsics3.checkParameterIsNotNull(certificate, "certificate");
            return "sha256/" + b((X509Certificate) certificate).f();
        }

        public final ByteString b(X509Certificate x509Certificate) {
            Intrinsics3.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate.getPublicKey();
            Intrinsics3.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics3.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            return ByteString.Companion.d(companion, encoded, 0, 0, 3).g(Constants.SHA256);
        }
    }

    /* JADX INFO: renamed from: f0.g$b */
    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class b {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            Objects.requireNonNull(bVar);
            if (!Intrinsics3.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            if (!Intrinsics3.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            return !(Intrinsics3.areEqual((Object) null, (Object) null) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append(MentionUtils.SLASH_CHAR);
            throw null;
        }
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i) {
        int i2 = i & 2;
        Intrinsics3.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = null;
    }

    public final void a(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Intrinsics3.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Set<b> set = this.c;
        List<b> listEmptyList = Collections2.emptyList();
        for (Object obj : set) {
            Objects.requireNonNull((b) obj);
            Intrinsics3.checkParameterIsNotNull(str, "hostname");
            if (StringsJVM.startsWith$default(null, "**.", false, 2, null)) {
                throw null;
            }
            if (StringsJVM.startsWith$default(null, "*.", false, 2, null)) {
                throw null;
            }
            if (Intrinsics3.areEqual(str, (Object) null)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                TypeIntrinsics.asMutableList(listEmptyList).add(obj);
            }
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = function0.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                Objects.requireNonNull((b) it.next());
                throw null;
            }
        }
        StringBuilder sbX = outline.X("Certificate pinning failure!", "\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sbX.append("\n    ");
            Intrinsics3.checkParameterIsNotNull(x509Certificate2, "certificate");
            if (!(x509Certificate2 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            Intrinsics3.checkParameterIsNotNull(x509Certificate2, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate2.getPublicKey();
            Intrinsics3.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics3.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            sb.append(ByteString.Companion.d(companion, encoded, 0, 0, 3).g(Constants.SHA256).f());
            sbX.append(sb.toString());
            sbX.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            Intrinsics3.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
            sbX.append(subjectDN.getName());
        }
        sbX.append("\n  Pinned certificates for ");
        sbX.append(str);
        sbX.append(":");
        for (b bVar : listEmptyList) {
            sbX.append("\n    ");
            sbX.append(bVar);
        }
        String string = sbX.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final CertificatePinner b(CertificateChainCleaner certificateChainCleaner) {
        Intrinsics3.checkParameterIsNotNull(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics3.areEqual(this.d, certificateChainCleaner) ? this : new CertificatePinner(this.c, certificateChainCleaner);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Intrinsics3.areEqual(certificatePinner.c, this.c) && Intrinsics3.areEqual(certificatePinner.d, this.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.c.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.d;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public CertificatePinner(Set<b> set, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics3.checkParameterIsNotNull(set, "pins");
        this.c = set;
        this.d = certificateChainCleaner;
    }
}
