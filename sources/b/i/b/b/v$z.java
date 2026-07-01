package b.i.b.b;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$z<K, V> extends v$n<K, V, v$y<K, V>, v$z<K, V>> {
    private final ReferenceQueue<K> queueForKeys;
    private final ReferenceQueue<V> queueForValues;

    public v$z(v<K, V, v$y<K, V>, v$z<K, V>> vVar, int i, int i2) {
        super(vVar, i, i2);
        this.queueForKeys = new ReferenceQueue<>();
        this.queueForValues = new ReferenceQueue<>();
    }

    public static /* synthetic */ ReferenceQueue o(v$z v_z) {
        return v_z.queueForKeys;
    }

    public static /* synthetic */ ReferenceQueue p(v$z v_z) {
        return v_z.queueForValues;
    }

    @Override // b.i.b.b.v$n
    public void f() {
        a(this.queueForKeys);
    }

    @Override // b.i.b.b.v$n
    public void g() {
        b(this.queueForKeys);
        c(this.queueForValues);
    }

    @Override // b.i.b.b.v$n
    public v$n l() {
        return this;
    }
}
