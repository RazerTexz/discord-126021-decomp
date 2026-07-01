package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class c$b extends d0.z.d.j implements Function1<d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.g1.c> {
    public c$b(c cVar) {
        super(1, cVar);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return d0.z.d.a0.getOrCreateKotlinClass(c.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.c invoke(d0.e0.p.d.m0.c.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.g1.c invoke2(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "p0");
        return c.access$computeTypeQualifierNickname((c) this.receiver, eVar);
    }
}
