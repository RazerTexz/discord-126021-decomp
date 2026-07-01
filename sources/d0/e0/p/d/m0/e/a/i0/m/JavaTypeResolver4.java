package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMapper;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.resolvers2;
import d0.e0.p.d.m0.e.a.k0.i;
import d0.e0.p.d.m0.e.a.k0.javaTypes;
import d0.e0.p.d.m0.e.a.k0.javaTypes2;
import d0.e0.p.d.m0.e.a.k0.javaTypes3;
import d0.e0.p.d.m0.e.a.k0.javaTypes4;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.SpecialTypes2;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.CollectionsJVM;
import d0.t.IndexedValue;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.d, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver4 {
    public final context4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final resolvers2 f3340b;

    public JavaTypeResolver4(context4 context4Var, resolvers2 resolvers2Var) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(resolvers2Var, "typeParameterResolver");
        this.a = context4Var;
        this.f3340b = resolvers2Var;
    }

    public static final KotlinType4 c(javaTypes3 javatypes3) {
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(Intrinsics3.stringPlus("Unresolved java class ", javatypes3.getPresentableText()));
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return kotlinType4CreateErrorType;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver4 javaTypeResolver4, javaTypes2 javatypes2, JavaTypeResolver javaTypeResolver, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return javaTypeResolver4.transformArrayType(javatypes2, javaTypeResolver, z2);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0184  */
    /* JADX WARN: Code duplicated, block: B:104:0x0192  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01da  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01fb A[LOOP:1: B:117:0x01f5->B:119:0x01fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:121:0x021b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0236  */
    /* JADX WARN: Code duplicated, block: B:126:0x025f  */
    /* JADX WARN: Code duplicated, block: B:128:0x026b  */
    /* JADX WARN: Code duplicated, block: B:129:0x026d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0271  */
    /* JADX WARN: Code duplicated, block: B:137:0x0280  */
    /* JADX WARN: Code duplicated, block: B:140:0x0284  */
    /* JADX WARN: Code duplicated, block: B:141:0x0293  */
    /* JADX WARN: Code duplicated, block: B:143:0x029b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x012b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x012c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0132  */
    /* JADX WARN: Code duplicated, block: B:76:0x0135  */
    /* JADX WARN: Code duplicated, block: B:81:0x0143  */
    /* JADX WARN: Code duplicated, block: B:84:0x0148  */
    /* JADX WARN: Code duplicated, block: B:85:0x014a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0169  */
    /* JADX WARN: Code duplicated, block: B:97:0x0173  */
    public final KotlinType4 a(javaTypes3 javatypes3, JavaTypeResolver javaTypeResolver, KotlinType4 kotlinType4) {
        TypeConstructor typeConstructor;
        TypeConstructor typeConstructor2;
        ClassDescriptor classDescriptorConvertReadOnlyToMutable;
        boolean z2;
        boolean z3;
        boolean z4;
        TypeConstructor constructor;
        boolean zIsRaw;
        boolean z5;
        List<TypeParameterDescriptor> parameters;
        ArrayList arrayList;
        List list;
        javaTypes5 javatypes5;
        TypeParameterDescriptor typeParameterDescriptor;
        TypeUsage typeUsage;
        JavaTypeResolver attributes$default;
        Variance variance;
        TypeParameterDescriptor typeParameterDescriptor2;
        TypeProjection typeProjectionImpl;
        javaTypes javatypes;
        javaTypes5 bound;
        Variance variance2;
        boolean z6;
        ArrayList arrayList2;
        Iterator<T> it;
        ArrayList arrayList3;
        JavaTypeResolver javaTypeResolverWithFlexibility;
        Variance variance3 = Variance.OUT_VARIANCE;
        TypeUsage typeUsage2 = TypeUsage.SUPERTYPE;
        JavaTypeResolver2 javaTypeResolver2 = JavaTypeResolver2.FLEXIBLE_LOWER_BOUND;
        TypeParameterDescriptor typeParameterDescriptor3 = null;
        Annotations4 annotations = kotlinType4 == null ? null : kotlinType4.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.a, javatypes3, false, 4, null);
        }
        Annotations4 annotations4 = annotations;
        i classifier = javatypes3.getClassifier();
        boolean z7 = false;
        if (classifier == null) {
            typeConstructor = b(javatypes3);
        } else {
            if (!(classifier instanceof d0.e0.p.d.m0.e.a.k0.g)) {
                if (!(classifier instanceof y)) {
                    throw new IllegalStateException(Intrinsics3.stringPlus("Unknown classifier kind: ", classifier));
                }
                TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = this.f3340b.resolveTypeParameter((y) classifier);
                if (typeParameterDescriptorResolveTypeParameter == null) {
                    typeConstructor2 = null;
                } else {
                    typeConstructor = typeParameterDescriptorResolveTypeParameter.getTypeConstructor();
                }
                if (typeConstructor2 == null) {
                    return null;
                }
                if (javaTypeResolver.getFlexibility() == javaTypeResolver2) {
                    z4 = false;
                } else {
                    if (!javaTypeResolver.isForAnnotationParameter() || javaTypeResolver.getHowThisTypeIsUsed() == typeUsage2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z4 = z3;
                }
                if (kotlinType4 == null) {
                    constructor = null;
                } else {
                    constructor = kotlinType4.getConstructor();
                }
                if (!Intrinsics3.areEqual(constructor, typeConstructor2) && !javatypes3.isRaw() && z4) {
                    return kotlinType4.makeNullableAsSpecified(true);
                }
                zIsRaw = javatypes3.isRaw();
                if (zIsRaw) {
                    if (javatypes3.getTypeArguments().isEmpty()) {
                        List<TypeParameterDescriptor> parameters2 = typeConstructor2.getParameters();
                        Intrinsics3.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                        z5 = parameters2.isEmpty() ^ true;
                    }
                }
                parameters = typeConstructor2.getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters, "constructor.parameters");
                if (z5) {
                    arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor4 : parameters) {
                        SpecialTypes2 specialTypes2 = new SpecialTypes2(this.a.getStorageManager(), new JavaTypeResolver3(typeParameterDescriptor4, javaTypeResolver, typeConstructor2));
                        RawType rawType = RawType.f3341b;
                        Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor4, "parameter");
                        if (zIsRaw) {
                            javaTypeResolverWithFlexibility = javaTypeResolver;
                        } else {
                            javaTypeResolverWithFlexibility = javaTypeResolver.withFlexibility(JavaTypeResolver2.INFLEXIBLE);
                        }
                        arrayList3.add(rawType.computeProjection(typeParameterDescriptor4, javaTypeResolverWithFlexibility, specialTypes2));
                    }
                    list = _Collections.toList(arrayList3);
                } else if (parameters.size() != javatypes3.getTypeArguments().size()) {
                    arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    it = parameters.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new TypeProjectionImpl(ErrorUtils.createErrorType(((TypeParameterDescriptor) it.next()).getName().asString())));
                    }
                    list = _Collections.toList(arrayList2);
                } else {
                    Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(javatypes3.getTypeArguments());
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10));
                    for (IndexedValue indexedValue : iterableWithIndex) {
                        int iComponent1 = indexedValue.component1();
                        javatypes5 = (javaTypes5) indexedValue.component2();
                        parameters.size();
                        typeParameterDescriptor = parameters.get(iComponent1);
                        typeUsage = TypeUsage.COMMON;
                        attributes$default = JavaTypeResolver5.toAttributes$default(typeUsage, z7, typeParameterDescriptor3, 3, typeParameterDescriptor3);
                        Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                        variance = Variance.INVARIANT;
                        if (javatypes5 instanceof javaTypes) {
                            javatypes = (javaTypes) javatypes5;
                            bound = javatypes.getBound();
                            if (javatypes.isExtends()) {
                                variance2 = variance3;
                            } else {
                                variance2 = Variance.IN_VARIANCE;
                            }
                            if (bound == null) {
                                typeParameterDescriptor2 = null;
                                typeProjectionImpl = JavaTypeResolver5.makeStarProjection(typeParameterDescriptor, attributes$default);
                            } else {
                                if (typeParameterDescriptor.getVariance() == variance && variance2 != typeParameterDescriptor.getVariance()) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    typeParameterDescriptor2 = null;
                                    typeProjectionImpl = JavaTypeResolver5.makeStarProjection(typeParameterDescriptor, attributes$default);
                                } else {
                                    typeParameterDescriptor2 = null;
                                    typeProjectionImpl = TypeUtils2.createProjection(transformJavaType(bound, JavaTypeResolver5.toAttributes$default(typeUsage, false, null, 3, null)), variance2, typeParameterDescriptor);
                                }
                            }
                        } else {
                            typeParameterDescriptor2 = null;
                            typeProjectionImpl = new TypeProjectionImpl(variance, transformJavaType(javatypes5, attributes$default));
                        }
                        arrayList.add(typeProjectionImpl);
                        typeParameterDescriptor3 = typeParameterDescriptor2;
                        z7 = false;
                    }
                    list = _Collections.toList(arrayList);
                }
                List list2 = list;
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                return KotlinTypeFactory.simpleType$default(annotations4, typeConstructor2, list2, z4, null, 16, null);
            }
            d0.e0.p.d.m0.e.a.k0.g gVar = (d0.e0.p.d.m0.e.a.k0.g) classifier;
            FqName fqName = gVar.getFqName();
            if (fqName == null) {
                throw new AssertionError(Intrinsics3.stringPlus("Class type should have a FQ name: ", classifier));
            }
            if (javaTypeResolver.isForAnnotationParameter() && Intrinsics3.areEqual(fqName, JavaTypeResolver5.a)) {
                classDescriptorConvertReadOnlyToMutable = this.a.getComponents().getReflectionTypes().getKClass();
            } else {
                JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.a;
                ClassDescriptor classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.a.getModule().getBuiltIns(), null, 4, null);
                if (classDescriptorMapJavaToKotlin$default == null) {
                    classDescriptorConvertReadOnlyToMutable = null;
                } else if (javaToKotlinClassMapper.isReadOnly(classDescriptorMapJavaToKotlin$default)) {
                    if (javaTypeResolver.getFlexibility() != javaTypeResolver2 && javaTypeResolver.getHowThisTypeIsUsed() != typeUsage2) {
                        javaTypes5 javatypes6 = (javaTypes5) _Collections.lastOrNull((List) javatypes3.getTypeArguments());
                        javaTypes javatypes2 = javatypes6 instanceof javaTypes ? (javaTypes) javatypes6 : null;
                        if ((javatypes2 == null || javatypes2.getBound() == null || javatypes2.isExtends()) ? false : true) {
                            List<TypeParameterDescriptor> parameters3 = javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default).getTypeConstructor().getParameters();
                            Intrinsics3.checkNotNullExpressionValue(parameters3, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
                            TypeParameterDescriptor typeParameterDescriptor5 = (TypeParameterDescriptor) _Collections.lastOrNull((List) parameters3);
                            Variance variance4 = typeParameterDescriptor5 == null ? null : typeParameterDescriptor5.getVariance();
                            if (variance4 == null || variance4 == variance3) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            classDescriptorConvertReadOnlyToMutable = classDescriptorMapJavaToKotlin$default;
                        }
                    }
                    classDescriptorConvertReadOnlyToMutable = javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default);
                } else {
                    classDescriptorConvertReadOnlyToMutable = classDescriptorMapJavaToKotlin$default;
                }
            }
            if (classDescriptorConvertReadOnlyToMutable == null) {
                classDescriptorConvertReadOnlyToMutable = this.a.getComponents().getModuleClassResolver().resolveClass(gVar);
            }
            typeConstructor = classDescriptorConvertReadOnlyToMutable == null ? null : classDescriptorConvertReadOnlyToMutable.getTypeConstructor();
            if (typeConstructor == null) {
                typeConstructor = b(javatypes3);
            }
        }
        typeConstructor2 = typeConstructor;
        if (typeConstructor2 == null) {
            return null;
        }
        if (javaTypeResolver.getFlexibility() == javaTypeResolver2) {
            z4 = false;
        } else {
            if (javaTypeResolver.isForAnnotationParameter()) {
                z3 = false;
            } else {
                z3 = false;
            }
            z4 = z3;
        }
        if (kotlinType4 == null) {
            constructor = null;
        } else {
            constructor = kotlinType4.getConstructor();
        }
        if (!Intrinsics3.areEqual(constructor, typeConstructor2)) {
        }
        zIsRaw = javatypes3.isRaw();
        if (zIsRaw) {
            if (javatypes3.getTypeArguments().isEmpty()) {
                List<TypeParameterDescriptor> parameters4 = typeConstructor2.getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters4, "constructor.parameters");
                if (parameters4.isEmpty() ^ true) {
                }
            }
        }
        parameters = typeConstructor2.getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "constructor.parameters");
        if (z5) {
            arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
            while (r5.hasNext()) {
                SpecialTypes2 specialTypes3 = new SpecialTypes2(this.a.getStorageManager(), new JavaTypeResolver3(typeParameterDescriptor4, javaTypeResolver, typeConstructor2));
                RawType rawType2 = RawType.f3341b;
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor4, "parameter");
                if (zIsRaw) {
                    javaTypeResolverWithFlexibility = javaTypeResolver;
                } else {
                    javaTypeResolverWithFlexibility = javaTypeResolver.withFlexibility(JavaTypeResolver2.INFLEXIBLE);
                }
                arrayList3.add(rawType2.computeProjection(typeParameterDescriptor4, javaTypeResolverWithFlexibility, specialTypes3));
            }
            list = _Collections.toList(arrayList3);
        } else if (parameters.size() != javatypes3.getTypeArguments().size()) {
            arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
            it = parameters.iterator();
            while (it.hasNext()) {
                arrayList2.add(new TypeProjectionImpl(ErrorUtils.createErrorType(((TypeParameterDescriptor) it.next()).getName().asString())));
            }
            list = _Collections.toList(arrayList2);
        } else {
            Iterable<IndexedValue> iterableWithIndex2 = _Collections.withIndex(javatypes3.getTypeArguments());
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex2, 10));
            while (r1.hasNext()) {
                int iComponent2 = indexedValue.component1();
                javatypes5 = (javaTypes5) indexedValue.component2();
                parameters.size();
                typeParameterDescriptor = parameters.get(iComponent2);
                typeUsage = TypeUsage.COMMON;
                attributes$default = JavaTypeResolver5.toAttributes$default(typeUsage, z7, typeParameterDescriptor3, 3, typeParameterDescriptor3);
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                variance = Variance.INVARIANT;
                if (javatypes5 instanceof javaTypes) {
                    javatypes = (javaTypes) javatypes5;
                    bound = javatypes.getBound();
                    if (javatypes.isExtends()) {
                        variance2 = variance3;
                    } else {
                        variance2 = Variance.IN_VARIANCE;
                    }
                    if (bound == null) {
                        typeParameterDescriptor2 = null;
                        typeProjectionImpl = JavaTypeResolver5.makeStarProjection(typeParameterDescriptor, attributes$default);
                    } else {
                        if (typeParameterDescriptor.getVariance() == variance) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z6) {
                            typeParameterDescriptor2 = null;
                            typeProjectionImpl = JavaTypeResolver5.makeStarProjection(typeParameterDescriptor, attributes$default);
                        } else {
                            typeParameterDescriptor2 = null;
                            typeProjectionImpl = TypeUtils2.createProjection(transformJavaType(bound, JavaTypeResolver5.toAttributes$default(typeUsage, false, null, 3, null)), variance2, typeParameterDescriptor);
                        }
                    }
                } else {
                    typeParameterDescriptor2 = null;
                    typeProjectionImpl = new TypeProjectionImpl(variance, transformJavaType(javatypes5, attributes$default));
                }
                arrayList.add(typeProjectionImpl);
                typeParameterDescriptor3 = typeParameterDescriptor2;
                z7 = false;
            }
            list = _Collections.toList(arrayList);
        }
        List list3 = list;
        KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
        return KotlinTypeFactory.simpleType$default(annotations4, typeConstructor2, list3, z4, null, 16, null);
    }

    public final TypeConstructor b(javaTypes3 javatypes3) {
        ClassId classId = ClassId.topLevel(new FqName(javatypes3.getClassifierQualifiedName()));
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.a.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsJVM.listOf(0)).getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    public final KotlinType transformArrayType(javaTypes2 javatypes2, JavaTypeResolver javaTypeResolver, boolean z2) {
        Variance variance = Variance.OUT_VARIANCE;
        Variance variance2 = Variance.INVARIANT;
        Intrinsics3.checkNotNullParameter(javatypes2, "arrayType");
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        javaTypes5 componentType = javatypes2.getComponentType();
        javaTypes4 javatypes4 = componentType instanceof javaTypes4 ? (javaTypes4) componentType : null;
        PrimitiveType type = javatypes4 == null ? null : javatypes4.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.a, javatypes2, true);
        if (type != null) {
            KotlinType4 primitiveArrayKotlinType = this.a.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics3.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            primitiveArrayKotlinType.replaceAnnotations(Annotations4.f.create(_Collections.plus((Iterable) lazyJavaAnnotations, (Iterable) primitiveArrayKotlinType.getAnnotations())));
            if (javaTypeResolver.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType kotlinTypeTransformJavaType = transformJavaType(componentType, JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, javaTypeResolver.isForAnnotationParameter(), null, 2, null));
        if (!javaTypeResolver.isForAnnotationParameter()) {
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
            KotlinType4 arrayType = this.a.getModule().getBuiltIns().getArrayType(variance2, kotlinTypeTransformJavaType, lazyJavaAnnotations);
            Intrinsics3.checkNotNullExpressionValue(arrayType, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
            return KotlinTypeFactory.flexibleType(arrayType, this.a.getModule().getBuiltIns().getArrayType(variance, kotlinTypeTransformJavaType, lazyJavaAnnotations).makeNullableAsSpecified(true));
        }
        if (!z2) {
            variance = variance2;
        }
        KotlinType4 arrayType2 = this.a.getModule().getBuiltIns().getArrayType(variance, kotlinTypeTransformJavaType, lazyJavaAnnotations);
        Intrinsics3.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
        return arrayType2;
    }

    public final KotlinType transformJavaType(javaTypes5 javatypes5, JavaTypeResolver javaTypeResolver) {
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        if (javatypes5 instanceof javaTypes4) {
            PrimitiveType type = ((javaTypes4) javatypes5).getType();
            KotlinType4 primitiveKotlinType = type != null ? this.a.getModule().getBuiltIns().getPrimitiveKotlinType(type) : this.a.getModule().getBuiltIns().getUnitType();
            Intrinsics3.checkNotNullExpressionValue(primitiveKotlinType, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return primitiveKotlinType;
        }
        if (!(javatypes5 instanceof javaTypes3)) {
            if (javatypes5 instanceof javaTypes2) {
                return transformArrayType$default(this, (javaTypes2) javatypes5, javaTypeResolver, false, 4, null);
            }
            if (!(javatypes5 instanceof javaTypes)) {
                if (javatypes5 != null) {
                    throw new UnsupportedOperationException(Intrinsics3.stringPlus("Unsupported type: ", javatypes5));
                }
                KotlinType4 defaultBound = this.a.getModule().getBuiltIns().getDefaultBound();
                Intrinsics3.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            }
            javaTypes5 bound = ((javaTypes) javatypes5).getBound();
            KotlinType kotlinTypeTransformJavaType = bound == null ? null : transformJavaType(bound, javaTypeResolver);
            if (kotlinTypeTransformJavaType != null) {
                return kotlinTypeTransformJavaType;
            }
            KotlinType4 defaultBound2 = this.a.getModule().getBuiltIns().getDefaultBound();
            Intrinsics3.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
            return defaultBound2;
        }
        javaTypes3 javatypes3 = (javaTypes3) javatypes5;
        boolean z2 = (javaTypeResolver.isForAnnotationParameter() || javaTypeResolver.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean zIsRaw = javatypes3.isRaw();
        if (!zIsRaw && !z2) {
            KotlinType4 kotlinType4A = a(javatypes3, javaTypeResolver, null);
            if (kotlinType4A == null) {
                kotlinType4A = c(javatypes3);
            }
            return kotlinType4A;
        }
        KotlinType4 kotlinType4A2 = a(javatypes3, javaTypeResolver.withFlexibility(JavaTypeResolver2.FLEXIBLE_LOWER_BOUND), null);
        if (kotlinType4A2 == null) {
            return c(javatypes3);
        }
        KotlinType4 kotlinType4A3 = a(javatypes3, javaTypeResolver.withFlexibility(JavaTypeResolver2.FLEXIBLE_UPPER_BOUND), kotlinType4A2);
        if (kotlinType4A3 == null) {
            return c(javatypes3);
        }
        if (zIsRaw) {
            return new RawType2(kotlinType4A2, kotlinType4A3);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.flexibleType(kotlinType4A2, kotlinType4A3);
    }
}
