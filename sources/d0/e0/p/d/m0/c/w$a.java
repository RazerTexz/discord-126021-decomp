package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class w$a extends d0.z.d.j implements Function1<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.g.a> {
    public static final w$a j = new w$a();

    public w$a() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.g.a.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.a invoke(d0.e0.p.d.m0.g.a aVar) {
        return invoke2(aVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.g.a invoke2(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "p0");
        return aVar.getOuterClassId();
    }
}
