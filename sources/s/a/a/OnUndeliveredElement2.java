package s.a.a;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;

/* JADX INFO: renamed from: s.a.a.o, reason: use source file name */
/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OnUndeliveredElement2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Function1 $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElement2(Function1 function1, Object obj, CoroutineContext coroutineContext) {
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
        OnUndeliveredElement onUndeliveredElementP = b.i.a.f.e.o.f.p(function1, obj, null);
        if (onUndeliveredElementP != null) {
            b.i.a.f.e.o.f.u0(coroutineContext, onUndeliveredElementP);
        }
        return Unit.a;
    }
}
