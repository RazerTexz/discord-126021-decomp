package b.i.a.f.h.l;

import b.d.b.a.outline;
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
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e6<T> implements q6<T> {
    public static final int[] a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Unsafe f1441b = j7.k();
    public final int[] c;
    public final Object[] d;
    public final int e;
    public final int f;
    public final c6 g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final i6 m;
    public final m5 n;
    public final d7<?, ?> o;
    public final j4<?> p;
    public final v5 q;

    public e6(int[] iArr, Object[] objArr, int i, int i2, c6 c6Var, boolean z2, int[] iArr2, int i3, int i4, i6 i6Var, m5 m5Var, d7 d7Var, j4 j4Var, v5 v5Var) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        boolean z3 = c6Var instanceof u4;
        this.i = z2;
        this.h = j4Var != null && j4Var.e(c6Var);
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = i6Var;
        this.n = m5Var;
        this.o = d7Var;
        this.p = j4Var;
        this.g = c6Var;
        this.q = v5Var;
    }

    public static <T> float F(T t, long j) {
        return ((Float) j7.r(t, j)).floatValue();
    }

    public static <T> int J(T t, long j) {
        return ((Integer) j7.r(t, j)).intValue();
    }

    public static <T> long L(T t, long j) {
        return ((Long) j7.r(t, j)).longValue();
    }

    public static c7 M(Object obj) {
        u4 u4Var = (u4) obj;
        c7 c7Var = u4Var.zzb;
        if (c7Var != c7.a) {
            return c7Var;
        }
        c7 c7VarC = c7.c();
        u4Var.zzb = c7VarC;
        return c7VarC;
    }

    public static <T> boolean N(T t, long j) {
        return ((Boolean) j7.r(t, j)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:182:0x03a5  */
    public static e6 n(a6 a6Var, i6 i6Var, m5 m5Var, d7 d7Var, j4 j4Var, v5 v5Var) {
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
        o6 o6Var;
        int i16;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i17;
        Field fieldP;
        int i18;
        char cCharAt9;
        int i19;
        int i20;
        Field fieldP2;
        Field fieldP3;
        int i21;
        char cCharAt10;
        int i22;
        char cCharAt11;
        int i23;
        char cCharAt12;
        int i24;
        char cCharAt13;
        if (!(a6Var instanceof o6)) {
            throw new NoSuchMethodError();
        }
        o6 o6Var2 = (o6) a6Var;
        int i25 = 0;
        boolean z2 = ((o6Var2.d & 1) == 1 ? (char) 1 : (char) 2) == 2;
        String str = o6Var2.f1477b;
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
            iArr = a;
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
        Unsafe unsafe = f1441b;
        Object[] objArr = o6Var2.c;
        Class<?> cls = o6Var2.a.getClass();
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
                o6Var = o6Var2;
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
                    fieldP2 = (Field) obj;
                } else {
                    fieldP2 = p(cls, (String) obj);
                    objArr[i79] = fieldP2;
                }
                int i80 = i2;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP2);
                int i81 = i79 + 1;
                Object obj2 = objArr[i81];
                if (obj2 instanceof Field) {
                    fieldP3 = (Field) obj2;
                } else {
                    fieldP3 = p(cls, (String) obj2);
                    objArr[i81] = fieldP3;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldP3);
                str = str;
                z2 = z2;
                i15 = i77;
                i16 = i80;
                iObjectFieldOffset2 = iObjectFieldOffset3;
                objArr2 = objArr2;
                i17 = 0;
            } else {
                o6Var = o6Var2;
                i16 = i2 + 1;
                Field fieldP4 = p(cls, (String) objArr[i2]);
                if (i71 == 9 || i71 == 17) {
                    objArr2[((i61 / 3) << 1) + 1] = fieldP4.getType();
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP4);
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
                                fieldP = (Field) obj3;
                            } else {
                                fieldP = p(cls, (String) obj3);
                                objArr[i87] = fieldP;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldP);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldP4);
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
            o6Var2 = o6Var;
        }
        return new e6(iArr3, objArr2, iCharAt, iCharAt2, o6Var2.a, z2, iArr, iCharAt4, i56, i6Var, m5Var, d7Var, j4Var, v5Var);
    }

    public static Field p(Class<?> cls, String str) {
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
            throw new RuntimeException(outline.J(outline.S(outline.b(string, name.length() + outline.b(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", string));
        }
    }

    public static List<?> q(Object obj, long j) {
        return (List) j7.r(obj, j);
    }

    public static void r(int i, Object obj, v7 v7Var) throws IOException {
        if (obj instanceof String) {
            ((g4) v7Var).a.k(i, (String) obj);
        } else {
            ((g4) v7Var).a.h(i, (t3) obj);
        }
    }

    public static <UT, UB> void s(d7<UT, UB> d7Var, T t, v7 v7Var) throws IOException {
        d7Var.c(d7Var.e(t), v7Var);
    }

    public static <T> double y(T t, long j) {
        return ((Double) j7.r(t, j)).doubleValue();
    }

    public final Object A(int i) {
        return this.d[(i / 3) << 1];
    }

    public final void B(T t, int i) {
        int i2 = this.c[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        j7.e.e(t, j, (1 << (i2 >>> 20)) | j7.b(t, j));
    }

    public final void C(T t, int i, int i2) {
        j7.e.e(t, this.c[i2 + 2] & 1048575, i);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public final void D(T t, v7 v7Var) throws IOException {
        Iterator itL;
        Map.Entry<?, ?> entry;
        int i;
        if (this.h) {
            n4<T> n4VarB = this.p.b(t);
            if (n4VarB.f1461b.isEmpty()) {
                itL = null;
                entry = null;
            } else {
                itL = n4VarB.l();
                entry = (Map.Entry) itL.next();
            }
        } else {
            itL = null;
            entry = null;
        }
        int length = this.c.length;
        Unsafe unsafe = f1441b;
        int i2 = 1048575;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int I = I(i4);
            int[] iArr = this.c;
            int i5 = iArr[i4];
            int i6 = (I & 267386880) >>> 20;
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
            while (entry != null && this.p.a(entry) <= i5) {
                this.p.d(v7Var, entry);
                entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
            }
            long j = I & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a(i5, j7.q(t, j));
                        continue;
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).b(i5, j7.n(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.g(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.l(i5, j7.m(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        r(i5, unsafe.getObject(t, j), v7Var);
                    } else {
                        continue;
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).d(i5, unsafe.getObject(t, j), o(i4));
                    } else {
                        continue;
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.h(i5, (t3) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.y(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.s(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.G(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).a.z(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).g(i5, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).f(i5, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        ((g4) v7Var).e(i5, unsafe.getObject(t, j), o(i4));
                    } else {
                        continue;
                    }
                    break;
                case 18:
                    s6.h(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 19:
                    s6.q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 20:
                    s6.u(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 21:
                    s6.x(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 22:
                    s6.J(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 23:
                    s6.D(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 24:
                    s6.O(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 25:
                    s6.R(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 26:
                    s6.f(this.c[i4], (List) unsafe.getObject(t, j), v7Var);
                    break;
                case 27:
                    s6.g(this.c[i4], (List) unsafe.getObject(t, j), v7Var, o(i4));
                    break;
                case 28:
                    s6.o(this.c[i4], (List) unsafe.getObject(t, j), v7Var);
                    break;
                case 29:
                    s6.M(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 30:
                    s6.Q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 31:
                    s6.P(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 32:
                    s6.G(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 33:
                    s6.N(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 34:
                    s6.A(this.c[i4], (List) unsafe.getObject(t, j), v7Var, false);
                    break;
                case 35:
                    s6.h(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 36:
                    s6.q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 37:
                    s6.u(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 38:
                    s6.x(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 39:
                    s6.J(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 40:
                    s6.D(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 41:
                    s6.O(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 42:
                    s6.R(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 43:
                    s6.M(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 44:
                    s6.Q(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 45:
                    s6.P(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 46:
                    s6.G(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 47:
                    s6.N(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 48:
                    s6.A(this.c[i4], (List) unsafe.getObject(t, j), v7Var, true);
                    break;
                case 49:
                    s6.p(this.c[i4], (List) unsafe.getObject(t, j), v7Var, o(i4));
                    break;
                case 50:
                    t(v7Var, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a(i5, y(t, j));
                    }
                    break;
                case 52:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).b(i5, F(t, j));
                    }
                    break;
                case 53:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.g(i5, L(t, j));
                    }
                    break;
                case 54:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.g(i5, L(t, j));
                    }
                    break;
                case 55:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.s(i5, J(t, j));
                    }
                    break;
                case 56:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.z(i5, L(t, j));
                    }
                    break;
                case 57:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.G(i5, J(t, j));
                    }
                    break;
                case 58:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.l(i5, N(t, j));
                    }
                    break;
                case 59:
                    if (w(t, i5, i4)) {
                        r(i5, unsafe.getObject(t, j), v7Var);
                    }
                    break;
                case 60:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).d(i5, unsafe.getObject(t, j), o(i4));
                    }
                    break;
                case 61:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.h(i5, (t3) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.y(i5, J(t, j));
                    }
                    break;
                case 63:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.s(i5, J(t, j));
                    }
                    break;
                case 64:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.G(i5, J(t, j));
                    }
                    break;
                case 65:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).a.z(i5, L(t, j));
                    }
                    break;
                case 66:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).g(i5, J(t, j));
                    }
                    break;
                case 67:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).f(i5, L(t, j));
                    }
                    break;
                case 68:
                    if (w(t, i5, i4)) {
                        ((g4) v7Var).e(i5, unsafe.getObject(t, j), o(i4));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.d(v7Var, entry);
            entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
        }
        s(this.o, t, v7Var);
    }

    public final void E(T t, T t2, int i) {
        int[] iArr = this.c;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (w(t2, i3, i)) {
            Object objR = w(t, i3, i) ? j7.r(t, j) : null;
            Object objR2 = j7.r(t2, j);
            if (objR != null && objR2 != null) {
                j7.f(t, j, w4.c(objR, objR2));
                C(t, i3, i);
            } else if (objR2 != null) {
                j7.f(t, j, objR2);
                C(t, i3, i);
            }
        }
    }

    public final a5 G(int i) {
        return (a5) this.d[((i / 3) << 1) + 1];
    }

    public final boolean H(T t, T t2, int i) {
        return v(t, i) == v(t2, i);
    }

    public final int I(int i) {
        return this.c[i + 1];
    }

    public final int K(int i) {
        return this.c[i + 2];
    }

    @Override // b.i.a.f.h.l.q6
    public final T a() {
        return (T) this.m.b(this.g);
    }

    @Override // b.i.a.f.h.l.q6
    public final int b(T t) {
        int i;
        int iA;
        int length = this.c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int I = I(i3);
            int i4 = this.c[i3];
            long j = 1048575 & I;
            int iHashCode = 37;
            switch ((I & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iA = w4.a(Double.doubleToLongBits(j7.q(t, j)));
                    i2 = iA + i;
                    break;
                case 1:
                    i = i2 * 53;
                    iA = Float.floatToIntBits(j7.n(t, j));
                    i2 = iA + i;
                    break;
                case 2:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 3:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 4:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 5:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 6:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 7:
                    i = i2 * 53;
                    iA = w4.b(j7.m(t, j));
                    i2 = iA + i;
                    break;
                case 8:
                    i = i2 * 53;
                    iA = ((String) j7.r(t, j)).hashCode();
                    i2 = iA + i;
                    break;
                case 9:
                    Object objR = j7.r(t, j);
                    if (objR != null) {
                        iHashCode = objR.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 11:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 12:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 13:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 14:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 15:
                    i = i2 * 53;
                    iA = j7.b(t, j);
                    i2 = iA + i;
                    break;
                case 16:
                    i = i2 * 53;
                    iA = w4.a(j7.i(t, j));
                    i2 = iA + i;
                    break;
                case 17:
                    Object objR2 = j7.r(t, j);
                    if (objR2 != null) {
                        iHashCode = objR2.hashCode();
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
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 50:
                    i = i2 * 53;
                    iA = j7.r(t, j).hashCode();
                    i2 = iA + i;
                    break;
                case 51:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(Double.doubleToLongBits(y(t, j)));
                        i2 = iA + i;
                    }
                    break;
                case 52:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = Float.floatToIntBits(F(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 53:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 54:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 55:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 56:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 57:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 58:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.b(N(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 59:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = ((String) j7.r(t, j)).hashCode();
                        i2 = iA + i;
                    }
                    break;
                case 60:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                    }
                    break;
                case 61:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                    }
                    break;
                case 62:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 63:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 64:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 65:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 66:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = J(t, j);
                        i2 = iA + i;
                    }
                    break;
                case 67:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = w4.a(L(t, j));
                        i2 = iA + i;
                    }
                    break;
                case 68:
                    if (w(t, i4, i3)) {
                        i = i2 * 53;
                        iA = j7.r(t, j).hashCode();
                        i2 = iA + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.o.e(t).hashCode() + (i2 * 53);
        return this.h ? (iHashCode2 * 53) + this.p.b(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de A[LOOP:1: B:47:0x00cc->B:52:0x00de, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.a.f.h.l.q6
    public final boolean c(T t) {
        int i;
        int i2;
        List list;
        q6 q6VarO;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            if (i6 >= this.k) {
                return !this.h || this.p.b(t).m();
            }
            int i7 = this.j[i6];
            int i8 = this.c[i7];
            int I = I(i7);
            int i9 = this.c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = f1441b.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if (((268435456 & I) != 0) && !x(t, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & I) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (x(t, i7, i, i2, i11) && !o(i7).c(j7.r(t, I & 1048575))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) j7.r(t, I & 1048575);
                if (!list.isEmpty()) {
                    q6VarO = o(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!q6VarO.c(list.get(i3))) {
                            z2 = false;
                            break;
                        }
                    }
                }
                if (!z2) {
                    return false;
                }
            } else if (i12 == 60 || i12 == 68) {
                if (w(t, i8, i7) && !o(i7).c(j7.r(t, I & 1048575))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) j7.r(t, I & 1048575);
                if (!list.isEmpty()) {
                    q6VarO = o(i7);
                    while (i3 < list.size()) {
                        if (!q6VarO.c(list.get(i3))) {
                            z2 = false;
                            break;
                        }
                    }
                }
                if (!z2) {
                    return false;
                }
            } else if (i12 == 50 && !this.q.e(j7.r(t, I & 1048575)).isEmpty()) {
                Objects.requireNonNull(this.q.g(A(i7)));
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final void d(T t) {
        int i;
        int i2 = this.k;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            long jI = I(this.j[i2]) & 1048575;
            Object objR = j7.r(t, jI);
            if (objR != null) {
                j7.f(t, jI, this.q.c(objR));
            }
            i2++;
        }
        int length = this.j.length;
        while (i < length) {
            this.n.b(t, this.j[i]);
            i++;
        }
        this.o.h(t);
        if (this.h) {
            this.p.g(t);
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
    @Override // b.i.a.f.h.l.q6
    public final int e(T t) {
        int i;
        int iU;
        int iL;
        int iD;
        int iL2;
        int iU2;
        int iL3;
        int iD2;
        int iL4;
        if (this.i) {
            Unsafe unsafe = f1441b;
            int i2 = 0;
            for (int i3 = 0; i3 < this.c.length; i3 += 3) {
                int I = I(i3);
                int i4 = (I & 267386880) >>> 20;
                int i5 = this.c[i3];
                long j = I & 1048575;
                if (i4 >= o4.S.a() && i4 <= o4.f1468f0.a()) {
                    int i6 = this.c[i3 + 2];
                }
                switch (i4) {
                    case 0:
                        if (v(t, i3)) {
                            iU2 = zzhi.u(i5);
                            i2 += iU2;
                        }
                        break;
                    case 1:
                        if (v(t, i3)) {
                            iU2 = zzhi.n(i5);
                            i2 += iU2;
                        }
                        break;
                    case 2:
                        if (v(t, i3)) {
                            iU2 = zzhi.B(i5, j7.i(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 3:
                        if (v(t, i3)) {
                            iU2 = zzhi.E(i5, j7.i(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 4:
                        if (v(t, i3)) {
                            iU2 = zzhi.I(i5, j7.b(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 5:
                        if (v(t, i3)) {
                            iU2 = zzhi.N(i5);
                            i2 += iU2;
                        }
                        break;
                    case 6:
                        if (v(t, i3)) {
                            iU2 = zzhi.S(i5);
                            i2 += iU2;
                        }
                        break;
                    case 7:
                        if (v(t, i3)) {
                            iU2 = zzhi.v(i5);
                            i2 += iU2;
                        }
                        break;
                    case 8:
                        if (v(t, i3)) {
                            Object objR = j7.r(t, j);
                            iU2 = objR instanceof t3 ? zzhi.w(i5, (t3) objR) : zzhi.o(i5, (String) objR);
                            i2 += iU2;
                        }
                        break;
                    case 9:
                        if (v(t, i3)) {
                            iU2 = s6.a(i5, j7.r(t, j), o(i3));
                            i2 += iU2;
                        }
                        break;
                    case 10:
                        if (v(t, i3)) {
                            iU2 = zzhi.w(i5, (t3) j7.r(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 11:
                        if (v(t, i3)) {
                            iU2 = zzhi.M(i5, j7.b(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 12:
                        if (v(t, i3)) {
                            iU2 = zzhi.U(i5, j7.b(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 13:
                        if (v(t, i3)) {
                            iU2 = zzhi.T(i5);
                            i2 += iU2;
                        }
                        break;
                    case 14:
                        if (v(t, i3)) {
                            iU2 = zzhi.Q(i5);
                            i2 += iU2;
                        }
                        break;
                    case 15:
                        if (v(t, i3)) {
                            iU2 = zzhi.P(i5, j7.b(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 16:
                        if (v(t, i3)) {
                            iU2 = zzhi.J(i5, j7.i(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 17:
                        if (v(t, i3)) {
                            iU2 = zzhi.x(i5, (c6) j7.r(t, j), o(i3));
                            i2 += iU2;
                        }
                        break;
                    case 18:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 19:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 20:
                        iU2 = s6.k(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 21:
                        iU2 = s6.r(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 22:
                        iU2 = s6.y(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 23:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 24:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 25:
                        List<?> listQ = q(t, j);
                        Class<?> cls = s6.a;
                        int size = listQ.size();
                        iU2 = size == 0 ? 0 : size * zzhi.v(i5);
                        i2 += iU2;
                        break;
                    case 26:
                        iU2 = s6.b(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 27:
                        iU2 = s6.c(i5, q(t, j), o(i3));
                        i2 += iU2;
                        break;
                    case 28:
                        iU2 = s6.l(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 29:
                        iU2 = s6.B(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 30:
                        iU2 = s6.v(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 31:
                        iU2 = s6.H(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 32:
                        iU2 = s6.K(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 33:
                        iU2 = s6.E(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 34:
                        iU2 = s6.s(i5, q(t, j));
                        i2 += iU2;
                        break;
                    case 35:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 36:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 37:
                        iL3 = s6.d((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 38:
                        iL3 = s6.n((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 39:
                        iL3 = s6.z((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 40:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 41:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 42:
                        List list = (List) unsafe.getObject(t, j);
                        Class<?> cls2 = s6.a;
                        iL3 = list.size();
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 43:
                        iL3 = s6.C((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 44:
                        iL3 = s6.w((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 45:
                        iL3 = s6.I((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 46:
                        iL3 = s6.L((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 47:
                        iL3 = s6.F((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 48:
                        iL3 = s6.t((List) unsafe.getObject(t, j));
                        if (iL3 > 0) {
                            iD2 = zzhi.D(i5);
                            iL4 = zzhi.L(iL3);
                            i2 = iL4 + iD2 + iL3 + i2;
                        }
                        break;
                    case 49:
                        iU2 = s6.m(i5, q(t, j), o(i3));
                        i2 += iU2;
                        break;
                    case 50:
                        iU2 = this.q.i(i5, j7.r(t, j), A(i3));
                        i2 += iU2;
                        break;
                    case 51:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.u(i5);
                            i2 += iU2;
                        }
                        break;
                    case 52:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.n(i5);
                            i2 += iU2;
                        }
                        break;
                    case 53:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.B(i5, L(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 54:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.E(i5, L(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 55:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.I(i5, J(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 56:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.N(i5);
                            i2 += iU2;
                        }
                        break;
                    case 57:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.S(i5);
                            i2 += iU2;
                        }
                        break;
                    case 58:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.v(i5);
                            i2 += iU2;
                        }
                        break;
                    case 59:
                        if (w(t, i5, i3)) {
                            Object objR2 = j7.r(t, j);
                            iU2 = objR2 instanceof t3 ? zzhi.w(i5, (t3) objR2) : zzhi.o(i5, (String) objR2);
                            i2 += iU2;
                        }
                        break;
                    case 60:
                        if (w(t, i5, i3)) {
                            iU2 = s6.a(i5, j7.r(t, j), o(i3));
                            i2 += iU2;
                        }
                        break;
                    case 61:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.w(i5, (t3) j7.r(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 62:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.M(i5, J(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 63:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.U(i5, J(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 64:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.T(i5);
                            i2 += iU2;
                        }
                        break;
                    case 65:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.Q(i5);
                            i2 += iU2;
                        }
                        break;
                    case 66:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.P(i5, J(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 67:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.J(i5, L(t, j));
                            i2 += iU2;
                        }
                        break;
                    case 68:
                        if (w(t, i5, i3)) {
                            iU2 = zzhi.x(i5, (c6) j7.r(t, j), o(i3));
                            i2 += iU2;
                        }
                        break;
                }
            }
            d7<?, ?> d7Var = this.o;
            return d7Var.j(d7Var.e(t)) + i2;
        }
        Unsafe unsafe2 = f1441b;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        for (int i10 = 0; i10 < this.c.length; i10 += 3) {
            int I2 = I(i10);
            int[] iArr = this.c;
            int i11 = iArr[i10];
            int i12 = (I2 & 267386880) >>> 20;
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
            long j2 = I2 & 1048575;
            switch (i12) {
                case 0:
                    if ((i9 & i) != 0) {
                        iU = zzhi.u(i11);
                        i7 += iU;
                    }
                    break;
                case 1:
                    if ((i9 & i) != 0) {
                        iU = zzhi.n(i11);
                        i7 += iU;
                    }
                    break;
                case 2:
                    if ((i9 & i) != 0) {
                        iU = zzhi.B(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                    }
                    break;
                case 3:
                    if ((i9 & i) != 0) {
                        iU = zzhi.E(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                    }
                    break;
                case 4:
                    if ((i9 & i) != 0) {
                        iU = zzhi.I(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                    }
                    break;
                case 5:
                    if ((i9 & i) != 0) {
                        iU = zzhi.N(i11);
                        i7 += iU;
                    }
                    break;
                case 6:
                    if ((i9 & i) != 0) {
                        iU = zzhi.S(i11);
                        i7 += iU;
                    }
                    break;
                case 7:
                    if ((i9 & i) != 0) {
                        iU = zzhi.v(i11);
                        i7 += iU;
                    }
                    break;
                case 8:
                    if ((i9 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        iU = object instanceof t3 ? zzhi.w(i11, (t3) object) : zzhi.o(i11, (String) object);
                        i7 += iU;
                    }
                    break;
                case 9:
                    if ((i9 & i) != 0) {
                        iU = s6.a(i11, unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                    }
                    break;
                case 10:
                    if ((i9 & i) != 0) {
                        iU = zzhi.w(i11, (t3) unsafe2.getObject(t, j2));
                        i7 += iU;
                    }
                    break;
                case 11:
                    if ((i9 & i) != 0) {
                        iU = zzhi.M(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                    }
                    break;
                case 12:
                    if ((i9 & i) != 0) {
                        iU = zzhi.U(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                    }
                    break;
                case 13:
                    if ((i9 & i) != 0) {
                        iU = zzhi.T(i11);
                        i7 += iU;
                    }
                    break;
                case 14:
                    if ((i9 & i) != 0) {
                        iU = zzhi.Q(i11);
                        i7 += iU;
                    }
                    break;
                case 15:
                    if ((i9 & i) != 0) {
                        iU = zzhi.P(i11, unsafe2.getInt(t, j2));
                        i7 += iU;
                    }
                    break;
                case 16:
                    if ((i9 & i) != 0) {
                        iU = zzhi.J(i11, unsafe2.getLong(t, j2));
                        i7 += iU;
                    }
                    break;
                case 17:
                    if ((i9 & i) != 0) {
                        iU = zzhi.x(i11, (c6) unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                    }
                    break;
                case 18:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 19:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 20:
                    iU = s6.k(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 21:
                    iU = s6.r(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 22:
                    iU = s6.y(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 23:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 24:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 25:
                    List list2 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls3 = s6.a;
                    int size2 = list2.size();
                    iU = size2 == 0 ? 0 : size2 * zzhi.v(i11);
                    i7 += iU;
                    break;
                case 26:
                    iU = s6.b(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 27:
                    iU = s6.c(i11, (List) unsafe2.getObject(t, j2), o(i10));
                    i7 += iU;
                    break;
                case 28:
                    iU = s6.l(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 29:
                    iU = s6.B(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 30:
                    iU = s6.v(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 31:
                    iU = s6.H(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 32:
                    iU = s6.K(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 33:
                    iU = s6.E(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 34:
                    iU = s6.s(i11, (List) unsafe2.getObject(t, j2));
                    i7 += iU;
                    break;
                case 35:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 36:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 37:
                    iL = s6.d((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 38:
                    iL = s6.n((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 39:
                    iL = s6.z((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 40:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 41:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 42:
                    List list3 = (List) unsafe2.getObject(t, j2);
                    Class<?> cls4 = s6.a;
                    iL = list3.size();
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 43:
                    iL = s6.C((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 44:
                    iL = s6.w((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 45:
                    iL = s6.I((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 46:
                    iL = s6.L((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 47:
                    iL = s6.F((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 48:
                    iL = s6.t((List) unsafe2.getObject(t, j2));
                    if (iL > 0) {
                        iD = zzhi.D(i11);
                        iL2 = zzhi.L(iL);
                        i7 = iL2 + iD + iL + i7;
                    }
                    break;
                case 49:
                    iU = s6.m(i11, (List) unsafe2.getObject(t, j2), o(i10));
                    i7 += iU;
                    break;
                case 50:
                    iU = this.q.i(i11, unsafe2.getObject(t, j2), A(i10));
                    i7 += iU;
                    break;
                case 51:
                    if (w(t, i11, i10)) {
                        iU = zzhi.u(i11);
                        i7 += iU;
                    }
                    break;
                case 52:
                    if (w(t, i11, i10)) {
                        iU = zzhi.n(i11);
                        i7 += iU;
                    }
                    break;
                case 53:
                    if (w(t, i11, i10)) {
                        iU = zzhi.B(i11, L(t, j2));
                        i7 += iU;
                    }
                    break;
                case 54:
                    if (w(t, i11, i10)) {
                        iU = zzhi.E(i11, L(t, j2));
                        i7 += iU;
                    }
                    break;
                case 55:
                    if (w(t, i11, i10)) {
                        iU = zzhi.I(i11, J(t, j2));
                        i7 += iU;
                    }
                    break;
                case 56:
                    if (w(t, i11, i10)) {
                        iU = zzhi.N(i11);
                        i7 += iU;
                    }
                    break;
                case 57:
                    if (w(t, i11, i10)) {
                        iU = zzhi.S(i11);
                        i7 += iU;
                    }
                    break;
                case 58:
                    if (w(t, i11, i10)) {
                        iU = zzhi.v(i11);
                        i7 += iU;
                    }
                    break;
                case 59:
                    if (w(t, i11, i10)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        iU = object2 instanceof t3 ? zzhi.w(i11, (t3) object2) : zzhi.o(i11, (String) object2);
                        i7 += iU;
                    }
                    break;
                case 60:
                    if (w(t, i11, i10)) {
                        iU = s6.a(i11, unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                    }
                    break;
                case 61:
                    if (w(t, i11, i10)) {
                        iU = zzhi.w(i11, (t3) unsafe2.getObject(t, j2));
                        i7 += iU;
                    }
                    break;
                case 62:
                    if (w(t, i11, i10)) {
                        iU = zzhi.M(i11, J(t, j2));
                        i7 += iU;
                    }
                    break;
                case 63:
                    if (w(t, i11, i10)) {
                        iU = zzhi.U(i11, J(t, j2));
                        i7 += iU;
                    }
                    break;
                case 64:
                    if (w(t, i11, i10)) {
                        iU = zzhi.T(i11);
                        i7 += iU;
                    }
                    break;
                case 65:
                    if (w(t, i11, i10)) {
                        iU = zzhi.Q(i11);
                        i7 += iU;
                    }
                    break;
                case 66:
                    if (w(t, i11, i10)) {
                        iU = zzhi.P(i11, J(t, j2));
                        i7 += iU;
                    }
                    break;
                case 67:
                    if (w(t, i11, i10)) {
                        iU = zzhi.J(i11, L(t, j2));
                        i7 += iU;
                    }
                    break;
                case 68:
                    if (w(t, i11, i10)) {
                        iU = zzhi.x(i11, (c6) unsafe2.getObject(t, j2), o(i10));
                        i7 += iU;
                    }
                    break;
            }
        }
        d7<?, ?> d7Var2 = this.o;
        int iJ = d7Var2.j(d7Var2.e(t)) + i7;
        if (!this.h) {
            return iJ;
        }
        n4<T> n4VarB = this.p.b(t);
        int iA = 0;
        for (int i15 = 0; i15 < n4VarB.f1461b.e(); i15++) {
            Map.Entry entryD = n4VarB.f1461b.d(i15);
            iA += n4.a((p4) entryD.getKey(), entryD.getValue());
        }
        for (Map.Entry entry : n4VarB.f1461b.g()) {
            iA += n4.a((p4) entry.getKey(), entry.getValue());
        }
        return iJ + iA;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // b.i.a.f.h.l.q6
    public final boolean f(T t, T t2) {
        int length = this.c.length;
        int i = 0;
        while (true) {
            boolean zJ = true;
            if (i >= length) {
                if (!this.o.e(t).equals(this.o.e(t2))) {
                    return false;
                }
                if (this.h) {
                    return this.p.b(t).equals(this.p.b(t2));
                }
                return true;
            }
            int I = I(i);
            long j = I & 1048575;
            switch ((I & 267386880) >>> 20) {
                case 0:
                    if (!H(t, t2, i) || Double.doubleToLongBits(j7.q(t, j)) != Double.doubleToLongBits(j7.q(t2, j))) {
                        zJ = false;
                    }
                    break;
                case 1:
                    if (!H(t, t2, i) || Float.floatToIntBits(j7.n(t, j)) != Float.floatToIntBits(j7.n(t2, j))) {
                        zJ = false;
                    }
                    break;
                case 2:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 3:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 4:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 5:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 6:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 7:
                    if (!H(t, t2, i) || j7.m(t, j) != j7.m(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 8:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                        zJ = false;
                    }
                    break;
                case 9:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                        zJ = false;
                    }
                    break;
                case 10:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                        zJ = false;
                    }
                    break;
                case 11:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 12:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 13:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 14:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 15:
                    if (!H(t, t2, i) || j7.b(t, j) != j7.b(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 16:
                    if (!H(t, t2, i) || j7.i(t, j) != j7.i(t2, j)) {
                        zJ = false;
                    }
                    break;
                case 17:
                    if (!H(t, t2, i) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                        zJ = false;
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
                    zJ = s6.j(j7.r(t, j), j7.r(t2, j));
                    break;
                case 50:
                    zJ = s6.j(j7.r(t, j), j7.r(t2, j));
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
                    long jK = K(i) & 1048575;
                    if (j7.b(t, jK) != j7.b(t2, jK) || !s6.j(j7.r(t, j), j7.r(t2, j))) {
                        zJ = false;
                    }
                    break;
            }
            if (!zJ) {
                return false;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // b.i.a.f.h.l.q6
    public final void g(T t, v7 v7Var) throws IOException {
        Iterator itL;
        Map.Entry<?, ?> entry;
        Objects.requireNonNull(v7Var);
        if (!this.i) {
            D(t, v7Var);
            return;
        }
        if (this.h) {
            n4<T> n4VarB = this.p.b(t);
            if (n4VarB.f1461b.isEmpty()) {
                itL = null;
                entry = null;
            } else {
                itL = n4VarB.l();
                entry = (Map.Entry) itL.next();
            }
        } else {
            itL = null;
            entry = null;
        }
        int length = this.c.length;
        for (int i = 0; i < length; i += 3) {
            int I = I(i);
            int i2 = this.c[i];
            while (entry != null && this.p.a(entry) <= i2) {
                this.p.d(v7Var, entry);
                entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
            }
            switch ((267386880 & I) >>> 20) {
                case 0:
                    if (v(t, i)) {
                        ((g4) v7Var).a(i2, j7.q(t, I & 1048575));
                    }
                    break;
                case 1:
                    if (v(t, i)) {
                        ((g4) v7Var).b(i2, j7.n(t, I & 1048575));
                    }
                    break;
                case 2:
                    if (v(t, i)) {
                        ((g4) v7Var).a.g(i2, j7.i(t, I & 1048575));
                    }
                    break;
                case 3:
                    if (v(t, i)) {
                        ((g4) v7Var).a.g(i2, j7.i(t, I & 1048575));
                    }
                    break;
                case 4:
                    if (v(t, i)) {
                        ((g4) v7Var).a.s(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 5:
                    if (v(t, i)) {
                        ((g4) v7Var).a.z(i2, j7.i(t, I & 1048575));
                    }
                    break;
                case 6:
                    if (v(t, i)) {
                        ((g4) v7Var).a.G(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 7:
                    if (v(t, i)) {
                        ((g4) v7Var).a.l(i2, j7.m(t, I & 1048575));
                    }
                    break;
                case 8:
                    if (v(t, i)) {
                        r(i2, j7.r(t, I & 1048575), v7Var);
                    }
                    break;
                case 9:
                    if (v(t, i)) {
                        ((g4) v7Var).d(i2, j7.r(t, I & 1048575), o(i));
                    }
                    break;
                case 10:
                    if (v(t, i)) {
                        ((g4) v7Var).a.h(i2, (t3) j7.r(t, I & 1048575));
                    }
                    break;
                case 11:
                    if (v(t, i)) {
                        ((g4) v7Var).a.y(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 12:
                    if (v(t, i)) {
                        ((g4) v7Var).a.s(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 13:
                    if (v(t, i)) {
                        ((g4) v7Var).a.G(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 14:
                    if (v(t, i)) {
                        ((g4) v7Var).a.z(i2, j7.i(t, I & 1048575));
                    }
                    break;
                case 15:
                    if (v(t, i)) {
                        ((g4) v7Var).g(i2, j7.b(t, I & 1048575));
                    }
                    break;
                case 16:
                    if (v(t, i)) {
                        ((g4) v7Var).f(i2, j7.i(t, I & 1048575));
                    }
                    break;
                case 17:
                    if (v(t, i)) {
                        ((g4) v7Var).e(i2, j7.r(t, I & 1048575), o(i));
                    }
                    break;
                case 18:
                    s6.h(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 19:
                    s6.q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 20:
                    s6.u(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 21:
                    s6.x(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 22:
                    s6.J(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 23:
                    s6.D(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 24:
                    s6.O(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 25:
                    s6.R(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 26:
                    s6.f(this.c[i], (List) j7.r(t, I & 1048575), v7Var);
                    break;
                case 27:
                    s6.g(this.c[i], (List) j7.r(t, I & 1048575), v7Var, o(i));
                    break;
                case 28:
                    s6.o(this.c[i], (List) j7.r(t, I & 1048575), v7Var);
                    break;
                case 29:
                    s6.M(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 30:
                    s6.Q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 31:
                    s6.P(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 32:
                    s6.G(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 33:
                    s6.N(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 34:
                    s6.A(this.c[i], (List) j7.r(t, I & 1048575), v7Var, false);
                    break;
                case 35:
                    s6.h(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 36:
                    s6.q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 37:
                    s6.u(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 38:
                    s6.x(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 39:
                    s6.J(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 40:
                    s6.D(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 41:
                    s6.O(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 42:
                    s6.R(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 43:
                    s6.M(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 44:
                    s6.Q(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 45:
                    s6.P(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 46:
                    s6.G(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 47:
                    s6.N(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 48:
                    s6.A(this.c[i], (List) j7.r(t, I & 1048575), v7Var, true);
                    break;
                case 49:
                    s6.p(this.c[i], (List) j7.r(t, I & 1048575), v7Var, o(i));
                    break;
                case 50:
                    t(v7Var, i2, j7.r(t, I & 1048575), i);
                    break;
                case 51:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a(i2, y(t, I & 1048575));
                    }
                    break;
                case 52:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).b(i2, F(t, I & 1048575));
                    }
                    break;
                case 53:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.g(i2, L(t, I & 1048575));
                    }
                    break;
                case 54:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.g(i2, L(t, I & 1048575));
                    }
                    break;
                case 55:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.s(i2, J(t, I & 1048575));
                    }
                    break;
                case 56:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.z(i2, L(t, I & 1048575));
                    }
                    break;
                case 57:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.G(i2, J(t, I & 1048575));
                    }
                    break;
                case 58:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.l(i2, N(t, I & 1048575));
                    }
                    break;
                case 59:
                    if (w(t, i2, i)) {
                        r(i2, j7.r(t, I & 1048575), v7Var);
                    }
                    break;
                case 60:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).d(i2, j7.r(t, I & 1048575), o(i));
                    }
                    break;
                case 61:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.h(i2, (t3) j7.r(t, I & 1048575));
                    }
                    break;
                case 62:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.y(i2, J(t, I & 1048575));
                    }
                    break;
                case 63:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.s(i2, J(t, I & 1048575));
                    }
                    break;
                case 64:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.G(i2, J(t, I & 1048575));
                    }
                    break;
                case 65:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).a.z(i2, L(t, I & 1048575));
                    }
                    break;
                case 66:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).g(i2, J(t, I & 1048575));
                    }
                    break;
                case 67:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).f(i2, L(t, I & 1048575));
                    }
                    break;
                case 68:
                    if (w(t, i2, i)) {
                        ((g4) v7Var).e(i2, j7.r(t, I & 1048575), o(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.p.d(v7Var, entry);
            entry = itL.hasNext() ? (Map.Entry) itL.next() : null;
        }
        s(this.o, t, v7Var);
    }

    /* JADX WARN: Code duplicated, block: B:131:0x03a1 A[PHI: r0 r19 r24 r27
      0x03a1: PHI (r0v21 int) = (r0v17 int), (r0v23 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r19v2 int) = (r19v1 int), (r19v3 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r24v3 int) = (r24v2 int), (r24v4 int) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]
      0x03a1: PHI (r27v7 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:128:0x0387, B:118:0x0340] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    /* JADX WARN: Failed to find 'out' block for switch in B:38:0x009b. Please report as an issue. */
    @Override // b.i.a.f.h.l.q6
    public final void h(T t, byte[] bArr, int i, int i2, s3 s3Var) throws IOException {
        int i3;
        int iJ1;
        int iZ;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        e6<T> e6Var;
        int i7;
        int i8;
        int i9;
        s3 s3Var2;
        e6<T> e6Var2;
        int i10;
        int i11;
        int i12;
        int i13;
        T t2;
        int i14;
        T t3;
        s3 s3Var3;
        e6<T> e6Var3;
        int i15;
        T t4;
        s3 s3Var4;
        s3 s3Var5;
        T t5;
        s3 s3Var6;
        T t6;
        i2 = i2;
        if (!this.i) {
            m(t, bArr, i, i2, 0, s3Var);
            return;
        }
        Unsafe unsafe2 = f1441b;
        int i16 = -1;
        int i17 = 0;
        T t7 = t;
        byte[] bArr2 = bArr;
        int iI1 = i;
        s3 s3Var7 = s3Var;
        e6<T> e6Var4 = this;
        int i18 = -1;
        int i19 = 0;
        int i20 = 1048575;
        int i21 = 0;
        while (iI1 < i2) {
            int i22 = iI1 + 1;
            byte b2 = bArr2[iI1];
            if (b2 < 0) {
                iJ1 = b.i.a.f.e.o.f.J1(b2, bArr2, i22, s3Var7);
                i3 = s3Var7.a;
            } else {
                i3 = b2;
                iJ1 = i22;
            }
            int i23 = i3 >>> 3;
            int i24 = i3 & 7;
            if (i23 > i18) {
                int i25 = i19 / 3;
                if (i23 < e6Var4.e || i23 > e6Var4.f) {
                    i4 = -1;
                } else {
                    iZ = e6Var4.z(i23, i25);
                    i4 = iZ;
                }
            } else if (i23 < e6Var4.e || i23 > e6Var4.f) {
                i4 = -1;
            } else {
                iZ = e6Var4.z(i23, i17);
                i4 = iZ;
            }
            if (i4 == i16) {
                i5 = i23;
                i6 = 0;
            } else {
                int[] iArr = e6Var4.c;
                int i26 = iArr[i4 + 1];
                int i27 = (i26 & 267386880) >>> 20;
                long j = i26 & 1048575;
                e6<T> e6Var5 = e6Var4;
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
                            s3 s3Var8 = s3Var7;
                            bArr2 = bArr2;
                            e6Var = e6Var5;
                            if (i24 != 1) {
                                i6 = i14;
                            } else {
                                j7.d(t8, j, Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr2, iJ1)));
                                iI1 = iJ1 + 8;
                                i7 = i21 | i29;
                                t7 = t8;
                                s3Var7 = s3Var8;
                                unsafe = unsafe2;
                                i19 = i14;
                            }
                            i21 = i7;
                            e6Var4 = e6Var;
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
                            s3Var3 = s3Var7;
                            bArr2 = bArr2;
                            e6Var3 = e6Var5;
                            if (i24 == 5) {
                                j7.e.d(t3, j, Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr2, iJ1)));
                                iI1 = iJ1 + 4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3Var3 = s3Var7;
                            bArr2 = bArr2;
                            T t9 = t7;
                            e6Var3 = e6Var5;
                            if (i24 == 0) {
                                iI1 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var3);
                                unsafe2.putLong(t, j, s3Var3.f1493b);
                                i15 = i21 | i29;
                                t3 = t9;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3Var3 = s3Var7;
                            bArr2 = bArr2;
                            t4 = t7;
                            e6Var3 = e6Var5;
                            if (i24 == 0) {
                                iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var3);
                                unsafe2.putInt(t4, j, s3Var3.a);
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3 s3Var9 = s3Var7;
                            bArr2 = bArr2;
                            T t10 = t7;
                            if (i24 == 1) {
                                e6Var3 = e6Var5;
                                s3Var3 = s3Var9;
                                unsafe2.putLong(t, j, b.i.a.f.e.o.f.o2(bArr2, iJ1));
                                iI1 = iJ1 + 8;
                                t3 = t10;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3Var5 = s3Var7;
                            bArr2 = bArr2;
                            t5 = t7;
                            if (i24 != 5) {
                                i6 = i14;
                            } else {
                                unsafe2.putInt(t5, j, b.i.a.f.e.o.f.N1(bArr2, iJ1));
                                iI1 = iJ1 + 4;
                                i21 |= i29;
                                t7 = t5;
                                s3Var7 = s3Var5;
                                i19 = i14;
                                e6Var4 = e6Var5;
                                i18 = i5;
                                i17 = 0;
                                i16 = -1;
                            }
                            break;
                        case 7:
                            i5 = i23;
                            i14 = i4;
                            s3Var5 = s3Var7;
                            bArr2 = bArr2;
                            t5 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iI1 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var5);
                                j7.e.g(t5, j, s3Var5.f1493b != 0);
                                i21 |= i29;
                                t7 = t5;
                                s3Var7 = s3Var5;
                                i19 = i14;
                                e6Var4 = e6Var5;
                                i18 = i5;
                                i17 = 0;
                                i16 = -1;
                            }
                            break;
                        case 8:
                            i5 = i23;
                            i14 = i4;
                            s3Var4 = s3Var7;
                            bArr2 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                iI1 = (536870912 & i26) == 0 ? b.i.a.f.e.o.f.r2(bArr2, iJ1, s3Var4) : b.i.a.f.e.o.f.t2(bArr2, iJ1, s3Var4);
                                unsafe2.putObject(t4, j, s3Var4.c);
                                s3Var3 = s3Var4;
                                e6Var3 = e6Var5;
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3Var4 = s3Var7;
                            bArr2 = bArr2;
                            t4 = t7;
                            if (i24 == 2) {
                                iI1 = b.i.a.f.e.o.f.M1(e6Var5.o(i14), bArr2, iJ1, i2, s3Var4);
                                Object object = unsafe2.getObject(t4, j);
                                if (object == null) {
                                    e6Var5 = e6Var5;
                                    unsafe2.putObject(t4, j, s3Var4.c);
                                } else {
                                    e6Var5 = e6Var5;
                                    unsafe2.putObject(t4, j, w4.c(object, s3Var4.c));
                                }
                                s3Var3 = s3Var4;
                                e6Var3 = e6Var5;
                                t3 = t4;
                                i15 = i21 | i29;
                                i21 = i15;
                                t7 = t3;
                                s3Var7 = s3Var3;
                                unsafe = unsafe2;
                                i19 = i14;
                                e6Var4 = e6Var3;
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
                            s3Var6 = s3Var7;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 2) {
                                i6 = i14;
                            } else {
                                iI1 = b.i.a.f.e.o.f.v2(bArr2, iJ1, s3Var6);
                                unsafe2.putObject(t6, j, s3Var6.c);
                                i21 |= i29;
                                e6Var2 = e6Var5;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i13 = i14;
                            }
                            break;
                        case 12:
                            i5 = i23;
                            i14 = i4;
                            s3Var6 = s3Var7;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var6);
                                unsafe2.putInt(t6, j, s3Var6.a);
                                i21 |= i29;
                                e6Var2 = e6Var5;
                                t2 = t6;
                                s3Var2 = s3Var6;
                                i13 = i14;
                            }
                            break;
                        case 15:
                            i5 = i23;
                            i14 = i4;
                            s3Var6 = s3Var7;
                            bArr2 = bArr2;
                            t6 = t7;
                            if (i24 != 0) {
                                i6 = i14;
                            } else {
                                iI1 = b.i.a.f.e.o.f.O1(bArr2, iJ1, s3Var6);
                                unsafe2.putInt(t6, j, d4.b(s3Var6.a));
                                i21 |= i29;
                                e6Var2 = e6Var5;
                                t2 = t6;
                                s3Var2 = s3Var6;
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
                                int iN2 = b.i.a.f.e.o.f.n2(bArr2, iJ1, s3Var7);
                                i14 = i4;
                                i5 = i23;
                                s3 s3Var10 = s3Var7;
                                unsafe2.putLong(t, j, d4.a(s3Var7.f1493b));
                                i21 |= i29;
                                iI1 = iN2;
                                t6 = t7;
                                s3Var6 = s3Var10;
                                e6Var5 = e6Var5;
                                e6Var2 = e6Var5;
                                t2 = t6;
                                s3Var2 = s3Var6;
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
                    s3Var2 = s3Var7;
                    e6Var2 = e6Var5;
                    int i31 = i4;
                    if (i27 != 27) {
                        int i32 = iJ1;
                        i8 = i31;
                        if (i27 <= 49) {
                            i10 = i20;
                            i11 = i21;
                            unsafe = unsafe2;
                            iI1 = k(t, bArr, i32, i2, i3, i5, i24, i8, i26, i27, j, s3Var);
                            if (iI1 == i32) {
                                i9 = iI1;
                                i21 = i11;
                                i20 = i10;
                                iI1 = b.i.a.f.e.o.f.I1(i3, bArr, i9, i2, M(t), s3Var);
                                i19 = i8;
                            } else {
                                i19 = i8;
                                i21 = i11;
                                i20 = i10;
                            }
                            e6Var = this;
                            t7 = t;
                            bArr2 = bArr;
                            s3Var7 = s3Var;
                            i7 = i21;
                            i21 = i7;
                            e6Var4 = e6Var;
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
                                iI1 = j(t, bArr, i12, i2, i3, i5, i24, i26, i27, j, i8, s3Var);
                                if (iI1 != i12) {
                                    i19 = i8;
                                    i21 = i11;
                                    i20 = i10;
                                }
                                e6Var = this;
                                t7 = t;
                                bArr2 = bArr;
                                s3Var7 = s3Var;
                                i7 = i21;
                                i21 = i7;
                                e6Var4 = e6Var;
                                i2 = i2;
                                i18 = i5;
                                unsafe2 = unsafe;
                                i17 = 0;
                                i16 = -1;
                            } else if (i24 == 2) {
                                l(t, bArr, i12, i2, i8, j, s3Var);
                                throw null;
                            }
                            i9 = iI1;
                            i21 = i11;
                            i20 = i10;
                            iI1 = b.i.a.f.e.o.f.I1(i3, bArr, i9, i2, M(t), s3Var);
                            i19 = i8;
                            e6Var = this;
                            t7 = t;
                            bArr2 = bArr;
                            s3Var7 = s3Var;
                            i7 = i21;
                            i21 = i7;
                            e6Var4 = e6Var;
                            i2 = i2;
                            i18 = i5;
                            unsafe2 = unsafe;
                            i17 = 0;
                            i16 = -1;
                        }
                    } else if (i24 == 2) {
                        b5 b5VarF = (b5) unsafe2.getObject(t11, j);
                        if (!b5VarF.a()) {
                            int size = b5VarF.size();
                            b5VarF = b5VarF.f(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t11, j, b5VarF);
                        }
                        i13 = i31;
                        t2 = t11;
                        iI1 = b.i.a.f.e.o.f.K1(e6Var2.o(i31), i3, bArr, iJ1, i2, b5VarF, s3Var);
                    } else {
                        i8 = i31;
                        i12 = iJ1;
                        i10 = i20;
                        i11 = i21;
                        unsafe = unsafe2;
                    }
                    iI1 = i12;
                    i9 = iI1;
                    i21 = i11;
                    i20 = i10;
                    iI1 = b.i.a.f.e.o.f.I1(i3, bArr, i9, i2, M(t), s3Var);
                    i19 = i8;
                    e6Var = this;
                    t7 = t;
                    bArr2 = bArr;
                    s3Var7 = s3Var;
                    i7 = i21;
                    i21 = i7;
                    e6Var4 = e6Var;
                    i2 = i2;
                    i18 = i5;
                    unsafe2 = unsafe;
                    i17 = 0;
                    i16 = -1;
                }
                t7 = t2;
                e6Var4 = e6Var2;
                s3Var7 = s3Var2;
                i19 = i13;
                i18 = i5;
                i17 = 0;
                i16 = -1;
            }
            i8 = i6;
            unsafe = unsafe2;
            i9 = iJ1;
            iI1 = b.i.a.f.e.o.f.I1(i3, bArr, i9, i2, M(t), s3Var);
            i19 = i8;
            e6Var = this;
            t7 = t;
            bArr2 = bArr;
            s3Var7 = s3Var;
            i7 = i21;
            i21 = i7;
            e6Var4 = e6Var;
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
        if (iI1 != i2) {
            throw zzij.d();
        }
    }

    @Override // b.i.a.f.h.l.q6
    public final void i(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.c.length; i += 3) {
            int I = I(i);
            long j = 1048575 & I;
            int i2 = this.c[i];
            switch ((I & 267386880) >>> 20) {
                case 0:
                    if (v(t2, i)) {
                        j7.d(t, j, j7.q(t2, j));
                        B(t, i);
                    }
                    break;
                case 1:
                    if (v(t2, i)) {
                        j7.e.d(t, j, j7.n(t2, j));
                        B(t, i);
                    }
                    break;
                case 2:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                    }
                    break;
                case 3:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                    }
                    break;
                case 4:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 5:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                    }
                    break;
                case 6:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 7:
                    if (v(t2, i)) {
                        j7.e.g(t, j, j7.m(t2, j));
                        B(t, i);
                    }
                    break;
                case 8:
                    if (v(t2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        B(t, i);
                    }
                    break;
                case 9:
                    u(t, t2, i);
                    break;
                case 10:
                    if (v(t2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        B(t, i);
                    }
                    break;
                case 11:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 12:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 13:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 14:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                    }
                    break;
                case 15:
                    if (v(t2, i)) {
                        j7.e.e(t, j, j7.b(t2, j));
                        B(t, i);
                    }
                    break;
                case 16:
                    if (v(t2, i)) {
                        j7.e(t, j, j7.i(t2, j));
                        B(t, i);
                    }
                    break;
                case 17:
                    u(t, t2, i);
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
                    this.n.a(t, t2, j);
                    break;
                case 50:
                    v5 v5Var = this.q;
                    Class<?> cls = s6.a;
                    j7.f(t, j, v5Var.f(j7.r(t, j), j7.r(t2, j)));
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
                    if (w(t2, i2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        C(t, i2, i);
                    }
                    break;
                case 60:
                    E(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (w(t2, i2, i)) {
                        j7.f(t, j, j7.r(t2, j));
                        C(t, i2, i);
                    }
                    break;
                case 68:
                    E(t, t2, i);
                    break;
            }
        }
        d7<?, ?> d7Var = this.o;
        Class<?> cls2 = s6.a;
        d7Var.d(t, d7Var.g(d7Var.e(t), d7Var.e(t2)));
        if (this.h) {
            s6.i(this.p, t, t2);
        }
    }

    public final int j(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, s3 s3Var) throws IOException {
        int iN2;
        Unsafe unsafe = f1441b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, i))));
                iN2 = i + 8;
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, i))));
                iN2 = i + 4;
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                unsafe.putObject(t, j, Long.valueOf(s3Var.f1493b));
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                unsafe.putObject(t, j, Integer.valueOf(s3Var.a));
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(b.i.a.f.e.o.f.o2(bArr, i)));
                iN2 = i + 8;
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(b.i.a.f.e.o.f.N1(bArr, i)));
                iN2 = i + 4;
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                unsafe.putObject(t, j, Boolean.valueOf(s3Var.f1493b != 0));
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iO1 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                int i9 = s3Var.a;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !k7.b(bArr, iO1, iO1 + i9)) {
                        throw zzij.e();
                    }
                    unsafe.putObject(t, j, new String(bArr, iO1, i9, w4.a));
                    iO1 += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iO1;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iM1 = b.i.a.f.e.o.f.M1(o(i8), bArr, i, i2, s3Var);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, s3Var.c);
                } else {
                    unsafe.putObject(t, j, w4.c(object, s3Var.c));
                }
                unsafe.putInt(t, j2, i4);
                return iM1;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.v2(bArr, i, s3Var);
                unsafe.putObject(t, j, s3Var.c);
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iO2 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                int i10 = s3Var.a;
                a5 a5Var = (a5) this.d[((i8 / 3) << 1) + 1];
                if (a5Var != null && !a5Var.f(i10)) {
                    M(t).a(i3, Long.valueOf(i10));
                    return iO2;
                }
                unsafe.putObject(t, j, Integer.valueOf(i10));
                iN2 = iO2;
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
                unsafe.putObject(t, j, Integer.valueOf(d4.b(s3Var.a)));
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.n2(bArr, i, s3Var);
                unsafe.putObject(t, j, Long.valueOf(d4.a(s3Var.f1493b)));
                unsafe.putInt(t, j2, i4);
                return iN2;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iN2 = b.i.a.f.e.o.f.L1(o(i8), bArr, i, i2, (i3 & (-8)) | 4, s3Var);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, s3Var.c);
                } else {
                    unsafe.putObject(t, j, w4.c(object2, s3Var.c));
                }
                unsafe.putInt(t, j2, i4);
                return iN2;
            default:
                return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int k(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, s3 s3Var) throws IOException {
        int iH1;
        int iO1 = i;
        Unsafe unsafe = f1441b;
        b5 b5VarF = (b5) unsafe.getObject(t, j2);
        if (!b5VarF.a()) {
            int size = b5VarF.size();
            b5VarF = b5VarF.f(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, b5VarF);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    f4 f4Var = (f4) b5VarF;
                    int iO2 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i8 = s3Var.a + iO2;
                    while (iO2 < i8) {
                        f4Var.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, iO2)));
                        iO2 += 8;
                    }
                    if (iO2 == i8) {
                        return iO2;
                    }
                    throw zzij.a();
                }
                if (i5 == 1) {
                    f4 f4Var2 = (f4) b5VarF;
                    f4Var2.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, i)));
                    while (true) {
                        int i9 = iO1 + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i9, s3Var);
                        if (i3 != s3Var.a) {
                            return i9;
                        }
                        f4Var2.d(Double.longBitsToDouble(b.i.a.f.e.o.f.o2(bArr, iO1)));
                    }
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    t4 t4Var = (t4) b5VarF;
                    int iO3 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i10 = s3Var.a + iO3;
                    while (iO3 < i10) {
                        t4Var.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, iO3)));
                        iO3 += 4;
                    }
                    if (iO3 == i10) {
                        return iO3;
                    }
                    throw zzij.a();
                }
                if (i5 == 5) {
                    t4 t4Var2 = (t4) b5VarF;
                    t4Var2.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, i)));
                    while (true) {
                        int i11 = iO1 + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i11, s3Var);
                        if (i3 != s3Var.a) {
                            return i11;
                        }
                        t4Var2.d(Float.intBitsToFloat(b.i.a.f.e.o.f.N1(bArr, iO1)));
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    q5 q5Var = (q5) b5VarF;
                    int iO4 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i12 = s3Var.a + iO4;
                    while (iO4 < i12) {
                        iO4 = b.i.a.f.e.o.f.n2(bArr, iO4, s3Var);
                        q5Var.d(s3Var.f1493b);
                    }
                    if (iO4 == i12) {
                        return iO4;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    q5 q5Var2 = (q5) b5VarF;
                    int iN2 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    q5Var2.d(s3Var.f1493b);
                    while (iN2 < i2) {
                        int iO5 = b.i.a.f.e.o.f.O1(bArr, iN2, s3Var);
                        if (i3 != s3Var.a) {
                            return iN2;
                        }
                        iN2 = b.i.a.f.e.o.f.n2(bArr, iO5, s3Var);
                        q5Var2.d(s3Var.f1493b);
                    }
                    return iN2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return b.i.a.f.e.o.f.P1(bArr, iO1, b5VarF, s3Var);
                }
                if (i5 == 0) {
                    return b.i.a.f.e.o.f.H1(i3, bArr, i, i2, b5VarF, s3Var);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    q5 q5Var3 = (q5) b5VarF;
                    int iO6 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i13 = s3Var.a + iO6;
                    while (iO6 < i13) {
                        q5Var3.d(b.i.a.f.e.o.f.o2(bArr, iO6));
                        iO6 += 8;
                    }
                    if (iO6 == i13) {
                        return iO6;
                    }
                    throw zzij.a();
                }
                if (i5 == 1) {
                    q5 q5Var4 = (q5) b5VarF;
                    q5Var4.d(b.i.a.f.e.o.f.o2(bArr, i));
                    while (true) {
                        int i14 = iO1 + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i14, s3Var);
                        if (i3 != s3Var.a) {
                            return i14;
                        }
                        q5Var4.d(b.i.a.f.e.o.f.o2(bArr, iO1));
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    x4 x4Var = (x4) b5VarF;
                    int iO7 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i15 = s3Var.a + iO7;
                    while (iO7 < i15) {
                        x4Var.g(b.i.a.f.e.o.f.N1(bArr, iO7));
                        iO7 += 4;
                    }
                    if (iO7 == i15) {
                        return iO7;
                    }
                    throw zzij.a();
                }
                if (i5 == 5) {
                    x4 x4Var2 = (x4) b5VarF;
                    x4Var2.g(b.i.a.f.e.o.f.N1(bArr, i));
                    while (true) {
                        int i16 = iO1 + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iO1 = b.i.a.f.e.o.f.O1(bArr, i16, s3Var);
                        if (i3 != s3Var.a) {
                            return i16;
                        }
                        x4Var2.g(b.i.a.f.e.o.f.N1(bArr, iO1));
                    }
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    r3 r3Var = (r3) b5VarF;
                    int iO8 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i17 = s3Var.a + iO8;
                    while (iO8 < i17) {
                        iO8 = b.i.a.f.e.o.f.n2(bArr, iO8, s3Var);
                        r3Var.d(s3Var.f1493b != 0);
                    }
                    if (iO8 == i17) {
                        return iO8;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    r3 r3Var2 = (r3) b5VarF;
                    int iN3 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    r3Var2.d(s3Var.f1493b != 0);
                    while (iN3 < i2) {
                        int iO9 = b.i.a.f.e.o.f.O1(bArr, iN3, s3Var);
                        if (i3 != s3Var.a) {
                            return iN3;
                        }
                        iN3 = b.i.a.f.e.o.f.n2(bArr, iO9, s3Var);
                        r3Var2.d(s3Var.f1493b != 0);
                    }
                    return iN3;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & Permission.MANAGE_WEBHOOKS) != 0) {
                        iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        int i18 = s3Var.a;
                        if (i18 < 0) {
                            throw zzij.b();
                        }
                        if (i18 == 0) {
                            b5VarF.add("");
                        } else {
                            int i19 = iO1 + i18;
                            if (!k7.b(bArr, iO1, i19)) {
                                throw zzij.e();
                            }
                            b5VarF.add(new String(bArr, iO1, i18, w4.a));
                            iO1 = i19;
                        }
                        while (iO1 < i2) {
                            int iO10 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                            if (i3 != s3Var.a) {
                                break;
                            } else {
                                iO1 = b.i.a.f.e.o.f.O1(bArr, iO10, s3Var);
                                int i20 = s3Var.a;
                                if (i20 < 0) {
                                    throw zzij.b();
                                }
                                if (i20 == 0) {
                                    b5VarF.add("");
                                } else {
                                    int i21 = iO1 + i20;
                                    if (!k7.b(bArr, iO1, i21)) {
                                        throw zzij.e();
                                    }
                                    b5VarF.add(new String(bArr, iO1, i20, w4.a));
                                    iO1 = i21;
                                }
                            }
                        }
                    } else {
                        iO1 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        int i22 = s3Var.a;
                        if (i22 < 0) {
                            throw zzij.b();
                        }
                        if (i22 == 0) {
                            b5VarF.add("");
                        } else {
                            b5VarF.add(new String(bArr, iO1, i22, w4.a));
                            iO1 += i22;
                        }
                        while (iO1 < i2) {
                            int iO11 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                            if (i3 != s3Var.a) {
                                break;
                            } else {
                                iO1 = b.i.a.f.e.o.f.O1(bArr, iO11, s3Var);
                                int i23 = s3Var.a;
                                if (i23 < 0) {
                                    throw zzij.b();
                                }
                                if (i23 == 0) {
                                    b5VarF.add("");
                                } else {
                                    b5VarF.add(new String(bArr, iO1, i23, w4.a));
                                    iO1 += i23;
                                }
                            }
                        }
                    }
                }
                break;
            case 27:
                if (i5 == 2) {
                    return b.i.a.f.e.o.f.K1(o(i6), i3, bArr, i, i2, b5VarF, s3Var);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iO12 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i24 = s3Var.a;
                    if (i24 < 0) {
                        throw zzij.b();
                    }
                    if (i24 > bArr.length - iO12) {
                        throw zzij.a();
                    }
                    if (i24 == 0) {
                        b5VarF.add(t3.j);
                    } else {
                        b5VarF.add(t3.h(bArr, iO12, i24));
                        iO12 += i24;
                    }
                    while (iO12 < i2) {
                        int iO13 = b.i.a.f.e.o.f.O1(bArr, iO12, s3Var);
                        if (i3 != s3Var.a) {
                            return iO12;
                        }
                        iO12 = b.i.a.f.e.o.f.O1(bArr, iO13, s3Var);
                        int i25 = s3Var.a;
                        if (i25 < 0) {
                            throw zzij.b();
                        }
                        if (i25 > bArr.length - iO12) {
                            throw zzij.a();
                        }
                        if (i25 == 0) {
                            b5VarF.add(t3.j);
                        } else {
                            b5VarF.add(t3.h(bArr, iO12, i25));
                            iO12 += i25;
                        }
                    }
                    return iO12;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iH1 = b.i.a.f.e.o.f.P1(bArr, iO1, b5VarF, s3Var);
                } else if (i5 == 0) {
                    iH1 = b.i.a.f.e.o.f.H1(i3, bArr, i, i2, b5VarF, s3Var);
                }
                u4 u4Var = (u4) t;
                Object objA = u4Var.zzb;
                if (objA == c7.a) {
                    objA = null;
                }
                a5 a5Var = (a5) this.d[((i6 / 3) << 1) + 1];
                d7<?, ?> d7Var = this.o;
                Class<?> cls = s6.a;
                if (a5Var != null) {
                    if (b5VarF instanceof RandomAccess) {
                        int size2 = b5VarF.size();
                        int i26 = 0;
                        for (int i27 = 0; i27 < size2; i27++) {
                            int iIntValue = ((Integer) b5VarF.get(i27)).intValue();
                            if (a5Var.f(iIntValue)) {
                                if (i27 != i26) {
                                    b5VarF.set(i26, Integer.valueOf(iIntValue));
                                }
                                i26++;
                            } else {
                                if (objA == null) {
                                    objA = d7Var.a();
                                }
                                d7Var.b(objA, i4, iIntValue);
                            }
                        }
                        if (i26 != size2) {
                            b5VarF.subList(i26, size2).clear();
                        }
                    } else {
                        Iterator<E> it = b5VarF.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!a5Var.f(iIntValue2)) {
                                if (objA == null) {
                                    objA = d7Var.a();
                                }
                                d7Var.b(objA, i4, iIntValue2);
                                it.remove();
                            }
                        }
                    }
                }
                c7 c7Var = (c7) objA;
                if (c7Var != null) {
                    u4Var.zzb = c7Var;
                }
                return iH1;
            case 33:
            case 47:
                if (i5 == 2) {
                    x4 x4Var3 = (x4) b5VarF;
                    int iO14 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i28 = s3Var.a + iO14;
                    while (iO14 < i28) {
                        iO14 = b.i.a.f.e.o.f.O1(bArr, iO14, s3Var);
                        x4Var3.g(d4.b(s3Var.a));
                    }
                    if (iO14 == i28) {
                        return iO14;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    x4 x4Var4 = (x4) b5VarF;
                    int iO15 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    x4Var4.g(d4.b(s3Var.a));
                    while (iO15 < i2) {
                        int iO16 = b.i.a.f.e.o.f.O1(bArr, iO15, s3Var);
                        if (i3 != s3Var.a) {
                            return iO15;
                        }
                        iO15 = b.i.a.f.e.o.f.O1(bArr, iO16, s3Var);
                        x4Var4.g(d4.b(s3Var.a));
                    }
                    return iO15;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    q5 q5Var5 = (q5) b5VarF;
                    int iO17 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                    int i29 = s3Var.a + iO17;
                    while (iO17 < i29) {
                        iO17 = b.i.a.f.e.o.f.n2(bArr, iO17, s3Var);
                        q5Var5.d(d4.a(s3Var.f1493b));
                    }
                    if (iO17 == i29) {
                        return iO17;
                    }
                    throw zzij.a();
                }
                if (i5 == 0) {
                    q5 q5Var6 = (q5) b5VarF;
                    int iN4 = b.i.a.f.e.o.f.n2(bArr, iO1, s3Var);
                    q5Var6.d(d4.a(s3Var.f1493b));
                    while (iN4 < i2) {
                        int iO18 = b.i.a.f.e.o.f.O1(bArr, iN4, s3Var);
                        if (i3 != s3Var.a) {
                            return iN4;
                        }
                        iN4 = b.i.a.f.e.o.f.n2(bArr, iO18, s3Var);
                        q5Var6.d(d4.a(s3Var.f1493b));
                    }
                    return iN4;
                }
                break;
            case 49:
                if (i5 == 3) {
                    q6 q6VarO = o(i6);
                    int i30 = (i3 & (-8)) | 4;
                    iO1 = b.i.a.f.e.o.f.L1(q6VarO, bArr, i, i2, i30, s3Var);
                    b5VarF.add(s3Var.c);
                    while (iO1 < i2) {
                        int iO19 = b.i.a.f.e.o.f.O1(bArr, iO1, s3Var);
                        if (i3 == s3Var.a) {
                            iO1 = b.i.a.f.e.o.f.L1(q6VarO, bArr, iO19, i2, i30, s3Var);
                            b5VarF.add(s3Var.c);
                        }
                    }
                }
                break;
        }
        return iO1;
    }

    public final <K, V> int l(T t, byte[] bArr, int i, int i2, int i3, long j, s3 s3Var) throws IOException {
        Unsafe unsafe = f1441b;
        Object obj = this.d[(i3 / 3) << 1];
        Object object = unsafe.getObject(t, j);
        if (this.q.d(object)) {
            Object objH = this.q.h(obj);
            this.q.f(objH, object);
            unsafe.putObject(t, j, objH);
            object = objH;
        }
        t5<?, ?> t5VarG = this.q.g(obj);
        this.q.b(object);
        int iO1 = b.i.a.f.e.o.f.O1(bArr, i, s3Var);
        int i4 = s3Var.a;
        if (i4 < 0 || i4 > i2 - iO1) {
            throw zzij.a();
        }
        Objects.requireNonNull(t5VarG);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 14621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int m(T r31, byte[] r32, int r33, int r34, int r35, b.i.a.f.h.l.s3 r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.f.h.l.e6.m(java.lang.Object, byte[], int, int, int, b.i.a.f.h.l.s3):int");
    }

    public final q6 o(int i) {
        int i2 = (i / 3) << 1;
        Object[] objArr = this.d;
        q6 q6Var = (q6) objArr[i2];
        if (q6Var != null) {
            return q6Var;
        }
        q6<T> q6VarA = n6.a.a((Class) objArr[i2 + 1]);
        this.d[i2] = q6VarA;
        return q6VarA;
    }

    public final <K, V> void t(v7 v7Var, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            this.q.g(this.d[(i2 / 3) << 1]);
            Map<?, ?> mapE = this.q.e(obj);
            g4 g4Var = (g4) v7Var;
            Objects.requireNonNull(g4Var);
            Iterator<Map.Entry<?, ?>> it = mapE.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                g4Var.a.f(i, 2);
                next.getKey();
                next.getValue();
                Objects.requireNonNull(null);
                throw null;
            }
        }
    }

    public final void u(T t, T t2, int i) {
        long j = this.c[i + 1] & 1048575;
        if (v(t2, i)) {
            Object objR = j7.r(t, j);
            Object objR2 = j7.r(t2, j);
            if (objR != null && objR2 != null) {
                j7.f(t, j, w4.c(objR, objR2));
                B(t, i);
            } else if (objR2 != null) {
                j7.f(t, j, objR2);
                B(t, i);
            }
        }
    }

    public final boolean v(T t, int i) {
        int[] iArr = this.c;
        int i2 = iArr[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return (j7.b(t, j) & (1 << (i2 >>> 20))) != 0;
        }
        int i3 = iArr[i + 1];
        long j2 = i3 & 1048575;
        switch ((i3 & 267386880) >>> 20) {
            case 0:
                return j7.q(t, j2) != 0.0d;
            case 1:
                return j7.n(t, j2) != 0.0f;
            case 2:
                return j7.i(t, j2) != 0;
            case 3:
                return j7.i(t, j2) != 0;
            case 4:
                return j7.b(t, j2) != 0;
            case 5:
                return j7.i(t, j2) != 0;
            case 6:
                return j7.b(t, j2) != 0;
            case 7:
                return j7.m(t, j2);
            case 8:
                Object objR = j7.r(t, j2);
                if (objR instanceof String) {
                    return !((String) objR).isEmpty();
                }
                if (objR instanceof t3) {
                    return !t3.j.equals(objR);
                }
                throw new IllegalArgumentException();
            case 9:
                return j7.r(t, j2) != null;
            case 10:
                return !t3.j.equals(j7.r(t, j2));
            case 11:
                return j7.b(t, j2) != 0;
            case 12:
                return j7.b(t, j2) != 0;
            case 13:
                return j7.b(t, j2) != 0;
            case 14:
                return j7.i(t, j2) != 0;
            case 15:
                return j7.b(t, j2) != 0;
            case 16:
                return j7.i(t, j2) != 0;
            case 17:
                return j7.r(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean w(T t, int i, int i2) {
        return j7.b(t, (long) (this.c[i2 + 2] & 1048575)) == i;
    }

    public final boolean x(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return v(t, i);
        }
        return (i3 & i4) != 0;
    }

    public final int z(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.c[i4];
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
