package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends d0.z.d.o implements Function2<d0.e0.p.d.m0.k.v.j, a, Boolean> {
    public static final d j = new d();

    public d() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.k.v.j jVar, a aVar) {
        return Boolean.valueOf(invoke2(jVar, aVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.k.v.j jVar, a aVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "it");
        return d0.z.d.m.areEqual(jVar.getEnumEntryName().getIdentifier(), aVar.getJavaTarget());
    }
}
