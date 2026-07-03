package p600f0.p601e0.p606h;

import java.io.IOException;
import java.net.ProtocolException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;

/* JADX INFO: renamed from: f0.e0.h.j */
/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12304j {

    /* JADX INFO: renamed from: a */
    public final EnumC12381y f25544a;

    /* JADX INFO: renamed from: b */
    public final int f25545b;

    /* JADX INFO: renamed from: c */
    public final String f25546c;

    public C12304j(EnumC12381y enumC12381y, int i, String str) {
        C12238m.checkParameterIsNotNull(enumC12381y, "protocol");
        C12238m.checkParameterIsNotNull(str, "message");
        this.f25544a = enumC12381y;
        this.f25545b = i;
        this.f25546c = str;
    }

    /* JADX INFO: renamed from: a */
    public static final C12304j m10234a(String str) throws IOException {
        String strSubstring;
        EnumC12381y enumC12381y = EnumC12381y.HTTP_1_0;
        C12238m.checkParameterIsNotNull(str, "statusLine");
        int i = 9;
        if (C12103t.startsWith$default(str, "HTTP/1.", false, 2, null)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
                }
                enumC12381y = EnumC12381y.HTTP_1_1;
            }
        } else {
            if (!C12103t.startsWith$default(str, "ICY ", false, 2, null)) {
                throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
        }
        try {
            String strSubstring2 = str.substring(i, i2);
            C12238m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i3 = Integer.parseInt(strSubstring2);
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
                }
                strSubstring = str.substring(i + 4);
                C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new C12304j(enumC12381y, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(C1643a.m883w("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f25544a == EnumC12381y.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f25545b);
        sb.append(' ');
        sb.append(this.f25546c);
        String string = sb.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
