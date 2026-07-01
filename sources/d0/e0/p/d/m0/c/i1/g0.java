package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x$a;
import d0.e0.p.d.m0.c.z0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0 extends q implements t0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(d0.e0.p.d.m0.c.m mVar, t0 t0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, b$a b_a, u0 u0Var) {
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
        if (u0Var != null) {
        } else {
            a(4);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 17) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "getOriginal";
        } else if (i == 23) {
            objArr[1] = "copy";
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 17 && i != 18 && i != 23 && i != 24) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static g0 create(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, b$a b_a, u0 u0Var) {
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
        if (b_a == null) {
            a(8);
            throw null;
        }
        if (u0Var != null) {
            return new g0(mVar, null, gVar, eVar, b_a, u0Var);
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public q b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        if (mVar == null) {
            a(19);
            throw null;
        }
        if (b_a == null) {
            a(20);
            throw null;
        }
        if (gVar == null) {
            a(21);
            throw null;
        }
        t0 t0Var = (t0) xVar;
        if (eVar == null) {
            eVar = getName();
        }
        return new g0(mVar, t0Var, gVar, eVar, b_a, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public /* bridge */ /* synthetic */ q initialize(q0 q0Var, q0 q0Var2, List list, List list2, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar) {
        return initialize(q0Var, q0Var2, (List<? extends z0>) list, (List<c1>) list2, c0Var, zVar, uVar);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.t0
    public x$a<? extends t0> newCopyBuilder() {
        x$a x_aNewCopyBuilder = super.newCopyBuilder();
        if (x_aNewCopyBuilder != null) {
            return x_aNewCopyBuilder;
        }
        a(24);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public g0 initialize(q0 q0Var, q0 q0Var2, List<? extends z0> list, List<c1> list2, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar) {
        if (list == null) {
            a(10);
            throw null;
        }
        if (list2 == null) {
            a(11);
            throw null;
        }
        if (uVar == null) {
            a(12);
            throw null;
        }
        g0 g0VarInitialize = initialize(q0Var, q0Var2, list, list2, c0Var, zVar, uVar, null);
        if (g0VarInitialize != null) {
            return g0VarInitialize;
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public t0 copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        t0 t0Var = (t0) super.copy(mVar, zVar, uVar, b_a, z2);
        if (t0Var != null) {
            return t0Var;
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    public g0 initialize(q0 q0Var, q0 q0Var2, List<? extends z0> list, List<c1> list2, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, Map<? extends d0.e0.p.d.m0.c.a$a<?>, ?> map) {
        if (list == null) {
            a(14);
            throw null;
        }
        if (list2 == null) {
            a(15);
            throw null;
        }
        if (uVar != null) {
            super.initialize(q0Var, q0Var2, list, list2, c0Var, zVar, uVar);
            if (map != null && !map.isEmpty()) {
                this.L = new LinkedHashMap(map);
            }
            return this;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public t0 getOriginal() {
        t0 t0Var = (t0) super.getOriginal();
        if (t0Var != null) {
            return t0Var;
        }
        a(18);
        throw null;
    }
}
