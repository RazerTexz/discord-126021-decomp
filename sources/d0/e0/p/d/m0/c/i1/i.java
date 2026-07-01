package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ClassDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends h {
    public final d0.e0.p.d.m0.c.z r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.f f3267s;
    public final u0 t;
    public d0.e0.p.d.m0.k.a0.i u;
    public Set<d0.e0.p.d.m0.c.d> v;
    public d0.e0.p.d.m0.c.d w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.f fVar, Collection<d0.e0.p.d.m0.n.c0> collection, d0.e0.p.d.m0.c.u0 u0Var, boolean z2, d0.e0.p.d.m0.m.o oVar) {
        super(oVar, mVar, eVar, u0Var, z2);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (zVar == null) {
            a(2);
            throw null;
        }
        if (fVar == null) {
            a(3);
            throw null;
        }
        if (collection == null) {
            a(4);
            throw null;
        }
        if (u0Var == null) {
            a(5);
            throw null;
        }
        if (oVar == null) {
            a(6);
            throw null;
        }
        this.r = zVar;
        this.f3267s = fVar;
        this.t = new d0.e0.p.d.m0.n.i(this, Collections.emptyList(), collection, oVar);
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        if (empty != null) {
            return empty;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
        Set<d0.e0.p.d.m0.c.d> set = this.v;
        if (set != null) {
            return set;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        d0.e0.p.d.m0.c.f fVar = this.f3267s;
        if (fVar != null) {
            return fVar;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z zVar = this.r;
        if (zVar != null) {
            return zVar;
        }
        a(16);
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
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        u0 u0Var = this.t;
        if (u0Var != null) {
            return u0Var;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar == null) {
            a(12);
            throw null;
        }
        d0.e0.p.d.m0.k.a0.i iVar = this.u;
        if (iVar != null) {
            return iVar;
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.e;
        if (uVar != null) {
            return uVar;
        }
        a(17);
        throw null;
    }

    public final void initialize(d0.e0.p.d.m0.k.a0.i iVar, Set<d0.e0.p.d.m0.c.d> set, d0.e0.p.d.m0.c.d dVar) {
        if (iVar == null) {
            a(7);
            throw null;
        }
        if (set == null) {
            a(8);
            throw null;
        }
        this.u = iVar;
        this.v = set;
        this.w = dVar;
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
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("class ");
        sbU.append(getName());
        return sbU.toString();
    }
}
