package d0.e0.p.d.m0.p;

import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final f extractRadix(String str) {
        m.checkNotNullParameter(str, "value");
        if (t.startsWith$default(str, "0x", false, 2, null) || t.startsWith$default(str, "0X", false, 2, null)) {
            String strSubstring = str.substring(2);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return new f(strSubstring, 16);
        }
        if (!t.startsWith$default(str, "0b", false, 2, null) && !t.startsWith$default(str, "0B", false, 2, null)) {
            return new f(str, 10);
        }
        String strSubstring2 = str.substring(2);
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return new f(strSubstring2, 2);
    }
}
