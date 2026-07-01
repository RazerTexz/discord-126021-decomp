package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements d0.e0.p.d.m0.k.u.a.b {
    public final w0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends List<? extends i1>> f3528b;
    public final j c;
    public final z0 d;
    public final Lazy e;

    public j(w0 w0Var, Function0<? extends List<? extends i1>> function0, j jVar, z0 z0Var) {
        d0.z.d.m.checkNotNullParameter(w0Var, "projection");
        this.a = w0Var;
        this.f3528b = function0;
        this.c = jVar;
        this.d = z0Var;
        this.e = d0.g.lazy(d0.i.PUBLICATION, new j$b(this));
    }

    public static final /* synthetic */ Function0 access$getSupertypesComputation$p(j jVar) {
        return jVar.f3528b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!d0.z.d.m.areEqual(j.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j jVar = (j) obj;
        j jVar2 = this.c;
        if (jVar2 == null) {
            jVar2 = this;
        }
        j jVar3 = jVar.c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return jVar2 == jVar;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        c0 type = getProjection().getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "projection.type");
        return d0.e0.p.d.m0.n.o1.a.getBuiltIns(type);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.k.u.a.b
    public w0 getProjection() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    public int hashCode() {
        j jVar = this.c;
        return jVar == null ? super.hashCode() : jVar.hashCode();
    }

    public final void initializeSupertypes(List<? extends i1> list) {
        d0.z.d.m.checkNotNullParameter(list, "supertypes");
        Function0<? extends List<? extends i1>> function0 = this.f3528b;
        this.f3528b = new j$c(list);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ u0 refine(g gVar) {
        return refine(gVar);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CapturedType(");
        sbU.append(getProjection());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<i1> getSupertypes() {
        List<i1> list = (List) this.e.getValue();
        return list == null ? d0.t.n.emptyList() : list;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public j refine(g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        w0 w0VarRefine = getProjection().refine(gVar);
        d0.z.d.m.checkNotNullExpressionValue(w0VarRefine, "projection.refine(kotlinTypeRefiner)");
        j$d j_d = this.f3528b == null ? null : new j$d(this, gVar);
        j jVar = this.c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(w0VarRefine, j_d, jVar, this.d);
    }

    public /* synthetic */ j(w0 w0Var, Function0 function0, j jVar, z0 z0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(w0Var, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : jVar, (i & 8) != 0 ? null : z0Var);
    }

    public /* synthetic */ j(w0 w0Var, List list, j jVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(w0Var, list, (i & 4) != 0 ? null : jVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(w0 w0Var, List<? extends i1> list, j jVar) {
        this(w0Var, new j$a(list), jVar, null, 8, null);
        d0.z.d.m.checkNotNullParameter(w0Var, "projection");
        d0.z.d.m.checkNotNullParameter(list, "supertypes");
    }
}
