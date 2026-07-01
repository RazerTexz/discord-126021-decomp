package com.discord.widgets.chat.list.adapter;

import com.discord.models.domain.ModelInvite;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2", f = "WidgetChatListAdapterItemInviteBase.kt", l = {}, m = "invokeSuspend")
public final class WidgetChatListAdapterItemInviteBase$joinServerOrDM$2 extends k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
    public int label;

    public WidgetChatListAdapterItemInviteBase$joinServerOrDM$2(Continuation continuation) {
        super(2, continuation);
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetChatListAdapterItemInviteBase$joinServerOrDM$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
        return ((WidgetChatListAdapterItemInviteBase$joinServerOrDM$2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        return Unit.a;
    }
}
