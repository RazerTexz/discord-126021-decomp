package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PropertyDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0$a {
    public d0.e0.p.d.m0.c.m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0.e0.p.d.m0.c.z f3263b;
    public d0.e0.p.d.m0.c.u c;
    public b$a e;
    public q0 h;
    public d0.e0.p.d.m0.g.e i;
    public d0.e0.p.d.m0.n.c0 j;
    public final /* synthetic */ c0 k;
    public d0.e0.p.d.m0.c.n0 d = null;
    public z0 f = z0.a;
    public boolean g = true;

    public c0$a(c0 c0Var) {
        this.k = c0Var;
        this.a = c0Var.getContainingDeclaration();
        this.f3263b = c0Var.getModality();
        this.c = c0Var.getVisibility();
        this.e = c0Var.getKind();
        this.h = c0Var.B;
        this.i = c0Var.getName();
        this.j = c0Var.getType();
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                break;
            case 4:
                objArr[0] = "type";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 8:
                objArr[0] = "visibility";
                break;
            case 10:
                objArr[0] = "kind";
                break;
            case 12:
                objArr[0] = "typeParameters";
                break;
            case 15:
                objArr[0] = "substitution";
                break;
            case 18:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            default:
                objArr[0] = "owner";
                break;
        }
        if (i == 1) {
            objArr[1] = "setOwner";
        } else if (i == 2) {
            objArr[1] = "setOriginal";
        } else if (i == 3) {
            objArr[1] = "setPreserveSourceElement";
        } else if (i == 5) {
            objArr[1] = "setReturnType";
        } else if (i == 7) {
            objArr[1] = "setModality";
        } else if (i == 9) {
            objArr[1] = "setVisibility";
        } else if (i == 11) {
            objArr[1] = "setKind";
        } else if (i == 19) {
            objArr[1] = "setName";
        } else if (i == 13) {
            objArr[1] = "setTypeParameters";
        } else if (i == 14) {
            objArr[1] = "setDispatchReceiverParameter";
        } else if (i == 16) {
            objArr[1] = "setSubstitution";
        } else if (i != 17) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        } else {
            objArr[1] = "setCopyOverrides";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                break;
            case 4:
                objArr[2] = "setReturnType";
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 8:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setKind";
                break;
            case 12:
                objArr[2] = "setTypeParameters";
                break;
            case 15:
                objArr[2] = "setSubstitution";
                break;
            case 18:
                objArr[2] = "setName";
                break;
            default:
                objArr[2] = "setOwner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public d0.e0.p.d.m0.c.n0 build() {
        q0 q0VarSubstitute;
        f0 f0Var;
        d0 d0Var;
        e0 e0Var;
        d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> kVar;
        c0 c0Var = this.k;
        Objects.requireNonNull(c0Var);
        b$a b_a = b$a.FAKE_OVERRIDE;
        d0.e0.p.d.m0.c.m mVar = this.a;
        d0.e0.p.d.m0.c.z zVar = this.f3263b;
        d0.e0.p.d.m0.c.u uVar = this.c;
        d0.e0.p.d.m0.c.n0 n0Var = this.d;
        b$a b_a2 = this.e;
        d0.e0.p.d.m0.g.e eVar = this.i;
        u0 u0Var = u0.a;
        c0 c0VarB = c0Var.b(mVar, zVar, uVar, n0Var, b_a2, eVar, u0Var);
        List<d0.e0.p.d.m0.c.z0> typeParameters = c0Var.getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.size());
        c1 c1VarSubstituteTypeParameters = d0.e0.p.d.m0.n.o.substituteTypeParameters(typeParameters, this.f, c0VarB, arrayList);
        d0.e0.p.d.m0.n.c0 c0Var2 = this.j;
        j1 j1Var = j1.OUT_VARIANCE;
        d0.e0.p.d.m0.n.c0 c0VarSubstitute = c1VarSubstituteTypeParameters.substitute(c0Var2, j1Var);
        if (c0VarSubstitute == null) {
            return null;
        }
        q0 q0Var = this.h;
        if (q0Var != null) {
            q0VarSubstitute = q0Var.substitute(c1VarSubstituteTypeParameters);
            if (q0VarSubstitute == null) {
                return null;
            }
        } else {
            q0VarSubstitute = null;
        }
        q0 q0Var2 = c0Var.C;
        if (q0Var2 != null) {
            d0.e0.p.d.m0.n.c0 c0VarSubstitute2 = c1VarSubstituteTypeParameters.substitute(q0Var2.getType(), j1.IN_VARIANCE);
            if (c0VarSubstitute2 == null) {
                return null;
            }
            f0Var = new f0(c0VarB, new d0.e0.p.d.m0.k.a0.p.b(c0VarB, c0VarSubstitute2, c0Var.C.getValue()), c0Var.C.getAnnotations());
        } else {
            f0Var = null;
        }
        c0VarB.setType(c0VarSubstitute, arrayList, q0VarSubstitute, f0Var);
        d0 d0Var2 = c0Var.E;
        if (d0Var2 == null) {
            d0Var = null;
        } else {
            d0.e0.p.d.m0.c.g1.g annotations = d0Var2.getAnnotations();
            d0.e0.p.d.m0.c.z zVar2 = this.f3263b;
            d0.e0.p.d.m0.c.u visibility = c0Var.E.getVisibility();
            if (this.e == b_a && d0.e0.p.d.m0.c.t.isPrivate(visibility.normalize())) {
                visibility = d0.e0.p.d.m0.c.t.h;
            }
            d0.e0.p.d.m0.c.u uVar2 = visibility;
            boolean zIsDefault = c0Var.E.isDefault();
            boolean zIsExternal = c0Var.E.isExternal();
            boolean zIsInline = c0Var.E.isInline();
            b$a b_a3 = this.e;
            d0.e0.p.d.m0.c.n0 n0Var2 = this.d;
            d0Var = new d0(c0VarB, annotations, zVar2, uVar2, zIsDefault, zIsExternal, zIsInline, b_a3, n0Var2 == null ? null : n0Var2.getGetter(), u0Var);
        }
        if (d0Var != null) {
            d0.e0.p.d.m0.n.c0 returnType = c0Var.E.getReturnType();
            d0Var.setInitialSignatureDescriptor(c0.c(c1VarSubstituteTypeParameters, c0Var.E));
            d0Var.initialize(returnType != null ? c1VarSubstituteTypeParameters.substitute(returnType, j1Var) : null);
        }
        p0 p0Var = c0Var.F;
        if (p0Var == null) {
            e0Var = null;
        } else {
            d0.e0.p.d.m0.c.g1.g annotations2 = p0Var.getAnnotations();
            d0.e0.p.d.m0.c.z zVar3 = this.f3263b;
            d0.e0.p.d.m0.c.u visibility2 = c0Var.F.getVisibility();
            if (this.e == b_a && d0.e0.p.d.m0.c.t.isPrivate(visibility2.normalize())) {
                visibility2 = d0.e0.p.d.m0.c.t.h;
            }
            d0.e0.p.d.m0.c.u uVar3 = visibility2;
            boolean zIsDefault2 = c0Var.F.isDefault();
            boolean zIsExternal2 = c0Var.F.isExternal();
            boolean zIsInline2 = c0Var.F.isInline();
            b$a b_a4 = this.e;
            d0.e0.p.d.m0.c.n0 n0Var3 = this.d;
            e0Var = new e0(c0VarB, annotations2, zVar3, uVar3, zIsDefault2, zIsExternal2, zIsInline2, b_a4, n0Var3 == null ? null : n0Var3.getSetter(), u0Var);
        }
        if (e0Var != null) {
            List<d0.e0.p.d.m0.c.c1> substitutedValueParameters = q.getSubstitutedValueParameters(e0Var, c0Var.F.getValueParameters(), c1VarSubstituteTypeParameters, false, false, null);
            if (substitutedValueParameters == null) {
                c0VarB.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(e0.createSetterParameter(e0Var, d0.e0.p.d.m0.k.x.a.getBuiltIns(this.a).getNothingType(), c0Var.F.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() != 1) {
                throw new IllegalStateException();
            }
            e0Var.setInitialSignatureDescriptor(c0.c(c1VarSubstituteTypeParameters, c0Var.F));
            e0Var.initialize(substitutedValueParameters.get(0));
        }
        d0.e0.p.d.m0.c.v vVar = c0Var.H;
        p pVar = vVar == null ? null : new p(vVar.getAnnotations(), c0VarB);
        d0.e0.p.d.m0.c.v vVar2 = c0Var.I;
        c0VarB.initialize(d0Var, e0Var, pVar, vVar2 != null ? new p(vVar2.getAnnotations(), c0VarB) : null);
        if (this.g) {
            d0.e0.p.d.m0.p.j jVarCreate = d0.e0.p.d.m0.p.j.create();
            Iterator<? extends d0.e0.p.d.m0.c.n0> it = c0Var.getOverriddenDescriptors().iterator();
            while (it.hasNext()) {
                jVarCreate.add(it.next().substitute(c1VarSubstituteTypeParameters));
            }
            c0VarB.setOverriddenDescriptors(jVarCreate);
        }
        if (c0Var.isConst() && (kVar = c0Var.p) != null) {
            c0VarB.setCompileTimeInitializer(kVar);
        }
        return c0VarB;
    }

    public c0$a setCopyOverrides(boolean z2) {
        this.g = z2;
        return this;
    }

    public c0$a setKind(b$a b_a) {
        if (b_a != null) {
            this.e = b_a;
            return this;
        }
        a(10);
        throw null;
    }

    public c0$a setModality(d0.e0.p.d.m0.c.z zVar) {
        if (zVar != null) {
            this.f3263b = zVar;
            return this;
        }
        a(6);
        throw null;
    }

    public c0$a setOriginal(d0.e0.p.d.m0.c.b bVar) {
        this.d = (d0.e0.p.d.m0.c.n0) bVar;
        return this;
    }

    public c0$a setOwner(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            this.a = mVar;
            return this;
        }
        a(0);
        throw null;
    }

    public c0$a setSubstitution(z0 z0Var) {
        if (z0Var != null) {
            this.f = z0Var;
            return this;
        }
        a(15);
        throw null;
    }

    public c0$a setVisibility(d0.e0.p.d.m0.c.u uVar) {
        if (uVar != null) {
            this.c = uVar;
            return this;
        }
        a(8);
        throw null;
    }
}
