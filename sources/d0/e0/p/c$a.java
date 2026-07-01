package d0.e0.p;

import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.l.b.u;
import d0.z.d.a0;
import d0.z.d.j;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c$a extends j implements Function2<u, i, t0> {
    public static final c$a j = new c$a();

    public c$a() {
        super(2);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "loadFunction";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(u.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final t0 invoke2(u uVar, i iVar) {
        m.checkNotNullParameter(uVar, "p1");
        m.checkNotNullParameter(iVar, "p2");
        return uVar.loadFunction(iVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ t0 invoke(u uVar, i iVar) {
        return invoke2(uVar, iVar);
    }
}
