package com.discord.views.calls;

import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SpeakerPulseView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1$1", f = "SpeakerPulseView.kt", l = {88}, m = "invokeSuspend")
public final class SpeakerPulseView$f$a extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SpeakerPulseView$f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView$f$a(SpeakerPulseView$f speakerPulseView$f, Continuation continuation) {
        super(2, continuation);
        this.this$0 = speakerPulseView$f;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        SpeakerPulseView$f$a speakerPulseView$f$a = new SpeakerPulseView$f$a(this.this$0, continuation);
        speakerPulseView$f$a.L$0 = obj;
        return speakerPulseView$f$a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        m.checkNotNullParameter(continuation2, "completion");
        SpeakerPulseView$f$a speakerPulseView$f$a = new SpeakerPulseView$f$a(this.this$0, continuation2);
        speakerPulseView$f$a.L$0 = coroutineScope;
        return speakerPulseView$f$a.invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            SpeakerPulseView speakerPulseView = this.this$0.this$0;
            this.label = 1;
            if (speakerPulseView.e(coroutineScope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
