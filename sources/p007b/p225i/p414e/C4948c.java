package p007b.p225i.p414e;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4969h;

/* JADX INFO: renamed from: b.i.e.c */
/* JADX INFO: compiled from: BinaryBitmap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4948c {

    /* JADX INFO: renamed from: a */
    public final AbstractC4947b f13171a;

    /* JADX INFO: renamed from: b */
    public C4963b f13172b;

    public C4948c(AbstractC4947b abstractC4947b) {
        this.f13171a = abstractC4947b;
    }

    /* JADX INFO: renamed from: a */
    public C4963b m6913a() throws NotFoundException {
        int i;
        C4948c c4948c = this;
        if (c4948c.f13172b == null) {
            C4969h c4969h = (C4969h) c4948c.f13171a;
            C4963b c4963b = c4969h.f13280e;
            if (c4963b == null) {
                AbstractC4951f abstractC4951f = c4969h.f13170a;
                int i2 = abstractC4951f.f13186a;
                int i3 = abstractC4951f.f13187b;
                if (i2 < 40 || i3 < 40) {
                    C4963b c4963b2 = new C4963b(i2, i3);
                    c4969h.m6953b(i2);
                    int[] iArr = c4969h.f13279d;
                    for (int i4 = 1; i4 < 5; i4++) {
                        byte[] bArrMo6916b = abstractC4951f.mo6916b((i3 * i4) / 5, c4969h.f13278c);
                        int i5 = (i2 << 2) / 5;
                        for (int i6 = i2 / 5; i6 < i5; i6++) {
                            int i7 = (bArrMo6916b[i6] & 255) >> 3;
                            iArr[i7] = iArr[i7] + 1;
                        }
                    }
                    int iM6952a = C4969h.m6952a(iArr);
                    byte[] bArrMo6915a = abstractC4951f.mo6915a();
                    for (int i8 = 0; i8 < i3; i8++) {
                        int i9 = i8 * i2;
                        for (int i10 = 0; i10 < i2; i10++) {
                            if ((bArrMo6915a[i9 + i10] & 255) < iM6952a) {
                                c4963b2.m6946j(i10, i8);
                            }
                        }
                    }
                    c4969h.f13280e = c4963b2;
                } else {
                    byte[] bArrMo6915a2 = abstractC4951f.mo6915a();
                    int i11 = i2 >> 3;
                    if ((i2 & 7) != 0) {
                        i11++;
                    }
                    int i12 = i3 >> 3;
                    if ((i3 & 7) != 0) {
                        i12++;
                    }
                    int i13 = i3 - 8;
                    int i14 = i2 - 8;
                    int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, i12, i11);
                    int i15 = 0;
                    while (true) {
                        int i16 = 8;
                        if (i15 >= i12) {
                            break;
                        }
                        int i17 = i15 << 3;
                        if (i17 > i13) {
                            i17 = i13;
                        }
                        int i18 = 0;
                        while (i18 < i11) {
                            int i19 = i18 << 3;
                            if (i19 > i14) {
                                i19 = i14;
                            }
                            int i20 = (i17 * i2) + i19;
                            int i21 = 0;
                            int i22 = 0;
                            int i23 = 255;
                            int i24 = 0;
                            while (i21 < i16) {
                                int i25 = i17;
                                int i26 = i21;
                                int i27 = i23;
                                int i28 = i24;
                                int i29 = 0;
                                while (i29 < i16) {
                                    int i30 = bArrMo6915a2[i20 + i29] & 255;
                                    i22 += i30;
                                    if (i30 < i27) {
                                        i27 = i30;
                                    }
                                    if (i30 > i28) {
                                        i28 = i30;
                                    }
                                    i29++;
                                    i16 = 8;
                                }
                                if (i28 - i27 > 24) {
                                    i = i26;
                                    while (true) {
                                        i++;
                                        i20 += i2;
                                        if (i >= 8) {
                                            break;
                                        }
                                        int i31 = 0;
                                        for (int i32 = 8; i31 < i32; i32 = 8) {
                                            i22 += bArrMo6915a2[i20 + i31] & 255;
                                            i31++;
                                            i27 = i27;
                                        }
                                    }
                                    i23 = i27;
                                } else {
                                    i23 = i27;
                                    i = i26;
                                }
                                i21 = i + 1;
                                i20 += i2;
                                i16 = 8;
                                i24 = i28;
                                i17 = i25;
                            }
                            int i33 = i17;
                            int i34 = i22 >> 6;
                            int i35 = i23;
                            if (i24 - i35 <= 24) {
                                i34 = i35 / 2;
                                if (i15 > 0 && i18 > 0) {
                                    int i36 = i15 - 1;
                                    int i37 = i18 - 1;
                                    int i38 = (((iArr2[i15][i37] * 2) + iArr2[i36][i18]) + iArr2[i36][i37]) / 4;
                                    if (i35 < i38) {
                                        i34 = i38;
                                    }
                                }
                            }
                            iArr2[i15][i18] = i34;
                            i18++;
                            i17 = i33;
                            i16 = 8;
                        }
                        i15++;
                    }
                    C4963b c4963b3 = new C4963b(i2, i3);
                    for (int i39 = 0; i39 < i12; i39++) {
                        int i40 = i39 << 3;
                        if (i40 > i13) {
                            i40 = i13;
                        }
                        int i41 = i12 - 3;
                        if (i39 < 2) {
                            i41 = 2;
                        } else if (i39 <= i41) {
                            i41 = i39;
                        }
                        int i42 = 0;
                        while (i42 < i11) {
                            int i43 = i42 << 3;
                            if (i43 > i14) {
                                i43 = i14;
                            }
                            int i44 = i11 - 3;
                            if (i42 < 2) {
                                i44 = 2;
                            } else if (i42 <= i44) {
                                i44 = i42;
                            }
                            int i45 = i11;
                            int i46 = -2;
                            int i47 = 0;
                            for (int i48 = 2; i46 <= i48; i48 = 2) {
                                int[] iArr3 = iArr2[i41 + i46];
                                i47 = iArr3[i44 - 2] + iArr3[i44 - 1] + iArr3[i44] + iArr3[i44 + 1] + iArr3[i44 + 2] + i47;
                                i46++;
                            }
                            int i49 = i47 / 25;
                            int i50 = (i40 * i2) + i43;
                            int i51 = i41;
                            int i52 = 8;
                            int i53 = 0;
                            while (i53 < i52) {
                                int i54 = i12;
                                int i55 = 0;
                                while (i55 < i52) {
                                    byte[] bArr = bArrMo6915a2;
                                    if ((bArrMo6915a2[i50 + i55] & 255) <= i49) {
                                        c4963b3.m6946j(i43 + i55, i40 + i53);
                                    }
                                    i55++;
                                    bArrMo6915a2 = bArr;
                                    i52 = 8;
                                }
                                i53++;
                                i50 += i2;
                                i12 = i54;
                                i52 = 8;
                            }
                            i42++;
                            i41 = i51;
                            i11 = i45;
                        }
                    }
                    c4969h.f13280e = c4963b3;
                }
                c4963b = c4969h.f13280e;
            }
            c4948c = this;
            c4948c.f13172b = c4963b;
        }
        return c4948c.f13172b;
    }

    /* JADX INFO: renamed from: b */
    public C4962a m6914b(int i, C4962a c4962a) throws NotFoundException {
        int i2;
        C4969h c4969h = (C4969h) this.f13171a;
        AbstractC4951f abstractC4951f = c4969h.f13170a;
        int i3 = abstractC4951f.f13186a;
        if (c4962a.f13228k < i3) {
            c4962a = new C4962a(i3);
        } else {
            int length = c4962a.f13227j.length;
            for (int i4 = 0; i4 < length; i4++) {
                c4962a.f13227j[i4] = 0;
            }
        }
        c4969h.m6953b(i3);
        byte[] bArrMo6916b = abstractC4951f.mo6916b(i, c4969h.f13278c);
        int[] iArr = c4969h.f13279d;
        int i5 = 0;
        while (true) {
            i2 = 1;
            if (i5 >= i3) {
                break;
            }
            int i6 = (bArrMo6916b[i5] & 255) >> 3;
            iArr[i6] = iArr[i6] + 1;
            i5++;
        }
        int iM6952a = C4969h.m6952a(iArr);
        if (i3 < 3) {
            for (int i7 = 0; i7 < i3; i7++) {
                if ((bArrMo6916b[i7] & 255) < iM6952a) {
                    c4962a.m6940j(i7);
                }
            }
        } else {
            int i8 = bArrMo6916b[0] & 255;
            int i9 = bArrMo6916b[1] & 255;
            while (i2 < i3 - 1) {
                int i10 = i2 + 1;
                int i11 = bArrMo6916b[i10] & 255;
                if ((((i9 << 2) - i8) - i11) / 2 < iM6952a) {
                    c4962a.m6940j(i2);
                }
                i8 = i9;
                i2 = i10;
                i9 = i11;
            }
        }
        return c4962a;
    }

    public String toString() {
        try {
            return m6913a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
