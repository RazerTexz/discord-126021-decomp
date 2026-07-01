package b.i.b.b;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$x<K, V> extends v$n<K, V, v$w<K, V>, v$x<K, V>> {
    private final ReferenceQueue<K> queueForKeys;

    public v$x(v<K, V, v$w<K, V>, v$x<K, V>> vVar, int i, int i2) {
        super(vVar, i, i2);
        this.queueForKeys = new ReferenceQueue<>();
    }

    public static /* synthetic */ ReferenceQueue o(v$x v_x) {
        return v_x.queueForKeys;
    }

    @Override // b.i.b.b.v$n
    public void f() {
        a(this.queueForKeys);
    }

    @Override // b.i.b.b.v$n
    public void g() {
        b(this.queueForKeys);
    }

    @Override // b.i.b.b.v$n
    public v$n l() {
        return this;
    }
}
