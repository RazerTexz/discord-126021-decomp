package s.a.b2;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ Runnable $block;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$c(a aVar, Runnable runnable) {
        super(1);
        this.this$0 = aVar;
        this.$block = runnable;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.this$0.k.removeCallbacks(this.$block);
        return Unit.a;
    }
}
