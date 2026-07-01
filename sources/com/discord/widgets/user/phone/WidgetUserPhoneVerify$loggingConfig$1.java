package com.discord.widgets.user.phone;

import com.discord.analytics.generated.events.impression.TrackImpressionUserVerifyPhone;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public static final WidgetUserPhoneVerify$loggingConfig$1 INSTANCE = new WidgetUserPhoneVerify$loggingConfig$1();

    public WidgetUserPhoneVerify$loggingConfig$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionUserVerifyPhone();
    }
}
