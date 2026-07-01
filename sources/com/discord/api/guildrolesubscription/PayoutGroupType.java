package com.discord.api.guildrolesubscription;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: compiled from: PayoutGroupType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PayoutGroupType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    MARKETPLACE("marketplace"),
    STAGE_EVENT_SKU("stage_event_sku"),
    SERVER_ROLE_SUBSCRIPTION("server_role_subscription");

    public static final PayoutGroupType$Companion Companion = new PayoutGroupType$Companion(null);
    private final String apiValue;

    PayoutGroupType(String str) {
        this.apiValue = str;
    }

    public final String getApiValue() {
        return this.apiValue;
    }
}
