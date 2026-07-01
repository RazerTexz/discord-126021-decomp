package com.discord.widgets.voice.call;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetVoiceCallIncoming$Model $model;
    public final /* synthetic */ WidgetVoiceCallIncoming this$0;

    public WidgetVoiceCallIncoming$configureUI$4(WidgetVoiceCallIncoming widgetVoiceCallIncoming, WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model) {
        this.this$0 = widgetVoiceCallIncoming;
        this.$model = widgetVoiceCallIncoming$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.onDecline(this.$model.getChannelId());
    }
}
