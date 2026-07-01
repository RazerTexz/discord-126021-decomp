package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;

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
        return this.userId == guildJoinRequest.userId && Intrinsics3.areEqual(this.user, guildJoinRequest.user) && this.guildId == guildJoinRequest.guildId && Intrinsics3.areEqual(this.createdAt, guildJoinRequest.createdAt) && Intrinsics3.areEqual(this.applicationStatus, guildJoinRequest.applicationStatus) && Intrinsics3.areEqual(this.rejectionReason, guildJoinRequest.rejectionReason) && Intrinsics3.areEqual(this.inviteCode, guildJoinRequest.inviteCode) && Intrinsics3.areEqual(this.lastSeen, guildJoinRequest.lastSeen) && Intrinsics3.areEqual(this.actionedAt, guildJoinRequest.actionedAt);
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
        StringBuilder sbU = outline.U("GuildJoinRequest(userId=");
        sbU.append(this.userId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", rejectionReason=");
        sbU.append(this.rejectionReason);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", lastSeen=");
        sbU.append(this.lastSeen);
        sbU.append(", actionedAt=");
        return outline.J(sbU, this.actionedAt, ")");
    }
}
