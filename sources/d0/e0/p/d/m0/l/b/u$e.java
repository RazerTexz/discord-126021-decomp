package d0.e0.p.d.m0.l.b;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$e extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
    public final /* synthetic */ d0.e0.p.d.m0.i.n $callable;
    public final /* synthetic */ y $containerOfCallable;
    public final /* synthetic */ int $i;
    public final /* synthetic */ b $kind;
    public final /* synthetic */ d0.e0.p.d.m0.f.u $proto;
    public final /* synthetic */ u this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u$e(u uVar, y yVar, d0.e0.p.d.m0.i.n nVar, b bVar, int i, d0.e0.p.d.m0.f.u uVar2) {
        super(0);
        this.this$0 = uVar;
        this.$containerOfCallable = yVar;
        this.$callable = nVar;
        this.$kind = bVar;
        this.$i = i;
        this.$proto = uVar2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
        return d0.t.u.toList(u.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
    }
}
