package h0.a.a;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import b.d.b.a.outline;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.d, reason: use source file name */
/* JADX INFO: compiled from: ClassReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassReader2 {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3700b;
    public final String[] c;
    public final ConstantDynamic2[] d;
    public final int[] e;
    public final int f;
    public final int g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ClassReader2(byte[] bArr, int i, boolean z2) {
        int i2;
        this.a = bArr;
        if (z2) {
            int i3 = i + 6;
            if (q(i3) > 56) {
                StringBuilder sbU = outline.U("Unsupported class file major version ");
                sbU.append((int) q(i3));
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        int iU = u(i + 8);
        this.f3700b = new int[iU];
        this.c = new String[iU];
        int i4 = i + 10;
        int i5 = 1;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int iU2 = 4;
            if (i5 >= iU) {
                this.f = i6;
                this.g = i4;
                int[] iArr = null;
                this.d = z3 ? new ConstantDynamic2[iU] : null;
                if (z3 | z4) {
                    char[] cArr = new char[i6];
                    int iC = c();
                    for (int iU3 = u(iC - 2); iU3 > 0; iU3--) {
                        String strT = t(iC, cArr);
                        int iL = l(iC + 2);
                        int i7 = iC + 6;
                        if ("BootstrapMethods".equals(strT)) {
                            int iU4 = u(i7);
                            int[] iArr2 = new int[iU4];
                            int iU5 = i7 + 2;
                            for (int i8 = 0; i8 < iU4; i8++) {
                                iArr2[i8] = iU5;
                                iU5 += (u(iU5 + 2) * 2) + 4;
                            }
                            iArr = iArr2;
                        } else {
                            iC = i7 + iL;
                        }
                    }
                }
                this.e = iArr;
                return;
            }
            int i9 = i5 + 1;
            int i10 = i4 + 1;
            this.f3700b[i5] = i10;
            switch (bArr[i4]) {
                case 1:
                    iU2 = u(i10) + 3;
                    if (iU2 > i6) {
                        i6 = iU2;
                    }
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 5:
                case 6:
                    iU2 = 9;
                    i9++;
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i2 = 3;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 15:
                    i2 = iU2;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 17:
                    z3 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                    break;
                case 18:
                    z4 = true;
                    i2 = 5;
                    i4 += i2;
                    i5 = i9;
                    break;
            }
        }
    }

    public final void a(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            if (label2Arr[i] == null) {
                label2Arr[i] = new Label2();
            }
            Label2 label2 = label2Arr[i];
            label2.f3714b = (short) (label2.f3714b | 1);
        }
    }

    public final Label2 b(int i, Label2[] label2Arr) {
        if (label2Arr[i] == null) {
            label2Arr[i] = new Label2();
        }
        Label2 label2 = label2Arr[i];
        label2.f3714b = (short) (label2.f3714b & (-2));
        return label2;
    }

    public final int c() {
        int i = this.g;
        int iU = (u(i + 6) * 2) + i + 8;
        int iU2 = u(iU);
        int iL = iU + 2;
        while (true) {
            int i2 = iU2 - 1;
            if (iU2 <= 0) {
                break;
            }
            int iU3 = u(iL + 6);
            iL += 8;
            while (true) {
                int i3 = iU3 - 1;
                if (iU3 > 0) {
                    iL += l(iL + 2) + 6;
                    iU3 = i3;
                }
            }
            iU2 = i2;
        }
        int iU4 = u(iL);
        int iL2 = iL + 2;
        while (true) {
            int i4 = iU4 - 1;
            if (iU4 <= 0) {
                return iL2 + 2;
            }
            int iU5 = u(iL2 + 6);
            iL2 += 8;
            while (true) {
                int i5 = iU5 - 1;
                if (iU5 > 0) {
                    iL2 += l(iL2 + 2) + 6;
                    iU5 = i5;
                }
            }
            iU4 = i4;
        }
    }

    public final int d(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || f(iArr[i]) < 67) {
            return -1;
        }
        return u(iArr[i] + 1);
    }

    public final Attribute2 e(Attribute2[] attribute2Arr, String str, int i, int i2, char[] cArr, int i3, Label2[] label2Arr) {
        for (Attribute2 attribute2 : attribute2Arr) {
            if (attribute2.a.equals(str)) {
                Attribute2 attribute3 = new Attribute2(attribute2.a);
                byte[] bArr = new byte[i2];
                attribute3.f3697b = bArr;
                System.arraycopy(this.a, i, bArr, 0, i2);
                return attribute3;
            }
        }
        Attribute2 attribute4 = new Attribute2(str);
        byte[] bArr2 = new byte[i2];
        attribute4.f3697b = bArr2;
        System.arraycopy(this.a, i, bArr2, 0, i2);
        return attribute4;
    }

    public int f(int i) {
        return this.a[i] & 255;
    }

    public String g(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    /* JADX WARN: Code duplicated, block: B:151:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:208:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:267:0x066f  */
    /* JADX WARN: Code duplicated, block: B:269:0x0676  */
    /* JADX WARN: Code duplicated, block: B:271:0x0683  */
    /* JADX WARN: Code duplicated, block: B:276:0x0695  */
    /* JADX WARN: Code duplicated, block: B:278:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:280:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:281:0x06be  */
    /* JADX WARN: Code duplicated, block: B:291:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:293:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:294:0x070b  */
    /* JADX WARN: Code duplicated, block: B:296:0x0738  */
    /* JADX WARN: Code duplicated, block: B:302:0x0749  */
    /* JADX WARN: Code duplicated, block: B:304:0x0755  */
    /* JADX WARN: Code duplicated, block: B:306:0x0760  */
    /* JADX WARN: Code duplicated, block: B:307:0x0772  */
    /* JADX WARN: Code duplicated, block: B:309:0x077e  */
    /* JADX WARN: Code duplicated, block: B:311:0x078f  */
    /* JADX WARN: Code duplicated, block: B:313:0x07d2 A[LOOP:17: B:312:0x07d0->B:313:0x07d2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:316:0x080f  */
    /* JADX WARN: Code duplicated, block: B:325:0x082f  */
    /* JADX WARN: Code duplicated, block: B:329:0x0845  */
    /* JADX WARN: Code duplicated, block: B:331:0x086d  */
    /* JADX WARN: Code duplicated, block: B:332:0x0878  */
    /* JADX WARN: Code duplicated, block: B:334:0x0880  */
    /* JADX WARN: Code duplicated, block: B:335:0x0882  */
    /* JADX WARN: Code duplicated, block: B:339:0x0895  */
    /* JADX WARN: Code duplicated, block: B:340:0x0898  */
    /* JADX WARN: Code duplicated, block: B:342:0x089e  */
    /* JADX WARN: Code duplicated, block: B:344:0x08c5 A[LOOP:18: B:343:0x08c3->B:344:0x08c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:347:0x090e A[LOOP:19: B:346:0x090c->B:347:0x090e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:350:0x092f  */
    /* JADX WARN: Code duplicated, block: B:352:0x095e A[LOOP:20: B:351:0x095c->B:352:0x095e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:354:0x0972  */
    /* JADX WARN: Code duplicated, block: B:355:0x098c  */
    /* JADX WARN: Code duplicated, block: B:356:0x09a6  */
    /* JADX WARN: Code duplicated, block: B:357:0x09be  */
    /* JADX WARN: Code duplicated, block: B:359:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:360:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:364:0x0a17  */
    /* JADX WARN: Code duplicated, block: B:365:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:366:0x0a4b  */
    /* JADX WARN: Code duplicated, block: B:368:0x0a63  */
    /* JADX WARN: Code duplicated, block: B:371:0x0a80  */
    /* JADX WARN: Code duplicated, block: B:375:0x0a87  */
    /* JADX WARN: Code duplicated, block: B:379:0x0ab0  */
    /* JADX WARN: Code duplicated, block: B:383:0x0ab7  */
    /* JADX WARN: Code duplicated, block: B:384:0x0ad9  */
    /* JADX WARN: Code duplicated, block: B:494:0x068f A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:138:0x036d. Please report as an issue. */
    public final void h(MethodVisitor2 methodVisitor2, Context3 context3, int i) {
        Label2[] label2Arr;
        int i2;
        int i3;
        int[] iArr;
        String strT;
        int i4;
        int[] iArr2;
        int[] iArr3;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        boolean z3;
        int i11;
        int i12;
        Label2[] label2Arr2;
        int i13;
        int iL;
        int[] iArr4;
        Label2[] label2Arr3;
        int i14;
        int i15;
        MethodWriter2 methodWriter2;
        boolean z4;
        int i16;
        int i17;
        String strG;
        String strT2;
        String strT3;
        boolean z5;
        int iU;
        Object[] objArr;
        int i18;
        int i19;
        MethodWriter2 methodWriter3;
        Symbol2 symbol2D;
        Label2 label2;
        int i20;
        int i21;
        int i22;
        MethodWriter2 methodWriter4;
        Symbol2 symbol2M;
        Label2 label3;
        int i23;
        boolean z6;
        int i24;
        Label2 label4;
        int i25;
        int iD;
        int i26;
        int i27;
        int i28;
        int i29;
        Label2[] label2Arr4;
        int i30;
        int iU2;
        int iX;
        short s2;
        int i31;
        int iU3;
        int i32;
        int i33;
        int[] iArr5;
        Label2[] label2Arr5;
        int i34;
        Label2[] label2Arr6;
        int i35;
        int[] iArrS;
        int i36;
        byte[] bArr = this.a;
        char[] cArr = context3.c;
        int iU4 = u(i);
        int iU5 = u(i + 2);
        int iL2 = l(i + 4);
        int i37 = i + 8;
        int i38 = i37 + iL2;
        Label2[] label2Arr7 = new Label2[iL2 + 1];
        context3.g = label2Arr7;
        int i39 = i37;
        while (i39 < i38) {
            int i40 = i39 - i37;
            switch (bArr[i39] & 255) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case Opcodes.LUSHR /* 125 */:
                case 126:
                case Opcodes.LAND /* 127 */:
                case 128:
                case Opcodes.LOR /* 129 */:
                case 130:
                case Opcodes.LXOR /* 131 */:
                case Opcodes.I2L /* 133 */:
                case Opcodes.I2F /* 134 */:
                case Opcodes.I2D /* 135 */:
                case Opcodes.L2I /* 136 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.L2D /* 138 */:
                case Opcodes.F2I /* 139 */:
                case Opcodes.F2L /* 140 */:
                case Opcodes.F2D /* 141 */:
                case Opcodes.D2I /* 142 */:
                case Opcodes.D2L /* 143 */:
                case Opcodes.D2F /* 144 */:
                case Opcodes.I2B /* 145 */:
                case Opcodes.I2C /* 146 */:
                case Opcodes.I2S /* 147 */:
                case Opcodes.LCMP /* 148 */:
                case Opcodes.FCMPL /* 149 */:
                case 150:
                case Opcodes.DCMPL /* 151 */:
                case Opcodes.DCMPG /* 152 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.LRETURN /* 173 */:
                case Opcodes.FRETURN /* 174 */:
                case 175:
                case Opcodes.ARETURN /* 176 */:
                case Opcodes.RETURN /* 177 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.ATHROW /* 191 */:
                case Opcodes.MONITORENTER /* 194 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    i39++;
                    break;
                case 16:
                case 18:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case Opcodes.RET /* 169 */:
                case Opcodes.NEWARRAY /* 188 */:
                    i39 += 2;
                    break;
                case 17:
                case 19:
                case 20:
                case Opcodes.IINC /* 132 */:
                case Opcodes.GETSTATIC /* 178 */:
                case Opcodes.PUTSTATIC /* 179 */:
                case 180:
                case Opcodes.PUTFIELD /* 181 */:
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                case Opcodes.INVOKESPECIAL /* 183 */:
                case Opcodes.INVOKESTATIC /* 184 */:
                case Opcodes.NEW /* 187 */:
                case Opcodes.ANEWARRAY /* 189 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    i39 += 3;
                    break;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Opcodes.IF_ICMPEQ /* 159 */:
                case Opcodes.IF_ICMPNE /* 160 */:
                case Opcodes.IF_ICMPLT /* 161 */:
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.IF_ICMPGT /* 163 */:
                case Opcodes.IF_ICMPLE /* 164 */:
                case Opcodes.IF_ACMPEQ /* 165 */:
                case Opcodes.IF_ACMPNE /* 166 */:
                case Opcodes.GOTO /* 167 */:
                case Opcodes.JSR /* 168 */:
                case Opcodes.IFNULL /* 198 */:
                case Opcodes.IFNONNULL /* 199 */:
                    b(q(i39 + 1) + i40, label2Arr7);
                    i39 += 3;
                    break;
                case Opcodes.TABLESWITCH /* 170 */:
                    int i41 = (4 - (i40 & 3)) + i39;
                    b(l(i41) + i40, label2Arr7);
                    int iL3 = (l(i41 + 8) - l(i41 + 4)) + 1;
                    i36 = i41 + 12;
                    while (true) {
                        int i42 = iL3 - 1;
                        if (iL3 <= 0) {
                            i39 = i36;
                        } else {
                            b(l(i36) + i40, label2Arr7);
                            i36 += 4;
                            iL3 = i42;
                        }
                        break;
                    }
                    break;
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    int i43 = (4 - (i40 & 3)) + i39;
                    b(l(i43) + i40, label2Arr7);
                    int iL4 = l(i43 + 4);
                    i36 = i43 + 8;
                    while (true) {
                        int i44 = iL4 - 1;
                        if (iL4 <= 0) {
                            i39 = i36;
                        } else {
                            b(l(i36 + 4) + i40, label2Arr7);
                            i36 += 8;
                            iL4 = i44;
                        }
                        break;
                    }
                    break;
                case Opcodes.INVOKEINTERFACE /* 185 */:
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    i39 += 5;
                    break;
                case 196:
                    int i45 = bArr[i39 + 1] & 255;
                    if (i45 != 132) {
                        if (i45 != 169) {
                            switch (i45) {
                                default:
                                    switch (i45) {
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            throw new IllegalArgumentException();
                                    }
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    i39 += 4;
                                    break;
                            }
                        }
                        i39 += 4;
                    } else {
                        i39 += 6;
                    }
                    break;
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    i39 += 4;
                    break;
                case 200:
                case 201:
                case 220:
                    b(l(i39 + 1) + i40, label2Arr7);
                    i39 += 5;
                    break;
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                    b(u(i39 + 1) + i40, label2Arr7);
                    i39 += 3;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iU6 = u(i39);
        int i46 = i39 + 2;
        while (true) {
            int i47 = iU6 - 1;
            if (iU6 > 0) {
                Label2 label2B = b(u(i46), label2Arr7);
                Label2 label2B2 = b(u(i46 + 2), label2Arr7);
                Label2 label2B3 = b(u(i46 + 4), label2Arr7);
                String strT4 = t(this.f3700b[u(i46 + 6)], cArr);
                i46 += 8;
                MethodWriter2 methodWriter5 = (MethodWriter2) methodVisitor2;
                Handler5 handler5 = new Handler5(label2B, label2B2, label2B3, strT4 != null ? methodWriter5.d.m(7, strT4).a : 0, strT4);
                if (methodWriter5.m == null) {
                    methodWriter5.m = handler5;
                } else {
                    methodWriter5.n.f = handler5;
                }
                methodWriter5.n = handler5;
                iU6 = i47;
                i38 = i38;
            } else {
                int i48 = i38;
                int iU7 = u(i46);
                int i49 = i46 + 2;
                int[] iArr6 = null;
                boolean z7 = true;
                int i50 = 0;
                Attribute2 attribute2 = null;
                int i51 = 0;
                int[] iArrS2 = null;
                int i52 = 0;
                int i53 = 0;
                while (true) {
                    int i54 = iU7 - 1;
                    if (iU7 > 0) {
                        String strT5 = t(i49, cArr);
                        int iL5 = l(i49 + 2);
                        int i55 = i49 + 6;
                        if ("LocalVariableTable".equals(strT5)) {
                            if ((context3.f3707b & 2) == 0) {
                                int iU8 = u(i55);
                                int i56 = i55 + 2;
                                while (true) {
                                    int i57 = iU8 - 1;
                                    if (iU8 > 0) {
                                        int iU9 = u(i56);
                                        a(iU9, label2Arr7);
                                        a(u(i56 + 2) + iU9, label2Arr7);
                                        i56 += 10;
                                        iU8 = i57;
                                    } else {
                                        i52 = i55;
                                        iArrS = iArr6;
                                        label2Arr5 = label2Arr7;
                                        i34 = iL2;
                                        iArr6 = iArrS;
                                        label2Arr6 = label2Arr5;
                                        i35 = i34;
                                    }
                                }
                            }
                            iArr5 = iArr6;
                            label2Arr5 = label2Arr7;
                            i34 = iL2;
                            iArrS = iArr5;
                            iArr6 = iArrS;
                            label2Arr6 = label2Arr5;
                            i35 = i34;
                        } else if ("LocalVariableTypeTable".equals(strT5)) {
                            i53 = i55;
                            iArrS = iArr6;
                            label2Arr5 = label2Arr7;
                            i34 = iL2;
                            iArr6 = iArrS;
                            label2Arr6 = label2Arr5;
                            i35 = i34;
                        } else if ("LineNumberTable".equals(strT5)) {
                            if ((context3.f3707b & 2) == 0) {
                                int iU10 = u(i55);
                                int i58 = i55 + 2;
                                while (true) {
                                    int i59 = iU10 - 1;
                                    if (iU10 > 0) {
                                        int iU11 = u(i58);
                                        int iU12 = u(i58 + 2);
                                        int i60 = i58 + 4;
                                        a(iU11, label2Arr7);
                                        Label2 label5 = label2Arr7[iU11];
                                        if (label5.c == 0) {
                                            label5.c = (short) iU12;
                                            i60 = i60;
                                            label2Arr7 = label2Arr7;
                                            iL2 = iL2;
                                        } else {
                                            if (label5.d == null) {
                                                label5.d = new int[4];
                                            }
                                            int[] iArr7 = label5.d;
                                            int i61 = iArr7[0] + 1;
                                            iArr7[0] = i61;
                                            if (i61 >= iArr7.length) {
                                                int[] iArr8 = new int[iArr7.length + 4];
                                                System.arraycopy(iArr7, 0, iArr8, 0, iArr7.length);
                                                label5.d = iArr8;
                                            }
                                            label5.d[i61] = iU12;
                                        }
                                        iU10 = i59;
                                        i58 = i60;
                                        iArr6 = iArr6;
                                        label2Arr7 = label2Arr7;
                                        iL2 = iL2;
                                    }
                                }
                            }
                            iArr5 = iArr6;
                            label2Arr5 = label2Arr7;
                            i34 = iL2;
                            iArrS = iArr5;
                            iArr6 = iArrS;
                            label2Arr6 = label2Arr5;
                            i35 = i34;
                        } else {
                            iArr5 = iArr6;
                            label2Arr5 = label2Arr7;
                            i34 = iL2;
                            if ("RuntimeVisibleTypeAnnotations".equals(strT5)) {
                                iArrS = s(methodVisitor2, context3, i55, true);
                                iArr6 = iArrS;
                                label2Arr6 = label2Arr5;
                                i35 = i34;
                            } else if ("RuntimeInvisibleTypeAnnotations".equals(strT5)) {
                                iArrS2 = s(methodVisitor2, context3, i55, false);
                                iArrS = iArr5;
                                iArr6 = iArrS;
                                label2Arr6 = label2Arr5;
                                i35 = i34;
                            } else {
                                if ("StackMapTable".equals(strT5)) {
                                    if ((context3.f3707b & 4) == 0) {
                                        i50 = i55 + 2;
                                        i51 = i55 + iL5;
                                    }
                                } else if (!"StackMap".equals(strT5)) {
                                    label2Arr6 = label2Arr5;
                                    i35 = i34;
                                    Attribute2 attribute2E = e(context3.a, strT5, i55, iL5, cArr, i, label2Arr6);
                                    attribute2E.c = attribute2;
                                    attribute2 = attribute2E;
                                    iArr6 = iArr5;
                                } else if ((context3.f3707b & 4) == 0) {
                                    i50 = i55 + 2;
                                    i51 = i55 + iL5;
                                    iArr6 = iArr5;
                                    label2Arr6 = label2Arr5;
                                    i35 = i34;
                                    z7 = false;
                                }
                                iArrS = iArr5;
                                iArr6 = iArrS;
                                label2Arr6 = label2Arr5;
                                i35 = i34;
                            }
                        }
                        i49 = i55 + iL5;
                        label2Arr7 = label2Arr6;
                        iU7 = i54;
                        i48 = i48;
                        iL2 = i35;
                    } else {
                        int[] iArr9 = iArr6;
                        Label2[] label2Arr8 = label2Arr7;
                        int i62 = iL2;
                        int i63 = i48;
                        Attribute2 attribute3 = attribute2;
                        boolean z8 = (context3.f3707b & 8) != 0;
                        if (i50 != 0) {
                            context3.m = -1;
                            context3.n = 0;
                            context3.o = 0;
                            context3.p = 0;
                            Object[] objArr2 = new Object[iU5];
                            context3.q = objArr2;
                            context3.r = 0;
                            context3.f3708s = new Object[iU4];
                            if (z8) {
                                String str = context3.f;
                                if ((context3.d & 8) == 0) {
                                    if ("<init>".equals(context3.e)) {
                                        objArr2[0] = Opcodes2.g;
                                    } else {
                                        objArr2[0] = g(this.g + 2, context3.c);
                                    }
                                    i32 = 1;
                                } else {
                                    i32 = 0;
                                }
                                int i64 = i32;
                                int i65 = 1;
                                while (true) {
                                    int i66 = i65 + 1;
                                    char cCharAt = str.charAt(i65);
                                    if (cCharAt == 'F') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = Opcodes2.c;
                                    } else if (cCharAt == 'L') {
                                        int i67 = i66;
                                        while (str.charAt(i67) != ';') {
                                            i67++;
                                        }
                                        objArr2[i64] = str.substring(i66, i67);
                                        i64++;
                                        i65 = i67 + 1;
                                    } else if (cCharAt == 'S' || cCharAt == 'I') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = Opcodes2.f3723b;
                                    } else if (cCharAt == 'J') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = Opcodes2.e;
                                    } else if (cCharAt == 'Z') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = Opcodes2.f3723b;
                                    } else if (cCharAt != '[') {
                                        switch (cCharAt) {
                                            case 'B':
                                            case 'C':
                                                i33 = i64 + 1;
                                                objArr2[i64] = Opcodes2.f3723b;
                                                break;
                                            case 'D':
                                                i33 = i64 + 1;
                                                objArr2[i64] = Opcodes2.d;
                                                break;
                                        }
                                        context3.o = i64;
                                    } else {
                                        while (str.charAt(i66) == '[') {
                                            i66++;
                                        }
                                        if (str.charAt(i66) == 'L') {
                                            do {
                                                i66++;
                                            } while (str.charAt(i66) != ';');
                                        }
                                        int i68 = i66 + 1;
                                        objArr2[i64] = str.substring(i65, i68);
                                        i65 = i68;
                                        i64++;
                                    }
                                    i64 = i33;
                                    i65 = i66;
                                }
                            }
                            int i69 = i50;
                            while (true) {
                                i2 = i51;
                                if (i69 < i2 - 2) {
                                    if (bArr[i69] != 8 || (iU3 = u(i69 + 1)) < 0) {
                                        i31 = i62;
                                    } else {
                                        i31 = i62;
                                        if (iU3 < i31) {
                                            if ((bArr[i37 + iU3] & 255) == 187) {
                                                label2Arr8 = label2Arr8;
                                                b(iU3, label2Arr8);
                                            } else {
                                                label2Arr8 = label2Arr8;
                                            }
                                        }
                                        i69++;
                                        label2Arr8 = label2Arr8;
                                        i62 = i31;
                                        i51 = i2;
                                    }
                                    i69++;
                                    label2Arr8 = label2Arr8;
                                    i62 = i31;
                                    i51 = i2;
                                } else {
                                    label2Arr = label2Arr8;
                                }
                            }
                        } else {
                            label2Arr = label2Arr8;
                            i2 = i51;
                        }
                        int i70 = i62;
                        if (!z8 || (context3.f3707b & 256) == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            methodVisitor2.c(-1, iU5, null, 0, null);
                        }
                        int[] iArr10 = iArr9;
                        int iD2 = d(iArr10, i3);
                        int[] iArr11 = iArrS2;
                        int iD3 = d(iArr11, i3);
                        int i71 = (context3.f3707b & 256) == 0 ? 33 : 0;
                        int i72 = iD3;
                        int i73 = i37;
                        int i74 = i50;
                        int i75 = 0;
                        int i76 = 0;
                        int iD4 = iD2;
                        boolean z9 = false;
                        while (true) {
                            int i77 = i63;
                            if (i73 >= i77) {
                                int[] iArr12 = iArr10;
                                int i78 = iU4;
                                int i79 = iU5;
                                Label2[] label2Arr9 = label2Arr;
                                int[] iArr13 = iArr11;
                                if (label2Arr9[i70] != null) {
                                    methodVisitor2.i(label2Arr9[i70]);
                                }
                                int i80 = i52;
                                if (i80 != 0 && (context3.f3707b & 2) == 0) {
                                    int i81 = i53;
                                    if (i81 != 0) {
                                        int iU13 = u(i81) * 3;
                                        int[] iArr14 = new int[iU13];
                                        int i82 = i81 + 2;
                                        while (iU13 > 0) {
                                            int i83 = iU13 - 1;
                                            iArr14[i83] = i82 + 6;
                                            int i84 = i83 - 1;
                                            iArr14[i84] = u(i82 + 8);
                                            iU13 = i84 - 1;
                                            iArr14[iU13] = u(i82);
                                            i82 += 10;
                                        }
                                        iArr = iArr14;
                                    } else {
                                        iArr = null;
                                    }
                                    int iU14 = u(i80);
                                    int i85 = i80 + 2;
                                    while (true) {
                                        int i86 = iU14 - 1;
                                        if (iU14 > 0) {
                                            int iU15 = u(i85);
                                            int iU16 = u(i85 + 2);
                                            String strT6 = t(i85 + 4, cArr);
                                            String strT7 = t(i85 + 6, cArr);
                                            int iU17 = u(i85 + 8);
                                            int i87 = i85 + 10;
                                            if (iArr == null) {
                                                strT = null;
                                                break;
                                                break;
                                            }
                                            int i88 = 0;
                                            while (true) {
                                                if (i88 >= iArr.length) {
                                                    strT = null;
                                                    break;
                                                } else {
                                                    if (iArr[i88] == iU15 && iArr[i88 + 1] == iU17) {
                                                        strT = t(iArr[i88 + 2], cArr);
                                                        break;
                                                    }
                                                    i88 += 3;
                                                }
                                            }
                                            methodVisitor2.l(strT6, strT7, strT, label2Arr9[iU15], label2Arr9[iU15 + iU16], iU17);
                                            iU14 = i86;
                                            i85 = i87;
                                        }
                                    }
                                }
                                int i89 = 65;
                                if (iArr12 != null) {
                                    int length = iArr12.length;
                                    int i90 = 0;
                                    while (i90 < length) {
                                        int i91 = iArr12[i90];
                                        int iF = f(i91);
                                        if (iF == 64 || iF == i89) {
                                            int iR = r(context3, i91);
                                            k(methodVisitor2.m(context3.h, context3.i, context3.j, context3.k, context3.l, t(iR, cArr), true), iR + 2, true, cArr);
                                        }
                                        i90++;
                                        attribute3 = attribute3;
                                        i89 = 65;
                                    }
                                }
                                Attribute2 attribute4 = attribute3;
                                if (iArr13 != null) {
                                    for (int i92 : iArr13) {
                                        int iF2 = f(i92);
                                        if (iF2 == 64 || iF2 == 65) {
                                            int iR2 = r(context3, i92);
                                            k(methodVisitor2.m(context3.h, context3.i, context3.j, context3.k, context3.l, t(iR2, cArr), false), iR2 + 2, true, cArr);
                                        }
                                    }
                                }
                                Attribute2 attribute5 = attribute4;
                                while (attribute5 != null) {
                                    Attribute2 attribute6 = attribute5.c;
                                    attribute5.c = null;
                                    MethodWriter2 methodWriter6 = (MethodWriter2) methodVisitor2;
                                    attribute5.c = methodWriter6.M;
                                    methodWriter6.M = attribute5;
                                    attribute5 = attribute6;
                                }
                                methodVisitor2.n(i78, i79);
                                return;
                            }
                            i63 = i77;
                            int i93 = i73 - i37;
                            int i94 = iU4;
                            Label2[] label2Arr10 = label2Arr;
                            Label2 label6 = label2Arr10[i93];
                            boolean z10 = z9;
                            if (label6 == null) {
                                i4 = i73;
                            } else {
                                boolean z11 = (context3.f3707b & 2) == 0;
                                methodVisitor2.i(label6);
                                if (!z11 || (s2 = label6.c) == 0) {
                                    i4 = i73;
                                } else {
                                    methodVisitor2.k(s2 & 65535, label6);
                                    if (label6.d != null) {
                                        int i95 = 1;
                                        while (true) {
                                            int[] iArr15 = label6.d;
                                            i4 = i73;
                                            if (i95 <= iArr15[0]) {
                                                methodVisitor2.k(iArr15[i95], label6);
                                                i95++;
                                                i73 = i4;
                                            }
                                        }
                                    } else {
                                        i4 = i73;
                                    }
                                }
                            }
                            boolean z12 = z10;
                            int i96 = i74;
                            while (i96 != 0) {
                                int i97 = context3.m;
                                if (i97 == i93 || i97 == -1) {
                                    if (i97 != -1) {
                                        if (!z7 || z8) {
                                            iArr11 = iArr11;
                                            iArr10 = iArr10;
                                            i26 = i96;
                                            methodVisitor2.c(-1, context3.o, context3.q, context3.r, context3.f3708s);
                                        } else {
                                            i26 = i96;
                                            iArr11 = iArr11;
                                            iArr10 = iArr10;
                                            methodVisitor2.c(context3.n, context3.p, context3.q, context3.r, context3.f3708s);
                                        }
                                        z12 = false;
                                    } else {
                                        iArr11 = iArr11;
                                        iArr10 = iArr10;
                                        iU5 = iU5;
                                        i4 = i4;
                                        i26 = i96;
                                        z12 = z12;
                                    }
                                    if (i26 < i2) {
                                        char[] cArr2 = context3.c;
                                        Label2[] label2Arr11 = context3.g;
                                        if (z7) {
                                            i27 = i26 + 1;
                                            i29 = this.a[i26] & 255;
                                            i28 = 0;
                                        } else {
                                            context3.m = -1;
                                            i27 = i26;
                                            i28 = 0;
                                            i29 = 255;
                                        }
                                        context3.p = i28;
                                        if (i29 < 64) {
                                            context3.n = 3;
                                            context3.r = i28;
                                            iX = i27;
                                            label2Arr4 = label2Arr11;
                                            i30 = i2;
                                        } else {
                                            if (i29 < 128) {
                                                iU2 = i29 - 64;
                                                i30 = i2;
                                                label2Arr4 = label2Arr11;
                                                iX = x(i27, context3.f3708s, 0, cArr2, label2Arr4);
                                                context3.n = 4;
                                                context3.r = 1;
                                            } else {
                                                label2Arr4 = label2Arr11;
                                                i30 = i2;
                                                if (i29 < 247) {
                                                    throw new IllegalArgumentException();
                                                }
                                                iU2 = u(i27);
                                                int iX2 = i27 + 2;
                                                if (i29 == 247) {
                                                    iX = x(iX2, context3.f3708s, 0, cArr2, label2Arr4);
                                                    context3.n = 4;
                                                    context3.r = 1;
                                                } else {
                                                    if (i29 >= 248 && i29 < 251) {
                                                        context3.n = 2;
                                                        int i98 = 251 - i29;
                                                        context3.p = i98;
                                                        context3.o -= i98;
                                                        context3.r = 0;
                                                    } else if (i29 == 251) {
                                                        context3.n = 3;
                                                        context3.r = 0;
                                                    } else if (i29 < 255) {
                                                        int i99 = i29 - 251;
                                                        int i100 = z8 ? context3.o : 0;
                                                        int i101 = i99;
                                                        while (i101 > 0) {
                                                            iX2 = x(iX2, context3.q, i100, cArr2, label2Arr4);
                                                            i101--;
                                                            i99 = i99;
                                                            i100++;
                                                            cArr2 = cArr2;
                                                        }
                                                        int i102 = i99;
                                                        context3.n = 1;
                                                        context3.p = i102;
                                                        context3.o += i102;
                                                        context3.r = 0;
                                                    } else {
                                                        int iU18 = u(iX2);
                                                        int iX3 = iX2 + 2;
                                                        context3.n = 0;
                                                        context3.p = iU18;
                                                        context3.o = iU18;
                                                        for (int i103 = 0; i103 < iU18; i103++) {
                                                            iX3 = x(iX3, context3.q, i103, cArr2, label2Arr4);
                                                        }
                                                        int iU19 = u(iX3);
                                                        iX2 = iX3 + 2;
                                                        context3.r = iU19;
                                                        for (int i104 = 0; i104 < iU19; i104++) {
                                                            iX2 = x(iX2, context3.f3708s, i104, cArr2, label2Arr4);
                                                        }
                                                    }
                                                    iX = iX2;
                                                }
                                            }
                                            i29 = iU2;
                                        }
                                        int i105 = i29 + 1 + context3.m;
                                        context3.m = i105;
                                        b(i105, label2Arr4);
                                        i96 = iX;
                                        i2 = i30;
                                    } else {
                                        i96 = 0;
                                    }
                                } else {
                                    iArr2 = iArr11;
                                    iArr3 = iArr10;
                                    i5 = i2;
                                    i6 = iU5;
                                    i7 = i4;
                                    i8 = i96;
                                    if (z12) {
                                        if ((context3.f3707b & 8) != 0) {
                                            methodVisitor2.c(256, 0, null, 0, null);
                                        }
                                        z2 = false;
                                    } else {
                                        z2 = z12;
                                    }
                                    i9 = bArr[i7] & 255;
                                    switch (i9) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case 96:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case 123:
                                        case 124:
                                        case Opcodes.LUSHR /* 125 */:
                                        case 126:
                                        case Opcodes.LAND /* 127 */:
                                        case 128:
                                        case Opcodes.LOR /* 129 */:
                                        case 130:
                                        case Opcodes.LXOR /* 131 */:
                                        case Opcodes.I2L /* 133 */:
                                        case Opcodes.I2F /* 134 */:
                                        case Opcodes.I2D /* 135 */:
                                        case Opcodes.L2I /* 136 */:
                                        case Opcodes.L2F /* 137 */:
                                        case Opcodes.L2D /* 138 */:
                                        case Opcodes.F2I /* 139 */:
                                        case Opcodes.F2L /* 140 */:
                                        case Opcodes.F2D /* 141 */:
                                        case Opcodes.D2I /* 142 */:
                                        case Opcodes.D2L /* 143 */:
                                        case Opcodes.D2F /* 144 */:
                                        case Opcodes.I2B /* 145 */:
                                        case Opcodes.I2C /* 146 */:
                                        case Opcodes.I2S /* 147 */:
                                        case Opcodes.LCMP /* 148 */:
                                        case Opcodes.FCMPL /* 149 */:
                                        case 150:
                                        case Opcodes.DCMPL /* 151 */:
                                        case Opcodes.DCMPG /* 152 */:
                                        case Opcodes.IRETURN /* 172 */:
                                        case Opcodes.LRETURN /* 173 */:
                                        case Opcodes.FRETURN /* 174 */:
                                        case 175:
                                        case Opcodes.ARETURN /* 176 */:
                                        case Opcodes.RETURN /* 177 */:
                                        case Opcodes.ARRAYLENGTH /* 190 */:
                                        case Opcodes.ATHROW /* 191 */:
                                        case Opcodes.MONITORENTER /* 194 */:
                                        case Opcodes.MONITOREXIT /* 195 */:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            methodVisitor2.e(i9);
                                            i10 = i7 + 1;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null && i75 < iArr3.length && iD4 <= i93) {
                                                if (iD4 == i93) {
                                                    int iR3 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR3, cArr), true), iR3 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null && i25 < iArr2.length && iD <= i93) {
                                                if (iD == i93) {
                                                    int iR4 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR4, cArr), false), iR4 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 16:
                                        case Opcodes.NEWARRAY /* 188 */:
                                            methodVisitor2.g(i9, bArr[i7 + 1]);
                                            i10 = i7 + 2;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR5 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR5, cArr), true), iR5 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR6 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR6, cArr), false), iR6 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 17:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            methodVisitor2.g(i9, q(i7 + 1));
                                            i10 = i7 + 3;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR7 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR7, cArr), true), iR7 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR8 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR8, cArr), false), iR8 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 18:
                                            methodVisitor2.j(i(bArr[i7 + 1] & 255, cArr));
                                            i10 = i7 + 2;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR9 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR9, cArr), true), iR9 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR10 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR10, cArr), false), iR10 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 19:
                                        case 20:
                                            methodVisitor2.j(i(u(i7 + 1), cArr));
                                            i10 = i7 + 3;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR11 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR11, cArr), true), iR11 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR12 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR12, cArr), false), iR12 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case Opcodes.RET /* 169 */:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            methodVisitor2.t(i9, bArr[i7 + 1] & 255);
                                            i10 = i7 + 2;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR13 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR13, cArr), true), iR13 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR14 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR14, cArr), false), iR14 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                            int i106 = i9 - 26;
                                            methodVisitor2.t((i106 >> 2) + 21, 3 & i106);
                                            i10 = i7 + 1;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR15 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR15, cArr), true), iR15 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR16 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR16, cArr), false), iR16 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                            int i107 = i9 - 59;
                                            methodVisitor2.t((i107 >> 2) + 54, 3 & i107);
                                            i10 = i7 + 1;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR17 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR17, cArr), true), iR17 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR18 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR18, cArr), false), iR18 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.IINC /* 132 */:
                                            methodVisitor2.d(bArr[i7 + 1] & 255, bArr[i7 + 2]);
                                            i10 = i7 + 3;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR19 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR19, cArr), true), iR19 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR110 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR110, cArr), false), iR110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case Opcodes.IF_ICMPEQ /* 159 */:
                                        case Opcodes.IF_ICMPNE /* 160 */:
                                        case Opcodes.IF_ICMPLT /* 161 */:
                                        case Opcodes.IF_ICMPGE /* 162 */:
                                        case Opcodes.IF_ICMPGT /* 163 */:
                                        case Opcodes.IF_ICMPLE /* 164 */:
                                        case Opcodes.IF_ACMPEQ /* 165 */:
                                        case Opcodes.IF_ACMPNE /* 166 */:
                                        case Opcodes.GOTO /* 167 */:
                                        case Opcodes.JSR /* 168 */:
                                        case Opcodes.IFNULL /* 198 */:
                                        case Opcodes.IFNONNULL /* 199 */:
                                            methodVisitor2.h(i9, label2Arr10[q(i7 + 1) + i93]);
                                            i10 = i7 + 3;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR111 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR111, cArr), true), iR111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR112 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR112, cArr), false), iR112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.TABLESWITCH /* 170 */:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            int i108 = (4 - (i93 & 3)) + i7;
                                            Label2 label7 = label2Arr10[l(i108) + i93];
                                            int iL6 = l(i108 + 4);
                                            int iL7 = l(i108 + 8);
                                            i11 = i108 + 12;
                                            i12 = (iL7 - iL6) + 1;
                                            label2Arr2 = new Label2[i12];
                                            for (i13 = 0; i13 < i12; i13++) {
                                                label2Arr2[i13] = label2Arr10[l(i11) + i93];
                                                i11 += 4;
                                            }
                                            methodVisitor2.q(iL6, iL7, label7, label2Arr2);
                                            i10 = i11;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR113 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR113, cArr), true), iR113 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR114 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR114, cArr), false), iR114 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.LOOKUPSWITCH /* 171 */:
                                            z2 = z2;
                                            int i109 = (4 - (i93 & 3)) + i7;
                                            Label2 label8 = label2Arr10[l(i109) + i93];
                                            iL = l(i109 + 4);
                                            iArr4 = new int[iL];
                                            label2Arr3 = new Label2[iL];
                                            i14 = i109 + 8;
                                            for (i15 = 0; i15 < iL; i15++) {
                                                iArr4[i15] = l(i14);
                                                label2Arr3[i15] = label2Arr10[l(i14 + 4) + i93];
                                                i14 += 8;
                                            }
                                            methodWriter2 = (MethodWriter2) methodVisitor2;
                                            ByteVector2 byteVector2 = methodWriter2.l;
                                            methodWriter2.Z = byteVector2.f3699b;
                                            byteVector2.g(Opcodes.LOOKUPSWITCH);
                                            int i110 = i14;
                                            byteVector2.h(null, 0, (4 - (methodWriter2.l.f3699b % 4)) % 4);
                                            z4 = true;
                                            label8.e(methodWriter2.l, methodWriter2.Z, true);
                                            methodWriter2.l.i(iL);
                                            i16 = 0;
                                            while (i16 < iL) {
                                                methodWriter2.l.i(iArr4[i16]);
                                                label2Arr3[i16].e(methodWriter2.l, methodWriter2.Z, z4);
                                                i16++;
                                                iL = iL;
                                                z4 = true;
                                            }
                                            methodWriter2.B(label8, label2Arr3);
                                            i10 = i110;
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR115 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR115, cArr), true), iR115 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR116 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR116, cArr), false), iR116 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.GETSTATIC /* 178 */:
                                        case Opcodes.PUTSTATIC /* 179 */:
                                        case 180:
                                        case Opcodes.PUTFIELD /* 181 */:
                                        case Opcodes.INVOKEVIRTUAL /* 182 */:
                                        case Opcodes.INVOKESPECIAL /* 183 */:
                                        case Opcodes.INVOKESTATIC /* 184 */:
                                        case Opcodes.INVOKEINTERFACE /* 185 */:
                                            i17 = this.f3700b[u(i7 + 1)];
                                            int i111 = this.f3700b[u(i17 + 2)];
                                            strG = g(i17, cArr);
                                            strT2 = t(i111, cArr);
                                            strT3 = t(i111 + 2, cArr);
                                            if (i9 < 182) {
                                                methodVisitor2.b(i9, strG, strT2, strT3);
                                            } else {
                                                if (bArr[i17 - 1] == 11) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                methodVisitor2.p(i9, strG, strT2, strT3, z5);
                                            }
                                            if (i9 == 185) {
                                                i10 = i7 + 5;
                                            } else {
                                                i10 = i7 + 3;
                                            }
                                            iD4 = iD4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR117 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR117, cArr), true), iR117 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR118 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR118, cArr), false), iR118 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                                            int i112 = this.f3700b[u(i7 + 1)];
                                            int i113 = this.f3700b[u(i112 + 2)];
                                            String strT8 = t(i113, cArr);
                                            String strT9 = t(i113 + 2, cArr);
                                            int i114 = this.e[u(i112)];
                                            Handle2 handle2 = (Handle2) i(u(i114), cArr);
                                            iU = u(i114 + 2);
                                            objArr = new Object[iU];
                                            i18 = i114 + 4;
                                            i19 = 0;
                                            while (i19 < iU) {
                                                objArr[i19] = i(u(i18), cArr);
                                                i18 += 2;
                                                i19++;
                                                iU = iU;
                                            }
                                            methodWriter3 = (MethodWriter2) methodVisitor2;
                                            methodWriter3.Z = methodWriter3.l.f3699b;
                                            SymbolTable2 symbolTable2 = methodWriter3.d;
                                            symbol2D = symbolTable2.d(18, strT8, strT9, symbolTable2.a(handle2, objArr).a);
                                            methodWriter3.l.e(Opcodes.INVOKEDYNAMIC, symbol2D.a);
                                            methodWriter3.l.j(0);
                                            label2 = methodWriter3.Q;
                                            if (label2 != null) {
                                                i20 = methodWriter3.N;
                                                if (i20 != 4 || i20 == 3) {
                                                    label2.k.b(Opcodes.INVOKEDYNAMIC, 0, symbol2D, methodWriter3.d);
                                                } else {
                                                    int iA = symbol2D.a();
                                                    int i115 = methodWriter3.R + ((iA & 3) - (iA >> 2)) + 1;
                                                    if (i115 > methodWriter3.S) {
                                                        methodWriter3.S = i115;
                                                    }
                                                    methodWriter3.R = i115;
                                                }
                                            }
                                            i10 = i7 + 5;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR119 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR119, cArr), true), iR119 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR1110 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1110, cArr), false), iR1110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.NEW /* 187 */:
                                        case Opcodes.ANEWARRAY /* 189 */:
                                        case Opcodes.CHECKCAST /* 192 */:
                                        case Opcodes.INSTANCEOF /* 193 */:
                                            methodVisitor2.s(i9, g(i7 + 1, cArr));
                                            i10 = i7 + 3;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR1111 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1111, cArr), true), iR1111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR1112 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1112, cArr), false), iR1112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 196:
                                            i21 = bArr[i7 + 1] & 255;
                                            if (i21 == 132) {
                                                methodVisitor2.d(u(i7 + 2), q(i7 + 4));
                                                i10 = i7 + 6;
                                            } else {
                                                methodVisitor2.t(i21, u(i7 + 2));
                                                i10 = i7 + 4;
                                            }
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR1113 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1113, cArr), true), iR1113 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR1114 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1114, cArr), false), iR1114 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case Opcodes.MULTIANEWARRAY /* 197 */:
                                            String strG2 = g(i7 + 1, cArr);
                                            i22 = bArr[i7 + 3] & 255;
                                            methodWriter4 = (MethodWriter2) methodVisitor2;
                                            methodWriter4.Z = methodWriter4.l.f3699b;
                                            symbol2M = methodWriter4.d.m(7, strG2);
                                            ByteVector2 byteVector3 = methodWriter4.l;
                                            byteVector3.e(Opcodes.MULTIANEWARRAY, symbol2M.a);
                                            byteVector3.g(i22);
                                            label3 = methodWriter4.Q;
                                            if (label3 != null) {
                                                i23 = methodWriter4.N;
                                                if (i23 != 4 || i23 == 3) {
                                                    label3.k.b(Opcodes.MULTIANEWARRAY, i22, symbol2M, methodWriter4.d);
                                                } else {
                                                    methodWriter4.R = (1 - i22) + methodWriter4.R;
                                                }
                                            }
                                            i10 = i7 + 4;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR1115 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1115, cArr), true), iR1115 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR1116 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1116, cArr), false), iR1116 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 200:
                                        case 201:
                                            methodVisitor2.h(i9 - i71, label2Arr10[l(i7 + 1) + i93]);
                                            i10 = i7 + 5;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR1117 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1117, cArr), true), iR1117 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR1118 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1118, cArr), false), iR1118 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 202:
                                        case 203:
                                        case 204:
                                        case 205:
                                        case 206:
                                        case 207:
                                        case 208:
                                        case 209:
                                        case 210:
                                        case 211:
                                        case 212:
                                        case 213:
                                        case 214:
                                        case 215:
                                        case 216:
                                        case 217:
                                        case 218:
                                        case 219:
                                            if (i9 < 218) {
                                                i24 = i9 - 49;
                                            } else {
                                                i24 = i9 - 20;
                                            }
                                            label4 = label2Arr10[u(i7 + 1) + i93];
                                            if (i24 != 167 || i24 == 168) {
                                                methodVisitor2.h(i24 + 33, label4);
                                                z6 = z2;
                                            } else {
                                                methodVisitor2.h(i24 < 167 ? ((i24 + 1) ^ 1) - 1 : i24 ^ 1, b(i93 + 3, label2Arr10));
                                                methodVisitor2.h(200, label4);
                                                z6 = true;
                                            }
                                            i10 = i7 + 3;
                                            z8 = z8;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR1119 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR1119, cArr), true), iR1119 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR11110 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR11110, cArr), false), iR11110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        case 220:
                                            methodVisitor2.h(200, label2Arr10[l(i7 + 1) + i93]);
                                            i10 = i7 + 5;
                                            z8 = z8;
                                            z3 = true;
                                            while (iArr3 != null) {
                                                if (iD4 == i93) {
                                                    int iR11111 = r(context3, iArr3[i75]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR11111, cArr), true), iR11111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iD4 = d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iD = i72;
                                            while (iArr2 != null) {
                                                if (iD == i93) {
                                                    int iR11112 = r(context3, iArr2[i25]);
                                                    k(methodVisitor2.f(context3.h, context3.i, t(iR11112, cArr), false), iR11112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iD = d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iD;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            label2Arr = label2Arr10;
                                            i73 = i10;
                                            iU4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iD4 = iD4;
                                            iArr11 = iArr2;
                                            iU5 = i6;
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            iArr2 = iArr11;
                            iArr3 = iArr10;
                            i5 = i2;
                            i6 = iU5;
                            i7 = i4;
                            i8 = i96;
                            if (z12) {
                                if ((context3.f3707b & 8) != 0) {
                                    methodVisitor2.c(256, 0, null, 0, null);
                                }
                                z2 = false;
                            } else {
                                z2 = z12;
                            }
                            i9 = bArr[i7] & 255;
                            switch (i9) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 123:
                                case 124:
                                case Opcodes.LUSHR /* 125 */:
                                case 126:
                                case Opcodes.LAND /* 127 */:
                                case 128:
                                case Opcodes.LOR /* 129 */:
                                case 130:
                                case Opcodes.LXOR /* 131 */:
                                case Opcodes.I2L /* 133 */:
                                case Opcodes.I2F /* 134 */:
                                case Opcodes.I2D /* 135 */:
                                case Opcodes.L2I /* 136 */:
                                case Opcodes.L2F /* 137 */:
                                case Opcodes.L2D /* 138 */:
                                case Opcodes.F2I /* 139 */:
                                case Opcodes.F2L /* 140 */:
                                case Opcodes.F2D /* 141 */:
                                case Opcodes.D2I /* 142 */:
                                case Opcodes.D2L /* 143 */:
                                case Opcodes.D2F /* 144 */:
                                case Opcodes.I2B /* 145 */:
                                case Opcodes.I2C /* 146 */:
                                case Opcodes.I2S /* 147 */:
                                case Opcodes.LCMP /* 148 */:
                                case Opcodes.FCMPL /* 149 */:
                                case 150:
                                case Opcodes.DCMPL /* 151 */:
                                case Opcodes.DCMPG /* 152 */:
                                case Opcodes.IRETURN /* 172 */:
                                case Opcodes.LRETURN /* 173 */:
                                case Opcodes.FRETURN /* 174 */:
                                case 175:
                                case Opcodes.ARETURN /* 176 */:
                                case Opcodes.RETURN /* 177 */:
                                case Opcodes.ARRAYLENGTH /* 190 */:
                                case Opcodes.ATHROW /* 191 */:
                                case Opcodes.MONITORENTER /* 194 */:
                                case Opcodes.MONITOREXIT /* 195 */:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    methodVisitor2.e(i9);
                                    i10 = i7 + 1;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11113 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11113, cArr), true), iR11113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11114 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11114, cArr), false), iR11114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 16:
                                case Opcodes.NEWARRAY /* 188 */:
                                    methodVisitor2.g(i9, bArr[i7 + 1]);
                                    i10 = i7 + 2;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11115 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11115, cArr), true), iR11115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11116 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11116, cArr), false), iR11116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 17:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    methodVisitor2.g(i9, q(i7 + 1));
                                    i10 = i7 + 3;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11117 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11117, cArr), true), iR11117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11118 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11118, cArr), false), iR11118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 18:
                                    methodVisitor2.j(i(bArr[i7 + 1] & 255, cArr));
                                    i10 = i7 + 2;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11119 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11119, cArr), true), iR11119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111110 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111110, cArr), false), iR111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 19:
                                case 20:
                                    methodVisitor2.j(i(u(i7 + 1), cArr));
                                    i10 = i7 + 3;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111111 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111111, cArr), true), iR111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111112 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111112, cArr), false), iR111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case Opcodes.RET /* 169 */:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    methodVisitor2.t(i9, bArr[i7 + 1] & 255);
                                    i10 = i7 + 2;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111113 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111113, cArr), true), iR111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111114 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111114, cArr), false), iR111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    int i1010 = i9 - 26;
                                    methodVisitor2.t((i1010 >> 2) + 21, 3 & i1010);
                                    i10 = i7 + 1;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111115 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111115, cArr), true), iR111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111116 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111116, cArr), false), iR111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                    int i1011 = i9 - 59;
                                    methodVisitor2.t((i1011 >> 2) + 54, 3 & i1011);
                                    i10 = i7 + 1;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111117 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111117, cArr), true), iR111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111118 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111118, cArr), false), iR111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.IINC /* 132 */:
                                    methodVisitor2.d(bArr[i7 + 1] & 255, bArr[i7 + 2]);
                                    i10 = i7 + 3;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111119 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111119, cArr), true), iR111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR1111110 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111110, cArr), false), iR1111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 153:
                                case 154:
                                case 155:
                                case 156:
                                case 157:
                                case 158:
                                case Opcodes.IF_ICMPEQ /* 159 */:
                                case Opcodes.IF_ICMPNE /* 160 */:
                                case Opcodes.IF_ICMPLT /* 161 */:
                                case Opcodes.IF_ICMPGE /* 162 */:
                                case Opcodes.IF_ICMPGT /* 163 */:
                                case Opcodes.IF_ICMPLE /* 164 */:
                                case Opcodes.IF_ACMPEQ /* 165 */:
                                case Opcodes.IF_ACMPNE /* 166 */:
                                case Opcodes.GOTO /* 167 */:
                                case Opcodes.JSR /* 168 */:
                                case Opcodes.IFNULL /* 198 */:
                                case Opcodes.IFNONNULL /* 199 */:
                                    methodVisitor2.h(i9, label2Arr10[q(i7 + 1) + i93]);
                                    i10 = i7 + 3;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR1111111 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111111, cArr), true), iR1111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR1111112 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111112, cArr), false), iR1111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.TABLESWITCH /* 170 */:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    int i1012 = (4 - (i93 & 3)) + i7;
                                    Label2 label9 = label2Arr10[l(i1012) + i93];
                                    int iL8 = l(i1012 + 4);
                                    int iL9 = l(i1012 + 8);
                                    i11 = i1012 + 12;
                                    i12 = (iL9 - iL8) + 1;
                                    label2Arr2 = new Label2[i12];
                                    while (i13 < i12) {
                                        label2Arr2[i13] = label2Arr10[l(i11) + i93];
                                        i11 += 4;
                                    }
                                    methodVisitor2.q(iL8, iL9, label9, label2Arr2);
                                    i10 = i11;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR1111113 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111113, cArr), true), iR1111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR1111114 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111114, cArr), false), iR1111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.LOOKUPSWITCH /* 171 */:
                                    z2 = z2;
                                    int i1013 = (4 - (i93 & 3)) + i7;
                                    Label2 label10 = label2Arr10[l(i1013) + i93];
                                    iL = l(i1013 + 4);
                                    iArr4 = new int[iL];
                                    label2Arr3 = new Label2[iL];
                                    i14 = i1013 + 8;
                                    while (i15 < iL) {
                                        iArr4[i15] = l(i14);
                                        label2Arr3[i15] = label2Arr10[l(i14 + 4) + i93];
                                        i14 += 8;
                                    }
                                    methodWriter2 = (MethodWriter2) methodVisitor2;
                                    ByteVector2 byteVector4 = methodWriter2.l;
                                    methodWriter2.Z = byteVector4.f3699b;
                                    byteVector4.g(Opcodes.LOOKUPSWITCH);
                                    int i116 = i14;
                                    byteVector4.h(null, 0, (4 - (methodWriter2.l.f3699b % 4)) % 4);
                                    z4 = true;
                                    label10.e(methodWriter2.l, methodWriter2.Z, true);
                                    methodWriter2.l.i(iL);
                                    i16 = 0;
                                    while (i16 < iL) {
                                        methodWriter2.l.i(iArr4[i16]);
                                        label2Arr3[i16].e(methodWriter2.l, methodWriter2.Z, z4);
                                        i16++;
                                        iL = iL;
                                        z4 = true;
                                    }
                                    methodWriter2.B(label10, label2Arr3);
                                    i10 = i116;
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR1111115 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111115, cArr), true), iR1111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR1111116 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111116, cArr), false), iR1111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.GETSTATIC /* 178 */:
                                case Opcodes.PUTSTATIC /* 179 */:
                                case 180:
                                case Opcodes.PUTFIELD /* 181 */:
                                case Opcodes.INVOKEVIRTUAL /* 182 */:
                                case Opcodes.INVOKESPECIAL /* 183 */:
                                case Opcodes.INVOKESTATIC /* 184 */:
                                case Opcodes.INVOKEINTERFACE /* 185 */:
                                    i17 = this.f3700b[u(i7 + 1)];
                                    int i117 = this.f3700b[u(i17 + 2)];
                                    strG = g(i17, cArr);
                                    strT2 = t(i117, cArr);
                                    strT3 = t(i117 + 2, cArr);
                                    if (i9 < 182) {
                                        methodVisitor2.b(i9, strG, strT2, strT3);
                                    } else {
                                        if (bArr[i17 - 1] == 11) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        methodVisitor2.p(i9, strG, strT2, strT3, z5);
                                    }
                                    if (i9 == 185) {
                                        i10 = i7 + 5;
                                    } else {
                                        i10 = i7 + 3;
                                    }
                                    iD4 = iD4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR1111117 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111117, cArr), true), iR1111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR1111118 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111118, cArr), false), iR1111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.INVOKEDYNAMIC /* 186 */:
                                    int i118 = this.f3700b[u(i7 + 1)];
                                    int i119 = this.f3700b[u(i118 + 2)];
                                    String strT10 = t(i119, cArr);
                                    String strT11 = t(i119 + 2, cArr);
                                    int i1110 = this.e[u(i118)];
                                    Handle2 handle3 = (Handle2) i(u(i1110), cArr);
                                    iU = u(i1110 + 2);
                                    objArr = new Object[iU];
                                    i18 = i1110 + 4;
                                    i19 = 0;
                                    while (i19 < iU) {
                                        objArr[i19] = i(u(i18), cArr);
                                        i18 += 2;
                                        i19++;
                                        iU = iU;
                                    }
                                    methodWriter3 = (MethodWriter2) methodVisitor2;
                                    methodWriter3.Z = methodWriter3.l.f3699b;
                                    SymbolTable2 symbolTable3 = methodWriter3.d;
                                    symbol2D = symbolTable3.d(18, strT10, strT11, symbolTable3.a(handle3, objArr).a);
                                    methodWriter3.l.e(Opcodes.INVOKEDYNAMIC, symbol2D.a);
                                    methodWriter3.l.j(0);
                                    label2 = methodWriter3.Q;
                                    if (label2 != null) {
                                        i20 = methodWriter3.N;
                                        if (i20 != 4) {
                                            label2.k.b(Opcodes.INVOKEDYNAMIC, 0, symbol2D, methodWriter3.d);
                                        } else {
                                            label2.k.b(Opcodes.INVOKEDYNAMIC, 0, symbol2D, methodWriter3.d);
                                        }
                                    }
                                    i10 = i7 + 5;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR1111119 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR1111119, cArr), true), iR1111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11111110 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111110, cArr), false), iR11111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.NEW /* 187 */:
                                case Opcodes.ANEWARRAY /* 189 */:
                                case Opcodes.CHECKCAST /* 192 */:
                                case Opcodes.INSTANCEOF /* 193 */:
                                    methodVisitor2.s(i9, g(i7 + 1, cArr));
                                    i10 = i7 + 3;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11111111 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111111, cArr), true), iR11111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11111112 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111112, cArr), false), iR11111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 196:
                                    i21 = bArr[i7 + 1] & 255;
                                    if (i21 == 132) {
                                        methodVisitor2.d(u(i7 + 2), q(i7 + 4));
                                        i10 = i7 + 6;
                                    } else {
                                        methodVisitor2.t(i21, u(i7 + 2));
                                        i10 = i7 + 4;
                                    }
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11111113 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111113, cArr), true), iR11111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11111114 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111114, cArr), false), iR11111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case Opcodes.MULTIANEWARRAY /* 197 */:
                                    String strG3 = g(i7 + 1, cArr);
                                    i22 = bArr[i7 + 3] & 255;
                                    methodWriter4 = (MethodWriter2) methodVisitor2;
                                    methodWriter4.Z = methodWriter4.l.f3699b;
                                    symbol2M = methodWriter4.d.m(7, strG3);
                                    ByteVector2 byteVector5 = methodWriter4.l;
                                    byteVector5.e(Opcodes.MULTIANEWARRAY, symbol2M.a);
                                    byteVector5.g(i22);
                                    label3 = methodWriter4.Q;
                                    if (label3 != null) {
                                        i23 = methodWriter4.N;
                                        if (i23 != 4) {
                                            label3.k.b(Opcodes.MULTIANEWARRAY, i22, symbol2M, methodWriter4.d);
                                        } else {
                                            label3.k.b(Opcodes.MULTIANEWARRAY, i22, symbol2M, methodWriter4.d);
                                        }
                                    }
                                    i10 = i7 + 4;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11111115 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111115, cArr), true), iR11111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11111116 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111116, cArr), false), iR11111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 200:
                                case 201:
                                    methodVisitor2.h(i9 - i71, label2Arr10[l(i7 + 1) + i93]);
                                    i10 = i7 + 5;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11111117 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111117, cArr), true), iR11111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR11111118 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111118, cArr), false), iR11111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 202:
                                case 203:
                                case 204:
                                case 205:
                                case 206:
                                case 207:
                                case 208:
                                case 209:
                                case 210:
                                case 211:
                                case 212:
                                case 213:
                                case 214:
                                case 215:
                                case 216:
                                case 217:
                                case 218:
                                case 219:
                                    if (i9 < 218) {
                                        i24 = i9 - 49;
                                    } else {
                                        i24 = i9 - 20;
                                    }
                                    label4 = label2Arr10[u(i7 + 1) + i93];
                                    if (i24 != 167) {
                                        methodVisitor2.h(i24 + 33, label4);
                                        z6 = z2;
                                    } else {
                                        methodVisitor2.h(i24 + 33, label4);
                                        z6 = z2;
                                    }
                                    i10 = i7 + 3;
                                    z8 = z8;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR11111119 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR11111119, cArr), true), iR11111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111111110 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111111110, cArr), false), iR111111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                case 220:
                                    methodVisitor2.h(200, label2Arr10[l(i7 + 1) + i93]);
                                    i10 = i7 + 5;
                                    z8 = z8;
                                    z3 = true;
                                    while (iArr3 != null) {
                                        if (iD4 == i93) {
                                            int iR111111111 = r(context3, iArr3[i75]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111111111, cArr), true), iR111111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iD4 = d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iD = i72;
                                    while (iArr2 != null) {
                                        if (iD == i93) {
                                            int iR111111112 = r(context3, iArr2[i25]);
                                            k(methodVisitor2.f(context3.h, context3.i, t(iR111111112, cArr), false), iR111111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iD = d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iD;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    label2Arr = label2Arr10;
                                    i73 = i10;
                                    iU4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iD4 = iD4;
                                    iArr11 = iArr2;
                                    iU5 = i6;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                    }
                }
            }
        }
    }

    public Object i(int i, char[] cArr) {
        int[] iArr = this.f3700b;
        int i2 = iArr[i];
        byte b2 = this.a[i2 - 1];
        switch (b2) {
            case 3:
                return Integer.valueOf(l(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(l(i2)));
            case 5:
                return Long.valueOf(m(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(m(i2)));
            case 7:
                return Type2.h(t(i2, cArr));
            case 8:
                return t(i2, cArr);
            default:
                switch (b2) {
                    case 15:
                        int iF = f(i2);
                        int i3 = this.f3700b[u(i2 + 1)];
                        int i4 = this.f3700b[u(i3 + 2)];
                        return new Handle2(iF, g(i3, cArr), t(i4, cArr), t(i4 + 2, cArr), this.a[i3 - 1] == 11);
                    case 16:
                        String strT = t(i2, cArr);
                        return new Type2(11, strT, 0, strT.length());
                    case 17:
                        ConstantDynamic2 constantDynamic2 = this.d[i];
                        if (constantDynamic2 != null) {
                            return constantDynamic2;
                        }
                        int i5 = iArr[i];
                        int i6 = iArr[u(i5 + 2)];
                        String strT2 = t(i6, cArr);
                        String strT3 = t(i6 + 2, cArr);
                        int i7 = this.e[u(i5)];
                        Handle2 handle2 = (Handle2) i(u(i7), cArr);
                        int iU = u(i7 + 2);
                        Object[] objArr = new Object[iU];
                        int i8 = i7 + 4;
                        for (int i9 = 0; i9 < iU; i9++) {
                            objArr[i9] = i(u(i8), cArr);
                            i8 += 2;
                        }
                        ConstantDynamic2[] constantDynamic2Arr = this.d;
                        ConstantDynamic2 constantDynamic3 = new ConstantDynamic2(strT2, strT3, handle2, objArr);
                        constantDynamic2Arr[i] = constantDynamic3;
                        return constantDynamic3;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:99:0x0235  */
    public final int j(AnnotationWriter2 annotationWriter2, int i, String str, char[] cArr) {
        int i2 = 0;
        if (annotationWriter2 == null) {
            int i3 = this.a[i] & 255;
            if (i3 == 64) {
                return k(null, i + 3, true, cArr);
            }
            if (i3 != 91) {
                return i3 != 101 ? i + 3 : i + 5;
            }
            return k(null, i + 1, false, cArr);
        }
        int i4 = i + 1;
        int i5 = this.a[i] & 255;
        if (i5 == 64) {
            String strT = t(i4, cArr);
            annotationWriter2.e++;
            if (annotationWriter2.f3696b) {
                annotationWriter2.c.j(annotationWriter2.a.l(str));
            }
            ByteVector2 byteVector2 = annotationWriter2.c;
            byteVector2.e(64, annotationWriter2.a.l(strT));
            byteVector2.j(0);
            return k(new AnnotationWriter2(annotationWriter2.a, true, annotationWriter2.c, null), i4 + 2, true, cArr);
        }
        if (i5 == 70) {
            annotationWriter2.e(str, i(u(i4), cArr));
        } else if (i5 == 83) {
            annotationWriter2.e(str, Short.valueOf((short) l(this.f3700b[u(i4)])));
        } else if (i5 == 99) {
            String strT2 = t(i4, cArr);
            annotationWriter2.e(str, Type2.k(strT2, 0, strT2.length()));
        } else {
            if (i5 == 101) {
                String strT3 = t(i4, cArr);
                String strT4 = t(i4 + 2, cArr);
                annotationWriter2.e++;
                if (annotationWriter2.f3696b) {
                    annotationWriter2.c.j(annotationWriter2.a.l(str));
                }
                ByteVector2 byteVector3 = annotationWriter2.c;
                byteVector3.e(101, annotationWriter2.a.l(strT3));
                byteVector3.j(annotationWriter2.a.l(strT4));
                return i4 + 4;
            }
            if (i5 == 115) {
                annotationWriter2.e(str, t(i4, cArr));
            } else if (i5 == 73 || i5 == 74) {
                annotationWriter2.e(str, i(u(i4), cArr));
            } else if (i5 == 90) {
                annotationWriter2.e(str, l(this.f3700b[u(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
            } else {
                if (i5 == 91) {
                    int iU = u(i4);
                    int i6 = i4 + 2;
                    if (iU == 0) {
                        return k(annotationWriter2.f(str), i6 - 2, false, cArr);
                    }
                    int i7 = this.a[i6] & 255;
                    if (i7 == 70) {
                        float[] fArr = new float[iU];
                        while (i2 < iU) {
                            fArr[i2] = Float.intBitsToFloat(l(this.f3700b[u(i6 + 1)]));
                            i6 += 3;
                            i2++;
                        }
                        annotationWriter2.e(str, fArr);
                        return i6;
                    }
                    if (i7 == 83) {
                        short[] sArr = new short[iU];
                        while (i2 < iU) {
                            sArr[i2] = (short) l(this.f3700b[u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationWriter2.e(str, sArr);
                        return i6;
                    }
                    if (i7 == 90) {
                        boolean[] zArr = new boolean[iU];
                        for (int i8 = 0; i8 < iU; i8++) {
                            zArr[i8] = l(this.f3700b[u(i6 + 1)]) != 0;
                            i6 += 3;
                        }
                        annotationWriter2.e(str, zArr);
                        return i6;
                    }
                    if (i7 == 73) {
                        int[] iArr = new int[iU];
                        while (i2 < iU) {
                            iArr[i2] = l(this.f3700b[u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationWriter2.e(str, iArr);
                        return i6;
                    }
                    if (i7 == 74) {
                        long[] jArr = new long[iU];
                        while (i2 < iU) {
                            jArr[i2] = m(this.f3700b[u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationWriter2.e(str, jArr);
                        return i6;
                    }
                    switch (i7) {
                        case 66:
                            byte[] bArr = new byte[iU];
                            while (i2 < iU) {
                                bArr[i2] = (byte) l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, bArr);
                            return i6;
                        case 67:
                            char[] cArr2 = new char[iU];
                            while (i2 < iU) {
                                cArr2[i2] = (char) l(this.f3700b[u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, cArr2);
                            return i6;
                        case 68:
                            double[] dArr = new double[iU];
                            while (i2 < iU) {
                                dArr[i2] = Double.longBitsToDouble(m(this.f3700b[u(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            annotationWriter2.e(str, dArr);
                            return i6;
                        default:
                            return k(annotationWriter2.f(str), i6 - 2, false, cArr);
                    }
                }
                switch (i5) {
                    case 66:
                        annotationWriter2.e(str, Byte.valueOf((byte) l(this.f3700b[u(i4)])));
                        break;
                    case 67:
                        annotationWriter2.e(str, Character.valueOf((char) l(this.f3700b[u(i4)])));
                        break;
                    case 68:
                        annotationWriter2.e(str, i(u(i4), cArr));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return i4 + 2;
    }

    public final int k(AnnotationWriter2 annotationWriter2, int i, boolean z2, char[] cArr) {
        int iU = u(i);
        int iJ = i + 2;
        if (!z2) {
            while (true) {
                int i2 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(annotationWriter2, iJ, null, cArr);
                iU = i2;
            }
        } else {
            while (true) {
                int i3 = iU - 1;
                if (iU <= 0) {
                    break;
                }
                iJ = j(annotationWriter2, iJ + 2, t(iJ, cArr), cArr);
                iU = i3;
            }
        }
        if (annotationWriter2 != null) {
            annotationWriter2.g();
        }
        return iJ;
    }

    public int l(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long m(int i) {
        return (((long) l(i)) << 32) | (((long) l(i + 4)) & 4294967295L);
    }

    public String n(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public String o(int i, char[] cArr) {
        return t(this.f3700b[u(i)], cArr);
    }

    public final void p(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        AnnotationWriter2 annotationWriter2;
        int iK = i + 1;
        int i2 = this.a[i] & 255;
        MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
        if (z2) {
            methodWriter2.D = i2;
        } else {
            methodWriter2.F = i2;
        }
        char[] cArr = context3.c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iU = u(iK);
            iK += 2;
            while (true) {
                int i4 = iU - 1;
                if (iU > 0) {
                    String strT = t(iK, cArr);
                    int i5 = iK + 2;
                    ByteVector2 byteVector2 = new ByteVector2();
                    byteVector2.j(methodWriter2.d.l(strT));
                    byteVector2.j(0);
                    if (z2) {
                        if (methodWriter2.E == null) {
                            methodWriter2.E = new AnnotationWriter2[Type2.a(methodWriter2.i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr = methodWriter2.E;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, annotationWriter2Arr[i3]);
                        annotationWriter2Arr[i3] = annotationWriter2;
                    } else {
                        if (methodWriter2.G == null) {
                            methodWriter2.G = new AnnotationWriter2[Type2.a(methodWriter2.i).length];
                        }
                        AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.G;
                        annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, annotationWriter2Arr2[i3]);
                        annotationWriter2Arr2[i3] = annotationWriter2;
                    }
                    iK = k(annotationWriter2, i5, true, cArr);
                    iU = i4;
                }
            }
        }
    }

    public short q(int i) {
        byte[] bArr = this.a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    public final int r(Context3 context3, int i) {
        int i2;
        int i3;
        int iL = l(i);
        int i4 = iL >>> 24;
        if (i4 != 0 && i4 != 1) {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iL & InputDeviceCompat.SOURCE_ANY;
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                    i3 = i + 1;
                    break;
                case 22:
                    i2 = iL & (-65536);
                    i3 = i + 2;
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            int iU = u(i + 1);
                            i3 = i + 3;
                            context3.j = new Label2[iU];
                            context3.k = new Label2[iU];
                            context3.l = new int[iU];
                            for (int i5 = 0; i5 < iU; i5++) {
                                int iU2 = u(i3);
                                int iU3 = u(i3 + 2);
                                int iU4 = u(i3 + 4);
                                i3 += 6;
                                context3.j[i5] = b(iU2, context3.g);
                                context3.k[i5] = b(iU2 + iU3, context3.g);
                                context3.l[i5] = iU4;
                            }
                            break;
                        case 66:
                            i2 = iL & InputDeviceCompat.SOURCE_ANY;
                            i3 = i + 3;
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iL & ViewCompat.MEASURED_STATE_MASK;
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iL & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i2 = iL & (-65536);
            i3 = i + 2;
        }
        context3.h = i2;
        int iF = f(i3);
        context3.i = iF == 0 ? null : new TypePath2(this.a, i3);
        return (iF * 2) + i3 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e A[FALL_THROUGH] */
    public final int[] s(MethodVisitor2 methodVisitor2, Context3 context3, int i, boolean z2) {
        int i2;
        AnnotationWriter2 annotationWriter2;
        char[] cArr = context3.c;
        int iU = u(i);
        int[] iArr = new int[iU];
        int iK = i + 2;
        for (int i3 = 0; i3 < iU; i3++) {
            iArr[i3] = iK;
            int iL = l(iK);
            int i4 = iL >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iU2 = u(iK + 1);
                                i2 = iK + 3;
                                while (true) {
                                    int i5 = iU2 - 1;
                                    if (iU2 > 0) {
                                        int iU3 = u(i2);
                                        int iU4 = u(i2 + 2);
                                        i2 += 6;
                                        b(iU3, context3.g);
                                        b(iU3 + iU4, context3.g);
                                        iU2 = i5;
                                    }
                                    break;
                                }
                                break;
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i2 = iK + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iK + 3;
                        break;
                }
            } else {
                i2 = iK + 3;
            }
            int iF = f(i2);
            if (i4 == 66) {
                TypePath2 typePath2 = iF != 0 ? new TypePath2(this.a, i2) : null;
                int i6 = (iF * 2) + 1 + i2;
                String strT = t(i6, cArr);
                int i7 = i6 + 2;
                int i8 = iL & InputDeviceCompat.SOURCE_ANY;
                MethodWriter2 methodWriter2 = (MethodWriter2) methodVisitor2;
                Objects.requireNonNull(methodWriter2);
                ByteVector2 byteVector2 = new ByteVector2();
                b.i.a.f.e.o.f.W0(i8, byteVector2);
                TypePath2.a(typePath2, byteVector2);
                byteVector2.j(methodWriter2.d.l(strT));
                byteVector2.j(0);
                if (z2) {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, methodWriter2.w);
                    methodWriter2.w = annotationWriter2;
                } else {
                    annotationWriter2 = new AnnotationWriter2(methodWriter2.d, true, byteVector2, methodWriter2.f3719x);
                    methodWriter2.f3719x = annotationWriter2;
                }
                iK = k(annotationWriter2, i7, true, cArr);
            } else {
                iK = k(null, (iF * 2) + 3 + i2, true, cArr);
            }
        }
        return iArr;
    }

    public String t(int i, char[] cArr) {
        int iU = u(i);
        if (i == 0 || iU == 0) {
            return null;
        }
        return w(iU, cArr);
    }

    public int u(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final String v(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.a;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if ((b2 & 128) == 0) {
                i3 = i5 + 1;
                cArr[i5] = (char) (b2 & 127);
            } else if ((b2 & 224) == 192) {
                cArr[i5] = (char) (((b2 & 31) << 6) + (bArr[i6] & 63));
                i5++;
                i = i6 + 1;
            } else {
                i3 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((b2 & 15) << 12) + ((bArr[i6] & 63) << 6);
                i6 = i7 + 1;
                cArr[i5] = (char) (i8 + (bArr[i7] & 63));
            }
            i = i6;
            i5 = i3;
        }
        return new String(cArr, 0, i5);
    }

    public final String w(int i, char[] cArr) {
        String[] strArr = this.c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.f3700b[i];
        String strV = v(i2 + 2, u(i2), cArr);
        strArr[i] = strV;
        return strV;
    }

    public final int x(int i, Object[] objArr, int i2, char[] cArr, Label2[] label2Arr) {
        int i3 = i + 1;
        switch (this.a[i] & 255) {
            case 0:
                objArr[i2] = Opcodes2.a;
                return i3;
            case 1:
                objArr[i2] = Opcodes2.f3723b;
                return i3;
            case 2:
                objArr[i2] = Opcodes2.c;
                return i3;
            case 3:
                objArr[i2] = Opcodes2.d;
                return i3;
            case 4:
                objArr[i2] = Opcodes2.e;
                return i3;
            case 5:
                objArr[i2] = Opcodes2.f;
                return i3;
            case 6:
                objArr[i2] = Opcodes2.g;
                return i3;
            case 7:
                objArr[i2] = g(i3, cArr);
                break;
            case 8:
                objArr[i2] = b(u(i3), label2Arr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
