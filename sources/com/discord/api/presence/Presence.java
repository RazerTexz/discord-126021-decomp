package com.discord.api.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: Presence.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Presence {
    private final List<Activity> activities;
    private final ClientStatuses clientStatus;
    private final Long guildId;
    private final ClientStatus status;
    private final User user;
    private final Long userId;

    public Presence(ClientStatus clientStatus, List<Activity> list, ClientStatuses clientStatuses, User user, Long l, Long l2) {
        Intrinsics3.checkNotNullParameter(clientStatus, "status");
        this.status = clientStatus;
        this.activities = list;
        this.clientStatus = clientStatuses;
        this.user = user;
        this.userId = l;
        this.guildId = l2;
    }

    public static Presence a(Presence presence, ClientStatus clientStatus, List list, ClientStatuses clientStatuses, User user, Long l, Long l2, int i) {
        ClientStatus clientStatus2 = (i & 1) != 0 ? presence.status : null;
        List<Activity> list2 = (i & 2) != 0 ? presence.activities : null;
        ClientStatuses clientStatuses2 = (i & 4) != 0 ? presence.clientStatus : null;
        if ((i & 8) != 0) {
            user = presence.user;
        }
        User user2 = user;
        Long l3 = (i & 16) != 0 ? presence.userId : null;
        Long l4 = (i & 32) != 0 ? presence.guildId : null;
        Intrinsics3.checkNotNullParameter(clientStatus2, "status");
        return new Presence(clientStatus2, list2, clientStatuses2, user2, l3, l4);
    }

    public final List<Activity> b() {
        return this.activities;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ClientStatuses getClientStatus() {
        return this.clientStatus;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ClientStatus getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Presence)) {
            return false;
        }
        Presence presence = (Presence) other;
        return Intrinsics3.areEqual(this.status, presence.status) && Intrinsics3.areEqual(this.activities, presence.activities) && Intrinsics3.areEqual(this.clientStatus, presence.clientStatus) && Intrinsics3.areEqual(this.user, presence.user) && Intrinsics3.areEqual(this.userId, presence.userId) && Intrinsics3.areEqual(this.guildId, presence.guildId);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        ClientStatus clientStatus = this.status;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        List<Activity> list = this.activities;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        ClientStatuses clientStatuses = this.clientStatus;
        int iHashCode3 = (iHashCode2 + (clientStatuses != null ? clientStatuses.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Long l = this.userId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Presence(status=");
        sbU.append(this.status);
        sbU.append(", activities=");
        sbU.append(this.activities);
        sbU.append(", clientStatus=");
        sbU.append(this.clientStatus);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
