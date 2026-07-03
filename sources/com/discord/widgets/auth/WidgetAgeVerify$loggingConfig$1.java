package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGate;
import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGateUnderage;
import com.discord.api.science.AnalyticsSchema;
import com.discord.app.AppViewFlipper;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetAgeVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify$loggingConfig$1(WidgetAgeVerify widgetAgeVerify) {
        super(0);
        this.this$0 = widgetAgeVerify;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        AnalyticsSchema trackImpressionUserAgeGate;
        boolean z2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId() > 0;
        AppViewFlipper appViewFlipper = this.this$0.getBinding().f15644b;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
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
