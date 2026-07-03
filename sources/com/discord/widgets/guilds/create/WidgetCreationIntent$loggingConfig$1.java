package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddIntentSelection;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetCreationIntent$loggingConfig$1 INSTANCE = new WidgetCreationIntent$loggingConfig$1();

    public WidgetCreationIntent$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionGuildAddIntentSelection trackImpressionGuildAddIntentSelection = new TrackImpressionGuildAddIntentSelection();
        trackImpressionGuildAddIntentSelection.m7523e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
        return trackImpressionGuildAddIntentSelection;
    }
}
