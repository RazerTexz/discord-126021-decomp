package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsLanding;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettings$loggingConfig$1 INSTANCE = new WidgetServerSettings$loggingConfig$1();

    public WidgetServerSettings$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsLanding();
    }
}
