package d0.e0.p.d.m0.e.a.l0;

import d0.Tuples;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMapper;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations3;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.Annotations5;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.e.a.AnnotationQualifierApplicabilityType;
import d0.e0.p.d.m0.e.a.AnnotationQualifiersFqNames2;
import d0.e0.p.d.m0.e.a.AnnotationTypeQualifierResolver;
import d0.e0.p.d.m0.e.a.JavaTypeQualifiersByElementType;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames2;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue2;
import d0.e0.p.d.m0.e.a.h0.AnnotationDefaultValue3;
import d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaPropertyDescriptor;
import d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.h0.util3;
import d0.e0.p.d.m0.e.a.h0.util4;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.JavaDescriptorUtil;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaTypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.utils2;
import d0.e0.p.d.m0.e.a.utils4;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.e.b.methodSignatureBuildingUtils;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.w.deprecation;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.RawType3;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement {
    public final AnnotationTypeQualifierResolver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaTypeEnhancementState f3348b;
    public final typeEnhancement4 c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$a */
    /* JADX INFO: compiled from: signatureEnhancement.kt */
    public static class a {
        public final KotlinType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3349b;
        public final boolean c;

        public a(KotlinType kotlinType, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.a = kotlinType;
            this.f3349b = z2;
            this.c = z3;
        }

        public final boolean getContainsFunctionN() {
            return this.c;
        }

        public final KotlinType getType() {
            return this.a;
        }

        public final boolean getWereChanges() {
            return this.f3349b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$c */
    /* JADX INFO: compiled from: signatureEnhancement.kt */
    public static final class c extends a {
        public final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(KotlinType kotlinType, boolean z2, boolean z3, boolean z4) {
            super(kotlinType, z3, z4);
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            this.d = z2;
        }

        public final boolean getHasDefaultValue() {
            return this.d;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$d */
    /* JADX INFO: compiled from: signatureEnhancement.kt */
    public static final class d extends Lambda implements Function1<KotlinType3, Boolean> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(KotlinType3 kotlinType3) {
            return Boolean.valueOf(invoke2(kotlinType3));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "it");
            return kotlinType3 instanceof RawType3;
        }
    }

    public signatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, JavaTypeEnhancementState javaTypeEnhancementState, typeEnhancement4 typeenhancement4) {
        Intrinsics3.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics3.checkNotNullParameter(typeenhancement4, "typeEnhancement");
        this.a = annotationTypeQualifierResolver;
        this.f3348b = javaTypeEnhancementState;
        this.c = typeenhancement4;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e2  */
    public final NullabilityQualifierWithMigrationStatus a(AnnotationDescriptor annotationDescriptor, boolean z2, boolean z3) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3;
        typeQualifiers3 typequalifiers3 = typeQualifiers3.FORCE_FLEXIBILITY;
        typeQualifiers3 typequalifiers4 = typeQualifiers3.NULLABLE;
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z4 = (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || z3) && !z2;
        if (this.f3348b.getJspecifyReportLevel() != JavaTypeEnhancementState2.IGNORE) {
            boolean z5 = this.f3348b.getJspecifyReportLevel() == JavaTypeEnhancementState2.WARN;
            if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJSPECIFY_NULLABLE())) {
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers4, z5);
            } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJSPECIFY_NULLNESS_UNKNOWN())) {
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers3, z5);
            } else {
                nullabilityQualifierWithMigrationStatus = null;
            }
        } else {
            nullabilityQualifierWithMigrationStatus = null;
        }
        if (nullabilityQualifierWithMigrationStatus == null) {
            typeQualifiers3 typequalifiers5 = typeQualifiers3.NOT_NULL;
            if (JvmAnnotationNames2.getNULLABLE_ANNOTATIONS().contains(fqName)) {
                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers4, z4);
            } else {
                if (JvmAnnotationNames2.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
                    nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers5, z4);
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getJAVAX_NONNULL_ANNOTATION())) {
                    d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = DescriptorUtils2.firstArgument(annotationDescriptor);
                    d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
                    if (jVar != null) {
                        switch (jVar.getEnumEntryName().asString()) {
                            case "MAYBE":
                            case "NEVER":
                                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers4, z4);
                                break;
                            case "UNKNOWN":
                                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers3, z4);
                                break;
                            case "ALWAYS":
                                nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers5, z4);
                                break;
                            default:
                                nullabilityQualifierWithMigrationStatus = null;
                                break;
                        }
                    } else {
                        nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers5, z4);
                    }
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(typequalifiers4, z4);
                } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers5, z4);
                } else {
                    if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
                        nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers5, true);
                    } else if (Intrinsics3.areEqual(fqName, JvmAnnotationNames2.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
                        nullabilityQualifierWithMigrationStatus2 = new NullabilityQualifierWithMigrationStatus(typequalifiers4, true);
                    } else {
                        nullabilityQualifierWithMigrationStatus = null;
                    }
                    nullabilityQualifierWithMigrationStatus = nullabilityQualifierWithMigrationStatus2;
                }
                nullabilityQualifierWithMigrationStatus = nullabilityQualifierWithMigrationStatus3;
            }
            if (nullabilityQualifierWithMigrationStatus == null) {
                return null;
            }
        }
        return (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && (annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, null, true, 1, null) : nullabilityQualifierWithMigrationStatus;
    }

    public final b b(CallableMemberDescriptor callableMemberDescriptor, Annotations3 annotations3, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        KotlinType kotlinTypeInvoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            Intrinsics3.checkNotNullExpressionValue(callableMemberDescriptor2, "it");
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return new b(annotations3, kotlinTypeInvoke, arrayList, z2, context.copyWithNewDefaultTypeQualifiers(context4Var, function1.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, 64, null);
    }

    public final b c(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, context4 context4Var, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        context4 context4VarCopyWithNewDefaultTypeQualifiers;
        return b(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, valueParameterDescriptor.getAnnotations())) == null) ? context4Var : context4VarCopyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    /* JADX WARN: Code duplicated, block: B:126:0x022b  */
    /* JADX WARN: Code duplicated, block: B:146:0x026a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x026c  */
    /* JADX WARN: Code duplicated, block: B:148:0x027a  */
    /* JADX WARN: Code duplicated, block: B:150:0x027d  */
    /* JADX WARN: Code duplicated, block: B:151:0x027f  */
    /* JADX WARN: Code duplicated, block: B:155:0x0298 A[LOOP:4: B:153:0x0292->B:155:0x0298, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x007f  */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(context4 context4Var, Collection<? extends D> collection) {
        CallableMemberDescriptor callableMemberDescriptor;
        a aVarEnhance$default;
        boolean z2;
        Tuples2<CallableDescriptor.a<?>, ?> tuples2;
        KotlinType type;
        ArrayList arrayList;
        boolean z3;
        boolean z4;
        KotlinType type2;
        boolean zDeclaresDefaultValue;
        List<predefinedEnhancementInfo4> parametersInfo;
        String strSignature;
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(collection, "platformSignatures");
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            CallableMemberDescriptor callableMemberDescriptorEnhance = (CallableMemberDescriptor) it.next();
            if (callableMemberDescriptorEnhance instanceof JavaCallableMemberDescriptor) {
                JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) callableMemberDescriptorEnhance;
                if (javaCallableMemberDescriptor.getKind() != CallableMemberDescriptor.a.FAKE_OVERRIDE || javaCallableMemberDescriptor.getOriginal().getOverriddenDescriptors().size() != 1) {
                    context4 context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, callableMemberDescriptorEnhance.getAnnotations());
                    predefinedEnhancementInfo4 predefinedenhancementinfo4 = null;
                    if (callableMemberDescriptorEnhance instanceof JavaPropertyDescriptor) {
                        JavaPropertyDescriptor javaPropertyDescriptor = (JavaPropertyDescriptor) callableMemberDescriptorEnhance;
                        PropertyGetterDescriptorImpl getter = javaPropertyDescriptor.getGetter();
                        if (Intrinsics3.areEqual(getter == null ? null : Boolean.valueOf(getter.isDefault()), Boolean.FALSE)) {
                            PropertyGetterDescriptorImpl getter2 = javaPropertyDescriptor.getGetter();
                            Intrinsics3.checkNotNull(getter2);
                            callableMemberDescriptor = getter2;
                        } else {
                            callableMemberDescriptor = callableMemberDescriptorEnhance;
                        }
                    } else {
                        callableMemberDescriptor = callableMemberDescriptorEnhance;
                    }
                    JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) callableMemberDescriptorEnhance;
                    if (javaCallableMemberDescriptor2.getExtensionReceiverParameter() != null) {
                        FunctionDescriptor functionDescriptor = (FunctionDescriptor) (!(callableMemberDescriptor instanceof FunctionDescriptor) ? null : callableMemberDescriptor);
                        aVarEnhance$default = b.enhance$default(c(callableMemberDescriptorEnhance, functionDescriptor == null ? null : (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.M), context4VarCopyWithNewDefaultTypeQualifiers, signatureEnhancement3.j), null, 1, null);
                    } else {
                        aVarEnhance$default = null;
                    }
                    JavaMethodDescriptor javaMethodDescriptor = callableMemberDescriptorEnhance instanceof JavaMethodDescriptor ? (JavaMethodDescriptor) callableMemberDescriptorEnhance : null;
                    predefinedEnhancementInfo2 predefinedenhancementinfo2 = (javaMethodDescriptor == null || (strSignature = methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, (ClassDescriptor) javaMethodDescriptor.getContainingDeclaration(), methodSignatureMapping3.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null))) == null) ? null : predefinedEnhancementInfo.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature);
                    if (predefinedenhancementinfo2 != null) {
                        predefinedenhancementinfo2.getParametersInfo().size();
                        javaCallableMemberDescriptor2.getValueParameters().size();
                    }
                    List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters, "annotationOwnerForMember.valueParameters");
                    ArrayList<c> arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters, 10));
                    for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                        a aVarEnhance = c(callableMemberDescriptorEnhance, valueParameterDescriptor, context4VarCopyWithNewDefaultTypeQualifiers, new signatureEnhancement5(valueParameterDescriptor)).enhance((predefinedenhancementinfo2 == null || (parametersInfo = predefinedenhancementinfo2.getParametersInfo()) == null) ? predefinedenhancementinfo4 : (predefinedEnhancementInfo4) _Collections.getOrNull(parametersInfo, valueParameterDescriptor.getIndex()));
                        if (aVarEnhance.getWereChanges()) {
                            type2 = aVarEnhance.getType();
                        } else {
                            type2 = valueParameterDescriptor.getType();
                            Intrinsics3.checkNotNullExpressionValue(type2, "p.type");
                        }
                        Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "p");
                        AnnotationDefaultValue defaultValueFromAnnotation = util3.getDefaultValueFromAnnotation(valueParameterDescriptor);
                        if (defaultValueFromAnnotation instanceof AnnotationDefaultValue3) {
                            zDeclaresDefaultValue = utils2.lexicalCastFrom(type2, ((AnnotationDefaultValue3) defaultValueFromAnnotation).getValue()) != null;
                        } else if (Intrinsics3.areEqual(defaultValueFromAnnotation, AnnotationDefaultValue2.a)) {
                            zDeclaresDefaultValue = TypeUtils.acceptsNullable(type2);
                        } else {
                            if (defaultValueFromAnnotation != null) {
                                throw new NoWhenBranchMatchedException();
                            }
                            zDeclaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
                        }
                        boolean z5 = zDeclaresDefaultValue && valueParameterDescriptor.getOverriddenDescriptors().isEmpty();
                        arrayList3.add(new c(aVarEnhance.getType(), z5, aVarEnhance.getWereChanges() || z5 != valueParameterDescriptor.declaresDefaultValue(), aVarEnhance.getContainsFunctionN()));
                        predefinedenhancementinfo4 = null;
                    }
                    PropertyDescriptor propertyDescriptor = (PropertyDescriptor) (!(callableMemberDescriptorEnhance instanceof PropertyDescriptor) ? null : callableMemberDescriptorEnhance);
                    Boolean boolValueOf = propertyDescriptor == null ? null : Boolean.valueOf(JavaDescriptorUtil.isJavaField(propertyDescriptor));
                    Boolean bool = Boolean.TRUE;
                    a aVarEnhance2 = b(callableMemberDescriptorEnhance, callableMemberDescriptor, true, context4VarCopyWithNewDefaultTypeQualifiers, Intrinsics3.areEqual(boolValueOf, bool) ? AnnotationQualifierApplicabilityType.FIELD : AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, signatureEnhancement4.j).enhance(predefinedenhancementinfo2 == null ? null : predefinedenhancementinfo2.getReturnTypeInfo());
                    if (Intrinsics3.areEqual(aVarEnhance$default == null ? null : Boolean.valueOf(aVarEnhance$default.getContainsFunctionN()), bool) || aVarEnhance2.getContainsFunctionN()) {
                        z2 = true;
                    } else {
                        if (arrayList3.isEmpty()) {
                            z4 = false;
                            break;
                        }
                        Iterator it2 = arrayList3.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z4 = false;
                                break;
                            }
                            if (((c) it2.next()).getContainsFunctionN()) {
                                z4 = true;
                                break;
                            }
                        }
                        if (z4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (Intrinsics3.areEqual(aVarEnhance$default == null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE) || aVarEnhance2.getWereChanges()) {
                        if (z2) {
                            tuples2 = Tuples.to(deprecation.getDEPRECATED_FUNCTION_KEY(), new utils4(callableMemberDescriptorEnhance));
                        } else {
                            tuples2 = null;
                        }
                        if (aVarEnhance$default == null) {
                            type = null;
                        } else {
                            type = aVarEnhance$default.getType();
                        }
                        arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                        for (c cVar : arrayList3) {
                            arrayList.add(new util4(cVar.getType(), cVar.getHasDefaultValue()));
                        }
                        callableMemberDescriptorEnhance = javaCallableMemberDescriptor2.enhance(type, arrayList, aVarEnhance2.getType(), tuples2);
                    } else {
                        if (arrayList3.isEmpty()) {
                            z3 = false;
                            break;
                        }
                        Iterator it3 = arrayList3.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (((c) it3.next()).getWereChanges()) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3 || z2) {
                            if (z2) {
                                tuples2 = Tuples.to(deprecation.getDEPRECATED_FUNCTION_KEY(), new utils4(callableMemberDescriptorEnhance));
                            } else {
                                tuples2 = null;
                            }
                            if (aVarEnhance$default == null) {
                                type = null;
                            } else {
                                type = aVarEnhance$default.getType();
                            }
                            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
                            while (r3.hasNext()) {
                                arrayList.add(new util4(cVar.getType(), cVar.getHasDefaultValue()));
                            }
                            callableMemberDescriptorEnhance = javaCallableMemberDescriptor2.enhance(type, arrayList, aVarEnhance2.getType(), tuples2);
                        }
                    }
                }
            }
            arrayList2.add(callableMemberDescriptorEnhance);
        }
        return arrayList2;
    }

    public final KotlinType enhanceSuperType(KotlinType kotlinType, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        Intrinsics3.checkNotNullParameter(context4Var, "context");
        return b.enhance$default(new b(null, kotlinType, Collections2.emptyList(), false, context4Var, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameterDescriptor, List<? extends KotlinType> list, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics3.checkNotNullParameter(list, "bounds");
        Intrinsics3.checkNotNullParameter(context4Var, "context");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (KotlinType type : list) {
            if (!TypeUtils2.contains(type, d.j)) {
                type = b.enhance$default(new b(this, typeParameterDescriptor, type, Collections2.emptyList(), false, context4Var, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(type);
        }
        return arrayList;
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor, boolean z2, boolean z3) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusA;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusA2 = a(annotationDescriptor, z2, z3);
        if (nullabilityQualifierWithMigrationStatusA2 != null) {
            return nullabilityQualifierWithMigrationStatusA2;
        }
        AnnotationDescriptor annotationDescriptorResolveTypeQualifierAnnotation = this.a.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (annotationDescriptorResolveTypeQualifierAnnotation == null) {
            return null;
        }
        JavaTypeEnhancementState2 javaTypeEnhancementState2ResolveJsr305AnnotationState = this.a.resolveJsr305AnnotationState(annotationDescriptor);
        if (javaTypeEnhancementState2ResolveJsr305AnnotationState.isIgnore() || (nullabilityQualifierWithMigrationStatusA = a(annotationDescriptorResolveTypeQualifierAnnotation, z2, z3)) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatusA, null, javaTypeEnhancementState2ResolveJsr305AnnotationState.isWarning(), 1, null);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$b */
    /* JADX INFO: compiled from: signatureEnhancement.kt */
    public final class b {
        public final Annotations3 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KotlinType f3350b;
        public final Collection<KotlinType> c;
        public final boolean d;
        public final context4 e;
        public final AnnotationQualifierApplicabilityType f;
        public final boolean g;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$b$a */
        /* JADX INFO: compiled from: signatureEnhancement.kt */
        public static final class a extends Lambda implements Function1<KotlinType3, Boolean> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(KotlinType3 kotlinType3) {
                ClassifierDescriptor declarationDescriptor = kotlinType3.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    return Boolean.FALSE;
                }
                Name name = declarationDescriptor.getName();
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.a;
                return Boolean.valueOf(Intrinsics3.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics3.areEqual(DescriptorUtils2.fqNameOrNull(declarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.l$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: signatureEnhancement.kt */
        public static final class C0386b extends Lambda implements Function1<Integer, typeQualifiers> {
            public final /* synthetic */ predefinedEnhancementInfo4 $predefined;
            public final /* synthetic */ Function1<Integer, typeQualifiers> $qualifiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0386b(predefinedEnhancementInfo4 predefinedenhancementinfo4, Function1<? super Integer, typeQualifiers> function1) {
                super(1);
                this.$predefined = predefinedenhancementinfo4;
                this.$qualifiers = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ typeQualifiers invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final typeQualifiers invoke(int i) {
                typeQualifiers typequalifiers = this.$predefined.getMap().get(Integer.valueOf(i));
                return typequalifiers == null ? this.$qualifiers.invoke(Integer.valueOf(i)) : typequalifiers;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(signatureEnhancement signatureenhancement, Annotations3 annotations3, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z3) {
            Intrinsics3.checkNotNullParameter(signatureenhancement, "this$0");
            Intrinsics3.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics3.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics3.checkNotNullParameter(context4Var, "containerContext");
            Intrinsics3.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
            signatureEnhancement.this = signatureenhancement;
            this.a = annotations3;
            this.f3350b = kotlinType;
            this.c = collection;
            this.d = z2;
            this.e = context4Var;
            this.f = annotationQualifierApplicabilityType;
            this.g = z3;
        }

        public static final <T> T c(List<FqName> list, Annotations4 annotations4, T t) {
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (annotations4.findAnnotation((FqName) it.next()) != null) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                return t;
            }
            return null;
        }

        public static final void d(b bVar, ArrayList<signatureEnhancement7> arrayList, KotlinType kotlinType, context4 context4Var, TypeParameterDescriptor typeParameterDescriptor) {
            context4 context4VarCopyWithNewDefaultTypeQualifiers = context.copyWithNewDefaultTypeQualifiers(context4Var, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = context4VarCopyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(bVar.g ? AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS : AnnotationQualifierApplicabilityType.TYPE_USE);
            arrayList.add(new signatureEnhancement7(kotlinType, annotationQualifiersFqNames2, typeParameterDescriptor, false));
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
            for (Tuples2 tuples2 : _Collections.zip(arguments, parameters)) {
                TypeProjection typeProjection = (TypeProjection) tuples2.component1();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) tuples2.component2();
                if (typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "arg.type");
                    arrayList.add(new signatureEnhancement7(type, annotationQualifiersFqNames2, typeParameterDescriptor2, true));
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type2, "arg.type");
                    d(bVar, arrayList, type2, context4VarCopyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                }
            }
        }

        public static /* synthetic */ a enhance$default(b bVar, predefinedEnhancementInfo4 predefinedenhancementinfo4, int i, Object obj) {
            if ((i & 1) != 0) {
                predefinedenhancementinfo4 = null;
            }
            return bVar.enhance(predefinedenhancementinfo4);
        }

        public final typeQualifiers3 a(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z2;
            boolean z3;
            if (!(typeParameterDescriptor instanceof LazyJavaTypeParameterDescriptor)) {
                return null;
            }
            LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) typeParameterDescriptor;
            List<KotlinType> upperBounds = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
            boolean z4 = false;
            if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                Iterator<T> it = upperBounds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = true;
                        break;
                    }
                    if (!KotlinType2.isError((KotlinType) it.next())) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = true;
                break;
            }
            if (z2) {
                return null;
            }
            List<KotlinType> upperBounds2 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds2, "upperBounds");
            if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                Iterator<T> it2 = upperBounds2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = true;
                        break;
                    }
                    if (!signatureEnhancement6.access$isNullabilityFlexible((KotlinType) it2.next())) {
                        z3 = false;
                        break;
                    }
                }
            } else {
                z3 = true;
                break;
            }
            if (z3) {
                return null;
            }
            List<KotlinType> upperBounds3 = lazyJavaTypeParameterDescriptor.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                for (KotlinType kotlinType : upperBounds3) {
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
                    if (!KotlinType2.isNullable(kotlinType)) {
                        z4 = true;
                        break;
                    }
                }
            }
            return z4 ? typeQualifiers3.NOT_NULL : typeQualifiers3.NULLABLE;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0048  */
        /* JADX WARN: Code duplicated, block: B:17:0x004b  */
        /* JADX WARN: Code duplicated, block: B:19:0x0051  */
        /* JADX WARN: Code duplicated, block: B:20:0x0054  */
        public final typeQualifiers b(KotlinType kotlinType) {
            Tuples2 tuples2;
            typeQualifiers3 typequalifiers3;
            typeQualifiers3 typequalifiers4;
            typeQualifiers2 typequalifiers2;
            if (flexibleTypes2.isFlexible(kotlinType)) {
                KotlinType6 kotlinType6AsFlexibleType = flexibleTypes2.asFlexibleType(kotlinType);
                tuples2 = new Tuples2(kotlinType6AsFlexibleType.getLowerBound(), kotlinType6AsFlexibleType.getUpperBound());
            } else {
                tuples2 = new Tuples2(kotlinType, kotlinType);
            }
            KotlinType kotlinType2 = (KotlinType) tuples2.component1();
            KotlinType kotlinType3 = (KotlinType) tuples2.component2();
            JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.a;
            if (!kotlinType2.isMarkedNullable()) {
                if (kotlinType3.isMarkedNullable()) {
                    typequalifiers3 = null;
                } else {
                    typequalifiers4 = typeQualifiers3.NOT_NULL;
                }
                if (javaToKotlinClassMapper.isReadOnly(kotlinType2)) {
                    typequalifiers2 = typeQualifiers2.READ_ONLY;
                } else if (javaToKotlinClassMapper.isMutable(kotlinType3)) {
                    typequalifiers2 = typeQualifiers2.MUTABLE;
                } else {
                    typequalifiers2 = null;
                }
                return new typeQualifiers(typequalifiers3, typequalifiers2, kotlinType.unwrap() instanceof typeEnhancement5, false, 8, null);
            }
            typequalifiers4 = typeQualifiers3.NULLABLE;
            typequalifiers3 = typequalifiers4;
            if (javaToKotlinClassMapper.isReadOnly(kotlinType2)) {
                typequalifiers2 = typeQualifiers2.READ_ONLY;
            } else if (javaToKotlinClassMapper.isMutable(kotlinType3)) {
                typequalifiers2 = typeQualifiers2.MUTABLE;
            } else {
                typequalifiers2 = null;
            }
            return new typeQualifiers(typequalifiers3, typequalifiers2, kotlinType.unwrap() instanceof typeEnhancement5, false, 8, null);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0227  */
        /* JADX WARN: Code duplicated, block: B:107:0x0236  */
        /* JADX WARN: Code duplicated, block: B:110:0x023a  */
        /* JADX WARN: Code duplicated, block: B:113:0x0247  */
        /* JADX WARN: Code duplicated, block: B:114:0x024a  */
        /* JADX WARN: Code duplicated, block: B:116:0x024d  */
        /* JADX WARN: Code duplicated, block: B:117:0x024f  */
        /* JADX WARN: Code duplicated, block: B:119:0x0255  */
        /* JADX WARN: Code duplicated, block: B:120:0x0264  */
        /* JADX WARN: Code duplicated, block: B:122:0x0276  */
        /* JADX WARN: Code duplicated, block: B:123:0x0278  */
        /* JADX WARN: Code duplicated, block: B:128:0x029f  */
        /* JADX WARN: Code duplicated, block: B:136:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:138:0x02b7  */
        /* JADX WARN: Code duplicated, block: B:139:0x02b9  */
        /* JADX WARN: Code duplicated, block: B:143:0x02c2  */
        /* JADX WARN: Code duplicated, block: B:146:0x02d4  */
        /* JADX WARN: Code duplicated, block: B:147:0x02d6  */
        /* JADX WARN: Code duplicated, block: B:149:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:150:0x02df A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:151:0x02e1  */
        /* JADX WARN: Code duplicated, block: B:152:0x02ec  */
        /* JADX WARN: Code duplicated, block: B:155:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:157:0x02fa A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:158:0x02fc  */
        /* JADX WARN: Code duplicated, block: B:159:0x02fe A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:161:0x0304  */
        /* JADX WARN: Code duplicated, block: B:163:0x030a  */
        /* JADX WARN: Code duplicated, block: B:165:0x030e  */
        /* JADX WARN: Code duplicated, block: B:168:0x0315  */
        /* JADX WARN: Code duplicated, block: B:169:0x0317 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:170:0x0319  */
        /* JADX WARN: Code duplicated, block: B:171:0x031b  */
        /* JADX WARN: Code duplicated, block: B:175:0x032c  */
        /* JADX WARN: Code duplicated, block: B:176:0x032e  */
        /* JADX WARN: Code duplicated, block: B:179:0x0333  */
        /* JADX WARN: Code duplicated, block: B:180:0x0335  */
        /* JADX WARN: Code duplicated, block: B:188:0x035a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:190:0x035d  */
        /* JADX WARN: Code duplicated, block: B:196:0x036a  */
        /* JADX WARN: Code duplicated, block: B:198:0x036d  */
        /* JADX WARN: Code duplicated, block: B:199:0x036f  */
        /* JADX WARN: Code duplicated, block: B:202:0x0388  */
        /* JADX WARN: Code duplicated, block: B:203:0x038a  */
        /* JADX WARN: Code duplicated, block: B:205:0x038d  */
        /* JADX WARN: Code duplicated, block: B:206:0x038f  */
        /* JADX WARN: Code duplicated, block: B:211:0x03a1  */
        /* JADX WARN: Code duplicated, block: B:215:0x03ab  */
        /* JADX WARN: Code duplicated, block: B:217:0x03b1  */
        /* JADX WARN: Code duplicated, block: B:220:0x03b6  */
        /* JADX WARN: Code duplicated, block: B:221:0x03b8  */
        /* JADX WARN: Code duplicated, block: B:223:0x03be  */
        /* JADX WARN: Code duplicated, block: B:224:0x03c0  */
        /* JADX WARN: Code duplicated, block: B:229:0x03c9  */
        /* JADX WARN: Code duplicated, block: B:22:0x0070  */
        /* JADX WARN: Code duplicated, block: B:232:0x03cd  */
        /* JADX WARN: Code duplicated, block: B:235:0x03dc  */
        /* JADX WARN: Code duplicated, block: B:238:0x03e5  */
        /* JADX WARN: Code duplicated, block: B:239:0x03e7  */
        /* JADX WARN: Code duplicated, block: B:243:0x03f0  */
        /* JADX WARN: Code duplicated, block: B:246:0x03f7  */
        /* JADX WARN: Code duplicated, block: B:249:0x0401  */
        /* JADX WARN: Code duplicated, block: B:252:0x040f A[EDGE_INSN: B:252:0x040f->B:253:0x0410 BREAK  A[LOOP:9: B:247:0x03fb->B:307:?]] */
        /* JADX WARN: Code duplicated, block: B:255:0x0413  */
        /* JADX WARN: Code duplicated, block: B:256:0x0415  */
        /* JADX WARN: Code duplicated, block: B:258:0x0418 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:260:0x0424 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:261:0x0426  */
        /* JADX WARN: Code duplicated, block: B:262:0x0428  */
        /* JADX WARN: Code duplicated, block: B:303:0x02ac A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:305:0x040f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:306:0x040d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:307:? A[LOOP:9: B:247:0x03fb->B:307:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:0x0211  */
        /* JADX WARN: Code duplicated, block: B:96:0x0219  */
        /* JADX WARN: Code duplicated, block: B:97:0x021b  */
        /* JADX WARN: Code duplicated, block: B:98:0x0222  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18, types: [d0.e0.p.d.m0.e.a.l0.e] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v49 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r4v4, types: [d0.e0.p.d.m0.e.a.l0.d] */
        /* JADX WARN: Type inference failed for: r6v3, types: [d0.e0.p.d.m0.e.a.l0.l$a] */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v5 */
        public final a enhance(predefinedEnhancementInfo4 predefinedenhancementinfo4) {
            Object obj;
            boolean z2;
            a aVar;
            ?? r6;
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2;
            Annotations4 annotations;
            Annotations3 annotations3;
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames3;
            ClassifierDescriptor declarationDescriptor;
            TypeParameterDescriptor typeParameterDescriptor;
            typeQualifiers3 typequalifiers3A;
            boolean z3;
            Tuples2 tuples2;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
            boolean zBooleanValue;
            boolean z4;
            signatureEnhancement signatureenhancement;
            Iterator<AnnotationDescriptor> it;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
            typeQualifiers3 typequalifiers3;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3;
            Object objValueOf;
            boolean z5;
            typeQualifiers typequalifiers;
            typeQualifiers3 qualifier;
            Object objC;
            Object objC2;
            boolean z6;
            Object objValueOf2;
            ?? r1;
            typeQualifiers3 nullability;
            typeQualifiers3 nullability2;
            boolean z7;
            typeQualifiers3 typequalifiers3Select;
            typeQualifiers2 typequalifiers2;
            Set set;
            boolean z8;
            boolean z9;
            boolean z10;
            typeQualifiers typequalifiersCreateJavaTypeQualifiers;
            boolean z11;
            Iterator it2;
            Object obj2;
            ValueParameterDescriptor valueParameterDescriptor;
            Object varargElementType;
            boolean z12;
            boolean z13;
            typeQualifiers3 typequalifiers3A2;
            typeQualifiers3 qualifier2;
            typeQualifiers3 typequalifiers4;
            NullabilityQualifierWithMigrationStatus nullabilityQualifier;
            boolean z14;
            JavaTypeQualifiersByElementType defaultTypeQualifiers;
            boolean z15;
            Collection<KotlinType> collection = this.c;
            int i = 10;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
            Iterator it3 = collection.iterator();
            while (true) {
                obj = null;
                if (!it3.hasNext()) {
                    break;
                }
                KotlinType kotlinType = (KotlinType) it3.next();
                ArrayList arrayList2 = new ArrayList(1);
                d(this, arrayList2, kotlinType, this.e, null);
                arrayList.add(arrayList2);
            }
            KotlinType kotlinType2 = this.f3350b;
            ArrayList arrayList3 = new ArrayList(1);
            d(this, arrayList3, kotlinType2, this.e, null);
            if (this.d) {
                Collection<KotlinType> collection2 = this.c;
                if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                    Iterator it4 = collection2.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z15 = false;
                            break;
                        }
                        if (!KotlinTypeChecker.a.equalTypes((KotlinType) it4.next(), this.f3350b)) {
                            z15 = true;
                            break;
                        }
                    }
                } else {
                    z15 = false;
                    break;
                }
                if (z15) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            int size = z2 ? 1 : arrayList3.size();
            typeQualifiers[] typequalifiersArr = new typeQualifiers[size];
            int i2 = 0;
            while (i2 < size) {
                boolean z16 = i2 == 0;
                signatureEnhancement7 signatureenhancement7 = (signatureEnhancement7) arrayList3.get(i2);
                KotlinType kotlinTypeComponent1 = signatureenhancement7.component1();
                AnnotationQualifiersFqNames2 annotationQualifiersFqNames2Component2 = signatureenhancement7.component2();
                TypeParameterDescriptor typeParameterDescriptorComponent3 = signatureenhancement7.component3();
                boolean zComponent4 = signatureenhancement7.component4();
                ArrayList arrayList4 = new ArrayList();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    signatureEnhancement7 signatureenhancement8 = (signatureEnhancement7) _Collections.getOrNull((List) it5.next(), i2);
                    Object type = signatureenhancement8 == null ? obj : signatureenhancement8.getType();
                    if (type != null) {
                        arrayList4.add(type);
                    }
                }
                typeQualifiers3 typequalifiers5 = typeQualifiers3.NULLABLE;
                int i3 = size;
                ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, i));
                Iterator it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    arrayList5.add(b((KotlinType) it6.next()));
                }
                ArrayList arrayList6 = new ArrayList();
                Iterator it7 = arrayList5.iterator();
                while (it7.hasNext()) {
                    ArrayList arrayList7 = arrayList;
                    typeQualifiers2 mutability = ((typeQualifiers) it7.next()).getMutability();
                    if (mutability != null) {
                        arrayList6.add(mutability);
                    }
                    arrayList = arrayList7;
                }
                ArrayList arrayList8 = arrayList;
                Set set2 = _Collections.toSet(arrayList6);
                ArrayList arrayList9 = new ArrayList();
                Iterator it8 = arrayList5.iterator();
                while (it8.hasNext()) {
                    Iterator it9 = it8;
                    typeQualifiers3 nullability3 = ((typeQualifiers) it8.next()).getNullability();
                    if (nullability3 != null) {
                        arrayList9.add(nullability3);
                    }
                    it8 = it9;
                }
                Set set3 = _Collections.toSet(arrayList9);
                ArrayList arrayList10 = new ArrayList();
                Iterator it10 = arrayList4.iterator();
                while (it10.hasNext()) {
                    ArrayList arrayList11 = arrayList3;
                    typeQualifiers3 nullability4 = b(TypeWithEnhancement2.unwrapEnhancement((KotlinType) it10.next())).getNullability();
                    if (nullability4 != null) {
                        arrayList10.add(nullability4);
                    }
                    arrayList3 = arrayList11;
                }
                ArrayList arrayList12 = arrayList3;
                Set set4 = _Collections.toSet(arrayList10);
                typeQualifiers3 typequalifiers6 = typeQualifiers3.NOT_NULL;
                boolean typeEnhancementImprovements = this.e.getComponents().getSettings().getTypeEnhancementImprovements();
                if (z16) {
                    annotationQualifiersFqNames2 = annotationQualifiersFqNames2Component2;
                    Annotations3 annotations4 = this.a;
                    if (annotations4 != null && !(annotations4 instanceof TypeParameterDescriptor) && typeEnhancementImprovements) {
                        Annotations4 annotations2 = annotations4.getAnnotations();
                        signatureEnhancement signatureenhancement2 = signatureEnhancement.this;
                        typequalifiersArr = typequalifiersArr;
                        ArrayList arrayList13 = new ArrayList();
                        Iterator<AnnotationDescriptor> it11 = annotations2.iterator();
                        while (it11.hasNext()) {
                            int i4 = i2;
                            AnnotationDescriptor next = it11.next();
                            Iterator<AnnotationDescriptor> it12 = it11;
                            ArrayList arrayList14 = arrayList5;
                            AnnotationTypeQualifierResolver.a aVarResolveAnnotation = signatureenhancement2.a.resolveAnnotation(next);
                            if ((aVarResolveAnnotation == null || aVarResolveAnnotation.component2().contains(AnnotationQualifierApplicabilityType.TYPE_USE)) ? false : true) {
                                arrayList13.add(next);
                            }
                            i2 = i4;
                            it11 = it12;
                            arrayList5 = arrayList14;
                        }
                        arrayList5 = arrayList5;
                        i2 = i2;
                        annotations = Annotations5.composeAnnotations(Annotations4.f.create(arrayList13), kotlinTypeComponent1.getAnnotations());
                    }
                    if (z16) {
                        defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                        if (defaultTypeQualifiers == null) {
                            annotationQualifiersFqNames3 = null;
                        } else {
                            annotationQualifiersFqNames3 = defaultTypeQualifiers.get(this.f);
                        }
                    } else {
                        annotationQualifiersFqNames3 = annotationQualifiersFqNames2;
                    }
                    if (annotationQualifiersFqNames3 != null) {
                        if (annotationQualifiersFqNames3.getAffectsTypeParameterBasedTypes() && TypeUtils2.isTypeParameter(kotlinTypeComponent1)) {
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        if (!z14) {
                            annotationQualifiersFqNames3 = null;
                        }
                    } else {
                        annotationQualifiersFqNames3 = null;
                    }
                    declarationDescriptor = kotlinTypeComponent1.getConstructor().getDeclarationDescriptor();
                    if (declarationDescriptor instanceof TypeParameterDescriptor) {
                        typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
                    } else {
                        typeParameterDescriptor = null;
                    }
                    if (typeParameterDescriptor == null) {
                        typequalifiers3A = null;
                    } else {
                        typequalifiers3A = a(typeParameterDescriptor);
                    }
                    if (typequalifiers3A == null) {
                        tuples2 = new Tuples2(null, Boolean.FALSE);
                    } else {
                        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus4 = new NullabilityQualifierWithMigrationStatus(typequalifiers6, false, 2, null);
                        if (typequalifiers3A == typequalifiers6) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        tuples2 = new Tuples2(nullabilityQualifierWithMigrationStatus4, Boolean.valueOf(z3));
                    }
                    nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) tuples2.component1();
                    zBooleanValue = ((Boolean) tuples2.component2()).booleanValue();
                    z4 = this.g;
                    signatureenhancement = signatureEnhancement.this;
                    it = annotations.iterator();
                    do {
                        if (it.hasNext()) {
                            nullabilityQualifierWithMigrationStatusExtractNullability = null;
                            break;
                        }
                        nullabilityQualifierWithMigrationStatusExtractNullability = signatureenhancement.extractNullability(it.next(), typeEnhancementImprovements, z4);
                    } while (nullabilityQualifierWithMigrationStatusExtractNullability == null);
                    if (nullabilityQualifierWithMigrationStatusExtractNullability == null && !zComponent4) {
                        nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatusExtractNullability;
                    } else {
                        nullabilityQualifierWithMigrationStatus2 = null;
                    }
                    if (nullabilityQualifierWithMigrationStatus2 == null) {
                        if (nullabilityQualifierWithMigrationStatus == null) {
                            if (annotationQualifiersFqNames3 == null && (nullabilityQualifier = annotationQualifiersFqNames3.getNullabilityQualifier()) != null) {
                                nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                            } else {
                                nullabilityQualifierWithMigrationStatus = null;
                            }
                        }
                        if (typeParameterDescriptorComponent3 == null) {
                            typequalifiers3A2 = null;
                        } else {
                            typequalifiers3A2 = a(typeParameterDescriptorComponent3);
                        }
                        if (typequalifiers3A2 == null) {
                            nullabilityQualifierWithMigrationStatus3 = nullabilityQualifierWithMigrationStatus;
                            typequalifiers3 = null;
                        } else if (nullabilityQualifierWithMigrationStatus == null) {
                            nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                            typequalifiers3 = null;
                        } else {
                            qualifier2 = nullabilityQualifierWithMigrationStatus.getQualifier();
                            typequalifiers4 = typeQualifiers3.FORCE_FLEXIBILITY;
                            if (typequalifiers3A2 != typequalifiers4) {
                                typequalifiers3A2 = qualifier2;
                            } else if (qualifier2 != typequalifiers4) {
                                if (typequalifiers3A2 == typequalifiers5) {
                                    typequalifiers3A2 = qualifier2;
                                } else if (qualifier2 != typequalifiers5) {
                                    typequalifiers3A2 = typequalifiers6;
                                }
                            }
                            typequalifiers3 = null;
                            nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                        }
                    } else {
                        typequalifiers3 = null;
                        nullabilityQualifierWithMigrationStatus3 = nullabilityQualifierWithMigrationStatus2;
                    }
                    if (nullabilityQualifierWithMigrationStatus2 != null) {
                        if (!zBooleanValue) {
                            if (annotationQualifiersFqNames3 == null) {
                                objValueOf = typequalifiers3;
                            } else {
                                objValueOf = Boolean.valueOf(annotationQualifiersFqNames3.getMakesTypeParameterNotNull());
                            }
                            if (Intrinsics3.areEqual(objValueOf, Boolean.TRUE)) {
                                z5 = false;
                            }
                        }
                        z5 = true;
                    } else if (nullabilityQualifierWithMigrationStatus2.getQualifier() == typequalifiers6) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (nullabilityQualifierWithMigrationStatus3 == null) {
                        qualifier = typequalifiers3;
                    } else {
                        qualifier = nullabilityQualifierWithMigrationStatus3.getQualifier();
                    }
                    List<FqName> read_only_annotations = JvmAnnotationNames2.getREAD_ONLY_ANNOTATIONS();
                    typeQualifiers2 typequalifiers7 = typeQualifiers2.READ_ONLY;
                    objC = c(read_only_annotations, annotations, typequalifiers7);
                    List<FqName> mutable_annotations = JvmAnnotationNames2.getMUTABLE_ANNOTATIONS();
                    typeQualifiers2 typequalifiers8 = typeQualifiers2.MUTABLE;
                    objC2 = c(mutable_annotations, annotations, typequalifiers8);
                    if (objC == null && objC2 != null && !Intrinsics3.areEqual(objC, objC2)) {
                        objC2 = typequalifiers3;
                    } else if (objC != null) {
                        objC2 = objC;
                    }
                    typeQualifiers2 typequalifiers9 = (typeQualifiers2) objC2;
                    if (z5 || !TypeUtils2.isTypeParameter(kotlinTypeComponent1)) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (nullabilityQualifierWithMigrationStatus3 == null) {
                        objValueOf2 = typequalifiers3;
                    } else {
                        objValueOf2 = Boolean.valueOf(nullabilityQualifierWithMigrationStatus3.isForWarningOnly());
                    }
                    typequalifiers = new typeQualifiers(qualifier, typequalifiers9, z6, Intrinsics3.areEqual(objValueOf2, Boolean.TRUE));
                    if (!typequalifiers.isNullabilityQualifierForWarning()) {
                        r1 = typequalifiers;
                    } else {
                        r1 = typequalifiers3;
                    }
                    if (r1 == 0) {
                        nullability = typequalifiers3;
                    } else {
                        nullability = r1.getNullability();
                    }
                    nullability2 = typequalifiers.getNullability();
                    if (this.d || !z16) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    typequalifiers3Select = typeEnchancementUtils.select(set3, nullability, z7);
                    if (typequalifiers3Select == null) {
                        typequalifiers3Select = typequalifiers3;
                    } else {
                        obj2 = this.a;
                        if (!(obj2 instanceof ValueParameterDescriptor)) {
                            obj2 = typequalifiers3;
                        }
                        valueParameterDescriptor = (ValueParameterDescriptor) obj2;
                        if (valueParameterDescriptor == null) {
                            varargElementType = typequalifiers3;
                        } else {
                            varargElementType = valueParameterDescriptor.getVarargElementType();
                        }
                        if (varargElementType != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!z12 && z16 && typequalifiers3Select == typequalifiers5) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            typequalifiers3Select = typequalifiers3;
                        }
                    }
                    typequalifiers2 = (typeQualifiers2) typeEnchancementUtils.select(set2, typequalifiers8, typequalifiers7, typequalifiers.getMutability(), z7);
                    if (nullability2 == nullability) {
                        set = set4;
                        if (!Intrinsics3.areEqual(set, set3)) {
                            z8 = false;
                        }
                        if (typequalifiers.isNotNullTypeParameter()) {
                            z9 = true;
                        } else {
                            if (arrayList5.isEmpty()) {
                                it2 = arrayList5.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        z11 = false;
                                        break;
                                    }
                                    if (((typeQualifiers) it2.next()).isNotNullTypeParameter()) {
                                        z11 = true;
                                        break;
                                    }
                                }
                            } else {
                                z11 = false;
                                break;
                            }
                            if (z11) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                        }
                        if (typequalifiers3Select == null || !z8) {
                            if (typequalifiers3Select == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                        } else {
                            typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typeEnchancementUtils.select(set, nullability2, z7), typequalifiers2, true, z9);
                        }
                        typequalifiersArr[i2] = typequalifiersCreateJavaTypeQualifiers;
                        i2++;
                        obj = typequalifiers3;
                        size = i3;
                        arrayList = arrayList8;
                        arrayList3 = arrayList12;
                        typequalifiersArr = typequalifiersArr;
                        i = 10;
                    } else {
                        set = set4;
                    }
                    z8 = true;
                    if (typequalifiers.isNotNullTypeParameter()) {
                        z9 = true;
                    } else {
                        if (arrayList5.isEmpty()) {
                            it2 = arrayList5.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    z11 = false;
                                    break;
                                }
                                if (((typeQualifiers) it2.next()).isNotNullTypeParameter()) {
                                    z11 = true;
                                    break;
                                }
                            }
                        } else {
                            z11 = false;
                            break;
                        }
                        if (z11) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    if (typequalifiers3Select == null) {
                        if (typequalifiers3Select == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                    } else {
                        if (typequalifiers3Select == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                    }
                    typequalifiersArr[i2] = typequalifiersCreateJavaTypeQualifiers;
                    i2++;
                    obj = typequalifiers3;
                    size = i3;
                    arrayList = arrayList8;
                    arrayList3 = arrayList12;
                    typequalifiersArr = typequalifiersArr;
                    i = 10;
                } else {
                    annotationQualifiersFqNames2 = annotationQualifiersFqNames2Component2;
                }
                annotations = (!z16 || (annotations3 = this.a) == null) ? kotlinTypeComponent1.getAnnotations() : Annotations5.composeAnnotations(annotations3.getAnnotations(), kotlinTypeComponent1.getAnnotations());
                if (z16) {
                    defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                    if (defaultTypeQualifiers == null) {
                        annotationQualifiersFqNames3 = null;
                    } else {
                        annotationQualifiersFqNames3 = defaultTypeQualifiers.get(this.f);
                    }
                } else {
                    annotationQualifiersFqNames3 = annotationQualifiersFqNames2;
                }
                if (annotationQualifiersFqNames3 != null) {
                    if (annotationQualifiersFqNames3.getAffectsTypeParameterBasedTypes()) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (!z14) {
                        annotationQualifiersFqNames3 = null;
                    }
                } else {
                    annotationQualifiersFqNames3 = null;
                }
                declarationDescriptor = kotlinTypeComponent1.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    typeParameterDescriptor = (TypeParameterDescriptor) declarationDescriptor;
                } else {
                    typeParameterDescriptor = null;
                }
                if (typeParameterDescriptor == null) {
                    typequalifiers3A = null;
                } else {
                    typequalifiers3A = a(typeParameterDescriptor);
                }
                if (typequalifiers3A == null) {
                    tuples2 = new Tuples2(null, Boolean.FALSE);
                } else {
                    NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus5 = new NullabilityQualifierWithMigrationStatus(typequalifiers6, false, 2, null);
                    if (typequalifiers3A == typequalifiers6) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    tuples2 = new Tuples2(nullabilityQualifierWithMigrationStatus5, Boolean.valueOf(z3));
                }
                nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) tuples2.component1();
                zBooleanValue = ((Boolean) tuples2.component2()).booleanValue();
                z4 = this.g;
                signatureenhancement = signatureEnhancement.this;
                it = annotations.iterator();
                do {
                    if (it.hasNext()) {
                        nullabilityQualifierWithMigrationStatusExtractNullability = null;
                        break;
                    }
                    nullabilityQualifierWithMigrationStatusExtractNullability = signatureenhancement.extractNullability(it.next(), typeEnhancementImprovements, z4);
                } while (nullabilityQualifierWithMigrationStatusExtractNullability == null);
                if (nullabilityQualifierWithMigrationStatusExtractNullability == null) {
                    nullabilityQualifierWithMigrationStatus2 = null;
                } else {
                    nullabilityQualifierWithMigrationStatus2 = nullabilityQualifierWithMigrationStatusExtractNullability;
                }
                if (nullabilityQualifierWithMigrationStatus2 == null) {
                    if (nullabilityQualifierWithMigrationStatus == null) {
                        if (annotationQualifiersFqNames3 == null) {
                            nullabilityQualifierWithMigrationStatus = null;
                        } else {
                            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                        }
                    }
                    if (typeParameterDescriptorComponent3 == null) {
                        typequalifiers3A2 = null;
                    } else {
                        typequalifiers3A2 = a(typeParameterDescriptorComponent3);
                    }
                    if (typequalifiers3A2 == null) {
                        nullabilityQualifierWithMigrationStatus3 = nullabilityQualifierWithMigrationStatus;
                        typequalifiers3 = null;
                    } else if (nullabilityQualifierWithMigrationStatus == null) {
                        nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                        typequalifiers3 = null;
                    } else {
                        qualifier2 = nullabilityQualifierWithMigrationStatus.getQualifier();
                        typequalifiers4 = typeQualifiers3.FORCE_FLEXIBILITY;
                        if (typequalifiers3A2 != typequalifiers4) {
                            typequalifiers3A2 = qualifier2;
                        } else if (qualifier2 != typequalifiers4) {
                            if (typequalifiers3A2 == typequalifiers5) {
                                typequalifiers3A2 = qualifier2;
                            } else if (qualifier2 != typequalifiers5) {
                                typequalifiers3A2 = typequalifiers6;
                            }
                        }
                        typequalifiers3 = null;
                        nullabilityQualifierWithMigrationStatus3 = new NullabilityQualifierWithMigrationStatus(typequalifiers3A2, false, 2, null);
                    }
                } else {
                    typequalifiers3 = null;
                    nullabilityQualifierWithMigrationStatus3 = nullabilityQualifierWithMigrationStatus2;
                }
                if (nullabilityQualifierWithMigrationStatus2 != null) {
                    if (!zBooleanValue) {
                        if (annotationQualifiersFqNames3 == null) {
                            objValueOf = typequalifiers3;
                        } else {
                            objValueOf = Boolean.valueOf(annotationQualifiersFqNames3.getMakesTypeParameterNotNull());
                        }
                        if (Intrinsics3.areEqual(objValueOf, Boolean.TRUE)) {
                            z5 = false;
                        }
                    }
                    z5 = true;
                } else if (nullabilityQualifierWithMigrationStatus2.getQualifier() == typequalifiers6) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (nullabilityQualifierWithMigrationStatus3 == null) {
                    qualifier = typequalifiers3;
                } else {
                    qualifier = nullabilityQualifierWithMigrationStatus3.getQualifier();
                }
                List<FqName> read_only_annotations2 = JvmAnnotationNames2.getREAD_ONLY_ANNOTATIONS();
                typeQualifiers2 typequalifiers10 = typeQualifiers2.READ_ONLY;
                objC = c(read_only_annotations2, annotations, typequalifiers10);
                List<FqName> mutable_annotations2 = JvmAnnotationNames2.getMUTABLE_ANNOTATIONS();
                typeQualifiers2 typequalifiers11 = typeQualifiers2.MUTABLE;
                objC2 = c(mutable_annotations2, annotations, typequalifiers11);
                if (objC == null) {
                    if (objC != null) {
                        objC2 = objC;
                    }
                } else if (objC != null) {
                    objC2 = objC;
                }
                typeQualifiers2 typequalifiers12 = (typeQualifiers2) objC2;
                if (z5) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                if (nullabilityQualifierWithMigrationStatus3 == null) {
                    objValueOf2 = typequalifiers3;
                } else {
                    objValueOf2 = Boolean.valueOf(nullabilityQualifierWithMigrationStatus3.isForWarningOnly());
                }
                typequalifiers = new typeQualifiers(qualifier, typequalifiers12, z6, Intrinsics3.areEqual(objValueOf2, Boolean.TRUE));
                if (!typequalifiers.isNullabilityQualifierForWarning()) {
                    r1 = typequalifiers;
                } else {
                    r1 = typequalifiers3;
                }
                if (r1 == 0) {
                    nullability = typequalifiers3;
                } else {
                    nullability = r1.getNullability();
                }
                nullability2 = typequalifiers.getNullability();
                if (this.d) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                typequalifiers3Select = typeEnchancementUtils.select(set3, nullability, z7);
                if (typequalifiers3Select == null) {
                    typequalifiers3Select = typequalifiers3;
                } else {
                    obj2 = this.a;
                    if (!(obj2 instanceof ValueParameterDescriptor)) {
                        obj2 = typequalifiers3;
                    }
                    valueParameterDescriptor = (ValueParameterDescriptor) obj2;
                    if (valueParameterDescriptor == null) {
                        varargElementType = typequalifiers3;
                    } else {
                        varargElementType = valueParameterDescriptor.getVarargElementType();
                    }
                    if (varargElementType != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        typequalifiers3Select = typequalifiers3;
                    }
                }
                typequalifiers2 = (typeQualifiers2) typeEnchancementUtils.select(set2, typequalifiers11, typequalifiers10, typequalifiers.getMutability(), z7);
                if (nullability2 == nullability) {
                    set = set4;
                    if (!Intrinsics3.areEqual(set, set3)) {
                        z8 = false;
                    }
                    if (typequalifiers.isNotNullTypeParameter()) {
                        z9 = true;
                    } else {
                        if (arrayList5.isEmpty()) {
                            it2 = arrayList5.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    z11 = false;
                                    break;
                                }
                                if (((typeQualifiers) it2.next()).isNotNullTypeParameter()) {
                                    z11 = true;
                                    break;
                                }
                            }
                        } else {
                            z11 = false;
                            break;
                        }
                        if (z11) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    if (typequalifiers3Select == null) {
                        if (typequalifiers3Select == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                    } else {
                        if (typequalifiers3Select == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                    }
                    typequalifiersArr[i2] = typequalifiersCreateJavaTypeQualifiers;
                    i2++;
                    obj = typequalifiers3;
                    size = i3;
                    arrayList = arrayList8;
                    arrayList3 = arrayList12;
                    typequalifiersArr = typequalifiersArr;
                    i = 10;
                } else {
                    set = set4;
                }
                z8 = true;
                if (typequalifiers.isNotNullTypeParameter()) {
                    z9 = true;
                } else {
                    if (arrayList5.isEmpty()) {
                        it2 = arrayList5.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                z11 = false;
                                break;
                            }
                            if (((typeQualifiers) it2.next()).isNotNullTypeParameter()) {
                                z11 = true;
                                break;
                            }
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                    if (z11) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                if (typequalifiers3Select == null) {
                    if (typequalifiers3Select == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                } else {
                    if (typequalifiers3Select == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    typequalifiersCreateJavaTypeQualifiers = typeEnchancementUtils.createJavaTypeQualifiers(typequalifiers3Select, typequalifiers2, z10, z9);
                }
                typequalifiersArr[i2] = typequalifiersCreateJavaTypeQualifiers;
                i2++;
                obj = typequalifiers3;
                size = i3;
                arrayList = arrayList8;
                arrayList3 = arrayList12;
                typequalifiersArr = typequalifiersArr;
                i = 10;
            }
            Object obj3 = obj;
            signatureEnhancement2 signatureenhancement3 = new signatureEnhancement2(typequalifiersArr);
            Object c0386b = predefinedenhancementinfo4 == null ? obj3 : new C0386b(predefinedenhancementinfo4, signatureenhancement3);
            boolean zContains = TypeUtils.contains(this.f3350b, a.j);
            ?? r4 = signatureEnhancement.this.c;
            KotlinType kotlinType3 = this.f3350b;
            ?? r2 = signatureenhancement3;
            if (c0386b != null) {
                r2 = c0386b;
            }
            KotlinType kotlinTypeEnhance = r4.enhance(kotlinType3, r2);
            if (kotlinTypeEnhance == null) {
                r6 = obj3;
            } else {
                aVar = new a(kotlinTypeEnhance, true, zContains);
            }
            if (r6 == 0) {
                r6 = aVar;
                return new a(this.f3350b, false, zContains);
            }
            r6 = aVar;
            return r6;
        }

        public /* synthetic */ b(Annotations3 annotations3, KotlinType kotlinType, Collection collection, boolean z2, context4 context4Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(signatureEnhancement.this, annotations3, kotlinType, collection, z2, context4Var, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z3);
        }
    }
}
