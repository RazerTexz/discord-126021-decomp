package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.api.user.User;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1$1(WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1 widgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Guild guild = WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0.this$0.this$0).getData().getGuild();
        Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
        Long id2 = this.this$0.this$0.$interaction.getId();
        if (id2 != null) {
            long jLongValue = id2.longValue();
            if (!this.this$0.this$0.$message.isLocalApplicationCommand() || this.this$0.this$0.$message.isFailed()) {
                Integer type = this.this$0.this$0.$message.getType();
                if (type != null && type.intValue() == 23) {
                    return;
                }
                WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0.this$0.this$0).getEventHandler();
                long channelId = this.this$0.this$0.$message.getChannelId();
                long id3 = this.this$0.this$0.$message.getId();
                long id4 = this.this$0.this$0.$interactionUser.getId();
                User author = this.this$0.this$0.$message.getAuthor();
                m.checkNotNull(author);
                eventHandler.onCommandClicked(jLongValue, lValueOf, channelId, id3, id4, author.getId(), this.this$0.this$0.$message.getNonce());
            }
        }
    }
}
