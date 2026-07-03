package com.discord.widgets.nux;

import com.discord.analytics.generated.events.impression.TrackImpressionHubCreateGuildTemplate;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubGuildTemplates$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetHubGuildTemplates$loggingConfig$1 INSTANCE = new WidgetHubGuildTemplates$loggingConfig$1();

    public WidgetHubGuildTemplates$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionHubCreateGuildTemplate();
    }
}
