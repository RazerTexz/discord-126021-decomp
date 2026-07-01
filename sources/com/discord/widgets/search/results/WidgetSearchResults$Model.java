package com.discord.widgets.search.results;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSearchResults$Model implements WidgetChatListAdapter$Data {
    public static final WidgetSearchResults$Model$Companion Companion = new WidgetSearchResults$Model$Companion(null);
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
    public WidgetSearchResults$Model(List<? extends ChatListEntry> list, long j, Map<Long, String> map, long j2, Set<Long> set) {
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(set, "myRoleIds");
        this.list = list;
        this.userId = j;
        this.channelNames = map;
        this.oldestMessageId = j2;
        this.myRoleIds = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSearchResults$Model copy$default(WidgetSearchResults$Model widgetSearchResults$Model, List list, long j, Map map, long j2, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetSearchResults$Model.getList();
        }
        if ((i & 2) != 0) {
            j = widgetSearchResults$Model.getUserId();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            map = widgetSearchResults$Model.getChannelNames();
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            j2 = widgetSearchResults$Model.getOldestMessageId();
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            set = widgetSearchResults$Model.getMyRoleIds();
        }
        return widgetSearchResults$Model.copy(list, j3, map2, j4, set);
    }

    public final List<ChatListEntry> component1() {
        return getList();
    }

    public final long component2() {
        return getUserId();
    }

    public final Map<Long, String> component3() {
        return getChannelNames();
    }

    public final long component4() {
        return getOldestMessageId();
    }

    public final Set<Long> component5() {
        return getMyRoleIds();
    }

    public final WidgetSearchResults$Model copy(List<? extends ChatListEntry> list, long userId, Map<Long, String> channelNames, long oldestMessageId, Set<Long> myRoleIds) {
        m.checkNotNullParameter(list, "list");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(myRoleIds, "myRoleIds");
        return new WidgetSearchResults$Model(list, userId, channelNames, oldestMessageId, myRoleIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSearchResults$Model)) {
            return false;
        }
        WidgetSearchResults$Model widgetSearchResults$Model = (WidgetSearchResults$Model) other;
        return m.areEqual(getList(), widgetSearchResults$Model.getList()) && getUserId() == widgetSearchResults$Model.getUserId() && m.areEqual(getChannelNames(), widgetSearchResults$Model.getChannelNames()) && getOldestMessageId() == widgetSearchResults$Model.getOldestMessageId() && m.areEqual(getMyRoleIds(), widgetSearchResults$Model.getMyRoleIds());
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

    public int hashCode() {
        List<ChatListEntry> list = getList();
        int iA = (b.a(getUserId()) + ((list != null ? list.hashCode() : 0) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iA2 = (b.a(getOldestMessageId()) + ((iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        return iA2 + (myRoleIds != null ? myRoleIds.hashCode() : 0);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(list=");
        sbU.append(getList());
        sbU.append(", userId=");
        sbU.append(getUserId());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", oldestMessageId=");
        sbU.append(getOldestMessageId());
        sbU.append(", myRoleIds=");
        sbU.append(getMyRoleIds());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetSearchResults$Model(List list, long j, Map map, long j2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? 0L : j, map, j2, set);
    }
}
