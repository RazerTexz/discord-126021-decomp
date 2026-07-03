package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11452n;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.l */
/* JADX INFO: compiled from: DeclarationDescriptorNonRootImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11383l extends AbstractC11381k implements InterfaceC11452n {

    /* JADX INFO: renamed from: l */
    public final InterfaceC11450m f22896l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC11467u0 f22897m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11383l(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11344g, c11716e);
        if (interfaceC11450m == null) {
            m9416a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9416a(1);
            throw null;
        }
        if (c11716e == null) {
            m9416a(2);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9416a(3);
            throw null;
        }
        this.f22896l = interfaceC11450m;
        this.f22897m = interfaceC11467u0;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9416a(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public InterfaceC11450m getContainingDeclaration() {
        InterfaceC11450m interfaceC11450m = this.f22896l;
        if (interfaceC11450m != null) {
            return interfaceC11450m;
        }
        m9416a(5);
        throw null;
    }

    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = this.f22897m;
        if (interfaceC11467u0 != null) {
            return interfaceC11467u0;
        }
        m9416a(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11456p getOriginal() {
        InterfaceC11456p interfaceC11456p = (InterfaceC11456p) super.getOriginal();
        if (interfaceC11456p != null) {
            return interfaceC11456p;
        }
        m9416a(4);
        throw null;
    }
}
