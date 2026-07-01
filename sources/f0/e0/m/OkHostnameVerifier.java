package f0.e0.m;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
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

/* JADX INFO: renamed from: f0.e0.m.d, reason: use source file name */
/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier a = new OkHostnameVerifier();

    public final List<String> a(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!Intrinsics3.areEqual(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections2.emptyList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0158  */
    public final boolean b(String str, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        Intrinsics3.checkParameterIsNotNull(str, "host");
        Intrinsics3.checkParameterIsNotNull(x509Certificate, "certificate");
        byte[] bArr = Util7.a;
        Intrinsics3.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
        if (Util7.f.matches(str)) {
            String strR1 = f.r1(str);
            List<String> listA = a(x509Certificate, 7);
            if (!(listA instanceof Collection) || !listA.isEmpty()) {
                Iterator<T> it = listA.iterator();
                while (it.hasNext()) {
                    if (Intrinsics3.areEqual(strR1, f.r1((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            Locale locale = Locale.US;
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> listA2 = a(x509Certificate, 2);
            if (!(listA2 instanceof Collection) || !listA2.isEmpty()) {
                for (String strW : listA2) {
                    if ((lowerCase == null || lowerCase.length() == 0) || StringsJVM.startsWith$default(lowerCase, ".", false, 2, null) || StringsJVM.endsWith$default(lowerCase, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else if ((strW == null || strW.length() == 0) || StringsJVM.startsWith$default(strW, ".", false, 2, null) || StringsJVM.endsWith$default(strW, "..", false, 2, null)) {
                        zAreEqual = false;
                    } else {
                        String strW2 = !StringsJVM.endsWith$default(lowerCase, ".", false, 2, null) ? outline.w(lowerCase, ".") : lowerCase;
                        if (!StringsJVM.endsWith$default(strW, ".", false, 2, null)) {
                            strW = outline.w(strW, ".");
                        }
                        Locale locale2 = Locale.US;
                        Intrinsics3.checkExpressionValueIsNotNull(locale2, "Locale.US");
                        if (strW == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = strW.toLowerCase(locale2);
                        Intrinsics3.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (!Strings4.contains$default((CharSequence) lowerCase2, (CharSequence) "*", false, 2, (Object) null)) {
                            zAreEqual = Intrinsics3.areEqual(strW2, lowerCase2);
                        } else if (!StringsJVM.startsWith$default(lowerCase2, "*.", false, 2, null) || Strings4.indexOf$default((CharSequence) lowerCase2, '*', 1, false, 4, (Object) null) != -1 || strW2.length() < lowerCase2.length() || Intrinsics3.areEqual("*.", lowerCase2)) {
                            zAreEqual = false;
                        } else {
                            String strSubstring = lowerCase2.substring(1);
                            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            if (StringsJVM.endsWith$default(strW2, strSubstring, false, 2, null) && ((length = strW2.length() - strSubstring.length()) <= 0 || Strings4.lastIndexOf$default((CharSequence) strW2, '.', length - 1, false, 4, (Object) null) == -1)) {
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
        Intrinsics3.checkParameterIsNotNull(str, "host");
        Intrinsics3.checkParameterIsNotNull(sSLSession, "session");
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
