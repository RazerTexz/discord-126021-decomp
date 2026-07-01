package b.i.a.f.h.l;

import b.d.b.a.outline;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t4 extends o3<Float> implements b5<Float>, l6, RandomAccess {
    public float[] k;
    public int l;

    static {
        new t4(new float[0], 0).j = false;
    }

    public t4() {
        this.k = new float[10];
        this.l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        c();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(g(i));
        }
        float[] fArr = this.k;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.k, i, fArr2, i + 1, this.l - i);
            this.k = fArr2;
        }
        this.k[i] = fFloatValue;
        this.l++;
        ((AbstractList) this).modCount++;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        Charset charset = w4.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof t4)) {
            return super.addAll(collection);
        }
        t4 t4Var = (t4) collection;
        int i = t4Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.k;
        if (i3 > fArr.length) {
            this.k = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(t4Var.k, 0, this.k, this.l, t4Var.l);
        this.l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f) {
        c();
        int i = this.l;
        float[] fArr = this.k;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.k = fArr2;
        }
        float[] fArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        fArr3[i2] = f;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(g(i));
        }
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t4)) {
            return super.equals(obj);
        }
        t4 t4Var = (t4) obj;
        if (this.l != t4Var.l) {
            return false;
        }
        float[] fArr = t4Var.k;
        for (int i = 0; i < this.l; i++) {
            if (Float.floatToIntBits(this.k[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // b.i.a.f.h.l.b5
    public final /* synthetic */ b5<Float> f(int i) {
        if (i >= this.l) {
            return new t4(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final String g(int i) {
        return outline.h(35, "Index:", i, ", Size:", this.l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Float.valueOf(this.k[i]);
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.l; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.k[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        float[] fArr = this.k;
        float f = fArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.l--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.k;
        System.arraycopy(fArr, i2, fArr, i, this.l - i2);
        this.l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        c();
        e(i);
        float[] fArr = this.k;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.l;
    }

    public t4(float[] fArr, int i) {
        this.k = fArr;
        this.l = i;
    }

    @Override // b.i.a.f.h.l.o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
