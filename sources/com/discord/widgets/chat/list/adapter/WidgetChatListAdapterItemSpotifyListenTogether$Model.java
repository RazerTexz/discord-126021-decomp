package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.models.presence.Presence;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemSpotifyListenTogether$Model {
    public static final WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion Companion = new WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion(null);
    private final boolean isMe;
    private final SpotifyListenTogetherEntry item;
    private final Presence presence;
    private final List<CollapsedUser> users;

    public WidgetChatListAdapterItemSpotifyListenTogether$Model(Presence presence, List<CollapsedUser> list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
        m.checkNotNullParameter(list, "users");
        m.checkNotNullParameter(spotifyListenTogetherEntry, "item");
        this.presence = presence;
        this.users = list;
        this.item = spotifyListenTogetherEntry;
        this.isMe = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether$Model copy$default(WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model, Presence presence, List list, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            presence = widgetChatListAdapterItemSpotifyListenTogether$Model.presence;
        }
        if ((i & 2) != 0) {
            list = widgetChatListAdapterItemSpotifyListenTogether$Model.users;
        }
        if ((i & 4) != 0) {
            spotifyListenTogetherEntry = widgetChatListAdapterItemSpotifyListenTogether$Model.item;
        }
        if ((i & 8) != 0) {
            z2 = widgetChatListAdapterItemSpotifyListenTogether$Model.isMe;
        }
        return widgetChatListAdapterItemSpotifyListenTogether$Model.copy(presence, list, spotifyListenTogetherEntry, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    public final List<CollapsedUser> component2() {
        return this.users;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SpotifyListenTogetherEntry getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    public final WidgetChatListAdapterItemSpotifyListenTogether$Model copy(Presence presence, List<CollapsedUser> users, SpotifyListenTogetherEntry item, boolean isMe) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(item, "item");
        return new WidgetChatListAdapterItemSpotifyListenTogether$Model(presence, users, item, isMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemSpotifyListenTogether$Model)) {
            return false;
        }
        WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model = (WidgetChatListAdapterItemSpotifyListenTogether$Model) other;
        return m.areEqual(this.presence, widgetChatListAdapterItemSpotifyListenTogether$Model.presence) && m.areEqual(this.users, widgetChatListAdapterItemSpotifyListenTogether$Model.users) && m.areEqual(this.item, widgetChatListAdapterItemSpotifyListenTogether$Model.item) && this.isMe == widgetChatListAdapterItemSpotifyListenTogether$Model.isMe;
    }

    public final SpotifyListenTogetherEntry getItem() {
        return this.item;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final List<CollapsedUser> getUsers() {
        return this.users;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Presence presence = this.presence;
        int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
        List<CollapsedUser> list = this.users;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        SpotifyListenTogetherEntry spotifyListenTogetherEntry = this.item;
        int iHashCode3 = (iHashCode2 + (spotifyListenTogetherEntry != null ? spotifyListenTogetherEntry.hashCode() : 0)) * 31;
        boolean z2 = this.isMe;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(presence=");
        sbU.append(this.presence);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", item=");
        sbU.append(this.item);
        sbU.append(", isMe=");
        return a.O(sbU, this.isMe, ")");
    }
}
