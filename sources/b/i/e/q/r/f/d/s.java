package b.i.e.q.r.f.d;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: GeneralAppIdDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public final b.i.e.n.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f1874b = new m();
    public final StringBuilder c = new StringBuilder();

    public s(b.i.e.n.a aVar) {
        this.a = aVar;
    }

    public static int d(b.i.e.n.a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.b(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            o oVarB = b(i, str);
            String strA = r.a(oVarB.f1871b);
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarB.d ? String.valueOf(oVarB.c) : null;
            int i2 = oVarB.a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x0399  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    public o b(int i, String str) throws FormatException {
        boolean zB;
        boolean z2;
        l lVar;
        boolean z3;
        p pVar;
        boolean z4;
        char c;
        n nVar;
        n nVar2;
        int iD;
        int i2;
        boolean z5;
        char c2;
        n nVar3;
        n nVar4;
        int iD2;
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.f1874b.a = i;
        int i3 = 2;
        while (true) {
            m mVar = this.f1874b;
            int i4 = mVar.a;
            int i5 = mVar.f1869b;
            if (i5 == i3) {
                while (true) {
                    int i6 = this.f1874b.a;
                    int i7 = i6 + 5;
                    b.i.e.n.a aVar = this.a;
                    if (i7 <= aVar.k) {
                        int iD3 = d(aVar, i6, 5);
                        if (iD3 < 5 || iD3 >= 16) {
                            int i8 = i6 + 6;
                            b.i.e.n.a aVar2 = this.a;
                            if (i8 > aVar2.k || (iD2 = d(aVar2, i6, 6)) < 16 || iD2 >= 63) {
                                z5 = false;
                            }
                        }
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        int i9 = this.f1874b.a;
                        int iD4 = d(this.a, i9, 5);
                        if (iD4 == 15) {
                            nVar4 = new n(i9 + 5, '$');
                        } else {
                            if (iD4 < 5 || iD4 >= 15) {
                                int iD5 = d(this.a, i9, 6);
                                if (iD5 < 32 || iD5 >= 58) {
                                    switch (iD5) {
                                        case 58:
                                            c2 = '*';
                                            break;
                                        case 59:
                                            c2 = ',';
                                            break;
                                        case 60:
                                            c2 = '-';
                                            break;
                                        case 61:
                                            c2 = '.';
                                            break;
                                        case 62:
                                            c2 = MentionUtilsKt.SLASH_CHAR;
                                            break;
                                        default:
                                            throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iD5)));
                                    }
                                    nVar3 = new n(i9 + 6, c2);
                                } else {
                                    nVar3 = new n(i9 + 6, (char) (iD5 + 33));
                                }
                            } else {
                                nVar3 = new n(i9 + 5, (char) ((iD4 + 48) - 5));
                            }
                            nVar4 = nVar3;
                        }
                        m mVar2 = this.f1874b;
                        int i10 = nVar4.a;
                        mVar2.a = i10;
                        char c3 = nVar4.f1870b;
                        if (c3 == '$') {
                            lVar = new l(new o(i10, this.c.toString()), true);
                        } else {
                            this.c.append(c3);
                        }
                    } else {
                        if (e(this.f1874b.a)) {
                            this.f1874b.a(3);
                            this.f1874b.f1869b = 1;
                        } else if (f(this.f1874b.a)) {
                            m mVar3 = this.f1874b;
                            int i11 = mVar3.a + 5;
                            int i12 = this.a.k;
                            if (i11 < i12) {
                                mVar3.a(5);
                            } else {
                                mVar3.a = i12;
                            }
                            this.f1874b.f1869b = 3;
                        }
                        lVar = new l(null, false);
                    }
                }
                z3 = lVar.f1868b;
            } else {
                if (i5 == 3) {
                    while (true) {
                        int i13 = this.f1874b.a;
                        int i14 = i13 + 5;
                        b.i.e.n.a aVar3 = this.a;
                        if (i14 <= aVar3.k) {
                            int iD6 = d(aVar3, i13, 5);
                            if (iD6 < 5 || iD6 >= 16) {
                                int i15 = i13 + 7;
                                b.i.e.n.a aVar4 = this.a;
                                if (i15 <= aVar4.k) {
                                    int iD7 = d(aVar4, i13, 7);
                                    if (iD7 < 64 || iD7 >= 116) {
                                        int i16 = i13 + 8;
                                        b.i.e.n.a aVar5 = this.a;
                                        if (i16 <= aVar5.k && (iD = d(aVar5, i13, 8)) >= 232 && iD < 253) {
                                        }
                                    }
                                }
                                z4 = false;
                            }
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            int i17 = this.f1874b.a;
                            int iD8 = d(this.a, i17, 5);
                            if (iD8 == 15) {
                                nVar2 = new n(i17 + 5, '$');
                            } else {
                                if (iD8 < 5 || iD8 >= 15) {
                                    int iD9 = d(this.a, i17, 7);
                                    if (iD9 >= 64 && iD9 < 90) {
                                        nVar = new n(i17 + 7, (char) (iD9 + 1));
                                    } else if (iD9 < 90 || iD9 >= 116) {
                                        switch (d(this.a, i17, 8)) {
                                            case 232:
                                                c = '!';
                                                break;
                                            case 233:
                                                c = '\"';
                                                break;
                                            case 234:
                                                c = '%';
                                                break;
                                            case 235:
                                                c = '&';
                                                break;
                                            case 236:
                                                c = '\'';
                                                break;
                                            case 237:
                                                c = '(';
                                                break;
                                            case 238:
                                                c = ')';
                                                break;
                                            case 239:
                                                c = '*';
                                                break;
                                            case 240:
                                                c = '+';
                                                break;
                                            case 241:
                                                c = ',';
                                                break;
                                            case 242:
                                                c = '-';
                                                break;
                                            case 243:
                                                c = '.';
                                                break;
                                            case 244:
                                                c = MentionUtilsKt.SLASH_CHAR;
                                                break;
                                            case 245:
                                                c = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
                                                break;
                                            case 246:
                                                c = ';';
                                                break;
                                            case 247:
                                                c = '<';
                                                break;
                                            case 248:
                                                c = '=';
                                                break;
                                            case 249:
                                                c = '>';
                                                break;
                                            case 250:
                                                c = '?';
                                                break;
                                            case 251:
                                                c = '_';
                                                break;
                                            case 252:
                                                c = ' ';
                                                break;
                                            default:
                                                throw FormatException.a();
                                        }
                                        nVar = new n(i17 + 8, c);
                                    } else {
                                        nVar = new n(i17 + 7, (char) (iD9 + 7));
                                    }
                                } else {
                                    nVar = new n(i17 + 5, (char) ((iD8 + 48) - 5));
                                }
                                nVar2 = nVar;
                            }
                            m mVar4 = this.f1874b;
                            int i18 = nVar2.a;
                            mVar4.a = i18;
                            char c4 = nVar2.f1870b;
                            if (c4 == '$') {
                                lVar = new l(new o(i18, this.c.toString()), true);
                            } else {
                                this.c.append(c4);
                            }
                        } else {
                            if (e(this.f1874b.a)) {
                                this.f1874b.a(3);
                                this.f1874b.f1869b = 1;
                            } else if (f(this.f1874b.a)) {
                                m mVar5 = this.f1874b;
                                int i19 = mVar5.a + 5;
                                int i20 = this.a.k;
                                if (i19 < i20) {
                                    mVar5.a(5);
                                } else {
                                    mVar5.a = i20;
                                }
                                this.f1874b.f1869b = 2;
                            }
                            lVar = new l(null, false);
                        }
                    }
                    z3 = lVar.f1868b;
                } else {
                    while (true) {
                        int i21 = this.f1874b.a;
                        int i22 = i21 + 7;
                        int i23 = this.a.k;
                        if (i22 > i23) {
                            zB = i21 + 4 <= i23;
                        } else {
                            int i24 = i21;
                            while (true) {
                                int i25 = i21 + 3;
                                if (i24 >= i25) {
                                    zB = this.a.b(i25);
                                } else if (!this.a.b(i24)) {
                                    i24++;
                                }
                            }
                        }
                        if (zB) {
                            int i26 = this.f1874b.a;
                            int i27 = i26 + 7;
                            b.i.e.n.a aVar6 = this.a;
                            if (i27 > aVar6.k) {
                                int iD10 = d(aVar6, i26, 4);
                                pVar = iD10 == 0 ? new p(this.a.k, 10, 10) : new p(this.a.k, iD10 - 1, 10);
                            } else {
                                int iD11 = d(aVar6, i26, 7) - 8;
                                pVar = new p(i27, iD11 / 11, iD11 % 11);
                            }
                            m mVar6 = this.f1874b;
                            int i28 = pVar.a;
                            mVar6.a = i28;
                            int i29 = pVar.f1872b;
                            if (i29 == 10) {
                                lVar = new l(pVar.c == 10 ? new o(i28, this.c.toString()) : new o(i28, this.c.toString(), pVar.c), true);
                            } else {
                                this.c.append(i29);
                                int i30 = pVar.c;
                                if (i30 == 10) {
                                    lVar = new l(new o(this.f1874b.a, this.c.toString()), true);
                                } else {
                                    this.c.append(i30);
                                }
                            }
                        } else {
                            int i31 = this.f1874b.a;
                            if (i31 + 1 > this.a.k) {
                                z2 = false;
                            } else {
                                int i32 = 0;
                                while (true) {
                                    if (i32 < 4) {
                                        int i33 = i32 + i31;
                                        b.i.e.n.a aVar7 = this.a;
                                        if (i33 < aVar7.k) {
                                            if (aVar7.b(i33)) {
                                                z2 = false;
                                            } else {
                                                i32++;
                                            }
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                m mVar7 = this.f1874b;
                                mVar7.f1869b = 2;
                                mVar7.a(4);
                            }
                            lVar = new l(null, false);
                        }
                    }
                    z3 = lVar.f1868b;
                }
                i2 = this.f1874b.a;
                if ((!(i4 != i2) || z3) && !z3) {
                }
            }
            i2 = this.f1874b.a;
            i3 = !(i4 != i2) ? 2 : 2;
        }
        o oVar = lVar.a;
        return (oVar == null || !oVar.d) ? new o(i2, this.c.toString()) : new o(i2, this.c.toString(), oVar.c);
    }

    public int c(int i, int i2) {
        return d(this.a, i, i2);
    }

    public final boolean e(int i) {
        int i2 = i + 3;
        if (i2 > this.a.k) {
            return false;
        }
        while (i < i2) {
            if (this.a.b(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean f(int i) {
        if (i + 1 > this.a.k) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            b.i.e.n.a aVar = this.a;
            if (i3 >= aVar.k) {
                return true;
            }
            if (i2 == 2) {
                if (!aVar.b(i + 2)) {
                    return false;
                }
            } else if (aVar.b(i3)) {
                return false;
            }
        }
        return true;
    }
}
