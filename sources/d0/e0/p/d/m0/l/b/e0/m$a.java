package d0.e0.p.d.m0.l.b.e0;

import d0.t.u;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a extends o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
    public final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m$a(m mVar) {
        super(0);
        this.this$0 = mVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
        return u.toList(m.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(this.this$0.getProto(), m.access$getC$p(this.this$0).getNameResolver()));
    }
}
