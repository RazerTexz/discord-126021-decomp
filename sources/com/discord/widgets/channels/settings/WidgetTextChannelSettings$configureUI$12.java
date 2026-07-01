package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.R$id;
import com.discord.utilities.threads.ThreadUtils$ThreadArchiveDurations;
import java.util.Map;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$12 implements View$OnClickListener {
    public final /* synthetic */ Map $durationsMap;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$12(WidgetTextChannelSettings widgetTextChannelSettings, Map map) {
        this.this$0 = widgetTextChannelSettings;
        this.$durationsMap = map;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetTextChannelSettings.access$getState$p(this.this$0).put(R$id.duration_selector, Integer.valueOf(ThreadUtils$ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
        WidgetTextChannelSettings.access$getState$p(this.this$0).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(this.this$0).k);
        WidgetTextChannelSettings.access$updateRadioState(this.this$0, this.$durationsMap, ThreadUtils$ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
    }
}
