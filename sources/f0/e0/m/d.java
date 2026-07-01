package f0.e0.m;

import b.i.a.f.e.o.f;
import d0.g0.t;
import d0.g0.w;
import d0.t.n;
import d0.z.d.m;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements HostnameVerifier {
    public static final d a = new d();

    public final List<String> a(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return n.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!m.areEqual(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return n.emptyList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0158  */
    public final boolean b(String str, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        m.checkParameterIsNotNull(str, "host");
        m.checkParameterIsNotNull(x509Certificate, "certificate");
        byte[] bArr = f0.e0.c.a;
        m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
        if (f0.e0.c.f.matches(str)) {
            String strR1 = f.r1(str);
            List<String> listA = a(x509Certificate, 7);
            if (!(listA instanceof Collection) || !listA.isEmpty()) {
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    if (m.areEqual(strR1, f.r1((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            Locale locale = Locale.US;
            m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase(locale);
            m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> listA2 = a(x509Certificate, 2);
            if (!(listA2 instanceof Collection) || !listA2.isEmpty()) {
                for (String strW : listA2) {
                    if ((lowerCase == null || lowerCase.length() == 0) || t.startsWith$default(lowerCase, ".", false, 2, null) || t.endsWith$default(lowerCase, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else if ((strW == null || strW.length() == 0) || t.startsWith$default(strW, ".", false, 2, null) || t.endsWith$default(strW, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else {
                        String strW2 = !t.endsWith$default(lowerCase, ".", false, 2, null) ? b.d.b.a.a.w(lowerCase, ".") : lowerCase;
                        if (!t.endsWith$default(strW, ".", false, 2, null)) {
                            strW = b.d.b.a.a.w(strW, ".");
                        }
                        Locale locale2 = Locale.US;
                        m.checkExpressionValueIsNotNull(locale2, "Locale.US");
                        if (strW == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = strW.toLowerCase(locale2);
                        m.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (!w.contains$default((CharSequence) lowerCase2, (CharSequence) "*", false, 2, (Object) null)) {
                            zAreEqual = m.areEqual(strW2, lowerCase2);
                        } else if (!t.startsWith$default(lowerCase2, "*.", false, 2, null) || w.indexOf$default((CharSequence) lowerCase2, '*', 1, false, 4, (Object) null) != -1 || strW2.length() < lowerCase2.length() || m.areEqual("*.", lowerCase2)) {
                            zAreEqual = false;
                        } else {
                            String strSubstring = lowerCase2.substring(1);
                            m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            if (t.endsWith$default(strW2, strSubstring, false, 2, null) && ((length = strW2.length() - strSubstring.length()) <= 0 || w.lastIndexOf$default((CharSequence) strW2, '.', length - 1, false, 4, (Object) null) == -1)) {
                                zAreEqual = true;
                            } else {
                                zAreEqual = false;
                            }
                        }
                    }
                    if (zAreEqual) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        m.checkParameterIsNotNull(str, "host");
        m.checkParameterIsNotNull(sSLSession, "session");
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return b(str, (X509Certificate) certificate);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
