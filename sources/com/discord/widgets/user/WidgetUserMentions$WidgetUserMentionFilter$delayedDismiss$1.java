package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "com.discord.widgets.user.WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1", m10085f = "WidgetUserMentions.kt", m10086l = {386}, m10087m = "invokeSuspend")
public final class WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WidgetUserMentions.WidgetUserMentionFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetUserMentionFilter;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            this.label = 1;
            if (C3404f.m4234P(600L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
        }
        this.this$0.dismiss();
        return Unit.f27425a;
    }
}
