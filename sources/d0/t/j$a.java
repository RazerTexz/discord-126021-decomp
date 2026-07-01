package d0.t;

import java.util.RandomAccess;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a extends c<Integer> implements RandomAccess {
    public final /* synthetic */ int[] k;

    public j$a(int[] iArr) {
        this.k = iArr;
    }

    @Override // d0.t.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains(((Number) obj).intValue());
        }
        return false;
    }

    @Override // d0.t.c, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.t.a
    public int getSize() {
        return this.k.length;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // d0.t.a, java.util.Collection
    public boolean isEmpty() {
        return this.k.length == 0;
    }

    @Override // d0.t.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf(((Number) obj).intValue());
        }
        return -1;
    }

    public boolean contains(int i) {
        return k.contains(this.k, i);
    }

    @Override // d0.t.c, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(this.k[i]);
    }

    public int indexOf(int i) {
        return k.indexOf(this.k, i);
    }

    public int lastIndexOf(int i) {
        return k.lastIndexOf(this.k, i);
    }
}
