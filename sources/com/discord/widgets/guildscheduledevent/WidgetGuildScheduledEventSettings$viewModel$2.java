package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$viewModel$2 extends Lambda implements Function0<GuildScheduledEventSettingsViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$viewModel$2(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(0);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventSettingsViewModel invoke() {
        long guildId = this.this$0.getGuildId();
        Long existingGuildScheduledEventId = this.this$0.getExistingGuildScheduledEventId();
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra("EXTRA_ENTITY_TYPE");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.api.guildscheduledevent.GuildScheduledEventEntityType");
        return new GuildScheduledEventSettingsViewModel(guildId, existingGuildScheduledEventId, (GuildScheduledEventEntityType) serializableExtra, IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_CHANNEL_ID"), this.this$0.getMostRecentIntent().getStringExtra("EXTRA_EXTERNAL_LOCATION"), null, 32, null);
    }
}
