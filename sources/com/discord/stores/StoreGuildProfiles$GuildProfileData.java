package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guild.preview.GuildPreview;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildProfiles$GuildProfileData {
    private final GuildPreview data;
    private final StoreGuildProfiles$FetchStates fetchState;

    public StoreGuildProfiles$GuildProfileData(StoreGuildProfiles$FetchStates storeGuildProfiles$FetchStates, GuildPreview guildPreview) {
        m.checkNotNullParameter(storeGuildProfiles$FetchStates, "fetchState");
        this.fetchState = storeGuildProfiles$FetchStates;
        this.data = guildPreview;
    }

    public static /* synthetic */ StoreGuildProfiles$GuildProfileData copy$default(StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, StoreGuildProfiles$FetchStates storeGuildProfiles$FetchStates, GuildPreview guildPreview, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildProfiles$FetchStates = storeGuildProfiles$GuildProfileData.fetchState;
        }
        if ((i & 2) != 0) {
            guildPreview = storeGuildProfiles$GuildProfileData.data;
        }
        return storeGuildProfiles$GuildProfileData.copy(storeGuildProfiles$FetchStates, guildPreview);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildProfiles$FetchStates getFetchState() {
        return this.fetchState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildPreview getData() {
        return this.data;
    }

    public final StoreGuildProfiles$GuildProfileData copy(StoreGuildProfiles$FetchStates fetchState, GuildPreview data) {
        m.checkNotNullParameter(fetchState, "fetchState");
        return new StoreGuildProfiles$GuildProfileData(fetchState, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGuildProfiles$GuildProfileData)) {
            return false;
        }
        StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData = (StoreGuildProfiles$GuildProfileData) other;
        return m.areEqual(this.fetchState, storeGuildProfiles$GuildProfileData.fetchState) && m.areEqual(this.data, storeGuildProfiles$GuildProfileData.data);
    }

    public final GuildPreview getData() {
        return this.data;
    }

    public final StoreGuildProfiles$FetchStates getFetchState() {
        return this.fetchState;
    }

    public int hashCode() {
        StoreGuildProfiles$FetchStates storeGuildProfiles$FetchStates = this.fetchState;
        int iHashCode = (storeGuildProfiles$FetchStates != null ? storeGuildProfiles$FetchStates.hashCode() : 0) * 31;
        GuildPreview guildPreview = this.data;
        return iHashCode + (guildPreview != null ? guildPreview.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildProfileData(fetchState=");
        sbU.append(this.fetchState);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
