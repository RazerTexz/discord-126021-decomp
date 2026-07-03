package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.g0 */
/* JADX INFO: compiled from: SimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11374g0 extends AbstractC11391q implements InterfaceC11465t0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11374g0(InterfaceC11450m interfaceC11450m, InterfaceC11465t0 interfaceC11465t0, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, interfaceC11467u0);
        if (interfaceC11450m == null) {
            m9409a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9409a(1);
            throw null;
        }
        if (c11716e == null) {
            m9409a(2);
            throw null;
        }
        if (aVar == null) {
            m9409a(3);
            throw null;
        }
        if (interfaceC11467u0 != null) {
        } else {
            m9409a(4);
            throw null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9409a(int i) {
        String str = (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 17) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "getOriginal";
        } else if (i == 23) {
            objArr[1] = "copy";
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 17 && i != 18 && i != 23 && i != 24) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11374g0 create(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9409a(5);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9409a(6);
            throw null;
        }
        if (c11716e == null) {
            m9409a(7);
            throw null;
        }
        if (aVar == null) {
            m9409a(8);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11374g0(interfaceC11450m, null, interfaceC11344g, c11716e, aVar, interfaceC11467u0);
        }
        m9409a(9);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9409a(19);
            throw null;
        }
        if (aVar == null) {
            m9409a(20);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9409a(21);
            throw null;
        }
        InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) interfaceC11472x;
        if (c11716e == null) {
            c11716e = getName();
        }
        return new C11374g0(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public /* bridge */ /* synthetic */ AbstractC11391q initialize(InterfaceC11459q0 interfaceC11459q0, InterfaceC11459q0 interfaceC11459q1, List list, List list2, AbstractC11913c0 abstractC11913c0, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u) {
        return initialize(interfaceC11459q0, interfaceC11459q1, (List<? extends InterfaceC11477z0>) list, (List<InterfaceC11326c1>) list2, abstractC11913c0, enumC11476z, abstractC11466u);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0
    public InterfaceC11472x.a<? extends InterfaceC11465t0> newCopyBuilder() {
        InterfaceC11472x.a aVarNewCopyBuilder = super.newCopyBuilder();
        if (aVarNewCopyBuilder != null) {
            return aVarNewCopyBuilder;
        }
        m9409a(24);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public C11374g0 initialize(InterfaceC11459q0 interfaceC11459q0, InterfaceC11459q0 interfaceC11459q1, List<? extends InterfaceC11477z0> list, List<InterfaceC11326c1> list2, AbstractC11913c0 abstractC11913c0, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u) {
        if (list == null) {
            m9409a(10);
            throw null;
        }
        if (list2 == null) {
            m9409a(11);
            throw null;
        }
        if (abstractC11466u == null) {
            m9409a(12);
            throw null;
        }
        C11374g0 c11374g0Initialize = initialize(interfaceC11459q0, interfaceC11459q1, list, list2, abstractC11913c0, enumC11476z, abstractC11466u, null);
        if (c11374g0Initialize != null) {
            return c11374g0Initialize;
        }
        m9409a(13);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11465t0 copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11321b.a aVar, boolean z2) {
        InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) super.copy(interfaceC11450m, enumC11476z, abstractC11466u, aVar, z2);
        if (interfaceC11465t0 != null) {
            return interfaceC11465t0;
        }
        m9409a(23);
        throw null;
    }

    public C11374g0 initialize(InterfaceC11459q0 interfaceC11459q0, InterfaceC11459q0 interfaceC11459q1, List<? extends InterfaceC11477z0> list, List<InterfaceC11326c1> list2, AbstractC11913c0 abstractC11913c0, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, Map<? extends InterfaceC11318a.a<?>, ?> map) {
        if (list == null) {
            m9409a(14);
            throw null;
        }
        if (list2 == null) {
            m9409a(15);
            throw null;
        }
        if (abstractC11466u != null) {
            super.initialize(interfaceC11459q0, interfaceC11459q1, list, list2, abstractC11913c0, enumC11476z, abstractC11466u);
            if (map != null && !map.isEmpty()) {
                this.f22933L = new LinkedHashMap(map);
            }
            return this;
        }
        m9409a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11465t0 getOriginal() {
        InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) super.getOriginal();
        if (interfaceC11465t0 != null) {
            return interfaceC11465t0;
        }
        m9409a(18);
        throw null;
    }
}
