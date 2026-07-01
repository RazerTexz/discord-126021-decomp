package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$c extends d0.e0.p.d.m0.c.i1.i {
    /* JADX WARN: Illegal instructions before constructor call */
    public t$c(d0.e0.p.d.m0.g.e eVar) {
        if (eVar == null) {
            a(0);
            throw null;
        }
        d0.e0.p.d.m0.c.c0 errorModule = t.getErrorModule();
        d0.e0.p.d.m0.c.z zVar = d0.e0.p.d.m0.c.z.OPEN;
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.CLASS;
        List listEmptyList = Collections.emptyList();
        d0.e0.p.d.m0.c.u0 u0Var = d0.e0.p.d.m0.c.u0.a;
        super(errorModule, eVar, zVar, fVar, listEmptyList, u0Var, false, d0.e0.p.d.m0.m.f.f3514b);
        d0.e0.p.d.m0.c.i1.g gVarCreate = d0.e0.p.d.m0.c.i1.g.create(this, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), true, u0Var);
        gVarCreate.initialize(Collections.emptyList(), d0.e0.p.d.m0.c.t.d);
        d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = t.createErrorScope(getName().asString());
        gVarCreate.setReturnType(new s(t.b("<ERROR>", this), iVarCreateErrorScope));
        initialize(iVarCreateErrorScope, Collections.singleton(gVarCreate), gVarCreate);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 5 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 5:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                break;
            case 3:
                objArr[0] = "typeArguments";
                break;
            case 4:
            case 7:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 6:
                objArr[0] = "typeSubstitution";
                break;
            default:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
        }
        if (i == 2) {
            objArr[1] = "substitute";
        } else if (i == 5 || i == 8) {
            objArr[1] = "getMemberScope";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 4:
            case 6:
            case 7:
                objArr[2] = "getMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 5 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getMemberScope(z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        if (z0Var == null) {
            a(6);
            throw null;
        }
        if (gVar == null) {
            a(7);
            throw null;
        }
        StringBuilder sbU = b.d.b.a.a.U("Error scope for class ");
        sbU.append(getName());
        sbU.append(" with arguments: ");
        sbU.append(z0Var);
        d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = t.createErrorScope(sbU.toString());
        if (iVarCreateErrorScope != null) {
            return iVarCreateErrorScope;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.e substitute(c1 c1Var) {
        if (c1Var != null) {
            return this;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.i
    public String toString() {
        return getName().asString();
    }
}
