package com.discord.widgets.guilds.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$FriendsItem extends GuildListItem {
    private final boolean isSelected;

    public GuildListItem$FriendsItem(boolean z2) {
        super(-2L, null);
        this.isSelected = z2;
    }

    public static /* synthetic */ GuildListItem$FriendsItem copy$default(GuildListItem$FriendsItem guildListItem$FriendsItem, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildListItem$FriendsItem.isSelected;
        }
        return guildListItem$FriendsItem.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final GuildListItem$FriendsItem copy(boolean isSelected) {
        return new GuildListItem$FriendsItem(isSelected);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildListItem$FriendsItem) && this.isSelected == ((GuildListItem$FriendsItem) other).isSelected;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isSelected;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        return a.O(a.U("FriendsItem(isSelected="), this.isSelected, ")");
    }
}
