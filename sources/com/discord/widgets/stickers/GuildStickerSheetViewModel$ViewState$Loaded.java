package com.discord.widgets.stickers;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildStickerSheetViewModel$ViewState$Loaded extends GuildStickerSheetViewModel$ViewState {
    private final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerGuildInfo;
    private final boolean isCurrentGuild;
    private final boolean isUserPremium;
    private final Sticker sticker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel$ViewState$Loaded(Sticker sticker, boolean z2, boolean z3, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo) {
        super(null);
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, "guildStickerGuildInfo");
        this.sticker = sticker;
        this.isUserPremium = z2;
        this.isCurrentGuild = z3;
        this.guildStickerGuildInfo = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo;
    }

    public static /* synthetic */ GuildStickerSheetViewModel$ViewState$Loaded copy$default(GuildStickerSheetViewModel$ViewState$Loaded guildStickerSheetViewModel$ViewState$Loaded, Sticker sticker, boolean z2, boolean z3, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = guildStickerSheetViewModel$ViewState$Loaded.sticker;
        }
        if ((i & 2) != 0) {
            z2 = guildStickerSheetViewModel$ViewState$Loaded.isUserPremium;
        }
        if ((i & 4) != 0) {
            z3 = guildStickerSheetViewModel$ViewState$Loaded.isCurrentGuild;
        }
        if ((i & 8) != 0) {
            guildStickerSheetViewModel$Companion$GuildStickerGuildInfo = guildStickerSheetViewModel$ViewState$Loaded.guildStickerGuildInfo;
        }
        return guildStickerSheetViewModel$ViewState$Loaded.copy(sticker, z2, z3, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsUserPremium() {
        return this.isUserPremium;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsCurrentGuild() {
        return this.isCurrentGuild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo getGuildStickerGuildInfo() {
        return this.guildStickerGuildInfo;
    }

    public final GuildStickerSheetViewModel$ViewState$Loaded copy(Sticker sticker, boolean isUserPremium, boolean isCurrentGuild, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerGuildInfo) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
        return new GuildStickerSheetViewModel$ViewState$Loaded(sticker, isUserPremium, isCurrentGuild, guildStickerGuildInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildStickerSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        GuildStickerSheetViewModel$ViewState$Loaded guildStickerSheetViewModel$ViewState$Loaded = (GuildStickerSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.sticker, guildStickerSheetViewModel$ViewState$Loaded.sticker) && this.isUserPremium == guildStickerSheetViewModel$ViewState$Loaded.isUserPremium && this.isCurrentGuild == guildStickerSheetViewModel$ViewState$Loaded.isCurrentGuild && m.areEqual(this.guildStickerGuildInfo, guildStickerSheetViewModel$ViewState$Loaded.guildStickerGuildInfo);
    }

    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo getGuildStickerGuildInfo() {
        return this.guildStickerGuildInfo;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        boolean z2 = this.isUserPremium;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.isCurrentGuild;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo = this.guildStickerGuildInfo;
        return i2 + (guildStickerSheetViewModel$Companion$GuildStickerGuildInfo != null ? guildStickerSheetViewModel$Companion$GuildStickerGuildInfo.hashCode() : 0);
    }

    public final boolean isCurrentGuild() {
        return this.isCurrentGuild;
    }

    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(sticker=");
        sbU.append(this.sticker);
        sbU.append(", isUserPremium=");
        sbU.append(this.isUserPremium);
        sbU.append(", isCurrentGuild=");
        sbU.append(this.isCurrentGuild);
        sbU.append(", guildStickerGuildInfo=");
        sbU.append(this.guildStickerGuildInfo);
        sbU.append(")");
        return sbU.toString();
    }
}
