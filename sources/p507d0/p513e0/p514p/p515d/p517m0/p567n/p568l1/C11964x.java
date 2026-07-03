package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12235j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.x */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C11964x extends C12235j implements Function2<AbstractC11913c0, AbstractC11913c0, Boolean> {
    public C11964x(C11962v c11962v) {
        super(2, c11962v);
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable
    public final String getName() {
        return "isStrictSupertype";
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public final KDeclarationContainer getOwner() {
        return C12216a0.getOrCreateKotlinClass(C11962v.class);
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public final String getSignature() {
        return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        return Boolean.valueOf(invoke2(abstractC11913c0, abstractC11913c1));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "p0");
        C12238m.checkNotNullParameter(abstractC11913c1, "p1");
        return C11962v.access$isStrictSupertype((C11962v) this.receiver, abstractC11913c0, abstractC11913c1);
    }
}
