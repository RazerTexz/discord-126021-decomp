package f0;

import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CipherSuite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b {
    public j$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final j a(j$b j_b, String str, int i) {
        j jVar = new j(str, null);
        j.f3672b.put(str, jVar);
        return jVar;
    }

    public final synchronized j b(String str) {
        j jVar;
        d0.z.d.m.checkParameterIsNotNull(str, "javaName");
        Map<String, j> map = j.f3672b;
        jVar = map.get(str);
        if (jVar == null) {
            jVar = map.get(c(str));
            if (jVar == null) {
                jVar = new j(str, null);
            }
            map.put(str, jVar);
        }
        return jVar;
    }

    public final String c(String str) {
        if (d0.g0.t.startsWith$default(str, "TLS_", false, 2, null)) {
            StringBuilder sbU = b.d.b.a.a.U("SSL_");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(4);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            sbU.append(strSubstring);
            return sbU.toString();
        }
        if (!d0.g0.t.startsWith$default(str, "SSL_", false, 2, null)) {
            return str;
        }
        StringBuilder sbU2 = b.d.b.a.a.U("TLS_");
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = str.substring(4);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sbU2.append(strSubstring2);
        return sbU2.toString();
    }
}
