package d0.e0.p.d;

import java.util.Collection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a$b extends d0.z.d.o implements Function0<Collection<? extends f<?>>> {
    public final /* synthetic */ n$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a$b(n$a n_a) {
        super(0);
        this.this$0 = n_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Collection<? extends f<?>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<? extends f<?>> invoke2() {
        n$a n_a = this.this$0;
        return n_a.i.b(n_a.getScope(), i$c.DECLARED);
    }
}
