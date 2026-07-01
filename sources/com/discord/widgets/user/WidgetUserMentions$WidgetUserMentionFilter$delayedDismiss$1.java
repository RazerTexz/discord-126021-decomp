package com.discord.widgets.user;

import b.i.a.f.e.o.f;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "com.discord.widgets.user.WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1", f = "WidgetUserMentions.kt", l = {386}, m = "invokeSuspend")
public final class WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WidgetUserMentions$WidgetUserMentionFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetUserMentions$WidgetUserMentionFilter;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (f.P(600L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        this.this$0.dismiss();
        return Unit.a;
    }
}
