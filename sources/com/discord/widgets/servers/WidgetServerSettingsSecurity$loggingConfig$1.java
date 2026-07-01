package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsSecurity;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$loggingConfig$1 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsSecurity$loggingConfig$1 INSTANCE = new WidgetServerSettingsSecurity$loggingConfig$1();

    public WidgetServerSettingsSecurity$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsSecurity();
    }
}
