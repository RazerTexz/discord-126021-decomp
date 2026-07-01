package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$onConfigure$2$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetServerSettingsIntegrationsListItem$onConfigure$2 this$0;

    public WidgetServerSettingsIntegrationsListItem$onConfigure$2$1(WidgetServerSettingsIntegrationsListItem$onConfigure$2 widgetServerSettingsIntegrationsListItem$onConfigure$2) {
        this.this$0 = widgetServerSettingsIntegrationsListItem$onConfigure$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r3) {
        CheckedSetting checkedSetting = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(this.this$0.this$0).h;
        m.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
        checkedSetting.setChecked(true);
        CheckedSetting checkedSetting2 = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(this.this$0.this$0).h;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
        checkedSetting2.setEnabled(false);
        WidgetServerSettingsIntegrationsListItem.access$showSyncingUI(this.this$0.this$0, true);
    }
}
