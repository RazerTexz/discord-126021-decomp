package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1, reason: use source file name */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeParameterUtils {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$a */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class a extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor) {
            return Boolean.valueOf(invoke2(declarationDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "it");
            return declarationDescriptor instanceof CallableDescriptor;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$b */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class b extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor) {
            return Boolean.valueOf(invoke2(declarationDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "it");
            return !(declarationDescriptor instanceof ConstructorDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.a1$c */
    /* JADX INFO: compiled from: typeParameterUtils.kt */
    public static final class c extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Sequence<TypeParameterDescriptor> invoke(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "it");
            List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor).getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
            return _Collections.asSequence(typeParameters);
        }
    }

    public static final typeParameterUtils3 a(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        if (classifierDescriptorWithTypeParameters == null || ErrorUtils.isError(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (classifierDescriptorWithTypeParameters.isInner()) {
            List<TypeProjection> listSubList = kotlinType.getArguments().subList(i, size);
            DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
            return new typeParameterUtils3(classifierDescriptorWithTypeParameters, listSubList, a(kotlinType, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
        }
        if (size != kotlinType.getArguments().size()) {
            DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters);
        }
        return new typeParameterUtils3(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), null);
    }

    public static final typeParameterUtils3 buildPossiblyInnerType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        return a(kotlinType, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> listEmptyList;
        DeclarationDescriptor next;
        TypeConstructor typeConstructor;
        Intrinsics3.checkNotNullParameter(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        List list = _Sequences2.toList(_Sequences2.flatMap(_Sequences2.filter(_Sequences2.takeWhile(DescriptorUtils2.getParents(classifierDescriptorWithTypeParameters), a.j), b.j), c.j));
        Iterator<DeclarationDescriptor> it = DescriptorUtils2.getParents(classifierDescriptorWithTypeParameters).iterator();
        do {
            listEmptyList = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof ClassDescriptor));
        ClassDescriptor classDescriptor = (ClassDescriptor) next;
        if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
            listEmptyList = typeConstructor.getParameters();
        }
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        if (list.isEmpty() && listEmptyList.isEmpty()) {
            List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        List<TypeParameterDescriptor> listPlus = _Collections.plus((Collection) list, (Iterable) listEmptyList);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : listPlus) {
            Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "it");
            arrayList.add(new typeParameterUtils2(typeParameterDescriptor, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
        }
        return _Collections.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
    }
}
