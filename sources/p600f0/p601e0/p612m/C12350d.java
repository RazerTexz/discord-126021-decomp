package p600f0.p601e0.p612m;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.m.d */
/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12350d implements HostnameVerifier {

    /* JADX INFO: renamed from: a */
    public static final C12350d f25811a = new C12350d();

    /* JADX INFO: renamed from: a */
    public final List<String> m10343a(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return C12147n.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!C12238m.areEqual(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return C12147n.emptyList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0158  */
    /* JADX INFO: renamed from: b */
    public final boolean m10344b(String str, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        C12238m.checkParameterIsNotNull(str, "host");
        C12238m.checkParameterIsNotNull(x509Certificate, "certificate");
        byte[] bArr = C12272c.f25397a;
        C12238m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
        if (C12272c.f25402f.matches(str)) {
            String strM4337r1 = C3404f.m4337r1(str);
            List<String> listM10343a = m10343a(x509Certificate, 7);
            if (!(listM10343a instanceof Collection) || !listM10343a.isEmpty()) {
                Iterator<T> it = listM10343a.iterator();
                while (it.hasNext()) {
                    if (C12238m.areEqual(strM4337r1, C3404f.m4337r1((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            Locale locale = Locale.US;
            C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase(locale);
            C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> listM10343a2 = m10343a(x509Certificate, 2);
            if (!(listM10343a2 instanceof Collection) || !listM10343a2.isEmpty()) {
                for (String strM883w : listM10343a2) {
                    if ((lowerCase == null || lowerCase.length() == 0) || C12103t.startsWith$default(lowerCase, ".", false, 2, null) || C12103t.endsWith$default(lowerCase, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else if ((strM883w == null || strM883w.length() == 0) || C12103t.startsWith$default(strM883w, ".", false, 2, null) || C12103t.endsWith$default(strM883w, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else {
                        String strM883w2 = !C12103t.endsWith$default(lowerCase, ".", false, 2, null) ? C1643a.m883w(lowerCase, ".") : lowerCase;
                        if (!C12103t.endsWith$default(strM883w, ".", false, 2, null)) {
                            strM883w = C1643a.m883w(strM883w, ".");
                        }
                        Locale locale2 = Locale.US;
                        C12238m.checkExpressionValueIsNotNull(locale2, "Locale.US");
                        if (strM883w == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = strM883w.toLowerCase(locale2);
                        C12238m.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (!C12106w.contains$default((CharSequence) lowerCase2, (CharSequence) "*", false, 2, (Object) null)) {
                            zAreEqual = C12238m.areEqual(strM883w2, lowerCase2);
                        } else if (!C12103t.startsWith$default(lowerCase2, "*.", false, 2, null) || C12106w.indexOf$default((CharSequence) lowerCase2, '*', 1, false, 4, (Object) null) != -1 || strM883w2.length() < lowerCase2.length() || C12238m.areEqual("*.", lowerCase2)) {
                            zAreEqual = false;
                        } else {
                            String strSubstring = lowerCase2.substring(1);
                            C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            if (C12103t.endsWith$default(strM883w2, strSubstring, false, 2, null) && ((length = strM883w2.length() - strSubstring.length()) <= 0 || C12106w.lastIndexOf$default((CharSequence) strM883w2, '.', length - 1, false, 4, (Object) null) == -1)) {
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
        C12238m.checkParameterIsNotNull(str, "host");
        C12238m.checkParameterIsNotNull(sSLSession, "session");
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return m10344b(str, (X509Certificate) certificate);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
