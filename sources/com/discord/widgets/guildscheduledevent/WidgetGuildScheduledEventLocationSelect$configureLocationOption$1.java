package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$configureLocationOption$1 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventEntityType $settingValue;
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    public WidgetGuildScheduledEventLocationSelect$configureLocationOption$1(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, GuildScheduledEventEntityType guildScheduledEventEntityType) {
        this.this$0 = widgetGuildScheduledEventLocationSelect;
        this.$settingValue = guildScheduledEventEntityType;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(this.this$0).selectLocationOption(this.$settingValue);
    }
}
