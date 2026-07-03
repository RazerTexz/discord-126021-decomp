package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.b */
/* JADX INFO: compiled from: AbstractLazyTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11363b extends AbstractC11371f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11363b(InterfaceC11905o interfaceC11905o, InterfaceC11450m interfaceC11450m, C11716e c11716e, EnumC11935j1 enumC11935j1, boolean z2, int i, InterfaceC11467u0 interfaceC11467u0, InterfaceC11473x0 interfaceC11473x0) {
        super(interfaceC11905o, interfaceC11450m, InterfaceC11344g.f22735f.getEMPTY(), c11716e, enumC11935j1, z2, i, interfaceC11467u0, interfaceC11473x0);
        if (interfaceC11905o == null) {
            m9388a(0);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9388a(1);
            throw null;
        }
        if (c11716e == null) {
            m9388a(2);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9388a(3);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9388a(4);
            throw null;
        }
        if (interfaceC11473x0 != null) {
        } else {
            m9388a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9388a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "variance";
        } else if (i == 4) {
            objArr[0] = "source";
        } else if (i != 5) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "supertypeLoopChecker";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = isReified() ? "reified " : "";
        if (getVariance() != EnumC11935j1.INVARIANT) {
            str = getVariance() + " ";
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
