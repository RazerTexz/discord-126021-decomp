package d0.e0.p.d.m0.b.q;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.l.f $javaAnalogueDescriptor;
    public final /* synthetic */ d0.e0.p.d.m0.c.e $kotlinMutableClassIfContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0.e0.p.d.m0.e.a.i0.l.f fVar, d0.e0.p.d.m0.c.e eVar) {
        super(0);
        this.$javaAnalogueDescriptor = fVar;
        this.$kotlinMutableClassIfContainer = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.c.e invoke() {
        d0.e0.p.d.m0.e.a.i0.l.f fVar = this.$javaAnalogueDescriptor;
        d0.e0.p.d.m0.e.a.g0.g gVar = d0.e0.p.d.m0.e.a.g0.g.a;
        d0.z.d.m.checkNotNullExpressionValue(gVar, "EMPTY");
        return fVar.copy$descriptors_jvm(gVar, this.$kotlinMutableClassIfContainer);
    }
}
