package com.discord.api.activity;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityEmoji {
    private final boolean animated;
    private final String id;
    private final String name;

    public ActivityEmoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.animated = z2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityEmoji)) {
            return false;
        }
        ActivityEmoji activityEmoji = (ActivityEmoji) other;
        return C12238m.areEqual(this.id, activityEmoji.id) && C12238m.areEqual(this.name, activityEmoji.name) && this.animated == activityEmoji.animated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.animated;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ActivityEmoji(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", animated=");
        return C1643a.m827O(sbM833U, this.animated, ")");
    }
}
