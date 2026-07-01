package com.discord.utilities.analytics;

import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$Companion$instance$2, reason: use source file name */
/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker2 extends Lambda implements Function0<AppStartAnalyticsTracker> {
    public static final AppStartAnalyticsTracker2 INSTANCE = new AppStartAnalyticsTracker2();

    public AppStartAnalyticsTracker2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppStartAnalyticsTracker invoke() {
        return new AppStartAnalyticsTracker(AnalyticsUtils.Tracker.INSTANCE.getInstance(), ClockFactory.get(), StoreStream.INSTANCE.getUserSettingsSystem());
    }
}
