package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.KotlinTarget;
import d0.e0.p.d.m0.e.a.g0.JavaAnnotationMapper3;
import d0.e0.p.d.m0.e.a.l0.NullabilityQualifierWithMigrationStatus;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver {
    public final JavaTypeEnhancementState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final storage4<ClassDescriptor, AnnotationDescriptor> f3309b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$a */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public static final class a {
        public final AnnotationDescriptor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3310b;

        public a(AnnotationDescriptor annotationDescriptor, int i) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "typeQualifier");
            this.a = annotationDescriptor;
            this.f3310b = i;
        }

        public final AnnotationDescriptor component1() {
            return this.a;
        }

        public final List<AnnotationQualifierApplicabilityType> component2() {
            AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArrValuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 6; i++) {
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = annotationQualifierApplicabilityTypeArrValuesCustom[i];
                boolean z2 = true;
                if (!((this.f3310b & (1 << annotationQualifierApplicabilityType.ordinal())) != 0)) {
                    if (!((this.f3310b & 8) != 0) || annotationQualifierApplicabilityType == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
                        z2 = false;
                    }
                }
                if (z2) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$b */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<ClassDescriptor, AnnotationDescriptor> {
        public b(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
            super(1, annotationTypeQualifierResolver);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(AnnotationTypeQualifierResolver.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotationDescriptor invoke(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "p0");
            return AnnotationTypeQualifierResolver.access$computeTypeQualifierNickname((AnnotationTypeQualifierResolver) this.receiver, classDescriptor);
        }
    }

    public AnnotationTypeQualifierResolver(StorageManager storageManager, JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = javaTypeEnhancementState;
        this.f3309b = storageManager.createMemoizedFunctionWithNullableValues(new b(this));
    }

    public static final AnnotationDescriptor access$computeTypeQualifierNickname(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, ClassDescriptor classDescriptor) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        if (!classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        Iterator<AnnotationDescriptor> it = classDescriptor.getAnnotations().iterator();
        while (it.hasNext()) {
            AnnotationDescriptor annotationDescriptorResolveTypeQualifierAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(it.next());
            if (annotationDescriptorResolveTypeQualifierAnnotation != null) {
                return annotationDescriptorResolveTypeQualifierAnnotation;
            }
        }
        return null;
    }

    public static final List access$toKotlinTargetNames(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, String str) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        Set<KotlinTarget> setMapJavaTargetArgumentByName = JavaAnnotationMapper3.a.mapJavaTargetArgumentByName(str);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setMapJavaTargetArgumentByName, 10));
        Iterator<T> it = setMapJavaTargetArgumentByName.iterator();
        while (it.hasNext()) {
            arrayList.add(((KotlinTarget) it.next()).name());
        }
        return arrayList;
    }

    public final List<AnnotationQualifierApplicabilityType> a(d0.e0.p.d.m0.k.v.g<?> gVar, Function2<? super d0.e0.p.d.m0.k.v.j, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (gVar instanceof d0.e0.p.d.m0.k.v.b) {
            List<? extends d0.e0.p.d.m0.k.v.g<?>> value = ((d0.e0.p.d.m0.k.v.b) gVar).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                MutableCollections.addAll(arrayList, a((d0.e0.p.d.m0.k.v.g) it.next(), function2));
            }
            return arrayList;
        }
        if (!(gVar instanceof d0.e0.p.d.m0.k.v.j)) {
            return Collections2.emptyList();
        }
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArrValuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
        for (int i = 0; i < 6; i++) {
            annotationQualifierApplicabilityType = annotationQualifierApplicabilityTypeArrValuesCustom[i];
            if (function2.invoke(gVar, annotationQualifierApplicabilityType).booleanValue()) {
                return Collections2.listOfNotNull(annotationQualifierApplicabilityType);
            }
        }
        annotationQualifierApplicabilityType = null;
        return Collections2.listOfNotNull(annotationQualifierApplicabilityType);
    }

    public final a resolveAnnotation(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        Annotations4 annotations = annotationClass.getAnnotations();
        FqName fqName = JvmAnnotationNames.c;
        Intrinsics3.checkNotNullExpressionValue(fqName, "TARGET_ANNOTATION");
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName);
        if (annotationDescriptorFindAnnotation == null) {
            return null;
        }
        Map<Name, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = annotationDescriptorFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Name, d0.e0.p.d.m0.k.v.g<?>>> it = allValueArguments.entrySet().iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, a(it.next().getValue(), new AnnotationTypeQualifierResolver3(this)));
        }
        int iOrdinal = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((AnnotationQualifierApplicabilityType) it2.next()).ordinal();
        }
        return new a(annotationDescriptor, iOrdinal);
    }

    public final JavaTypeEnhancementState2 resolveJsr305AnnotationState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        JavaTypeEnhancementState2 javaTypeEnhancementState2ResolveJsr305CustomState = resolveJsr305CustomState(annotationDescriptor);
        return javaTypeEnhancementState2ResolveJsr305CustomState == null ? this.a.getGlobalJsr305Level() : javaTypeEnhancementState2ResolveJsr305CustomState;
    }

    public final JavaTypeEnhancementState2 resolveJsr305CustomState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        Map<String, JavaTypeEnhancementState2> userDefinedLevelForSpecificJsr305Annotation = this.a.getUserDefinedLevelForSpecificJsr305Annotation();
        FqName fqName = annotationDescriptor.getFqName();
        JavaTypeEnhancementState2 javaTypeEnhancementState2 = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (javaTypeEnhancementState2 != null) {
            return javaTypeEnhancementState2;
        }
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotationClass.getAnnotations().findAnnotation(AnnotationQualifiersFqNames.getMIGRATION_ANNOTATION_FQNAME());
        d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = annotationDescriptorFindAnnotation == null ? null : DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation);
        d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
        if (jVar == null) {
            return null;
        }
        JavaTypeEnhancementState2 migrationLevelForJsr305 = this.a.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            return migrationLevelForJsr305;
        }
        String strAsString = jVar.getEnumEntryName().asString();
        int iHashCode = strAsString.hashCode();
        if (iHashCode == -2137067054) {
            if (strAsString.equals("IGNORE")) {
                return JavaTypeEnhancementState2.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strAsString.equals("STRICT")) {
                return JavaTypeEnhancementState2.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strAsString.equals("WARN")) {
            return JavaTypeEnhancementState2.WARN;
        }
        return null;
    }

    public final AnnotationQualifiersFqNames2 resolveQualifierBuiltInDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledDefaultAnnotations() || (annotationQualifiersFqNames2 = AnnotationQualifiersFqNames.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        JavaTypeEnhancementState2 jspecifyReportLevel = AnnotationQualifiersFqNames.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationDescriptor.getFqName()) ? this.a.getJspecifyReportLevel() : resolveJsr305AnnotationState(annotationDescriptor);
        if (!(jspecifyReportLevel != JavaTypeEnhancementState2.IGNORE)) {
            jspecifyReportLevel = null;
        }
        if (jspecifyReportLevel == null) {
            return null;
        }
        return AnnotationQualifiersFqNames2.copy$default(annotationQualifiersFqNames2, NullabilityQualifierWithMigrationStatus.copy$default(annotationQualifiersFqNames2.getNullabilityQualifier(), null, jspecifyReportLevel.isWarning(), 1, null), null, false, 6, null);
    }

    public final AnnotationDescriptor resolveTypeQualifierAnnotation(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledJsr305() || (annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor)) == null) {
            return null;
        }
        if (AnnotationTypeQualifierResolver4.access$isAnnotatedWithTypeQualifier(annotationClass)) {
            return annotationDescriptor;
        }
        if (annotationClass.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.f3309b.invoke(annotationClass);
    }

    public final a resolveTypeQualifierDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        AnnotationDescriptor next;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.a.getDisabledJsr305()) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        ClassDescriptor annotationClass2 = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        Intrinsics3.checkNotNull(annotationClass2);
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotationClass2.getAnnotations().findAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        Intrinsics3.checkNotNull(annotationDescriptorFindAnnotation);
        Map<Name, d0.e0.p.d.m0.k.v.g<?>> allValueArguments = annotationDescriptorFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Name, d0.e0.p.d.m0.k.v.g<?>> entry : allValueArguments.entrySet()) {
            MutableCollections.addAll(arrayList, Intrinsics3.areEqual(entry.getKey(), JvmAnnotationNames.f3305b) ? a(entry.getValue(), AnnotationTypeQualifierResolver2.j) : Collections2.emptyList());
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((AnnotationQualifierApplicabilityType) it.next()).ordinal();
        }
        Iterator<AnnotationDescriptor> it2 = annotationClass.getAnnotations().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!(resolveTypeQualifierAnnotation(next) != null));
        AnnotationDescriptor annotationDescriptor2 = next;
        if (annotationDescriptor2 == null) {
            return null;
        }
        return new a(annotationDescriptor2, iOrdinal);
    }
}
