package com.discord.widgets.servers.settings.members;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsMembers;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsMembers4 INSTANCE = new WidgetServerSettingsMembers4();

    public WidgetServerSettingsMembers4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsMembers();
    }
}
