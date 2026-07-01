package b.a.v;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.i.a.f.e.o.f;
import com.discord.tooltips.SparkleView;
import d0.l;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
@d0.w.i.a.e(c = "com.discord.tooltips.SparkleView$startAnimation$1$onAnimationEnd$1", f = "SparkleView.kt", l = {61}, m = "invokeSuspend")
public final class d$a extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(d dVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = dVar;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new d$a(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        m.checkNotNullParameter(continuation2, "completion");
        return new d$a(this.this$0, continuation2).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (f.P(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatA = SparkleView.a(this.this$0.a);
        if (animatedVectorDrawableCompatA != null) {
            animatedVectorDrawableCompatA.start();
        }
        return Unit.a;
    }
}
