package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.s */
/* JADX INFO: compiled from: GeneralAppIdDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5030s {

    /* JADX INFO: renamed from: a */
    public final C4962a f13457a;

    /* JADX INFO: renamed from: b */
    public final C5024m f13458b = new C5024m();

    /* JADX INFO: renamed from: c */
    public final StringBuilder f13459c = new StringBuilder();

    public C5030s(C4962a c4962a) {
        this.f13457a = c4962a;
    }

    /* JADX INFO: renamed from: d */
    public static int m7038d(C4962a c4962a, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c4962a.m6935b(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public String m7039a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            C5026o c5026oM7040b = m7040b(i, str);
            String strM7035a = C5029r.m7035a(c5026oM7040b.f13446b);
            if (strM7035a != null) {
                sb.append(strM7035a);
            }
            String strValueOf = c5026oM7040b.f13448d ? String.valueOf(c5026oM7040b.f13447c) : null;
            int i2 = c5026oM7040b.f13451a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = strValueOf;
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x0399  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    /* JADX INFO: renamed from: b */
    public C5026o m7040b(int i, String str) throws FormatException {
        boolean zM6935b;
        boolean z2;
        C5023l c5023l;
        boolean z3;
        C5027p c5027p;
        boolean z4;
        char c;
        C5025n c5025n;
        C5025n c5025n2;
        int iM7038d;
        int i2;
        boolean z5;
        char c2;
        C5025n c5025n3;
        C5025n c5025n4;
        int iM7038d2;
        this.f13459c.setLength(0);
        if (str != null) {
            this.f13459c.append(str);
        }
        this.f13458b.f13443a = i;
        int i3 = 2;
        while (true) {
            C5024m c5024m = this.f13458b;
            int i4 = c5024m.f13443a;
            int i5 = c5024m.f13444b;
            if (i5 == i3) {
                while (true) {
                    int i6 = this.f13458b.f13443a;
                    int i7 = i6 + 5;
                    C4962a c4962a = this.f13457a;
                    if (i7 <= c4962a.f13228k) {
                        int iM7038d3 = m7038d(c4962a, i6, 5);
                        if (iM7038d3 < 5 || iM7038d3 >= 16) {
                            int i8 = i6 + 6;
                            C4962a c4962a2 = this.f13457a;
                            if (i8 > c4962a2.f13228k || (iM7038d2 = m7038d(c4962a2, i6, 6)) < 16 || iM7038d2 >= 63) {
                                z5 = false;
                            }
                        }
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        int i9 = this.f13458b.f13443a;
                        int iM7038d4 = m7038d(this.f13457a, i9, 5);
                        if (iM7038d4 == 15) {
                            c5025n4 = new C5025n(i9 + 5, '$');
                        } else {
                            if (iM7038d4 < 5 || iM7038d4 >= 15) {
                                int iM7038d5 = m7038d(this.f13457a, i9, 6);
                                if (iM7038d5 < 32 || iM7038d5 >= 58) {
                                    switch (iM7038d5) {
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
                                            throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iM7038d5)));
                                    }
                                    c5025n3 = new C5025n(i9 + 6, c2);
                                } else {
                                    c5025n3 = new C5025n(i9 + 6, (char) (iM7038d5 + 33));
                                }
                            } else {
                                c5025n3 = new C5025n(i9 + 5, (char) ((iM7038d4 + 48) - 5));
                            }
                            c5025n4 = c5025n3;
                        }
                        C5024m c5024m2 = this.f13458b;
                        int i10 = c5025n4.f13451a;
                        c5024m2.f13443a = i10;
                        char c3 = c5025n4.f13445b;
                        if (c3 == '$') {
                            c5023l = new C5023l(new C5026o(i10, this.f13459c.toString()), true);
                        } else {
                            this.f13459c.append(c3);
                        }
                    } else {
                        if (m7042e(this.f13458b.f13443a)) {
                            this.f13458b.m7034a(3);
                            this.f13458b.f13444b = 1;
                        } else if (m7043f(this.f13458b.f13443a)) {
                            C5024m c5024m3 = this.f13458b;
                            int i11 = c5024m3.f13443a + 5;
                            int i12 = this.f13457a.f13228k;
                            if (i11 < i12) {
                                c5024m3.m7034a(5);
                            } else {
                                c5024m3.f13443a = i12;
                            }
                            this.f13458b.f13444b = 3;
                        }
                        c5023l = new C5023l(null, false);
                    }
                }
                z3 = c5023l.f13442b;
            } else {
                if (i5 == 3) {
                    while (true) {
                        int i13 = this.f13458b.f13443a;
                        int i14 = i13 + 5;
                        C4962a c4962a3 = this.f13457a;
                        if (i14 <= c4962a3.f13228k) {
                            int iM7038d6 = m7038d(c4962a3, i13, 5);
                            if (iM7038d6 < 5 || iM7038d6 >= 16) {
                                int i15 = i13 + 7;
                                C4962a c4962a4 = this.f13457a;
                                if (i15 <= c4962a4.f13228k) {
                                    int iM7038d7 = m7038d(c4962a4, i13, 7);
                                    if (iM7038d7 < 64 || iM7038d7 >= 116) {
                                        int i16 = i13 + 8;
                                        C4962a c4962a5 = this.f13457a;
                                        if (i16 <= c4962a5.f13228k && (iM7038d = m7038d(c4962a5, i13, 8)) >= 232 && iM7038d < 253) {
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
                            int i17 = this.f13458b.f13443a;
                            int iM7038d8 = m7038d(this.f13457a, i17, 5);
                            if (iM7038d8 == 15) {
                                c5025n2 = new C5025n(i17 + 5, '$');
                            } else {
                                if (iM7038d8 < 5 || iM7038d8 >= 15) {
                                    int iM7038d9 = m7038d(this.f13457a, i17, 7);
                                    if (iM7038d9 >= 64 && iM7038d9 < 90) {
                                        c5025n = new C5025n(i17 + 7, (char) (iM7038d9 + 1));
                                    } else if (iM7038d9 < 90 || iM7038d9 >= 116) {
                                        switch (m7038d(this.f13457a, i17, 8)) {
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
                                                throw FormatException.m9260a();
                                        }
                                        c5025n = new C5025n(i17 + 8, c);
                                    } else {
                                        c5025n = new C5025n(i17 + 7, (char) (iM7038d9 + 7));
                                    }
                                } else {
                                    c5025n = new C5025n(i17 + 5, (char) ((iM7038d8 + 48) - 5));
                                }
                                c5025n2 = c5025n;
                            }
                            C5024m c5024m4 = this.f13458b;
                            int i18 = c5025n2.f13451a;
                            c5024m4.f13443a = i18;
                            char c4 = c5025n2.f13445b;
                            if (c4 == '$') {
                                c5023l = new C5023l(new C5026o(i18, this.f13459c.toString()), true);
                            } else {
                                this.f13459c.append(c4);
                            }
                        } else {
                            if (m7042e(this.f13458b.f13443a)) {
                                this.f13458b.m7034a(3);
                                this.f13458b.f13444b = 1;
                            } else if (m7043f(this.f13458b.f13443a)) {
                                C5024m c5024m5 = this.f13458b;
                                int i19 = c5024m5.f13443a + 5;
                                int i20 = this.f13457a.f13228k;
                                if (i19 < i20) {
                                    c5024m5.m7034a(5);
                                } else {
                                    c5024m5.f13443a = i20;
                                }
                                this.f13458b.f13444b = 2;
                            }
                            c5023l = new C5023l(null, false);
                        }
                    }
                    z3 = c5023l.f13442b;
                } else {
                    while (true) {
                        int i21 = this.f13458b.f13443a;
                        int i22 = i21 + 7;
                        int i23 = this.f13457a.f13228k;
                        if (i22 > i23) {
                            zM6935b = i21 + 4 <= i23;
                        } else {
                            int i24 = i21;
                            while (true) {
                                int i25 = i21 + 3;
                                if (i24 >= i25) {
                                    zM6935b = this.f13457a.m6935b(i25);
                                } else if (!this.f13457a.m6935b(i24)) {
                                    i24++;
                                }
                            }
                        }
                        if (zM6935b) {
                            int i26 = this.f13458b.f13443a;
                            int i27 = i26 + 7;
                            C4962a c4962a6 = this.f13457a;
                            if (i27 > c4962a6.f13228k) {
                                int iM7038d10 = m7038d(c4962a6, i26, 4);
                                c5027p = iM7038d10 == 0 ? new C5027p(this.f13457a.f13228k, 10, 10) : new C5027p(this.f13457a.f13228k, iM7038d10 - 1, 10);
                            } else {
                                int iM7038d11 = m7038d(c4962a6, i26, 7) - 8;
                                c5027p = new C5027p(i27, iM7038d11 / 11, iM7038d11 % 11);
                            }
                            C5024m c5024m6 = this.f13458b;
                            int i28 = c5027p.f13451a;
                            c5024m6.f13443a = i28;
                            int i29 = c5027p.f13449b;
                            if (i29 == 10) {
                                c5023l = new C5023l(c5027p.f13450c == 10 ? new C5026o(i28, this.f13459c.toString()) : new C5026o(i28, this.f13459c.toString(), c5027p.f13450c), true);
                            } else {
                                this.f13459c.append(i29);
                                int i30 = c5027p.f13450c;
                                if (i30 == 10) {
                                    c5023l = new C5023l(new C5026o(this.f13458b.f13443a, this.f13459c.toString()), true);
                                } else {
                                    this.f13459c.append(i30);
                                }
                            }
                        } else {
                            int i31 = this.f13458b.f13443a;
                            if (i31 + 1 > this.f13457a.f13228k) {
                                z2 = false;
                            } else {
                                int i32 = 0;
                                while (true) {
                                    if (i32 < 4) {
                                        int i33 = i32 + i31;
                                        C4962a c4962a7 = this.f13457a;
                                        if (i33 < c4962a7.f13228k) {
                                            if (c4962a7.m6935b(i33)) {
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
                                C5024m c5024m7 = this.f13458b;
                                c5024m7.f13444b = 2;
                                c5024m7.m7034a(4);
                            }
                            c5023l = new C5023l(null, false);
                        }
                    }
                    z3 = c5023l.f13442b;
                }
                i2 = this.f13458b.f13443a;
                if ((!(i4 != i2) || z3) && !z3) {
                }
            }
            i2 = this.f13458b.f13443a;
            i3 = !(i4 != i2) ? 2 : 2;
        }
        C5026o c5026o = c5023l.f13441a;
        return (c5026o == null || !c5026o.f13448d) ? new C5026o(i2, this.f13459c.toString()) : new C5026o(i2, this.f13459c.toString(), c5026o.f13447c);
    }

    /* JADX INFO: renamed from: c */
    public int m7041c(int i, int i2) {
        return m7038d(this.f13457a, i, i2);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m7042e(int i) {
        int i2 = i + 3;
        if (i2 > this.f13457a.f13228k) {
            return false;
        }
        while (i < i2) {
            if (this.f13457a.m6935b(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m7043f(int i) {
        if (i + 1 > this.f13457a.f13228k) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            C4962a c4962a = this.f13457a;
            if (i3 >= c4962a.f13228k) {
                return true;
            }
            if (i2 == 2) {
                if (!c4962a.m6935b(i + 2)) {
                    return false;
                }
            } else if (c4962a.m6935b(i3)) {
                return false;
            }
        }
        return true;
    }
}
