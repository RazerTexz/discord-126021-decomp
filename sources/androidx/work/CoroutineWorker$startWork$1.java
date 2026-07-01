package androidx.work;

import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
public final class CoroutineWorker$startWork$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object L$0;
    public int label;
    private CoroutineScope p$;
    public final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coroutineWorker;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkParameterIsNotNull(continuation, "completion");
        CoroutineWorker$startWork$1 coroutineWorker$startWork$1 = new CoroutineWorker$startWork$1(this.this$0, continuation);
        coroutineWorker$startWork$1.p$ = (CoroutineScope) obj;
        return coroutineWorker$startWork$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineWorker$startWork$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                l.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = coroutineWorker.doWork(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            this.this$0.getFuture$work_runtime_ktx_release().set((ListenableWorker$Result) obj);
        } catch (Throwable th) {
            this.this$0.getFuture$work_runtime_ktx_release().setException(th);
        }
        return Unit.a;
    }
}
