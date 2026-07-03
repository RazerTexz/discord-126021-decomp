package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.p410q.AbstractC4931p;

/* JADX INFO: loaded from: classes3.dex */
public class JsonReader implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final char[] f21625j = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: k */
    public final Reader f21626k;

    /* JADX INFO: renamed from: l */
    public boolean f21627l = false;

    /* JADX INFO: renamed from: m */
    public final char[] f21628m = new char[1024];

    /* JADX INFO: renamed from: n */
    public int f21629n = 0;

    /* JADX INFO: renamed from: o */
    public int f21630o = 0;

    /* JADX INFO: renamed from: p */
    public int f21631p = 0;

    /* JADX INFO: renamed from: q */
    public int f21632q = 0;

    /* JADX INFO: renamed from: r */
    public int f21633r = 0;

    /* JADX INFO: renamed from: s */
    public long f21634s;

    /* JADX INFO: renamed from: t */
    public int f21635t;

    /* JADX INFO: renamed from: u */
    public String f21636u;

    /* JADX INFO: renamed from: v */
    public int[] f21637v;

    /* JADX INFO: renamed from: w */
    public int f21638w;

    /* JADX INFO: renamed from: x */
    public String[] f21639x;

    /* JADX INFO: renamed from: y */
    public int[] f21640y;

    /* JADX INFO: renamed from: com.google.gson.stream.JsonReader$a */
    public class C11149a extends AbstractC4931p {
    }

    static {
        AbstractC4931p.f13124a = new C11149a();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.f21637v = iArr;
        this.f21638w = 0;
        this.f21638w = 0 + 1;
        iArr[0] = 6;
        this.f21639x = new String[32];
        this.f21640y = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f21626k = reader;
    }

    /* JADX INFO: renamed from: A */
    public long mo6874A() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 15) {
            this.f21633r = 0;
            int[] iArr = this.f21640y;
            int i = this.f21638w - 1;
            iArr[i] = iArr[i] + 1;
            return this.f21634s;
        }
        if (iM9247d == 16) {
            this.f21636u = new String(this.f21628m, this.f21629n, this.f21635t);
            this.f21629n += this.f21635t;
        } else {
            if (iM9247d != 8 && iM9247d != 9 && iM9247d != 10) {
                StringBuilder sbM833U = C1643a.m833U("Expected a long but was ");
                sbM833U.append(mo6878N());
                sbM833U.append(m9250t());
                throw new IllegalStateException(sbM833U.toString());
            }
            if (iM9247d == 10) {
                this.f21636u = m9240L();
            } else {
                this.f21636u = m9239I(iM9247d == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.f21636u);
                this.f21633r = 0;
                int[] iArr2 = this.f21640y;
                int i2 = this.f21638w - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.f21633r = 11;
        double d = Double.parseDouble(this.f21636u);
        long j2 = (long) d;
        if (j2 != d) {
            StringBuilder sbM833U2 = C1643a.m833U("Expected a long but was ");
            sbM833U2.append(this.f21636u);
            sbM833U2.append(m9250t());
            throw new NumberFormatException(sbM833U2.toString());
        }
        this.f21636u = null;
        this.f21633r = 0;
        int[] iArr3 = this.f21640y;
        int i3 = this.f21638w - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    /* JADX INFO: renamed from: C */
    public String mo6875C() throws IOException {
        String strM9239I;
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 14) {
            strM9239I = m9240L();
        } else if (iM9247d == 12) {
            strM9239I = m9239I('\'');
        } else {
            if (iM9247d != 13) {
                StringBuilder sbM833U = C1643a.m833U("Expected a name but was ");
                sbM833U.append(mo6878N());
                sbM833U.append(m9250t());
                throw new IllegalStateException(sbM833U.toString());
            }
            strM9239I = m9239I('\"');
        }
        this.f21633r = 0;
        this.f21639x[this.f21638w - 1] = strM9239I;
        return strM9239I;
    }

    /* JADX INFO: renamed from: D */
    public final int m9238D(boolean z2) throws IOException {
        char[] cArr = this.f21628m;
        int i = this.f21629n;
        int i2 = this.f21630o;
        while (true) {
            boolean z3 = true;
            if (i == i2) {
                this.f21629n = i;
                if (!m9248n(1)) {
                    if (!z2) {
                        return -1;
                    }
                    StringBuilder sbM833U = C1643a.m833U("End of input");
                    sbM833U.append(m9250t());
                    throw new EOFException(sbM833U.toString());
                }
                i = this.f21629n;
                i2 = this.f21630o;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f21631p++;
                this.f21632q = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f21629n = i3;
                    if (i3 == i2) {
                        this.f21629n = i3 - 1;
                        boolean zM9248n = m9248n(2);
                        this.f21629n++;
                        if (!zM9248n) {
                            return c;
                        }
                    }
                    m9246c();
                    int i4 = this.f21629n;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.f21629n = i4 + 1;
                        while (true) {
                            int i5 = 0;
                            if (this.f21629n + 2 > this.f21630o && !m9248n(2)) {
                                z3 = false;
                                break;
                            }
                            char[] cArr2 = this.f21628m;
                            int i6 = this.f21629n;
                            if (cArr2[i6] != '\n') {
                                while (true) {
                                    if (i5 >= 2) {
                                        break;
                                    }
                                    if (this.f21628m[this.f21629n + i5] != "*/".charAt(i5)) {
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                this.f21631p++;
                                this.f21632q = i6 + 1;
                            }
                            this.f21629n++;
                        }
                        if (!z3) {
                            m9245V("Unterminated comment");
                            throw null;
                        }
                        i = this.f21629n + 2;
                        i2 = this.f21630o;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.f21629n = i4 + 1;
                        m9244T();
                        i = this.f21629n;
                        i2 = this.f21630o;
                    }
                } else {
                    if (c != '#') {
                        this.f21629n = i3;
                        return c;
                    }
                    this.f21629n = i3;
                    m9246c();
                    m9244T();
                    i = this.f21629n;
                    i2 = this.f21630o;
                }
            }
            i = i3;
        }
    }

    /* JADX INFO: renamed from: H */
    public void mo6876H() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d != 7) {
            StringBuilder sbM833U = C1643a.m833U("Expected null but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
        this.f21633r = 0;
        int[] iArr = this.f21640y;
        int i = this.f21638w - 1;
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: renamed from: I */
    public final String m9239I(char c) throws IOException {
        int i;
        char[] cArr = this.f21628m;
        StringBuilder sb = null;
        do {
            int i2 = this.f21629n;
            int i3 = this.f21630o;
            while (true) {
                int i4 = i3;
                i = i2;
                while (true) {
                    if (i2 < i4) {
                        int i5 = i2 + 1;
                        char c2 = cArr[i2];
                        if (c2 == c) {
                            this.f21629n = i5;
                            int i6 = (i5 - i) - 1;
                            if (sb == null) {
                                return new String(cArr, i, i6);
                            }
                            sb.append(cArr, i, i6);
                            return sb.toString();
                        }
                        if (c2 == '\\') {
                            this.f21629n = i5;
                            int i7 = (i5 - i) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                            }
                            sb.append(cArr, i, i7);
                            sb.append(m9242R());
                            i2 = this.f21629n;
                            i3 = this.f21630o;
                        } else {
                            if (c2 == '\n') {
                                this.f21631p++;
                                this.f21632q = i5;
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
            this.f21629n = i2;
        } while (m9248n(1));
        m9245V("Unterminated string");
        throw null;
    }

    /* JADX INFO: renamed from: J */
    public String mo6877J() throws IOException {
        String str;
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 10) {
            str = m9240L();
        } else if (iM9247d == 8) {
            str = m9239I('\'');
        } else if (iM9247d == 9) {
            str = m9239I('\"');
        } else if (iM9247d == 11) {
            str = this.f21636u;
            this.f21636u = null;
        } else if (iM9247d == 15) {
            str = Long.toString(this.f21634s);
        } else {
            if (iM9247d != 16) {
                StringBuilder sbM833U = C1643a.m833U("Expected a string but was ");
                sbM833U.append(mo6878N());
                sbM833U.append(m9250t());
                throw new IllegalStateException(sbM833U.toString());
            }
            str = new String(this.f21628m, this.f21629n, this.f21635t);
            this.f21629n += this.f21635t;
        }
        this.f21633r = 0;
        int[] iArr = this.f21640y;
        int i = this.f21638w - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX INFO: renamed from: L */
    public final String m9240L() throws IOException {
        String string;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.f21629n;
                if (i3 + i2 < this.f21630o) {
                    char c = this.f21628m[i3 + i2];
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
                        m9246c();
                    }
                    i = i2;
                } else if (i2 >= this.f21628m.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.f21628m, this.f21629n, i2);
                    this.f21629n += i2;
                    if (!m9248n(1)) {
                    }
                } else if (!m9248n(i2 + 1)) {
                    i = i2;
                }
                if (sb == null) {
                    string = new String(this.f21628m, this.f21629n, i);
                } else {
                    sb.append(this.f21628m, this.f21629n, i);
                    string = sb.toString();
                }
                this.f21629n += i;
                return string;
            }
        }
    }

    /* JADX INFO: renamed from: N */
    public JsonToken mo6878N() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        switch (iM9247d) {
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

    /* JADX INFO: renamed from: O */
    public final void m9241O(int i) {
        int i2 = this.f21638w;
        int[] iArr = this.f21637v;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.f21637v = Arrays.copyOf(iArr, i3);
            this.f21640y = Arrays.copyOf(this.f21640y, i3);
            this.f21639x = (String[]) Arrays.copyOf(this.f21639x, i3);
        }
        int[] iArr2 = this.f21637v;
        int i4 = this.f21638w;
        this.f21638w = i4 + 1;
        iArr2[i4] = i;
    }

    /* JADX INFO: renamed from: R */
    public final char m9242R() throws IOException {
        int i;
        int i2;
        if (this.f21629n == this.f21630o && !m9248n(1)) {
            m9245V("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.f21628m;
        int i3 = this.f21629n;
        int i4 = i3 + 1;
        this.f21629n = i4;
        char c = cArr[i3];
        if (c == '\n') {
            this.f21631p++;
            this.f21632q = i4;
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
                m9245V("Invalid escape sequence");
                throw null;
            }
            if (i4 + 4 > this.f21630o && !m9248n(4)) {
                m9245V("Unterminated escape sequence");
                throw null;
            }
            char c2 = 0;
            int i5 = this.f21629n;
            int i6 = i5 + 4;
            while (i5 < i6) {
                char c3 = this.f21628m[i5];
                char c4 = (char) (c2 << 4);
                if (c3 < '0' || c3 > '9') {
                    if (c3 >= 'a' && c3 <= 'f') {
                        i = c3 - 'a';
                    } else {
                        if (c3 < 'A' || c3 > 'F') {
                            StringBuilder sbM833U = C1643a.m833U("\\u");
                            sbM833U.append(new String(this.f21628m, this.f21629n, 4));
                            throw new NumberFormatException(sbM833U.toString());
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
            this.f21629n += 4;
            return c2;
        }
        return c;
    }

    /* JADX INFO: renamed from: S */
    public final void m9243S(char c) throws IOException {
        char[] cArr = this.f21628m;
        do {
            int i = this.f21629n;
            int i2 = this.f21630o;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f21629n = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.f21629n = i3;
                    m9242R();
                    i = this.f21629n;
                    i2 = this.f21630o;
                } else {
                    if (c2 == '\n') {
                        this.f21631p++;
                        this.f21632q = i3;
                    }
                    i = i3;
                }
            }
            this.f21629n = i;
        } while (m9248n(1));
        m9245V("Unterminated string");
        throw null;
    }

    /* JADX INFO: renamed from: T */
    public final void m9244T() throws IOException {
        char c;
        do {
            if (this.f21629n >= this.f21630o && !m9248n(1)) {
                return;
            }
            char[] cArr = this.f21628m;
            int i = this.f21629n;
            int i2 = i + 1;
            this.f21629n = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f21631p++;
                this.f21632q = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009b. Please report as an issue. */
    /* JADX INFO: renamed from: U */
    public void mo6879U() throws IOException {
        int i = 0;
        do {
            int iM9247d = this.f21633r;
            if (iM9247d == 0) {
                iM9247d = m9247d();
            }
            if (iM9247d == 3) {
                m9241O(1);
            } else {
                if (iM9247d == 1) {
                    m9241O(3);
                } else if (iM9247d == 4 || iM9247d == 2) {
                    this.f21638w--;
                    i--;
                } else if (iM9247d == 14 || iM9247d == 10) {
                    while (true) {
                        int i2 = 0;
                        while (true) {
                            int i3 = this.f21629n + i2;
                            if (i3 < this.f21630o) {
                                char c = this.f21628m[i3];
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
                                    m9246c();
                                }
                                this.f21629n += i2;
                            } else {
                                this.f21629n = i3;
                                if (!m9248n(1)) {
                                }
                            }
                        }
                    }
                } else if (iM9247d == 8 || iM9247d == 12) {
                    m9243S('\'');
                } else if (iM9247d == 9 || iM9247d == 13) {
                    m9243S('\"');
                } else if (iM9247d == 16) {
                    this.f21629n += this.f21635t;
                }
                this.f21633r = 0;
            }
            i++;
            this.f21633r = 0;
        } while (i != 0);
        int[] iArr = this.f21640y;
        int i4 = this.f21638w;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.f21639x[i4 - 1] = "null";
    }

    /* JADX INFO: renamed from: V */
    public final IOException m9245V(String str) throws IOException {
        StringBuilder sbM833U = C1643a.m833U(str);
        sbM833U.append(m9250t());
        throw new MalformedJsonException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: a */
    public void mo6882a() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 3) {
            m9241O(1);
            this.f21640y[this.f21638w - 1] = 0;
            this.f21633r = 0;
        } else {
            StringBuilder sbM833U = C1643a.m833U("Expected BEGIN_ARRAY but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo6883b() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 1) {
            m9241O(3);
            this.f21633r = 0;
        } else {
            StringBuilder sbM833U = C1643a.m833U("Expected BEGIN_OBJECT but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m9246c() throws IOException {
        if (this.f21627l) {
            return;
        }
        m9245V("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21633r = 0;
        this.f21637v[0] = 8;
        this.f21638w = 1;
        this.f21626k.close();
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
    /* JADX INFO: renamed from: d */
    public int m9247d() throws IOException {
        int iM9238D;
        String str;
        String str2;
        int i;
        char c;
        char[] cArr;
        int i2;
        int i3;
        long j;
        int i4;
        char c2;
        char c3;
        long j2;
        int i5;
        int[] iArr = this.f21637v;
        int i6 = this.f21638w;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int iM9238D2 = m9238D(true);
            if (iM9238D2 != 44) {
                if (iM9238D2 != 59) {
                    if (iM9238D2 == 93) {
                        this.f21633r = 4;
                        return 4;
                    }
                    m9245V("Unterminated array");
                    throw null;
                }
                m9246c();
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5 && (iM9238D = m9238D(true)) != 44) {
                    if (iM9238D != 59) {
                        if (iM9238D == 125) {
                            this.f21633r = 2;
                            return 2;
                        }
                        m9245V("Unterminated object");
                        throw null;
                    }
                    m9246c();
                }
                int iM9238D3 = m9238D(true);
                if (iM9238D3 == 34) {
                    this.f21633r = 13;
                    return 13;
                }
                if (iM9238D3 == 39) {
                    m9246c();
                    this.f21633r = 12;
                    return 12;
                }
                if (iM9238D3 == 125) {
                    if (i7 != 5) {
                        this.f21633r = 2;
                        return 2;
                    }
                    m9245V("Expected name");
                    throw null;
                }
                m9246c();
                this.f21629n--;
                if (m9249s((char) iM9238D3)) {
                    this.f21633r = 14;
                    return 14;
                }
                m9245V("Expected name");
                throw null;
            }
            if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int iM9238D4 = m9238D(true);
                if (iM9238D4 != 58) {
                    if (iM9238D4 != 61) {
                        m9245V("Expected ':'");
                        throw null;
                    }
                    m9246c();
                    if (this.f21629n < this.f21630o || m9248n(1)) {
                        char[] cArr2 = this.f21628m;
                        int i8 = this.f21629n;
                        if (cArr2[i8] == '>') {
                            this.f21629n = i8 + 1;
                        }
                    }
                }
            } else if (i7 == 6) {
                if (this.f21627l) {
                    m9238D(true);
                    int i9 = this.f21629n - 1;
                    this.f21629n = i9;
                    char[] cArr3 = f21625j;
                    if (i9 + cArr3.length <= this.f21630o || m9248n(cArr3.length)) {
                        int i10 = 0;
                        while (true) {
                            char[] cArr4 = f21625j;
                            if (i10 >= cArr4.length) {
                                this.f21629n += cArr4.length;
                                break;
                            }
                            if (this.f21628m[this.f21629n + i10] != cArr4[i10]) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
                this.f21637v[this.f21638w - 1] = 7;
            } else if (i7 == 7) {
                if (m9238D(false) == -1) {
                    this.f21633r = 17;
                    return 17;
                }
                m9246c();
                this.f21629n--;
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM9238D5 = m9238D(true);
        if (iM9238D5 == 34) {
            this.f21633r = 9;
            return 9;
        }
        if (iM9238D5 == 39) {
            m9246c();
            this.f21633r = 8;
            return 8;
        }
        if (iM9238D5 != 44 && iM9238D5 != 59) {
            if (iM9238D5 == 91) {
                this.f21633r = 3;
                return 3;
            }
            if (iM9238D5 != 93) {
                if (iM9238D5 == 123) {
                    this.f21633r = 1;
                    return 1;
                }
                int i11 = this.f21629n - 1;
                this.f21629n = i11;
                char c4 = this.f21628m[i11];
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
                        cArr = this.f21628m;
                        i2 = this.f21629n;
                        i3 = this.f21630o;
                        j = 0;
                        long j3 = 0;
                        i4 = 0;
                        c2 = 0;
                        boolean z2 = true;
                        boolean z3 = false;
                        while (true) {
                            if (i2 + i4 != i3) {
                                c3 = cArr[i2 + i4];
                                if (c3 != '+') {
                                    if (c3 != 'E' || c3 == 'e') {
                                        j2 = j;
                                        if (c2 != 2 || c2 == 4) {
                                            c2 = 5;
                                            i4++;
                                            j = j2;
                                        }
                                    } else if (c3 == '-') {
                                        j2 = j;
                                        if (c2 == 0) {
                                            c2 = 1;
                                            z3 = true;
                                        } else {
                                            if (c2 != 5) {
                                            }
                                            c2 = 6;
                                        }
                                        i4++;
                                        j = j2;
                                    } else if (c3 == '.') {
                                        j2 = j;
                                        if (c2 == 2) {
                                            c2 = 3;
                                            i4++;
                                            j = j2;
                                        }
                                    } else if (c3 >= '0' && c3 <= '9') {
                                        if (c2 == 1 || c2 == 0) {
                                            j3 = -(c3 - '0');
                                            c2 = 2;
                                        } else if (c2 == 2) {
                                            if (j3 != j) {
                                                long j4 = (10 * j3) - ((long) (c3 - '0'));
                                                z2 &= j3 > -922337203685477580L || (j3 == -922337203685477580L && j4 < j3);
                                                j3 = j4;
                                            }
                                        } else if (c2 == 3) {
                                            c2 = 4;
                                        } else if (c2 == 5 || c2 == 6) {
                                            c2 = 7;
                                        }
                                        j2 = 0;
                                        i4++;
                                        j = j2;
                                    } else if (!m9249s(c3)) {
                                        if (c2 != 2 && z2 && ((j3 != Long.MIN_VALUE || z3) && (j3 != 0 || !z3))) {
                                            if (!z3) {
                                                j3 = -j3;
                                            }
                                            this.f21634s = j3;
                                            this.f21629n += i4;
                                            i5 = 15;
                                            this.f21633r = 15;
                                        } else if (c2 != 2 || c2 == 4 || c2 == 7) {
                                            this.f21635t = i4;
                                            i5 = 16;
                                            this.f21633r = 16;
                                        }
                                    }
                                    if (i5 != 0) {
                                        return i5;
                                    }
                                    if (m9249s(this.f21628m[this.f21629n])) {
                                        m9245V("Expected value");
                                        throw null;
                                    }
                                    m9246c();
                                    this.f21633r = 10;
                                    return 10;
                                }
                                j2 = j;
                                if (c2 != 5) {
                                }
                                c2 = 6;
                                i4++;
                                j = j2;
                            } else if (i4 != cArr.length) {
                                if (!m9248n(i4 + 1)) {
                                    i2 = this.f21629n;
                                    i3 = this.f21630o;
                                    c3 = cArr[i2 + i4];
                                    if (c3 != '+') {
                                        if (c3 != 'E') {
                                            j2 = j;
                                            if (c2 != 2) {
                                            }
                                            c2 = 5;
                                            i4++;
                                            j = j2;
                                        } else {
                                            j2 = j;
                                            if (c2 != 2) {
                                            }
                                            c2 = 5;
                                            i4++;
                                            j = j2;
                                        }
                                        if (i5 != 0) {
                                            return i5;
                                        }
                                        if (m9249s(this.f21628m[this.f21629n])) {
                                            m9245V("Expected value");
                                            throw null;
                                        }
                                        m9246c();
                                        this.f21633r = 10;
                                        return 10;
                                    }
                                    j2 = j;
                                    if (c2 != 5) {
                                    }
                                    c2 = 6;
                                    i4++;
                                    j = j2;
                                }
                                if (c2 != 2) {
                                    if (c2 != 2) {
                                    }
                                    this.f21635t = i4;
                                    i5 = 16;
                                    this.f21633r = 16;
                                } else {
                                    if (c2 != 2) {
                                    }
                                    this.f21635t = i4;
                                    i5 = 16;
                                    this.f21633r = 16;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                if (m9249s(this.f21628m[this.f21629n])) {
                                    m9245V("Expected value");
                                    throw null;
                                }
                                m9246c();
                                this.f21633r = 10;
                                return 10;
                            }
                            i5 = 0;
                            if (i5 != 0) {
                                return i5;
                            }
                            if (m9249s(this.f21628m[this.f21629n])) {
                                m9245V("Expected value");
                                throw null;
                            }
                            m9246c();
                            this.f21633r = 10;
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
                        if ((this.f21629n + length >= this.f21630o && !m9248n(length + 1)) || !m9249s(this.f21628m[this.f21629n + length])) {
                            this.f21629n += length;
                            this.f21633r = i;
                            break;
                        }
                        break;
                    }
                    if ((this.f21629n + i12 < this.f21630o || m9248n(i12 + 1)) && ((c = this.f21628m[this.f21629n + i12]) == str.charAt(i12) || c == str2.charAt(i12))) {
                        i12++;
                    }
                    i = 0;
                    break;
                }
                if (i != 0) {
                    return i;
                }
                cArr = this.f21628m;
                i2 = this.f21629n;
                i3 = this.f21630o;
                j = 0;
                long j5 = 0;
                i4 = 0;
                c2 = 0;
                boolean z4 = true;
                boolean z5 = false;
                while (true) {
                    if (i2 + i4 != i3) {
                        c3 = cArr[i2 + i4];
                        if (c3 != '+') {
                            if (c3 != 'E') {
                                j2 = j;
                                if (c2 != 2) {
                                }
                                c2 = 5;
                                i4++;
                                j = j2;
                            } else {
                                j2 = j;
                                if (c2 != 2) {
                                }
                                c2 = 5;
                                i4++;
                                j = j2;
                            }
                            if (i5 != 0) {
                                return i5;
                            }
                            if (m9249s(this.f21628m[this.f21629n])) {
                                m9245V("Expected value");
                                throw null;
                            }
                            m9246c();
                            this.f21633r = 10;
                            return 10;
                        }
                        j2 = j;
                        if (c2 != 5) {
                        }
                        c2 = 6;
                        i4++;
                        j = j2;
                    } else if (i4 != cArr.length) {
                        if (!m9248n(i4 + 1)) {
                            i2 = this.f21629n;
                            i3 = this.f21630o;
                            c3 = cArr[i2 + i4];
                            if (c3 != '+') {
                                if (c3 != 'E') {
                                    j2 = j;
                                    if (c2 != 2) {
                                    }
                                    c2 = 5;
                                    i4++;
                                    j = j2;
                                } else {
                                    j2 = j;
                                    if (c2 != 2) {
                                    }
                                    c2 = 5;
                                    i4++;
                                    j = j2;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                if (m9249s(this.f21628m[this.f21629n])) {
                                    m9245V("Expected value");
                                    throw null;
                                }
                                m9246c();
                                this.f21633r = 10;
                                return 10;
                            }
                            j2 = j;
                            if (c2 != 5) {
                            }
                            c2 = 6;
                            i4++;
                            j = j2;
                        }
                        if (c2 != 2) {
                            if (c2 != 2) {
                            }
                            this.f21635t = i4;
                            i5 = 16;
                            this.f21633r = 16;
                        } else {
                            if (c2 != 2) {
                            }
                            this.f21635t = i4;
                            i5 = 16;
                            this.f21633r = 16;
                        }
                        if (i5 != 0) {
                            return i5;
                        }
                        if (m9249s(this.f21628m[this.f21629n])) {
                            m9245V("Expected value");
                            throw null;
                        }
                        m9246c();
                        this.f21633r = 10;
                        return 10;
                    }
                    i5 = 0;
                    if (i5 != 0) {
                        return i5;
                    }
                    if (m9249s(this.f21628m[this.f21629n])) {
                        m9245V("Expected value");
                        throw null;
                    }
                    m9246c();
                    this.f21633r = 10;
                    return 10;
                }
            }
            if (i7 == 1) {
                this.f21633r = 4;
                return 4;
            }
        }
        if (i7 != 1 && i7 != 2) {
            m9245V("Unexpected value");
            throw null;
        }
        m9246c();
        this.f21629n--;
        this.f21633r = 7;
        return 7;
    }

    /* JADX INFO: renamed from: e */
    public void mo6886e() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d != 4) {
            StringBuilder sbM833U = C1643a.m833U("Expected END_ARRAY but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
        int i = this.f21638w - 1;
        this.f21638w = i;
        int[] iArr = this.f21640y;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f21633r = 0;
    }

    /* JADX INFO: renamed from: f */
    public void mo6887f() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d != 2) {
            StringBuilder sbM833U = C1643a.m833U("Expected END_OBJECT but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
        int i = this.f21638w - 1;
        this.f21638w = i;
        this.f21639x[i] = null;
        int[] iArr = this.f21640y;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f21633r = 0;
    }

    public String getPath() {
        StringBuilder sbM829Q = C1643a.m829Q('$');
        int i = this.f21638w;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f21637v[i2];
            if (i3 == 1 || i3 == 2) {
                sbM829Q.append('[');
                sbM829Q.append(this.f21640y[i2]);
                sbM829Q.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbM829Q.append('.');
                String[] strArr = this.f21639x;
                if (strArr[i2] != null) {
                    sbM829Q.append(strArr[i2]);
                }
            }
        }
        return sbM829Q.toString();
    }

    /* JADX INFO: renamed from: n */
    public final boolean m9248n(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.f21628m;
        int i4 = this.f21632q;
        int i5 = this.f21629n;
        this.f21632q = i4 - i5;
        int i6 = this.f21630o;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f21630o = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f21630o = 0;
        }
        this.f21629n = 0;
        do {
            Reader reader = this.f21626k;
            int i8 = this.f21630o;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.f21630o + i9;
            this.f21630o = i2;
            if (this.f21631p == 0 && (i3 = this.f21632q) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f21629n++;
                this.f21632q = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    /* JADX INFO: renamed from: q */
    public boolean mo6888q() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        return (iM9247d == 2 || iM9247d == 4) ? false : true;
    }

    /* JADX INFO: renamed from: s */
    public final boolean m9249s(char c) throws IOException {
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
        m9246c();
        return false;
    }

    /* JADX INFO: renamed from: t */
    public String m9250t() {
        StringBuilder sbM835W = C1643a.m835W(" at line ", this.f21631p + 1, " column ", (this.f21629n - this.f21632q) + 1, " path ");
        sbM835W.append(getPath());
        return sbM835W.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + m9250t();
    }

    /* JADX INFO: renamed from: u */
    public boolean mo6889u() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 5) {
            this.f21633r = 0;
            int[] iArr = this.f21640y;
            int i = this.f21638w - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iM9247d != 6) {
            StringBuilder sbM833U = C1643a.m833U("Expected a boolean but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
        this.f21633r = 0;
        int[] iArr2 = this.f21640y;
        int i2 = this.f21638w - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    /* JADX INFO: renamed from: x */
    public double mo6890x() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 15) {
            this.f21633r = 0;
            int[] iArr = this.f21640y;
            int i = this.f21638w - 1;
            iArr[i] = iArr[i] + 1;
            return this.f21634s;
        }
        if (iM9247d == 16) {
            this.f21636u = new String(this.f21628m, this.f21629n, this.f21635t);
            this.f21629n += this.f21635t;
        } else if (iM9247d == 8 || iM9247d == 9) {
            this.f21636u = m9239I(iM9247d == 8 ? '\'' : '\"');
        } else if (iM9247d == 10) {
            this.f21636u = m9240L();
        } else if (iM9247d != 11) {
            StringBuilder sbM833U = C1643a.m833U("Expected a double but was ");
            sbM833U.append(mo6878N());
            sbM833U.append(m9250t());
            throw new IllegalStateException(sbM833U.toString());
        }
        this.f21633r = 11;
        double d = Double.parseDouble(this.f21636u);
        if (!this.f21627l && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + m9250t());
        }
        this.f21636u = null;
        this.f21633r = 0;
        int[] iArr2 = this.f21640y;
        int i2 = this.f21638w - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    /* JADX INFO: renamed from: y */
    public int mo6891y() throws IOException {
        int iM9247d = this.f21633r;
        if (iM9247d == 0) {
            iM9247d = m9247d();
        }
        if (iM9247d == 15) {
            long j = this.f21634s;
            int i = (int) j;
            if (j != i) {
                StringBuilder sbM833U = C1643a.m833U("Expected an int but was ");
                sbM833U.append(this.f21634s);
                sbM833U.append(m9250t());
                throw new NumberFormatException(sbM833U.toString());
            }
            this.f21633r = 0;
            int[] iArr = this.f21640y;
            int i2 = this.f21638w - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iM9247d == 16) {
            this.f21636u = new String(this.f21628m, this.f21629n, this.f21635t);
            this.f21629n += this.f21635t;
        } else {
            if (iM9247d != 8 && iM9247d != 9 && iM9247d != 10) {
                StringBuilder sbM833U2 = C1643a.m833U("Expected an int but was ");
                sbM833U2.append(mo6878N());
                sbM833U2.append(m9250t());
                throw new IllegalStateException(sbM833U2.toString());
            }
            if (iM9247d == 10) {
                this.f21636u = m9240L();
            } else {
                this.f21636u = m9239I(iM9247d == 8 ? '\'' : '\"');
            }
            try {
                int i3 = Integer.parseInt(this.f21636u);
                this.f21633r = 0;
                int[] iArr2 = this.f21640y;
                int i4 = this.f21638w - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.f21633r = 11;
        double d = Double.parseDouble(this.f21636u);
        int i5 = (int) d;
        if (i5 != d) {
            StringBuilder sbM833U3 = C1643a.m833U("Expected an int but was ");
            sbM833U3.append(this.f21636u);
            sbM833U3.append(m9250t());
            throw new NumberFormatException(sbM833U3.toString());
        }
        this.f21636u = null;
        this.f21633r = 0;
        int[] iArr3 = this.f21640y;
        int i6 = this.f21638w - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }
}
