package com.discord.api.guildrolesubscription;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PayoutGroupStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PayoutGroupStatus {
    UNKNOWN(0),
    OPEN(1),
    PAYOUT_CREATED(2),
    CANCELED(3);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: PayoutGroupStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutGroupStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
