package com.discord.utilities.analytics;

import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.OnAttributionChangedListener;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig$init$1$1 implements OnAttributionChangedListener {
    public static final AdjustConfig$init$1$1 INSTANCE = new AdjustConfig$init$1$1();

    @Override // com.adjust.sdk.OnAttributionChangedListener
    public final void onAttributionChanged(AdjustAttribution adjustAttribution) {
        if (adjustAttribution != null) {
            AnalyticsTracker.INSTANCE.attributionChange(adjustAttribution);
        }
    }
}
