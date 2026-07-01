package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.c, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeResolver3 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ JavaTypeResolver $attr;
    public final /* synthetic */ TypeConstructor $constructor;
    public final /* synthetic */ TypeParameterDescriptor $parameter;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.c$a */
    /* JADX INFO: compiled from: JavaTypeResolver.kt */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ TypeConstructor $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TypeConstructor typeConstructor) {
            super(0);
            this.$constructor = typeConstructor;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            ClassifierDescriptor declarationDescriptor = this.$constructor.getDeclarationDescriptor();
            Intrinsics3.checkNotNull(declarationDescriptor);
            KotlinType4 defaultType = declarationDescriptor.getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return TypeUtils2.replaceArgumentsWithStarProjections(defaultType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolver3(TypeParameterDescriptor typeParameterDescriptor, JavaTypeResolver javaTypeResolver, TypeConstructor typeConstructor) {
        super(0);
        this.$parameter = typeParameterDescriptor;
        this.$attr = javaTypeResolver;
        this.$constructor = typeConstructor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KotlinType invoke() {
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
        return JavaTypeResolver5.getErasedUpperBound(typeParameterDescriptor, this.$attr.getUpperBoundOfTypeParameter(), new a(this.$constructor));
    }
}
