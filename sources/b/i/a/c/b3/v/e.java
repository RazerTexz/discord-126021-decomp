package b.i.a.c.b3.v;

import androidx.annotation.Nullable;
import b.i.a.c.f3.x;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebvttCssParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final Pattern a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f888b = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    public final x c = new x();
    public final StringBuilder d = new StringBuilder();

    public static String a(x xVar, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int i = xVar.f984b;
        int i2 = xVar.c;
        while (i < i2 && !z2) {
            char c = (char) xVar.a[i];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z2 = true;
            } else {
                i++;
                sb.append(c);
            }
        }
        xVar.F(i - xVar.f984b);
        return sb.toString();
    }

    @Nullable
    public static String b(x xVar, StringBuilder sb) {
        c(xVar);
        if (xVar.a() == 0) {
            return null;
        }
        String strA = a(xVar, sb);
        if (!"".equals(strA)) {
            return strA;
        }
        char cT = (char) xVar.t();
        StringBuilder sb2 = new StringBuilder(1);
        sb2.append(cT);
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    public static void c(x xVar) {
        boolean z2;
        boolean z3;
        while (true) {
            for (boolean z4 = true; xVar.a() > 0 && z4; z4 = false) {
                char c = (char) xVar.a[xVar.f984b];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    xVar.F(1);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    int i = xVar.f984b;
                    int i2 = xVar.c;
                    byte[] bArr = xVar.a;
                    if (i + 2 <= i2) {
                        int i3 = i + 1;
                        if (bArr[i] == 47) {
                            int i4 = i3 + 1;
                            if (bArr[i3] == 42) {
                                while (true) {
                                    int i5 = i4 + 1;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    if (((char) bArr[i4]) == '*' && ((char) bArr[i5]) == '/') {
                                        i2 = i5 + 1;
                                        i4 = i2;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                xVar.F(i2 - xVar.f984b);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                    }
                }
            }
            return;
        }
    }
}
