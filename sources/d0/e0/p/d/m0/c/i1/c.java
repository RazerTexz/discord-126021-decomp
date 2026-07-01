package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: AbstractReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends k implements q0 {
    public static final d0.e0.p.d.m0.g.e l = d0.e0.p.d.m0.g.e.special("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d0.e0.p.d.m0.c.g1.g gVar) {
        super(gVar, l);
        if (gVar != null) {
        } else {
            a(0);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitReceiverParameterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getDispatchReceiverParameter() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getExtensionReceiverParameter() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.k0 getOriginal() {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.a
    public Collection<? extends d0.e0.p.d.m0.c.a> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        return getType();
    }

    @Override // d0.e0.p.d.m0.c.p
    public u0 getSource() {
        return u0.a;
    }

    @Override // d0.e0.p.d.m0.c.b1
    public d0.e0.p.d.m0.n.c0 getType() {
        d0.e0.p.d.m0.n.c0 type = getValue().getType();
        if (type != null) {
            return type;
        }
        a(3);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<z0> getTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<c1> getValueParameters() {
        List<c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.f;
        if (uVar != null) {
            return uVar;
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.q0, d0.e0.p.d.m0.c.w0
    public q0 substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        if (c1Var == null) {
            a(1);
            throw null;
        }
        if (c1Var.isEmpty()) {
            return this;
        }
        d0.e0.p.d.m0.n.c0 c0VarSubstitute = getContainingDeclaration() instanceof d0.e0.p.d.m0.c.e ? c1Var.substitute(getType(), j1.OUT_VARIANCE) : c1Var.substitute(getType(), j1.INVARIANT);
        if (c0VarSubstitute == null) {
            return null;
        }
        return c0VarSubstitute == getType() ? this : new f0(getContainingDeclaration(), new d0.e0.p.d.m0.k.a0.p.g(c0VarSubstitute), getAnnotations());
    }
}
