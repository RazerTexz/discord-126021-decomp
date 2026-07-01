package com.google.gson.stream;

import b.d.b.a.outline;
import b.i.d.q.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JsonReader implements Closeable {
    public static final char[] j = ")]}'\n".toCharArray();
    public final Reader k;
    public boolean l = false;
    public final char[] m = new char[1024];
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f3135s;
    public int t;
    public String u;
    public int[] v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String[] f3136x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f3137y;

    public class a extends JsonReaderInternalAccess {
    }

    static {
        JsonReaderInternalAccess.a = new a();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.v = iArr;
        this.w = 0;
        this.w = 0 + 1;
        iArr[0] = 6;
        this.f3136x = new String[32];
        this.f3137y = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.k = reader;
    }

    public long A() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.r = 0;
            int[] iArr = this.f3137y;
            int i = this.w - 1;
            iArr[i] = iArr[i] + 1;
            return this.f3135s;
        }
        if (iD == 16) {
            this.u = new String(this.m, this.n, this.t);
            this.n += this.t;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                StringBuilder sbU = outline.U("Expected a long but was ");
                sbU.append(N());
                sbU.append(t());
                throw new IllegalStateException(sbU.toString());
            }
            if (iD == 10) {
                this.u = L();
            } else {
                this.u = I(iD == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.u);
                this.r = 0;
                int[] iArr2 = this.f3137y;
                int i2 = this.w - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.r = 11;
        double d = Double.parseDouble(this.u);
        long j3 = (long) d;
        if (j3 != d) {
            StringBuilder sbU2 = outline.U("Expected a long but was ");
            sbU2.append(this.u);
            sbU2.append(t());
            throw new NumberFormatException(sbU2.toString());
        }
        this.u = null;
        this.r = 0;
        int[] iArr3 = this.f3137y;
        int i3 = this.w - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j3;
    }

    public String C() throws IOException {
        String strI;
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 14) {
            strI = L();
        } else if (iD == 12) {
            strI = I('\'');
        } else {
            if (iD != 13) {
                StringBuilder sbU = outline.U("Expected a name but was ");
                sbU.append(N());
                sbU.append(t());
                throw new IllegalStateException(sbU.toString());
            }
            strI = I('\"');
        }
        this.r = 0;
        this.f3136x[this.w - 1] = strI;
        return strI;
    }

    public final int D(boolean z2) throws IOException {
        char[] cArr = this.m;
        int i = this.n;
        int i2 = this.o;
        while (true) {
            boolean z3 = true;
            if (i == i2) {
                this.n = i;
                if (!n(1)) {
                    if (!z2) {
                        return -1;
                    }
                    StringBuilder sbU = outline.U("End of input");
                    sbU.append(t());
                    throw new EOFException(sbU.toString());
                }
                i = this.n;
                i2 = this.o;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.p++;
                this.q = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.n = i3;
                    if (i3 == i2) {
                        this.n = i3 - 1;
                        boolean zN = n(2);
                        this.n++;
                        if (!zN) {
                            return c;
                        }
                    }
                    c();
                    int i4 = this.n;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.n = i4 + 1;
                        while (true) {
                            int i5 = 0;
                            if (this.n + 2 > this.o && !n(2)) {
                                z3 = false;
                                break;
                            }
                            char[] cArr2 = this.m;
                            int i6 = this.n;
                            if (cArr2[i6] != '\n') {
                                while (true) {
                                    if (i5 >= 2) {
                                        break;
                                    }
                                    if (this.m[this.n + i5] != "*/".charAt(i5)) {
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                this.p++;
                                this.q = i6 + 1;
                            }
                            this.n++;
                        }
                        if (!z3) {
                            V("Unterminated comment");
                            throw null;
                        }
                        i = this.n + 2;
                        i2 = this.o;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.n = i4 + 1;
                        T();
                        i = this.n;
                        i2 = this.o;
                    }
                } else {
                    if (c != '#') {
                        this.n = i3;
                        return c;
                    }
                    this.n = i3;
                    c();
                    T();
                    i = this.n;
                    i2 = this.o;
                }
            }
            i = i3;
        }
    }

    public void H() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 7) {
            StringBuilder sbU = outline.U("Expected null but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
        this.r = 0;
        int[] iArr = this.f3137y;
        int i = this.w - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final String I(char c) throws IOException {
        int i;
        char[] cArr = this.m;
        StringBuilder sb = null;
        do {
            int i2 = this.n;
            int i3 = this.o;
            while (true) {
                int i4 = i3;
                i = i2;
                while (true) {
                    if (i2 < i4) {
                        int i5 = i2 + 1;
                        char c2 = cArr[i2];
                        if (c2 == c) {
                            this.n = i5;
                            int i6 = (i5 - i) - 1;
                            if (sb == null) {
                                return new String(cArr, i, i6);
                            }
                            sb.append(cArr, i, i6);
                            return sb.toString();
                        }
                        if (c2 == '\\') {
                            this.n = i5;
                            int i7 = (i5 - i) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                            }
                            sb.append(cArr, i, i7);
                            sb.append(R());
                            i2 = this.n;
                            i3 = this.o;
                        } else {
                            if (c2 == '\n') {
                                this.p++;
                                this.q = i5;
                            }
                            i2 = i5;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i2 - i) * 2, 16));
            }
            sb.append(cArr, i, i2 - i);
            this.n = i2;
        } while (n(1));
        V("Unterminated string");
        throw null;
    }

    public String J() throws IOException {
        String str;
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 10) {
            str = L();
        } else if (iD == 8) {
            str = I('\'');
        } else if (iD == 9) {
            str = I('\"');
        } else if (iD == 11) {
            str = this.u;
            this.u = null;
        } else if (iD == 15) {
            str = Long.toString(this.f3135s);
        } else {
            if (iD != 16) {
                StringBuilder sbU = outline.U("Expected a string but was ");
                sbU.append(N());
                sbU.append(t());
                throw new IllegalStateException(sbU.toString());
            }
            str = new String(this.m, this.n, this.t);
            this.n += this.t;
        }
        this.r = 0;
        int[] iArr = this.f3137y;
        int i = this.w - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    public final String L() throws IOException {
        String string;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.n;
                if (i3 + i2 < this.o) {
                    char c = this.m[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    i = i2;
                } else if (i2 >= this.m.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.m, this.n, i2);
                    this.n += i2;
                    if (!n(1)) {
                    }
                } else if (!n(i2 + 1)) {
                    i = i2;
                }
                if (sb == null) {
                    string = new String(this.m, this.n, i);
                } else {
                    sb.append(this.m, this.n, i);
                    string = sb.toString();
                }
                this.n += i;
                return string;
            }
        }
    }

    public JsonToken N() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        switch (iD) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void O(int i) {
        int i2 = this.w;
        int[] iArr = this.v;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.v = Arrays.copyOf(iArr, i3);
            this.f3137y = Arrays.copyOf(this.f3137y, i3);
            this.f3136x = (String[]) Arrays.copyOf(this.f3136x, i3);
        }
        int[] iArr2 = this.v;
        int i4 = this.w;
        this.w = i4 + 1;
        iArr2[i4] = i;
    }

    public final char R() throws IOException {
        int i;
        int i2;
        if (this.n == this.o && !n(1)) {
            V("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.m;
        int i3 = this.n;
        int i4 = i3 + 1;
        this.n = i4;
        char c = cArr[i3];
        if (c == '\n') {
            this.p++;
            this.q = i4;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                V("Invalid escape sequence");
                throw null;
            }
            if (i4 + 4 > this.o && !n(4)) {
                V("Unterminated escape sequence");
                throw null;
            }
            char c2 = 0;
            int i5 = this.n;
            int i6 = i5 + 4;
            while (i5 < i6) {
                char c3 = this.m[i5];
                char c4 = (char) (c2 << 4);
                if (c3 < '0' || c3 > '9') {
                    if (c3 >= 'a' && c3 <= 'f') {
                        i = c3 - 'a';
                    } else {
                        if (c3 < 'A' || c3 > 'F') {
                            StringBuilder sbU = outline.U("\\u");
                            sbU.append(new String(this.m, this.n, 4));
                            throw new NumberFormatException(sbU.toString());
                        }
                        i = c3 - 'A';
                    }
                    i2 = i + 10;
                } else {
                    i2 = c3 - '0';
                }
                c2 = (char) (i2 + c4);
                i5++;
            }
            this.n += 4;
            return c2;
        }
        return c;
    }

    public final void S(char c) throws IOException {
        char[] cArr = this.m;
        do {
            int i = this.n;
            int i2 = this.o;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.n = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.n = i3;
                    R();
                    i = this.n;
                    i2 = this.o;
                } else {
                    if (c2 == '\n') {
                        this.p++;
                        this.q = i3;
                    }
                    i = i3;
                }
            }
            this.n = i;
        } while (n(1));
        V("Unterminated string");
        throw null;
    }

    public final void T() throws IOException {
        char c;
        do {
            if (this.n >= this.o && !n(1)) {
                return;
            }
            char[] cArr = this.m;
            int i = this.n;
            int i2 = i + 1;
            this.n = i2;
            c = cArr[i];
            if (c == '\n') {
                this.p++;
                this.q = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009b. Please report as an issue. */
    public void U() throws IOException {
        int i = 0;
        do {
            int iD = this.r;
            if (iD == 0) {
                iD = d();
            }
            if (iD == 3) {
                O(1);
            } else {
                if (iD == 1) {
                    O(3);
                } else if (iD == 4 || iD == 2) {
                    this.w--;
                    i--;
                } else if (iD == 14 || iD == 10) {
                    while (true) {
                        int i2 = 0;
                        while (true) {
                            int i3 = this.n + i2;
                            if (i3 < this.o) {
                                char c = this.m[i3];
                                if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                    if (c != '#') {
                                        if (c != ',') {
                                            if (c != '/' && c != '=') {
                                                if (c != '{' && c != '}' && c != ':') {
                                                    if (c != ';') {
                                                        switch (c) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    c();
                                }
                                this.n += i2;
                            } else {
                                this.n = i3;
                                if (!n(1)) {
                                }
                            }
                        }
                    }
                } else if (iD == 8 || iD == 12) {
                    S('\'');
                } else if (iD == 9 || iD == 13) {
                    S('\"');
                } else if (iD == 16) {
                    this.n += this.t;
                }
                this.r = 0;
            }
            i++;
            this.r = 0;
        } while (i != 0);
        int[] iArr = this.f3137y;
        int i4 = this.w;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.f3136x[i4 - 1] = "null";
    }

    public final IOException V(String str) throws IOException {
        StringBuilder sbU = outline.U(str);
        sbU.append(t());
        throw new MalformedJsonException(sbU.toString());
    }

    public void a() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 3) {
            O(1);
            this.f3137y[this.w - 1] = 0;
            this.r = 0;
        } else {
            StringBuilder sbU = outline.U("Expected BEGIN_ARRAY but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public void b() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 1) {
            O(3);
            this.r = 0;
        } else {
            StringBuilder sbU = outline.U("Expected BEGIN_OBJECT but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public final void c() throws IOException {
        if (this.l) {
            return;
        }
        V("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.r = 0;
        this.v[0] = 8;
        this.w = 1;
        this.k.close();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x0175  */
    /* JADX WARN: Code duplicated, block: B:111:0x0187  */
    /* JADX WARN: Code duplicated, block: B:114:0x018d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0197  */
    /* JADX WARN: Code duplicated, block: B:118:0x019b A[PHI: r2 r3
      0x019b: PHI (r2v31 int) = (r2v30 int), (r2v36 int) binds: [B:110:0x0185, B:117:0x0197] A[DONT_GENERATE, DONT_INLINE]
      0x019b: PHI (r3v7 int) = (r3v6 int), (r3v9 int) binds: [B:110:0x0185, B:117:0x0197] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:120:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:160:0x0207 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x0229 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:172:0x022b  */
    /* JADX WARN: Code duplicated, block: B:185:0x024b  */
    /* JADX WARN: Code duplicated, block: B:187:0x0250  */
    /* JADX WARN: Code duplicated, block: B:190:0x0255  */
    /* JADX WARN: Code duplicated, block: B:195:0x0264 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:196:0x0265  */
    /* JADX WARN: Code duplicated, block: B:198:0x0271  */
    /* JADX WARN: Code duplicated, block: B:200:0x0279  */
    /* JADX WARN: Code duplicated, block: B:261:0x018a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x018a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x0205 A[SYNTHETIC] */
    public int d() throws IOException {
        int iD;
        String str;
        String str2;
        int i;
        char c;
        char[] cArr;
        int i2;
        int i3;
        long j2;
        int i4;
        char c2;
        char c3;
        long j3;
        int i5;
        int[] iArr = this.v;
        int i6 = this.w;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int iD2 = D(true);
            if (iD2 != 44) {
                if (iD2 != 59) {
                    if (iD2 == 93) {
                        this.r = 4;
                        return 4;
                    }
                    V("Unterminated array");
                    throw null;
                }
                c();
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5 && (iD = D(true)) != 44) {
                    if (iD != 59) {
                        if (iD == 125) {
                            this.r = 2;
                            return 2;
                        }
                        V("Unterminated object");
                        throw null;
                    }
                    c();
                }
                int iD3 = D(true);
                if (iD3 == 34) {
                    this.r = 13;
                    return 13;
                }
                if (iD3 == 39) {
                    c();
                    this.r = 12;
                    return 12;
                }
                if (iD3 == 125) {
                    if (i7 != 5) {
                        this.r = 2;
                        return 2;
                    }
                    V("Expected name");
                    throw null;
                }
                c();
                this.n--;
                if (s((char) iD3)) {
                    this.r = 14;
                    return 14;
                }
                V("Expected name");
                throw null;
            }
            if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int iD4 = D(true);
                if (iD4 != 58) {
                    if (iD4 != 61) {
                        V("Expected ':'");
                        throw null;
                    }
                    c();
                    if (this.n < this.o || n(1)) {
                        char[] cArr2 = this.m;
                        int i8 = this.n;
                        if (cArr2[i8] == '>') {
                            this.n = i8 + 1;
                        }
                    }
                }
            } else if (i7 == 6) {
                if (this.l) {
                    D(true);
                    int i9 = this.n - 1;
                    this.n = i9;
                    char[] cArr3 = j;
                    if (i9 + cArr3.length <= this.o || n(cArr3.length)) {
                        int i10 = 0;
                        while (true) {
                            char[] cArr4 = j;
                            if (i10 >= cArr4.length) {
                                this.n += cArr4.length;
                                break;
                            }
                            if (this.m[this.n + i10] != cArr4[i10]) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
                this.v[this.w - 1] = 7;
            } else if (i7 == 7) {
                if (D(false) == -1) {
                    this.r = 17;
                    return 17;
                }
                c();
                this.n--;
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iD5 = D(true);
        if (iD5 == 34) {
            this.r = 9;
            return 9;
        }
        if (iD5 == 39) {
            c();
            this.r = 8;
            return 8;
        }
        if (iD5 != 44 && iD5 != 59) {
            if (iD5 == 91) {
                this.r = 3;
                return 3;
            }
            if (iD5 != 93) {
                if (iD5 == 123) {
                    this.r = 1;
                    return 1;
                }
                int i11 = this.n - 1;
                this.n = i11;
                char c4 = this.m[i11];
                if (c4 == 't' || c4 == 'T') {
                    str = "true";
                    str2 = "TRUE";
                    i = 5;
                } else {
                    if (c4 != 'f' && c4 != 'F') {
                        if (c4 != 'n' && c4 != 'N') {
                            i = 0;
                            break;
                        }
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                        if (i != 0) {
                            return i;
                        }
                        cArr = this.m;
                        i2 = this.n;
                        i3 = this.o;
                        j2 = 0;
                        long j4 = 0;
                        i4 = 0;
                        c2 = 0;
                        boolean z2 = true;
                        boolean z3 = false;
                        while (true) {
                            if (i2 + i4 != i3) {
                                c3 = cArr[i2 + i4];
                                if (c3 != '+') {
                                    if (c3 != 'E' || c3 == 'e') {
                                        j3 = j2;
                                        if (c2 != 2 || c2 == 4) {
                                            c2 = 5;
                                            i4++;
                                            j2 = j3;
                                        }
                                    } else if (c3 == '-') {
                                        j3 = j2;
                                        if (c2 == 0) {
                                            c2 = 1;
                                            z3 = true;
                                        } else {
                                            if (c2 != 5) {
                                            }
                                            c2 = 6;
                                        }
                                        i4++;
                                        j2 = j3;
                                    } else if (c3 == '.') {
                                        j3 = j2;
                                        if (c2 == 2) {
                                            c2 = 3;
                                            i4++;
                                            j2 = j3;
                                        }
                                    } else if (c3 >= '0' && c3 <= '9') {
                                        if (c2 == 1 || c2 == 0) {
                                            j4 = -(c3 - '0');
                                            c2 = 2;
                                        } else if (c2 == 2) {
                                            if (j4 != j2) {
                                                long j5 = (10 * j4) - ((long) (c3 - '0'));
                                                z2 &= j4 > -922337203685477580L || (j4 == -922337203685477580L && j5 < j4);
                                                j4 = j5;
                                            }
                                        } else if (c2 == 3) {
                                            c2 = 4;
                                        } else if (c2 == 5 || c2 == 6) {
                                            c2 = 7;
                                        }
                                        j3 = 0;
                                        i4++;
                                        j2 = j3;
                                    } else if (!s(c3)) {
                                        if (c2 != 2 && z2 && ((j4 != Long.MIN_VALUE || z3) && (j4 != 0 || !z3))) {
                                            if (!z3) {
                                                j4 = -j4;
                                            }
                                            this.f3135s = j4;
                                            this.n += i4;
                                            i5 = 15;
                                            this.r = 15;
                                        } else if (c2 != 2 || c2 == 4 || c2 == 7) {
                                            this.t = i4;
                                            i5 = 16;
                                            this.r = 16;
                                        }
                                    }
                                    if (i5 != 0) {
                                        return i5;
                                    }
                                    if (s(this.m[this.n])) {
                                        V("Expected value");
                                        throw null;
                                    }
                                    c();
                                    this.r = 10;
                                    return 10;
                                }
                                j3 = j2;
                                if (c2 != 5) {
                                }
                                c2 = 6;
                                i4++;
                                j2 = j3;
                            } else if (i4 != cArr.length) {
                                if (!n(i4 + 1)) {
                                    i2 = this.n;
                                    i3 = this.o;
                                    c3 = cArr[i2 + i4];
                                    if (c3 != '+') {
                                        if (c3 != 'E') {
                                            j3 = j2;
                                            if (c2 != 2) {
                                            }
                                            c2 = 5;
                                            i4++;
                                            j2 = j3;
                                        } else {
                                            j3 = j2;
                                            if (c2 != 2) {
                                            }
                                            c2 = 5;
                                            i4++;
                                            j2 = j3;
                                        }
                                        if (i5 != 0) {
                                            return i5;
                                        }
                                        if (s(this.m[this.n])) {
                                            V("Expected value");
                                            throw null;
                                        }
                                        c();
                                        this.r = 10;
                                        return 10;
                                    }
                                    j3 = j2;
                                    if (c2 != 5) {
                                    }
                                    c2 = 6;
                                    i4++;
                                    j2 = j3;
                                }
                                if (c2 != 2) {
                                    if (c2 != 2) {
                                    }
                                    this.t = i4;
                                    i5 = 16;
                                    this.r = 16;
                                } else {
                                    if (c2 != 2) {
                                    }
                                    this.t = i4;
                                    i5 = 16;
                                    this.r = 16;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                if (s(this.m[this.n])) {
                                    V("Expected value");
                                    throw null;
                                }
                                c();
                                this.r = 10;
                                return 10;
                            }
                            i5 = 0;
                            if (i5 != 0) {
                                return i5;
                            }
                            if (s(this.m[this.n])) {
                                V("Expected value");
                                throw null;
                            }
                            c();
                            this.r = 10;
                            return 10;
                        }
                    }
                    str = "false";
                    str2 = "FALSE";
                    i = 6;
                }
                int length = str.length();
                int i12 = 1;
                while (true) {
                    if (i12 >= length) {
                        if ((this.n + length >= this.o && !n(length + 1)) || !s(this.m[this.n + length])) {
                            this.n += length;
                            this.r = i;
                            break;
                        }
                        break;
                    }
                    if ((this.n + i12 < this.o || n(i12 + 1)) && ((c = this.m[this.n + i12]) == str.charAt(i12) || c == str2.charAt(i12))) {
                        i12++;
                    }
                    i = 0;
                    break;
                }
                if (i != 0) {
                    return i;
                }
                cArr = this.m;
                i2 = this.n;
                i3 = this.o;
                j2 = 0;
                long j6 = 0;
                i4 = 0;
                c2 = 0;
                boolean z4 = true;
                boolean z5 = false;
                while (true) {
                    if (i2 + i4 != i3) {
                        c3 = cArr[i2 + i4];
                        if (c3 != '+') {
                            if (c3 != 'E') {
                                j3 = j2;
                                if (c2 != 2) {
                                }
                                c2 = 5;
                                i4++;
                                j2 = j3;
                            } else {
                                j3 = j2;
                                if (c2 != 2) {
                                }
                                c2 = 5;
                                i4++;
                                j2 = j3;
                            }
                            if (i5 != 0) {
                                return i5;
                            }
                            if (s(this.m[this.n])) {
                                V("Expected value");
                                throw null;
                            }
                            c();
                            this.r = 10;
                            return 10;
                        }
                        j3 = j2;
                        if (c2 != 5) {
                        }
                        c2 = 6;
                        i4++;
                        j2 = j3;
                    } else if (i4 != cArr.length) {
                        if (!n(i4 + 1)) {
                            i2 = this.n;
                            i3 = this.o;
                            c3 = cArr[i2 + i4];
                            if (c3 != '+') {
                                if (c3 != 'E') {
                                    j3 = j2;
                                    if (c2 != 2) {
                                    }
                                    c2 = 5;
                                    i4++;
                                    j2 = j3;
                                } else {
                                    j3 = j2;
                                    if (c2 != 2) {
                                    }
                                    c2 = 5;
                                    i4++;
                                    j2 = j3;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                if (s(this.m[this.n])) {
                                    V("Expected value");
                                    throw null;
                                }
                                c();
                                this.r = 10;
                                return 10;
                            }
                            j3 = j2;
                            if (c2 != 5) {
                            }
                            c2 = 6;
                            i4++;
                            j2 = j3;
                        }
                        if (c2 != 2) {
                            if (c2 != 2) {
                            }
                            this.t = i4;
                            i5 = 16;
                            this.r = 16;
                        } else {
                            if (c2 != 2) {
                            }
                            this.t = i4;
                            i5 = 16;
                            this.r = 16;
                        }
                        if (i5 != 0) {
                            return i5;
                        }
                        if (s(this.m[this.n])) {
                            V("Expected value");
                            throw null;
                        }
                        c();
                        this.r = 10;
                        return 10;
                    }
                    i5 = 0;
                    if (i5 != 0) {
                        return i5;
                    }
                    if (s(this.m[this.n])) {
                        V("Expected value");
                        throw null;
                    }
                    c();
                    this.r = 10;
                    return 10;
                }
            }
            if (i7 == 1) {
                this.r = 4;
                return 4;
            }
        }
        if (i7 != 1 && i7 != 2) {
            V("Unexpected value");
            throw null;
        }
        c();
        this.n--;
        this.r = 7;
        return 7;
    }

    public void e() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 4) {
            StringBuilder sbU = outline.U("Expected END_ARRAY but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
        int i = this.w - 1;
        this.w = i;
        int[] iArr = this.f3137y;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.r = 0;
    }

    public void f() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD != 2) {
            StringBuilder sbU = outline.U("Expected END_OBJECT but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
        int i = this.w - 1;
        this.w = i;
        this.f3136x[i] = null;
        int[] iArr = this.f3137y;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.r = 0;
    }

    public String getPath() {
        StringBuilder sbQ = outline.Q('$');
        int i = this.w;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.v[i2];
            if (i3 == 1 || i3 == 2) {
                sbQ.append('[');
                sbQ.append(this.f3137y[i2]);
                sbQ.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbQ.append('.');
                String[] strArr = this.f3136x;
                if (strArr[i2] != null) {
                    sbQ.append(strArr[i2]);
                }
            }
        }
        return sbQ.toString();
    }

    public final boolean n(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.m;
        int i4 = this.q;
        int i5 = this.n;
        this.q = i4 - i5;
        int i6 = this.o;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.o = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.o = 0;
        }
        this.n = 0;
        do {
            Reader reader = this.k;
            int i8 = this.o;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.o + i9;
            this.o = i2;
            if (this.p == 0 && (i3 = this.q) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.n++;
                this.q = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    public boolean q() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        return (iD == 2 || iD == 4) ? false : true;
    }

    public final boolean s(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    public String t() {
        StringBuilder sbW = outline.W(" at line ", this.p + 1, " column ", (this.n - this.q) + 1, " path ");
        sbW.append(getPath());
        return sbW.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + t();
    }

    public boolean u() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 5) {
            this.r = 0;
            int[] iArr = this.f3137y;
            int i = this.w - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iD != 6) {
            StringBuilder sbU = outline.U("Expected a boolean but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
        this.r = 0;
        int[] iArr2 = this.f3137y;
        int i2 = this.w - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public double x() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            this.r = 0;
            int[] iArr = this.f3137y;
            int i = this.w - 1;
            iArr[i] = iArr[i] + 1;
            return this.f3135s;
        }
        if (iD == 16) {
            this.u = new String(this.m, this.n, this.t);
            this.n += this.t;
        } else if (iD == 8 || iD == 9) {
            this.u = I(iD == 8 ? '\'' : '\"');
        } else if (iD == 10) {
            this.u = L();
        } else if (iD != 11) {
            StringBuilder sbU = outline.U("Expected a double but was ");
            sbU.append(N());
            sbU.append(t());
            throw new IllegalStateException(sbU.toString());
        }
        this.r = 11;
        double d = Double.parseDouble(this.u);
        if (!this.l && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + t());
        }
        this.u = null;
        this.r = 0;
        int[] iArr2 = this.f3137y;
        int i2 = this.w - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public int y() throws IOException {
        int iD = this.r;
        if (iD == 0) {
            iD = d();
        }
        if (iD == 15) {
            long j2 = this.f3135s;
            int i = (int) j2;
            if (j2 != i) {
                StringBuilder sbU = outline.U("Expected an int but was ");
                sbU.append(this.f3135s);
                sbU.append(t());
                throw new NumberFormatException(sbU.toString());
            }
            this.r = 0;
            int[] iArr = this.f3137y;
            int i2 = this.w - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iD == 16) {
            this.u = new String(this.m, this.n, this.t);
            this.n += this.t;
        } else {
            if (iD != 8 && iD != 9 && iD != 10) {
                StringBuilder sbU2 = outline.U("Expected an int but was ");
                sbU2.append(N());
                sbU2.append(t());
                throw new IllegalStateException(sbU2.toString());
            }
            if (iD == 10) {
                this.u = L();
            } else {
                this.u = I(iD == 8 ? '\'' : '\"');
            }
            try {
                int i3 = Integer.parseInt(this.u);
                this.r = 0;
                int[] iArr2 = this.f3137y;
                int i4 = this.w - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.r = 11;
        double d = Double.parseDouble(this.u);
        int i5 = (int) d;
        if (i5 != d) {
            StringBuilder sbU3 = outline.U("Expected an int but was ");
            sbU3.append(this.u);
            sbU3.append(t());
            throw new NumberFormatException(sbU3.toString());
        }
        this.u = null;
        this.r = 0;
        int[] iArr3 = this.f3137y;
        int i6 = this.w - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }
}
