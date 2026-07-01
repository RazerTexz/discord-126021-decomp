package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.channel.GuildChannelIconType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic extends WidgetChannelTopicViewModel$StoreState$Guild {
    private final Channel channel;
    private final GuildChannelIconType channelIconType;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic(Channel channel, GuildChannelIconType guildChannelIconType, boolean z2, boolean z3) {
        super(z2, z3, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildChannelIconType, "channelIconType");
        this.channel = channel;
        this.channelIconType = guildChannelIconType;
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic copy$default(WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic, Channel channel, GuildChannelIconType guildChannelIconType, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.channel;
        }
        if ((i & 2) != 0) {
            guildChannelIconType = widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.channelIconType;
        }
        if ((i & 4) != 0) {
            z2 = widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getIsRightPanelOpened();
        }
        if ((i & 8) != 0) {
            z3 = widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.copy(channel, guildChannelIconType, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildChannelIconType getChannelIconType() {
        return this.channelIconType;
    }

    public final boolean component3() {
        return getIsRightPanelOpened();
    }

    public final boolean component4() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic copy(Channel channel, GuildChannelIconType channelIconType, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelIconType, "channelIconType");
        return new WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic(channel, channelIconType, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic)) {
            return false;
        }
        WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic = (WidgetChannelTopicViewModel$StoreState$Guild$DefaultTopic) other;
        return m.areEqual(this.channel, widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.channel) && m.areEqual(this.channelIconType, widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.channelIconType) && getIsRightPanelOpened() == widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$StoreState$Guild$DefaultTopic.getIsOnHomeTab();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildChannelIconType getChannelIconType() {
        return this.channelIconType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        GuildChannelIconType guildChannelIconType = this.channelIconType;
        int iHashCode2 = (iHashCode + (guildChannelIconType != null ? guildChannelIconType.hashCode() : 0)) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r1 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState$Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState$Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("DefaultTopic(channel=");
        sbU.append(this.channel);
        sbU.append(", channelIconType=");
        sbU.append(this.channelIconType);
        sbU.append(", isRightPanelOpened=");
        sbU.append(getIsRightPanelOpened());
        sbU.append(", isOnHomeTab=");
        sbU.append(getIsOnHomeTab());
        sbU.append(")");
        return sbU.toString();
    }
}
