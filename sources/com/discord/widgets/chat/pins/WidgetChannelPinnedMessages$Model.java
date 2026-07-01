package com.discord.widgets.chat.pins;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelPinnedMessages$Model implements WidgetChatListAdapter$Data {
    public static final WidgetChannelPinnedMessages$Model$Companion Companion = new WidgetChannelPinnedMessages$Model$Companion(null);
    private final Channel channel;
    private final long channelId;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final long guildId;
    private final boolean isSpoilerClickAllowed;
    private final List<ChatListEntry> list;
    private final Set<Long> myRoleIds;
    private final long newMessagesMarkerMessageId;
    private final long oldestMessageId;
    private final long userId;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelPinnedMessages$Model(Channel channel, Guild guild, long j, Map<Long, String> map, List<? extends ChatListEntry> list, Set<Long> set, long j2, long j3, long j4, long j5, boolean z2) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(set, "myRoleIds");
        this.channel = channel;
        this.guild = guild;
        this.userId = j;
        this.channelNames = map;
        this.list = list;
        this.myRoleIds = set;
        this.channelId = j2;
        this.guildId = j3;
        this.oldestMessageId = j4;
        this.newMessagesMarkerMessageId = j5;
        this.isSpoilerClickAllowed = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelPinnedMessages$Model copy$default(WidgetChannelPinnedMessages$Model widgetChannelPinnedMessages$Model, Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, Object obj) {
        return widgetChannelPinnedMessages$Model.copy((i & 1) != 0 ? widgetChannelPinnedMessages$Model.channel : channel, (i & 2) != 0 ? widgetChannelPinnedMessages$Model.getGuild() : guild, (i & 4) != 0 ? widgetChannelPinnedMessages$Model.getUserId() : j, (i & 8) != 0 ? widgetChannelPinnedMessages$Model.getChannelNames() : map, (i & 16) != 0 ? widgetChannelPinnedMessages$Model.getList() : list, (i & 32) != 0 ? widgetChannelPinnedMessages$Model.getMyRoleIds() : set, (i & 64) != 0 ? widgetChannelPinnedMessages$Model.getChannelId() : j2, (i & 128) != 0 ? widgetChannelPinnedMessages$Model.getGuildId() : j3, (i & 256) != 0 ? widgetChannelPinnedMessages$Model.getOldestMessageId() : j4, (i & 512) != 0 ? widgetChannelPinnedMessages$Model.getNewMessagesMarkerMessageId() : j5, (i & 1024) != 0 ? widgetChannelPinnedMessages$Model.getIsSpoilerClickAllowed() : z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final long component10() {
        return getNewMessagesMarkerMessageId();
    }

    public final boolean component11() {
        return getIsSpoilerClickAllowed();
    }

    public final Guild component2() {
        return getGuild();
    }

    public final long component3() {
        return getUserId();
    }

    public final Map<Long, String> component4() {
        return getChannelNames();
    }

    public final List<ChatListEntry> component5() {
        return getList();
    }

    public final Set<Long> component6() {
        return getMyRoleIds();
    }

    public final long component7() {
        return getChannelId();
    }

    public final long component8() {
        return getGuildId();
    }

    public final long component9() {
        return getOldestMessageId();
    }

    public final WidgetChannelPinnedMessages$Model copy(Channel channel, Guild guild, long userId, Map<Long, String> channelNames, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long channelId, long guildId, long oldestMessageId, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(myRoleIds, "myRoleIds");
        return new WidgetChannelPinnedMessages$Model(channel, guild, userId, channelNames, list, myRoleIds, channelId, guildId, oldestMessageId, newMessagesMarkerMessageId, isSpoilerClickAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelPinnedMessages$Model)) {
            return false;
        }
        WidgetChannelPinnedMessages$Model widgetChannelPinnedMessages$Model = (WidgetChannelPinnedMessages$Model) other;
        return m.areEqual(this.channel, widgetChannelPinnedMessages$Model.channel) && m.areEqual(getGuild(), widgetChannelPinnedMessages$Model.getGuild()) && getUserId() == widgetChannelPinnedMessages$Model.getUserId() && m.areEqual(getChannelNames(), widgetChannelPinnedMessages$Model.getChannelNames()) && m.areEqual(getList(), widgetChannelPinnedMessages$Model.getList()) && m.areEqual(getMyRoleIds(), widgetChannelPinnedMessages$Model.getMyRoleIds()) && getChannelId() == widgetChannelPinnedMessages$Model.getChannelId() && getGuildId() == widgetChannelPinnedMessages$Model.getGuildId() && getOldestMessageId() == widgetChannelPinnedMessages$Model.getOldestMessageId() && getNewMessagesMarkerMessageId() == widgetChannelPinnedMessages$Model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == widgetChannelPinnedMessages$Model.getIsSpoilerClickAllowed();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public List<ChatListEntry> getList() {
        return this.list;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Set<Long> getMyRoleIds() {
        return this.myRoleIds;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getOldestMessageId() {
        return this.oldestMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Guild guild = getGuild();
        int iA = (b.a(getUserId()) + ((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iHashCode2 = (iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iA2 = (b.a(getNewMessagesMarkerMessageId()) + ((b.a(getOldestMessageId()) + ((b.a(getGuildId()) + ((b.a(getChannelId()) + ((iHashCode3 + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
        ?? r0 = isSpoilerClickAllowed;
        if (isSpoilerClickAllowed) {
            r0 = 1;
        }
        return iA2 + r0;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(", userId=");
        sbU.append(getUserId());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", list=");
        sbU.append(getList());
        sbU.append(", myRoleIds=");
        sbU.append(getMyRoleIds());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", oldestMessageId=");
        sbU.append(getOldestMessageId());
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(getNewMessagesMarkerMessageId());
        sbU.append(", isSpoilerClickAllowed=");
        sbU.append(getIsSpoilerClickAllowed());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetChannelPinnedMessages$Model(Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, guild, j, map, list, set, (i & 64) != 0 ? channel.getId() : j2, (i & 128) != 0 ? channel.getGuildId() : j3, (i & 256) != 0 ? 0L : j4, (i & 512) != 0 ? 0L : j5, (i & 1024) != 0 ? false : z2);
    }
}
