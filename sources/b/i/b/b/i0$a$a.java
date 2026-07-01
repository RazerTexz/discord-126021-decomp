package b.i.b.b;

import java.util.AbstractMap$SimpleImmutableEntry;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0$a$a<K, V> extends p<Map$Entry<K, V>> {
    public final /* synthetic */ i0$a this$0;

    public i0$a$a(i0$a i0_a) {
        this.this$0 = i0_a;
    }

    @Override // java.util.List
    public Object get(int i) {
        b.i.a.f.e.o.f.x(i, this.this$0.p);
        i0$a i0_a = this.this$0;
        Object[] objArr = i0_a.n;
        int i2 = i * 2;
        int i3 = i0_a.o;
        return new AbstractMap$SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.this$0.p;
    }
}
