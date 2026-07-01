package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends d0.z.d.o implements Function2<d0.e0.p.d.m0.k.v.j, a, Boolean> {
    public final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar) {
        super(2);
        this.this$0 = cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.k.v.j jVar, a aVar) {
        return Boolean.valueOf(invoke2(jVar, aVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.k.v.j jVar, a aVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "it");
        return c.access$toKotlinTargetNames(this.this$0, aVar.getJavaTarget()).contains(jVar.getEnumEntryName().getIdentifier());
    }
}
