package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.w0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PropertyAccessorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends l implements d0.e0.p.d.m0.c.m0 {
    public boolean n;
    public final boolean o;
    public final d0.e0.p.d.m0.c.z p;
    public final d0.e0.p.d.m0.c.n0 q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b$a f3258s;
    public d0.e0.p.d.m0.c.u t;
    public d0.e0.p.d.m0.c.x u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, d0.e0.p.d.m0.c.n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, boolean z2, boolean z3, boolean z4, b$a b_a, u0 u0Var) {
        super(n0Var.getContainingDeclaration(), gVar, eVar, u0Var);
        if (zVar == null) {
            a(0);
            throw null;
        }
        if (uVar == null) {
            a(1);
            throw null;
        }
        if (n0Var == null) {
            a(2);
            throw null;
        }
        if (gVar == null) {
            a(3);
            throw null;
        }
        if (eVar == null) {
            a(4);
            throw null;
        }
        if (u0Var == null) {
            a(5);
            throw null;
        }
        this.u = null;
        this.p = zVar;
        this.t = uVar;
        this.q = n0Var;
        this.n = z2;
        this.o = z3;
        this.r = z4;
        this.f3258s = b_a;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public Collection<d0.e0.p.d.m0.c.m0> b(boolean z2) {
        ArrayList arrayList = new ArrayList(0);
        for (d0.e0.p.d.m0.c.n0 n0Var : getCorrespondingProperty().getOverriddenDescriptors()) {
            w0 getter = z2 ? n0Var.getGetter() : n0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        return copy(mVar, zVar, uVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.m0
    public d0.e0.p.d.m0.c.n0 getCorrespondingProperty() {
        d0.e0.p.d.m0.c.n0 n0Var = this.q;
        if (n0Var != null) {
            return n0Var;
        }
        a(12);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // d0.e0.p.d.m0.c.x
    public d0.e0.p.d.m0.c.x getInitialSignatureDescriptor() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.b
    public b$a getKind() {
        b$a b_a = this.f3258s;
        if (b_a != null) {
            return b_a;
        }
        a(6);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z zVar = this.p;
        if (zVar != null) {
            return zVar;
        }
        a(9);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public abstract d0.e0.p.d.m0.c.m0 getOriginal();

    @Override // d0.e0.p.d.m0.c.a
    public List<z0> getTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public <V> V getUserData(d0.e0.p.d.m0.c.a$a<V> a_a) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = this.t;
        if (uVar != null) {
            return uVar;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.m0
    public boolean isDefault() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isInfix() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isInline() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isOperator() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isTailrec() {
        return false;
    }

    public void setDefault(boolean z2) {
        this.n = z2;
    }

    public void setInitialSignatureDescriptor(d0.e0.p.d.m0.c.x xVar) {
        this.u = xVar;
    }

    @Override // d0.e0.p.d.m0.c.b
    public void setOverriddenDescriptors(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        if (collection != null) {
            return;
        }
        a(14);
        throw null;
    }

    public void setVisibility(d0.e0.p.d.m0.c.u uVar) {
        this.t = uVar;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.b
    public d0.e0.p.d.m0.c.m0 copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b$a b_a, boolean z2) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.x substitute(c1 c1Var) {
        if (c1Var != null) {
            throw new UnsupportedOperationException();
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.x getOriginal() {
        return getOriginal();
    }
}
