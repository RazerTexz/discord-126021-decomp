package b.i.e.q.r.f;

import b.i.a.f.e.o.f;
import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import b.i.e.q.OneDReader;
import b.i.e.q.r.AbstractRSSReader;
import b.i.e.q.r.DataCharacter;
import b.i.e.q.r.FinderPattern;
import b.i.e.q.r.f.d.AI013103decoder;
import b.i.e.q.r.f.d.AI01320xDecoder;
import b.i.e.q.r.f.d.AI01392xDecoder;
import b.i.e.q.r.f.d.AI01393xDecoder;
import b.i.e.q.r.f.d.AI013x0x1xDecoder;
import b.i.e.q.r.f.d.AI01AndOtherAIs;
import b.i.e.q.r.f.d.AbstractExpandedDecoder;
import b.i.e.q.r.f.d.AnyAIDecoder;
import b.i.e.q.r.f.d.GeneralAppIdDecoder;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.q.r.f.c, reason: use source file name */
/* JADX INFO: compiled from: RSSExpandedReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    public static final int[] g = {7, 5, 4, 3, 1};
    public static final int[] h = {4, 20, 52, 104, 204};
    public static final int[] i = {0, 348, 1388, 2948, 3988};
    public static final int[][] j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Opcodes.D2L, 7, 21, 63}, new int[]{Opcodes.ANEWARRAY, Opcodes.I2B, 13, 39, 117, Opcodes.F2L, 209, 205}, new int[]{Opcodes.INSTANCEOF, 157, 49, Opcodes.I2S, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, Opcodes.L2I, Opcodes.MULTIANEWARRAY, Opcodes.RET, 85, 44, Opcodes.IINC}, new int[]{Opcodes.INVOKEINTERFACE, Opcodes.I2L, Opcodes.NEWARRAY, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, Opcodes.L2D, 203, Opcodes.NEW, Opcodes.F2I, 206, 196, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, Opcodes.LOR, Opcodes.ARETURN, 106, 107, 110, 119, Opcodes.I2C}, new int[]{16, 48, Opcodes.D2F, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, Opcodes.L2F, 200, Opcodes.GETSTATIC, 112, Opcodes.LUSHR, Opcodes.IF_ICMPLE}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, Opcodes.PUTSTATIC, 115}, new int[]{Opcodes.I2F, Opcodes.ATHROW, Opcodes.DCMPL, 31, 93, 68, 204, Opcodes.ARRAYLENGTH}, new int[]{Opcodes.LCMP, 22, 66, Opcodes.IFNULL, Opcodes.IRETURN, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, Opcodes.CHECKCAST, 154, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, 175}, new int[]{103, 98, 83, 38, 114, Opcodes.LXOR, Opcodes.INVOKEVIRTUAL, 124}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, Opcodes.LAND, Opcodes.TABLESWITCH, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, Opcodes.I2D, Opcodes.MONITORENTER, Opcodes.IF_ICMPNE, 58, Opcodes.FRETURN, 100, 89}};
    public static final int[][] l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<ExpandedPair> m = new ArrayList(11);
    public final List<ExpandedRow> n = new ArrayList();
    public final int[] o = new int[2];
    public boolean p;

    public static Result n(List<ExpandedPair> list) throws NotFoundException, FormatException {
        AbstractExpandedDecoder aI013103decoder;
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f1865b == null) {
            size--;
        }
        BitArray bitArray = new BitArray(size * 12);
        int i2 = list.get(0).f1865b.a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                bitArray.j(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            ExpandedPair expandedPair = list.get(i5);
            int i6 = expandedPair.a.a;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i6) != 0) {
                    bitArray.j(i3);
                }
                i3++;
            }
            DataCharacter dataCharacter = expandedPair.f1865b;
            if (dataCharacter != null) {
                int i8 = dataCharacter.a;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        bitArray.j(i3);
                    }
                    i3++;
                }
            }
        }
        if (bitArray.b(1)) {
            aI013103decoder = new AI01AndOtherAIs(bitArray);
        } else if (bitArray.b(2)) {
            int iD = GeneralAppIdDecoder.d(bitArray, 1, 4);
            if (iD == 4) {
                aI013103decoder = new AI013103decoder(bitArray);
            } else if (iD != 5) {
                int iD2 = GeneralAppIdDecoder.d(bitArray, 1, 5);
                if (iD2 == 12) {
                    aI013103decoder = new AI01392xDecoder(bitArray);
                } else if (iD2 != 13) {
                    switch (GeneralAppIdDecoder.d(bitArray, 1, 7)) {
                        case 56:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "310", "11");
                            break;
                        case 57:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "320", "11");
                            break;
                        case 58:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "310", "13");
                            break;
                        case 59:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "320", "13");
                            break;
                        case 60:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "310", "15");
                            break;
                        case 61:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "320", "15");
                            break;
                        case 62:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "310", "17");
                            break;
                        case 63:
                            aI013103decoder = new AI013x0x1xDecoder(bitArray, "320", "17");
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(bitArray)));
                    }
                } else {
                    aI013103decoder = new AI01393xDecoder(bitArray);
                }
            } else {
                aI013103decoder = new AI01320xDecoder(bitArray);
            }
        } else {
            aI013103decoder = new AnyAIDecoder(bitArray);
        }
        String strA = aI013103decoder.a();
        ResultPoint[] resultPointArr = list.get(0).c.c;
        ResultPoint[] resultPointArr2 = list.get(list.size() - 1).c.c;
        return new Result(strA, null, new ResultPoint[]{resultPointArr[0], resultPointArr[1], resultPointArr2[0], resultPointArr2[1]}, BarcodeFormat.RSS_EXPANDED);
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

    @Override // b.i.e.q.OneDReader
    public Result b(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.m.clear();
        this.p = false;
        try {
            return n(p(i2, bitArray));
        } catch (NotFoundException unused) {
            this.m.clear();
            this.p = true;
            return n(p(i2, bitArray));
        }
    }

    public final boolean k() {
        ExpandedPair expandedPair = this.m.get(0);
        DataCharacter dataCharacter = expandedPair.a;
        DataCharacter dataCharacter2 = expandedPair.f1865b;
        if (dataCharacter2 == null) {
            return false;
        }
        int i2 = dataCharacter2.f1863b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.m.size(); i4++) {
            ExpandedPair expandedPair2 = this.m.get(i4);
            i2 += expandedPair2.a.f1863b;
            i3++;
            DataCharacter dataCharacter3 = expandedPair2.f1865b;
            if (dataCharacter3 != null) {
                i2 += dataCharacter3.f1863b;
                i3++;
            }
        }
        return ((i3 + (-4)) * 211) + (i2 % 211) == dataCharacter.a;
    }

    public final List<ExpandedPair> l(List<ExpandedRow> list, int i2) throws NotFoundException {
        boolean z2;
        while (i2 < this.n.size()) {
            ExpandedRow expandedRow = this.n.get(i2);
            this.m.clear();
            Iterator<ExpandedRow> it = list.iterator();
            while (it.hasNext()) {
                this.m.addAll(it.next().a);
            }
            this.m.addAll(expandedRow.a);
            List<ExpandedPair> list2 = this.m;
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
                arrayList.add(expandedRow);
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

    public final List<ExpandedPair> m(boolean z2) {
        List<ExpandedPair> listL = null;
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

    public DataCharacter o(BitArray bitArray, FinderPattern finderPattern, boolean z2, boolean z3) throws NotFoundException {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int[] iArr = this.f1862b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z3) {
            OneDReader.f(bitArray, finderPattern.f1864b[0], iArr);
        } else {
            OneDReader.e(bitArray, finderPattern.f1864b[1], iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        float fH1 = f.h1(iArr) / 17.0f;
        int[] iArr2 = finderPattern.f1864b;
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
            AbstractRSSReader.h(this.e, this.c);
        }
        if (z5) {
            AbstractRSSReader.g(this.e, this.c);
        }
        if (z6) {
            if (z7) {
                throw NotFoundException.l;
            }
            AbstractRSSReader.h(this.f, this.c);
        }
        if (z7) {
            AbstractRSSReader.g(this.f, this.d);
        }
        int i9 = (((finderPattern.a * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
        int i10 = 0;
        int i11 = 0;
        for (int length2 = iArr3.length - 1; length2 >= 0; length2--) {
            if ((finderPattern.a == 0 && z2 && z3) ? false : true) {
                i10 += iArr3[length2] * k[i9][length2 * 2];
            }
            i11 += iArr3[length2];
        }
        int i12 = 0;
        for (int length3 = iArr4.length - 1; length3 >= 0; length3--) {
            if ((finderPattern.a == 0 && z2 && z3) ? false : true) {
                i12 += iArr4[length3] * k[i9][(length3 * 2) + 1];
            }
        }
        int i13 = i10 + i12;
        if ((i11 & 1) != 0 || i11 > 13 || i11 < 4) {
            throw NotFoundException.l;
        }
        int i14 = (13 - i11) / 2;
        int i15 = g[i14];
        return new DataCharacter((f.p0(iArr3, i15, true) * h[i14]) + f.p0(iArr4, 9 - i15, false) + i[i14], i13);
    }

    public List<ExpandedPair> p(int i2, BitArray bitArray) throws NotFoundException {
        boolean zEquals;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                List<ExpandedPair> list = this.m;
                list.add(q(bitArray, list, i2));
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
            ExpandedRow expandedRow = this.n.get(i3);
            if (expandedRow.f1866b > i2) {
                zEquals = expandedRow.a.equals(this.m);
                break;
            }
            zEquals2 = expandedRow.a.equals(this.m);
            i3++;
        }
        if (!zEquals && !zEquals2) {
            List<ExpandedPair> list2 = this.m;
            Iterator<T> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                ExpandedRow expandedRow2 = (ExpandedRow) it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        break;
                    }
                    ExpandedPair expandedPair = (ExpandedPair) it2.next();
                    Iterator<ExpandedPair> it3 = expandedRow2.a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z6 = false;
                            break;
                        }
                        if (expandedPair.equals(it3.next())) {
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
                this.n.add(i3, new ExpandedRow(this.m, i2, false));
                List<ExpandedPair> list3 = this.m;
                Iterator<ExpandedRow> it4 = this.n.iterator();
                while (it4.hasNext()) {
                    ExpandedRow next = it4.next();
                    if (next.a.size() != list3.size()) {
                        Iterator<ExpandedPair> it5 = next.a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            ExpandedPair next2 = it5.next();
                            Iterator<ExpandedPair> it6 = list3.iterator();
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
            List<ExpandedPair> listM = m(false);
            if (listM != null) {
                return listM;
            }
            List<ExpandedPair> listM2 = m(true);
            if (listM2 != null) {
                return listM2;
            }
        }
        throw NotFoundException.l;
    }

    public ExpandedPair q(BitArray bitArray, List<ExpandedPair> list, int i2) throws NotFoundException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        FinderPattern finderPattern;
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
            int i10 = bitArray.k;
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
                z5 = !bitArray.b(i3);
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
                if (bitArray.b(i3) != z6) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    if (i11 == 3) {
                        if (z4) {
                            r(iArr);
                        }
                        if (AbstractRSSReader.i(iArr)) {
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
                while (i13 >= 0 && !bitArray.b(i13)) {
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
                int iG = bitArray.g(iArr2[1] + 1);
                i5 = iG - this.o[1];
                i6 = iG;
                i7 = i15;
            }
            int[] iArr4 = this.a;
            System.arraycopy(iArr4, i4, iArr4, 1, iArr4.length - 1);
            iArr4[i4] = i5;
            DataCharacter dataCharacterO = null;
            try {
                int iJ = AbstractRSSReader.j(iArr4, j);
                int[] iArr5 = new int[2];
                iArr5[i4] = i7;
                iArr5[1] = i6;
                finderPattern = new FinderPattern(iJ, iArr5, i7, i6, i2);
            } catch (NotFoundException unused) {
                finderPattern = null;
            }
            if (finderPattern == null) {
                int i16 = this.o[0];
                iF = bitArray.b(i16) ? bitArray.f(bitArray.g(i16)) : bitArray.g(bitArray.f(i16));
            } else {
                z3 = false;
            }
            if (!z3) {
                DataCharacter dataCharacterO2 = o(bitArray, finderPattern, z2, true);
                if (!list.isEmpty()) {
                    if (list.get(list.size() - 1).f1865b == null) {
                        throw NotFoundException.l;
                    }
                }
                try {
                    dataCharacterO = o(bitArray, finderPattern, z2, false);
                } catch (NotFoundException unused2) {
                }
                return new ExpandedPair(dataCharacterO2, dataCharacterO, finderPattern, true);
            }
            i8 = 2;
            i9 = 0;
        }
    }

    @Override // b.i.e.q.OneDReader, b.i.e.Reader
    public void reset() {
        this.m.clear();
        this.n.clear();
    }
}
