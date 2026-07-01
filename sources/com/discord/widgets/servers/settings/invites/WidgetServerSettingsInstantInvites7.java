package com.discord.widgets.servers.settings.invites;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsInvites;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites7 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsInstantInvites7 INSTANCE = new WidgetServerSettingsInstantInvites7();

    public WidgetServerSettingsInstantInvites7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsInvites();
    }
}
