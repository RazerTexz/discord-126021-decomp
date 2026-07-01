package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsVanityUrl;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsVanityUrl5 INSTANCE = new WidgetServerSettingsVanityUrl5();

    public WidgetServerSettingsVanityUrl5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsVanityUrl();
    }
}
