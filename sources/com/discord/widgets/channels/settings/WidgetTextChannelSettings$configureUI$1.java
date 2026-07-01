package com.discord.widgets.channels.settings;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetTextChannelSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    public WidgetTextChannelSettings$configureUI$1(WidgetTextChannelSettings widgetTextChannelSettings, WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        this.this$0 = widgetTextChannelSettings;
        this.$this_configureUI = widgetTextChannelSettings$Model;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_channel_settings_delete /* 2131364369 */:
                if (this.$this_configureUI.isPublicGuildRulesChannel() || this.$this_configureUI.isPublicGuildUpdatesChannel()) {
                    WidgetTextChannelSettings.access$cannotDeleteWarn(this.this$0, this.$this_configureUI.isPublicGuildRulesChannel());
                } else {
                    WidgetTextChannelSettings.access$confirmDelete(this.this$0, this.$this_configureUI.getChannel());
                }
                break;
            case R$id.menu_channel_settings_reset /* 2131364370 */:
                StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
                m.checkNotNullExpressionValue(context, "context");
                userGuildSettings.setChannelNotificationsDefault(context, this.$this_configureUI.getChannel());
                break;
        }
    }
}
