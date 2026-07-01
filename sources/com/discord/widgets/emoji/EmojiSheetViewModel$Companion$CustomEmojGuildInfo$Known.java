package com.discord.widgets.emoji;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known extends EmojiSheetViewModel$Companion$CustomEmojGuildInfo {
    private final Integer approximateOnline;
    private final Guild guild;
    private final boolean isPublic;
    private final boolean isUserInGuild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known(Guild guild, boolean z2, boolean z3, Integer num) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.isPublic = z2;
        this.isUserInGuild = z3;
        this.approximateOnline = num;
    }

    public static /* synthetic */ EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known copy$default(EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known, Guild guild, boolean z2, boolean z3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.guild;
        }
        if ((i & 2) != 0) {
            z2 = emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getIsPublic();
        }
        if ((i & 4) != 0) {
            z3 = emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getIsUserInGuild();
        }
        if ((i & 8) != 0) {
            num = emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.approximateOnline;
        }
        return emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.copy(guild, z2, z3, num);
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

    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
        m.checkNotNullParameter(guild, "guild");
        return new EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known(guild, isPublic, isUserInGuild, approximateOnline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known)) {
            return false;
        }
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known = (EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known) other;
        return m.areEqual(this.guild, emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.guild) && getIsPublic() == emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getIsPublic() && getIsUserInGuild() == emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getIsUserInGuild() && m.areEqual(this.approximateOnline, emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.approximateOnline);
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

    @Override // com.discord.widgets.emoji.EmojiSheetViewModel$Companion$CustomEmojGuildInfo
    /* JADX INFO: renamed from: isPublic, reason: from getter */
    public boolean getIsPublic() {
        return this.isPublic;
    }

    @Override // com.discord.widgets.emoji.EmojiSheetViewModel$Companion$CustomEmojGuildInfo
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
