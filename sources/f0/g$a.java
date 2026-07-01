package f0;

import com.adjust.sdk.Constants;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;
import okio.ByteString$a;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a {
    public g$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final String a(Certificate certificate) {
        d0.z.d.m.checkParameterIsNotNull(certificate, "certificate");
        return "sha256/" + b((X509Certificate) certificate).f();
    }

    public final ByteString b(X509Certificate x509Certificate) {
        d0.z.d.m.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
        ByteString$a byteString$a = ByteString.k;
        PublicKey publicKey = x509Certificate.getPublicKey();
        d0.z.d.m.checkExpressionValueIsNotNull(publicKey, "publicKey");
        byte[] encoded = publicKey.getEncoded();
        d0.z.d.m.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
        return ByteString$a.d(byteString$a, encoded, 0, 0, 3).g(Constants.SHA256);
    }
}
