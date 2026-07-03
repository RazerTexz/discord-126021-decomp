package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.d0 */
/* JADX INFO: compiled from: PropertyGetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11368d0 extends AbstractC11364b0 implements InterfaceC11455o0 {

    /* JADX INFO: renamed from: v */
    public AbstractC11913c0 f22849v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC11455o0 f22850w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public C11368d0(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, boolean z2, boolean z3, boolean z4, InterfaceC11321b.a aVar, InterfaceC11455o0 interfaceC11455o0, InterfaceC11467u0 interfaceC11467u0) {
        InterfaceC11455o0 interfaceC11455o1;
        C11368d0 c11368d0;
        if (interfaceC11453n0 == null) {
            m9396a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9396a(1);
            throw null;
        }
        if (enumC11476z == null) {
            m9396a(2);
            throw null;
        }
        if (abstractC11466u == null) {
            m9396a(3);
            throw null;
        }
        if (aVar == null) {
            m9396a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9396a(5);
            throw null;
        }
        StringBuilder sbM833U = C1643a.m833U("<get-");
        sbM833U.append(interfaceC11453n0.getName());
        sbM833U.append(">");
        super(enumC11476z, abstractC11466u, interfaceC11453n0, interfaceC11344g, C11716e.special(sbM833U.toString()), z2, z3, z4, aVar, interfaceC11467u0);
        if (interfaceC11455o0 != null) {
            c11368d0 = this;
            interfaceC11455o1 = interfaceC11455o0;
        } else {
            interfaceC11455o1 = this;
            c11368d0 = interfaceC11455o1;
        }
        c11368d0.f22850w = interfaceC11455o1;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9396a(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitPropertyGetterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public Collection<? extends InterfaceC11455o0> getOverriddenDescriptors() {
        return m9390b(true);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public AbstractC11913c0 getReturnType() {
        return this.f22849v;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11326c1> getValueParameters() {
        List<InterfaceC11326c1> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9396a(7);
        throw null;
    }

    public void initialize(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 == null) {
            abstractC11913c0 = getCorrespondingProperty().getType();
        }
        this.f22849v = abstractC11913c0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11364b0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11455o0 getOriginal() {
        InterfaceC11455o0 interfaceC11455o0 = this.f22850w;
        if (interfaceC11455o0 != null) {
            return interfaceC11455o0;
        }
        m9396a(8);
        throw null;
    }
}
