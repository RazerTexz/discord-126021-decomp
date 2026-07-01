package b.i.b.b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$q$a<K, V> implements v$j<K, V, v$q<K, V>, v$r<K, V>> {
    public static final v$q$a<?, ?> a = new v$q$a<>();

    @Override // b.i.b.b.v$j
    public v$i a(v$n v_n, v$i v_i, @NullableDecl v$i v_i2) {
        v$q v_q = (v$q) v_i;
        v$q v_q2 = new v$q(v_q.a, v_q.f1650b, (v$q) v_i2);
        v_q2.d = v_q.d;
        return v_q2;
    }

    @Override // b.i.b.b.v$j
    public v$p b() {
        return v$p.j;
    }

    @Override // b.i.b.b.v$j
    public v$p c() {
        return v$p.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.v$j
    public void d(v$n v_n, v$i v_i, Object obj) {
        ((v$q) v_i).d = obj;
    }

    @Override // b.i.b.b.v$j
    public v$n e(v vVar, int i, int i2) {
        return new v$r(vVar, i, i2);
    }

    @Override // b.i.b.b.v$j
    public v$i f(v$n v_n, Object obj, int i, @NullableDecl v$i v_i) {
        return new v$q(obj, i, (v$q) v_i);
    }
}
