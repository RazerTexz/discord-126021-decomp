package d0.e0.p.d.m0.l.b.e0;

import d0.z.d.o;
import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$i extends o implements Function0<Collection<? extends d0.e0.p.d.m0.c.e>> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$i(d dVar) {
        super(0);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.c.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends d0.e0.p.d.m0.c.e> invoke2() {
        return d.access$computeSubclassesForSealedClass(this.this$0);
    }
}
