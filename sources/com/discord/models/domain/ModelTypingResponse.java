package com.discord.models.domain;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelTypingResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelTypingResponse {
    private final Long messageSendCooldownMs;
    private final Long threadCreateCooldownMs;

    public ModelTypingResponse(Long l, Long l2) {
        this.messageSendCooldownMs = l;
        this.threadCreateCooldownMs = l2;
    }

    public static /* synthetic */ ModelTypingResponse copy$default(ModelTypingResponse modelTypingResponse, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelTypingResponse.messageSendCooldownMs;
        }
        if ((i & 2) != 0) {
            l2 = modelTypingResponse.threadCreateCooldownMs;
        }
        return modelTypingResponse.copy(l, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public final ModelTypingResponse copy(Long messageSendCooldownMs, Long threadCreateCooldownMs) {
        return new ModelTypingResponse(messageSendCooldownMs, threadCreateCooldownMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelTypingResponse)) {
            return false;
        }
        ModelTypingResponse modelTypingResponse = (ModelTypingResponse) other;
        return C12238m.areEqual(this.messageSendCooldownMs, modelTypingResponse.messageSendCooldownMs) && C12238m.areEqual(this.threadCreateCooldownMs, modelTypingResponse.threadCreateCooldownMs);
    }

    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public int hashCode() {
        Long l = this.messageSendCooldownMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.threadCreateCooldownMs;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelTypingResponse(messageSendCooldownMs=");
        sbM833U.append(this.messageSendCooldownMs);
        sbM833U.append(", threadCreateCooldownMs=");
        return C1643a.m819G(sbM833U, this.threadCreateCooldownMs, ")");
    }
}
