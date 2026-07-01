package com.discord.widgets.contact_sync;

import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.t.h0;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactSyncFlowAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFlowAnalytics$Companion {
    private ContactSyncFlowAnalytics$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackStart$default(ContactSyncFlowAnalytics$Companion contactSyncFlowAnalytics$Companion, boolean z2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            map = null;
        }
        contactSyncFlowAnalytics$Companion.trackStart(z2, map);
    }

    public final void trackStart(boolean isOnboarding, Map<String, ? extends Object> additionalProps) {
        Map<String, ? extends Object> mutableMap = h0.toMutableMap(additionalProps != null ? additionalProps : h0.emptyMap());
        mutableMap.put("has_phone_number", Boolean.valueOf(StoreStream.Companion.getUsers().getMeSnapshot().getPhoneNumber() != null));
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.relationshipSyncFlow("Contact Sync", "Flow Initialized", "Landing", 0, false, false, mutableMap);
        if (isOnboarding) {
            AnalyticsTracker.newUserOnboarding$default(analyticsTracker, "Contact Sync", "Flow Initialized", "Landing", null, false, 24, null);
        }
    }

    public /* synthetic */ ContactSyncFlowAnalytics$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
