package d0.e0.p.d.m0.e.a.i0;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.c.ClassOrPackageFragmentDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.e.a.AnnotationQualifierApplicabilityType;
import d0.e0.p.d.m0.e.a.AnnotationQualifiersFqNames2;
import d0.e0.p.d.m0.e.a.AnnotationTypeQualifierResolver;
import d0.e0.p.d.m0.e.a.JavaTypeQualifiersByElementType;
import d0.e0.p.d.m0.e.a.k0.z;
import d0.e0.p.d.m0.e.a.l0.NullabilityQualifierWithMigrationStatus;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a$a */
    /* JADX INFO: compiled from: context.kt */
    public static final class a extends Lambda implements Function0<JavaTypeQualifiersByElementType> {
        public final /* synthetic */ ClassOrPackageFragmentDescriptor $containingDeclaration;
        public final /* synthetic */ context4 $this_childForClassOrPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(context4 context4Var, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
            super(0);
            this.$this_childForClassOrPackage = context4Var;
            this.$containingDeclaration = classOrPackageFragmentDescriptor;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JavaTypeQualifiersByElementType invoke() {
            return context.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a$b */
    /* JADX INFO: compiled from: context.kt */
    public static final class b extends Lambda implements Function0<JavaTypeQualifiersByElementType> {
        public final /* synthetic */ Annotations4 $additionalAnnotations;
        public final /* synthetic */ context4 $this_copyWithNewDefaultTypeQualifiers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(context4 context4Var, Annotations4 annotations4) {
            super(0);
            this.$this_copyWithNewDefaultTypeQualifiers = context4Var;
            this.$additionalAnnotations = annotations4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final JavaTypeQualifiersByElementType invoke() {
            return context.computeNewDefaultTypeQualifiers(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }
    }

    public static final context4 a(context4 context4Var, DeclarationDescriptor declarationDescriptor, z zVar, int i, Lazy<JavaTypeQualifiersByElementType> lazy) {
        context2 components = context4Var.getComponents();
        resolvers2 resolversVar = zVar == null ? null : new resolvers(context4Var, declarationDescriptor, zVar, i);
        if (resolversVar == null) {
            resolversVar = context4Var.getTypeParameterResolver();
        }
        return new context4(components, resolversVar, lazy);
    }

    public static final context4 child(context4 context4Var, resolvers2 resolvers2Var) {
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(resolvers2Var, "typeParameterResolver");
        return new context4(context4Var.getComponents(), resolvers2Var, context4Var.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final context4 childForClassOrPackage(context4 context4Var, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, z zVar, int i) {
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(classOrPackageFragmentDescriptor, "containingDeclaration");
        return a(context4Var, classOrPackageFragmentDescriptor, zVar, i, LazyJVM.lazy(Lazy5.NONE, new a(context4Var, classOrPackageFragmentDescriptor)));
    }

    public static /* synthetic */ context4 childForClassOrPackage$default(context4 context4Var, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, z zVar, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            zVar = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForClassOrPackage(context4Var, classOrPackageFragmentDescriptor, zVar, i);
    }

    public static final context4 childForMethod(context4 context4Var, DeclarationDescriptor declarationDescriptor, z zVar, int i) {
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(zVar, "typeParameterOwner");
        return a(context4Var, declarationDescriptor, zVar, i, context4Var.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ context4 childForMethod$default(context4 context4Var, DeclarationDescriptor declarationDescriptor, z zVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForMethod(context4Var, declarationDescriptor, zVar, i);
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(context4 context4Var, Annotations4 annotations4) {
        boolean z2;
        EnumMap enumMap;
        EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> defaultQualifiers;
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(annotations4, "additionalAnnotations");
        if (context4Var.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            return context4Var.getDefaultTypeQualifiers();
        }
        ArrayList<AnnotationQualifiersFqNames2> arrayList = new ArrayList();
        Iterator<AnnotationDescriptor> it = annotations4.iterator();
        while (true) {
            z2 = false;
            enumMap = null;
            annotationQualifiersFqNames2 = null;
            annotationQualifiersFqNames2 = null;
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = null;
            enumMap = null;
            if (!it.hasNext()) {
                break;
            }
            AnnotationDescriptor next = it.next();
            AnnotationTypeQualifierResolver annotationTypeQualifierResolver = context4Var.getComponents().getAnnotationTypeQualifierResolver();
            AnnotationQualifiersFqNames2 annotationQualifiersFqNames2ResolveQualifierBuiltInDefaultAnnotation = annotationTypeQualifierResolver.resolveQualifierBuiltInDefaultAnnotation(next);
            if (annotationQualifiersFqNames2ResolveQualifierBuiltInDefaultAnnotation == null) {
                AnnotationTypeQualifierResolver.a aVarResolveTypeQualifierDefaultAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierDefaultAnnotation(next);
                if (aVarResolveTypeQualifierDefaultAnnotation != null) {
                    AnnotationDescriptor annotationDescriptorComponent1 = aVarResolveTypeQualifierDefaultAnnotation.component1();
                    List<AnnotationQualifierApplicabilityType> listComponent2 = aVarResolveTypeQualifierDefaultAnnotation.component2();
                    JavaTypeEnhancementState2 javaTypeEnhancementState2ResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305CustomState(next);
                    if (javaTypeEnhancementState2ResolveJsr305CustomState == null) {
                        javaTypeEnhancementState2ResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305AnnotationState(annotationDescriptorComponent1);
                    }
                    if (!javaTypeEnhancementState2ResolveJsr305CustomState.isIgnore()) {
                        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusExtractNullability = context4Var.getComponents().getSignatureEnhancement().extractNullability(annotationDescriptorComponent1, context4Var.getComponents().getSettings().getTypeEnhancementImprovements(), false);
                        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatusCopy$default = nullabilityQualifierWithMigrationStatusExtractNullability == null ? null : NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatusExtractNullability, null, javaTypeEnhancementState2ResolveJsr305CustomState.isWarning(), 1, null);
                        if (nullabilityQualifierWithMigrationStatusCopy$default != null) {
                            annotationQualifiersFqNames2 = new AnnotationQualifiersFqNames2(nullabilityQualifierWithMigrationStatusCopy$default, listComponent2, false, 4, null);
                        }
                    }
                }
            } else {
                annotationQualifiersFqNames2 = annotationQualifiersFqNames2ResolveQualifierBuiltInDefaultAnnotation;
            }
            if (annotationQualifiersFqNames2 != null) {
                arrayList.add(annotationQualifiersFqNames2);
            }
        }
        if (arrayList.isEmpty()) {
            return context4Var.getDefaultTypeQualifiers();
        }
        JavaTypeQualifiersByElementType defaultTypeQualifiers = context4Var.getDefaultTypeQualifiers();
        if (defaultTypeQualifiers != null && (defaultQualifiers = defaultTypeQualifiers.getDefaultQualifiers()) != null) {
            enumMap = new EnumMap((EnumMap) defaultQualifiers);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(AnnotationQualifierApplicabilityType.class);
        }
        for (AnnotationQualifiersFqNames2 annotationQualifiersFqNames3 : arrayList) {
            Iterator<AnnotationQualifierApplicabilityType> it2 = annotationQualifiersFqNames3.getQualifierApplicabilityTypes().iterator();
            while (it2.hasNext()) {
                enumMap.put(it2.next(), annotationQualifiersFqNames3);
                z2 = true;
            }
        }
        return !z2 ? context4Var.getDefaultTypeQualifiers() : new JavaTypeQualifiersByElementType(enumMap);
    }

    public static final context4 copyWithNewDefaultTypeQualifiers(context4 context4Var, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(annotations4, "additionalAnnotations");
        return annotations4.isEmpty() ? context4Var : new context4(context4Var.getComponents(), context4Var.getTypeParameterResolver(), LazyJVM.lazy(Lazy5.NONE, new b(context4Var, annotations4)));
    }

    public static final context4 replaceComponents(context4 context4Var, context2 context2Var) {
        Intrinsics3.checkNotNullParameter(context4Var, "<this>");
        Intrinsics3.checkNotNullParameter(context2Var, "components");
        return new context4(context2Var, context4Var.getTypeParameterResolver(), context4Var.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }
}
