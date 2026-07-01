package d0.e0.p.d.m0.e.a.i0.m;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.StarProjectionImpl2;
import d0.e0.p.d.m0.n.StarProjectionImpl3;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.e, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver5 {
    public static final FqName a = new FqName("java.lang.Class");

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.e$a */
    /* JADX INFO: compiled from: JavaTypeResolver.kt */
    public static final class a extends Lambda implements Function0<KotlinType4> {
        public final /* synthetic */ TypeParameterDescriptor $this_getErasedUpperBound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TypeParameterDescriptor typeParameterDescriptor) {
            super(0);
            this.$this_getErasedUpperBound = typeParameterDescriptor;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            StringBuilder sbU = outline.U("Can't compute erased upper bound of type parameter `");
            sbU.append(this.$this_getErasedUpperBound);
            sbU.append('`');
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(sbU.toString());
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
            return kotlinType4CreateErrorType;
        }
    }

    public static final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0<? extends KotlinType> function0) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return function0.invoke();
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
        KotlinType kotlinType = (KotlinType) _Collections.first((List) upperBounds);
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics3.checkNotNullExpressionValue(kotlinType, "firstUpperBound");
            return TypeUtils2.replaceArgumentsWithStarProjections(kotlinType);
        }
        if (typeParameterDescriptor2 != null) {
            typeParameterDescriptor = typeParameterDescriptor2;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (Intrinsics3.areEqual(typeParameterDescriptor3, typeParameterDescriptor)) {
                return function0.invoke();
            }
            List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            KotlinType kotlinType2 = (KotlinType) _Collections.first((List) upperBounds2);
            if (kotlinType2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                Intrinsics3.checkNotNullExpressionValue(kotlinType2, "nextUpperBound");
                return TypeUtils2.replaceArgumentsWithStarProjections(kotlinType2);
            }
            declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static /* synthetic */ KotlinType getErasedUpperBound$default(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterDescriptor2 = null;
        }
        if ((i & 2) != 0) {
            function0 = new a(typeParameterDescriptor);
        }
        return getErasedUpperBound(typeParameterDescriptor, typeParameterDescriptor2, function0);
    }

    public static final TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeResolver javaTypeResolver) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics3.checkNotNullParameter(javaTypeResolver, "attr");
        return javaTypeResolver.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE ? new TypeProjectionImpl(StarProjectionImpl3.starProjectionType(typeParameterDescriptor)) : new StarProjectionImpl2(typeParameterDescriptor);
    }

    public static final JavaTypeResolver toAttributes(TypeUsage typeUsage, boolean z2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeUsage, "<this>");
        return new JavaTypeResolver(typeUsage, null, z2, typeParameterDescriptor, 2, null);
    }

    public static /* synthetic */ JavaTypeResolver toAttributes$default(TypeUsage typeUsage, boolean z2, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z2, typeParameterDescriptor);
    }
}
