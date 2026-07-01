package g0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$a {
    public o$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(long j, e eVar, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7 = i;
        if (!(i2 < i3)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (!(list.get(i8).j() >= i7)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        if (i7 == byteString.j()) {
            int iIntValue = list2.get(i2).intValue();
            int i9 = i2 + 1;
            ByteString byteString3 = list.get(i9);
            i4 = i9;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (byteString.m(i7) == byteString2.m(i7)) {
            int iMin = Math.min(byteString.j(), byteString2.j());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && byteString.m(i11) == byteString2.m(i11); i11++) {
                i10++;
            }
            long jB = b(eVar) + j + ((long) 2) + ((long) i10) + 1;
            eVar.W(-i10);
            eVar.W(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                eVar.W(byteString.m(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (!(i12 == list.get(i4).j())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                eVar.W(list2.get(i4).intValue());
                return;
            } else {
                e eVar2 = new e();
                eVar.W(((int) (b(eVar2) + jB)) * (-1));
                a(jB, eVar2, i12, list, i4, i3, list2);
                eVar.P(eVar2);
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (list.get(i14 - 1).m(i7) != list.get(i14).m(i7)) {
                i13++;
            }
        }
        long jB2 = b(eVar) + j + ((long) 2) + ((long) (i13 * 2));
        eVar.W(i13);
        eVar.W(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            byte bM = list.get(i15).m(i7);
            if (i15 == i4 || bM != list.get(i15 - 1).m(i7)) {
                eVar.W(bM & 255);
            }
        }
        e eVar3 = new e();
        while (i4 < i3) {
            byte bM2 = list.get(i4).m(i7);
            int i16 = i4 + 1;
            int i17 = i16;
            while (true) {
                if (i17 >= i3) {
                    i6 = i3;
                    break;
                } else {
                    if (bM2 != list.get(i17).m(i7)) {
                        i6 = i17;
                        break;
                    }
                    i17++;
                }
            }
            if (i16 == i6 && i7 + 1 == list.get(i4).j()) {
                eVar.W(list2.get(i4).intValue());
            } else {
                eVar.W(((int) (b(eVar3) + jB2)) * (-1));
                a(jB2, eVar3, i7 + 1, list, i4, i6, list2);
            }
            eVar3 = eVar3;
            i4 = i6;
        }
        eVar.P(eVar3);
    }

    public final long b(e eVar) {
        return eVar.k / ((long) 4);
    }

    public final o c(ByteString... byteStringArr) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteStringArr, "byteStrings");
        int i = 0;
        if (byteStringArr.length == 0) {
            return new o(new ByteString[0], new int[]{0, -1}, null);
        }
        List<? extends ByteString> mutableList = d0.t.k.toMutableList(byteStringArr);
        d0.t.q.sort(mutableList);
        ArrayList arrayList = new ArrayList(byteStringArr.length);
        for (ByteString byteString : byteStringArr) {
            arrayList.add(-1);
        }
        Object[] array = arrayList.toArray(new Integer[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Integer[] numArr = (Integer[]) array;
        List<Integer> listMutableListOf = d0.t.n.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
        int length = byteStringArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            listMutableListOf.set(d0.t.n.binarySearch$default(mutableList, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
            i2++;
            i3++;
        }
        if (!(mutableList.get(0).j() > 0)) {
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }
        int i4 = 0;
        while (i4 < mutableList.size()) {
            ByteString byteString2 = mutableList.get(i4);
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < mutableList.size()) {
                ByteString byteString3 = mutableList.get(i6);
                Objects.requireNonNull(byteString3);
                d0.z.d.m.checkParameterIsNotNull(byteString2, "prefix");
                if (!byteString3.n(0, byteString2, 0, byteString2.j())) {
                    break;
                }
                if (!(byteString3.j() != byteString2.j())) {
                    throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                }
                if (listMutableListOf.get(i6).intValue() > listMutableListOf.get(i4).intValue()) {
                    mutableList.remove(i6);
                    listMutableListOf.remove(i6);
                } else {
                    i6++;
                }
            }
            i4 = i5;
        }
        e eVar = new e();
        a(0L, eVar, 0, mutableList, 0, mutableList.size(), listMutableListOf);
        int[] iArr = new int[(int) b(eVar)];
        while (!eVar.w()) {
            iArr[i] = eVar.readInt();
            i++;
        }
        Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
        d0.z.d.m.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new o((ByteString[]) objArrCopyOf, iArr, null);
    }
}
