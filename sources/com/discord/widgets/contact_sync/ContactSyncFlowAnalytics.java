package com.discord.widgets.contact_sync;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactSyncFlowAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFlowAnalytics {
    private static final String CONTACT_SYNC_FLOW_KEY = "Contact Sync";
    public static final ContactSyncFlowAnalytics$Companion Companion = new ContactSyncFlowAnalytics$Companion(null);
    private final Clock clock;
    private final boolean isOnboarding;
    private String lastStep;
    private long lastStepTimestamp;

    public ContactSyncFlowAnalytics() {
        this(false, null, 3, null);
    }

    public ContactSyncFlowAnalytics(boolean z2, Clock clock) {
        m.checkNotNullParameter(clock, "clock");
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
        m.checkNotNullParameter(toStep, "toStep");
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
