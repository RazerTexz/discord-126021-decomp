package h0.a.a;

import androidx.core.view.ViewCompat;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.SymbolTable2;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.m, reason: use source file name */
/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public class Frame3 {
    public Label2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3711b;
    public int[] c;
    public int[] d;
    public int[] e;
    public short f;
    public short g;
    public int h;
    public int[] i;

    public Frame3(Label2 label2) {
        this.a = label2;
    }

    public static int c(SymbolTable2 symbolTable2, Object obj) {
        if (obj instanceof Integer) {
            return 16777216 | ((Integer) obj).intValue();
        }
        return obj instanceof String ? d(symbolTable2, Type2.h((String) obj).d(), 0) : symbolTable2.p("", ((Label2) obj).e) | 50331648;
    }

    public static int d(SymbolTable2 symbolTable2, String str, int i) {
        char cCharAt = str.charAt(i);
        int iN = 16777218;
        if (cCharAt == 'F') {
            return 16777218;
        }
        if (cCharAt == 'L') {
            return symbolTable2.n(str.substring(i + 1, str.length() - 1)) | 33554432;
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
                                iN = symbolTable2.n(str.substring(i2 + 1, str.length() - 1)) | 33554432;
                            } else if (cCharAt2 == 'S') {
                                iN = 16777228;
                            } else if (cCharAt2 == 'Z') {
                                iN = 16777225;
                            } else if (cCharAt2 == 'I') {
                                iN = 16777217;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        iN = 16777226;
                                        break;
                                    case 'C':
                                        iN = 16777227;
                                        break;
                                    case 'D':
                                        iN = 16777219;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                iN = 16777220;
                            }
                        }
                        return ((i2 - i) << 28) | iN;
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

    public static boolean g(SymbolTable2 symbolTable2, int i, int[] iArr, int i2) {
        int iMin;
        int iN;
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
                    iN = symbolTable2.n("java/lang/Object");
                    i7 = iMin | iN;
                }
            } else if ((i5 & 251658240) == 33554432) {
                int i9 = (i4 & (-268435456)) | 33554432;
                int i10 = i4 & 1048575;
                int i11 = 1048575 & i5;
                long j = ((long) i10) | (((long) i11) << 32);
                int iR = SymbolTable2.r(130, i10 + i11);
                SymbolTable2.a aVarQ = symbolTable2.q(iR);
                while (true) {
                    if (aVarQ == null) {
                        SymbolTable2.a[] aVarArr = symbolTable2.l;
                        String str = aVarArr[i10].e;
                        String str2 = aVarArr[i11].e;
                        Objects.requireNonNull(symbolTable2.a);
                        ClassLoader classLoader = ClassWriter2.class.getClassLoader();
                        try {
                            Class<?> cls = Class.forName(str.replace(MentionUtils.SLASH_CHAR, '.'), false, classLoader);
                            try {
                                Class<?> cls2 = Class.forName(str2.replace(MentionUtils.SLASH_CHAR, '.'), false, classLoader);
                                if (cls.isAssignableFrom(cls2)) {
                                    strReplace = str;
                                } else if (cls2.isAssignableFrom(cls)) {
                                    strReplace = str2;
                                } else if (!cls.isInterface() && !cls2.isInterface()) {
                                    do {
                                        cls = cls.getSuperclass();
                                    } while (!cls.isAssignableFrom(cls2));
                                    strReplace = cls.getName().replace('.', MentionUtils.SLASH_CHAR);
                                }
                                int iN2 = symbolTable2.n(strReplace);
                                SymbolTable2.a aVar = new SymbolTable2.a(symbolTable2.k, 130, j, iR);
                                symbolTable2.v(aVar);
                                aVar.g = iN2;
                                i3 = iN2;
                                break;
                            } catch (ClassNotFoundException e) {
                                throw new TypeNotPresentException(str2, e);
                            }
                        } catch (ClassNotFoundException e2) {
                            throw new TypeNotPresentException(str, e2);
                        }
                    }
                    if (aVarQ.f3724b == 130 && aVarQ.h == iR && aVarQ.f == j) {
                        i3 = aVarQ.g;
                        break;
                    }
                    aVarQ = aVarQ.i;
                }
                i7 = i9 | i3;
            } else {
                iMin = ((i4 & (-268435456)) - 268435456) | 33554432;
                iN = symbolTable2.n("java/lang/Object");
                i7 = iMin | iN;
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

    public final void a(MethodWriter2 methodWriter2) {
        int i;
        int[] iArr = this.f3711b;
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
        int[] iArr2 = this.c;
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i7 += (i9 == 16777220 || i9 == 16777219) ? 2 : 1;
            i8++;
        }
        methodWriter2.A(this.a.e, i4, i8);
        int i10 = 3;
        int i11 = 0;
        while (true) {
            int i12 = i4 - 1;
            if (i4 <= 0) {
                break;
            }
            int i13 = iArr[i11];
            i11 += (i13 == 16777220 || i13 == 16777219) ? 2 : 1;
            methodWriter2.W[i10] = i13;
            i4 = i12;
            i10++;
        }
        while (true) {
            int i14 = i8 - 1;
            if (i8 <= 0) {
                methodWriter2.z();
                return;
            }
            int i15 = iArr2[i2];
            i2 += (i15 == 16777220 || i15 == 16777219) ? 2 : 1;
            methodWriter2.W[i10] = i15;
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
    public void b(int i, int i2, Symbol2 symbol2, SymbolTable2 symbolTable2) {
        switch (i) {
            case 0:
                return;
            case 1:
                l(16777221);
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
                l(16777217);
                return;
            case 9:
            case 10:
                l(16777220);
                l(16777216);
                return;
            case 11:
            case 12:
            case 13:
                l(16777218);
                return;
            case 14:
            case 15:
                l(16777219);
                l(16777216);
                return;
            case 18:
                int i3 = symbol2.f3724b;
                switch (i3) {
                    case 3:
                        l(16777217);
                        return;
                    case 4:
                        l(16777218);
                        return;
                    case 5:
                        l(16777220);
                        l(16777216);
                        return;
                    case 6:
                        l(16777219);
                        l(16777216);
                        return;
                    case 7:
                        l(symbolTable2.n("java/lang/Class") | 33554432);
                        return;
                    case 8:
                        l(symbolTable2.n("java/lang/String") | 33554432);
                        return;
                    default:
                        switch (i3) {
                            case 15:
                                l(symbolTable2.n("java/lang/invoke/MethodHandle") | 33554432);
                                return;
                            case 16:
                                l(symbolTable2.n("java/lang/invoke/MethodType") | 33554432);
                                return;
                            case 17:
                                m(symbolTable2, symbol2.e);
                                return;
                            default:
                                throw new AssertionError();
                        }
                }
            default:
                switch (i) {
                    case 21:
                        l(16777217);
                        return;
                    case 22:
                        l(16777220);
                        l(16777216);
                        return;
                    case 23:
                        l(16777218);
                        return;
                    case 24:
                        l(16777219);
                        l(16777216);
                        return;
                    case 25:
                        l(f(i2));
                        return;
                    default:
                        switch (i) {
                            case 46:
                            case 51:
                            case 52:
                            case 53:
                                j(2);
                                l(16777217);
                                return;
                            case 47:
                                j(2);
                                l(16777220);
                                l(16777216);
                                return;
                            case 48:
                                j(2);
                                l(16777218);
                                return;
                            case 49:
                                j(2);
                                l(16777219);
                                l(16777216);
                                return;
                            case 50:
                                j(1);
                                int i4 = i();
                                if (i4 != 16777221) {
                                    i4 -= 268435456;
                                }
                                l(i4);
                                return;
                            case 54:
                            case 56:
                            case 58:
                                o(i2, i());
                                if (i2 > 0) {
                                    int i5 = i2 - 1;
                                    int iF = f(i5);
                                    if (iF == 16777220 || iF == 16777219) {
                                        o(i5, 16777216);
                                        return;
                                    }
                                    int i6 = iF & 251658240;
                                    if (i6 == 67108864 || i6 == 83886080) {
                                        o(i5, iF | 1048576);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 55:
                            case 57:
                                j(1);
                                o(i2, i());
                                o(i2 + 1, 16777216);
                                if (i2 > 0) {
                                    int i7 = i2 - 1;
                                    int iF2 = f(i7);
                                    if (iF2 == 16777220 || iF2 == 16777219) {
                                        o(i7, 16777216);
                                        return;
                                    }
                                    int i8 = iF2 & 251658240;
                                    if (i8 == 67108864 || i8 == 83886080) {
                                        o(i7, iF2 | 1048576);
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
                                        j(3);
                                        return;
                                    case 80:
                                    case 82:
                                        j(4);
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
                                        j(2);
                                        return;
                                    case 89:
                                        int i9 = i();
                                        l(i9);
                                        l(i9);
                                        return;
                                    case 90:
                                        int i10 = i();
                                        int i11 = i();
                                        l(i10);
                                        l(i11);
                                        l(i10);
                                        return;
                                    case 91:
                                        int i12 = i();
                                        int i13 = i();
                                        int i14 = i();
                                        l(i12);
                                        l(i14);
                                        l(i13);
                                        l(i12);
                                        return;
                                    case 92:
                                        int i15 = i();
                                        int i16 = i();
                                        l(i16);
                                        l(i15);
                                        l(i16);
                                        l(i15);
                                        return;
                                    case 93:
                                        int i17 = i();
                                        int i18 = i();
                                        int i19 = i();
                                        l(i18);
                                        l(i17);
                                        l(i19);
                                        l(i18);
                                        l(i17);
                                        return;
                                    case 94:
                                        int i20 = i();
                                        int i21 = i();
                                        int i22 = i();
                                        int i23 = i();
                                        l(i21);
                                        l(i20);
                                        l(i23);
                                        l(i22);
                                        l(i21);
                                        l(i20);
                                        return;
                                    case 95:
                                        int i24 = i();
                                        int i25 = i();
                                        l(i24);
                                        l(i25);
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
                                        j(2);
                                        l(16777217);
                                        return;
                                    case 97:
                                    case 101:
                                    case 105:
                                    case 109:
                                    case 113:
                                    case Opcodes.LAND /* 127 */:
                                    case Opcodes.LOR /* 129 */:
                                    case Opcodes.LXOR /* 131 */:
                                        j(4);
                                        l(16777220);
                                        l(16777216);
                                        return;
                                    case 98:
                                    case 102:
                                    case 106:
                                    case 110:
                                    case 114:
                                    case Opcodes.L2F /* 137 */:
                                    case Opcodes.D2F /* 144 */:
                                        j(2);
                                        l(16777218);
                                        return;
                                    case 99:
                                    case 103:
                                    case 107:
                                    case 111:
                                    case 115:
                                        j(4);
                                        l(16777219);
                                        l(16777216);
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
                                        j(3);
                                        l(16777220);
                                        l(16777216);
                                        return;
                                    case Opcodes.IINC /* 132 */:
                                        o(i2, 16777217);
                                        return;
                                    case Opcodes.I2L /* 133 */:
                                    case Opcodes.F2L /* 140 */:
                                        j(1);
                                        l(16777220);
                                        l(16777216);
                                        return;
                                    case Opcodes.I2F /* 134 */:
                                        j(1);
                                        l(16777218);
                                        return;
                                    case Opcodes.I2D /* 135 */:
                                    case Opcodes.F2D /* 141 */:
                                        j(1);
                                        l(16777219);
                                        l(16777216);
                                        return;
                                    case Opcodes.L2D /* 138 */:
                                        j(2);
                                        l(16777219);
                                        l(16777216);
                                        return;
                                    case Opcodes.F2I /* 139 */:
                                    case Opcodes.ARRAYLENGTH /* 190 */:
                                    case Opcodes.INSTANCEOF /* 193 */:
                                        j(1);
                                        l(16777217);
                                        return;
                                    case Opcodes.D2L /* 143 */:
                                        j(2);
                                        l(16777220);
                                        l(16777216);
                                        return;
                                    case Opcodes.LCMP /* 148 */:
                                    case Opcodes.DCMPL /* 151 */:
                                    case Opcodes.DCMPG /* 152 */:
                                        j(4);
                                        l(16777217);
                                        return;
                                    case Opcodes.JSR /* 168 */:
                                    case Opcodes.RET /* 169 */:
                                        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
                                    case Opcodes.GETSTATIC /* 178 */:
                                        m(symbolTable2, symbol2.e);
                                        return;
                                    case Opcodes.PUTSTATIC /* 179 */:
                                        k(symbol2.e);
                                        return;
                                    case 180:
                                        j(1);
                                        m(symbolTable2, symbol2.e);
                                        return;
                                    case Opcodes.PUTFIELD /* 181 */:
                                        k(symbol2.e);
                                        i();
                                        return;
                                    case Opcodes.INVOKEVIRTUAL /* 182 */:
                                    case Opcodes.INVOKESPECIAL /* 183 */:
                                    case Opcodes.INVOKESTATIC /* 184 */:
                                    case Opcodes.INVOKEINTERFACE /* 185 */:
                                        k(symbol2.e);
                                        if (i != 184) {
                                            int i26 = i();
                                            if (i == 183 && symbol2.d.charAt(0) == '<') {
                                                if (this.i == null) {
                                                    this.i = new int[2];
                                                }
                                                int length = this.i.length;
                                                int i27 = this.h;
                                                if (i27 >= length) {
                                                    int[] iArr = new int[Math.max(i27 + 1, length * 2)];
                                                    System.arraycopy(this.i, 0, iArr, 0, length);
                                                    this.i = iArr;
                                                }
                                                int[] iArr2 = this.i;
                                                int i28 = this.h;
                                                this.h = i28 + 1;
                                                iArr2[i28] = i26;
                                            }
                                        }
                                        m(symbolTable2, symbol2.e);
                                        return;
                                    case Opcodes.INVOKEDYNAMIC /* 186 */:
                                        k(symbol2.e);
                                        m(symbolTable2, symbol2.e);
                                        return;
                                    case Opcodes.NEW /* 187 */:
                                        l(50331648 | symbolTable2.p(symbol2.e, i2));
                                        return;
                                    case Opcodes.NEWARRAY /* 188 */:
                                        i();
                                        switch (i2) {
                                            case 4:
                                                l(285212681);
                                                return;
                                            case 5:
                                                l(285212683);
                                                return;
                                            case 6:
                                                l(285212674);
                                                return;
                                            case 7:
                                                l(285212675);
                                                return;
                                            case 8:
                                                l(285212682);
                                                return;
                                            case 9:
                                                l(285212684);
                                                return;
                                            case 10:
                                                l(285212673);
                                                return;
                                            case 11:
                                                l(285212676);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                    case Opcodes.ANEWARRAY /* 189 */:
                                        String str = symbol2.e;
                                        i();
                                        if (str.charAt(0) != '[') {
                                            l(symbolTable2.n(str) | 301989888);
                                            return;
                                        }
                                        m(symbolTable2, '[' + str);
                                        return;
                                    case Opcodes.CHECKCAST /* 192 */:
                                        String str2 = symbol2.e;
                                        i();
                                        if (str2.charAt(0) == '[') {
                                            m(symbolTable2, str2);
                                            return;
                                        } else {
                                            l(symbolTable2.n(str2) | 33554432);
                                            return;
                                        }
                                    default:
                                        switch (i) {
                                            case Opcodes.MULTIANEWARRAY /* 197 */:
                                                j(i2);
                                                m(symbolTable2, symbol2.e);
                                                return;
                                            case Opcodes.IFNULL /* 198 */:
                                            case Opcodes.IFNONNULL /* 199 */:
                                                break;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                        break;
                                }
                                j(1);
                                return;
                        }
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:23:0x004f A[LOOP:0: B:7:0x000d->B:23:0x004f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0037 A[SYNTHETIC] */
    public final int e(SymbolTable2 symbolTable2, int i) {
        int i2;
        int iN;
        if (i == 16777222 || ((-16777216) & i) == 50331648) {
            for (int i3 = 0; i3 < this.h; i3++) {
                int i4 = this.i[i3];
                int i5 = (-268435456) & i4;
                int i6 = 251658240 & i4;
                int i7 = i4 & 1048575;
                if (i6 == 67108864) {
                    i2 = this.f3711b[i7];
                } else {
                    if (i6 == 83886080) {
                        int[] iArr = this.c;
                        i2 = iArr[iArr.length - i7];
                    }
                    if (i == i4) {
                        if (i == 16777222) {
                            iN = symbolTable2.n(symbolTable2.d);
                        } else {
                            iN = symbolTable2.n(symbolTable2.l[i & 1048575].e);
                        }
                        return iN | 33554432;
                    }
                }
                i4 = i2 + i5;
                if (i == i4) {
                    if (i == 16777222) {
                        iN = symbolTable2.n(symbolTable2.d);
                    } else {
                        iN = symbolTable2.n(symbolTable2.l[i & 1048575].e);
                    }
                    return iN | 33554432;
                }
            }
        }
        return i;
    }

    public final int f(int i) {
        int[] iArr = this.d;
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
    public final boolean h(SymbolTable2 symbolTable2, Frame3 frame3, int i) {
        boolean zG;
        boolean zG2;
        int i2;
        boolean z2;
        int iE;
        int i3;
        int i4;
        int length = this.f3711b.length;
        int length2 = this.c.length;
        if (frame3.f3711b == null) {
            frame3.f3711b = new int[length];
            zG = true;
        } else {
            zG = false;
        }
        int i5 = 0;
        while (i5 < length) {
            int[] iArr = this.d;
            if (iArr == null || i5 >= iArr.length || (i3 = iArr[i5]) == 0) {
                iE = this.f3711b[i5];
            } else {
                int i6 = i3 & (-268435456);
                int i7 = 251658240 & i3;
                if (i7 == 67108864) {
                    i4 = i6 + this.f3711b[i3 & 1048575];
                    if ((i3 & 1048576) == 0 || !(i4 == 16777220 || i4 == 16777219)) {
                        iE = i4;
                    } else {
                        iE = 16777216;
                    }
                } else if (i7 == 83886080) {
                    i4 = i6 + this.c[length2 - (i3 & 1048575)];
                    if ((i3 & 1048576) == 0 || !(i4 == 16777220 || i4 == 16777219)) {
                        iE = i4;
                    } else {
                        iE = 16777216;
                    }
                } else {
                    iE = i3;
                }
            }
            if (this.i != null) {
                iE = e(symbolTable2, iE);
            }
            zG |= g(symbolTable2, iE, frame3.f3711b, i5);
            i5++;
        }
        if (i > 0) {
            for (int i8 = 0; i8 < length; i8++) {
                zG |= g(symbolTable2, this.f3711b[i8], frame3.f3711b, i8);
            }
            if (frame3.c == null) {
                frame3.c = new int[1];
                z2 = true;
            } else {
                z2 = zG;
            }
            return g(symbolTable2, i, frame3.c, 0) | z2;
        }
        int length3 = this.c.length + this.f;
        if (frame3.c == null) {
            frame3.c = new int[this.g + length3];
            zG2 = true;
        } else {
            zG2 = zG;
        }
        for (int i9 = 0; i9 < length3; i9++) {
            int iE2 = this.c[i9];
            if (this.i != null) {
                iE2 = e(symbolTable2, iE2);
            }
            zG2 |= g(symbolTable2, iE2, frame3.c, i9);
        }
        for (int i10 = 0; i10 < this.g; i10++) {
            int iE3 = this.e[i10];
            int i11 = iE3 & (-268435456);
            int i12 = iE3 & 251658240;
            if (i12 == 67108864) {
                i2 = i11 + this.f3711b[iE3 & 1048575];
                if ((iE3 & 1048576) == 0 || !(i2 == 16777220 || i2 == 16777219)) {
                    iE3 = i2;
                } else {
                    iE3 = 16777216;
                }
            } else if (i12 == 83886080) {
                i2 = i11 + this.c[length2 - (iE3 & 1048575)];
                if ((iE3 & 1048576) == 0 || !(i2 == 16777220 || i2 == 16777219)) {
                    iE3 = i2;
                } else {
                    iE3 = 16777216;
                }
            }
            if (this.i != null) {
                iE3 = e(symbolTable2, iE3);
            }
            zG2 |= g(symbolTable2, iE3, frame3.c, length3 + i10);
        }
        return zG2;
    }

    public final int i() {
        short s2 = this.g;
        if (s2 <= 0) {
            short s3 = (short) (this.f - 1);
            this.f = s3;
            return 83886080 | (-s3);
        }
        int[] iArr = this.e;
        short s4 = (short) (s2 - 1);
        this.g = s4;
        return iArr[s4];
    }

    public final void j(int i) {
        short s2 = this.g;
        if (s2 >= i) {
            this.g = (short) (s2 - i);
        } else {
            this.f = (short) (this.f - (i - s2));
            this.g = (short) 0;
        }
    }

    public final void k(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            j((Type2.b(str) >> 2) - 1);
        } else if (cCharAt == 'J' || cCharAt == 'D') {
            j(2);
        } else {
            j(1);
        }
    }

    public final void l(int i) {
        if (this.e == null) {
            this.e = new int[10];
        }
        int length = this.e.length;
        short s2 = this.g;
        if (s2 >= length) {
            int[] iArr = new int[Math.max(s2 + 1, length * 2)];
            System.arraycopy(this.e, 0, iArr, 0, length);
            this.e = iArr;
        }
        int[] iArr2 = this.e;
        short s3 = this.g;
        short s4 = (short) (s3 + 1);
        this.g = s4;
        iArr2[s3] = i;
        short s5 = (short) (this.f + s4);
        Label2 label2 = this.a;
        if (s5 > label2.i) {
            label2.i = s5;
        }
    }

    public final void m(SymbolTable2 symbolTable2, String str) {
        int iD = d(symbolTable2, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (iD != 0) {
            l(iD);
            if (iD == 16777220 || iD == 16777219) {
                l(16777216);
            }
        }
    }

    public final void n(SymbolTable2 symbolTable2, int i, String str, int i2) {
        int[] iArr = new int[i2];
        this.f3711b = iArr;
        this.c = new int[0];
        int i3 = 1;
        if ((i & 8) != 0) {
            i3 = 0;
        } else if ((i & 262144) == 0) {
            iArr[0] = 33554432 | symbolTable2.n(symbolTable2.d);
        } else {
            iArr[0] = 16777222;
        }
        for (Type2 type2 : Type2.a(str)) {
            int iD = d(symbolTable2, type2.d(), 0);
            int[] iArr2 = this.f3711b;
            int i4 = i3 + 1;
            iArr2[i3] = iD;
            if (iD == 16777220 || iD == 16777219) {
                i3 = i4 + 1;
                iArr2[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.f3711b[i3] = 16777216;
            i3++;
        }
    }

    public final void o(int i, int i2) {
        if (this.d == null) {
            this.d = new int[10];
        }
        int length = this.d.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.d, 0, iArr, 0, length);
            this.d = iArr;
        }
        this.d[i] = i2;
    }
}
