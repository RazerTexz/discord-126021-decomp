package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
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
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.C12027i;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f */
/* JADX INFO: compiled from: JavaMethodDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11515f extends C11374g0 implements InterfaceC11511b {

    /* JADX INFO: renamed from: M */
    public static final InterfaceC11318a.a<InterfaceC11326c1> f23262M = new a();

    /* JADX INFO: renamed from: N */
    public b f23263N;

    /* JADX INFO: renamed from: O */
    public final boolean f23264O;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f$a */
    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    public static class a implements InterfaceC11318a.a<InterfaceC11326c1> {
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.f$b */
    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    public enum b {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        b(boolean z2, boolean z3) {
            this.isStable = z2;
            this.isSynthesized = z3;
        }

        public static b get(boolean z2, boolean z3) {
            if (z2) {
                return z3 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            }
            return z3 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11515f(InterfaceC11450m interfaceC11450m, InterfaceC11465t0 interfaceC11465t0, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0, boolean z2) {
        super(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, interfaceC11467u0);
        if (interfaceC11450m == null) {
            m9458a(0);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9458a(1);
            throw null;
        }
        if (c11716e == null) {
            m9458a(2);
            throw null;
        }
        if (aVar == null) {
            m9458a(3);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9458a(4);
            throw null;
        }
        this.f23263N = null;
        this.f23264O = z2;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9458a(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C11515f createJavaMethod(InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, InterfaceC11467u0 interfaceC11467u0, boolean z2) {
        if (interfaceC11450m == null) {
            m9458a(5);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9458a(6);
            throw null;
        }
        if (c11716e == null) {
            m9458a(7);
            throw null;
        }
        if (interfaceC11467u0 != null) {
            return new C11515f(interfaceC11450m, null, interfaceC11344g, c11716e, InterfaceC11321b.a.DECLARATION, interfaceC11467u0, z2);
        }
        m9458a(8);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        if (interfaceC11450m == null) {
            m9458a(13);
            throw null;
        }
        if (aVar == null) {
            m9458a(14);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9458a(15);
            throw null;
        }
        InterfaceC11465t0 interfaceC11465t0 = (InterfaceC11465t0) interfaceC11472x;
        if (c11716e == null) {
            c11716e = getName();
        }
        C11515f c11515f = new C11515f(interfaceC11450m, interfaceC11465t0, interfaceC11344g, c11716e, aVar, interfaceC11467u0, this.f23264O);
        c11515f.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return c11515f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b
    public /* bridge */ /* synthetic */ InterfaceC11511b enhance(AbstractC11913c0 abstractC11913c0, List list, AbstractC11913c0 abstractC11913c1, Pair pair) {
        return enhance(abstractC11913c0, (List<C11521l>) list, abstractC11913c1, (Pair<InterfaceC11318a.a<?>, ?>) pair);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    public boolean hasStableParameterNames() {
        return this.f23263N.isStable;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public boolean hasSynthesizedParameterNames() {
        return this.f23263N.isSynthesized;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0
    public C11374g0 initialize(InterfaceC11459q0 interfaceC11459q0, InterfaceC11459q0 interfaceC11459q1, List<? extends InterfaceC11477z0> list, List<InterfaceC11326c1> list2, AbstractC11913c0 abstractC11913c0, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, Map<? extends InterfaceC11318a.a<?>, ?> map) {
        if (list == null) {
            m9458a(9);
            throw null;
        }
        if (list2 == null) {
            m9458a(10);
            throw null;
        }
        if (abstractC11466u == null) {
            m9458a(11);
            throw null;
        }
        C11374g0 c11374g0Initialize = super.initialize(interfaceC11459q0, interfaceC11459q1, list, list2, abstractC11913c0, enumC11476z, abstractC11466u, map);
        setOperator(C12027i.f24917a.check(c11374g0Initialize).isSuccess());
        if (c11374g0Initialize != null) {
            return c11374g0Initialize;
        }
        m9458a(12);
        throw null;
    }

    public void setParameterNamesStatus(boolean z2, boolean z3) {
        this.f23263N = b.get(z2, z3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b
    public C11515f enhance(AbstractC11913c0 abstractC11913c0, List<C11521l> list, AbstractC11913c0 abstractC11913c1, Pair<InterfaceC11318a.a<?>, ?> pair) {
        if (list == null) {
            m9458a(18);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m9458a(19);
            throw null;
        }
        C11515f c11515f = (C11515f) newCopyBuilder().setValueParameters(C11520k.copyValueParameters(list, getValueParameters(), this)).setReturnType(abstractC11913c1).setExtensionReceiverParameter(abstractC11913c0 == null ? null : C11786d.createExtensionReceiverParameterForCallable(this, abstractC11913c0, InterfaceC11344g.f22735f.getEMPTY())).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (pair != null) {
            c11515f.putInUserDataMap(pair.getFirst(), pair.getSecond());
        }
        if (c11515f != null) {
            return c11515f;
        }
        m9458a(20);
        throw null;
    }
}
