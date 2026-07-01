package d0.e0.p.d.m0.e.a.h0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a$a;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: JavaMethodDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends g0 implements b {
    public static final a$a<c1> M = new f$a();
    public f$b N;
    public final boolean O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(m mVar, t0 t0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, b$a b_a, u0 u0Var, boolean z2) {
        super(mVar, t0Var, gVar, eVar, b_a, u0Var);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (b_a == null) {
            a(3);
            throw null;
        }
        if (u0Var == null) {
            a(4);
            throw null;
        }
        this.N = null;
        this.O = z2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static f createJavaMethod(m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, u0 u0Var, boolean z2) {
        if (mVar == null) {
            a(5);
            throw null;
        }
        if (gVar == null) {
            a(6);
            throw null;
        }
        if (eVar == null) {
            a(7);
            throw null;
        }
        if (u0Var != null) {
            return new f(mVar, null, gVar, eVar, b$a.DECLARATION, u0Var, z2);
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(m mVar, x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        if (mVar == null) {
            a(13);
            throw null;
        }
        if (b_a == null) {
            a(14);
            throw null;
        }
        if (gVar == null) {
            a(15);
            throw null;
        }
        t0 t0Var = (t0) xVar;
        if (eVar == null) {
            eVar = getName();
        }
        f fVar = new f(mVar, t0Var, gVar, eVar, b_a, u0Var, this.O);
        fVar.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return fVar;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.b
    public /* bridge */ /* synthetic */ b enhance(c0 c0Var, List list, c0 c0Var2, Pair pair) {
        return enhance(c0Var, (List<l>) list, c0Var2, (Pair<a$a<?>, ?>) pair);
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public boolean hasStableParameterNames() {
        return this.N.isStable;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return this.N.isSynthesized;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0
    public g0 initialize(q0 q0Var, q0 q0Var2, List<? extends z0> list, List<c1> list2, c0 c0Var, z zVar, u uVar, Map<? extends a$a<?>, ?> map) {
        if (list == null) {
            a(9);
            throw null;
        }
        if (list2 == null) {
            a(10);
            throw null;
        }
        if (uVar == null) {
            a(11);
            throw null;
        }
        g0 g0VarInitialize = super.initialize(q0Var, q0Var2, list, list2, c0Var, zVar, uVar, map);
        setOperator(d0.e0.p.d.m0.o.i.a.check(g0VarInitialize).isSuccess());
        if (g0VarInitialize != null) {
            return g0VarInitialize;
        }
        a(12);
        throw null;
    }

    public void setParameterNamesStatus(boolean z2, boolean z3) {
        this.N = f$b.get(z2, z3);
    }

    @Override // d0.e0.p.d.m0.e.a.h0.b
    public f enhance(c0 c0Var, List<l> list, c0 c0Var2, Pair<a$a<?>, ?> pair) {
        if (list == null) {
            a(18);
            throw null;
        }
        if (c0Var2 == null) {
            a(19);
            throw null;
        }
        f fVar = (f) newCopyBuilder().setValueParameters(k.copyValueParameters(list, getValueParameters(), this)).setReturnType(c0Var2).setExtensionReceiverParameter(c0Var == null ? null : d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(this, c0Var, d0.e0.p.d.m0.c.g1.g.f.getEMPTY())).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (pair != null) {
            fVar.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        if (fVar != null) {
            return fVar;
        }
        a(20);
        throw null;
    }
}
