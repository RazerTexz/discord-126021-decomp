package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.domain.Harvest, reason: use source file name */
/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserConsents3 {
    private final String completedAt;
    private final String createdAt;
    private final String id;
    private final long userId;

    public ModelUserConsents3(String str, long j, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, "createdAt");
        this.id = str;
        this.userId = j;
        this.createdAt = str2;
        this.completedAt = str3;
    }

    public static /* synthetic */ boolean canRequest$default(ModelUserConsents3 modelUserConsents3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        return modelUserConsents3.canRequest(j);
    }

    public static /* synthetic */ ModelUserConsents3 copy$default(ModelUserConsents3 modelUserConsents3, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelUserConsents3.id;
        }
        if ((i & 2) != 0) {
            j = modelUserConsents3.userId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = modelUserConsents3.createdAt;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = modelUserConsents3.completedAt;
        }
        return modelUserConsents3.copy(str, j2, str4, str3);
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

    public final ModelUserConsents3 copy(String id2, long userId, String createdAt, String completedAt) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        return new ModelUserConsents3(id2, userId, createdAt, completedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents3)) {
            return false;
        }
        ModelUserConsents3 modelUserConsents3 = (ModelUserConsents3) other;
        return Intrinsics3.areEqual(this.id, modelUserConsents3.id) && this.userId == modelUserConsents3.userId && Intrinsics3.areEqual(this.createdAt, modelUserConsents3.createdAt) && Intrinsics3.areEqual(this.completedAt, modelUserConsents3.completedAt);
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
        return createdAtInMillis() + WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Harvest(id=");
        sbU.append(this.id);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", completedAt=");
        return outline.J(sbU, this.completedAt, ")");
    }
}
