package d0.e0.p.d.m0.l.b.e0;

import d0.z.d.a0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class d$g extends d0.z.d.j implements Function1<d0.e0.p.d.m0.n.l1.g, d$a> {
    public d$g(d dVar) {
        super(1, dVar);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(d$a.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d$a invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d$a invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "p0");
        return new d$a((d) this.receiver, gVar);
    }
}
