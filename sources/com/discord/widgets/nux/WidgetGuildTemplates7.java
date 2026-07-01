package com.discord.widgets.nux;

import com.discord.analytics.generated.events.impression.TrackImpressionHubCreateGuildTemplate;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.nux.WidgetHubGuildTemplates$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates7 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetGuildTemplates7 INSTANCE = new WidgetGuildTemplates7();

    public WidgetGuildTemplates7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionHubCreateGuildTemplate();
    }
}
