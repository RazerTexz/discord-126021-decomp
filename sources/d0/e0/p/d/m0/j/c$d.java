package d0.e0.p.d.m0.j;

import d0.t.n0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$d extends d0.z.d.o implements Function1<h, Unit> {
    public static final c$d j = new c$d();

    public c$d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(h hVar) {
        invoke2(hVar);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "<this>");
        hVar.setModifiers(n0.emptySet());
        hVar.setClassifierNamePolicy(b$b.a);
        hVar.setParameterNameRenderingPolicy(n.ONLY_NON_SYNTHESIZED);
    }
}
