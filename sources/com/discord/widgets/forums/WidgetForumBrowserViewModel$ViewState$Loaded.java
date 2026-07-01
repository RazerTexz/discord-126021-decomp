package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumBrowserViewModel$ViewState$Loaded extends WidgetForumBrowserViewModel$ViewState {
    private final boolean canCreateForumChannelPosts;
    private final long channelId;
    private final String channelName;
    private final String channelTopic;
    private final long guildId;
    private final List<ForumBrowserItem> listItems;
    private final WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserViewModel$ViewState$Loaded(WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState, List<? extends ForumBrowserItem> list, boolean z2, String str, String str2, long j, long j2) {
        super(widgetForumBrowserViewModel$NsfwPanelState, null);
        m.checkNotNullParameter(widgetForumBrowserViewModel$NsfwPanelState, "nsfwPanelState");
        m.checkNotNullParameter(list, "listItems");
        m.checkNotNullParameter(str, "channelName");
        this.nsfwPanelState = widgetForumBrowserViewModel$NsfwPanelState;
        this.listItems = list;
        this.canCreateForumChannelPosts = z2;
        this.channelName = str;
        this.channelTopic = str2;
        this.channelId = j;
        this.guildId = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetForumBrowserViewModel$ViewState$Loaded copy$default(WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded, WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState, List list, boolean z2, String str, String str2, long j, long j2, int i, Object obj) {
        return widgetForumBrowserViewModel$ViewState$Loaded.copy((i & 1) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.getNsfwPanelState() : widgetForumBrowserViewModel$NsfwPanelState, (i & 2) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.listItems : list, (i & 4) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.canCreateForumChannelPosts : z2, (i & 8) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.channelName : str, (i & 16) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.channelTopic : str2, (i & 32) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.channelId : j, (i & 64) != 0 ? widgetForumBrowserViewModel$ViewState$Loaded.guildId : j2);
    }

    public final WidgetForumBrowserViewModel$NsfwPanelState component1() {
        return getNsfwPanelState();
    }

    public final List<ForumBrowserItem> component2() {
        return this.listItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanCreateForumChannelPosts() {
        return this.canCreateForumChannelPosts;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getChannelTopic() {
        return this.channelTopic;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetForumBrowserViewModel$ViewState$Loaded copy(WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState, List<? extends ForumBrowserItem> listItems, boolean canCreateForumChannelPosts, String channelName, String channelTopic, long channelId, long guildId) {
        m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
        m.checkNotNullParameter(listItems, "listItems");
        m.checkNotNullParameter(channelName, "channelName");
        return new WidgetForumBrowserViewModel$ViewState$Loaded(nsfwPanelState, listItems, canCreateForumChannelPosts, channelName, channelTopic, channelId, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumBrowserViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetForumBrowserViewModel$ViewState$Loaded widgetForumBrowserViewModel$ViewState$Loaded = (WidgetForumBrowserViewModel$ViewState$Loaded) other;
        return m.areEqual(getNsfwPanelState(), widgetForumBrowserViewModel$ViewState$Loaded.getNsfwPanelState()) && m.areEqual(this.listItems, widgetForumBrowserViewModel$ViewState$Loaded.listItems) && this.canCreateForumChannelPosts == widgetForumBrowserViewModel$ViewState$Loaded.canCreateForumChannelPosts && m.areEqual(this.channelName, widgetForumBrowserViewModel$ViewState$Loaded.channelName) && m.areEqual(this.channelTopic, widgetForumBrowserViewModel$ViewState$Loaded.channelTopic) && this.channelId == widgetForumBrowserViewModel$ViewState$Loaded.channelId && this.guildId == widgetForumBrowserViewModel$ViewState$Loaded.guildId;
    }

    public final boolean getCanCreateForumChannelPosts() {
        return this.canCreateForumChannelPosts;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getChannelTopic() {
        return this.channelTopic;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<ForumBrowserItem> getListItems() {
        return this.listItems;
    }

    @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel$ViewState
    public WidgetForumBrowserViewModel$NsfwPanelState getNsfwPanelState() {
        return this.nsfwPanelState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState = getNsfwPanelState();
        int iHashCode = (nsfwPanelState != null ? nsfwPanelState.hashCode() : 0) * 31;
        List<ForumBrowserItem> list = this.listItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.canCreateForumChannelPosts;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        String str = this.channelName;
        int iHashCode3 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelTopic;
        return b.a(this.guildId) + ((b.a(this.channelId) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(nsfwPanelState=");
        sbU.append(getNsfwPanelState());
        sbU.append(", listItems=");
        sbU.append(this.listItems);
        sbU.append(", canCreateForumChannelPosts=");
        sbU.append(this.canCreateForumChannelPosts);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelTopic=");
        sbU.append(this.channelTopic);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
