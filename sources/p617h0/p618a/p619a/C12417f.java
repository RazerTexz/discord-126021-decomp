package p617h0.p618a.p619a;

import org.objectweb.asm.ClassTooLargeException;
import org.objectweb.asm.MethodTooLargeException;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p617h0.p618a.p619a.C12413b;

/* JADX INFO: renamed from: h0.a.a.f */
/* JADX INFO: compiled from: ClassWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12417f extends AbstractC12416e {

    /* JADX INFO: renamed from: A */
    public C12413b f26162A;

    /* JADX INFO: renamed from: B */
    public int f26163B;

    /* JADX INFO: renamed from: a */
    public int f26164a;

    /* JADX INFO: renamed from: b */
    public final C12433v f26165b;

    /* JADX INFO: renamed from: c */
    public int f26166c;

    /* JADX INFO: renamed from: d */
    public int f26167d;

    /* JADX INFO: renamed from: e */
    public int f26168e;

    /* JADX INFO: renamed from: f */
    public int f26169f;

    /* JADX INFO: renamed from: g */
    public int[] f26170g;

    /* JADX INFO: renamed from: h */
    public C12423l f26171h;

    /* JADX INFO: renamed from: i */
    public C12423l f26172i;

    /* JADX INFO: renamed from: j */
    public C12429r f26173j;

    /* JADX INFO: renamed from: k */
    public C12429r f26174k;

    /* JADX INFO: renamed from: l */
    public int f26175l;

    /* JADX INFO: renamed from: m */
    public C12414c f26176m;

    /* JADX INFO: renamed from: n */
    public int f26177n;

    /* JADX INFO: renamed from: o */
    public int f26178o;

    /* JADX INFO: renamed from: p */
    public int f26179p;

    /* JADX INFO: renamed from: q */
    public int f26180q;

    /* JADX INFO: renamed from: r */
    public C12414c f26181r;

    /* JADX INFO: renamed from: s */
    public C12412a f26182s;

    /* JADX INFO: renamed from: t */
    public C12412a f26183t;

    /* JADX INFO: renamed from: u */
    public C12412a f26184u;

    /* JADX INFO: renamed from: v */
    public C12412a f26185v;

    /* JADX INFO: renamed from: w */
    public C12430s f26186w;

    /* JADX INFO: renamed from: x */
    public int f26187x;

    /* JADX INFO: renamed from: y */
    public int f26188y;

    /* JADX INFO: renamed from: z */
    public C12414c f26189z;

    public C12417f(int i) {
        super(Opcodes.ASM7);
        this.f26165b = new C12433v(this);
        if ((i & 2) != 0) {
            this.f26163B = 4;
        } else if ((i & 1) != 0) {
            this.f26163B = 1;
        } else {
            this.f26163B = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:412:0x0acf  */
    /* JADX INFO: renamed from: a */
    public final byte[] m10563a(byte[] bArr, boolean z2) {
        String strM10545g;
        C12413b c12413b;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        C12417f c12417f;
        String str7;
        String str8;
        boolean z3;
        String str9;
        String str10;
        String str11;
        String str12;
        int i2;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        int i3;
        String str23;
        int i4;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        C12415d c12415d;
        String str31;
        int i5;
        String[] strArr;
        String[] strArr2;
        int i6;
        String str32;
        C12413b.a aVar = new C12413b.a();
        aVar.m10528a(this.f26162A);
        for (C12423l c12423l = this.f26171h; c12423l != null; c12423l = (C12423l) c12423l.f26216a) {
            aVar.m10528a(c12423l.f26227l);
        }
        C12429r c12429r = this.f26173j;
        while (true) {
            strM10545g = null;
            if (c12429r == null) {
                break;
            }
            aVar.m10528a(c12429r.f26277M);
            aVar.m10528a(null);
            c12429r = (C12429r) c12429r.f26263b;
        }
        int i7 = aVar.f26151a;
        C12413b[] c12413bArr = new C12413b[i7];
        System.arraycopy(aVar.f26152b, 0, c12413bArr, 0, i7);
        this.f26171h = null;
        this.f26172i = null;
        this.f26173j = null;
        this.f26174k = null;
        this.f26182s = null;
        this.f26183t = null;
        this.f26184u = null;
        this.f26185v = null;
        this.f26186w = null;
        this.f26187x = 0;
        this.f26188y = 0;
        this.f26189z = null;
        this.f26162A = null;
        this.f26163B = z2 ? 3 : 0;
        C12415d c12415d2 = new C12415d(bArr, 0, false);
        int i8 = (z2 ? 8 : 0) | 256;
        C12419h c12419h = new C12419h();
        c12419h.f26194a = c12413bArr;
        c12419h.f26195b = i8;
        char[] cArr = new char[c12415d2.f26160f];
        c12419h.f26196c = cArr;
        int i9 = c12415d2.f26161g;
        int iM10559u = c12415d2.m10559u(i9);
        String strM10545g2 = c12415d2.m10545g(i9 + 2, cArr);
        String strM10545g3 = c12415d2.m10545g(i9 + 4, cArr);
        int iM10559u2 = c12415d2.m10559u(i9 + 6);
        String[] strArr3 = new String[iM10559u2];
        int i10 = i9 + 8;
        for (int i11 = 0; i11 < iM10559u2; i11++) {
            strArr3[i11] = c12415d2.m10545g(i10, cArr);
            i10 += 2;
        }
        int iM10541c = c12415d2.m10541c();
        String strM10558t = null;
        C12413b c12413bM10543e = null;
        String strM10558t2 = null;
        String strM10545g4 = null;
        int i12 = iM10559u;
        int iM10559u3 = c12415d2.m10559u(iM10541c - 2);
        String[] strArr4 = strArr3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        String strM10560v = null;
        while (true) {
            c12413b = c12413bM10543e;
            str = strM10558t;
            str2 = "Synthetic";
            str3 = strM10560v;
            str4 = "Deprecated";
            i = i13;
            str5 = strM10545g;
            str6 = "RuntimeVisibleAnnotations";
            if (iM10559u3 <= 0) {
                break;
            }
            String strM10558t3 = c12415d2.m10558t(iM10541c, cArr);
            int i22 = i10;
            int iM10550l = c12415d2.m10550l(iM10541c + 2);
            int i23 = iM10541c + 6;
            C12419h c12419h2 = c12419h;
            if ("SourceFile".equals(strM10558t3)) {
                strM10558t = c12415d2.m10558t(i23, cArr);
                strM10560v = str3;
                i13 = i;
                strM10545g = str5;
            } else {
                if ("InnerClasses".equals(strM10558t3)) {
                    i21 = i23;
                } else if ("EnclosingMethod".equals(strM10558t3)) {
                    i15 = i23;
                } else if ("NestHost".equals(strM10558t3)) {
                    strM10545g4 = c12415d2.m10545g(i23, cArr);
                } else if ("NestMembers".equals(strM10558t3)) {
                    i20 = i23;
                } else if ("Signature".equals(strM10558t3)) {
                    strM10558t2 = c12415d2.m10558t(i23, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strM10558t3)) {
                    i16 = i23;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strM10558t3)) {
                    i18 = i23;
                } else if ("Deprecated".equals(strM10558t3)) {
                    i12 |= 131072;
                } else if ("Synthetic".equals(strM10558t3)) {
                    i12 |= 4096;
                } else {
                    if ("SourceDebugExtension".equals(strM10558t3)) {
                        strM10560v = c12415d2.m10560v(i23, iM10550l, new char[iM10550l]);
                        i13 = i;
                        strM10545g = str5;
                        strM10558t = str;
                    } else if ("RuntimeInvisibleAnnotations".equals(strM10558t3)) {
                        i17 = i23;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strM10558t3)) {
                        i19 = i23;
                    } else if ("Module".equals(strM10558t3)) {
                        i13 = i23;
                        strM10545g = str5;
                        strM10560v = str3;
                        strM10558t = str;
                    } else if ("ModuleMainClass".equals(strM10558t3)) {
                        strM10545g = c12415d2.m10545g(i23, cArr);
                        i13 = i;
                        strM10560v = str3;
                        strM10558t = str;
                    } else if ("ModulePackages".equals(strM10558t3)) {
                        i14 = i23;
                    } else {
                        if ("BootstrapMethods".equals(strM10558t3)) {
                            i6 = i23;
                            str32 = str3;
                            c12413bM10543e = c12413b;
                        } else {
                            i6 = i23;
                            str32 = str3;
                            c12413bM10543e = c12415d2.m10543e(c12413bArr, strM10558t3, i6, iM10550l, cArr, -1, null);
                            c12413bM10543e.f26150c = c12413b;
                        }
                        strM10558t = str;
                        i13 = i;
                        i12 = i12;
                        strM10545g = str5;
                        strM10560v = str32;
                    }
                    iM10541c = i6 + iM10550l;
                    iM10559u3--;
                    strArr4 = strArr4;
                    i10 = i22;
                    c12419h = c12419h2;
                }
                i13 = i;
                strM10545g = str5;
                strM10560v = str3;
                strM10558t = str;
            }
            c12413bM10543e = c12413b;
            i6 = i23;
            strArr4 = strArr4;
            iM10541c = i6 + iM10550l;
            iM10559u3--;
            strArr4 = strArr4;
            i10 = i22;
            c12419h = c12419h2;
        }
        int i24 = i10;
        String str33 = "RuntimeInvisibleTypeAnnotations";
        String str34 = "RuntimeInvisibleAnnotations";
        C12419h c12419h3 = c12419h;
        C12415d c12415d3 = c12415d2;
        String str35 = "RuntimeVisibleTypeAnnotations";
        m10565c(c12415d2.m10550l(c12415d2.f26156b[1] - 7), i12, strM10545g2, strM10558t2, strM10545g3, strArr4);
        if ((i8 & 2) != 0 || (str == null && str3 == null)) {
            c12417f = this;
            str7 = "Signature";
        } else {
            c12417f = this;
            str7 = "Signature";
            if (str != null) {
                c12417f.f26180q = c12417f.f26165b.m10637l(str);
            }
            if (str3 != null) {
                C12414c c12414c = new C12414c();
                c12414c.m10529a(str3, 0, Integer.MAX_VALUE);
                c12417f.f26181r = c12414c;
            }
        }
        if (i != 0) {
            char[] cArr2 = c12419h3.f26196c;
            String strM10558t4 = c12415d3.m10558t(c12415d3.f26156b[c12415d3.m10559u(i)], cArr2);
            int iM10559u4 = c12415d3.m10559u(i + 2);
            String strM10558t5 = c12415d3.m10558t(i + 4, cArr2);
            int i25 = i + 6;
            C12433v c12433v = c12417f.f26165b;
            C12430s c12430s = new C12430s(c12433v, c12433v.m10638m(19, strM10558t4).f26340a, iM10559u4, strM10558t5 == null ? 0 : c12417f.f26165b.m10637l(strM10558t5));
            c12417f.f26186w = c12430s;
            if (str5 != null) {
                c12430s.f26332q = c12433v.m10638m(7, str5).f26340a;
            }
            int i26 = i14;
            if (i26 != 0) {
                int iM10559u5 = c12415d3.m10559u(i26);
                int i27 = i26 + 2;
                while (true) {
                    int i28 = iM10559u5 - 1;
                    if (iM10559u5 <= 0) {
                        break;
                    }
                    c12430s.f26331p.m10538j(c12430s.f26316a.m10638m(20, c12415d3.m10553o(i27, cArr2)).f26340a);
                    c12430s.f26330o++;
                    i27 += 2;
                    iM10559u5 = i28;
                }
            }
            int iM10559u6 = c12415d3.m10559u(i25);
            int i29 = i25 + 2;
            while (true) {
                int i30 = iM10559u6 - 1;
                if (iM10559u6 <= 0) {
                    break;
                }
                String strM10552n = c12415d3.m10552n(i29, cArr2);
                int iM10559u7 = c12415d3.m10559u(i29 + 2);
                String strM10558t6 = c12415d3.m10558t(i29 + 4, cArr2);
                i29 += 6;
                C12414c c12414c2 = c12430s.f26321f;
                String str36 = str2;
                c12414c2.m10538j(c12430s.f26316a.m10638m(19, strM10552n).f26340a);
                c12414c2.m10538j(iM10559u7);
                c12414c2.m10538j(strM10558t6 == null ? 0 : c12430s.f26316a.m10637l(strM10558t6));
                c12430s.f26320e++;
                iM10559u6 = i30;
                str2 = str36;
            }
            str8 = str2;
            int iM10559u8 = c12415d3.m10559u(i29);
            int i31 = i29 + 2;
            while (true) {
                int i32 = iM10559u8 - 1;
                if (iM10559u8 <= 0) {
                    break;
                }
                String strM10553o = c12415d3.m10553o(i31, cArr2);
                int iM10559u9 = c12415d3.m10559u(i31 + 2);
                int iM10559u10 = c12415d3.m10559u(i31 + 4);
                i31 += 6;
                if (iM10559u10 != 0) {
                    strArr2 = new String[iM10559u10];
                    int i33 = i31;
                    for (int i34 = 0; i34 < iM10559u10; i34++) {
                        strArr2[i34] = c12415d3.m10552n(i33, cArr2);
                        i33 += 2;
                    }
                    i31 = i33;
                } else {
                    strArr2 = null;
                }
                C12414c c12414c3 = c12430s.f26323h;
                c12414c3.m10538j(c12430s.f26316a.m10638m(20, strM10553o).f26340a);
                c12414c3.m10538j(iM10559u9);
                if (strArr2 == null) {
                    c12430s.f26323h.m10538j(0);
                } else {
                    c12430s.f26323h.m10538j(strArr2.length);
                    for (String str37 : strArr2) {
                        c12430s.f26323h.m10538j(c12430s.f26316a.m10635j(str37).f26340a);
                    }
                }
                c12430s.f26322g++;
                iM10559u8 = i32;
            }
            int iM10559u11 = c12415d3.m10559u(i31);
            int i35 = i31 + 2;
            while (true) {
                int i36 = iM10559u11 - 1;
                if (iM10559u11 <= 0) {
                    break;
                }
                String strM10553o2 = c12415d3.m10553o(i35, cArr2);
                int iM10559u12 = c12415d3.m10559u(i35 + 2);
                int iM10559u13 = c12415d3.m10559u(i35 + 4);
                i35 += 6;
                if (iM10559u13 != 0) {
                    strArr = new String[iM10559u13];
                    int i37 = i35;
                    for (int i38 = 0; i38 < iM10559u13; i38++) {
                        strArr[i38] = c12415d3.m10552n(i37, cArr2);
                        i37 += 2;
                    }
                    i35 = i37;
                } else {
                    strArr = null;
                }
                C12414c c12414c4 = c12430s.f26325j;
                c12414c4.m10538j(c12430s.f26316a.m10638m(20, strM10553o2).f26340a);
                c12414c4.m10538j(iM10559u12);
                if (strArr == null) {
                    c12430s.f26325j.m10538j(0);
                } else {
                    c12430s.f26325j.m10538j(strArr.length);
                    for (String str38 : strArr) {
                        c12430s.f26325j.m10538j(c12430s.f26316a.m10635j(str38).f26340a);
                    }
                }
                c12430s.f26324i++;
                iM10559u11 = i36;
            }
            int iM10559u14 = c12415d3.m10559u(i35);
            int i39 = i35 + 2;
            while (true) {
                int i40 = iM10559u14 - 1;
                if (iM10559u14 <= 0) {
                    break;
                }
                c12430s.f26327l.m10538j(c12430s.f26316a.m10638m(7, c12415d3.m10545g(i39, cArr2)).f26340a);
                c12430s.f26326k++;
                i39 += 2;
                iM10559u14 = i40;
            }
            int iM10559u15 = c12415d3.m10559u(i39);
            int i41 = i39 + 2;
            while (true) {
                int i42 = iM10559u15 - 1;
                if (iM10559u15 <= 0) {
                    break;
                }
                String strM10545g5 = c12415d3.m10545g(i41, cArr2);
                int iM10559u16 = c12415d3.m10559u(i41 + 2);
                String[] strArr5 = new String[iM10559u16];
                int i43 = i41 + 4;
                for (int i44 = 0; i44 < iM10559u16; i44++) {
                    strArr5[i44] = c12415d3.m10545g(i43, cArr2);
                    i43 += 2;
                }
                char[] cArr3 = cArr2;
                c12430s.f26329n.m10538j(c12430s.f26316a.m10638m(7, strM10545g5).f26340a);
                c12430s.f26329n.m10538j(iM10559u16);
                for (int i45 = 0; i45 < iM10559u16; i45++) {
                    c12430s.f26329n.m10538j(c12430s.f26316a.m10628c(strArr5[i45]).f26340a);
                }
                c12430s.f26328m++;
                iM10559u15 = i42;
                i41 = i43;
                cArr2 = cArr3;
            }
        } else {
            str8 = "Synthetic";
        }
        String str39 = strM10545g4;
        if (str39 != null) {
            c12417f.f26187x = c12417f.f26165b.m10638m(7, str39).f26340a;
        }
        int i46 = i15;
        if (i46 != 0) {
            String strM10545g6 = c12415d3.m10545g(i46, cArr);
            int iM10559u17 = c12415d3.m10559u(i46 + 2);
            String strM10558t7 = iM10559u17 == 0 ? null : c12415d3.m10558t(c12415d3.f26156b[iM10559u17], cArr);
            String strM10558t8 = iM10559u17 == 0 ? null : c12415d3.m10558t(c12415d3.f26156b[iM10559u17] + 2, cArr);
            c12417f.f26177n = c12417f.f26165b.m10638m(7, strM10545g6).f26340a;
            if (strM10558t7 != null && strM10558t8 != null) {
                c12417f.f26178o = c12417f.f26165b.m10636k(strM10558t7, strM10558t8);
            }
        }
        int i47 = i16;
        if (i47 != 0) {
            int iM10559u18 = c12415d3.m10559u(i47);
            int iM10549k = i47 + 2;
            while (true) {
                int i48 = iM10559u18 - 1;
                if (iM10559u18 <= 0) {
                    break;
                }
                iM10549k = c12415d3.m10549k(c12417f.m10566d(c12415d3.m10558t(iM10549k, cArr), true), iM10549k + 2, true, cArr);
                iM10559u18 = i48;
            }
        }
        int i49 = i17;
        if (i49 != 0) {
            int iM10559u19 = c12415d3.m10559u(i49);
            int iM10549k2 = i49 + 2;
            while (true) {
                int i50 = iM10559u19 - 1;
                if (iM10559u19 <= 0) {
                    break;
                }
                iM10549k2 = c12415d3.m10549k(c12417f.m10566d(c12415d3.m10558t(iM10549k2, cArr), false), iM10549k2 + 2, true, cArr);
                iM10559u19 = i50;
            }
        }
        int i51 = i18;
        if (i51 != 0) {
            int iM10559u20 = c12415d3.m10559u(i51);
            int iM10549k3 = i51 + 2;
            while (true) {
                int i52 = iM10559u20 - 1;
                if (iM10559u20 <= 0) {
                    break;
                }
                int iM10556r = c12415d3.m10556r(c12419h3, iM10549k3);
                iM10549k3 = c12415d3.m10549k(c12417f.m10568f(c12419h3.f26201h, c12419h3.f26202i, c12415d3.m10558t(iM10556r, cArr), true), iM10556r + 2, true, cArr);
                iM10559u20 = i52;
            }
        }
        int i53 = i19;
        if (i53 != 0) {
            int iM10559u21 = c12415d3.m10559u(i53);
            int iM10549k4 = i53 + 2;
            while (true) {
                int i54 = iM10559u21 - 1;
                if (iM10559u21 <= 0) {
                    break;
                }
                int iM10556r2 = c12415d3.m10556r(c12419h3, iM10549k4);
                iM10549k4 = c12415d3.m10549k(c12417f.m10568f(c12419h3.f26201h, c12419h3.f26202i, c12415d3.m10558t(iM10556r2, cArr), false), iM10556r2 + 2, true, cArr);
                iM10559u21 = i54;
            }
        }
        C12413b c12413b2 = c12413b;
        while (c12413b2 != null) {
            C12413b c12413b3 = c12413b2.f26150c;
            c12413b2.f26150c = null;
            c12413b2.f26150c = c12417f.f26162A;
            c12417f.f26162A = c12413b2;
            c12413b2 = c12413b3;
        }
        int i55 = i20;
        if (i55 != 0) {
            int iM10559u22 = c12415d3.m10559u(i55);
            int i56 = i55 + 2;
            while (true) {
                int i57 = iM10559u22 - 1;
                if (iM10559u22 <= 0) {
                    break;
                }
                String strM10545g7 = c12415d3.m10545g(i56, cArr);
                if (c12417f.f26189z == null) {
                    c12417f.f26189z = new C12414c();
                }
                c12417f.f26188y++;
                c12417f.f26189z.m10538j(c12417f.f26165b.m10638m(7, strM10545g7).f26340a);
                i56 += 2;
                iM10559u22 = i57;
            }
        }
        int i58 = i21;
        if (i58 != 0) {
            int iM10559u23 = c12415d3.m10559u(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = iM10559u23 - 1;
                if (iM10559u23 <= 0) {
                    break;
                }
                String strM10545g8 = c12415d3.m10545g(i59, cArr);
                String strM10545g9 = c12415d3.m10545g(i59 + 2, cArr);
                String strM10558t9 = c12415d3.m10558t(i59 + 4, cArr);
                int iM10559u24 = c12415d3.m10559u(i59 + 6);
                if (c12417f.f26176m == null) {
                    c12417f.f26176m = new C12414c();
                }
                AbstractC12432u abstractC12432uM10638m = c12417f.f26165b.m10638m(7, strM10545g8);
                if (abstractC12432uM10638m.f26346g == 0) {
                    c12417f.f26175l++;
                    c12417f.f26176m.m10538j(abstractC12432uM10638m.f26340a);
                    c12417f.f26176m.m10538j(strM10545g9 == null ? 0 : c12417f.f26165b.m10638m(7, strM10545g9).f26340a);
                    c12417f.f26176m.m10538j(strM10558t9 == null ? 0 : c12417f.f26165b.m10637l(strM10558t9));
                    c12417f.f26176m.m10538j(iM10559u24);
                    abstractC12432uM10638m.f26346g = c12417f.f26175l;
                }
                i59 += 8;
                iM10559u23 = i60;
            }
        }
        int iM10559u25 = c12415d3.m10559u(i24);
        int i61 = i24 + 2;
        while (true) {
            int i62 = iM10559u25 - 1;
            if (iM10559u25 <= 0) {
                break;
            }
            char[] cArr4 = c12419h3.f26196c;
            int iM10559u26 = c12415d3.m10559u(i61);
            String strM10558t10 = c12415d3.m10558t(i61 + 2, cArr4);
            String strM10558t11 = c12415d3.m10558t(i61 + 4, cArr4);
            int i63 = i61 + 6;
            int iM10559u27 = c12415d3.m10559u(i63);
            i61 = i63 + 2;
            int i64 = iM10559u26;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            C12413b c12413b4 = null;
            int i68 = 0;
            String strM10558t12 = null;
            Object objM10547i = null;
            while (true) {
                int i69 = iM10559u27 - 1;
                if (iM10559u27 <= 0) {
                    break;
                }
                String strM10558t13 = c12415d3.m10558t(i61, cArr4);
                int iM10550l2 = c12415d3.m10550l(i61 + 2);
                int i70 = i61 + 6;
                if ("ConstantValue".equals(strM10558t13)) {
                    int iM10559u28 = c12415d3.m10559u(i70);
                    if (iM10559u28 == 0) {
                        str22 = str8;
                        objM10547i = null;
                    } else {
                        objM10547i = c12415d3.m10547i(iM10559u28, cArr4);
                        str22 = str8;
                    }
                    i3 = i62;
                    i5 = i64;
                    i4 = i68;
                    str23 = str35;
                    str24 = str34;
                    str25 = str6;
                    str26 = str33;
                    str31 = str26;
                    str28 = str22;
                    str27 = str23;
                    str30 = str4;
                    c12415d = c12415d3;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                } else {
                    if (str7.equals(strM10558t13)) {
                        strM10558t12 = c12415d3.m10558t(i70, cArr4);
                    } else if (str4.equals(strM10558t13)) {
                        i64 |= 131072;
                    } else {
                        str22 = str8;
                        if (str22.equals(strM10558t13)) {
                            i64 |= 4096;
                            i3 = i62;
                            i5 = i64;
                            i4 = i68;
                            str23 = str35;
                            str24 = str34;
                            str25 = str6;
                            str26 = str33;
                            str31 = str26;
                            str28 = str22;
                            str27 = str23;
                            str30 = str4;
                            c12415d = c12415d3;
                            str29 = str24;
                            i68 = i4;
                            i64 = i5;
                        } else {
                            i3 = i62;
                            String str40 = str6;
                            if (str40.equals(strM10558t13)) {
                                str31 = str33;
                                i65 = i70;
                                str28 = str22;
                                str30 = str4;
                                str27 = str35;
                                str29 = str34;
                                str25 = str40;
                                c12415d = c12415d3;
                            } else {
                                int i71 = i64;
                                str23 = str35;
                                if (str23.equals(strM10558t13)) {
                                    i67 = i70;
                                    i4 = i68;
                                    str24 = str34;
                                } else {
                                    i4 = i68;
                                    str24 = str34;
                                    if (str24.equals(strM10558t13)) {
                                        i66 = i70;
                                    } else {
                                        str25 = str40;
                                        str26 = str33;
                                        if (str26.equals(strM10558t13)) {
                                            i5 = i71;
                                            i4 = i70;
                                            str31 = str26;
                                            str28 = str22;
                                            str27 = str23;
                                            str30 = str4;
                                            c12415d = c12415d3;
                                            str29 = str24;
                                            i68 = i4;
                                            i64 = i5;
                                        } else {
                                            str27 = str23;
                                            str28 = str22;
                                            str29 = str24;
                                            str30 = str4;
                                            c12415d = c12415d3;
                                            str31 = str26;
                                            C12413b c12413bM10543e2 = c12415d3.m10543e(c12419h3.f26194a, strM10558t13, i70, iM10550l2, cArr4, -1, null);
                                            c12413bM10543e2.f26150c = c12413b4;
                                            c12413b4 = c12413bM10543e2;
                                            i64 = i71;
                                            i68 = i4;
                                        }
                                    }
                                }
                                i5 = i71;
                                str25 = str40;
                                str26 = str33;
                                str31 = str26;
                                str28 = str22;
                                str27 = str23;
                                str30 = str4;
                                c12415d = c12415d3;
                                str29 = str24;
                                i68 = i4;
                                i64 = i5;
                            }
                        }
                    }
                    str22 = str8;
                    i3 = i62;
                    i5 = i64;
                    i4 = i68;
                    str23 = str35;
                    str24 = str34;
                    str25 = str6;
                    str26 = str33;
                    str31 = str26;
                    str28 = str22;
                    str27 = str23;
                    str30 = str4;
                    c12415d = c12415d3;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                }
                i61 = i70 + iM10550l2;
                c12415d3 = c12415d;
                c12419h3 = c12419h3;
                iM10559u27 = i69;
                str4 = str30;
                i62 = i3;
                str8 = str28;
                str34 = str29;
                str33 = str31;
                str7 = str7;
                str6 = str25;
                str35 = str27;
            }
            String str41 = str33;
            int i72 = i62;
            String str42 = str4;
            C12413b c12413b5 = c12413b4;
            C12415d c12415d4 = c12415d3;
            int i73 = i68;
            String str43 = str35;
            String str44 = str34;
            String str45 = str8;
            String str46 = str6;
            String str47 = str7;
            C12419h c12419h4 = c12419h3;
            C12423l c12423l2 = new C12423l(c12417f.f26165b, i64, strM10558t10, strM10558t11, strM10558t12, objM10547i);
            if (c12417f.f26171h == null) {
                c12417f.f26171h = c12423l2;
            } else {
                c12417f.f26172i.f26216a = c12423l2;
            }
            c12417f.f26172i = c12423l2;
            if (i65 != 0) {
                int iM10559u29 = c12415d4.m10559u(i65);
                int iM10549k5 = i65 + 2;
                while (true) {
                    int i74 = iM10559u29 - 1;
                    if (iM10559u29 <= 0) {
                        break;
                    }
                    iM10549k5 = c12415d4.m10549k(c12423l2.m10570a(c12415d4.m10558t(iM10549k5, cArr4), true), iM10549k5 + 2, true, cArr4);
                    iM10559u29 = i74;
                }
            }
            if (i66 != 0) {
                int iM10559u30 = c12415d4.m10559u(i66);
                int iM10549k6 = i66 + 2;
                while (true) {
                    int i75 = iM10559u30 - 1;
                    if (iM10559u30 <= 0) {
                        break;
                    }
                    iM10549k6 = c12415d4.m10549k(c12423l2.m10570a(c12415d4.m10558t(iM10549k6, cArr4), false), iM10549k6 + 2, true, cArr4);
                    iM10559u30 = i75;
                }
            }
            if (i67 != 0) {
                int iM10559u31 = c12415d4.m10559u(i67);
                int iM10549k7 = i67 + 2;
                while (true) {
                    int i76 = iM10559u31 - 1;
                    if (iM10559u31 <= 0) {
                        break;
                    }
                    int iM10556r3 = c12415d4.m10556r(c12419h4, iM10549k7);
                    iM10549k7 = c12415d4.m10549k(c12423l2.m10571b(c12419h4.f26201h, c12419h4.f26202i, c12415d4.m10558t(iM10556r3, cArr4), true), iM10556r3 + 2, true, cArr4);
                    iM10559u31 = i76;
                }
            }
            if (i73 != 0) {
                int iM10559u32 = c12415d4.m10559u(i73);
                int iM10549k8 = i73 + 2;
                while (true) {
                    int i77 = iM10559u32 - 1;
                    if (iM10559u32 <= 0) {
                        break;
                    }
                    int iM10556r4 = c12415d4.m10556r(c12419h4, iM10549k8);
                    iM10549k8 = c12415d4.m10549k(c12423l2.m10571b(c12419h4.f26201h, c12419h4.f26202i, c12415d4.m10558t(iM10556r4, cArr4), false), iM10556r4 + 2, true, cArr4);
                    iM10559u32 = i77;
                }
            }
            C12413b c12413b6 = c12413b5;
            while (c12413b6 != null) {
                C12413b c12413b7 = c12413b6.f26150c;
                c12413b6.f26150c = null;
                c12413b6.f26150c = c12423l2.f26227l;
                c12423l2.f26227l = c12413b6;
                c12413b6 = c12413b7;
            }
            c12415d3 = c12415d4;
            c12419h3 = c12419h4;
            str4 = str42;
            iM10559u25 = i72;
            str8 = str45;
            str34 = str44;
            str33 = str41;
            str7 = str47;
            str6 = str46;
            str35 = str43;
        }
        String str48 = str33;
        String str49 = str4;
        C12415d c12415d5 = c12415d3;
        String str50 = str35;
        String str51 = str34;
        String str52 = str8;
        String str53 = str6;
        String str54 = str7;
        C12419h c12419h5 = c12419h3;
        int i78 = 1;
        int iM10559u33 = c12415d5.m10559u(i61);
        int i79 = i61 + 2;
        while (true) {
            int i80 = iM10559u33 - 1;
            if (iM10559u33 <= 0) {
                return m10564b();
            }
            char[] cArr5 = c12419h5.f26196c;
            c12419h5.f26197d = c12415d5.m10559u(i79);
            c12419h5.f26198e = c12415d5.m10558t(i79 + 2, cArr5);
            int i81 = i79 + 4;
            c12419h5.f26199f = c12415d5.m10558t(i81, cArr5);
            int i82 = i79 + 6;
            int iM10559u34 = c12415d5.m10559u(i82);
            int i83 = i82 + 2;
            int i84 = 0;
            int i85 = 0;
            boolean z4 = false;
            C12413b c12413b8 = null;
            String[] strArr6 = null;
            int i86 = 0;
            int i87 = 0;
            int iM10559u35 = 0;
            int i88 = 0;
            int i89 = 0;
            int i90 = 0;
            int i91 = 0;
            int i92 = 0;
            int i93 = 0;
            while (true) {
                int i94 = iM10559u34 - 1;
                if (iM10559u34 <= 0) {
                    break;
                }
                String strM10558t14 = c12415d5.m10558t(i83, cArr5);
                int iM10550l3 = c12415d5.m10550l(i83 + 2);
                int i95 = i83 + 6;
                if ("Code".equals(strM10558t14)) {
                    if ((c12419h5.f26195b & i78) == 0) {
                        i93 = i95;
                        str11 = str53;
                        str10 = str49;
                        i2 = i82;
                        str12 = str11;
                        str15 = str48;
                        str17 = str54;
                        str16 = str10;
                        str18 = str12;
                        str19 = str50;
                        str20 = str51;
                        str21 = str15;
                    } else {
                        str9 = str54;
                        str10 = str49;
                        str54 = str9;
                        str11 = str53;
                        i2 = i82;
                        str12 = str11;
                        str15 = str48;
                        str17 = str54;
                        str16 = str10;
                        str18 = str12;
                        str19 = str50;
                        str20 = str51;
                        str21 = str15;
                    }
                } else if ("Exceptions".equals(strM10558t14)) {
                    int iM10559u36 = c12415d5.m10559u(i95);
                    String[] strArr7 = new String[iM10559u36];
                    int i96 = i95 + 2;
                    for (int i97 = 0; i97 < iM10559u36; i97++) {
                        strArr7[i97] = c12415d5.m10545g(i96, cArr5);
                        i96 += 2;
                    }
                    strArr6 = strArr7;
                    i85 = i95;
                    str11 = str53;
                    str10 = str49;
                    i2 = i82;
                    str12 = str11;
                    str15 = str48;
                    str17 = str54;
                    str16 = str10;
                    str18 = str12;
                    str19 = str50;
                    str20 = str51;
                    str21 = str15;
                } else {
                    str9 = str54;
                    if (str9.equals(strM10558t14)) {
                        iM10559u35 = c12415d5.m10559u(i95);
                        str10 = str49;
                        str54 = str9;
                        str11 = str53;
                        i2 = i82;
                        str12 = str11;
                        str15 = str48;
                        str17 = str54;
                        str16 = str10;
                        str18 = str12;
                        str19 = str50;
                        str20 = str51;
                        str21 = str15;
                    } else {
                        str10 = str49;
                        if (str10.equals(strM10558t14)) {
                            c12419h5.f26197d |= 131072;
                            str54 = str9;
                            str11 = str53;
                            i2 = i82;
                            str12 = str11;
                            str15 = str48;
                            str17 = str54;
                            str16 = str10;
                            str18 = str12;
                            str19 = str50;
                            str20 = str51;
                            str21 = str15;
                        } else {
                            str54 = str9;
                            str11 = str53;
                            if (str11.equals(strM10558t14)) {
                                i87 = i95;
                                i2 = i82;
                                str12 = str11;
                                str15 = str48;
                                str17 = str54;
                                str16 = str10;
                                str18 = str12;
                                str19 = str50;
                                str20 = str51;
                                str21 = str15;
                            } else {
                                str12 = str11;
                                String str55 = str50;
                                if (str55.equals(strM10558t14)) {
                                    i2 = i82;
                                    i89 = i95;
                                } else {
                                    i2 = i82;
                                    if ("AnnotationDefault".equals(strM10558t14)) {
                                        i84 = i95;
                                    } else {
                                        str13 = str52;
                                        if (str13.equals(strM10558t14)) {
                                            c12419h5.f26197d |= 4096;
                                            str17 = str54;
                                            str52 = str13;
                                            str16 = str10;
                                            str19 = str55;
                                            str18 = str12;
                                            str20 = str51;
                                            str21 = str48;
                                            z4 = true;
                                        } else {
                                            str50 = str55;
                                            str14 = str51;
                                            if (str14.equals(strM10558t14)) {
                                                i88 = i95;
                                                str52 = str13;
                                                str51 = str14;
                                                str15 = str48;
                                                str17 = str54;
                                                str16 = str10;
                                                str18 = str12;
                                                str19 = str50;
                                                str20 = str51;
                                                str21 = str15;
                                            } else {
                                                str51 = str14;
                                                str15 = str48;
                                                if (str15.equals(strM10558t14)) {
                                                    str52 = str13;
                                                    i90 = i95;
                                                } else {
                                                    str52 = str13;
                                                    if ("RuntimeVisibleParameterAnnotations".equals(strM10558t14)) {
                                                        i91 = i95;
                                                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strM10558t14)) {
                                                        i92 = i95;
                                                    } else if ("MethodParameters".equals(strM10558t14)) {
                                                        i86 = i95;
                                                    } else {
                                                        str16 = str10;
                                                        str17 = str54;
                                                        str18 = str12;
                                                        str19 = str50;
                                                        str20 = str51;
                                                        str21 = str15;
                                                        C12413b c12413bM10543e3 = c12415d5.m10543e(c12419h5.f26194a, strM10558t14, i95, iM10550l3, cArr5, -1, null);
                                                        c12413bM10543e3.f26150c = c12413b8;
                                                        z4 = z4;
                                                        i85 = i85;
                                                        c12413b8 = c12413bM10543e3;
                                                        i84 = i84;
                                                    }
                                                }
                                                str17 = str54;
                                                str16 = str10;
                                                str18 = str12;
                                                str19 = str50;
                                                str20 = str51;
                                                str21 = str15;
                                            }
                                        }
                                    }
                                }
                                str50 = str55;
                                str13 = str52;
                                str14 = str51;
                                str52 = str13;
                                str51 = str14;
                                str15 = str48;
                                str17 = str54;
                                str16 = str10;
                                str18 = str12;
                                str19 = str50;
                                str20 = str51;
                                str21 = str15;
                            }
                        }
                    }
                }
                i83 = i95 + iM10550l3;
                i82 = i2;
                str48 = str21;
                iM10559u34 = i94;
                str49 = str16;
                str51 = str20;
                str50 = str19;
                str53 = str18;
                str54 = str17;
                i78 = 1;
            }
            String str56 = str54;
            int i98 = i82;
            int i99 = i84;
            int i100 = i85;
            boolean z5 = z4;
            C12413b c12413b9 = c12413b8;
            String str57 = str53;
            String str58 = str50;
            String str59 = str51;
            String str60 = str48;
            int i101 = iM10559u35;
            String str61 = str52;
            C12415d c12415d6 = c12415d5;
            str49 = str49;
            C12419h c12419h6 = c12419h5;
            AbstractC12428q abstractC12428qM10567e = m10567e(c12419h5.f26197d, c12419h5.f26198e, c12419h5.f26199f, i101 == 0 ? null : c12415d5.m10561w(i101, cArr5), strArr6);
            C12429r c12429r2 = (C12429r) abstractC12428qM10567e;
            int i102 = i83 - i79;
            boolean z6 = (c12419h6.f26197d & 131072) != 0;
            int iM10559u37 = c12415d6.m10559u(i81);
            C12433v c12433v2 = c12429r2.f26293d;
            if (c12415d6 == c12433v2.f26348b && iM10559u37 == c12429r2.f26297h && i101 == c12429r2.f26265A) {
                int i103 = c12429r2.f26294e;
                if (z6 != ((i103 & 131072) != 0)) {
                    z3 = false;
                } else if (z5 != (c12433v2.f26349c < 49 && (i103 & 4096) != 0)) {
                    z3 = false;
                } else if (i100 != 0) {
                    if (c12415d6.m10559u(i100) == c12429r2.f26314y) {
                        int i104 = i100 + 2;
                        int i105 = 0;
                        while (true) {
                            if (i105 < c12429r2.f26314y) {
                                if (c12415d6.m10559u(i104) != c12429r2.f26315z[i105]) {
                                    z3 = false;
                                } else {
                                    i104 += 2;
                                    i105++;
                                }
                            }
                        }
                    }
                    c12429r2.f26291a0 = i98;
                    c12429r2.f26292b0 = i102 - 6;
                    z3 = true;
                } else if (c12429r2.f26314y != 0) {
                    z3 = false;
                } else {
                    c12429r2.f26291a0 = i98;
                    c12429r2.f26292b0 = i102 - 6;
                    z3 = true;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i106 = i86;
                if (i106 != 0) {
                    int iM10544f = c12415d6.m10544f(i106);
                    int i107 = i106 + 1;
                    while (true) {
                        int i108 = iM10544f - 1;
                        if (iM10544f <= 0) {
                            break;
                        }
                        String strM10558t15 = c12415d6.m10558t(i107, cArr5);
                        int iM10559u38 = c12415d6.m10559u(i107 + 2);
                        if (c12429r2.f26276L == null) {
                            c12429r2.f26276L = new C12414c();
                        }
                        c12429r2.f26275K++;
                        C12414c c12414c5 = c12429r2.f26276L;
                        c12414c5.m10538j(strM10558t15 == null ? 0 : c12429r2.f26293d.m10637l(strM10558t15));
                        c12414c5.m10538j(iM10559u38);
                        i107 += 4;
                        iM10544f = i108;
                    }
                }
                if (i99 != 0) {
                    C12414c c12414c6 = new C12414c();
                    c12429r2.f26274J = c12414c6;
                    C12412a c12412a = new C12412a(c12429r2.f26293d, false, c12414c6, null);
                    c12415d6.m10548j(c12412a, i99, null, cArr5);
                    c12412a.m10522g();
                }
                int i109 = i87;
                if (i109 != 0) {
                    int iM10559u39 = c12415d6.m10559u(i109);
                    int iM10549k9 = i109 + 2;
                    while (true) {
                        int i110 = iM10559u39 - 1;
                        if (iM10559u39 <= 0) {
                            break;
                        }
                        iM10549k9 = c12415d6.m10549k(abstractC12428qM10567e.mo10593a(c12415d6.m10558t(iM10549k9, cArr5), true), iM10549k9 + 2, true, cArr5);
                        iM10559u39 = i110;
                    }
                }
                int i111 = i88;
                if (i111 != 0) {
                    int iM10559u40 = c12415d6.m10559u(i111);
                    int iM10549k10 = i111 + 2;
                    while (true) {
                        int i112 = iM10559u40 - 1;
                        if (iM10559u40 <= 0) {
                            break;
                        }
                        iM10549k10 = c12415d6.m10549k(abstractC12428qM10567e.mo10593a(c12415d6.m10558t(iM10549k10, cArr5), false), iM10549k10 + 2, true, cArr5);
                        iM10559u40 = i112;
                    }
                }
                int i113 = i89;
                if (i113 != 0) {
                    int iM10559u41 = c12415d6.m10559u(i113);
                    int iM10549k11 = i113 + 2;
                    while (true) {
                        int i114 = iM10559u41 - 1;
                        if (iM10559u41 <= 0) {
                            break;
                        }
                        int iM10556r5 = c12415d6.m10556r(c12419h6, iM10549k11);
                        iM10549k11 = c12415d6.m10549k(abstractC12428qM10567e.mo10610r(c12419h6.f26201h, c12419h6.f26202i, c12415d6.m10558t(iM10556r5, cArr5), true), iM10556r5 + 2, true, cArr5);
                        iM10559u41 = i114;
                    }
                }
                int i115 = i90;
                if (i115 != 0) {
                    int iM10559u42 = c12415d6.m10559u(i115);
                    int iM10549k12 = i115 + 2;
                    while (true) {
                        int i116 = iM10559u42 - 1;
                        if (iM10559u42 <= 0) {
                            break;
                        }
                        int iM10556r6 = c12415d6.m10556r(c12419h6, iM10549k12);
                        iM10549k12 = c12415d6.m10549k(abstractC12428qM10567e.mo10610r(c12419h6.f26201h, c12419h6.f26202i, c12415d6.m10558t(iM10556r6, cArr5), false), iM10556r6 + 2, true, cArr5);
                        iM10559u42 = i116;
                    }
                }
                int i117 = i91;
                if (i117 != 0) {
                    c12415d6.m10554p(abstractC12428qM10567e, c12419h6, i117, true);
                }
                int i118 = i92;
                if (i118 != 0) {
                    c12415d6.m10554p(abstractC12428qM10567e, c12419h6, i118, false);
                }
                C12413b c12413b10 = c12413b9;
                while (c12413b10 != null) {
                    C12413b c12413b11 = c12413b10.f26150c;
                    c12413b10.f26150c = null;
                    c12413b10.f26150c = c12429r2.f26277M;
                    c12429r2.f26277M = c12413b10;
                    c12413b10 = c12413b11;
                }
                int i119 = i93;
                if (i119 != 0) {
                    c12415d6.m10546h(abstractC12428qM10567e, c12419h6, i119);
                }
            }
            iM10559u33 = i80;
            i79 = i83;
            c12415d5 = c12415d6;
            c12419h5 = c12419h6;
            str52 = str61;
            str48 = str60;
            str53 = str57;
            str54 = str56;
            str51 = str59;
            str50 = str58;
            i78 = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:337:0x06b3  */
    /* JADX INFO: renamed from: b */
    public byte[] m10564b() throws MethodTooLargeException, ClassTooLargeException {
        String str;
        String str2;
        int iM10523a;
        int i;
        String str3;
        int i2;
        int i3;
        int i4;
        int i5;
        String str4;
        String str5;
        int i6;
        int iM10518a;
        int iM10523a2;
        int iM10523a3 = (this.f26169f * 2) + 24;
        C12423l c12423l = this.f26171h;
        int i7 = 0;
        while (true) {
            str = "RuntimeInvisibleTypeAnnotations";
            str2 = "RuntimeVisibleTypeAnnotations";
            iM10523a = 16;
            if (c12423l == null) {
                break;
            }
            i7++;
            if (c12423l.f26222g != 0) {
                c12423l.f26217b.m10637l("ConstantValue");
            } else {
                iM10523a = 8;
            }
            if ((c12423l.f26218c & 4096) != 0) {
                C12433v c12433v = c12423l.f26217b;
                if (c12433v.f26349c < 49) {
                    c12433v.m10637l("Synthetic");
                    iM10523a += 6;
                }
            }
            if (c12423l.f26221f != 0) {
                c12423l.f26217b.m10637l("Signature");
                iM10523a += 8;
            }
            if ((c12423l.f26218c & 131072) != 0) {
                c12423l.f26217b.m10637l("Deprecated");
                iM10523a += 6;
            }
            C12412a c12412a = c12423l.f26223h;
            if (c12412a != null) {
                iM10523a += c12412a.m10518a("RuntimeVisibleAnnotations");
            }
            C12412a c12412a2 = c12423l.f26224i;
            if (c12412a2 != null) {
                iM10523a += c12412a2.m10518a("RuntimeInvisibleAnnotations");
            }
            C12412a c12412a3 = c12423l.f26225j;
            if (c12412a3 != null) {
                iM10523a += c12412a3.m10518a("RuntimeVisibleTypeAnnotations");
            }
            C12412a c12412a4 = c12423l.f26226k;
            if (c12412a4 != null) {
                iM10523a += c12412a4.m10518a("RuntimeInvisibleTypeAnnotations");
            }
            C12413b c12413b = c12423l.f26227l;
            if (c12413b != null) {
                iM10523a += c12413b.m10523a(c12423l.f26217b);
            }
            iM10523a3 += iM10523a;
            c12423l = (C12423l) c12423l.f26216a;
        }
        C12429r c12429r = this.f26173j;
        int i8 = 0;
        while (true) {
            if (c12429r == null) {
                C12414c c12414c = this.f26176m;
                if (c12414c != null) {
                    iM10523a3 += c12414c.f26154b + 8;
                    this.f26165b.m10637l("InnerClasses");
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.f26177n != 0) {
                    i++;
                    iM10523a3 += 10;
                    this.f26165b.m10637l("EnclosingMethod");
                }
                if ((this.f26166c & 4096) != 0) {
                    str3 = "EnclosingMethod";
                    if ((this.f26164a & 65535) < 49) {
                        i++;
                        iM10523a3 += 6;
                        this.f26165b.m10637l("Synthetic");
                    }
                } else {
                    str3 = "EnclosingMethod";
                }
                if (this.f26179p != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("Signature");
                }
                if (this.f26180q != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("SourceFile");
                }
                C12414c c12414c2 = this.f26181r;
                if (c12414c2 != null) {
                    i++;
                    iM10523a3 += c12414c2.f26154b + 6;
                    this.f26165b.m10637l("SourceDebugExtension");
                }
                if ((this.f26166c & 131072) != 0) {
                    i++;
                    iM10523a3 += 6;
                    this.f26165b.m10637l("Deprecated");
                }
                C12412a c12412a5 = this.f26182s;
                if (c12412a5 != null) {
                    i++;
                    iM10523a3 += c12412a5.m10518a("RuntimeVisibleAnnotations");
                }
                C12412a c12412a6 = this.f26183t;
                if (c12412a6 != null) {
                    i++;
                    iM10523a3 += c12412a6.m10518a("RuntimeInvisibleAnnotations");
                }
                C12412a c12412a7 = this.f26184u;
                if (c12412a7 != null) {
                    i++;
                    iM10523a3 += c12412a7.m10518a("RuntimeVisibleTypeAnnotations");
                }
                C12412a c12412a8 = this.f26185v;
                if (c12412a8 != null) {
                    i++;
                    iM10523a3 += c12412a8.m10518a("RuntimeInvisibleTypeAnnotations");
                }
                C12433v c12433v2 = this.f26165b;
                if (c12433v2.f26356j != null) {
                    c12433v2.m10637l("BootstrapMethods");
                    i2 = c12433v2.f26356j.f26154b + 8;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    i++;
                    C12433v c12433v3 = this.f26165b;
                    if (c12433v3.f26356j != null) {
                        c12433v3.m10637l("BootstrapMethods");
                        i6 = c12433v3.f26356j.f26154b + 8;
                    } else {
                        i6 = 0;
                    }
                    iM10523a3 += i6;
                }
                C12430s c12430s = this.f26186w;
                String str6 = "ModuleMainClass";
                int i9 = i8;
                if (c12430s != null) {
                    i += (c12430s.f26330o > 0 ? 1 : 0) + 1 + (c12430s.f26332q > 0 ? 1 : 0);
                    c12430s.f26316a.m10637l("Module");
                    int i10 = c12430s.f26321f.f26154b + 22 + c12430s.f26323h.f26154b + c12430s.f26325j.f26154b + c12430s.f26327l.f26154b + c12430s.f26329n.f26154b;
                    if (c12430s.f26330o > 0) {
                        c12430s.f26316a.m10637l("ModulePackages");
                        i10 += c12430s.f26331p.f26154b + 8;
                    }
                    if (c12430s.f26332q > 0) {
                        c12430s.f26316a.m10637l("ModuleMainClass");
                        i10 += 8;
                    }
                    iM10523a3 += i10;
                }
                if (this.f26187x != 0) {
                    i++;
                    iM10523a3 += 8;
                    this.f26165b.m10637l("NestHost");
                }
                C12414c c12414c3 = this.f26189z;
                if (c12414c3 != null) {
                    i++;
                    iM10523a3 += c12414c3.f26154b + 8;
                    this.f26165b.m10637l("NestMembers");
                }
                C12413b c12413b2 = this.f26162A;
                if (c12413b2 != null) {
                    int iM10525c = i + c12413b2.m10525c();
                    iM10523a3 += this.f26162A.m10523a(this.f26165b);
                    i = iM10525c;
                }
                C12433v c12433v4 = this.f26165b;
                int i11 = iM10523a3 + c12433v4.f26354h.f26154b;
                int i12 = c12433v4.f26353g;
                if (i12 > 65535) {
                    throw new ClassTooLargeException(this.f26165b.f26350d, i12);
                }
                C12414c c12414c4 = new C12414c(i11);
                c12414c4.m10537i(-889275714);
                c12414c4.m10537i(this.f26164a);
                C12433v c12433v5 = this.f26165b;
                c12414c4.m10538j(c12433v5.f26353g);
                C12414c c12414c5 = c12433v5.f26354h;
                c12414c4.m10536h(c12414c5.f26153a, 0, c12414c5.f26154b);
                c12414c4.m10538j((~((this.f26164a & 65535) < 49 ? 4096 : 0)) & this.f26166c);
                c12414c4.m10538j(this.f26167d);
                c12414c4.m10538j(this.f26168e);
                c12414c4.m10538j(this.f26169f);
                for (int i13 = 0; i13 < this.f26169f; i13++) {
                    c12414c4.m10538j(this.f26170g[i13]);
                }
                c12414c4.m10538j(i7);
                C12423l c12423l2 = this.f26171h;
                while (c12423l2 != null) {
                    boolean z2 = c12423l2.f26217b.f26349c < 49;
                    c12414c4.m10538j((~(z2 ? 4096 : 0)) & c12423l2.f26218c);
                    c12414c4.m10538j(c12423l2.f26219d);
                    c12414c4.m10538j(c12423l2.f26220e);
                    int iM10525c2 = c12423l2.f26222g != 0 ? 1 : 0;
                    int i14 = c12423l2.f26218c;
                    String str7 = str6;
                    if ((i14 & 4096) != 0 && z2) {
                        iM10525c2++;
                    }
                    if (c12423l2.f26221f != 0) {
                        iM10525c2++;
                    }
                    if ((i14 & 131072) != 0) {
                        iM10525c2++;
                    }
                    if (c12423l2.f26223h != null) {
                        iM10525c2++;
                    }
                    if (c12423l2.f26224i != null) {
                        iM10525c2++;
                    }
                    if (c12423l2.f26225j != null) {
                        iM10525c2++;
                    }
                    if (c12423l2.f26226k != null) {
                        iM10525c2++;
                    }
                    C12413b c12413b3 = c12423l2.f26227l;
                    if (c12413b3 != null) {
                        iM10525c2 += c12413b3.m10525c();
                    }
                    c12414c4.m10538j(iM10525c2);
                    if (c12423l2.f26222g != 0) {
                        C1643a.m878t0(c12423l2.f26217b, "ConstantValue", c12414c4, 2);
                        c12414c4.m10538j(c12423l2.f26222g);
                    }
                    if ((c12423l2.f26218c & 4096) != 0 && z2) {
                        C1643a.m878t0(c12423l2.f26217b, "Synthetic", c12414c4, 0);
                    }
                    if (c12423l2.f26221f != 0) {
                        C1643a.m878t0(c12423l2.f26217b, "Signature", c12414c4, 2);
                        c12414c4.m10538j(c12423l2.f26221f);
                    }
                    if ((c12423l2.f26218c & 131072) != 0) {
                        C1643a.m878t0(c12423l2.f26217b, "Deprecated", c12414c4, 0);
                    }
                    C12412a c12412a9 = c12423l2.f26223h;
                    if (c12412a9 != null) {
                        c12412a9.m10519c(c12423l2.f26217b.m10637l("RuntimeVisibleAnnotations"), c12414c4);
                    }
                    C12412a c12412a10 = c12423l2.f26224i;
                    if (c12412a10 != null) {
                        c12412a10.m10519c(c12423l2.f26217b.m10637l("RuntimeInvisibleAnnotations"), c12414c4);
                    }
                    C12412a c12412a11 = c12423l2.f26225j;
                    if (c12412a11 != null) {
                        str4 = str2;
                        c12412a11.m10519c(c12423l2.f26217b.m10637l(str4), c12414c4);
                    } else {
                        str4 = str2;
                    }
                    C12412a c12412a12 = c12423l2.f26226k;
                    if (c12412a12 != null) {
                        str5 = str;
                        c12412a12.m10519c(c12423l2.f26217b.m10637l(str5), c12414c4);
                    } else {
                        str5 = str;
                    }
                    C12413b c12413b4 = c12423l2.f26227l;
                    if (c12413b4 != null) {
                        c12413b4.m10526d(c12423l2.f26217b, c12414c4);
                    }
                    c12423l2 = (C12423l) c12423l2.f26216a;
                    str2 = str4;
                    str = str5;
                    str6 = str7;
                }
                String str8 = str6;
                String str9 = str;
                String str10 = str2;
                c12414c4.m10538j(i9);
                boolean z3 = false;
                boolean z4 = false;
                for (C12429r c12429r2 = this.f26173j; c12429r2 != null; c12429r2 = (C12429r) c12429r2.f26263b) {
                    z4 |= c12429r2.f26310u > 0;
                    z3 |= c12429r2.f26289Y;
                    c12429r2.m10619y(c12414c4);
                }
                c12414c4.m10538j(i);
                if (this.f26176m != null) {
                    c12414c4.m10538j(this.f26165b.m10637l("InnerClasses"));
                    c12414c4.m10537i(this.f26176m.f26154b + 2);
                    c12414c4.m10538j(this.f26175l);
                    C12414c c12414c6 = this.f26176m;
                    c12414c4.m10536h(c12414c6.f26153a, 0, c12414c6.f26154b);
                }
                if (this.f26177n != 0) {
                    C1643a.m878t0(this.f26165b, str3, c12414c4, 4);
                    c12414c4.m10538j(this.f26177n);
                    c12414c4.m10538j(this.f26178o);
                }
                if ((this.f26166c & 4096) != 0 && (this.f26164a & 65535) < 49) {
                    C1643a.m878t0(this.f26165b, "Synthetic", c12414c4, 0);
                }
                if (this.f26179p != 0) {
                    i3 = 2;
                    C1643a.m878t0(this.f26165b, "Signature", c12414c4, 2);
                    c12414c4.m10538j(this.f26179p);
                } else {
                    i3 = 2;
                }
                if (this.f26180q != 0) {
                    C1643a.m878t0(this.f26165b, "SourceFile", c12414c4, i3);
                    c12414c4.m10538j(this.f26180q);
                }
                C12414c c12414c7 = this.f26181r;
                if (c12414c7 != null) {
                    int i15 = c12414c7.f26154b;
                    C1643a.m878t0(this.f26165b, "SourceDebugExtension", c12414c4, i15);
                    i4 = 0;
                    c12414c4.m10536h(this.f26181r.f26153a, 0, i15);
                } else {
                    i4 = 0;
                }
                if ((this.f26166c & 131072) != 0) {
                    C1643a.m878t0(this.f26165b, "Deprecated", c12414c4, i4);
                }
                C12412a c12412a13 = this.f26182s;
                if (c12412a13 != null) {
                    c12412a13.m10519c(this.f26165b.m10637l("RuntimeVisibleAnnotations"), c12414c4);
                }
                C12412a c12412a14 = this.f26183t;
                if (c12412a14 != null) {
                    c12412a14.m10519c(this.f26165b.m10637l("RuntimeInvisibleAnnotations"), c12414c4);
                }
                C12412a c12412a15 = this.f26184u;
                if (c12412a15 != null) {
                    c12412a15.m10519c(this.f26165b.m10637l(str10), c12414c4);
                }
                C12412a c12412a16 = this.f26185v;
                if (c12412a16 != null) {
                    c12412a16.m10519c(this.f26165b.m10637l(str9), c12414c4);
                }
                C12433v c12433v6 = this.f26165b;
                if (c12433v6.f26356j != null) {
                    c12414c4.m10538j(c12433v6.m10637l("BootstrapMethods"));
                    c12414c4.m10537i(c12433v6.f26356j.f26154b + 2);
                    c12414c4.m10538j(c12433v6.f26355i);
                    C12414c c12414c8 = c12433v6.f26356j;
                    c12414c4.m10536h(c12414c8.f26153a, 0, c12414c8.f26154b);
                }
                C12430s c12430s2 = this.f26186w;
                if (c12430s2 != null) {
                    C1643a.m878t0(c12430s2.f26316a, "Module", c12414c4, c12430s2.f26321f.f26154b + 16 + c12430s2.f26323h.f26154b + c12430s2.f26325j.f26154b + c12430s2.f26327l.f26154b + c12430s2.f26329n.f26154b);
                    c12414c4.m10538j(c12430s2.f26317b);
                    c12414c4.m10538j(c12430s2.f26318c);
                    c12414c4.m10538j(c12430s2.f26319d);
                    c12414c4.m10538j(c12430s2.f26320e);
                    C12414c c12414c9 = c12430s2.f26321f;
                    c12414c4.m10536h(c12414c9.f26153a, 0, c12414c9.f26154b);
                    c12414c4.m10538j(c12430s2.f26322g);
                    C12414c c12414c10 = c12430s2.f26323h;
                    c12414c4.m10536h(c12414c10.f26153a, 0, c12414c10.f26154b);
                    c12414c4.m10538j(c12430s2.f26324i);
                    C12414c c12414c11 = c12430s2.f26325j;
                    c12414c4.m10536h(c12414c11.f26153a, 0, c12414c11.f26154b);
                    c12414c4.m10538j(c12430s2.f26326k);
                    C12414c c12414c12 = c12430s2.f26327l;
                    c12414c4.m10536h(c12414c12.f26153a, 0, c12414c12.f26154b);
                    c12414c4.m10538j(c12430s2.f26328m);
                    C12414c c12414c13 = c12430s2.f26329n;
                    c12414c4.m10536h(c12414c13.f26153a, 0, c12414c13.f26154b);
                    if (c12430s2.f26330o > 0) {
                        c12414c4.m10538j(c12430s2.f26316a.m10637l("ModulePackages"));
                        c12414c4.m10537i(c12430s2.f26331p.f26154b + 2);
                        c12414c4.m10538j(c12430s2.f26330o);
                        C12414c c12414c14 = c12430s2.f26331p;
                        c12414c4.m10536h(c12414c14.f26153a, 0, c12414c14.f26154b);
                    }
                    if (c12430s2.f26332q > 0) {
                        i5 = 2;
                        C1643a.m878t0(c12430s2.f26316a, str8, c12414c4, 2);
                        c12414c4.m10538j(c12430s2.f26332q);
                    } else {
                        i5 = 2;
                    }
                } else {
                    i5 = 2;
                }
                if (this.f26187x != 0) {
                    C1643a.m878t0(this.f26165b, "NestHost", c12414c4, i5);
                    c12414c4.m10538j(this.f26187x);
                }
                if (this.f26189z != null) {
                    c12414c4.m10538j(this.f26165b.m10637l("NestMembers"));
                    c12414c4.m10537i(this.f26189z.f26154b + 2);
                    c12414c4.m10538j(this.f26188y);
                    C12414c c12414c15 = this.f26189z;
                    c12414c4.m10536h(c12414c15.f26153a, 0, c12414c15.f26154b);
                }
                C12413b c12413b5 = this.f26162A;
                if (c12413b5 != null) {
                    c12413b5.m10526d(this.f26165b, c12414c4);
                }
                return z3 ? m10563a(c12414c4.f26153a, z4) : c12414c4.f26153a;
            }
            int i16 = i8 + 1;
            if (c12429r.f26291a0 != 0) {
                iM10523a2 = c12429r.f26292b0 + 6;
                i16 = i16;
            } else {
                int i17 = c12429r.f26301l.f26154b;
                if (i17 <= 0) {
                    i16 = i16;
                    iM10518a = 8;
                } else {
                    if (i17 > 65535) {
                        throw new MethodTooLargeException(c12429r.f26293d.f26350d, c12429r.f26296g, c12429r.f26298i, c12429r.f26301l.f26154b);
                    }
                    c12429r.f26293d.m10637l("Code");
                    int i18 = c12429r.f26301l.f26154b + iM10523a;
                    int i19 = 0;
                    for (C12426o c12426o = c12429r.f26302m; c12426o != null; c12426o = c12426o.f26247f) {
                        i19++;
                    }
                    iM10518a = (i19 * 8) + 2 + i18 + 8;
                    if (c12429r.f26311v != null) {
                        C12433v c12433v7 = c12429r.f26293d;
                        c12433v7.m10637l(c12433v7.f26349c >= 50 ? "StackMapTable" : "StackMap");
                        iM10518a += c12429r.f26311v.f26154b + 8;
                    }
                    if (c12429r.f26305p != null) {
                        c12429r.f26293d.m10637l("LineNumberTable");
                        iM10518a += c12429r.f26305p.f26154b + 8;
                    }
                    if (c12429r.f26307r != null) {
                        c12429r.f26293d.m10637l("LocalVariableTable");
                        iM10518a += c12429r.f26307r.f26154b + 8;
                    }
                    if (c12429r.f26309t != null) {
                        c12429r.f26293d.m10637l("LocalVariableTypeTable");
                        iM10518a += c12429r.f26309t.f26154b + 8;
                    }
                    C12412a c12412a17 = c12429r.f26312w;
                    if (c12412a17 != null) {
                        iM10518a += c12412a17.m10518a("RuntimeVisibleTypeAnnotations");
                    }
                    C12412a c12412a18 = c12429r.f26313x;
                    if (c12412a18 != null) {
                        iM10518a += c12412a18.m10518a("RuntimeInvisibleTypeAnnotations");
                    }
                }
                if (c12429r.f26314y > 0) {
                    c12429r.f26293d.m10637l("Exceptions");
                    iM10518a += (c12429r.f26314y * 2) + 8;
                }
                C12433v c12433v8 = c12429r.f26293d;
                boolean z5 = c12433v8.f26349c < 49;
                if ((c12429r.f26294e & 4096) != 0 && z5) {
                    c12433v8.m10637l("Synthetic");
                    iM10518a += 6;
                }
                if (c12429r.f26265A != 0) {
                    c12429r.f26293d.m10637l("Signature");
                    iM10518a += 8;
                }
                if ((c12429r.f26294e & 131072) != 0) {
                    c12429r.f26293d.m10637l("Deprecated");
                    iM10518a += 6;
                }
                C12412a c12412a19 = c12429r.f26266B;
                if (c12412a19 != null) {
                    iM10518a += c12412a19.m10518a("RuntimeVisibleAnnotations");
                }
                C12412a c12412a20 = c12429r.f26267C;
                if (c12412a20 != null) {
                    iM10518a += c12412a20.m10518a("RuntimeInvisibleAnnotations");
                }
                C12412a[] c12412aArr = c12429r.f26269E;
                if (c12412aArr != null) {
                    int length = c12429r.f26268D;
                    if (length == 0) {
                        length = c12412aArr.length;
                    }
                    iM10518a += C12412a.m10516b("RuntimeVisibleParameterAnnotations", c12412aArr, length);
                }
                C12412a[] c12412aArr2 = c12429r.f26271G;
                if (c12412aArr2 != null) {
                    int length2 = c12429r.f26270F;
                    if (length2 == 0) {
                        length2 = c12412aArr2.length;
                    }
                    iM10518a += C12412a.m10516b("RuntimeInvisibleParameterAnnotations", c12412aArr2, length2);
                }
                C12412a c12412a21 = c12429r.f26272H;
                if (c12412a21 != null) {
                    iM10518a += c12412a21.m10518a("RuntimeVisibleTypeAnnotations");
                }
                C12412a c12412a22 = c12429r.f26273I;
                if (c12412a22 != null) {
                    iM10518a += c12412a22.m10518a("RuntimeInvisibleTypeAnnotations");
                }
                if (c12429r.f26274J != null) {
                    c12429r.f26293d.m10637l("AnnotationDefault");
                    iM10518a += c12429r.f26274J.f26154b + 6;
                }
                if (c12429r.f26276L != null) {
                    c12429r.f26293d.m10637l("MethodParameters");
                    iM10523a2 = c12429r.f26276L.f26154b + 7 + iM10518a;
                } else {
                    iM10523a2 = iM10518a;
                }
                C12413b c12413b6 = c12429r.f26277M;
                if (c12413b6 != null) {
                    iM10523a2 += c12413b6.m10523a(c12429r.f26293d);
                }
            }
            iM10523a3 += iM10523a2;
            c12429r = (C12429r) c12429r.f26263b;
            iM10523a = 16;
            i8 = i16;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m10565c(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f26164a = i;
        this.f26166c = i2;
        C12433v c12433v = this.f26165b;
        int i3 = i & 65535;
        c12433v.f26349c = i3;
        c12433v.f26350d = str;
        this.f26167d = c12433v.m10638m(7, str).f26340a;
        if (str2 != null) {
            this.f26179p = this.f26165b.m10637l(str2);
        }
        this.f26168e = str3 == null ? 0 : this.f26165b.m10638m(7, str3).f26340a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f26169f = length;
            this.f26170g = new int[length];
            for (int i4 = 0; i4 < this.f26169f; i4++) {
                this.f26170g[i4] = this.f26165b.m10628c(strArr[i4]).f26340a;
            }
        }
        if (this.f26163B != 1 || i3 < 51) {
            return;
        }
        this.f26163B = 2;
    }

    /* JADX INFO: renamed from: d */
    public final C12412a m10566d(String str, boolean z2) {
        C12414c c12414c = new C12414c();
        c12414c.m10538j(this.f26165b.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26165b, true, c12414c, this.f26182s);
            this.f26182s = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26165b, true, c12414c, this.f26183t);
        this.f26183t = c12412a2;
        return c12412a2;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC12428q m10567e(int i, String str, String str2, String str3, String[] strArr) {
        C12429r c12429r = new C12429r(this.f26165b, i, str, str2, str3, strArr, this.f26163B);
        if (this.f26173j == null) {
            this.f26173j = c12429r;
        } else {
            this.f26174k.f26263b = c12429r;
        }
        this.f26174k = c12429r;
        return c12429r;
    }

    /* JADX INFO: renamed from: f */
    public final C12412a m10568f(int i, C12435x c12435x, String str, boolean z2) {
        C12414c c12414c = new C12414c();
        C3404f.m4256W0(i, c12414c);
        C12435x.m10655a(c12435x, c12414c);
        c12414c.m10538j(this.f26165b.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26165b, true, c12414c, this.f26184u);
            this.f26184u = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26165b, true, c12414c, this.f26185v);
        this.f26185v = c12412a2;
        return c12412a2;
    }
}
