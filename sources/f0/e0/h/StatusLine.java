package f0.e0.h;

import b.d.b.a.outline;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: renamed from: f0.e0.h.j, reason: use source file name */
/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StatusLine {
    public final Protocol2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3630b;
    public final String c;

    public StatusLine(Protocol2 protocol2, int i, String str) {
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics3.checkParameterIsNotNull(str, "message");
        this.a = protocol2;
        this.f3630b = i;
        this.c = str;
    }

    public static final StatusLine a(String str) throws IOException {
        String strSubstring;
        Protocol2 protocol2 = Protocol2.HTTP_1_0;
        Intrinsics3.checkParameterIsNotNull(str, "statusLine");
        int i = 9;
        if (StringsJVM.startsWith$default(str, "HTTP/1.", false, 2, null)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(outline.w("Unexpected status line: ", str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException(outline.w("Unexpected status line: ", str));
                }
                protocol2 = Protocol2.HTTP_1_1;
            }
        } else {
            if (!StringsJVM.startsWith$default(str, "ICY ", false, 2, null)) {
                throw new ProtocolException(outline.w("Unexpected status line: ", str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException(outline.w("Unexpected status line: ", str));
        }
        try {
            String strSubstring2 = str.substring(i, i2);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int i3 = Integer.parseInt(strSubstring2);
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException(outline.w("Unexpected status line: ", str));
                }
                strSubstring = str.substring(i + 4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            return new StatusLine(protocol2, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(outline.w("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a == Protocol2.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f3630b);
        sb.append(' ');
        sb.append(this.c);
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
