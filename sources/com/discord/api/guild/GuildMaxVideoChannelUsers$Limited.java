package com.discord.api.guild;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildMaxVideoChannelUsers$Limited extends GuildMaxVideoChannelUsers {
    private final int limit;

    public GuildMaxVideoChannelUsers$Limited(int i) {
        super(null);
        this.limit = i;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildMaxVideoChannelUsers$Limited) && this.limit == ((GuildMaxVideoChannelUsers$Limited) other).limit;
        }
        return true;
    }

    public int hashCode() {
        return this.limit;
    }

    public String toString() {
        return a.B(a.U("Limited(limit="), this.limit, ")");
    }
}
