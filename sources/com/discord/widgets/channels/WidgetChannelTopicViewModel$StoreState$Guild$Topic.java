package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.channel.GuildChannelIconType;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$StoreState$Guild$Topic extends WidgetChannelTopicViewModel$StoreState$Guild {
    private final boolean allowAnimatedEmojis;
    private final Channel channel;
    private final GuildChannelIconType channelIconType;
    private final Map<Long, Channel> channels;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;
    private final Map<Long, GuildMember> members;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, User> users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelTopicViewModel$StoreState$Guild$Topic(Channel channel, Map<Long, Channel> map, GuildChannelIconType guildChannelIconType, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, boolean z2, boolean z3, boolean z4) {
        super(z3, z4, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(guildChannelIconType, "channelIconType");
        m.checkNotNullParameter(map2, "users");
        m.checkNotNullParameter(map3, "members");
        m.checkNotNullParameter(map4, "roles");
        this.channel = channel;
        this.channels = map;
        this.channelIconType = guildChannelIconType;
        this.users = map2;
        this.members = map3;
        this.roles = map4;
        this.allowAnimatedEmojis = z2;
        this.isRightPanelOpened = z3;
        this.isOnHomeTab = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelTopicViewModel$StoreState$Guild$Topic copy$default(WidgetChannelTopicViewModel$StoreState$Guild$Topic widgetChannelTopicViewModel$StoreState$Guild$Topic, Channel channel, Map map, GuildChannelIconType guildChannelIconType, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return widgetChannelTopicViewModel$StoreState$Guild$Topic.copy((i & 1) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.channel : channel, (i & 2) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.channels : map, (i & 4) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.channelIconType : guildChannelIconType, (i & 8) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.users : map2, (i & 16) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.members : map3, (i & 32) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.roles : map4, (i & 64) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.allowAnimatedEmojis : z2, (i & 128) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.getIsRightPanelOpened() : z3, (i & 256) != 0 ? widgetChannelTopicViewModel$StoreState$Guild$Topic.getIsOnHomeTab() : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, Channel> component2() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildChannelIconType getChannelIconType() {
        return this.channelIconType;
    }

    public final Map<Long, User> component4() {
        return this.users;
    }

    public final Map<Long, GuildMember> component5() {
        return this.members;
    }

    public final Map<Long, GuildRole> component6() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final boolean component8() {
        return getIsRightPanelOpened();
    }

    public final boolean component9() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$StoreState$Guild$Topic copy(Channel channel, Map<Long, Channel> channels, GuildChannelIconType channelIconType, Map<Long, ? extends User> users, Map<Long, GuildMember> members, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(channelIconType, "channelIconType");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(members, "members");
        m.checkNotNullParameter(roles, "roles");
        return new WidgetChannelTopicViewModel$StoreState$Guild$Topic(channel, channels, channelIconType, users, members, roles, allowAnimatedEmojis, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$StoreState$Guild$Topic)) {
            return false;
        }
        WidgetChannelTopicViewModel$StoreState$Guild$Topic widgetChannelTopicViewModel$StoreState$Guild$Topic = (WidgetChannelTopicViewModel$StoreState$Guild$Topic) other;
        return m.areEqual(this.channel, widgetChannelTopicViewModel$StoreState$Guild$Topic.channel) && m.areEqual(this.channels, widgetChannelTopicViewModel$StoreState$Guild$Topic.channels) && m.areEqual(this.channelIconType, widgetChannelTopicViewModel$StoreState$Guild$Topic.channelIconType) && m.areEqual(this.users, widgetChannelTopicViewModel$StoreState$Guild$Topic.users) && m.areEqual(this.members, widgetChannelTopicViewModel$StoreState$Guild$Topic.members) && m.areEqual(this.roles, widgetChannelTopicViewModel$StoreState$Guild$Topic.roles) && this.allowAnimatedEmojis == widgetChannelTopicViewModel$StoreState$Guild$Topic.allowAnimatedEmojis && getIsRightPanelOpened() == widgetChannelTopicViewModel$StoreState$Guild$Topic.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$StoreState$Guild$Topic.getIsOnHomeTab();
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildChannelIconType getChannelIconType() {
        return this.channelIconType;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Map<Long, GuildMember> getMembers() {
        return this.members;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.channels;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        GuildChannelIconType guildChannelIconType = this.channelIconType;
        int iHashCode3 = (iHashCode2 + (guildChannelIconType != null ? guildChannelIconType.hashCode() : 0)) * 31;
        Map<Long, User> map2 = this.users;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map3 = this.members;
        int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map4 = this.roles;
        int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode6 + r1) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r2 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
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
        StringBuilder sbU = a.U("Topic(channel=");
        sbU.append(this.channel);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelIconType=");
        sbU.append(this.channelIconType);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", isRightPanelOpened=");
        sbU.append(getIsRightPanelOpened());
        sbU.append(", isOnHomeTab=");
        sbU.append(getIsOnHomeTab());
        sbU.append(")");
        return sbU.toString();
    }
}
