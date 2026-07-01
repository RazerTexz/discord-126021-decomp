package com.discord.widgets.guilds.invite;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildAddGuildInvite;
import com.discord.analytics.generated.events.impression.TrackImpressionGuildInvite;
import com.discord.analytics.generated.events.impression.TrackImpressionGuildInviteLinkSettings;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare6 extends Lambda implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare6(WidgetGuildInviteShare widgetGuildInviteShare) {
        super(0);
        this.this$0 = widgetGuildInviteShare;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        String stringExtraOrDefault = IntentUtilsKt.getStringExtraOrDefault(this.this$0.getMostRecentIntent(), "com.discord.intent.ORIGIN_SOURCE", "");
        if (WidgetGuildInviteShare.access$getBottomSheetBehavior$p(this.this$0).getState() == 3) {
            return new TrackImpressionGuildInviteLinkSettings();
        }
        if (Intrinsics3.areEqual(stringExtraOrDefault, "Guild Create")) {
            TrackImpressionGuildAddGuildInvite trackImpressionGuildAddGuildInvite = new TrackImpressionGuildAddGuildInvite();
            trackImpressionGuildAddGuildInvite.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.GUILD_ADD_FLOW, 7));
            return trackImpressionGuildAddGuildInvite;
        }
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        Long lValueOf = longExtra == 0 ? null : Long.valueOf(longExtra);
        long longExtra2 = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        return new TrackImpressionGuildInvite(lValueOf, longExtra2 != 0 ? Long.valueOf(longExtra2) : null);
    }
}
