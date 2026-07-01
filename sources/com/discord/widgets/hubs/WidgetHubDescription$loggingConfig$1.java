package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.impression.TrackImpressionHubCreateGuildCustomize;
import com.discord.analytics.generated.events.impression.TrackImpressionHubExistingGuildCustomize;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$loggingConfig$1(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return this.this$0.getArgs().isNewGuild() ? new TrackImpressionHubCreateGuildCustomize() : new TrackImpressionHubExistingGuildCustomize();
    }
}
