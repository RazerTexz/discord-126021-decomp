package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserRegistration;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetAuthRegisterIdentity$loggingConfig$1 INSTANCE = new WidgetAuthRegisterIdentity$loggingConfig$1();

    public WidgetAuthRegisterIdentity$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserRegistration trackImpressionUserRegistration = new TrackImpressionUserRegistration(RegistrationSteps.IDENTITY);
        trackImpressionUserRegistration.m7528e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserRegistration;
    }
}
