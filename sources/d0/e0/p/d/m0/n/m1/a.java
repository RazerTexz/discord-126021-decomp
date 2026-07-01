package d0.e0.p.d.m0.n.m1;

import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.x$a;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.n.t$d;
import java.util.Collection;

/* JADX INFO: compiled from: ErrorSimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends g0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, t$d t_d) {
        super(eVar, null, g.f.getEMPTY(), d0.e0.p.d.m0.g.e.special("<ERROR FUNCTION>"), b$a.DECLARATION, u0.a);
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (t_d != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(m mVar, x xVar, b$a b_a, d0.e0.p.d.m0.g.e eVar, g gVar, u0 u0Var) {
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (b_a == null) {
            a(3);
            throw null;
        }
        if (gVar != null) {
            return this;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ b copy(m mVar, z zVar, u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public t0 copy(m mVar, z zVar, u uVar, b$a b_a, boolean z2) {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public <V> V getUserData(d0.e0.p.d.m0.c.a$a<V> a_a) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.t0
    public x$a<? extends t0> newCopyBuilder() {
        return new a$a(this);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public void setOverriddenDescriptors(Collection<? extends b> collection) {
        if (collection != null) {
            return;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ x copy(m mVar, z zVar, u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }
}
