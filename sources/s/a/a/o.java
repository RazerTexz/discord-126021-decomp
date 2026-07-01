package s.a.a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d0.z.d.o implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Function1 $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = function1;
        this.$element = obj;
        this.$context = coroutineContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Function1 function1 = this.$this_bindCancellationFun;
        Object obj = this.$element;
        CoroutineContext coroutineContext = this.$context;
        UndeliveredElementException undeliveredElementExceptionP = b.i.a.f.e.o.f.p(function1, obj, null);
        if (undeliveredElementExceptionP != null) {
            b.i.a.f.e.o.f.u0(coroutineContext, undeliveredElementExceptionP);
        }
        return Unit.a;
    }
}
