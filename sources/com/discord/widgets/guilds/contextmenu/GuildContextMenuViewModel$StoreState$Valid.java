package com.discord.widgets.guilds.contextmenu;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildContextMenuViewModel$StoreState$Valid extends GuildContextMenuViewModel$StoreState {
    private final Guild guild;
    private final boolean isGuildUnread;
    private final long myUserId;
    private final long selectedGuildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel$StoreState$Valid(Guild guild, long j, boolean z2, long j2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.myUserId = j;
        this.isGuildUnread = z2;
        this.selectedGuildId = j2;
    }

    public static /* synthetic */ GuildContextMenuViewModel$StoreState$Valid copy$default(GuildContextMenuViewModel$StoreState$Valid guildContextMenuViewModel$StoreState$Valid, Guild guild, long j, boolean z2, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildContextMenuViewModel$StoreState$Valid.guild;
        }
        if ((i & 2) != 0) {
            j = guildContextMenuViewModel$StoreState$Valid.myUserId;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            z2 = guildContextMenuViewModel$StoreState$Valid.isGuildUnread;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            j2 = guildContextMenuViewModel$StoreState$Valid.selectedGuildId;
        }
        return guildContextMenuViewModel$StoreState$Valid.copy(guild, j3, z3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsGuildUnread() {
        return this.isGuildUnread;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final GuildContextMenuViewModel$StoreState$Valid copy(Guild guild, long myUserId, boolean isGuildUnread, long selectedGuildId) {
        m.checkNotNullParameter(guild, "guild");
        return new GuildContextMenuViewModel$StoreState$Valid(guild, myUserId, isGuildUnread, selectedGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildContextMenuViewModel$StoreState$Valid)) {
            return false;
        }
        GuildContextMenuViewModel$StoreState$Valid guildContextMenuViewModel$StoreState$Valid = (GuildContextMenuViewModel$StoreState$Valid) other;
        return m.areEqual(this.guild, guildContextMenuViewModel$StoreState$Valid.guild) && this.myUserId == guildContextMenuViewModel$StoreState$Valid.myUserId && this.isGuildUnread == guildContextMenuViewModel$StoreState$Valid.isGuildUnread && this.selectedGuildId == guildContextMenuViewModel$StoreState$Valid.selectedGuildId;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        Guild guild = this.guild;
        int iA = (b.a(this.myUserId) + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
        boolean z2 = this.isGuildUnread;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return b.a(this.selectedGuildId) + ((iA + r0) * 31);
    }

    public final boolean isGuildUnread() {
        return this.isGuildUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", isGuildUnread=");
        sbU.append(this.isGuildUnread);
        sbU.append(", selectedGuildId=");
        return a.C(sbU, this.selectedGuildId, ")");
    }
}
