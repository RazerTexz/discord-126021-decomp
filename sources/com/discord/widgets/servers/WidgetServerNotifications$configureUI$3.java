package com.discord.widgets.servers;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$configureUI$3<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetServerNotifications$Model $model;
    public final /* synthetic */ WidgetServerNotifications this$0;

    public WidgetServerNotifications$configureUI$3(WidgetServerNotifications widgetServerNotifications, WidgetServerNotifications$Model widgetServerNotifications$Model) {
        this.this$0 = widgetServerNotifications;
        this.$model = widgetServerNotifications$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
        CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(this.this$0).q;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsRolesSwitch");
        Context context = checkedSetting.getContext();
        m.checkNotNullExpressionValue(context, "binding.serverNotificationsRolesSwitch.context");
        StoreUserGuildSettings.setGuildToggles$default(userGuildSettings, context, this.$model.getGuild(), null, Boolean.valueOf(!this.$model.getGuildSettings().isSuppressRoles()), null, null, 32, null);
    }
}
