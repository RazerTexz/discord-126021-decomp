package p617h0.p618a.p619a;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: h0.a.a.d */
/* JADX INFO: compiled from: ClassReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12415d {

    /* JADX INFO: renamed from: a */
    public final byte[] f26155a;

    /* JADX INFO: renamed from: b */
    public final int[] f26156b;

    /* JADX INFO: renamed from: c */
    public final String[] f26157c;

    /* JADX INFO: renamed from: d */
    public final C12418g[] f26158d;

    /* JADX INFO: renamed from: e */
    public final int[] f26159e;

    /* JADX INFO: renamed from: f */
    public final int f26160f;

    /* JADX INFO: renamed from: g */
    public final int f26161g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C12415d(byte[] bArr, int i, boolean z2) {
        int i2;
        this.f26155a = bArr;
        if (z2) {
            int i3 = i + 6;
            if (m10555q(i3) > 56) {
                StringBuilder sbM833U = C1643a.m833U("Unsupported class file major version ");
                sbM833U.append((int) m10555q(i3));
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }
        int iM10559u = m10559u(i + 8);
        this.f26156b = new int[iM10559u];
        this.f26157c = new String[iM10559u];
        int i4 = i + 10;
        int i5 = 1;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            int iM10559u2 = 4;
            if (i5 >= iM10559u) {
                this.f26160f = i6;
                this.f26161g = i4;
                int[] iArr = null;
                this.f26158d = z3 ? new C12418g[iM10559u] : null;
                if (z3 | z4) {
                    char[] cArr = new char[i6];
                    int iM10541c = m10541c();
                    for (int iM10559u3 = m10559u(iM10541c - 2); iM10559u3 > 0; iM10559u3--) {
                        String strM10558t = m10558t(iM10541c, cArr);
                        int iM10550l = m10550l(iM10541c + 2);
                        int i7 = iM10541c + 6;
                        if ("BootstrapMethods".equals(strM10558t)) {
                            int iM10559u4 = m10559u(i7);
                            int[] iArr2 = new int[iM10559u4];
                            int iM10559u5 = i7 + 2;
                            for (int i8 = 0; i8 < iM10559u4; i8++) {
                                iArr2[i8] = iM10559u5;
                                iM10559u5 += (m10559u(iM10559u5 + 2) * 2) + 4;
                            }
                            iArr = iArr2;
                        } else {
                            iM10541c = i7 + iM10550l;
                        }
                    }
                }
                this.f26159e = iArr;
                return;
            }
            int i9 = i5 + 1;
            int i10 = i4 + 1;
            this.f26156b[i5] = i10;
            switch (bArr[i4]) {
                case 1:
                    iM10559u2 = m10559u(i10) + 3;
                    if (iM10559u2 > i6) {
                        i6 = iM10559u2;
                    }
                    i2 = iM10559u2;
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
                    iM10559u2 = 9;
                    i9++;
                    i2 = iM10559u2;
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
                    i2 = iM10559u2;
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

    /* JADX INFO: renamed from: a */
    public final void m10539a(int i, C12427p[] c12427pArr) {
        if (c12427pArr[i] == null) {
            if (c12427pArr[i] == null) {
                c12427pArr[i] = new C12427p();
            }
            C12427p c12427p = c12427pArr[i];
            c12427p.f26249b = (short) (c12427p.f26249b | 1);
        }
    }

    /* JADX INFO: renamed from: b */
    public final C12427p m10540b(int i, C12427p[] c12427pArr) {
        if (c12427pArr[i] == null) {
            c12427pArr[i] = new C12427p();
        }
        C12427p c12427p = c12427pArr[i];
        c12427p.f26249b = (short) (c12427p.f26249b & (-2));
        return c12427p;
    }

    /* JADX INFO: renamed from: c */
    public final int m10541c() {
        int i = this.f26161g;
        int iM10559u = (m10559u(i + 6) * 2) + i + 8;
        int iM10559u2 = m10559u(iM10559u);
        int iM10550l = iM10559u + 2;
        while (true) {
            int i2 = iM10559u2 - 1;
            if (iM10559u2 <= 0) {
                break;
            }
            int iM10559u3 = m10559u(iM10550l + 6);
            iM10550l += 8;
            while (true) {
                int i3 = iM10559u3 - 1;
                if (iM10559u3 > 0) {
                    iM10550l += m10550l(iM10550l + 2) + 6;
                    iM10559u3 = i3;
                }
            }
            iM10559u2 = i2;
        }
        int iM10559u4 = m10559u(iM10550l);
        int iM10550l2 = iM10550l + 2;
        while (true) {
            int i4 = iM10559u4 - 1;
            if (iM10559u4 <= 0) {
                return iM10550l2 + 2;
            }
            int iM10559u5 = m10559u(iM10550l2 + 6);
            iM10550l2 += 8;
            while (true) {
                int i5 = iM10559u5 - 1;
                if (iM10559u5 > 0) {
                    iM10550l2 += m10550l(iM10550l2 + 2) + 6;
                    iM10559u5 = i5;
                }
            }
            iM10559u4 = i4;
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m10542d(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || m10544f(iArr[i]) < 67) {
            return -1;
        }
        return m10559u(iArr[i] + 1);
    }

    /* JADX INFO: renamed from: e */
    public final C12413b m10543e(C12413b[] c12413bArr, String str, int i, int i2, char[] cArr, int i3, C12427p[] c12427pArr) {
        for (C12413b c12413b : c12413bArr) {
            if (c12413b.f26148a.equals(str)) {
                C12413b c12413b2 = new C12413b(c12413b.f26148a);
                byte[] bArr = new byte[i2];
                c12413b2.f26149b = bArr;
                System.arraycopy(this.f26155a, i, bArr, 0, i2);
                return c12413b2;
            }
        }
        C12413b c12413b3 = new C12413b(str);
        byte[] bArr2 = new byte[i2];
        c12413b3.f26149b = bArr2;
        System.arraycopy(this.f26155a, i, bArr2, 0, i2);
        return c12413b3;
    }

    /* JADX INFO: renamed from: f */
    public int m10544f(int i) {
        return this.f26155a[i] & 255;
    }

    /* JADX INFO: renamed from: g */
    public String m10545g(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
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
    /* JADX INFO: renamed from: h */
    public final void m10546h(AbstractC12428q abstractC12428q, C12419h c12419h, int i) {
        C12427p[] c12427pArr;
        int i2;
        int i3;
        int[] iArr;
        String strM10558t;
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
        C12427p[] c12427pArr2;
        int i13;
        int iM10550l;
        int[] iArr4;
        C12427p[] c12427pArr3;
        int i14;
        int i15;
        C12429r c12429r;
        boolean z4;
        int i16;
        int i17;
        String strM10545g;
        String strM10558t2;
        String strM10558t3;
        boolean z5;
        int iM10559u;
        Object[] objArr;
        int i18;
        int i19;
        C12429r c12429r2;
        AbstractC12432u abstractC12432uM10629d;
        C12427p c12427p;
        int i20;
        int i21;
        int i22;
        C12429r c12429r3;
        AbstractC12432u abstractC12432uM10638m;
        C12427p c12427p2;
        int i23;
        boolean z6;
        int i24;
        C12427p c12427p3;
        int i25;
        int iM10542d;
        int i26;
        int i27;
        int i28;
        int i29;
        C12427p[] c12427pArr4;
        int i30;
        int iM10559u2;
        int iM10562x;
        short s2;
        int i31;
        int iM10559u3;
        int i32;
        int i33;
        int[] iArr5;
        C12427p[] c12427pArr5;
        int i34;
        C12427p[] c12427pArr6;
        int i35;
        int[] iArrM10557s;
        int i36;
        byte[] bArr = this.f26155a;
        char[] cArr = c12419h.f26196c;
        int iM10559u4 = m10559u(i);
        int iM10559u5 = m10559u(i + 2);
        int iM10550l2 = m10550l(i + 4);
        int i37 = i + 8;
        int i38 = i37 + iM10550l2;
        C12427p[] c12427pArr7 = new C12427p[iM10550l2 + 1];
        c12419h.f26200g = c12427pArr7;
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
                    m10540b(m10555q(i39 + 1) + i40, c12427pArr7);
                    i39 += 3;
                    break;
                case Opcodes.TABLESWITCH /* 170 */:
                    int i41 = (4 - (i40 & 3)) + i39;
                    m10540b(m10550l(i41) + i40, c12427pArr7);
                    int iM10550l3 = (m10550l(i41 + 8) - m10550l(i41 + 4)) + 1;
                    i36 = i41 + 12;
                    while (true) {
                        int i42 = iM10550l3 - 1;
                        if (iM10550l3 <= 0) {
                            i39 = i36;
                        } else {
                            m10540b(m10550l(i36) + i40, c12427pArr7);
                            i36 += 4;
                            iM10550l3 = i42;
                        }
                        break;
                    }
                    break;
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    int i43 = (4 - (i40 & 3)) + i39;
                    m10540b(m10550l(i43) + i40, c12427pArr7);
                    int iM10550l4 = m10550l(i43 + 4);
                    i36 = i43 + 8;
                    while (true) {
                        int i44 = iM10550l4 - 1;
                        if (iM10550l4 <= 0) {
                            i39 = i36;
                        } else {
                            m10540b(m10550l(i36 + 4) + i40, c12427pArr7);
                            i36 += 8;
                            iM10550l4 = i44;
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
                    m10540b(m10550l(i39 + 1) + i40, c12427pArr7);
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
                    m10540b(m10559u(i39 + 1) + i40, c12427pArr7);
                    i39 += 3;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iM10559u6 = m10559u(i39);
        int i46 = i39 + 2;
        while (true) {
            int i47 = iM10559u6 - 1;
            if (iM10559u6 > 0) {
                C12427p c12427pM10540b = m10540b(m10559u(i46), c12427pArr7);
                C12427p c12427pM10540b2 = m10540b(m10559u(i46 + 2), c12427pArr7);
                C12427p c12427pM10540b3 = m10540b(m10559u(i46 + 4), c12427pArr7);
                String strM10558t4 = m10558t(this.f26156b[m10559u(i46 + 6)], cArr);
                i46 += 8;
                C12429r c12429r4 = (C12429r) abstractC12428q;
                C12426o c12426o = new C12426o(c12427pM10540b, c12427pM10540b2, c12427pM10540b3, strM10558t4 != null ? c12429r4.f26293d.m10638m(7, strM10558t4).f26340a : 0, strM10558t4);
                if (c12429r4.f26302m == null) {
                    c12429r4.f26302m = c12426o;
                } else {
                    c12429r4.f26303n.f26247f = c12426o;
                }
                c12429r4.f26303n = c12426o;
                iM10559u6 = i47;
                i38 = i38;
            } else {
                int i48 = i38;
                int iM10559u7 = m10559u(i46);
                int i49 = i46 + 2;
                int[] iArr6 = null;
                boolean z7 = true;
                int i50 = 0;
                C12413b c12413b = null;
                int i51 = 0;
                int[] iArrM10557s2 = null;
                int i52 = 0;
                int i53 = 0;
                while (true) {
                    int i54 = iM10559u7 - 1;
                    if (iM10559u7 > 0) {
                        String strM10558t5 = m10558t(i49, cArr);
                        int iM10550l5 = m10550l(i49 + 2);
                        int i55 = i49 + 6;
                        if ("LocalVariableTable".equals(strM10558t5)) {
                            if ((c12419h.f26195b & 2) == 0) {
                                int iM10559u8 = m10559u(i55);
                                int i56 = i55 + 2;
                                while (true) {
                                    int i57 = iM10559u8 - 1;
                                    if (iM10559u8 > 0) {
                                        int iM10559u9 = m10559u(i56);
                                        m10539a(iM10559u9, c12427pArr7);
                                        m10539a(m10559u(i56 + 2) + iM10559u9, c12427pArr7);
                                        i56 += 10;
                                        iM10559u8 = i57;
                                    } else {
                                        i52 = i55;
                                        iArrM10557s = iArr6;
                                        c12427pArr5 = c12427pArr7;
                                        i34 = iM10550l2;
                                        iArr6 = iArrM10557s;
                                        c12427pArr6 = c12427pArr5;
                                        i35 = i34;
                                    }
                                }
                            }
                            iArr5 = iArr6;
                            c12427pArr5 = c12427pArr7;
                            i34 = iM10550l2;
                            iArrM10557s = iArr5;
                            iArr6 = iArrM10557s;
                            c12427pArr6 = c12427pArr5;
                            i35 = i34;
                        } else if ("LocalVariableTypeTable".equals(strM10558t5)) {
                            i53 = i55;
                            iArrM10557s = iArr6;
                            c12427pArr5 = c12427pArr7;
                            i34 = iM10550l2;
                            iArr6 = iArrM10557s;
                            c12427pArr6 = c12427pArr5;
                            i35 = i34;
                        } else if ("LineNumberTable".equals(strM10558t5)) {
                            if ((c12419h.f26195b & 2) == 0) {
                                int iM10559u10 = m10559u(i55);
                                int i58 = i55 + 2;
                                while (true) {
                                    int i59 = iM10559u10 - 1;
                                    if (iM10559u10 > 0) {
                                        int iM10559u11 = m10559u(i58);
                                        int iM10559u12 = m10559u(i58 + 2);
                                        int i60 = i58 + 4;
                                        m10539a(iM10559u11, c12427pArr7);
                                        C12427p c12427p4 = c12427pArr7[iM10559u11];
                                        if (c12427p4.f26250c == 0) {
                                            c12427p4.f26250c = (short) iM10559u12;
                                            i60 = i60;
                                            c12427pArr7 = c12427pArr7;
                                            iM10550l2 = iM10550l2;
                                        } else {
                                            if (c12427p4.f26251d == null) {
                                                c12427p4.f26251d = new int[4];
                                            }
                                            int[] iArr7 = c12427p4.f26251d;
                                            int i61 = iArr7[0] + 1;
                                            iArr7[0] = i61;
                                            if (i61 >= iArr7.length) {
                                                int[] iArr8 = new int[iArr7.length + 4];
                                                System.arraycopy(iArr7, 0, iArr8, 0, iArr7.length);
                                                c12427p4.f26251d = iArr8;
                                            }
                                            c12427p4.f26251d[i61] = iM10559u12;
                                        }
                                        iM10559u10 = i59;
                                        i58 = i60;
                                        iArr6 = iArr6;
                                        c12427pArr7 = c12427pArr7;
                                        iM10550l2 = iM10550l2;
                                    }
                                }
                            }
                            iArr5 = iArr6;
                            c12427pArr5 = c12427pArr7;
                            i34 = iM10550l2;
                            iArrM10557s = iArr5;
                            iArr6 = iArrM10557s;
                            c12427pArr6 = c12427pArr5;
                            i35 = i34;
                        } else {
                            iArr5 = iArr6;
                            c12427pArr5 = c12427pArr7;
                            i34 = iM10550l2;
                            if ("RuntimeVisibleTypeAnnotations".equals(strM10558t5)) {
                                iArrM10557s = m10557s(abstractC12428q, c12419h, i55, true);
                                iArr6 = iArrM10557s;
                                c12427pArr6 = c12427pArr5;
                                i35 = i34;
                            } else if ("RuntimeInvisibleTypeAnnotations".equals(strM10558t5)) {
                                iArrM10557s2 = m10557s(abstractC12428q, c12419h, i55, false);
                                iArrM10557s = iArr5;
                                iArr6 = iArrM10557s;
                                c12427pArr6 = c12427pArr5;
                                i35 = i34;
                            } else {
                                if ("StackMapTable".equals(strM10558t5)) {
                                    if ((c12419h.f26195b & 4) == 0) {
                                        i50 = i55 + 2;
                                        i51 = i55 + iM10550l5;
                                    }
                                } else if (!"StackMap".equals(strM10558t5)) {
                                    c12427pArr6 = c12427pArr5;
                                    i35 = i34;
                                    C12413b c12413bM10543e = m10543e(c12419h.f26194a, strM10558t5, i55, iM10550l5, cArr, i, c12427pArr6);
                                    c12413bM10543e.f26150c = c12413b;
                                    c12413b = c12413bM10543e;
                                    iArr6 = iArr5;
                                } else if ((c12419h.f26195b & 4) == 0) {
                                    i50 = i55 + 2;
                                    i51 = i55 + iM10550l5;
                                    iArr6 = iArr5;
                                    c12427pArr6 = c12427pArr5;
                                    i35 = i34;
                                    z7 = false;
                                }
                                iArrM10557s = iArr5;
                                iArr6 = iArrM10557s;
                                c12427pArr6 = c12427pArr5;
                                i35 = i34;
                            }
                        }
                        i49 = i55 + iM10550l5;
                        c12427pArr7 = c12427pArr6;
                        iM10559u7 = i54;
                        i48 = i48;
                        iM10550l2 = i35;
                    } else {
                        int[] iArr9 = iArr6;
                        C12427p[] c12427pArr8 = c12427pArr7;
                        int i62 = iM10550l2;
                        int i63 = i48;
                        C12413b c12413b2 = c12413b;
                        boolean z8 = (c12419h.f26195b & 8) != 0;
                        if (i50 != 0) {
                            c12419h.f26206m = -1;
                            c12419h.f26207n = 0;
                            c12419h.f26208o = 0;
                            c12419h.f26209p = 0;
                            Object[] objArr2 = new Object[iM10559u5];
                            c12419h.f26210q = objArr2;
                            c12419h.f26211r = 0;
                            c12419h.f26212s = new Object[iM10559u4];
                            if (z8) {
                                String str = c12419h.f26199f;
                                if ((c12419h.f26197d & 8) == 0) {
                                    if ("<init>".equals(c12419h.f26198e)) {
                                        objArr2[0] = InterfaceC12431t.f26339g;
                                    } else {
                                        objArr2[0] = m10545g(this.f26161g + 2, c12419h.f26196c);
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
                                        objArr2[i64] = InterfaceC12431t.f26335c;
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
                                        objArr2[i64] = InterfaceC12431t.f26334b;
                                    } else if (cCharAt == 'J') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = InterfaceC12431t.f26337e;
                                    } else if (cCharAt == 'Z') {
                                        i33 = i64 + 1;
                                        objArr2[i64] = InterfaceC12431t.f26334b;
                                    } else if (cCharAt != '[') {
                                        switch (cCharAt) {
                                            case 'B':
                                            case 'C':
                                                i33 = i64 + 1;
                                                objArr2[i64] = InterfaceC12431t.f26334b;
                                                break;
                                            case 'D':
                                                i33 = i64 + 1;
                                                objArr2[i64] = InterfaceC12431t.f26336d;
                                                break;
                                        }
                                        c12419h.f26208o = i64;
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
                                    if (bArr[i69] != 8 || (iM10559u3 = m10559u(i69 + 1)) < 0) {
                                        i31 = i62;
                                    } else {
                                        i31 = i62;
                                        if (iM10559u3 < i31) {
                                            if ((bArr[i37 + iM10559u3] & 255) == 187) {
                                                c12427pArr8 = c12427pArr8;
                                                m10540b(iM10559u3, c12427pArr8);
                                            } else {
                                                c12427pArr8 = c12427pArr8;
                                            }
                                        }
                                        i69++;
                                        c12427pArr8 = c12427pArr8;
                                        i62 = i31;
                                        i51 = i2;
                                    }
                                    i69++;
                                    c12427pArr8 = c12427pArr8;
                                    i62 = i31;
                                    i51 = i2;
                                } else {
                                    c12427pArr = c12427pArr8;
                                }
                            }
                        } else {
                            c12427pArr = c12427pArr8;
                            i2 = i51;
                        }
                        int i70 = i62;
                        if (!z8 || (c12419h.f26195b & 256) == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            abstractC12428q.mo10595c(-1, iM10559u5, null, 0, null);
                        }
                        int[] iArr10 = iArr9;
                        int iM10542d2 = m10542d(iArr10, i3);
                        int[] iArr11 = iArrM10557s2;
                        int iM10542d3 = m10542d(iArr11, i3);
                        int i71 = (c12419h.f26195b & 256) == 0 ? 33 : 0;
                        int i72 = iM10542d3;
                        int i73 = i37;
                        int i74 = i50;
                        int i75 = 0;
                        int i76 = 0;
                        int iM10542d4 = iM10542d2;
                        boolean z9 = false;
                        while (true) {
                            int i77 = i63;
                            if (i73 >= i77) {
                                int[] iArr12 = iArr10;
                                int i78 = iM10559u4;
                                int i79 = iM10559u5;
                                C12427p[] c12427pArr9 = c12427pArr;
                                int[] iArr13 = iArr11;
                                if (c12427pArr9[i70] != null) {
                                    abstractC12428q.mo10601i(c12427pArr9[i70]);
                                }
                                int i80 = i52;
                                if (i80 != 0 && (c12419h.f26195b & 2) == 0) {
                                    int i81 = i53;
                                    if (i81 != 0) {
                                        int iM10559u13 = m10559u(i81) * 3;
                                        int[] iArr14 = new int[iM10559u13];
                                        int i82 = i81 + 2;
                                        while (iM10559u13 > 0) {
                                            int i83 = iM10559u13 - 1;
                                            iArr14[i83] = i82 + 6;
                                            int i84 = i83 - 1;
                                            iArr14[i84] = m10559u(i82 + 8);
                                            iM10559u13 = i84 - 1;
                                            iArr14[iM10559u13] = m10559u(i82);
                                            i82 += 10;
                                        }
                                        iArr = iArr14;
                                    } else {
                                        iArr = null;
                                    }
                                    int iM10559u14 = m10559u(i80);
                                    int i85 = i80 + 2;
                                    while (true) {
                                        int i86 = iM10559u14 - 1;
                                        if (iM10559u14 > 0) {
                                            int iM10559u15 = m10559u(i85);
                                            int iM10559u16 = m10559u(i85 + 2);
                                            String strM10558t6 = m10558t(i85 + 4, cArr);
                                            String strM10558t7 = m10558t(i85 + 6, cArr);
                                            int iM10559u17 = m10559u(i85 + 8);
                                            int i87 = i85 + 10;
                                            if (iArr == null) {
                                                strM10558t = null;
                                                break;
                                                break;
                                            }
                                            int i88 = 0;
                                            while (true) {
                                                if (i88 >= iArr.length) {
                                                    strM10558t = null;
                                                    break;
                                                } else {
                                                    if (iArr[i88] == iM10559u15 && iArr[i88 + 1] == iM10559u17) {
                                                        strM10558t = m10558t(iArr[i88 + 2], cArr);
                                                        break;
                                                    }
                                                    i88 += 3;
                                                }
                                            }
                                            abstractC12428q.mo10604l(strM10558t6, strM10558t7, strM10558t, c12427pArr9[iM10559u15], c12427pArr9[iM10559u15 + iM10559u16], iM10559u17);
                                            iM10559u14 = i86;
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
                                        int iM10544f = m10544f(i91);
                                        if (iM10544f == 64 || iM10544f == i89) {
                                            int iM10556r = m10556r(c12419h, i91);
                                            m10549k(abstractC12428q.mo10605m(c12419h.f26201h, c12419h.f26202i, c12419h.f26203j, c12419h.f26204k, c12419h.f26205l, m10558t(iM10556r, cArr), true), iM10556r + 2, true, cArr);
                                        }
                                        i90++;
                                        c12413b2 = c12413b2;
                                        i89 = 65;
                                    }
                                }
                                C12413b c12413b3 = c12413b2;
                                if (iArr13 != null) {
                                    for (int i92 : iArr13) {
                                        int iM10544f2 = m10544f(i92);
                                        if (iM10544f2 == 64 || iM10544f2 == 65) {
                                            int iM10556r2 = m10556r(c12419h, i92);
                                            m10549k(abstractC12428q.mo10605m(c12419h.f26201h, c12419h.f26202i, c12419h.f26203j, c12419h.f26204k, c12419h.f26205l, m10558t(iM10556r2, cArr), false), iM10556r2 + 2, true, cArr);
                                        }
                                    }
                                }
                                C12413b c12413b4 = c12413b3;
                                while (c12413b4 != null) {
                                    C12413b c12413b5 = c12413b4.f26150c;
                                    c12413b4.f26150c = null;
                                    C12429r c12429r5 = (C12429r) abstractC12428q;
                                    c12413b4.f26150c = c12429r5.f26277M;
                                    c12429r5.f26277M = c12413b4;
                                    c12413b4 = c12413b5;
                                }
                                abstractC12428q.mo10606n(i78, i79);
                                return;
                            }
                            i63 = i77;
                            int i93 = i73 - i37;
                            int i94 = iM10559u4;
                            C12427p[] c12427pArr10 = c12427pArr;
                            C12427p c12427p5 = c12427pArr10[i93];
                            boolean z10 = z9;
                            if (c12427p5 == null) {
                                i4 = i73;
                            } else {
                                boolean z11 = (c12419h.f26195b & 2) == 0;
                                abstractC12428q.mo10601i(c12427p5);
                                if (!z11 || (s2 = c12427p5.f26250c) == 0) {
                                    i4 = i73;
                                } else {
                                    abstractC12428q.mo10603k(s2 & 65535, c12427p5);
                                    if (c12427p5.f26251d != null) {
                                        int i95 = 1;
                                        while (true) {
                                            int[] iArr15 = c12427p5.f26251d;
                                            i4 = i73;
                                            if (i95 <= iArr15[0]) {
                                                abstractC12428q.mo10603k(iArr15[i95], c12427p5);
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
                                int i97 = c12419h.f26206m;
                                if (i97 == i93 || i97 == -1) {
                                    if (i97 != -1) {
                                        if (!z7 || z8) {
                                            iArr11 = iArr11;
                                            iArr10 = iArr10;
                                            i26 = i96;
                                            abstractC12428q.mo10595c(-1, c12419h.f26208o, c12419h.f26210q, c12419h.f26211r, c12419h.f26212s);
                                        } else {
                                            i26 = i96;
                                            iArr11 = iArr11;
                                            iArr10 = iArr10;
                                            abstractC12428q.mo10595c(c12419h.f26207n, c12419h.f26209p, c12419h.f26210q, c12419h.f26211r, c12419h.f26212s);
                                        }
                                        z12 = false;
                                    } else {
                                        iArr11 = iArr11;
                                        iArr10 = iArr10;
                                        iM10559u5 = iM10559u5;
                                        i4 = i4;
                                        i26 = i96;
                                        z12 = z12;
                                    }
                                    if (i26 < i2) {
                                        char[] cArr2 = c12419h.f26196c;
                                        C12427p[] c12427pArr11 = c12419h.f26200g;
                                        if (z7) {
                                            i27 = i26 + 1;
                                            i29 = this.f26155a[i26] & 255;
                                            i28 = 0;
                                        } else {
                                            c12419h.f26206m = -1;
                                            i27 = i26;
                                            i28 = 0;
                                            i29 = 255;
                                        }
                                        c12419h.f26209p = i28;
                                        if (i29 < 64) {
                                            c12419h.f26207n = 3;
                                            c12419h.f26211r = i28;
                                            iM10562x = i27;
                                            c12427pArr4 = c12427pArr11;
                                            i30 = i2;
                                        } else {
                                            if (i29 < 128) {
                                                iM10559u2 = i29 - 64;
                                                i30 = i2;
                                                c12427pArr4 = c12427pArr11;
                                                iM10562x = m10562x(i27, c12419h.f26212s, 0, cArr2, c12427pArr4);
                                                c12419h.f26207n = 4;
                                                c12419h.f26211r = 1;
                                            } else {
                                                c12427pArr4 = c12427pArr11;
                                                i30 = i2;
                                                if (i29 < 247) {
                                                    throw new IllegalArgumentException();
                                                }
                                                iM10559u2 = m10559u(i27);
                                                int iM10562x2 = i27 + 2;
                                                if (i29 == 247) {
                                                    iM10562x = m10562x(iM10562x2, c12419h.f26212s, 0, cArr2, c12427pArr4);
                                                    c12419h.f26207n = 4;
                                                    c12419h.f26211r = 1;
                                                } else {
                                                    if (i29 >= 248 && i29 < 251) {
                                                        c12419h.f26207n = 2;
                                                        int i98 = 251 - i29;
                                                        c12419h.f26209p = i98;
                                                        c12419h.f26208o -= i98;
                                                        c12419h.f26211r = 0;
                                                    } else if (i29 == 251) {
                                                        c12419h.f26207n = 3;
                                                        c12419h.f26211r = 0;
                                                    } else if (i29 < 255) {
                                                        int i99 = i29 - 251;
                                                        int i100 = z8 ? c12419h.f26208o : 0;
                                                        int i101 = i99;
                                                        while (i101 > 0) {
                                                            iM10562x2 = m10562x(iM10562x2, c12419h.f26210q, i100, cArr2, c12427pArr4);
                                                            i101--;
                                                            i99 = i99;
                                                            i100++;
                                                            cArr2 = cArr2;
                                                        }
                                                        int i102 = i99;
                                                        c12419h.f26207n = 1;
                                                        c12419h.f26209p = i102;
                                                        c12419h.f26208o += i102;
                                                        c12419h.f26211r = 0;
                                                    } else {
                                                        int iM10559u18 = m10559u(iM10562x2);
                                                        int iM10562x3 = iM10562x2 + 2;
                                                        c12419h.f26207n = 0;
                                                        c12419h.f26209p = iM10559u18;
                                                        c12419h.f26208o = iM10559u18;
                                                        for (int i103 = 0; i103 < iM10559u18; i103++) {
                                                            iM10562x3 = m10562x(iM10562x3, c12419h.f26210q, i103, cArr2, c12427pArr4);
                                                        }
                                                        int iM10559u19 = m10559u(iM10562x3);
                                                        iM10562x2 = iM10562x3 + 2;
                                                        c12419h.f26211r = iM10559u19;
                                                        for (int i104 = 0; i104 < iM10559u19; i104++) {
                                                            iM10562x2 = m10562x(iM10562x2, c12419h.f26212s, i104, cArr2, c12427pArr4);
                                                        }
                                                    }
                                                    iM10562x = iM10562x2;
                                                }
                                            }
                                            i29 = iM10559u2;
                                        }
                                        int i105 = i29 + 1 + c12419h.f26206m;
                                        c12419h.f26206m = i105;
                                        m10540b(i105, c12427pArr4);
                                        i96 = iM10562x;
                                        i2 = i30;
                                    } else {
                                        i96 = 0;
                                    }
                                } else {
                                    iArr2 = iArr11;
                                    iArr3 = iArr10;
                                    i5 = i2;
                                    i6 = iM10559u5;
                                    i7 = i4;
                                    i8 = i96;
                                    if (z12) {
                                        if ((c12419h.f26195b & 8) != 0) {
                                            abstractC12428q.mo10595c(256, 0, null, 0, null);
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
                                            abstractC12428q.mo10597e(i9);
                                            i10 = i7 + 1;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null && i75 < iArr3.length && iM10542d4 <= i93) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r3 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r3, cArr), true), iM10556r3 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null && i25 < iArr2.length && iM10542d <= i93) {
                                                if (iM10542d == i93) {
                                                    int iM10556r4 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r4, cArr), false), iM10556r4 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 16:
                                        case Opcodes.NEWARRAY /* 188 */:
                                            abstractC12428q.mo10599g(i9, bArr[i7 + 1]);
                                            i10 = i7 + 2;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r5 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r5, cArr), true), iM10556r5 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r6 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r6, cArr), false), iM10556r6 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 17:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            abstractC12428q.mo10599g(i9, m10555q(i7 + 1));
                                            i10 = i7 + 3;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r7 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r7, cArr), true), iM10556r7 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r8 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r8, cArr), false), iM10556r8 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 18:
                                            abstractC12428q.mo10602j(m10547i(bArr[i7 + 1] & 255, cArr));
                                            i10 = i7 + 2;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r9 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r9, cArr), true), iM10556r9 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r10 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r10, cArr), false), iM10556r10 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 19:
                                        case 20:
                                            abstractC12428q.mo10602j(m10547i(m10559u(i7 + 1), cArr));
                                            i10 = i7 + 3;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r11 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11, cArr), true), iM10556r11 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r12 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r12, cArr), false), iM10556r12 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
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
                                            abstractC12428q.mo10612t(i9, bArr[i7 + 1] & 255);
                                            i10 = i7 + 2;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r13 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r13, cArr), true), iM10556r13 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r14 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r14, cArr), false), iM10556r14 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
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
                                            abstractC12428q.mo10612t((i106 >> 2) + 21, 3 & i106);
                                            i10 = i7 + 1;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r15 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r15, cArr), true), iM10556r15 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r16 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r16, cArr), false), iM10556r16 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
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
                                            abstractC12428q.mo10612t((i107 >> 2) + 54, 3 & i107);
                                            i10 = i7 + 1;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r17 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r17, cArr), true), iM10556r17 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r18 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r18, cArr), false), iM10556r18 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.IINC /* 132 */:
                                            abstractC12428q.mo10596d(bArr[i7 + 1] & 255, bArr[i7 + 2]);
                                            i10 = i7 + 3;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r19 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r19, cArr), true), iM10556r19 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r110 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r110, cArr), false), iM10556r110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
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
                                            abstractC12428q.mo10600h(i9, c12427pArr10[m10555q(i7 + 1) + i93]);
                                            i10 = i7 + 3;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r111 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111, cArr), true), iM10556r111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r112 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r112, cArr), false), iM10556r112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.TABLESWITCH /* 170 */:
                                            z8 = z8;
                                            z2 = z2;
                                            i8 = i8;
                                            int i108 = (4 - (i93 & 3)) + i7;
                                            C12427p c12427p6 = c12427pArr10[m10550l(i108) + i93];
                                            int iM10550l6 = m10550l(i108 + 4);
                                            int iM10550l7 = m10550l(i108 + 8);
                                            i11 = i108 + 12;
                                            i12 = (iM10550l7 - iM10550l6) + 1;
                                            c12427pArr2 = new C12427p[i12];
                                            for (i13 = 0; i13 < i12; i13++) {
                                                c12427pArr2[i13] = c12427pArr10[m10550l(i11) + i93];
                                                i11 += 4;
                                            }
                                            abstractC12428q.mo10609q(iM10550l6, iM10550l7, c12427p6, c12427pArr2);
                                            i10 = i11;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r113 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r113, cArr), true), iM10556r113 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r114 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r114, cArr), false), iM10556r114 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.LOOKUPSWITCH /* 171 */:
                                            z2 = z2;
                                            int i109 = (4 - (i93 & 3)) + i7;
                                            C12427p c12427p7 = c12427pArr10[m10550l(i109) + i93];
                                            iM10550l = m10550l(i109 + 4);
                                            iArr4 = new int[iM10550l];
                                            c12427pArr3 = new C12427p[iM10550l];
                                            i14 = i109 + 8;
                                            for (i15 = 0; i15 < iM10550l; i15++) {
                                                iArr4[i15] = m10550l(i14);
                                                c12427pArr3[i15] = c12427pArr10[m10550l(i14 + 4) + i93];
                                                i14 += 8;
                                            }
                                            c12429r = (C12429r) abstractC12428q;
                                            C12414c c12414c = c12429r.f26301l;
                                            c12429r.f26290Z = c12414c.f26154b;
                                            c12414c.m10535g(Opcodes.LOOKUPSWITCH);
                                            int i110 = i14;
                                            c12414c.m10536h(null, 0, (4 - (c12429r.f26301l.f26154b % 4)) % 4);
                                            z4 = true;
                                            c12427p7.m10591e(c12429r.f26301l, c12429r.f26290Z, true);
                                            c12429r.f26301l.m10537i(iM10550l);
                                            i16 = 0;
                                            while (i16 < iM10550l) {
                                                c12429r.f26301l.m10537i(iArr4[i16]);
                                                c12427pArr3[i16].m10591e(c12429r.f26301l, c12429r.f26290Z, z4);
                                                i16++;
                                                iM10550l = iM10550l;
                                                z4 = true;
                                            }
                                            c12429r.m10614B(c12427p7, c12427pArr3);
                                            i10 = i110;
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r115 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r115, cArr), true), iM10556r115 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r116 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r116, cArr), false), iM10556r116 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.GETSTATIC /* 178 */:
                                        case Opcodes.PUTSTATIC /* 179 */:
                                        case 180:
                                        case Opcodes.PUTFIELD /* 181 */:
                                        case Opcodes.INVOKEVIRTUAL /* 182 */:
                                        case Opcodes.INVOKESPECIAL /* 183 */:
                                        case Opcodes.INVOKESTATIC /* 184 */:
                                        case Opcodes.INVOKEINTERFACE /* 185 */:
                                            i17 = this.f26156b[m10559u(i7 + 1)];
                                            int i111 = this.f26156b[m10559u(i17 + 2)];
                                            strM10545g = m10545g(i17, cArr);
                                            strM10558t2 = m10558t(i111, cArr);
                                            strM10558t3 = m10558t(i111 + 2, cArr);
                                            if (i9 < 182) {
                                                abstractC12428q.mo10594b(i9, strM10545g, strM10558t2, strM10558t3);
                                            } else {
                                                if (bArr[i17 - 1] == 11) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                abstractC12428q.mo10608p(i9, strM10545g, strM10558t2, strM10558t3, z5);
                                            }
                                            if (i9 == 185) {
                                                i10 = i7 + 5;
                                            } else {
                                                i10 = i7 + 3;
                                            }
                                            iM10542d4 = iM10542d4;
                                            i75 = i75;
                                            z3 = z2;
                                            iArr3 = iArr3;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r117 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r117, cArr), true), iM10556r117 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r118 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r118, cArr), false), iM10556r118 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.INVOKEDYNAMIC /* 186 */:
                                            int i112 = this.f26156b[m10559u(i7 + 1)];
                                            int i113 = this.f26156b[m10559u(i112 + 2)];
                                            String strM10558t8 = m10558t(i113, cArr);
                                            String strM10558t9 = m10558t(i113 + 2, cArr);
                                            int i114 = this.f26159e[m10559u(i112)];
                                            C12425n c12425n = (C12425n) m10547i(m10559u(i114), cArr);
                                            iM10559u = m10559u(i114 + 2);
                                            objArr = new Object[iM10559u];
                                            i18 = i114 + 4;
                                            i19 = 0;
                                            while (i19 < iM10559u) {
                                                objArr[i19] = m10547i(m10559u(i18), cArr);
                                                i18 += 2;
                                                i19++;
                                                iM10559u = iM10559u;
                                            }
                                            c12429r2 = (C12429r) abstractC12428q;
                                            c12429r2.f26290Z = c12429r2.f26301l.f26154b;
                                            C12433v c12433v = c12429r2.f26293d;
                                            abstractC12432uM10629d = c12433v.m10629d(18, strM10558t8, strM10558t9, c12433v.m10626a(c12425n, objArr).f26340a);
                                            c12429r2.f26301l.m10533e(Opcodes.INVOKEDYNAMIC, abstractC12432uM10629d.f26340a);
                                            c12429r2.f26301l.m10538j(0);
                                            c12427p = c12429r2.f26281Q;
                                            if (c12427p != null) {
                                                i20 = c12429r2.f26278N;
                                                if (i20 != 4 || i20 == 3) {
                                                    c12427p.f26258k.mo10569b(Opcodes.INVOKEDYNAMIC, 0, abstractC12432uM10629d, c12429r2.f26293d);
                                                } else {
                                                    int iM10621a = abstractC12432uM10629d.m10621a();
                                                    int i115 = c12429r2.f26282R + ((iM10621a & 3) - (iM10621a >> 2)) + 1;
                                                    if (i115 > c12429r2.f26283S) {
                                                        c12429r2.f26283S = i115;
                                                    }
                                                    c12429r2.f26282R = i115;
                                                }
                                            }
                                            i10 = i7 + 5;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r119 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r119, cArr), true), iM10556r119 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r1110 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1110, cArr), false), iM10556r1110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.NEW /* 187 */:
                                        case Opcodes.ANEWARRAY /* 189 */:
                                        case Opcodes.CHECKCAST /* 192 */:
                                        case Opcodes.INSTANCEOF /* 193 */:
                                            abstractC12428q.mo10611s(i9, m10545g(i7 + 1, cArr));
                                            i10 = i7 + 3;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r1111 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111, cArr), true), iM10556r1111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r1112 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1112, cArr), false), iM10556r1112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 196:
                                            i21 = bArr[i7 + 1] & 255;
                                            if (i21 == 132) {
                                                abstractC12428q.mo10596d(m10559u(i7 + 2), m10555q(i7 + 4));
                                                i10 = i7 + 6;
                                            } else {
                                                abstractC12428q.mo10612t(i21, m10559u(i7 + 2));
                                                i10 = i7 + 4;
                                            }
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r1113 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1113, cArr), true), iM10556r1113 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r1114 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1114, cArr), false), iM10556r1114 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case Opcodes.MULTIANEWARRAY /* 197 */:
                                            String strM10545g2 = m10545g(i7 + 1, cArr);
                                            i22 = bArr[i7 + 3] & 255;
                                            c12429r3 = (C12429r) abstractC12428q;
                                            c12429r3.f26290Z = c12429r3.f26301l.f26154b;
                                            abstractC12432uM10638m = c12429r3.f26293d.m10638m(7, strM10545g2);
                                            C12414c c12414c2 = c12429r3.f26301l;
                                            c12414c2.m10533e(Opcodes.MULTIANEWARRAY, abstractC12432uM10638m.f26340a);
                                            c12414c2.m10535g(i22);
                                            c12427p2 = c12429r3.f26281Q;
                                            if (c12427p2 != null) {
                                                i23 = c12429r3.f26278N;
                                                if (i23 != 4 || i23 == 3) {
                                                    c12427p2.f26258k.mo10569b(Opcodes.MULTIANEWARRAY, i22, abstractC12432uM10638m, c12429r3.f26293d);
                                                } else {
                                                    c12429r3.f26282R = (1 - i22) + c12429r3.f26282R;
                                                }
                                            }
                                            i10 = i7 + 4;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r1115 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1115, cArr), true), iM10556r1115 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r1116 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1116, cArr), false), iM10556r1116 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 200:
                                        case 201:
                                            abstractC12428q.mo10600h(i9 - i71, c12427pArr10[m10550l(i7 + 1) + i93]);
                                            i10 = i7 + 5;
                                            z6 = z2;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r1117 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1117, cArr), true), iM10556r1117 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r1118 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1118, cArr), false), iM10556r1118 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
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
                                            c12427p3 = c12427pArr10[m10559u(i7 + 1) + i93];
                                            if (i24 != 167 || i24 == 168) {
                                                abstractC12428q.mo10600h(i24 + 33, c12427p3);
                                                z6 = z2;
                                            } else {
                                                abstractC12428q.mo10600h(i24 < 167 ? ((i24 + 1) ^ 1) - 1 : i24 ^ 1, m10540b(i93 + 3, c12427pArr10));
                                                abstractC12428q.mo10600h(200, c12427p3);
                                                z6 = true;
                                            }
                                            i10 = i7 + 3;
                                            z8 = z8;
                                            z3 = z6;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r1119 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1119, cArr), true), iM10556r1119 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r11110 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11110, cArr), false), iM10556r11110 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        case 220:
                                            abstractC12428q.mo10600h(200, c12427pArr10[m10550l(i7 + 1) + i93]);
                                            i10 = i7 + 5;
                                            z8 = z8;
                                            z3 = true;
                                            while (iArr3 != null) {
                                                if (iM10542d4 == i93) {
                                                    int iM10556r11111 = m10556r(c12419h, iArr3[i75]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111, cArr), true), iM10556r11111 + 2, true, cArr);
                                                }
                                                i75++;
                                                iM10542d4 = m10542d(iArr3, i75);
                                            }
                                            i25 = i76;
                                            iM10542d = i72;
                                            while (iArr2 != null) {
                                                if (iM10542d == i93) {
                                                    int iM10556r11112 = m10556r(c12419h, iArr2[i25]);
                                                    m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11112, cArr), false), iM10556r11112 + 2, true, cArr);
                                                }
                                                i25++;
                                                iM10542d = m10542d(iArr2, i25);
                                                z3 = z3;
                                                i10 = i10;
                                                i93 = i93;
                                            }
                                            z9 = z3;
                                            i76 = i25;
                                            i72 = iM10542d;
                                            i75 = i75;
                                            iArr10 = iArr3;
                                            c12427pArr = c12427pArr10;
                                            i73 = i10;
                                            iM10559u4 = i94;
                                            z8 = z8;
                                            i2 = i5;
                                            i74 = i8;
                                            iM10542d4 = iM10542d4;
                                            iArr11 = iArr2;
                                            iM10559u5 = i6;
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            iArr2 = iArr11;
                            iArr3 = iArr10;
                            i5 = i2;
                            i6 = iM10559u5;
                            i7 = i4;
                            i8 = i96;
                            if (z12) {
                                if ((c12419h.f26195b & 8) != 0) {
                                    abstractC12428q.mo10595c(256, 0, null, 0, null);
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
                                    abstractC12428q.mo10597e(i9);
                                    i10 = i7 + 1;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11113 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11113, cArr), true), iM10556r11113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11114 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11114, cArr), false), iM10556r11114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 16:
                                case Opcodes.NEWARRAY /* 188 */:
                                    abstractC12428q.mo10599g(i9, bArr[i7 + 1]);
                                    i10 = i7 + 2;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11115 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11115, cArr), true), iM10556r11115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11116 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11116, cArr), false), iM10556r11116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 17:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    abstractC12428q.mo10599g(i9, m10555q(i7 + 1));
                                    i10 = i7 + 3;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11117 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11117, cArr), true), iM10556r11117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11118 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11118, cArr), false), iM10556r11118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 18:
                                    abstractC12428q.mo10602j(m10547i(bArr[i7 + 1] & 255, cArr));
                                    i10 = i7 + 2;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11119 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11119, cArr), true), iM10556r11119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111110 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111110, cArr), false), iM10556r111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 19:
                                case 20:
                                    abstractC12428q.mo10602j(m10547i(m10559u(i7 + 1), cArr));
                                    i10 = i7 + 3;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111111 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111111, cArr), true), iM10556r111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111112 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111112, cArr), false), iM10556r111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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
                                    abstractC12428q.mo10612t(i9, bArr[i7 + 1] & 255);
                                    i10 = i7 + 2;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111113 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111113, cArr), true), iM10556r111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111114 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111114, cArr), false), iM10556r111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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
                                    abstractC12428q.mo10612t((i1010 >> 2) + 21, 3 & i1010);
                                    i10 = i7 + 1;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111115 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111115, cArr), true), iM10556r111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111116 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111116, cArr), false), iM10556r111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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
                                    abstractC12428q.mo10612t((i1011 >> 2) + 54, 3 & i1011);
                                    i10 = i7 + 1;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111117 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111117, cArr), true), iM10556r111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111118 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111118, cArr), false), iM10556r111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.IINC /* 132 */:
                                    abstractC12428q.mo10596d(bArr[i7 + 1] & 255, bArr[i7 + 2]);
                                    i10 = i7 + 3;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111119 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111119, cArr), true), iM10556r111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r1111110 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111110, cArr), false), iM10556r1111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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
                                    abstractC12428q.mo10600h(i9, c12427pArr10[m10555q(i7 + 1) + i93]);
                                    i10 = i7 + 3;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r1111111 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111111, cArr), true), iM10556r1111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r1111112 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111112, cArr), false), iM10556r1111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.TABLESWITCH /* 170 */:
                                    z8 = z8;
                                    z2 = z2;
                                    i8 = i8;
                                    int i1012 = (4 - (i93 & 3)) + i7;
                                    C12427p c12427p8 = c12427pArr10[m10550l(i1012) + i93];
                                    int iM10550l8 = m10550l(i1012 + 4);
                                    int iM10550l9 = m10550l(i1012 + 8);
                                    i11 = i1012 + 12;
                                    i12 = (iM10550l9 - iM10550l8) + 1;
                                    c12427pArr2 = new C12427p[i12];
                                    while (i13 < i12) {
                                        c12427pArr2[i13] = c12427pArr10[m10550l(i11) + i93];
                                        i11 += 4;
                                    }
                                    abstractC12428q.mo10609q(iM10550l8, iM10550l9, c12427p8, c12427pArr2);
                                    i10 = i11;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r1111113 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111113, cArr), true), iM10556r1111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r1111114 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111114, cArr), false), iM10556r1111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.LOOKUPSWITCH /* 171 */:
                                    z2 = z2;
                                    int i1013 = (4 - (i93 & 3)) + i7;
                                    C12427p c12427p9 = c12427pArr10[m10550l(i1013) + i93];
                                    iM10550l = m10550l(i1013 + 4);
                                    iArr4 = new int[iM10550l];
                                    c12427pArr3 = new C12427p[iM10550l];
                                    i14 = i1013 + 8;
                                    while (i15 < iM10550l) {
                                        iArr4[i15] = m10550l(i14);
                                        c12427pArr3[i15] = c12427pArr10[m10550l(i14 + 4) + i93];
                                        i14 += 8;
                                    }
                                    c12429r = (C12429r) abstractC12428q;
                                    C12414c c12414c3 = c12429r.f26301l;
                                    c12429r.f26290Z = c12414c3.f26154b;
                                    c12414c3.m10535g(Opcodes.LOOKUPSWITCH);
                                    int i116 = i14;
                                    c12414c3.m10536h(null, 0, (4 - (c12429r.f26301l.f26154b % 4)) % 4);
                                    z4 = true;
                                    c12427p9.m10591e(c12429r.f26301l, c12429r.f26290Z, true);
                                    c12429r.f26301l.m10537i(iM10550l);
                                    i16 = 0;
                                    while (i16 < iM10550l) {
                                        c12429r.f26301l.m10537i(iArr4[i16]);
                                        c12427pArr3[i16].m10591e(c12429r.f26301l, c12429r.f26290Z, z4);
                                        i16++;
                                        iM10550l = iM10550l;
                                        z4 = true;
                                    }
                                    c12429r.m10614B(c12427p9, c12427pArr3);
                                    i10 = i116;
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r1111115 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111115, cArr), true), iM10556r1111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r1111116 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111116, cArr), false), iM10556r1111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.GETSTATIC /* 178 */:
                                case Opcodes.PUTSTATIC /* 179 */:
                                case 180:
                                case Opcodes.PUTFIELD /* 181 */:
                                case Opcodes.INVOKEVIRTUAL /* 182 */:
                                case Opcodes.INVOKESPECIAL /* 183 */:
                                case Opcodes.INVOKESTATIC /* 184 */:
                                case Opcodes.INVOKEINTERFACE /* 185 */:
                                    i17 = this.f26156b[m10559u(i7 + 1)];
                                    int i117 = this.f26156b[m10559u(i17 + 2)];
                                    strM10545g = m10545g(i17, cArr);
                                    strM10558t2 = m10558t(i117, cArr);
                                    strM10558t3 = m10558t(i117 + 2, cArr);
                                    if (i9 < 182) {
                                        abstractC12428q.mo10594b(i9, strM10545g, strM10558t2, strM10558t3);
                                    } else {
                                        if (bArr[i17 - 1] == 11) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        abstractC12428q.mo10608p(i9, strM10545g, strM10558t2, strM10558t3, z5);
                                    }
                                    if (i9 == 185) {
                                        i10 = i7 + 5;
                                    } else {
                                        i10 = i7 + 3;
                                    }
                                    iM10542d4 = iM10542d4;
                                    i75 = i75;
                                    z3 = z2;
                                    iArr3 = iArr3;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r1111117 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111117, cArr), true), iM10556r1111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r1111118 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111118, cArr), false), iM10556r1111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.INVOKEDYNAMIC /* 186 */:
                                    int i118 = this.f26156b[m10559u(i7 + 1)];
                                    int i119 = this.f26156b[m10559u(i118 + 2)];
                                    String strM10558t10 = m10558t(i119, cArr);
                                    String strM10558t11 = m10558t(i119 + 2, cArr);
                                    int i1110 = this.f26159e[m10559u(i118)];
                                    C12425n c12425n2 = (C12425n) m10547i(m10559u(i1110), cArr);
                                    iM10559u = m10559u(i1110 + 2);
                                    objArr = new Object[iM10559u];
                                    i18 = i1110 + 4;
                                    i19 = 0;
                                    while (i19 < iM10559u) {
                                        objArr[i19] = m10547i(m10559u(i18), cArr);
                                        i18 += 2;
                                        i19++;
                                        iM10559u = iM10559u;
                                    }
                                    c12429r2 = (C12429r) abstractC12428q;
                                    c12429r2.f26290Z = c12429r2.f26301l.f26154b;
                                    C12433v c12433v2 = c12429r2.f26293d;
                                    abstractC12432uM10629d = c12433v2.m10629d(18, strM10558t10, strM10558t11, c12433v2.m10626a(c12425n2, objArr).f26340a);
                                    c12429r2.f26301l.m10533e(Opcodes.INVOKEDYNAMIC, abstractC12432uM10629d.f26340a);
                                    c12429r2.f26301l.m10538j(0);
                                    c12427p = c12429r2.f26281Q;
                                    if (c12427p != null) {
                                        i20 = c12429r2.f26278N;
                                        if (i20 != 4) {
                                            c12427p.f26258k.mo10569b(Opcodes.INVOKEDYNAMIC, 0, abstractC12432uM10629d, c12429r2.f26293d);
                                        } else {
                                            c12427p.f26258k.mo10569b(Opcodes.INVOKEDYNAMIC, 0, abstractC12432uM10629d, c12429r2.f26293d);
                                        }
                                    }
                                    i10 = i7 + 5;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r1111119 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r1111119, cArr), true), iM10556r1111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11111110 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111110, cArr), false), iM10556r11111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.NEW /* 187 */:
                                case Opcodes.ANEWARRAY /* 189 */:
                                case Opcodes.CHECKCAST /* 192 */:
                                case Opcodes.INSTANCEOF /* 193 */:
                                    abstractC12428q.mo10611s(i9, m10545g(i7 + 1, cArr));
                                    i10 = i7 + 3;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11111111 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111111, cArr), true), iM10556r11111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11111112 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111112, cArr), false), iM10556r11111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 196:
                                    i21 = bArr[i7 + 1] & 255;
                                    if (i21 == 132) {
                                        abstractC12428q.mo10596d(m10559u(i7 + 2), m10555q(i7 + 4));
                                        i10 = i7 + 6;
                                    } else {
                                        abstractC12428q.mo10612t(i21, m10559u(i7 + 2));
                                        i10 = i7 + 4;
                                    }
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11111113 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111113, cArr), true), iM10556r11111113 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11111114 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111114, cArr), false), iM10556r11111114 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case Opcodes.MULTIANEWARRAY /* 197 */:
                                    String strM10545g3 = m10545g(i7 + 1, cArr);
                                    i22 = bArr[i7 + 3] & 255;
                                    c12429r3 = (C12429r) abstractC12428q;
                                    c12429r3.f26290Z = c12429r3.f26301l.f26154b;
                                    abstractC12432uM10638m = c12429r3.f26293d.m10638m(7, strM10545g3);
                                    C12414c c12414c4 = c12429r3.f26301l;
                                    c12414c4.m10533e(Opcodes.MULTIANEWARRAY, abstractC12432uM10638m.f26340a);
                                    c12414c4.m10535g(i22);
                                    c12427p2 = c12429r3.f26281Q;
                                    if (c12427p2 != null) {
                                        i23 = c12429r3.f26278N;
                                        if (i23 != 4) {
                                            c12427p2.f26258k.mo10569b(Opcodes.MULTIANEWARRAY, i22, abstractC12432uM10638m, c12429r3.f26293d);
                                        } else {
                                            c12427p2.f26258k.mo10569b(Opcodes.MULTIANEWARRAY, i22, abstractC12432uM10638m, c12429r3.f26293d);
                                        }
                                    }
                                    i10 = i7 + 4;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11111115 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111115, cArr), true), iM10556r11111115 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11111116 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111116, cArr), false), iM10556r11111116 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 200:
                                case 201:
                                    abstractC12428q.mo10600h(i9 - i71, c12427pArr10[m10550l(i7 + 1) + i93]);
                                    i10 = i7 + 5;
                                    z6 = z2;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11111117 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111117, cArr), true), iM10556r11111117 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r11111118 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111118, cArr), false), iM10556r11111118 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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
                                    c12427p3 = c12427pArr10[m10559u(i7 + 1) + i93];
                                    if (i24 != 167) {
                                        abstractC12428q.mo10600h(i24 + 33, c12427p3);
                                        z6 = z2;
                                    } else {
                                        abstractC12428q.mo10600h(i24 + 33, c12427p3);
                                        z6 = z2;
                                    }
                                    i10 = i7 + 3;
                                    z8 = z8;
                                    z3 = z6;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r11111119 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r11111119, cArr), true), iM10556r11111119 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111111110 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111111110, cArr), false), iM10556r111111110 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
                                    break;
                                case 220:
                                    abstractC12428q.mo10600h(200, c12427pArr10[m10550l(i7 + 1) + i93]);
                                    i10 = i7 + 5;
                                    z8 = z8;
                                    z3 = true;
                                    while (iArr3 != null) {
                                        if (iM10542d4 == i93) {
                                            int iM10556r111111111 = m10556r(c12419h, iArr3[i75]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111111111, cArr), true), iM10556r111111111 + 2, true, cArr);
                                        }
                                        i75++;
                                        iM10542d4 = m10542d(iArr3, i75);
                                    }
                                    i25 = i76;
                                    iM10542d = i72;
                                    while (iArr2 != null) {
                                        if (iM10542d == i93) {
                                            int iM10556r111111112 = m10556r(c12419h, iArr2[i25]);
                                            m10549k(abstractC12428q.mo10598f(c12419h.f26201h, c12419h.f26202i, m10558t(iM10556r111111112, cArr), false), iM10556r111111112 + 2, true, cArr);
                                        }
                                        i25++;
                                        iM10542d = m10542d(iArr2, i25);
                                        z3 = z3;
                                        i10 = i10;
                                        i93 = i93;
                                    }
                                    z9 = z3;
                                    i76 = i25;
                                    i72 = iM10542d;
                                    i75 = i75;
                                    iArr10 = iArr3;
                                    c12427pArr = c12427pArr10;
                                    i73 = i10;
                                    iM10559u4 = i94;
                                    z8 = z8;
                                    i2 = i5;
                                    i74 = i8;
                                    iM10542d4 = iM10542d4;
                                    iArr11 = iArr2;
                                    iM10559u5 = i6;
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

    /* JADX INFO: renamed from: i */
    public Object m10547i(int i, char[] cArr) {
        int[] iArr = this.f26156b;
        int i2 = iArr[i];
        byte b2 = this.f26155a[i2 - 1];
        switch (b2) {
            case 3:
                return Integer.valueOf(m10550l(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(m10550l(i2)));
            case 5:
                return Long.valueOf(m10551m(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(m10551m(i2)));
            case 7:
                return C12434w.m10647h(m10558t(i2, cArr));
            case 8:
                return m10558t(i2, cArr);
            default:
                switch (b2) {
                    case 15:
                        int iM10544f = m10544f(i2);
                        int i3 = this.f26156b[m10559u(i2 + 1)];
                        int i4 = this.f26156b[m10559u(i3 + 2)];
                        return new C12425n(iM10544f, m10545g(i3, cArr), m10558t(i4, cArr), m10558t(i4 + 2, cArr), this.f26155a[i3 - 1] == 11);
                    case 16:
                        String strM10558t = m10558t(i2, cArr);
                        return new C12434w(11, strM10558t, 0, strM10558t.length());
                    case 17:
                        C12418g c12418g = this.f26158d[i];
                        if (c12418g != null) {
                            return c12418g;
                        }
                        int i5 = iArr[i];
                        int i6 = iArr[m10559u(i5 + 2)];
                        String strM10558t2 = m10558t(i6, cArr);
                        String strM10558t3 = m10558t(i6 + 2, cArr);
                        int i7 = this.f26159e[m10559u(i5)];
                        C12425n c12425n = (C12425n) m10547i(m10559u(i7), cArr);
                        int iM10559u = m10559u(i7 + 2);
                        Object[] objArr = new Object[iM10559u];
                        int i8 = i7 + 4;
                        for (int i9 = 0; i9 < iM10559u; i9++) {
                            objArr[i9] = m10547i(m10559u(i8), cArr);
                            i8 += 2;
                        }
                        C12418g[] c12418gArr = this.f26158d;
                        C12418g c12418g2 = new C12418g(strM10558t2, strM10558t3, c12425n, objArr);
                        c12418gArr[i] = c12418g2;
                        return c12418g2;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:99:0x0235  */
    /* JADX INFO: renamed from: j */
    public final int m10548j(C12412a c12412a, int i, String str, char[] cArr) {
        int i2 = 0;
        if (c12412a == null) {
            int i3 = this.f26155a[i] & 255;
            if (i3 == 64) {
                return m10549k(null, i + 3, true, cArr);
            }
            if (i3 != 91) {
                return i3 != 101 ? i + 3 : i + 5;
            }
            return m10549k(null, i + 1, false, cArr);
        }
        int i4 = i + 1;
        int i5 = this.f26155a[i] & 255;
        if (i5 == 64) {
            String strM10558t = m10558t(i4, cArr);
            c12412a.f26145e++;
            if (c12412a.f26142b) {
                c12412a.f26143c.m10538j(c12412a.f26141a.m10637l(str));
            }
            C12414c c12414c = c12412a.f26143c;
            c12414c.m10533e(64, c12412a.f26141a.m10637l(strM10558t));
            c12414c.m10538j(0);
            return m10549k(new C12412a(c12412a.f26141a, true, c12412a.f26143c, null), i4 + 2, true, cArr);
        }
        if (i5 == 70) {
            c12412a.m10520e(str, m10547i(m10559u(i4), cArr));
        } else if (i5 == 83) {
            c12412a.m10520e(str, Short.valueOf((short) m10550l(this.f26156b[m10559u(i4)])));
        } else if (i5 == 99) {
            String strM10558t2 = m10558t(i4, cArr);
            c12412a.m10520e(str, C12434w.m10649k(strM10558t2, 0, strM10558t2.length()));
        } else {
            if (i5 == 101) {
                String strM10558t3 = m10558t(i4, cArr);
                String strM10558t4 = m10558t(i4 + 2, cArr);
                c12412a.f26145e++;
                if (c12412a.f26142b) {
                    c12412a.f26143c.m10538j(c12412a.f26141a.m10637l(str));
                }
                C12414c c12414c2 = c12412a.f26143c;
                c12414c2.m10533e(101, c12412a.f26141a.m10637l(strM10558t3));
                c12414c2.m10538j(c12412a.f26141a.m10637l(strM10558t4));
                return i4 + 4;
            }
            if (i5 == 115) {
                c12412a.m10520e(str, m10558t(i4, cArr));
            } else if (i5 == 73 || i5 == 74) {
                c12412a.m10520e(str, m10547i(m10559u(i4), cArr));
            } else if (i5 == 90) {
                c12412a.m10520e(str, m10550l(this.f26156b[m10559u(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
            } else {
                if (i5 == 91) {
                    int iM10559u = m10559u(i4);
                    int i6 = i4 + 2;
                    if (iM10559u == 0) {
                        return m10549k(c12412a.m10521f(str), i6 - 2, false, cArr);
                    }
                    int i7 = this.f26155a[i6] & 255;
                    if (i7 == 70) {
                        float[] fArr = new float[iM10559u];
                        while (i2 < iM10559u) {
                            fArr[i2] = Float.intBitsToFloat(m10550l(this.f26156b[m10559u(i6 + 1)]));
                            i6 += 3;
                            i2++;
                        }
                        c12412a.m10520e(str, fArr);
                        return i6;
                    }
                    if (i7 == 83) {
                        short[] sArr = new short[iM10559u];
                        while (i2 < iM10559u) {
                            sArr[i2] = (short) m10550l(this.f26156b[m10559u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        c12412a.m10520e(str, sArr);
                        return i6;
                    }
                    if (i7 == 90) {
                        boolean[] zArr = new boolean[iM10559u];
                        for (int i8 = 0; i8 < iM10559u; i8++) {
                            zArr[i8] = m10550l(this.f26156b[m10559u(i6 + 1)]) != 0;
                            i6 += 3;
                        }
                        c12412a.m10520e(str, zArr);
                        return i6;
                    }
                    if (i7 == 73) {
                        int[] iArr = new int[iM10559u];
                        while (i2 < iM10559u) {
                            iArr[i2] = m10550l(this.f26156b[m10559u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        c12412a.m10520e(str, iArr);
                        return i6;
                    }
                    if (i7 == 74) {
                        long[] jArr = new long[iM10559u];
                        while (i2 < iM10559u) {
                            jArr[i2] = m10551m(this.f26156b[m10559u(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        c12412a.m10520e(str, jArr);
                        return i6;
                    }
                    switch (i7) {
                        case 66:
                            byte[] bArr = new byte[iM10559u];
                            while (i2 < iM10559u) {
                                bArr[i2] = (byte) m10550l(this.f26156b[m10559u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            c12412a.m10520e(str, bArr);
                            return i6;
                        case 67:
                            char[] cArr2 = new char[iM10559u];
                            while (i2 < iM10559u) {
                                cArr2[i2] = (char) m10550l(this.f26156b[m10559u(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            c12412a.m10520e(str, cArr2);
                            return i6;
                        case 68:
                            double[] dArr = new double[iM10559u];
                            while (i2 < iM10559u) {
                                dArr[i2] = Double.longBitsToDouble(m10551m(this.f26156b[m10559u(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            c12412a.m10520e(str, dArr);
                            return i6;
                        default:
                            return m10549k(c12412a.m10521f(str), i6 - 2, false, cArr);
                    }
                }
                switch (i5) {
                    case 66:
                        c12412a.m10520e(str, Byte.valueOf((byte) m10550l(this.f26156b[m10559u(i4)])));
                        break;
                    case 67:
                        c12412a.m10520e(str, Character.valueOf((char) m10550l(this.f26156b[m10559u(i4)])));
                        break;
                    case 68:
                        c12412a.m10520e(str, m10547i(m10559u(i4), cArr));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return i4 + 2;
    }

    /* JADX INFO: renamed from: k */
    public final int m10549k(C12412a c12412a, int i, boolean z2, char[] cArr) {
        int iM10559u = m10559u(i);
        int iM10548j = i + 2;
        if (!z2) {
            while (true) {
                int i2 = iM10559u - 1;
                if (iM10559u <= 0) {
                    break;
                }
                iM10548j = m10548j(c12412a, iM10548j, null, cArr);
                iM10559u = i2;
            }
        } else {
            while (true) {
                int i3 = iM10559u - 1;
                if (iM10559u <= 0) {
                    break;
                }
                iM10548j = m10548j(c12412a, iM10548j + 2, m10558t(iM10548j, cArr), cArr);
                iM10559u = i3;
            }
        }
        if (c12412a != null) {
            c12412a.m10522g();
        }
        return iM10548j;
    }

    /* JADX INFO: renamed from: l */
    public int m10550l(int i) {
        byte[] bArr = this.f26155a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX INFO: renamed from: m */
    public long m10551m(int i) {
        return (((long) m10550l(i)) << 32) | (((long) m10550l(i + 4)) & 4294967295L);
    }

    /* JADX INFO: renamed from: n */
    public String m10552n(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
    }

    /* JADX INFO: renamed from: o */
    public String m10553o(int i, char[] cArr) {
        return m10558t(this.f26156b[m10559u(i)], cArr);
    }

    /* JADX INFO: renamed from: p */
    public final void m10554p(AbstractC12428q abstractC12428q, C12419h c12419h, int i, boolean z2) {
        C12412a c12412a;
        int iM10549k = i + 1;
        int i2 = this.f26155a[i] & 255;
        C12429r c12429r = (C12429r) abstractC12428q;
        if (z2) {
            c12429r.f26268D = i2;
        } else {
            c12429r.f26270F = i2;
        }
        char[] cArr = c12419h.f26196c;
        for (int i3 = 0; i3 < i2; i3++) {
            int iM10559u = m10559u(iM10549k);
            iM10549k += 2;
            while (true) {
                int i4 = iM10559u - 1;
                if (iM10559u > 0) {
                    String strM10558t = m10558t(iM10549k, cArr);
                    int i5 = iM10549k + 2;
                    C12414c c12414c = new C12414c();
                    c12414c.m10538j(c12429r.f26293d.m10637l(strM10558t));
                    c12414c.m10538j(0);
                    if (z2) {
                        if (c12429r.f26269E == null) {
                            c12429r.f26269E = new C12412a[C12434w.m10644a(c12429r.f26298i).length];
                        }
                        C12412a[] c12412aArr = c12429r.f26269E;
                        c12412a = new C12412a(c12429r.f26293d, true, c12414c, c12412aArr[i3]);
                        c12412aArr[i3] = c12412a;
                    } else {
                        if (c12429r.f26271G == null) {
                            c12429r.f26271G = new C12412a[C12434w.m10644a(c12429r.f26298i).length];
                        }
                        C12412a[] c12412aArr2 = c12429r.f26271G;
                        c12412a = new C12412a(c12429r.f26293d, true, c12414c, c12412aArr2[i3]);
                        c12412aArr2[i3] = c12412a;
                    }
                    iM10549k = m10549k(c12412a, i5, true, cArr);
                    iM10559u = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public short m10555q(int i) {
        byte[] bArr = this.f26155a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    /* JADX INFO: renamed from: r */
    public final int m10556r(C12419h c12419h, int i) {
        int i2;
        int i3;
        int iM10550l = m10550l(i);
        int i4 = iM10550l >>> 24;
        if (i4 != 0 && i4 != 1) {
            switch (i4) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = iM10550l & InputDeviceCompat.SOURCE_ANY;
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                    i3 = i + 1;
                    break;
                case 22:
                    i2 = iM10550l & (-65536);
                    i3 = i + 2;
                    break;
                default:
                    switch (i4) {
                        case 64:
                        case 65:
                            i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                            int iM10559u = m10559u(i + 1);
                            i3 = i + 3;
                            c12419h.f26203j = new C12427p[iM10559u];
                            c12419h.f26204k = new C12427p[iM10559u];
                            c12419h.f26205l = new int[iM10559u];
                            for (int i5 = 0; i5 < iM10559u; i5++) {
                                int iM10559u2 = m10559u(i3);
                                int iM10559u3 = m10559u(i3 + 2);
                                int iM10559u4 = m10559u(i3 + 4);
                                i3 += 6;
                                c12419h.f26203j[i5] = m10540b(iM10559u2, c12419h.f26200g);
                                c12419h.f26204k[i5] = m10540b(iM10559u2 + iM10559u3, c12419h.f26200g);
                                c12419h.f26205l[i5] = iM10559u4;
                            }
                            break;
                        case 66:
                            i2 = iM10550l & InputDeviceCompat.SOURCE_ANY;
                            i3 = i + 3;
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = iM10550l & ViewCompat.MEASURED_STATE_MASK;
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = iM10550l & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i2 = iM10550l & (-65536);
            i3 = i + 2;
        }
        c12419h.f26201h = i2;
        int iM10544f = m10544f(i3);
        c12419h.f26202i = iM10544f == 0 ? null : new C12435x(this.f26155a, i3);
        return (iM10544f * 2) + i3 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004e A[FALL_THROUGH] */
    /* JADX INFO: renamed from: s */
    public final int[] m10557s(AbstractC12428q abstractC12428q, C12419h c12419h, int i, boolean z2) {
        int i2;
        C12412a c12412a;
        char[] cArr = c12419h.f26196c;
        int iM10559u = m10559u(i);
        int[] iArr = new int[iM10559u];
        int iM10549k = i + 2;
        for (int i3 = 0; i3 < iM10559u; i3++) {
            iArr[i3] = iM10549k;
            int iM10550l = m10550l(iM10549k);
            int i4 = iM10550l >>> 24;
            if (i4 != 23) {
                switch (i4) {
                    default:
                        switch (i4) {
                            case 64:
                            case 65:
                                int iM10559u2 = m10559u(iM10549k + 1);
                                i2 = iM10549k + 3;
                                while (true) {
                                    int i5 = iM10559u2 - 1;
                                    if (iM10559u2 > 0) {
                                        int iM10559u3 = m10559u(i2);
                                        int iM10559u4 = m10559u(i2 + 2);
                                        i2 += 6;
                                        m10540b(iM10559u3, c12419h.f26200g);
                                        m10540b(iM10559u3 + iM10559u4, c12419h.f26200g);
                                        iM10559u2 = i5;
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
                                i2 = iM10549k + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = iM10549k + 3;
                        break;
                }
            } else {
                i2 = iM10549k + 3;
            }
            int iM10544f = m10544f(i2);
            if (i4 == 66) {
                C12435x c12435x = iM10544f != 0 ? new C12435x(this.f26155a, i2) : null;
                int i6 = (iM10544f * 2) + 1 + i2;
                String strM10558t = m10558t(i6, cArr);
                int i7 = i6 + 2;
                int i8 = iM10550l & InputDeviceCompat.SOURCE_ANY;
                C12429r c12429r = (C12429r) abstractC12428q;
                Objects.requireNonNull(c12429r);
                C12414c c12414c = new C12414c();
                C3404f.m4256W0(i8, c12414c);
                C12435x.m10655a(c12435x, c12414c);
                c12414c.m10538j(c12429r.f26293d.m10637l(strM10558t));
                c12414c.m10538j(0);
                if (z2) {
                    c12412a = new C12412a(c12429r.f26293d, true, c12414c, c12429r.f26312w);
                    c12429r.f26312w = c12412a;
                } else {
                    c12412a = new C12412a(c12429r.f26293d, true, c12414c, c12429r.f26313x);
                    c12429r.f26313x = c12412a;
                }
                iM10549k = m10549k(c12412a, i7, true, cArr);
            } else {
                iM10549k = m10549k(null, (iM10544f * 2) + 3 + i2, true, cArr);
            }
        }
        return iArr;
    }

    /* JADX INFO: renamed from: t */
    public String m10558t(int i, char[] cArr) {
        int iM10559u = m10559u(i);
        if (i == 0 || iM10559u == 0) {
            return null;
        }
        return m10561w(iM10559u, cArr);
    }

    /* JADX INFO: renamed from: u */
    public int m10559u(int i) {
        byte[] bArr = this.f26155a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX INFO: renamed from: v */
    public final String m10560v(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.f26155a;
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

    /* JADX INFO: renamed from: w */
    public final String m10561w(int i, char[] cArr) {
        String[] strArr = this.f26157c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.f26156b[i];
        String strM10560v = m10560v(i2 + 2, m10559u(i2), cArr);
        strArr[i] = strM10560v;
        return strM10560v;
    }

    /* JADX INFO: renamed from: x */
    public final int m10562x(int i, Object[] objArr, int i2, char[] cArr, C12427p[] c12427pArr) {
        int i3 = i + 1;
        switch (this.f26155a[i] & 255) {
            case 0:
                objArr[i2] = InterfaceC12431t.f26333a;
                return i3;
            case 1:
                objArr[i2] = InterfaceC12431t.f26334b;
                return i3;
            case 2:
                objArr[i2] = InterfaceC12431t.f26335c;
                return i3;
            case 3:
                objArr[i2] = InterfaceC12431t.f26336d;
                return i3;
            case 4:
                objArr[i2] = InterfaceC12431t.f26337e;
                return i3;
            case 5:
                objArr[i2] = InterfaceC12431t.f26338f;
                return i3;
            case 6:
                objArr[i2] = InterfaceC12431t.f26339g;
                return i3;
            case 7:
                objArr[i2] = m10545g(i3, cArr);
                break;
            case 8:
                objArr[i2] = m10540b(m10559u(i3), c12427pArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
