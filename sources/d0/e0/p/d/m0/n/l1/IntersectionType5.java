package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.y, reason: use source file name */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class IntersectionType5 extends FunctionReference implements Function2<KotlinType, KotlinType, Boolean> {
    public IntersectionType5(NewKotlinTypeChecker2 newKotlinTypeChecker2) {
        super(2, newKotlinTypeChecker2);
    }

    @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "equalTypes";
    }

    @Override // d0.z.d.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection2.getOrCreateKotlinClass(NewKotlinTypeChecker2.class);
    }

    @Override // d0.z.d.CallableReference
    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
        return Boolean.valueOf(invoke2(kotlinType, kotlinType2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "p0");
        Intrinsics3.checkNotNullParameter(kotlinType2, "p1");
        return ((NewKotlinTypeChecker2) this.receiver).equalTypes(kotlinType, kotlinType2);
    }
}
