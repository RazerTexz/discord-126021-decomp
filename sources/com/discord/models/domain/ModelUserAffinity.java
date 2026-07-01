package com.discord.models.domain;

import b.d.b.a.outline;

/* JADX INFO: compiled from: ModelUserAffinity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserAffinity {
    private final float affinity;
    private final long userId;

    public ModelUserAffinity(long j, float f) {
        this.userId = j;
        this.affinity = f;
    }

    public static /* synthetic */ ModelUserAffinity copy$default(ModelUserAffinity modelUserAffinity, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserAffinity.userId;
        }
        if ((i & 2) != 0) {
            f = modelUserAffinity.affinity;
        }
        return modelUserAffinity.copy(j, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getAffinity() {
        return this.affinity;
    }

    public final ModelUserAffinity copy(long userId, float affinity) {
        return new ModelUserAffinity(userId, affinity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserAffinity)) {
            return false;
        }
        ModelUserAffinity modelUserAffinity = (ModelUserAffinity) other;
        return this.userId == modelUserAffinity.userId && Float.compare(this.affinity, modelUserAffinity.affinity) == 0;
    }

    public final float getAffinity() {
        return this.affinity;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.userId;
        return Float.floatToIntBits(this.affinity) + (((int) (j ^ (j >>> 32))) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserAffinity(userId=");
        sbU.append(this.userId);
        sbU.append(", affinity=");
        sbU.append(this.affinity);
        sbU.append(")");
        return sbU.toString();
    }
}
