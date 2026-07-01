package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGroupInviteFriends$Model$FriendItem implements MGRecyclerDataPayload {
    public static final WidgetGroupInviteFriends$Model$FriendItem$Companion Companion = new WidgetGroupInviteFriends$Model$FriendItem$Companion(null);
    public static final int TYPE_FRIEND = 0;
    private final boolean isApplicationStreaming;
    private final boolean isSelected;
    private final String key;
    private final Presence presence;
    private final int type;
    private final User user;

    public WidgetGroupInviteFriends$Model$FriendItem() {
        this(null, null, false, false, 15, null);
    }

    public WidgetGroupInviteFriends$Model$FriendItem(User user, Presence presence, boolean z2, boolean z3) {
        this.user = user;
        this.presence = presence;
        this.isSelected = z2;
        this.isApplicationStreaming = z3;
        this.key = String.valueOf(user != null ? Long.valueOf(user.getId()) : null);
    }

    public static /* synthetic */ WidgetGroupInviteFriends$Model$FriendItem copy$default(WidgetGroupInviteFriends$Model$FriendItem widgetGroupInviteFriends$Model$FriendItem, User user, Presence presence, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetGroupInviteFriends$Model$FriendItem.user;
        }
        if ((i & 2) != 0) {
            presence = widgetGroupInviteFriends$Model$FriendItem.presence;
        }
        if ((i & 4) != 0) {
            z2 = widgetGroupInviteFriends$Model$FriendItem.isSelected;
        }
        if ((i & 8) != 0) {
            z3 = widgetGroupInviteFriends$Model$FriendItem.isApplicationStreaming;
        }
        return widgetGroupInviteFriends$Model$FriendItem.copy(user, presence, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final WidgetGroupInviteFriends$Model$FriendItem copy(User user, Presence presence, boolean isSelected, boolean isApplicationStreaming) {
        return new WidgetGroupInviteFriends$Model$FriendItem(user, presence, isSelected, isApplicationStreaming);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGroupInviteFriends$Model$FriendItem)) {
            return false;
        }
        WidgetGroupInviteFriends$Model$FriendItem widgetGroupInviteFriends$Model$FriendItem = (WidgetGroupInviteFriends$Model$FriendItem) other;
        return m.areEqual(this.user, widgetGroupInviteFriends$Model$FriendItem.user) && m.areEqual(this.presence, widgetGroupInviteFriends$Model$FriendItem.presence) && this.isSelected == widgetGroupInviteFriends$Model$FriendItem.isSelected && this.isApplicationStreaming == widgetGroupInviteFriends$Model$FriendItem.isApplicationStreaming;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
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
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Presence presence = this.presence;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.isSelected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.isApplicationStreaming;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("FriendItem(user=");
        sbU.append(this.user);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", isSelected=");
        sbU.append(this.isSelected);
        sbU.append(", isApplicationStreaming=");
        return a.O(sbU, this.isApplicationStreaming, ")");
    }

    public /* synthetic */ WidgetGroupInviteFriends$Model$FriendItem(User user, Presence presence, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : presence, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }
}
