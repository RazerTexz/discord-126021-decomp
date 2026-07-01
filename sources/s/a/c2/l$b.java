package s.a.c2;

import d0.k$a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b extends d0.z.d.o implements Function1<Throwable, Unit> {
    public final /* synthetic */ CancellableContinuation $cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l$b(CancellableContinuation cancellableContinuation) {
        super(1);
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        CancellableContinuation cancellableContinuation = this.$cont;
        Unit unit = Unit.a;
        k$a k_a = d0.k.j;
        cancellableContinuation.resumeWith(d0.k.m97constructorimpl(unit));
        return unit;
    }
}
