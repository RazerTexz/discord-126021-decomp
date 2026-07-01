package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import java.util.List;

/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends l implements z0 {
    public final j1 n;
    public final boolean o;
    public final int p;
    public final d0.e0.p.d.m0.m.j<u0> q;
    public final d0.e0.p.d.m0.m.j<d0.e0.p.d.m0.n.j0> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.o f3264s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, j1 j1Var, boolean z2, int i, d0.e0.p.d.m0.c.u0 u0Var, x0 x0Var) {
        super(mVar, gVar, eVar, u0Var);
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
            a(1);
            throw null;
        }
        if (gVar == null) {
            a(2);
            throw null;
        }
        if (eVar == null) {
            a(3);
            throw null;
        }
        if (j1Var == null) {
            a(4);
            throw null;
        }
        if (u0Var == null) {
            a(5);
            throw null;
        }
        if (x0Var == null) {
            a(6);
            throw null;
        }
        this.n = j1Var;
        this.o = z2;
        this.p = i;
        this.q = oVar.createLazyValue(new f$a(this, oVar, x0Var));
        this.r = oVar.createLazyValue(new f$b(this, eVar));
        this.f3264s = oVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitTypeParameterDescriptor(this, d);
    }

    public List<d0.e0.p.d.m0.n.c0> b(List<d0.e0.p.d.m0.n.c0> list) {
        if (list == null) {
            a(12);
            throw null;
        }
        if (list != null) {
            return list;
        }
        a(13);
        throw null;
    }

    public abstract void c(d0.e0.p.d.m0.n.c0 c0Var);

    public abstract List<d0.e0.p.d.m0.n.c0> d();

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.j0 getDefaultType() {
        d0.e0.p.d.m0.n.j0 j0VarInvoke = this.r.invoke();
        if (j0VarInvoke != null) {
            return j0VarInvoke;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public int getIndex() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.z0
    public d0.e0.p.d.m0.m.o getStorageManager() {
        d0.e0.p.d.m0.m.o oVar = this.f3264s;
        if (oVar != null) {
            return oVar;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.z0, d0.e0.p.d.m0.c.h
    public final u0 getTypeConstructor() {
        u0 u0VarInvoke = this.q.invoke();
        if (u0VarInvoke != null) {
            return u0VarInvoke;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public List<d0.e0.p.d.m0.n.c0> getUpperBounds() {
        List<d0.e0.p.d.m0.n.c0> supertypes = ((f$c) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public j1 getVariance() {
        j1 j1Var = this.n;
        if (j1Var != null) {
            return j1Var;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.z0
    public boolean isReified() {
        return this.o;
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
    public z0 getOriginal() {
        z0 z0Var = (z0) super.getOriginal();
        if (z0Var != null) {
            return z0Var;
        }
        a(11);
        throw null;
    }
}
