package p007b.p225i.p414e.p434s;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.InterfaceC4957l;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4966e;
import p007b.p225i.p414e.p418n.C4967f;
import p007b.p225i.p414e.p418n.C4970i;
import p007b.p225i.p414e.p434s.p435b.C5053e;
import p007b.p225i.p414e.p434s.p435b.C5057i;
import p007b.p225i.p414e.p434s.p435b.C5058j;
import p007b.p225i.p414e.p434s.p436c.C5059a;
import p007b.p225i.p414e.p434s.p436c.C5061c;
import p007b.p225i.p414e.p434s.p436c.C5062d;
import p007b.p225i.p414e.p434s.p436c.C5063e;
import p007b.p225i.p414e.p434s.p436c.C5064f;

/* JADX INFO: renamed from: b.i.e.s.a */
/* JADX INFO: compiled from: QRCodeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5048a implements InterfaceC4954i {

    /* JADX INFO: renamed from: a */
    public static final C4956k[] f13508a = new C4956k[0];

    /* JADX INFO: renamed from: b */
    public final C5053e f13509b = new C5053e();

    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public final Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i;
        C5059a c5059aM7110b;
        float f;
        float f2;
        float f3;
        C4966e c4966eM7097a;
        C4956k[] c4956kArr;
        int i2;
        int i3;
        if (map == null || !map.containsKey(EnumC4949d.PURE_BARCODE)) {
            C4963b c4963bM6913a = c4948c.m6913a();
            C5061c c5061c = new C5061c(c4963bM6913a);
            InterfaceC4957l interfaceC4957l = map == null ? null : (InterfaceC4957l) map.get(EnumC4949d.NEED_RESULT_POINT_CALLBACK);
            c5061c.f13569b = interfaceC4957l;
            C5063e c5063e = new C5063e(c4963bM6913a, interfaceC4957l);
            boolean z2 = map != null && map.containsKey(EnumC4949d.TRY_HARDER);
            int i4 = c4963bM6913a.f13230k;
            int i5 = c4963bM6913a.f13229j;
            int i6 = (i4 * 3) / 388;
            if (i6 < 3 || z2) {
                i6 = 3;
            }
            int[] iArr = new int[5];
            int i7 = i6 - 1;
            boolean zM7118f = false;
            while (true) {
                int i8 = 4;
                if (i7 >= i4 || zM7118f) {
                    break;
                }
                c5063e.m7115b(iArr);
                int i9 = 0;
                int i10 = 0;
                while (i9 < i5) {
                    if (c5063e.f13572a.m6942f(i9, i7)) {
                        if ((i10 & 1) == 1) {
                            i10++;
                        }
                        iArr[i10] = iArr[i10] + 1;
                    } else if ((i10 & 1) != 0) {
                        iArr[i10] = iArr[i10] + 1;
                    } else if (i10 != i8) {
                        i10++;
                        iArr[i10] = iArr[i10] + 1;
                    } else if (C5063e.m7114c(iArr) && c5063e.m7117e(iArr, i7, i9)) {
                        if (c5063e.f13574c) {
                            zM7118f = c5063e.m7118f();
                        } else {
                            if (c5063e.f13573b.size() <= 1) {
                                i2 = 2;
                                i3 = 0;
                                break;
                            }
                            Iterator<C5062d> it = c5063e.f13573b.iterator();
                            C5062d c5062d = null;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = 2;
                                    i3 = 0;
                                    break;
                                }
                                C5062d next = it.next();
                                if (next.f13571d >= 2) {
                                    if (c5062d != null) {
                                        c5063e.f13574c = true;
                                        int iAbs = (int) (Math.abs(c5062d.f13207a - next.f13207a) - Math.abs(c5062d.f13208b - next.f13208b));
                                        i2 = 2;
                                        i3 = iAbs / 2;
                                        break;
                                    }
                                    c5062d = next;
                                }
                            }
                            if (i3 > iArr[i2]) {
                                i7 += (i3 - iArr[i2]) - i2;
                                i9 = i5 - 1;
                            }
                        }
                        c5063e.m7115b(iArr);
                        i6 = 2;
                        i10 = 0;
                    } else {
                        c5063e.m7119g(iArr);
                        i10 = 3;
                    }
                    i9++;
                    i8 = 4;
                }
                if (C5063e.m7114c(iArr) && c5063e.m7117e(iArr, i7, i5)) {
                    i6 = iArr[0];
                    if (c5063e.f13574c) {
                        zM7118f = c5063e.m7118f();
                    }
                }
                i7 += i6;
            }
            int size = c5063e.f13573b.size();
            if (size < 3) {
                throw NotFoundException.f21665l;
            }
            float f4 = 0.0f;
            if (size > 3) {
                Iterator<C5062d> it2 = c5063e.f13573b.iterator();
                float f5 = 0.0f;
                float f6 = 0.0f;
                while (it2.hasNext()) {
                    float f7 = it2.next().f13570c;
                    f5 += f7;
                    f6 += f7 * f7;
                }
                float f8 = size;
                float f9 = f5 / f8;
                float fSqrt = (float) Math.sqrt((f6 / f8) - (f9 * f9));
                Collections.sort(c5063e.f13573b, new C5063e.c(f9, null));
                float fMax = Math.max(0.2f * f9, fSqrt);
                int i11 = 0;
                while (i11 < c5063e.f13573b.size() && c5063e.f13573b.size() > 3) {
                    if (Math.abs(c5063e.f13573b.get(i11).f13570c - f9) > fMax) {
                        c5063e.f13573b.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (c5063e.f13573b.size() > 3) {
                Iterator<C5062d> it3 = c5063e.f13573b.iterator();
                while (it3.hasNext()) {
                    f4 += it3.next().f13570c;
                }
                Collections.sort(c5063e.f13573b, new C5063e.b(f4 / c5063e.f13573b.size(), null));
                List<C5062d> list = c5063e.f13573b;
                i = 3;
                list.subList(3, list.size()).clear();
            } else {
                i = 3;
            }
            C5062d[] c5062dArr = new C5062d[i];
            c5062dArr[0] = c5063e.f13573b.get(0);
            c5062dArr[1] = c5063e.f13573b.get(1);
            c5062dArr[2] = c5063e.f13573b.get(2);
            C4956k.m6923b(c5062dArr);
            C5064f c5064f = new C5064f(c5062dArr);
            C5062d c5062d2 = c5064f.f13578b;
            C5062d c5062d3 = c5064f.f13579c;
            C5062d c5062d4 = c5064f.f13577a;
            float fM7109a = (c5061c.m7109a(c5062d2, c5062d4) + c5061c.m7109a(c5062d2, c5062d3)) / 2.0f;
            if (fM7109a < 1.0f) {
                throw NotFoundException.f21665l;
            }
            int iM4265Z0 = ((C3404f.m4265Z0(C3404f.m4237Q(c5062d2.f13207a, c5062d2.f13208b, c5062d4.f13207a, c5062d4.f13208b) / fM7109a) + C3404f.m4265Z0(C3404f.m4237Q(c5062d2.f13207a, c5062d2.f13208b, c5062d3.f13207a, c5062d3.f13208b) / fM7109a)) / 2) + 7;
            int i12 = iM4265Z0 & 3;
            if (i12 == 0) {
                iM4265Z0++;
            } else if (i12 == 2) {
                iM4265Z0--;
            } else if (i12 == 3) {
                throw NotFoundException.f21665l;
            }
            int[] iArr2 = C5058j.f13548a;
            if (iM4265Z0 % 4 != 1) {
                throw FormatException.m9260a();
            }
            try {
                C5058j c5058jM7104d = C5058j.m7104d((iM4265Z0 - 17) / 4);
                int iM7105c = c5058jM7104d.m7105c() - 7;
                if (c5058jM7104d.f13551d.length <= 0) {
                    c5059aM7110b = null;
                    break;
                }
                float f10 = c5062d3.f13207a;
                float f11 = c5062d2.f13207a;
                float f12 = (f10 - f11) + c5062d4.f13207a;
                float f13 = c5062d3.f13208b;
                float f14 = c5062d2.f13208b;
                float f15 = (f13 - f14) + c5062d4.f13208b;
                float f16 = 1.0f - (3.0f / iM7105c);
                int iM839a = (int) C1643a.m839a(f12, f11, f16, f11);
                int iM839a2 = (int) C1643a.m839a(f15, f14, f16, f14);
                int i13 = 4;
                while (true) {
                    if (i13 > 16) {
                        c5059aM7110b = null;
                        break;
                    }
                    try {
                        c5059aM7110b = c5061c.m7110b(fM7109a, iM839a, iM839a2, i13);
                        break;
                    } catch (NotFoundException unused) {
                        i13 <<= 1;
                    }
                }
                float f17 = iM4265Z0 - 3.5f;
                if (c5059aM7110b != null) {
                    f = c5059aM7110b.f13207a;
                    f2 = c5059aM7110b.f13208b;
                    f3 = f17 - 3.0f;
                } else {
                    f = (c5062d3.f13207a - c5062d2.f13207a) + c5062d4.f13207a;
                    f2 = (c5062d3.f13208b - c5062d2.f13208b) + c5062d4.f13208b;
                    f3 = f17;
                }
                C4963b c4963bM6951a = C4967f.f13274a.m6951a(c5061c.f13568a, iM4265Z0, iM4265Z0, C4970i.m6954a(3.5f, 3.5f, f17, 3.5f, f3, f3, 3.5f, f17, c5062d2.f13207a, c5062d2.f13208b, c5062d3.f13207a, c5062d3.f13208b, f, f2, c5062d4.f13207a, c5062d4.f13208b));
                C4956k[] c4956kArr2 = c5059aM7110b == null ? new C4956k[]{c5062d4, c5062d2, c5062d3} : new C4956k[]{c5062d4, c5062d2, c5062d3, c5059aM7110b};
                c4966eM7097a = this.f13509b.m7097a(c4963bM6951a, map);
                c4956kArr = c4956kArr2;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.m9260a();
            }
        } else {
            C4963b c4963bM6913a2 = c4948c.m6913a();
            int[] iArrM6945i = c4963bM6913a2.m6945i();
            int[] iArrM6943g = c4963bM6913a2.m6943g();
            if (iArrM6945i == null || iArrM6943g == null) {
                throw NotFoundException.f21665l;
            }
            int i14 = c4963bM6913a2.f13230k;
            int i15 = c4963bM6913a2.f13229j;
            int i16 = iArrM6945i[0];
            int i17 = iArrM6945i[1];
            boolean z3 = true;
            int i18 = 0;
            while (i16 < i15 && i17 < i14) {
                if (z3 != c4963bM6913a2.m6942f(i16, i17)) {
                    i18++;
                    if (i18 == 5) {
                        break;
                    }
                    z3 = !z3;
                }
                i16++;
                i17++;
            }
            if (i16 == i15 || i17 == i14) {
                throw NotFoundException.f21665l;
            }
            float f18 = (i16 - iArrM6945i[0]) / 7.0f;
            int i19 = iArrM6945i[1];
            int i20 = iArrM6943g[1];
            int i21 = iArrM6945i[0];
            int i22 = iArrM6943g[0];
            if (i21 >= i22 || i19 >= i20) {
                throw NotFoundException.f21665l;
            }
            int i23 = i20 - i19;
            if (i23 != i22 - i21 && (i22 = i21 + i23) >= c4963bM6913a2.f13229j) {
                throw NotFoundException.f21665l;
            }
            int iRound = Math.round(((i22 - i21) + 1) / f18);
            int iRound2 = Math.round((i23 + 1) / f18);
            if (iRound <= 0 || iRound2 <= 0) {
                throw NotFoundException.f21665l;
            }
            if (iRound2 != iRound) {
                throw NotFoundException.f21665l;
            }
            int i24 = (int) (f18 / 2.0f);
            int i25 = i19 + i24;
            int i26 = i21 + i24;
            int i27 = (((int) ((iRound - 1) * f18)) + i26) - i22;
            if (i27 > 0) {
                if (i27 > i24) {
                    throw NotFoundException.f21665l;
                }
                i26 -= i27;
            }
            int i28 = (((int) ((iRound2 - 1) * f18)) + i25) - i20;
            if (i28 > 0) {
                if (i28 > i24) {
                    throw NotFoundException.f21665l;
                }
                i25 -= i28;
            }
            C4963b c4963b = new C4963b(iRound, iRound2);
            for (int i29 = 0; i29 < iRound2; i29++) {
                int i30 = ((int) (i29 * f18)) + i25;
                for (int i31 = 0; i31 < iRound; i31++) {
                    if (c4963bM6913a2.m6942f(((int) (i31 * f18)) + i26, i30)) {
                        c4963b.m6946j(i31, i29);
                    }
                }
            }
            c4966eM7097a = this.f13509b.m7097a(c4963b, map);
            c4956kArr = f13508a;
        }
        Object obj = c4966eM7097a.f13271f;
        if ((obj instanceof C5057i) && ((C5057i) obj).f13547a && c4956kArr.length >= 3) {
            C4956k c4956k = c4956kArr[0];
            c4956kArr[0] = c4956kArr[2];
            c4956kArr[2] = c4956k;
        }
        Result result = new Result(c4966eM7097a.f13268c, c4966eM7097a.f13266a, c4956kArr, EnumC4946a.QR_CODE);
        List<byte[]> list2 = c4966eM7097a.f13269d;
        if (list2 != null) {
            result.m9262b(EnumC4955j.BYTE_SEGMENTS, list2);
        }
        String str = c4966eM7097a.f13270e;
        if (str != null) {
            result.m9262b(EnumC4955j.ERROR_CORRECTION_LEVEL, str);
        }
        if (c4966eM7097a.f13272g >= 0 && c4966eM7097a.f13273h >= 0) {
            result.m9262b(EnumC4955j.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c4966eM7097a.f13273h));
            result.m9262b(EnumC4955j.STRUCTURED_APPEND_PARITY, Integer.valueOf(c4966eM7097a.f13272g));
        }
        return result;
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
