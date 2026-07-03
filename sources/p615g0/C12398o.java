package p615g0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;
import p507d0.p580t.AbstractC12125c;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12153q;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.o */
/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12398o extends AbstractC12125c<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: k */
    public static final a f26106k = new a(null);

    /* JADX INFO: renamed from: l */
    public final ByteString[] f26107l;

    /* JADX INFO: renamed from: m */
    public final int[] f26108m;

    /* JADX INFO: renamed from: g0.o$a */
    /* JADX INFO: compiled from: Options.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m10489a(long j, C12388e c12388e, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) throws IOException {
            int i4;
            int i5;
            int i6;
            int i7 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (!(list.get(i8).mo10502j() >= i7)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i7 == byteString.mo10502j()) {
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
            if (byteString.mo10505m(i7) == byteString2.mo10505m(i7)) {
                int iMin = Math.min(byteString.mo10502j(), byteString2.mo10502j());
                int i10 = 0;
                for (int i11 = i7; i11 < iMin && byteString.mo10505m(i11) == byteString2.mo10505m(i11); i11++) {
                    i10++;
                }
                long jM10490b = m10490b(c12388e) + j + ((long) 2) + ((long) i10) + 1;
                c12388e.m10447W(-i10);
                c12388e.m10447W(i5);
                int i12 = i7 + i10;
                while (i7 < i12) {
                    c12388e.m10447W(byteString.mo10505m(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (!(i12 == list.get(i4).mo10502j())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    c12388e.m10447W(list2.get(i4).intValue());
                    return;
                } else {
                    C12388e c12388e2 = new C12388e();
                    c12388e.m10447W(((int) (m10490b(c12388e2) + jM10490b)) * (-1));
                    m10489a(jM10490b, c12388e2, i12, list, i4, i3, list2);
                    c12388e.mo10440P(c12388e2);
                    return;
                }
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (list.get(i14 - 1).mo10505m(i7) != list.get(i14).mo10505m(i7)) {
                    i13++;
                }
            }
            long jM10490b2 = m10490b(c12388e) + j + ((long) 2) + ((long) (i13 * 2));
            c12388e.m10447W(i13);
            c12388e.m10447W(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                byte bMo10505m = list.get(i15).mo10505m(i7);
                if (i15 == i4 || bMo10505m != list.get(i15 - 1).mo10505m(i7)) {
                    c12388e.m10447W(bMo10505m & 255);
                }
            }
            C12388e c12388e3 = new C12388e();
            while (i4 < i3) {
                byte bMo10505m2 = list.get(i4).mo10505m(i7);
                int i16 = i4 + 1;
                int i17 = i16;
                while (true) {
                    if (i17 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (bMo10505m2 != list.get(i17).mo10505m(i7)) {
                            i6 = i17;
                            break;
                        }
                        i17++;
                    }
                }
                if (i16 == i6 && i7 + 1 == list.get(i4).mo10502j()) {
                    c12388e.m10447W(list2.get(i4).intValue());
                } else {
                    c12388e.m10447W(((int) (m10490b(c12388e3) + jM10490b2)) * (-1));
                    m10489a(jM10490b2, c12388e3, i7 + 1, list, i4, i6, list2);
                }
                c12388e3 = c12388e3;
                i4 = i6;
            }
            c12388e.mo10440P(c12388e3);
        }

        /* JADX INFO: renamed from: b */
        public final long m10490b(C12388e c12388e) {
            return c12388e.f26080k / ((long) 4);
        }

        /* JADX INFO: renamed from: c */
        public final C12398o m10491c(ByteString... byteStringArr) throws IOException {
            C12238m.checkParameterIsNotNull(byteStringArr, "byteStrings");
            int i = 0;
            if (byteStringArr.length == 0) {
                return new C12398o(new ByteString[0], new int[]{0, -1}, null);
            }
            List<? extends ByteString> mutableList = C12141k.toMutableList(byteStringArr);
            C12153q.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List<Integer> listMutableListOf = C12147n.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listMutableListOf.set(C12147n.binarySearch$default(mutableList, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (!(mutableList.get(0).mo10502j() > 0)) {
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
                    C12238m.checkParameterIsNotNull(byteString2, "prefix");
                    if (!byteString3.mo10506n(0, byteString2, 0, byteString2.mo10502j())) {
                        break;
                    }
                    if (!(byteString3.mo10502j() != byteString2.mo10502j())) {
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
            C12388e c12388e = new C12388e();
            m10489a(0L, c12388e, 0, mutableList, 0, mutableList.size(), listMutableListOf);
            int[] iArr = new int[(int) m10490b(c12388e)];
            while (!c12388e.mo10472w()) {
                iArr[i] = c12388e.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
            C12238m.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new C12398o((ByteString[]) objArrCopyOf, iArr, null);
        }
    }

    public C12398o(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f26107l = byteStringArr;
        this.f26108m = iArr;
    }

    @Override // p507d0.p580t.AbstractC12121a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.List
    public Object get(int i) {
        return this.f26107l[i];
    }

    @Override // p507d0.p580t.AbstractC12121a
    public int getSize() {
        return this.f26107l.length;
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
