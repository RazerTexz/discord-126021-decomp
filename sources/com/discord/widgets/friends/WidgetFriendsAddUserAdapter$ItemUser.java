package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddUserAdapter$ItemUser implements MGRecyclerDataPayload {
    public static final WidgetFriendsAddUserAdapter$ItemUser$Companion Companion = new WidgetFriendsAddUserAdapter$ItemUser$Companion(null);
    private final List<CharSequence> aliases;
    private final boolean isFriend;
    private final String key;
    private final Presence presence;
    private final int type;
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetFriendsAddUserAdapter$ItemUser(User user, List<? extends CharSequence> list, Presence presence, boolean z2) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(list, "aliases");
        this.user = user;
        this.aliases = list;
        this.presence = presence;
        this.isFriend = z2;
        this.type = 1;
        this.key = String.valueOf(user.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetFriendsAddUserAdapter$ItemUser copy$default(WidgetFriendsAddUserAdapter$ItemUser widgetFriendsAddUserAdapter$ItemUser, User user, List list, Presence presence, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetFriendsAddUserAdapter$ItemUser.user;
        }
        if ((i & 2) != 0) {
            list = widgetFriendsAddUserAdapter$ItemUser.aliases;
        }
        if ((i & 4) != 0) {
            presence = widgetFriendsAddUserAdapter$ItemUser.presence;
        }
        if ((i & 8) != 0) {
            z2 = widgetFriendsAddUserAdapter$ItemUser.isFriend;
        }
        return widgetFriendsAddUserAdapter$ItemUser.copy(user, list, presence, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final List<CharSequence> component2() {
        return this.aliases;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    public final WidgetFriendsAddUserAdapter$ItemUser copy(User user, List<? extends CharSequence> aliases, Presence presence, boolean isFriend) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(aliases, "aliases");
        return new WidgetFriendsAddUserAdapter$ItemUser(user, aliases, presence, isFriend);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetFriendsAddUserAdapter$ItemUser)) {
            return false;
        }
        WidgetFriendsAddUserAdapter$ItemUser widgetFriendsAddUserAdapter$ItemUser = (WidgetFriendsAddUserAdapter$ItemUser) other;
        return m.areEqual(this.user, widgetFriendsAddUserAdapter$ItemUser.user) && m.areEqual(this.aliases, widgetFriendsAddUserAdapter$ItemUser.aliases) && m.areEqual(this.presence, widgetFriendsAddUserAdapter$ItemUser.presence) && this.isFriend == widgetFriendsAddUserAdapter$ItemUser.isFriend;
    }

    public final List<CharSequence> getAliases() {
        return this.aliases;
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
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<CharSequence> list = this.aliases;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        int iHashCode3 = (iHashCode2 + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.isFriend;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public String toString() {
        StringBuilder sbU = a.U("ItemUser(user=");
        sbU.append(this.user);
        sbU.append(", aliases=");
        sbU.append(this.aliases);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", isFriend=");
        return a.O(sbU, this.isFriend, ")");
    }

    public /* synthetic */ WidgetFriendsAddUserAdapter$ItemUser(User user, List list, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, list, (i & 4) != 0 ? null : presence, z2);
    }
}
