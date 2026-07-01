package b.i.b.b;

import java.util.Map$Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0<K, V> extends q<K, V> {
    public static final q<Object, Object> m = new i0(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    public final transient int[] n;
    public final transient Object[] o;
    public final transient int p;

    public i0(int[] iArr, Object[] objArr, int i) {
        this.n = iArr;
        this.o = objArr;
        this.p = i;
    }

    @Override // b.i.b.b.q
    public r<Map$Entry<K, V>> b() {
        return new i0$a(this, this.o, 0, this.p);
    }

    @Override // b.i.b.b.q
    public r<K> c() {
        return new i0$b(this, new i0$c(this.o, 0, this.p));
    }

    @Override // b.i.b.b.q
    public n<V> d() {
        return new i0$c(this.o, 1, this.p);
    }

    @Override // b.i.b.b.q
    public boolean f() {
        return false;
    }

    @Override // b.i.b.b.q, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int[] iArr = this.n;
        Object[] objArr = this.o;
        int i = this.p;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
        while (true) {
            int i2 = iC1 & length;
            int i3 = iArr[i2];
            if (i3 == -1) {
                return null;
            }
            if (objArr[i3].equals(obj)) {
                return (V) objArr[i3 ^ 1];
            }
            iC1 = i2 + 1;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.p;
    }
}
