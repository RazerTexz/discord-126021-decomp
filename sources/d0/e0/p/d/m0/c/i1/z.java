package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.n.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MutableClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends h {
    public final d0.e0.p.d.m0.c.f r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f3279s;
    public d0.e0.p.d.m0.c.z t;
    public d0.e0.p.d.m0.c.u u;
    public u0 v;
    public List<z0> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Collection<d0.e0.p.d.m0.n.c0> f3280x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.o f3281y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.f fVar, boolean z2, boolean z3, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.u0 u0Var, d0.e0.p.d.m0.m.o oVar) {
        super(oVar, mVar, eVar, u0Var, z3);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (fVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (u0Var == null) {
            a(3);
            throw null;
        }
        if (oVar == null) {
            a(4);
            throw null;
        }
        this.f3280x = new ArrayList();
        this.f3281y = oVar;
        this.r = fVar;
        this.f3279s = z2;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void createTypeConstructor() {
        this.v = new d0.e0.p.d.m0.n.i(this, this.w, this.f3280x, this.f3281y);
        Iterator<d0.e0.p.d.m0.c.d> it = getConstructors().iterator();
        while (it.hasNext()) {
            ((g) it.next()).setReturnType(getDefaultType());
        }
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        if (empty != null) {
            return empty;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List<z0> list = this.w;
        if (list != null) {
            return list;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        d0.e0.p.d.m0.c.f fVar = this.r;
        if (fVar != null) {
            return fVar;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z zVar = this.t;
        if (zVar != null) {
            return zVar;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        i$b i_b = i$b.f3461b;
        if (i_b != null) {
            return i_b;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        u0 u0Var = this.v;
        if (u0Var != null) {
            return u0Var;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar == null) {
            a(16);
            throw null;
        }
        i$b i_b = i$b.f3461b;
        if (i_b != null) {
            return i_b;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = this.u;
        if (uVar != null) {
            return uVar;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return this.f3279s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public void setModality(d0.e0.p.d.m0.c.z zVar) {
        if (zVar != null) {
            this.t = zVar;
        } else {
            a(6);
            throw null;
        }
    }

    public void setTypeParameterDescriptors(List<z0> list) {
        if (list == null) {
            a(14);
            throw null;
        }
        if (this.w == null) {
            this.w = new ArrayList(list);
        } else {
            StringBuilder sbU = b.d.b.a.a.U("Type parameters are already set for ");
            sbU.append(getName());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public void setVisibility(d0.e0.p.d.m0.c.u uVar) {
        if (uVar != null) {
            this.u = uVar;
        } else {
            a(9);
            throw null;
        }
    }

    public String toString() {
        return k.toString(this);
    }

    @Override // d0.e0.p.d.m0.c.e
    public Set<d0.e0.p.d.m0.c.d> getConstructors() {
        Set<d0.e0.p.d.m0.c.d> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(13);
        throw null;
    }
}
