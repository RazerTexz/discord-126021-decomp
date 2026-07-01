package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadSettingsViewModel$ViewState $viewState;

    public WidgetThreadSettings$configureUI$3(WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        this.$viewState = widgetThreadSettingsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelPinnedMessages.Companion.show(a.x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel$ViewState$Valid) this.$viewState).getChannel().getId());
    }
}
