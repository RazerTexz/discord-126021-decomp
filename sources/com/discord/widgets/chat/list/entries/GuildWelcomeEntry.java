package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildWelcomeEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildWelcomeEntry extends ChatListEntry {
    private final boolean canInvite;
    private final boolean guildHasIcon;
    private final long guildId;
    private final String guildName;
    private final boolean isOwner;
    private final String key;
    private final int type;

    public GuildWelcomeEntry(boolean z2, boolean z3, boolean z4, long j, String str) {
        m.checkNotNullParameter(str, "guildName");
        this.isOwner = z2;
        this.guildHasIcon = z3;
        this.canInvite = z4;
        this.guildId = j;
        this.guildName = str;
        this.type = 25;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ GuildWelcomeEntry copy$default(GuildWelcomeEntry guildWelcomeEntry, boolean z2, boolean z3, boolean z4, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildWelcomeEntry.isOwner;
        }
        if ((i & 2) != 0) {
            z3 = guildWelcomeEntry.guildHasIcon;
        }
        boolean z5 = z3;
        if ((i & 4) != 0) {
            z4 = guildWelcomeEntry.canInvite;
        }
        boolean z6 = z4;
        if ((i & 8) != 0) {
            j = guildWelcomeEntry.guildId;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str = guildWelcomeEntry.guildName;
        }
        return guildWelcomeEntry.copy(z2, z5, z6, j2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanInvite() {
        return this.canInvite;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final GuildWelcomeEntry copy(boolean isOwner, boolean guildHasIcon, boolean canInvite, long guildId, String guildName) {
        m.checkNotNullParameter(guildName, "guildName");
        return new GuildWelcomeEntry(isOwner, guildHasIcon, canInvite, guildId, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeEntry)) {
            return false;
        }
        GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) other;
        return this.isOwner == guildWelcomeEntry.isOwner && this.guildHasIcon == guildWelcomeEntry.guildHasIcon && this.canInvite == guildWelcomeEntry.canInvite && this.guildId == guildWelcomeEntry.guildId && m.areEqual(this.guildName, guildWelcomeEntry.guildName);
    }

    public final boolean getCanInvite() {
        return this.canInvite;
    }

    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.isOwner;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.guildHasIcon;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canInvite;
        int iA = (b.a(this.guildId) + ((i2 + (z4 ? 1 : z4)) * 31)) * 31;
        String str = this.guildName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildWelcomeEntry(isOwner=");
        sbU.append(this.isOwner);
        sbU.append(", guildHasIcon=");
        sbU.append(this.guildHasIcon);
        sbU.append(", canInvite=");
        sbU.append(this.canInvite);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        return a.J(sbU, this.guildName, ")");
    }
}
