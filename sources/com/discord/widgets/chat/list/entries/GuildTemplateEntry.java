package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildTemplateEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildTemplateEntry extends ChatListEntry {
    private final String guildTemplateCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public GuildTemplateEntry(long j, long j2, String str) {
        Intrinsics3.checkNotNullParameter(str, "guildTemplateCode");
        this.userId = j;
        this.messageId = j2;
        this.guildTemplateCode = str;
        this.type = 30;
        this.key = "30 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ GuildTemplateEntry copy$default(GuildTemplateEntry guildTemplateEntry, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guildTemplateEntry.userId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = guildTemplateEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = guildTemplateEntry.guildTemplateCode;
        }
        return guildTemplateEntry.copy(j3, j4, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    public final GuildTemplateEntry copy(long userId, long messageId, String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return new GuildTemplateEntry(userId, messageId, guildTemplateCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTemplateEntry)) {
            return false;
        }
        GuildTemplateEntry guildTemplateEntry = (GuildTemplateEntry) other;
        return this.userId == guildTemplateEntry.userId && this.messageId == guildTemplateEntry.messageId && Intrinsics3.areEqual(this.guildTemplateCode, guildTemplateEntry.guildTemplateCode);
    }

    public final String getGuildTemplateCode() {
        return this.guildTemplateCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.userId) * 31)) * 31;
        String str = this.guildTemplateCode;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildTemplateEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", guildTemplateCode=");
        return outline.J(sbU, this.guildTemplateCode, ")");
    }
}
