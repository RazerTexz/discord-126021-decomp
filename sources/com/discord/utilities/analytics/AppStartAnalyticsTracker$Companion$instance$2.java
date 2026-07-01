package com.discord.utilities.analytics;

import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker$Companion$instance$2 extends o implements Function0<AppStartAnalyticsTracker> {
    public static final AppStartAnalyticsTracker$Companion$instance$2 INSTANCE = new AppStartAnalyticsTracker$Companion$instance$2();

    public AppStartAnalyticsTracker$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppStartAnalyticsTracker invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppStartAnalyticsTracker invoke() {
        return new AppStartAnalyticsTracker(AnalyticsUtils$Tracker.Companion.getInstance(), ClockFactory.get(), StoreStream.Companion.getUserSettingsSystem());
    }
}
