package b.c.a.y.k;

import b.c.a.c0.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.n, reason: use source file name */
/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    public final List<Keyframe<V>> a;

    public BaseAnimatableValue(V v) {
        this.a = Collections.singletonList(new Keyframe(v));
    }

    @Override // b.c.a.y.k.AnimatableValue
    public List<Keyframe<V>> b() {
        return this.a;
    }

    @Override // b.c.a.y.k.AnimatableValue
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

    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.a = list;
    }
}
