package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11451m0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11364b0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11941a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11953m;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12042j;
import p507d0.p580t.C12163u;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.k */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11793k {

    /* JADX INFO: renamed from: a */
    public static final List<InterfaceC11788f> f24410a = C12163u.toList(ServiceLoader.load(InterfaceC11788f.class, InterfaceC11788f.class.getClassLoader()));

    /* JADX INFO: renamed from: b */
    public static final C11793k f24411b;

    /* JADX INFO: renamed from: c */
    public static final InterfaceC11946f.a f24412c;

    /* JADX INFO: renamed from: d */
    public final AbstractC11947g f24413d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC11946f.a f24414e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$a */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class a implements InterfaceC11946f.a {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9938a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f.a
        public boolean equals(InterfaceC12008u0 interfaceC12008u0, InterfaceC12008u0 interfaceC12008u1) {
            if (interfaceC12008u0 == null) {
                m9938a(0);
                throw null;
            }
            if (interfaceC12008u1 != null) {
                return interfaceC12008u0.equals(interfaceC12008u1);
            }
            m9938a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$b */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class b<D> implements Function2<D, D, Pair<InterfaceC11318a, InterfaceC11318a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Ld0/e0/p/d/m0/c/a;Ld0/e0/p/d/m0/c/a;>; */
        @Override // kotlin.jvm.functions.Function2
        public Pair invoke(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
            return new Pair(interfaceC11318a, interfaceC11318a2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$c */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class c implements Function1<InterfaceC11321b, InterfaceC11318a> {
        @Override // kotlin.jvm.functions.Function1
        public InterfaceC11321b invoke(InterfaceC11321b interfaceC11321b) {
            return interfaceC11321b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class d {

        /* JADX INFO: renamed from: a */
        public static final d f24415a = new d(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: b */
        public final a f24416b;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d$a */
        /* JADX INFO: compiled from: OverridingUtil.java */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public d(a aVar, String str) {
            if (aVar == null) {
                m9939a(3);
                throw null;
            }
            if (str != null) {
                this.f24416b = aVar;
            } else {
                m9939a(4);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9939a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i == 1 || i == 2) {
                objArr[0] = "debugMessage";
            } else if (i == 3) {
                objArr[0] = "success";
            } else if (i != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            } else {
                objArr[0] = "debugMessage";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i == 1) {
                objArr[2] = "incompatible";
            } else if (i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        public static d conflict(String str) {
            if (str != null) {
                return new d(a.CONFLICT, str);
            }
            m9939a(2);
            throw null;
        }

        public static d incompatible(String str) {
            if (str != null) {
                return new d(a.INCOMPATIBLE, str);
            }
            m9939a(1);
            throw null;
        }

        public static d success() {
            d dVar = f24415a;
            if (dVar != null) {
                return dVar;
            }
            m9939a(0);
            throw null;
        }

        public a getResult() {
            a aVar = this.f24416b;
            if (aVar != null) {
                return aVar;
            }
            m9939a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$e */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public class e extends C11941a {

        /* JADX INFO: renamed from: j */
        public final Map<InterfaceC12008u0, InterfaceC12008u0> f24421j;

        public e(Map<InterfaceC12008u0, InterfaceC12008u0> map) {
            super(true, true, true, C11793k.this.f24413d);
            this.f24421j = map;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9940a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1 || i == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i == 2 || i == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Code duplicated, block: B:23:0x003f  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11941a
        public boolean areEqualTypeConstructors(InterfaceC12008u0 interfaceC12008u0, InterfaceC12008u0 interfaceC12008u1) {
            boolean z2;
            if (interfaceC12008u0 == null) {
                m9940a(0);
                throw null;
            }
            if (interfaceC12008u1 == null) {
                m9940a(1);
                throw null;
            }
            if (!super.areEqualTypeConstructors(interfaceC12008u0, interfaceC12008u1)) {
                if (interfaceC12008u0 == null) {
                    m9940a(2);
                    throw null;
                }
                if (interfaceC12008u1 == null) {
                    m9940a(3);
                    throw null;
                }
                if (C11793k.this.f24414e.equals(interfaceC12008u0, interfaceC12008u1)) {
                    z2 = true;
                } else {
                    Map<InterfaceC12008u0, InterfaceC12008u0> map = this.f24421j;
                    if (map != null) {
                        InterfaceC12008u0 interfaceC12008u2 = map.get(interfaceC12008u0);
                        InterfaceC12008u0 interfaceC12008u3 = this.f24421j.get(interfaceC12008u1);
                        if ((interfaceC12008u2 != null && interfaceC12008u2.equals(interfaceC12008u1)) || (interfaceC12008u3 != null && interfaceC12008u3.equals(interfaceC12008u0))) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
            }
            return true;
        }
    }

    static {
        a aVar = new a();
        f24412c = aVar;
        f24411b = new C11793k(aVar, AbstractC11947g.a.f24807a);
    }

    public C11793k(InterfaceC11946f.a aVar, AbstractC11947g abstractC11947g) {
        if (aVar == null) {
            m9930a(4);
            throw null;
        }
        if (abstractC11947g == null) {
            m9930a(5);
            throw null;
        }
        this.f24414e = aVar;
        this.f24413d = abstractC11947g;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:29:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:94:0x0184  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9930a(int i) {
        String str;
        int i2;
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    i2 = 2;
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            i2 = 2;
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 3:
            default:
                objArr[0] = "equalityAxioms";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = "f";
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = "result";
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case 75:
                objArr[0] = "typeChecker";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case 87:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case 85:
            case 104:
                objArr[0] = "strategy";
                break;
            case 55:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case 57:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 61:
            case 63:
                objArr[0] = "notOverridden";
                break;
            case 65:
            case 67:
            case 71:
                objArr[0] = "a";
                break;
            case 66:
            case 68:
            case 73:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case 70:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case 72:
                objArr[0] = "aReturnType";
                break;
            case 74:
                objArr[0] = "bReturnType";
                break;
            case 76:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case 97:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i == 9 || i == 10) {
            objArr[1] = "filterOverrides";
        } else if (i == 14) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i == 19) {
            objArr[1] = "isOverridableBy";
        } else if (i == 93) {
            objArr[1] = "getMinimalModality";
        } else if (i == 96) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    objArr[1] = "isOverridableBy";
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "extractMembersOverridableInBothWays";
        }
        switch (i) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerContext";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 55:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 61:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case 63:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 65:
            case 66:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 76:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case 85:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case 87:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m9931c(InterfaceC11321b interfaceC11321b, Set<InterfaceC11321b> set) {
        if (interfaceC11321b == null) {
            m9930a(15);
            throw null;
        }
        if (set == null) {
            m9930a(16);
            throw null;
        }
        if (interfaceC11321b.getKind().isReal()) {
            set.add(interfaceC11321b);
            return;
        }
        if (interfaceC11321b.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + interfaceC11321b);
        }
        Iterator<? extends InterfaceC11321b> it = interfaceC11321b.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            m9931c(it.next(), set);
        }
    }

    public static C11793k create(AbstractC11947g abstractC11947g, InterfaceC11946f.a aVar) {
        if (abstractC11947g == null) {
            m9930a(2);
            throw null;
        }
        if (aVar != null) {
            return new C11793k(aVar, abstractC11947g);
        }
        m9930a(3);
        throw null;
    }

    public static C11793k createWithTypeRefiner(AbstractC11947g abstractC11947g) {
        if (abstractC11947g != null) {
            return new C11793k(f24412c, abstractC11947g);
        }
        m9930a(1);
        throw null;
    }

    /* JADX INFO: renamed from: d */
    public static List<AbstractC11913c0> m9932d(InterfaceC11318a interfaceC11318a) {
        InterfaceC11459q0 extensionReceiverParameter = interfaceC11318a.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<InterfaceC11326c1> it = interfaceC11318a.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public static void m9933e(Collection<InterfaceC11321b> collection, InterfaceC11330e interfaceC11330e, AbstractC11792j abstractC11792j) {
        EnumC11476z enumC11476z;
        EnumC11476z modality;
        if (collection == null) {
            m9930a(83);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9930a(84);
            throw null;
        }
        if (abstractC11792j == null) {
            m9930a(85);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9930a(94);
            throw null;
        }
        if (collection == null) {
            m9930a(95);
            throw null;
        }
        List listFilter = C12163u.filter(collection, new C11795m(interfaceC11330e));
        if (listFilter == null) {
            m9930a(96);
            throw null;
        }
        boolean zIsEmpty = listFilter.isEmpty();
        Collection<? extends InterfaceC11321b> collection2 = zIsEmpty ? collection : listFilter;
        Iterator<? extends InterfaceC11321b> it = collection2.iterator();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (it.hasNext()) {
                InterfaceC11321b next = it.next();
                int iOrdinal = next.getModality().ordinal();
                if (iOrdinal == 0) {
                    modality = EnumC11476z.FINAL;
                } else {
                    if (iOrdinal == 1) {
                        throw new IllegalStateException("Member cannot have SEALED modality: " + next);
                    }
                    if (iOrdinal == 2) {
                        z3 = true;
                    } else if (iOrdinal == 3) {
                        z4 = true;
                    }
                }
            } else {
                if (interfaceC11330e.isExpect() && interfaceC11330e.getModality() != EnumC11476z.ABSTRACT && interfaceC11330e.getModality() != EnumC11476z.SEALED) {
                    z2 = true;
                }
                if (z3 && !z4) {
                    modality = EnumC11476z.OPEN;
                } else {
                    if (z3 || !z4) {
                        HashSet hashSet = new HashSet();
                        Iterator<? extends InterfaceC11321b> it2 = collection2.iterator();
                        while (it2.hasNext()) {
                            hashSet.addAll(getOverriddenDeclarations(it2.next()));
                        }
                        Set<InterfaceC11321b> setFilterOutOverridden = filterOutOverridden(hashSet);
                        EnumC11476z modality2 = interfaceC11330e.getModality();
                        if (setFilterOutOverridden == null) {
                            m9930a(91);
                            throw null;
                        }
                        if (modality2 == null) {
                            m9930a(92);
                            throw null;
                        }
                        EnumC11476z enumC11476z2 = EnumC11476z.ABSTRACT;
                        for (InterfaceC11321b interfaceC11321b : setFilterOutOverridden) {
                            EnumC11476z modality3 = (z2 && interfaceC11321b.getModality() == EnumC11476z.ABSTRACT) ? modality2 : interfaceC11321b.getModality();
                            if (modality3.compareTo(enumC11476z2) < 0) {
                                enumC11476z2 = modality3;
                            }
                        }
                        if (enumC11476z2 != null) {
                            enumC11476z = enumC11476z2;
                            break;
                        } else {
                            m9930a(93);
                            throw null;
                        }
                    }
                    modality = z2 ? interfaceC11330e.getModality() : EnumC11476z.ABSTRACT;
                    if (modality == null) {
                        m9930a(90);
                        throw null;
                    }
                }
            }
            enumC11476z = modality;
            break;
        }
        InterfaceC11321b interfaceC11321bCopy = ((InterfaceC11321b) selectMostSpecificMember(collection2, new c())).copy(interfaceC11330e, enumC11476z, zIsEmpty ? C11464t.f23090h : C11464t.f23089g, InterfaceC11321b.a.FAKE_OVERRIDE, false);
        abstractC11792j.setOverriddenDescriptors(interfaceC11321bCopy, collection2);
        abstractC11792j.addFakeOverride(interfaceC11321bCopy);
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, InterfaceC11318a> function1, Function1<H, Unit> function2) {
        if (h == null) {
            m9930a(97);
            throw null;
        }
        if (collection == null) {
            m9930a(98);
            throw null;
        }
        if (function1 == null) {
            m9930a(99);
            throw null;
        }
        if (function2 == null) {
            m9930a(100);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        InterfaceC11318a interfaceC11318aInvoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            InterfaceC11318a interfaceC11318aInvoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                d.a bothWaysOverridability = getBothWaysOverridability(interfaceC11318aInvoke, interfaceC11318aInvoke2);
                if (bothWaysOverridability == d.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == d.a.CONFLICT) {
                    function2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static <D extends InterfaceC11318a> Set<D> filterOutOverridden(Set<D> set) {
        if (set != null) {
            return filterOverrides(set, !set.isEmpty() && C11836a.isTypeRefinementEnabled(C11836a.getModule(set.iterator().next())), null, new b());
        }
        m9930a(6);
        throw null;
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z2, Function0<?> function0, Function2<? super D, ? super D, Pair<InterfaceC11318a, InterfaceC11318a>> function2) {
        if (set == null) {
            m9930a(7);
            throw null;
        }
        if (function2 == null) {
            m9930a(8);
            throw null;
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Pair<InterfaceC11318a, InterfaceC11318a> pairInvoke = function2.invoke(obj, (Object) it.next());
                InterfaceC11318a interfaceC11318aComponent1 = pairInvoke.component1();
                InterfaceC11318a interfaceC11318aComponent2 = pairInvoke.component2();
                if (!overrides(interfaceC11318aComponent1, interfaceC11318aComponent2, z2, true)) {
                    if (overrides(interfaceC11318aComponent2, interfaceC11318aComponent1, z2, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static AbstractC11466u findMaxVisibility(Collection<? extends InterfaceC11321b> collection) {
        AbstractC11466u abstractC11466u;
        if (collection == null) {
            m9930a(107);
            throw null;
        }
        if (collection.isEmpty()) {
            return C11464t.f23093k;
        }
        Iterator<? extends InterfaceC11321b> it = collection.iterator();
        loop0: while (true) {
            abstractC11466u = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                AbstractC11466u visibility = it.next().getVisibility();
                if (abstractC11466u != null) {
                    Integer numCompare = C11464t.compare(visibility, abstractC11466u);
                    if (numCompare == null) {
                        break;
                    }
                    if (numCompare.intValue() > 0) {
                    }
                }
                abstractC11466u = visibility;
            }
        }
        if (abstractC11466u == null) {
            return null;
        }
        Iterator<? extends InterfaceC11321b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numCompare2 = C11464t.compare(abstractC11466u, it2.next().getVisibility());
            if (numCompare2 == null || numCompare2.intValue() < 0) {
                return null;
            }
        }
        return abstractC11466u;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m9934g(InterfaceC11318a interfaceC11318a, AbstractC11913c0 abstractC11913c0, InterfaceC11318a interfaceC11318a2, AbstractC11913c0 abstractC11913c1, Pair<C11953m, C11941a> pair) {
        if (abstractC11913c0 == null) {
            m9930a(72);
            throw null;
        }
        if (abstractC11913c1 != null) {
            return pair.getFirst().isSubtypeOf(pair.getSecond(), abstractC11913c0.unwrap(), abstractC11913c1.unwrap());
        }
        m9930a(74);
        throw null;
    }

    public static d getBasicOverridabilityProblem(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
        boolean z2;
        d dVarIncompatible;
        if (interfaceC11318a == null) {
            m9930a(38);
            throw null;
        }
        if (interfaceC11318a2 == null) {
            m9930a(39);
            throw null;
        }
        boolean z3 = interfaceC11318a instanceof InterfaceC11472x;
        if ((z3 && !(interfaceC11318a2 instanceof InterfaceC11472x)) || (((z2 = interfaceC11318a instanceof InterfaceC11453n0)) && !(interfaceC11318a2 instanceof InterfaceC11453n0))) {
            return d.incompatible("Member kind mismatch");
        }
        if (!z3 && !z2) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + interfaceC11318a);
        }
        if (!interfaceC11318a.getName().equals(interfaceC11318a2.getName())) {
            return d.incompatible("Name mismatch");
        }
        if ((interfaceC11318a.getExtensionReceiverParameter() == null) != (interfaceC11318a2.getExtensionReceiverParameter() == null)) {
            dVarIncompatible = d.incompatible("Receiver presence mismatch");
        } else {
            dVarIncompatible = interfaceC11318a.getValueParameters().size() != interfaceC11318a2.getValueParameters().size() ? d.incompatible("Value parameter number mismatch") : null;
        }
        if (dVarIncompatible != null) {
            return dVarIncompatible;
        }
        return null;
    }

    public static d.a getBothWaysOverridability(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
        C11793k c11793k = f24411b;
        d.a result = c11793k.isOverridableBy(interfaceC11318a2, interfaceC11318a, null).getResult();
        d.a result2 = c11793k.isOverridableBy(interfaceC11318a, interfaceC11318a2, null).getResult();
        d.a aVar = d.a.OVERRIDABLE;
        if (result == aVar && result2 == aVar) {
            return aVar;
        }
        d.a aVar2 = d.a.CONFLICT;
        return (result == aVar2 || result2 == aVar2) ? aVar2 : d.a.INCOMPATIBLE;
    }

    public static Set<InterfaceC11321b> getOverriddenDeclarations(InterfaceC11321b interfaceC11321b) {
        if (interfaceC11321b == null) {
            m9930a(13);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m9931c(interfaceC11321b, linkedHashSet);
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m9935h(InterfaceC11458q interfaceC11458q, InterfaceC11458q interfaceC11458q2) {
        Integer numCompare = C11464t.compare(interfaceC11458q.getVisibility(), interfaceC11458q2.getVisibility());
        return numCompare == null || numCompare.intValue() >= 0;
    }

    public static boolean isMoreSpecific(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
        if (interfaceC11318a == null) {
            m9930a(65);
            throw null;
        }
        if (interfaceC11318a2 == null) {
            m9930a(66);
            throw null;
        }
        AbstractC11913c0 returnType = interfaceC11318a.getReturnType();
        AbstractC11913c0 returnType2 = interfaceC11318a2.getReturnType();
        if (!m9935h(interfaceC11318a, interfaceC11318a2)) {
            return false;
        }
        Pair<C11953m, C11941a> pairM9937f = f24411b.m9937f(interfaceC11318a.getTypeParameters(), interfaceC11318a2.getTypeParameters());
        if (interfaceC11318a instanceof InterfaceC11472x) {
            return m9934g(interfaceC11318a, returnType, interfaceC11318a2, returnType2, pairM9937f);
        }
        if (!(interfaceC11318a instanceof InterfaceC11453n0)) {
            StringBuilder sbM833U = C1643a.m833U("Unexpected callable: ");
            sbM833U.append(interfaceC11318a.getClass());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        InterfaceC11453n0 interfaceC11453n0 = (InterfaceC11453n0) interfaceC11318a;
        InterfaceC11453n0 interfaceC11453n1 = (InterfaceC11453n0) interfaceC11318a2;
        InterfaceC11457p0 setter = interfaceC11453n0.getSetter();
        InterfaceC11457p0 setter2 = interfaceC11453n1.getSetter();
        if (!((setter == null || setter2 == null) ? true : m9935h(setter, setter2))) {
            return false;
        }
        if (interfaceC11453n0.isVar() && interfaceC11453n1.isVar()) {
            return pairM9937f.getFirst().equalTypes(pairM9937f.getSecond(), returnType.unwrap(), returnType2.unwrap());
        }
        return (interfaceC11453n0.isVar() || !interfaceC11453n1.isVar()) && m9934g(interfaceC11318a, returnType, interfaceC11318a2, returnType2, pairM9937f);
    }

    public static boolean isVisibleForOverride(InterfaceC11474y interfaceC11474y, InterfaceC11474y interfaceC11474y2) {
        if (interfaceC11474y == null) {
            m9930a(55);
            throw null;
        }
        if (interfaceC11474y2 != null) {
            return !C11464t.isPrivate(interfaceC11474y2.getVisibility()) && C11464t.isVisibleIgnoringReceiver(interfaceC11474y2, interfaceC11474y);
        }
        m9930a(56);
        throw null;
    }

    public static <D extends InterfaceC11318a> boolean overrides(D d2, D d3, boolean z2, boolean z3) {
        if (d2 == null) {
            m9930a(11);
            throw null;
        }
        if (d3 == null) {
            m9930a(12);
            throw null;
        }
        if (!d2.equals(d3) && C11784b.f24391a.areEquivalent(d2.getOriginal(), d3.getOriginal(), z2, z3)) {
            return true;
        }
        InterfaceC11318a original = d3.getOriginal();
        Iterator it = C11787e.getAllOverriddenDescriptors(d2).iterator();
        while (it.hasNext()) {
            if (C11784b.f24391a.areEquivalent(original, (InterfaceC11318a) it.next(), z2, z3)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(InterfaceC11321b interfaceC11321b, Function1<InterfaceC11321b, Unit> function1) {
        AbstractC11466u abstractC11466u;
        if (interfaceC11321b == null) {
            m9930a(105);
            throw null;
        }
        for (InterfaceC11321b interfaceC11321b2 : interfaceC11321b.getOverriddenDescriptors()) {
            if (interfaceC11321b2.getVisibility() == C11464t.f23089g) {
                resolveUnknownVisibilityForMember(interfaceC11321b2, function1);
            }
        }
        if (interfaceC11321b.getVisibility() != C11464t.f23089g) {
            return;
        }
        Collection<? extends InterfaceC11321b> overriddenDescriptors = interfaceC11321b.getOverriddenDescriptors();
        AbstractC11466u abstractC11466uFindMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (abstractC11466uFindMaxVisibility == null) {
            abstractC11466uFindMaxVisibility = null;
            break;
        }
        if (interfaceC11321b.getKind() == InterfaceC11321b.a.FAKE_OVERRIDE) {
            for (InterfaceC11321b interfaceC11321b3 : overriddenDescriptors) {
                if (interfaceC11321b3.getModality() != EnumC11476z.ABSTRACT && !interfaceC11321b3.getVisibility().equals(abstractC11466uFindMaxVisibility)) {
                    abstractC11466uFindMaxVisibility = null;
                    break;
                }
            }
        } else {
            abstractC11466uFindMaxVisibility = abstractC11466uFindMaxVisibility.normalize();
        }
        if (abstractC11466uFindMaxVisibility == null) {
            if (function1 != null) {
                function1.invoke(interfaceC11321b);
            }
            abstractC11466u = C11464t.f23087e;
        } else {
            abstractC11466u = abstractC11466uFindMaxVisibility;
        }
        if (interfaceC11321b instanceof C11366c0) {
            ((C11366c0) interfaceC11321b).setVisibility(abstractC11466u);
            Iterator<InterfaceC11451m0> it = ((InterfaceC11453n0) interfaceC11321b).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), abstractC11466uFindMaxVisibility == null ? null : function1);
            }
            return;
        }
        if (interfaceC11321b instanceof AbstractC11391q) {
            ((AbstractC11391q) interfaceC11321b).setVisibility(abstractC11466u);
            return;
        }
        AbstractC11364b0 abstractC11364b0 = (AbstractC11364b0) interfaceC11321b;
        abstractC11364b0.setVisibility(abstractC11466u);
        if (abstractC11466u != abstractC11364b0.getCorrespondingProperty().getVisibility()) {
            abstractC11364b0.setDefault(false);
        }
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, InterfaceC11318a> function1) {
        H h;
        boolean z2;
        if (collection == null) {
            m9930a(76);
            throw null;
        }
        if (function1 == null) {
            m9930a(77);
            throw null;
        }
        if (collection.size() == 1) {
            H h2 = (H) C12163u.first(collection);
            if (h2 != null) {
                return h2;
            }
            m9930a(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = C12163u.map(collection, function1);
        H h3 = (H) C12163u.first(collection);
        InterfaceC11318a interfaceC11318aInvoke = function1.invoke(h3);
        for (H h4 : collection) {
            InterfaceC11318a interfaceC11318aInvoke2 = function1.invoke(h4);
            if (interfaceC11318aInvoke2 == null) {
                m9930a(69);
                throw null;
            }
            if (map == null) {
                m9930a(70);
                throw null;
            }
            Iterator it = map.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!isMoreSpecific(interfaceC11318aInvoke2, (InterfaceC11318a) it.next())) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(h4);
            }
            if (isMoreSpecific(interfaceC11318aInvoke2, interfaceC11318aInvoke) && !isMoreSpecific(interfaceC11318aInvoke, interfaceC11318aInvoke2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 != null) {
                return h3;
            }
            m9930a(79);
            throw null;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) C12163u.first((Iterable) arrayList);
            if (h5 != null) {
                return h5;
            }
            m9930a(80);
            throw null;
        }
        Iterator it2 = arrayList.iterator();
        do {
            if (!it2.hasNext()) {
                h = null;
                break;
            }
            h = (H) it2.next();
        } while (C12015y.isFlexible(function1.invoke(h).getReturnType()));
        if (h != null) {
            return h;
        }
        H h6 = (H) C12163u.first((Iterable) arrayList);
        if (h6 != null) {
            return h6;
        }
        m9930a(82);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9936b(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, Pair<C11953m, C11941a> pair) {
        if (abstractC11913c0 == null) {
            m9930a(44);
            throw null;
        }
        if (abstractC11913c1 == null) {
            m9930a(45);
            throw null;
        }
        if (pair == null) {
            m9930a(46);
            throw null;
        }
        if (C11919e0.isError(abstractC11913c0) && C11919e0.isError(abstractC11913c1)) {
            return true;
        }
        return pair.getFirst().equalTypes(pair.getSecond(), abstractC11913c0.unwrap(), abstractC11913c1.unwrap());
    }

    /* JADX INFO: renamed from: f */
    public final Pair<C11953m, C11941a> m9937f(List<InterfaceC11477z0> list, List<InterfaceC11477z0> list2) {
        e eVar;
        if (list == null) {
            m9930a(40);
            throw null;
        }
        if (list2 == null) {
            m9930a(41);
            throw null;
        }
        C11953m c11953m = new C11953m(this.f24413d);
        if (list == null) {
            m9930a(42);
            throw null;
        }
        if (list2 == null) {
            m9930a(43);
            throw null;
        }
        if (list.isEmpty()) {
            eVar = new e(null);
        } else {
            HashMap map = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
            }
            eVar = new e(map);
        }
        return new Pair<>(c11953m, eVar);
    }

    public void generateOverridesInFunctionGroup(C11716e c11716e, Collection<? extends InterfaceC11321b> collection, Collection<? extends InterfaceC11321b> collection2, InterfaceC11330e interfaceC11330e, AbstractC11792j abstractC11792j) {
        if (c11716e == null) {
            m9930a(50);
            throw null;
        }
        if (collection == null) {
            m9930a(51);
            throw null;
        }
        if (collection2 == null) {
            m9930a(52);
            throw null;
        }
        if (interfaceC11330e == null) {
            m9930a(53);
            throw null;
        }
        if (abstractC11792j == null) {
            m9930a(54);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (InterfaceC11321b interfaceC11321b : collection2) {
            if (interfaceC11321b == null) {
                m9930a(57);
                throw null;
            }
            if (collection == null) {
                m9930a(58);
                throw null;
            }
            if (interfaceC11330e == null) {
                m9930a(59);
                throw null;
            }
            if (abstractC11792j == null) {
                m9930a(60);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            C12042j c12042jCreate = C12042j.create();
            for (InterfaceC11321b interfaceC11321b2 : collection) {
                d.a result = isOverridableBy(interfaceC11321b2, interfaceC11321b, interfaceC11330e).getResult();
                boolean zIsVisibleForOverride = isVisibleForOverride(interfaceC11321b, interfaceC11321b2);
                int iOrdinal = result.ordinal();
                if (iOrdinal == 0) {
                    if (zIsVisibleForOverride) {
                        c12042jCreate.add(interfaceC11321b2);
                    }
                    arrayList.add(interfaceC11321b2);
                } else if (iOrdinal == 2) {
                    if (zIsVisibleForOverride) {
                        abstractC11792j.overrideConflict(interfaceC11321b2, interfaceC11321b);
                    }
                    arrayList.add(interfaceC11321b2);
                }
            }
            abstractC11792j.setOverriddenDescriptors(interfaceC11321b, c12042jCreate);
            linkedHashSet.removeAll(arrayList);
        }
        if (interfaceC11330e == null) {
            m9930a(62);
            throw null;
        }
        if (abstractC11792j == null) {
            m9930a(64);
            throw null;
        }
        if (linkedHashSet.size() < 2 ? true : C12163u.all(linkedHashSet, new C11794l(((InterfaceC11321b) linkedHashSet.iterator().next()).getContainingDeclaration()))) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                m9933e(Collections.singleton((InterfaceC11321b) it.next()), interfaceC11330e, abstractC11792j);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(linkedHashSet);
        while (!linkedList.isEmpty()) {
            InterfaceC11321b interfaceC11321bFindMemberWithMaxVisibility = C11802t.findMemberWithMaxVisibility(linkedList);
            if (interfaceC11321bFindMemberWithMaxVisibility == null) {
                m9930a(102);
                throw null;
            }
            m9933e(extractMembersOverridableInBothWays(interfaceC11321bFindMemberWithMaxVisibility, linkedList, new C11796n(), new C11797o(abstractC11792j, interfaceC11321bFindMemberWithMaxVisibility)), interfaceC11330e, abstractC11792j);
        }
    }

    public d isOverridableBy(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e) {
        if (interfaceC11318a == null) {
            m9930a(17);
            throw null;
        }
        if (interfaceC11318a2 == null) {
            m9930a(18);
            throw null;
        }
        d dVarIsOverridableBy = isOverridableBy(interfaceC11318a, interfaceC11318a2, interfaceC11330e, false);
        if (dVarIsOverridableBy != null) {
            return dVarIsOverridableBy;
        }
        m9930a(19);
        throw null;
    }

    public d isOverridableByWithoutExternalConditions(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, boolean z2) {
        if (interfaceC11318a == null) {
            m9930a(28);
            throw null;
        }
        if (interfaceC11318a2 == null) {
            m9930a(29);
            throw null;
        }
        d basicOverridabilityProblem = getBasicOverridabilityProblem(interfaceC11318a, interfaceC11318a2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<AbstractC11913c0> listM9932d = m9932d(interfaceC11318a);
        List<AbstractC11913c0> listM9932d2 = m9932d(interfaceC11318a2);
        List<InterfaceC11477z0> typeParameters = interfaceC11318a.getTypeParameters();
        List<InterfaceC11477z0> typeParameters2 = interfaceC11318a2.getTypeParameters();
        if (typeParameters.size() != typeParameters2.size()) {
            int i = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) listM9932d;
                if (i >= arrayList.size()) {
                    d dVarConflict = d.conflict("Type parameter number mismatch");
                    if (dVarConflict != null) {
                        return dVarConflict;
                    }
                    m9930a(32);
                    throw null;
                }
                if (!InterfaceC11946f.f24806a.equalTypes((AbstractC11913c0) arrayList.get(i), (AbstractC11913c0) ((ArrayList) listM9932d2).get(i))) {
                    d dVarIncompatible = d.incompatible("Type parameter number mismatch");
                    if (dVarIncompatible != null) {
                        return dVarIncompatible;
                    }
                    m9930a(31);
                    throw null;
                }
                i++;
            }
        } else {
            Pair<C11953m, C11941a> pairM9937f = m9937f(typeParameters, typeParameters2);
            int i2 = 0;
            while (true) {
                boolean z3 = true;
                if (i2 < typeParameters.size()) {
                    InterfaceC11477z0 interfaceC11477z0 = typeParameters.get(i2);
                    InterfaceC11477z0 interfaceC11477z1 = typeParameters2.get(i2);
                    if (interfaceC11477z0 == null) {
                        m9930a(47);
                        throw null;
                    }
                    if (interfaceC11477z1 == null) {
                        m9930a(48);
                        throw null;
                    }
                    List<AbstractC11913c0> upperBounds = interfaceC11477z0.getUpperBounds();
                    ArrayList arrayList2 = new ArrayList(interfaceC11477z1.getUpperBounds());
                    if (upperBounds.size() != arrayList2.size()) {
                        z3 = false;
                        break;
                    }
                    for (AbstractC11913c0 abstractC11913c0 : upperBounds) {
                        ListIterator listIterator = arrayList2.listIterator();
                        while (true) {
                            if (!listIterator.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (m9936b(abstractC11913c0, (AbstractC11913c0) listIterator.next(), pairM9937f)) {
                                listIterator.remove();
                            }
                        }
                    }
                    if (!z3) {
                        d dVarIncompatible2 = d.incompatible("Type parameter bounds mismatch");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        m9930a(33);
                        throw null;
                    }
                    i2++;
                } else {
                    int i3 = 0;
                    while (true) {
                        ArrayList arrayList3 = (ArrayList) listM9932d;
                        if (i3 >= arrayList3.size()) {
                            if ((interfaceC11318a instanceof InterfaceC11472x) && (interfaceC11318a2 instanceof InterfaceC11472x) && ((InterfaceC11472x) interfaceC11318a).isSuspend() != ((InterfaceC11472x) interfaceC11318a2).isSuspend()) {
                                d dVarConflict2 = d.conflict("Incompatible suspendability");
                                if (dVarConflict2 != null) {
                                    return dVarConflict2;
                                }
                                m9930a(35);
                                throw null;
                            }
                            if (z2) {
                                AbstractC11913c0 returnType = interfaceC11318a.getReturnType();
                                AbstractC11913c0 returnType2 = interfaceC11318a2.getReturnType();
                                if (returnType != null && returnType2 != null) {
                                    if (!(C11919e0.isError(returnType2) && C11919e0.isError(returnType)) && !pairM9937f.getFirst().isSubtypeOf(pairM9937f.getSecond(), returnType2.unwrap(), returnType.unwrap())) {
                                        d dVarConflict3 = d.conflict("Return type mismatch");
                                        if (dVarConflict3 != null) {
                                            return dVarConflict3;
                                        }
                                        m9930a(36);
                                        throw null;
                                    }
                                }
                            }
                            d dVarSuccess = d.success();
                            if (dVarSuccess != null) {
                                return dVarSuccess;
                            }
                            m9930a(37);
                            throw null;
                        }
                        if (!m9936b((AbstractC11913c0) arrayList3.get(i3), (AbstractC11913c0) ((ArrayList) listM9932d2).get(i3), pairM9937f)) {
                            d dVarIncompatible3 = d.incompatible("Value parameter type mismatch");
                            if (dVarIncompatible3 != null) {
                                return dVarIncompatible3;
                            }
                            m9930a(34);
                            throw null;
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public d isOverridableBy(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e, boolean z2) {
        InterfaceC11788f.a aVar = InterfaceC11788f.a.CONFLICTS_ONLY;
        if (interfaceC11318a == null) {
            m9930a(20);
            throw null;
        }
        if (interfaceC11318a2 != null) {
            d dVarIsOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(interfaceC11318a, interfaceC11318a2, z2);
            boolean z3 = dVarIsOverridableByWithoutExternalConditions.getResult() == d.a.OVERRIDABLE;
            for (InterfaceC11788f interfaceC11788f : f24410a) {
                if (interfaceC11788f.getContract() != aVar && (!z3 || interfaceC11788f.getContract() != InterfaceC11788f.a.SUCCESS_ONLY)) {
                    int iOrdinal = interfaceC11788f.isOverridable(interfaceC11318a, interfaceC11318a2, interfaceC11330e).ordinal();
                    if (iOrdinal == 0) {
                        z3 = true;
                    } else {
                        if (iOrdinal == 1) {
                            d dVarConflict = d.conflict("External condition failed");
                            if (dVarConflict != null) {
                                return dVarConflict;
                            }
                            m9930a(22);
                            throw null;
                        }
                        if (iOrdinal == 2) {
                            d dVarIncompatible = d.incompatible("External condition");
                            if (dVarIncompatible != null) {
                                return dVarIncompatible;
                            }
                            m9930a(23);
                            throw null;
                        }
                    }
                }
            }
            if (!z3) {
                return dVarIsOverridableByWithoutExternalConditions;
            }
            for (InterfaceC11788f interfaceC11788f2 : f24410a) {
                if (interfaceC11788f2.getContract() == aVar) {
                    int iOrdinal2 = interfaceC11788f2.isOverridable(interfaceC11318a, interfaceC11318a2, interfaceC11330e).ordinal();
                    if (iOrdinal2 == 0) {
                        StringBuilder sbM833U = C1643a.m833U("Contract violation in ");
                        sbM833U.append(interfaceC11788f2.getClass().getName());
                        sbM833U.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(sbM833U.toString());
                    }
                    if (iOrdinal2 == 1) {
                        d dVarConflict2 = d.conflict("External condition failed");
                        if (dVarConflict2 != null) {
                            return dVarConflict2;
                        }
                        m9930a(25);
                        throw null;
                    }
                    if (iOrdinal2 == 2) {
                        d dVarIncompatible2 = d.incompatible("External condition");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        m9930a(26);
                        throw null;
                    }
                }
            }
            d dVarSuccess = d.success();
            if (dVarSuccess != null) {
                return dVarSuccess;
            }
            m9930a(27);
            throw null;
        }
        m9930a(21);
        throw null;
    }
}
