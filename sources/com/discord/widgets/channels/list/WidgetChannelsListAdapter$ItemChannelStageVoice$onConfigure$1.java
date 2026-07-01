package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ChannelListItem $data;
    public final /* synthetic */ boolean $isGuildRoleSubscriptionLockedChannel;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemChannelStageVoice this$0;

    public WidgetChannelsListAdapter$ItemChannelStageVoice$onConfigure$1(WidgetChannelsListAdapter$ItemChannelStageVoice widgetChannelsListAdapter$ItemChannelStageVoice, boolean z2, ChannelListItem channelListItem) {
        this.this$0 = widgetChannelsListAdapter$ItemChannelStageVoice;
        this.$isGuildRoleSubscriptionLockedChannel = z2;
        this.$data = channelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$isGuildRoleSubscriptionLockedChannel) {
            WidgetChannelsListAdapter$ItemChannelStageVoice.access$getAdapter$p(this.this$0).getOnSelectGuildRoleSubscriptionLockedChannel().invoke(((ChannelListItemStageVoiceChannel) this.$data).getChannel());
        } else {
            WidgetChannelsListAdapter$ItemChannelStageVoice.access$getAdapter$p(this.this$0).getOnCallChannel().invoke(((ChannelListItemStageVoiceChannel) this.$data).getChannel());
        }
    }
}
