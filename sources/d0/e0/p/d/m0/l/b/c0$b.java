package d0.e0.p.d.m0.l.b;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c0$b extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
    public final /* synthetic */ d0.e0.p.d.m0.f.q $proto;
    public final /* synthetic */ c0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0$b(c0 c0Var, d0.e0.p.d.m0.f.q qVar) {
        super(0);
        this.this$0 = c0Var;
        this.$proto = qVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
        return c0.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, c0.access$getC$p(this.this$0).getNameResolver());
    }
}
