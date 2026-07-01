package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcomeKt;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Harvest {
    private final String completedAt;
    private final String createdAt;
    private final String id;
    private final long userId;

    public Harvest(String str, long j, String str2, String str3) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(str2, "createdAt");
        this.id = str;
        this.userId = j;
        this.createdAt = str2;
        this.completedAt = str3;
    }

    public static /* synthetic */ boolean canRequest$default(Harvest harvest, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        return harvest.canRequest(j);
    }

    public static /* synthetic */ Harvest copy$default(Harvest harvest, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = harvest.id;
        }
        if ((i & 2) != 0) {
            j = harvest.userId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = harvest.createdAt;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = harvest.completedAt;
        }
        return harvest.copy(str, j2, str4, str3);
    }

    private final long createdAtInMillis() {
        return TimeUtils.parseUTCDate(this.createdAt);
    }

    public final boolean canRequest(long now) {
        return now > nextAvailableRequestInMillis();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCompletedAt() {
        return this.completedAt;
    }

    public final Harvest copy(String id2, long userId, String createdAt, String completedAt) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(createdAt, "createdAt");
        return new Harvest(id2, userId, createdAt, completedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Harvest)) {
            return false;
        }
        Harvest harvest = (Harvest) other;
        return m.areEqual(this.id, harvest.id) && this.userId == harvest.userId && m.areEqual(this.createdAt, harvest.createdAt) && m.areEqual(this.completedAt, harvest.completedAt);
    }

    public final String getCompletedAt() {
        return this.completedAt;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getId() {
        return this.id;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.userId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.completedAt;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final long nextAvailableRequestInMillis() {
        return createdAtInMillis() + WidgetChatListAdapterItemGuildWelcomeKt.OLD_GUILD_AGE_THRESHOLD;
    }

    public String toString() {
        StringBuilder sbU = a.U("Harvest(id=");
        sbU.append(this.id);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", completedAt=");
        return a.J(sbU, this.completedAt, ")");
    }
}
