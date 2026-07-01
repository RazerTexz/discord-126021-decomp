package b.i.a.c.a3;

import android.util.SparseArray;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Consumer3;

/* JADX INFO: renamed from: b.i.a.c.a3.m0, reason: use source file name */
/* JADX INFO: compiled from: SpannedData.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpannedData<V> {
    public final Consumer3<V> c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<V> f829b = new SparseArray<>();
    public int a = -1;

    public SpannedData(Consumer3<V> consumer3) {
        this.c = consumer3;
    }

    public void a(int i, V v) {
        if (this.a == -1) {
            AnimatableValueParser.D(this.f829b.size() == 0);
            this.a = 0;
        }
        if (this.f829b.size() > 0) {
            SparseArray<V> sparseArray = this.f829b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            AnimatableValueParser.j(i >= iKeyAt);
            if (iKeyAt == i) {
                Consumer3<V> consumer3 = this.c;
                SparseArray<V> sparseArray2 = this.f829b;
                consumer3.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f829b.append(i, v);
    }

    public V b(int i) {
        if (this.a == -1) {
            this.a = 0;
        }
        while (true) {
            int i2 = this.a;
            if (i2 <= 0 || i >= this.f829b.keyAt(i2)) {
                break;
            }
            this.a--;
        }
        while (this.a < this.f829b.size() - 1 && i >= this.f829b.keyAt(this.a + 1)) {
            this.a++;
        }
        return this.f829b.valueAt(this.a);
    }

    public V c() {
        SparseArray<V> sparseArray = this.f829b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }
}
