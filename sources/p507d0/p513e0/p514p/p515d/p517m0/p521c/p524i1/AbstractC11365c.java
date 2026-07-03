package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11407k0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.C11783g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.c */
/* JADX INFO: compiled from: AbstractReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11365c extends AbstractC11381k implements InterfaceC11459q0 {

    /* JADX INFO: renamed from: l */
    public static final C11716e f22818l = C11716e.special("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11365c(InterfaceC11344g interfaceC11344g) {
        super(interfaceC11344g, f22818l);
        if (interfaceC11344g != null) {
        } else {
            m9391a(0);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9391a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitReceiverParameterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public InterfaceC11459q0 getDispatchReceiverParameter() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public InterfaceC11459q0 getExtensionReceiverParameter() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11407k0 getOriginal() {
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public Collection<? extends InterfaceC11318a> getOverriddenDescriptors() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        m9391a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public AbstractC11913c0 getReturnType() {
        return getType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        return InterfaceC11467u0.f23099a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11323b1
    public AbstractC11913c0 getType() {
        AbstractC11913c0 type = getValue().getType();
        if (type != null) {
            return type;
        }
        m9391a(3);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11477z0> getTypeParameters() {
        List<InterfaceC11477z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9391a(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11326c1> getValueParameters() {
        List<InterfaceC11326c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9391a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public AbstractC11466u getVisibility() {
        AbstractC11466u abstractC11466u = C11464t.f23088f;
        if (abstractC11466u != null) {
            return abstractC11466u;
        }
        m9391a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11459q0 substitute(C11914c1 c11914c1) {
        if (c11914c1 == null) {
            m9391a(1);
            throw null;
        }
        if (c11914c1.isEmpty()) {
            return this;
        }
        AbstractC11913c0 abstractC11913c0Substitute = getContainingDeclaration() instanceof InterfaceC11330e ? c11914c1.substitute(getType(), EnumC11935j1.OUT_VARIANCE) : c11914c1.substitute(getType(), EnumC11935j1.INVARIANT);
        if (abstractC11913c0Substitute == null) {
            return null;
        }
        return abstractC11913c0Substitute == getType() ? this : new C11372f0(getContainingDeclaration(), new C11783g(abstractC11913c0Substitute), getAnnotations());
    }
}
