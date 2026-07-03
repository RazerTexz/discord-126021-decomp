package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.h */
/* JADX INFO: compiled from: ClassDescriptorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11375h extends AbstractC11361a {

    /* JADX INFO: renamed from: o */
    public final InterfaceC11450m f22875o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC11467u0 f22876p;

    /* JADX INFO: renamed from: q */
    public final boolean f22877q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11375h(InterfaceC11905o interfaceC11905o, InterfaceC11450m interfaceC11450m, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, boolean z2) {
        super(interfaceC11905o, c11716e);
        if (interfaceC11905o == null) {
            m9410a(0);
            throw null;
        }
        if (interfaceC11450m == null) {
            m9410a(1);
            throw null;
        }
        if (c11716e == null) {
            m9410a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9410a(3);
            throw null;
        }
        this.f22875o = interfaceC11450m;
        this.f22876p = interfaceC11467u0;
        this.f22877q = z2;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9410a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        InterfaceC11450m interfaceC11450m = this.f22875o;
        if (interfaceC11450m != null) {
            return interfaceC11450m;
        }
        m9410a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = this.f22876p;
        if (interfaceC11467u0 != null) {
            return interfaceC11467u0;
        }
        m9410a(5);
        throw null;
    }

    public boolean isExternal() {
        return this.f22877q;
    }
}
