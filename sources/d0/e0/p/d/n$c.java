package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n$c extends d0.z.d.j implements Function2<d0.e0.p.d.m0.l.b.u, d0.e0.p.d.m0.f.n, n0> {
    public static final n$c j = new n$c();

    public n$c() {
        super(2);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "loadProperty";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.l.b.u.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ n0 invoke(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
        return invoke2(uVar, nVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final n0 invoke2(d0.e0.p.d.m0.l.b.u uVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(uVar, "p1");
        d0.z.d.m.checkNotNullParameter(nVar, "p2");
        return uVar.loadProperty(nVar);
    }
}
