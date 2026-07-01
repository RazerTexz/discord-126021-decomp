package b.i.b.b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$w$a<K, V> implements v$j<K, V, v$w<K, V>, v$x<K, V>> {
    public static final v$w$a<?, ?> a = new v$w$a<>();

    @Override // b.i.b.b.v$j
    public v$i a(v$n v_n, v$i v_i, @NullableDecl v$i v_i2) {
        v$x v_x = (v$x) v_n;
        v$w v_w = (v$w) v_i;
        v$w v_w2 = (v$w) v_i2;
        if (v_w.get() == null) {
            return null;
        }
        v$w v_w3 = new v$w(v$x.o(v_x), v_w.get(), v_w.a, v_w2);
        v_w3.c = v_w.c;
        return v_w3;
    }

    @Override // b.i.b.b.v$j
    public v$p b() {
        return v$p.k;
    }

    @Override // b.i.b.b.v$j
    public v$p c() {
        return v$p.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.i.b.b.v$j
    public void d(v$n v_n, v$i v_i, Object obj) {
        ((v$w) v_i).c = obj;
    }

    @Override // b.i.b.b.v$j
    public v$n e(v vVar, int i, int i2) {
        return new v$x(vVar, i, i2);
    }

    @Override // b.i.b.b.v$j
    public v$i f(v$n v_n, Object obj, int i, @NullableDecl v$i v_i) {
        return new v$w(v$x.o((v$x) v_n), obj, i, (v$w) v_i);
    }
}
