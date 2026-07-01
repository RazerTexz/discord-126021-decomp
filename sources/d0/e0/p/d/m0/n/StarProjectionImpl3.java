package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p0, reason: use source file name */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StarProjectionImpl3 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p0$a */
    /* JADX INFO: compiled from: StarProjectionImpl.kt */
    public static final class a extends TypeSubstitution3 {
        public final /* synthetic */ List<TypeConstructor> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends TypeConstructor> list) {
            this.c = list;
        }

        @Override // d0.e0.p.d.m0.n.TypeSubstitution3
        public TypeProjection get(TypeConstructor typeConstructor) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "key");
            if (!this.c.contains(typeConstructor)) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
        }
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "<this>");
        List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) typeParameterDescriptor.getContainingDeclaration()).getTypeConstructor().getParameters();
        Intrinsics3.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
        }
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(new a(arrayList));
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        KotlinType kotlinTypeSubstitute = typeSubstitutor2Create.substitute((KotlinType) _Collections.first((List) upperBounds), Variance.OUT_VARIANCE);
        if (kotlinTypeSubstitute != null) {
            return kotlinTypeSubstitute;
        }
        KotlinType4 defaultBound = DescriptorUtils2.getBuiltIns(typeParameterDescriptor).getDefaultBound();
        Intrinsics3.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }
}
