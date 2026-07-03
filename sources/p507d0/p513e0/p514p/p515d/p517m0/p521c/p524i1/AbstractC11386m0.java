package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.m0 */
/* JADX INFO: compiled from: VariableDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11386m0 extends AbstractC11383l implements InterfaceC11329d1 {

    /* JADX INFO: renamed from: n */
    public AbstractC11913c0 f22906n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11386m0(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11913c0 abstractC11913c0, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11450m, interfaceC11344g, c11716e, interfaceC11467u0);
        if (interfaceC11450m == null) {
            m9417a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9417a(1);
            throw null;
        }
        if (c11716e == null) {
            m9417a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9417a(3);
            throw null;
        }
        this.f22906n = abstractC11913c0;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9417a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public InterfaceC11459q0 getDispatchReceiverParameter() {
        return null;
    }

    public InterfaceC11459q0 getExtensionReceiverParameter() {
        return null;
    }

    public AbstractC11913c0 getReturnType() {
        AbstractC11913c0 type = getType();
        if (type != null) {
            return type;
        }
        m9417a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11323b1
    public AbstractC11913c0 getType() {
        AbstractC11913c0 abstractC11913c0 = this.f22906n;
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        m9417a(4);
        throw null;
    }

    public List<InterfaceC11477z0> getTypeParameters() {
        List<InterfaceC11477z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9417a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11326c1> getValueParameters() {
        List<InterfaceC11326c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9417a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public void setOutType(AbstractC11913c0 abstractC11913c0) {
        this.f22906n = abstractC11913c0;
    }
}
