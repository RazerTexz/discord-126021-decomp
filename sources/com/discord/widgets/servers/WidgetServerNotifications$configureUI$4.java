package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerNotifications$Model $model;
    public final /* synthetic */ WidgetServerNotifications this$0;

    public WidgetServerNotifications$configureUI$4(WidgetServerNotifications widgetServerNotifications, WidgetServerNotifications$Model widgetServerNotifications$Model) {
        this.this$0 = widgetServerNotifications;
        this.$model = widgetServerNotifications$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerNotifications.access$getBinding$p(this.this$0).o.toggle();
        StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
        CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(this.this$0).o;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsPushSwitch");
        Context context = checkedSetting.getContext();
        m.checkNotNullExpressionValue(context, "binding.serverNotificationsPushSwitch.context");
        userGuildSettings.setGuildToggles(context, this.$model.getGuild(), null, null, null, Boolean.valueOf(!this.$model.getGuildSettings().isMobilePush()));
    }
}
