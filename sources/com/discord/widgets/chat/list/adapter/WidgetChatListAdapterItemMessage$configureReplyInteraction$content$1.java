package com.discord.widgets.chat.list.adapter;

import com.discord.api.interaction.Interaction;
import com.discord.api.user.User;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ User $interactionUser;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Interaction interaction, Message message, User user) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$interaction = interaction;
        this.$message = message;
        this.$interactionUser = user;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("commandNameOnClick", new WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1(this));
    }
}
