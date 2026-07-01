package com.discord.api.guildrolesubscription;

import androidx.core.os.EnvironmentCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PayoutGroupType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PayoutGroupType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    MARKETPLACE("marketplace"),
    STAGE_EVENT_SKU("stage_event_sku"),
    SERVER_ROLE_SUBSCRIPTION("server_role_subscription");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String apiValue;

    /* JADX INFO: compiled from: PayoutGroupType.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    PayoutGroupType(String str) {
        this.apiValue = str;
    }

    public final String getApiValue() {
        return this.apiValue;
    }
}
