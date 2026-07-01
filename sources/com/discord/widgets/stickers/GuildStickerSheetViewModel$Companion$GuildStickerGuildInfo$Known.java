package com.discord.widgets.stickers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known extends GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo {
    private final Integer approximateOnline;
    private final Guild guild;
    private final boolean isPublic;
    private final boolean isUserInGuild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known(Guild guild, boolean z2, boolean z3, Integer num) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.isPublic = z2;
        this.isUserInGuild = z3;
        this.approximateOnline = num;
    }

    public static /* synthetic */ GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known copy$default(GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known, Guild guild, boolean z2, boolean z3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.guild;
        }
        if ((i & 2) != 0) {
            z2 = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getIsPublic();
        }
        if ((i & 4) != 0) {
            z3 = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getIsUserInGuild();
        }
        if ((i & 8) != 0) {
            num = guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.approximateOnline;
        }
        return guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.copy(guild, z2, z3, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean component2() {
        return getIsPublic();
    }

    public final boolean component3() {
        return getIsUserInGuild();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getApproximateOnline() {
        return this.approximateOnline;
    }

    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
        m.checkNotNullParameter(guild, "guild");
        return new GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known(guild, isPublic, isUserInGuild, approximateOnline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known)) {
            return false;
        }
        GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known = (GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known) other;
        return m.areEqual(this.guild, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.guild) && getIsPublic() == guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getIsPublic() && getIsUserInGuild() == guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getIsUserInGuild() && m.areEqual(this.approximateOnline, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.approximateOnline);
    }

    public final Integer getApproximateOnline() {
        return this.approximateOnline;
    }

    public final Guild getGuild() {
        return this.guild;
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
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean isPublic = getIsPublic();
        ?? r2 = isPublic;
        if (isPublic) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean isUserInGuild = getIsUserInGuild();
        int i2 = (i + (isUserInGuild ? 1 : isUserInGuild)) * 31;
        Integer num = this.approximateOnline;
        return i2 + (num != null ? num.hashCode() : 0);
    }

    @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo
    /* JADX INFO: renamed from: isPublic, reason: from getter */
    public boolean getIsPublic() {
        return this.isPublic;
    }

    @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo
    /* JADX INFO: renamed from: isUserInGuild, reason: from getter */
    public boolean getIsUserInGuild() {
        return this.isUserInGuild;
    }

    public String toString() {
        StringBuilder sbU = a.U("Known(guild=");
        sbU.append(this.guild);
        sbU.append(", isPublic=");
        sbU.append(getIsPublic());
        sbU.append(", isUserInGuild=");
        sbU.append(getIsUserInGuild());
        sbU.append(", approximateOnline=");
        return a.F(sbU, this.approximateOnline, ")");
    }
}
