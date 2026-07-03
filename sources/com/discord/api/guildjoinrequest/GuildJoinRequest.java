package com.discord.api.guildjoinrequest;

import com.discord.api.user.User;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildJoinRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildJoinRequest {
    private final String actionedAt;
    private final ApplicationStatus applicationStatus;
    private final String createdAt;
    private final long guildId;
    private final String inviteCode;
    private final String lastSeen;
    private final String rejectionReason;
    private final User user;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequest)) {
            return false;
        }
        GuildJoinRequest guildJoinRequest = (GuildJoinRequest) other;
        return this.userId == guildJoinRequest.userId && C12238m.areEqual(this.user, guildJoinRequest.user) && this.guildId == guildJoinRequest.guildId && C12238m.areEqual(this.createdAt, guildJoinRequest.createdAt) && C12238m.areEqual(this.applicationStatus, guildJoinRequest.applicationStatus) && C12238m.areEqual(this.rejectionReason, guildJoinRequest.rejectionReason) && C12238m.areEqual(this.inviteCode, guildJoinRequest.inviteCode) && C12238m.areEqual(this.lastSeen, guildJoinRequest.lastSeen) && C12238m.areEqual(this.actionedAt, guildJoinRequest.actionedAt);
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        int iHashCode = user != null ? user.hashCode() : 0;
        long j2 = this.guildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.createdAt;
        int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        String str2 = this.rejectionReason;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.inviteCode;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastSeen;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.actionedAt;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildJoinRequest(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", user=");
        sbM833U.append(this.user);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(", applicationStatus=");
        sbM833U.append(this.applicationStatus);
        sbM833U.append(", rejectionReason=");
        sbM833U.append(this.rejectionReason);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", lastSeen=");
        sbM833U.append(this.lastSeen);
        sbM833U.append(", actionedAt=");
        return C1643a.m822J(sbM833U, this.actionedAt, ")");
    }
}
