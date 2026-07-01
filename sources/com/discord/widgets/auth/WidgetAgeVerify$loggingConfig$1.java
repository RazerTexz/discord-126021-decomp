package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGate;
import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGateUnderage;
import com.discord.api.science.AnalyticsSchema;
import com.discord.app.AppViewFlipper;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetAgeVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify$loggingConfig$1(WidgetAgeVerify widgetAgeVerify) {
        super(0);
        this.this$0 = widgetAgeVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        AnalyticsSchema trackImpressionUserAgeGate;
        boolean z2 = StoreStream.Companion.getUsers().getMeSnapshot().getId() > 0;
        AppViewFlipper appViewFlipper = WidgetAgeVerify.access$getBinding$p(this.this$0).f2224b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        int displayedChild = appViewFlipper.getDisplayedChild();
        if (displayedChild == 0) {
            trackImpressionUserAgeGate = new TrackImpressionUserAgeGate(Boolean.valueOf(z2));
        } else {
            if (displayedChild != 2) {
                return null;
            }
            trackImpressionUserAgeGate = new TrackImpressionUserAgeGateUnderage(Boolean.valueOf(z2));
        }
        return trackImpressionUserAgeGate;
    }
}
