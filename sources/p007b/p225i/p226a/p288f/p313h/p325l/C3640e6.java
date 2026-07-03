package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.api.permission.Permission;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: b.i.a.f.h.l.e6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3640e6<T> implements InterfaceC3801q6<T> {

    /* JADX INFO: renamed from: a */
    public static final int[] f9913a = new int[0];

    /* JADX INFO: renamed from: b */
    public static final Unsafe f9914b = C3711j7.m4986k();

    /* JADX INFO: renamed from: c */
    public final int[] f9915c;

    /* JADX INFO: renamed from: d */
    public final Object[] f9916d;

    /* JADX INFO: renamed from: e */
    public final int f9917e;

    /* JADX INFO: renamed from: f */
    public final int f9918f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC3612c6 f9919g;

    /* JADX INFO: renamed from: h */
    public final boolean f9920h;

    /* JADX INFO: renamed from: i */
    public final boolean f9921i;

    /* JADX INFO: renamed from: j */
    public final int[] f9922j;

    /* JADX INFO: renamed from: k */
    public final int f9923k;

    /* JADX INFO: renamed from: l */
    public final int f9924l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC3696i6 f9925m;

    /* JADX INFO: renamed from: n */
    public final AbstractC3748m5 f9926n;

    /* JADX INFO: renamed from: o */
    public final AbstractC3627d7<?, ?> f9927o;

    /* JADX INFO: renamed from: p */
    public final AbstractC3708j4<?> f9928p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC3865v5 f9929q;

    public C3640e6(int[] iArr, Object[] objArr, int i, int i2, InterfaceC3612c6 interfaceC3612c6, boolean z2, int[] iArr2, int i3, int i4, InterfaceC3696i6 interfaceC3696i6, AbstractC3748m5 abstractC3748m5, AbstractC3627d7 abstractC3627d7, AbstractC3708j4 abstractC3708j4, InterfaceC3865v5 interfaceC3865v5) {
        this.f9915c = iArr;
        this.f9916d = objArr;
        this.f9917e = i;
        this.f9918f = i2;
        boolean z3 = interfaceC3612c6 instanceof AbstractC3851u4;
        this.f9921i = z2;
        this.f9920h = abstractC3708j4 != null && abstractC3708j4.mo4973e(interfaceC3612c6);
        this.f9922j = iArr2;
        this.f9923k = i3;
        this.f9924l = i4;
        this.f9925m = interfaceC3696i6;
        this.f9926n = abstractC3748m5;
        this.f9927o = abstractC3627d7;
        this.f9928p = abstractC3708j4;
        this.f9919g = interfaceC3612c6;
        this.f9929q = interfaceC3865v5;
    }

    /* JADX INFO: renamed from: F */
    public static <T> float m4823F(T t, long j) {
        return ((Float) C3711j7.m4993r(t, j)).floatValue();
    }

    /* JADX INFO: renamed from: J */
    public static <T> int m4824J(T t, long j) {
        return ((Integer) C3711j7.m4993r(t, j)).intValue();
    }

    /* JADX INFO: renamed from: L */
    public static <T> long m4825L(T t, long j) {
        return ((Long) C3711j7.m4993r(t, j)).longValue();
    }

    /* JADX INFO: renamed from: M */
    public static C3613c7 m4826M(Object obj) {
        AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) obj;
        C3613c7 c3613c7 = abstractC3851u4.zzb;
        if (c3613c7 != C3613c7.f9877a) {
            return c3613c7;
        }
        C3613c7 c3613c7M4610c = C3613c7.m4610c();
        abstractC3851u4.zzb = c3613c7M4610c;
        return c3613c7M4610c;
    }

    /* JADX INFO: renamed from: N */
    public static <T> boolean m4827N(T t, long j) {
        return ((Boolean) C3711j7.m4993r(t, j)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:182:0x03a5  */
    /* JADX INFO: renamed from: n */
    public static C3640e6 m4828n(InterfaceC3584a6 interfaceC3584a6, InterfaceC3696i6 interfaceC3696i6, AbstractC3748m5 abstractC3748m5, AbstractC3627d7 abstractC3627d7, AbstractC3708j4 abstractC3708j4, InterfaceC3865v5 interfaceC3865v5) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        int i6;
        char cCharAt3;
        int i7;
        char cCharAt4;
        int i8;
        char cCharAt5;
        int i9;
        char cCharAt6;
        int i10;
        char cCharAt7;
        int i11;
        char cCharAt8;
        int i12;
        int i13;
        int i14;
        int i15;
        C3775o6 c3775o6;
        int i16;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i17;
        Field fieldM4829p;
        int i18;
        char cCharAt9;
        int i19;
        int i20;
        Field fieldM4829p2;
        Field fieldM4829p3;
        int i21;
        char cCharAt10;
        int i22;
        char cCharAt11;
        int i23;
        char cCharAt12;
        int i24;
        char cCharAt13;
        if (!(interfaceC3584a6 instanceof C3775o6)) {
            throw new NoSuchMethodError();
        }
        C3775o6 c3775o7 = (C3775o6) interfaceC3584a6;
        int i25 = 0;
        boolean z2 = ((c3775o7.f10181d & 1) == 1 ? (char) 1 : (char) 2) == 2;
        String str = c3775o7.f10179b;
        int length = str.length();
        if (str.charAt(0) >= 55296) {
            int i26 = 1;
            while (true) {
                i = i26 + 1;
                if (str.charAt(i26) < 55296) {
                    break;
                }
                i26 = i;
            }
        } else {
            i = 1;
        }
        int i27 = i + 1;
        int iCharAt5 = str.charAt(i);
        if (iCharAt5 >= 55296) {
            int i28 = iCharAt5 & 8191;
            int i29 = 13;
            while (true) {
                i24 = i27 + 1;
                cCharAt13 = str.charAt(i27);
                if (cCharAt13 < 55296) {
                    break;
                }
                i28 |= (cCharAt13 & 8191) << i29;
                i29 += 13;
                i27 = i24;
            }
            iCharAt5 = i28 | (cCharAt13 << i29);
            i27 = i24;
        }
        if (iCharAt5 == 0) {
            iArr = f9913a;
            i3 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iCharAt4 = 0;
        } else {
            int i30 = i27 + 1;
            int iCharAt6 = str.charAt(i27);
            if (iCharAt6 >= 55296) {
                int i31 = iCharAt6 & 8191;
                int i32 = 13;
                while (true) {
                    i11 = i30 + 1;
                    cCharAt8 = str.charAt(i30);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i31 |= (cCharAt8 & 8191) << i32;
                    i32 += 13;
                    i30 = i11;
                }
                iCharAt6 = i31 | (cCharAt8 << i32);
                i30 = i11;
            }
            int i33 = i30 + 1;
            int iCharAt7 = str.charAt(i30);
            if (iCharAt7 >= 55296) {
                int i34 = iCharAt7 & 8191;
                int i35 = 13;
                while (true) {
                    i10 = i33 + 1;
                    cCharAt7 = str.charAt(i33);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt7 & 8191) << i35;
                    i35 += 13;
                    i33 = i10;
                }
                iCharAt7 = i34 | (cCharAt7 << i35);
                i33 = i10;
            }
            int i36 = i33 + 1;
            iCharAt = str.charAt(i33);
            if (iCharAt >= 55296) {
                int i37 = iCharAt & 8191;
                int i38 = 13;
                while (true) {
                    i9 = i36 + 1;
                    cCharAt6 = str.charAt(i36);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt6 & 8191) << i38;
                    i38 += 13;
                    i36 = i9;
                }
                iCharAt = i37 | (cCharAt6 << i38);
                i36 = i9;
            }
            int i39 = i36 + 1;
            iCharAt2 = str.charAt(i36);
            if (iCharAt2 >= 55296) {
                int i40 = iCharAt2 & 8191;
                int i41 = 13;
                while (true) {
                    i8 = i39 + 1;
                    cCharAt5 = str.charAt(i39);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt5 & 8191) << i41;
                    i41 += 13;
                    i39 = i8;
                }
                iCharAt2 = i40 | (cCharAt5 << i41);
                i39 = i8;
            }
            int i42 = i39 + 1;
            iCharAt3 = str.charAt(i39);
            if (iCharAt3 >= 55296) {
                int i43 = iCharAt3 & 8191;
                int i44 = 13;
                while (true) {
                    i7 = i42 + 1;
                    cCharAt4 = str.charAt(i42);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt4 & 8191) << i44;
                    i44 += 13;
                    i42 = i7;
                }
                iCharAt3 = i43 | (cCharAt4 << i44);
                i42 = i7;
            }
            int i45 = i42 + 1;
            int iCharAt8 = str.charAt(i42);
            if (iCharAt8 >= 55296) {
                int i46 = iCharAt8 & 8191;
                int i47 = 13;
                while (true) {
                    i6 = i45 + 1;
                    cCharAt3 = str.charAt(i45);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt3 & 8191) << i47;
                    i47 += 13;
                    i45 = i6;
                }
                iCharAt8 = i46 | (cCharAt3 << i47);
                i45 = i6;
            }
            int i48 = i45 + 1;
            int iCharAt9 = str.charAt(i45);
            if (iCharAt9 >= 55296) {
                int i49 = iCharAt9 & 8191;
                int i50 = 13;
                while (true) {
                    i5 = i48 + 1;
                    cCharAt2 = str.charAt(i48);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt2 & 8191) << i50;
                    i50 += 13;
                    i48 = i5;
                }
                iCharAt9 = i49 | (cCharAt2 << i50);
                i48 = i5;
            }
            int i51 = i48 + 1;
            iCharAt4 = str.charAt(i48);
            if (iCharAt4 >= 55296) {
                int i52 = iCharAt4 & 8191;
                int i53 = i51;
                int i54 = 13;
                while (true) {
                    i4 = i53 + 1;
                    cCharAt = str.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i52 |= (cCharAt & 8191) << i54;
                    i54 += 13;
                    i53 = i4;
                }
                iCharAt4 = i52 | (cCharAt << i54);
                i51 = i4;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = (iCharAt6 << 1) + iCharAt7;
            i3 = iCharAt8;
            iArr = iArr2;
            i25 = iCharAt6;
            i27 = i51;
        }
        Unsafe unsafe = f9914b;
        Object[] objArr = c3775o7.f10180c;
        Class<?> cls = c3775o7.f10178a.getClass();
        int i55 = i27;
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr2 = new Object[iCharAt3 << 1];
        int i56 = iCharAt4 + i3;
        int i57 = iCharAt4;
        int i58 = i55;
        int i59 = i56;
        int i60 = 0;
        int i61 = 0;
        while (i58 < length) {
            int i62 = i58 + 1;
            int iCharAt10 = str.charAt(i58);
            int i63 = length;
            if (iCharAt10 >= 55296) {
                int i64 = iCharAt10 & 8191;
                int i65 = i62;
                int i66 = 13;
                while (true) {
                    i23 = i65 + 1;
                    cCharAt12 = str.charAt(i65);
                    i12 = iCharAt4;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i23;
                    iCharAt4 = i12;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i13 = i23;
            } else {
                i12 = iCharAt4;
                i13 = i62;
            }
            int i67 = i13 + 1;
            int iCharAt11 = str.charAt(i13);
            if (iCharAt11 >= 55296) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i22 = i69 + 1;
                    cCharAt11 = str.charAt(i69);
                    i14 = iCharAt2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i22;
                    iCharAt2 = i14;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i15 = i22;
            } else {
                i14 = iCharAt2;
                i15 = i67;
            }
            int i71 = iCharAt11 & 255;
            int i72 = iCharAt;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            if (i71 >= 51) {
                int i73 = i15 + 1;
                int iCharAt12 = str.charAt(i15);
                char c = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = 13;
                    int i75 = iCharAt12 & 8191;
                    int i76 = i73;
                    while (true) {
                        i21 = i76 + 1;
                        cCharAt10 = str.charAt(i76);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i76 = i21;
                        c = 55296;
                    }
                    iCharAt12 = i75 | (cCharAt10 << i74);
                    i20 = i21;
                } else {
                    i20 = i73;
                }
                int i77 = i20;
                int i78 = i71 - 51;
                c3775o6 = c3775o7;
                if (i78 == 9 || i78 == 17) {
                    objArr2[((i61 / 3) << 1) + 1] = objArr[i2];
                    i2++;
                } else if (i78 == 12 && !z2) {
                    objArr2[((i61 / 3) << 1) + 1] = objArr[i2];
                    i2++;
                }
                int i79 = iCharAt12 << 1;
                Object obj = objArr[i79];
                if (obj instanceof Field) {
                    fieldM4829p2 = (Field) obj;
                } else {
                    fieldM4829p2 = m4829p(cls, (String) obj);
                    objArr[i79] = fieldM4829p2;
                }
                int i80 = i2;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4829p2);
                int i81 = i79 + 1;
                Object obj2 = objArr[i81];
                if (obj2 instanceof Field) {
                    fieldM4829p3 = (Field) obj2;
                } else {
                    fieldM4829p3 = m4829p(cls, (String) obj2);
                    objArr[i81] = fieldM4829p3;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldM4829p3);
                str = str;
                z2 = z2;
                i15 = i77;
                i16 = i80;
                iObjectFieldOffset2 = iObjectFieldOffset3;
                objArr2 = objArr2;
                i17 = 0;
            } else {
                c3775o6 = c3775o7;
                i16 = i2 + 1;
                Field fieldM4829p4 = m4829p(cls, (String) objArr[i2]);
                if (i71 == 9 || i71 == 17) {
                    objArr2[((i61 / 3) << 1) + 1] = fieldM4829p4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        i19 = i16 + 1;
                        objArr2[((i61 / 3) << 1) + 1] = objArr[i16];
                    } else {
                        if (i71 == 12 || i71 == 30 || i71 == 44) {
                            if (!z2) {
                                i19 = i16 + 1;
                                objArr2[((i61 / 3) << 1) + 1] = objArr[i16];
                            }
                        } else if (i71 == 50) {
                            int i82 = i57 + 1;
                            iArr[i57] = i61;
                            int i83 = (i61 / 3) << 1;
                            i19 = i16 + 1;
                            objArr2[i83] = objArr[i16];
                            if ((iCharAt11 & 2048) != 0) {
                                i16 = i19 + 1;
                                objArr2[i83 + 1] = objArr[i19];
                                i57 = i82;
                            } else {
                                i57 = i82;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4829p4);
                        if ((iCharAt11 & 4096) == 4096 || i71 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i17 = 0;
                        } else {
                            int i84 = i15 + 1;
                            int iCharAt13 = str.charAt(i15);
                            if (iCharAt13 >= 55296) {
                                int i85 = iCharAt13 & 8191;
                                int i86 = 13;
                                while (true) {
                                    i18 = i84 + 1;
                                    cCharAt9 = str.charAt(i84);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i85 |= (cCharAt9 & 8191) << i86;
                                    i86 += 13;
                                    i84 = i18;
                                }
                                iCharAt13 = i85 | (cCharAt9 << i86);
                                i84 = i18;
                            }
                            int i87 = (iCharAt13 / 32) + (i25 << 1);
                            Object obj3 = objArr[i87];
                            if (obj3 instanceof Field) {
                                fieldM4829p = (Field) obj3;
                            } else {
                                fieldM4829p = m4829p(cls, (String) obj3);
                                objArr[i87] = fieldM4829p;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM4829p);
                            i17 = iCharAt13 % 32;
                            i15 = i84;
                        }
                        if (i71 >= 18 && i71 <= 49) {
                            iArr[i59] = iObjectFieldOffset;
                            i59++;
                        }
                    }
                    i16 = i19;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM4829p4);
                if ((iCharAt11 & 4096) == 4096) {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i17 = 0;
                }
                if (i71 >= 18) {
                    iArr[i59] = iObjectFieldOffset;
                    i59++;
                }
            }
            int i88 = i61 + 1;
            iArr3[i61] = iCharAt10;
            int i89 = i88 + 1;
            iArr3[i88] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i71 << 20) | iObjectFieldOffset;
            i61 = i89 + 1;
            iArr3[i89] = (i17 << 20) | iObjectFieldOffset2;
            z2 = z2;
            i58 = i15;
            iCharAt = i72;
            length = i63;
            iCharAt4 = i12;
            iCharAt2 = i14;
            objArr2 = objArr2;
            str = str;
            i2 = i16;
            c3775o7 = c3775o6;
        }
        return new C3640e6(iArr3, objArr2, iCharAt, iCharAt2, c3775o7.f10178a, z2, iArr, iCharAt4, i56, interfaceC3696i6, abstractC3748m5, abstractC3627d7, abstractC3708j4, interfaceC3865v5);
    }

    /* JADX INFO: renamed from: p */
    public static Field m4829p(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(C1643a.m822J(C1643a.m831S(C1643a.m841b(string, name.length() + C1643a.m841b(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", string));
        }
    }

    /* JADX INFO: renamed from: q */
    public static List<?> m4830q(Object obj, long j) {
        return (List) C3711j7.m4993r(obj, j);
    }

    /* JADX INFO: renamed from: r */
    public static void m4831r(int i, Object obj, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        if (obj instanceof String) {
            ((C3666g4) interfaceC3867v7).f9967a.mo9091k(i, (String) obj);
        } else {
            ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i, (AbstractC3837t3) obj);
        }
    }

    /* JADX INFO: renamed from: s */
    public static <UT, UB> void m4832s(AbstractC3627d7<UT, UB> abstractC3627d7, T t, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        abstractC3627d7.mo4636c(abstractC3627d7.mo4638e(t), interfaceC3867v7);
    }

    /* JADX INFO: renamed from: y */
    public static <T> double m4833y(T t, long j) {
        return ((Double) C3711j7.m4993r(t, j)).doubleValue();
    }

    /* JADX INFO: renamed from: A */
    public final Object m4834A(int i) {
        return this.f9916d[(i / 3) << 1];
    }

    /* JADX INFO: renamed from: B */
    public final void m4835B(T t, int i) {
        int i2 = this.f9915c[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        C3711j7.f10036e.m5005e(t, j, (1 << (i2 >>> 20)) | C3711j7.m4977b(t, j));
    }

    /* JADX INFO: renamed from: C */
    public final void m4836C(T t, int i, int i2) {
        C3711j7.f10036e.m5005e(t, this.f9915c[i2 + 2] & 1048575, i);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX INFO: renamed from: D */
    public final void m4837D(T t, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        Iterator itM5135l;
        Map.Entry<?, ?> entry;
        int i;
        if (this.f9920h) {
            C3760n4<T> c3760n4Mo4970b = this.f9928p.mo4970b(t);
            if (c3760n4Mo4970b.f10111b.isEmpty()) {
                itM5135l = null;
                entry = null;
            } else {
                itM5135l = c3760n4Mo4970b.m5135l();
                entry = (Map.Entry) itM5135l.next();
            }
        } else {
            itM5135l = null;
            entry = null;
        }
        int length = this.f9915c.length;
        Unsafe unsafe = f9914b;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iM4841I = m4841I(i4);
            int[] iArr = this.f9915c;
            int i5 = iArr[i4];
            int i6 = (iM4841I & 267386880) >>> 20;
            if (i6 <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                if (i8 != i2) {
                    i3 = unsafe.getInt(t, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.f9928p.mo4969a(entry) <= i5) {
                this.f9928p.mo4972d(interfaceC3867v7, entry);
                entry = itM5135l.hasNext() ? (Map.Entry) itM5135l.next() : null;
            }
            long j = iM4841I & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4909a(i5, C3711j7.m4992q(t, j));
                        continue;
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4910b(i5, C3711j7.m4989n(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9092l(i5, C3711j7.m4988m(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        m4831r(i5, unsafe.getObject(t, j), interfaceC3867v7);
                    } else {
                        continue;
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4912d(i5, unsafe.getObject(t, j), m4856o(i4));
                    } else {
                        continue;
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i5, (AbstractC3837t3) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9097y(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4915g(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4914f(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        ((C3666g4) interfaceC3867v7).m4913e(i5, unsafe.getObject(t, j), m4856o(i4));
                    } else {
                        continue;
                    }
                    break;
                case 18:
                    C3827s6.m5242h(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 19:
                    C3827s6.m5251q(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 20:
                    C3827s6.m5255u(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 21:
                    C3827s6.m5258x(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 22:
                    C3827s6.m5226J(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 23:
                    C3827s6.m5220D(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 24:
                    C3827s6.m5231O(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 25:
                    C3827s6.m5234R(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 26:
                    C3827s6.m5240f(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7);
                    break;
                case 27:
                    C3827s6.m5241g(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, m4856o(i4));
                    break;
                case 28:
                    C3827s6.m5249o(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7);
                    break;
                case 29:
                    C3827s6.m5229M(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 30:
                    C3827s6.m5233Q(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 31:
                    C3827s6.m5232P(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 32:
                    C3827s6.m5223G(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 33:
                    C3827s6.m5230N(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 34:
                    C3827s6.m5217A(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, false);
                    break;
                case 35:
                    C3827s6.m5242h(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 36:
                    C3827s6.m5251q(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 37:
                    C3827s6.m5255u(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 38:
                    C3827s6.m5258x(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 39:
                    C3827s6.m5226J(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 40:
                    C3827s6.m5220D(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 41:
                    C3827s6.m5231O(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 42:
                    C3827s6.m5234R(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 43:
                    C3827s6.m5229M(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 44:
                    C3827s6.m5233Q(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 45:
                    C3827s6.m5232P(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 46:
                    C3827s6.m5223G(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 47:
                    C3827s6.m5230N(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 48:
                    C3827s6.m5217A(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, true);
                    break;
                case 49:
                    C3827s6.m5250p(this.f9915c[i4], (List) unsafe.getObject(t, j), interfaceC3867v7, m4856o(i4));
                    break;
                case 50:
                    m4857t(interfaceC3867v7, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4909a(i5, m4833y(t, j));
                    }
                    break;
                case 52:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4910b(i5, m4823F(t, j));
                    }
                    break;
                case 53:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i5, m4825L(t, j));
                    }
                    break;
                case 54:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i5, m4825L(t, j));
                    }
                    break;
                case 55:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i5, m4824J(t, j));
                    }
                    break;
                case 56:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i5, m4825L(t, j));
                    }
                    break;
                case 57:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i5, m4824J(t, j));
                    }
                    break;
                case 58:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9092l(i5, m4827N(t, j));
                    }
                    break;
                case 59:
                    if (m4860w(t, i5, i4)) {
                        m4831r(i5, unsafe.getObject(t, j), interfaceC3867v7);
                    }
                    break;
                case 60:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4912d(i5, unsafe.getObject(t, j), m4856o(i4));
                    }
                    break;
                case 61:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i5, (AbstractC3837t3) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9097y(i5, m4824J(t, j));
                    }
                    break;
                case 63:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i5, m4824J(t, j));
                    }
                    break;
                case 64:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i5, m4824J(t, j));
                    }
                    break;
                case 65:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i5, m4825L(t, j));
                    }
                    break;
                case 66:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4915g(i5, m4824J(t, j));
                    }
                    break;
                case 67:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4914f(i5, m4825L(t, j));
                    }
                    break;
                case 68:
                    if (m4860w(t, i5, i4)) {
                        ((C3666g4) interfaceC3867v7).m4913e(i5, unsafe.getObject(t, j), m4856o(i4));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.f9928p.mo4972d(interfaceC3867v7, entry);
            entry = itM5135l.hasNext() ? (Map.Entry) itM5135l.next() : null;
        }
        m4832s(this.f9927o, t, interfaceC3867v7);
    }

    /* JADX INFO: renamed from: E */
    public final void m4838E(T t, T t2, int i) {
        int[] iArr = this.f9915c;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (m4860w(t2, i3, i)) {
            Object objM4993r = m4860w(t, i3, i) ? C3711j7.m4993r(t, j) : null;
            Object objM4993r2 = C3711j7.m4993r(t2, j);
            if (objM4993r != null && objM4993r2 != null) {
                C3711j7.m4981f(t, j, C3877w4.m5346c(objM4993r, objM4993r2));
                m4836C(t, i3, i);
            } else if (objM4993r2 != null) {
                C3711j7.m4981f(t, j, objM4993r2);
                m4836C(t, i3, i);
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final InterfaceC3583a5 m4839G(int i) {
        return (InterfaceC3583a5) this.f9916d[((i / 3) << 1) + 1];
    }

    /* JADX INFO: renamed from: H */
    public final boolean m4840H(T t, T t2, int i) {
        return m4859v(t, i) == m4859v(t2, i);
    }

    /* JADX INFO: renamed from: I */
    public final int m4841I(int i) {
        return this.f9915c[i + 1];
    }

    /* JADX INFO: renamed from: K */
    public final int m4842K(int i) {
        return this.f9915c[i + 2];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: a */
    public final T mo4843a() {
        return (T) this.f9925m.mo4937b(this.f9919g);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: b */
    public final int mo4844b(T t) {
        int i;
        int iM5344a;
        int length = this.f9915c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iM4841I = m4841I(i3);
            int i4 = this.f9915c[i3];
            long j = 1048575 & iM4841I;
            int iHashCode = 37;
            switch ((iM4841I & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(Double.doubleToLongBits(C3711j7.m4992q(t, j)));
                    i2 = iM5344a + i;
                    break;
                case 1:
                    i = i2 * 53;
                    iM5344a = Float.floatToIntBits(C3711j7.m4989n(t, j));
                    i2 = iM5344a + i;
                    break;
                case 2:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(C3711j7.m4984i(t, j));
                    i2 = iM5344a + i;
                    break;
                case 3:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(C3711j7.m4984i(t, j));
                    i2 = iM5344a + i;
                    break;
                case 4:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 5:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(C3711j7.m4984i(t, j));
                    i2 = iM5344a + i;
                    break;
                case 6:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 7:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5345b(C3711j7.m4988m(t, j));
                    i2 = iM5344a + i;
                    break;
                case 8:
                    i = i2 * 53;
                    iM5344a = ((String) C3711j7.m4993r(t, j)).hashCode();
                    i2 = iM5344a + i;
                    break;
                case 9:
                    Object objM4993r = C3711j7.m4993r(t, j);
                    if (objM4993r != null) {
                        iHashCode = objM4993r.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4993r(t, j).hashCode();
                    i2 = iM5344a + i;
                    break;
                case 11:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 12:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 13:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 14:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(C3711j7.m4984i(t, j));
                    i2 = iM5344a + i;
                    break;
                case 15:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4977b(t, j);
                    i2 = iM5344a + i;
                    break;
                case 16:
                    i = i2 * 53;
                    iM5344a = C3877w4.m5344a(C3711j7.m4984i(t, j));
                    i2 = iM5344a + i;
                    break;
                case 17:
                    Object objM4993r2 = C3711j7.m4993r(t, j);
                    if (objM4993r2 != null) {
                        iHashCode = objM4993r2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    i = i2 * 53;
                    iM5344a = C3711j7.m4993r(t, j).hashCode();
                    i2 = iM5344a + i;
                    break;
                case 50:
                    i = i2 * 53;
                    iM5344a = C3711j7.m4993r(t, j).hashCode();
                    i2 = iM5344a + i;
                    break;
                case 51:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(Double.doubleToLongBits(m4833y(t, j)));
                        i2 = iM5344a + i;
                    }
                    break;
                case 52:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = Float.floatToIntBits(m4823F(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 53:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(m4825L(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 54:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(m4825L(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 55:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 56:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(m4825L(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 57:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 58:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5345b(m4827N(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 59:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = ((String) C3711j7.m4993r(t, j)).hashCode();
                        i2 = iM5344a + i;
                    }
                    break;
                case 60:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3711j7.m4993r(t, j).hashCode();
                        i2 = iM5344a + i;
                    }
                    break;
                case 61:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3711j7.m4993r(t, j).hashCode();
                        i2 = iM5344a + i;
                    }
                    break;
                case 62:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 63:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 64:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 65:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(m4825L(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 66:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = m4824J(t, j);
                        i2 = iM5344a + i;
                    }
                    break;
                case 67:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3877w4.m5344a(m4825L(t, j));
                        i2 = iM5344a + i;
                    }
                    break;
                case 68:
                    if (m4860w(t, i4, i3)) {
                        i = i2 * 53;
                        iM5344a = C3711j7.m4993r(t, j).hashCode();
                        i2 = iM5344a + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.f9927o.mo4638e(t).hashCode() + (i2 * 53);
        return this.f9920h ? (iHashCode2 * 53) + this.f9928p.mo4970b(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de A[LOOP:1: B:47:0x00cc->B:52:0x00de, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: c */
    public final boolean mo4845c(T t) {
        int i;
        int i2;
        List list;
        InterfaceC3801q6 interfaceC3801q6M4856o;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            if (i6 >= this.f9923k) {
                return !this.f9920h || this.f9928p.mo4970b(t).m5136m();
            }
            int i7 = this.f9922j[i6];
            int i8 = this.f9915c[i7];
            int iM4841I = m4841I(i7);
            int i9 = this.f9915c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = f9914b.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if (((268435456 & iM4841I) != 0) && !m4861x(t, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & iM4841I) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (m4861x(t, i7, i, i2, i11) && !m4856o(i7).mo4845c(C3711j7.m4993r(t, iM4841I & 1048575))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) C3711j7.m4993r(t, iM4841I & 1048575);
                if (!list.isEmpty()) {
                    interfaceC3801q6M4856o = m4856o(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!interfaceC3801q6M4856o.mo4845c(list.get(i3))) {
                            z2 = false;
                            break;
                        }
                    }
                }
                if (!z2) {
                    return false;
                }
            } else if (i12 == 60 || i12 == 68) {
                if (m4860w(t, i8, i7) && !m4856o(i7).mo4845c(C3711j7.m4993r(t, iM4841I & 1048575))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) C3711j7.m4993r(t, iM4841I & 1048575);
                if (!list.isEmpty()) {
                    interfaceC3801q6M4856o = m4856o(i7);
                    while (i3 < list.size()) {
                        if (!interfaceC3801q6M4856o.mo4845c(list.get(i3))) {
                            z2 = false;
                            break;
                        }
                    }
                }
                if (!z2) {
                    return false;
                }
            } else if (i12 == 50 && !this.f9929q.mo5336e(C3711j7.m4993r(t, iM4841I & 1048575)).isEmpty()) {
                Objects.requireNonNull(this.f9929q.mo5338g(m4834A(i7)));
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: d */
    public final void mo4846d(T t) {
        int i;
        int i2 = this.f9923k;
        while (true) {
            i = this.f9924l;
            if (i2 >= i) {
                break;
            }
            long jM4841I = m4841I(this.f9922j[i2]) & 1048575;
            Object objM4993r = C3711j7.m4993r(t, jM4841I);
            if (objM4993r != null) {
                C3711j7.m4981f(t, jM4841I, this.f9929q.mo5334c(objM4993r));
            }
            i2++;
        }
        int length = this.f9922j.length;
        while (i < length) {
            this.f9926n.mo5071b(t, this.f9922j[i]);
            i++;
        }
        this.f9927o.mo4641h(t);
        if (this.f9920h) {
            this.f9928p.mo4975g(t);
        }
    }

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
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: e */
    public final int mo4847e(T t) {
        int i;
        int iM9076u;
        int iM5228L;
        int iM9052D;
        int iM9059L;
        int iM9076u2;
        int iM5228L2;
        int iM9052D2;
        int iM9059L2;
        if (this.f9921i) {
            Unsafe unsafe = f9914b;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f9915c.length; i3 += 3) {
                int iM4841I = m4841I(i3);
                int i4 = (iM4841I & 267386880) >>> 20;
                int i5 = this.f9915c[i3];
                long j = iM4841I & 1048575;
                if (i4 >= EnumC3773o4.f10142S.m5154a() && i4 <= EnumC3773o4.f10155f0.m5154a()) {
                    int i6 = this.f9915c[i3 + 2];
                }
                switch (i4) {
                    case 0:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9076u(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 1:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9072n(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 2:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9051B(i5, C3711j7.m4984i(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 3:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9053E(i5, C3711j7.m4984i(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 4:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9056I(i5, C3711j7.m4977b(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 5:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9061N(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 6:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9066S(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 7:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9077v(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 8:
                        if (m4859v(t, i3)) {
                            Object objM4993r = C3711j7.m4993r(t, j);
                            iM9076u2 = objM4993r instanceof AbstractC3837t3 ? zzhi.m9078w(i5, (AbstractC3837t3) objM4993r) : zzhi.m9073o(i5, (String) objM4993r);
                            i2 += iM9076u2;
                        }
                        break;
                    case 9:
                        if (m4859v(t, i3)) {
                            iM9076u2 = C3827s6.m5235a(i5, C3711j7.m4993r(t, j), m4856o(i3));
                            i2 += iM9076u2;
                        }
                        break;
                    case 10:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9078w(i5, (AbstractC3837t3) C3711j7.m4993r(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 11:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9060M(i5, C3711j7.m4977b(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 12:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9068U(i5, C3711j7.m4977b(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 13:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9067T(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 14:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9064Q(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 15:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9063P(i5, C3711j7.m4977b(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 16:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9057J(i5, C3711j7.m4984i(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 17:
                        if (m4859v(t, i3)) {
                            iM9076u2 = zzhi.m9079x(i5, (InterfaceC3612c6) C3711j7.m4993r(t, j), m4856o(i3));
                            i2 += iM9076u2;
                        }
                        break;
                    case 18:
                        iM9076u2 = C3827s6.m5227K(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 19:
                        iM9076u2 = C3827s6.m5224H(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 20:
                        iM9076u2 = C3827s6.m5245k(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 21:
                        iM9076u2 = C3827s6.m5252r(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 22:
                        iM9076u2 = C3827s6.m5259y(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 23:
                        iM9076u2 = C3827s6.m5227K(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 24:
                        iM9076u2 = C3827s6.m5224H(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 25:
                        List<?> listM4830q = m4830q(t, j);
                        Class<?> cls = C3827s6.f10313a;
                        int size = listM4830q.size();
                        iM9076u2 = size == 0 ? 0 : size * zzhi.m9077v(i5);
                        i2 += iM9076u2;
                        break;
                    case 26:
                        iM9076u2 = C3827s6.m5236b(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 27:
                        iM9076u2 = C3827s6.m5237c(i5, m4830q(t, j), m4856o(i3));
                        i2 += iM9076u2;
                        break;
                    case 28:
                        iM9076u2 = C3827s6.m5246l(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 29:
                        iM9076u2 = C3827s6.m5218B(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 30:
                        iM9076u2 = C3827s6.m5256v(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 31:
                        iM9076u2 = C3827s6.m5224H(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 32:
                        iM9076u2 = C3827s6.m5227K(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 33:
                        iM9076u2 = C3827s6.m5221E(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 34:
                        iM9076u2 = C3827s6.m5253s(i5, m4830q(t, j));
                        i2 += iM9076u2;
                        break;
                    case 35:
                        iM5228L2 = C3827s6.m5228L((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 36:
                        iM5228L2 = C3827s6.m5225I((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 37:
                        iM5228L2 = C3827s6.m5238d((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 38:
                        iM5228L2 = C3827s6.m5248n((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 39:
                        iM5228L2 = C3827s6.m5260z((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 40:
                        iM5228L2 = C3827s6.m5228L((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 41:
                        iM5228L2 = C3827s6.m5225I((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 42:
                        List list = (List) unsafe.getObject(t, j);
                        Class<?> cls2 = C3827s6.f10313a;
                        iM5228L2 = list.size();
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 43:
                        iM5228L2 = C3827s6.m5219C((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 44:
                        iM5228L2 = C3827s6.m5257w((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 45:
                        iM5228L2 = C3827s6.m5225I((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 46:
                        iM5228L2 = C3827s6.m5228L((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 47:
                        iM5228L2 = C3827s6.m5222F((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 48:
                        iM5228L2 = C3827s6.m5254t((List) unsafe.getObject(t, j));
                        if (iM5228L2 > 0) {
                            iM9052D2 = zzhi.m9052D(i5);
                            iM9059L2 = zzhi.m9059L(iM5228L2);
                            i2 = iM9059L2 + iM9052D2 + iM5228L2 + i2;
                        }
                        break;
                    case 49:
                        iM9076u2 = C3827s6.m5247m(i5, m4830q(t, j), m4856o(i3));
                        i2 += iM9076u2;
                        break;
                    case 50:
                        iM9076u2 = this.f9929q.mo5340i(i5, C3711j7.m4993r(t, j), m4834A(i3));
                        i2 += iM9076u2;
                        break;
                    case 51:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9076u(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 52:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9072n(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 53:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9051B(i5, m4825L(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 54:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9053E(i5, m4825L(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 55:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9056I(i5, m4824J(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 56:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9061N(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 57:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9066S(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 58:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9077v(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 59:
                        if (m4860w(t, i5, i3)) {
                            Object objM4993r2 = C3711j7.m4993r(t, j);
                            iM9076u2 = objM4993r2 instanceof AbstractC3837t3 ? zzhi.m9078w(i5, (AbstractC3837t3) objM4993r2) : zzhi.m9073o(i5, (String) objM4993r2);
                            i2 += iM9076u2;
                        }
                        break;
                    case 60:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = C3827s6.m5235a(i5, C3711j7.m4993r(t, j), m4856o(i3));
                            i2 += iM9076u2;
                        }
                        break;
                    case 61:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9078w(i5, (AbstractC3837t3) C3711j7.m4993r(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 62:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9060M(i5, m4824J(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 63:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9068U(i5, m4824J(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 64:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9067T(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 65:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9064Q(i5);
                            i2 += iM9076u2;
                        }
                        break;
                    case 66:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9063P(i5, m4824J(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 67:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9057J(i5, m4825L(t, j));
                            i2 += iM9076u2;
                        }
                        break;
                    case 68:
                        if (m4860w(t, i5, i3)) {
                            iM9076u2 = zzhi.m9079x(i5, (InterfaceC3612c6) C3711j7.m4993r(t, j), m4856o(i3));
                            i2 += iM9076u2;
                        }
                        break;
                }
            }
            AbstractC3627d7<?, ?> abstractC3627d7 = this.f9927o;
            return abstractC3627d7.mo4643j(abstractC3627d7.mo4638e(t)) + i2;
        }
        Unsafe unsafe2 = f9914b;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        for (int i10 = 0; i10 < this.f9915c.length; i10 += 3) {
            int iM4841I2 = m4841I(i10);
            int[] iArr = this.f9915c;
            int i11 = iArr[i10];
            int i12 = (iM4841I2 & 267386880) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr[i10 + 2];
                int i14 = i13 & 1048575;
                i = 1 << (i13 >>> 20);
                if (i14 != i8) {
                    i9 = unsafe2.getInt(t, i14);
                    i8 = i14;
                }
            } else {
                i = 0;
            }
            long j2 = iM4841I2 & 1048575;
            switch (i12) {
                case 0:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9076u(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 1:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9072n(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 2:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9051B(i11, unsafe2.getLong(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 3:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9053E(i11, unsafe2.getLong(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 4:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9056I(i11, unsafe2.getInt(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 5:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9061N(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 6:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9066S(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 7:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9077v(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 8:
                    if ((i9 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        iM9076u = object instanceof AbstractC3837t3 ? zzhi.m9078w(i11, (AbstractC3837t3) object) : zzhi.m9073o(i11, (String) object);
                        i7 += iM9076u;
                    }
                    break;
                case 9:
                    if ((i9 & i) != 0) {
                        iM9076u = C3827s6.m5235a(i11, unsafe2.getObject(t, j2), m4856o(i10));
                        i7 += iM9076u;
                    }
                    break;
                case 10:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9078w(i11, (AbstractC3837t3) unsafe2.getObject(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 11:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9060M(i11, unsafe2.getInt(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 12:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9068U(i11, unsafe2.getInt(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 13:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9067T(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 14:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9064Q(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 15:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9063P(i11, unsafe2.getInt(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 16:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9057J(i11, unsafe2.getLong(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 17:
                    if ((i9 & i) != 0) {
                        iM9076u = zzhi.m9079x(i11, (InterfaceC3612c6) unsafe2.getObject(t, j2), m4856o(i10));
                        i7 += iM9076u;
                    }
                    break;
                case 18:
                    iM9076u = C3827s6.m5227K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 19:
                    iM9076u = C3827s6.m5224H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 20:
                    iM9076u = C3827s6.m5245k(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 21:
                    iM9076u = C3827s6.m5252r(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 22:
                    iM9076u = C3827s6.m5259y(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 23:
                    iM9076u = C3827s6.m5227K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 24:
                    iM9076u = C3827s6.m5224H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 25:
                    List list2 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls3 = C3827s6.f10313a;
                    int size2 = list2.size();
                    iM9076u = size2 == 0 ? 0 : size2 * zzhi.m9077v(i11);
                    i7 += iM9076u;
                    break;
                case 26:
                    iM9076u = C3827s6.m5236b(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 27:
                    iM9076u = C3827s6.m5237c(i11, (List) unsafe2.getObject(t, j2), m4856o(i10));
                    i7 += iM9076u;
                    break;
                case 28:
                    iM9076u = C3827s6.m5246l(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 29:
                    iM9076u = C3827s6.m5218B(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 30:
                    iM9076u = C3827s6.m5256v(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 31:
                    iM9076u = C3827s6.m5224H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 32:
                    iM9076u = C3827s6.m5227K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 33:
                    iM9076u = C3827s6.m5221E(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 34:
                    iM9076u = C3827s6.m5253s(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iM9076u;
                    break;
                case 35:
                    iM5228L = C3827s6.m5228L((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 36:
                    iM5228L = C3827s6.m5225I((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 37:
                    iM5228L = C3827s6.m5238d((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 38:
                    iM5228L = C3827s6.m5248n((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 39:
                    iM5228L = C3827s6.m5260z((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 40:
                    iM5228L = C3827s6.m5228L((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 41:
                    iM5228L = C3827s6.m5225I((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 42:
                    List list3 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls4 = C3827s6.f10313a;
                    iM5228L = list3.size();
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 43:
                    iM5228L = C3827s6.m5219C((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 44:
                    iM5228L = C3827s6.m5257w((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 45:
                    iM5228L = C3827s6.m5225I((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 46:
                    iM5228L = C3827s6.m5228L((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 47:
                    iM5228L = C3827s6.m5222F((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 48:
                    iM5228L = C3827s6.m5254t((List) unsafe2.getObject(t, j2));
                    if (iM5228L > 0) {
                        iM9052D = zzhi.m9052D(i11);
                        iM9059L = zzhi.m9059L(iM5228L);
                        i7 = iM9059L + iM9052D + iM5228L + i7;
                    }
                    break;
                case 49:
                    iM9076u = C3827s6.m5247m(i11, (List) unsafe2.getObject(t, j2), m4856o(i10));
                    i7 += iM9076u;
                    break;
                case 50:
                    iM9076u = this.f9929q.mo5340i(i11, unsafe2.getObject(t, j2), m4834A(i10));
                    i7 += iM9076u;
                    break;
                case 51:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9076u(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 52:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9072n(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 53:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9051B(i11, m4825L(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 54:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9053E(i11, m4825L(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 55:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9056I(i11, m4824J(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 56:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9061N(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 57:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9066S(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 58:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9077v(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 59:
                    if (m4860w(t, i11, i10)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        iM9076u = object2 instanceof AbstractC3837t3 ? zzhi.m9078w(i11, (AbstractC3837t3) object2) : zzhi.m9073o(i11, (String) object2);
                        i7 += iM9076u;
                    }
                    break;
                case 60:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = C3827s6.m5235a(i11, unsafe2.getObject(t, j2), m4856o(i10));
                        i7 += iM9076u;
                    }
                    break;
                case 61:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9078w(i11, (AbstractC3837t3) unsafe2.getObject(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 62:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9060M(i11, m4824J(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 63:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9068U(i11, m4824J(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 64:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9067T(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 65:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9064Q(i11);
                        i7 += iM9076u;
                    }
                    break;
                case 66:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9063P(i11, m4824J(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 67:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9057J(i11, m4825L(t, j2));
                        i7 += iM9076u;
                    }
                    break;
                case 68:
                    if (m4860w(t, i11, i10)) {
                        iM9076u = zzhi.m9079x(i11, (InterfaceC3612c6) unsafe2.getObject(t, j2), m4856o(i10));
                        i7 += iM9076u;
                    }
                    break;
            }
        }
        AbstractC3627d7<?, ?> abstractC3627d8 = this.f9927o;
        int iMo4643j = abstractC3627d8.mo4643j(abstractC3627d8.mo4638e(t)) + i7;
        if (!this.f9920h) {
            return iMo4643j;
        }
        C3760n4<T> c3760n4Mo4970b = this.f9928p.mo4970b(t);
        int iM5124a = 0;
        for (int i15 = 0; i15 < c3760n4Mo4970b.f10111b.m5207e(); i15++) {
            Map.Entry entryM5206d = c3760n4Mo4970b.f10111b.m5206d(i15);
            iM5124a += C3760n4.m5124a((InterfaceC3786p4) entryM5206d.getKey(), entryM5206d.getValue());
        }
        for (Map.Entry entry : c3760n4Mo4970b.f10111b.m5209g()) {
            iM5124a += C3760n4.m5124a((InterfaceC3786p4) entry.getKey(), entry.getValue());
        }
        return iMo4643j + iM5124a;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: f */
    public final boolean mo4848f(T t, T t2) {
        int length = this.f9915c.length;
        int i = 0;
        while (true) {
            boolean zM5244j = true;
            if (i >= length) {
                if (!this.f9927o.mo4638e(t).equals(this.f9927o.mo4638e(t2))) {
                    return false;
                }
                if (this.f9920h) {
                    return this.f9928p.mo4970b(t).equals(this.f9928p.mo4970b(t2));
                }
                return true;
            }
            int iM4841I = m4841I(i);
            long j = iM4841I & 1048575;
            switch ((iM4841I & 267386880) >>> 20) {
                case 0:
                    if (!m4840H(t, t2, i) || Double.doubleToLongBits(C3711j7.m4992q(t, j)) != Double.doubleToLongBits(C3711j7.m4992q(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 1:
                    if (!m4840H(t, t2, i) || Float.floatToIntBits(C3711j7.m4989n(t, j)) != Float.floatToIntBits(C3711j7.m4989n(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 2:
                    if (!m4840H(t, t2, i) || C3711j7.m4984i(t, j) != C3711j7.m4984i(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 3:
                    if (!m4840H(t, t2, i) || C3711j7.m4984i(t, j) != C3711j7.m4984i(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 4:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 5:
                    if (!m4840H(t, t2, i) || C3711j7.m4984i(t, j) != C3711j7.m4984i(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 6:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 7:
                    if (!m4840H(t, t2, i) || C3711j7.m4988m(t, j) != C3711j7.m4988m(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 8:
                    if (!m4840H(t, t2, i) || !C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 9:
                    if (!m4840H(t, t2, i) || !C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 10:
                    if (!m4840H(t, t2, i) || !C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 11:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 12:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 13:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 14:
                    if (!m4840H(t, t2, i) || C3711j7.m4984i(t, j) != C3711j7.m4984i(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 15:
                    if (!m4840H(t, t2, i) || C3711j7.m4977b(t, j) != C3711j7.m4977b(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 16:
                    if (!m4840H(t, t2, i) || C3711j7.m4984i(t, j) != C3711j7.m4984i(t2, j)) {
                        zM5244j = false;
                    }
                    break;
                case 17:
                    if (!m4840H(t, t2, i) || !C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j))) {
                        zM5244j = false;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    zM5244j = C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j));
                    break;
                case 50:
                    zM5244j = C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
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
                    long jM4842K = m4842K(i) & 1048575;
                    if (C3711j7.m4977b(t, jM4842K) != C3711j7.m4977b(t2, jM4842K) || !C3827s6.m5244j(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j))) {
                        zM5244j = false;
                    }
                    break;
            }
            if (!zM5244j) {
                return false;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: g */
    public final void mo4849g(T t, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        Iterator itM5135l;
        Map.Entry<?, ?> entry;
        Objects.requireNonNull(interfaceC3867v7);
        if (!this.f9921i) {
            m4837D(t, interfaceC3867v7);
            return;
        }
        if (this.f9920h) {
            C3760n4<T> c3760n4Mo4970b = this.f9928p.mo4970b(t);
            if (c3760n4Mo4970b.f10111b.isEmpty()) {
                itM5135l = null;
                entry = null;
            } else {
                itM5135l = c3760n4Mo4970b.m5135l();
                entry = (Map.Entry) itM5135l.next();
            }
        } else {
            itM5135l = null;
            entry = null;
        }
        int length = this.f9915c.length;
        for (int i = 0; i < length; i += 3) {
            int iM4841I = m4841I(i);
            int i2 = this.f9915c[i];
            while (entry != null && this.f9928p.mo4969a(entry) <= i2) {
                this.f9928p.mo4972d(interfaceC3867v7, entry);
                entry = itM5135l.hasNext() ? (Map.Entry) itM5135l.next() : null;
            }
            switch ((267386880 & iM4841I) >>> 20) {
                case 0:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4909a(i2, C3711j7.m4992q(t, iM4841I & 1048575));
                    }
                    break;
                case 1:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4910b(i2, C3711j7.m4989n(t, iM4841I & 1048575));
                    }
                    break;
                case 2:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i2, C3711j7.m4984i(t, iM4841I & 1048575));
                    }
                    break;
                case 3:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i2, C3711j7.m4984i(t, iM4841I & 1048575));
                    }
                    break;
                case 4:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 5:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i2, C3711j7.m4984i(t, iM4841I & 1048575));
                    }
                    break;
                case 6:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 7:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9092l(i2, C3711j7.m4988m(t, iM4841I & 1048575));
                    }
                    break;
                case 8:
                    if (m4859v(t, i)) {
                        m4831r(i2, C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7);
                    }
                    break;
                case 9:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4912d(i2, C3711j7.m4993r(t, iM4841I & 1048575), m4856o(i));
                    }
                    break;
                case 10:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i2, (AbstractC3837t3) C3711j7.m4993r(t, iM4841I & 1048575));
                    }
                    break;
                case 11:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9097y(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 12:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 13:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 14:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i2, C3711j7.m4984i(t, iM4841I & 1048575));
                    }
                    break;
                case 15:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4915g(i2, C3711j7.m4977b(t, iM4841I & 1048575));
                    }
                    break;
                case 16:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4914f(i2, C3711j7.m4984i(t, iM4841I & 1048575));
                    }
                    break;
                case 17:
                    if (m4859v(t, i)) {
                        ((C3666g4) interfaceC3867v7).m4913e(i2, C3711j7.m4993r(t, iM4841I & 1048575), m4856o(i));
                    }
                    break;
                case 18:
                    C3827s6.m5242h(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 19:
                    C3827s6.m5251q(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 20:
                    C3827s6.m5255u(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 21:
                    C3827s6.m5258x(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 22:
                    C3827s6.m5226J(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 23:
                    C3827s6.m5220D(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 24:
                    C3827s6.m5231O(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 25:
                    C3827s6.m5234R(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 26:
                    C3827s6.m5240f(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7);
                    break;
                case 27:
                    C3827s6.m5241g(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, m4856o(i));
                    break;
                case 28:
                    C3827s6.m5249o(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7);
                    break;
                case 29:
                    C3827s6.m5229M(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 30:
                    C3827s6.m5233Q(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 31:
                    C3827s6.m5232P(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 32:
                    C3827s6.m5223G(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 33:
                    C3827s6.m5230N(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 34:
                    C3827s6.m5217A(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, false);
                    break;
                case 35:
                    C3827s6.m5242h(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 36:
                    C3827s6.m5251q(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 37:
                    C3827s6.m5255u(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 38:
                    C3827s6.m5258x(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 39:
                    C3827s6.m5226J(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 40:
                    C3827s6.m5220D(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 41:
                    C3827s6.m5231O(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 42:
                    C3827s6.m5234R(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 43:
                    C3827s6.m5229M(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 44:
                    C3827s6.m5233Q(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 45:
                    C3827s6.m5232P(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 46:
                    C3827s6.m5223G(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 47:
                    C3827s6.m5230N(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 48:
                    C3827s6.m5217A(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, true);
                    break;
                case 49:
                    C3827s6.m5250p(this.f9915c[i], (List) C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7, m4856o(i));
                    break;
                case 50:
                    m4857t(interfaceC3867v7, i2, C3711j7.m4993r(t, iM4841I & 1048575), i);
                    break;
                case 51:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4909a(i2, m4833y(t, iM4841I & 1048575));
                    }
                    break;
                case 52:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4910b(i2, m4823F(t, iM4841I & 1048575));
                    }
                    break;
                case 53:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i2, m4825L(t, iM4841I & 1048575));
                    }
                    break;
                case 54:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i2, m4825L(t, iM4841I & 1048575));
                    }
                    break;
                case 55:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 56:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i2, m4825L(t, iM4841I & 1048575));
                    }
                    break;
                case 57:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 58:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9092l(i2, m4827N(t, iM4841I & 1048575));
                    }
                    break;
                case 59:
                    if (m4860w(t, i2, i)) {
                        m4831r(i2, C3711j7.m4993r(t, iM4841I & 1048575), interfaceC3867v7);
                    }
                    break;
                case 60:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4912d(i2, C3711j7.m4993r(t, iM4841I & 1048575), m4856o(i));
                    }
                    break;
                case 61:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i2, (AbstractC3837t3) C3711j7.m4993r(t, iM4841I & 1048575));
                    }
                    break;
                case 62:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9097y(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 63:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9095s(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 64:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 65:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i2, m4825L(t, iM4841I & 1048575));
                    }
                    break;
                case 66:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4915g(i2, m4824J(t, iM4841I & 1048575));
                    }
                    break;
                case 67:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4914f(i2, m4825L(t, iM4841I & 1048575));
                    }
                    break;
                case 68:
                    if (m4860w(t, i2, i)) {
                        ((C3666g4) interfaceC3867v7).m4913e(i2, C3711j7.m4993r(t, iM4841I & 1048575), m4856o(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.f9928p.mo4972d(interfaceC3867v7, entry);
            entry = itM5135l.hasNext() ? (Map.Entry) itM5135l.next() : null;
        }
        m4832s(this.f9927o, t, interfaceC3867v7);
    }

    /* JADX WARN: Code duplicated, block: B:131:0x03a1 A[PHI: r0 r19 r24 r27
      0x03a1: PHI (r0v21 int) = (r0v17 int), (r0v23 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r19v2 int) = (r19v1 int), (r19v3 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r24v3 int) = (r24v2 int), (r24v4 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r27v7 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x009b. Please report as an issue. */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: h */
    public final void mo4850h(T t, byte[] bArr, int i, int i2, C3824s3 c3824s3) throws IOException {
        int i3;
        int iM4218J1;
        int iM4862z;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        C3640e6<T> c3640e6;
        int i7;
        int i8;
        int i9;
        C3824s3 c3824s4;
        C3640e6<T> c3640e7;
        int i10;
        int i11;
        int i12;
        int i13;
        T t2;
        int i14;
        T t3;
        C3824s3 c3824s5;
        C3640e6<T> c3640e8;
        int i15;
        T t4;
        C3824s3 c3824s6;
        C3824s3 c3824s7;
        T t5;
        C3824s3 c3824s8;
        T t6;
        i2 = i2;
        if (!this.f9921i) {
            m4855m(t, bArr, i, i2, 0, c3824s3);
            return;
        }
        Unsafe unsafe2 = f9914b;
        int i16 = -1;
        int i17 = 0;
        T t7 = t;
        byte[] bArr2 = bArr;
        int iM4215I1 = i;
        C3824s3 c3824s9 = c3824s3;
        C3640e6<T> c3640e9 = this;
        int i18 = -1;
        int i19 = 0;
        int i20 = 1048575;
        int i21 = 0;
        while (iM4215I1 < i2) {
            int i22 = iM4215I1 + 1;
            byte b2 = bArr2[iM4215I1];
            if (b2 < 0) {
                iM4218J1 = C3404f.m4218J1(b2, bArr2, i22, c3824s9);
                i3 = c3824s9.f10307a;
            } else {
                i3 = b2;
                iM4218J1 = i22;
            }
            int i23 = i3 >>> 3;
            int i24 = i3 & 7;
            if (i23 > i18) {
                int i25 = i19 / 3;
                if (i23 < c3640e9.f9917e || i23 > c3640e9.f9918f) {
                    i4 = -1;
                } else {
                    iM4862z = c3640e9.m4862z(i23, i25);
                    i4 = iM4862z;
                }
            } else if (i23 < c3640e9.f9917e || i23 > c3640e9.f9918f) {
                i4 = -1;
            } else {
                iM4862z = c3640e9.m4862z(i23, i17);
                i4 = iM4862z;
            }
            if (i4 == i16) {
                i5 = i23;
                i6 = 0;
            } else {
                int[] iArr = c3640e9.f9915c;
                int i26 = iArr[i4 + 1];
                int i27 = (i26 & 267386880) >>> 20;
                long j = i26 & 1048575;
                C3640e6<T> c3640e10 = c3640e9;
                if (i27 <= 17) {
                    int i28 = iArr[i4 + 2];
                    int i29 = 1 << (i28 >>> 20);
                    int i30 = i28 & 1048575;
                    if (i30 != i20) {
                        if (i20 != 1048575) {
                            unsafe2.putInt(t7, i20, i21);
                        }
                        if (i30 != 1048575) {
                            i21 = unsafe2.getInt(t7, i30);
                        }
                        i20 = i30;
                    }
                    switch (i27) {
                        case 0:
                            i5 = i23;
                            i14 = i4;
                            T t8 = t7;
                            C3824s3 c3824s10 = c3824s9;
                            bArr2 = bArr2;
                            c3640e6 = c3640e10;
                            if (i24 != 1) {
                                i6 = i14;
                            } else {
                                C3711j7.m4979d(t8, j, Double.longBitsToDouble(C3404f.m4326o2(bArr2, iM4218J1)));
                                iM4215I1 = iM4218J1 + 8;
                                i7 = i21 | i29;
                                t7 = t8;
                                c3824s9 = c3824s10;
                                unsafe = unsafe2;
                                i19 = i14;
                            }
                            i21 = i7;
                            c3640e9 = c3640e6;
                            i2 = i2;
                            i18 = i5;
                            unsafe2 = unsafe;
                            i17 = 0;
                            i16 = -1;
                            break;
                        case 1:
                            i5 = i23;
                            i14 = i4;
                            t3 = t7;
                            c3824s5 = c3824s9;
                            bArr2 = bArr2;
                            c3640e8 = c3640e10;
                            if (i24 == 5) {
                                C3711j7.f10036e.mo5000d(t3, j, Float.intBitsToFloat(C3404f.m4230N1(bArr2, iM4218J1)));
                                iM4215I1 = iM4218J1 + 4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 2:
                        case 3:
                            i5 = i23;
                            i14 = i4;
                            c3824s5 = c3824s9;
                            bArr2 = bArr2;
                            T t9 = t7;
                            c3640e8 = c3640e10;
                            if (i24 == 0) {
                                iM4215I1 = C3404f.m4322n2(bArr2, iM4218J1, c3824s5);
                                unsafe2.putLong(t, j, c3824s5.f10308b);
                                i15 = i21 | i29;
                                t3 = t9;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 4:
                        case 11:
                            i5 = i23;
                            i14 = i4;
                            c3824s5 = c3824s9;
                            bArr2 = bArr2;
                            t4 = t7;
                            c3640e8 = c3640e10;
                            if (i24 == 0) {
                                iM4215I1 = C3404f.m4233O1(bArr2, iM4218J1, c3824s5);
                                unsafe2.putInt(t4, j, c3824s5.f10307a);
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 5:
                        case 14:
                            i5 = i23;
                            i14 = i4;
                            C3824s3 c3824s11 = c3824s9;
                            bArr2 = bArr2;
                            T t10 = t7;
                            if (i24 == 1) {
                                c3640e8 = c3640e10;
                                c3824s5 = c3824s11;
                                unsafe2.putLong(t, j, C3404f.m4326o2(bArr2, iM4218J1));
                                iM4215I1 = iM4218J1 + 8;
                                t3 = t10;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 6:
                        case 13:
                            i5 = i23;
                            i14 = i4;
                            c3824s7 = c3824s9;
                            bArr2 = bArr2;
                            t5 = t7;
                            if (i24 != 5) {
                                i6 = i14;
                            } else {
                                unsafe2.putInt(t5, j, C3404f.m4230N1(bArr2, iM4218J1));
                                iM4215I1 = iM4218J1 + 4;
                                i21 |= i29;
                                t7 = t5;
                                c3824s9 = c3824s7;
                                i19 = i14;
                                c3640e9 = c3640e10;
                                i18 = i5;
                                i17 = 0;
                                i16 = -1;
                            }
                            break;
                        case 7:
                            i5 = i23;
                            i14 = i4;
                            c3824s7 = c3824s9;
                            bArr2 = bArr2;
                            t5 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iM4215I1 = C3404f.m4322n2(bArr2, iM4218J1, c3824s7);
                                C3711j7.f10036e.mo5001g(t5, j, c3824s7.f10308b != 0);
                                i21 |= i29;
                                t7 = t5;
                                c3824s9 = c3824s7;
                                i19 = i14;
                                c3640e9 = c3640e10;
                                i18 = i5;
                                i17 = 0;
                                i16 = -1;
                            }
                            break;
                        case 8:
                            i5 = i23;
                            i14 = i4;
                            c3824s6 = c3824s9;
                            bArr2 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                iM4215I1 = (536870912 & i26) == 0 ? C3404f.m4338r2(bArr2, iM4218J1, c3824s6) : C3404f.m4346t2(bArr2, iM4218J1, c3824s6);
                                unsafe2.putObject(t4, j, c3824s6.f10309c);
                                c3824s5 = c3824s6;
                                c3640e8 = c3640e10;
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 9:
                            i5 = i23;
                            i14 = i4;
                            c3824s6 = c3824s9;
                            bArr2 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                iM4215I1 = C3404f.m4227M1(c3640e10.m4856o(i14), bArr2, iM4218J1, i2, c3824s6);
                                Object object = unsafe2.getObject(t4, j);
                                if (object == null) {
                                    c3640e10 = c3640e10;
                                    unsafe2.putObject(t4, j, c3824s6.f10309c);
                                } else {
                                    c3640e10 = c3640e10;
                                    unsafe2.putObject(t4, j, C3877w4.m5346c(object, c3824s6.f10309c));
                                }
                                c3824s5 = c3824s6;
                                c3640e8 = c3640e10;
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                c3824s9 = c3824s5;
                                unsafe = unsafe2;
                                i19 = i14;
                                c3640e9 = c3640e8;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            }
                            i6 = i14;
                            break;
                        case 10:
                            i5 = i23;
                            i14 = i4;
                            c3824s8 = c3824s9;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 2) {
                                i6 = i14;
                            } else {
                                iM4215I1 = C3404f.m4354v2(bArr2, iM4218J1, c3824s8);
                                unsafe2.putObject(t6, j, c3824s8.f10309c);
                                i21 |= i29;
                                c3640e7 = c3640e10;
                                t2 = t6;
                                c3824s4 = c3824s8;
                                i13 = i14;
                            }
                            break;
                        case 12:
                            i5 = i23;
                            i14 = i4;
                            c3824s8 = c3824s9;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iM4215I1 = C3404f.m4233O1(bArr2, iM4218J1, c3824s8);
                                unsafe2.putInt(t6, j, c3824s8.f10307a);
                                i21 |= i29;
                                c3640e7 = c3640e10;
                                t2 = t6;
                                c3824s4 = c3824s8;
                                i13 = i14;
                            }
                            break;
                        case 15:
                            i5 = i23;
                            i14 = i4;
                            c3824s8 = c3824s9;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iM4215I1 = C3404f.m4233O1(bArr2, iM4218J1, c3824s8);
                                unsafe2.putInt(t6, j, C3624d4.m4631b(c3824s8.f10307a));
                                i21 |= i29;
                                c3640e7 = c3640e10;
                                t2 = t6;
                                c3824s4 = c3824s8;
                                i13 = i14;
                            }
                            break;
                        case 16:
                            if (i24 != 0) {
                                i5 = i23;
                                i14 = i4;
                                i6 = i14;
                            } else {
                                bArr2 = bArr2;
                                int iM4322n2 = C3404f.m4322n2(bArr2, iM4218J1, c3824s9);
                                i14 = i4;
                                i5 = i23;
                                C3824s3 c3824s12 = c3824s9;
                                unsafe2.putLong(t, j, C3624d4.m4630a(c3824s9.f10308b));
                                i21 |= i29;
                                iM4215I1 = iM4322n2;
                                t6 = t7;
                                c3824s8 = c3824s12;
                                c3640e10 = c3640e10;
                                c3640e7 = c3640e10;
                                t2 = t6;
                                c3824s4 = c3824s8;
                                i13 = i14;
                            }
                            break;
                        default:
                            i5 = i23;
                            i14 = i4;
                            i6 = i14;
                            break;
                    }
                } else {
                    i5 = i23;
                    T t11 = t7;
                    c3824s4 = c3824s9;
                    c3640e7 = c3640e10;
                    int i31 = i4;
                    if (i27 != 27) {
                        int i32 = iM4218J1;
                        i8 = i31;
                        if (i27 <= 49) {
                            i10 = i20;
                            i11 = i21;
                            unsafe = unsafe2;
                            iM4215I1 = m4853k(t, bArr, i32, i2, i3, i5, i24, i8, i26, i27, j, c3824s3);
                            if (iM4215I1 == i32) {
                                i9 = iM4215I1;
                                i21 = i11;
                                i20 = i10;
                                iM4215I1 = C3404f.m4215I1(i3, bArr, i9, i2, m4826M(t), c3824s3);
                                i19 = i8;
                            } else {
                                i19 = i8;
                                i21 = i11;
                                i20 = i10;
                            }
                            c3640e6 = this;
                            t7 = t;
                            bArr2 = bArr;
                            c3824s9 = c3824s3;
                            i7 = i21;
                            i21 = i7;
                            c3640e9 = c3640e6;
                            i2 = i2;
                            i18 = i5;
                            unsafe2 = unsafe;
                            i17 = 0;
                            i16 = -1;
                        } else {
                            i10 = i20;
                            i11 = i21;
                            unsafe = unsafe2;
                            i12 = i32;
                            if (i27 != 50) {
                                iM4215I1 = m4852j(t, bArr, i12, i2, i3, i5, i24, i26, i27, j, i8, c3824s3);
                                if (iM4215I1 != i12) {
                                    i19 = i8;
                                    i21 = i11;
                                    i20 = i10;
                                }
                                c3640e6 = this;
                                t7 = t;
                                bArr2 = bArr;
                                c3824s9 = c3824s3;
                                i7 = i21;
                                i21 = i7;
                                c3640e9 = c3640e6;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            } else if (i24 == 2) {
                                m4854l(t, bArr, i12, i2, i8, j, c3824s3);
                                throw null;
                            }
                            i9 = iM4215I1;
                            i21 = i11;
                            i20 = i10;
                            iM4215I1 = C3404f.m4215I1(i3, bArr, i9, i2, m4826M(t), c3824s3);
                            i19 = i8;
                            c3640e6 = this;
                            t7 = t;
                            bArr2 = bArr;
                            c3824s9 = c3824s3;
                            i7 = i21;
                            i21 = i7;
                            c3640e9 = c3640e6;
                            i2 = i2;
                            i18 = i5;
                            unsafe2 = unsafe;
                            i17 = 0;
                            i16 = -1;
                        }
                    } else if (i24 == 2) {
                        InterfaceC3597b5 interfaceC3597b5Mo4569f = (InterfaceC3597b5) unsafe2.getObject(t11, j);
                        if (!interfaceC3597b5Mo4569f.mo4568a()) {
                            int size = interfaceC3597b5Mo4569f.size();
                            interfaceC3597b5Mo4569f = interfaceC3597b5Mo4569f.mo4569f(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t11, j, interfaceC3597b5Mo4569f);
                        }
                        i13 = i31;
                        t2 = t11;
                        iM4215I1 = C3404f.m4221K1(c3640e7.m4856o(i31), i3, bArr, iM4218J1, i2, interfaceC3597b5Mo4569f, c3824s3);
                    } else {
                        i8 = i31;
                        i12 = iM4218J1;
                        i10 = i20;
                        i11 = i21;
                        unsafe = unsafe2;
                    }
                    iM4215I1 = i12;
                    i9 = iM4215I1;
                    i21 = i11;
                    i20 = i10;
                    iM4215I1 = C3404f.m4215I1(i3, bArr, i9, i2, m4826M(t), c3824s3);
                    i19 = i8;
                    c3640e6 = this;
                    t7 = t;
                    bArr2 = bArr;
                    c3824s9 = c3824s3;
                    i7 = i21;
                    i21 = i7;
                    c3640e9 = c3640e6;
                    i2 = i2;
                    i18 = i5;
                    unsafe2 = unsafe;
                    i17 = 0;
                    i16 = -1;
                }
                t7 = t2;
                c3640e9 = c3640e7;
                c3824s9 = c3824s4;
                i19 = i13;
                i18 = i5;
                i17 = 0;
                i16 = -1;
            }
            i8 = i6;
            unsafe = unsafe2;
            i9 = iM4218J1;
            iM4215I1 = C3404f.m4215I1(i3, bArr, i9, i2, m4826M(t), c3824s3);
            i19 = i8;
            c3640e6 = this;
            t7 = t;
            bArr2 = bArr;
            c3824s9 = c3824s3;
            i7 = i21;
            i21 = i7;
            c3640e9 = c3640e6;
            i2 = i2;
            i18 = i5;
            unsafe2 = unsafe;
            i17 = 0;
            i16 = -1;
        }
        int i33 = i21;
        Unsafe unsafe3 = unsafe2;
        if (i20 != 1048575) {
            unsafe3.putInt(t, i20, i33);
        }
        if (iM4215I1 != i2) {
            throw zzij.m9106d();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3801q6
    /* JADX INFO: renamed from: i */
    public final void mo4851i(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.f9915c.length; i += 3) {
            int iM4841I = m4841I(i);
            long j = 1048575 & iM4841I;
            int i2 = this.f9915c[i];
            switch ((iM4841I & 267386880) >>> 20) {
                case 0:
                    if (m4859v(t2, i)) {
                        C3711j7.m4979d(t, j, C3711j7.m4992q(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 1:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.mo5000d(t, j, C3711j7.m4989n(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 2:
                    if (m4859v(t2, i)) {
                        C3711j7.m4980e(t, j, C3711j7.m4984i(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 3:
                    if (m4859v(t2, i)) {
                        C3711j7.m4980e(t, j, C3711j7.m4984i(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 4:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 5:
                    if (m4859v(t2, i)) {
                        C3711j7.m4980e(t, j, C3711j7.m4984i(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 6:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 7:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.mo5001g(t, j, C3711j7.m4988m(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 8:
                    if (m4859v(t2, i)) {
                        C3711j7.m4981f(t, j, C3711j7.m4993r(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 9:
                    m4858u(t, t2, i);
                    break;
                case 10:
                    if (m4859v(t2, i)) {
                        C3711j7.m4981f(t, j, C3711j7.m4993r(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 11:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 12:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 13:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 14:
                    if (m4859v(t2, i)) {
                        C3711j7.m4980e(t, j, C3711j7.m4984i(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 15:
                    if (m4859v(t2, i)) {
                        C3711j7.f10036e.m5005e(t, j, C3711j7.m4977b(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 16:
                    if (m4859v(t2, i)) {
                        C3711j7.m4980e(t, j, C3711j7.m4984i(t2, j));
                        m4835B(t, i);
                    }
                    break;
                case 17:
                    m4858u(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
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
                    this.f9926n.mo5070a(t, t2, j);
                    break;
                case 50:
                    InterfaceC3865v5 interfaceC3865v5 = this.f9929q;
                    Class<?> cls = C3827s6.f10313a;
                    C3711j7.m4981f(t, j, interfaceC3865v5.mo5337f(C3711j7.m4993r(t, j), C3711j7.m4993r(t2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (m4860w(t2, i2, i)) {
                        C3711j7.m4981f(t, j, C3711j7.m4993r(t2, j));
                        m4836C(t, i2, i);
                    }
                    break;
                case 60:
                    m4838E(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (m4860w(t2, i2, i)) {
                        C3711j7.m4981f(t, j, C3711j7.m4993r(t2, j));
                        m4836C(t, i2, i);
                    }
                    break;
                case 68:
                    m4838E(t, t2, i);
                    break;
            }
        }
        AbstractC3627d7<?, ?> abstractC3627d7 = this.f9927o;
        Class<?> cls2 = C3827s6.f10313a;
        abstractC3627d7.mo4637d(t, abstractC3627d7.mo4640g(abstractC3627d7.mo4638e(t), abstractC3627d7.mo4638e(t2)));
        if (this.f9920h) {
            C3827s6.m5243i(this.f9928p, t, t2);
        }
    }

    /* JADX INFO: renamed from: j */
    public final int m4852j(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C3824s3 c3824s3) throws IOException {
        int iM4322n2;
        Unsafe unsafe = f9914b;
        long j2 = this.f9915c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(C3404f.m4326o2(bArr, i))));
                iM4322n2 = i + 8;
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(C3404f.m4230N1(bArr, i))));
                iM4322n2 = i + 4;
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iM4322n2 = C3404f.m4322n2(bArr, i, c3824s3);
                unsafe.putObject(t, j, Long.valueOf(c3824s3.f10308b));
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iM4322n2 = C3404f.m4233O1(bArr, i, c3824s3);
                unsafe.putObject(t, j, Integer.valueOf(c3824s3.f10307a));
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(C3404f.m4326o2(bArr, i)));
                iM4322n2 = i + 8;
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(C3404f.m4230N1(bArr, i)));
                iM4322n2 = i + 4;
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iM4322n2 = C3404f.m4322n2(bArr, i, c3824s3);
                unsafe.putObject(t, j, Boolean.valueOf(c3824s3.f10308b != 0));
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iM4233O1 = C3404f.m4233O1(bArr, i, c3824s3);
                int i9 = c3824s3.f10307a;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !C3724k7.m5022b(bArr, iM4233O1, iM4233O1 + i9)) {
                        throw zzij.m9107e();
                    }
                    unsafe.putObject(t, j, new String(bArr, iM4233O1, i9, C3877w4.f10379a));
                    iM4233O1 += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iM4233O1;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iM4227M1 = C3404f.m4227M1(m4856o(i8), bArr, i, i2, c3824s3);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, c3824s3.f10309c);
                } else {
                    unsafe.putObject(t, j, C3877w4.m5346c(object, c3824s3.f10309c));
                }
                unsafe.putInt(t, j2, i4);
                return iM4227M1;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iM4322n2 = C3404f.m4354v2(bArr, i, c3824s3);
                unsafe.putObject(t, j, c3824s3.f10309c);
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iM4233O2 = C3404f.m4233O1(bArr, i, c3824s3);
                int i10 = c3824s3.f10307a;
                InterfaceC3583a5 interfaceC3583a5 = (InterfaceC3583a5) this.f9916d[((i8 / 3) << 1) + 1];
                if (interfaceC3583a5 != null && !interfaceC3583a5.mo4556f(i10)) {
                    m4826M(t).m4611a(i3, Long.valueOf(i10));
                    return iM4233O2;
                }
                unsafe.putObject(t, j, Integer.valueOf(i10));
                iM4322n2 = iM4233O2;
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iM4322n2 = C3404f.m4233O1(bArr, i, c3824s3);
                unsafe.putObject(t, j, Integer.valueOf(C3624d4.m4631b(c3824s3.f10307a)));
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iM4322n2 = C3404f.m4322n2(bArr, i, c3824s3);
                unsafe.putObject(t, j, Long.valueOf(C3624d4.m4630a(c3824s3.f10308b)));
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iM4322n2 = C3404f.m4224L1(m4856o(i8), bArr, i, i2, (i3 & (-8)) | 4, c3824s3);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, c3824s3.f10309c);
                } else {
                    unsafe.putObject(t, j, C3877w4.m5346c(object2, c3824s3.f10309c));
                }
                unsafe.putInt(t, j2, i4);
                return iM4322n2;
            default:
                return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: k */
    public final int m4853k(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C3824s3 c3824s3) throws IOException {
        int iM4212H1;
        int iM4233O1 = i;
        Unsafe unsafe = f9914b;
        InterfaceC3597b5 interfaceC3597b5Mo4569f = (InterfaceC3597b5) unsafe.getObject(t, j2);
        if (!interfaceC3597b5Mo4569f.mo4568a()) {
            int size = interfaceC3597b5Mo4569f.size();
            interfaceC3597b5Mo4569f = interfaceC3597b5Mo4569f.mo4569f(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, interfaceC3597b5Mo4569f);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    C3652f4 c3652f4 = (C3652f4) interfaceC3597b5Mo4569f;
                    int iM4233O2 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i8 = c3824s3.f10307a + iM4233O2;
                    while (iM4233O2 < i8) {
                        c3652f4.m4877d(Double.longBitsToDouble(C3404f.m4326o2(bArr, iM4233O2)));
                        iM4233O2 += 8;
                    }
                    if (iM4233O2 == i8) {
                        return iM4233O2;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 1) {
                    C3652f4 c3652f5 = (C3652f4) interfaceC3597b5Mo4569f;
                    c3652f5.m4877d(Double.longBitsToDouble(C3404f.m4326o2(bArr, i)));
                    while (true) {
                        int i9 = iM4233O1 + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iM4233O1 = C3404f.m4233O1(bArr, i9, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return i9;
                        }
                        c3652f5.m4877d(Double.longBitsToDouble(C3404f.m4326o2(bArr, iM4233O1)));
                    }
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    C3838t4 c3838t4 = (C3838t4) interfaceC3597b5Mo4569f;
                    int iM4233O3 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i10 = c3824s3.f10307a + iM4233O3;
                    while (iM4233O3 < i10) {
                        c3838t4.m5290d(Float.intBitsToFloat(C3404f.m4230N1(bArr, iM4233O3)));
                        iM4233O3 += 4;
                    }
                    if (iM4233O3 == i10) {
                        return iM4233O3;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 5) {
                    C3838t4 c3838t5 = (C3838t4) interfaceC3597b5Mo4569f;
                    c3838t5.m5290d(Float.intBitsToFloat(C3404f.m4230N1(bArr, i)));
                    while (true) {
                        int i11 = iM4233O1 + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iM4233O1 = C3404f.m4233O1(bArr, i11, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return i11;
                        }
                        c3838t5.m5290d(Float.intBitsToFloat(C3404f.m4230N1(bArr, iM4233O1)));
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    C3800q5 c3800q5 = (C3800q5) interfaceC3597b5Mo4569f;
                    int iM4233O4 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i12 = c3824s3.f10307a + iM4233O4;
                    while (iM4233O4 < i12) {
                        iM4233O4 = C3404f.m4322n2(bArr, iM4233O4, c3824s3);
                        c3800q5.m5186d(c3824s3.f10308b);
                    }
                    if (iM4233O4 == i12) {
                        return iM4233O4;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 0) {
                    C3800q5 c3800q6 = (C3800q5) interfaceC3597b5Mo4569f;
                    int iM4322n2 = C3404f.m4322n2(bArr, iM4233O1, c3824s3);
                    c3800q6.m5186d(c3824s3.f10308b);
                    while (iM4322n2 < i2) {
                        int iM4233O5 = C3404f.m4233O1(bArr, iM4322n2, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return iM4322n2;
                        }
                        iM4322n2 = C3404f.m4322n2(bArr, iM4233O5, c3824s3);
                        c3800q6.m5186d(c3824s3.f10308b);
                    }
                    return iM4322n2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return C3404f.m4236P1(bArr, iM4233O1, interfaceC3597b5Mo4569f, c3824s3);
                }
                if (i5 == 0) {
                    return C3404f.m4212H1(i3, bArr, i, i2, interfaceC3597b5Mo4569f, c3824s3);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    C3800q5 c3800q7 = (C3800q5) interfaceC3597b5Mo4569f;
                    int iM4233O6 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i13 = c3824s3.f10307a + iM4233O6;
                    while (iM4233O6 < i13) {
                        c3800q7.m5186d(C3404f.m4326o2(bArr, iM4233O6));
                        iM4233O6 += 8;
                    }
                    if (iM4233O6 == i13) {
                        return iM4233O6;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 1) {
                    C3800q5 c3800q8 = (C3800q5) interfaceC3597b5Mo4569f;
                    c3800q8.m5186d(C3404f.m4326o2(bArr, i));
                    while (true) {
                        int i14 = iM4233O1 + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iM4233O1 = C3404f.m4233O1(bArr, i14, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return i14;
                        }
                        c3800q8.m5186d(C3404f.m4326o2(bArr, iM4233O1));
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    C3890x4 c3890x4 = (C3890x4) interfaceC3597b5Mo4569f;
                    int iM4233O7 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i15 = c3824s3.f10307a + iM4233O7;
                    while (iM4233O7 < i15) {
                        c3890x4.m5358g(C3404f.m4230N1(bArr, iM4233O7));
                        iM4233O7 += 4;
                    }
                    if (iM4233O7 == i15) {
                        return iM4233O7;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 5) {
                    C3890x4 c3890x5 = (C3890x4) interfaceC3597b5Mo4569f;
                    c3890x5.m5358g(C3404f.m4230N1(bArr, i));
                    while (true) {
                        int i16 = iM4233O1 + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iM4233O1 = C3404f.m4233O1(bArr, i16, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return i16;
                        }
                        c3890x5.m5358g(C3404f.m4230N1(bArr, iM4233O1));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    C3811r3 c3811r3 = (C3811r3) interfaceC3597b5Mo4569f;
                    int iM4233O8 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i17 = c3824s3.f10307a + iM4233O8;
                    while (iM4233O8 < i17) {
                        iM4233O8 = C3404f.m4322n2(bArr, iM4233O8, c3824s3);
                        c3811r3.m5198d(c3824s3.f10308b != 0);
                    }
                    if (iM4233O8 == i17) {
                        return iM4233O8;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 0) {
                    C3811r3 c3811r4 = (C3811r3) interfaceC3597b5Mo4569f;
                    int iM4322n3 = C3404f.m4322n2(bArr, iM4233O1, c3824s3);
                    c3811r4.m5198d(c3824s3.f10308b != 0);
                    while (iM4322n3 < i2) {
                        int iM4233O9 = C3404f.m4233O1(bArr, iM4322n3, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return iM4322n3;
                        }
                        iM4322n3 = C3404f.m4322n2(bArr, iM4233O9, c3824s3);
                        c3811r4.m5198d(c3824s3.f10308b != 0);
                    }
                    return iM4322n3;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & Permission.MANAGE_WEBHOOKS) != 0) {
                        iM4233O1 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                        int i18 = c3824s3.f10307a;
                        if (i18 < 0) {
                            throw zzij.m9104b();
                        }
                        if (i18 == 0) {
                            interfaceC3597b5Mo4569f.add("");
                        } else {
                            int i19 = iM4233O1 + i18;
                            if (!C3724k7.m5022b(bArr, iM4233O1, i19)) {
                                throw zzij.m9107e();
                            }
                            interfaceC3597b5Mo4569f.add(new String(bArr, iM4233O1, i18, C3877w4.f10379a));
                            iM4233O1 = i19;
                        }
                        while (iM4233O1 < i2) {
                            int iM4233O10 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                            if (i3 != c3824s3.f10307a) {
                                break;
                            } else {
                                iM4233O1 = C3404f.m4233O1(bArr, iM4233O10, c3824s3);
                                int i20 = c3824s3.f10307a;
                                if (i20 < 0) {
                                    throw zzij.m9104b();
                                }
                                if (i20 == 0) {
                                    interfaceC3597b5Mo4569f.add("");
                                } else {
                                    int i21 = iM4233O1 + i20;
                                    if (!C3724k7.m5022b(bArr, iM4233O1, i21)) {
                                        throw zzij.m9107e();
                                    }
                                    interfaceC3597b5Mo4569f.add(new String(bArr, iM4233O1, i20, C3877w4.f10379a));
                                    iM4233O1 = i21;
                                }
                            }
                        }
                    } else {
                        iM4233O1 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                        int i22 = c3824s3.f10307a;
                        if (i22 < 0) {
                            throw zzij.m9104b();
                        }
                        if (i22 == 0) {
                            interfaceC3597b5Mo4569f.add("");
                        } else {
                            interfaceC3597b5Mo4569f.add(new String(bArr, iM4233O1, i22, C3877w4.f10379a));
                            iM4233O1 += i22;
                        }
                        while (iM4233O1 < i2) {
                            int iM4233O11 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                            if (i3 != c3824s3.f10307a) {
                                break;
                            } else {
                                iM4233O1 = C3404f.m4233O1(bArr, iM4233O11, c3824s3);
                                int i23 = c3824s3.f10307a;
                                if (i23 < 0) {
                                    throw zzij.m9104b();
                                }
                                if (i23 == 0) {
                                    interfaceC3597b5Mo4569f.add("");
                                } else {
                                    interfaceC3597b5Mo4569f.add(new String(bArr, iM4233O1, i23, C3877w4.f10379a));
                                    iM4233O1 += i23;
                                }
                            }
                        }
                    }
                }
                break;
            case 27:
                if (i5 == 2) {
                    return C3404f.m4221K1(m4856o(i6), i3, bArr, i, i2, interfaceC3597b5Mo4569f, c3824s3);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iM4233O12 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i24 = c3824s3.f10307a;
                    if (i24 < 0) {
                        throw zzij.m9104b();
                    }
                    if (i24 > bArr.length - iM4233O12) {
                        throw zzij.m9103a();
                    }
                    if (i24 == 0) {
                        interfaceC3597b5Mo4569f.add(AbstractC3837t3.f10322j);
                    } else {
                        interfaceC3597b5Mo4569f.add(AbstractC3837t3.m5279h(bArr, iM4233O12, i24));
                        iM4233O12 += i24;
                    }
                    while (iM4233O12 < i2) {
                        int iM4233O13 = C3404f.m4233O1(bArr, iM4233O12, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return iM4233O12;
                        }
                        iM4233O12 = C3404f.m4233O1(bArr, iM4233O13, c3824s3);
                        int i25 = c3824s3.f10307a;
                        if (i25 < 0) {
                            throw zzij.m9104b();
                        }
                        if (i25 > bArr.length - iM4233O12) {
                            throw zzij.m9103a();
                        }
                        if (i25 == 0) {
                            interfaceC3597b5Mo4569f.add(AbstractC3837t3.f10322j);
                        } else {
                            interfaceC3597b5Mo4569f.add(AbstractC3837t3.m5279h(bArr, iM4233O12, i25));
                            iM4233O12 += i25;
                        }
                    }
                    return iM4233O12;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iM4212H1 = C3404f.m4236P1(bArr, iM4233O1, interfaceC3597b5Mo4569f, c3824s3);
                } else if (i5 == 0) {
                    iM4212H1 = C3404f.m4212H1(i3, bArr, i, i2, interfaceC3597b5Mo4569f, c3824s3);
                }
                AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) t;
                Object objMo4634a = abstractC3851u4.zzb;
                if (objMo4634a == C3613c7.f9877a) {
                    objMo4634a = null;
                }
                InterfaceC3583a5 interfaceC3583a5 = (InterfaceC3583a5) this.f9916d[((i6 / 3) << 1) + 1];
                AbstractC3627d7<?, ?> abstractC3627d7 = this.f9927o;
                Class<?> cls = C3827s6.f10313a;
                if (interfaceC3583a5 != null) {
                    if (interfaceC3597b5Mo4569f instanceof RandomAccess) {
                        int size2 = interfaceC3597b5Mo4569f.size();
                        int i26 = 0;
                        for (int i27 = 0; i27 < size2; i27++) {
                            int iIntValue = ((Integer) interfaceC3597b5Mo4569f.get(i27)).intValue();
                            if (interfaceC3583a5.mo4556f(iIntValue)) {
                                if (i27 != i26) {
                                    interfaceC3597b5Mo4569f.set(i26, Integer.valueOf(iIntValue));
                                }
                                i26++;
                            } else {
                                if (objMo4634a == null) {
                                    objMo4634a = abstractC3627d7.mo4634a();
                                }
                                abstractC3627d7.mo4635b(objMo4634a, i4, iIntValue);
                            }
                        }
                        if (i26 != size2) {
                            interfaceC3597b5Mo4569f.subList(i26, size2).clear();
                        }
                    } else {
                        Iterator<E> it = interfaceC3597b5Mo4569f.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!interfaceC3583a5.mo4556f(iIntValue2)) {
                                if (objMo4634a == null) {
                                    objMo4634a = abstractC3627d7.mo4634a();
                                }
                                abstractC3627d7.mo4635b(objMo4634a, i4, iIntValue2);
                                it.remove();
                            }
                        }
                    }
                }
                C3613c7 c3613c7 = (C3613c7) objMo4634a;
                if (c3613c7 != null) {
                    abstractC3851u4.zzb = c3613c7;
                }
                return iM4212H1;
            case 33:
            case 47:
                if (i5 == 2) {
                    C3890x4 c3890x6 = (C3890x4) interfaceC3597b5Mo4569f;
                    int iM4233O14 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i28 = c3824s3.f10307a + iM4233O14;
                    while (iM4233O14 < i28) {
                        iM4233O14 = C3404f.m4233O1(bArr, iM4233O14, c3824s3);
                        c3890x6.m5358g(C3624d4.m4631b(c3824s3.f10307a));
                    }
                    if (iM4233O14 == i28) {
                        return iM4233O14;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 0) {
                    C3890x4 c3890x7 = (C3890x4) interfaceC3597b5Mo4569f;
                    int iM4233O15 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    c3890x7.m5358g(C3624d4.m4631b(c3824s3.f10307a));
                    while (iM4233O15 < i2) {
                        int iM4233O16 = C3404f.m4233O1(bArr, iM4233O15, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return iM4233O15;
                        }
                        iM4233O15 = C3404f.m4233O1(bArr, iM4233O16, c3824s3);
                        c3890x7.m5358g(C3624d4.m4631b(c3824s3.f10307a));
                    }
                    return iM4233O15;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    C3800q5 c3800q9 = (C3800q5) interfaceC3597b5Mo4569f;
                    int iM4233O17 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                    int i29 = c3824s3.f10307a + iM4233O17;
                    while (iM4233O17 < i29) {
                        iM4233O17 = C3404f.m4322n2(bArr, iM4233O17, c3824s3);
                        c3800q9.m5186d(C3624d4.m4630a(c3824s3.f10308b));
                    }
                    if (iM4233O17 == i29) {
                        return iM4233O17;
                    }
                    throw zzij.m9103a();
                }
                if (i5 == 0) {
                    C3800q5 c3800q10 = (C3800q5) interfaceC3597b5Mo4569f;
                    int iM4322n4 = C3404f.m4322n2(bArr, iM4233O1, c3824s3);
                    c3800q10.m5186d(C3624d4.m4630a(c3824s3.f10308b));
                    while (iM4322n4 < i2) {
                        int iM4233O18 = C3404f.m4233O1(bArr, iM4322n4, c3824s3);
                        if (i3 != c3824s3.f10307a) {
                            return iM4322n4;
                        }
                        iM4322n4 = C3404f.m4322n2(bArr, iM4233O18, c3824s3);
                        c3800q10.m5186d(C3624d4.m4630a(c3824s3.f10308b));
                    }
                    return iM4322n4;
                }
                break;
            case 49:
                if (i5 == 3) {
                    InterfaceC3801q6 interfaceC3801q6M4856o = m4856o(i6);
                    int i30 = (i3 & (-8)) | 4;
                    iM4233O1 = C3404f.m4224L1(interfaceC3801q6M4856o, bArr, i, i2, i30, c3824s3);
                    interfaceC3597b5Mo4569f.add(c3824s3.f10309c);
                    while (iM4233O1 < i2) {
                        int iM4233O19 = C3404f.m4233O1(bArr, iM4233O1, c3824s3);
                        if (i3 == c3824s3.f10307a) {
                            iM4233O1 = C3404f.m4224L1(interfaceC3801q6M4856o, bArr, iM4233O19, i2, i30, c3824s3);
                            interfaceC3597b5Mo4569f.add(c3824s3.f10309c);
                        }
                    }
                }
                break;
        }
        return iM4233O1;
    }

    /* JADX INFO: renamed from: l */
    public final <K, V> int m4854l(T t, byte[] bArr, int i, int i2, int i3, long j, C3824s3 c3824s3) throws IOException {
        Unsafe unsafe = f9914b;
        Object obj = this.f9916d[(i3 / 3) << 1];
        Object object = unsafe.getObject(t, j);
        if (this.f9929q.mo5335d(object)) {
            Object objMo5339h = this.f9929q.mo5339h(obj);
            this.f9929q.mo5337f(objMo5339h, object);
            unsafe.putObject(t, j, objMo5339h);
            object = objMo5339h;
        }
        C3839t5<?, ?> c3839t5Mo5338g = this.f9929q.mo5338g(obj);
        this.f9929q.mo5333b(object);
        int iM4233O1 = C3404f.m4233O1(bArr, i, c3824s3);
        int i4 = c3824s3.f10307a;
        if (i4 < 0 || i4 > i2 - iM4233O1) {
            throw zzij.m9103a();
        }
        Objects.requireNonNull(c3839t5Mo5338g);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 14621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    /* JADX INFO: renamed from: m */
    public final int m4855m(T r31, byte[] r32, int r33, int r34, int r35, p007b.p225i.p226a.p288f.p313h.p325l.C3824s3 r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p288f.p313h.p325l.C3640e6.m4855m(java.lang.Object, byte[], int, int, int, b.i.a.f.h.l.s3):int");
    }

    /* JADX INFO: renamed from: o */
    public final InterfaceC3801q6 m4856o(int i) {
        int i2 = (i / 3) << 1;
        Object[] objArr = this.f9916d;
        InterfaceC3801q6 interfaceC3801q6 = (InterfaceC3801q6) objArr[i2];
        if (interfaceC3801q6 != null) {
            return interfaceC3801q6;
        }
        InterfaceC3801q6<T> interfaceC3801q6M5138a = C3762n6.f10114a.m5138a((Class) objArr[i2 + 1]);
        this.f9916d[i2] = interfaceC3801q6M5138a;
        return interfaceC3801q6M5138a;
    }

    /* JADX INFO: renamed from: t */
    public final <K, V> void m4857t(InterfaceC3867v7 interfaceC3867v7, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.f9929q.mo5338g(this.f9916d[(i2 / 3) << 1]);
            Map<?, ?> mapMo5336e = this.f9929q.mo5336e(obj);
            C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
            Objects.requireNonNull(c3666g4);
            Iterator<Map.Entry<?, ?>> it = mapMo5336e.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                c3666g4.f9967a.mo9086f(i, 2);
                next.getKey();
                next.getValue();
                Objects.requireNonNull(null);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m4858u(T t, T t2, int i) {
        long j = this.f9915c[i + 1] & 1048575;
        if (m4859v(t2, i)) {
            Object objM4993r = C3711j7.m4993r(t, j);
            Object objM4993r2 = C3711j7.m4993r(t2, j);
            if (objM4993r != null && objM4993r2 != null) {
                C3711j7.m4981f(t, j, C3877w4.m5346c(objM4993r, objM4993r2));
                m4835B(t, i);
            } else if (objM4993r2 != null) {
                C3711j7.m4981f(t, j, objM4993r2);
                m4835B(t, i);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public final boolean m4859v(T t, int i) {
        int[] iArr = this.f9915c;
        int i2 = iArr[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return (C3711j7.m4977b(t, j) & (1 << (i2 >>> 20))) != 0;
        }
        int i3 = iArr[i + 1];
        long j2 = i3 & 1048575;
        switch ((i3 & 267386880) >>> 20) {
            case 0:
                return C3711j7.m4992q(t, j2) != 0.0d;
            case 1:
                return C3711j7.m4989n(t, j2) != 0.0f;
            case 2:
                return C3711j7.m4984i(t, j2) != 0;
            case 3:
                return C3711j7.m4984i(t, j2) != 0;
            case 4:
                return C3711j7.m4977b(t, j2) != 0;
            case 5:
                return C3711j7.m4984i(t, j2) != 0;
            case 6:
                return C3711j7.m4977b(t, j2) != 0;
            case 7:
                return C3711j7.m4988m(t, j2);
            case 8:
                Object objM4993r = C3711j7.m4993r(t, j2);
                if (objM4993r instanceof String) {
                    return !((String) objM4993r).isEmpty();
                }
                if (objM4993r instanceof AbstractC3837t3) {
                    return !AbstractC3837t3.f10322j.equals(objM4993r);
                }
                throw new IllegalArgumentException();
            case 9:
                return C3711j7.m4993r(t, j2) != null;
            case 10:
                return !AbstractC3837t3.f10322j.equals(C3711j7.m4993r(t, j2));
            case 11:
                return C3711j7.m4977b(t, j2) != 0;
            case 12:
                return C3711j7.m4977b(t, j2) != 0;
            case 13:
                return C3711j7.m4977b(t, j2) != 0;
            case 14:
                return C3711j7.m4984i(t, j2) != 0;
            case 15:
                return C3711j7.m4977b(t, j2) != 0;
            case 16:
                return C3711j7.m4984i(t, j2) != 0;
            case 17:
                return C3711j7.m4993r(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: w */
    public final boolean m4860w(T t, int i, int i2) {
        return C3711j7.m4977b(t, (long) (this.f9915c[i2 + 2] & 1048575)) == i;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m4861x(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return m4859v(t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX INFO: renamed from: z */
    public final int m4862z(int i, int i2) {
        int length = (this.f9915c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f9915c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
