package b.a.a.a0;

import com.discord.rlottie.RLottieImageView;
import d0.l;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@d0.w.i.a.e(c = "com.discord.dialogs.gifting.WidgetGiftAcceptDialog$configureUI$1$1", f = "WidgetGiftAcceptDialog.kt", l = {118}, m = "invokeSuspend")
public final class c$c extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ RLottieImageView $this_apply;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$c(RLottieImageView rLottieImageView, Continuation continuation) {
        super(2, continuation);
        this.$this_apply = rLottieImageView;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new c$c(this.$this_apply, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        m.checkNotNullParameter(continuation2, "completion");
        return new c$c(this.$this_apply, continuation2).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (b.i.a.f.e.o.f.P(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        this.$this_apply.b();
        return Unit.a;
    }
}
