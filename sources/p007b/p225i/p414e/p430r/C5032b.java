package p007b.p225i.p414e.p430r;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4966e;
import p007b.p225i.p414e.p430r.p431d.C5034a;
import p007b.p225i.p414e.p430r.p431d.C5035b;
import p007b.p225i.p414e.p430r.p431d.C5036c;
import p007b.p225i.p414e.p430r.p431d.C5037d;
import p007b.p225i.p414e.p430r.p431d.C5039f;
import p007b.p225i.p414e.p430r.p431d.C5040g;
import p007b.p225i.p414e.p430r.p431d.C5041h;
import p007b.p225i.p414e.p430r.p431d.C5043j;
import p007b.p225i.p414e.p430r.p431d.p432k.C5044a;
import p007b.p225i.p414e.p430r.p433e.C5047a;

/* JADX INFO: renamed from: b.i.e.r.b */
/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5032b implements InterfaceC4954i {
    /* JADX INFO: renamed from: b */
    public static int m7046b(C4956k c4956k, C4956k c4956k2) {
        if (c4956k == null || c4956k2 == null) {
            return 0;
        }
        return (int) Math.abs(c4956k.f13207a - c4956k2.f13207a);
    }

    /* JADX INFO: renamed from: c */
    public static int m7047c(C4956k c4956k, C4956k c4956k2) {
        if (c4956k == null || c4956k2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(c4956k.f13207a - c4956k2.f13207a);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:140:0x030b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0310  */
    /* JADX WARN: Code duplicated, block: B:39:0x0163  */
    /* JADX WARN: Code duplicated, block: B:42:0x016c  */
    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        C5036c c5036c;
        C5039f c5039f;
        int i;
        boolean z2;
        C4966e c4966eM7062b;
        int i2;
        Iterator<C4956k[]> it;
        C5036c c5036c2;
        int i3;
        C5037d c5037d;
        int i4;
        int i5;
        int i6;
        C5040g c5040g;
        int i7;
        int i8;
        int i9;
        C5036c c5036c3;
        int i10;
        int i11;
        int i12;
        C5037d c5037dM7063c;
        C5034a c5034aM7059c;
        C5034a c5034aM7059c2;
        ArrayList arrayList = new ArrayList();
        C4963b c4963bM6913a = c4948c.m6913a();
        char c = 0;
        List<C4956k[]> listM7080a = C5047a.m7080a(false, c4963bM6913a);
        int i13 = 2;
        if (((ArrayList) listM7080a).isEmpty()) {
            int i14 = c4963bM6913a.f13229j;
            int i15 = c4963bM6913a.f13230k;
            C4963b c4963b = new C4963b(i14, i15, c4963bM6913a.f13231l, (int[]) c4963bM6913a.f13232m.clone());
            C4962a c4962a = new C4962a(i14);
            C4962a c4962a2 = new C4962a(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                c4962a = c4963b.m6944h(i16, c4962a);
                int i17 = (i15 - 1) - i16;
                c4962a2 = c4963b.m6944h(i17, c4962a2);
                c4962a.m6939i();
                c4962a2.m6939i();
                int[] iArr = c4962a2.f13227j;
                int[] iArr2 = c4963b.f13232m;
                int i18 = c4963b.f13231l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = c4962a.f13227j;
                int[] iArr4 = c4963b.f13232m;
                int i19 = c4963b.f13231l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listM7080a = C5047a.m7080a(false, c4963b);
            c4963bM6913a = c4963b;
        }
        Iterator<C4956k[]> it2 = listM7080a.iterator();
        while (it2.hasNext()) {
            C4956k[] next = it2.next();
            C4956k c4956k = next[4];
            C4956k c4956k2 = next[5];
            C4956k c4956k3 = next[6];
            C4956k c4956k4 = next[7];
            int iMin = Math.min(Math.min(m7047c(next[c], next[4]), (m7047c(next[6], next[i13]) * 17) / 18), Math.min(m7047c(next[1], next[5]), (m7047c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(m7046b(next[c], next[4]), (m7046b(next[6], next[i13]) * 17) / 18), Math.max(m7046b(next[1], next[5]), (m7046b(next[7], next[3]) * 17) / 18));
            C5044a c5044a = C5043j.f13495a;
            C5036c c5036c4 = new C5036c(c4963bM6913a, c4956k, c4956k2, c4956k3, c4956k4);
            C5039f c5039f2 = null;
            C5041h c5041hM7064d = null;
            C5041h c5041hM7064d2 = null;
            int i20 = 0;
            while (true) {
                if (i20 >= i13) {
                    c5036c = c5036c4;
                    c5039f = c5039f2;
                    break;
                }
                if (c4956k != null) {
                    c5041hM7064d = C5043j.m7064d(c4963bM6913a, c5036c4, c4956k, true, iMin, iMax);
                }
                C5041h c5041h = c5041hM7064d;
                if (c4956k3 != null) {
                    c5041hM7064d2 = C5043j.m7064d(c4963bM6913a, c5036c4, c4956k3, false, iMin, iMax);
                }
                if (c5041h == null && c5041hM7064d2 == null) {
                    c5039f2 = null;
                } else {
                    if (c5041h == null || (c5034aM7059c = c5041h.m7059c()) == null) {
                        if (c5041hM7064d2 == null) {
                            c5034aM7059c = null;
                        } else {
                            c5034aM7059c = c5041hM7064d2.m7059c();
                        }
                    } else if (c5041hM7064d2 != null && (c5034aM7059c2 = c5041hM7064d2.m7059c()) != null && c5034aM7059c.f13464a != c5034aM7059c2.f13464a && c5034aM7059c.f13465b != c5034aM7059c2.f13465b && c5034aM7059c.f13468e != c5034aM7059c2.f13468e) {
                        c5034aM7059c = null;
                    }
                    if (c5034aM7059c == null) {
                        c5039f2 = null;
                    } else {
                        C5036c c5036cM7061a = C5043j.m7061a(c5041h);
                        C5036c c5036cM7061a2 = C5043j.m7061a(c5041hM7064d2);
                        if (c5036cM7061a == null) {
                            c5036cM7061a = c5036cM7061a2;
                        } else if (c5036cM7061a2 != null) {
                            c5036cM7061a = new C5036c(c5036cM7061a.f13470a, c5036cM7061a.f13471b, c5036cM7061a.f13472c, c5036cM7061a2.f13473d, c5036cM7061a2.f13474e);
                        }
                        c5039f2 = new C5039f(c5034aM7059c, c5036cM7061a);
                    }
                }
                if (c5039f2 == null) {
                    throw NotFoundException.f21665l;
                }
                if (i20 != 0 || (c5036c4 = c5039f2.f13489c) == null) {
                    c5036c = c5036c4;
                } else {
                    c5036c = c5036c4;
                    if (c5036c4.f13477h < c5036c.f13477h || c5036c4.f13478i > c5036c.f13478i) {
                        i20++;
                        c5041hM7064d = c5041h;
                        i13 = 2;
                    }
                }
                c5039f2.f13489c = c5036c;
                c5039f = c5039f2;
                c5041hM7064d = c5041h;
                break;
            }
            int i21 = c5039f.f13490d + 1;
            C5040g[] c5040gArr = c5039f.f13488b;
            c5040gArr[c] = c5041hM7064d;
            c5040gArr[i21] = c5041hM7064d2;
            boolean z3 = c5041hM7064d != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (c5039f.f13488b[i24] == null) {
                    C5040g c5041h2 = (i24 == 0 || i24 == i21) ? new C5041h(c5036c, i24 == 0) : new C5040g(c5036c);
                    c5039f.f13488b[i24] = c5041h2;
                    int i25 = c5036c.f13477h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= c5036c.f13478i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (C5043j.m7065e(c5039f, i29)) {
                            C5040g c5040g2 = c5039f.f13488b[i29];
                            c5037d = c5040g2.f13492b[i25 - c5040g2.f13491a.f13477h];
                        } else {
                            c5037d = null;
                        }
                        if (c5037d != null) {
                            i5 = z3 ? c5037d.f13480b : c5037d.f13479a;
                        } else {
                            C5037d c5037dM7057a = c5039f.f13488b[i24].m7057a(i25);
                            if (c5037dM7057a != null) {
                                i5 = z3 ? c5037dM7057a.f13479a : c5037dM7057a.f13480b;
                            } else {
                                if (C5043j.m7065e(c5039f, i29)) {
                                    c5037dM7057a = c5039f.f13488b[i29].m7057a(i25);
                                }
                                if (c5037dM7057a == null) {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (!C5043j.m7065e(c5039f, i32)) {
                                            i4 = i25;
                                            if (!z3) {
                                                i5 = c5039f.f13489c.f13476g;
                                                break;
                                            }
                                            i5 = c5039f.f13489c.f13475f;
                                            break;
                                        }
                                        C5037d[] c5037dArr = c5039f.f13488b[i32].f13492b;
                                        int length = c5037dArr.length;
                                        i4 = i25;
                                        int i33 = 0;
                                        while (i33 < length) {
                                            int i34 = length;
                                            C5037d c5037d2 = c5037dArr[i33];
                                            if (c5037d2 != null) {
                                                i5 = ((c5037d2.f13480b - c5037d2.f13479a) * i28 * i31) + (z3 ? c5037d2.f13480b : c5037d2.f13479a);
                                                break;
                                            }
                                            i33++;
                                            length = i34;
                                        }
                                        i31++;
                                        i30 = i32;
                                        i25 = i4;
                                    }
                                } else {
                                    i5 = z3 ? c5037dM7057a.f13480b : c5037dM7057a.f13479a;
                                }
                                if (i5 >= 0 || i5 > c5036c.f13476g) {
                                    if (i27 != -1) {
                                        i10 = i27;
                                    } else {
                                        i6 = i26;
                                        c5040g = c5041h2;
                                        i7 = i24;
                                        i8 = i21;
                                        iMax2 = iMax2;
                                        i9 = i4;
                                        c5036c3 = c5036c;
                                    }
                                    i26 = i6;
                                    i25 = i9 + 1;
                                    c5041h2 = c5040g;
                                    it2 = it2;
                                    c5036c = c5036c3;
                                    i24 = i7;
                                    i21 = i8;
                                } else {
                                    i10 = i5;
                                }
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                c5036c3 = c5036c;
                                i7 = i24;
                                c5040g = c5041h2;
                                i8 = i21;
                                c5037dM7063c = C5043j.m7063c(c4963bM6913a, c5036c.f13475f, c5036c.f13476g, z3, i10, i9, i12, i11);
                                if (c5037dM7063c != null) {
                                    c5040g.f13492b[i9 - c5040g.f13491a.f13477h] = c5037dM7063c;
                                    int iMin2 = Math.min(i12, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                    iMax2 = Math.max(i11, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                    i26 = iMin2;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                    i26 = i6;
                                }
                                i25 = i9 + 1;
                                c5041h2 = c5040g;
                                it2 = it2;
                                c5036c = c5036c3;
                                i24 = i7;
                                i21 = i8;
                            }
                        }
                        i4 = i25;
                        if (i5 >= 0) {
                            if (i27 != -1) {
                                i10 = i27;
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                c5036c3 = c5036c;
                                i7 = i24;
                                c5040g = c5041h2;
                                i8 = i21;
                                c5037dM7063c = C5043j.m7063c(c4963bM6913a, c5036c.f13475f, c5036c.f13476g, z3, i10, i9, i12, i11);
                                if (c5037dM7063c != null) {
                                    c5040g.f13492b[i9 - c5040g.f13491a.f13477h] = c5037dM7063c;
                                    int iMin3 = Math.min(i12, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                    iMax2 = Math.max(i11, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                    i26 = iMin3;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                }
                                i25 = i9 + 1;
                                c5041h2 = c5040g;
                                it2 = it2;
                                c5036c = c5036c3;
                                i24 = i7;
                                i21 = i8;
                            } else {
                                i6 = i26;
                                c5040g = c5041h2;
                                i7 = i24;
                                i8 = i21;
                                iMax2 = iMax2;
                                i9 = i4;
                                c5036c3 = c5036c;
                            }
                        } else if (i27 != -1) {
                            i10 = i27;
                            i11 = iMax2;
                            i9 = i4;
                            i12 = i26;
                            c5036c3 = c5036c;
                            i7 = i24;
                            c5040g = c5041h2;
                            i8 = i21;
                            c5037dM7063c = C5043j.m7063c(c4963bM6913a, c5036c.f13475f, c5036c.f13476g, z3, i10, i9, i12, i11);
                            if (c5037dM7063c != null) {
                                c5040g.f13492b[i9 - c5040g.f13491a.f13477h] = c5037dM7063c;
                                int iMin4 = Math.min(i12, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                iMax2 = Math.max(i11, c5037dM7063c.f13480b - c5037dM7063c.f13479a);
                                i26 = iMin4;
                                i27 = i10;
                            } else {
                                iMax2 = i11;
                                i6 = i12;
                            }
                            i25 = i9 + 1;
                            c5041h2 = c5040g;
                            it2 = it2;
                            c5036c = c5036c3;
                            i24 = i7;
                            i21 = i8;
                        } else {
                            i6 = i26;
                            c5040g = c5041h2;
                            i7 = i24;
                            i8 = i21;
                            iMax2 = iMax2;
                            i9 = i4;
                            c5036c3 = c5036c;
                        }
                        i26 = i6;
                        i25 = i9 + 1;
                        c5041h2 = c5040g;
                        it2 = it2;
                        c5036c = c5036c3;
                        i24 = i7;
                        i21 = i8;
                    }
                    it = it2;
                    c5036c2 = c5036c;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it2;
                    c5036c2 = c5036c;
                    i3 = i21;
                }
                i23++;
                it2 = it;
                c5036c = c5036c2;
                i21 = i3;
            }
            Iterator<C4956k[]> it3 = it2;
            C5035b[][] c5035bArr = (C5035b[][]) Array.newInstance((Class<?>) C5035b.class, c5039f.f13487a.f13468e, c5039f.f13490d + 2);
            for (int i35 = 0; i35 < c5035bArr.length; i35++) {
                for (int i36 = 0; i36 < c5035bArr[i35].length; i36++) {
                    c5035bArr[i35][i36] = new C5035b();
                }
            }
            char c2 = 0;
            c5039f.m7056a(c5039f.f13488b[0]);
            int i37 = 1;
            c5039f.m7056a(c5039f.f13488b[c5039f.f13490d + 1]);
            int i38 = 928;
            while (true) {
                C5040g[] c5040gArr2 = c5039f.f13488b;
                if (c5040gArr2[c2] != null) {
                    int i39 = c5039f.f13490d + i37;
                    if (c5040gArr2[i39] != null) {
                        C5037d[] c5037dArr2 = c5040gArr2[c2].f13492b;
                        C5037d[] c5037dArr3 = c5040gArr2[i39].f13492b;
                        for (int i40 = 0; i40 < c5037dArr2.length; i40++) {
                            if (c5037dArr2[i40] != null && c5037dArr3[i40] != null && c5037dArr2[i40].f13483e == c5037dArr3[i40].f13483e) {
                                for (int i41 = 1; i41 <= c5039f.f13490d; i41++) {
                                    C5037d c5037d3 = c5039f.f13488b[i41].f13492b[i40];
                                    if (c5037d3 != null) {
                                        c5037d3.f13483e = c5037dArr2[i40].f13483e;
                                        if (!c5037d3.m7050a()) {
                                            c5039f.f13488b[i41].f13492b[i40] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                C5040g[] c5040gArr3 = c5039f.f13488b;
                int i42 = 0;
                if (c5040gArr3[0] != null) {
                    C5037d[] c5037dArr4 = c5040gArr3[0].f13492b;
                    int i43 = 0;
                    for (int i44 = 0; i44 < c5037dArr4.length; i44++) {
                        if (c5037dArr4[i44] != null) {
                            int i45 = c5037dArr4[i44].f13483e;
                            int i46 = i43;
                            int iM7055b = 0;
                            for (int i47 = 1; i47 < c5039f.f13490d + 1 && iM7055b < 2; i47++) {
                                C5037d c5037d4 = c5039f.f13488b[i47].f13492b[i44];
                                if (c5037d4 != null) {
                                    iM7055b = C5039f.m7055b(i45, iM7055b, c5037d4);
                                    if (!c5037d4.m7050a()) {
                                        i46++;
                                    }
                                }
                            }
                            i43 = i46;
                        }
                    }
                    i42 = i43;
                }
                C5040g[] c5040gArr4 = c5039f.f13488b;
                int i48 = c5039f.f13490d + 1;
                if (c5040gArr4[i48] == null) {
                    i = 0;
                } else {
                    C5037d[] c5037dArr5 = c5040gArr4[i48].f13492b;
                    i = 0;
                    for (int i49 = 0; i49 < c5037dArr5.length; i49++) {
                        if (c5037dArr5[i49] != null) {
                            int i50 = c5037dArr5[i49].f13483e;
                            int i51 = i;
                            int iM7055b2 = 0;
                            for (int i52 = c5039f.f13490d + 1; i52 > 0 && iM7055b2 < 2; i52--) {
                                C5037d c5037d5 = c5039f.f13488b[i52].f13492b[i49];
                                if (c5037d5 != null) {
                                    iM7055b2 = C5039f.m7055b(i50, iM7055b2, c5037d5);
                                    if (!c5037d5.m7050a()) {
                                        i51++;
                                    }
                                }
                            }
                            i = i51;
                        }
                    }
                }
                int i53 = i42 + i;
                if (i53 == 0) {
                    i53 = 0;
                } else {
                    for (int i54 = 1; i54 < c5039f.f13490d + 1; i54++) {
                        C5037d[] c5037dArr6 = c5039f.f13488b[i54].f13492b;
                        for (int i55 = 0; i55 < c5037dArr6.length; i55++) {
                            if (c5037dArr6[i55] != null && !c5037dArr6[i55].m7050a()) {
                                C5037d c5037d6 = c5037dArr6[i55];
                                C5040g[] c5040gArr5 = c5039f.f13488b;
                                C5037d[] c5037dArr7 = c5040gArr5[i54 - 1].f13492b;
                                int i56 = i54 + 1;
                                C5037d[] c5037dArr8 = c5040gArr5[i56] != null ? c5040gArr5[i56].f13492b : c5037dArr7;
                                C5037d[] c5037dArr9 = new C5037d[14];
                                c5037dArr9[2] = c5037dArr7[i55];
                                c5037dArr9[3] = c5037dArr8[i55];
                                if (i55 > 0) {
                                    int i57 = i55 - 1;
                                    c5037dArr9[0] = c5037dArr6[i57];
                                    c5037dArr9[4] = c5037dArr7[i57];
                                    c5037dArr9[5] = c5037dArr8[i57];
                                }
                                if (i55 > 1) {
                                    int i58 = i55 - 2;
                                    c5037dArr9[8] = c5037dArr6[i58];
                                    c5037dArr9[10] = c5037dArr7[i58];
                                    c5037dArr9[11] = c5037dArr8[i58];
                                }
                                if (i55 < c5037dArr6.length - 1) {
                                    int i59 = i55 + 1;
                                    c5037dArr9[1] = c5037dArr6[i59];
                                    c5037dArr9[6] = c5037dArr7[i59];
                                    c5037dArr9[7] = c5037dArr8[i59];
                                }
                                if (i55 < c5037dArr6.length - 2) {
                                    int i60 = i55 + 2;
                                    c5037dArr9[9] = c5037dArr6[i60];
                                    c5037dArr9[12] = c5037dArr7[i60];
                                    c5037dArr9[13] = c5037dArr8[i60];
                                }
                                int i61 = 0;
                                for (int i62 = 14; i61 < i62; i62 = 14) {
                                    C5037d c5037d7 = c5037dArr9[i61];
                                    if (c5037d7 != null && c5037d7.m7050a() && c5037d7.f13481c == c5037d6.f13481c) {
                                        c5037d6.f13483e = c5037d7.f13483e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i61++;
                                }
                            }
                        }
                    }
                }
                if (i53 <= 0 || i53 >= i38) {
                    break;
                }
                i38 = i53;
                c2 = 0;
                i37 = 1;
            }
            int i63 = 0;
            for (C5040g c5040g3 : c5039f.f13488b) {
                if (c5040g3 != null) {
                    for (C5037d c5037d8 : c5040g3.f13492b) {
                        if (c5037d8 != null && (i2 = c5037d8.f13483e) >= 0 && i2 < c5035bArr.length) {
                            c5035bArr[i2][i63].m7049b(c5037d8.f13482d);
                        }
                    }
                }
                i63++;
            }
            C5035b c5035b = c5035bArr[0][1];
            int[] iArrM7048a = c5035b.m7048a();
            int i64 = c5039f.f13490d;
            C5034a c5034a = c5039f.f13487a;
            int i65 = (i64 * c5034a.f13468e) - (2 << c5034a.f13465b);
            if (iArrM7048a.length == 0) {
                if (i65 <= 0 || i65 > 928) {
                    throw NotFoundException.f21665l;
                }
                c5035b.m7049b(i65);
            } else if (iArrM7048a[0] != i65) {
                c5035b.m7049b(i65);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[c5039f.f13487a.f13468e * c5039f.f13490d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i66 = 0; i66 < c5039f.f13487a.f13468e; i66++) {
                int i67 = 0;
                while (i67 < c5039f.f13490d) {
                    int i68 = i67 + 1;
                    int[] iArrM7048a2 = c5035bArr[i66][i68].m7048a();
                    int i69 = (c5039f.f13490d * i66) + i67;
                    if (iArrM7048a2.length == 0) {
                        arrayList2.add(Integer.valueOf(i69));
                    } else if (iArrM7048a2.length == 1) {
                        iArr5[i69] = iArrM7048a2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i69));
                        arrayList3.add(iArrM7048a2);
                    }
                    i67 = i68;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i70 = 0; i70 < size; i70++) {
                iArr6[i70] = (int[]) arrayList3.get(i70);
            }
            int i71 = c5039f.f13487a.f13465b;
            int[] iArrM7045b = C5031a.m7045b(arrayList2);
            int[] iArrM7045b2 = C5031a.m7045b(arrayList4);
            int length2 = iArrM7045b2.length;
            int[] iArr7 = new int[length2];
            int i72 = 100;
            while (true) {
                int i73 = i72 - 1;
                if (i72 <= 0) {
                    throw ChecksumException.m9259a();
                }
                for (int i74 = 0; i74 < length2; i74++) {
                    iArr5[iArrM7045b2[i74]] = iArr6[i74][iArr7[i74]];
                }
                try {
                    c4966eM7062b = C5043j.m7062b(iArr5, i71, iArrM7045b);
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.m9259a();
                    }
                    for (int i75 = 0; i75 < length2; i75++) {
                        if (iArr7[i75] < iArr6[i75].length - 1) {
                            iArr7[i75] = iArr7[i75] + 1;
                            break;
                        }
                        iArr7[i75] = 0;
                        if (i75 == length2 - 1) {
                            throw ChecksumException.m9259a();
                        }
                    }
                    i72 = i73;
                }
            }
            Result result = new Result(c4966eM7062b.f13268c, c4966eM7062b.f13266a, next, EnumC4946a.PDF_417);
            result.m9262b(EnumC4955j.ERROR_CORRECTION_LEVEL, c4966eM7062b.f13270e);
            C5033c c5033c = (C5033c) c4966eM7062b.f13271f;
            if (c5033c != null) {
                result.m9262b(EnumC4955j.PDF417_EXTRA_METADATA, c5033c);
            }
            arrayList.add(result);
            it2 = it3;
            c = 0;
            i13 = 2;
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.f21665l;
        }
        return resultArr[0];
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
