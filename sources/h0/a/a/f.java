package h0.a.a;

import org.objectweb.asm.ClassTooLargeException;
import org.objectweb.asm.MethodTooLargeException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ClassWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends e {
    public b A;
    public int B;
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f3701b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int[] g;
    public l h;
    public l i;
    public r j;
    public r k;
    public int l;
    public c m;
    public int n;
    public int o;
    public int p;
    public int q;
    public c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f3702s;
    public a t;
    public a u;
    public a v;
    public s w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3704y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f3705z;

    public f(int i) {
        super(Opcodes.ASM7);
        this.f3701b = new v(this);
        if ((i & 2) != 0) {
            this.B = 4;
        } else if ((i & 1) != 0) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:412:0x0acf  */
    public final byte[] a(byte[] bArr, boolean z2) {
        String strG;
        b bVar;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        f fVar;
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
        d dVar;
        String str31;
        int i5;
        String[] strArr;
        String[] strArr2;
        int i6;
        String str32;
        b$a b_a = new b$a();
        b_a.a(this.A);
        for (l lVar = this.h; lVar != null; lVar = (l) lVar.a) {
            b_a.a(lVar.l);
        }
        r rVar = this.j;
        while (true) {
            strG = null;
            if (rVar == null) {
                break;
            }
            b_a.a(rVar.M);
            b_a.a(null);
            rVar = (r) rVar.f3715b;
        }
        int i7 = b_a.a;
        b[] bVarArr = new b[i7];
        System.arraycopy(b_a.f3698b, 0, bVarArr, 0, i7);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.f3702s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.f3703x = 0;
        this.f3704y = 0;
        this.f3705z = null;
        this.A = null;
        this.B = z2 ? 3 : 0;
        d dVar2 = new d(bArr, 0, false);
        int i8 = (z2 ? 8 : 0) | 256;
        h hVar = new h();
        hVar.a = bVarArr;
        hVar.f3707b = i8;
        char[] cArr = new char[dVar2.f];
        hVar.c = cArr;
        int i9 = dVar2.g;
        int iU = dVar2.u(i9);
        String strG2 = dVar2.g(i9 + 2, cArr);
        String strG3 = dVar2.g(i9 + 4, cArr);
        int iU2 = dVar2.u(i9 + 6);
        String[] strArr3 = new String[iU2];
        int i10 = i9 + 8;
        for (int i11 = 0; i11 < iU2; i11++) {
            strArr3[i11] = dVar2.g(i10, cArr);
            i10 += 2;
        }
        int iC = dVar2.c();
        String strT = null;
        b bVarE = null;
        String strT2 = null;
        String strG4 = null;
        int i12 = iU;
        int iU3 = dVar2.u(iC - 2);
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
        String strV = null;
        while (true) {
            bVar = bVarE;
            str = strT;
            str2 = "Synthetic";
            str3 = strV;
            str4 = "Deprecated";
            i = i13;
            str5 = strG;
            str6 = "RuntimeVisibleAnnotations";
            if (iU3 <= 0) {
                break;
            }
            String strT3 = dVar2.t(iC, cArr);
            int i22 = i10;
            int iL = dVar2.l(iC + 2);
            int i23 = iC + 6;
            h hVar2 = hVar;
            if ("SourceFile".equals(strT3)) {
                strT = dVar2.t(i23, cArr);
                strV = str3;
                i13 = i;
                strG = str5;
            } else {
                if ("InnerClasses".equals(strT3)) {
                    i21 = i23;
                } else if ("EnclosingMethod".equals(strT3)) {
                    i15 = i23;
                } else if ("NestHost".equals(strT3)) {
                    strG4 = dVar2.g(i23, cArr);
                } else if ("NestMembers".equals(strT3)) {
                    i20 = i23;
                } else if ("Signature".equals(strT3)) {
                    strT2 = dVar2.t(i23, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strT3)) {
                    i16 = i23;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strT3)) {
                    i18 = i23;
                } else if ("Deprecated".equals(strT3)) {
                    i12 |= 131072;
                } else if ("Synthetic".equals(strT3)) {
                    i12 |= 4096;
                } else {
                    if ("SourceDebugExtension".equals(strT3)) {
                        strV = dVar2.v(i23, iL, new char[iL]);
                        i13 = i;
                        strG = str5;
                        strT = str;
                    } else if ("RuntimeInvisibleAnnotations".equals(strT3)) {
                        i17 = i23;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strT3)) {
                        i19 = i23;
                    } else if ("Module".equals(strT3)) {
                        i13 = i23;
                        strG = str5;
                        strV = str3;
                        strT = str;
                    } else if ("ModuleMainClass".equals(strT3)) {
                        strG = dVar2.g(i23, cArr);
                        i13 = i;
                        strV = str3;
                        strT = str;
                    } else if ("ModulePackages".equals(strT3)) {
                        i14 = i23;
                    } else {
                        if ("BootstrapMethods".equals(strT3)) {
                            i6 = i23;
                            str32 = str3;
                            bVarE = bVar;
                        } else {
                            i6 = i23;
                            str32 = str3;
                            bVarE = dVar2.e(bVarArr, strT3, i6, iL, cArr, -1, null);
                            bVarE.c = bVar;
                        }
                        strT = str;
                        i13 = i;
                        i12 = i12;
                        strG = str5;
                        strV = str32;
                    }
                    iC = i6 + iL;
                    iU3--;
                    strArr4 = strArr4;
                    i10 = i22;
                    hVar = hVar2;
                }
                i13 = i;
                strG = str5;
                strV = str3;
                strT = str;
            }
            bVarE = bVar;
            i6 = i23;
            strArr4 = strArr4;
            iC = i6 + iL;
            iU3--;
            strArr4 = strArr4;
            i10 = i22;
            hVar = hVar2;
        }
        int i24 = i10;
        String str33 = "RuntimeInvisibleTypeAnnotations";
        String str34 = "RuntimeInvisibleAnnotations";
        h hVar3 = hVar;
        d dVar3 = dVar2;
        String str35 = "RuntimeVisibleTypeAnnotations";
        c(dVar2.l(dVar2.f3700b[1] - 7), i12, strG2, strT2, strG3, strArr4);
        if ((i8 & 2) != 0 || (str == null && str3 == null)) {
            fVar = this;
            str7 = "Signature";
        } else {
            fVar = this;
            str7 = "Signature";
            if (str != null) {
                fVar.q = fVar.f3701b.l(str);
            }
            if (str3 != null) {
                c cVar = new c();
                cVar.a(str3, 0, Integer.MAX_VALUE);
                fVar.r = cVar;
            }
        }
        if (i != 0) {
            char[] cArr2 = hVar3.c;
            String strT4 = dVar3.t(dVar3.f3700b[dVar3.u(i)], cArr2);
            int iU4 = dVar3.u(i + 2);
            String strT5 = dVar3.t(i + 4, cArr2);
            int i25 = i + 6;
            v vVar = fVar.f3701b;
            s sVar = new s(vVar, vVar.m(19, strT4).a, iU4, strT5 == null ? 0 : fVar.f3701b.l(strT5));
            fVar.w = sVar;
            if (str5 != null) {
                sVar.q = vVar.m(7, str5).a;
            }
            int i26 = i14;
            if (i26 != 0) {
                int iU5 = dVar3.u(i26);
                int i27 = i26 + 2;
                while (true) {
                    int i28 = iU5 - 1;
                    if (iU5 <= 0) {
                        break;
                    }
                    sVar.p.j(sVar.a.m(20, dVar3.o(i27, cArr2)).a);
                    sVar.o++;
                    i27 += 2;
                    iU5 = i28;
                }
            }
            int iU6 = dVar3.u(i25);
            int i29 = i25 + 2;
            while (true) {
                int i30 = iU6 - 1;
                if (iU6 <= 0) {
                    break;
                }
                String strN = dVar3.n(i29, cArr2);
                int iU7 = dVar3.u(i29 + 2);
                String strT6 = dVar3.t(i29 + 4, cArr2);
                i29 += 6;
                c cVar2 = sVar.f;
                String str36 = str2;
                cVar2.j(sVar.a.m(19, strN).a);
                cVar2.j(iU7);
                cVar2.j(strT6 == null ? 0 : sVar.a.l(strT6));
                sVar.e++;
                iU6 = i30;
                str2 = str36;
            }
            str8 = str2;
            int iU8 = dVar3.u(i29);
            int i31 = i29 + 2;
            while (true) {
                int i32 = iU8 - 1;
                if (iU8 <= 0) {
                    break;
                }
                String strO = dVar3.o(i31, cArr2);
                int iU9 = dVar3.u(i31 + 2);
                int iU10 = dVar3.u(i31 + 4);
                i31 += 6;
                if (iU10 != 0) {
                    strArr2 = new String[iU10];
                    int i33 = i31;
                    for (int i34 = 0; i34 < iU10; i34++) {
                        strArr2[i34] = dVar3.n(i33, cArr2);
                        i33 += 2;
                    }
                    i31 = i33;
                } else {
                    strArr2 = null;
                }
                c cVar3 = sVar.h;
                cVar3.j(sVar.a.m(20, strO).a);
                cVar3.j(iU9);
                if (strArr2 == null) {
                    sVar.h.j(0);
                } else {
                    sVar.h.j(strArr2.length);
                    for (String str37 : strArr2) {
                        sVar.h.j(sVar.a.j(str37).a);
                    }
                }
                sVar.g++;
                iU8 = i32;
            }
            int iU11 = dVar3.u(i31);
            int i35 = i31 + 2;
            while (true) {
                int i36 = iU11 - 1;
                if (iU11 <= 0) {
                    break;
                }
                String strO2 = dVar3.o(i35, cArr2);
                int iU12 = dVar3.u(i35 + 2);
                int iU13 = dVar3.u(i35 + 4);
                i35 += 6;
                if (iU13 != 0) {
                    strArr = new String[iU13];
                    int i37 = i35;
                    for (int i38 = 0; i38 < iU13; i38++) {
                        strArr[i38] = dVar3.n(i37, cArr2);
                        i37 += 2;
                    }
                    i35 = i37;
                } else {
                    strArr = null;
                }
                c cVar4 = sVar.j;
                cVar4.j(sVar.a.m(20, strO2).a);
                cVar4.j(iU12);
                if (strArr == null) {
                    sVar.j.j(0);
                } else {
                    sVar.j.j(strArr.length);
                    for (String str38 : strArr) {
                        sVar.j.j(sVar.a.j(str38).a);
                    }
                }
                sVar.i++;
                iU11 = i36;
            }
            int iU14 = dVar3.u(i35);
            int i39 = i35 + 2;
            while (true) {
                int i40 = iU14 - 1;
                if (iU14 <= 0) {
                    break;
                }
                sVar.l.j(sVar.a.m(7, dVar3.g(i39, cArr2)).a);
                sVar.k++;
                i39 += 2;
                iU14 = i40;
            }
            int iU15 = dVar3.u(i39);
            int i41 = i39 + 2;
            while (true) {
                int i42 = iU15 - 1;
                if (iU15 <= 0) {
                    break;
                }
                String strG5 = dVar3.g(i41, cArr2);
                int iU16 = dVar3.u(i41 + 2);
                String[] strArr5 = new String[iU16];
                int i43 = i41 + 4;
                for (int i44 = 0; i44 < iU16; i44++) {
                    strArr5[i44] = dVar3.g(i43, cArr2);
                    i43 += 2;
                }
                char[] cArr3 = cArr2;
                sVar.n.j(sVar.a.m(7, strG5).a);
                sVar.n.j(iU16);
                for (int i45 = 0; i45 < iU16; i45++) {
                    sVar.n.j(sVar.a.c(strArr5[i45]).a);
                }
                sVar.m++;
                iU15 = i42;
                i41 = i43;
                cArr2 = cArr3;
            }
        } else {
            str8 = "Synthetic";
        }
        String str39 = strG4;
        if (str39 != null) {
            fVar.f3703x = fVar.f3701b.m(7, str39).a;
        }
        int i46 = i15;
        if (i46 != 0) {
            String strG6 = dVar3.g(i46, cArr);
            int iU17 = dVar3.u(i46 + 2);
            String strT7 = iU17 == 0 ? null : dVar3.t(dVar3.f3700b[iU17], cArr);
            String strT8 = iU17 == 0 ? null : dVar3.t(dVar3.f3700b[iU17] + 2, cArr);
            fVar.n = fVar.f3701b.m(7, strG6).a;
            if (strT7 != null && strT8 != null) {
                fVar.o = fVar.f3701b.k(strT7, strT8);
            }
        }
        int i47 = i16;
        if (i47 != 0) {
            int iU18 = dVar3.u(i47);
            int iK = i47 + 2;
            while (true) {
                int i48 = iU18 - 1;
                if (iU18 <= 0) {
                    break;
                }
                iK = dVar3.k(fVar.d(dVar3.t(iK, cArr), true), iK + 2, true, cArr);
                iU18 = i48;
            }
        }
        int i49 = i17;
        if (i49 != 0) {
            int iU19 = dVar3.u(i49);
            int iK2 = i49 + 2;
            while (true) {
                int i50 = iU19 - 1;
                if (iU19 <= 0) {
                    break;
                }
                iK2 = dVar3.k(fVar.d(dVar3.t(iK2, cArr), false), iK2 + 2, true, cArr);
                iU19 = i50;
            }
        }
        int i51 = i18;
        if (i51 != 0) {
            int iU20 = dVar3.u(i51);
            int iK3 = i51 + 2;
            while (true) {
                int i52 = iU20 - 1;
                if (iU20 <= 0) {
                    break;
                }
                int iR = dVar3.r(hVar3, iK3);
                iK3 = dVar3.k(fVar.f(hVar3.h, hVar3.i, dVar3.t(iR, cArr), true), iR + 2, true, cArr);
                iU20 = i52;
            }
        }
        int i53 = i19;
        if (i53 != 0) {
            int iU21 = dVar3.u(i53);
            int iK4 = i53 + 2;
            while (true) {
                int i54 = iU21 - 1;
                if (iU21 <= 0) {
                    break;
                }
                int iR2 = dVar3.r(hVar3, iK4);
                iK4 = dVar3.k(fVar.f(hVar3.h, hVar3.i, dVar3.t(iR2, cArr), false), iR2 + 2, true, cArr);
                iU21 = i54;
            }
        }
        b bVar2 = bVar;
        while (bVar2 != null) {
            b bVar3 = bVar2.c;
            bVar2.c = null;
            bVar2.c = fVar.A;
            fVar.A = bVar2;
            bVar2 = bVar3;
        }
        int i55 = i20;
        if (i55 != 0) {
            int iU22 = dVar3.u(i55);
            int i56 = i55 + 2;
            while (true) {
                int i57 = iU22 - 1;
                if (iU22 <= 0) {
                    break;
                }
                String strG7 = dVar3.g(i56, cArr);
                if (fVar.f3705z == null) {
                    fVar.f3705z = new c();
                }
                fVar.f3704y++;
                fVar.f3705z.j(fVar.f3701b.m(7, strG7).a);
                i56 += 2;
                iU22 = i57;
            }
        }
        int i58 = i21;
        if (i58 != 0) {
            int iU23 = dVar3.u(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = iU23 - 1;
                if (iU23 <= 0) {
                    break;
                }
                String strG8 = dVar3.g(i59, cArr);
                String strG9 = dVar3.g(i59 + 2, cArr);
                String strT9 = dVar3.t(i59 + 4, cArr);
                int iU24 = dVar3.u(i59 + 6);
                if (fVar.m == null) {
                    fVar.m = new c();
                }
                u uVarM = fVar.f3701b.m(7, strG8);
                if (uVarM.g == 0) {
                    fVar.l++;
                    fVar.m.j(uVarM.a);
                    fVar.m.j(strG9 == null ? 0 : fVar.f3701b.m(7, strG9).a);
                    fVar.m.j(strT9 == null ? 0 : fVar.f3701b.l(strT9));
                    fVar.m.j(iU24);
                    uVarM.g = fVar.l;
                }
                i59 += 8;
                iU23 = i60;
            }
        }
        int iU25 = dVar3.u(i24);
        int i61 = i24 + 2;
        while (true) {
            int i62 = iU25 - 1;
            if (iU25 <= 0) {
                break;
            }
            char[] cArr4 = hVar3.c;
            int iU26 = dVar3.u(i61);
            String strT10 = dVar3.t(i61 + 2, cArr4);
            String strT11 = dVar3.t(i61 + 4, cArr4);
            int i63 = i61 + 6;
            int iU27 = dVar3.u(i63);
            i61 = i63 + 2;
            int i64 = iU26;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            b bVar4 = null;
            int i68 = 0;
            String strT12 = null;
            Object objI = null;
            while (true) {
                int i69 = iU27 - 1;
                if (iU27 <= 0) {
                    break;
                }
                String strT13 = dVar3.t(i61, cArr4);
                int iL2 = dVar3.l(i61 + 2);
                int i70 = i61 + 6;
                if ("ConstantValue".equals(strT13)) {
                    int iU28 = dVar3.u(i70);
                    if (iU28 == 0) {
                        str22 = str8;
                        objI = null;
                    } else {
                        objI = dVar3.i(iU28, cArr4);
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
                    dVar = dVar3;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                } else {
                    if (str7.equals(strT13)) {
                        strT12 = dVar3.t(i70, cArr4);
                    } else if (str4.equals(strT13)) {
                        i64 |= 131072;
                    } else {
                        str22 = str8;
                        if (str22.equals(strT13)) {
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
                            dVar = dVar3;
                            str29 = str24;
                            i68 = i4;
                            i64 = i5;
                        } else {
                            i3 = i62;
                            String str40 = str6;
                            if (str40.equals(strT13)) {
                                str31 = str33;
                                i65 = i70;
                                str28 = str22;
                                str30 = str4;
                                str27 = str35;
                                str29 = str34;
                                str25 = str40;
                                dVar = dVar3;
                            } else {
                                int i71 = i64;
                                str23 = str35;
                                if (str23.equals(strT13)) {
                                    i67 = i70;
                                    i4 = i68;
                                    str24 = str34;
                                } else {
                                    i4 = i68;
                                    str24 = str34;
                                    if (str24.equals(strT13)) {
                                        i66 = i70;
                                    } else {
                                        str25 = str40;
                                        str26 = str33;
                                        if (str26.equals(strT13)) {
                                            i5 = i71;
                                            i4 = i70;
                                            str31 = str26;
                                            str28 = str22;
                                            str27 = str23;
                                            str30 = str4;
                                            dVar = dVar3;
                                            str29 = str24;
                                            i68 = i4;
                                            i64 = i5;
                                        } else {
                                            str27 = str23;
                                            str28 = str22;
                                            str29 = str24;
                                            str30 = str4;
                                            dVar = dVar3;
                                            str31 = str26;
                                            b bVarE2 = dVar3.e(hVar3.a, strT13, i70, iL2, cArr4, -1, null);
                                            bVarE2.c = bVar4;
                                            bVar4 = bVarE2;
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
                                dVar = dVar3;
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
                    dVar = dVar3;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                }
                i61 = i70 + iL2;
                dVar3 = dVar;
                hVar3 = hVar3;
                iU27 = i69;
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
            b bVar5 = bVar4;
            d dVar4 = dVar3;
            int i73 = i68;
            String str43 = str35;
            String str44 = str34;
            String str45 = str8;
            String str46 = str6;
            String str47 = str7;
            h hVar4 = hVar3;
            l lVar2 = new l(fVar.f3701b, i64, strT10, strT11, strT12, objI);
            if (fVar.h == null) {
                fVar.h = lVar2;
            } else {
                fVar.i.a = lVar2;
            }
            fVar.i = lVar2;
            if (i65 != 0) {
                int iU29 = dVar4.u(i65);
                int iK5 = i65 + 2;
                while (true) {
                    int i74 = iU29 - 1;
                    if (iU29 <= 0) {
                        break;
                    }
                    iK5 = dVar4.k(lVar2.a(dVar4.t(iK5, cArr4), true), iK5 + 2, true, cArr4);
                    iU29 = i74;
                }
            }
            if (i66 != 0) {
                int iU30 = dVar4.u(i66);
                int iK6 = i66 + 2;
                while (true) {
                    int i75 = iU30 - 1;
                    if (iU30 <= 0) {
                        break;
                    }
                    iK6 = dVar4.k(lVar2.a(dVar4.t(iK6, cArr4), false), iK6 + 2, true, cArr4);
                    iU30 = i75;
                }
            }
            if (i67 != 0) {
                int iU31 = dVar4.u(i67);
                int iK7 = i67 + 2;
                while (true) {
                    int i76 = iU31 - 1;
                    if (iU31 <= 0) {
                        break;
                    }
                    int iR3 = dVar4.r(hVar4, iK7);
                    iK7 = dVar4.k(lVar2.b(hVar4.h, hVar4.i, dVar4.t(iR3, cArr4), true), iR3 + 2, true, cArr4);
                    iU31 = i76;
                }
            }
            if (i73 != 0) {
                int iU32 = dVar4.u(i73);
                int iK8 = i73 + 2;
                while (true) {
                    int i77 = iU32 - 1;
                    if (iU32 <= 0) {
                        break;
                    }
                    int iR4 = dVar4.r(hVar4, iK8);
                    iK8 = dVar4.k(lVar2.b(hVar4.h, hVar4.i, dVar4.t(iR4, cArr4), false), iR4 + 2, true, cArr4);
                    iU32 = i77;
                }
            }
            b bVar6 = bVar5;
            while (bVar6 != null) {
                b bVar7 = bVar6.c;
                bVar6.c = null;
                bVar6.c = lVar2.l;
                lVar2.l = bVar6;
                bVar6 = bVar7;
            }
            dVar3 = dVar4;
            hVar3 = hVar4;
            str4 = str42;
            iU25 = i72;
            str8 = str45;
            str34 = str44;
            str33 = str41;
            str7 = str47;
            str6 = str46;
            str35 = str43;
        }
        String str48 = str33;
        String str49 = str4;
        d dVar5 = dVar3;
        String str50 = str35;
        String str51 = str34;
        String str52 = str8;
        String str53 = str6;
        String str54 = str7;
        h hVar5 = hVar3;
        int i78 = 1;
        int iU33 = dVar5.u(i61);
        int i79 = i61 + 2;
        while (true) {
            int i80 = iU33 - 1;
            if (iU33 <= 0) {
                return b();
            }
            char[] cArr5 = hVar5.c;
            hVar5.d = dVar5.u(i79);
            hVar5.e = dVar5.t(i79 + 2, cArr5);
            int i81 = i79 + 4;
            hVar5.f = dVar5.t(i81, cArr5);
            int i82 = i79 + 6;
            int iU34 = dVar5.u(i82);
            int i83 = i82 + 2;
            int i84 = 0;
            int i85 = 0;
            boolean z4 = false;
            b bVar8 = null;
            String[] strArr6 = null;
            int i86 = 0;
            int i87 = 0;
            int iU35 = 0;
            int i88 = 0;
            int i89 = 0;
            int i90 = 0;
            int i91 = 0;
            int i92 = 0;
            int i93 = 0;
            while (true) {
                int i94 = iU34 - 1;
                if (iU34 <= 0) {
                    break;
                }
                String strT14 = dVar5.t(i83, cArr5);
                int iL3 = dVar5.l(i83 + 2);
                int i95 = i83 + 6;
                if ("Code".equals(strT14)) {
                    if ((hVar5.f3707b & i78) == 0) {
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
                } else if ("Exceptions".equals(strT14)) {
                    int iU36 = dVar5.u(i95);
                    String[] strArr7 = new String[iU36];
                    int i96 = i95 + 2;
                    for (int i97 = 0; i97 < iU36; i97++) {
                        strArr7[i97] = dVar5.g(i96, cArr5);
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
                    if (str9.equals(strT14)) {
                        iU35 = dVar5.u(i95);
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
                        if (str10.equals(strT14)) {
                            hVar5.d |= 131072;
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
                            if (str11.equals(strT14)) {
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
                                if (str55.equals(strT14)) {
                                    i2 = i82;
                                    i89 = i95;
                                } else {
                                    i2 = i82;
                                    if ("AnnotationDefault".equals(strT14)) {
                                        i84 = i95;
                                    } else {
                                        str13 = str52;
                                        if (str13.equals(strT14)) {
                                            hVar5.d |= 4096;
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
                                            if (str14.equals(strT14)) {
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
                                                if (str15.equals(strT14)) {
                                                    str52 = str13;
                                                    i90 = i95;
                                                } else {
                                                    str52 = str13;
                                                    if ("RuntimeVisibleParameterAnnotations".equals(strT14)) {
                                                        i91 = i95;
                                                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strT14)) {
                                                        i92 = i95;
                                                    } else if ("MethodParameters".equals(strT14)) {
                                                        i86 = i95;
                                                    } else {
                                                        str16 = str10;
                                                        str17 = str54;
                                                        str18 = str12;
                                                        str19 = str50;
                                                        str20 = str51;
                                                        str21 = str15;
                                                        b bVarE3 = dVar5.e(hVar5.a, strT14, i95, iL3, cArr5, -1, null);
                                                        bVarE3.c = bVar8;
                                                        z4 = z4;
                                                        i85 = i85;
                                                        bVar8 = bVarE3;
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
                i83 = i95 + iL3;
                i82 = i2;
                str48 = str21;
                iU34 = i94;
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
            b bVar9 = bVar8;
            String str57 = str53;
            String str58 = str50;
            String str59 = str51;
            String str60 = str48;
            int i101 = iU35;
            String str61 = str52;
            d dVar6 = dVar5;
            str49 = str49;
            h hVar6 = hVar5;
            q qVarE = e(hVar5.d, hVar5.e, hVar5.f, i101 == 0 ? null : dVar5.w(i101, cArr5), strArr6);
            r rVar2 = (r) qVarE;
            int i102 = i83 - i79;
            boolean z6 = (hVar6.d & 131072) != 0;
            int iU37 = dVar6.u(i81);
            v vVar2 = rVar2.d;
            if (dVar6 == vVar2.f3725b && iU37 == rVar2.h && i101 == rVar2.A) {
                int i103 = rVar2.e;
                if (z6 != ((i103 & 131072) != 0)) {
                    z3 = false;
                } else if (z5 != (vVar2.c < 49 && (i103 & 4096) != 0)) {
                    z3 = false;
                } else if (i100 != 0) {
                    if (dVar6.u(i100) == rVar2.f3720y) {
                        int i104 = i100 + 2;
                        int i105 = 0;
                        while (true) {
                            if (i105 < rVar2.f3720y) {
                                if (dVar6.u(i104) != rVar2.f3721z[i105]) {
                                    z3 = false;
                                } else {
                                    i104 += 2;
                                    i105++;
                                }
                            }
                        }
                    }
                    rVar2.f3716a0 = i98;
                    rVar2.f3717b0 = i102 - 6;
                    z3 = true;
                } else if (rVar2.f3720y != 0) {
                    z3 = false;
                } else {
                    rVar2.f3716a0 = i98;
                    rVar2.f3717b0 = i102 - 6;
                    z3 = true;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i106 = i86;
                if (i106 != 0) {
                    int iF = dVar6.f(i106);
                    int i107 = i106 + 1;
                    while (true) {
                        int i108 = iF - 1;
                        if (iF <= 0) {
                            break;
                        }
                        String strT15 = dVar6.t(i107, cArr5);
                        int iU38 = dVar6.u(i107 + 2);
                        if (rVar2.L == null) {
                            rVar2.L = new c();
                        }
                        rVar2.K++;
                        c cVar5 = rVar2.L;
                        cVar5.j(strT15 == null ? 0 : rVar2.d.l(strT15));
                        cVar5.j(iU38);
                        i107 += 4;
                        iF = i108;
                    }
                }
                if (i99 != 0) {
                    c cVar6 = new c();
                    rVar2.J = cVar6;
                    a aVar = new a(rVar2.d, false, cVar6, null);
                    dVar6.j(aVar, i99, null, cArr5);
                    aVar.g();
                }
                int i109 = i87;
                if (i109 != 0) {
                    int iU39 = dVar6.u(i109);
                    int iK9 = i109 + 2;
                    while (true) {
                        int i110 = iU39 - 1;
                        if (iU39 <= 0) {
                            break;
                        }
                        iK9 = dVar6.k(qVarE.a(dVar6.t(iK9, cArr5), true), iK9 + 2, true, cArr5);
                        iU39 = i110;
                    }
                }
                int i111 = i88;
                if (i111 != 0) {
                    int iU40 = dVar6.u(i111);
                    int iK10 = i111 + 2;
                    while (true) {
                        int i112 = iU40 - 1;
                        if (iU40 <= 0) {
                            break;
                        }
                        iK10 = dVar6.k(qVarE.a(dVar6.t(iK10, cArr5), false), iK10 + 2, true, cArr5);
                        iU40 = i112;
                    }
                }
                int i113 = i89;
                if (i113 != 0) {
                    int iU41 = dVar6.u(i113);
                    int iK11 = i113 + 2;
                    while (true) {
                        int i114 = iU41 - 1;
                        if (iU41 <= 0) {
                            break;
                        }
                        int iR5 = dVar6.r(hVar6, iK11);
                        iK11 = dVar6.k(qVarE.r(hVar6.h, hVar6.i, dVar6.t(iR5, cArr5), true), iR5 + 2, true, cArr5);
                        iU41 = i114;
                    }
                }
                int i115 = i90;
                if (i115 != 0) {
                    int iU42 = dVar6.u(i115);
                    int iK12 = i115 + 2;
                    while (true) {
                        int i116 = iU42 - 1;
                        if (iU42 <= 0) {
                            break;
                        }
                        int iR6 = dVar6.r(hVar6, iK12);
                        iK12 = dVar6.k(qVarE.r(hVar6.h, hVar6.i, dVar6.t(iR6, cArr5), false), iR6 + 2, true, cArr5);
                        iU42 = i116;
                    }
                }
                int i117 = i91;
                if (i117 != 0) {
                    dVar6.p(qVarE, hVar6, i117, true);
                }
                int i118 = i92;
                if (i118 != 0) {
                    dVar6.p(qVarE, hVar6, i118, false);
                }
                b bVar10 = bVar9;
                while (bVar10 != null) {
                    b bVar11 = bVar10.c;
                    bVar10.c = null;
                    bVar10.c = rVar2.M;
                    rVar2.M = bVar10;
                    bVar10 = bVar11;
                }
                int i119 = i93;
                if (i119 != 0) {
                    dVar6.h(qVarE, hVar6, i119);
                }
            }
            iU33 = i80;
            i79 = i83;
            dVar5 = dVar6;
            hVar5 = hVar6;
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
    public byte[] b() throws MethodTooLargeException, ClassTooLargeException {
        String str;
        String str2;
        int iA;
        int i;
        String str3;
        int i2;
        int i3;
        int i4;
        int i5;
        String str4;
        String str5;
        int i6;
        int iA2;
        int iA3;
        int iA4 = (this.f * 2) + 24;
        l lVar = this.h;
        int i7 = 0;
        while (true) {
            str = "RuntimeInvisibleTypeAnnotations";
            str2 = "RuntimeVisibleTypeAnnotations";
            iA = 16;
            if (lVar == null) {
                break;
            }
            i7++;
            if (lVar.g != 0) {
                lVar.f3710b.l("ConstantValue");
            } else {
                iA = 8;
            }
            if ((lVar.c & 4096) != 0) {
                v vVar = lVar.f3710b;
                if (vVar.c < 49) {
                    vVar.l("Synthetic");
                    iA += 6;
                }
            }
            if (lVar.f != 0) {
                lVar.f3710b.l("Signature");
                iA += 8;
            }
            if ((lVar.c & 131072) != 0) {
                lVar.f3710b.l("Deprecated");
                iA += 6;
            }
            a aVar = lVar.h;
            if (aVar != null) {
                iA += aVar.a("RuntimeVisibleAnnotations");
            }
            a aVar2 = lVar.i;
            if (aVar2 != null) {
                iA += aVar2.a("RuntimeInvisibleAnnotations");
            }
            a aVar3 = lVar.j;
            if (aVar3 != null) {
                iA += aVar3.a("RuntimeVisibleTypeAnnotations");
            }
            a aVar4 = lVar.k;
            if (aVar4 != null) {
                iA += aVar4.a("RuntimeInvisibleTypeAnnotations");
            }
            b bVar = lVar.l;
            if (bVar != null) {
                iA += bVar.a(lVar.f3710b);
            }
            iA4 += iA;
            lVar = (l) lVar.a;
        }
        r rVar = this.j;
        int i8 = 0;
        while (true) {
            if (rVar == null) {
                c cVar = this.m;
                if (cVar != null) {
                    iA4 += cVar.f3699b + 8;
                    this.f3701b.l("InnerClasses");
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.n != 0) {
                    i++;
                    iA4 += 10;
                    this.f3701b.l("EnclosingMethod");
                }
                if ((this.c & 4096) != 0) {
                    str3 = "EnclosingMethod";
                    if ((this.a & 65535) < 49) {
                        i++;
                        iA4 += 6;
                        this.f3701b.l("Synthetic");
                    }
                } else {
                    str3 = "EnclosingMethod";
                }
                if (this.p != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("Signature");
                }
                if (this.q != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("SourceFile");
                }
                c cVar2 = this.r;
                if (cVar2 != null) {
                    i++;
                    iA4 += cVar2.f3699b + 6;
                    this.f3701b.l("SourceDebugExtension");
                }
                if ((this.c & 131072) != 0) {
                    i++;
                    iA4 += 6;
                    this.f3701b.l("Deprecated");
                }
                a aVar5 = this.f3702s;
                if (aVar5 != null) {
                    i++;
                    iA4 += aVar5.a("RuntimeVisibleAnnotations");
                }
                a aVar6 = this.t;
                if (aVar6 != null) {
                    i++;
                    iA4 += aVar6.a("RuntimeInvisibleAnnotations");
                }
                a aVar7 = this.u;
                if (aVar7 != null) {
                    i++;
                    iA4 += aVar7.a("RuntimeVisibleTypeAnnotations");
                }
                a aVar8 = this.v;
                if (aVar8 != null) {
                    i++;
                    iA4 += aVar8.a("RuntimeInvisibleTypeAnnotations");
                }
                v vVar2 = this.f3701b;
                if (vVar2.j != null) {
                    vVar2.l("BootstrapMethods");
                    i2 = vVar2.j.f3699b + 8;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    i++;
                    v vVar3 = this.f3701b;
                    if (vVar3.j != null) {
                        vVar3.l("BootstrapMethods");
                        i6 = vVar3.j.f3699b + 8;
                    } else {
                        i6 = 0;
                    }
                    iA4 += i6;
                }
                s sVar = this.w;
                String str6 = "ModuleMainClass";
                int i9 = i8;
                if (sVar != null) {
                    i += (sVar.o > 0 ? 1 : 0) + 1 + (sVar.q > 0 ? 1 : 0);
                    sVar.a.l("Module");
                    int i10 = sVar.f.f3699b + 22 + sVar.h.f3699b + sVar.j.f3699b + sVar.l.f3699b + sVar.n.f3699b;
                    if (sVar.o > 0) {
                        sVar.a.l("ModulePackages");
                        i10 += sVar.p.f3699b + 8;
                    }
                    if (sVar.q > 0) {
                        sVar.a.l("ModuleMainClass");
                        i10 += 8;
                    }
                    iA4 += i10;
                }
                if (this.f3703x != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("NestHost");
                }
                c cVar3 = this.f3705z;
                if (cVar3 != null) {
                    i++;
                    iA4 += cVar3.f3699b + 8;
                    this.f3701b.l("NestMembers");
                }
                b bVar2 = this.A;
                if (bVar2 != null) {
                    int iC = i + bVar2.c();
                    iA4 += this.A.a(this.f3701b);
                    i = iC;
                }
                v vVar4 = this.f3701b;
                int i11 = iA4 + vVar4.h.f3699b;
                int i12 = vVar4.g;
                if (i12 > 65535) {
                    throw new ClassTooLargeException(this.f3701b.d, i12);
                }
                c cVar4 = new c(i11);
                cVar4.i(-889275714);
                cVar4.i(this.a);
                v vVar5 = this.f3701b;
                cVar4.j(vVar5.g);
                c cVar5 = vVar5.h;
                cVar4.h(cVar5.a, 0, cVar5.f3699b);
                cVar4.j((~((this.a & 65535) < 49 ? 4096 : 0)) & this.c);
                cVar4.j(this.d);
                cVar4.j(this.e);
                cVar4.j(this.f);
                for (int i13 = 0; i13 < this.f; i13++) {
                    cVar4.j(this.g[i13]);
                }
                cVar4.j(i7);
                l lVar2 = this.h;
                while (lVar2 != null) {
                    boolean z2 = lVar2.f3710b.c < 49;
                    cVar4.j((~(z2 ? 4096 : 0)) & lVar2.c);
                    cVar4.j(lVar2.d);
                    cVar4.j(lVar2.e);
                    int iC2 = lVar2.g != 0 ? 1 : 0;
                    int i14 = lVar2.c;
                    String str7 = str6;
                    if ((i14 & 4096) != 0 && z2) {
                        iC2++;
                    }
                    if (lVar2.f != 0) {
                        iC2++;
                    }
                    if ((i14 & 131072) != 0) {
                        iC2++;
                    }
                    if (lVar2.h != null) {
                        iC2++;
                    }
                    if (lVar2.i != null) {
                        iC2++;
                    }
                    if (lVar2.j != null) {
                        iC2++;
                    }
                    if (lVar2.k != null) {
                        iC2++;
                    }
                    b bVar3 = lVar2.l;
                    if (bVar3 != null) {
                        iC2 += bVar3.c();
                    }
                    cVar4.j(iC2);
                    if (lVar2.g != 0) {
                        b.d.b.a.a.t0(lVar2.f3710b, "ConstantValue", cVar4, 2);
                        cVar4.j(lVar2.g);
                    }
                    if ((lVar2.c & 4096) != 0 && z2) {
                        b.d.b.a.a.t0(lVar2.f3710b, "Synthetic", cVar4, 0);
                    }
                    if (lVar2.f != 0) {
                        b.d.b.a.a.t0(lVar2.f3710b, "Signature", cVar4, 2);
                        cVar4.j(lVar2.f);
                    }
                    if ((lVar2.c & 131072) != 0) {
                        b.d.b.a.a.t0(lVar2.f3710b, "Deprecated", cVar4, 0);
                    }
                    a aVar9 = lVar2.h;
                    if (aVar9 != null) {
                        aVar9.c(lVar2.f3710b.l("RuntimeVisibleAnnotations"), cVar4);
                    }
                    a aVar10 = lVar2.i;
                    if (aVar10 != null) {
                        aVar10.c(lVar2.f3710b.l("RuntimeInvisibleAnnotations"), cVar4);
                    }
                    a aVar11 = lVar2.j;
                    if (aVar11 != null) {
                        str4 = str2;
                        aVar11.c(lVar2.f3710b.l(str4), cVar4);
                    } else {
                        str4 = str2;
                    }
                    a aVar12 = lVar2.k;
                    if (aVar12 != null) {
                        str5 = str;
                        aVar12.c(lVar2.f3710b.l(str5), cVar4);
                    } else {
                        str5 = str;
                    }
                    b bVar4 = lVar2.l;
                    if (bVar4 != null) {
                        bVar4.d(lVar2.f3710b, cVar4);
                    }
                    lVar2 = (l) lVar2.a;
                    str2 = str4;
                    str = str5;
                    str6 = str7;
                }
                String str8 = str6;
                String str9 = str;
                String str10 = str2;
                cVar4.j(i9);
                boolean z3 = false;
                boolean z4 = false;
                for (r rVar2 = this.j; rVar2 != null; rVar2 = (r) rVar2.f3715b) {
                    z4 |= rVar2.u > 0;
                    z3 |= rVar2.Y;
                    rVar2.y(cVar4);
                }
                cVar4.j(i);
                if (this.m != null) {
                    cVar4.j(this.f3701b.l("InnerClasses"));
                    cVar4.i(this.m.f3699b + 2);
                    cVar4.j(this.l);
                    c cVar6 = this.m;
                    cVar4.h(cVar6.a, 0, cVar6.f3699b);
                }
                if (this.n != 0) {
                    b.d.b.a.a.t0(this.f3701b, str3, cVar4, 4);
                    cVar4.j(this.n);
                    cVar4.j(this.o);
                }
                if ((this.c & 4096) != 0 && (this.a & 65535) < 49) {
                    b.d.b.a.a.t0(this.f3701b, "Synthetic", cVar4, 0);
                }
                if (this.p != 0) {
                    i3 = 2;
                    b.d.b.a.a.t0(this.f3701b, "Signature", cVar4, 2);
                    cVar4.j(this.p);
                } else {
                    i3 = 2;
                }
                if (this.q != 0) {
                    b.d.b.a.a.t0(this.f3701b, "SourceFile", cVar4, i3);
                    cVar4.j(this.q);
                }
                c cVar7 = this.r;
                if (cVar7 != null) {
                    int i15 = cVar7.f3699b;
                    b.d.b.a.a.t0(this.f3701b, "SourceDebugExtension", cVar4, i15);
                    i4 = 0;
                    cVar4.h(this.r.a, 0, i15);
                } else {
                    i4 = 0;
                }
                if ((this.c & 131072) != 0) {
                    b.d.b.a.a.t0(this.f3701b, "Deprecated", cVar4, i4);
                }
                a aVar13 = this.f3702s;
                if (aVar13 != null) {
                    aVar13.c(this.f3701b.l("RuntimeVisibleAnnotations"), cVar4);
                }
                a aVar14 = this.t;
                if (aVar14 != null) {
                    aVar14.c(this.f3701b.l("RuntimeInvisibleAnnotations"), cVar4);
                }
                a aVar15 = this.u;
                if (aVar15 != null) {
                    aVar15.c(this.f3701b.l(str10), cVar4);
                }
                a aVar16 = this.v;
                if (aVar16 != null) {
                    aVar16.c(this.f3701b.l(str9), cVar4);
                }
                v vVar6 = this.f3701b;
                if (vVar6.j != null) {
                    cVar4.j(vVar6.l("BootstrapMethods"));
                    cVar4.i(vVar6.j.f3699b + 2);
                    cVar4.j(vVar6.i);
                    c cVar8 = vVar6.j;
                    cVar4.h(cVar8.a, 0, cVar8.f3699b);
                }
                s sVar2 = this.w;
                if (sVar2 != null) {
                    b.d.b.a.a.t0(sVar2.a, "Module", cVar4, sVar2.f.f3699b + 16 + sVar2.h.f3699b + sVar2.j.f3699b + sVar2.l.f3699b + sVar2.n.f3699b);
                    cVar4.j(sVar2.f3722b);
                    cVar4.j(sVar2.c);
                    cVar4.j(sVar2.d);
                    cVar4.j(sVar2.e);
                    c cVar9 = sVar2.f;
                    cVar4.h(cVar9.a, 0, cVar9.f3699b);
                    cVar4.j(sVar2.g);
                    c cVar10 = sVar2.h;
                    cVar4.h(cVar10.a, 0, cVar10.f3699b);
                    cVar4.j(sVar2.i);
                    c cVar11 = sVar2.j;
                    cVar4.h(cVar11.a, 0, cVar11.f3699b);
                    cVar4.j(sVar2.k);
                    c cVar12 = sVar2.l;
                    cVar4.h(cVar12.a, 0, cVar12.f3699b);
                    cVar4.j(sVar2.m);
                    c cVar13 = sVar2.n;
                    cVar4.h(cVar13.a, 0, cVar13.f3699b);
                    if (sVar2.o > 0) {
                        cVar4.j(sVar2.a.l("ModulePackages"));
                        cVar4.i(sVar2.p.f3699b + 2);
                        cVar4.j(sVar2.o);
                        c cVar14 = sVar2.p;
                        cVar4.h(cVar14.a, 0, cVar14.f3699b);
                    }
                    if (sVar2.q > 0) {
                        i5 = 2;
                        b.d.b.a.a.t0(sVar2.a, str8, cVar4, 2);
                        cVar4.j(sVar2.q);
                    } else {
                        i5 = 2;
                    }
                } else {
                    i5 = 2;
                }
                if (this.f3703x != 0) {
                    b.d.b.a.a.t0(this.f3701b, "NestHost", cVar4, i5);
                    cVar4.j(this.f3703x);
                }
                if (this.f3705z != null) {
                    cVar4.j(this.f3701b.l("NestMembers"));
                    cVar4.i(this.f3705z.f3699b + 2);
                    cVar4.j(this.f3704y);
                    c cVar15 = this.f3705z;
                    cVar4.h(cVar15.a, 0, cVar15.f3699b);
                }
                b bVar5 = this.A;
                if (bVar5 != null) {
                    bVar5.d(this.f3701b, cVar4);
                }
                return z3 ? a(cVar4.a, z4) : cVar4.a;
            }
            int i16 = i8 + 1;
            if (rVar.f3716a0 != 0) {
                iA3 = rVar.f3717b0 + 6;
                i16 = i16;
            } else {
                int i17 = rVar.l.f3699b;
                if (i17 <= 0) {
                    i16 = i16;
                    iA2 = 8;
                } else {
                    if (i17 > 65535) {
                        throw new MethodTooLargeException(rVar.d.d, rVar.g, rVar.i, rVar.l.f3699b);
                    }
                    rVar.d.l("Code");
                    int i18 = rVar.l.f3699b + iA;
                    int i19 = 0;
                    for (o oVar = rVar.m; oVar != null; oVar = oVar.f) {
                        i19++;
                    }
                    iA2 = (i19 * 8) + 2 + i18 + 8;
                    if (rVar.v != null) {
                        v vVar7 = rVar.d;
                        vVar7.l(vVar7.c >= 50 ? "StackMapTable" : "StackMap");
                        iA2 += rVar.v.f3699b + 8;
                    }
                    if (rVar.p != null) {
                        rVar.d.l("LineNumberTable");
                        iA2 += rVar.p.f3699b + 8;
                    }
                    if (rVar.r != null) {
                        rVar.d.l("LocalVariableTable");
                        iA2 += rVar.r.f3699b + 8;
                    }
                    if (rVar.t != null) {
                        rVar.d.l("LocalVariableTypeTable");
                        iA2 += rVar.t.f3699b + 8;
                    }
                    a aVar17 = rVar.w;
                    if (aVar17 != null) {
                        iA2 += aVar17.a("RuntimeVisibleTypeAnnotations");
                    }
                    a aVar18 = rVar.f3719x;
                    if (aVar18 != null) {
                        iA2 += aVar18.a("RuntimeInvisibleTypeAnnotations");
                    }
                }
                if (rVar.f3720y > 0) {
                    rVar.d.l("Exceptions");
                    iA2 += (rVar.f3720y * 2) + 8;
                }
                v vVar8 = rVar.d;
                boolean z5 = vVar8.c < 49;
                if ((rVar.e & 4096) != 0 && z5) {
                    vVar8.l("Synthetic");
                    iA2 += 6;
                }
                if (rVar.A != 0) {
                    rVar.d.l("Signature");
                    iA2 += 8;
                }
                if ((rVar.e & 131072) != 0) {
                    rVar.d.l("Deprecated");
                    iA2 += 6;
                }
                a aVar19 = rVar.B;
                if (aVar19 != null) {
                    iA2 += aVar19.a("RuntimeVisibleAnnotations");
                }
                a aVar20 = rVar.C;
                if (aVar20 != null) {
                    iA2 += aVar20.a("RuntimeInvisibleAnnotations");
                }
                a[] aVarArr = rVar.E;
                if (aVarArr != null) {
                    int length = rVar.D;
                    if (length == 0) {
                        length = aVarArr.length;
                    }
                    iA2 += a.b("RuntimeVisibleParameterAnnotations", aVarArr, length);
                }
                a[] aVarArr2 = rVar.G;
                if (aVarArr2 != null) {
                    int length2 = rVar.F;
                    if (length2 == 0) {
                        length2 = aVarArr2.length;
                    }
                    iA2 += a.b("RuntimeInvisibleParameterAnnotations", aVarArr2, length2);
                }
                a aVar21 = rVar.H;
                if (aVar21 != null) {
                    iA2 += aVar21.a("RuntimeVisibleTypeAnnotations");
                }
                a aVar22 = rVar.I;
                if (aVar22 != null) {
                    iA2 += aVar22.a("RuntimeInvisibleTypeAnnotations");
                }
                if (rVar.J != null) {
                    rVar.d.l("AnnotationDefault");
                    iA2 += rVar.J.f3699b + 6;
                }
                if (rVar.L != null) {
                    rVar.d.l("MethodParameters");
                    iA3 = rVar.L.f3699b + 7 + iA2;
                } else {
                    iA3 = iA2;
                }
                b bVar6 = rVar.M;
                if (bVar6 != null) {
                    iA3 += bVar6.a(rVar.d);
                }
            }
            iA4 += iA3;
            rVar = (r) rVar.f3715b;
            iA = 16;
            i8 = i16;
        }
    }

    public final void c(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.a = i;
        this.c = i2;
        v vVar = this.f3701b;
        int i3 = i & 65535;
        vVar.c = i3;
        vVar.d = str;
        this.d = vVar.m(7, str).a;
        if (str2 != null) {
            this.p = this.f3701b.l(str2);
        }
        this.e = str3 == null ? 0 : this.f3701b.m(7, str3).a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f = length;
            this.g = new int[length];
            for (int i4 = 0; i4 < this.f; i4++) {
                this.g[i4] = this.f3701b.c(strArr[i4]).a;
            }
        }
        if (this.B != 1 || i3 < 51) {
            return;
        }
        this.B = 2;
    }

    public final a d(String str, boolean z2) {
        c cVar = new c();
        cVar.j(this.f3701b.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.f3701b, true, cVar, this.f3702s);
            this.f3702s = aVar;
            return aVar;
        }
        a aVar2 = new a(this.f3701b, true, cVar, this.t);
        this.t = aVar2;
        return aVar2;
    }

    public final q e(int i, String str, String str2, String str3, String[] strArr) {
        r rVar = new r(this.f3701b, i, str, str2, str3, strArr, this.B);
        if (this.j == null) {
            this.j = rVar;
        } else {
            this.k.f3715b = rVar;
        }
        this.k = rVar;
        return rVar;
    }

    public final a f(int i, x xVar, String str, boolean z2) {
        c cVar = new c();
        b.i.a.f.e.o.f.W0(i, cVar);
        x.a(xVar, cVar);
        cVar.j(this.f3701b.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.f3701b, true, cVar, this.u);
            this.u = aVar;
            return aVar;
        }
        a aVar2 = new a(this.f3701b, true, cVar, this.v);
        this.v = aVar2;
        return aVar2;
    }
}
