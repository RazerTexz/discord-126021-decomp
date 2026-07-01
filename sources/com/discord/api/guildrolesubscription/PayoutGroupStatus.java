package com.discord.api.guildrolesubscription;


/* JADX INFO: compiled from: PayoutGroupStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PayoutGroupStatus {
    UNKNOWN(0),
    OPEN(1),
    PAYOUT_CREATED(2),
    CANCELED(3);

    public static final PayoutGroupStatus$Companion Companion = new PayoutGroupStatus$Companion(null);
    private final int apiValue;

    PayoutGroupStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
