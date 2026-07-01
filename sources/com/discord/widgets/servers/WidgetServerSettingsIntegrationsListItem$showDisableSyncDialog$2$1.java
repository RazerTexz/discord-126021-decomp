package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2 this$0;

    public WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2$1(WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2 widgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2) {
        this.this$0 = widgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r1) {
        this.this$0.$dialog.dismiss();
    }
}
