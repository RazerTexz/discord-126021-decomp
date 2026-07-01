package b.i.b.b;

import java.lang.ref.ReferenceQueue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$s$a<K, V> implements v$j<K, V, v$s<K, V>, v$t<K, V>> {
    public static final v$s$a<?, ?> a = new v$s$a<>();

    @Override // b.i.b.b.v$j
    public v$i a(v$n v_n, v$i v_i, @NullableDecl v$i v_i2) {
        v$t v_t = (v$t) v_n;
        v$s v_s = (v$s) v_i;
        v$s v_s2 = (v$s) v_i2;
        int i = v$n.j;
        if (v_s.getValue() == null) {
            return null;
        }
        ReferenceQueue<V> referenceQueueO = v$t.o(v_t);
        v$s v_s3 = new v$s(v_s.a, v_s.f1650b, v_s2);
        v_s3.d = (v$b0<K, V, v$s<K, V>>) v_s.d.b(referenceQueueO, v_s3);
        return v_s3;
    }

    @Override // b.i.b.b.v$j
    public v$p b() {
        return v$p.j;
    }

    @Override // b.i.b.b.v$j
    public v$p c() {
        return v$p.k;
    }

    @Override // b.i.b.b.v$j
    public void d(v$n v_n, v$i v_i, Object obj) {
        v$s v_s = (v$s) v_i;
        ReferenceQueue referenceQueueO = v$t.o((v$t) v_n);
        v$b0<K, V, v$s<K, V>> v_b0 = v_s.d;
        v_s.d = new v$c0(referenceQueueO, obj, v_s);
        v_b0.clear();
    }

    @Override // b.i.b.b.v$j
    public v$n e(v vVar, int i, int i2) {
        return new v$t(vVar, i, i2);
    }

    @Override // b.i.b.b.v$j
    public v$i f(v$n v_n, Object obj, int i, @NullableDecl v$i v_i) {
        return new v$s(obj, i, (v$s) v_i);
    }
}
