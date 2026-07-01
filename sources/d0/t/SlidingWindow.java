package d0.t;

import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: d0.t.l0, reason: use source file name */
/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SlidingWindow<T> extends AbstractList<T> implements RandomAccess {
    public final int k;
    public int l;
    public int m;
    public final Object[] n;

    /* JADX INFO: renamed from: d0.t.l0$a */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    public static final class a extends AbstractIterator3<T> {
        public int l;
        public int m;

        public a() {
            this.l = SlidingWindow.this.size();
            this.m = SlidingWindow.this.l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.t.AbstractIterator3
        public void a() {
            if (this.l == 0) {
                this.j = 3;
                return;
            }
            b(SlidingWindow.this.n[this.m]);
            this.m = (this.m + 1) % SlidingWindow.this.k;
            this.l--;
        }
    }

    public SlidingWindow(Object[] objArr, int i) {
        Intrinsics3.checkNotNullParameter(objArr, "buffer");
        this.n = objArr;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.q("ring buffer filled size should not be negative but it is ", i).toString());
        }
        if (i <= objArr.length) {
            this.k = objArr.length;
            this.m = i;
        } else {
            StringBuilder sbV = outline.V("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbV.append(objArr.length);
            throw new IllegalArgumentException(sbV.toString().toString());
        }
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.n[(size() + this.l) % this.k] = t;
        this.m = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SlidingWindow<T> expanded(int i) {
        Object[] array;
        int i2 = this.k;
        int iCoerceAtMost = _Ranges.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.l == 0) {
            array = Arrays.copyOf(this.n, iCoerceAtMost);
            Intrinsics3.checkNotNullExpressionValue(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new SlidingWindow<>(array, size());
    }

    @Override // d0.t.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.j.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.n[(this.l + i) % this.k];
    }

    @Override // d0.t.AbstractCollection
    public int getSize() {
        return this.m;
    }

    public final boolean isFull() {
        return size() == this.k;
    }

    @Override // d0.t.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    public final void removeFirst(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.q("n shouldn't be negative but it is ", i).toString());
        }
        if (!(i <= size())) {
            StringBuilder sbV = outline.V("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
            sbV.append(size());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        if (i > 0) {
            int i2 = this.l;
            int i3 = (i2 + i) % this.k;
            if (i2 > i3) {
                _ArraysJvm.fill(this.n, (Object) null, i2, this.k);
                _ArraysJvm.fill(this.n, (Object) null, 0, i3);
            } else {
                _ArraysJvm.fill(this.n, (Object) null, i2, i3);
            }
            this.l = i3;
            this.m = size() - i;
        }
    }

    @Override // d0.t.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics3.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics3.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.l; i2 < size && i3 < this.k; i3++) {
            tArr[i2] = this.n[i3];
            i2++;
        }
        while (i2 < size) {
            tArr[i2] = this.n[i];
            i2++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public SlidingWindow(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.t.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
