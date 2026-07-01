package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations6;
import d0.e0.p.d.m0.c.g1.Annotations7;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor4;
import d0.e0.p.d.m0.n.l1.NewCapturedType2;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.n.p1.CapturedTypeApproximation2;
import d0.e0.p.d.m0.p.exceptionUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c1, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeSubstitutor2 {
    public static final TypeSubstitutor2 a = create(TypeSubstitution5.a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeSubstitution5 f3520b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.c1$a */
    /* JADX INFO: compiled from: TypeSubstitutor.java */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public TypeSubstitutor2(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            this.f3520b = typeSubstitution5;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b1  */
    public static /* synthetic */ void a(int i) {
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

    public static int b(Variance variance, Variance variance2) {
        Variance variance3 = Variance.OUT_VARIANCE;
        Variance variance4 = Variance.IN_VARIANCE;
        if (variance == variance4 && variance2 == variance3) {
            return 3;
        }
        return (variance == variance3 && variance2 == variance4) ? 2 : 1;
    }

    public static String c(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (exceptionUtils.isProcessCanceledException(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public static Variance combine(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            a(33);
            throw null;
        }
        if (typeProjection != null) {
            return typeProjection.isStarProjection() ? Variance.OUT_VARIANCE : combine(variance, typeProjection.getProjectionKind());
        }
        a(34);
        throw null;
    }

    public static TypeSubstitutor2 create(TypeSubstitution5 typeSubstitution5) {
        if (typeSubstitution5 != null) {
            return new TypeSubstitutor2(typeSubstitution5);
        }
        a(0);
        throw null;
    }

    public static TypeSubstitutor2 createChainedSubstitutor(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution6) {
        if (typeSubstitution5 == null) {
            a(2);
            throw null;
        }
        if (typeSubstitution6 != null) {
            return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution5, typeSubstitution6));
        }
        a(3);
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
    public final TypeProjection d(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor, int i) throws a {
        if (typeProjection == null) {
            a(17);
            throw null;
        }
        TypeSubstitution5 typeSubstitution5 = this.f3520b;
        if (i > 100) {
            StringBuilder sbU = outline.U("Recursion too deep. Most likely infinite loop while substituting ");
            sbU.append(c(typeProjection));
            sbU.append("; substitution: ");
            sbU.append(c(typeSubstitution5));
            throw new IllegalStateException(sbU.toString());
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            KotlinType3 origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection typeProjectionD = d(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
            return new TypeProjectionImpl(typeProjectionD.getProjectionKind(), TypeWithEnhancement2.wrapEnhancement(typeProjectionD.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        }
        if (dynamicTypes2.isDynamic(type) || (type.unwrap() instanceof RawType3)) {
            return typeProjection;
        }
        TypeProjection typeProjectionImpl = this.f3520b.get(type);
        if (typeProjectionImpl == null) {
            typeProjectionImpl = null;
        } else if (type.getAnnotations().hasAnnotation(StandardNames.a.G)) {
            TypeConstructor constructor = typeProjectionImpl.getType().getConstructor();
            if (constructor instanceof NewCapturedType2) {
                TypeProjection projection = ((NewCapturedType2) constructor).getProjection();
                Variance projectionKind = projection.getProjectionKind();
                if (b(typeProjection.getProjectionKind(), projectionKind) == 3) {
                    typeProjectionImpl = new TypeProjectionImpl(projection.getType());
                } else if (typeParameterDescriptor != null && b(typeParameterDescriptor.getVariance(), projectionKind) == 3) {
                    typeProjectionImpl = new TypeProjectionImpl(projection.getType());
                }
            }
        }
        Variance projectionKind2 = typeProjection.getProjectionKind();
        if (typeProjectionImpl == null && flexibleTypes2.isFlexible(type) && !TypeCapabilities2.isCustomTypeVariable(type)) {
            KotlinType6 kotlinType6AsFlexibleType = flexibleTypes2.asFlexibleType(type);
            int i2 = i + 1;
            TypeProjection typeProjectionD2 = d(new TypeProjectionImpl(projectionKind2, kotlinType6AsFlexibleType.getLowerBound()), typeParameterDescriptor, i2);
            TypeProjection typeProjectionD3 = d(new TypeProjectionImpl(projectionKind2, kotlinType6AsFlexibleType.getUpperBound()), typeParameterDescriptor, i2);
            return (typeProjectionD2.getType() == kotlinType6AsFlexibleType.getLowerBound() && typeProjectionD3.getType() == kotlinType6AsFlexibleType.getUpperBound()) ? typeProjection : new TypeProjectionImpl(typeProjectionD2.getProjectionKind(), KotlinTypeFactory.flexibleType(TypeSubstitution.asSimpleType(typeProjectionD2.getType()), TypeSubstitution.asSimpleType(typeProjectionD3.getType())));
        }
        if (KotlinBuiltIns.isNothing(type) || KotlinType2.isError(type)) {
            return typeProjection;
        }
        if (typeProjectionImpl != null) {
            int iB = b(projectionKind2, typeProjectionImpl.getProjectionKind());
            if (!CapturedTypeConstructor4.isCaptured(type)) {
                int iH = b.c.a.y.b.h(iB);
                if (iH == 1) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                }
                if (iH == 2) {
                    throw new a("Out-projection in in-position");
                }
            }
            TypeCapabilities customTypeVariable = TypeCapabilities2.getCustomTypeVariable(type);
            if (typeProjectionImpl.isStarProjection()) {
                return typeProjectionImpl;
            }
            KotlinType kotlinTypeSubstitutionResult = customTypeVariable != null ? customTypeVariable.substitutionResult(typeProjectionImpl.getType()) : TypeUtils.makeNullableIfNeeded(typeProjectionImpl.getType(), type.isMarkedNullable());
            if (!type.getAnnotations().isEmpty()) {
                Annotations4 annotations4FilterAnnotations = this.f3520b.filterAnnotations(type.getAnnotations());
                if (annotations4FilterAnnotations == null) {
                    a(31);
                    throw null;
                }
                if (annotations4FilterAnnotations.hasAnnotation(StandardNames.a.G)) {
                    annotations4FilterAnnotations = new Annotations7(annotations4FilterAnnotations, new TypeSubstitutor());
                }
                kotlinTypeSubstitutionResult = TypeUtils2.replaceAnnotations(kotlinTypeSubstitutionResult, new Annotations6(kotlinTypeSubstitutionResult.getAnnotations(), annotations4FilterAnnotations));
            }
            if (iB == 1) {
                projectionKind2 = combine(projectionKind2, typeProjectionImpl.getProjectionKind());
            }
            return new TypeProjectionImpl(projectionKind2, kotlinTypeSubstitutionResult);
        }
        Variance variance = Variance.INVARIANT;
        KotlinType type2 = typeProjection.getType();
        Variance projectionKind3 = typeProjection.getProjectionKind();
        if (type2.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        KotlinType4 abbreviation = SpecialTypes5.getAbbreviation(type2);
        KotlinType kotlinTypeSubstitute = abbreviation != null ? replaceWithNonApproximatingSubstitution().substitute(abbreviation, variance) : null;
        List<TypeParameterDescriptor> parameters = type2.getConstructor().getParameters();
        List<TypeProjection> arguments = type2.getArguments();
        ArrayList arrayList = new ArrayList(parameters.size());
        boolean z2 = false;
        for (int i3 = 0; i3 < parameters.size(); i3++) {
            TypeParameterDescriptor typeParameterDescriptor2 = parameters.get(i3);
            TypeProjection typeProjection2 = arguments.get(i3);
            TypeProjection typeProjectionD4 = d(typeProjection2, typeParameterDescriptor2, i + 1);
            int iH2 = b.c.a.y.b.h(b(typeParameterDescriptor2.getVariance(), typeProjectionD4.getProjectionKind()));
            if (iH2 != 0) {
                if (iH2 == 1 || iH2 == 2) {
                    typeProjectionD4 = TypeUtils.makeStarProjection(typeParameterDescriptor2);
                }
            } else if (typeParameterDescriptor2.getVariance() != variance && !typeProjectionD4.isStarProjection()) {
                typeProjectionD4 = new TypeProjectionImpl(variance, typeProjectionD4.getType());
            }
            if (typeProjectionD4 != typeProjection2) {
                z2 = true;
            }
            arrayList.add(typeProjectionD4);
        }
        if (z2) {
            arguments = arrayList;
        }
        KotlinType kotlinTypeReplace = TypeSubstitution.replace(type2, arguments, this.f3520b.filterAnnotations(type2.getAnnotations()));
        if ((kotlinTypeReplace instanceof KotlinType4) && (kotlinTypeSubstitute instanceof KotlinType4)) {
            kotlinTypeReplace = SpecialTypes5.withAbbreviation((KotlinType4) kotlinTypeReplace, (KotlinType4) kotlinTypeSubstitute);
        }
        return new TypeProjectionImpl(projectionKind3, kotlinTypeReplace);
    }

    public TypeSubstitution5 getSubstitution() {
        TypeSubstitution5 typeSubstitution5 = this.f3520b;
        if (typeSubstitution5 != null) {
            return typeSubstitution5;
        }
        a(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.f3520b.isEmpty();
    }

    public TypeSubstitutor2 replaceWithNonApproximatingSubstitution() {
        TypeSubstitution5 typeSubstitution5 = this.f3520b;
        return ((typeSubstitution5 instanceof TypeSubstitution4) && typeSubstitution5.approximateContravariantCapturedTypes()) ? new TypeSubstitutor2(new TypeSubstitution4(((TypeSubstitution4) this.f3520b).getParameters(), ((TypeSubstitution4) this.f3520b).getArguments(), false)) : this;
    }

    public KotlinType safeSubstitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            a(8);
            throw null;
        }
        if (variance == null) {
            a(9);
            throw null;
        }
        if (isEmpty()) {
            if (kotlinType != null) {
                return kotlinType;
            }
            a(10);
            throw null;
        }
        try {
            KotlinType type = d(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
            if (type != null) {
                return type;
            }
            a(11);
            throw null;
        } catch (a e) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(e.getMessage());
            if (kotlinType4CreateErrorType != null) {
                return kotlinType4CreateErrorType;
            }
            a(12);
            throw null;
        }
    }

    public KotlinType substitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            a(13);
            throw null;
        }
        if (variance == null) {
            a(14);
            throw null;
        }
        TypeProjection typeProjectionSubstitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (typeProjectionSubstitute == null) {
            return null;
        }
        return typeProjectionSubstitute.getType();
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(16);
            throw null;
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return d(typeProjection, null, 0);
        } catch (a unused) {
            return null;
        }
    }

    public static TypeSubstitutor2 create(KotlinType kotlinType) {
        if (kotlinType != null) {
            return create(TypeSubstitution3.create(kotlinType.getConstructor(), kotlinType.getArguments()));
        }
        a(5);
        throw null;
    }

    public static Variance combine(Variance variance, Variance variance2) {
        if (variance == null) {
            a(36);
            throw null;
        }
        if (variance2 != null) {
            Variance variance3 = Variance.INVARIANT;
            if (variance == variance3) {
                if (variance2 != null) {
                    return variance2;
                }
                a(38);
                throw null;
            }
            if (variance2 == variance3) {
                if (variance != null) {
                    return variance;
                }
                a(39);
                throw null;
            }
            if (variance == variance2) {
                if (variance2 != null) {
                    return variance2;
                }
                a(40);
                throw null;
            }
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
        a(37);
        throw null;
    }

    public TypeProjection substitute(TypeProjection typeProjection) {
        if (typeProjection != null) {
            TypeProjection typeProjectionSubstituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
            return (this.f3520b.approximateCapturedTypes() || this.f3520b.approximateContravariantCapturedTypes()) ? CapturedTypeApproximation2.approximateCapturedTypesIfNecessary(typeProjectionSubstituteWithoutApproximation, this.f3520b.approximateContravariantCapturedTypes()) : typeProjectionSubstituteWithoutApproximation;
        }
        a(15);
        throw null;
    }
}
