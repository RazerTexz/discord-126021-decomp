package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.EmojiSet;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState {
    private final Map<Long, Channel> channels;
    private final EmojiSet guildEmojis;
    private final ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData;

    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState(Map<Long, Channel> map, EmojiSet emojiSet, ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData) {
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(emojiSet, "guildEmojis");
        m.checkNotNullParameter(serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
        this.channels = map;
        this.guildEmojis = emojiSet;
        this.guildRoleSubscriptionStoreData = serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState copy$default(ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState, Map map, EmojiSet emojiSet, ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, int i, Object obj) {
        if ((i & 1) != 0) {
            map = serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.channels;
        }
        if ((i & 2) != 0) {
            emojiSet = serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.guildEmojis;
        }
        if ((i & 4) != 0) {
            serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData = serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.guildRoleSubscriptionStoreData;
        }
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.copy(map, emojiSet, serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData);
    }

    public final Map<Long, Channel> component1() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EmojiSet getGuildEmojis() {
        return this.guildEmojis;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
        return this.guildRoleSubscriptionStoreData;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState copy(Map<Long, Channel> channels, EmojiSet guildEmojis, ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreData) {
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(guildEmojis, "guildEmojis");
        m.checkNotNullParameter(guildRoleSubscriptionStoreData, "guildRoleSubscriptionStoreData");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState(channels, guildEmojis, guildRoleSubscriptionStoreData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState) other;
        return m.areEqual(this.channels, serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.channels) && m.areEqual(this.guildEmojis, serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.guildEmojis) && m.areEqual(this.guildRoleSubscriptionStoreData, serverSettingsGuildRoleSubscriptionEditTierViewModel$StoreState.guildRoleSubscriptionStoreData);
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final EmojiSet getGuildEmojis() {
        return this.guildEmojis;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData getGuildRoleSubscriptionStoreData() {
        return this.guildRoleSubscriptionStoreData;
    }

    public int hashCode() {
        Map<Long, Channel> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        EmojiSet emojiSet = this.guildEmojis;
        int iHashCode2 = (iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0)) * 31;
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData = this.guildRoleSubscriptionStoreData;
        return iHashCode2 + (serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData != null ? serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channels=");
        sbU.append(this.channels);
        sbU.append(", guildEmojis=");
        sbU.append(this.guildEmojis);
        sbU.append(", guildRoleSubscriptionStoreData=");
        sbU.append(this.guildRoleSubscriptionStoreData);
        sbU.append(")");
        return sbU.toString();
    }
}
