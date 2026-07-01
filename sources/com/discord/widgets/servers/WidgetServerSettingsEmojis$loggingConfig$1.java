package com.discord.widgets.servers;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsEmoji;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$loggingConfig$1 extends o implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsEmojis$loggingConfig$1 INSTANCE = new WidgetServerSettingsEmojis$loggingConfig$1();

    public WidgetServerSettingsEmojis$loggingConfig$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsEmoji();
    }
}
