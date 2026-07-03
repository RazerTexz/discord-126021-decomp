package p007b.p225i.p226a.p288f.p313h.p325l;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.t4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3838t4 extends AbstractC3772o3<Float> implements InterfaceC3597b5<Float>, InterfaceC3736l6, RandomAccess {

    /* JADX INFO: renamed from: k */
    public float[] f10324k;

    /* JADX INFO: renamed from: l */
    public int f10325l;

    static {
        new C3838t4(new float[0], 0).f10123j = false;
    }

    public C3838t4() {
        this.f10324k = new float[10];
        this.f10325l = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        m5153c();
        if (i < 0 || i > (i2 = this.f10325l)) {
            throw new IndexOutOfBoundsException(m5292g(i));
        }
        float[] fArr = this.f10324k;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f10324k, i, fArr2, i + 1, this.f10325l - i);
            this.f10324k = fArr2;
        }
        this.f10324k[i] = fFloatValue;
        this.f10325l++;
        ((AbstractList) this).modCount++;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        m5153c();
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof C3838t4)) {
            return super.addAll(collection);
        }
        C3838t4 c3838t4 = (C3838t4) collection;
        int i = c3838t4.f10325l;
        if (i == 0) {
            return false;
        }
        int i2 = this.f10325l;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.f10324k;
        if (i3 > fArr.length) {
            this.f10324k = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c3838t4.f10324k, 0, this.f10324k, this.f10325l, c3838t4.f10325l);
        this.f10325l = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: renamed from: d */
    public final void m5290d(float f) {
        m5153c();
        int i = this.f10325l;
        float[] fArr = this.f10324k;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f10324k = fArr2;
        }
        float[] fArr3 = this.f10324k;
        int i2 = this.f10325l;
        this.f10325l = i2 + 1;
        fArr3[i2] = f;
    }

    /* JADX INFO: renamed from: e */
    public final void m5291e(int i) {
        if (i < 0 || i >= this.f10325l) {
            throw new IndexOutOfBoundsException(m5292g(i));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3838t4)) {
            return super.equals(obj);
        }
        C3838t4 c3838t4 = (C3838t4) obj;
        if (this.f10325l != c3838t4.f10325l) {
            return false;
        }
        float[] fArr = c3838t4.f10324k;
        for (int i = 0; i < this.f10325l; i++) {
            if (Float.floatToIntBits(this.f10324k[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3597b5
    /* JADX INFO: renamed from: f */
    public final /* synthetic */ InterfaceC3597b5<Float> mo4569f(int i) {
        if (i >= this.f10325l) {
            return new C3838t4(Arrays.copyOf(this.f10324k, i), this.f10325l);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: g */
    public final String m5292g(int i) {
        return C1643a.m853h(35, "Index:", i, ", Size:", this.f10325l);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m5291e(i);
        return Float.valueOf(this.f10324k[i]);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.f10325l; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f10324k[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.f10325l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f10324k[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m5153c();
        m5291e(i);
        float[] fArr = this.f10324k;
        float f = fArr[i];
        int i2 = this.f10325l;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.f10325l--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m5153c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f10324k;
        System.arraycopy(fArr, i2, fArr, i, this.f10325l - i2);
        this.f10325l -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        m5153c();
        m5291e(i);
        float[] fArr = this.f10324k;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10325l;
    }

    public C3838t4(float[] fArr, int i) {
        this.f10324k = fArr;
        this.f10325l = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3772o3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m5290d(((Float) obj).floatValue());
        return true;
    }
}
