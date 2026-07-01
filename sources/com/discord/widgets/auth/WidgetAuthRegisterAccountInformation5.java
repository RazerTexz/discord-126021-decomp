package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserRegistration;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetAuthRegisterAccountInformation5 INSTANCE = new WidgetAuthRegisterAccountInformation5();

    public WidgetAuthRegisterAccountInformation5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserRegistration trackImpressionUserRegistration = new TrackImpressionUserRegistration(RegistrationSteps.ACCOUNT_INFORMATION);
        trackImpressionUserRegistration.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserRegistration;
    }
}
