package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserLogin;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public static final WidgetAuthLogin$loggingConfig$1 INSTANCE = new WidgetAuthLogin$loggingConfig$1();

    public WidgetAuthLogin$loggingConfig$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserLogin trackImpressionUserLogin = new TrackImpressionUserLogin(null, 1);
        trackImpressionUserLogin.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_LOGIN_FLOW, 7));
        return trackImpressionUserLogin;
    }
}
