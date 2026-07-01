package b.c.a.a0.i0;

import androidx.annotation.Nullable;
import b.c.a.a0.i0.JsonReader2;
import b.d.b.a.outline;
import g0.Buffer3;
import g0.BufferedSource;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: renamed from: b.c.a.a0.i0.d, reason: use source file name */
/* JADX INFO: compiled from: JsonUtf8Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader2 {
    public static final ByteString o = ByteString.h("'\\");
    public static final ByteString p = ByteString.h("\"\\");
    public static final ByteString q = ByteString.h("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString r = ByteString.h("\n\r");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ByteString f335s = ByteString.h("*/");
    public final BufferedSource t;
    public final Buffer3 u;
    public int v = 0;
    public long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f336x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public String f337y;

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        this.t = bufferedSource;
        this.u = bufferedSource.g();
        x(6);
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void A() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 14) {
            U();
        } else if (I == 13) {
            T(p);
        } else if (I == 12) {
            T(o);
        } else if (I != 15) {
            StringBuilder sbU = outline.U("Expected a name but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
        this.v = 0;
        this.m[this.k - 1] = "null";
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void C() throws IOException {
        int i = 0;
        do {
            int I = this.v;
            if (I == 0) {
                I = I();
            }
            if (I == 3) {
                x(1);
            } else {
                if (I == 1) {
                    x(3);
                } else if (I == 4) {
                    i--;
                    if (i < 0) {
                        StringBuilder sbU = outline.U("Expected a value but was ");
                        sbU.append(u());
                        sbU.append(" at path ");
                        sbU.append(getPath());
                        throw new JsonDataException(sbU.toString());
                    }
                    this.k--;
                } else if (I == 2) {
                    i--;
                    if (i < 0) {
                        StringBuilder sbU2 = outline.U("Expected a value but was ");
                        sbU2.append(u());
                        sbU2.append(" at path ");
                        sbU2.append(getPath());
                        throw new JsonDataException(sbU2.toString());
                    }
                    this.k--;
                } else if (I == 14 || I == 10) {
                    U();
                } else if (I == 9 || I == 13) {
                    T(p);
                } else if (I == 8 || I == 12) {
                    T(o);
                } else if (I == 17) {
                    this.u.skip(this.f336x);
                } else if (I == 18) {
                    StringBuilder sbU3 = outline.U("Expected a value but was ");
                    sbU3.append(u());
                    sbU3.append(" at path ");
                    sbU3.append(getPath());
                    throw new JsonDataException(sbU3.toString());
                }
                this.v = 0;
            }
            i++;
            this.v = 0;
        } while (i != 0);
        int[] iArr = this.n;
        int i2 = this.k;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.m[i2 - 1] = "null";
    }

    public final void H() throws IOException {
        D("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:135:0x01af  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d3 A[DONT_INVERT, PHI: r2
      0x01d3: PHI (r2v20 char) = (r2v19 char), (r2v23 char) binds: [B:134:0x01ad, B:146:0x01d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:148:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:164:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:167:0x0203  */
    /* JADX WARN: Code duplicated, block: B:173:0x0213 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:174:0x0214  */
    /* JADX WARN: Code duplicated, block: B:176:0x0222  */
    /* JADX WARN: Code duplicated, block: B:178:0x0228  */
    /* JADX WARN: Code duplicated, block: B:233:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x0123  */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:92:0x0141  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int I() throws IOException {
        String str;
        String str2;
        int i;
        byte bQ;
        char c;
        int i2;
        boolean z2;
        int i3;
        char c2;
        int i4;
        byte bQ2;
        int i5;
        int[] iArr = this.l;
        int i6 = this.k;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int iN = N(true);
            this.u.readByte();
            if (iN != 44) {
                if (iN == 59) {
                    H();
                    throw null;
                }
                if (iN == 93) {
                    this.v = 4;
                    return 4;
                }
                D("Unterminated array");
                throw null;
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5) {
                    int iN2 = N(true);
                    this.u.readByte();
                    if (iN2 != 44) {
                        if (iN2 == 59) {
                            H();
                            throw null;
                        }
                        if (iN2 == 125) {
                            this.v = 2;
                            return 2;
                        }
                        D("Unterminated object");
                        throw null;
                    }
                }
                int iN3 = N(true);
                if (iN3 == 34) {
                    this.u.readByte();
                    this.v = 13;
                    return 13;
                }
                if (iN3 == 39) {
                    this.u.readByte();
                    H();
                    throw null;
                }
                if (iN3 != 125) {
                    H();
                    throw null;
                }
                if (i7 == 5) {
                    D("Expected name");
                    throw null;
                }
                this.u.readByte();
                this.v = 2;
                return 2;
            }
            if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int iN4 = N(true);
                this.u.readByte();
                if (iN4 != 58) {
                    if (iN4 != 61) {
                        D("Expected ':'");
                        throw null;
                    }
                    H();
                    throw null;
                }
            } else if (i7 == 6) {
                iArr[i6 - 1] = 7;
            } else {
                if (i7 == 7) {
                    if (N(false) == -1) {
                        this.v = 18;
                        return 18;
                    }
                    H();
                    throw null;
                }
                if (i7 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int iN5 = N(true);
        if (iN5 == 34) {
            this.u.readByte();
            this.v = 9;
            return 9;
        }
        if (iN5 == 39) {
            H();
            throw null;
        }
        if (iN5 != 44 && iN5 != 59) {
            if (iN5 == 91) {
                this.u.readByte();
                this.v = 3;
                return 3;
            }
            if (iN5 != 93) {
                if (iN5 == 123) {
                    this.u.readByte();
                    this.v = 1;
                    return 1;
                }
                byte bQ3 = this.u.q(0L);
                if (bQ3 == 116 || bQ3 == 84) {
                    str = "true";
                    str2 = "TRUE";
                    i = 5;
                } else {
                    if (bQ3 != 102 && bQ3 != 70) {
                        if (bQ3 != 110 && bQ3 != 78) {
                            i = 0;
                            break;
                        }
                        str = "null";
                        str2 = "NULL";
                        i = 7;
                        if (i != 0) {
                            return i;
                        }
                        long j = 0;
                        c = 0;
                        i2 = 0;
                        z2 = true;
                        boolean z3 = false;
                        while (true) {
                            i3 = i2 + 1;
                            if (this.t.j(i3)) {
                                bQ2 = this.u.q(i2);
                                if (bQ2 != 43) {
                                    if (bQ2 != 69 || bQ2 == 101) {
                                        i5 = i3;
                                        if (c != 2 || c == 4) {
                                            c = 5;
                                            i2 = i5;
                                        } else {
                                            i4 = 0;
                                        }
                                    } else if (bQ2 == 45) {
                                        i5 = i3;
                                        if (c == 0) {
                                            c = 1;
                                            z3 = true;
                                        } else {
                                            if (c != 5) {
                                                i4 = 0;
                                            }
                                            c = 6;
                                        }
                                        i2 = i5;
                                    } else if (bQ2 != 46) {
                                        if (bQ2 >= 48 && bQ2 <= 57) {
                                            if (c == 1 || c == 0) {
                                                i5 = i3;
                                                j = -(bQ2 - 48);
                                                c = 2;
                                            } else if (c != 2) {
                                                i5 = i3;
                                                if (c == 3) {
                                                    c = 4;
                                                } else if (c == 5 || c == 6) {
                                                    c = 7;
                                                }
                                                i2 = i5;
                                            } else if (j != 0) {
                                                i5 = i3;
                                                long j2 = (10 * j) - ((long) (bQ2 - 48));
                                                z2 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z2;
                                                j = j2;
                                            }
                                            i2 = i5;
                                        } else if (!L(bQ2)) {
                                        }
                                        i4 = 0;
                                    } else {
                                        i5 = i3;
                                        if (c == 2) {
                                            c = 3;
                                            i2 = i5;
                                        } else {
                                            i4 = 0;
                                        }
                                    }
                                    if (i4 != 0) {
                                        return i4;
                                    }
                                    if (L(this.u.q(0L))) {
                                        H();
                                        throw null;
                                    }
                                    D("Expected value");
                                    throw null;
                                }
                                i5 = i3;
                                if (c != 5) {
                                    i4 = 0;
                                    if (i4 != 0) {
                                        return i4;
                                    }
                                    if (L(this.u.q(0L))) {
                                        D("Expected value");
                                        throw null;
                                    }
                                    H();
                                    throw null;
                                }
                                c = 6;
                                i2 = i5;
                            }
                            c2 = 2;
                            if (c != 2) {
                                if (c != c2 || c == 4 || c == 7) {
                                    this.f336x = i2;
                                    i4 = 17;
                                    this.v = 17;
                                } else {
                                    i4 = 0;
                                }
                            } else if (z2 || ((j == Long.MIN_VALUE && !z3) || (j == 0 && z3))) {
                                c2 = 2;
                                if (c != c2) {
                                }
                                this.f336x = i2;
                                i4 = 17;
                                this.v = 17;
                            } else {
                                if (!z3) {
                                    j = -j;
                                }
                                this.w = j;
                                this.u.skip(i2);
                                i4 = 16;
                                this.v = 16;
                            }
                            if (i4 != 0) {
                                return i4;
                            }
                            if (L(this.u.q(0L))) {
                                D("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                    }
                    str = "false";
                    str2 = "FALSE";
                    i = 6;
                }
                int length = str.length();
                int i8 = 1;
                while (true) {
                    if (i8 >= length) {
                        if (!this.t.j(length + 1) || !L(this.u.q(length))) {
                            this.u.skip(length);
                            this.v = i;
                            break;
                        }
                    } else {
                        int i9 = i8 + 1;
                        if (this.t.j(i9) && ((bQ = this.u.q(i8)) == str.charAt(i8) || bQ == str2.charAt(i8))) {
                            i8 = i9;
                        }
                    }
                    i = 0;
                    break;
                }
                if (i != 0) {
                    return i;
                }
                long j3 = 0;
                c = 0;
                i2 = 0;
                z2 = true;
                boolean z4 = false;
                while (true) {
                    i3 = i2 + 1;
                    if (this.t.j(i3)) {
                        bQ2 = this.u.q(i2);
                        if (bQ2 != 43) {
                            if (bQ2 != 69) {
                                i5 = i3;
                                if (c != 2) {
                                }
                                c = 5;
                                i2 = i5;
                            } else {
                                i5 = i3;
                                if (c != 2) {
                                }
                                c = 5;
                                i2 = i5;
                            }
                            if (i4 != 0) {
                                return i4;
                            }
                            if (L(this.u.q(0L))) {
                                D("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        i5 = i3;
                        if (c != 5) {
                            i4 = 0;
                            if (i4 != 0) {
                                return i4;
                            }
                            if (L(this.u.q(0L))) {
                                D("Expected value");
                                throw null;
                            }
                            H();
                            throw null;
                        }
                        c = 6;
                        i2 = i5;
                    }
                    c2 = 2;
                    if (c != 2) {
                        if (c != c2) {
                        }
                        this.f336x = i2;
                        i4 = 17;
                        this.v = 17;
                    } else {
                        if (z2) {
                        }
                        c2 = 2;
                        if (c != c2) {
                        }
                        this.f336x = i2;
                        i4 = 17;
                        this.v = 17;
                    }
                    if (i4 != 0) {
                        return i4;
                    }
                    if (L(this.u.q(0L))) {
                        D("Expected value");
                        throw null;
                    }
                    H();
                    throw null;
                }
            }
            if (i7 == 1) {
                this.u.readByte();
                this.v = 4;
                return 4;
            }
        }
        if (i7 == 1 || i7 == 2) {
            H();
            throw null;
        }
        D("Unexpected value");
        throw null;
    }

    public final int J(String str, JsonReader2.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.v = 0;
                this.m[this.k - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean L(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        H();
        throw null;
    }

    public final int N(boolean z2) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!this.t.j(i2)) {
                if (z2) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            byte bQ = this.u.q(i);
            if (bQ != 10 && bQ != 32 && bQ != 13 && bQ != 9) {
                this.u.skip(i2 - 1);
                if (bQ == 47) {
                    if (!this.t.j(2L)) {
                        return bQ;
                    }
                    H();
                    throw null;
                }
                if (bQ != 35) {
                    return bQ;
                }
                H();
                throw null;
            }
            i = i2;
        }
    }

    public final String O(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jE = this.t.E(byteString);
            if (jE == -1) {
                D("Unterminated string");
                throw null;
            }
            if (this.u.q(jE) != 92) {
                if (sb == null) {
                    String strH = this.u.H(jE);
                    this.u.readByte();
                    return strH;
                }
                sb.append(this.u.H(jE));
                this.u.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.u.H(jE));
            this.u.readByte();
            sb.append(S());
        }
    }

    public final String R() throws IOException {
        long jE = this.t.E(q);
        return jE != -1 ? this.u.H(jE) : this.u.D();
    }

    public final char S() throws IOException {
        int i;
        int i2;
        if (!this.t.j(1L)) {
            D("Unterminated escape sequence");
            throw null;
        }
        byte b2 = this.u.readByte();
        if (b2 == 10 || b2 == 34 || b2 == 39 || b2 == 47 || b2 == 92) {
            return (char) b2;
        }
        if (b2 == 98) {
            return '\b';
        }
        if (b2 == 102) {
            return '\f';
        }
        if (b2 == 110) {
            return '\n';
        }
        if (b2 == 114) {
            return '\r';
        }
        if (b2 == 116) {
            return '\t';
        }
        if (b2 != 117) {
            StringBuilder sbU = outline.U("Invalid escape sequence: \\");
            sbU.append((char) b2);
            D(sbU.toString());
            throw null;
        }
        if (!this.t.j(4L)) {
            StringBuilder sbU2 = outline.U("Unterminated escape sequence at path ");
            sbU2.append(getPath());
            throw new EOFException(sbU2.toString());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bQ = this.u.q(i3);
            char c2 = (char) (c << 4);
            if (bQ < 48 || bQ > 57) {
                if (bQ >= 97 && bQ <= 102) {
                    i = bQ - 97;
                } else {
                    if (bQ < 65 || bQ > 70) {
                        StringBuilder sbU3 = outline.U("\\u");
                        sbU3.append(this.u.H(4L));
                        D(sbU3.toString());
                        throw null;
                    }
                    i = bQ - 65;
                }
                i2 = i + 10;
            } else {
                i2 = bQ - 48;
            }
            c = (char) (i2 + c2);
        }
        this.u.skip(4L);
        return c;
    }

    public final void T(ByteString byteString) throws IOException {
        while (true) {
            long jE = this.t.E(byteString);
            if (jE == -1) {
                D("Unterminated string");
                throw null;
            }
            if (this.u.q(jE) != 92) {
                this.u.skip(jE + 1);
                return;
            } else {
                this.u.skip(jE + 1);
                S();
            }
        }
    }

    public final void U() throws IOException {
        long jE = this.t.E(q);
        Buffer3 buffer3 = this.u;
        if (jE == -1) {
            jE = buffer3.k;
        }
        buffer3.skip(jE);
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void a() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 3) {
            x(1);
            this.n[this.k - 1] = 0;
            this.v = 0;
        } else {
            StringBuilder sbU = outline.U("Expected BEGIN_ARRAY but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void b() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 1) {
            x(3);
            this.v = 0;
        } else {
            StringBuilder sbU = outline.U("Expected BEGIN_OBJECT but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void c() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I != 4) {
            StringBuilder sbU = outline.U("Expected END_ARRAY but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
        int i = this.k - 1;
        this.k = i;
        int[] iArr = this.n;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.v = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.v = 0;
        this.l[0] = 8;
        this.k = 1;
        Buffer3 buffer3 = this.u;
        buffer3.skip(buffer3.k);
        this.t.close();
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public void d() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I != 2) {
            StringBuilder sbU = outline.U("Expected END_OBJECT but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
        int i = this.k - 1;
        this.k = i;
        this.m[i] = null;
        int[] iArr = this.n;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.v = 0;
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public boolean e() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        return (I == 2 || I == 4 || I == 18) ? false : true;
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public boolean f() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 5) {
            this.v = 0;
            int[] iArr = this.n;
            int i = this.k - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (I == 6) {
            this.v = 0;
            int[] iArr2 = this.n;
            int i2 = this.k - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        StringBuilder sbU = outline.U("Expected a boolean but was ");
        sbU.append(u());
        sbU.append(" at path ");
        sbU.append(getPath());
        throw new JsonDataException(sbU.toString());
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public double n() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 16) {
            this.v = 0;
            int[] iArr = this.n;
            int i = this.k - 1;
            iArr[i] = iArr[i] + 1;
            return this.w;
        }
        if (I == 17) {
            this.f337y = this.u.H(this.f336x);
        } else if (I == 9) {
            this.f337y = O(p);
        } else if (I == 8) {
            this.f337y = O(o);
        } else if (I == 10) {
            this.f337y = R();
        } else if (I != 11) {
            StringBuilder sbU = outline.U("Expected a double but was ");
            sbU.append(u());
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
        this.v = 11;
        try {
            double d = Double.parseDouble(this.f337y);
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + d + " at path " + getPath());
            }
            this.f337y = null;
            this.v = 0;
            int[] iArr2 = this.n;
            int i2 = this.k - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return d;
        } catch (NumberFormatException unused) {
            StringBuilder sbU2 = outline.U("Expected a double but was ");
            sbU2.append(this.f337y);
            sbU2.append(" at path ");
            sbU2.append(getPath());
            throw new JsonDataException(sbU2.toString());
        }
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public int q() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 16) {
            long j = this.w;
            int i = (int) j;
            if (j == i) {
                this.v = 0;
                int[] iArr = this.n;
                int i2 = this.k - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            StringBuilder sbU = outline.U("Expected an int but was ");
            sbU.append(this.w);
            sbU.append(" at path ");
            sbU.append(getPath());
            throw new JsonDataException(sbU.toString());
        }
        if (I == 17) {
            this.f337y = this.u.H(this.f336x);
        } else if (I == 9 || I == 8) {
            String strO = I == 9 ? O(p) : O(o);
            this.f337y = strO;
            try {
                int i3 = Integer.parseInt(strO);
                this.v = 0;
                int[] iArr2 = this.n;
                int i4 = this.k - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (I != 11) {
            StringBuilder sbU2 = outline.U("Expected an int but was ");
            sbU2.append(u());
            sbU2.append(" at path ");
            sbU2.append(getPath());
            throw new JsonDataException(sbU2.toString());
        }
        this.v = 11;
        try {
            double d = Double.parseDouble(this.f337y);
            int i5 = (int) d;
            if (i5 != d) {
                StringBuilder sbU3 = outline.U("Expected an int but was ");
                sbU3.append(this.f337y);
                sbU3.append(" at path ");
                sbU3.append(getPath());
                throw new JsonDataException(sbU3.toString());
            }
            this.f337y = null;
            this.v = 0;
            int[] iArr3 = this.n;
            int i6 = this.k - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            StringBuilder sbU4 = outline.U("Expected an int but was ");
            sbU4.append(this.f337y);
            sbU4.append(" at path ");
            sbU4.append(getPath());
            throw new JsonDataException(sbU4.toString());
        }
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public String s() throws IOException {
        String strO;
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 14) {
            strO = R();
        } else if (I == 13) {
            strO = O(p);
        } else if (I == 12) {
            strO = O(o);
        } else {
            if (I != 15) {
                StringBuilder sbU = outline.U("Expected a name but was ");
                sbU.append(u());
                sbU.append(" at path ");
                sbU.append(getPath());
                throw new JsonDataException(sbU.toString());
            }
            strO = this.f337y;
        }
        this.v = 0;
        this.m[this.k - 1] = strO;
        return strO;
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public String t() throws IOException {
        String strH;
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I == 10) {
            strH = R();
        } else if (I == 9) {
            strH = O(p);
        } else if (I == 8) {
            strH = O(o);
        } else if (I == 11) {
            strH = this.f337y;
            this.f337y = null;
        } else if (I == 16) {
            strH = Long.toString(this.w);
        } else {
            if (I != 17) {
                StringBuilder sbU = outline.U("Expected a string but was ");
                sbU.append(u());
                sbU.append(" at path ");
                sbU.append(getPath());
                throw new JsonDataException(sbU.toString());
            }
            strH = this.u.H(this.f336x);
        }
        this.v = 0;
        int[] iArr = this.n;
        int i = this.k - 1;
        iArr[i] = iArr[i] + 1;
        return strH;
    }

    public String toString() {
        StringBuilder sbU = outline.U("JsonReader(");
        sbU.append(this.t);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public JsonReader2.b u() throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        switch (I) {
            case 1:
                return JsonReader2.b.BEGIN_OBJECT;
            case 2:
                return JsonReader2.b.END_OBJECT;
            case 3:
                return JsonReader2.b.BEGIN_ARRAY;
            case 4:
                return JsonReader2.b.END_ARRAY;
            case 5:
            case 6:
                return JsonReader2.b.BOOLEAN;
            case 7:
                return JsonReader2.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader2.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader2.b.NAME;
            case 16:
            case 17:
                return JsonReader2.b.NUMBER;
            case 18:
                return JsonReader2.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // b.c.a.a0.i0.JsonReader2
    public int y(JsonReader2.a aVar) throws IOException {
        int I = this.v;
        if (I == 0) {
            I = I();
        }
        if (I < 12 || I > 15) {
            return -1;
        }
        if (I == 15) {
            return J(this.f337y, aVar);
        }
        int iV0 = this.t.v0(aVar.f333b);
        if (iV0 != -1) {
            this.v = 0;
            this.m[this.k - 1] = aVar.a[iV0];
            return iV0;
        }
        String str = this.m[this.k - 1];
        String strS = s();
        int iJ = J(strS, aVar);
        if (iJ == -1) {
            this.v = 15;
            this.f337y = strS;
            this.m[this.k - 1] = str;
        }
        return iJ;
    }
}
