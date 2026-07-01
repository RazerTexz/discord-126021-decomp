package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.message.MessageReference;
import com.discord.models.message.Message;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    public WidgetChatListAdapterItemSystemMessage$onConfigure$1(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message) {
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$message = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Integer type = this.$message.getType();
        if (type != null && type.intValue() == 7) {
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getData().getGuildId());
            return;
        }
        if ((type != null && type.intValue() == 8) || ((type != null && type.intValue() == 9) || ((type != null && type.intValue() == 10) || (type != null && type.intValue() == 11)))) {
            AnalyticsTracker.guildBoostPromotionOpened$default(AnalyticsTracker.INSTANCE, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getData().getGuildId(), new Traits$Location(null, Traits$Location$Section.CHANNEL_TEXT_AREA, Traits$Location$Obj.BOOST_GEM_ICON, null, null, 25, null), null, 4, null);
            WidgetGuildBoost$Companion widgetGuildBoost$Companion = WidgetGuildBoost.Companion;
            LinkifiedTextView linkifiedTextView = WidgetChatListAdapterItemSystemMessage.access$getBinding$p(this.this$0).h;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
            Context context = linkifiedTextView.getContext();
            m.checkNotNullExpressionValue(context, "binding.systemText.context");
            widgetGuildBoost$Companion.create(context, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getData().getGuildId());
            return;
        }
        if (type != null && type.intValue() == 12) {
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getData().getGuildId());
            return;
        }
        if (type != null && type.intValue() == 6) {
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler().onOpenPinsClicked(this.$message);
            return;
        }
        if (type != null && type.intValue() == 18) {
            MessageReference messageReference = this.$message.getMessageReference();
            Long channelId = messageReference != null ? messageReference.getChannelId() : null;
            if (channelId != null) {
                ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getData().getGuildId(), channelId.longValue(), null, null, 12, null);
            }
        }
    }
}
