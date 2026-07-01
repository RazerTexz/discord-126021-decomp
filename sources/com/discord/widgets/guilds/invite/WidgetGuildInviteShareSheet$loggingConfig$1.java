package com.discord.widgets.guilds.invite;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddGuildInvite;
import com.discord.analytics.generated.events.impression.TrackImpressionGuildInvite;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$loggingConfig$1 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareSheet$loggingConfig$1(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        super(0);
        this.this$0 = widgetGuildInviteShareSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        String string = this.this$0.getArgumentsOrDefault().getString("ARG_ANALYTICS_SOURCE");
        if (string != null && string.hashCode() == -1756346871 && string.equals("Guild Create")) {
            TrackImpressionGuildAddGuildInvite trackImpressionGuildAddGuildInvite = new TrackImpressionGuildAddGuildInvite();
            trackImpressionGuildAddGuildInvite.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
            return trackImpressionGuildAddGuildInvite;
        }
        return new TrackImpressionGuildInvite(Long.valueOf(this.this$0.getArgumentsOrDefault().getLong("ARG_GUILD_ID")), Long.valueOf(this.this$0.getArgumentsOrDefault().getLong("ARG_CHANNEL_ID")));
    }
}
