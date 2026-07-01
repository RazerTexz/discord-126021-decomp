package com.discord.widgets.stickers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildStickerSheetViewModel$StoreState {
    private final Long currentGuildId;
    private final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerGuildInfo;
    private final MeUser meUser;
    private final Map<Long, Guild> userGuilds;

    public GuildStickerSheetViewModel$StoreState(MeUser meUser, Long l, Map<Long, Guild> map, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "userGuilds");
        m.checkNotNullParameter(guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, "guildStickerGuildInfo");
        this.meUser = meUser;
        this.currentGuildId = l;
        this.userGuilds = map;
        this.guildStickerGuildInfo = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildStickerSheetViewModel$StoreState copy$default(GuildStickerSheetViewModel$StoreState guildStickerSheetViewModel$StoreState, MeUser meUser, Long l, Map map, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = guildStickerSheetViewModel$StoreState.meUser;
        }
        if ((i & 2) != 0) {
            l = guildStickerSheetViewModel$StoreState.currentGuildId;
        }
        if ((i & 4) != 0) {
            map = guildStickerSheetViewModel$StoreState.userGuilds;
        }
        if ((i & 8) != 0) {
            guildStickerSheetViewModel$Companion$GuildStickerGuildInfo = guildStickerSheetViewModel$StoreState.guildStickerGuildInfo;
        }
        return guildStickerSheetViewModel$StoreState.copy(meUser, l, map, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getCurrentGuildId() {
        return this.currentGuildId;
    }

    public final Map<Long, Guild> component3() {
        return this.userGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo getGuildStickerGuildInfo() {
        return this.guildStickerGuildInfo;
    }

    public final GuildStickerSheetViewModel$StoreState copy(MeUser meUser, Long currentGuildId, Map<Long, Guild> userGuilds, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerGuildInfo) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(userGuilds, "userGuilds");
        m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
        return new GuildStickerSheetViewModel$StoreState(meUser, currentGuildId, userGuilds, guildStickerGuildInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildStickerSheetViewModel$StoreState)) {
            return false;
        }
        GuildStickerSheetViewModel$StoreState guildStickerSheetViewModel$StoreState = (GuildStickerSheetViewModel$StoreState) other;
        return m.areEqual(this.meUser, guildStickerSheetViewModel$StoreState.meUser) && m.areEqual(this.currentGuildId, guildStickerSheetViewModel$StoreState.currentGuildId) && m.areEqual(this.userGuilds, guildStickerSheetViewModel$StoreState.userGuilds) && m.areEqual(this.guildStickerGuildInfo, guildStickerSheetViewModel$StoreState.guildStickerGuildInfo);
    }

    public final Long getCurrentGuildId() {
        return this.currentGuildId;
    }

    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo getGuildStickerGuildInfo() {
        return this.guildStickerGuildInfo;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Map<Long, Guild> getUserGuilds() {
        return this.userGuilds;
    }

    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Long l = this.currentGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Map<Long, Guild> map = this.userGuilds;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo = this.guildStickerGuildInfo;
        return iHashCode3 + (guildStickerSheetViewModel$Companion$GuildStickerGuildInfo != null ? guildStickerSheetViewModel$Companion$GuildStickerGuildInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(meUser=");
        sbU.append(this.meUser);
        sbU.append(", currentGuildId=");
        sbU.append(this.currentGuildId);
        sbU.append(", userGuilds=");
        sbU.append(this.userGuilds);
        sbU.append(", guildStickerGuildInfo=");
        sbU.append(this.guildStickerGuildInfo);
        sbU.append(")");
        return sbU.toString();
    }
}
