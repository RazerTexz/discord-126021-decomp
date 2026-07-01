package com.discord.widgets.contact_sync;

import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactSyncFlowAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFlowAnalytics {
    private static final String CONTACT_SYNC_FLOW_KEY = "Contact Sync";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private final boolean isOnboarding;
    private String lastStep;
    private long lastStepTimestamp;

    /* JADX INFO: compiled from: ContactSyncFlowAnalytics.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trackStart$default(Companion companion, boolean z2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            companion.trackStart(z2, map);
        }

        public final void trackStart(boolean isOnboarding, Map<String, ? extends Object> additionalProps) {
            Map<String, ? extends Object> mutableMap = Maps6.toMutableMap(additionalProps != null ? additionalProps : Maps6.emptyMap());
            mutableMap.put("has_phone_number", Boolean.valueOf(StoreStream.INSTANCE.getUsers().getMeSnapshot().getPhoneNumber() != null));
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            analyticsTracker.relationshipSyncFlow(ContactSyncFlowAnalytics.CONTACT_SYNC_FLOW_KEY, "Flow Initialized", "Landing", 0, false, false, mutableMap);
            if (isOnboarding) {
                AnalyticsTracker.newUserOnboarding$default(analyticsTracker, ContactSyncFlowAnalytics.CONTACT_SYNC_FLOW_KEY, "Flow Initialized", "Landing", null, false, 24, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactSyncFlowAnalytics() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public ContactSyncFlowAnalytics(boolean z2, Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.isOnboarding = z2;
        this.clock = clock;
        this.lastStepTimestamp = clock.currentTimeMillis();
        this.lastStep = "Landing";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackEnd$default(ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        contactSyncFlowAnalytics.trackEnd(z2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackFlowStep$default(ContactSyncFlowAnalytics contactSyncFlowAnalytics, String str, boolean z2, boolean z3, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        contactSyncFlowAnalytics.trackFlowStep(str, z2, z3, map);
    }

    public final Clock getClock() {
        return this.clock;
    }

    /* JADX INFO: renamed from: isOnboarding, reason: from getter */
    public final boolean getIsOnboarding() {
        return this.isOnboarding;
    }

    public final void trackEnd(boolean skip, Map<String, ? extends Object> additionalProps) {
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.relationshipSyncFlow(CONTACT_SYNC_FLOW_KEY, this.lastStep, "Complete", (int) ((jCurrentTimeMillis - this.lastStepTimestamp) / ((long) 1000)), skip, false, additionalProps);
        if (this.isOnboarding) {
            analyticsTracker.newUserOnboarding(CONTACT_SYNC_FLOW_KEY, this.lastStep, "Complete", Long.valueOf(this.lastStepTimestamp), skip);
        }
    }

    public final void trackFlowStep(String toStep, boolean skip, boolean back, Map<String, ? extends Object> additionalProps) {
        Intrinsics3.checkNotNullParameter(toStep, "toStep");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.relationshipSyncFlow(CONTACT_SYNC_FLOW_KEY, this.lastStep, toStep, (int) ((jCurrentTimeMillis - this.lastStepTimestamp) / ((long) 1000)), skip, back, additionalProps);
        if (this.isOnboarding) {
            analyticsTracker.newUserOnboarding(CONTACT_SYNC_FLOW_KEY, this.lastStep, toStep, Long.valueOf(this.lastStepTimestamp), skip);
        }
        this.lastStepTimestamp = jCurrentTimeMillis;
        this.lastStep = toStep;
    }

    public /* synthetic */ ContactSyncFlowAnalytics(boolean z2, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? ClockFactory.get() : clock);
    }
}
