package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddIntentSelection;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetCreationIntent4 INSTANCE = new WidgetCreationIntent4();

    public WidgetCreationIntent4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionGuildAddIntentSelection trackImpressionGuildAddIntentSelection = new TrackImpressionGuildAddIntentSelection();
        trackImpressionGuildAddIntentSelection.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
        return trackImpressionGuildAddIntentSelection;
    }
}
