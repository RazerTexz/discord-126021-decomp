package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.R$id;
import java.util.Map;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$10 implements View$OnClickListener {
    public final /* synthetic */ Map $durationsMap;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$10(WidgetTextChannelSettings widgetTextChannelSettings, Map map) {
        this.this$0 = widgetTextChannelSettings;
        this.$durationsMap = map;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetTextChannelSettings.access$getState$p(this.this$0).put(R$id.duration_selector, 60);
        WidgetTextChannelSettings.access$getState$p(this.this$0).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(this.this$0).k);
        WidgetTextChannelSettings.access$updateRadioState(this.this$0, this.$durationsMap, 60);
    }
}
