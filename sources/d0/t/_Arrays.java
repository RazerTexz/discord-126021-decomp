package d0.t;

import d0.Tuples;
import d0.c0.Random;
import d0.g0.Appendable;
import d0.z.d.ArrayIterator4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.g0.KMarkers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.t.k, reason: use source file name */
/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _Arrays extends _ArraysJvm {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.k$a */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, KMarkers {
        public final /* synthetic */ Object[] j;

        public a(Object[] objArr) {
            this.j = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ArrayIterator4.iterator(this.j);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.k$b */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class b<T> implements Sequence<T> {
        public final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return ArrayIterator4.iterator(this.a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.k$c */
    /* JADX INFO: compiled from: _Arrays.kt */
    public static final class c<T> extends Lambda implements Function0<Iterator<? extends T>> {
        public final /* synthetic */ Object[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object[] objArr) {
            super(0);
            this.$this_withIndex = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Iterator<T> invoke() {
            return ArrayIterator4.iterator(this.$this_withIndex);
        }
    }

    public static final <T> Iterable<T> asIterable(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$asIterable");
        return tArr.length == 0 ? Collections2.emptyList() : new a(tArr);
    }

    public static final <T> Sequence<T> asSequence(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$asSequence");
        return tArr.length == 0 ? d0.f0.n.emptySequence() : new b(tArr);
    }

    public static final <T> boolean contains(T[] tArr, T t) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$contains");
        return indexOf(tArr, t) >= 0;
    }

    public static final <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$filterNotNull");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C c2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$filterNotNullTo");
        Intrinsics3.checkNotNullParameter(c2, "destination");
        for (T t : tArr) {
            if (t != null) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T> T first(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$first");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static final <T> T firstOrNull(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$firstOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <T> Ranges2 getIndices(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$indices");
        return new Ranges2(0, getLastIndex(tArr));
    }

    public static final <T> int getLastIndex(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final <T> T getOrNull(T[] tArr, int i) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$getOrNull");
        if (i < 0 || i > getLastIndex(tArr)) {
            return null;
        }
        return tArr[i];
    }

    public static final <T> int indexOf(T[] tArr, T t) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (Intrinsics3.areEqual(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics3.checkNotNullParameter(tArr, "$this$joinTo");
        Intrinsics3.checkNotNullParameter(a2, "buffer");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            Appendable.appendElement(a2, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> String joinToString(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$joinToString");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
    }

    public static final <T> T last(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$last");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[getLastIndex(tArr)];
    }

    public static final int lastIndexOf(int[] iArr, int i) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$lastIndexOf");
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (i == iArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final <T, R> List<R> map(T[] tArr, Function1<? super T, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(function1.invoke(t));
        }
        return arrayList;
    }

    public static final <T> T random(T[] tArr, Random random) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$random");
        Intrinsics3.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[random.nextInt(tArr.length)];
    }

    public static final <T> T single(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$single");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T singleOrNull(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$sortedArrayWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics3.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOf(this, size)");
        _ArraysJvm.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static final <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$sortedWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        return _ArraysJvm.asList(sortedArrayWith(tArr, comparator));
    }

    public static final int sum(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$sum");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c2) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$toCollection");
        Intrinsics3.checkNotNullParameter(c2, "destination");
        for (T t : tArr) {
            c2.add(t);
        }
        return c2;
    }

    public static final int[] toIntArray(Integer[] numArr) {
        Intrinsics3.checkNotNullParameter(numArr, "$this$toIntArray");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static final <T> List<T> toList(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$toList");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? toMutableList(tArr) : CollectionsJVM.listOf(tArr[0]);
        }
        return Collections2.emptyList();
    }

    public static final <T> List<T> toMutableList(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$toMutableList");
        return new ArrayList(Collections2.asCollection(tArr));
    }

    public static final <T> Set<T> toSet(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$toSet");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(MapsJVM.mapCapacity(tArr.length))) : SetsJVM.setOf(tArr[0]);
        }
        return Sets5.emptySet();
    }

    public static final <T> Iterable<IndexedValue<T>> withIndex(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$withIndex");
        return new Iterables(new c(tArr));
    }

    public static final <T, R> List<Tuples2<T, R>> zip(T[] tArr, R[] rArr) {
        Intrinsics3.checkNotNullParameter(tArr, "$this$zip");
        Intrinsics3.checkNotNullParameter(rArr, "other");
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(Tuples.to(tArr[i], rArr[i]));
        }
        return arrayList;
    }

    public static final boolean contains(int[] iArr, int i) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$contains");
        return indexOf(iArr, i) >= 0;
    }

    public static final int getLastIndex(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$lastIndex");
        return iArr.length - 1;
    }

    public static final Integer getOrNull(int[] iArr, int i) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$getOrNull");
        if (i < 0 || i > getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static final String joinToString(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics3.checkNotNullParameter(bArr, "$this$joinToString");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        String string = ((StringBuilder) joinTo(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics3.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final boolean contains(char[] cArr, char c2) {
        Intrinsics3.checkNotNullParameter(cArr, "$this$contains");
        return indexOf(cArr, c2) >= 0;
    }

    public static final List<Short> toMutableList(short[] sArr) {
        Intrinsics3.checkNotNullParameter(sArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final int indexOf(int[] iArr, int i) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final char single(char[] cArr) {
        Intrinsics3.checkNotNullParameter(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final List<Byte> toList(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "$this$toList");
        int length = bArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return CollectionsJVM.listOf(Byte.valueOf(bArr[0]));
    }

    public static final List<Integer> toMutableList(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static final int indexOf(char[] cArr, char c2) {
        Intrinsics3.checkNotNullParameter(cArr, "$this$indexOf");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c2 == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) throws IOException {
        Intrinsics3.checkNotNullParameter(bArr, "$this$joinTo");
        Intrinsics3.checkNotNullParameter(a2, "buffer");
        Intrinsics3.checkNotNullParameter(charSequence, "separator");
        Intrinsics3.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics3.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics3.checkNotNullParameter(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a2.append(function1.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf((int) b2));
            }
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final List<Long> toMutableList(long[] jArr) {
        Intrinsics3.checkNotNullParameter(jArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static final List<Short> toList(short[] sArr) {
        Intrinsics3.checkNotNullParameter(sArr, "$this$toList");
        int length = sArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return CollectionsJVM.listOf(Short.valueOf(sArr[0]));
    }

    public static final List<Float> toMutableList(float[] fArr) {
        Intrinsics3.checkNotNullParameter(fArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        Intrinsics3.checkNotNullParameter(dArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final List<Integer> toList(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "$this$toList");
        int length = iArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return CollectionsJVM.listOf(Integer.valueOf(iArr[0]));
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        Intrinsics3.checkNotNullParameter(zArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z2 : zArr) {
            arrayList.add(Boolean.valueOf(z2));
        }
        return arrayList;
    }

    public static final List<Character> toMutableList(char[] cArr) {
        Intrinsics3.checkNotNullParameter(cArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final List<Long> toList(long[] jArr) {
        Intrinsics3.checkNotNullParameter(jArr, "$this$toList");
        int length = jArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return CollectionsJVM.listOf(Long.valueOf(jArr[0]));
    }

    public static final List<Float> toList(float[] fArr) {
        Intrinsics3.checkNotNullParameter(fArr, "$this$toList");
        int length = fArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return CollectionsJVM.listOf(Float.valueOf(fArr[0]));
    }

    public static final List<Double> toList(double[] dArr) {
        Intrinsics3.checkNotNullParameter(dArr, "$this$toList");
        int length = dArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return CollectionsJVM.listOf(Double.valueOf(dArr[0]));
    }

    public static final List<Boolean> toList(boolean[] zArr) {
        Intrinsics3.checkNotNullParameter(zArr, "$this$toList");
        int length = zArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return CollectionsJVM.listOf(Boolean.valueOf(zArr[0]));
    }

    public static final List<Character> toList(char[] cArr) {
        Intrinsics3.checkNotNullParameter(cArr, "$this$toList");
        int length = cArr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return CollectionsJVM.listOf(Character.valueOf(cArr[0]));
    }
}
