package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.channel.GuildChannelIconType;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$ViewState$Guild$Topic extends WidgetChannelTopicViewModel$ViewState$Guild {
    private final boolean allowAnimatedEmojis;
    private final List<Node<MessageRenderContext>> ast;
    private final Channel channel;
    private final GuildChannelIconType channelIconType;
    private final Map<Long, String> channelNames;
    private final boolean isLinkifyConflicting;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;
    private final String rawTopicString;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, String> userNames;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel$ViewState$Guild$Topic(String str, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, boolean z2, List<Node<MessageRenderContext>> list, boolean z3, GuildChannelIconType guildChannelIconType, Channel channel, boolean z4, boolean z5) {
        super(guildChannelIconType, z4, z5, null);
        m.checkNotNullParameter(str, "rawTopicString");
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(map2, "userNames");
        m.checkNotNullParameter(map3, "roles");
        m.checkNotNullParameter(list, "ast");
        m.checkNotNullParameter(guildChannelIconType, "channelIconType");
        m.checkNotNullParameter(channel, "channel");
        this.rawTopicString = str;
        this.channelNames = map;
        this.userNames = map2;
        this.roles = map3;
        this.allowAnimatedEmojis = z2;
        this.ast = list;
        this.isLinkifyConflicting = z3;
        this.channelIconType = guildChannelIconType;
        this.channel = channel;
        this.isRightPanelOpened = z4;
        this.isOnHomeTab = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelTopicViewModel$ViewState$Guild$Topic copy$default(WidgetChannelTopicViewModel$ViewState$Guild$Topic widgetChannelTopicViewModel$ViewState$Guild$Topic, String str, Map map, Map map2, Map map3, boolean z2, List list, boolean z3, GuildChannelIconType guildChannelIconType, Channel channel, boolean z4, boolean z5, int i, Object obj) {
        return widgetChannelTopicViewModel$ViewState$Guild$Topic.copy((i & 1) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.rawTopicString : str, (i & 2) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.channelNames : map, (i & 4) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.userNames : map2, (i & 8) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.roles : map3, (i & 16) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.allowAnimatedEmojis : z2, (i & 32) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.ast : list, (i & 64) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.isLinkifyConflicting : z3, (i & 128) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.getChannelIconType() : guildChannelIconType, (i & 256) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.channel : channel, (i & 512) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.getIsRightPanelOpened() : z4, (i & 1024) != 0 ? widgetChannelTopicViewModel$ViewState$Guild$Topic.getIsOnHomeTab() : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRawTopicString() {
        return this.rawTopicString;
    }

    public final boolean component10() {
        return getIsRightPanelOpened();
    }

    public final boolean component11() {
        return getIsOnHomeTab();
    }

    public final Map<Long, String> component2() {
        return this.channelNames;
    }

    public final Map<Long, String> component3() {
        return this.userNames;
    }

    public final Map<Long, GuildRole> component4() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final List<Node<MessageRenderContext>> component6() {
        return this.ast;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsLinkifyConflicting() {
        return this.isLinkifyConflicting;
    }

    public final GuildChannelIconType component8() {
        return getChannelIconType();
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetChannelTopicViewModel$ViewState$Guild$Topic copy(String rawTopicString, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, List<Node<MessageRenderContext>> ast, boolean isLinkifyConflicting, GuildChannelIconType channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(rawTopicString, "rawTopicString");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(userNames, "userNames");
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(ast, "ast");
        m.checkNotNullParameter(channelIconType, "channelIconType");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelTopicViewModel$ViewState$Guild$Topic(rawTopicString, channelNames, userNames, roles, allowAnimatedEmojis, ast, isLinkifyConflicting, channelIconType, channel, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$ViewState$Guild$Topic)) {
            return false;
        }
        WidgetChannelTopicViewModel$ViewState$Guild$Topic widgetChannelTopicViewModel$ViewState$Guild$Topic = (WidgetChannelTopicViewModel$ViewState$Guild$Topic) other;
        return m.areEqual(this.rawTopicString, widgetChannelTopicViewModel$ViewState$Guild$Topic.rawTopicString) && m.areEqual(this.channelNames, widgetChannelTopicViewModel$ViewState$Guild$Topic.channelNames) && m.areEqual(this.userNames, widgetChannelTopicViewModel$ViewState$Guild$Topic.userNames) && m.areEqual(this.roles, widgetChannelTopicViewModel$ViewState$Guild$Topic.roles) && this.allowAnimatedEmojis == widgetChannelTopicViewModel$ViewState$Guild$Topic.allowAnimatedEmojis && m.areEqual(this.ast, widgetChannelTopicViewModel$ViewState$Guild$Topic.ast) && this.isLinkifyConflicting == widgetChannelTopicViewModel$ViewState$Guild$Topic.isLinkifyConflicting && m.areEqual(getChannelIconType(), widgetChannelTopicViewModel$ViewState$Guild$Topic.getChannelIconType()) && m.areEqual(this.channel, widgetChannelTopicViewModel$ViewState$Guild$Topic.channel) && getIsRightPanelOpened() == widgetChannelTopicViewModel$ViewState$Guild$Topic.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$ViewState$Guild$Topic.getIsOnHomeTab();
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final List<Node<MessageRenderContext>> getAst() {
        return this.ast;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState$Guild
    public GuildChannelIconType getChannelIconType() {
        return this.channelIconType;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final String getRawTopicString() {
        return this.rawTopicString;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, String> getUserNames() {
        return this.userNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.rawTopicString;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<Long, String> map = this.channelNames;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.userNames;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map3 = this.roles;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        List<Node<MessageRenderContext>> list = this.ast;
        int iHashCode5 = (i + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.isLinkifyConflicting;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode5 + r3) * 31;
        GuildChannelIconType channelIconType = getChannelIconType();
        int iHashCode6 = (i2 + (channelIconType != null ? channelIconType.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r1 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r1 = 1;
        }
        int i3 = (iHashCode7 + r1) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    public final boolean isLinkifyConflicting() {
        return this.isLinkifyConflicting;
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
        StringBuilder sbU = a.U("Topic(rawTopicString=");
        sbU.append(this.rawTopicString);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", userNames=");
        sbU.append(this.userNames);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", ast=");
        sbU.append(this.ast);
        sbU.append(", isLinkifyConflicting=");
        sbU.append(this.isLinkifyConflicting);
        sbU.append(", channelIconType=");
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
