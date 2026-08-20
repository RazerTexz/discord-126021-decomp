package com.discord.utilities.analytics;

import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker$Companion$instance$2 extends AbstractC12240o implements Function0<AppStartAnalyticsTracker> {
    public static final AppStartAnalyticsTracker$Companion$instance$2 INSTANCE = new AppStartAnalyticsTracker$Companion$instance$2();

    public AppStartAnalyticsTracker$Companion$instance$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppStartAnalyticsTracker invoke() {
        return new AppStartAnalyticsTracker(AnalyticsUtils.Tracker.INSTANCE.getInstance(), ClockFactory.get(), StoreStream.INSTANCE.getUserSettingsSystem());
    }
}
