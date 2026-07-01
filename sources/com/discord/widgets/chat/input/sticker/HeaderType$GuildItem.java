package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HeaderType$GuildItem extends HeaderType {
    private final Guild guild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderType$GuildItem(Guild guild) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
    }

    public static /* synthetic */ HeaderType$GuildItem copy$default(HeaderType$GuildItem headerType$GuildItem, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = headerType$GuildItem.guild;
        }
        return headerType$GuildItem.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final HeaderType$GuildItem copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new HeaderType$GuildItem(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HeaderType$GuildItem) && m.areEqual(this.guild, ((HeaderType$GuildItem) other).guild);
        }
        return true;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.input.sticker.HeaderType
    public String getId() {
        return String.valueOf(this.guild.getId());
    }

    public int hashCode() {
        Guild guild = this.guild;
        if (guild != null) {
            return guild.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildItem(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
