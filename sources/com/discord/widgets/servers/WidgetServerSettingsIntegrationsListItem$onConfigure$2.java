package com.discord.widgets.servers;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import com.discord.restapi.RestAPIParams$EnableIntegration;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$onConfigure$2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetServerSettingsIntegrations$Model$IntegrationItem $data;
    public final /* synthetic */ long $integrationId;
    public final /* synthetic */ boolean $isTwitch;
    public final /* synthetic */ WidgetServerSettingsIntegrationsListItem this$0;

    public WidgetServerSettingsIntegrationsListItem$onConfigure$2(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, WidgetServerSettingsIntegrations$Model$IntegrationItem widgetServerSettingsIntegrations$Model$IntegrationItem, long j, boolean z2) {
        this.this$0 = widgetServerSettingsIntegrationsListItem;
        this.$data = widgetServerSettingsIntegrations$Model$IntegrationItem;
        this.$integrationId = j;
        this.$isTwitch = z2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "checked");
        if (!bool.booleanValue()) {
            Observable observableUi = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().enableIntegration(this.$data.getGuildId(), new RestAPIParams$EnableIntegration(this.$data.getIntegration().getType(), String.valueOf(this.$integrationId))), false, 1, null));
            WidgetServerSettingsIntegrationsListItem$onConfigure$2$1 widgetServerSettingsIntegrationsListItem$onConfigure$2$1 = new WidgetServerSettingsIntegrationsListItem$onConfigure$2$1(this);
            CheckedSetting checkedSetting = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(this.this$0).h;
            m.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
            observableUi.k(o.j(widgetServerSettingsIntegrationsListItem$onConfigure$2$1, checkedSetting.getContext(), null, 4));
            return;
        }
        WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem = this.this$0;
        long guildId = this.$data.getGuildId();
        long j = this.$integrationId;
        boolean z2 = this.$isTwitch;
        CheckedSetting checkedSetting2 = WidgetServerSettingsIntegrationsListItem.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "binding.integrationSyncSwitch.context");
        WidgetServerSettingsIntegrationsListItem.access$showDisableSyncDialog(widgetServerSettingsIntegrationsListItem, guildId, j, z2, context);
    }
}
