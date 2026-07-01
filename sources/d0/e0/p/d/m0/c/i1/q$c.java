package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x$a;
import d0.e0.p.d.m0.n.z0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class q$c implements x$a<d0.e0.p.d.m0.c.x> {
    public z0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0.e0.p.d.m0.c.m f3275b;
    public d0.e0.p.d.m0.c.z c;
    public d0.e0.p.d.m0.c.u d;
    public d0.e0.p.d.m0.c.x e;
    public b$a f;
    public List<c1> g;
    public q0 h;
    public q0 i;
    public d0.e0.p.d.m0.n.c0 j;
    public d0.e0.p.d.m0.g.e k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public List<d0.e0.p.d.m0.c.z0> q;
    public d0.e0.p.d.m0.c.g1.g r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3276s;
    public Map<d0.e0.p.d.m0.c.a$a<?>, Object> t;
    public Boolean u;
    public boolean v;
    public final /* synthetic */ q w;

    public q$c(q qVar, z0 z0Var, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, List<c1> list, q0 q0Var, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.g.e eVar) {
        if (z0Var == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
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
        if (list == null) {
            a(5);
            throw null;
        }
        if (c0Var == null) {
            a(6);
            throw null;
        }
        this.w = qVar;
        this.e = null;
        this.i = qVar.r;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = qVar.isHiddenToOvercomeSignatureClash();
        this.q = null;
        this.r = null;
        this.f3276s = qVar.isHiddenForResolutionEverywhereBesideSupercalls();
        this.t = new LinkedHashMap();
        this.u = null;
        this.v = false;
        this.a = z0Var;
        this.f3275b = mVar;
        this.c = zVar;
        this.d = uVar;
        this.f = b_a;
        this.g = list;
        this.h = q0Var;
        this.j = c0Var;
        this.k = eVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 35:
            case 37:
            case 38:
            case 39:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 11:
            case 13:
            case 16:
            case 18:
            case 20:
            case 22:
            case 32:
            case 34:
            case 36:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 35:
            case 37:
            case 38:
            case 39:
                i2 = 2;
                break;
            case 9:
            case 11:
            case 13:
            case 16:
            case 18:
            case 20:
            case 22:
            case 32:
            case 34:
            case 36:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "newOwner";
                break;
            case 2:
                objArr[0] = "newModality";
                break;
            case 3:
                objArr[0] = "newVisibility";
                break;
            case 4:
            case 13:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "newValueParameterDescriptors";
                break;
            case 6:
                objArr[0] = "newReturnType";
                break;
            case 7:
                objArr[0] = "owner";
                break;
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 35:
            case 37:
            case 38:
            case 39:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 9:
                objArr[0] = "modality";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 16:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 18:
            case 20:
                objArr[0] = "parameters";
                break;
            case 22:
                objArr[0] = "type";
                break;
            case 32:
                objArr[0] = "additionalAnnotations";
                break;
            case 34:
            default:
                objArr[0] = "substitution";
                break;
            case 36:
                objArr[0] = "userDataKey";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "setOwner";
                break;
            case 9:
            case 11:
            case 13:
            case 16:
            case 18:
            case 20:
            case 22:
            case 32:
            case 34:
            case 36:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            case 10:
                objArr[1] = "setModality";
                break;
            case 12:
                objArr[1] = "setVisibility";
                break;
            case 14:
                objArr[1] = "setKind";
                break;
            case 15:
                objArr[1] = "setCopyOverrides";
                break;
            case 17:
                objArr[1] = "setName";
                break;
            case 19:
                objArr[1] = "setValueParameters";
                break;
            case 21:
                objArr[1] = "setTypeParameters";
                break;
            case 23:
                objArr[1] = "setReturnType";
                break;
            case 24:
                objArr[1] = "setExtensionReceiverParameter";
                break;
            case 25:
                objArr[1] = "setDispatchReceiverParameter";
                break;
            case 26:
                objArr[1] = "setOriginal";
                break;
            case 27:
                objArr[1] = "setSignatureChange";
                break;
            case 28:
                objArr[1] = "setPreserveSourceElement";
                break;
            case 29:
                objArr[1] = "setDropOriginalInContainingParts";
                break;
            case 30:
                objArr[1] = "setHiddenToOvercomeSignatureClash";
                break;
            case 31:
                objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                break;
            case 33:
                objArr[1] = "setAdditionalAnnotations";
                break;
            case 35:
                objArr[1] = "setSubstitution";
                break;
            case 37:
                objArr[1] = "putUserData";
                break;
            case 38:
                objArr[1] = "getSubstitution";
                break;
            case 39:
                objArr[1] = "setJustForTypeSubstitution";
                break;
        }
        switch (i) {
            case 7:
                objArr[2] = "setOwner";
                break;
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 35:
            case 37:
            case 38:
            case 39:
                break;
            case 9:
                objArr[2] = "setModality";
                break;
            case 11:
                objArr[2] = "setVisibility";
                break;
            case 13:
                objArr[2] = "setKind";
                break;
            case 16:
                objArr[2] = "setName";
                break;
            case 18:
                objArr[2] = "setValueParameters";
                break;
            case 20:
                objArr[2] = "setTypeParameters";
                break;
            case 22:
                objArr[2] = "setReturnType";
                break;
            case 32:
                objArr[2] = "setAdditionalAnnotations";
                break;
            case 34:
                objArr[2] = "setSubstitution";
                break;
            case 36:
                objArr[2] = "putUserData";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
            case 19:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 33:
            case 35:
            case 37:
            case 38:
            case 39:
                throw new IllegalStateException(str2);
            case 9:
            case 11:
            case 13:
            case 16:
            case 18:
            case 20:
            case 22:
            case 32:
            case 34:
            case 36:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public d0.e0.p.d.m0.c.x build() {
        return this.w.c(this);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setAdditionalAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return setAdditionalAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setCopyOverrides(boolean z2) {
        return setCopyOverrides(z2);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setDispatchReceiverParameter(q0 q0Var) {
        return setDispatchReceiverParameter(q0Var);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setDropOriginalInContainingParts() {
        return setDropOriginalInContainingParts();
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setExtensionReceiverParameter(q0 q0Var) {
        return setExtensionReceiverParameter(q0Var);
    }

    public q$c setHasSynthesizedParameterNames(boolean z2) {
        this.u = Boolean.valueOf(z2);
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setHiddenForResolutionEverywhereBesideSupercalls() {
        return setHiddenForResolutionEverywhereBesideSupercalls();
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setHiddenToOvercomeSignatureClash() {
        return setHiddenToOvercomeSignatureClash();
    }

    public q$c setJustForTypeSubstitution(boolean z2) {
        this.v = z2;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setKind(b$a b_a) {
        return setKind(b_a);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setModality(d0.e0.p.d.m0.c.z zVar) {
        return setModality(zVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setName(d0.e0.p.d.m0.g.e eVar) {
        return setName(eVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setOriginal(d0.e0.p.d.m0.c.b bVar) {
        return setOriginal(bVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setOwner(d0.e0.p.d.m0.c.m mVar) {
        return setOwner(mVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setPreserveSourceElement() {
        return setPreserveSourceElement();
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setReturnType(d0.e0.p.d.m0.n.c0 c0Var) {
        return setReturnType(c0Var);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setSignatureChange() {
        return setSignatureChange();
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setSubstitution(z0 z0Var) {
        return setSubstitution(z0Var);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setTypeParameters(List list) {
        return setTypeParameters((List<d0.e0.p.d.m0.c.z0>) list);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setValueParameters(List list) {
        return setValueParameters((List<c1>) list);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public /* bridge */ /* synthetic */ x$a setVisibility(d0.e0.p.d.m0.c.u uVar) {
        return setVisibility(uVar);
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setAdditionalAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        if (gVar != null) {
            this.r = gVar;
            return this;
        }
        a(32);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setCopyOverrides(boolean z2) {
        this.l = z2;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setDispatchReceiverParameter(q0 q0Var) {
        this.i = q0Var;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setDropOriginalInContainingParts() {
        this.o = true;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setExtensionReceiverParameter(q0 q0Var) {
        this.h = q0Var;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setHiddenForResolutionEverywhereBesideSupercalls() {
        this.f3276s = true;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setHiddenToOvercomeSignatureClash() {
        this.p = true;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setKind(b$a b_a) {
        if (b_a != null) {
            this.f = b_a;
            return this;
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setModality(d0.e0.p.d.m0.c.z zVar) {
        if (zVar != null) {
            this.c = zVar;
            return this;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setName(d0.e0.p.d.m0.g.e eVar) {
        if (eVar != null) {
            this.k = eVar;
            return this;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setOriginal(d0.e0.p.d.m0.c.b bVar) {
        this.e = (d0.e0.p.d.m0.c.x) bVar;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setOwner(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            this.f3275b = mVar;
            return this;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setPreserveSourceElement() {
        this.n = true;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setReturnType(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var != null) {
            this.j = c0Var;
            return this;
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setSignatureChange() {
        this.m = true;
        return this;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setSubstitution(z0 z0Var) {
        if (z0Var != null) {
            this.a = z0Var;
            return this;
        }
        a(34);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setTypeParameters(List<d0.e0.p.d.m0.c.z0> list) {
        if (list != null) {
            this.q = list;
            return this;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setValueParameters(List<c1> list) {
        if (list != null) {
            this.g = list;
            return this;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.x$a
    public q$c setVisibility(d0.e0.p.d.m0.c.u uVar) {
        if (uVar != null) {
            this.d = uVar;
            return this;
        }
        a(11);
        throw null;
    }
}
