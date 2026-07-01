package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: compiled from: ModelAppliedGuildBoost.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelAppliedGuildBoost {
    private final long guildId;
    private final long id;
    private final long userId;

    public ModelAppliedGuildBoost(long j, long j2, long j3) {
        this.id = j;
        this.guildId = j2;
        this.userId = j3;
    }

    public static /* synthetic */ ModelAppliedGuildBoost copy$default(ModelAppliedGuildBoost modelAppliedGuildBoost, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelAppliedGuildBoost.id;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = modelAppliedGuildBoost.guildId;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = modelAppliedGuildBoost.userId;
        }
        return modelAppliedGuildBoost.copy(j4, j5, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final ModelAppliedGuildBoost copy(long id2, long guildId, long userId) {
        return new ModelAppliedGuildBoost(id2, guildId, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelAppliedGuildBoost)) {
            return false;
        }
        ModelAppliedGuildBoost modelAppliedGuildBoost = (ModelAppliedGuildBoost) other;
        return this.id == modelAppliedGuildBoost.id && this.guildId == modelAppliedGuildBoost.guildId && this.userId == modelAppliedGuildBoost.userId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getId() {
        return this.id;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        return i + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAppliedGuildBoost(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return a.C(sbU, this.userId, ")");
    }
}
