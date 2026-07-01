package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.channel.GuildChannelIconType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic extends WidgetChannelTopicViewModel$ViewState$Guild {
    private final Channel channel;
    private final GuildChannelIconType channelIconType;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic(GuildChannelIconType guildChannelIconType, Channel channel, boolean z2, boolean z3) {
        super(guildChannelIconType, z2, z3, null);
        m.checkNotNullParameter(guildChannelIconType, "channelIconType");
        m.checkNotNullParameter(channel, "channel");
        this.channelIconType = guildChannelIconType;
        this.channel = channel;
        this.isRightPanelOpened = z2;
        this.isOnHomeTab = z3;
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic copy$default(WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic, GuildChannelIconType guildChannelIconType, Channel channel, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guildChannelIconType = widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getChannelIconType();
        }
        if ((i & 2) != 0) {
            channel = widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.channel;
        }
        if ((i & 4) != 0) {
            z2 = widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getIsRightPanelOpened();
        }
        if ((i & 8) != 0) {
            z3 = widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.copy(guildChannelIconType, channel, z2, z3);
    }

    public final GuildChannelIconType component1() {
        return getChannelIconType();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean component3() {
        return getIsRightPanelOpened();
    }

    public final boolean component4() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic copy(GuildChannelIconType channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channelIconType, "channelIconType");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic(channelIconType, channel, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic)) {
            return false;
        }
        WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic = (WidgetChannelTopicViewModel$ViewState$Guild$DefaultTopic) other;
        return m.areEqual(getChannelIconType(), widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getChannelIconType()) && m.areEqual(this.channel, widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.channel) && getIsRightPanelOpened() == widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$ViewState$Guild$DefaultTopic.getIsOnHomeTab();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState$Guild
    public GuildChannelIconType getChannelIconType() {
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
        GuildChannelIconType channelIconType = getChannelIconType();
        int iHashCode = (channelIconType != null ? channelIconType.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r1 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState$Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState
    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState$Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState
    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("DefaultTopic(channelIconType=");
        sbU.append(getChannelIconType());
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isRightPanelOpened=");
        sbU.append(getIsRightPanelOpened());
        sbU.append(", isOnHomeTab=");
        sbU.append(getIsOnHomeTab());
        sbU.append(")");
        return sbU.toString();
    }
}
