package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11791i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11793k;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.a */
/* JADX INFO: compiled from: DescriptorResolverUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11498a {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.a$a */
    /* JADX INFO: compiled from: DescriptorResolverUtils.java */
    public static class a extends AbstractC11791i {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC11880p f23219a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Set f23220b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ boolean f23221c;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DescriptorResolverUtils.java */
        public class C13310a implements Function1<InterfaceC11321b, Unit> {
            public C13310a() {
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(InterfaceC11321b interfaceC11321b) {
                if (interfaceC11321b == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                }
                a.this.f23219a.reportCannotInferVisibility(interfaceC11321b);
                return Unit.f27425a;
            }
        }

        public a(InterfaceC11880p interfaceC11880p, Set set, boolean z2) {
            this.f23219a = interfaceC11880p;
            this.f23220b = set;
            this.f23221c = z2;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9452a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "fromSuper";
            } else if (i == 2) {
                objArr[0] = "fromCurrent";
            } else if (i == 3) {
                objArr[0] = "member";
            } else if (i != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i == 1 || i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11792j
        public void addFakeOverride(InterfaceC11321b interfaceC11321b) {
            if (interfaceC11321b == null) {
                m9452a(0);
                throw null;
            }
            C11793k.resolveUnknownVisibilityForMember(interfaceC11321b, new C13310a());
            this.f23220b.add(interfaceC11321b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11791i
        public void conflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2) {
            if (interfaceC11321b == null) {
                m9452a(1);
                throw null;
            }
            if (interfaceC11321b2 != null) {
                return;
            }
            m9452a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11792j
        public void setOverriddenDescriptors(InterfaceC11321b interfaceC11321b, Collection<? extends InterfaceC11321b> collection) {
            if (interfaceC11321b == null) {
                m9452a(3);
                throw null;
            }
            if (collection == null) {
                m9452a(4);
                throw null;
            }
            if (!this.f23221c || interfaceC11321b.getKind() == InterfaceC11321b.a.FAKE_OVERRIDE) {
                super.setOverriddenDescriptors(interfaceC11321b, collection);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9450a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(str2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static <D extends InterfaceC11321b> Collection<D> m9451b(C11716e c11716e, Collection<D> collection, Collection<D> collection2, InterfaceC11330e interfaceC11330e, InterfaceC11880p interfaceC11880p, C11793k c11793k, boolean z2) {
        if (c11716e == null) {
            m9450a(12);
            throw null;
        }
        if (collection == null) {
            m9450a(13);
            throw null;
        }
        if (collection2 == null) {
            m9450a(14);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9450a(15);
            throw null;
        }
        if (interfaceC11880p == null) {
            m9450a(16);
            throw null;
        }
        if (c11793k == null) {
            m9450a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c11793k.generateOverridesInFunctionGroup(c11716e, collection, collection2, interfaceC11330e, new a(interfaceC11880p, linkedHashSet, z2));
        return linkedHashSet;
    }

    public static InterfaceC11326c1 getAnnotationParameterByName(C11716e c11716e, InterfaceC11330e interfaceC11330e) {
        if (c11716e == null) {
            m9450a(19);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9450a(20);
            throw null;
        }
        Collection<InterfaceC11327d> constructors = interfaceC11330e.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (InterfaceC11326c1 interfaceC11326c1 : constructors.iterator().next().getValueParameters()) {
            if (interfaceC11326c1.getName().equals(c11716e)) {
                return interfaceC11326c1;
            }
        }
        return null;
    }

    public static <D extends InterfaceC11321b> Collection<D> resolveOverridesForNonStaticMembers(C11716e c11716e, Collection<D> collection, Collection<D> collection2, InterfaceC11330e interfaceC11330e, InterfaceC11880p interfaceC11880p, C11793k c11793k) {
        if (c11716e == null) {
            m9450a(0);
            throw null;
        }
        if (collection == null) {
            m9450a(1);
            throw null;
        }
        if (collection2 == null) {
            m9450a(2);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9450a(3);
            throw null;
        }
        if (interfaceC11880p == null) {
            m9450a(4);
            throw null;
        }
        if (c11793k != null) {
            return m9451b(c11716e, collection, collection2, interfaceC11330e, interfaceC11880p, c11793k, false);
        }
        m9450a(5);
        throw null;
    }

    public static <D extends InterfaceC11321b> Collection<D> resolveOverridesForStaticMembers(C11716e c11716e, Collection<D> collection, Collection<D> collection2, InterfaceC11330e interfaceC11330e, InterfaceC11880p interfaceC11880p, C11793k c11793k) {
        if (c11716e == null) {
            m9450a(6);
            throw null;
        }
        if (collection == null) {
            m9450a(7);
            throw null;
        }
        if (collection2 == null) {
            m9450a(8);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9450a(9);
            throw null;
        }
        if (interfaceC11880p == null) {
            m9450a(10);
            throw null;
        }
        if (c11793k != null) {
            return m9451b(c11716e, collection, collection2, interfaceC11330e, interfaceC11880p, c11793k, true);
        }
        m9450a(11);
        throw null;
    }
}
