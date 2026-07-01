package h0.a.a;

import b.d.b.a.outline;
import h0.a.a.Attribute2;
import org.objectweb.asm.ClassTooLargeException;
import org.objectweb.asm.MethodTooLargeException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: ClassWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassWriter2 extends ClassVisitor2 {
    public Attribute2 A;
    public int B;
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SymbolTable2 f3701b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int[] g;
    public FieldWriter2 h;
    public FieldWriter2 i;
    public MethodWriter2 j;
    public MethodWriter2 k;
    public int l;
    public ByteVector2 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public ByteVector2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnnotationWriter2 f3702s;
    public AnnotationWriter2 t;
    public AnnotationWriter2 u;
    public AnnotationWriter2 v;
    public ModuleWriter2 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3704y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ByteVector2 f3705z;

    public ClassWriter2(int i) {
        super(Opcodes.ASM7);
        this.f3701b = new SymbolTable2(this);
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
        Attribute2 attribute2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        ClassWriter2 classWriter2;
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
        ClassReader2 classReader2;
        String str31;
        int i5;
        String[] strArr;
        String[] strArr2;
        int i6;
        String str32;
        Attribute2.a aVar = new Attribute2.a();
        aVar.a(this.A);
        for (FieldWriter2 fieldWriter2 = this.h; fieldWriter2 != null; fieldWriter2 = (FieldWriter2) fieldWriter2.a) {
            aVar.a(fieldWriter2.l);
        }
        MethodWriter2 methodWriter2 = this.j;
        while (true) {
            strG = null;
            if (methodWriter2 == null) {
                break;
            }
            aVar.a(methodWriter2.M);
            aVar.a(null);
            methodWriter2 = (MethodWriter2) methodWriter2.f3715b;
        }
        int i7 = aVar.a;
        Attribute2[] attribute2Arr = new Attribute2[i7];
        System.arraycopy(aVar.f3698b, 0, attribute2Arr, 0, i7);
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
        ClassReader2 classReader3 = new ClassReader2(bArr, 0, false);
        int i8 = (z2 ? 8 : 0) | 256;
        Context3 context3 = new Context3();
        context3.a = attribute2Arr;
        context3.f3707b = i8;
        char[] cArr = new char[classReader3.f];
        context3.c = cArr;
        int i9 = classReader3.g;
        int iU = classReader3.u(i9);
        String strG2 = classReader3.g(i9 + 2, cArr);
        String strG3 = classReader3.g(i9 + 4, cArr);
        int iU2 = classReader3.u(i9 + 6);
        String[] strArr3 = new String[iU2];
        int i10 = i9 + 8;
        for (int i11 = 0; i11 < iU2; i11++) {
            strArr3[i11] = classReader3.g(i10, cArr);
            i10 += 2;
        }
        int iC = classReader3.c();
        String strT = null;
        Attribute2 attribute2E = null;
        String strT2 = null;
        String strG4 = null;
        int i12 = iU;
        int iU3 = classReader3.u(iC - 2);
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
            attribute2 = attribute2E;
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
            String strT3 = classReader3.t(iC, cArr);
            int i22 = i10;
            int iL = classReader3.l(iC + 2);
            int i23 = iC + 6;
            Context3 context4 = context3;
            if ("SourceFile".equals(strT3)) {
                strT = classReader3.t(i23, cArr);
                strV = str3;
                i13 = i;
                strG = str5;
            } else {
                if ("InnerClasses".equals(strT3)) {
                    i21 = i23;
                } else if ("EnclosingMethod".equals(strT3)) {
                    i15 = i23;
                } else if ("NestHost".equals(strT3)) {
                    strG4 = classReader3.g(i23, cArr);
                } else if ("NestMembers".equals(strT3)) {
                    i20 = i23;
                } else if ("Signature".equals(strT3)) {
                    strT2 = classReader3.t(i23, cArr);
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
                        strV = classReader3.v(i23, iL, new char[iL]);
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
                        strG = classReader3.g(i23, cArr);
                        i13 = i;
                        strV = str3;
                        strT = str;
                    } else if ("ModulePackages".equals(strT3)) {
                        i14 = i23;
                    } else {
                        if ("BootstrapMethods".equals(strT3)) {
                            i6 = i23;
                            str32 = str3;
                            attribute2E = attribute2;
                        } else {
                            i6 = i23;
                            str32 = str3;
                            attribute2E = classReader3.e(attribute2Arr, strT3, i6, iL, cArr, -1, null);
                            attribute2E.c = attribute2;
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
                    context3 = context4;
                }
                i13 = i;
                strG = str5;
                strV = str3;
                strT = str;
            }
            attribute2E = attribute2;
            i6 = i23;
            strArr4 = strArr4;
            iC = i6 + iL;
            iU3--;
            strArr4 = strArr4;
            i10 = i22;
            context3 = context4;
        }
        int i24 = i10;
        String str33 = "RuntimeInvisibleTypeAnnotations";
        String str34 = "RuntimeInvisibleAnnotations";
        Context3 context5 = context3;
        ClassReader2 classReader4 = classReader3;
        String str35 = "RuntimeVisibleTypeAnnotations";
        c(classReader3.l(classReader3.f3700b[1] - 7), i12, strG2, strT2, strG3, strArr4);
        if ((i8 & 2) != 0 || (str == null && str3 == null)) {
            classWriter2 = this;
            str7 = "Signature";
        } else {
            classWriter2 = this;
            str7 = "Signature";
            if (str != null) {
                classWriter2.q = classWriter2.f3701b.l(str);
            }
            if (str3 != null) {
                ByteVector2 byteVector2 = new ByteVector2();
                byteVector2.a(str3, 0, Integer.MAX_VALUE);
                classWriter2.r = byteVector2;
            }
        }
        if (i != 0) {
            char[] cArr2 = context5.c;
            String strT4 = classReader4.t(classReader4.f3700b[classReader4.u(i)], cArr2);
            int iU4 = classReader4.u(i + 2);
            String strT5 = classReader4.t(i + 4, cArr2);
            int i25 = i + 6;
            SymbolTable2 symbolTable2 = classWriter2.f3701b;
            ModuleWriter2 moduleWriter2 = new ModuleWriter2(symbolTable2, symbolTable2.m(19, strT4).a, iU4, strT5 == null ? 0 : classWriter2.f3701b.l(strT5));
            classWriter2.w = moduleWriter2;
            if (str5 != null) {
                moduleWriter2.q = symbolTable2.m(7, str5).a;
            }
            int i26 = i14;
            if (i26 != 0) {
                int iU5 = classReader4.u(i26);
                int i27 = i26 + 2;
                while (true) {
                    int i28 = iU5 - 1;
                    if (iU5 <= 0) {
                        break;
                    }
                    moduleWriter2.p.j(moduleWriter2.a.m(20, classReader4.o(i27, cArr2)).a);
                    moduleWriter2.o++;
                    i27 += 2;
                    iU5 = i28;
                }
            }
            int iU6 = classReader4.u(i25);
            int i29 = i25 + 2;
            while (true) {
                int i30 = iU6 - 1;
                if (iU6 <= 0) {
                    break;
                }
                String strN = classReader4.n(i29, cArr2);
                int iU7 = classReader4.u(i29 + 2);
                String strT6 = classReader4.t(i29 + 4, cArr2);
                i29 += 6;
                ByteVector2 byteVector3 = moduleWriter2.f;
                String str36 = str2;
                byteVector3.j(moduleWriter2.a.m(19, strN).a);
                byteVector3.j(iU7);
                byteVector3.j(strT6 == null ? 0 : moduleWriter2.a.l(strT6));
                moduleWriter2.e++;
                iU6 = i30;
                str2 = str36;
            }
            str8 = str2;
            int iU8 = classReader4.u(i29);
            int i31 = i29 + 2;
            while (true) {
                int i32 = iU8 - 1;
                if (iU8 <= 0) {
                    break;
                }
                String strO = classReader4.o(i31, cArr2);
                int iU9 = classReader4.u(i31 + 2);
                int iU10 = classReader4.u(i31 + 4);
                i31 += 6;
                if (iU10 != 0) {
                    strArr2 = new String[iU10];
                    int i33 = i31;
                    for (int i34 = 0; i34 < iU10; i34++) {
                        strArr2[i34] = classReader4.n(i33, cArr2);
                        i33 += 2;
                    }
                    i31 = i33;
                } else {
                    strArr2 = null;
                }
                ByteVector2 byteVector4 = moduleWriter2.h;
                byteVector4.j(moduleWriter2.a.m(20, strO).a);
                byteVector4.j(iU9);
                if (strArr2 == null) {
                    moduleWriter2.h.j(0);
                } else {
                    moduleWriter2.h.j(strArr2.length);
                    for (String str37 : strArr2) {
                        moduleWriter2.h.j(moduleWriter2.a.j(str37).a);
                    }
                }
                moduleWriter2.g++;
                iU8 = i32;
            }
            int iU11 = classReader4.u(i31);
            int i35 = i31 + 2;
            while (true) {
                int i36 = iU11 - 1;
                if (iU11 <= 0) {
                    break;
                }
                String strO2 = classReader4.o(i35, cArr2);
                int iU12 = classReader4.u(i35 + 2);
                int iU13 = classReader4.u(i35 + 4);
                i35 += 6;
                if (iU13 != 0) {
                    strArr = new String[iU13];
                    int i37 = i35;
                    for (int i38 = 0; i38 < iU13; i38++) {
                        strArr[i38] = classReader4.n(i37, cArr2);
                        i37 += 2;
                    }
                    i35 = i37;
                } else {
                    strArr = null;
                }
                ByteVector2 byteVector5 = moduleWriter2.j;
                byteVector5.j(moduleWriter2.a.m(20, strO2).a);
                byteVector5.j(iU12);
                if (strArr == null) {
                    moduleWriter2.j.j(0);
                } else {
                    moduleWriter2.j.j(strArr.length);
                    for (String str38 : strArr) {
                        moduleWriter2.j.j(moduleWriter2.a.j(str38).a);
                    }
                }
                moduleWriter2.i++;
                iU11 = i36;
            }
            int iU14 = classReader4.u(i35);
            int i39 = i35 + 2;
            while (true) {
                int i40 = iU14 - 1;
                if (iU14 <= 0) {
                    break;
                }
                moduleWriter2.l.j(moduleWriter2.a.m(7, classReader4.g(i39, cArr2)).a);
                moduleWriter2.k++;
                i39 += 2;
                iU14 = i40;
            }
            int iU15 = classReader4.u(i39);
            int i41 = i39 + 2;
            while (true) {
                int i42 = iU15 - 1;
                if (iU15 <= 0) {
                    break;
                }
                String strG5 = classReader4.g(i41, cArr2);
                int iU16 = classReader4.u(i41 + 2);
                String[] strArr5 = new String[iU16];
                int i43 = i41 + 4;
                for (int i44 = 0; i44 < iU16; i44++) {
                    strArr5[i44] = classReader4.g(i43, cArr2);
                    i43 += 2;
                }
                char[] cArr3 = cArr2;
                moduleWriter2.n.j(moduleWriter2.a.m(7, strG5).a);
                moduleWriter2.n.j(iU16);
                for (int i45 = 0; i45 < iU16; i45++) {
                    moduleWriter2.n.j(moduleWriter2.a.c(strArr5[i45]).a);
                }
                moduleWriter2.m++;
                iU15 = i42;
                i41 = i43;
                cArr2 = cArr3;
            }
        } else {
            str8 = "Synthetic";
        }
        String str39 = strG4;
        if (str39 != null) {
            classWriter2.f3703x = classWriter2.f3701b.m(7, str39).a;
        }
        int i46 = i15;
        if (i46 != 0) {
            String strG6 = classReader4.g(i46, cArr);
            int iU17 = classReader4.u(i46 + 2);
            String strT7 = iU17 == 0 ? null : classReader4.t(classReader4.f3700b[iU17], cArr);
            String strT8 = iU17 == 0 ? null : classReader4.t(classReader4.f3700b[iU17] + 2, cArr);
            classWriter2.n = classWriter2.f3701b.m(7, strG6).a;
            if (strT7 != null && strT8 != null) {
                classWriter2.o = classWriter2.f3701b.k(strT7, strT8);
            }
        }
        int i47 = i16;
        if (i47 != 0) {
            int iU18 = classReader4.u(i47);
            int iK = i47 + 2;
            while (true) {
                int i48 = iU18 - 1;
                if (iU18 <= 0) {
                    break;
                }
                iK = classReader4.k(classWriter2.d(classReader4.t(iK, cArr), true), iK + 2, true, cArr);
                iU18 = i48;
            }
        }
        int i49 = i17;
        if (i49 != 0) {
            int iU19 = classReader4.u(i49);
            int iK2 = i49 + 2;
            while (true) {
                int i50 = iU19 - 1;
                if (iU19 <= 0) {
                    break;
                }
                iK2 = classReader4.k(classWriter2.d(classReader4.t(iK2, cArr), false), iK2 + 2, true, cArr);
                iU19 = i50;
            }
        }
        int i51 = i18;
        if (i51 != 0) {
            int iU20 = classReader4.u(i51);
            int iK3 = i51 + 2;
            while (true) {
                int i52 = iU20 - 1;
                if (iU20 <= 0) {
                    break;
                }
                int iR = classReader4.r(context5, iK3);
                iK3 = classReader4.k(classWriter2.f(context5.h, context5.i, classReader4.t(iR, cArr), true), iR + 2, true, cArr);
                iU20 = i52;
            }
        }
        int i53 = i19;
        if (i53 != 0) {
            int iU21 = classReader4.u(i53);
            int iK4 = i53 + 2;
            while (true) {
                int i54 = iU21 - 1;
                if (iU21 <= 0) {
                    break;
                }
                int iR2 = classReader4.r(context5, iK4);
                iK4 = classReader4.k(classWriter2.f(context5.h, context5.i, classReader4.t(iR2, cArr), false), iR2 + 2, true, cArr);
                iU21 = i54;
            }
        }
        Attribute2 attribute3 = attribute2;
        while (attribute3 != null) {
            Attribute2 attribute4 = attribute3.c;
            attribute3.c = null;
            attribute3.c = classWriter2.A;
            classWriter2.A = attribute3;
            attribute3 = attribute4;
        }
        int i55 = i20;
        if (i55 != 0) {
            int iU22 = classReader4.u(i55);
            int i56 = i55 + 2;
            while (true) {
                int i57 = iU22 - 1;
                if (iU22 <= 0) {
                    break;
                }
                String strG7 = classReader4.g(i56, cArr);
                if (classWriter2.f3705z == null) {
                    classWriter2.f3705z = new ByteVector2();
                }
                classWriter2.f3704y++;
                classWriter2.f3705z.j(classWriter2.f3701b.m(7, strG7).a);
                i56 += 2;
                iU22 = i57;
            }
        }
        int i58 = i21;
        if (i58 != 0) {
            int iU23 = classReader4.u(i58);
            int i59 = i58 + 2;
            while (true) {
                int i60 = iU23 - 1;
                if (iU23 <= 0) {
                    break;
                }
                String strG8 = classReader4.g(i59, cArr);
                String strG9 = classReader4.g(i59 + 2, cArr);
                String strT9 = classReader4.t(i59 + 4, cArr);
                int iU24 = classReader4.u(i59 + 6);
                if (classWriter2.m == null) {
                    classWriter2.m = new ByteVector2();
                }
                Symbol2 symbol2M = classWriter2.f3701b.m(7, strG8);
                if (symbol2M.g == 0) {
                    classWriter2.l++;
                    classWriter2.m.j(symbol2M.a);
                    classWriter2.m.j(strG9 == null ? 0 : classWriter2.f3701b.m(7, strG9).a);
                    classWriter2.m.j(strT9 == null ? 0 : classWriter2.f3701b.l(strT9));
                    classWriter2.m.j(iU24);
                    symbol2M.g = classWriter2.l;
                }
                i59 += 8;
                iU23 = i60;
            }
        }
        int iU25 = classReader4.u(i24);
        int i61 = i24 + 2;
        while (true) {
            int i62 = iU25 - 1;
            if (iU25 <= 0) {
                break;
            }
            char[] cArr4 = context5.c;
            int iU26 = classReader4.u(i61);
            String strT10 = classReader4.t(i61 + 2, cArr4);
            String strT11 = classReader4.t(i61 + 4, cArr4);
            int i63 = i61 + 6;
            int iU27 = classReader4.u(i63);
            i61 = i63 + 2;
            int i64 = iU26;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            Attribute2 attribute5 = null;
            int i68 = 0;
            String strT12 = null;
            Object objI = null;
            while (true) {
                int i69 = iU27 - 1;
                if (iU27 <= 0) {
                    break;
                }
                String strT13 = classReader4.t(i61, cArr4);
                int iL2 = classReader4.l(i61 + 2);
                int i70 = i61 + 6;
                if ("ConstantValue".equals(strT13)) {
                    int iU28 = classReader4.u(i70);
                    if (iU28 == 0) {
                        str22 = str8;
                        objI = null;
                    } else {
                        objI = classReader4.i(iU28, cArr4);
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
                    classReader2 = classReader4;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                } else {
                    if (str7.equals(strT13)) {
                        strT12 = classReader4.t(i70, cArr4);
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
                            classReader2 = classReader4;
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
                                classReader2 = classReader4;
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
                                            classReader2 = classReader4;
                                            str29 = str24;
                                            i68 = i4;
                                            i64 = i5;
                                        } else {
                                            str27 = str23;
                                            str28 = str22;
                                            str29 = str24;
                                            str30 = str4;
                                            classReader2 = classReader4;
                                            str31 = str26;
                                            Attribute2 attribute2E2 = classReader4.e(context5.a, strT13, i70, iL2, cArr4, -1, null);
                                            attribute2E2.c = attribute5;
                                            attribute5 = attribute2E2;
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
                                classReader2 = classReader4;
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
                    classReader2 = classReader4;
                    str29 = str24;
                    i68 = i4;
                    i64 = i5;
                }
                i61 = i70 + iL2;
                classReader4 = classReader2;
                context5 = context5;
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
            Attribute2 attribute6 = attribute5;
            ClassReader2 classReader5 = classReader4;
            int i73 = i68;
            String str43 = str35;
            String str44 = str34;
            String str45 = str8;
            String str46 = str6;
            String str47 = str7;
            Context3 context6 = context5;
            FieldWriter2 fieldWriter3 = new FieldWriter2(classWriter2.f3701b, i64, strT10, strT11, strT12, objI);
            if (classWriter2.h == null) {
                classWriter2.h = fieldWriter3;
            } else {
                classWriter2.i.a = fieldWriter3;
            }
            classWriter2.i = fieldWriter3;
            if (i65 != 0) {
                int iU29 = classReader5.u(i65);
                int iK5 = i65 + 2;
                while (true) {
                    int i74 = iU29 - 1;
                    if (iU29 <= 0) {
                        break;
                    }
                    iK5 = classReader5.k(fieldWriter3.a(classReader5.t(iK5, cArr4), true), iK5 + 2, true, cArr4);
                    iU29 = i74;
                }
            }
            if (i66 != 0) {
                int iU30 = classReader5.u(i66);
                int iK6 = i66 + 2;
                while (true) {
                    int i75 = iU30 - 1;
                    if (iU30 <= 0) {
                        break;
                    }
                    iK6 = classReader5.k(fieldWriter3.a(classReader5.t(iK6, cArr4), false), iK6 + 2, true, cArr4);
                    iU30 = i75;
                }
            }
            if (i67 != 0) {
                int iU31 = classReader5.u(i67);
                int iK7 = i67 + 2;
                while (true) {
                    int i76 = iU31 - 1;
                    if (iU31 <= 0) {
                        break;
                    }
                    int iR3 = classReader5.r(context6, iK7);
                    iK7 = classReader5.k(fieldWriter3.b(context6.h, context6.i, classReader5.t(iR3, cArr4), true), iR3 + 2, true, cArr4);
                    iU31 = i76;
                }
            }
            if (i73 != 0) {
                int iU32 = classReader5.u(i73);
                int iK8 = i73 + 2;
                while (true) {
                    int i77 = iU32 - 1;
                    if (iU32 <= 0) {
                        break;
                    }
                    int iR4 = classReader5.r(context6, iK8);
                    iK8 = classReader5.k(fieldWriter3.b(context6.h, context6.i, classReader5.t(iR4, cArr4), false), iR4 + 2, true, cArr4);
                    iU32 = i77;
                }
            }
            Attribute2 attribute7 = attribute6;
            while (attribute7 != null) {
                Attribute2 attribute8 = attribute7.c;
                attribute7.c = null;
                attribute7.c = fieldWriter3.l;
                fieldWriter3.l = attribute7;
                attribute7 = attribute8;
            }
            classReader4 = classReader5;
            context5 = context6;
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
        ClassReader2 classReader6 = classReader4;
        String str50 = str35;
        String str51 = str34;
        String str52 = str8;
        String str53 = str6;
        String str54 = str7;
        Context3 context7 = context5;
        int i78 = 1;
        int iU33 = classReader6.u(i61);
        int i79 = i61 + 2;
        while (true) {
            int i80 = iU33 - 1;
            if (iU33 <= 0) {
                return b();
            }
            char[] cArr5 = context7.c;
            context7.d = classReader6.u(i79);
            context7.e = classReader6.t(i79 + 2, cArr5);
            int i81 = i79 + 4;
            context7.f = classReader6.t(i81, cArr5);
            int i82 = i79 + 6;
            int iU34 = classReader6.u(i82);
            int i83 = i82 + 2;
            int i84 = 0;
            int i85 = 0;
            boolean z4 = false;
            Attribute2 attribute9 = null;
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
                String strT14 = classReader6.t(i83, cArr5);
                int iL3 = classReader6.l(i83 + 2);
                int i95 = i83 + 6;
                if ("Code".equals(strT14)) {
                    if ((context7.f3707b & i78) == 0) {
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
                    int iU36 = classReader6.u(i95);
                    String[] strArr7 = new String[iU36];
                    int i96 = i95 + 2;
                    for (int i97 = 0; i97 < iU36; i97++) {
                        strArr7[i97] = classReader6.g(i96, cArr5);
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
                        iU35 = classReader6.u(i95);
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
                            context7.d |= 131072;
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
                                            context7.d |= 4096;
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
                                                        Attribute2 attribute2E3 = classReader6.e(context7.a, strT14, i95, iL3, cArr5, -1, null);
                                                        attribute2E3.c = attribute9;
                                                        z4 = z4;
                                                        i85 = i85;
                                                        attribute9 = attribute2E3;
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
            Attribute2 attribute10 = attribute9;
            String str57 = str53;
            String str58 = str50;
            String str59 = str51;
            String str60 = str48;
            int i101 = iU35;
            String str61 = str52;
            ClassReader2 classReader7 = classReader6;
            str49 = str49;
            Context3 context8 = context7;
            MethodVisitor2 methodVisitor2E = e(context7.d, context7.e, context7.f, i101 == 0 ? null : classReader6.w(i101, cArr5), strArr6);
            MethodWriter2 methodWriter3 = (MethodWriter2) methodVisitor2E;
            int i102 = i83 - i79;
            boolean z6 = (context8.d & 131072) != 0;
            int iU37 = classReader7.u(i81);
            SymbolTable2 symbolTable3 = methodWriter3.d;
            if (classReader7 == symbolTable3.f3725b && iU37 == methodWriter3.h && i101 == methodWriter3.A) {
                int i103 = methodWriter3.e;
                if (z6 != ((i103 & 131072) != 0)) {
                    z3 = false;
                } else if (z5 != (symbolTable3.c < 49 && (i103 & 4096) != 0)) {
                    z3 = false;
                } else if (i100 != 0) {
                    if (classReader7.u(i100) == methodWriter3.f3720y) {
                        int i104 = i100 + 2;
                        int i105 = 0;
                        while (true) {
                            if (i105 < methodWriter3.f3720y) {
                                if (classReader7.u(i104) != methodWriter3.f3721z[i105]) {
                                    z3 = false;
                                } else {
                                    i104 += 2;
                                    i105++;
                                }
                            }
                        }
                    }
                    methodWriter3.f3716a0 = i98;
                    methodWriter3.f3717b0 = i102 - 6;
                    z3 = true;
                } else if (methodWriter3.f3720y != 0) {
                    z3 = false;
                } else {
                    methodWriter3.f3716a0 = i98;
                    methodWriter3.f3717b0 = i102 - 6;
                    z3 = true;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i106 = i86;
                if (i106 != 0) {
                    int iF = classReader7.f(i106);
                    int i107 = i106 + 1;
                    while (true) {
                        int i108 = iF - 1;
                        if (iF <= 0) {
                            break;
                        }
                        String strT15 = classReader7.t(i107, cArr5);
                        int iU38 = classReader7.u(i107 + 2);
                        if (methodWriter3.L == null) {
                            methodWriter3.L = new ByteVector2();
                        }
                        methodWriter3.K++;
                        ByteVector2 byteVector6 = methodWriter3.L;
                        byteVector6.j(strT15 == null ? 0 : methodWriter3.d.l(strT15));
                        byteVector6.j(iU38);
                        i107 += 4;
                        iF = i108;
                    }
                }
                if (i99 != 0) {
                    ByteVector2 byteVector7 = new ByteVector2();
                    methodWriter3.J = byteVector7;
                    AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(methodWriter3.d, false, byteVector7, null);
                    classReader7.j(annotationWriter2, i99, null, cArr5);
                    annotationWriter2.g();
                }
                int i109 = i87;
                if (i109 != 0) {
                    int iU39 = classReader7.u(i109);
                    int iK9 = i109 + 2;
                    while (true) {
                        int i110 = iU39 - 1;
                        if (iU39 <= 0) {
                            break;
                        }
                        iK9 = classReader7.k(methodVisitor2E.a(classReader7.t(iK9, cArr5), true), iK9 + 2, true, cArr5);
                        iU39 = i110;
                    }
                }
                int i111 = i88;
                if (i111 != 0) {
                    int iU40 = classReader7.u(i111);
                    int iK10 = i111 + 2;
                    while (true) {
                        int i112 = iU40 - 1;
                        if (iU40 <= 0) {
                            break;
                        }
                        iK10 = classReader7.k(methodVisitor2E.a(classReader7.t(iK10, cArr5), false), iK10 + 2, true, cArr5);
                        iU40 = i112;
                    }
                }
                int i113 = i89;
                if (i113 != 0) {
                    int iU41 = classReader7.u(i113);
                    int iK11 = i113 + 2;
                    while (true) {
                        int i114 = iU41 - 1;
                        if (iU41 <= 0) {
                            break;
                        }
                        int iR5 = classReader7.r(context8, iK11);
                        iK11 = classReader7.k(methodVisitor2E.r(context8.h, context8.i, classReader7.t(iR5, cArr5), true), iR5 + 2, true, cArr5);
                        iU41 = i114;
                    }
                }
                int i115 = i90;
                if (i115 != 0) {
                    int iU42 = classReader7.u(i115);
                    int iK12 = i115 + 2;
                    while (true) {
                        int i116 = iU42 - 1;
                        if (iU42 <= 0) {
                            break;
                        }
                        int iR6 = classReader7.r(context8, iK12);
                        iK12 = classReader7.k(methodVisitor2E.r(context8.h, context8.i, classReader7.t(iR6, cArr5), false), iR6 + 2, true, cArr5);
                        iU42 = i116;
                    }
                }
                int i117 = i91;
                if (i117 != 0) {
                    classReader7.p(methodVisitor2E, context8, i117, true);
                }
                int i118 = i92;
                if (i118 != 0) {
                    classReader7.p(methodVisitor2E, context8, i118, false);
                }
                Attribute2 attribute11 = attribute10;
                while (attribute11 != null) {
                    Attribute2 attribute12 = attribute11.c;
                    attribute11.c = null;
                    attribute11.c = methodWriter3.M;
                    methodWriter3.M = attribute11;
                    attribute11 = attribute12;
                }
                int i119 = i93;
                if (i119 != 0) {
                    classReader7.h(methodVisitor2E, context8, i119);
                }
            }
            iU33 = i80;
            i79 = i83;
            classReader6 = classReader7;
            context7 = context8;
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
        FieldWriter2 fieldWriter2 = this.h;
        int i7 = 0;
        while (true) {
            str = "RuntimeInvisibleTypeAnnotations";
            str2 = "RuntimeVisibleTypeAnnotations";
            iA = 16;
            if (fieldWriter2 == null) {
                break;
            }
            i7++;
            if (fieldWriter2.g != 0) {
                fieldWriter2.f3710b.l("ConstantValue");
            } else {
                iA = 8;
            }
            if ((fieldWriter2.c & 4096) != 0) {
                SymbolTable2 symbolTable2 = fieldWriter2.f3710b;
                if (symbolTable2.c < 49) {
                    symbolTable2.l("Synthetic");
                    iA += 6;
                }
            }
            if (fieldWriter2.f != 0) {
                fieldWriter2.f3710b.l("Signature");
                iA += 8;
            }
            if ((fieldWriter2.c & 131072) != 0) {
                fieldWriter2.f3710b.l("Deprecated");
                iA += 6;
            }
            AnnotationWriter2 annotationWriter2 = fieldWriter2.h;
            if (annotationWriter2 != null) {
                iA += annotationWriter2.a("RuntimeVisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter3 = fieldWriter2.i;
            if (annotationWriter3 != null) {
                iA += annotationWriter3.a("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter2 annotationWriter4 = fieldWriter2.j;
            if (annotationWriter4 != null) {
                iA += annotationWriter4.a("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter2 annotationWriter5 = fieldWriter2.k;
            if (annotationWriter5 != null) {
                iA += annotationWriter5.a("RuntimeInvisibleTypeAnnotations");
            }
            Attribute2 attribute2 = fieldWriter2.l;
            if (attribute2 != null) {
                iA += attribute2.a(fieldWriter2.f3710b);
            }
            iA4 += iA;
            fieldWriter2 = (FieldWriter2) fieldWriter2.a;
        }
        MethodWriter2 methodWriter2 = this.j;
        int i8 = 0;
        while (true) {
            if (methodWriter2 == null) {
                ByteVector2 byteVector2 = this.m;
                if (byteVector2 != null) {
                    iA4 += byteVector2.f3699b + 8;
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
                ByteVector2 byteVector3 = this.r;
                if (byteVector3 != null) {
                    i++;
                    iA4 += byteVector3.f3699b + 6;
                    this.f3701b.l("SourceDebugExtension");
                }
                if ((this.c & 131072) != 0) {
                    i++;
                    iA4 += 6;
                    this.f3701b.l("Deprecated");
                }
                AnnotationWriter2 annotationWriter6 = this.f3702s;
                if (annotationWriter6 != null) {
                    i++;
                    iA4 += annotationWriter6.a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter7 = this.t;
                if (annotationWriter7 != null) {
                    i++;
                    iA4 += annotationWriter7.a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter8 = this.u;
                if (annotationWriter8 != null) {
                    i++;
                    iA4 += annotationWriter8.a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter9 = this.v;
                if (annotationWriter9 != null) {
                    i++;
                    iA4 += annotationWriter9.a("RuntimeInvisibleTypeAnnotations");
                }
                SymbolTable2 symbolTable3 = this.f3701b;
                if (symbolTable3.j != null) {
                    symbolTable3.l("BootstrapMethods");
                    i2 = symbolTable3.j.f3699b + 8;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    i++;
                    SymbolTable2 symbolTable4 = this.f3701b;
                    if (symbolTable4.j != null) {
                        symbolTable4.l("BootstrapMethods");
                        i6 = symbolTable4.j.f3699b + 8;
                    } else {
                        i6 = 0;
                    }
                    iA4 += i6;
                }
                ModuleWriter2 moduleWriter2 = this.w;
                String str6 = "ModuleMainClass";
                int i9 = i8;
                if (moduleWriter2 != null) {
                    i += (moduleWriter2.o > 0 ? 1 : 0) + 1 + (moduleWriter2.q > 0 ? 1 : 0);
                    moduleWriter2.a.l("Module");
                    int i10 = moduleWriter2.f.f3699b + 22 + moduleWriter2.h.f3699b + moduleWriter2.j.f3699b + moduleWriter2.l.f3699b + moduleWriter2.n.f3699b;
                    if (moduleWriter2.o > 0) {
                        moduleWriter2.a.l("ModulePackages");
                        i10 += moduleWriter2.p.f3699b + 8;
                    }
                    if (moduleWriter2.q > 0) {
                        moduleWriter2.a.l("ModuleMainClass");
                        i10 += 8;
                    }
                    iA4 += i10;
                }
                if (this.f3703x != 0) {
                    i++;
                    iA4 += 8;
                    this.f3701b.l("NestHost");
                }
                ByteVector2 byteVector4 = this.f3705z;
                if (byteVector4 != null) {
                    i++;
                    iA4 += byteVector4.f3699b + 8;
                    this.f3701b.l("NestMembers");
                }
                Attribute2 attribute3 = this.A;
                if (attribute3 != null) {
                    int iC = i + attribute3.c();
                    iA4 += this.A.a(this.f3701b);
                    i = iC;
                }
                SymbolTable2 symbolTable5 = this.f3701b;
                int i11 = iA4 + symbolTable5.h.f3699b;
                int i12 = symbolTable5.g;
                if (i12 > 65535) {
                    throw new ClassTooLargeException(this.f3701b.d, i12);
                }
                ByteVector2 byteVector5 = new ByteVector2(i11);
                byteVector5.i(-889275714);
                byteVector5.i(this.a);
                SymbolTable2 symbolTable6 = this.f3701b;
                byteVector5.j(symbolTable6.g);
                ByteVector2 byteVector6 = symbolTable6.h;
                byteVector5.h(byteVector6.a, 0, byteVector6.f3699b);
                byteVector5.j((~((this.a & 65535) < 49 ? 4096 : 0)) & this.c);
                byteVector5.j(this.d);
                byteVector5.j(this.e);
                byteVector5.j(this.f);
                for (int i13 = 0; i13 < this.f; i13++) {
                    byteVector5.j(this.g[i13]);
                }
                byteVector5.j(i7);
                FieldWriter2 fieldWriter3 = this.h;
                while (fieldWriter3 != null) {
                    boolean z2 = fieldWriter3.f3710b.c < 49;
                    byteVector5.j((~(z2 ? 4096 : 0)) & fieldWriter3.c);
                    byteVector5.j(fieldWriter3.d);
                    byteVector5.j(fieldWriter3.e);
                    int iC2 = fieldWriter3.g != 0 ? 1 : 0;
                    int i14 = fieldWriter3.c;
                    String str7 = str6;
                    if ((i14 & 4096) != 0 && z2) {
                        iC2++;
                    }
                    if (fieldWriter3.f != 0) {
                        iC2++;
                    }
                    if ((i14 & 131072) != 0) {
                        iC2++;
                    }
                    if (fieldWriter3.h != null) {
                        iC2++;
                    }
                    if (fieldWriter3.i != null) {
                        iC2++;
                    }
                    if (fieldWriter3.j != null) {
                        iC2++;
                    }
                    if (fieldWriter3.k != null) {
                        iC2++;
                    }
                    Attribute2 attribute4 = fieldWriter3.l;
                    if (attribute4 != null) {
                        iC2 += attribute4.c();
                    }
                    byteVector5.j(iC2);
                    if (fieldWriter3.g != 0) {
                        outline.t0(fieldWriter3.f3710b, "ConstantValue", byteVector5, 2);
                        byteVector5.j(fieldWriter3.g);
                    }
                    if ((fieldWriter3.c & 4096) != 0 && z2) {
                        outline.t0(fieldWriter3.f3710b, "Synthetic", byteVector5, 0);
                    }
                    if (fieldWriter3.f != 0) {
                        outline.t0(fieldWriter3.f3710b, "Signature", byteVector5, 2);
                        byteVector5.j(fieldWriter3.f);
                    }
                    if ((fieldWriter3.c & 131072) != 0) {
                        outline.t0(fieldWriter3.f3710b, "Deprecated", byteVector5, 0);
                    }
                    AnnotationWriter2 annotationWriter10 = fieldWriter3.h;
                    if (annotationWriter10 != null) {
                        annotationWriter10.c(fieldWriter3.f3710b.l("RuntimeVisibleAnnotations"), byteVector5);
                    }
                    AnnotationWriter2 annotationWriter11 = fieldWriter3.i;
                    if (annotationWriter11 != null) {
                        annotationWriter11.c(fieldWriter3.f3710b.l("RuntimeInvisibleAnnotations"), byteVector5);
                    }
                    AnnotationWriter2 annotationWriter12 = fieldWriter3.j;
                    if (annotationWriter12 != null) {
                        str4 = str2;
                        annotationWriter12.c(fieldWriter3.f3710b.l(str4), byteVector5);
                    } else {
                        str4 = str2;
                    }
                    AnnotationWriter2 annotationWriter13 = fieldWriter3.k;
                    if (annotationWriter13 != null) {
                        str5 = str;
                        annotationWriter13.c(fieldWriter3.f3710b.l(str5), byteVector5);
                    } else {
                        str5 = str;
                    }
                    Attribute2 attribute5 = fieldWriter3.l;
                    if (attribute5 != null) {
                        attribute5.d(fieldWriter3.f3710b, byteVector5);
                    }
                    fieldWriter3 = (FieldWriter2) fieldWriter3.a;
                    str2 = str4;
                    str = str5;
                    str6 = str7;
                }
                String str8 = str6;
                String str9 = str;
                String str10 = str2;
                byteVector5.j(i9);
                boolean z3 = false;
                boolean z4 = false;
                for (MethodWriter2 methodWriter3 = this.j; methodWriter3 != null; methodWriter3 = (MethodWriter2) methodWriter3.f3715b) {
                    z4 |= methodWriter3.u > 0;
                    z3 |= methodWriter3.Y;
                    methodWriter3.y(byteVector5);
                }
                byteVector5.j(i);
                if (this.m != null) {
                    byteVector5.j(this.f3701b.l("InnerClasses"));
                    byteVector5.i(this.m.f3699b + 2);
                    byteVector5.j(this.l);
                    ByteVector2 byteVector7 = this.m;
                    byteVector5.h(byteVector7.a, 0, byteVector7.f3699b);
                }
                if (this.n != 0) {
                    outline.t0(this.f3701b, str3, byteVector5, 4);
                    byteVector5.j(this.n);
                    byteVector5.j(this.o);
                }
                if ((this.c & 4096) != 0 && (this.a & 65535) < 49) {
                    outline.t0(this.f3701b, "Synthetic", byteVector5, 0);
                }
                if (this.p != 0) {
                    i3 = 2;
                    outline.t0(this.f3701b, "Signature", byteVector5, 2);
                    byteVector5.j(this.p);
                } else {
                    i3 = 2;
                }
                if (this.q != 0) {
                    outline.t0(this.f3701b, "SourceFile", byteVector5, i3);
                    byteVector5.j(this.q);
                }
                ByteVector2 byteVector8 = this.r;
                if (byteVector8 != null) {
                    int i15 = byteVector8.f3699b;
                    outline.t0(this.f3701b, "SourceDebugExtension", byteVector5, i15);
                    i4 = 0;
                    byteVector5.h(this.r.a, 0, i15);
                } else {
                    i4 = 0;
                }
                if ((this.c & 131072) != 0) {
                    outline.t0(this.f3701b, "Deprecated", byteVector5, i4);
                }
                AnnotationWriter2 annotationWriter14 = this.f3702s;
                if (annotationWriter14 != null) {
                    annotationWriter14.c(this.f3701b.l("RuntimeVisibleAnnotations"), byteVector5);
                }
                AnnotationWriter2 annotationWriter15 = this.t;
                if (annotationWriter15 != null) {
                    annotationWriter15.c(this.f3701b.l("RuntimeInvisibleAnnotations"), byteVector5);
                }
                AnnotationWriter2 annotationWriter16 = this.u;
                if (annotationWriter16 != null) {
                    annotationWriter16.c(this.f3701b.l(str10), byteVector5);
                }
                AnnotationWriter2 annotationWriter17 = this.v;
                if (annotationWriter17 != null) {
                    annotationWriter17.c(this.f3701b.l(str9), byteVector5);
                }
                SymbolTable2 symbolTable7 = this.f3701b;
                if (symbolTable7.j != null) {
                    byteVector5.j(symbolTable7.l("BootstrapMethods"));
                    byteVector5.i(symbolTable7.j.f3699b + 2);
                    byteVector5.j(symbolTable7.i);
                    ByteVector2 byteVector9 = symbolTable7.j;
                    byteVector5.h(byteVector9.a, 0, byteVector9.f3699b);
                }
                ModuleWriter2 moduleWriter3 = this.w;
                if (moduleWriter3 != null) {
                    outline.t0(moduleWriter3.a, "Module", byteVector5, moduleWriter3.f.f3699b + 16 + moduleWriter3.h.f3699b + moduleWriter3.j.f3699b + moduleWriter3.l.f3699b + moduleWriter3.n.f3699b);
                    byteVector5.j(moduleWriter3.f3722b);
                    byteVector5.j(moduleWriter3.c);
                    byteVector5.j(moduleWriter3.d);
                    byteVector5.j(moduleWriter3.e);
                    ByteVector2 byteVector10 = moduleWriter3.f;
                    byteVector5.h(byteVector10.a, 0, byteVector10.f3699b);
                    byteVector5.j(moduleWriter3.g);
                    ByteVector2 byteVector11 = moduleWriter3.h;
                    byteVector5.h(byteVector11.a, 0, byteVector11.f3699b);
                    byteVector5.j(moduleWriter3.i);
                    ByteVector2 byteVector12 = moduleWriter3.j;
                    byteVector5.h(byteVector12.a, 0, byteVector12.f3699b);
                    byteVector5.j(moduleWriter3.k);
                    ByteVector2 byteVector13 = moduleWriter3.l;
                    byteVector5.h(byteVector13.a, 0, byteVector13.f3699b);
                    byteVector5.j(moduleWriter3.m);
                    ByteVector2 byteVector14 = moduleWriter3.n;
                    byteVector5.h(byteVector14.a, 0, byteVector14.f3699b);
                    if (moduleWriter3.o > 0) {
                        byteVector5.j(moduleWriter3.a.l("ModulePackages"));
                        byteVector5.i(moduleWriter3.p.f3699b + 2);
                        byteVector5.j(moduleWriter3.o);
                        ByteVector2 byteVector15 = moduleWriter3.p;
                        byteVector5.h(byteVector15.a, 0, byteVector15.f3699b);
                    }
                    if (moduleWriter3.q > 0) {
                        i5 = 2;
                        outline.t0(moduleWriter3.a, str8, byteVector5, 2);
                        byteVector5.j(moduleWriter3.q);
                    } else {
                        i5 = 2;
                    }
                } else {
                    i5 = 2;
                }
                if (this.f3703x != 0) {
                    outline.t0(this.f3701b, "NestHost", byteVector5, i5);
                    byteVector5.j(this.f3703x);
                }
                if (this.f3705z != null) {
                    byteVector5.j(this.f3701b.l("NestMembers"));
                    byteVector5.i(this.f3705z.f3699b + 2);
                    byteVector5.j(this.f3704y);
                    ByteVector2 byteVector16 = this.f3705z;
                    byteVector5.h(byteVector16.a, 0, byteVector16.f3699b);
                }
                Attribute2 attribute6 = this.A;
                if (attribute6 != null) {
                    attribute6.d(this.f3701b, byteVector5);
                }
                return z3 ? a(byteVector5.a, z4) : byteVector5.a;
            }
            int i16 = i8 + 1;
            if (methodWriter2.f3716a0 != 0) {
                iA3 = methodWriter2.f3717b0 + 6;
                i16 = i16;
            } else {
                int i17 = methodWriter2.l.f3699b;
                if (i17 <= 0) {
                    i16 = i16;
                    iA2 = 8;
                } else {
                    if (i17 > 65535) {
                        throw new MethodTooLargeException(methodWriter2.d.d, methodWriter2.g, methodWriter2.i, methodWriter2.l.f3699b);
                    }
                    methodWriter2.d.l("Code");
                    int i18 = methodWriter2.l.f3699b + iA;
                    int i19 = 0;
                    for (Handler5 handler5 = methodWriter2.m; handler5 != null; handler5 = handler5.f) {
                        i19++;
                    }
                    iA2 = (i19 * 8) + 2 + i18 + 8;
                    if (methodWriter2.v != null) {
                        SymbolTable2 symbolTable8 = methodWriter2.d;
                        symbolTable8.l(symbolTable8.c >= 50 ? "StackMapTable" : "StackMap");
                        iA2 += methodWriter2.v.f3699b + 8;
                    }
                    if (methodWriter2.p != null) {
                        methodWriter2.d.l("LineNumberTable");
                        iA2 += methodWriter2.p.f3699b + 8;
                    }
                    if (methodWriter2.r != null) {
                        methodWriter2.d.l("LocalVariableTable");
                        iA2 += methodWriter2.r.f3699b + 8;
                    }
                    if (methodWriter2.t != null) {
                        methodWriter2.d.l("LocalVariableTypeTable");
                        iA2 += methodWriter2.t.f3699b + 8;
                    }
                    AnnotationWriter2 annotationWriter18 = methodWriter2.w;
                    if (annotationWriter18 != null) {
                        iA2 += annotationWriter18.a("RuntimeVisibleTypeAnnotations");
                    }
                    AnnotationWriter2 annotationWriter19 = methodWriter2.f3719x;
                    if (annotationWriter19 != null) {
                        iA2 += annotationWriter19.a("RuntimeInvisibleTypeAnnotations");
                    }
                }
                if (methodWriter2.f3720y > 0) {
                    methodWriter2.d.l("Exceptions");
                    iA2 += (methodWriter2.f3720y * 2) + 8;
                }
                SymbolTable2 symbolTable9 = methodWriter2.d;
                boolean z5 = symbolTable9.c < 49;
                if ((methodWriter2.e & 4096) != 0 && z5) {
                    symbolTable9.l("Synthetic");
                    iA2 += 6;
                }
                if (methodWriter2.A != 0) {
                    methodWriter2.d.l("Signature");
                    iA2 += 8;
                }
                if ((methodWriter2.e & 131072) != 0) {
                    methodWriter2.d.l("Deprecated");
                    iA2 += 6;
                }
                AnnotationWriter2 annotationWriter20 = methodWriter2.B;
                if (annotationWriter20 != null) {
                    iA2 += annotationWriter20.a("RuntimeVisibleAnnotations");
                }
                AnnotationWriter2 annotationWriter21 = methodWriter2.C;
                if (annotationWriter21 != null) {
                    iA2 += annotationWriter21.a("RuntimeInvisibleAnnotations");
                }
                AnnotationWriter2[] annotationWriter2Arr = methodWriter2.E;
                if (annotationWriter2Arr != null) {
                    int length = methodWriter2.D;
                    if (length == 0) {
                        length = annotationWriter2Arr.length;
                    }
                    iA2 += AnnotationWriter2.b("RuntimeVisibleParameterAnnotations", annotationWriter2Arr, length);
                }
                AnnotationWriter2[] annotationWriter2Arr2 = methodWriter2.G;
                if (annotationWriter2Arr2 != null) {
                    int length2 = methodWriter2.F;
                    if (length2 == 0) {
                        length2 = annotationWriter2Arr2.length;
                    }
                    iA2 += AnnotationWriter2.b("RuntimeInvisibleParameterAnnotations", annotationWriter2Arr2, length2);
                }
                AnnotationWriter2 annotationWriter22 = methodWriter2.H;
                if (annotationWriter22 != null) {
                    iA2 += annotationWriter22.a("RuntimeVisibleTypeAnnotations");
                }
                AnnotationWriter2 annotationWriter23 = methodWriter2.I;
                if (annotationWriter23 != null) {
                    iA2 += annotationWriter23.a("RuntimeInvisibleTypeAnnotations");
                }
                if (methodWriter2.J != null) {
                    methodWriter2.d.l("AnnotationDefault");
                    iA2 += methodWriter2.J.f3699b + 6;
                }
                if (methodWriter2.L != null) {
                    methodWriter2.d.l("MethodParameters");
                    iA3 = methodWriter2.L.f3699b + 7 + iA2;
                } else {
                    iA3 = iA2;
                }
                Attribute2 attribute7 = methodWriter2.M;
                if (attribute7 != null) {
                    iA3 += attribute7.a(methodWriter2.d);
                }
            }
            iA4 += iA3;
            methodWriter2 = (MethodWriter2) methodWriter2.f3715b;
            iA = 16;
            i8 = i16;
        }
    }

    public final void c(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.a = i;
        this.c = i2;
        SymbolTable2 symbolTable2 = this.f3701b;
        int i3 = i & 65535;
        symbolTable2.c = i3;
        symbolTable2.d = str;
        this.d = symbolTable2.m(7, str).a;
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

    public final AnnotationWriter2 d(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.j(this.f3701b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.f3702s);
            this.f3702s = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.t);
        this.t = annotationWriter3;
        return annotationWriter3;
    }

    public final MethodVisitor2 e(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter2 methodWriter2 = new MethodWriter2(this.f3701b, i, str, str2, str3, strArr, this.B);
        if (this.j == null) {
            this.j = methodWriter2;
        } else {
            this.k.f3715b = methodWriter2;
        }
        this.k = methodWriter2;
        return methodWriter2;
    }

    public final AnnotationWriter2 f(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        b.i.a.f.e.o.f.W0(i, byteVector2);
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.f3701b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.u);
            this.u = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.f3701b, true, byteVector2, this.v);
        this.v = annotationWriter3;
        return annotationWriter3;
    }
}
