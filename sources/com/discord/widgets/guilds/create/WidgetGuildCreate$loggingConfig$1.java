package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddCustomize;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreate$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetGuildCreate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreate$loggingConfig$1(WidgetGuildCreate widgetGuildCreate) {
        super(0);
        this.this$0 = widgetGuildCreate;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionGuildAddCustomize trackImpressionGuildAddCustomize = new TrackImpressionGuildAddCustomize();
        trackImpressionGuildAddCustomize.e(new TrackImpressionMetadata(null, null, null, m.areEqual(this.this$0.getArgs().getAnalyticsLocation(), GuildTemplateAnalytics.STEP_GUILD_TEMPLATE) ? ImpressionGroups.GUILD_ADD_NUF : ImpressionGroups.GUILD_ADD_FLOW, 7));
        return trackImpressionGuildAddCustomize;
    }
}
