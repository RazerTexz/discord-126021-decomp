package com.discord.api.guildrolesubscription;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PayoutStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PayoutStatus {
    UNKNOWN(0),
    OPEN(1),
    PAID(2),
    PENDING(3),
    MANUAL(4),
    CANCELED(5),
    DEFERRED(6),
    DEFERRED_INTERNAL(7),
    PROCESSING(8),
    ERROR(9),
    REJECTED(10),
    RISK_REVIEW(11),
    SUBMITTED(12),
    PENDING_FUNDS(13);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: PayoutStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
