package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends h {
    public final u0 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.k.a0.i f3269s;
    public final d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> t;
    public final d0.e0.p.d.m0.c.g1.g u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.g.e eVar2, d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> jVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.u0 u0Var) {
        super(oVar, eVar, eVar2, u0Var, false);
        if (oVar == null) {
            a(6);
            throw null;
        }
        if (c0Var == null) {
            a(8);
            throw null;
        }
        if (eVar2 == null) {
            a(9);
            throw null;
        }
        if (jVar == null) {
            a(10);
            throw null;
        }
        if (gVar == null) {
            a(11);
            throw null;
        }
        if (u0Var == null) {
            a(12);
            throw null;
        }
        this.u = gVar;
        this.r = new d0.e0.p.d.m0.n.i(this, Collections.emptyList(), Collections.singleton(c0Var), oVar);
        this.f3269s = new o$a(this, oVar);
        this.t = jVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static o create(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.g.e eVar2, d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> jVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.u0 u0Var) {
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (eVar2 == null) {
            a(2);
            throw null;
        }
        if (jVar == null) {
            a(3);
            throw null;
        }
        if (gVar == null) {
            a(4);
            throw null;
        }
        if (u0Var != null) {
            return new o(oVar, eVar, eVar.getDefaultType(), eVar2, jVar, gVar, u0Var);
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g gVar = this.u;
        if (gVar != null) {
            return gVar;
        }
        a(21);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        return d0.e0.p.d.m0.c.f.ENUM_ENTRY;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        return d0.e0.p.d.m0.c.z.FINAL;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        i$b i_b = i$b.f3461b;
        if (i_b != null) {
            return i_b;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        u0 u0Var = this.r;
        if (u0Var != null) {
            return u0Var;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar == null) {
            a(13);
            throw null;
        }
        d0.e0.p.d.m0.k.a0.i iVar = this.f3269s;
        if (iVar != null) {
            return iVar;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.e;
        if (uVar != null) {
            return uVar;
        }
        a(20);
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
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("enum entry ");
        sbU.append(getName());
        return sbU.toString();
    }
}
