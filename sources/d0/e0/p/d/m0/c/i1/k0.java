package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.x0$a;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TypeParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class k0 extends f {
    public final Function1<d0.e0.p.d.m0.n.c0, Void> t;
    public final List<d0.e0.p.d.m0.n.c0> u;
    public boolean v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, j1 j1Var, d0.e0.p.d.m0.g.e eVar, int i, u0 u0Var, Function1<d0.e0.p.d.m0.n.c0, Void> function1, x0 x0Var, d0.e0.p.d.m0.m.o oVar) {
        super(oVar, mVar, gVar, eVar, j1Var, z2, i, u0Var, x0Var);
        if (mVar == null) {
            a(19);
            throw null;
        }
        if (gVar == null) {
            a(20);
            throw null;
        }
        if (j1Var == null) {
            a(21);
            throw null;
        }
        if (eVar == null) {
            a(22);
            throw null;
        }
        if (u0Var == null) {
            a(23);
            throw null;
        }
        if (x0Var == null) {
            a(24);
            throw null;
        }
        if (oVar == null) {
            a(25);
            throw null;
        }
        this.u = new ArrayList(1);
        this.v = false;
        this.t = function1;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static k0 createForFurtherModification(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, j1 j1Var, d0.e0.p.d.m0.g.e eVar, int i, u0 u0Var, d0.e0.p.d.m0.m.o oVar) {
        if (mVar == null) {
            a(6);
            throw null;
        }
        if (gVar == null) {
            a(7);
            throw null;
        }
        if (j1Var == null) {
            a(8);
            throw null;
        }
        if (eVar == null) {
            a(9);
            throw null;
        }
        if (u0Var == null) {
            a(10);
            throw null;
        }
        if (oVar != null) {
            return createForFurtherModification(mVar, gVar, z2, j1Var, eVar, i, u0Var, null, x0$a.a, oVar);
        }
        a(11);
        throw null;
    }

    public static z0 createWithDefaultBound(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, j1 j1Var, d0.e0.p.d.m0.g.e eVar, int i, d0.e0.p.d.m0.m.o oVar) {
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (j1Var == null) {
            a(2);
            throw null;
        }
        if (eVar == null) {
            a(3);
            throw null;
        }
        if (oVar == null) {
            a(4);
            throw null;
        }
        k0 k0VarCreateForFurtherModification = createForFurtherModification(mVar, gVar, z2, j1Var, eVar, i, u0.a, oVar);
        k0VarCreateForFurtherModification.addUpperBound(d0.e0.p.d.m0.k.x.a.getBuiltIns(mVar).getDefaultBound());
        k0VarCreateForFurtherModification.setInitialized();
        return k0VarCreateForFurtherModification;
    }

    public void addUpperBound(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var == null) {
            a(26);
            throw null;
        }
        e();
        if (d0.e0.p.d.m0.n.e0.isError(c0Var)) {
            return;
        }
        this.u.add(c0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public void c(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var == null) {
            a(27);
            throw null;
        }
        Function1<d0.e0.p.d.m0.n.c0, Void> function1 = this.t;
        if (function1 == null) {
            return;
        }
        function1.invoke(c0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.f
    public List<d0.e0.p.d.m0.n.c0> d() {
        if (!this.v) {
            StringBuilder sbU = b.d.b.a.a.U("Type parameter descriptor is not initialized: ");
            sbU.append(f());
            throw new IllegalStateException(sbU.toString());
        }
        List<d0.e0.p.d.m0.n.c0> list = this.u;
        if (list != null) {
            return list;
        }
        a(28);
        throw null;
    }

    public final void e() {
        if (this.v) {
            StringBuilder sbU = b.d.b.a.a.U("Type parameter descriptor is already initialized: ");
            sbU.append(f());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public final String f() {
        return getName() + " declared in " + d0.e0.p.d.m0.k.e.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        e();
        this.v = true;
    }

    public static k0 createForFurtherModification(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, j1 j1Var, d0.e0.p.d.m0.g.e eVar, int i, u0 u0Var, Function1<d0.e0.p.d.m0.n.c0, Void> function1, x0 x0Var, d0.e0.p.d.m0.m.o oVar) {
        if (mVar == null) {
            a(12);
            throw null;
        }
        if (gVar == null) {
            a(13);
            throw null;
        }
        if (j1Var == null) {
            a(14);
            throw null;
        }
        if (eVar == null) {
            a(15);
            throw null;
        }
        if (u0Var == null) {
            a(16);
            throw null;
        }
        if (x0Var == null) {
            a(17);
            throw null;
        }
        if (oVar != null) {
            return new k0(mVar, gVar, z2, j1Var, eVar, i, u0Var, function1, x0Var, oVar);
        }
        a(18);
        throw null;
    }
}
