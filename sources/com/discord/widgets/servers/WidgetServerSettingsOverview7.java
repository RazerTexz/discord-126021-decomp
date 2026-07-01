package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsOverview;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview7 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsOverview7 INSTANCE = new WidgetServerSettingsOverview7();

    public WidgetServerSettingsOverview7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsOverview();
    }
}
