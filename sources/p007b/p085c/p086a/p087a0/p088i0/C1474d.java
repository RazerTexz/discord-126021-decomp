package p007b.p085c.p086a.p087a0.p088i0;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: b.c.a.a0.i0.d */
/* JADX INFO: compiled from: JsonUtf8Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1474d extends AbstractC1473c {

    /* JADX INFO: renamed from: o */
    public static final ByteString f2254o = ByteString.m11006h("'\\");

    /* JADX INFO: renamed from: p */
    public static final ByteString f2255p = ByteString.m11006h("\"\\");

    /* JADX INFO: renamed from: q */
    public static final ByteString f2256q = ByteString.m11006h("{}[]:, \n\t\r\f/\\;#=");

    /* JADX INFO: renamed from: r */
    public static final ByteString f2257r = ByteString.m11006h("\n\r");

    /* JADX INFO: renamed from: s */
    public static final ByteString f2258s = ByteString.m11006h("*/");

    /* JADX INFO: renamed from: t */
    public final InterfaceC12390g f2259t;

    /* JADX INFO: renamed from: u */
    public final C12388e f2260u;

    /* JADX INFO: renamed from: v */
    public int f2261v = 0;

    /* JADX INFO: renamed from: w */
    public long f2262w;

    /* JADX INFO: renamed from: x */
    public int f2263x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public String f2264y;

    public C1474d(InterfaceC12390g interfaceC12390g) {
        Objects.requireNonNull(interfaceC12390g, "source == null");
        this.f2259t = interfaceC12390g;
        this.f2260u = interfaceC12390g.mo10457g();
        m614x(6);
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: A */
    public void mo600A() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 14) {
            m626U();
        } else if (iM618I == 13) {
            m625T(f2255p);
        } else if (iM618I == 12) {
            m625T(f2254o);
        } else if (iM618I != 15) {
            StringBuilder sbM833U = C1643a.m833U("Expected a name but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
        this.f2261v = 0;
        this.f2239m[this.f2237k - 1] = "null";
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: C */
    public void mo601C() throws IOException {
        int i = 0;
        do {
            int iM618I = this.f2261v;
            if (iM618I == 0) {
                iM618I = m618I();
            }
            if (iM618I == 3) {
                m614x(1);
            } else {
                if (iM618I == 1) {
                    m614x(3);
                } else if (iM618I == 4) {
                    i--;
                    if (i < 0) {
                        StringBuilder sbM833U = C1643a.m833U("Expected a value but was ");
                        sbM833U.append(mo613u());
                        sbM833U.append(" at path ");
                        sbM833U.append(getPath());
                        throw new C1471a(sbM833U.toString());
                    }
                    this.f2237k--;
                } else if (iM618I == 2) {
                    i--;
                    if (i < 0) {
                        StringBuilder sbM833U2 = C1643a.m833U("Expected a value but was ");
                        sbM833U2.append(mo613u());
                        sbM833U2.append(" at path ");
                        sbM833U2.append(getPath());
                        throw new C1471a(sbM833U2.toString());
                    }
                    this.f2237k--;
                } else if (iM618I == 14 || iM618I == 10) {
                    m626U();
                } else if (iM618I == 9 || iM618I == 13) {
                    m625T(f2255p);
                } else if (iM618I == 8 || iM618I == 12) {
                    m625T(f2254o);
                } else if (iM618I == 17) {
                    this.f2260u.skip(this.f2263x);
                } else if (iM618I == 18) {
                    StringBuilder sbM833U3 = C1643a.m833U("Expected a value but was ");
                    sbM833U3.append(mo613u());
                    sbM833U3.append(" at path ");
                    sbM833U3.append(getPath());
                    throw new C1471a(sbM833U3.toString());
                }
                this.f2261v = 0;
            }
            i++;
            this.f2261v = 0;
        } while (i != 0);
        int[] iArr = this.f2240n;
        int i2 = this.f2237k;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f2239m[i2 - 1] = "null";
    }

    /* JADX INFO: renamed from: H */
    public final void m617H() throws IOException {
        m602D("Use JsonReader.setLenient(true) to accept malformed JSON");
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
    /* JADX INFO: renamed from: I */
    public final int m618I() throws IOException {
        String str;
        String str2;
        int i;
        byte bM10464q;
        char c;
        int i2;
        boolean z2;
        int i3;
        char c2;
        int i4;
        byte bM10464q2;
        int i5;
        int[] iArr = this.f2238l;
        int i6 = this.f2237k;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int iM621N = m621N(true);
            this.f2260u.readByte();
            if (iM621N != 44) {
                if (iM621N == 59) {
                    m617H();
                    throw null;
                }
                if (iM621N == 93) {
                    this.f2261v = 4;
                    return 4;
                }
                m602D("Unterminated array");
                throw null;
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5) {
                    int iM621N2 = m621N(true);
                    this.f2260u.readByte();
                    if (iM621N2 != 44) {
                        if (iM621N2 == 59) {
                            m617H();
                            throw null;
                        }
                        if (iM621N2 == 125) {
                            this.f2261v = 2;
                            return 2;
                        }
                        m602D("Unterminated object");
                        throw null;
                    }
                }
                int iM621N3 = m621N(true);
                if (iM621N3 == 34) {
                    this.f2260u.readByte();
                    this.f2261v = 13;
                    return 13;
                }
                if (iM621N3 == 39) {
                    this.f2260u.readByte();
                    m617H();
                    throw null;
                }
                if (iM621N3 != 125) {
                    m617H();
                    throw null;
                }
                if (i7 == 5) {
                    m602D("Expected name");
                    throw null;
                }
                this.f2260u.readByte();
                this.f2261v = 2;
                return 2;
            }
            if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int iM621N4 = m621N(true);
                this.f2260u.readByte();
                if (iM621N4 != 58) {
                    if (iM621N4 != 61) {
                        m602D("Expected ':'");
                        throw null;
                    }
                    m617H();
                    throw null;
                }
            } else if (i7 == 6) {
                iArr[i6 - 1] = 7;
            } else {
                if (i7 == 7) {
                    if (m621N(false) == -1) {
                        this.f2261v = 18;
                        return 18;
                    }
                    m617H();
                    throw null;
                }
                if (i7 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int iM621N5 = m621N(true);
        if (iM621N5 == 34) {
            this.f2260u.readByte();
            this.f2261v = 9;
            return 9;
        }
        if (iM621N5 == 39) {
            m617H();
            throw null;
        }
        if (iM621N5 != 44 && iM621N5 != 59) {
            if (iM621N5 == 91) {
                this.f2260u.readByte();
                this.f2261v = 3;
                return 3;
            }
            if (iM621N5 != 93) {
                if (iM621N5 == 123) {
                    this.f2260u.readByte();
                    this.f2261v = 1;
                    return 1;
                }
                byte bM10464q3 = this.f2260u.m10464q(0L);
                if (bM10464q3 == 116 || bM10464q3 == 84) {
                    str = "true";
                    str2 = "TRUE";
                    i = 5;
                } else {
                    if (bM10464q3 != 102 && bM10464q3 != 70) {
                        if (bM10464q3 != 110 && bM10464q3 != 78) {
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
                            if (this.f2259t.mo10458j(i3)) {
                                bM10464q2 = this.f2260u.m10464q(i2);
                                if (bM10464q2 != 43) {
                                    if (bM10464q2 != 69 || bM10464q2 == 101) {
                                        i5 = i3;
                                        if (c != 2 || c == 4) {
                                            c = 5;
                                            i2 = i5;
                                        } else {
                                            i4 = 0;
                                        }
                                    } else if (bM10464q2 == 45) {
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
                                    } else if (bM10464q2 != 46) {
                                        if (bM10464q2 >= 48 && bM10464q2 <= 57) {
                                            if (c == 1 || c == 0) {
                                                i5 = i3;
                                                j = -(bM10464q2 - 48);
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
                                                long j2 = (10 * j) - ((long) (bM10464q2 - 48));
                                                z2 = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) & z2;
                                                j = j2;
                                            }
                                            i2 = i5;
                                        } else if (!m620L(bM10464q2)) {
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
                                    if (m620L(this.f2260u.m10464q(0L))) {
                                        m617H();
                                        throw null;
                                    }
                                    m602D("Expected value");
                                    throw null;
                                }
                                i5 = i3;
                                if (c != 5) {
                                    i4 = 0;
                                    if (i4 != 0) {
                                        return i4;
                                    }
                                    if (m620L(this.f2260u.m10464q(0L))) {
                                        m602D("Expected value");
                                        throw null;
                                    }
                                    m617H();
                                    throw null;
                                }
                                c = 6;
                                i2 = i5;
                            }
                            c2 = 2;
                            if (c != 2) {
                                if (c != c2 || c == 4 || c == 7) {
                                    this.f2263x = i2;
                                    i4 = 17;
                                    this.f2261v = 17;
                                } else {
                                    i4 = 0;
                                }
                            } else if (z2 || ((j == Long.MIN_VALUE && !z3) || (j == 0 && z3))) {
                                c2 = 2;
                                if (c != c2) {
                                }
                                this.f2263x = i2;
                                i4 = 17;
                                this.f2261v = 17;
                            } else {
                                if (!z3) {
                                    j = -j;
                                }
                                this.f2262w = j;
                                this.f2260u.skip(i2);
                                i4 = 16;
                                this.f2261v = 16;
                            }
                            if (i4 != 0) {
                                return i4;
                            }
                            if (m620L(this.f2260u.m10464q(0L))) {
                                m602D("Expected value");
                                throw null;
                            }
                            m617H();
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
                        if (!this.f2259t.mo10458j(length + 1) || !m620L(this.f2260u.m10464q(length))) {
                            this.f2260u.skip(length);
                            this.f2261v = i;
                            break;
                        }
                    } else {
                        int i9 = i8 + 1;
                        if (this.f2259t.mo10458j(i9) && ((bM10464q = this.f2260u.m10464q(i8)) == str.charAt(i8) || bM10464q == str2.charAt(i8))) {
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
                    if (this.f2259t.mo10458j(i3)) {
                        bM10464q2 = this.f2260u.m10464q(i2);
                        if (bM10464q2 != 43) {
                            if (bM10464q2 != 69) {
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
                            if (m620L(this.f2260u.m10464q(0L))) {
                                m602D("Expected value");
                                throw null;
                            }
                            m617H();
                            throw null;
                        }
                        i5 = i3;
                        if (c != 5) {
                            i4 = 0;
                            if (i4 != 0) {
                                return i4;
                            }
                            if (m620L(this.f2260u.m10464q(0L))) {
                                m602D("Expected value");
                                throw null;
                            }
                            m617H();
                            throw null;
                        }
                        c = 6;
                        i2 = i5;
                    }
                    c2 = 2;
                    if (c != 2) {
                        if (c != c2) {
                        }
                        this.f2263x = i2;
                        i4 = 17;
                        this.f2261v = 17;
                    } else {
                        if (z2) {
                        }
                        c2 = 2;
                        if (c != c2) {
                        }
                        this.f2263x = i2;
                        i4 = 17;
                        this.f2261v = 17;
                    }
                    if (i4 != 0) {
                        return i4;
                    }
                    if (m620L(this.f2260u.m10464q(0L))) {
                        m602D("Expected value");
                        throw null;
                    }
                    m617H();
                    throw null;
                }
            }
            if (i7 == 1) {
                this.f2260u.readByte();
                this.f2261v = 4;
                return 4;
            }
        }
        if (i7 == 1 || i7 == 2) {
            m617H();
            throw null;
        }
        m602D("Unexpected value");
        throw null;
    }

    /* JADX INFO: renamed from: J */
    public final int m619J(String str, AbstractC1473c.a aVar) {
        int length = aVar.f2241a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f2241a[i])) {
                this.f2261v = 0;
                this.f2239m[this.f2237k - 1] = str;
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: L */
    public final boolean m620L(int i) throws IOException {
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
        m617H();
        throw null;
    }

    /* JADX INFO: renamed from: N */
    public final int m621N(boolean z2) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!this.f2259t.mo10458j(i2)) {
                if (z2) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            byte bM10464q = this.f2260u.m10464q(i);
            if (bM10464q != 10 && bM10464q != 32 && bM10464q != 13 && bM10464q != 9) {
                this.f2260u.skip(i2 - 1);
                if (bM10464q == 47) {
                    if (!this.f2259t.mo10458j(2L)) {
                        return bM10464q;
                    }
                    m617H();
                    throw null;
                }
                if (bM10464q != 35) {
                    return bM10464q;
                }
                m617H();
                throw null;
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: O */
    public final String m622O(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jMo10430E = this.f2259t.mo10430E(byteString);
            if (jMo10430E == -1) {
                m602D("Unterminated string");
                throw null;
            }
            if (this.f2260u.m10464q(jMo10430E) != 92) {
                if (sb == null) {
                    String strM10433H = this.f2260u.m10433H(jMo10430E);
                    this.f2260u.readByte();
                    return strM10433H;
                }
                sb.append(this.f2260u.m10433H(jMo10430E));
                this.f2260u.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f2260u.m10433H(jMo10430E));
            this.f2260u.readByte();
            sb.append(m624S());
        }
    }

    /* JADX INFO: renamed from: R */
    public final String m623R() throws IOException {
        long jMo10430E = this.f2259t.mo10430E(f2256q);
        return jMo10430E != -1 ? this.f2260u.m10433H(jMo10430E) : this.f2260u.m10429D();
    }

    /* JADX INFO: renamed from: S */
    public final char m624S() throws IOException {
        int i;
        int i2;
        if (!this.f2259t.mo10458j(1L)) {
            m602D("Unterminated escape sequence");
            throw null;
        }
        byte b2 = this.f2260u.readByte();
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
            StringBuilder sbM833U = C1643a.m833U("Invalid escape sequence: \\");
            sbM833U.append((char) b2);
            m602D(sbM833U.toString());
            throw null;
        }
        if (!this.f2259t.mo10458j(4L)) {
            StringBuilder sbM833U2 = C1643a.m833U("Unterminated escape sequence at path ");
            sbM833U2.append(getPath());
            throw new EOFException(sbM833U2.toString());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bM10464q = this.f2260u.m10464q(i3);
            char c2 = (char) (c << 4);
            if (bM10464q < 48 || bM10464q > 57) {
                if (bM10464q >= 97 && bM10464q <= 102) {
                    i = bM10464q - 97;
                } else {
                    if (bM10464q < 65 || bM10464q > 70) {
                        StringBuilder sbM833U3 = C1643a.m833U("\\u");
                        sbM833U3.append(this.f2260u.m10433H(4L));
                        m602D(sbM833U3.toString());
                        throw null;
                    }
                    i = bM10464q - 65;
                }
                i2 = i + 10;
            } else {
                i2 = bM10464q - 48;
            }
            c = (char) (i2 + c2);
        }
        this.f2260u.skip(4L);
        return c;
    }

    /* JADX INFO: renamed from: T */
    public final void m625T(ByteString byteString) throws IOException {
        while (true) {
            long jMo10430E = this.f2259t.mo10430E(byteString);
            if (jMo10430E == -1) {
                m602D("Unterminated string");
                throw null;
            }
            if (this.f2260u.m10464q(jMo10430E) != 92) {
                this.f2260u.skip(jMo10430E + 1);
                return;
            } else {
                this.f2260u.skip(jMo10430E + 1);
                m624S();
            }
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m626U() throws IOException {
        long jMo10430E = this.f2259t.mo10430E(f2256q);
        C12388e c12388e = this.f2260u;
        if (jMo10430E == -1) {
            jMo10430E = c12388e.f26080k;
        }
        c12388e.skip(jMo10430E);
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: a */
    public void mo603a() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 3) {
            m614x(1);
            this.f2240n[this.f2237k - 1] = 0;
            this.f2261v = 0;
        } else {
            StringBuilder sbM833U = C1643a.m833U("Expected BEGIN_ARRAY but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: b */
    public void mo604b() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 1) {
            m614x(3);
            this.f2261v = 0;
        } else {
            StringBuilder sbM833U = C1643a.m833U("Expected BEGIN_OBJECT but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: c */
    public void mo605c() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I != 4) {
            StringBuilder sbM833U = C1643a.m833U("Expected END_ARRAY but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
        int i = this.f2237k - 1;
        this.f2237k = i;
        int[] iArr = this.f2240n;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f2261v = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2261v = 0;
        this.f2238l[0] = 8;
        this.f2237k = 1;
        C12388e c12388e = this.f2260u;
        c12388e.skip(c12388e.f26080k);
        this.f2259t.close();
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: d */
    public void mo606d() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I != 2) {
            StringBuilder sbM833U = C1643a.m833U("Expected END_OBJECT but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
        int i = this.f2237k - 1;
        this.f2237k = i;
        this.f2239m[i] = null;
        int[] iArr = this.f2240n;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.f2261v = 0;
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: e */
    public boolean mo607e() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        return (iM618I == 2 || iM618I == 4 || iM618I == 18) ? false : true;
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: f */
    public boolean mo608f() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 5) {
            this.f2261v = 0;
            int[] iArr = this.f2240n;
            int i = this.f2237k - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iM618I == 6) {
            this.f2261v = 0;
            int[] iArr2 = this.f2240n;
            int i2 = this.f2237k - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        StringBuilder sbM833U = C1643a.m833U("Expected a boolean but was ");
        sbM833U.append(mo613u());
        sbM833U.append(" at path ");
        sbM833U.append(getPath());
        throw new C1471a(sbM833U.toString());
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: n */
    public double mo609n() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 16) {
            this.f2261v = 0;
            int[] iArr = this.f2240n;
            int i = this.f2237k - 1;
            iArr[i] = iArr[i] + 1;
            return this.f2262w;
        }
        if (iM618I == 17) {
            this.f2264y = this.f2260u.m10433H(this.f2263x);
        } else if (iM618I == 9) {
            this.f2264y = m622O(f2255p);
        } else if (iM618I == 8) {
            this.f2264y = m622O(f2254o);
        } else if (iM618I == 10) {
            this.f2264y = m623R();
        } else if (iM618I != 11) {
            StringBuilder sbM833U = C1643a.m833U("Expected a double but was ");
            sbM833U.append(mo613u());
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
        this.f2261v = 11;
        try {
            double d = Double.parseDouble(this.f2264y);
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new C1472b("JSON forbids NaN and infinities: " + d + " at path " + getPath());
            }
            this.f2264y = null;
            this.f2261v = 0;
            int[] iArr2 = this.f2240n;
            int i2 = this.f2237k - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return d;
        } catch (NumberFormatException unused) {
            StringBuilder sbM833U2 = C1643a.m833U("Expected a double but was ");
            sbM833U2.append(this.f2264y);
            sbM833U2.append(" at path ");
            sbM833U2.append(getPath());
            throw new C1471a(sbM833U2.toString());
        }
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: q */
    public int mo610q() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 16) {
            long j = this.f2262w;
            int i = (int) j;
            if (j == i) {
                this.f2261v = 0;
                int[] iArr = this.f2240n;
                int i2 = this.f2237k - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            StringBuilder sbM833U = C1643a.m833U("Expected an int but was ");
            sbM833U.append(this.f2262w);
            sbM833U.append(" at path ");
            sbM833U.append(getPath());
            throw new C1471a(sbM833U.toString());
        }
        if (iM618I == 17) {
            this.f2264y = this.f2260u.m10433H(this.f2263x);
        } else if (iM618I == 9 || iM618I == 8) {
            String strM622O = iM618I == 9 ? m622O(f2255p) : m622O(f2254o);
            this.f2264y = strM622O;
            try {
                int i3 = Integer.parseInt(strM622O);
                this.f2261v = 0;
                int[] iArr2 = this.f2240n;
                int i4 = this.f2237k - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iM618I != 11) {
            StringBuilder sbM833U2 = C1643a.m833U("Expected an int but was ");
            sbM833U2.append(mo613u());
            sbM833U2.append(" at path ");
            sbM833U2.append(getPath());
            throw new C1471a(sbM833U2.toString());
        }
        this.f2261v = 11;
        try {
            double d = Double.parseDouble(this.f2264y);
            int i5 = (int) d;
            if (i5 != d) {
                StringBuilder sbM833U3 = C1643a.m833U("Expected an int but was ");
                sbM833U3.append(this.f2264y);
                sbM833U3.append(" at path ");
                sbM833U3.append(getPath());
                throw new C1471a(sbM833U3.toString());
            }
            this.f2264y = null;
            this.f2261v = 0;
            int[] iArr3 = this.f2240n;
            int i6 = this.f2237k - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            StringBuilder sbM833U4 = C1643a.m833U("Expected an int but was ");
            sbM833U4.append(this.f2264y);
            sbM833U4.append(" at path ");
            sbM833U4.append(getPath());
            throw new C1471a(sbM833U4.toString());
        }
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: s */
    public String mo611s() throws IOException {
        String strM622O;
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 14) {
            strM622O = m623R();
        } else if (iM618I == 13) {
            strM622O = m622O(f2255p);
        } else if (iM618I == 12) {
            strM622O = m622O(f2254o);
        } else {
            if (iM618I != 15) {
                StringBuilder sbM833U = C1643a.m833U("Expected a name but was ");
                sbM833U.append(mo613u());
                sbM833U.append(" at path ");
                sbM833U.append(getPath());
                throw new C1471a(sbM833U.toString());
            }
            strM622O = this.f2264y;
        }
        this.f2261v = 0;
        this.f2239m[this.f2237k - 1] = strM622O;
        return strM622O;
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: t */
    public String mo612t() throws IOException {
        String strM10433H;
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I == 10) {
            strM10433H = m623R();
        } else if (iM618I == 9) {
            strM10433H = m622O(f2255p);
        } else if (iM618I == 8) {
            strM10433H = m622O(f2254o);
        } else if (iM618I == 11) {
            strM10433H = this.f2264y;
            this.f2264y = null;
        } else if (iM618I == 16) {
            strM10433H = Long.toString(this.f2262w);
        } else {
            if (iM618I != 17) {
                StringBuilder sbM833U = C1643a.m833U("Expected a string but was ");
                sbM833U.append(mo613u());
                sbM833U.append(" at path ");
                sbM833U.append(getPath());
                throw new C1471a(sbM833U.toString());
            }
            strM10433H = this.f2260u.m10433H(this.f2263x);
        }
        this.f2261v = 0;
        int[] iArr = this.f2240n;
        int i = this.f2237k - 1;
        iArr[i] = iArr[i] + 1;
        return strM10433H;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("JsonReader(");
        sbM833U.append(this.f2259t);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: u */
    public AbstractC1473c.b mo613u() throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        switch (iM618I) {
            case 1:
                return AbstractC1473c.b.BEGIN_OBJECT;
            case 2:
                return AbstractC1473c.b.END_OBJECT;
            case 3:
                return AbstractC1473c.b.BEGIN_ARRAY;
            case 4:
                return AbstractC1473c.b.END_ARRAY;
            case 5:
            case 6:
                return AbstractC1473c.b.BOOLEAN;
            case 7:
                return AbstractC1473c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return AbstractC1473c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return AbstractC1473c.b.NAME;
            case 16:
            case 17:
                return AbstractC1473c.b.NUMBER;
            case 18:
                return AbstractC1473c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c
    /* JADX INFO: renamed from: y */
    public int mo615y(AbstractC1473c.a aVar) throws IOException {
        int iM618I = this.f2261v;
        if (iM618I == 0) {
            iM618I = m618I();
        }
        if (iM618I < 12 || iM618I > 15) {
            return -1;
        }
        if (iM618I == 15) {
            return m619J(this.f2264y, aVar);
        }
        int iMo10471v0 = this.f2259t.mo10471v0(aVar.f2242b);
        if (iMo10471v0 != -1) {
            this.f2261v = 0;
            this.f2239m[this.f2237k - 1] = aVar.f2241a[iMo10471v0];
            return iMo10471v0;
        }
        String str = this.f2239m[this.f2237k - 1];
        String strMo611s = mo611s();
        int iM619J = m619J(strMo611s, aVar);
        if (iM619J == -1) {
            this.f2261v = 15;
            this.f2264y = strMo611s;
            this.f2239m[this.f2237k - 1] = str;
        }
        return iM619J;
    }
}
