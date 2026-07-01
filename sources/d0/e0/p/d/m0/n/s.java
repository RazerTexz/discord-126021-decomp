package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public class s extends j0 {
    public final u0 k;
    public final d0.e0.p.d.m0.k.a0.i l;
    public final List<w0> m;
    public final boolean n;
    public final String o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar) {
        this(u0Var, iVar, null, false, null, 28, null);
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar, List<? extends w0> list, boolean z2) {
        this(u0Var, iVar, list, z2, null, 16, null);
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
    }

    public /* synthetic */ s(u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar, List list, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(u0Var, iVar, (i & 4) != 0 ? d0.t.n.emptyList() : list, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? "???" : str);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public u0 getConstructor() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return this.l;
    }

    public String getPresentableName() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public s refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.j0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : d0.t.u.joinToString(getArguments(), ", ", "<", ">", -1, "...", null));
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return new s(getConstructor(), getMemberScope(), getArguments(), z2, null, 16, null);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar, List<? extends w0> list, boolean z2, String str) {
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        d0.z.d.m.checkNotNullParameter(str, "presentableName");
        this.k = u0Var;
        this.l = iVar;
        this.m = list;
        this.n = z2;
        this.o = str;
    }
}
