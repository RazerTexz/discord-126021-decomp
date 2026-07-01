package f0.e0.h;

import d0.g0.t;
import d0.z.d.m;
import f0.y;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final y a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3630b;
    public final String c;

    public j(y yVar, int i, String str) {
        m.checkParameterIsNotNull(yVar, "protocol");
        m.checkParameterIsNotNull(str, "message");
        this.a = yVar;
        this.f3630b = i;
        this.c = str;
    }

    public static final j a(String str) throws IOException {
        String strSubstring;
        y yVar = y.HTTP_1_0;
        m.checkParameterIsNotNull(str, "statusLine");
        int i = 9;
        if (t.startsWith$default(str, "HTTP/1.", false, 2, null)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
                }
                yVar = y.HTTP_1_1;
            }
        } else {
            if (!t.startsWith$default(str, "ICY ", false, 2, null)) {
                throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
        }
        try {
            String strSubstring2 = str.substring(i, i2);
            m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i3 = Integer.parseInt(strSubstring2);
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
                }
                strSubstring = str.substring(i + 4);
                m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new j(yVar, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(b.d.b.a.a.w("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a == y.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f3630b);
        sb.append(' ');
        sb.append(this.c);
        String string = sb.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
