package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$i<T> extends t<T> {
    public final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3753b;
    public final String c;
    public final h<T, String> d;
    public final boolean e;

    public t$i(Method method, int i, String str, h<T, String> hVar, boolean z2) {
        this.a = method;
        this.f3753b = i;
        Objects.requireNonNull(str, "name == null");
        this.c = str;
        this.d = hVar;
        this.e = z2;
    }

    @Override // i0.t
    public void a(v vVar, T t) throws IOException {
        String strD;
        if (t == null) {
            throw c0.l(this.a, this.f3753b, b.d.b.a.a.J(b.d.b.a.a.U("Path parameter \""), this.c, "\" value must not be null."), new Object[0]);
        }
        String str = this.c;
        String strConvert = this.d.convert(t);
        boolean z2 = this.e;
        if (vVar.e == null) {
            throw new AssertionError();
        }
        int length = strConvert.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                strD = strConvert;
                break;
            }
            int iCodePointAt = strConvert.codePointAt(iCharCount);
            int i = 47;
            int i2 = -1;
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                g0.e eVar = new g0.e();
                eVar.c0(strConvert, 0, iCharCount);
                g0.e eVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = strConvert.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i2 || (!z2 && (iCodePointAt2 == i || iCodePointAt2 == 37))) {
                            if (eVar2 == null) {
                                eVar2 = new g0.e();
                            }
                            eVar2.d0(iCodePointAt2);
                            while (!eVar2.w()) {
                                int i3 = eVar2.readByte() & 255;
                                eVar.T(37);
                                char[] cArr = v.a;
                                eVar.T(cArr[(i3 >> 4) & 15]);
                                eVar.T(cArr[i3 & 15]);
                            }
                        } else {
                            eVar.d0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i = 47;
                    i2 = -1;
                }
                strD = eVar.D();
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strReplace = vVar.e.replace("{" + str + "}", strD);
        if (v.f3759b.matcher(strReplace).matches()) {
            throw new IllegalArgumentException(b.d.b.a.a.w("@Path parameters shouldn't perform path traversal ('.' or '..'): ", strConvert));
        }
        vVar.e = strReplace;
    }
}
