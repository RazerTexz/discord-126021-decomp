package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11348k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11349l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.C11806d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11950j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1.C11996b;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12035c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c1 */
/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11914c1 {

    /* JADX INFO: renamed from: a */
    public static final C11914c1 f24745a = create(AbstractC12018z0.f24899a);

    /* JADX INFO: renamed from: b */
    public final AbstractC12018z0 f24746b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.c1$a */
    /* JADX INFO: compiled from: TypeSubstitutor.java */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public C11914c1(AbstractC12018z0 abstractC12018z0) {
        if (abstractC12018z0 != null) {
            this.f24746b = abstractC12018z0;
        } else {
            m9998a(6);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9998a(int i) {
        String str;
        int i2;
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    i2 = 2;
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            i2 = 2;
                            break;
                    }
                case 10:
                case 11:
                case 12:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "substitutionContext";
                break;
            case 5:
                objArr[0] = "context";
                break;
            case 6:
            default:
                objArr[0] = "substitution";
                break;
            case 8:
            case 13:
                objArr[0] = "type";
                break;
            case 9:
            case 14:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 15:
            case 16:
            case 34:
                objArr[0] = "typeProjection";
                break;
            case 17:
            case 26:
                objArr[0] = "originalProjection";
                break;
            case 24:
                objArr[0] = "originalType";
                break;
            case 25:
                objArr[0] = "substituted";
                break;
            case 31:
                objArr[0] = "annotations";
                break;
            case 33:
            case 36:
                objArr[0] = "typeParameterVariance";
                break;
            case 37:
                objArr[0] = "projectionKind";
                break;
        }
        if (i == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i == 7) {
            objArr[1] = "getSubstitution";
        } else if (i == 32) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 35:
            case 38:
            case 39:
            case 40:
                break;
            case 2:
            case 3:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 4:
            case 5:
            default:
                objArr[2] = "create";
                break;
            case 6:
                objArr[2] = "<init>";
                break;
            case 8:
            case 9:
                objArr[2] = "safeSubstitute";
                break;
            case 13:
            case 14:
            case 15:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 17:
                objArr[2] = "unsafeSubstitute";
                break;
            case 24:
            case 25:
            case 26:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 31:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 7 && i != 32 && i != 35) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            switch (i) {
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                    break;
                                default:
                                    switch (i) {
                                        case 38:
                                        case 39:
                                        case 40:
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

    /* JADX INFO: renamed from: b */
    public static int m9999b(EnumC11935j1 enumC11935j1, EnumC11935j1 enumC11935j2) {
        EnumC11935j1 enumC11935j3 = EnumC11935j1.OUT_VARIANCE;
        EnumC11935j1 enumC11935j4 = EnumC11935j1.IN_VARIANCE;
        if (enumC11935j1 == enumC11935j4 && enumC11935j2 == enumC11935j3) {
            return 3;
        }
        return (enumC11935j1 == enumC11935j3 && enumC11935j2 == enumC11935j4) ? 2 : 1;
    }

    /* JADX INFO: renamed from: c */
    public static String m10000c(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (C12035c.isProcessCanceledException(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public static EnumC11935j1 combine(EnumC11935j1 enumC11935j1, InterfaceC12012w0 interfaceC12012w0) {
        if (enumC11935j1 == null) {
            m9998a(33);
            throw null;
        }
        if (interfaceC12012w0 != null) {
            return interfaceC12012w0.isStarProjection() ? EnumC11935j1.OUT_VARIANCE : combine(enumC11935j1, interfaceC12012w0.getProjectionKind());
        }
        m9998a(34);
        throw null;
    }

    public static C11914c1 create(AbstractC12018z0 abstractC12018z0) {
        if (abstractC12018z0 != null) {
            return new C11914c1(abstractC12018z0);
        }
        m9998a(0);
        throw null;
    }

    public static C11914c1 createChainedSubstitutor(AbstractC12018z0 abstractC12018z0, AbstractC12018z0 abstractC12018z1) {
        if (abstractC12018z0 == null) {
            m9998a(2);
            throw null;
        }
        if (abstractC12018z1 != null) {
            return create(C11993p.create(abstractC12018z0, abstractC12018z1));
        }
        m9998a(3);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: d */
    public final InterfaceC12012w0 m10001d(InterfaceC12012w0 interfaceC12012w0, InterfaceC11477z0 interfaceC11477z0, int i) throws a {
        if (interfaceC12012w0 == null) {
            m9998a(17);
            throw null;
        }
        AbstractC12018z0 abstractC12018z0 = this.f24746b;
        if (i > 100) {
            StringBuilder sbM833U = C1643a.m833U("Recursion too deep. Most likely infinite loop while substituting ");
            sbM833U.append(m10000c(interfaceC12012w0));
            sbM833U.append("; substitution: ");
            sbM833U.append(m10000c(abstractC12018z0));
            throw new IllegalStateException(sbM833U.toString());
        }
        if (interfaceC12012w0.isStarProjection()) {
            return interfaceC12012w0;
        }
        AbstractC11913c0 type = interfaceC12012w0.getType();
        if (type instanceof InterfaceC11923f1) {
            InterfaceC11923f1 interfaceC11923f1 = (InterfaceC11923f1) type;
            AbstractC11932i1 origin = interfaceC11923f1.getOrigin();
            AbstractC11913c0 enhancement = interfaceC11923f1.getEnhancement();
            InterfaceC12012w0 interfaceC12012w0M10001d = m10001d(new C12016y0(interfaceC12012w0.getProjectionKind(), origin), interfaceC11477z0, i + 1);
            return new C12016y0(interfaceC12012w0M10001d.getProjectionKind(), C11926g1.wrapEnhancement(interfaceC12012w0M10001d.getType().unwrap(), substitute(enhancement, interfaceC12012w0.getProjectionKind())));
        }
        if (C12001r.isDynamic(type) || (type.unwrap() instanceof InterfaceC11931i0)) {
            return interfaceC12012w0;
        }
        InterfaceC12012w0 c12016y0 = this.f24746b.get(type);
        if (c12016y0 == null) {
            c12016y0 = null;
        } else if (type.getAnnotations().hasAnnotation(C11291k.a.f22510G)) {
            InterfaceC12008u0 constructor = c12016y0.getType().getConstructor();
            if (constructor instanceof C11950j) {
                InterfaceC12012w0 projection = ((C11950j) constructor).getProjection();
                EnumC11935j1 projectionKind = projection.getProjectionKind();
                if (m9999b(interfaceC12012w0.getProjectionKind(), projectionKind) == 3) {
                    c12016y0 = new C12016y0(projection.getType());
                } else if (interfaceC11477z0 != null && m9999b(interfaceC11477z0.getVariance(), projectionKind) == 3) {
                    c12016y0 = new C12016y0(projection.getType());
                }
            }
        }
        EnumC11935j1 projectionKind2 = interfaceC12012w0.getProjectionKind();
        if (c12016y0 == null && C12015y.isFlexible(type) && !C12006t0.isCustomTypeVariable(type)) {
            AbstractC12009v abstractC12009vAsFlexibleType = C12015y.asFlexibleType(type);
            int i2 = i + 1;
            InterfaceC12012w0 interfaceC12012w0M10001d2 = m10001d(new C12016y0(projectionKind2, abstractC12009vAsFlexibleType.getLowerBound()), interfaceC11477z0, i2);
            InterfaceC12012w0 interfaceC12012w0M10001d3 = m10001d(new C12016y0(projectionKind2, abstractC12009vAsFlexibleType.getUpperBound()), interfaceC11477z0, i2);
            return (interfaceC12012w0M10001d2.getType() == abstractC12009vAsFlexibleType.getLowerBound() && interfaceC12012w0M10001d3.getType() == abstractC12009vAsFlexibleType.getUpperBound()) ? interfaceC12012w0 : new C12016y0(interfaceC12012w0M10001d2.getProjectionKind(), C11916d0.flexibleType(C11908a1.asSimpleType(interfaceC12012w0M10001d2.getType()), C11908a1.asSimpleType(interfaceC12012w0M10001d3.getType())));
        }
        if (AbstractC11288h.isNothing(type) || C11919e0.isError(type)) {
            return interfaceC12012w0;
        }
        if (c12016y0 != null) {
            int iM9999b = m9999b(projectionKind2, c12016y0.getProjectionKind());
            if (!C11806d.isCaptured(type)) {
                int iM758h = C1563b.m758h(iM9999b);
                if (iM758h == 1) {
                    return new C12016y0(EnumC11935j1.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                }
                if (iM758h == 2) {
                    throw new a("Out-projection in in-position");
                }
            }
            InterfaceC11933j customTypeVariable = C12006t0.getCustomTypeVariable(type);
            if (c12016y0.isStarProjection()) {
                return c12016y0;
            }
            AbstractC11913c0 abstractC11913c0SubstitutionResult = customTypeVariable != null ? customTypeVariable.substitutionResult(c12016y0.getType()) : C11920e1.makeNullableIfNeeded(c12016y0.getType(), type.isMarkedNullable());
            if (!type.getAnnotations().isEmpty()) {
                InterfaceC11344g interfaceC11344gFilterAnnotations = this.f24746b.filterAnnotations(type.getAnnotations());
                if (interfaceC11344gFilterAnnotations == null) {
                    m9998a(31);
                    throw null;
                }
                if (interfaceC11344gFilterAnnotations.hasAnnotation(C11291k.a.f22510G)) {
                    interfaceC11344gFilterAnnotations = new C11349l(interfaceC11344gFilterAnnotations, new C11911b1());
                }
                abstractC11913c0SubstitutionResult = C11992a.replaceAnnotations(abstractC11913c0SubstitutionResult, new C11348k(abstractC11913c0SubstitutionResult.getAnnotations(), interfaceC11344gFilterAnnotations));
            }
            if (iM9999b == 1) {
                projectionKind2 = combine(projectionKind2, c12016y0.getProjectionKind());
            }
            return new C12016y0(projectionKind2, abstractC11913c0SubstitutionResult);
        }
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        AbstractC11913c0 type2 = interfaceC12012w0.getType();
        EnumC11935j1 projectionKind3 = interfaceC12012w0.getProjectionKind();
        if (type2.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0) {
            return interfaceC12012w0;
        }
        AbstractC11934j0 abbreviation = C11968m0.getAbbreviation(type2);
        AbstractC11913c0 abstractC11913c0Substitute = abbreviation != null ? replaceWithNonApproximatingSubstitution().substitute(abbreviation, enumC11935j1) : null;
        List<InterfaceC11477z0> parameters = type2.getConstructor().getParameters();
        List<InterfaceC12012w0> arguments = type2.getArguments();
        ArrayList arrayList = new ArrayList(parameters.size());
        boolean z2 = false;
        for (int i3 = 0; i3 < parameters.size(); i3++) {
            InterfaceC11477z0 interfaceC11477z1 = parameters.get(i3);
            InterfaceC12012w0 interfaceC12012w1 = arguments.get(i3);
            InterfaceC12012w0 interfaceC12012w0M10001d4 = m10001d(interfaceC12012w1, interfaceC11477z1, i + 1);
            int iM758h2 = C1563b.m758h(m9999b(interfaceC11477z1.getVariance(), interfaceC12012w0M10001d4.getProjectionKind()));
            if (iM758h2 != 0) {
                if (iM758h2 == 1 || iM758h2 == 2) {
                    interfaceC12012w0M10001d4 = C11920e1.makeStarProjection(interfaceC11477z1);
                }
            } else if (interfaceC11477z1.getVariance() != enumC11935j1 && !interfaceC12012w0M10001d4.isStarProjection()) {
                interfaceC12012w0M10001d4 = new C12016y0(enumC11935j1, interfaceC12012w0M10001d4.getType());
            }
            if (interfaceC12012w0M10001d4 != interfaceC12012w1) {
                z2 = true;
            }
            arrayList.add(interfaceC12012w0M10001d4);
        }
        if (z2) {
            arguments = arrayList;
        }
        AbstractC11913c0 abstractC11913c0Replace = C11908a1.replace(type2, arguments, this.f24746b.filterAnnotations(type2.getAnnotations()));
        if ((abstractC11913c0Replace instanceof AbstractC11934j0) && (abstractC11913c0Substitute instanceof AbstractC11934j0)) {
            abstractC11913c0Replace = C11968m0.withAbbreviation((AbstractC11934j0) abstractC11913c0Replace, (AbstractC11934j0) abstractC11913c0Substitute);
        }
        return new C12016y0(projectionKind3, abstractC11913c0Replace);
    }

    public AbstractC12018z0 getSubstitution() {
        AbstractC12018z0 abstractC12018z0 = this.f24746b;
        if (abstractC12018z0 != null) {
            return abstractC12018z0;
        }
        m9998a(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.f24746b.isEmpty();
    }

    public C11914c1 replaceWithNonApproximatingSubstitution() {
        AbstractC12018z0 abstractC12018z0 = this.f24746b;
        return ((abstractC12018z0 instanceof C12017z) && abstractC12018z0.approximateContravariantCapturedTypes()) ? new C11914c1(new C12017z(((C12017z) this.f24746b).getParameters(), ((C12017z) this.f24746b).getArguments(), false)) : this;
    }

    public AbstractC11913c0 safeSubstitute(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1) {
        if (abstractC11913c0 == null) {
            m9998a(8);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9998a(9);
            throw null;
        }
        if (isEmpty()) {
            if (abstractC11913c0 != null) {
                return abstractC11913c0;
            }
            m9998a(10);
            throw null;
        }
        try {
            AbstractC11913c0 type = m10001d(new C12016y0(enumC11935j1, abstractC11913c0), null, 0).getType();
            if (type != null) {
                return type;
            }
            m9998a(11);
            throw null;
        } catch (a e) {
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(e.getMessage());
            if (abstractC11934j0CreateErrorType != null) {
                return abstractC11934j0CreateErrorType;
            }
            m9998a(12);
            throw null;
        }
    }

    public AbstractC11913c0 substitute(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1) {
        if (abstractC11913c0 == null) {
            m9998a(13);
            throw null;
        }
        if (enumC11935j1 == null) {
            m9998a(14);
            throw null;
        }
        InterfaceC12012w0 interfaceC12012w0Substitute = substitute(new C12016y0(enumC11935j1, getSubstitution().prepareTopLevelType(abstractC11913c0, enumC11935j1)));
        if (interfaceC12012w0Substitute == null) {
            return null;
        }
        return interfaceC12012w0Substitute.getType();
    }

    public InterfaceC12012w0 substituteWithoutApproximation(InterfaceC12012w0 interfaceC12012w0) {
        if (interfaceC12012w0 == null) {
            m9998a(16);
            throw null;
        }
        if (isEmpty()) {
            return interfaceC12012w0;
        }
        try {
            return m10001d(interfaceC12012w0, null, 0);
        } catch (a unused) {
            return null;
        }
    }

    public static C11914c1 create(AbstractC11913c0 abstractC11913c0) {
        if (abstractC11913c0 != null) {
            return create(AbstractC12010v0.create(abstractC11913c0.getConstructor(), abstractC11913c0.getArguments()));
        }
        m9998a(5);
        throw null;
    }

    public static EnumC11935j1 combine(EnumC11935j1 enumC11935j1, EnumC11935j1 enumC11935j2) {
        if (enumC11935j1 == null) {
            m9998a(36);
            throw null;
        }
        if (enumC11935j2 != null) {
            EnumC11935j1 enumC11935j3 = EnumC11935j1.INVARIANT;
            if (enumC11935j1 == enumC11935j3) {
                if (enumC11935j2 != null) {
                    return enumC11935j2;
                }
                m9998a(38);
                throw null;
            }
            if (enumC11935j2 == enumC11935j3) {
                if (enumC11935j1 != null) {
                    return enumC11935j1;
                }
                m9998a(39);
                throw null;
            }
            if (enumC11935j1 == enumC11935j2) {
                if (enumC11935j2 != null) {
                    return enumC11935j2;
                }
                m9998a(40);
                throw null;
            }
            throw new AssertionError("Variance conflict: type parameter variance '" + enumC11935j1 + "' and projection kind '" + enumC11935j2 + "' cannot be combined");
        }
        m9998a(37);
        throw null;
    }

    public InterfaceC12012w0 substitute(InterfaceC12012w0 interfaceC12012w0) {
        if (interfaceC12012w0 != null) {
            InterfaceC12012w0 interfaceC12012w0SubstituteWithoutApproximation = substituteWithoutApproximation(interfaceC12012w0);
            return (this.f24746b.approximateCapturedTypes() || this.f24746b.approximateContravariantCapturedTypes()) ? C11996b.approximateCapturedTypesIfNecessary(interfaceC12012w0SubstituteWithoutApproximation, this.f24746b.approximateContravariantCapturedTypes()) : interfaceC12012w0SubstituteWithoutApproximation;
        }
        m9998a(15);
        throw null;
    }
}
