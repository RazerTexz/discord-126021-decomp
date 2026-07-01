package com.discord.widgets.user;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMentions$Model implements WidgetChatListAdapter$Data {
    public static final WidgetUserMentions$Model$Companion Companion = new WidgetUserMentions$Model$Companion(null);
    private final boolean animateEmojis;
    private final long channelId;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final long guildId;
    private final String guildName;
    private final boolean isSpoilerClickAllowed;
    private final List<ChatListEntry> list;
    private final Set<Long> myRoleIds;
    private final long newMessagesMarkerMessageId;
    private final long oldestMessageId;
    private final NavigationTab selectedTab;
    private final long userId;

    public WidgetUserMentions$Model(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<ChatListEntry> list, Set<Long> set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab) {
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(set, "myRoleIds");
        m.checkNotNullParameter(navigationTab, "selectedTab");
        this.userId = j;
        this.channelId = j2;
        this.guild = guild;
        this.guildId = j3;
        this.channelNames = map;
        this.oldestMessageId = j4;
        this.list = list;
        this.myRoleIds = set;
        this.newMessagesMarkerMessageId = j5;
        this.isSpoilerClickAllowed = z2;
        this.animateEmojis = z3;
        this.guildName = str;
        this.selectedTab = navigationTab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserMentions$Model copy$default(WidgetUserMentions$Model widgetUserMentions$Model, long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, Object obj) {
        return widgetUserMentions$Model.copy((i & 1) != 0 ? widgetUserMentions$Model.getUserId() : j, (i & 2) != 0 ? widgetUserMentions$Model.getChannelId() : j2, (i & 4) != 0 ? widgetUserMentions$Model.getGuild() : guild, (i & 8) != 0 ? widgetUserMentions$Model.getGuildId() : j3, (i & 16) != 0 ? widgetUserMentions$Model.getChannelNames() : map, (i & 32) != 0 ? widgetUserMentions$Model.getOldestMessageId() : j4, (i & 64) != 0 ? widgetUserMentions$Model.getList() : list, (i & 128) != 0 ? widgetUserMentions$Model.getMyRoleIds() : set, (i & 256) != 0 ? widgetUserMentions$Model.getNewMessagesMarkerMessageId() : j5, (i & 512) != 0 ? widgetUserMentions$Model.getIsSpoilerClickAllowed() : z2, (i & 1024) != 0 ? widgetUserMentions$Model.animateEmojis : z3, (i & 2048) != 0 ? widgetUserMentions$Model.guildName : str, (i & 4096) != 0 ? widgetUserMentions$Model.selectedTab : navigationTab);
    }

    public final long component1() {
        return getUserId();
    }

    public final boolean component10() {
        return getIsSpoilerClickAllowed();
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    public final long component2() {
        return getChannelId();
    }

    public final Guild component3() {
        return getGuild();
    }

    public final long component4() {
        return getGuildId();
    }

    public final Map<Long, String> component5() {
        return getChannelNames();
    }

    public final long component6() {
        return getOldestMessageId();
    }

    public final List<ChatListEntry> component7() {
        return getList();
    }

    public final Set<Long> component8() {
        return getMyRoleIds();
    }

    public final long component9() {
        return getNewMessagesMarkerMessageId();
    }

    public final WidgetUserMentions$Model copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed, boolean animateEmojis, String guildName, NavigationTab selectedTab) {
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(myRoleIds, "myRoleIds");
        m.checkNotNullParameter(selectedTab, "selectedTab");
        return new WidgetUserMentions$Model(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, isSpoilerClickAllowed, animateEmojis, guildName, selectedTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMentions$Model)) {
            return false;
        }
        WidgetUserMentions$Model widgetUserMentions$Model = (WidgetUserMentions$Model) other;
        return getUserId() == widgetUserMentions$Model.getUserId() && getChannelId() == widgetUserMentions$Model.getChannelId() && m.areEqual(getGuild(), widgetUserMentions$Model.getGuild()) && getGuildId() == widgetUserMentions$Model.getGuildId() && m.areEqual(getChannelNames(), widgetUserMentions$Model.getChannelNames()) && getOldestMessageId() == widgetUserMentions$Model.getOldestMessageId() && m.areEqual(getList(), widgetUserMentions$Model.getList()) && m.areEqual(getMyRoleIds(), widgetUserMentions$Model.getMyRoleIds()) && getNewMessagesMarkerMessageId() == widgetUserMentions$Model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == widgetUserMentions$Model.getIsSpoilerClickAllowed() && this.animateEmojis == widgetUserMentions$Model.animateEmojis && m.areEqual(this.guildName, widgetUserMentions$Model.guildName) && m.areEqual(this.selectedTab, widgetUserMentions$Model.selectedTab);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
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

    public final String getGuildName() {
        return this.guildName;
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

    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public int hashCode() {
        int iA = (b.a(getChannelId()) + (b.a(getUserId()) * 31)) * 31;
        Guild guild = getGuild();
        int iA2 = (b.a(getGuildId()) + ((iA + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iA3 = (b.a(getOldestMessageId()) + ((iA2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode = (iA3 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iA4 = (b.a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31;
        boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
        ?? r1 = isSpoilerClickAllowed;
        if (isSpoilerClickAllowed) {
            r1 = 1;
        }
        int i = (iA4 + r1) * 31;
        boolean z2 = this.animateEmojis;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        String str = this.guildName;
        int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        NavigationTab navigationTab = this.selectedTab;
        return iHashCode2 + (navigationTab != null ? navigationTab.hashCode() : 0);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(userId=");
        sbU.append(getUserId());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", oldestMessageId=");
        sbU.append(getOldestMessageId());
        sbU.append(", list=");
        sbU.append(getList());
        sbU.append(", myRoleIds=");
        sbU.append(getMyRoleIds());
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(getNewMessagesMarkerMessageId());
        sbU.append(", isSpoilerClickAllowed=");
        sbU.append(getIsSpoilerClickAllowed());
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", selectedTab=");
        sbU.append(this.selectedTab);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetUserMentions$Model(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, guild, j3, map, j4, list, set, j5, (i & 512) != 0 ? false : z2, z3, str, navigationTab);
    }
}
