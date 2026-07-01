package com.discord.widgets.guilds.join;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddJoin;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoin3 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetGuildJoin3 INSTANCE = new WidgetGuildJoin3();

    public WidgetGuildJoin3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionGuildAddJoin trackImpressionGuildAddJoin = new TrackImpressionGuildAddJoin();
        trackImpressionGuildAddJoin.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
        return trackImpressionGuildAddJoin;
    }
}
