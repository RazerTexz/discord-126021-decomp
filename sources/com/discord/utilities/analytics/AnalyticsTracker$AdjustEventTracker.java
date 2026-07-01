package com.discord.utilities.analytics;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$AdjustEventTracker {
    private static final String EVENT_TOKEN_LOGIN = "ctt5aq";
    private static final String EVENT_TOKEN_REGISTER = "ebn8ke";
    public static final AnalyticsTracker$AdjustEventTracker INSTANCE = new AnalyticsTracker$AdjustEventTracker();

    private AnalyticsTracker$AdjustEventTracker() {
    }

    public final void trackLogin() {
        Adjust.trackEvent(new AdjustEvent(EVENT_TOKEN_LOGIN));
    }

    public final void trackRegister() {
        Adjust.trackEvent(new AdjustEvent(EVENT_TOKEN_REGISTER));
    }
}
