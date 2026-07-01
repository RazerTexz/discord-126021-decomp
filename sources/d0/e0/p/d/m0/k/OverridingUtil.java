package d0.e0.p.d.m0.k;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.MemberDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyAccessorDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyAccessorDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.ExternalOverridabilityCondition;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.e0.p.d.m0.n.l1.ClassicTypeCheckerContext;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker2;
import d0.e0.p.d.m0.p.SmartSet;
import d0.t._Collections;
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
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.k, reason: use source file name */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class OverridingUtil {
    public static final List<ExternalOverridabilityCondition> a = _Collections.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OverridingUtil f3468b;
    public static final KotlinTypeChecker.a c;
    public final KotlinTypeRefiner d;
    public final KotlinTypeChecker.a e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$a */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class a implements KotlinTypeChecker.a {
        public static /* synthetic */ void a(int i) {
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

        @Override // d0.e0.p.d.m0.n.l1.KotlinTypeChecker.a
        public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                a(0);
                throw null;
            }
            if (typeConstructor2 != null) {
                return typeConstructor.equals(typeConstructor2);
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$b */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class b<D> implements Function2<D, D, Tuples2<CallableDescriptor, CallableDescriptor>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Ld0/e0/p/d/m0/c/a;Ld0/e0/p/d/m0/c/a;>; */
        @Override // kotlin.jvm.functions.Function2
        public Tuples2 invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            return new Tuples2(callableDescriptor, callableDescriptor2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$c */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class c implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        @Override // kotlin.jvm.functions.Function1
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class d {
        public static final d a = new d(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f3469b;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d$a */
        /* JADX INFO: compiled from: OverridingUtil.java */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public d(a aVar, String str) {
            if (aVar == null) {
                a(3);
                throw null;
            }
            if (str != null) {
                this.f3469b = aVar;
            } else {
                a(4);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        public static /* synthetic */ void a(int i) {
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
            a(2);
            throw null;
        }

        public static d incompatible(String str) {
            if (str != null) {
                return new d(a.INCOMPATIBLE, str);
            }
            a(1);
            throw null;
        }

        public static d success() {
            d dVar = a;
            if (dVar != null) {
                return dVar;
            }
            a(0);
            throw null;
        }

        public a getResult() {
            a aVar = this.f3469b;
            if (aVar != null) {
                return aVar;
            }
            a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$e */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public class e extends ClassicTypeCheckerContext {
        public final Map<TypeConstructor, TypeConstructor> j;

        public e(Map<TypeConstructor, TypeConstructor> map) {
            super(true, true, true, OverridingUtil.this.d);
            this.j = map;
        }

        public static /* synthetic */ void a(int i) {
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
        @Override // d0.e0.p.d.m0.n.l1.ClassicTypeCheckerContext
        public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            boolean z2;
            if (typeConstructor == null) {
                a(0);
                throw null;
            }
            if (typeConstructor2 == null) {
                a(1);
                throw null;
            }
            if (!super.areEqualTypeConstructors(typeConstructor, typeConstructor2)) {
                if (typeConstructor == null) {
                    a(2);
                    throw null;
                }
                if (typeConstructor2 == null) {
                    a(3);
                    throw null;
                }
                if (OverridingUtil.this.e.equals(typeConstructor, typeConstructor2)) {
                    z2 = true;
                } else {
                    Map<TypeConstructor, TypeConstructor> map = this.j;
                    if (map != null) {
                        TypeConstructor typeConstructor3 = map.get(typeConstructor);
                        TypeConstructor typeConstructor4 = this.j.get(typeConstructor2);
                        if ((typeConstructor3 != null && typeConstructor3.equals(typeConstructor2)) || (typeConstructor4 != null && typeConstructor4.equals(typeConstructor))) {
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
        c = aVar;
        f3468b = new OverridingUtil(aVar, KotlinTypeRefiner.a.a);
    }

    public OverridingUtil(KotlinTypeChecker.a aVar, KotlinTypeRefiner kotlinTypeRefiner) {
        if (aVar == null) {
            a(4);
            throw null;
        }
        if (kotlinTypeRefiner == null) {
            a(5);
            throw null;
        }
        this.e = aVar;
        this.d = kotlinTypeRefiner;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:29:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:94:0x0184  */
    public static /* synthetic */ void a(int i) {
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

    public static void c(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
            throw null;
        }
        if (set == null) {
            a(16);
            throw null;
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            c(it.next(), set);
        }
    }

    public static OverridingUtil create(KotlinTypeRefiner kotlinTypeRefiner, KotlinTypeChecker.a aVar) {
        if (kotlinTypeRefiner == null) {
            a(2);
            throw null;
        }
        if (aVar != null) {
            return new OverridingUtil(aVar, kotlinTypeRefiner);
        }
        a(3);
        throw null;
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return new OverridingUtil(c, kotlinTypeRefiner);
        }
        a(1);
        throw null;
    }

    public static List<KotlinType> d(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    public static void e(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy2 overridingStrategy2) {
        Modality modality;
        Modality modality2;
        if (collection == null) {
            a(83);
            throw null;
        }
        if (classDescriptor == null) {
            a(84);
            throw null;
        }
        if (overridingStrategy2 == null) {
            a(85);
            throw null;
        }
        if (classDescriptor == null) {
            a(94);
            throw null;
        }
        if (collection == null) {
            a(95);
            throw null;
        }
        List listFilter = _Collections.filter(collection, new OverridingUtil3(classDescriptor));
        if (listFilter == null) {
            a(96);
            throw null;
        }
        boolean zIsEmpty = listFilter.isEmpty();
        Collection<? extends CallableMemberDescriptor> collection2 = zIsEmpty ? collection : listFilter;
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (it.hasNext()) {
                CallableMemberDescriptor next = it.next();
                int iOrdinal = next.getModality().ordinal();
                if (iOrdinal == 0) {
                    modality2 = Modality.FINAL;
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
                if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
                    z2 = true;
                }
                if (z3 && !z4) {
                    modality2 = Modality.OPEN;
                } else {
                    if (z3 || !z4) {
                        HashSet hashSet = new HashSet();
                        Iterator<? extends CallableMemberDescriptor> it2 = collection2.iterator();
                        while (it2.hasNext()) {
                            hashSet.addAll(getOverriddenDeclarations(it2.next()));
                        }
                        Set<CallableMemberDescriptor> setFilterOutOverridden = filterOutOverridden(hashSet);
                        Modality modality3 = classDescriptor.getModality();
                        if (setFilterOutOverridden == null) {
                            a(91);
                            throw null;
                        }
                        if (modality3 == null) {
                            a(92);
                            throw null;
                        }
                        Modality modality4 = Modality.ABSTRACT;
                        for (CallableMemberDescriptor callableMemberDescriptor : setFilterOutOverridden) {
                            Modality modality5 = (z2 && callableMemberDescriptor.getModality() == Modality.ABSTRACT) ? modality3 : callableMemberDescriptor.getModality();
                            if (modality5.compareTo(modality4) < 0) {
                                modality4 = modality5;
                            }
                        }
                        if (modality4 != null) {
                            modality = modality4;
                            break;
                        } else {
                            a(93);
                            throw null;
                        }
                    }
                    modality2 = z2 ? classDescriptor.getModality() : Modality.ABSTRACT;
                    if (modality2 == null) {
                        a(90);
                        throw null;
                    }
                }
            }
            modality = modality2;
            break;
        }
        CallableMemberDescriptor callableMemberDescriptorCopy = ((CallableMemberDescriptor) selectMostSpecificMember(collection2, new c())).copy(classDescriptor, modality, zIsEmpty ? DescriptorVisibilities.h : DescriptorVisibilities.g, CallableMemberDescriptor.a.FAKE_OVERRIDE, false);
        overridingStrategy2.setOverriddenDescriptors(callableMemberDescriptorCopy, collection2);
        overridingStrategy2.addFakeOverride(callableMemberDescriptorCopy);
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function2) {
        if (h == null) {
            a(97);
            throw null;
        }
        if (collection == null) {
            a(98);
            throw null;
        }
        if (function1 == null) {
            a(99);
            throw null;
        }
        if (function2 == null) {
            a(100);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        CallableDescriptor callableDescriptorInvoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor callableDescriptorInvoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                d.a bothWaysOverridability = getBothWaysOverridability(callableDescriptorInvoke, callableDescriptorInvoke2);
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

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> set) {
        if (set != null) {
            return filterOverrides(set, !set.isEmpty() && DescriptorUtils2.isTypeRefinementEnabled(DescriptorUtils2.getModule(set.iterator().next())), null, new b());
        }
        a(6);
        throw null;
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z2, Function0<?> function0, Function2<? super D, ? super D, Tuples2<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            a(7);
            throw null;
        }
        if (function2 == null) {
            a(8);
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
                Tuples2<CallableDescriptor, CallableDescriptor> tuples2Invoke = function2.invoke(obj, (Object) it.next());
                CallableDescriptor callableDescriptorComponent1 = tuples2Invoke.component1();
                CallableDescriptor callableDescriptorComponent2 = tuples2Invoke.component2();
                if (!overrides(callableDescriptorComponent1, callableDescriptorComponent2, z2, true)) {
                    if (overrides(callableDescriptorComponent2, callableDescriptorComponent1, z2, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static DescriptorVisibility2 findMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        DescriptorVisibility2 descriptorVisibility2;
        if (collection == null) {
            a(107);
            throw null;
        }
        if (collection.isEmpty()) {
            return DescriptorVisibilities.k;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            descriptorVisibility2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                DescriptorVisibility2 visibility = it.next().getVisibility();
                if (descriptorVisibility2 != null) {
                    Integer numCompare = DescriptorVisibilities.compare(visibility, descriptorVisibility2);
                    if (numCompare == null) {
                        break;
                    }
                    if (numCompare.intValue() > 0) {
                    }
                }
                descriptorVisibility2 = visibility;
            }
        }
        if (descriptorVisibility2 == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numCompare2 = DescriptorVisibilities.compare(descriptorVisibility2, it2.next().getVisibility());
            if (numCompare2 == null || numCompare2.intValue() < 0) {
                return null;
            }
        }
        return descriptorVisibility2;
    }

    public static boolean g(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2, Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2) {
        if (kotlinType == null) {
            a(72);
            throw null;
        }
        if (kotlinType2 != null) {
            return tuples2.getFirst().isSubtypeOf(tuples2.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
        }
        a(74);
        throw null;
    }

    public static d getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z2;
        d dVarIncompatible;
        if (callableDescriptor == null) {
            a(38);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(39);
            throw null;
        }
        boolean z3 = callableDescriptor instanceof FunctionDescriptor;
        if ((z3 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z2 = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return d.incompatible("Member kind mismatch");
        }
        if (!z3 && !z2) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return d.incompatible("Name mismatch");
        }
        if ((callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null)) {
            dVarIncompatible = d.incompatible("Receiver presence mismatch");
        } else {
            dVarIncompatible = callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size() ? d.incompatible("Value parameter number mismatch") : null;
        }
        if (dVarIncompatible != null) {
            return dVarIncompatible;
        }
        return null;
    }

    public static d.a getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = f3468b;
        d.a result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        d.a result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        d.a aVar = d.a.OVERRIDABLE;
        if (result == aVar && result2 == aVar) {
            return aVar;
        }
        d.a aVar2 = d.a.CONFLICT;
        return (result == aVar2 || result2 == aVar2) ? aVar2 : d.a.INCOMPATIBLE;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(13);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    public static boolean h(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        Integer numCompare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return numCompare == null || numCompare.intValue() >= 0;
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(65);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(66);
            throw null;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!h(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2F = f3468b.f(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return g(callableDescriptor, returnType, callableDescriptor2, returnType2, tuples2F);
        }
        if (!(callableDescriptor instanceof PropertyDescriptor)) {
            StringBuilder sbU = outline.U("Unexpected callable: ");
            sbU.append(callableDescriptor.getClass());
            throw new IllegalArgumentException(sbU.toString());
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        PropertySetterDescriptor setter2 = propertyDescriptor2.getSetter();
        if (!((setter == null || setter2 == null) ? true : h(setter, setter2))) {
            return false;
        }
        if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
            return tuples2F.getFirst().equalTypes(tuples2F.getSecond(), returnType.unwrap(), returnType2.unwrap());
        }
        return (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && g(callableDescriptor, returnType, callableDescriptor2, returnType2, tuples2F);
    }

    public static boolean isVisibleForOverride(MemberDescriptor memberDescriptor, MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            a(55);
            throw null;
        }
        if (memberDescriptor2 != null) {
            return !DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor);
        }
        a(56);
        throw null;
    }

    public static <D extends CallableDescriptor> boolean overrides(D d2, D d3, boolean z2, boolean z3) {
        if (d2 == null) {
            a(11);
            throw null;
        }
        if (d3 == null) {
            a(12);
            throw null;
        }
        if (!d2.equals(d3) && DescriptorEquivalenceForOverrides.a.areEquivalent(d2.getOriginal(), d3.getOriginal(), z2, z3)) {
            return true;
        }
        CallableDescriptor original = d3.getOriginal();
        Iterator it = DescriptorUtils.getAllOverriddenDescriptors(d2).iterator();
        while (it.hasNext()) {
            if (DescriptorEquivalenceForOverrides.a.areEquivalent(original, (CallableDescriptor) it.next(), z2, z3)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        DescriptorVisibility2 descriptorVisibility2;
        if (callableMemberDescriptor == null) {
            a(105);
            throw null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == DescriptorVisibilities.g) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != DescriptorVisibilities.g) {
            return;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        DescriptorVisibility2 descriptorVisibility2FindMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (descriptorVisibility2FindMaxVisibility == null) {
            descriptorVisibility2FindMaxVisibility = null;
            break;
        }
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.a.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor3 : overriddenDescriptors) {
                if (callableMemberDescriptor3.getModality() != Modality.ABSTRACT && !callableMemberDescriptor3.getVisibility().equals(descriptorVisibility2FindMaxVisibility)) {
                    descriptorVisibility2FindMaxVisibility = null;
                    break;
                }
            }
        } else {
            descriptorVisibility2FindMaxVisibility = descriptorVisibility2FindMaxVisibility.normalize();
        }
        if (descriptorVisibility2FindMaxVisibility == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            descriptorVisibility2 = DescriptorVisibilities.e;
        } else {
            descriptorVisibility2 = descriptorVisibility2FindMaxVisibility;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility2);
            Iterator<PropertyAccessorDescriptor> it = ((PropertyDescriptor) callableMemberDescriptor).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), descriptorVisibility2FindMaxVisibility == null ? null : function1);
            }
            return;
        }
        if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility2);
            return;
        }
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
        propertyAccessorDescriptorImpl.setVisibility(descriptorVisibility2);
        if (descriptorVisibility2 != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
            propertyAccessorDescriptorImpl.setDefault(false);
        }
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        H h;
        boolean z2;
        if (collection == null) {
            a(76);
            throw null;
        }
        if (function1 == null) {
            a(77);
            throw null;
        }
        if (collection.size() == 1) {
            H h2 = (H) _Collections.first(collection);
            if (h2 != null) {
                return h2;
            }
            a(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = _Collections.map(collection, function1);
        H h3 = (H) _Collections.first(collection);
        CallableDescriptor callableDescriptorInvoke = function1.invoke(h3);
        for (H h4 : collection) {
            CallableDescriptor callableDescriptorInvoke2 = function1.invoke(h4);
            if (callableDescriptorInvoke2 == null) {
                a(69);
                throw null;
            }
            if (map == null) {
                a(70);
                throw null;
            }
            Iterator it = map.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!isMoreSpecific(callableDescriptorInvoke2, (CallableDescriptor) it.next())) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(h4);
            }
            if (isMoreSpecific(callableDescriptorInvoke2, callableDescriptorInvoke) && !isMoreSpecific(callableDescriptorInvoke, callableDescriptorInvoke2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 != null) {
                return h3;
            }
            a(79);
            throw null;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) _Collections.first((Iterable) arrayList);
            if (h5 != null) {
                return h5;
            }
            a(80);
            throw null;
        }
        Iterator it2 = arrayList.iterator();
        do {
            if (!it2.hasNext()) {
                h = null;
                break;
            }
            h = (H) it2.next();
        } while (flexibleTypes2.isFlexible(function1.invoke(h).getReturnType()));
        if (h != null) {
            return h;
        }
        H h6 = (H) _Collections.first((Iterable) arrayList);
        if (h6 != null) {
            return h6;
        }
        a(82);
        throw null;
    }

    public final boolean b(KotlinType kotlinType, KotlinType kotlinType2, Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2) {
        if (kotlinType == null) {
            a(44);
            throw null;
        }
        if (kotlinType2 == null) {
            a(45);
            throw null;
        }
        if (tuples2 == null) {
            a(46);
            throw null;
        }
        if (KotlinType2.isError(kotlinType) && KotlinType2.isError(kotlinType2)) {
            return true;
        }
        return tuples2.getFirst().equalTypes(tuples2.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> f(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        e eVar;
        if (list == null) {
            a(40);
            throw null;
        }
        if (list2 == null) {
            a(41);
            throw null;
        }
        NewKotlinTypeChecker2 newKotlinTypeChecker2 = new NewKotlinTypeChecker2(this.d);
        if (list == null) {
            a(42);
            throw null;
        }
        if (list2 == null) {
            a(43);
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
        return new Tuples2<>(newKotlinTypeChecker2, eVar);
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy2 overridingStrategy2) {
        if (name == null) {
            a(50);
            throw null;
        }
        if (collection == null) {
            a(51);
            throw null;
        }
        if (collection2 == null) {
            a(52);
            throw null;
        }
        if (classDescriptor == null) {
            a(53);
            throw null;
        }
        if (overridingStrategy2 == null) {
            a(54);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            if (callableMemberDescriptor == null) {
                a(57);
                throw null;
            }
            if (collection == null) {
                a(58);
                throw null;
            }
            if (classDescriptor == null) {
                a(59);
                throw null;
            }
            if (overridingStrategy2 == null) {
                a(60);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            SmartSet smartSetCreate = SmartSet.create();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                d.a result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
                boolean zIsVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2);
                int iOrdinal = result.ordinal();
                if (iOrdinal == 0) {
                    if (zIsVisibleForOverride) {
                        smartSetCreate.add(callableMemberDescriptor2);
                    }
                    arrayList.add(callableMemberDescriptor2);
                } else if (iOrdinal == 2) {
                    if (zIsVisibleForOverride) {
                        overridingStrategy2.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                    }
                    arrayList.add(callableMemberDescriptor2);
                }
            }
            overridingStrategy2.setOverriddenDescriptors(callableMemberDescriptor, smartSetCreate);
            linkedHashSet.removeAll(arrayList);
        }
        if (classDescriptor == null) {
            a(62);
            throw null;
        }
        if (overridingStrategy2 == null) {
            a(64);
            throw null;
        }
        if (linkedHashSet.size() < 2 ? true : _Collections.all(linkedHashSet, new OverridingUtil2(((CallableMemberDescriptor) linkedHashSet.iterator().next()).getContainingDeclaration()))) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                e(Collections.singleton((CallableMemberDescriptor) it.next()), classDescriptor, overridingStrategy2);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(linkedHashSet);
        while (!linkedList.isEmpty()) {
            CallableMemberDescriptor callableMemberDescriptorFindMemberWithMaxVisibility = VisibilityUtil.findMemberWithMaxVisibility(linkedList);
            if (callableMemberDescriptorFindMemberWithMaxVisibility == null) {
                a(102);
                throw null;
            }
            e(extractMembersOverridableInBothWays(callableMemberDescriptorFindMemberWithMaxVisibility, linkedList, new OverridingUtil4(), new OverridingUtil5(overridingStrategy2, callableMemberDescriptorFindMemberWithMaxVisibility)), classDescriptor, overridingStrategy2);
        }
    }

    public d isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            a(17);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(18);
            throw null;
        }
        d dVarIsOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (dVarIsOverridableBy != null) {
            return dVarIsOverridableBy;
        }
        a(19);
        throw null;
    }

    public d isOverridableByWithoutExternalConditions(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z2) {
        if (callableDescriptor == null) {
            a(28);
            throw null;
        }
        if (callableDescriptor2 == null) {
            a(29);
            throw null;
        }
        d basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<KotlinType> listD = d(callableDescriptor);
        List<KotlinType> listD2 = d(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        if (typeParameters.size() != typeParameters2.size()) {
            int i = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) listD;
                if (i >= arrayList.size()) {
                    d dVarConflict = d.conflict("Type parameter number mismatch");
                    if (dVarConflict != null) {
                        return dVarConflict;
                    }
                    a(32);
                    throw null;
                }
                if (!KotlinTypeChecker.a.equalTypes((KotlinType) arrayList.get(i), (KotlinType) ((ArrayList) listD2).get(i))) {
                    d dVarIncompatible = d.incompatible("Type parameter number mismatch");
                    if (dVarIncompatible != null) {
                        return dVarIncompatible;
                    }
                    a(31);
                    throw null;
                }
                i++;
            }
        } else {
            Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2F = f(typeParameters, typeParameters2);
            int i2 = 0;
            while (true) {
                boolean z3 = true;
                if (i2 < typeParameters.size()) {
                    TypeParameterDescriptor typeParameterDescriptor = typeParameters.get(i2);
                    TypeParameterDescriptor typeParameterDescriptor2 = typeParameters2.get(i2);
                    if (typeParameterDescriptor == null) {
                        a(47);
                        throw null;
                    }
                    if (typeParameterDescriptor2 == null) {
                        a(48);
                        throw null;
                    }
                    List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                    ArrayList arrayList2 = new ArrayList(typeParameterDescriptor2.getUpperBounds());
                    if (upperBounds.size() != arrayList2.size()) {
                        z3 = false;
                        break;
                    }
                    for (KotlinType kotlinType : upperBounds) {
                        ListIterator listIterator = arrayList2.listIterator();
                        while (true) {
                            if (!listIterator.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (b(kotlinType, (KotlinType) listIterator.next(), tuples2F)) {
                                listIterator.remove();
                            }
                        }
                    }
                    if (!z3) {
                        d dVarIncompatible2 = d.incompatible("Type parameter bounds mismatch");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        a(33);
                        throw null;
                    }
                    i2++;
                } else {
                    int i3 = 0;
                    while (true) {
                        ArrayList arrayList3 = (ArrayList) listD;
                        if (i3 >= arrayList3.size()) {
                            if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
                                d dVarConflict2 = d.conflict("Incompatible suspendability");
                                if (dVarConflict2 != null) {
                                    return dVarConflict2;
                                }
                                a(35);
                                throw null;
                            }
                            if (z2) {
                                KotlinType returnType = callableDescriptor.getReturnType();
                                KotlinType returnType2 = callableDescriptor2.getReturnType();
                                if (returnType != null && returnType2 != null) {
                                    if (!(KotlinType2.isError(returnType2) && KotlinType2.isError(returnType)) && !tuples2F.getFirst().isSubtypeOf(tuples2F.getSecond(), returnType2.unwrap(), returnType.unwrap())) {
                                        d dVarConflict3 = d.conflict("Return type mismatch");
                                        if (dVarConflict3 != null) {
                                            return dVarConflict3;
                                        }
                                        a(36);
                                        throw null;
                                    }
                                }
                            }
                            d dVarSuccess = d.success();
                            if (dVarSuccess != null) {
                                return dVarSuccess;
                            }
                            a(37);
                            throw null;
                        }
                        if (!b((KotlinType) arrayList3.get(i3), (KotlinType) ((ArrayList) listD2).get(i3), tuples2F)) {
                            d dVarIncompatible3 = d.incompatible("Value parameter type mismatch");
                            if (dVarIncompatible3 != null) {
                                return dVarIncompatible3;
                            }
                            a(34);
                            throw null;
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public d isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z2) {
        ExternalOverridabilityCondition.a aVar = ExternalOverridabilityCondition.a.CONFLICTS_ONLY;
        if (callableDescriptor == null) {
            a(20);
            throw null;
        }
        if (callableDescriptor2 != null) {
            d dVarIsOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z2);
            boolean z3 = dVarIsOverridableByWithoutExternalConditions.getResult() == d.a.OVERRIDABLE;
            for (ExternalOverridabilityCondition externalOverridabilityCondition : a) {
                if (externalOverridabilityCondition.getContract() != aVar && (!z3 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.a.SUCCESS_ONLY)) {
                    int iOrdinal = externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (iOrdinal == 0) {
                        z3 = true;
                    } else {
                        if (iOrdinal == 1) {
                            d dVarConflict = d.conflict("External condition failed");
                            if (dVarConflict != null) {
                                return dVarConflict;
                            }
                            a(22);
                            throw null;
                        }
                        if (iOrdinal == 2) {
                            d dVarIncompatible = d.incompatible("External condition");
                            if (dVarIncompatible != null) {
                                return dVarIncompatible;
                            }
                            a(23);
                            throw null;
                        }
                    }
                }
            }
            if (!z3) {
                return dVarIsOverridableByWithoutExternalConditions;
            }
            for (ExternalOverridabilityCondition externalOverridabilityCondition2 : a) {
                if (externalOverridabilityCondition2.getContract() == aVar) {
                    int iOrdinal2 = externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (iOrdinal2 == 0) {
                        StringBuilder sbU = outline.U("Contract violation in ");
                        sbU.append(externalOverridabilityCondition2.getClass().getName());
                        sbU.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(sbU.toString());
                    }
                    if (iOrdinal2 == 1) {
                        d dVarConflict2 = d.conflict("External condition failed");
                        if (dVarConflict2 != null) {
                            return dVarConflict2;
                        }
                        a(25);
                        throw null;
                    }
                    if (iOrdinal2 == 2) {
                        d dVarIncompatible2 = d.incompatible("External condition");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        a(26);
                        throw null;
                    }
                }
            }
            d dVarSuccess = d.success();
            if (dVarSuccess != null) {
                return dVarSuccess;
            }
            a(27);
            throw null;
        }
        a(21);
        throw null;
    }
}
