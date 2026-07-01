package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$b {
    public final Collection<c0> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends c0> f3525b;

    /* JADX WARN: Multi-variable type inference failed */
    public g$b(Collection<? extends c0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "allSupertypes");
        this.a = collection;
        this.f3525b = d0.t.m.listOf(t.c);
    }

    public final Collection<c0> getAllSupertypes() {
        return this.a;
    }

    public final List<c0> getSupertypesWithoutCycles() {
        return this.f3525b;
    }

    public final void setSupertypesWithoutCycles(List<? extends c0> list) {
        d0.z.d.m.checkNotNullParameter(list, "<set-?>");
        this.f3525b = list;
    }
}
