package p007b.p085c.p086a.p095y.p096k;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p090c0.C1501a;

/* JADX INFO: renamed from: b.c.a.y.k.n */
/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1585n<V, O> implements InterfaceC1584m<V, O> {

    /* JADX INFO: renamed from: a */
    public final List<C1501a<V>> f2738a;

    public AbstractC1585n(V v) {
        this.f2738a = Collections.singletonList(new C1501a(v));
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    /* JADX INFO: renamed from: b */
    public List<C1501a<V>> mo774b() {
        return this.f2738a;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    public boolean isStatic() {
        return this.f2738a.isEmpty() || (this.f2738a.size() == 1 && this.f2738a.get(0).m667d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2738a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2738a.toArray()));
        }
        return sb.toString();
    }

    public AbstractC1585n(List<C1501a<V>> list) {
        this.f2738a = list;
    }
}
