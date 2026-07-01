package b.i.e.q.r.f;

import b.i.a.f.e.o.f;
import b.i.e.q.r.f.d.d;
import b.i.e.q.r.f.d.e;
import b.i.e.q.r.f.d.g;
import b.i.e.q.r.f.d.j;
import b.i.e.q.r.f.d.k;
import b.i.e.q.r.f.d.s;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: RSSExpandedReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends b.i.e.q.r.a {
    public static final int[] g = {7, 5, 4, 3, 1};
    public static final int[] h = {4, 20, 52, 104, 204};
    public static final int[] i = {0, 348, 1388, 2948, 3988};
    public static final int[][] j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Opcodes.D2L, 7, 21, 63}, new int[]{Opcodes.ANEWARRAY, Opcodes.I2B, 13, 39, 117, Opcodes.F2L, 209, 205}, new int[]{Opcodes.INSTANCEOF, 157, 49, Opcodes.I2S, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, Opcodes.L2I, Opcodes.MULTIANEWARRAY, Opcodes.RET, 85, 44, Opcodes.IINC}, new int[]{Opcodes.INVOKEINTERFACE, Opcodes.I2L, Opcodes.NEWARRAY, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, Opcodes.L2D, 203, Opcodes.NEW, Opcodes.F2I, 206, 196, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, Opcodes.LOR, Opcodes.ARETURN, 106, 107, 110, 119, Opcodes.I2C}, new int[]{16, 48, Opcodes.D2F, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, Opcodes.L2F, 200, Opcodes.GETSTATIC, 112, Opcodes.LUSHR, Opcodes.IF_ICMPLE}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, Opcodes.PUTSTATIC, 115}, new int[]{Opcodes.I2F, Opcodes.ATHROW, Opcodes.DCMPL, 31, 93, 68, 204, Opcodes.ARRAYLENGTH}, new int[]{Opcodes.LCMP, 22, 66, Opcodes.IFNULL, Opcodes.IRETURN, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, Opcodes.CHECKCAST, 154, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, 175}, new int[]{103, 98, 83, 38, 114, Opcodes.LXOR, Opcodes.INVOKEVIRTUAL, 124}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, Opcodes.LAND, Opcodes.TABLESWITCH, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, Opcodes.I2D, Opcodes.MONITORENTER, Opcodes.IF_ICMPNE, 58, Opcodes.FRETURN, 100, 89}};
    public static final int[][] l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<a> m = new ArrayList(11);
    public final List<b> n = new ArrayList();
    public final int[] o = new int[2];
    public boolean p;

    public static Result n(List<a> list) throws NotFoundException, FormatException {
        j aVar;
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f1865b == null) {
            size--;
        }
        b.i.e.n.a aVar2 = new b.i.e.n.a(size * 12);
        int i2 = list.get(0).f1865b.a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                aVar2.j(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            a aVar3 = list.get(i5);
            int i6 = aVar3.a.a;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i6) != 0) {
                    aVar2.j(i3);
                }
                i3++;
            }
            b.i.e.q.r.b bVar = aVar3.f1865b;
            if (bVar != null) {
                int i8 = bVar.a;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        aVar2.j(i3);
                    }
                    i3++;
                }
            }
        }
        if (aVar2.b(1)) {
            aVar = new g(aVar2);
        } else if (aVar2.b(2)) {
            int iD = s.d(aVar2, 1, 4);
            if (iD == 4) {
                aVar = new b.i.e.q.r.f.d.a(aVar2);
            } else if (iD != 5) {
                int iD2 = s.d(aVar2, 1, 5);
                if (iD2 == 12) {
                    aVar = new b.i.e.q.r.f.d.c(aVar2);
                } else if (iD2 != 13) {
                    switch (s.d(aVar2, 1, 7)) {
                        case 56:
                            aVar = new e(aVar2, "310", "11");
                            break;
                        case 57:
                            aVar = new e(aVar2, "320", "11");
                            break;
                        case 58:
                            aVar = new e(aVar2, "310", "13");
                            break;
                        case 59:
                            aVar = new e(aVar2, "320", "13");
                            break;
                        case 60:
                            aVar = new e(aVar2, "310", "15");
                            break;
                        case 61:
                            aVar = new e(aVar2, "320", "15");
                            break;
                        case 62:
                            aVar = new e(aVar2, "310", "17");
                            break;
                        case 63:
                            aVar = new e(aVar2, "320", "17");
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar2)));
                    }
                } else {
                    aVar = new d(aVar2);
                }
            } else {
                aVar = new b.i.e.q.r.f.d.b(aVar2);
            }
        } else {
            aVar = new k(aVar2);
        }
        String strA = aVar.a();
        b.i.e.k[] kVarArr = list.get(0).c.c;
        b.i.e.k[] kVarArr2 = list.get(list.size() - 1).c.c;
        return new Result(strA, null, new b.i.e.k[]{kVarArr[0], kVarArr[1], kVarArr2[0], kVarArr2[1]}, b.i.e.a.RSS_EXPANDED);
    }

    public static void r(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    @Override // b.i.e.q.k
    public Result b(int i2, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException, FormatException {
        this.m.clear();
        this.p = false;
        try {
            return n(p(i2, aVar));
        } catch (NotFoundException unused) {
            this.m.clear();
            this.p = true;
            return n(p(i2, aVar));
        }
    }

    public final boolean k() {
        a aVar = this.m.get(0);
        b.i.e.q.r.b bVar = aVar.a;
        b.i.e.q.r.b bVar2 = aVar.f1865b;
        if (bVar2 == null) {
            return false;
        }
        int i2 = bVar2.f1863b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.m.size(); i4++) {
            a aVar2 = this.m.get(i4);
            i2 += aVar2.a.f1863b;
            i3++;
            b.i.e.q.r.b bVar3 = aVar2.f1865b;
            if (bVar3 != null) {
                i2 += bVar3.f1863b;
                i3++;
            }
        }
        return ((i3 + (-4)) * 211) + (i2 % 211) == bVar.a;
    }

    public final List<a> l(List<b> list, int i2) throws NotFoundException {
        boolean z2;
        while (i2 < this.n.size()) {
            b bVar = this.n.get(i2);
            this.m.clear();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                this.m.addAll(it.next().a);
            }
            this.m.addAll(bVar.a);
            List<a> list2 = this.m;
            boolean z3 = false;
            for (int[] iArr : l) {
                if (list2.size() <= iArr.length) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list2.size()) {
                            z2 = true;
                            break;
                        }
                        if (list2.get(i3).c.a != iArr[i3]) {
                            z2 = false;
                            break;
                        }
                        i3++;
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                if (k()) {
                    return this.m;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(bVar);
                try {
                    return l(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i2++;
        }
        throw NotFoundException.l;
    }

    public final List<a> m(boolean z2) {
        List<a> listL = null;
        if (this.n.size() > 25) {
            this.n.clear();
            return null;
        }
        this.m.clear();
        if (z2) {
            Collections.reverse(this.n);
        }
        try {
            listL = l(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z2) {
            Collections.reverse(this.n);
        }
        return listL;
    }

    public b.i.e.q.r.b o(b.i.e.n.a aVar, b.i.e.q.r.c cVar, boolean z2, boolean z3) throws NotFoundException {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int[] iArr = this.f1862b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z3) {
            b.i.e.q.k.f(aVar, cVar.f1864b[0], iArr);
        } else {
            b.i.e.q.k.e(aVar, cVar.f1864b[1], iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        float fH1 = f.h1(iArr) / 17.0f;
        int[] iArr2 = cVar.f1864b;
        float f = (iArr2[1] - iArr2[0]) / 15.0f;
        if (Math.abs(fH1 - f) / f > 0.3f) {
            throw NotFoundException.l;
        }
        int[] iArr3 = this.e;
        int[] iArr4 = this.f;
        float[] fArr = this.c;
        float[] fArr2 = this.d;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f2 = (iArr[i5] * 1.0f) / fH1;
            int i6 = (int) (0.5f + f2);
            if (i6 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.l;
                }
                i6 = 1;
            } else if (i6 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.l;
                }
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArr3[i7] = i6;
                fArr[i7] = f2 - i6;
            } else {
                iArr4[i7] = i6;
                fArr2[i7] = f2 - i6;
            }
        }
        int iH1 = f.h1(this.e);
        int iH2 = f.h1(this.f);
        if (iH1 > 13) {
            z4 = false;
            z5 = true;
        } else {
            z4 = iH1 < 4;
            z5 = false;
        }
        if (iH2 > 13) {
            z6 = false;
            z7 = true;
        } else {
            z6 = iH2 < 4;
            z7 = false;
        }
        int i8 = (iH1 + iH2) - 17;
        boolean z8 = (iH1 & 1) == 1;
        boolean z9 = (iH2 & 1) == 0;
        if (i8 == 1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.l;
                }
                z5 = true;
            } else {
                if (!z9) {
                    throw NotFoundException.l;
                }
                z7 = true;
            }
        } else if (i8 != -1) {
            if (i8 != 0) {
                throw NotFoundException.l;
            }
            if (z8) {
                if (!z9) {
                    throw NotFoundException.l;
                }
                if (iH1 < iH2) {
                    z4 = true;
                    z7 = true;
                } else {
                    z6 = true;
                    z5 = true;
                }
            } else if (z9) {
                throw NotFoundException.l;
            }
        } else if (z8) {
            if (z9) {
                throw NotFoundException.l;
            }
            z4 = true;
        } else {
            if (!z9) {
                throw NotFoundException.l;
            }
            z6 = true;
        }
        if (z4) {
            if (z5) {
                throw NotFoundException.l;
            }
            b.i.e.q.r.a.h(this.e, this.c);
        }
        if (z5) {
            b.i.e.q.r.a.g(this.e, this.c);
        }
        if (z6) {
            if (z7) {
                throw NotFoundException.l;
            }
            b.i.e.q.r.a.h(this.f, this.c);
        }
        if (z7) {
            b.i.e.q.r.a.g(this.f, this.d);
        }
        int i9 = (((cVar.a * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
        int i10 = 0;
        int i11 = 0;
        for (int length2 = iArr3.length - 1; length2 >= 0; length2--) {
            if ((cVar.a == 0 && z2 && z3) ? false : true) {
                i10 += iArr3[length2] * k[i9][length2 * 2];
            }
            i11 += iArr3[length2];
        }
        int i12 = 0;
        for (int length3 = iArr4.length - 1; length3 >= 0; length3--) {
            if ((cVar.a == 0 && z2 && z3) ? false : true) {
                i12 += iArr4[length3] * k[i9][(length3 * 2) + 1];
            }
        }
        int i13 = i10 + i12;
        if ((i11 & 1) != 0 || i11 > 13 || i11 < 4) {
            throw NotFoundException.l;
        }
        int i14 = (13 - i11) / 2;
        int i15 = g[i14];
        return new b.i.e.q.r.b((f.p0(iArr3, i15, true) * h[i14]) + f.p0(iArr4, 9 - i15, false) + i[i14], i13);
    }

    public List<a> p(int i2, b.i.e.n.a aVar) throws NotFoundException {
        boolean zEquals;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                List<a> list = this.m;
                list.add(q(aVar, list, i2));
            } catch (NotFoundException e) {
                if (this.m.isEmpty()) {
                    throw e;
                }
                z7 = true;
            }
        }
        if (k()) {
            return this.m;
        }
        boolean z8 = !this.n.isEmpty();
        int i3 = 0;
        boolean zEquals2 = false;
        while (true) {
            if (i3 >= this.n.size()) {
                zEquals = false;
                break;
            }
            b bVar = this.n.get(i3);
            if (bVar.f1866b > i2) {
                zEquals = bVar.a.equals(this.m);
                break;
            }
            zEquals2 = bVar.a.equals(this.m);
            i3++;
        }
        if (!zEquals && !zEquals2) {
            List<a> list2 = this.m;
            Iterator<T> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                b bVar2 = (b) it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        break;
                    }
                    a aVar2 = (a) it2.next();
                    Iterator<a> it3 = bVar2.a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z6 = false;
                            break;
                        }
                        if (aVar2.equals(it3.next())) {
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
                this.n.add(i3, new b(this.m, i2, false));
                List<a> list3 = this.m;
                Iterator<b> it4 = this.n.iterator();
                while (it4.hasNext()) {
                    b next = it4.next();
                    if (next.a.size() != list3.size()) {
                        Iterator<a> it5 = next.a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            a next2 = it5.next();
                            Iterator<a> it6 = list3.iterator();
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
            List<a> listM = m(false);
            if (listM != null) {
                return listM;
            }
            List<a> listM2 = m(true);
            if (listM2 != null) {
                return listM2;
            }
        }
        throw NotFoundException.l;
    }

    public a q(b.i.e.n.a aVar, List<a> list, int i2) throws NotFoundException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        b.i.e.q.r.c cVar;
        int i8 = 2;
        int i9 = 0;
        boolean z2 = list.size() % 2 == 0;
        if (this.p) {
            z2 = !z2;
        }
        int iF = -1;
        boolean z3 = true;
        while (true) {
            int[] iArr = this.a;
            iArr[i9] = i9;
            iArr[1] = i9;
            iArr[i8] = i9;
            iArr[3] = i9;
            int i10 = aVar.k;
            if (iF >= 0) {
                i3 = iF;
            } else {
                i3 = list.isEmpty() ? 0 : list.get(list.size() - 1).c.f1864b[1];
            }
            boolean z4 = list.size() % i8 != 0;
            if (this.p) {
                z4 = !z4;
            }
            boolean z5 = false;
            while (i3 < i10) {
                z5 = !aVar.b(i3);
                if (!z5) {
                    break;
                }
                i3++;
            }
            boolean z6 = z5;
            int i11 = 0;
            int i12 = i3;
            while (true) {
                if (i3 >= i10) {
                    throw NotFoundException.l;
                }
                if (aVar.b(i3) != z6) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (i11 == 3) {
                        if (z4) {
                            r(iArr);
                        }
                        if (b.i.e.q.r.a.i(iArr)) {
                            break;
                        }
                        if (z4) {
                            r(iArr);
                        }
                        i12 = iArr[0] + iArr[1] + i12;
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = 0;
                        iArr[3] = 0;
                        i11--;
                    } else {
                        i11++;
                    }
                    iArr[i11] = 1;
                    z6 = !z6;
                }
                i3++;
            }
            int[] iArr2 = this.o;
            iArr2[0] = i12;
            iArr2[1] = i3;
            if (z2) {
                int i13 = iArr2[0] - 1;
                while (i13 >= 0 && !aVar.b(i13)) {
                    i13--;
                }
                int i14 = i13 + 1;
                int[] iArr3 = this.o;
                i4 = 0;
                i5 = iArr3[0] - i14;
                i7 = i14;
                i6 = iArr3[1];
            } else {
                i4 = 0;
                int i15 = iArr2[0];
                int iG = aVar.g(iArr2[1] + 1);
                i5 = iG - this.o[1];
                i6 = iG;
                i7 = i15;
            }
            int[] iArr4 = this.a;
            System.arraycopy(iArr4, i4, iArr4, 1, iArr4.length - 1);
            iArr4[i4] = i5;
            b.i.e.q.r.b bVarO = null;
            try {
                int iJ = b.i.e.q.r.a.j(iArr4, j);
                int[] iArr5 = new int[2];
                iArr5[i4] = i7;
                iArr5[1] = i6;
                cVar = new b.i.e.q.r.c(iJ, iArr5, i7, i6, i2);
            } catch (NotFoundException unused) {
                cVar = null;
            }
            if (cVar == null) {
                int i16 = this.o[0];
                iF = aVar.b(i16) ? aVar.f(aVar.g(i16)) : aVar.g(aVar.f(i16));
            } else {
                z3 = false;
            }
            if (!z3) {
                b.i.e.q.r.b bVarO2 = o(aVar, cVar, z2, true);
                if (!list.isEmpty()) {
                    if (list.get(list.size() - 1).f1865b == null) {
                        throw NotFoundException.l;
                    }
                }
                try {
                    bVarO = o(aVar, cVar, z2, false);
                } catch (NotFoundException unused2) {
                }
                return new a(bVarO2, bVarO, cVar, true);
            }
            i8 = 2;
            i9 = 0;
        }
    }

    @Override // b.i.e.q.k, b.i.e.i
    public void reset() {
        this.m.clear();
        this.n.clear();
    }
}
