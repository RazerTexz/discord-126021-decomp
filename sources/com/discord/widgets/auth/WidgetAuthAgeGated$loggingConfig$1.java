package com.discord.widgets.auth;

import com.discord.analytics.generated.events.impression.TrackImpressionUserAgeGateUnderage;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthAgeGated$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetAuthAgeGated$loggingConfig$1 INSTANCE = new WidgetAuthAgeGated$loggingConfig$1();

    public WidgetAuthAgeGated$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionUserAgeGateUnderage trackImpressionUserAgeGateUnderage = new TrackImpressionUserAgeGateUnderage(Boolean.valueOf(StoreStream.INSTANCE.getUsers().getMeSnapshot().getId() > 0));
        trackImpressionUserAgeGateUnderage.m7526e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.USER_REGISTRATION_FLOW, 7));
        return trackImpressionUserAgeGateUnderage;
    }
}
