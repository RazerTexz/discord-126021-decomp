package com.discord.widgets.user.phone;

import com.discord.analytics.generated.events.impression.TrackImpressionUserVerifyPhone;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetUserPhoneVerify$loggingConfig$1 INSTANCE = new WidgetUserPhoneVerify$loggingConfig$1();

    public WidgetUserPhoneVerify$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionUserVerifyPhone();
    }
}
