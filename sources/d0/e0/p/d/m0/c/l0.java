package d0.e0.p.d.m0.c;

import java.util.List;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 {
    public final i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d0.e0.p.d.m0.n.w0> f3298b;
    public final l0 c;

    /* JADX WARN: Multi-variable type inference failed */
    public l0(i iVar, List<? extends d0.e0.p.d.m0.n.w0> list, l0 l0Var) {
        d0.z.d.m.checkNotNullParameter(iVar, "classifierDescriptor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        this.a = iVar;
        this.f3298b = list;
        this.c = l0Var;
    }

    public final List<d0.e0.p.d.m0.n.w0> getArguments() {
        return this.f3298b;
    }

    public final i getClassifierDescriptor() {
        return this.a;
    }

    public final l0 getOuterType() {
        return this.c;
    }
}
