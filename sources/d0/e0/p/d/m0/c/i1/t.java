package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends u {
    public final u k;
    public final c1 l;
    public c1 m;
    public List<z0> n;
    public List<z0> o;
    public u0 p;

    public t(u uVar, c1 c1Var) {
        this.k = uVar;
        this.l = c1Var;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2];
        if (i == 2) {
            objArr[0] = "typeArguments";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 8) {
            objArr[0] = "typeArguments";
        } else if (i == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i != 22) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
            objArr[2] = "getMemberScope";
        } else if (i == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 8 && i != 10 && i != 13 && i != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitClassDescriptor(this, d);
    }

    public final c1 b() {
        if (this.m == null) {
            if (this.l.isEmpty()) {
                this.m = this.l;
            } else {
                List<z0> parameters = this.k.getTypeConstructor().getParameters();
                this.n = new ArrayList(parameters.size());
                this.m = d0.e0.p.d.m0.n.o.substituteTypeParameters(parameters, this.l.getSubstitution(), this, this.n);
                this.o = d0.t.u.filter(this.n, new t$a(this));
            }
        }
        return this.m;
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g annotations = this.k.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return this.k.getCompanionObjectDescriptor();
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
        Collection<d0.e0.p.d.m0.c.d> constructors = this.k.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (d0.e0.p.d.m0.c.d dVar : constructors) {
            arrayList.add(((d0.e0.p.d.m0.c.d) dVar.newCopyBuilder().setOriginal(dVar.getOriginal()).setModality(dVar.getModality()).setVisibility(dVar.getVisibility()).setKind(dVar.getKind()).setCopyOverrides(false).build()).substitute(b()));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        d0.e0.p.d.m0.c.m containingDeclaration = this.k.getContainingDeclaration();
        if (containingDeclaration != null) {
            return containingDeclaration;
        }
        a(21);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        b();
        List<z0> list = this.o;
        if (list != null) {
            return list;
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.j0 getDefaultType() {
        d0.e0.p.d.m0.n.j0 j0VarSimpleTypeWithNonTrivialMemberScope = d0.e0.p.d.m0.n.d0.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), e1.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (j0VarSimpleTypeWithNonTrivialMemberScope != null) {
            return j0VarSimpleTypeWithNonTrivialMemberScope;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        d0.e0.p.d.m0.c.f kind = this.k.getKind();
        if (kind != null) {
            return kind;
        }
        a(24);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getMemberScope(d0.e0.p.d.m0.n.z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        if (z0Var == null) {
            a(5);
            throw null;
        }
        if (gVar == null) {
            a(6);
            throw null;
        }
        d0.e0.p.d.m0.k.a0.i memberScope = this.k.getMemberScope(z0Var, gVar);
        if (!this.l.isEmpty()) {
            return new d0.e0.p.d.m0.k.a0.n(memberScope, b());
        }
        if (memberScope != null) {
            return memberScope;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z modality = this.k.getModality();
        if (modality != null) {
            return modality;
        }
        a(25);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e name = this.k.getName();
        if (name != null) {
            return name;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        Collection<d0.e0.p.d.m0.c.e> sealedSubclasses = this.k.getSealedSubclasses();
        if (sealedSubclasses != null) {
            return sealedSubclasses;
        }
        a(30);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.p
    public d0.e0.p.d.m0.c.u0 getSource() {
        return d0.e0.p.d.m0.c.u0.a;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        d0.e0.p.d.m0.k.a0.i staticScope = this.k.getStaticScope();
        if (staticScope != null) {
            return staticScope;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public q0 getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        u0 typeConstructor = this.k.getTypeConstructor();
        if (this.l.isEmpty()) {
            if (typeConstructor != null) {
                return typeConstructor;
            }
            a(0);
            throw null;
        }
        if (this.p == null) {
            c1 c1VarB = b();
            Collection<d0.e0.p.d.m0.n.c0> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            Iterator<d0.e0.p.d.m0.n.c0> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(c1VarB.substitute(it.next(), j1.INVARIANT));
            }
            this.p = new d0.e0.p.d.m0.n.i(this, this.n, arrayList, d0.e0.p.d.m0.m.f.f3514b);
        }
        u0 u0Var = this.p;
        if (u0Var != null) {
            return u0Var;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedInnerClassesScope() {
        d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = this.k.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope != null) {
            return unsubstitutedInnerClassesScope;
        }
        a(27);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope() {
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = getUnsubstitutedMemberScope(d0.e0.p.d.m0.k.x.a.getKotlinTypeRefiner(d0.e0.p.d.m0.k.e.getContainingModule(this.k)));
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return this.k.getUnsubstitutedPrimaryConstructor();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u visibility = this.k.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        a(26);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return this.k.isActual();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return this.k.isCompanionObject();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return this.k.isData();
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return this.k.isExpect();
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return this.k.isExternal();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return this.k.isFun();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return this.k.isInline();
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return this.k.isInner();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return this.k.isValue();
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar == null) {
            a(13);
            throw null;
        }
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = this.k.getUnsubstitutedMemberScope(gVar);
        if (!this.l.isEmpty()) {
            return new d0.e0.p.d.m0.k.a0.n(unsubstitutedMemberScope, b());
        }
        if (unsubstitutedMemberScope != null) {
            return unsubstitutedMemberScope;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.e substitute(c1 c1Var) {
        if (c1Var != null) {
            return c1Var.isEmpty() ? this : new t(this, c1.createChainedSubstitutor(c1Var.getSubstitution(), b().getSubstitution()));
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.e getOriginal() {
        d0.e0.p.d.m0.c.e original = this.k.getOriginal();
        if (original != null) {
            return original;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getMemberScope(d0.e0.p.d.m0.n.z0 z0Var) {
        if (z0Var != null) {
            d0.e0.p.d.m0.k.a0.i memberScope = getMemberScope(z0Var, d0.e0.p.d.m0.k.x.a.getKotlinTypeRefiner(d0.e0.p.d.m0.k.e.getContainingModule(this)));
            if (memberScope != null) {
                return memberScope;
            }
            a(11);
            throw null;
        }
        a(10);
        throw null;
    }
}
