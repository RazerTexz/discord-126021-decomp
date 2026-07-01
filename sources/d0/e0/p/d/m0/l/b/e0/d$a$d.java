package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.n.c0;
import d0.z.d.o;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$d extends o implements Function0<Collection<? extends c0>> {
    public final /* synthetic */ d$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a$d(d$a d_a) {
        super(0);
        this.this$0 = d_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends c0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends c0> invoke2() {
        return d$a.access$getKotlinTypeRefiner$p(this.this$0).refineSupertypes(d$a.access$getClassDescriptor(this.this$0));
    }
}
