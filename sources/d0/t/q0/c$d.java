package d0.t.q0;

import d0.z.d.m;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c$d<K, V> {
    public int j;
    public int k;
    public final c<K, V> l;

    public c$d(c<K, V> cVar) {
        m.checkNotNullParameter(cVar, "map");
        this.l = cVar;
        this.k = -1;
        initNext$kotlin_stdlib();
    }

    public final int getIndex$kotlin_stdlib() {
        return this.j;
    }

    public final int getLastIndex$kotlin_stdlib() {
        return this.k;
    }

    public final c<K, V> getMap$kotlin_stdlib() {
        return this.l;
    }

    public final boolean hasNext() {
        return this.j < c.access$getLength$p(this.l);
    }

    public final void initNext$kotlin_stdlib() {
        while (this.j < c.access$getLength$p(this.l)) {
            int[] iArrAccess$getPresenceArray$p = c.access$getPresenceArray$p(this.l);
            int i = this.j;
            if (iArrAccess$getPresenceArray$p[i] >= 0) {
                return;
            } else {
                this.j = i + 1;
            }
        }
    }

    public final void remove() {
        if (!(this.k != -1)) {
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
        this.l.checkIsMutable$kotlin_stdlib();
        c.access$removeKeyAt(this.l, this.k);
        this.k = -1;
    }

    public final void setIndex$kotlin_stdlib(int i) {
        this.j = i;
    }

    public final void setLastIndex$kotlin_stdlib(int i) {
        this.k = i;
    }
}
