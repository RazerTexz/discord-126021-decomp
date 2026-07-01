package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.stage.StageChannelJoinHelper;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$configureUI$2$1", f = "WidgetChatListAdapterItemStageInvite.kt", l = {121}, m = "invokeSuspend")
public final class WidgetChatListAdapterItemStageInvite$configureUI$2$1 extends k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public int label;
    public final /* synthetic */ WidgetChatListAdapterItemStageInvite$configureUI$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite$configureUI$2$1(WidgetChatListAdapterItemStageInvite$configureUI$2 widgetChatListAdapterItemStageInvite$configureUI$2, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetChatListAdapterItemStageInvite$configureUI$2;
        this.$guildId = j;
        this.$channelId = j2;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetChatListAdapterItemStageInvite$configureUI$2$1(this.this$0, this.$guildId, this.$channelId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
        return ((WidgetChatListAdapterItemStageInvite$configureUI$2$1) create(modelInvite, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
            Context context = this.this$0.$context;
            m.checkNotNullExpressionValue(context, "context");
            FragmentManager fragmentManager = WidgetChatListAdapterItemStageInvite.access$getAdapter$p(this.this$0.this$0).getFragmentManager();
            long j = this.$guildId;
            long j2 = this.$channelId;
            this.label = 1;
            if (StageChannelJoinHelper.lurkAndJoinStageAsync$default(stageChannelJoinHelper, context, fragmentManager, j, j2, true, null, null, null, this, 224, null) == coroutine_suspended) {
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
