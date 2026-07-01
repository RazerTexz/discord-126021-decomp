package com.discord.widgets.channels;

import com.discord.analytics.generated.events.impression.TrackImpressionChannelAddInfo;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$loggingConfig$1 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetCreateChannel$loggingConfig$1 INSTANCE = new WidgetCreateChannel$loggingConfig$1();

    public WidgetCreateChannel$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionChannelAddInfo trackImpressionChannelAddInfo = new TrackImpressionChannelAddInfo();
        trackImpressionChannelAddInfo.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.CHANNEL_ADD_FLOW, 7));
        return trackImpressionChannelAddInfo;
    }
}
