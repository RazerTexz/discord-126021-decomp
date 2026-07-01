package com.discord.widgets.home;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HomeConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HomeConfig implements Serializable {
    private final boolean ageGated;
    private final Long guildScheduledEventId;
    private final Long guildWelcomeSheetId;

    public HomeConfig() {
        this(null, null, false, 7, null);
    }

    public HomeConfig(Long l, Long l2, boolean z2) {
        this.guildWelcomeSheetId = l;
        this.guildScheduledEventId = l2;
        this.ageGated = z2;
    }

    public static /* synthetic */ HomeConfig copy$default(HomeConfig homeConfig, Long l, Long l2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = homeConfig.guildWelcomeSheetId;
        }
        if ((i & 2) != 0) {
            l2 = homeConfig.guildScheduledEventId;
        }
        if ((i & 4) != 0) {
            z2 = homeConfig.ageGated;
        }
        return homeConfig.copy(l, l2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildWelcomeSheetId() {
        return this.guildWelcomeSheetId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAgeGated() {
        return this.ageGated;
    }

    public final HomeConfig copy(Long guildWelcomeSheetId, Long guildScheduledEventId, boolean ageGated) {
        return new HomeConfig(guildWelcomeSheetId, guildScheduledEventId, ageGated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeConfig)) {
            return false;
        }
        HomeConfig homeConfig = (HomeConfig) other;
        return Intrinsics3.areEqual(this.guildWelcomeSheetId, homeConfig.guildWelcomeSheetId) && Intrinsics3.areEqual(this.guildScheduledEventId, homeConfig.guildScheduledEventId) && this.ageGated == homeConfig.ageGated;
    }

    public final boolean getAgeGated() {
        return this.ageGated;
    }

    public final Long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final Long getGuildWelcomeSheetId() {
        return this.guildWelcomeSheetId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Long l = this.guildWelcomeSheetId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildScheduledEventId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        boolean z2 = this.ageGated;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HomeConfig(guildWelcomeSheetId=");
        sbU.append(this.guildWelcomeSheetId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", ageGated=");
        return outline.O(sbU, this.ageGated, ")");
    }

    public /* synthetic */ HomeConfig(Long l, Long l2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? false : z2);
    }
}
