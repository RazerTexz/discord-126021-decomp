package com.discord.widgets.guilds.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildListItem$HubItem extends GuildListItem {
    private final boolean showSparkle;

    public GuildListItem$HubItem(boolean z2) {
        super(-8L, null);
        this.showSparkle = z2;
    }

    public static /* synthetic */ GuildListItem$HubItem copy$default(GuildListItem$HubItem guildListItem$HubItem, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildListItem$HubItem.showSparkle;
        }
        return guildListItem$HubItem.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowSparkle() {
        return this.showSparkle;
    }

    public final GuildListItem$HubItem copy(boolean showSparkle) {
        return new GuildListItem$HubItem(showSparkle);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildListItem$HubItem) && this.showSparkle == ((GuildListItem$HubItem) other).showSparkle;
        }
        return true;
    }

    public final boolean getShowSparkle() {
        return this.showSparkle;
    }

    public int hashCode() {
        boolean z2 = this.showSparkle;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("HubItem(showSparkle="), this.showSparkle, ")");
    }
}
