package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsChannels;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels6 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsChannels6 INSTANCE = new WidgetServerSettingsChannels6();

    public WidgetServerSettingsChannels6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsChannels();
    }
}
