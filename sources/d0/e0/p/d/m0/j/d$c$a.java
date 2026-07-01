package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.b.k$a;
import d0.t.o0;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c$a extends d0.z.d.o implements Function1<h, Unit> {
    public static final d$c$a j = new d$c$a();

    public d$c$a() {
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
        hVar.setExcludedTypeAnnotationClasses(o0.plus((Set) hVar.getExcludedTypeAnnotationClasses(), (Iterable) d0.t.m.listOf(k$a.f3228x)));
        hVar.setAnnotationArgumentsRenderingPolicy(a.ALWAYS_PARENTHESIZED);
    }
}
