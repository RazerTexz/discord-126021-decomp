package com.discord.widgets.guilds.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$UnavailableItem extends GuildListItem {
    private final int unavailableGuildCount;

    public GuildListItem$UnavailableItem(int i) {
        super(-1L, null);
        this.unavailableGuildCount = i;
    }

    public static /* synthetic */ GuildListItem$UnavailableItem copy$default(GuildListItem$UnavailableItem guildListItem$UnavailableItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildListItem$UnavailableItem.unavailableGuildCount;
        }
        return guildListItem$UnavailableItem.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    public final GuildListItem$UnavailableItem copy(int unavailableGuildCount) {
        return new GuildListItem$UnavailableItem(unavailableGuildCount);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildListItem$UnavailableItem) && this.unavailableGuildCount == ((GuildListItem$UnavailableItem) other).unavailableGuildCount;
        }
        return true;
    }

    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    public int hashCode() {
        return this.unavailableGuildCount;
    }

    public String toString() {
        return a.B(a.U("UnavailableItem(unavailableGuildCount="), this.unavailableGuildCount, ")");
    }
}
