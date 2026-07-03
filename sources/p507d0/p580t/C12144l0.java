package p507d0.p580t;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.l0 */
/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12144l0<T> extends AbstractC12125c<T> implements RandomAccess {

    /* JADX INFO: renamed from: k */
    public final int f25191k;

    /* JADX INFO: renamed from: l */
    public int f25192l;

    /* JADX INFO: renamed from: m */
    public int f25193m;

    /* JADX INFO: renamed from: n */
    public final Object[] f25194n;

    /* JADX INFO: renamed from: d0.t.l0$a */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    public static final class a extends AbstractC12123b<T> {

        /* JADX INFO: renamed from: l */
        public int f25195l;

        /* JADX INFO: renamed from: m */
        public int f25196m;

        public a() {
            this.f25195l = C12144l0.this.size();
            this.f25196m = C12144l0.this.f25192l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p580t.AbstractC12123b
        /* JADX INFO: renamed from: a */
        public void mo10059a() {
            if (this.f25195l == 0) {
                this.f25173j = 3;
                return;
            }
            m10074b(C12144l0.this.f25194n[this.f25196m]);
            this.f25196m = (this.f25196m + 1) % C12144l0.this.f25191k;
            this.f25195l--;
        }
    }

    public C12144l0(Object[] objArr, int i) {
        C12238m.checkNotNullParameter(objArr, "buffer");
        this.f25194n = objArr;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("ring buffer filled size should not be negative but it is ", i).toString());
        }
        if (i <= objArr.length) {
            this.f25191k = objArr.length;
            this.f25193m = i;
        } else {
            StringBuilder sbM834V = C1643a.m834V("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbM834V.append(objArr.length);
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f25194n[(size() + this.f25192l) % this.f25191k] = t;
        this.f25193m = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C12144l0<T> expanded(int i) {
        Object[] array;
        int i2 = this.f25191k;
        int iCoerceAtMost = C11226f.coerceAtMost(i2 + (i2 >> 1) + 1, i);
        if (this.f25192l == 0) {
            array = Arrays.copyOf(this.f25194n, iCoerceAtMost);
            C12238m.checkNotNullExpressionValue(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new C12144l0<>(array, size());
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.List
    public T get(int i) {
        AbstractC12125c.f25177j.checkElementIndex$kotlin_stdlib(i, size());
        return (T) this.f25194n[(this.f25192l + i) % this.f25191k];
    }

    @Override // p507d0.p580t.AbstractC12121a
    public int getSize() {
        return this.f25193m;
    }

    public final boolean isFull() {
        return size() == this.f25191k;
    }

    @Override // p507d0.p580t.AbstractC12125c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    public final void removeFirst(int i) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m871q("n shouldn't be negative but it is ", i).toString());
        }
        if (!(i <= size())) {
            StringBuilder sbM834V = C1643a.m834V("n shouldn't be greater than the buffer size: n = ", i, ", size = ");
            sbM834V.append(size());
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
        if (i > 0) {
            int i2 = this.f25192l;
            int i3 = (i2 + i) % this.f25191k;
            if (i2 > i3) {
                C12139j.fill(this.f25194n, (Object) null, i2, this.f25191k);
                C12139j.fill(this.f25194n, (Object) null, 0, i3);
            } else {
                C12139j.fill(this.f25194n, (Object) null, i2, i3);
            }
            this.f25192l = i3;
            this.f25193m = size() - i;
        }
    }

    @Override // p507d0.p580t.AbstractC12121a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C12238m.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            C12238m.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.f25192l; i2 < size && i3 < this.f25191k; i3++) {
            tArr[i2] = this.f25194n[i3];
            i2++;
        }
        while (i2 < size) {
            tArr[i2] = this.f25194n[i];
            i2++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public C12144l0(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p580t.AbstractC12121a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
