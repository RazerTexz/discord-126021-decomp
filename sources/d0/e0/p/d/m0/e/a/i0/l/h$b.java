package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.t0;
import d0.z.d.a0;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class h$b extends d0.z.d.j implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public h$b(h hVar) {
        super(1, hVar);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(h.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "p0");
        return h.access$searchMethodsInSupertypesWithoutBuiltinMagic((h) this.receiver, eVar);
    }
}
