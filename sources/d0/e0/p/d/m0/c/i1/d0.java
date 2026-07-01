package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.u0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PropertyGetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends b0 implements o0 {
    public d0.e0.p.d.m0.n.c0 v;
    public final o0 w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(d0.e0.p.d.m0.c.n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, boolean z2, boolean z3, boolean z4, b$a b_a, o0 o0Var, u0 u0Var) {
        o0 o0Var2;
        d0 d0Var;
        if (n0Var == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (zVar == null) {
            a(2);
            throw null;
        }
        if (uVar == null) {
            a(3);
            throw null;
        }
        if (b_a == null) {
            a(4);
            throw null;
        }
        if (u0Var == null) {
            a(5);
            throw null;
        }
        StringBuilder sbU = b.d.b.a.a.U("<get-");
        sbU.append(n0Var.getName());
        sbU.append(">");
        super(zVar, uVar, n0Var, gVar, d0.e0.p.d.m0.g.e.special(sbU.toString()), z2, z3, z4, b_a, u0Var);
        if (o0Var != null) {
            d0Var = this;
            o0Var2 = o0Var;
        } else {
            o0Var2 = this;
            d0Var = o0Var2;
        }
        d0Var.w = o0Var2;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitPropertyGetterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    public Collection<? extends o0> getOverriddenDescriptors() {
        return b(true);
    }

    @Override // d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<c1> getValueParameters() {
        List<c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(7);
        throw null;
    }

    public void initialize(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var == null) {
            c0Var = getCorrespondingProperty().getType();
        }
        this.v = c0Var;
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m0 getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public o0 getOriginal() {
        o0 o0Var = this.w;
        if (o0Var != null) {
            return o0Var;
        }
        a(8);
        throw null;
    }
}
