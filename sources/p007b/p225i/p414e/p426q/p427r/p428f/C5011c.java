package p007b.p225i.p414e.p426q.p427r.p428f;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p426q.AbstractC4997k;
import p007b.p225i.p414e.p426q.p427r.AbstractC5004a;
import p007b.p225i.p414e.p426q.p427r.C5005b;
import p007b.p225i.p414e.p426q.p427r.C5006c;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractC5021j;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5012a;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5013b;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5014c;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5015d;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5016e;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5018g;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5022k;
import p007b.p225i.p414e.p426q.p427r.p428f.p429d.C5030s;

/* JADX INFO: renamed from: b.i.e.q.r.f.c */
/* JADX INFO: compiled from: RSSExpandedReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5011c extends AbstractC5004a {

    /* JADX INFO: renamed from: g */
    public static final int[] f13427g = {7, 5, 4, 3, 1};

    /* JADX INFO: renamed from: h */
    public static final int[] f13428h = {4, 20, 52, 104, 204};

    /* JADX INFO: renamed from: i */
    public static final int[] f13429i = {0, 348, 1388, 2948, 3988};

    /* JADX INFO: renamed from: j */
    public static final int[][] f13430j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* JADX INFO: renamed from: k */
    public static final int[][] f13431k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Opcodes.D2L, 7, 21, 63}, new int[]{Opcodes.ANEWARRAY, Opcodes.I2B, 13, 39, 117, Opcodes.F2L, 209, 205}, new int[]{Opcodes.INSTANCEOF, 157, 49, Opcodes.I2S, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, Opcodes.L2I, Opcodes.MULTIANEWARRAY, Opcodes.RET, 85, 44, Opcodes.IINC}, new int[]{Opcodes.INVOKEINTERFACE, Opcodes.I2L, Opcodes.NEWARRAY, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, Opcodes.L2D, 203, Opcodes.NEW, Opcodes.F2I, 206, 196, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, Opcodes.LOR, Opcodes.ARETURN, 106, 107, 110, 119, Opcodes.I2C}, new int[]{16, 48, Opcodes.D2F, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, Opcodes.L2F, 200, Opcodes.GETSTATIC, 112, Opcodes.LUSHR, Opcodes.IF_ICMPLE}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, Opcodes.PUTSTATIC, 115}, new int[]{Opcodes.I2F, Opcodes.ATHROW, Opcodes.DCMPL, 31, 93, 68, 204, Opcodes.ARRAYLENGTH}, new int[]{Opcodes.LCMP, 22, 66, Opcodes.IFNULL, Opcodes.IRETURN, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, Opcodes.CHECKCAST, 154, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, 175}, new int[]{103, 98, 83, 38, 114, Opcodes.LXOR, Opcodes.INVOKEVIRTUAL, 124}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, Opcodes.LAND, Opcodes.TABLESWITCH, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, Opcodes.I2D, Opcodes.MONITORENTER, Opcodes.IF_ICMPNE, 58, Opcodes.FRETURN, 100, 89}};

    /* JADX INFO: renamed from: l */
    public static final int[][] f13432l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* JADX INFO: renamed from: m */
    public final List<C5009a> f13433m = new ArrayList(11);

    /* JADX INFO: renamed from: n */
    public final List<C5010b> f13434n = new ArrayList();

    /* JADX INFO: renamed from: o */
    public final int[] f13435o = new int[2];

    /* JADX INFO: renamed from: p */
    public boolean f13436p;

    /* JADX INFO: renamed from: n */
    public static Result m7020n(List<C5009a> list) throws NotFoundException, FormatException {
        AbstractC5021j c5012a;
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f13422b == null) {
            size--;
        }
        C4962a c4962a = new C4962a(size * 12);
        int i = list.get(0).f13422b.f13405a;
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & i) != 0) {
                c4962a.m6940j(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            C5009a c5009a = list.get(i4);
            int i5 = c5009a.f13421a.f13405a;
            for (int i6 = 11; i6 >= 0; i6--) {
                if (((1 << i6) & i5) != 0) {
                    c4962a.m6940j(i2);
                }
                i2++;
            }
            C5005b c5005b = c5009a.f13422b;
            if (c5005b != null) {
                int i7 = c5005b.f13405a;
                for (int i8 = 11; i8 >= 0; i8--) {
                    if (((1 << i8) & i7) != 0) {
                        c4962a.m6940j(i2);
                    }
                    i2++;
                }
            }
        }
        if (c4962a.m6935b(1)) {
            c5012a = new C5018g(c4962a);
        } else if (c4962a.m6935b(2)) {
            int iM7038d = C5030s.m7038d(c4962a, 1, 4);
            if (iM7038d == 4) {
                c5012a = new C5012a(c4962a);
            } else if (iM7038d != 5) {
                int iM7038d2 = C5030s.m7038d(c4962a, 1, 5);
                if (iM7038d2 == 12) {
                    c5012a = new C5014c(c4962a);
                } else if (iM7038d2 != 13) {
                    switch (C5030s.m7038d(c4962a, 1, 7)) {
                        case 56:
                            c5012a = new C5016e(c4962a, "310", "11");
                            break;
                        case 57:
                            c5012a = new C5016e(c4962a, "320", "11");
                            break;
                        case 58:
                            c5012a = new C5016e(c4962a, "310", "13");
                            break;
                        case 59:
                            c5012a = new C5016e(c4962a, "320", "13");
                            break;
                        case 60:
                            c5012a = new C5016e(c4962a, "310", "15");
                            break;
                        case 61:
                            c5012a = new C5016e(c4962a, "320", "15");
                            break;
                        case 62:
                            c5012a = new C5016e(c4962a, "310", "17");
                            break;
                        case 63:
                            c5012a = new C5016e(c4962a, "320", "17");
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(c4962a)));
                    }
                } else {
                    c5012a = new C5015d(c4962a);
                }
            } else {
                c5012a = new C5013b(c4962a);
            }
        } else {
            c5012a = new C5022k(c4962a);
        }
        String strMo7030a = c5012a.mo7030a();
        C4956k[] c4956kArr = list.get(0).f13423c.f13409c;
        C4956k[] c4956kArr2 = list.get(list.size() - 1).f13423c.f13409c;
        return new Result(strMo7030a, null, new C4956k[]{c4956kArr[0], c4956kArr[1], c4956kArr2[0], c4956kArr2[1]}, EnumC4946a.RSS_EXPANDED);
    }

    /* JADX INFO: renamed from: r */
    public static void m7021r(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, FormatException {
        this.f13433m.clear();
        this.f13436p = false;
        try {
            return m7020n(m7026p(i, c4962a));
        } catch (NotFoundException unused) {
            this.f13433m.clear();
            this.f13436p = true;
            return m7020n(m7026p(i, c4962a));
        }
    }

    /* JADX INFO: renamed from: k */
    public final boolean m7022k() {
        C5009a c5009a = this.f13433m.get(0);
        C5005b c5005b = c5009a.f13421a;
        C5005b c5005b2 = c5009a.f13422b;
        if (c5005b2 == null) {
            return false;
        }
        int i = c5005b2.f13406b;
        int i2 = 2;
        for (int i3 = 1; i3 < this.f13433m.size(); i3++) {
            C5009a c5009a2 = this.f13433m.get(i3);
            i += c5009a2.f13421a.f13406b;
            i2++;
            C5005b c5005b3 = c5009a2.f13422b;
            if (c5005b3 != null) {
                i += c5005b3.f13406b;
                i2++;
            }
        }
        return ((i2 + (-4)) * 211) + (i % 211) == c5005b.f13405a;
    }

    /* JADX INFO: renamed from: l */
    public final List<C5009a> m7023l(List<C5010b> list, int i) throws NotFoundException {
        boolean z2;
        while (i < this.f13434n.size()) {
            C5010b c5010b = this.f13434n.get(i);
            this.f13433m.clear();
            Iterator<C5010b> it = list.iterator();
            while (it.hasNext()) {
                this.f13433m.addAll(it.next().f13424a);
            }
            this.f13433m.addAll(c5010b.f13424a);
            List<C5009a> list2 = this.f13433m;
            boolean z3 = false;
            for (int[] iArr : f13432l) {
                if (list2.size() <= iArr.length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list2.size()) {
                            z2 = true;
                            break;
                        }
                        if (list2.get(i2).f13423c.f13407a != iArr[i2]) {
                            z2 = false;
                            break;
                        }
                        i2++;
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                if (m7022k()) {
                    return this.f13433m;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(c5010b);
                try {
                    return m7023l(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: m */
    public final List<C5009a> m7024m(boolean z2) {
        List<C5009a> listM7023l = null;
        if (this.f13434n.size() > 25) {
            this.f13434n.clear();
            return null;
        }
        this.f13433m.clear();
        if (z2) {
            Collections.reverse(this.f13434n);
        }
        try {
            listM7023l = m7023l(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z2) {
            Collections.reverse(this.f13434n);
        }
        return listM7023l;
    }

    /* JADX INFO: renamed from: o */
    public C5005b m7025o(C4962a c4962a, C5006c c5006c, boolean z2, boolean z3) throws NotFoundException {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int[] iArr = this.f13400b;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
        if (z3) {
            AbstractC4997k.m6998f(c4962a, c5006c.f13408b[0], iArr);
        } else {
            AbstractC4997k.m6997e(c4962a, c5006c.f13408b[1], iArr);
            int i2 = 0;
            for (int length = iArr.length - 1; i2 < length; length--) {
                int i3 = iArr[i2];
                iArr[i2] = iArr[length];
                iArr[length] = i3;
                i2++;
            }
        }
        float fM4297h1 = C3404f.m4297h1(iArr) / 17.0f;
        int[] iArr2 = c5006c.f13408b;
        float f = (iArr2[1] - iArr2[0]) / 15.0f;
        if (Math.abs(fM4297h1 - f) / f > 0.3f) {
            throw NotFoundException.f21665l;
        }
        int[] iArr3 = this.f13403e;
        int[] iArr4 = this.f13404f;
        float[] fArr = this.f13401c;
        float[] fArr2 = this.f13402d;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f2 = (iArr[i4] * 1.0f) / fM4297h1;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.f21665l;
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.f21665l;
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArr3[i6] = i5;
                fArr[i6] = f2 - i5;
            } else {
                iArr4[i6] = i5;
                fArr2[i6] = f2 - i5;
            }
        }
        int iM4297h1 = C3404f.m4297h1(this.f13403e);
        int iM4297h2 = C3404f.m4297h1(this.f13404f);
        if (iM4297h1 > 13) {
            z4 = false;
            z5 = true;
        } else {
            z4 = iM4297h1 < 4;
            z5 = false;
        }
        if (iM4297h2 > 13) {
            z6 = false;
            z7 = true;
        } else {
            z6 = iM4297h2 < 4;
            z7 = false;
        }
        int i7 = (iM4297h1 + iM4297h2) - 17;
        boolean z8 = (iM4297h1 & 1) == 1;
        boolean z9 = (iM4297h2 & 1) == 0;
        if (i7 == 1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.f21665l;
                }
                z5 = true;
            } else {
                if (!z9) {
                    throw NotFoundException.f21665l;
                }
                z7 = true;
            }
        } else if (i7 != -1) {
            if (i7 != 0) {
                throw NotFoundException.f21665l;
            }
            if (z8) {
                if (!z9) {
                    throw NotFoundException.f21665l;
                }
                if (iM4297h1 < iM4297h2) {
                    z4 = true;
                    z7 = true;
                } else {
                    z6 = true;
                    z5 = true;
                }
            } else if (z9) {
                throw NotFoundException.f21665l;
            }
        } else if (z8) {
            if (z9) {
                throw NotFoundException.f21665l;
            }
            z4 = true;
        } else {
            if (!z9) {
                throw NotFoundException.f21665l;
            }
            z6 = true;
        }
        if (z4) {
            if (z5) {
                throw NotFoundException.f21665l;
            }
            AbstractC5004a.m7010h(this.f13403e, this.f13401c);
        }
        if (z5) {
            AbstractC5004a.m7009g(this.f13403e, this.f13401c);
        }
        if (z6) {
            if (z7) {
                throw NotFoundException.f21665l;
            }
            AbstractC5004a.m7010h(this.f13404f, this.f13401c);
        }
        if (z7) {
            AbstractC5004a.m7009g(this.f13404f, this.f13402d);
        }
        int i8 = (((c5006c.f13407a * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArr3.length - 1; length2 >= 0; length2--) {
            if ((c5006c.f13407a == 0 && z2 && z3) ? false : true) {
                i9 += iArr3[length2] * f13431k[i8][length2 * 2];
            }
            i10 += iArr3[length2];
        }
        int i11 = 0;
        for (int length3 = iArr4.length - 1; length3 >= 0; length3--) {
            if ((c5006c.f13407a == 0 && z2 && z3) ? false : true) {
                i11 += iArr4[length3] * f13431k[i8][(length3 * 2) + 1];
            }
        }
        int i12 = i9 + i11;
        if ((i10 & 1) != 0 || i10 > 13 || i10 < 4) {
            throw NotFoundException.f21665l;
        }
        int i13 = (13 - i10) / 2;
        int i14 = f13427g[i13];
        return new C5005b((C3404f.m4328p0(iArr3, i14, true) * f13428h[i13]) + C3404f.m4328p0(iArr4, 9 - i14, false) + f13429i[i13], i12);
    }

    /* JADX INFO: renamed from: p */
    public List<C5009a> m7026p(int i, C4962a c4962a) throws NotFoundException {
        boolean zEquals;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                List<C5009a> list = this.f13433m;
                list.add(m7027q(c4962a, list, i));
            } catch (NotFoundException e) {
                if (this.f13433m.isEmpty()) {
                    throw e;
                }
                z7 = true;
            }
        }
        if (m7022k()) {
            return this.f13433m;
        }
        boolean z8 = !this.f13434n.isEmpty();
        int i2 = 0;
        boolean zEquals2 = false;
        while (true) {
            if (i2 >= this.f13434n.size()) {
                zEquals = false;
                break;
            }
            C5010b c5010b = this.f13434n.get(i2);
            if (c5010b.f13425b > i) {
                zEquals = c5010b.f13424a.equals(this.f13433m);
                break;
            }
            zEquals2 = c5010b.f13424a.equals(this.f13433m);
            i2++;
        }
        if (!zEquals && !zEquals2) {
            List<C5009a> list2 = this.f13433m;
            Iterator<T> it = this.f13434n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                C5010b c5010b2 = (C5010b) it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        break;
                    }
                    C5009a c5009a = (C5009a) it2.next();
                    Iterator<C5009a> it3 = c5010b2.f13424a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z6 = false;
                            break;
                        }
                        if (c5009a.equals(it3.next())) {
                            z6 = true;
                            break;
                        }
                    }
                    if (!z6) {
                        z5 = false;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.f13434n.add(i2, new C5010b(this.f13433m, i, false));
                List<C5009a> list3 = this.f13433m;
                Iterator<C5010b> it4 = this.f13434n.iterator();
                while (it4.hasNext()) {
                    C5010b next = it4.next();
                    if (next.f13424a.size() != list3.size()) {
                        Iterator<C5009a> it5 = next.f13424a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            C5009a next2 = it5.next();
                            Iterator<C5009a> it6 = list3.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    z4 = false;
                                    break;
                                }
                                if (next2.equals(it6.next())) {
                                    z4 = true;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it4.remove();
                        }
                    }
                }
            }
        }
        if (z8) {
            List<C5009a> listM7024m = m7024m(false);
            if (listM7024m != null) {
                return listM7024m;
            }
            List<C5009a> listM7024m2 = m7024m(true);
            if (listM7024m2 != null) {
                return listM7024m2;
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: q */
    public C5009a m7027q(C4962a c4962a, List<C5009a> list, int i) throws NotFoundException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        C5006c c5006c;
        int i7 = 2;
        int i8 = 0;
        boolean z2 = list.size() % 2 == 0;
        if (this.f13436p) {
            z2 = !z2;
        }
        int iM6936f = -1;
        boolean z3 = true;
        while (true) {
            int[] iArr = this.f13399a;
            iArr[i8] = i8;
            iArr[1] = i8;
            iArr[i7] = i8;
            iArr[3] = i8;
            int i9 = c4962a.f13228k;
            if (iM6936f >= 0) {
                i2 = iM6936f;
            } else {
                i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).f13423c.f13408b[1];
            }
            boolean z4 = list.size() % i7 != 0;
            if (this.f13436p) {
                z4 = !z4;
            }
            boolean z5 = false;
            while (i2 < i9) {
                z5 = !c4962a.m6935b(i2);
                if (!z5) {
                    break;
                }
                i2++;
            }
            boolean z6 = z5;
            int i10 = 0;
            int i11 = i2;
            while (true) {
                if (i2 >= i9) {
                    throw NotFoundException.f21665l;
                }
                if (c4962a.m6935b(i2) != z6) {
                    iArr[i10] = iArr[i10] + 1;
                } else {
                    if (i10 == 3) {
                        if (z4) {
                            m7021r(iArr);
                        }
                        if (AbstractC5004a.m7011i(iArr)) {
                            break;
                        }
                        if (z4) {
                            m7021r(iArr);
                        }
                        i11 = iArr[0] + iArr[1] + i11;
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = 0;
                        iArr[3] = 0;
                        i10--;
                    } else {
                        i10++;
                    }
                    iArr[i10] = 1;
                    z6 = !z6;
                }
                i2++;
            }
            int[] iArr2 = this.f13435o;
            iArr2[0] = i11;
            iArr2[1] = i2;
            if (z2) {
                int i12 = iArr2[0] - 1;
                while (i12 >= 0 && !c4962a.m6935b(i12)) {
                    i12--;
                }
                int i13 = i12 + 1;
                int[] iArr3 = this.f13435o;
                i3 = 0;
                i4 = iArr3[0] - i13;
                i6 = i13;
                i5 = iArr3[1];
            } else {
                i3 = 0;
                int i14 = iArr2[0];
                int iM6937g = c4962a.m6937g(iArr2[1] + 1);
                i4 = iM6937g - this.f13435o[1];
                i5 = iM6937g;
                i6 = i14;
            }
            int[] iArr4 = this.f13399a;
            System.arraycopy(iArr4, i3, iArr4, 1, iArr4.length - 1);
            iArr4[i3] = i4;
            C5005b c5005bM7025o = null;
            try {
                int iM7012j = AbstractC5004a.m7012j(iArr4, f13430j);
                int[] iArr5 = new int[2];
                iArr5[i3] = i6;
                iArr5[1] = i5;
                c5006c = new C5006c(iM7012j, iArr5, i6, i5, i);
            } catch (NotFoundException unused) {
                c5006c = null;
            }
            if (c5006c == null) {
                int i15 = this.f13435o[0];
                iM6936f = c4962a.m6935b(i15) ? c4962a.m6936f(c4962a.m6937g(i15)) : c4962a.m6937g(c4962a.m6936f(i15));
            } else {
                z3 = false;
            }
            if (!z3) {
                C5005b c5005bM7025o2 = m7025o(c4962a, c5006c, z2, true);
                if (!list.isEmpty()) {
                    if (list.get(list.size() - 1).f13422b == null) {
                        throw NotFoundException.f21665l;
                    }
                }
                try {
                    c5005bM7025o = m7025o(c4962a, c5006c, z2, false);
                } catch (NotFoundException unused2) {
                }
                return new C5009a(c5005bM7025o2, c5005bM7025o, c5006c, true);
            }
            i7 = 2;
            i8 = 0;
        }
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k, p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
        this.f13433m.clear();
        this.f13434n.clear();
    }
}
