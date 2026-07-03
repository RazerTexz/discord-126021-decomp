package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.g */
/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12039g {
    public static final C12038f extractRadix(String str) {
        C12238m.checkNotNullParameter(str, "value");
        if (C12103t.startsWith$default(str, "0x", false, 2, null) || C12103t.startsWith$default(str, "0X", false, 2, null)) {
            String strSubstring = str.substring(2);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return new C12038f(strSubstring, 16);
        }
        if (!C12103t.startsWith$default(str, "0b", false, 2, null) && !C12103t.startsWith$default(str, "0B", false, 2, null)) {
            return new C12038f(str, 10);
        }
        String strSubstring2 = str.substring(2);
        C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return new C12038f(strSubstring2, 2);
    }
}
