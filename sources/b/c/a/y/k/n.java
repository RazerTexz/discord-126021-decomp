package b.c.a.y.k;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {
    public final List<b.c.a.c0.a<V>> a;

    public n(V v) {
        this.a = Collections.singletonList(new b.c.a.c0.a(v));
    }

    @Override // b.c.a.y.k.m
    public List<b.c.a.c0.a<V>> b() {
        return this.a;
    }

    @Override // b.c.a.y.k.m
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    public n(List<b.c.a.c0.a<V>> list) {
        this.a = list;
    }
}
