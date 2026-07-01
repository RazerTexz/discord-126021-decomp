package com.discord.models.domain;


/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ModelSubscription$Status {
    UNPAID(0),
    ACTIVE(1),
    PAST_DUE(2),
    CANCELED(3),
    ENDED(4),
    ACCOUNT_HOLD(6);

    public static final ModelSubscription$Status$Companion Companion = new ModelSubscription$Status$Companion(null);
    private final int intRepresentation;

    ModelSubscription$Status(int i) {
        this.intRepresentation = i;
    }

    public final int getIntRepresentation() {
        return this.intRepresentation;
    }

    public final boolean isAccountHold() {
        return this == ACCOUNT_HOLD;
    }

    public final boolean isCanceled() {
        return this == CANCELED;
    }
}
