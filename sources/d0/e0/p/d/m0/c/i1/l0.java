package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l0 extends m0 implements c1 {
    public static final l0$a o = new l0$a(null);
    public final int p;
    public final boolean q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f3268s;
    public final d0.e0.p.d.m0.n.c0 t;
    public final c1 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(d0.e0.p.d.m0.c.a aVar, c1 c1Var, int i, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.c0 c0Var2, u0 u0Var) {
        super(aVar, gVar, eVar, c0Var, u0Var);
        d0.z.d.m.checkNotNullParameter(aVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(c0Var, "outType");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        this.p = i;
        this.q = z2;
        this.r = z3;
        this.f3268s = z4;
        this.t = c0Var2;
        this.u = c1Var == null ? this : c1Var;
    }

    public static final l0 createWithDestructuringDeclarations(d0.e0.p.d.m0.c.a aVar, c1 c1Var, int i, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.n.c0 c0Var, boolean z2, boolean z3, boolean z4, d0.e0.p.d.m0.n.c0 c0Var2, u0 u0Var, Function0<? extends List<? extends d1>> function0) {
        return o.createWithDestructuringDeclarations(aVar, c1Var, i, gVar, eVar, c0Var, z2, z3, z4, c0Var2, u0Var, function0);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitValueParameterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.c1
    public c1 copy(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.g.e eVar, int i) {
        d0.z.d.m.checkNotNullParameter(aVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(eVar, "newName");
        d0.e0.p.d.m0.c.g1.g annotations = getAnnotations();
        d0.z.d.m.checkNotNullExpressionValue(annotations, "annotations");
        d0.e0.p.d.m0.n.c0 type = getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "type");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        d0.e0.p.d.m0.n.c0 varargElementType = getVarargElementType();
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return new l0(aVar, null, i, annotations, eVar, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.c1
    public boolean declaresDefaultValue() {
        return this.q && ((d0.e0.p.d.m0.c.b) getContainingDeclaration()).getKind().isReal();
    }

    @Override // d0.e0.p.d.m0.c.d1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.v.g getCompileTimeInitializer() {
        return (d0.e0.p.d.m0.k.v.g) m85getCompileTimeInitializer();
    }

    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public Void m85getCompileTimeInitializer() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.c1
    public int getIndex() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.a
    public Collection<c1> getOverriddenDescriptors() {
        Collection<? extends d0.e0.p.d.m0.c.a> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.a) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.c1
    public d0.e0.p.d.m0.n.c0 getVarargElementType() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.f;
        d0.z.d.m.checkNotNullExpressionValue(uVar, "LOCAL");
        return uVar;
    }

    @Override // d0.e0.p.d.m0.c.c1
    public boolean isCrossinline() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.c1
    public boolean isNoinline() {
        return this.f3268s;
    }

    @Override // d0.e0.p.d.m0.c.d1
    public boolean isVar() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.a getContainingDeclaration() {
        return (d0.e0.p.d.m0.c.a) super.getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.w0
    public c1 substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(c1Var, "substitutor");
        if (c1Var.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public c1 getOriginal() {
        c1 c1Var = this.u;
        return c1Var == this ? this : c1Var.getOriginal();
    }
}
