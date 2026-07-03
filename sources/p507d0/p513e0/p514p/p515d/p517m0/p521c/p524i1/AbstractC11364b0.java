package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.b0 */
/* JADX INFO: compiled from: PropertyAccessorDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11364b0 extends AbstractC11383l implements InterfaceC11451m0 {

    /* JADX INFO: renamed from: n */
    public boolean f22810n;

    /* JADX INFO: renamed from: o */
    public final boolean f22811o;

    /* JADX INFO: renamed from: p */
    public final EnumC11476z f22812p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11453n0 f22813q;

    /* JADX INFO: renamed from: r */
    public final boolean f22814r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC11321b.a f22815s;

    /* JADX INFO: renamed from: t */
    public AbstractC11466u f22816t;

    /* JADX INFO: renamed from: u */
    public InterfaceC11472x f22817u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11364b0(EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, C11716e c11716e, boolean z2, boolean z3, boolean z4, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11453n0.getContainingDeclaration(), interfaceC11344g, c11716e, interfaceC11467u0);
        if (enumC11476z == null) {
            m9389a(0);
            throw null;
        }
        if (abstractC11466u == null) {
            m9389a(1);
            throw null;
        }
        if (interfaceC11453n0 == null) {
            m9389a(2);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9389a(3);
            throw null;
        }
        if (c11716e == null) {
            m9389a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9389a(5);
            throw null;
        }
        this.f22817u = null;
        this.f22812p = enumC11476z;
        this.f22816t = abstractC11466u;
        this.f22813q = interfaceC11453n0;
        this.f22810n = z2;
        this.f22811o = z3;
        this.f22814r = z4;
        this.f22815s = aVar;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9389a(int i) {
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

    /* JADX INFO: renamed from: b */
    public Collection<InterfaceC11451m0> m9390b(boolean z2) {
        ArrayList arrayList = new ArrayList(0);
        for (InterfaceC11453n0 interfaceC11453n0 : getCorrespondingProperty().getOverriddenDescriptors()) {
            InterfaceC11471w0 getter = z2 ? interfaceC11453n0.getGetter() : interfaceC11453n0.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0
    public InterfaceC11453n0 getCorrespondingProperty() {
        InterfaceC11453n0 interfaceC11453n0 = this.f22813q;
        if (interfaceC11453n0 != null) {
            return interfaceC11453n0;
        }
        m9389a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public InterfaceC11459q0 getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public InterfaceC11459q0 getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public InterfaceC11472x getInitialSignatureDescriptor() {
        return this.f22817u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11321b.a getKind() {
        InterfaceC11321b.a aVar = this.f22815s;
        if (aVar != null) {
            return aVar;
        }
        m9389a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public EnumC11476z getModality() {
        EnumC11476z enumC11476z = this.f22812p;
        if (enumC11476z != null) {
            return enumC11476z;
        }
        m9389a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public abstract InterfaceC11451m0 getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11477z0> getTypeParameters() {
        List<InterfaceC11477z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9389a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public <V> V getUserData(InterfaceC11318a.a<V> aVar) {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = this.f22816t;
        if (abstractC11466u != null) {
            return abstractC11466u;
        }
        m9389a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0
    public boolean isDefault() {
        return this.f22810n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return this.f22811o;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isInfix() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isInline() {
        return this.f22814r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isOperator() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isSuspend() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isTailrec() {
        return false;
    }

    public void setDefault(boolean z2) {
        this.f22810n = z2;
    }

    public void setInitialSignatureDescriptor(InterfaceC11472x interfaceC11472x) {
        this.f22817u = interfaceC11472x;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public void setOverriddenDescriptors(Collection<? extends InterfaceC11321b> collection) {
        if (collection != null) {
            return;
        }
        m9389a(14);
        throw null;
    }

    public void setVisibility(AbstractC11466u abstractC11466u) {
        this.f22816t = abstractC11466u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11451m0 copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11321b.a aVar, boolean z2) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11472x substitute(C11914c1 c11914c1) {
        if (c11914c1 != null) {
            throw new UnsupportedOperationException();
        }
        m9389a(7);
        throw null;
    }
}
