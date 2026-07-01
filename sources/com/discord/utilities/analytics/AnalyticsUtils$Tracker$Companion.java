package com.discord.utilities.analytics;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker$Companion {
    private AnalyticsUtils$Tracker$Companion() {
    }

    public final AnalyticsUtils$Tracker getInstance() {
        Lazy lazyAccess$getInstance$cp = AnalyticsUtils$Tracker.access$getInstance$cp();
        AnalyticsUtils$Tracker$Companion analyticsUtils$Tracker$Companion = AnalyticsUtils$Tracker.Companion;
        return (AnalyticsUtils$Tracker) lazyAccess$getInstance$cp.getValue();
    }

    public /* synthetic */ AnalyticsUtils$Tracker$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
