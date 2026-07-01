package d0.e0.p.d.m0.e.a.g0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorResolverUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a$a implements Function1<d0.e0.p.d.m0.c.b, Unit> {
    public final /* synthetic */ a$a j;

    public a$a$a(a$a a_a) {
        this.j = a_a;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d0.e0.p.d.m0.c.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Unit invoke2(d0.e0.p.d.m0.c.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
        }
        this.j.a.reportCannotInferVisibility(bVar);
        return Unit.a;
    }
}
