package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.a1;
import d0.e0.p.d.m0.c.z0;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b$a extends o implements Function0<List<? extends z0>> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b$a(d dVar) {
        super(0);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends z0> invoke2() {
        return a1.computeConstructorTypeParameters(this.this$0);
    }
}
