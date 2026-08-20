package p617h0.p618a.p619a;

import androidx.core.view.ViewCompat;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.m */
/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12424m {

    /* JADX INFO: renamed from: a */
    public C12427p f26228a;

    /* JADX INFO: renamed from: b */
    public int[] f26229b;

    /* JADX INFO: renamed from: c */
    public int[] f26230c;

    /* JADX INFO: renamed from: d */
    public int[] f26231d;

    /* JADX INFO: renamed from: e */
    public int[] f26232e;

    /* JADX INFO: renamed from: f */
    public short f26233f;

    /* JADX INFO: renamed from: g */
    public short f26234g;

    /* JADX INFO: renamed from: h */
    public int f26235h;

    /* JADX INFO: renamed from: i */
    public int[] f26236i;

    public C12424m(C12427p c12427p) {
        this.f26228a = c12427p;
    }

    /* JADX INFO: renamed from: c */
    public static int m10572c(C12433v c12433v, Object obj) {
        if (obj instanceof Integer) {
            return 16777216 | ((Integer) obj).intValue();
        }
        return obj instanceof String ? m10573d(c12433v, C12434w.m10647h((String) obj).m10651d(), 0) : c12433v.m10641p("", ((C12427p) obj).f26252e) | 50331648;
    }

    /* JADX INFO: renamed from: d */
    public static int m10573d(C12433v c12433v, String str, int i) {
        char cCharAt = str.charAt(i);
        int iM10639n = 16777218;
        if (cCharAt == 'F') {
            return 16777218;
        }
        if (cCharAt == 'L') {
            return c12433v.m10639n(str.substring(i + 1, str.length() - 1)) | 33554432;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return 16777220;
                }
                if (cCharAt != 'Z') {
                    if (cCharAt == '[') {
                        int i2 = i + 1;
                        while (str.charAt(i2) == '[') {
                            i2++;
                        }
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 != 'F') {
                            if (cCharAt2 == 'L') {
                                iM10639n = c12433v.m10639n(str.substring(i2 + 1, str.length() - 1)) | 33554432;
                            } else if (cCharAt2 == 'S') {
                                iM10639n = 16777228;
                            } else if (cCharAt2 == 'Z') {
                                iM10639n = 16777225;
                            } else if (cCharAt2 == 'I') {
                                iM10639n = 16777217;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        iM10639n = 16777226;
                                        break;
                                    case 'C':
                                        iM10639n = 16777227;
                                        break;
                                    case 'D':
                                        iM10639n = 16777219;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                iM10639n = 16777220;
                            }
                        }
                        return ((i2 - i) << 28) | iM10639n;
                    }
                    switch (cCharAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 16777219;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 16777217;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m10574g(C12433v c12433v, int i, int[] iArr, int i2) {
        int iMin;
        int iM10639n;
        int i3;
        int i4 = i;
        int i5 = iArr[i2];
        if (i5 == i4) {
            return false;
        }
        if ((268435455 & i4) == 16777221) {
            if (i5 == 16777221) {
                return false;
            }
            i4 = 16777221;
        }
        if (i5 == 0) {
            iArr[i2] = i4;
            return true;
        }
        int i6 = i5 & (-268435456);
        int i7 = 16777216;
        if (i6 != 0 || (i5 & 251658240) == 33554432) {
            if (i4 == 16777221) {
                return false;
            }
            String strReplace = "java/lang/Object";
            if ((i4 & ViewCompat.MEASURED_STATE_MASK) != ((-16777216) & i5)) {
                int i8 = i4 & (-268435456);
                if (i8 != 0 || (i4 & 251658240) == 33554432) {
                    if (i8 != 0 && (i4 & 251658240) != 33554432) {
                        i8 -= 268435456;
                    }
                    if (i6 != 0 && (i5 & 251658240) != 33554432) {
                        i6 -= 268435456;
                    }
                    iMin = Math.min(i8, i6) | 33554432;
                    iM10639n = c12433v.m10639n("java/lang/Object");
                    i7 = iMin | iM10639n;
                }
            } else if ((i5 & 251658240) == 33554432) {
                int i9 = (i4 & (-268435456)) | 33554432;
                int i10 = i4 & 1048575;
                int i11 = 1048575 & i5;
                long j = ((long) i10) | (((long) i11) << 32);
                int iM10622r = C12433v.m10622r(130, i10 + i11);
                C12433v.a aVarM10642q = c12433v.m10642q(iM10622r);
                while (true) {
                    if (aVarM10642q == null) {
                        C12433v.a[] aVarArr = c12433v.f26358l;
                        String str = aVarArr[i10].f26344e;
                        String str2 = aVarArr[i11].f26344e;
                        Objects.requireNonNull(c12433v.f26347a);
                        ClassLoader classLoader = C12417f.class.getClassLoader();
                        try {
                            Class<?> cls = Class.forName(str.replace(MentionUtilsKt.SLASH_CHAR, '.'), false, classLoader);
                            try {
                                Class<?> cls2 = Class.forName(str2.replace(MentionUtilsKt.SLASH_CHAR, '.'), false, classLoader);
                                if (cls.isAssignableFrom(cls2)) {
                                    strReplace = str;
                                } else if (cls2.isAssignableFrom(cls)) {
                                    strReplace = str2;
                                } else if (!cls.isInterface() && !cls2.isInterface()) {
                                    do {
                                        cls = cls.getSuperclass();
                                    } while (!cls.isAssignableFrom(cls2));
                                    strReplace = cls.getName().replace('.', MentionUtilsKt.SLASH_CHAR);
                                }
                                int iM10639n2 = c12433v.m10639n(strReplace);
                                C12433v.a aVar = new C12433v.a(c12433v.f26357k, 130, j, iM10622r);
                                c12433v.m10643v(aVar);
                                aVar.f26346g = iM10639n2;
                                i3 = iM10639n2;
                                break;
                            } catch (ClassNotFoundException e) {
                                throw new TypeNotPresentException(str2, e);
                            }
                        } catch (ClassNotFoundException e2) {
                            throw new TypeNotPresentException(str, e2);
                        }
                    }
                    if (aVarM10642q.f26341b == 130 && aVarM10642q.f26359h == iM10622r && aVarM10642q.f26345f == j) {
                        i3 = aVarM10642q.f26346g;
                        break;
                    }
                    aVarM10642q = aVarM10642q.f26360i;
                }
                i7 = i9 | i3;
            } else {
                iMin = ((i4 & (-268435456)) - 268435456) | 33554432;
                iM10639n = c12433v.m10639n("java/lang/Object");
                i7 = iMin | iM10639n;
            }
        } else if (i5 == 16777221) {
            if ((i4 & (-268435456)) == 0 && (i4 & 251658240) != 33554432) {
                i4 = 16777216;
            }
            i7 = i4;
        }
        if (i7 == i5) {
            return false;
        }
        iArr[i2] = i7;
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m10575a(C12429r c12429r) {
        int i;
        int[] iArr = this.f26229b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (true) {
            int i5 = 0;
            do {
                int i6 = 2;
                if (i3 >= iArr.length) {
                    break loop0;
                }
                i = iArr[i3];
                if (i != 16777220 && i != 16777219) {
                    i6 = 1;
                }
                i3 += i6;
                i5++;
            } while (i == 16777216);
            i4 += i5;
        }
        int[] iArr2 = this.f26230c;
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i7 += (i9 == 16777220 || i9 == 16777219) ? 2 : 1;
            i8++;
        }
        c12429r.m10613A(this.f26228a.f26252e, i4, i8);
        int i10 = 3;
        int i11 = 0;
        while (true) {
            int i12 = i4 - 1;
            if (i4 <= 0) {
                break;
            }
            int i13 = iArr[i11];
            i11 += (i13 == 16777220 || i13 == 16777219) ? 2 : 1;
            c12429r.f26287W[i10] = i13;
            i4 = i12;
            i10++;
        }
        while (true) {
            int i14 = i8 - 1;
            if (i8 <= 0) {
                c12429r.m10620z();
                return;
            }
            int i15 = iArr2[i2];
            i2 += (i15 == 16777220 || i15 == 16777219) ? 2 : 1;
            c12429r.f26287W[i10] = i15;
            i10++;
            i8 = i14;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02da  */
    /* JADX WARN: Code duplicated, block: B:103:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:121:0x035f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0366  */
    /* JADX WARN: Code duplicated, block: B:123:0x036a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0371  */
    /* JADX INFO: renamed from: b */
    public void mo10569b(int i, int i2, AbstractC12432u abstractC12432u, C12433v c12433v) {
        switch (i) {
            case 0:
                return;
            case 1:
                m10582l(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
                m10582l(16777217);
                return;
            case 9:
            case 10:
                m10582l(16777220);
                m10582l(16777216);
                return;
            case 11:
            case 12:
            case 13:
                m10582l(16777218);
                return;
            case 14:
            case 15:
                m10582l(16777219);
                m10582l(16777216);
                return;
            case 18:
                int i3 = abstractC12432u.f26341b;
                switch (i3) {
                    case 3:
                        m10582l(16777217);
                        return;
                    case 4:
                        m10582l(16777218);
                        return;
                    case 5:
                        m10582l(16777220);
                        m10582l(16777216);
                        return;
                    case 6:
                        m10582l(16777219);
                        m10582l(16777216);
                        return;
                    case 7:
                        m10582l(c12433v.m10639n("java/lang/Class") | 33554432);
                        return;
                    case 8:
                        m10582l(c12433v.m10639n("java/lang/String") | 33554432);
                        return;
                    default:
                        switch (i3) {
                            case 15:
                                m10582l(c12433v.m10639n("java/lang/invoke/MethodHandle") | 33554432);
                                return;
                            case 16:
                                m10582l(c12433v.m10639n("java/lang/invoke/MethodType") | 33554432);
                                return;
                            case 17:
                                m10583m(c12433v, abstractC12432u.f26344e);
                                return;
                            default:
                                throw new AssertionError();
                        }
                }
            default:
                switch (i) {
                    case 21:
                        m10582l(16777217);
                        return;
                    case 22:
                        m10582l(16777220);
                        m10582l(16777216);
                        return;
                    case 23:
                        m10582l(16777218);
                        return;
                    case 24:
                        m10582l(16777219);
                        m10582l(16777216);
                        return;
                    case 25:
                        m10582l(m10577f(i2));
                        return;
                    default:
                        switch (i) {
                            case 46:
                            case 51:
                            case 52:
                            case 53:
                                m10580j(2);
                                m10582l(16777217);
                                return;
                            case 47:
                                m10580j(2);
                                m10582l(16777220);
                                m10582l(16777216);
                                return;
                            case 48:
                                m10580j(2);
                                m10582l(16777218);
                                return;
                            case 49:
                                m10580j(2);
                                m10582l(16777219);
                                m10582l(16777216);
                                return;
                            case 50:
                                m10580j(1);
                                int iM10579i = m10579i();
                                if (iM10579i != 16777221) {
                                    iM10579i -= 268435456;
                                }
                                m10582l(iM10579i);
                                return;
                            case 54:
                            case 56:
                            case 58:
                                m10585o(i2, m10579i());
                                if (i2 > 0) {
                                    int i4 = i2 - 1;
                                    int iM10577f = m10577f(i4);
                                    if (iM10577f == 16777220 || iM10577f == 16777219) {
                                        m10585o(i4, 16777216);
                                        return;
                                    }
                                    int i5 = iM10577f & 251658240;
                                    if (i5 == 67108864 || i5 == 83886080) {
                                        m10585o(i4, iM10577f | 1048576);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 55:
                            case 57:
                                m10580j(1);
                                m10585o(i2, m10579i());
                                m10585o(i2 + 1, 16777216);
                                if (i2 > 0) {
                                    int i6 = i2 - 1;
                                    int iM10577f2 = m10577f(i6);
                                    if (iM10577f2 == 16777220 || iM10577f2 == 16777219) {
                                        m10585o(i6, 16777216);
                                        return;
                                    }
                                    int i7 = iM10577f2 & 251658240;
                                    if (i7 == 67108864 || i7 == 83886080) {
                                        m10585o(i6, iM10577f2 | 1048576);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case 79:
                                    case 81:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                        m10580j(3);
                                        return;
                                    case 80:
                                    case 82:
                                        m10580j(4);
                                        return;
                                    case 87:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case Opcodes.TABLESWITCH /* 170 */:
                                    case Opcodes.LOOKUPSWITCH /* 171 */:
                                    case Opcodes.IRETURN /* 172 */:
                                    case Opcodes.FRETURN /* 174 */:
                                    case Opcodes.ARETURN /* 176 */:
                                    case Opcodes.ATHROW /* 191 */:
                                    case Opcodes.MONITORENTER /* 194 */:
                                    case Opcodes.MONITOREXIT /* 195 */:
                                        break;
                                    case 88:
                                    case Opcodes.IF_ICMPEQ /* 159 */:
                                    case Opcodes.IF_ICMPNE /* 160 */:
                                    case Opcodes.IF_ICMPLT /* 161 */:
                                    case Opcodes.IF_ICMPGE /* 162 */:
                                    case Opcodes.IF_ICMPGT /* 163 */:
                                    case Opcodes.IF_ICMPLE /* 164 */:
                                    case Opcodes.IF_ACMPEQ /* 165 */:
                                    case Opcodes.IF_ACMPNE /* 166 */:
                                    case Opcodes.LRETURN /* 173 */:
                                    case 175:
                                        m10580j(2);
                                        return;
                                    case 89:
                                        int iM10579i2 = m10579i();
                                        m10582l(iM10579i2);
                                        m10582l(iM10579i2);
                                        return;
                                    case 90:
                                        int iM10579i3 = m10579i();
                                        int iM10579i4 = m10579i();
                                        m10582l(iM10579i3);
                                        m10582l(iM10579i4);
                                        m10582l(iM10579i3);
                                        return;
                                    case 91:
                                        int iM10579i5 = m10579i();
                                        int iM10579i6 = m10579i();
                                        int iM10579i7 = m10579i();
                                        m10582l(iM10579i5);
                                        m10582l(iM10579i7);
                                        m10582l(iM10579i6);
                                        m10582l(iM10579i5);
                                        return;
                                    case 92:
                                        int iM10579i8 = m10579i();
                                        int iM10579i9 = m10579i();
                                        m10582l(iM10579i9);
                                        m10582l(iM10579i8);
                                        m10582l(iM10579i9);
                                        m10582l(iM10579i8);
                                        return;
                                    case 93:
                                        int iM10579i10 = m10579i();
                                        int iM10579i11 = m10579i();
                                        int iM10579i12 = m10579i();
                                        m10582l(iM10579i11);
                                        m10582l(iM10579i10);
                                        m10582l(iM10579i12);
                                        m10582l(iM10579i11);
                                        m10582l(iM10579i10);
                                        return;
                                    case 94:
                                        int iM10579i13 = m10579i();
                                        int iM10579i14 = m10579i();
                                        int iM10579i15 = m10579i();
                                        int iM10579i16 = m10579i();
                                        m10582l(iM10579i14);
                                        m10582l(iM10579i13);
                                        m10582l(iM10579i16);
                                        m10582l(iM10579i15);
                                        m10582l(iM10579i14);
                                        m10582l(iM10579i13);
                                        return;
                                    case 95:
                                        int iM10579i17 = m10579i();
                                        int iM10579i18 = m10579i();
                                        m10582l(iM10579i17);
                                        m10582l(iM10579i18);
                                        return;
                                    case 96:
                                    case 100:
                                    case 104:
                                    case 108:
                                    case 112:
                                    case 120:
                                    case 122:
                                    case 124:
                                    case 126:
                                    case 128:
                                    case 130:
                                    case Opcodes.L2I /* 136 */:
                                    case Opcodes.D2I /* 142 */:
                                    case Opcodes.FCMPL /* 149 */:
                                    case 150:
                                        m10580j(2);
                                        m10582l(16777217);
                                        return;
                                    case 97:
                                    case 101:
                                    case 105:
                                    case 109:
                                    case 113:
                                    case Opcodes.LAND /* 127 */:
                                    case Opcodes.LOR /* 129 */:
                                    case Opcodes.LXOR /* 131 */:
                                        m10580j(4);
                                        m10582l(16777220);
                                        m10582l(16777216);
                                        return;
                                    case 98:
                                    case 102:
                                    case 106:
                                    case 110:
                                    case 114:
                                    case Opcodes.L2F /* 137 */:
                                    case Opcodes.D2F /* 144 */:
                                        m10580j(2);
                                        m10582l(16777218);
                                        return;
                                    case 99:
                                    case 103:
                                    case 107:
                                    case 111:
                                    case 115:
                                        m10580j(4);
                                        m10582l(16777219);
                                        m10582l(16777216);
                                        return;
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case Opcodes.I2B /* 145 */:
                                    case Opcodes.I2C /* 146 */:
                                    case Opcodes.I2S /* 147 */:
                                    case Opcodes.GOTO /* 167 */:
                                    case Opcodes.RETURN /* 177 */:
                                        return;
                                    case 121:
                                    case 123:
                                    case Opcodes.LUSHR /* 125 */:
                                        m10580j(3);
                                        m10582l(16777220);
                                        m10582l(16777216);
                                        return;
                                    case Opcodes.IINC /* 132 */:
                                        m10585o(i2, 16777217);
                                        return;
                                    case Opcodes.I2L /* 133 */:
                                    case Opcodes.F2L /* 140 */:
                                        m10580j(1);
                                        m10582l(16777220);
                                        m10582l(16777216);
                                        return;
                                    case Opcodes.I2F /* 134 */:
                                        m10580j(1);
                                        m10582l(16777218);
                                        return;
                                    case Opcodes.I2D /* 135 */:
                                    case Opcodes.F2D /* 141 */:
                                        m10580j(1);
                                        m10582l(16777219);
                                        m10582l(16777216);
                                        return;
                                    case Opcodes.L2D /* 138 */:
                                        m10580j(2);
                                        m10582l(16777219);
                                        m10582l(16777216);
                                        return;
                                    case Opcodes.F2I /* 139 */:
                                    case Opcodes.ARRAYLENGTH /* 190 */:
                                    case Opcodes.INSTANCEOF /* 193 */:
                                        m10580j(1);
                                        m10582l(16777217);
                                        return;
                                    case Opcodes.D2L /* 143 */:
                                        m10580j(2);
                                        m10582l(16777220);
                                        m10582l(16777216);
                                        return;
                                    case Opcodes.LCMP /* 148 */:
                                    case Opcodes.DCMPL /* 151 */:
                                    case Opcodes.DCMPG /* 152 */:
                                        m10580j(4);
                                        m10582l(16777217);
                                        return;
                                    case Opcodes.JSR /* 168 */:
                                    case Opcodes.RET /* 169 */:
                                        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
                                    case Opcodes.GETSTATIC /* 178 */:
                                        m10583m(c12433v, abstractC12432u.f26344e);
                                        return;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        m10581k(abstractC12432u.f26344e);
                                        return;
                                    case 180:
                                        m10580j(1);
                                        m10583m(c12433v, abstractC12432u.f26344e);
                                        return;
                                    case Opcodes.PUTFIELD /* 181 */:
                                        m10581k(abstractC12432u.f26344e);
                                        m10579i();
                                        return;
                                    case Opcodes.INVOKEVIRTUAL /* 182 */:
                                    case Opcodes.INVOKESPECIAL /* 183 */:
                                    case Opcodes.INVOKESTATIC /* 184 */:
                                    case Opcodes.INVOKEINTERFACE /* 185 */:
                                        m10581k(abstractC12432u.f26344e);
                                        if (i != 184) {
                                            int iM10579i19 = m10579i();
                                            if (i == 183 && abstractC12432u.f26343d.charAt(0) == '<') {
                                                if (this.f26236i == null) {
                                                    this.f26236i = new int[2];
                                                }
                                                int length = this.f26236i.length;
                                                int i8 = this.f26235h;
                                                if (i8 >= length) {
                                                    int[] iArr = new int[Math.max(i8 + 1, length * 2)];
                                                    System.arraycopy(this.f26236i, 0, iArr, 0, length);
                                                    this.f26236i = iArr;
                                                }
                                                int[] iArr2 = this.f26236i;
                                                int i9 = this.f26235h;
                                                this.f26235h = i9 + 1;
                                                iArr2[i9] = iM10579i19;
                                            }
                                        }
                                        m10583m(c12433v, abstractC12432u.f26344e);
                                        return;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        m10581k(abstractC12432u.f26344e);
                                        m10583m(c12433v, abstractC12432u.f26344e);
                                        return;
                                    case Opcodes.NEW /* 187 */:
                                        m10582l(50331648 | c12433v.m10641p(abstractC12432u.f26344e, i2));
                                        return;
                                    case Opcodes.NEWARRAY /* 188 */:
                                        m10579i();
                                        switch (i2) {
                                            case 4:
                                                m10582l(285212681);
                                                return;
                                            case 5:
                                                m10582l(285212683);
                                                return;
                                            case 6:
                                                m10582l(285212674);
                                                return;
                                            case 7:
                                                m10582l(285212675);
                                                return;
                                            case 8:
                                                m10582l(285212682);
                                                return;
                                            case 9:
                                                m10582l(285212684);
                                                return;
                                            case 10:
                                                m10582l(285212673);
                                                return;
                                            case 11:
                                                m10582l(285212676);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                    case Opcodes.ANEWARRAY /* 189 */:
                                        String str = abstractC12432u.f26344e;
                                        m10579i();
                                        if (str.charAt(0) != '[') {
                                            m10582l(c12433v.m10639n(str) | 301989888);
                                            return;
                                        }
                                        m10583m(c12433v, '[' + str);
                                        return;
                                    case Opcodes.CHECKCAST /* 192 */:
                                        String str2 = abstractC12432u.f26344e;
                                        m10579i();
                                        if (str2.charAt(0) == '[') {
                                            m10583m(c12433v, str2);
                                            return;
                                        } else {
                                            m10582l(c12433v.m10639n(str2) | 33554432);
                                            return;
                                        }
                                    default:
                                        switch (i) {
                                            case Opcodes.MULTIANEWARRAY /* 197 */:
                                                m10580j(i2);
                                                m10583m(c12433v, abstractC12432u.f26344e);
                                                return;
                                            case Opcodes.IFNULL /* 198 */:
                                            case Opcodes.IFNONNULL /* 199 */:
                                                break;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                        break;
                                }
                                m10580j(1);
                                return;
                        }
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:23:0x004f A[LOOP:0: B:7:0x000d->B:23:0x004f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0037 A[SYNTHETIC] */
    /* JADX INFO: renamed from: e */
    public final int m10576e(C12433v c12433v, int i) {
        int i2;
        int iM10639n;
        if (i == 16777222 || ((-16777216) & i) == 50331648) {
            for (int i3 = 0; i3 < this.f26235h; i3++) {
                int i4 = this.f26236i[i3];
                int i5 = (-268435456) & i4;
                int i6 = 251658240 & i4;
                int i7 = i4 & 1048575;
                if (i6 == 67108864) {
                    i2 = this.f26229b[i7];
                } else {
                    if (i6 == 83886080) {
                        int[] iArr = this.f26230c;
                        i2 = iArr[iArr.length - i7];
                    }
                    if (i == i4) {
                        if (i == 16777222) {
                            iM10639n = c12433v.m10639n(c12433v.f26350d);
                        } else {
                            iM10639n = c12433v.m10639n(c12433v.f26358l[i & 1048575].f26344e);
                        }
                        return iM10639n | 33554432;
                    }
                }
                i4 = i2 + i5;
                if (i == i4) {
                    if (i == 16777222) {
                        iM10639n = c12433v.m10639n(c12433v.f26350d);
                    } else {
                        iM10639n = c12433v.m10639n(c12433v.f26358l[i & 1048575].f26344e);
                    }
                    return iM10639n | 33554432;
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: f */
    public final int m10577f(int i) {
        int[] iArr = this.f26231d;
        if (iArr == null || i >= iArr.length) {
            return i | 67108864;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = i | 67108864;
        iArr[i] = i3;
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[PHI: r8
      0x0056: PHI (r8v16 int) = (r8v15 int), (r8v15 int), (r8v17 int), (r8v17 int) binds: [B:26:0x0065, B:28:0x0069, B:19:0x004d, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb A[PHI: r6
      0x00fb: PHI (r6v6 int) = (r6v5 int), (r6v5 int), (r6v9 int), (r6v9 int) binds: [B:68:0x010a, B:70:0x010e, B:61:0x00f2, B:63:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: h */
    public final boolean m10578h(C12433v c12433v, C12424m c12424m, int i) {
        boolean zM10574g;
        boolean zM10574g2;
        int i2;
        boolean z2;
        int iM10576e;
        int i3;
        int i4;
        int length = this.f26229b.length;
        int length2 = this.f26230c.length;
        if (c12424m.f26229b == null) {
            c12424m.f26229b = new int[length];
            zM10574g = true;
        } else {
            zM10574g = false;
        }
        int i5 = 0;
        while (i5 < length) {
            int[] iArr = this.f26231d;
            if (iArr == null || i5 >= iArr.length || (i3 = iArr[i5]) == 0) {
                iM10576e = this.f26229b[i5];
            } else {
                int i6 = i3 & (-268435456);
                int i7 = 251658240 & i3;
                if (i7 == 67108864) {
                    i4 = i6 + this.f26229b[i3 & 1048575];
                    if ((i3 & 1048576) == 0 || !(i4 == 16777220 || i4 == 16777219)) {
                        iM10576e = i4;
                    } else {
                        iM10576e = 16777216;
                    }
                } else if (i7 == 83886080) {
                    i4 = i6 + this.f26230c[length2 - (i3 & 1048575)];
                    if ((i3 & 1048576) == 0 || !(i4 == 16777220 || i4 == 16777219)) {
                        iM10576e = i4;
                    } else {
                        iM10576e = 16777216;
                    }
                } else {
                    iM10576e = i3;
                }
            }
            if (this.f26236i != null) {
                iM10576e = m10576e(c12433v, iM10576e);
            }
            zM10574g |= m10574g(c12433v, iM10576e, c12424m.f26229b, i5);
            i5++;
        }
        if (i > 0) {
            for (int i8 = 0; i8 < length; i8++) {
                zM10574g |= m10574g(c12433v, this.f26229b[i8], c12424m.f26229b, i8);
            }
            if (c12424m.f26230c == null) {
                c12424m.f26230c = new int[1];
                z2 = true;
            } else {
                z2 = zM10574g;
            }
            return m10574g(c12433v, i, c12424m.f26230c, 0) | z2;
        }
        int length3 = this.f26230c.length + this.f26233f;
        if (c12424m.f26230c == null) {
            c12424m.f26230c = new int[this.f26234g + length3];
            zM10574g2 = true;
        } else {
            zM10574g2 = zM10574g;
        }
        for (int i9 = 0; i9 < length3; i9++) {
            int iM10576e2 = this.f26230c[i9];
            if (this.f26236i != null) {
                iM10576e2 = m10576e(c12433v, iM10576e2);
            }
            zM10574g2 |= m10574g(c12433v, iM10576e2, c12424m.f26230c, i9);
        }
        for (int i10 = 0; i10 < this.f26234g; i10++) {
            int iM10576e3 = this.f26232e[i10];
            int i11 = iM10576e3 & (-268435456);
            int i12 = iM10576e3 & 251658240;
            if (i12 == 67108864) {
                i2 = i11 + this.f26229b[iM10576e3 & 1048575];
                if ((iM10576e3 & 1048576) == 0 || !(i2 == 16777220 || i2 == 16777219)) {
                    iM10576e3 = i2;
                } else {
                    iM10576e3 = 16777216;
                }
            } else if (i12 == 83886080) {
                i2 = i11 + this.f26230c[length2 - (iM10576e3 & 1048575)];
                if ((iM10576e3 & 1048576) == 0 || !(i2 == 16777220 || i2 == 16777219)) {
                    iM10576e3 = i2;
                } else {
                    iM10576e3 = 16777216;
                }
            }
            if (this.f26236i != null) {
                iM10576e3 = m10576e(c12433v, iM10576e3);
            }
            zM10574g2 |= m10574g(c12433v, iM10576e3, c12424m.f26230c, length3 + i10);
        }
        return zM10574g2;
    }

    /* JADX INFO: renamed from: i */
    public final int m10579i() {
        short s2 = this.f26234g;
        if (s2 <= 0) {
            short s3 = (short) (this.f26233f - 1);
            this.f26233f = s3;
            return 83886080 | (-s3);
        }
        int[] iArr = this.f26232e;
        short s4 = (short) (s2 - 1);
        this.f26234g = s4;
        return iArr[s4];
    }

    /* JADX INFO: renamed from: j */
    public final void m10580j(int i) {
        short s2 = this.f26234g;
        if (s2 >= i) {
            this.f26234g = (short) (s2 - i);
        } else {
            this.f26233f = (short) (this.f26233f - (i - s2));
            this.f26234g = (short) 0;
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m10581k(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            m10580j((C12434w.m10645b(str) >> 2) - 1);
        } else if (cCharAt == 'J' || cCharAt == 'D') {
            m10580j(2);
        } else {
            m10580j(1);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m10582l(int i) {
        if (this.f26232e == null) {
            this.f26232e = new int[10];
        }
        int length = this.f26232e.length;
        short s2 = this.f26234g;
        if (s2 >= length) {
            int[] iArr = new int[Math.max(s2 + 1, length * 2)];
            System.arraycopy(this.f26232e, 0, iArr, 0, length);
            this.f26232e = iArr;
        }
        int[] iArr2 = this.f26232e;
        short s3 = this.f26234g;
        short s4 = (short) (s3 + 1);
        this.f26234g = s4;
        iArr2[s3] = i;
        short s5 = (short) (this.f26233f + s4);
        C12427p c12427p = this.f26228a;
        if (s5 > c12427p.f26256i) {
            c12427p.f26256i = s5;
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m10583m(C12433v c12433v, String str) {
        int iM10573d = m10573d(c12433v, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (iM10573d != 0) {
            m10582l(iM10573d);
            if (iM10573d == 16777220 || iM10573d == 16777219) {
                m10582l(16777216);
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m10584n(C12433v c12433v, int i, String str, int i2) {
        int[] iArr = new int[i2];
        this.f26229b = iArr;
        this.f26230c = new int[0];
        int i3 = 1;
        if ((i & 8) != 0) {
            i3 = 0;
        } else if ((i & 262144) == 0) {
            iArr[0] = 33554432 | c12433v.m10639n(c12433v.f26350d);
        } else {
            iArr[0] = 16777222;
        }
        for (C12434w c12434w : C12434w.m10644a(str)) {
            int iM10573d = m10573d(c12433v, c12434w.m10651d(), 0);
            int[] iArr2 = this.f26229b;
            int i4 = i3 + 1;
            iArr2[i3] = iM10573d;
            if (iM10573d == 16777220 || iM10573d == 16777219) {
                i3 = i4 + 1;
                iArr2[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.f26229b[i3] = 16777216;
            i3++;
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m10585o(int i, int i2) {
        if (this.f26231d == null) {
            this.f26231d = new int[10];
        }
        int length = this.f26231d.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.f26231d, 0, iArr, 0, length);
            this.f26231d = iArr;
        }
        this.f26231d[i] = i2;
    }
}
