package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppFragment;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$configureDurationOption$1 implements View$OnClickListener {
    public final /* synthetic */ TimeDurationDisabledCommunication $settingValue;
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication$configureDurationOption$1(WidgetDisableGuildCommunication widgetDisableGuildCommunication, TimeDurationDisabledCommunication timeDurationDisabledCommunication) {
        this.this$0 = widgetDisableGuildCommunication;
        this.$settingValue = timeDurationDisabledCommunication;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d.clearFocus();
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
        WidgetDisableGuildCommunication.access$getViewModel$p(this.this$0).onDurationLengthSelected(this.$settingValue);
    }
}
