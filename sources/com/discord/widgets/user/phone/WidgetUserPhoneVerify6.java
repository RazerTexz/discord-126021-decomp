package com.discord.widgets.user.phone;

import com.discord.analytics.generated.events.impression.TrackImpressionUserVerifyPhone;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify6 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetUserPhoneVerify6 INSTANCE = new WidgetUserPhoneVerify6();

    public WidgetUserPhoneVerify6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionUserVerifyPhone();
    }
}
