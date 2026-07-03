package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.k0 */
/* JADX INFO: compiled from: TypeParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11382k0 extends AbstractC11371f {

    /* JADX INFO: renamed from: t */
    public final Function1<AbstractC11913c0, Void> f22893t;

    /* JADX INFO: renamed from: u */
    public final List<AbstractC11913c0> f22894u;

    /* JADX INFO: renamed from: v */
    public boolean f22895v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11382k0(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, boolean z2, EnumC11935j1 enumC11935j1, C11716e c11716e, int i, InterfaceC11467u0 interfaceC11467u0, Function1<AbstractC11913c0, Void> function1, InterfaceC11473x0 interfaceC11473x0, InterfaceC11905o interfaceC11905o) {
        super(interfaceC11905o, interfaceC11450m, interfaceC11344g, c11716e, enumC11935j1, z2, i, interfaceC11467u0, interfaceC11473x0);
        if (interfaceC11450m == null) {
            m9413a(19);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9413a(20);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9413a(21);
            throw null;
        }
        if (c11716e == null) {
            m9413a(22);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9413a(23);
            throw null;
        }
        if (interfaceC11473x0 == null) {
            m9413a(24);
            throw null;
        }
        if (interfaceC11905o == null) {
            m9413a(25);
            throw null;
        }
        this.f22894u = new ArrayList(1);
        this.f22895v = false;
        this.f22893t = function1;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9413a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11382k0 createForFurtherModification(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, boolean z2, EnumC11935j1 enumC11935j1, C11716e c11716e, int i, InterfaceC11467u0 interfaceC11467u0, InterfaceC11905o interfaceC11905o) {
        if (interfaceC11450m == null) {
            m9413a(6);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9413a(7);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9413a(8);
            throw null;
        }
        if (c11716e == null) {
            m9413a(9);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9413a(10);
            throw null;
        }
        if (interfaceC11905o != null) {
            return createForFurtherModification(interfaceC11450m, interfaceC11344g, z2, enumC11935j1, c11716e, i, interfaceC11467u0, null, InterfaceC11473x0.a.f23103a, interfaceC11905o);
        }
        m9413a(11);
        throw null;
    }

    public static InterfaceC11477z0 createWithDefaultBound(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, boolean z2, EnumC11935j1 enumC11935j1, C11716e c11716e, int i, InterfaceC11905o interfaceC11905o) {
        if (interfaceC11450m == null) {
            m9413a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9413a(1);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9413a(2);
            throw null;
        }
        if (c11716e == null) {
            m9413a(3);
            throw null;
        }
        if (interfaceC11905o == null) {
            m9413a(4);
            throw null;
        }
        C11382k0 c11382k0CreateForFurtherModification = createForFurtherModification(interfaceC11450m, interfaceC11344g, z2, enumC11935j1, c11716e, i, InterfaceC11467u0.f23099a, interfaceC11905o);
        c11382k0CreateForFurtherModification.addUpperBound(C11836a.getBuiltIns(interfaceC11450m).getDefaultBound());
        c11382k0CreateForFurtherModification.setInitialized();
        return c11382k0CreateForFurtherModification;
    }

    public void addUpperBound(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m9413a(26);
            throw null;
        }
        m9414e();
        if (C11919e0.isError(abstractC11913c0)) {
            return;
        }
        this.f22894u.add(abstractC11913c0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: c */
    public void mo9400c(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            m9413a(27);
            throw null;
        }
        Function1<AbstractC11913c0, Void> function1 = this.f22893t;
        if (function1 == null) {
            return;
        }
        function1.invoke(abstractC11913c0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11371f
    /* JADX INFO: renamed from: d */
    public List<AbstractC11913c0> mo9401d() {
        if (!this.f22895v) {
            StringBuilder sbM833U = C1643a.m833U("Type parameter descriptor is not initialized: ");
            sbM833U.append(m9415f());
            throw new IllegalStateException(sbM833U.toString());
        }
        List<AbstractC11913c0> list = this.f22894u;
        if (list != null) {
            return list;
        }
        m9413a(28);
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public final void m9414e() {
        if (this.f22895v) {
            StringBuilder sbM833U = C1643a.m833U("Type parameter descriptor is already initialized: ");
            sbM833U.append(m9415f());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: f */
    public final String m9415f() {
        return getName() + " declared in " + C11787e.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        m9414e();
        this.f22895v = true;
    }

    public static C11382k0 createForFurtherModification(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, boolean z2, EnumC11935j1 enumC11935j1, C11716e c11716e, int i, InterfaceC11467u0 interfaceC11467u0, Function1<AbstractC11913c0, Void> function1, InterfaceC11473x0 interfaceC11473x0, InterfaceC11905o interfaceC11905o) {
        if (interfaceC11450m == null) {
            m9413a(12);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9413a(13);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9413a(14);
            throw null;
        }
        if (c11716e == null) {
            m9413a(15);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9413a(16);
            throw null;
        }
        if (interfaceC11473x0 == null) {
            m9413a(17);
            throw null;
        }
        if (interfaceC11905o != null) {
            return new C11382k0(interfaceC11450m, interfaceC11344g, z2, enumC11935j1, c11716e, i, interfaceC11467u0, function1, interfaceC11473x0, interfaceC11905o);
        }
        m9413a(18);
        throw null;
    }
}
