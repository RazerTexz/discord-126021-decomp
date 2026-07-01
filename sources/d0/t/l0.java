package d0.t;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0<T> extends c<T> implements RandomAccess {
    public final int k;
    public int l;
    public int m;
    public final Object[] n;

    public l0(Object[] objArr, int i) {
        d0.z.d.m.checkNotNullParameter(objArr, "buffer");
        this.n = objArr;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("ring buffer filled size should not be negative but it is ", i).toString());
        }
        if (i <= objArr.length) {
            this.k = objArr.length;
            this.m = i;
        } else {
            StringBuilder sbV = b.d.b.a.a.V("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbV.append(objArr.length);
            throw new IllegalArgumentException(sbV.toString().toString());
        }
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(l0 l0Var) {
        return l0Var.n;
    }

    public static final /* synthetic */ int access$getCapacity$p(l0 l0Var) {
        return l0Var.k;
    }

    public static final /* synthetic */ int access$getStartIndex$p(l0 l0Var) {
        return l0Var.l;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.n[(size() + this.l) % access$getCapacity$p(this)] = t;
        this.m = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l0<T> expanded(int i) {
        Object[] array;
        int i2 = this.k;
        int iCoerceAtMost = d0.d0.f.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.l == 0) {
            array = Arrays.copyOf(this.n, iCoerceAtMost);
            d0.z.d.m.checkNotNullExpressionValue(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new l0<>(array, size());
    }

    @Override // d0.t.c, java.util.List
    public T get(int i) {
        c.j.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.n[(this.l + i) % access$getCapacity$p(this)];
    }

    @Override // d0.t.a
    public int getSize() {
        return this.m;
    }

    public final boolean isFull() {
        return size() == this.k;
    }

    @Override // d0.t.c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new l0$a(this);
    }

    public final void removeFirst(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("n shouldn't be negative but it is ", i).toString());
        }
        if (!(i <= size())) {
            StringBuilder sbV = b.d.b.a.a.V("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
            sbV.append(size());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        if (i > 0) {
            int i2 = this.l;
            int iAccess$getCapacity$p = (i2 + i) % access$getCapacity$p(this);
            if (i2 > iAccess$getCapacity$p) {
                j.fill(this.n, (Object) null, i2, this.k);
                j.fill(this.n, (Object) null, 0, iAccess$getCapacity$p);
            } else {
                j.fill(this.n, (Object) null, i2, iAccess$getCapacity$p);
            }
            this.l = iAccess$getCapacity$p;
            this.m = size() - i;
        }
    }

    @Override // d0.t.a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        d0.z.d.m.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            d0.z.d.m.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
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

    public l0(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.t.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
