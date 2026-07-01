package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.u0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PropertySetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class e0 extends b0 implements p0 {
    public c1 v;
    public final p0 w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(d0.e0.p.d.m0.c.n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, boolean z2, boolean z3, boolean z4, b$a b_a, p0 p0Var, u0 u0Var) {
        p0 p0Var2;
        e0 e0Var;
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
        StringBuilder sbU = b.d.b.a.a.U("<set-");
        sbU.append(n0Var.getName());
        sbU.append(">");
        super(zVar, uVar, n0Var, gVar, d0.e0.p.d.m0.g.e.special(sbU.toString()), z2, z3, z4, b_a, u0Var);
        if (p0Var != null) {
            e0Var = this;
            p0Var2 = p0Var;
        } else {
            p0Var2 = this;
            e0Var = p0Var2;
        }
        e0Var.w = p0Var2;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static l0 createSetterParameter(p0 p0Var, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        if (p0Var == null) {
            a(7);
            throw null;
        }
        if (c0Var == null) {
            a(8);
            throw null;
        }
        if (gVar != null) {
            return new l0(p0Var, null, 0, gVar, d0.e0.p.d.m0.g.e.special("<set-?>"), c0Var, false, false, false, null, u0.a);
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitPropertySetterDescriptor(this, d);
    }

    @Override // d0.e0.p.d.m0.c.i1.b0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a
    public Collection<? extends p0> getOverriddenDescriptors() {
        return b(false);
    }

    @Override // d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        d0.e0.p.d.m0.n.j0 unitType = d0.e0.p.d.m0.k.x.a.getBuiltIns(this).getUnitType();
        if (unitType != null) {
            return unitType;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<c1> getValueParameters() {
        c1 c1Var = this.v;
        if (c1Var == null) {
            throw new IllegalStateException();
        }
        List<c1> listSingletonList = Collections.singletonList(c1Var);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(11);
        throw null;
    }

    public void initialize(c1 c1Var) {
        if (c1Var != null) {
            this.v = c1Var;
        } else {
            a(6);
            throw null;
        }
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
    public p0 getOriginal() {
        p0 p0Var = this.w;
        if (p0Var != null) {
            return p0Var;
        }
        a(13);
        throw null;
    }
}
