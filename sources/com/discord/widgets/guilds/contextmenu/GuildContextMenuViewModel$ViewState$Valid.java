package com.discord.widgets.guilds.contextmenu;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildContextMenuViewModel$ViewState$Valid extends GuildContextMenuViewModel$ViewState {
    private final Guild guild;
    private final boolean isGuildSelected;
    private final boolean showLeaveGuild;
    private final boolean showMarkAsRead;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel$ViewState$Valid(Guild guild, boolean z2, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.showMarkAsRead = z2;
        this.showLeaveGuild = z3;
        this.isGuildSelected = z4;
    }

    public static /* synthetic */ GuildContextMenuViewModel$ViewState$Valid copy$default(GuildContextMenuViewModel$ViewState$Valid guildContextMenuViewModel$ViewState$Valid, Guild guild, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildContextMenuViewModel$ViewState$Valid.guild;
        }
        if ((i & 2) != 0) {
            z2 = guildContextMenuViewModel$ViewState$Valid.showMarkAsRead;
        }
        if ((i & 4) != 0) {
            z3 = guildContextMenuViewModel$ViewState$Valid.showLeaveGuild;
        }
        if ((i & 8) != 0) {
            z4 = guildContextMenuViewModel$ViewState$Valid.isGuildSelected;
        }
        return guildContextMenuViewModel$ViewState$Valid.copy(guild, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowMarkAsRead() {
        return this.showMarkAsRead;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowLeaveGuild() {
        return this.showLeaveGuild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGuildSelected() {
        return this.isGuildSelected;
    }

    public final GuildContextMenuViewModel$ViewState$Valid copy(Guild guild, boolean showMarkAsRead, boolean showLeaveGuild, boolean isGuildSelected) {
        m.checkNotNullParameter(guild, "guild");
        return new GuildContextMenuViewModel$ViewState$Valid(guild, showMarkAsRead, showLeaveGuild, isGuildSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildContextMenuViewModel$ViewState$Valid)) {
            return false;
        }
        GuildContextMenuViewModel$ViewState$Valid guildContextMenuViewModel$ViewState$Valid = (GuildContextMenuViewModel$ViewState$Valid) other;
        return m.areEqual(this.guild, guildContextMenuViewModel$ViewState$Valid.guild) && this.showMarkAsRead == guildContextMenuViewModel$ViewState$Valid.showMarkAsRead && this.showLeaveGuild == guildContextMenuViewModel$ViewState$Valid.showLeaveGuild && this.isGuildSelected == guildContextMenuViewModel$ViewState$Valid.isGuildSelected;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getShowLeaveGuild() {
        return this.showLeaveGuild;
    }

    public final boolean getShowMarkAsRead() {
        return this.showMarkAsRead;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.showMarkAsRead;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.showLeaveGuild;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isGuildSelected;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isGuildSelected() {
        return this.isGuildSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", showMarkAsRead=");
        sbU.append(this.showMarkAsRead);
        sbU.append(", showLeaveGuild=");
        sbU.append(this.showLeaveGuild);
        sbU.append(", isGuildSelected=");
        return a.O(sbU, this.isGuildSelected, ")");
    }
}
