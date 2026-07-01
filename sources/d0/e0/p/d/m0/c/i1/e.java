package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.e1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends l implements y0 {
    public final d0.e0.p.d.m0.c.u n;
    public List<? extends z0> o;
    public final e$b p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, u0 u0Var, d0.e0.p.d.m0.c.u uVar) {
        super(mVar, gVar, eVar, u0Var);
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(u0Var, "sourceElement");
        d0.z.d.m.checkNotNullParameter(uVar, "visibilityImpl");
        this.n = uVar;
        this.p = new e$b(this);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitTypeAliasDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List list = this.o;
        if (list != null) {
            return list;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getOriginal() {
        return getOriginal();
    }

    public final Collection<i0> getTypeAliasConstructors() {
        d0.e0.p.d.m0.l.b.e0.l lVar = (d0.e0.p.d.m0.l.b.e0.l) this;
        d0.e0.p.d.m0.c.e classDescriptor = lVar.getClassDescriptor();
        if (classDescriptor == null) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.d> constructors = classDescriptor.getConstructors();
        d0.z.d.m.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.c.d dVar : constructors) {
            j0$a j0_a = j0.M;
            d0.e0.p.d.m0.m.o oVar = lVar.q;
            d0.z.d.m.checkNotNullExpressionValue(dVar, "it");
            i0 i0VarCreateIfAvailable = j0_a.createIfAvailable(oVar, this, dVar);
            if (i0VarCreateIfAvailable != null) {
                arrayList.add(i0VarCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.u0 getTypeConstructor() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        return this.n;
    }

    public final void initialize(List<? extends z0> list) {
        d0.z.d.m.checkNotNullParameter(list, "declaredTypeParameters");
        this.o = list;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return e1.contains(((d0.e0.p.d.m0.l.b.e0.l) this).getUnderlyingType(), new e$a(this));
    }

    @Override // d0.e0.p.d.m0.c.i1.k
    public String toString() {
        return d0.z.d.m.stringPlus("typealias ", getName().asString());
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public y0 getOriginal() {
        return (y0) super.getOriginal();
    }
}
