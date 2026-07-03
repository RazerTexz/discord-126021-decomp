package com.discord.widgets.chat.list.entries;

import com.discord.models.domain.ModelInvite;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "inviteCode");
        C12238m.checkNotNullParameter(modelInvite, "invite");
        this.userId = j;
        this.messageId = j2;
        this.inviteCode = str;
        this.invite = modelInvite;
        this.guildId = j3;
        this.type = 39;
        this.key = "39 -- " + j2 + " -- " + str;
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
        C12238m.checkNotNullParameter(inviteCode, "inviteCode");
        C12238m.checkNotNullParameter(invite, "invite");
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
        return this.userId == stageInviteEntry.userId && this.messageId == stageInviteEntry.messageId && C12238m.areEqual(this.inviteCode, stageInviteEntry.inviteCode) && C12238m.areEqual(this.invite, stageInviteEntry.invite) && this.guildId == stageInviteEntry.guildId;
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
        int iM3a = (C0002b.m3a(this.messageId) + (C0002b.m3a(this.userId) * 31)) * 31;
        String str = this.inviteCode;
        int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        return C0002b.m3a(this.guildId) + ((iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StageInviteEntry(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", invite=");
        sbM833U.append(this.invite);
        sbM833U.append(", guildId=");
        return C1643a.m815C(sbM833U, this.guildId, ")");
    }
}
