package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: StageInviteEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageInviteEntry extends ChatListEntry {
    private final long guildId;
    private final ModelInvite invite;
    private final String inviteCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public StageInviteEntry(long j, long j2, String str, ModelInvite modelInvite, long j3) {
        m.checkNotNullParameter(str, "inviteCode");
        m.checkNotNullParameter(modelInvite, "invite");
        this.userId = j;
        this.messageId = j2;
        this.inviteCode = str;
        this.invite = modelInvite;
        this.guildId = j3;
        this.type = 39;
        this.key = "39 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ StageInviteEntry copy$default(StageInviteEntry stageInviteEntry, long j, long j2, String str, ModelInvite modelInvite, long j3, int i, Object obj) {
        return stageInviteEntry.copy((i & 1) != 0 ? stageInviteEntry.userId : j, (i & 2) != 0 ? stageInviteEntry.messageId : j2, (i & 4) != 0 ? stageInviteEntry.inviteCode : str, (i & 8) != 0 ? stageInviteEntry.invite : modelInvite, (i & 16) != 0 ? stageInviteEntry.guildId : j3);
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
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final StageInviteEntry copy(long userId, long messageId, String inviteCode, ModelInvite invite, long guildId) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        m.checkNotNullParameter(invite, "invite");
        return new StageInviteEntry(userId, messageId, inviteCode, invite, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageInviteEntry)) {
            return false;
        }
        StageInviteEntry stageInviteEntry = (StageInviteEntry) other;
        return this.userId == stageInviteEntry.userId && this.messageId == stageInviteEntry.messageId && m.areEqual(this.inviteCode, stageInviteEntry.inviteCode) && m.areEqual(this.invite, stageInviteEntry.invite) && this.guildId == stageInviteEntry.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getInviteCode() {
        return this.inviteCode;
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
        String str = this.inviteCode;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        return b.a(this.guildId) + ((iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("StageInviteEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
