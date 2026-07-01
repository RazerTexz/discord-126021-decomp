package b.i.b.b;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$t<K, V> extends v$n<K, V, v$s<K, V>, v$t<K, V>> {
    private final ReferenceQueue<V> queueForValues;

    public v$t(v<K, V, v$s<K, V>, v$t<K, V>> vVar, int i, int i2) {
        super(vVar, i, i2);
        this.queueForValues = new ReferenceQueue<>();
    }

    public static /* synthetic */ ReferenceQueue o(v$t v_t) {
        return v_t.queueForValues;
    }

    @Override // b.i.b.b.v$n
    public void f() {
        a(this.queueForValues);
    }

    @Override // b.i.b.b.v$n
    public void g() {
        c(this.queueForValues);
    }

    @Override // b.i.b.b.v$n
    public v$n l() {
        return this;
    }
}
