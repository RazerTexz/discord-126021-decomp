package com.discord.gateway.io;

import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.utilities.time.ClockFactory;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutgoingPayload$PresenceUpdate extends OutgoingPayload {
    private final List<Activity> activities;
    private final Boolean afk;
    private final Long since;
    private final String status;

    public /* synthetic */ OutgoingPayload$PresenceUpdate(String str, Long l, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Long.valueOf(ClockFactory.get().currentTimeMillis()) : l, (i & 4) != 0 ? n.emptyList() : list, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Long getSince() {
        return this.since;
    }

    private final List<Activity> component3() {
        return this.activities;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Boolean getAfk() {
        return this.afk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutgoingPayload$PresenceUpdate copy$default(OutgoingPayload$PresenceUpdate outgoingPayload$PresenceUpdate, String str, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outgoingPayload$PresenceUpdate.status;
        }
        if ((i & 2) != 0) {
            l = outgoingPayload$PresenceUpdate.since;
        }
        if ((i & 4) != 0) {
            list = outgoingPayload$PresenceUpdate.activities;
        }
        if ((i & 8) != 0) {
            bool = outgoingPayload$PresenceUpdate.afk;
        }
        return outgoingPayload$PresenceUpdate.copy(str, l, list, bool);
    }

    public final OutgoingPayload$PresenceUpdate copy(String status, Long since, List<Activity> activities, Boolean afk) {
        m.checkNotNullParameter(activities, "activities");
        return new OutgoingPayload$PresenceUpdate(status, since, activities, afk);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutgoingPayload$PresenceUpdate)) {
            return false;
        }
        OutgoingPayload$PresenceUpdate outgoingPayload$PresenceUpdate = (OutgoingPayload$PresenceUpdate) other;
        return m.areEqual(this.status, outgoingPayload$PresenceUpdate.status) && m.areEqual(this.since, outgoingPayload$PresenceUpdate.since) && m.areEqual(this.activities, outgoingPayload$PresenceUpdate.activities) && m.areEqual(this.afk, outgoingPayload$PresenceUpdate.afk);
    }

    public int hashCode() {
        String str = this.status;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.since;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        List<Activity> list = this.activities;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.afk;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PresenceUpdate(status=");
        sbU.append(this.status);
        sbU.append(", since=");
        sbU.append(this.since);
        sbU.append(", activities=");
        sbU.append(this.activities);
        sbU.append(", afk=");
        return a.D(sbU, this.afk, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$PresenceUpdate(String str, Long l, List<Activity> list, Boolean bool) {
        super(null);
        m.checkNotNullParameter(list, "activities");
        this.status = str;
        this.since = l;
        this.activities = list;
        this.afk = bool;
    }
}
