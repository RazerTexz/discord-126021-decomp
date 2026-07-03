package com.discord.api.presence;

import com.discord.api.activity.Activity;
import com.discord.api.user.User;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(clientStatus, "status");
        this.status = clientStatus;
        this.activities = list;
        this.clientStatus = clientStatuses;
        this.user = user;
        this.userId = l;
        this.guildId = l2;
    }

    /* JADX INFO: renamed from: a */
    public static Presence m8152a(Presence presence, ClientStatus clientStatus, List list, ClientStatuses clientStatuses, User user, Long l, Long l2, int i) {
        ClientStatus clientStatus2 = (i & 1) != 0 ? presence.status : null;
        List<Activity> list2 = (i & 2) != 0 ? presence.activities : null;
        ClientStatuses clientStatuses2 = (i & 4) != 0 ? presence.clientStatus : null;
        if ((i & 8) != 0) {
            user = presence.user;
        }
        User user2 = user;
        Long l3 = (i & 16) != 0 ? presence.userId : null;
        Long l4 = (i & 32) != 0 ? presence.guildId : null;
        C12238m.checkNotNullParameter(clientStatus2, "status");
        return new Presence(clientStatus2, list2, clientStatuses2, user2, l3, l4);
    }

    /* JADX INFO: renamed from: b */
    public final List<Activity> m8153b() {
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
        return C12238m.areEqual(this.status, presence.status) && C12238m.areEqual(this.activities, presence.activities) && C12238m.areEqual(this.clientStatus, presence.clientStatus) && C12238m.areEqual(this.user, presence.user) && C12238m.areEqual(this.userId, presence.userId) && C12238m.areEqual(this.guildId, presence.guildId);
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
        StringBuilder sbM833U = C1643a.m833U("Presence(status=");
        sbM833U.append(this.status);
        sbM833U.append(", activities=");
        sbM833U.append(this.activities);
        sbM833U.append(", clientStatus=");
        sbM833U.append(this.clientStatus);
        sbM833U.append(", user=");
        sbM833U.append(this.user);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }
}
