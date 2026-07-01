package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.z0;

/* JADX INFO: compiled from: AbstractClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends u {
    public final d0.e0.p.d.m0.g.e k;
    public final d0.e0.p.d.m0.m.j<d0.e0.p.d.m0.n.j0> l;
    public final d0.e0.p.d.m0.m.j<d0.e0.p.d.m0.k.a0.i> m;
    public final d0.e0.p.d.m0.m.j<q0> n;

    public a(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.g.e eVar) {
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        this.k = eVar;
        this.l = oVar.createLazyValue(new a$a(this));
        this.m = oVar.createLazyValue(new a$b(this));
        this.n = oVar.createLazyValue(new a$c(this));
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitClassDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.j0 getDefaultType() {
        d0.e0.p.d.m0.n.j0 j0VarInvoke = this.l.invoke();
        if (j0VarInvoke != null) {
            return j0VarInvoke;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getMemberScope(z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        if (z0Var == null) {
            a(9);
            throw null;
        }
        if (gVar == null) {
            a(10);
            throw null;
        }
        if (!z0Var.isEmpty()) {
            return new d0.e0.p.d.m0.k.a0.n(getUnsubstitutedMemberScope(gVar), c1.create(z0Var));
        }
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = getUnsubstitutedMemberScope(gVar);
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVar = this.k;
        if (eVar != null) {
            return eVar;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.e getOriginal() {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.e
    public q0 getThisAsReceiverParameter() {
        q0 q0VarInvoke = this.n.invoke();
        if (q0VarInvoke != null) {
            return q0VarInvoke;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedInnerClassesScope() {
        d0.e0.p.d.m0.k.a0.i iVarInvoke = this.m.invoke();
        if (iVarInvoke != null) {
            return iVarInvoke;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope() {
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = getUnsubstitutedMemberScope(d0.e0.p.d.m0.k.x.a.getKotlinTypeRefiner(d0.e0.p.d.m0.k.e.getContainingModule(this)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.e substitute(c1 c1Var) {
        if (c1Var != null) {
            return c1Var.isEmpty() ? this : new t(this, c1Var);
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getMemberScope(z0 z0Var) {
        if (z0Var != null) {
            d0.e0.p.d.m0.k.a0.i memberScope = getMemberScope(z0Var, d0.e0.p.d.m0.k.x.a.getKotlinTypeRefiner(d0.e0.p.d.m0.k.e.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            a(15);
            throw null;
        }
        a(14);
        throw null;
    }
}
