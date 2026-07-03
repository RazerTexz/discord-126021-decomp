package p659s.p660a.p661a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: s.a.a.o */
/* JADX INFO: compiled from: OnUndeliveredElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13032o extends AbstractC12240o implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Function1 $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13032o(Function1 function1, Object obj, CoroutineContext coroutineContext) {
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
        UndeliveredElementException undeliveredElementExceptionM4327p = C3404f.m4327p(function1, obj, null);
        if (undeliveredElementExceptionM4327p != null) {
            C3404f.m4348u0(coroutineContext, undeliveredElementExceptionM4327p);
        }
        return Unit.f27425a;
    }
}
