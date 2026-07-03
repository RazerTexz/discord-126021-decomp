package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.i */
/* JADX INFO: compiled from: ClassTypeConstructorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11930i extends AbstractC11909b implements InterfaceC12008u0 {

    /* JADX INFO: renamed from: c */
    public final InterfaceC11330e f24781c;

    /* JADX INFO: renamed from: d */
    public final List<InterfaceC11477z0> f24782d;

    /* JADX INFO: renamed from: e */
    public final Collection<AbstractC11913c0> f24783e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11930i(InterfaceC11330e interfaceC11330e, List<? extends InterfaceC11477z0> list, Collection<AbstractC11913c0> collection, InterfaceC11905o interfaceC11905o) {
        super(interfaceC11905o);
        if (interfaceC11330e == null) {
            m10012g(0);
            throw null;
        }
        if (list == null) {
            m10012g(1);
            throw null;
        }
        if (collection == null) {
            m10012g(2);
            throw null;
        }
        if (interfaceC11905o == null) {
            m10012g(3);
            throw null;
        }
        this.f24781c = interfaceC11330e;
        this.f24782d = Collections.unmodifiableList(new ArrayList(list));
        this.f24783e = Collections.unmodifiableCollection(collection);
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ void m10012g(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
    /* JADX INFO: renamed from: a */
    public Collection<AbstractC11913c0> mo9370a() {
        Collection<AbstractC11913c0> collection = this.f24783e;
        if (collection != null) {
            return collection;
        }
        m10012g(6);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g
    /* JADX INFO: renamed from: d */
    public InterfaceC11473x0 mo9371d() {
        return InterfaceC11473x0.a.f23103a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<InterfaceC11477z0> getParameters() {
        List<InterfaceC11477z0> list = this.f24782d;
        if (list != null) {
            return list;
        }
        m10012g(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return C11787e.getFqName(this.f24781c).asString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11924g, p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC11330e getDeclarationDescriptor() {
        InterfaceC11330e interfaceC11330e = this.f24781c;
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        m10012g(5);
        throw null;
    }
}
