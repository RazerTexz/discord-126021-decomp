package p600f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.p612m.AbstractC12349c;

/* JADX INFO: renamed from: f0.g */
/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12363g {

    /* JADX INFO: renamed from: c */
    public final Set<b> f25905c;

    /* JADX INFO: renamed from: d */
    public final AbstractC12349c f25906d;

    /* JADX INFO: renamed from: b */
    public static final a f25904b = new a(null);

    /* JADX INFO: renamed from: a */
    public static final C12363g f25903a = new C12363g(C12163u.toSet(new ArrayList()), null, 2);

    /* JADX INFO: renamed from: f0.g$a */
    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final String m10370a(Certificate certificate) {
            C12238m.checkParameterIsNotNull(certificate, "certificate");
            return "sha256/" + m10371b((X509Certificate) certificate).mo10500f();
        }

        /* JADX INFO: renamed from: b */
        public final ByteString m10371b(X509Certificate x509Certificate) {
            C12238m.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate.getPublicKey();
            C12238m.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            C12238m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            return ByteString.Companion.m11009d(companion, encoded, 0, 0, 3).mo10501g(Constants.SHA256);
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
            if (!C12238m.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            if (!C12238m.areEqual((Object) null, (Object) null)) {
                return false;
            }
            Objects.requireNonNull(bVar);
            return !(C12238m.areEqual((Object) null, (Object) null) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append(MentionUtilsKt.SLASH_CHAR);
            throw null;
        }
    }

    public C12363g(Set set, AbstractC12349c abstractC12349c, int i) {
        int i2 = i & 2;
        C12238m.checkParameterIsNotNull(set, "pins");
        this.f25905c = set;
        this.f25906d = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m10368a(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        C12238m.checkParameterIsNotNull(str, "hostname");
        C12238m.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        C12238m.checkParameterIsNotNull(str, "hostname");
        Set<b> set = this.f25905c;
        List<b> listEmptyList = C12147n.emptyList();
        for (Object obj : set) {
            Objects.requireNonNull((b) obj);
            C12238m.checkParameterIsNotNull(str, "hostname");
            if (C12103t.startsWith$default(null, "**.", false, 2, null)) {
                throw null;
            }
            if (C12103t.startsWith$default(null, "*.", false, 2, null)) {
                throw null;
            }
            if (C12238m.areEqual(str, (Object) null)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList();
                }
                C12224e0.asMutableList(listEmptyList).add(obj);
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
        StringBuilder sbM836X = C1643a.m836X("Certificate pinning failure!", "\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sbM836X.append("\n    ");
            C12238m.checkParameterIsNotNull(x509Certificate2, "certificate");
            if (!(x509Certificate2 instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            C12238m.checkParameterIsNotNull(x509Certificate2, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.INSTANCE;
            PublicKey publicKey = x509Certificate2.getPublicKey();
            C12238m.checkExpressionValueIsNotNull(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            C12238m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
            sb.append(ByteString.Companion.m11009d(companion, encoded, 0, 0, 3).mo10501g(Constants.SHA256).mo10500f());
            sbM836X.append(sb.toString());
            sbM836X.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            C12238m.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
            sbM836X.append(subjectDN.getName());
        }
        sbM836X.append("\n  Pinned certificates for ");
        sbM836X.append(str);
        sbM836X.append(":");
        for (b bVar : listEmptyList) {
            sbM836X.append("\n    ");
            sbM836X.append(bVar);
        }
        String string = sbM836X.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    /* JADX INFO: renamed from: b */
    public final C12363g m10369b(AbstractC12349c abstractC12349c) {
        C12238m.checkParameterIsNotNull(abstractC12349c, "certificateChainCleaner");
        return C12238m.areEqual(this.f25906d, abstractC12349c) ? this : new C12363g(this.f25905c, abstractC12349c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12363g) {
            C12363g c12363g = (C12363g) obj;
            if (C12238m.areEqual(c12363g.f25905c, this.f25905c) && C12238m.areEqual(c12363g.f25906d, this.f25906d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f25905c.hashCode() + 1517) * 41;
        AbstractC12349c abstractC12349c = this.f25906d;
        return iHashCode + (abstractC12349c != null ? abstractC12349c.hashCode() : 0);
    }

    public C12363g(Set<b> set, AbstractC12349c abstractC12349c) {
        C12238m.checkParameterIsNotNull(set, "pins");
        this.f25905c = set;
        this.f25906d = abstractC12349c;
    }
}
