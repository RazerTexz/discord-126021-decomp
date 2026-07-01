package g0;

import d0.t.AbstractList;
import d0.t.Collections2;
import d0.t.MutableCollectionsJVM;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* JADX INFO: renamed from: g0.o, reason: use source file name */
/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Options2 extends AbstractList<ByteString> implements RandomAccess {
    public static final a k = new a(null);
    public final ByteString[] l;
    public final int[] m;

    /* JADX INFO: renamed from: g0.o$a */
    /* JADX INFO: compiled from: Options.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(long j, Buffer3 buffer3, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) throws IOException {
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
                long jB = b(buffer3) + j + ((long) 2) + ((long) i10) + 1;
                buffer3.W(-i10);
                buffer3.W(i5);
                int i12 = i7 + i10;
                while (i7 < i12) {
                    buffer3.W(byteString.m(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (!(i12 == list.get(i4).j())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer3.W(list2.get(i4).intValue());
                    return;
                } else {
                    Buffer3 buffer4 = new Buffer3();
                    buffer3.W(((int) (b(buffer4) + jB)) * (-1));
                    a(jB, buffer4, i12, list, i4, i3, list2);
                    buffer3.P(buffer4);
                    return;
                }
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (list.get(i14 - 1).m(i7) != list.get(i14).m(i7)) {
                    i13++;
                }
            }
            long jB2 = b(buffer3) + j + ((long) 2) + ((long) (i13 * 2));
            buffer3.W(i13);
            buffer3.W(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                byte bM = list.get(i15).m(i7);
                if (i15 == i4 || bM != list.get(i15 - 1).m(i7)) {
                    buffer3.W(bM & 255);
                }
            }
            Buffer3 buffer5 = new Buffer3();
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
                    buffer3.W(list2.get(i4).intValue());
                } else {
                    buffer3.W(((int) (b(buffer5) + jB2)) * (-1));
                    a(jB2, buffer5, i7 + 1, list, i4, i6, list2);
                }
                buffer5 = buffer5;
                i4 = i6;
            }
            buffer3.P(buffer5);
        }

        public final long b(Buffer3 buffer3) {
            return buffer3.k / ((long) 4);
        }

        public final Options2 c(ByteString... byteStringArr) throws IOException {
            Intrinsics3.checkParameterIsNotNull(byteStringArr, "byteStrings");
            int i = 0;
            if (byteStringArr.length == 0) {
                return new Options2(new ByteString[0], new int[]{0, -1}, null);
            }
            List<? extends ByteString> mutableList = _Arrays.toMutableList(byteStringArr);
            MutableCollectionsJVM.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List<Integer> listMutableListOf = Collections2.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listMutableListOf.set(Collections2.binarySearch$default(mutableList, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
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
                    Intrinsics3.checkParameterIsNotNull(byteString2, "prefix");
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
            Buffer3 buffer3 = new Buffer3();
            a(0L, buffer3, 0, mutableList, 0, mutableList.size(), listMutableListOf);
            int[] iArr = new int[(int) b(buffer3)];
            while (!buffer3.w()) {
                iArr[i] = buffer3.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
            Intrinsics3.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new Options2((ByteString[]) objArrCopyOf, iArr, null);
        }
    }

    public Options2(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.l = byteStringArr;
        this.m = iArr;
    }

    @Override // d0.t.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // d0.t.AbstractList, java.util.List
    public Object get(int i) {
        return this.l[i];
    }

    @Override // d0.t.AbstractCollection
    public int getSize() {
        return this.l.length;
    }

    @Override // d0.t.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // d0.t.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
