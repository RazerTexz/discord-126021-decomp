package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureFabVisibility$1$1 implements Action0 {
    public final /* synthetic */ WidgetServerSettingsChannels$configureFabVisibility$1 this$0;

    public WidgetServerSettingsChannels$configureFabVisibility$1$1(WidgetServerSettingsChannels$configureFabVisibility$1 widgetServerSettingsChannels$configureFabVisibility$1) {
        this.this$0 = widgetServerSettingsChannels$configureFabVisibility$1;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.this$0.$setFabVisibility.invoke();
    }
}
