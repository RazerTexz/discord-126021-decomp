package com.discord.models.experiments.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExperimentContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ExperimentContext {
    private final Long channelId;
    private final Long guildId;
    private final boolean shouldTrigger;

    public ExperimentContext() {
        this(false, null, null, 7, null);
    }

    public ExperimentContext(boolean z2, Long l, Long l2) {
        this.shouldTrigger = z2;
        this.guildId = l;
        this.channelId = l2;
    }

    public static /* synthetic */ ExperimentContext copy$default(ExperimentContext experimentContext, boolean z2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = experimentContext.shouldTrigger;
        }
        if ((i & 2) != 0) {
            l = experimentContext.guildId;
        }
        if ((i & 4) != 0) {
            l2 = experimentContext.channelId;
        }
        return experimentContext.copy(z2, l, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldTrigger() {
        return this.shouldTrigger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    public final ExperimentContext copy(boolean shouldTrigger, Long guildId, Long channelId) {
        return new ExperimentContext(shouldTrigger, guildId, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExperimentContext)) {
            return false;
        }
        ExperimentContext experimentContext = (ExperimentContext) other;
        return this.shouldTrigger == experimentContext.shouldTrigger && C12238m.areEqual(this.guildId, experimentContext.guildId) && C12238m.areEqual(this.channelId, experimentContext.channelId);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getShouldTrigger() {
        return this.shouldTrigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.shouldTrigger;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Long l = this.guildId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ExperimentContext(shouldTrigger=");
        sbM833U.append(this.shouldTrigger);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        return C1643a.m819G(sbM833U, this.channelId, ")");
    }

    public /* synthetic */ ExperimentContext(boolean z2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}
