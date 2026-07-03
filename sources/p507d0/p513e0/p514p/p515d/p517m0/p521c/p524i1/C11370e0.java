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
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.e0 */
/* JADX INFO: compiled from: PropertySetterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11370e0 extends AbstractC11364b0 implements InterfaceC11457p0 {

    /* JADX INFO: renamed from: v */
    public InterfaceC11326c1 f22855v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC11457p0 f22856w;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public C11370e0(InterfaceC11453n0 interfaceC11453n0, InterfaceC11344g interfaceC11344g, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, boolean z2, boolean z3, boolean z4, InterfaceC11321b.a aVar, InterfaceC11457p0 interfaceC11457p0, InterfaceC11467u0 interfaceC11467u0) {
        InterfaceC11457p0 interfaceC11457p1;
        C11370e0 c11370e0;
        if (interfaceC11453n0 == null) {
            m9397a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9397a(1);
            throw null;
        }
        if (enumC11476z == null) {
            m9397a(2);
            throw null;
        }
        if (abstractC11466u == null) {
            m9397a(3);
            throw null;
        }
        if (aVar == null) {
            m9397a(4);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9397a(5);
            throw null;
        }
        StringBuilder sbM833U = C1643a.m833U("<set-");
        sbM833U.append(interfaceC11453n0.getName());
        sbM833U.append(">");
        super(enumC11476z, abstractC11466u, interfaceC11453n0, interfaceC11344g, C11716e.special(sbM833U.toString()), z2, z3, z4, aVar, interfaceC11467u0);
        if (interfaceC11457p0 != null) {
            c11370e0 = this;
            interfaceC11457p1 = interfaceC11457p0;
        } else {
            interfaceC11457p1 = this;
            c11370e0 = interfaceC11457p1;
        }
        c11370e0.f22856w = interfaceC11457p1;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9397a(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static C11384l0 createSetterParameter(InterfaceC11457p0 interfaceC11457p0, AbstractC11913c0 abstractC11913c0, InterfaceC11344g interfaceC11344g) {
        if (interfaceC11457p0 == null) {
            m9397a(7);
            throw null;
        }
        if (abstractC11913c0 == null) {
            m9397a(8);
            throw null;
        }
        if (interfaceC11344g != null) {
            return new C11384l0(interfaceC11457p0, null, 0, interfaceC11344g, C11716e.special("<set-?>"), abstractC11913c0, false, false, false, null, InterfaceC11467u0.f23099a);
        }
        m9397a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        return interfaceC11454o.visitPropertySetterDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public Collection<? extends InterfaceC11457p0> getOverriddenDescriptors() {
        return m9390b(false);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public AbstractC11913c0 getReturnType() {
        AbstractC11934j0 unitType = C11836a.getBuiltIns(this).getUnitType();
        if (unitType != null) {
            return unitType;
        }
        m9397a(12);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public List<InterfaceC11326c1> getValueParameters() {
        InterfaceC11326c1 interfaceC11326c1 = this.f22855v;
        if (interfaceC11326c1 == null) {
            throw new IllegalStateException();
        }
        List<InterfaceC11326c1> listSingletonList = Collections.singletonList(interfaceC11326c1);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        m9397a(11);
        throw null;
    }

    public void initialize(InterfaceC11326c1 interfaceC11326c1) {
        if (interfaceC11326c1 != null) {
            this.f22855v = interfaceC11326c1;
        } else {
            m9397a(6);
            throw null;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11364b0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11457p0 getOriginal() {
        InterfaceC11457p0 interfaceC11457p0 = this.f22856w;
        if (interfaceC11457p0 != null) {
            return interfaceC11457p0;
        }
        m9397a(13);
        throw null;
    }
}
