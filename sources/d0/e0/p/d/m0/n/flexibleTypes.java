package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.w, reason: use source file name */
/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class flexibleTypes extends KotlinType6 implements TypeCapabilities {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.w$a */
    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public flexibleTypes(KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        super(kotlinType4, kotlinType5);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public KotlinType4 getDelegate() {
        return getLowerBound();
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public boolean isTypeVariable() {
        return (getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics3.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor());
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType3 makeNullableAsSpecified(boolean z2) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        if (!descriptorRenderer4.getDebugMode()) {
            return descriptorRenderer2.renderFlexibleType(descriptorRenderer2.renderType(getLowerBound()), descriptorRenderer2.renderType(getUpperBound()), TypeUtils2.getBuiltIns(this));
        }
        StringBuilder sbQ = outline.Q('(');
        sbQ.append(descriptorRenderer2.renderType(getLowerBound()));
        sbQ.append("..");
        sbQ.append(descriptorRenderer2.renderType(getUpperBound()));
        sbQ.append(')');
        return sbQ.toString();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAnnotations(annotations4), getUpperBound().replaceAnnotations(annotations4));
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public KotlinType substitutionResult(KotlinType kotlinType) {
        KotlinType3 kotlinType3FlexibleType;
        Intrinsics3.checkNotNullParameter(kotlinType, "replacement");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            kotlinType3FlexibleType = kotlinType3Unwrap;
        } else {
            if (!(kotlinType3Unwrap instanceof KotlinType4)) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            KotlinType4 kotlinType4 = (KotlinType4) kotlinType3Unwrap;
            kotlinType3FlexibleType = KotlinTypeFactory.flexibleType(kotlinType4, kotlinType4.makeNullableAsSpecified(true));
        }
        return TypeWithEnhancement2.inheritEnhancement(kotlinType3FlexibleType, kotlinType3Unwrap);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public KotlinType6 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new flexibleTypes((KotlinType4) kotlinTypeRefiner.refineType(getLowerBound()), (KotlinType4) kotlinTypeRefiner.refineType(getUpperBound()));
    }
}
