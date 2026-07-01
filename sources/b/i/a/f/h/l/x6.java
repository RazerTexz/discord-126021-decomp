package b.i.a.f.h.l;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x6<K, V> implements Iterator<Map.Entry<K, V>> {
    public int j = -1;
    public boolean k;
    public Iterator<Map.Entry<K, V>> l;
    public final /* synthetic */ r6 m;

    public x6(r6 r6Var, t6 t6Var) {
        this.m = r6Var;
    }

    public final Iterator<Map.Entry<K, V>> a() {
        if (this.l == null) {
            this.l = this.m.m.entrySet().iterator();
        }
        return this.l;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j + 1 < this.m.l.size() || (!this.m.m.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.k = true;
        int i = this.j + 1;
        this.j = i;
        return i < this.m.l.size() ? this.m.l.get(this.j) : a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.k) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.k = false;
        r6 r6Var = this.m;
        int i = r6.j;
        r6Var.h();
        if (this.j >= this.m.l.size()) {
            a().remove();
            return;
        }
        r6 r6Var2 = this.m;
        int i2 = this.j;
        this.j = i2 - 1;
        r6Var2.f(i2);
    }
}
