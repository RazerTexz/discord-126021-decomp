package d0.w.h;

import d0.l;
import d0.w.i.a.i;
import d0.z.d.e0;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends i {
    public final /* synthetic */ Continuation $completion;
    public final /* synthetic */ Object $receiver$inlined;
    public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$a(Continuation continuation, Continuation continuation2, Function2 function2, Object obj) {
        super(continuation2);
        this.$completion = continuation;
        this.$this_createCoroutineUnintercepted$inlined = function2;
        this.$receiver$inlined = obj;
    }

    @Override // d0.w.i.a.a
    public Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.label = 2;
            l.throwOnFailure(obj);
            return obj;
        }
        this.label = 1;
        l.throwOnFailure(obj);
        Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
        Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        return ((Function2) e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
    }
}
