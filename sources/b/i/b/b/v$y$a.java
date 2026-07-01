package b.i.b.b;

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$y$a<K, V> implements v$j<K, V, v$y<K, V>, v$z<K, V>> {
    public static final v$y$a<?, ?> a = new v$y$a<>();

    @Override // b.i.b.b.v$j
    public v$i a(v$n v_n, v$i v_i, @NullableDecl v$i v_i2) {
        v$z v_z = (v$z) v_n;
        v$y v_y = (v$y) v_i;
        v$y v_y2 = (v$y) v_i2;
        if (v_y.get() == null) {
            return null;
        }
        int i = v$n.j;
        if (v_y.getValue() == null) {
            return null;
        }
        ReferenceQueue referenceQueueO = v$z.o(v_z);
        ReferenceQueue<V> referenceQueueP = v$z.p(v_z);
        v$y v_y3 = new v$y(referenceQueueO, v_y.get(), v_y.a, v_y2);
        v_y3.c = (v$b0<K, V, v$y<K, V>>) v_y.c.b(referenceQueueP, v_y3);
        return v_y3;
    }

    @Override // b.i.b.b.v$j
    public v$p b() {
        return v$p.k;
    }

    @Override // b.i.b.b.v$j
    public v$p c() {
        return v$p.k;
    }

    @Override // b.i.b.b.v$j
    public void d(v$n v_n, v$i v_i, Object obj) {
        v$y v_y = (v$y) v_i;
        ReferenceQueue referenceQueueP = v$z.p((v$z) v_n);
        v$b0<K, V, v$y<K, V>> v_b0 = v_y.c;
        v_y.c = new v$c0(referenceQueueP, obj, v_y);
        v_b0.clear();
    }

    @Override // b.i.b.b.v$j
    public v$n e(v vVar, int i, int i2) {
        return new v$z(vVar, i, i2);
    }

    @Override // b.i.b.b.v$j
    public v$i f(v$n v_n, Object obj, int i, @NullableDecl v$i v_i) {
        return new v$y(v$z.o((v$z) v_n), obj, i, (v$y) v_i);
    }
}
