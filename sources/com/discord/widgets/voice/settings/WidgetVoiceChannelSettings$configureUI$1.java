package com.discord.widgets.voice.settings;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetVoiceChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    public WidgetVoiceChannelSettings$configureUI$1(WidgetVoiceChannelSettings widgetVoiceChannelSettings, WidgetVoiceChannelSettings$Model widgetVoiceChannelSettings$Model) {
        this.this$0 = widgetVoiceChannelSettings;
        this.$this_configureUI = widgetVoiceChannelSettings$Model;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364369) {
            return;
        }
        WidgetVoiceChannelSettings.access$confirmDelete(this.this$0, this.$this_configureUI.getChannel());
    }
}
